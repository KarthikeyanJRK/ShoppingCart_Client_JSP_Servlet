package model;

import entities.*;
import java.util.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.WebResource;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;



public class ProductRestClient {

	private String BASE_URL = "http://localhost:8080/ShoppingCart_Server/rest/";
	private WebResource webresource;
	private Client client;
	
	public ProductRestClient() {
		this.client = Client.create(new DefaultClientConfig());
		this.webresource = this.client.resource(BASE_URL).path("product");
	}
	
	public List<ProductWS> findAll(){
		try {
			WebResource resource = this.webresource;
			GenericType<List<ProductWS>> genericType =new GenericType <List<ProductWS>>() {};
			return resource.path("findall").accept(MediaType.APPLICATION_JSON).get(genericType);
		}catch (Exception e) {
			return null;
		}
	}
	
	public ProductWS find(int id){
		try {
			WebResource resource = this.webresource;
			
			return resource.path("find/" + id).accept(MediaType.APPLICATION_JSON).get(ProductWS.class);
		}catch (Exception e) {
			return null;
		}
	}
}
