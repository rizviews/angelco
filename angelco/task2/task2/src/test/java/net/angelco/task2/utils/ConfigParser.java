package net.angelco.task2.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigParser {

    public ConfigModel parseConfig() {

        ConfigModel configModel = new ConfigModel();

        String configFile = "/config.json";

        System.out.println("resources: " + getClass().getResource(configFile).getPath());

        try {

            Gson gson = new Gson();
            configModel = gson.fromJson(new FileReader(getClass().getResource(configFile).getPath()),
                    ConfigModel.class);
            System.out.println("Password is: " + configModel.getPassword());

        } catch (Exception exception) {
            System.out.println("exception: " + exception.getMessage());
        }

        return configModel;

    }

}
