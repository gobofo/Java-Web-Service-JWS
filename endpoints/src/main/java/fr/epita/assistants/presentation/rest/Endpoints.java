package fr.epita.assistants.presentation.rest;

import fr.epita.assistants.presentation.rest.request.ReverseRequest;
import fr.epita.assistants.presentation.rest.response.HelloResponse;
import fr.epita.assistants.presentation.rest.response.ReverseResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Endpoints {
    @Path("/hello/{name}")
    @GET
    public Response helloWorld(@PathParam("name") String name) {
        if(name == null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        HelloResponse content = new HelloResponse("hello "+name);
        return Response.ok(content).build();
    }

    @Path("/reverse")
    @POST
    public Response reverse(ReverseRequest request)
    {
        if(request == null || request.getContent() == null || request.getContent().isEmpty())
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        StringBuilder SB = new StringBuilder();
        SB.append(request.getContent());
        SB.reverse();

        ReverseResponse rep = new ReverseResponse(request.getContent(), SB.toString());

        return Response.ok(rep).build();
    }

}
