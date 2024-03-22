CREATE TABLE IF NOT EXISTS response (
                                      id SERIAL PRIMARY KEY,
                        response TEXT,
                        commentary TEXT,
                        subject_id INT REFERENCES subject(id)
);
