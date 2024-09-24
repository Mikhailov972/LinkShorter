CREATE TABLE short_links
(
    id         BIGSERIAL PRIMARY KEY,
    long_link  TEXT NOT NULL,
    short_link TEXT NOT NULL UNIQUE
);