package com.snc.backend.model.transacts;

import com.snc.backend.model.radications.Radicate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tr_transact_document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    @ManyToOne(optional = false)
    @JoinColumn(name = "radicate_id")
    private Radicate radicate;

    @ManyToOne
    @JoinColumn(name = "transact_id")
    private Transact transact;
}
