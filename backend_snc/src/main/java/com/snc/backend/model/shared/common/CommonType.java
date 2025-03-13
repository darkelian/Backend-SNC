package com.snc.backend.model.shared.common;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class CommonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dispname", length = 70, unique = true)
    private String dispName;

    @Column(name = "text_code", length = 50, unique = true)
    private String textCode;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDispName() {
        return dispName;
    }
    public void setDispName(String dispName) {
        this.dispName = dispName;
    }
    public String getTextCode() {
        return textCode;
    }
    public void setTextCode(String textCode) {
        this.textCode = textCode;
    }

    @Override
    public String toString() {
        return dispName;
    }
}