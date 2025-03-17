package com.snc.backend.model.radications;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tr_radicate_status_change_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadicateStatusChangeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "comment")
    private String comment;
}
