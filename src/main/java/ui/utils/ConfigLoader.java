package ui.utils;

import java.io.IOException;

public class ConfigLoader {
    public static void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));

    }
}
