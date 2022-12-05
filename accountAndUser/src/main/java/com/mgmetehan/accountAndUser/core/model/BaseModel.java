package com.mgmetehan.accountAndUser.core.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date createdDateTime;

    protected Date lastModifiedDate;

    private boolean enable = true;

    public abstract <T extends BaseModel> void update(T entity);

    @PrePersist
    public void onCreate() {
        this.createdDateTime = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedDate = new Date();
    }
}