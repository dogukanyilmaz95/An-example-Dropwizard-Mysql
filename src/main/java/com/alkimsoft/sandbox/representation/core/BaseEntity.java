package com.alkimsoft.sandbox.representation.core;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by gunerkaanalkim on 14/03/16.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32)
    private String oid;

    @Version
    private long lastUpdated;

    private DateTime creationDateTime = new DateTime();

    private Boolean deletingStatus = false;

    public Boolean getDeletingStatus() {
        return deletingStatus;
    }

    public void setDeletingStatus(Boolean deletingStatus) {
        this.deletingStatus = deletingStatus;
    }

    public BaseEntity() {
    }

    public BaseEntity(String oid, long lastUpdated) {
        this.oid = oid;
        this.lastUpdated = lastUpdated;
    }

    public DateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(DateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
