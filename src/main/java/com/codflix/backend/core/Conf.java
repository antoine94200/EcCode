package com.codflix.backend.core;

import java.io.File;

/**
 * This class centralizes all the configuration of the app (port, database, resources, etc)
 */
public class Conf {
    // General
    public static final boolean DEBUG_MODE = true;
    public static final int HTTP_PORT = 8080;

    // Database
    public static final String DB_HOST = getEnv("CODFLIX_DB_HOST", "localhost:3307");
    public static final String DB_NAME = getEnv("CODFLIX_DB_NAME", "codflix");
    public static final String DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;
    public static final String DB_USER = getEnv("CODFLIX_DB_USER", "root");
    public static final String DB_PASSWORD = getEnv("CODFLIX_DB_PASSWORD", "root");

    // Resources
    public static final File RESOURCES_DIR = new File("src/main/resources");
    public static final File TEMPLATE_DIR = new File(RESOURCES_DIR, "templates");
    public static final File STATIC_DIR = new File(RESOURCES_DIR, "static");

    // Routes
    public static final String ROUTE_LOGGED_ROOT = "/medias/";

    /**
     * Helper to retrieve an environment variable and use a default value if not found.
     *
     * @param key: name of the environment variable
     * @param def: default value if the key was not found or is empty
     * @return the value at key or default.
     */
    private static String getEnv(String key, String def) {
        String value = System.getenv(key);
        if (value == null || value.isEmpty()) {
            value = def;
        }
        return value;
    }
}
