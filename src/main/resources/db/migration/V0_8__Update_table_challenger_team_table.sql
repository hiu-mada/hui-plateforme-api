ALTER TABLE "challenger_team_table"
    ADD COLUMN id_university VARCHAR REFERENCES "university_table"(id),
    ADD COLUMN id_discipline VARCHAR REFERENCES "discipline_table"(id)
