package com.codflix.backend.middlewares;

import com.codflix.backend.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

/**
 * Logs the HTTP request in the form of "GET /login user=bob".
 */
public class LoggerMiddleware implements Middleware {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    public void process(Request request, Response response) {
        String log = request.requestMethod() +
                " " + request.url() +
                " " + request.body();
        logger.info(log);
    }
}
