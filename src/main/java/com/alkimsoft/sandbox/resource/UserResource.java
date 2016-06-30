package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.dao.dao.UserDAO;
import com.alkimsoft.sandbox.representation.entities.User;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

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

    @POST
    @Path("create")
    @UnitOfWork
    public Response create(Map<String,String> userdata)
    {
        String username = userdata.get("name");
        String surname = userdata.get("surname");
        String job = userdata.get("job");
        String email=userdata.get("email");
        String password=userdata.get("password");

         User user = new User();
        user.setName(username);
        user.setSurname(surname);
        user.setJob(job);
        user.setEmail(email);
        user.setPassword(password);
        userDAO.create(user);

        return Response.ok().entity(user).build();

    }

    @POST
    @Path("update/{oid}")
    @UnitOfWork
    public Response update(Map<String,String> userdata) {

        String oid=userdata.get("oid");

        User user1 = userDAO.findById(oid);

        if (user1 != null) {
            user1.setName(userdata.get("name"));
            user1.setSurname(userdata.get("surname"));
            user1.setJob(userdata.get("job"));

            userDAO.update(user1);

            return Response.ok().entity(user1).build();
        } else {
            return Response.serverError().entity("Kullanıcı Bulunamadı.").build();
        }
    }



    @POST
    @Path("delete/{oid}")
    @UnitOfWork
    public Response delete(Map<String,String> userdata) {
        String oid=userdata.get("oid");
        User user1 = userDAO.findById(oid);

        if (user1 != null) {
          user1.setDeletingStatus(true);
            userDAO.update(user1);

            return Response.ok().entity(user1).build();
        } else {
            return Response.serverError().entity("Kullanıcı Bulunamadı.").build();
        }
    }
//p
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
            return Response.ok().entity(userDAO.getAll()).build();
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
