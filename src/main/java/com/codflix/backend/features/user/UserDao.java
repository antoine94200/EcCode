package com.codflix.backend.features.user;

import com.codflix.backend.core.Database;
import com.codflix.backend.models.User;

import java.sql.*;

public class UserDao {
    /**
     * Request who get the mail and password information
     * @param email
     * @param password
     * @return
     */
    public User getUserByCredentials(String email, String password) {
        User user = null;

        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");

            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = mapToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private User mapToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt(1), // id
                rs.getString(2), // email
                rs.getString(3) // password
        );
    }

    public User getUserById(int userId) {
        User user = null;

        Connection connection = Database.get().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM user WHERE id=?");

            st.setInt(1, userId);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = mapToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /***
     * Function that allows a user to suscribe
     * @param email
     * @param password
     * @return a boolean if the suscrption is ok or not
     */
     public boolean insertNewUser(String email, String password) {
        String s = "INSERT INTO `user`(`email`,`password`) VALUES ('"+ email +"','"+ password+"');";
         System.out.println(s);
        Connection connection = Database.get().getConnection();
        try {
           PreparedStatement st = connection.prepareStatement(s);
            st.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }



    }
}
