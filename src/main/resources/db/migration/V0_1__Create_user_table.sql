create extension if not exists "uuid-ossp";

CREATE TABLE IF NOT EXISTS "user_table"(
    id varchar primary key default uuid_generate_v4(),
    email varchar not null unique,
    username varchar not null unique,
    password varchar not null,
    profile_picture varchar
)