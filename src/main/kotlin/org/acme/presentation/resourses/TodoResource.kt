package org.acme.presentation.resourses

import jakarta.ws.rs.*

import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.acme.application.services.TodoService
import org.acme.domain.models.Todo

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TodoResource(private val todoService: TodoService) {
    @GET
    fun getAll(): List<Todo> = todoService.findAll()

    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: Long): Response {
        val todo = todoService.findById(id) ?: return Response.status(Response.Status.NOT_FOUND).build()
        return Response.ok(todo).build()
    }

    @POST
    fun create(todo: Todo): Response {
        val createdTodo = todoService.create(todo)
        return Response.status(Response.Status.CREATED).entity(createdTodo).build()
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: Long, todo: Todo): Response {
        val updatedTodo = todoService.update(id, todo) ?: return Response.status(Response.Status.NOT_FOUND).build()
        return Response.ok(updatedTodo).build()
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long): Response {
        return if (todoService.delete(id)) {
            Response.noContent().build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }
}