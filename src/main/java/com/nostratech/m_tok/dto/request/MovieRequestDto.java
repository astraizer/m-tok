package com.nostratech.m_tok.dto.request;

import com.nostratech.m_tok.validation.annotation.RatingValid;
import jakarta.validation.constraints.NotEmpty;

public class MovieRequestDto {
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Image is required")
    private String image;
    @NotEmpty(message = "Synopsis is required")
    private String synopsis;
    @RatingValid(message = "Rating wrong")
    private String rating;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getRating() {
        return rating;
    }
}
