package com.snc.backend.domain.model.radications;

import com.snc.backend.domain.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;

@Entity
@Table(name = "ra_radicate_channel_create_type")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RadicateChannelCreateType extends CommonType {
    // Hereda los campos de CommonType
}
