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
@Table(name = "tr_document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
