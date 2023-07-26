package com.example.authsample.common.wrapper;

/**
 * Created by Pendekar Koding on 2/3/2023
 **/
public class ReferenceBaseWrapper extends AuditableBaseWrapper {
    private static final long serialVersionUID = 958931178680097388L;

    private Integer version;
    private Boolean deleted;


    public ReferenceBaseWrapper() {
        //default constructor
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
