ALTER TABLE books ADD FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE books ADD FOREIGN KEY (waitlist_id) REFERENCES waitlist(id);

ALTER TABLE waitlist ADD FOREIGN KEY (book_id) REFERENCES books(id);
ALTER TABLE waitlist ADD FOREIGN KEY (user_id) REFERENCES users(id);