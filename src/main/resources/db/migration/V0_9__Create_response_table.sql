CREATE TABLE IF NOT EXISTS "response_table"(
    id VARCHAR PRIMARY KEY DEFAULT uuid_generate_v4(),
    response varchar,
    commentary text
)