package com.snc.backend.domain.model.transacts;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tr_transact_status_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
