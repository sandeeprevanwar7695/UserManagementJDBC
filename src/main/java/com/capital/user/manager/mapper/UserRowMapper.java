package com.capital.user.manager.mapper;

import com.capital.user.manager.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();

        user.setUserRoleName(rs.getString(1));
        user.setCreatedBy(rs.getInt(2));
        user.setLastUpdatedBy(rs.getInt(3));
        user.setIsActive(rs.getByte(4));
        String str =rs.getString(5);
        System.out.println(str);

        try {
            CustomPermission customPermission = new ObjectMapper().readValue(str, CustomPermission.class);
            user.setCustomPermission(customPermission);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        user.setEmail(rs.getString(6));
        user.setPhone(rs.getString(7));
        user.setAddress(rs.getString(8));
        user.setPinCode(rs.getString(9));
        user.setUserTypeName(rs.getString(10));

        return user;
    }

}
