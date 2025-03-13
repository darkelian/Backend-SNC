package com.snc.backend.model.transacts;
import com.snc.backend.model.radications.Radicate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_transact_document")
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

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Radicate getRadicate() {
        return radicate;
    }

    public void setRadicate(Radicate radicate) {
        this.radicate = radicate;
    }

    public Transact getTransact() {
        return transact;
    }

    public void setTransact(Transact transact) {
        this.transact = transact;
    }
}
