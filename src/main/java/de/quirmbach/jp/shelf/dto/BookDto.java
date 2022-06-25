package de.quirmbach.jp.shelf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    private List<String> publishers;
    @JsonProperty("isbn_10")
    private List<String> isbn10;
    @JsonProperty("isbn_13")
    private List<String> isbn13;
    private List<Integer> covers;
    @JsonProperty("full_title")
    private String fullTitle;
    private String key;
    private List<AuthorDto> authors;


    @NoArgsConstructor
    @Getter
    @Setter
    public static class AuthorDto {
        private String key;
    }

}
