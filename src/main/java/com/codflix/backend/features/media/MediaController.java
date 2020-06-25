package com.codflix.backend.features.media;

import com.codflix.backend.core.Template;
import com.codflix.backend.features.genre.GenreDao;
import com.codflix.backend.models.Genre;
import com.codflix.backend.models.Media;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaController {
    private final MediaDao mediaDao = new MediaDao();
//améliorer la fonction pour qu'elle gère les filtres genre, année et type
    public String list(Request request, Response response) {
        List<Media> medias;

        String title = request.queryParams("title");
        String type = request.queryParams("type");
        String genre = request.queryParams("genre");
        String date = request.queryParams("year");

        if (title == null && type == null) {
            medias = mediaDao.getAllMedias();
        } else {
            medias = mediaDao.filterMedias(title,type, genre, date);

        }

        Map<String, Object> model = new HashMap<>();
        model.put("medias", medias);
        return Template.render("media_list.html", model);
    }

    public String detail(Request request, Response res) {
        int id = Integer.parseInt(request.params(":id"));
        Media media = mediaDao.getMediaById(id);

        Map<String, Object> model = new HashMap<>();
        model.put("media", media);
        return Template.render("media_detail.html", model);
    }

    /**
     *
     * @param request the request for the BDD (table media)
     * @param response the response for the BDD (table media)
     * @return the html page for the media list
     */
    public String listGenre(Request request, Response response) {
        List<Media> medias;
        System.out.println("listGenre ici");

        int genre = Integer.parseInt(request.queryParams("genre"));
        System.out.println(genre);

        if (genre != 0) {
            medias = mediaDao.filterMediasByGenre(genre);
        } else {
            medias = mediaDao.getAllMedias();
        }

        Map<String, Object> model = new HashMap<>();
        model.put("medias", medias);
        return Template.render("media_list.html", model);
    }
}
