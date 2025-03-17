package com.snc.backend.model.request;

import java.time.LocalDateTime;

import com.snc.backend.model.shared.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "req_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tipo de solicitud
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private RequestType type;

    @Column(name = "number", length = 40, nullable = false)
    private String number;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "subject", length = 650)
    private String subject;

    @Lob
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private RequestStatusType status;

    @Column(name = "is_finished", nullable = false)
    private Boolean isFinished = false;

    @Column(name = "num_folios", nullable = false)
    private Integer numFolios;

    @Column(name = "num_annexes", nullable = false)
    private Integer numAnnexes;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @Column(name = "is_tutelage", nullable = false)
    private Boolean isTutelage = false;

    @Column(name = "is_right_of_petition", nullable = false)
    private Boolean isRightOfPetition = false;

    @ManyToOne
    @JoinColumn(name = "user_create_id", nullable = false)
    private User userCreate;

    @ManyToOne
    @JoinColumn(name = "user_radicate_id", nullable = false)
    private User userRadicate;

    @ManyToOne
    @JoinColumn(name = "user_create_type_id")
    private UserType userCreateType;

    @ManyToOne
    @JoinColumn(name = "correspondence_document_type_id")
    private CorrespondenceDocumentType correspondenceDocumentType;
}