package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.dao.dao.UserDAO;
import com.alkimsoft.sandbox.representation.entities.User;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arici on 28.06.2016.
 */
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @Path("create")
    @UnitOfWork
    public Response create() {
        User user1 = new User();
        user1.setName("Ali");
        user1.setSurname("Demir");
        user1.setJob("Muhasebeci");

        userDAO.create(user1);

        return Response.ok().entity(user1).build();
    }

    @GET
    @Path("update/{oid}")
    @UnitOfWork
    public Response update(@PathParam("oid") String oid) {
        User user1 = userDAO.findById(oid);

        if (user1 != null) {
            user1.setName("Veli");
            user1.setSurname("Çelik");
            user1.setJob("Ön Muhasebeci");

            userDAO.update(user1);

            return Response.ok().entity(user1).build();
        } else {
            return Response.serverError().entity("Kullanıcı Bulunamadı.").build();
        }
    }
}
