package com.snc.backend.model.transacts;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.model.shared.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_transact_status_history")
public class TransactStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id")
    private TransactStatusType status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_create_id")
    private User userCreate;

    @Column(name = "user_create_role", length = 50, nullable = false)
    private String userCreateRole;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transact_id")
    private Transact transact;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private TransactStatusChangeComment comment;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactStatusType getStatus() {
        return status;
    }

    public void setStatus(TransactStatusType status) {
        this.status = status;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserCreateRole() {
        return userCreateRole;
    }

    public void setUserCreateRole(String userCreateRole) {
        this.userCreateRole = userCreateRole;
    }

    public Transact getTransact() {
        return transact;
    }

    public void setTransact(Transact transact) {
        this.transact = transact;
    }

    public TransactStatusChangeComment getComment() {
        return comment;
    }

    public void setComment(TransactStatusChangeComment comment) {
        this.comment = comment;
    }
}
