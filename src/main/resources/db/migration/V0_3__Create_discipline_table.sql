CREATE TABLE IF NOT EXISTS "discipline_table"(
    id varchar primary key default uuid_generate_v4(),
    name varchar not null,
    description text
)