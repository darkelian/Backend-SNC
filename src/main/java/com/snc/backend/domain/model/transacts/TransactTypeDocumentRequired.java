package com.snc.backend.domain.model.transacts;
import com.snc.backend.domain.model.shared.common.TransactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tr_transact_type_document_required")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
