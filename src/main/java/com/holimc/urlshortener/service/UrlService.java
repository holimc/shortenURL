package com.holimc.urlshortener.service;

import com.holimc.urlshortener.domain.Url;
import com.holimc.urlshortener.domain.UrlRepository;
import com.holimc.urlshortener.dto.UrlRequest;
import com.holimc.urlshortener.util.Base62;
import com.holimc.urlshortener.util.UrlFormatter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UrlService{


    private final UrlRepository urlRepository;
    private final Base62 base62;
    private final UrlFormatter urlFormatter;

    public String shortenUrl(UrlRequest urlRequest) {
        int id = Optional.ofNullable(urlRepository.findByDestinationUrl(urlRequest.getDestinationUrl()))
                .map(Url::getId)
                .orElseGet(() -> save(urlRequest));

        return urlFormatter.format(base62.encode(id));
    }

    public String restoreUrl(String shorten) {
        int id = base62.decode(shorten);

        return findById(id);
        //error
    }

    public String findById(int id) {
        Url url = urlRepository.findById(id)
                // error
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 url 입니다."));

        return url.getDestinationUrl();
    }

    public int save(UrlRequest urlRequest) {
        Url url = urlRequest.toUrl();
        urlRepository.save(url);

        return url.getId();
    }


}
