package de.quirmbach.jp.shelf.resources;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import de.quirmbach.jp.shelf.dto.BookDto;
import de.quirmbach.jp.shelf.service.OpenLibraryService;
import de.quirmbach.jp.shelf.dto.SolrDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.Blocking;

@Path("/shelf")
public class ShelfResource {

    @Inject
    @RestClient
    OpenLibraryService openlibraryService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/search")
    @Blocking
    @Produces(MediaType.APPLICATION_JSON)
    public SolrDto findByQuery(@QueryParam("q") String q) {
        return openlibraryService.searchByTitle(q);
    }

    @GET
    @Path("/isbn/{isbn}")
    @Blocking
    @Produces(MediaType.APPLICATION_JSON)
    public BookDto getByIsbn(String isbn) {
        return openlibraryService.findBookByEditionKey(isbn);
    }
}