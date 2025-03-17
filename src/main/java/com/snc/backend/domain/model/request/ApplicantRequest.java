package com.snc.backend.domain.model.request;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "req_applicant_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @Column(name = "is_principal", nullable = false)
    private Boolean isPrincipal;
}

