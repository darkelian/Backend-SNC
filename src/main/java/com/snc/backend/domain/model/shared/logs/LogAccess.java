package com.snc.backend.domain.model.shared.logs;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.domain.model.shared.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_access")
public class LogAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    @Column(name = "is_login", nullable = false)
    private Boolean isLogin;

    @Column(name = "client_ip", length = 12)
    private String clientIp;

    @Column(name = "client_browser", length = 100)
    private String clientBrowser;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Asegúrate de tener definida la entidad User en tu proyecto

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // No se incluye setter para date ya que se asigna automáticamente

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientBrowser() {
        return clientBrowser;
    }

    public void setClientBrowser(String clientBrowser) {
        this.clientBrowser = clientBrowser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
