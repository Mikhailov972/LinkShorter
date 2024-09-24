package com.pet.shortlink.controller;

import com.pet.shortlink.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinkController {
    private final LinkService linkService;

    // Я бы подключил Lombok, чтобы не писать конструкторы, но тут как хочешь
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> createShortLink(@RequestBody String longUrl) {
        String shortUrl = linkService.createShortUrl(longUrl);
        // links Лишнее. У нас же цель сделать ссылку как можно короче
        return ResponseEntity.ok("http://localhost:8080/links/" + shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectToLongUrl(@PathVariable String shortUrl) {
        return linkService.getByShortUrl(shortUrl)
                .map(link -> new RedirectView(link.getLongUrl()))
                // Ну не ERROR, а просто сайт не нашли, но это так... Придирки, обычно бизнес скажет как обработать такую штуку
                .orElseGet(() -> new RedirectView("/error"));
    }
}
