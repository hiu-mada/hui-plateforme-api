CREATE TABLE IF NOT EXISTS challenger_team (
                                             id SERIAL PRIMARY KEY,
                               name VARCHAR(255),
                               slogan TEXT,
                               university_id INT REFERENCES university(id),
                               discipline_id INT REFERENCES discipline(id)
);
