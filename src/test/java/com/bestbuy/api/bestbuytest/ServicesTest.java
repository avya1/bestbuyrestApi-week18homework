package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.model.ServicesPojo;
import com.bestbuy.api.model.StoresPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBase {


    @Test
    public void getAllProductsInfo() {

        Response response =
                given()
                        .basePath("/services")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewServices() {

        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("Electronics");

        Response response =
                given()
                        .basePath("/services")
                        .header("Content-Type", "application/json")
                        .body(servicesPojo)
                        .when()
                        .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void deleteRecord() {
        Response response =
                given()
                        .basePath("/services")
                        .pathParam("id", 2)
                        .when()
                        .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();


    }

    @Test
    public void getProductById() {

        Response response =
                given()
                        .basePath("/services")
                        .pathParam("id", 6)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void updateProduct() {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Best Buy For product");

        Response response =
                given()
                        .basePath("/services")
                        .header("Content-Type", "application/json")
                        .body(servicesPojo)
                        .when()
                        .patch("/4");
        response.then().statusCode(200);
        response.prettyPrint();


    }

}
