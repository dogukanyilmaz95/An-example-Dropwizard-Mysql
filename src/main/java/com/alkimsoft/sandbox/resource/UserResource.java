package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.representation.entities.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @GET
    @Path("read")
    public Response read() {
        List<User> userList = new LinkedList<>();

        User user1 = new User();
        user1.setName("Ali");
        user1.setSurname("Demir");
        user1.setJob("Muhasebeci");

        User user2 = new User();
        user2.setName("İsmet");
        user2.setSurname("Özel");
        user2.setJob("Şair");

        userList.add(user1);
        userList.add(user2);

        return Response.ok().entity(userList).build();
    }
}
