package com.capital.user.manager.model;


import com.capital.user.manager.mapper.CustomPermission;


public class User {


    private String permissionName;
    private String userRoleName;
    private int createdBy;
    private int lastUpdatedBy;
    private byte isActive;
    CustomPermission customPermission;
    private String email;
    private String phone;
    private String address;
    private String pinCode;
    private String userTypeName;


    public User() {
    }

    public User(String permissionName, String userRoleName, int createdBy, int lastUpdatedBy, byte isActive, CustomPermission customPermission, String email, String phone, String address, String pinCode, String userTypeName) {
        this.permissionName = permissionName;
        this.userRoleName = userRoleName;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.isActive = isActive;
        this.customPermission = customPermission;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.pinCode = pinCode;
        this.userTypeName = userTypeName;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    public CustomPermission getCustomPermission() {
        return customPermission;
    }

    public void setCustomPermission(CustomPermission customPermission) {
        this.customPermission = customPermission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "User{" +
                "permissionName='" + permissionName + '\'' +
                ", userRoleName='" + userRoleName + '\'' +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", isActive=" + isActive +
                ", customPermission=" + customPermission +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
