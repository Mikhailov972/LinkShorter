package com.pet.shortlink.service;

import com.pet.shortlink.entity.LinkEntity;
import com.pet.shortlink.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {

    private final LinkRepository linkRepository;
    private final HashService hashService;

    public LinkService(LinkRepository linkRepository, HashService hashService) {
        this.linkRepository = linkRepository;
        this.hashService = hashService;
    }

    public String createShortUrl(String longUrl) {
        String shortUrl = hashService.hashUrl(longUrl);
        Optional<LinkEntity> existingLink = linkRepository.getByShortUrl(shortUrl);
        if (existingLink.isPresent()) {
            return existingLink.get().getShortUrl();
        }
        // сеттеры не очень( Лучше сразу инициализировать готовый объект, то есть поля прокидывать в конструктор
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setLongUrl(longUrl);
        linkEntity.setShortUrl(shortUrl);
        linkRepository.save(linkEntity);
        return linkEntity.getShortUrl();
    }

    public Optional<LinkEntity> getByShortUrl(String shortUrl) {
        return linkRepository.getByShortUrl(shortUrl);
    }

}
