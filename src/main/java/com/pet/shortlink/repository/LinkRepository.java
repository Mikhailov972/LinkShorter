package com.pet.shortlink.repository;

import com.pet.shortlink.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
// Максимальное значение Integer около 2 млрд. А мы рассчитали, что можем хранить 6 млрд. ссылок. Нужен Long
// Всегда используй Long
public interface LinkRepository extends JpaRepository<LinkEntity, Integer> {
    Optional<LinkEntity> getByShortUrl(String shortUrl);
    Optional<LinkEntity> getByLongUrl(String longUrl);
    Optional<LinkEntity> getById(Long longUrl);

}
