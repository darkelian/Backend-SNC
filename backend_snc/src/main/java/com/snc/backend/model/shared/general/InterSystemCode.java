package com.snc.backend.model.shared.general;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.model.shared.User;

import jakarta.persistence.*;


@Entity
@Table(name = "gen_inter_system_code")
public class InterSystemCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "source_system", length = 50, nullable = false)
    private String sourceSystem;

    @Column(name = "target_system", length = 50, nullable = false)
    private String targetSystem;

    @Column(name = "origin_value", length = 255, nullable = false)
    private String originValue;

    @Column(name = "target_value", length = 255, nullable = false)
    private String targetValue;

    @CreationTimestamp
    @Column(name = "date_from", nullable = false, updatable = false)
    private LocalDateTime dateFrom;

    @Column(name = "date_to")
    private LocalDateTime dateTo;

    @ManyToOne
    @JoinColumn(name = "user_log_id")
    private User userLog; // Asegúrate de tener definida la entidad User en tu proyecto

    @Column(name = "date_log")
    private LocalDateTime dateLog;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getTargetSystem() {
        return targetSystem;
    }

    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem;
    }

    public String getOriginValue() {
        return originValue;
    }

    public void setOriginValue(String originValue) {
        this.originValue = originValue;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public User getUserLog() {
        return userLog;
    }

    public void setUserLog(User userLog) {
        this.userLog = userLog;
    }

    public LocalDateTime getDateLog() {
        return dateLog;
    }

    public void setDateLog(LocalDateTime dateLog) {
        this.dateLog = dateLog;
    }
}