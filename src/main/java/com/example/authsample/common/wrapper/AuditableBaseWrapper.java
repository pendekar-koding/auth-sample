package com.example.authsample.common.wrapper;

import java.util.Date;

/**
 * Created by Pendekar Koding on 2/3/2023
 **/
public class AuditableBaseWrapper extends EntityBaseWrapper {
    private static final long serialVersionUID = 9218120148031867093L;

    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;

    public AuditableBaseWrapper() {
        //default constructor
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
