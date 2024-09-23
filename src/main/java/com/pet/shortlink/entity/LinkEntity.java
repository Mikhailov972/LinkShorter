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
    @Column(name = "long_link")
    private String longUrl;
    @Column(name = "short_link")
    private String shortUrl;
}
