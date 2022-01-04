package com.bestbuy.api.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class AssertionHomework {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI= "http://localhost";
        RestAssured.port = 3030;
        response =  given()
                .when()
                .get("/stores")
                .then();


    }


  @Test
           // 1. Verify the if the total is equal to 1562
    public void test001() {

      response.body("total", Matchers.equalTo(1562));
  }
  @Test
          public void test002(){

        //  2. Verify the if the stores of limit is equal to 10

        response.body("limit", Matchers.equalTo(10));

    }
    @Test
    public void test003(){
        //3. Check the single ‘Name’ in the arrayList Mapelwood

        response.body("data.name",hasItem("Rochester"));

    }

//4. Check the multiple ‘Names’ in the ArrayList (Square83215, Southridge, Green Bay)

    @Test
    public void test004(){
        response.body("data.name", IsCollectionContaining.hasItems("Northtown", "Fargo", "Rochester"));

    }
// 5. Verify the storied inside storeservices of the third store of second services

    @Test
    public void test005(){
       response.body("data[2].services[1].storeservices",hasKey("storeId"));

    }
// 6. Check hash map values ‘createdAt’ inside storeservices map where store name = Southridge
@Test
    public void test006(){
       // response.body("data.findAll{it.name=='GeekSquad Services'}",hasItems(hasEntry("createdAt","2016-11-17T17:56:35.881Z")));

       response.body("data[2].services[1]",hasKey("createdAt"));


    }
// 7. Verify the state = MN of third store

    @Test
    public void test007(){

        response.body("data[2].state",Matchers.equalTo("MN"));
    }
//8. Verify the name = West Des Moines of 9th store

    @Test
    public void test008(){

        response.body("data[8].name",Matchers.equalTo("West Des Moines"));
    }
//9. Verify the storeId = 13 for the 6th store

    @Test
    public void test009(){
        response.body("data[5].services[0].storeservices",Matchers.hasEntry("storeId",13));

    }
//10. Verify the serviceId = 14 for the 7th store
@Test
    public void test010(){
        response.body("data[6].services[7].storeservices",Matchers.hasEntry("serviceId",14));


    }
















}
