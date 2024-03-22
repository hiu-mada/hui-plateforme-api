DO
$$
    BEGIN
        IF not exists(SELECT * FROM pg_type where typname='role') then
           CREATE TYPE role AS ENUM ('ADMIN','USER') ;
    END IF;

END
$$;

ALTER TABLE "user_table"
    ADD COLUMN role role default 'USER';


