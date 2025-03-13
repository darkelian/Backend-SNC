package com.snc.backend.model.shared.common;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_transact_type")
public class TransactType extends CommonType {

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private TransactTypeCategoryType category;

    // Getters & Setters

    public TransactTypeCategoryType getCategory() {
        return category;
    }

    public void setCategory(TransactTypeCategoryType category) {
        this.category = category;
    }
}
