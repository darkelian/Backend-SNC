package com.snc.backend.domain.model.request;

import java.time.LocalDate;

import com.snc.backend.domain.model.shared.general.ColombianTown;
import com.snc.backend.domain.model.shared.general.WorldCountry;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "req_user_beneficiary", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"identification_type_id", "identification_number"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "second_name", length = 30)
    private String secondName;

    @Column(name = "first_last_name", length = 30)
    private String firstLastName;

    @Column(name = "second_last_name", length = 30)
    private String secondLastName;

    @Column(name = "business_name", length = 250)
    private String businessName;

    @ManyToOne
    @JoinColumn(name = "identification_type_id", nullable = false)
    private UserIdentificationType identificationType;

    @Column(name = "is_natural_person", nullable = false)
    private Boolean isNaturalPerson;

    @Column(name = "identification_number", length = 30, nullable = false)
    private String identificationNumber;

    @Column(name = "identification_date")
    private LocalDate identificationDate;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "phone_indicative", length = 10)
    private String phoneIndicative;

    @Column(name = "address", length = 255)
    private String address;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private WorldCountry country;

    @ManyToOne
    @JoinColumn(name = "colombian_town_id")
    private ColombianTown colombianTown;

    @Column(name = "external_state", length = 100)
    private String externalState;

    @Column(name = "external_town", length = 100)
    private String externalTown;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "is_accepted_email_communication")
    private Boolean isAcceptedEmailCommunication;

    @ManyToOne
    @JoinColumn(name = "applicant_type_id")
    private ApplicantType type;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified = false;
}
