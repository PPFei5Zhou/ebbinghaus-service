package com.easy.ebbinghausservice.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Base jpa entity.
 *
 * @author Easy
 */
@MappedSuperclass
public class Base {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateDate;

    public Base() {
    }

    public Base(String id, Timestamp createDate, Timestamp updateDate) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Base)) {
            return false;
        }
        Base base = (Base) o;
        return Objects.equals(getId(), base.getId())
                && Objects.equals(getCreateDate(), base.getCreateDate())
                && Objects.equals(getUpdateDate(), base.getUpdateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreateDate(), getUpdateDate());
    }

    @Override
    public String toString() {
        return "Base{"
                + "id='" + id + '\''
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + '}';
    }
}
