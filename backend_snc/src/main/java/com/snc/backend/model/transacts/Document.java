package com.snc.backend.model.transacts;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.snc.backend.model.shared.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tr_document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private DocumentType type;

    @Column(name = "filename", length = 100)
    private String filename;

    @Column(name = "url", length = 255)
    private String url;

    @Column(name = "filesize", nullable = false)
    private Integer filesize;

    @Column(name = "path", length = 255, nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name = "origin_type_id")
    private DocumentOriginType originType;

    @ManyToOne
    @JoinColumn(name = "user_create_id")
    private User userCreate;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DocumentOriginType getOriginType() {
        return originType;
    }

    public void setOriginType(DocumentOriginType originType) {
        this.originType = originType;
    }

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
