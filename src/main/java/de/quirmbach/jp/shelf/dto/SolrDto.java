package de.quirmbach.jp.shelf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SolrDto {
    private String start;
    @JsonProperty("num_found")
    private int numFound;
    private List<SolrDocDto> docs;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class SolrDocDto {
        private String title;
        @JsonProperty("author_name")
        private List<String> authorName;
        private List<String> isbn;
        @JsonProperty("edition_key")
        private List<String> editionKey;

    }
}
