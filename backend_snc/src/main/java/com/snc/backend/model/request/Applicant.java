package com.snc.backend.model.request;
import java.time.LocalDate;

import com.snc.backend.model.shared.general.ColombianTown;
import com.snc.backend.model.shared.general.WorldCountry;

import jakarta.persistence.*;

@Entity
@Table(name = "req_user_beneficiary", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"identification_type_id", "identification_number"})
})
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

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public UserIdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(UserIdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public Boolean getIsNaturalPerson() {
        return isNaturalPerson;
    }

    public void setIsNaturalPerson(Boolean isNaturalPerson) {
        this.isNaturalPerson = isNaturalPerson;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public LocalDate getIdentificationDate() {
        return identificationDate;
    }

    public void setIdentificationDate(LocalDate identificationDate) {
        this.identificationDate = identificationDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneIndicative() {
        return phoneIndicative;
    }

    public void setPhoneIndicative(String phoneIndicative) {
        this.phoneIndicative = phoneIndicative;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public WorldCountry getCountry() {
        return country;
    }

    public void setCountry(WorldCountry country) {
        this.country = country;
    }

    public ColombianTown getColombianTown() {
        return colombianTown;
    }

    public void setColombianTown(ColombianTown colombianTown) {
        this.colombianTown = colombianTown;
    }

    public String getExternalState() {
        return externalState;
    }

    public void setExternalState(String externalState) {
        this.externalState = externalState;
    }

    public String getExternalTown() {
        return externalTown;
    }

    public void setExternalTown(String externalTown) {
        this.externalTown = externalTown;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsAcceptedEmailCommunication() {
        return isAcceptedEmailCommunication;
    }

    public void setIsAcceptedEmailCommunication(Boolean isAcceptedEmailCommunication) {
        this.isAcceptedEmailCommunication = isAcceptedEmailCommunication;
    }

    public ApplicantType getType() {
        return type;
    }

    public void setType(ApplicantType type) {
        this.type = type;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
}
