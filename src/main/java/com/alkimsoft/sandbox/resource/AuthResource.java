package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.dao.dao.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by doğukan on 30.06.2016.
 */
@Path("auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    UserDAO userDAO;

    public AuthResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @POST
    @Path("login")
    @UnitOfWork
    public Response login(Map<String,String> userdata){
        String email=userdata.get("email");
        String password=userdata.get("password");

    }


    @POST
    @Path("logout")
    @UnitOfWork
    public Response login(Map<String,String> userdata){
        String email=userdata.get("email");
        String password=userdata.get("password");

    }



}
