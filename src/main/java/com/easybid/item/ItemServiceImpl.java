package com.easybid.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.easybid.exceptions.ResourceNotFoundException;
import com.easybid.item.dto.CreateItemDTO;
import com.easybid.item.dto.ItemResponseDTO;
import com.easybid.item.dto.UpdateItemDTO;
import com.easybid.itemImage.ItemImageEntity;
import com.easybid.itemImage.ItemImageService;
import com.easybid.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;
  private final ItemImageService itemImageService;

  public ItemServiceImpl(final ItemRepository itemRepository,
      final ItemImageService itemImageService) {
    this.itemRepository = itemRepository;
    this.itemImageService = itemImageService;
  }

  @Override
  @Transactional
  public ItemResponseDTO createItem(final CreateItemDTO createItemDTO, final MultipartFile[] files) {
    final ItemEntity item = new ItemEntity();
    item.setName(createItemDTO.getName());
    item.setDescription(createItemDTO.getDescription());
    item.setBuyNowPrice(createItemDTO.getBuyNowPrice());
    item.setStartingBid(createItemDTO.getStartingBid());
    item.setUser(createItemDTO.getUser());
    item.setCategory(createItemDTO.getCategory());
    this.itemRepository.save(item);
    this.itemImageService.createItemImage(item, files);
    return ItemMapper.toItemResponseDTO(item);
  }

  @Override
  public List<ItemResponseDTO> getAllItem() {
    final List<ItemEntity> items = this.itemRepository.findByDeletedAtIsNull();
    final List<ItemResponseDTO> itemRes = items.stream()
        .map(ItemMapper::toItemResponseDTO)
        .collect(Collectors.toList());
    return itemRes;
  }

  @Override
  public ItemResponseDTO getItemById(final UUID itemId) {
    return ItemMapper.toItemResponseDTO(this.findItemById(itemId));
  }

  @Override
  @Transactional
  public ItemResponseDTO updateItem(final UUID itemId, final UpdateItemDTO updateItemDTO, final MultipartFile[] files) {
    final ItemEntity item = this.findItemById(itemId);
    if (files != null && files.length > 0) {
      List<ItemImageEntity> imageEntities = new ArrayList<>(item.getImages());
      for (ItemImageEntity imageEntity : imageEntities) {
        this.itemImageService.deleteItemImage(imageEntity);
      }
      item.setImages(new ArrayList<>());
      this.itemImageService.createItemImage(item, files);
    }
    ItemMapper.updateEntityFromDTO(item, updateItemDTO);
    this.itemRepository.save(item);
    return ItemMapper.toItemResponseDTO(item);
  }

  @Override
  public void deleteItem(final UUID itemId) {
    final ItemEntity item = this.findItemById(itemId);
    item.setDeletedAt(LocalDateTime.now());
    this.itemRepository.save(item);
  }

  private ItemEntity findItemById(final UUID itemId) {
    return this.itemRepository.findByIdAndDeletedAtIsNull(itemId)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found for ID: " + itemId));
  }

}
