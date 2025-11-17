package br.com.fiap.resource;

import br.com.fiap.bo.RespostaUsuarioBO;
import br.com.fiap.to.RespostaUsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/resposta_usuario")
public class RespostaUsuarioResource {
    private RespostaUsuarioBO respostaUsuarioBO = new RespostaUsuarioBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<RespostaUsuarioTO> resultado = respostaUsuarioBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - OK
        }
        else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        RespostaUsuarioTO resultado = respostaUsuarioBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();  // 200 (OK)
        } else {
            response = Response.status(404);  // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid RespostaUsuarioTO respostaUsuario) {
        RespostaUsuarioTO resultado = respostaUsuarioBO.save(respostaUsuario);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 401 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (respostaUsuarioBO.delete(id)){
            response = Response.status(204);  // 204 - NO CONTENT
        } else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid RespostaUsuarioTO respostaUsuario, @PathParam("id") Long id) {
        respostaUsuario.setIdResposta(id);
        RespostaUsuarioTO resultado = respostaUsuarioBO.update(respostaUsuario);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}
