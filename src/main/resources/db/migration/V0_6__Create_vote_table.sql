CREATE TABLE IF NOT EXISTS "vote_table"(
    id_challenger VARCHAR REFERENCES "challenger_team_table"(id) ,
    id_user VARCHAR REFERENCES "user_table"(id)
)
