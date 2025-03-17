package com.snc.backend.model.shared.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tr_transact_type_category_type")
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class TransactTypeCategoryType extends CommonType {
    // Puedes agregar campos adicionales si es necesario
}
