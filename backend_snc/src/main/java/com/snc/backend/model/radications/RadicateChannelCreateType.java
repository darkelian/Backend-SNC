package com.snc.backend.model.radications;
import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ra_radicate_channel_create_type")
public class RadicateChannelCreateType extends CommonType {
    // Hereda los campos de CommonType
}