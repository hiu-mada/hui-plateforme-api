CREATE TABLE IF NOT EXISTS "challenger_team_table"(
    id varchar primary key default uuid_generate_v4(),
    name varchar not null ,
    slogan text
)