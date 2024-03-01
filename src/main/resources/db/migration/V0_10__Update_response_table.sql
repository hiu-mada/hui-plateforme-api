ALTER TABLE "response_table"
    ADD COLUMN id_challenger_team VARCHAR REFERENCES "challenger_team_table"(id) ,
    ADD COLUMN id_subject VARCHAR REFERENCES "subject_table"(id)