package net.wallethub.tests.utils;

import com.google.gson.Gson;
import java.io.FileReader;

public class ConfigParser {

    public ConfigModel parseConfig() {

        ConfigModel configModel = new ConfigModel();

        String configFile = "/config.json";

        System.out.println("resources: " + getClass().getResource(configFile).getPath());

        try {

            Gson gson = new Gson();
            configModel = gson.fromJson(new FileReader(getClass().getResource(configFile).getPath()),
                    ConfigModel.class);

        } catch (Exception exception) {
            System.out.println("exception: " + exception.getMessage());
        }

        return configModel;

    }

}
