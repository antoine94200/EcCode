package com.codflix.backend.features.genre;

import com.codflix.backend.core.Template;
import com.codflix.backend.models.Genre;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreController {

    private final GenreDao genreDao = new GenreDao();

    public String list(Request request, Response response) {
        List<Genre> genres = genreDao.getAllGenres();

        Map<String, Object> model = new HashMap<>();
        model.put("genres", genres);
        return Template.render("genre_list.html", model);
    }
}
