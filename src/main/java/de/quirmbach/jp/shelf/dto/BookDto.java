package de.quirmbach.jp.shelf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"fullTitle", "key"})
public record BookDto(
        List<String> publishers,
        @JsonProperty("isbn_10") List<String> isbn10,
        @JsonProperty("isbn_13") List<String> isbn13,
        List<Integer> covers,
        @JsonProperty("full_title") String fullTitle,
        String key,
        List<AuthorDto> authors
) {

}