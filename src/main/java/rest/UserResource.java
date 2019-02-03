/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mappers.UserMapper;

/**
 * REST Web Service
 *
 * @author martin
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;
    private UserMapper um;
    public Gson gson;

    public UserResource() {
        this.um = new UserMapper("pu");
        this.gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
        return gson.toJson(um.getAllUsers());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("id") int id) {
        return gson.toJson(um.getUser(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String name = json.get("username").getAsString();
        String title = json.get("title").getAsString();
       return "mæalfm";
    }
}
