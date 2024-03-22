CREATE TABLE IF NOT EXISTS vote (
            id SERIAL PRIMARY KEY,
            user_id INT REFERENCES "user"(id),
            challenger_team_id INT REFERENCES challenger_team(id)
);
