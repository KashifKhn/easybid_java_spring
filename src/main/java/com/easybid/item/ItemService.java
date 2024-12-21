package com.easybid.item;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.easybid.item.dto.CreateItemDTO;
import com.easybid.item.dto.ItemResponseDTO;
import com.easybid.item.dto.UpdateItemDTO;

public interface ItemService {

  ItemResponseDTO createItem(CreateItemDTO createItemDTO, MultipartFile[] files);

  List<ItemResponseDTO> getAllItem();

  ItemResponseDTO getItemById(UUID itemId);

  ItemResponseDTO updateItem(UUID itemId, UpdateItemDTO updateItemDTO, MultipartFile[] files);

  void deleteItem(UUID itemId);
}
