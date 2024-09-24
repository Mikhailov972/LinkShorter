package com.pet.shortlink.repository;

import com.pet.shortlink.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Integer> {
    Optional<LinkEntity> getByShortUrl(String shortUrl);
    Optional<LinkEntity> getByLongUrl(String longUrl);
    Optional<LinkEntity> getById(Long longUrl);

}
