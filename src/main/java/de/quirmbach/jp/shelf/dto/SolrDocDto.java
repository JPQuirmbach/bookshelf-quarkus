package de.quirmbach.jp.shelf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"title", "authorName", "editionKey", "isbn"})
public record SolrDocDto(
        String title,
        @JsonProperty("author_name") List<String> authorName,
        List<String> isbn,
        @JsonProperty("edition_key") List<String> editionKey
) {

}
