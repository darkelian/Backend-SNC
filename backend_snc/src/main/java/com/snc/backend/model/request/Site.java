package com.snc.backend.model.request;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "req_site")
public class Site extends CommonType {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private SiteType type;

    @ManyToOne
    @JoinColumn(name = "site_parent")
    private Site siteParent;

    // Getters & Setters
    public SiteType getType() {
        return type;
    }

    public void setType(SiteType type) {
        this.type = type;
    }

    public Site getSiteParent() {
        return siteParent;
    }

    public void setSiteParent(Site siteParent) {
        this.siteParent = siteParent;
    }
}
