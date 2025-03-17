package com.snc.backend.model.shared.common;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public abstract class CommonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dispname", length = 70, unique = true)
    private String dispName;

    @Column(name = "text_code", length = 50, unique = true)
    private String textCode;

    @Override
    public String toString() {
        return dispName;
    }
}
