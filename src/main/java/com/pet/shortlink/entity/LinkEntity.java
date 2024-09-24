package com.pet.shortlink.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "short_links")
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // Почему бы не назвать long_url?
    @Column(name = "long_link")
    private String longUrl;
    // Почему бы не назвать short_url?
    @Column(name = "short_link")
    private String shortUrl;
}
