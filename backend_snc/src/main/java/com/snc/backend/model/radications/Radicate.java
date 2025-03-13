package com.snc.backend.model.radications;

import com.snc.backend.model.request.Request;
import com.snc.backend.model.shared.User;
import com.snc.backend.model.shared.common.TransactType;
import com.snc.backend.model.shared.general.ColombianTown;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ra_radicate")
public class Radicate {

    @Id
    @Column(name = "radicated_number", length = 20)
    private String radicatedNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request", nullable = false)
    private Request request;

    @Column(name = "radicate_date", nullable = false, updatable = false)
    private LocalDateTime radicateDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", nullable = false)
    private RadicateStatusType status;

    @ManyToOne
    @JoinColumn(name = "town")
    private ColombianTown town;

    @Column(name = "state", length = 6, nullable = false)
    private String state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_create", nullable = false)
    private User userCreate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_user_create", nullable = false)
    private RadicateCreateUserType typeUserCreate;

    @ManyToOne
    @JoinColumn(name = "initial_transact_type")
    private TransactType initialTransactType;

    @Column(name = "requires_visit", nullable = false)
    private Boolean requiresVisit = false;

    @ManyToOne
    @JoinColumn(name = "channel_create_type")
    private RadicateChannelCreateType channelCreateType;

    // Método para asignar la fecha de creación
    @PrePersist
    public void prePersist() {
        this.radicateDate = LocalDateTime.now();
    }

    // Getters y Setters
    public String getRadicatedNumber() {
        return radicatedNumber;
    }
    public void setRadicatedNumber(String radicatedNumber) {
        this.radicatedNumber = radicatedNumber;
    }
    public Request getRequest() {
        return request;
    }
    public void setRequest(Request request) {
        this.request = request;
    }
    public LocalDateTime getRadicateDate() {
        return radicateDate;
    }
    public void setRadicateDate(LocalDateTime radicateDate) {
        this.radicateDate = radicateDate;
    }
    public RadicateStatusType getStatus() {
        return status;
    }
    public void setStatus(RadicateStatusType status) {
        this.status = status;
    }
    public ColombianTown getTown() {
        return town;
    }
    public void setTown(ColombianTown town) {
        this.town = town;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public User getUserCreate() {
        return userCreate;
    }
    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }
    public RadicateCreateUserType getTypeUserCreate() {
        return typeUserCreate;
    }
    public void setTypeUserCreate(RadicateCreateUserType typeUserCreate) {
        this.typeUserCreate = typeUserCreate;
    }
    public TransactType getInitialTransactType() {
        return initialTransactType;
    }
    public void setInitialTransactType(TransactType initialTransactType) {
        this.initialTransactType = initialTransactType;
    }
    public Boolean getRequiresVisit() {
        return requiresVisit;
    }
    public void setRequiresVisit(Boolean requiresVisit) {
        this.requiresVisit = requiresVisit;
    }
    public RadicateChannelCreateType getChannelCreateType() {
        return channelCreateType;
    }
    public void setChannelCreateType(RadicateChannelCreateType channelCreateType) {
        this.channelCreateType = channelCreateType;
    }
}
