package com.snc.backend.model.transacts;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.model.radications.Radicate;
import com.snc.backend.model.shared.User;
import com.snc.backend.model.shared.common.TransactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_transact")
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

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Radicate getRadicate() {
        return radicate;
    }

    public void setRadicate(Radicate radicate) {
        this.radicate = radicate;
    }

    public Integer getTrOrder() {
        return trOrder;
    }

    public void setTrOrder(Integer trOrder) {
        this.trOrder = trOrder;
    }

    public TransactType getType() {
        return type;
    }

    public void setType(TransactType type) {
        this.type = type;
    }

    public LandConditionType getLandCondition() {
        return landCondition;
    }

    public void setLandCondition(LandConditionType landCondition) {
        this.landCondition = landCondition;
    }

    public TransactStatusType getStatus() {
        return status;
    }

    public void setStatus(TransactStatusType status) {
        this.status = status;
    }

    public User getUserCreates() {
        return userCreates;
    }

    public void setUserCreates(User userCreates) {
        this.userCreates = userCreates;
    }

    public String getResolutionNumber() {
        return resolutionNumber;
    }

    public void setResolutionNumber(String resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public LocalDateTime getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(LocalDateTime resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDate getDateExpirationMedium() {
        return dateExpirationMedium;
    }

    public void setDateExpirationMedium(LocalDate dateExpirationMedium) {
        this.dateExpirationMedium = dateExpirationMedium;
    }

    public LocalDate getDateExpirationMaximum() {
        return dateExpirationMaximum;
    }

    public void setDateExpirationMaximum(LocalDate dateExpirationMaximum) {
        this.dateExpirationMaximum = dateExpirationMaximum;
    }

    public LocalDate getCadastralRegistrationDate() {
        return cadastralRegistrationDate;
    }

    public void setCadastralRegistrationDate(LocalDate cadastralRegistrationDate) {
        this.cadastralRegistrationDate = cadastralRegistrationDate;
    }

    public TransactSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(TransactSourceType sourceType) {
        this.sourceType = sourceType;
    }

    public ExecutionClassificationType getExecutionClassificationType() {
        return executionClassificationType;
    }

    public void setExecutionClassificationType(ExecutionClassificationType executionClassificationType) {
        this.executionClassificationType = executionClassificationType;
    }
}
