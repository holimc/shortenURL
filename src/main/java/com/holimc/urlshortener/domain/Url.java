package com.holimc.urlshortener.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Entity
@Table(name="url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @NotNull
    private String destinationUrl;

    @Lob
    @NotNull
    private String shortUrl;

    private long totalClicks;

    @Builder
    public Url(int id, String destinationUrl, String shortUrl){
        this.id = id;
        this.destinationUrl = destinationUrl;
        this.shortUrl = shortUrl;
    }

}
