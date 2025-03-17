package com.snc.backend.model.shared.general;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gen_world_countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorldCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "abb", length = 2, nullable = false)
    private String abb;

    @Column(name = "icon", length = 20, nullable = false)
    private String icon;

    @Column(name = "ident", length = 4, nullable = false)
    private String ident;

}