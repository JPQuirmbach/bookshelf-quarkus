package de.quirmbach.jp.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import de.quirmbach.jp.dto.SolrDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface OpenLibraryService {
    
    @GET
    @Path("search.json")
    SolrDto searchByTitle(@QueryParam("title") String title);

    @GET
    @Path("books/{edition}.json")
    Object findBookByEditionKey(String edition);
}
