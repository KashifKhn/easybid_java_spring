package com.easybid.category;

import java.util.Set;

import com.easybid.category.dto.UpdateCategoryDTO;
import com.easybid.common.BaseEntity;
import com.easybid.item.ItemEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Schema()
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

  @Column(nullable = false, length = 255)
  private String name;

  @Column(length = 255)
  private String description;

  @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
  private Boolean isActive;

  @OneToMany(mappedBy = "category")
  private Set<ItemEntity> items;

  public void updateFromDTO(UpdateCategoryDTO dto) {
    if (dto.getName() != null && !dto.getName().isBlank()) {
      this.setName(dto.getName());
    }
    if (dto.getDescription() != null && !dto.getDescription().isBlank()) {
      this.setDescription(dto.getDescription());
    }
    if (dto.getIsActive() != null) {
      this.setIsActive(dto.getIsActive());
    }
  }
}