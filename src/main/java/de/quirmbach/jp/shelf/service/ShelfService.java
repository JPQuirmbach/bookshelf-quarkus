package de.quirmbach.jp.shelf.service;

import de.quirmbach.jp.shelf.client.OpenLibraryClient;
import de.quirmbach.jp.shelf.client.OpenLibraryCoverClient;
import de.quirmbach.jp.shelf.dto.BookDto;
import de.quirmbach.jp.shelf.dto.Size;
import de.quirmbach.jp.shelf.dto.SolrDto;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ShelfService {

    @Inject
    @RestClient
    OpenLibraryClient openlibraryClient;

    @Inject
    @RestClient
    OpenLibraryCoverClient openLibraryCoverClient;

    public SolrDto searchByTitle(String q) {
        return openlibraryClient.searchByTitle(q);
    }

    public BookDto findBookByEditionKey(String isbn) {
        return openlibraryClient.findBookByEditionKey(isbn);
    }

    public byte[] getCover(String id) {
        return openLibraryCoverClient.getCover(id, Size.L, false);
    }
}
