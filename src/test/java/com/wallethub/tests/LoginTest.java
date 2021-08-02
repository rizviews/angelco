package com.wallethub.tests;

import java.io.InputStream;
import java.util.Properties;

import com.wallethub.pages.BasePage;
import com.wallethub.pages.facebook.FacebookLoginPage;

public class LoginTest {

    public void Login(String propFileName, String testIdentifier) {
        BasePage basePage = new BasePage();
        try (InputStream input = LoginTest.class.getClassLoader().getResourceAsStream(propFileName)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            if(testIdentifier.equals("task1")){

                basePage.LoginToFacebook(prop.getProperty("username"),prop.getProperty("password"));
            }
            else if(testIdentifier.equals("task2")){

                basePage.LoginToWalletHub(prop.getProperty("username"),prop.getProperty("password"));
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
