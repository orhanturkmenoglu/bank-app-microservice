package com.example.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;


    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;


    /**
     * get field @Column(updatable = false)
     *
     * @return createdAt @Column(updatable = false)

     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * set field @Column(updatable = false)
     *
     * @param createdAt @Column(updatable = false)

     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * get field @Column(updatable = false)
     *
     * @return createdBy @Column(updatable = false)

     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * set field @Column(updatable = false)
     *
     * @param createdBy @Column(updatable = false)

     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * get field @Column(insertable = false)
     *
     * @return updatedAt @Column(insertable = false)

     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * set field @Column(insertable = false)
     *
     * @param updatedAt @Column(insertable = false)

     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * get field @Column(insertable = false)
     *
     * @return updatedBy @Column(insertable = false)

     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * set field @Column(insertable = false)
     *
     * @param updatedBy @Column(insertable = false)

     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
