package de.quirmbach.jp.shelf.resources;

import de.quirmbach.jp.shelf.dto.BookDto;
import de.quirmbach.jp.shelf.dto.SolrDto;
import de.quirmbach.jp.shelf.service.ShelfService;
import io.quarkus.cache.CacheResult;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/shelf")
public class ShelfResource {

    @Inject
    ShelfService shelfService;

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "search-cache")
    public SolrDto findByQuery(@QueryParam("q") String q) {
        return shelfService.searchByTitle(q);
    }

    @GET
    @Path("/isbn/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "isbn-cache")
    public BookDto getByIsbn(String isbn) {
        return shelfService.findBookByEditionKey(isbn);
    }

    @GET
    @Path("/cover/{id}")
    @Produces("image/jpeg")
    @CacheResult(cacheName = "cover-cache")
    public byte[] getCover(String id) {
        return shelfService.getCover(id);
    }
}