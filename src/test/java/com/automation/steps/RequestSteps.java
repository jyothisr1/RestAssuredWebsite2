package com.automation.steps;

import com.automation.pojo.CreateResourcePojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header type {string} to {string}")
    public void set_header_type_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @When("user perform post call")
    public void user_perform_post_call() {
        RestAssuredUtils.post();
    }

    @Then("verify user status is {int}")
    public void verify_user_status_is(int statusCode) {
        Assert.assertEquals(statusCode,RestAssuredUtils.statusCode());
    }

    @And("set request body from the file {string}")
    public void setRequestBodyFromTheFile(String fileName) throws JsonProcessingException {
        String jsonFolderPath= ConfigReader.getConfig("json.folder.path");
        String jsonBody=RestAssuredUtils.getData(jsonFolderPath+fileName);
        ObjectMapper om=new ObjectMapper();
        CreateResourcePojo createResourcePojo =om.readValue(jsonBody, CreateResourcePojo.class);
        RestAssuredUtils.setBodyUsingPojo(createResourcePojo);
    }

    @And("verify id is not empty")
    public void verifyIdIsNotEmpty() {

    }
}
