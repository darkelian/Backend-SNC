package com.snc.backend.model.shared.audit;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request_audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "method", length = 50)
    private String method;

    @Column(name = "path", length = 100)
    private String path;

    @Column(name = "user_agent", length = 200, nullable = false)
    private String userAgent;

    @Column(name = "request", length = 100, nullable = false)
    private String request;

    @Column(name = "response", length = 100)
    private String response;

    @Column(name = "status", length = 20)
    private String status;

    @Override
    public String toString() {
        return id + "-" + method;
    }
}