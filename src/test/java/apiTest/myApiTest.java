package apiTest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class myApiTest {
    @Test
    public void hitGet(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

    }
    @Test
    public void setHeader(){
         given().log().all()
        .header("Content-type", "application/json; charset=UTF-8")
        .when().get("https://jsonplaceholder.typicode.com/posts/1")
        .then().log().all().statusCode(200);

    }
    @Test
    public void postRequest(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
        RestAssured.given().body("id: ,\n" +
                "    title: 'foo',\n" +
                "    body: 'bar',\n" +
                "    userId: 1,")
                .post().then().log().all().assertThat().statusCode(201);

    }
    @Test
    public void putRequest(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/1";
        RestAssured.given().body("id: ,\n" +
                "    title: 'foo',\n" +
                "    body: 'bar',\n" +
                "    userId: 7,")
                .put().then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void deleteRequest(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/1";
        RestAssured.given().body("id: ,\n" +
                "    title: 'foo',\n" +
                "    body: 'bar',\n" +
                "    userId: 7,")
                .delete().then().log().all().assertThat().statusCode(200);
    }
}
