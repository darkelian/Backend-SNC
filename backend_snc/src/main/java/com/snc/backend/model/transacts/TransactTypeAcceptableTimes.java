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
@Table(name = "tr_transact_type_acceptable_times")
public class TransactTypeAcceptableTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transact_type_id")
    private TransactType transactType;

    @Column(name = "medium", nullable = false)
    private Short medium = 0;

    @Column(name = "maximum", nullable = false)
    private Short maximum = 0;

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

    public Short getMedium() {
        return medium;
    }

    public void setMedium(Short medium) {
        this.medium = medium;
    }

    public Short getMaximum() {
        return maximum;
    }

    public void setMaximum(Short maximum) {
        this.maximum = maximum;
    }
}
