CREATE TABLE IF NOT EXISTS subject (
                                     id SERIAL PRIMARY KEY,
                       name VARCHAR(255),
                       max_score FLOAT,
                       challenger_team_id INT REFERENCES challenger_team(id)
);
