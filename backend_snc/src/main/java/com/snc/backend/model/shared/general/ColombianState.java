package com.snc.backend.model.shared.general;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gen_colombia_states")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColombianState {

    @Id
    @Column(length = 3)
    private String id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private WorldCountry country;

    @Column(name = "code", length = 2, nullable = false)
    private String code;
}
