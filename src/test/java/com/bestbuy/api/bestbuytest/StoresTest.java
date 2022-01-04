package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.model.ProductPojo;
import com.bestbuy.api.model.StoresPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;



public class StoresTest extends TestBase {


    @Test
    public void getAllProductsInfo() {

        Response response =
                given()
                        .basePath("/stores")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewStore(){

    StoresPojo storesPojo= new StoresPojo();
    storesPojo.setName("Decorama");
    storesPojo.setType("Dollar Savings");
    storesPojo.setAddress("12341 Semley Road");
    storesPojo.setAddress2("");
    storesPojo.setCity("Pune");
    storesPojo.setState("DB");
    storesPojo.setZip("23871");
    storesPojo.setLat(45.087f);
    storesPojo.setLng(23.123f);
    storesPojo.setHours("string");

    Response response =
            given()
                    .basePath("/stores")
                    .header("Content-Type", "application/json")
                    .body(storesPojo)
                    .when()
                    .post();
    response.then().statusCode(201);
    response.prettyPrint();

    }

    @Test
    public void deleteRecord() {
        Response response =
                given()
                        .basePath("/stores")
                        .pathParam("id", 8)
                        .when()
                        .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();


    }

    @Test
    public void getProductById() {

        Response response =
                given()
                        .basePath("/stores")
                        .pathParam("id",4)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void updateProduct(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Android Hub");
        storesPojo.setCity("");
        storesPojo.setState("MN");

        Response response =
                given()
                        .basePath("/stores")

                        .header("Content-Type","application/json")
                        .body(storesPojo)
                        .when()
                        .patch("/4");
        response.then().statusCode(200);
        response.prettyPrint();



    }


}
