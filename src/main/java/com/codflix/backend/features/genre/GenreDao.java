package com.codflix.backend.features.genre;

import com.codflix.backend.core.Database;
import com.codflix.backend.models.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {

    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        Connection connection = Database.get().getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM genre");
            while (rs.next()) {
                Genre genre = new Genre(
                        rs.getInt(1),
                        rs.getString(2)
                );

                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }
}
