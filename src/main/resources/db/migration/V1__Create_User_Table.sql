CREATE TABLE IF NOT EXISTS "user" (
                      id SERIAL PRIMARY KEY,
                      username VARCHAR(255),
                      password VARCHAR(255),
                      email VARCHAR(255),
                      created TIMESTAMP,
                      role VARCHAR(255),
                      profile_picture VARCHAR(255),
                      enabled BOOLEAN
);
