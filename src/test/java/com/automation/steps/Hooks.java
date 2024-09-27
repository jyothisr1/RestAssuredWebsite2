package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void setUp(){
        ConfigReader.initConfig();
        if(ConfigReader.getConfig("").equals("restful-api")){

        }
        RestAssured.baseURI=ConfigReader.getConfig("base.url");
    }
}
