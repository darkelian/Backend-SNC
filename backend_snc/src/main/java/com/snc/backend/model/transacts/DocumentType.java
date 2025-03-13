package com.snc.backend.model.transacts;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_document_type")
@AttributeOverride(name = "dispname", column = @Column(name = "dispname", length = 150, unique = true, nullable = false))
public class DocumentType extends CommonType {

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private DocumentTypeCategoryType category;

    // Getters y Setters
    public DocumentTypeCategoryType getCategory() {
        return category;
    }

    public void setCategory(DocumentTypeCategoryType category) {
        this.category = category;
    }
}
