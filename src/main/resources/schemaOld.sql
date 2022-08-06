    drop table if exists activities CASCADE;
    drop table if exists campers CASCADE;


    drop table if exists signups CASCADE;


    drop sequence if exists hibernate_sequence;

 create table activities (
       id bigint not null,
        created_at date,
        difficulty integer not null,
        name varchar(255),
        updated_at date,
        primary key (id)
    );


    create table campers (
       id bigint not null,
        age integer not null check (age>=8 AND age<=18),
        created_at date,
        name varchar(255),
        updated_at date,
        primary key (id)
    );


    create table signups (
       id bigint not null,
        created_at date,
        time integer not null check (time>=0 AND time<=23),
        updated_at date,
        activity_id bigint,
        camper_id bigint,
        primary key (id)
    );


    alter table signups
       add constraint FKaejxujxf1p9bgo6cm3ddv8lkn
       foreign key (activity_id)
       references activities;


    alter table signups
       add constraint FKlx5s3thbcvhlkgul2o6uw7p59
       foreign key (camper_id)
       references campers;