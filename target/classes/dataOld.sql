-- create table activities (
--        id bigint not null,
--         created_at date,
--         difficulty integer not null,
--         name varchar(255),
--         updated_at date,
--         primary key (id)
--     )

--     create table campers (
--        id bigint not null,
--         age integer not null check (age>=8 AND age<=18),
--         created_at date,
--         name varchar(255),
--         updated_at date,
--         primary key (id)
--     )

--     create table signups (
--        id bigint not null,
--         created_at date,
--         time integer not null check (time>=0 AND time<=23),
--         updated_at date,
--         activity_id bigint,
--         camper_id bigint,
--         primary key (id)
--     )


INSERT INTO activities(id, name, difficulty, created_at, updated_at) VALUES (1, 'tennis', 3, '2022-08-25', '2022-08-25');
INSERT INTO campers(id, name, age, created_at, updated_at) VALUES (1, 'Bobby', 10, '2022-08-25', '2022-08-25');
INSERT INTO signups(id, camper_id, activity_id, time, created_at, updated_at) VALUES (1, 1, 1, 8, '2022-08-25', '2022-08-25');