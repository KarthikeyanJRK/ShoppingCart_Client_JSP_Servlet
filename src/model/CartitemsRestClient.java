package model;

import entities.*;
import java.util.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientResponse;

import com.sun.deploy.config.DefaultConfig;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;



public class CartitemsRestClient {

	private String BASE_URL = "http://localhost:8080/ShoppingCart_Server/rest/";
	private WebResource webresource;
	private Client client;
	
	public CartitemsRestClient() {
		this.client = Client.create(new DefaultConfig());
		this.webresource = this.client.resource(BASE_URL).path("cartitems");
	}
	
	public void create(CartitemsWS cartitemsWS){
		try {
			WebResource resource = this.webresource;
			resource.type(MediaType.APPLICATION_JSON).post(cartitemsWS);
		}catch (Exception e) {
			System.out.println(e.getMessage());
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
