package com.holimc.urlshortener.dto;

import com.holimc.urlshortener.domain.Url;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Getter
public class UrlRequest {
    @URL
    @NotBlank
    private String destinationUrl;

    @URL
    @NotBlank
    private String shortUrl;

    public Url toUrl(){
        return Url.builder()
                .destinationUrl(destinationUrl)
                .shortUrl(shortUrl)
                .build();
    }
}
