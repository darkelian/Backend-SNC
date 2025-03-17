package com.snc.backend.model.radications;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.Builder;

@Entity
@Table(name = "ra_radicate_create_user_type")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class RadicateCreateUserType extends CommonType {
    // Hereda los campos de CommonType
}
