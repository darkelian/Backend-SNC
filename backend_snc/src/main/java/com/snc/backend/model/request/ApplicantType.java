package com.snc.backend.model.request;

import com.snc.backend.model.shared.common.CommonType;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "req_applicant_type")
public class ApplicantType extends CommonType {
}
