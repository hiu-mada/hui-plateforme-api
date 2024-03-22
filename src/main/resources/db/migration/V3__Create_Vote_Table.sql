CREATE TABLE IF NOT EXISTS vote (
                                  id SERIAL PRIMARY KEY,
                    user_id INT REFERENCES "user"(id)
);
