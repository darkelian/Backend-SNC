package com.snc.backend.model.transacts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_land_transact")
public class LandTransact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transact_id")
    private Transact transact;

    @Column(name = "land", length = 11, nullable = false)
    private String land;

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

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }
}
