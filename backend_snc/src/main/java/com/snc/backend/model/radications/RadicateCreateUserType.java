package com.snc.backend.model.radications;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ra_radicate_create_user_type")
public class RadicateCreateUserType extends CommonType {
    // Hereda los campos de CommonType
}