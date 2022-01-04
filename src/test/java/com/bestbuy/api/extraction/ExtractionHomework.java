package com.bestbuy.api.extraction;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionHomework {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();
    }

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is: " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The search query is: " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.printf("The 5th sore name is: %s%n", name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {

        List<String> names = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the all stores are:: " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {

        List<String> storeid = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of the all stores are:: " + storeid);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {

        int size = response.extract().path("data.size");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the items is: " + size);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = Fargo
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='Fargo'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for store name is Fargo:" + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Maplewood
    @Test
    public void test008() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Maplewood'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address for store name is Maplewood:" + address);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {

        List<String> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the all stores are:: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Sony Experience
    @Test
    public void test010() {
        List<String> storeServices = response.extract().path("data.services[9].storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("get storeservices of the store where service name = Sony Experience:" + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    // 11. Get all the storeId of all the store
// Extract the storeId of all the store
    @Test
    public void test011() {

        List<Integer> storeid = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of the all stores are:: " + storeid);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> id = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of the all stores are:: " + id);
        System.out.println("------------------End of Test---------------------------");
    }

//13. Find the store names Where state = WI

    @Test
    public void test13() {
        List<String> name = response.extract().path("data.findAll{it.state=='MN'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names where state is MN are :: " + name);
        System.out.println("------------------End of Test---------------------------");
    }


    //14. Find the Total number of services for the store where store name = Inver Grove Heights
    @Test
    public void test14() {
        int servicesNumbers = response.extract().path("data[1].services.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of the all stores are:: " + servicesNumbers);
        System.out.println("------------------End of Test---------------------------");
    }

/// 15. Find the createdAt for all services whose name = “Windows Store”

    @Test
    public void test15() {
        List<String> storeServices = response.extract().path("data.services[9].storeservices");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names where state is MN are :: " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }


    //            16. Find the name of all services Where store name = “Oakdale”
    @Test
    public void test16() {
        List<String> services = response.extract().path("data.findAll{it.name=='Oakdale'}.services.name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services:" + services);
        System.out.println("------------------End of Test---------------------------");
    }
    //            17. Find the zip of all the store
    @Test
    public void test17() {
        List<String> list = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of the all stores are:: " + list);
        System.out.println("------------------End of Test---------------------------");
    }


    //18. Find the zip of store name = Fargo
    @Test
        public void test18() {

        List<Integer> services = response.extract().path("data.findAll{it.name=='Fargo'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services:" + services);
        System.out.println("------------------End of Test---------------------------");
    }

//19. Find the storeservices details of the service name = Samsung Experience

    @Test
    public void test19(){
       // List<Integer> services = response.extract().path("data.findAll{it.services=='Samsung Experience'}.storeservices");
        //List<HashMap<String, ?>> address  = response.extract().path("data.findAll{it.service=='Samsung Experience'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all services:" );
        System.out.println("------------------End of Test---------------------------");
    }




//20. Find the lat of all the stores
@Test
public void test20() {
    List<String> list = response.extract().path("data.lat");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("the lat of the all stores are:: " + list);
    System.out.println("------------------End of Test---------------------------");
}


}