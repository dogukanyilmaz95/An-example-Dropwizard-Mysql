package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.auth.TokenGenaretor;
import com.alkimsoft.sandbox.dao.dao.UserDAO;
import com.alkimsoft.sandbox.representation.entities.UserToken;
import com.alkimsoft.sandbox.representation.entities.User;
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
    TokenGenaretor tokenGenaretor;
    UserToken userToken;

    public AuthResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @POST
    @Path("login")
    @UnitOfWork
    public Response login(Map<String,String> userdata){
        String email=userdata.get("email");
        String password=userdata.get("password");

        User user = userDAO.loginControl(password,email);

        if(user != null) {
            String tokenA =tokenGenaretor.generate().toString();
            userToken.setToken(tokenA);
            userToken.setUser(user);
            return Response.ok(tokenA).build();
        } else {
            return Response.ok("kullanıcı bulunamadı").build();
        }
    }



/*
    @POST
    @Path("logout")
    @UnitOfWork
    public Response logout(Map<String,String> userdata){
        String password=userdata.get("usertoken");

    }
*/


}
