package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseComponent3;
import utils.DataBuilder;

public class Base3Example extends BaseComponent3{
	
	String id;
	
	@Test
	public void createTodo() {
		
		
		Response resp = doRequest("POST", "", DataBuilder.buildTodo().toJSONString());
		id = resp.jsonPath().getString("id");	
		System.out.println(resp.asPrettyString());		
	}
	@Test(priority = 1)
	public void getTodo() {
		
		System.out.println("--------------GET-----------------");
		Response resp = doRequest("GET", id, "");
		System.out.println(resp.asPrettyString());		
	
	}
	
	@Test(priority = 2)
	public void updateTodo() {
		
		System.out.println("--------------PUT-----------------");
		Response resp = doRequest("PUT", id, DataBuilder.buildTodo().toJSONString());
		System.out.println(resp.asPrettyString());		
	
	}
	
	@Test(priority = 3)
	public void deleteTodo() {
		
		System.out.println("--------------DELETE-----------------");
		Response resp = doRequest("delete", id, DataBuilder.buildTodo().toJSONString());
		System.out.println(resp.asPrettyString());	
	}
	
}
