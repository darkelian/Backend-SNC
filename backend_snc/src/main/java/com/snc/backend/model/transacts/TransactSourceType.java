package com.snc.backend.model.transacts;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_transact_source_type")
public class TransactSourceType extends CommonType {
}
