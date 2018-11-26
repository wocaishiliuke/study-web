package com.baicai.dao;

import com.baicai.pojo.User;
import com.baicai.util.C3p0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User queryUser(User user) {
        Connection conn = C3p0Utils.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username=? and password=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                User existUser = new User();
                existUser.setUsername(rs.getString("username"));
                existUser.setPassword(rs.getString("password"));
                return existUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0Utils.release(conn, ps, rs);
        }
        return null;
    }
}
