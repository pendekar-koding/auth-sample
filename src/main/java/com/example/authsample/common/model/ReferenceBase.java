package com.example.authsample.common.model;

import org.apache.tomcat.util.security.MD5Encoder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Pendekar Koding on 2/3/2023
 **/
@MappedSuperclass
public class ReferenceBase extends AuditableBase {
    private static final long serialVersionUID = 2356004148521362099L;

    @Version
    private Integer version;
    private Boolean deleted;
    private String uuid;

    public ReferenceBase(){
      //default constructor
    }

    @PreUpdate
    private void preUpdate() {
        Integer currentVersion = getVersion();
        if (currentVersion != null) {
            this.version = getVersion() + 1;
        } else {
            this.version = Integer.parseInt("0");
        }

        if (getDeleted() == null) {
            this.deleted = false;
        }

        if (getUuid() == null) {
            this.uuid = MD5Encoder.encode(new Date().toString().getBytes());
        }
    }

    @PrePersist
    private void prePersist() {
        if (getUuid() == null) {
            ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
            this.uuid = UUID.randomUUID().toString() + zdt.toInstant().toEpochMilli();
        }
    }


    @Column(name = "version", length = 10)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", length = 64)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ReferenceBase{" +
                "version=" + version +
                ", deleted=" + deleted +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
