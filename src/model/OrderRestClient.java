package model;

import entities.*;
import java.util.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientResponse;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;



public class OrderRestClient {

	private String BASE_URL = "http://localhost:8080/ShoppingCart_Server/rest/";
	private WebResource webresource;
	private Client client;
	
	public OrderRestClient() {
		this.client = Client.create(new DefaultClientConfig());
		this.webresource = this.client.resource(BASE_URL).path("cusorder");
	}
	
	public String create(CusorderWS cusorderWS){
		try {
			WebResource resource = this.webresource;
			ClientResponse clientResponse = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, cusorderWS);
			return clientResponse.getEntity(String.class);
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
