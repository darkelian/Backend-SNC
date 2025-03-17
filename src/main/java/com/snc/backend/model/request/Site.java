package com.snc.backend.model.request;

import com.snc.backend.model.shared.common.CommonType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "req_site")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class Site extends CommonType {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private SiteType type;

    @ManyToOne
    @JoinColumn(name = "site_parent")
    private Site siteParent;
}
