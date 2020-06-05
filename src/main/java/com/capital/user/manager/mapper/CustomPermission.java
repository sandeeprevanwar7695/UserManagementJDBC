package com.capital.user.manager.mapper;

import javax.persistence.Entity;

public class CustomPermission {
    boolean create;
    boolean insert;
    boolean update;

    public CustomPermission() {
    }

    public CustomPermission(boolean create, boolean insert, boolean update) {
        this.create = create;
        this.insert = insert;
        this.update = update;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
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

    @Override
    public String toString() {
        return "{" +
                "\"create\":" +'\"'+ create +'\"'+","+
                "\"insert\":" +'\"'+ insert +'\"'+","+
                "\"update\":" +'\"'+ update +'\"'+
                "}";
    }


}
