package com.snc.backend.model.radications;
import jakarta.persistence.*;

@Entity
@Table(name = "tr_radicate_status_change_comment")
public class RadicateStatusChangeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "comment")
    private String comment;

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
