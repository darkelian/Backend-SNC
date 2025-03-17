package com.snc.backend.domain.model.request;

import com.snc.backend.domain.model.shared.general.ColombianTown;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "req_site_town_jurisdiction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteTownJurisdiction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private ColombianTown town;
}