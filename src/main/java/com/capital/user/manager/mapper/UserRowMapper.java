package com.capital.user.manager.mapper;

import com.capital.user.manager.model.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.minidev.json.JSONValue;
import org.springframework.jdbc.core.RowMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
