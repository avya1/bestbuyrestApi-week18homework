package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.model.ProductPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

public class ProductsTest extends TestBase {



    @Test
    public void getAllProductsInfo() {


        Response response =
                given()
                        .when()
                        .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewProduct() {

        ProductPojo productPojo = new ProductPojo();

        productPojo.setName("Apple Tab");
        productPojo.setType("Electronics");
        productPojo.setPrice(15.91);
        productPojo.setUpc("45349585950");
        productPojo.setShipping(12.11);
        productPojo.setDescription("Compitable");
        productPojo.setManufacturer("Ukpower Limited");
        productPojo.setModel("String");
        productPojo.setUrl("String");
        productPojo.setImage("String");
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(productPojo)
                        .when()
                        .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void deleteRecord() {
        Response response =
                given()
                        .basePath("/products")
                .pathParam("id", 333179)
                .when()
                        .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();
    }

    @Test
    public void getProductById() {

        Response response =
                given()
                        .basePath("/products")
                        .pathParam("id",43900)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void updateProduct(){
        ProductPojo productPojo= new ProductPojo();
        productPojo.setName("Samsung");
        productPojo.setPrice(11.12);

        Response response =
                given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .patch("/43900");
        response.then().statusCode(200);
        response.prettyPrint();



    }

}



