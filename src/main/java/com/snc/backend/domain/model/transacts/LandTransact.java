package com.snc.backend.domain.model.transacts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tr_land_transact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
