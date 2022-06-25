package de.quirmbach.jp.shelf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"start", "numFound", "docs"})
public record SolrDto(
        String start,
        @JsonProperty("num_found") int numFound,
        List<SolrDocDto> docs
) {

}
