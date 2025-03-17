package com.snc.backend.domain.model.transacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.domain.model.radications.Radicate;
import com.snc.backend.domain.model.shared.User;
import com.snc.backend.domain.model.shared.common.TransactType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tr_transact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "radicate_id")
    private Radicate radicate;

    @Column(name = "tr_order", nullable = false)
    private Integer trOrder = 0;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private TransactType type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "land_condition_id")
    private LandConditionType landCondition;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id")
    private TransactStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_creates_id")
    private User userCreates;

    @Column(name = "resolution_number", length = 20)
    private String resolutionNumber;

    @Column(name = "resolution_date")
    private LocalDateTime resolutionDate;

    @Column(name = "is_principal", nullable = false)
    private Boolean isPrincipal = false;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    @Column(name = "date_expiration_medium")
    private LocalDate dateExpirationMedium;

    @Column(name = "date_expiration_maximum")
    private LocalDate dateExpirationMaximum;

    @Column(name = "cadastral_registration_date")
    private LocalDate cadastralRegistrationDate;

    @ManyToOne
    @JoinColumn(name = "source_type_id")
    private TransactSourceType sourceType;

    @ManyToOne
    @JoinColumn(name = "execution_classification_type_id")
    private ExecutionClassificationType executionClassificationType;
}
