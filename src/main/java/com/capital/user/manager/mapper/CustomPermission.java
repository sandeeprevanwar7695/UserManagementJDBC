package com.capital.user.manager.mapper;

import javax.persistence.Entity;

public class CustomPermission {
    boolean create;
    boolean read;
    boolean insert;
    boolean update;
    boolean delete;

    public CustomPermission() {
        this.create = false;
        this.read = false;
        this.insert = false;
        this.update = false;
        this.delete = false;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "{" +
                "\"create\":" +'\"'+ create +'\"'+","+
                "\"read\":" +'\"'+ read +'\"'+","+
                "\"insert\":" +'\"'+ insert +'\"'+","+
                "\"update\":" +'\"'+ update +'\"'+","+
                "\"delete\":" +'\"'+ delete +'\"'+
                "}";
    }


}
