package com.pet.shortlink.controller;

import com.pet.shortlink.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> createShortLink(@RequestBody String longUrl) {
        String shortUrl = linkService.createShortUrl(longUrl);
        return ResponseEntity.ok("http://localhost:8080/links/" + shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirectToLongUrl(@PathVariable String shortUrl) {
        return linkService.getByShortUrl(shortUrl)
                .map(link -> new RedirectView(link.getLongUrl()))
                .orElseGet(() -> new RedirectView("/error"));
    }
}
