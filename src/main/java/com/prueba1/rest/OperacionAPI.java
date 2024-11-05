package com.prueba1.rest;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.prueba1.controls.dao.services.OperacionServices;

@Path("expresiones")
public class OperacionAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveInAPI() throws Exception{
        HashMap map = new HashMap<>();
        OperacionServices os = new OperacionServices();

        os.getOperacion().setExpresion1("41414+3");
        os.getOperacion().setExpresion2("4+3");
        os.save();

        map.put("msg", "OK");
        map.put("data", os.listAll().toArray());

        if (os.listAll().isEmpty()) {
            map.put("data", new Object[]{});
        }

        return Response.ok(map).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOperations() throws Exception {
        HashMap map = new HashMap<>();
        OperacionServices os = new OperacionServices();

        map.put("msg", "OK");
        map.put("data", os.listAll().toArray());

        if (os.listAll().isEmpty()) {
            map.put("data", new Object[]{});
        }

        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveOperations(HashMap map) {
        HashMap res = new HashMap<>();
        

        try {
            OperacionServices os = new OperacionServices();

            os.getOperacion().setExpresion1(map.get("expresion1").toString());
            os.getOperacion().setExpresion2(map.get("expresion2").toString());
            os.save();

            res.put("msg", "OK");
            res.put("data", "operacion registrada correctamente");

            return Response.ok(res).build();
        } catch (Exception e) {
            res.put("msg", "Error");
            res.put("data", e.toString());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }


}
