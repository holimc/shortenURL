package com.holimc.urlshortener.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Integer> {
    Url findByDestinationUrl(String url);
}
