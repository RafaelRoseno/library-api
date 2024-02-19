CREATE TABLE IF NOT EXISTS books (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(100) NOT NULL,
    title VARCHAR(255) NOT NULL,
    publication_year INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    book_condition VARCHAR(50) NOT NULL,
    available BOOLEAN,
    user_id BIGINT,
    waitlist_id BIGINT
);