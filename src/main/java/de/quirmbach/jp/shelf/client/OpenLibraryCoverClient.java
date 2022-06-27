package de.quirmbach.jp.shelf.client;


import de.quirmbach.jp.shelf.dto.Size;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RegisterRestClient
public interface OpenLibraryCoverClient {

    @GET
    @Path("b/id/{value}-{size}.jpg")
    byte[] getCover(String value, Size size, @QueryParam("default") boolean emptyResponseOnError);
}
