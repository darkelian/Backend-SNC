package com.snc.backend.domain.model.transacts;
import com.snc.backend.domain.model.shared.common.TransactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tr_transact_type_acceptable_times")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactTypeAcceptableTimes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "transact_type_id")
    private TransactType transactType;

    @Column(name = "medium", nullable = false)
    private Short medium = 0;

    @Column(name = "maximum", nullable = false)
    private Short maximum = 0;
}
