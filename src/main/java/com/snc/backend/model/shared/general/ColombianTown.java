package com.snc.backend.model.shared.general;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gen_colombia_towns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColombianTown {

    @Id
    @Column(length = 6)
    private String id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private ColombianState state;

    @Column(name = "code", length = 5, nullable = false)
    private String code;
}