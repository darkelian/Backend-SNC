package com.snc.backend.model.radications;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.snc.backend.model.shared.User;

@Entity
@Table(name = "ra_radicate_status_history")
public class RadicateStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "status")
    private RadicateStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_accountable_change_status")
    private User userAccountableChangeStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "radicate", nullable = false)
    private Radicate radicate;

    @ManyToOne
    @JoinColumn(name = "comment")
    private RadicateStatusChangeComment comment;

    // Método para asignar la fecha de creación
    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public RadicateStatusType getStatus() {
        return status;
    }
    public void setStatus(RadicateStatusType status) {
        this.status = status;
    }
    public User getUserAccountableChangeStatus() {
        return userAccountableChangeStatus;
    }
    public void setUserAccountableChangeStatus(User userAccountableChangeStatus) {
        this.userAccountableChangeStatus = userAccountableChangeStatus;
    }
    public Radicate getRadicate() {
        return radicate;
    }
    public void setRadicate(Radicate radicate) {
        this.radicate = radicate;
    }
    public RadicateStatusChangeComment getComment() {
        return comment;
    }
    public void setComment(RadicateStatusChangeComment comment) {
        this.comment = comment;
    }
}