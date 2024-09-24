CREATE TABLE short_links
(
    id         BIGSERIAL PRIMARY KEY,
    long_link  TEXT NOT NULL,
    short_link TEXT NOT NULL UNIQUE
);

-- Не добавил комментарии к таблице и полям =(