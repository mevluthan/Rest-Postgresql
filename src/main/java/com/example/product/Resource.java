package com.example.product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Path("/kullanici")
public class Resource {
    private KullaniciCRUD dao = KullaniciCRUD.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kullanici> list() {
        return dao.listAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Kullanici product = dao.get(id);
        if (product != null) {
            return Response.ok(product, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }




    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Kullanici product) throws URISyntaxException {
        int newProductId = dao.add(product);
        URI uri = new URI("/kullanici/" + newProductId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Kullanici product) {
        product.setId(id);
        if (dao.update(product)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (dao.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}