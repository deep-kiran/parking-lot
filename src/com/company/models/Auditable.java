package com.company.models;

import java.util.Date;
import java.util.Objects;

public abstract class Auditable {
    private Date createdAt;
    private Date updatedAt;
    private Long id;
    private long UID =0;
    public Auditable(){
        id =UID++;
        setCreatedAt(new Date());
        setUpdatedAt(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditable auditable = (Auditable) o;
        return Objects.equals(id, auditable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

}
