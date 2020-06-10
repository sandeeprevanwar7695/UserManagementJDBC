package com.capital.user.manager.dao;

import com.capital.user.manager.mapper.CustomPermission;

public class UserDaoConstants {
    private UserDaoConstants() {
    }


//    private int createdBy;
//    private int lastUpdatedBy;
//    private byte isActive;
//    CustomPermission customPermission;


    public static final String FETCH_USERS_QUERY = "Select user_role_name,created_By,last_Updated_By,is_Active,custom_permissions,email,phone,address,pin_code,user_type_name from user as u "
            + "inner join user_detail as ud on u.user_id = ud.user_id "
            + "inner join user_type as ut on ut.user_type_id=u.user_type_id "
            + "inner join user_role as ur on u.user_role_id = ur.user_role_id ";
           // + "inner join user_role_permission_map as urpm on  ur.user_role_id=urpm.user_role_id "
          //  + "inner join user_permission as up on  up.permission_id=urpm.permission_id where u.is_active=1";

    public static final String FETCH_USER_BY_ID_QUERY = "Select user_role_name,created_By,last_Updated_By,is_Active,custom_permissions,email,phone,address,pin_code,user_type_name from user as u "
            + "inner join user_detail as ud on u.user_id = ud.user_id "
            + "inner join user_type as ut on ut.user_type_id=u.user_type_id "
            + "inner join user_role as ur on u.user_role_id = ur.user_role_id "
            + "where u.user_id = ? and u.is_active=1";

    public static final String INSERT_USER_TABLE_QUERY ="INSERT INTO user(user_role_id,user_type_id,created_by," +
            "last_updated_by,is_active,custom_permissions,created_timestamp,updated_timestamp)" +
            "VALUES(?,?,?,?,?,?,?,?)";

    public static final String INSERT_USER_DETAIL_TABLE_QUERY ="INSERT INTO user_detail(user_id,email,phone,address,pin_code) VALUES(?,?,?,?,?)";
    public static final String FETCH_MAX_USER_ID_FROM_USER_TABLE_QUERY ="SELECT max(user_id) from user";

    public static final String FETCH_PERMISSIONS_FROM_USER_PERMISSION_TABLE_ON_USER_ROLE_QUERY = "select up.permission_name from user_permission up inner join user_role_permission_map urpm " +
            "on up.permission_id = urpm.permission_id inner join user_role ur on urpm.user_role_id = ur.user_role_id where ur.user_role_name=? " ;

    public static final String FETCH_USER_TYPE_ID_FROM_USER_TYPE_TABLE_QUERY ="SELECT user_type_id from user_type where user_type_name=?";
    public static final String INSERT_NEW_USER_TYPE_IN_USER_TYPE_TABLE_QUERY ="INSERT INTO user_type(user_type_name) VALUES(?)";
    public static final String FETCH_MAX_USERID_FROM_USER_TYPE_TABLE_QUERY ="SELECT max(user_type_id) from user_type";

    public static final String DELETE_FROM_USER_DETAIL_TABLE = "DELETE FROM user_detail where user_id= ?";
    public static final String DELETE_FROM_USER_TABLE = "DELETE FROM user  where user_id= ?";

    public static final String UPDATE_USER_TABLE_QUERY = "update user set  user_type_id=?, is_active=?,updated_timestamp=? where user_id=?";
    public static final String UPDATE_USER_DETAIL_TABLE_QUERY="update user_detail set email=?,phone=?,address=?,pin_code=? where user_id=?";

    public static final String FETCH_MIN_USER_ID_FROM_USER_TABLE_QUERY ="SELECT min(user_id) from user";
    public static final String DELETE_ALL_FROM_USER_DETAIL_TABLE = "DELETE FROM user_detail where user_id != ? ";
    public static final String DELETE_ALL_FROM_USER_TABLE = "DELETE FROM user where user_id != ? ";

}
