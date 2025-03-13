package com.snc.backend.model.request;

import java.time.LocalDateTime;

import com.snc.backend.model.shared.User;

import jakarta.persistence.*;

@Entity
@Table(name = "req_request")
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

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RequestStatusType getStatus() {
        return status;
    }

    public void setStatus(RequestStatusType status) {
        this.status = status;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Integer getNumFolios() {
        return numFolios;
    }

    public void setNumFolios(Integer numFolios) {
        this.numFolios = numFolios;
    }

    public Integer getNumAnnexes() {
        return numAnnexes;
    }

    public void setNumAnnexes(Integer numAnnexes) {
        this.numAnnexes = numAnnexes;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Boolean getIsTutelage() {
        return isTutelage;
    }

    public void setIsTutelage(Boolean isTutelage) {
        this.isTutelage = isTutelage;
    }

    public Boolean getIsRightOfPetition() {
        return isRightOfPetition;
    }

    public void setIsRightOfPetition(Boolean isRightOfPetition) {
        this.isRightOfPetition = isRightOfPetition;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public User getUserRadicate() {
        return userRadicate;
    }

    public void setUserRadicate(User userRadicate) {
        this.userRadicate = userRadicate;
    }

    public UserType getUserCreateType() {
        return userCreateType;
    }

    public void setUserCreateType(UserType userCreateType) {
        this.userCreateType = userCreateType;
    }

    public CorrespondenceDocumentType getCorrespondenceDocumentType() {
        return correspondenceDocumentType;
    }

    public void setCorrespondenceDocumentType(CorrespondenceDocumentType correspondenceDocumentType) {
        this.correspondenceDocumentType = correspondenceDocumentType;
    }
}
