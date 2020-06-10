package com.capital.user.manager.dao;

import com.capital.salt.dao.CapitalDaoSupport;
import com.capital.salt.exception.ApiException;
import com.capital.user.manager.mapper.CustomPermission;
import com.capital.user.manager.mapper.UserRowMapper;
import com.capital.user.manager.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

@Component
public class UserDAOImpl extends CapitalDaoSupport implements UserDAO {

    static DriverManagerDataSource datasource = new DriverManagerDataSource();
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);


    static {
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/capital");
        datasource.setUsername("root");
        datasource.setPassword("mysql123");
    }

    public UserDAOImpl(DataSource datasource) {
        super(datasource);
    }

    @Override
    public List<User> getAllUsers() throws ApiException {
        return queryForList(UserDaoConstants.FETCH_USERS_QUERY, new UserRowMapper());
    }

    @Override
    public User getUserById(Long id) throws ApiException {
        System.err.println(id);

        return queryForObject(UserDaoConstants.FETCH_USER_BY_ID_QUERY, new Object[]{id},
                new UserRowMapper());
    }


    @Override
    public User createUser(User user) {

        int user_role_id;
        int user_type_id;

        Timestamp created_timestamp = new Timestamp(new Date().getTime());
        Timestamp updated_timestamp = created_timestamp;

        if (user.getUserRoleName().toLowerCase() == "user") {
            user_role_id = 2;
        } else {
            user_role_id = 1;
        }

        List<String> permissionsArray = jdbcTemplate.query(UserDaoConstants.FETCH_PERMISSIONS_FROM_USER_PERMISSION_TABLE_ON_USER_ROLE_QUERY, new Object[]{user.getUserRoleName()}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {

                return resultSet.getString(1);
            }
        });

        CustomPermission customPermission = new CustomPermission();

        for (String permission : permissionsArray) {

            switch (permission.toLowerCase()) {
                case "create":
                    customPermission.setCreate(true);
                    break;

                case "read":
                    customPermission.setRead(true);
                    break;

                case "insert":
                    customPermission.setInsert(true);
                    break;

                case "update":
                    customPermission.setUpdate(true);
                    break;

                case "delete":
                    customPermission.setDelete(true);
                    break;
            }
        }
        user.setCustomPermission(customPermission);

        List<Integer> user_type_id_list = jdbcTemplate.queryForList(UserDaoConstants.FETCH_USER_TYPE_ID_FROM_USER_TYPE_TABLE_QUERY,
                new Object[]{user.getUserTypeName()}, Integer.class);

        if (user_type_id_list.isEmpty()) {

            jdbcTemplate.update(UserDaoConstants.INSERT_NEW_USER_TYPE_IN_USER_TYPE_TABLE_QUERY,user.getUserTypeName());
             user_type_id=  jdbcTemplate.queryForObject(UserDaoConstants.FETCH_MAX_USERID_FROM_USER_TYPE_TABLE_QUERY, new Object[] {}, Integer.class);

        }
        else{
            user_type_id = user_type_id_list.get(0);
        }


      jdbcTemplate.update(UserDaoConstants.INSERT_USER_TABLE_QUERY,user_role_id,user_type_id,user.getCreatedBy(),
               user.getLastUpdatedBy(),user.getIsActive(),user.getCustomPermission().toString(),created_timestamp,updated_timestamp);

        int user_id=  jdbcTemplate.queryForObject(UserDaoConstants.FETCH_MAX_USER_ID_FROM_USER_TABLE_QUERY, new Object[] {}, Integer.class);

        jdbcTemplate.update(UserDaoConstants.INSERT_USER_DETAIL_TABLE_QUERY,user_id,user.getEmail(),user.getPhone(),user.getAddress(),user.getPinCode());


        return null;
    }

    @Override
    public User updateUser(User user) {

        int user_type_id;

        List<Integer> user_type_id_list = jdbcTemplate.queryForList(UserDaoConstants.FETCH_USER_TYPE_ID_FROM_USER_TYPE_TABLE_QUERY,
                new Object[]{user.getUserTypeName()}, Integer.class);

        if (user_type_id_list.isEmpty()) {

            jdbcTemplate.update(UserDaoConstants.INSERT_NEW_USER_TYPE_IN_USER_TYPE_TABLE_QUERY,user.getUserTypeName());
            user_type_id=  jdbcTemplate.queryForObject(UserDaoConstants.FETCH_MAX_USERID_FROM_USER_TYPE_TABLE_QUERY, new Object[] {}, Integer.class);

        }
        else{
            user_type_id = user_type_id_list.get(0);
        }

        Timestamp updated_timestamp = new Timestamp(new Date().getTime());

        jdbcTemplate.update(UserDaoConstants.UPDATE_USER_TABLE_QUERY,user_type_id,user.getIsActive(),updated_timestamp,user.getUserId());

        jdbcTemplate.update(UserDaoConstants.UPDATE_USER_DETAIL_TABLE_QUERY,user.getEmail(),user.getPhone(),user.getAddress(),user.getPinCode(),user.getUserId());

        return null;
    }

    @Override
    public void deleteUserById(Long id) {

        jdbcTemplate.update(UserDaoConstants.DELETE_FROM_USER_DETAIL_TABLE,id);
        jdbcTemplate.update(UserDaoConstants.DELETE_FROM_USER_TABLE,id);
    }

    @Override
    public void deleteAll() {

        int user_id=  jdbcTemplate.queryForObject(UserDaoConstants.FETCH_MIN_USER_ID_FROM_USER_TABLE_QUERY, new Object[] {}, Integer.class);


        jdbcTemplate.update(UserDaoConstants.DELETE_ALL_FROM_USER_DETAIL_TABLE,user_id);
        jdbcTemplate.update(UserDaoConstants.DELETE_ALL_FROM_USER_TABLE,user_id);
    }
}
