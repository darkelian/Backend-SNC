package com.snc.backend.model.transacts;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_document_type_category_type")
@AttributeOverride(name = "dispname", column = @Column(name = "dispname", length = 150, unique = true, nullable = false))
public class DocumentTypeCategoryType extends CommonType {

}
