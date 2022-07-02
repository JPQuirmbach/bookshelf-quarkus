package de.quirmbach.jp.resources;

import de.quirmbach.jp.shelf.client.OpenLibraryClient;
import de.quirmbach.jp.shelf.dto.AuthorDto;
import de.quirmbach.jp.shelf.dto.BookDto;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ShelfResourceTest {

    @InjectMock
    OpenLibraryClient openLibraryClient;

    @BeforeEach
    public void setup() {
        Mockito.when(openLibraryClient.findBookByEditionKey("123"))
                .thenReturn(
                        new BookDto(
                                List.of("JP"),
                                List.of("123"),
                                List.of("321"),
                                List.of(123),
                                "Test Book",
                                "key",
                                List.of(new AuthorDto("TestAuthor"))
                        )
                );
    }

    @Test
    public void testIsbnEndpoint() {
        given()
                .when().get("/shelf/isbn/123")
                .then()
                .statusCode(200)
                .body("full_title", is("Test Book"))
                .body("key", is("key"))
                .body("authors[0].key", is("TestAuthor"));
    }

}