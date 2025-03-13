package com.snc.backend.model.request;
import com.snc.backend.model.shared.general.ColombianTown;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "req_site_town_jurisdiction")
public class SiteTownJurisdiction {

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private ColombianTown town;

    // Getters & Setters
    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public ColombianTown getTown() {
        return town;
    }

    public void setTown(ColombianTown town) {
        this.town = town;
    }
}
