package com.snc.backend.domain.model.shared.common;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tr_transact_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TransactType extends CommonType {

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private TransactTypeCategoryType category;
}
