package com.alkimsoft.sandbox.resource;

import com.alkimsoft.sandbox.representation.entities.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        User user = new User();
        user.setName("Ali");
        user.setSurname("Demir");
        user.setJob("Muhasebeci");

        return Response.ok().entity(user).build();
    }
}
