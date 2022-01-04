package com.bestbuy.api.extraction;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtraction {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                //  .then().log().all(); //to see result in console
                .then().statusCode(200);
    }
    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store limit : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store total: " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("name of 5th store is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> name = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of stores name are : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of stores Id are : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> dataSize = response.extract().path("data");
        int size = dataSize.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of Data is : " + size);
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> storeData = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store Data is : " + storeData);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester

    @Test
    public void test008() {
        List<HashMap<String, ?>> storeAdd = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        int count = storeAdd.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store address is : " + storeAdd);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get store services of the store where service name = Windows Store
    @Test
    public void test010() {
        List<?> services =response.extract().path("data.findAll{it.services.name=='Windows Store'}.storeservices");
        System.out.println("Services stores are : "+services);
    }

    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("---------------------StartingTest-----------------------------");
        System.out.println("Store Id's are: " + storeId);
        System.out.println("---------------------End of Test---------------------------");
    }

    // 12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> id = response.extract().path("data.id");
        int count = id.size();
        System.out.println("---------------------StartingTest-----------------------------");
        System.out.println("Store Id's are: " + count);
        System.out.println("---------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        List<String> storeNames = response.extract().path("data.findAll{it.state =='ND'}.name");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Store Id's are: " + storeNames);
        System.out.println("------------------------End of Test-----------------------------");
    }

    // 14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {

        List<HashMap<String,Object>> services =response.extract().path("data.findAll{it.name=='Rochester'}.services");
        int size=services.size();
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + size);
        System.out.println("------------------------End of Test-----------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<String> createdAt =response.extract().path("data.findAll{it.services.name=='Windows Store'}.services.created");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + createdAt);
        System.out.println("------------------------End of Test-----------------------------");
    }

    //16.Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + services);
        System.out.println("------------------------End of Test-----------------------------");
    }


    //17. Find the zip of all the store
    @Test
    public void test017() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + zip);
        System.out.println("------------------------End of Test-----------------------------");
    }


    //18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        List<Integer> zip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + zip);
        System.out.println("------------------------End of Test-----------------------------");
    }

    //19. Find the store services details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List<HashMap<String, ?>> storeServices = response.extract().path("data.findAll{it.services.name=='Magnolia Home Theater'}.id");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + storeServices);
        System.out.println("------------------------End of Test-----------------------------");
    }

    //20. Find the lat of all the store
    @Test
    public void test020() {
        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + lat);
        System.out.println("------------------------End of Test-----------------------------");
    }
}
