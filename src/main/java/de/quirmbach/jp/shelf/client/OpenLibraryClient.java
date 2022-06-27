package de.quirmbach.jp.shelf.client;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import de.quirmbach.jp.shelf.dto.BookDto;
import de.quirmbach.jp.shelf.dto.SolrDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface OpenLibraryClient {
    
    @GET
    @Path("search.json")
    SolrDto searchByTitle(@QueryParam("title") String title);

    @GET
    @Path("books/{edition}.json")
    BookDto findBookByEditionKey(String edition);
}
