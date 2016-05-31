package jaxrs;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//http://localhost:8080/add/1?x=2

@Path("add")
public class AddRest {

    @Autowired
    Adder adder;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{y}")
    public String add(@QueryParam("x") String x, @PathParam("y") String y) {
        return adder.add(x, y);
    }

}
