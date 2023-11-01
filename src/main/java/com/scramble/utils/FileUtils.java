package com.scramble.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static List<File> getFiles(File dir) {
        List<File> propertyFiles = new ArrayList<File>();
        File[] fileList = dir.listFiles();
        logger.info("list files " + fileList.length);
        for (File file : fileList) {
            if (!file.isDirectory())
                propertyFiles.add(file);
            else
                logger.debug(String.format(
                        "found directory [%s] inside properties of properties directory. if desirable, implement new method to load recursively",
                        file.getName()));
        }
        return propertyFiles;
    }

    public static String getFileContent(InputStream inputStream) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileContent(String fileName) {
        logger.info("Getting file content of: " + fileName);
        File file = new File(
                System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\" + fileName);
        logger.info(String.valueOf(file));
        try (InputStream inputStream = new FileInputStream(file)) {
            return getFileContent(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}