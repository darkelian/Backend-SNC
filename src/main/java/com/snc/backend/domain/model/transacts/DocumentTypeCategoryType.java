package com.snc.backend.domain.model.transacts;

import com.snc.backend.domain.model.shared.common.CommonType;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tr_document_type_category_type")
@AttributeOverride(name = "dispname", column = @Column(name = "dispname", length = 150, unique = true, nullable = false))
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class DocumentTypeCategoryType extends CommonType {
}
