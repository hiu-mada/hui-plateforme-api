ALTER TABLE "user_table"
    ADD COLUMN IF NOT EXISTS id_challenger VARCHAR REFERENCES "challenger_team_table"(id)
