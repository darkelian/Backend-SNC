package com.snc.backend.model.shared.general;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.model.shared.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "gen_inter_system_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private User userLog;

    @Column(name = "date_log")
    private LocalDateTime dateLog;
}