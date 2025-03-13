package com.snc.backend.model.transacts;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_party_transact")
public class PartyTransact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transact_id")
    private Transact transact;

    @Column(name = "party", nullable = false)
    private UUID party;

    @Column(name = "is_principal", nullable = false)
    private Boolean isPrincipal;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Transact getTransact() {
        return transact;
    }

    public void setTransact(Transact transact) {
        this.transact = transact;
    }

    public UUID getParty() {
        return party;
    }

    public void setParty(UUID party) {
        this.party = party;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }
}
