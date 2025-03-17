package com.snc.backend.model.radications;

import com.snc.backend.model.request.Request;
import com.snc.backend.model.shared.User;
import com.snc.backend.model.shared.common.TransactType;
import com.snc.backend.model.shared.general.ColombianTown;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ra_radicate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @PrePersist
    public void prePersist() {
        this.radicateDate = LocalDateTime.now();
    }
}
