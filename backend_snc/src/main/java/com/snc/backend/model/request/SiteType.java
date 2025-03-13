package com.snc.backend.model.request;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "req_site_type")
public class SiteType extends CommonType {
}
