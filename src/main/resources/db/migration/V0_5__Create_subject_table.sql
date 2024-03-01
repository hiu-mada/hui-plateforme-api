CREATE TABLE IF NOT EXISTS "subject_table"(
    id varchar primary key default uuid_generate_v4(),
    title varchar not null,
    description text,
    max_score float
)