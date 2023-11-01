package com.scramble.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class PropertyUtils {

    static {
        loadConfigurationProperties();
    }

    private static void loadConfigurationProperties() {
        String directoryPath = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\configuration\\";
        File propertiesDirectory = new File(directoryPath);

        if (!propertiesDirectory.isDirectory()) {
            throw new IllegalStateException(directoryPath + " should be a directory");
        }

        List<File> propertyFiles = FileUtils.getFiles(propertiesDirectory);

        Properties properties = new Properties();
        InputStream input = null;
        for (File file : propertyFiles) {
            try {
                if (!file.getName().endsWith(".properties")) {
                    throw new IllegalStateException(
                            "found file in properties directory that is of not file-type *.properties: "
                                    + file.getName());
                }
                input = new FileInputStream(file.getAbsolutePath());
                System.out.println(" abs " + file.getAbsolutePath());
                properties.load(input);
            } catch (IOException e) {
                throw new IllegalStateException("could not load property file: " + file.getName());
            }
        }
        Set<Object> setProperties = new HashSet<>(System.getProperties().keySet());
        for (String name : properties.stringPropertyNames()) {
            if (setProperties.contains(name)) {
                throw new IllegalStateException(String.format("error when attempting to set the following property:"
                                + "\n\t%1$s:%2$s\nthe following property already found:\n\t%1$s:%3$s\nplease take care to remove duplicate properties",
                        name, properties.getProperty(name), System.getProperty(name)));
            }
            setProperties.add(name);
            System.setProperty(name, properties.getProperty(name));
        }
    }

    public static String getProperty(String propertyName, String defaultValue) {
        String value = getProperty(propertyName);
        if (value == null) {
            System.out.println("returning default value [" + defaultValue + "] for system property: " + propertyName);
            return defaultValue;
        }
        return value;
    }

    public static synchronized String getProperty(String propertyName) {
        String property = System.getProperty(propertyName);
        if (property == null) {
            System.out.println("did not find the requested system property: " + propertyName);
        }
        return property;
    }
}