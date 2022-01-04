package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.model.CategoriesPojo;
import com.bestbuy.api.model.ProductPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesTest extends TestBase {

    @Test
    public void getAllProductsInfo() {


        Response response =
                given()
                        .basePath("/categories")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewCategories() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Birthday Gift Ideas");
        categoriesPojo.setId("abc1234");

        Response response =
                given()
                        .basePath("/categories")
                        .header("Content-Type", "application/json")
                        .body(categoriesPojo)
                        .when()
                        .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void deleteCategoryFromListwithId() {

        Response response =
                given()
                        .basePath("/categories")
                        .pathParam("id", "abcat0102005")
                        .when()
                        .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getProductById() {

        Response response =
                given()
                        .basePath("/categories")
                        .pathParam("id","abcat0020002")
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void updateProduct() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Computers");

        Response response =
                given()
                        .basePath("/categories")
                        .header("Content-Type", "application/json")
                        .body(categoriesPojo)
                        .when()
                        .patch("/abcat0020002");
        response.then().statusCode(200);
        response.prettyPrint();

    }


}
