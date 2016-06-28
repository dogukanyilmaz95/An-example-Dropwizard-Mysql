package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.dao.dao.UserDAO;
import com.alkimsoft.sandbox.representation.entities.User;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

        User user2 = new User();
        user2.setName("Ahmet");
        user2.setSurname("Taşçı");
        user2.setJob("Pazarcı");

        userDAO.create(user2);

        User user3 = new User();
        user3.setName("Mehmet");
        user3.setSurname("Bal");
        user3.setJob("mimar");

        userDAO.create(user3);

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



    @GET
    @Path("delete/{oid}")
    @UnitOfWork
    public Response delete(@PathParam("oid") String oid) {
        User user1 = userDAO.findById(oid);

        if (user1 != null) {
          user1.setDeletingStatus(true);

            userDAO.update(user1);

            return Response.ok().entity(user1).build();
        } else {
            return Response.serverError().entity("Kullanıcı Bulunamadı.").build();
        }
    }

    @GET
    @Path("read/{oid}")
    @UnitOfWork
    public Response readByOid(@PathParam("oid") String oid) {

        User user = userDAO.findById(oid);
        if (user != null) {
            return Response.ok().entity(user).build();
        } else {
            return Response.serverError().entity("Kullanıcı Bulunamadı.").build();
        }
    }

    @GET
    @Path("read")
    @UnitOfWork
    public Response read() {
            return Response.ok().entity(userDAO.findAll(User.class)).build();
    }


    @GET
    @Path("deleteAll")
    @UnitOfWork
    public Response deleteAll() {

        List<User> userList = userDAO.findAll(User.class);

        for ( int i=0;i<userList.size();i++){

            User user1 = userList.get(i);
            user1.setDeletingStatus(true);
        }
        return Response.ok().entity(userList).build();
    }
}
