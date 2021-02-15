package com.someth2say.reit.task;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;

@Path("/task")
public class TaskResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<List<PanacheEntityBase>> hello() {
        return Task.listAll();
    }
}