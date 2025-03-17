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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tr_party_transact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
