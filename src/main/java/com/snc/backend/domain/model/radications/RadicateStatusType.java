package com.snc.backend.domain.model.radications;

import com.snc.backend.domain.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "ra_radicate_status_type")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RadicateStatusType extends CommonType {
}
