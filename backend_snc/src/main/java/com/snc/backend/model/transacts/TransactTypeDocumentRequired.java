package com.snc.backend.model.transacts;
import com.snc.backend.model.shared.common.TransactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_transact_type_document_required")
public class TransactTypeDocumentRequired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transact_type_id")
    private TransactType transactType;

    @Column(name = "transact_condition", length = 10)
    private String transactCondition;

    @ManyToOne(optional = false)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public TransactType getTransactType() {
        return transactType;
    }

    public void setTransactType(TransactType transactType) {
        this.transactType = transactType;
    }

    public String getTransactCondition() {
        return transactCondition;
    }

    public void setTransactCondition(String transactCondition) {
        this.transactCondition = transactCondition;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }
}
