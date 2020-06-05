package com.capital.user.manager.dao;

import com.capital.salt.dao.CapitalDaoSupport;
import com.capital.salt.exception.ApiException;
import com.capital.user.manager.mapper.UserRowMapper;
import com.capital.user.manager.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class UserDAOImpl extends CapitalDaoSupport implements UserDAO {

    static DriverManagerDataSource datasource = new DriverManagerDataSource();
    static JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);

    static{
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
        return queryForObject(UserDaoConstants.FETCH_USER_BY_ID_QUERY, new Object[] { id },
                new UserRowMapper());
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public User createUser(User user) {

        int user_role_id;
        int user_type_id;
        Timestamp created_timestamp=new Timestamp(new Date().getTime());
        Timestamp updated_timestamp= created_timestamp;

        if(user.getUserRoleName()=="User") {
            user_role_id = 2;
            user_type_id=user.getUserTypeName().equals("permanent") ? 1 : 2;
        }
        else{
            user_role_id = 1;
            user_type_id=user.getUserTypeName().equals("permanent") ? 1 : 2;
        }

        List<String> permissionsArray = jdbcTemplate.query (UserDaoConstants.FETCH_PERMISSIONS_ON_USER_ROLE,new Object[] {user.getUserRoleName()}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {

                return resultSet.getString(1);
            }
        });

        System.out.println();
        System.out.println( permissionsArray );



//        jdbcTemplate.update(UserDaoConstants.INSERT_USER_QUERY,user_role_id,user_type_id,user.getCreatedBy(),
//                user.getLastUpdatedBy(),user.getIsActive(),user.getCustomPermission().toString(),created_timestamp,updated_timestamp);

       // int user_id=  jdbcTemplate.queryForObject(UserDaoConstants.FETCH_USERID_FROM_USER_DETAIL_QUERY, new Object[] {}, Integer.class);

        //jdbcTemplate.update(UserDaoConstants.INSERT_USER_DETAIL_QUERY,user_id,user.getEmail(),user.getPhone(),user.getAddress(),user.getPinCode());

        System.out.println( user.getUserRoleName() );



        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
