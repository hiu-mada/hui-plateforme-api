do
$$
    BEGIN
        if not exists(SELECT FROM pg_type where typename='role') then
           CREATE TYPE 'role' AS ENUM ('ADMIN','USER')
    END
$$;

ALTER TABLE "user_table"
    ADD COLUMN "role" role;