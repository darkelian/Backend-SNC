package com.snc.backend.domain.model.radications;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.snc.backend.domain.model.shared.User;

@Entity
@Table(name = "ra_radicate_status_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
    }
}
