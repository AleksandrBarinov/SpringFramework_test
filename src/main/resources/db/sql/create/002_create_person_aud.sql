create table person_aud (id int4 not null, rev int4 not null, revtype int2, age int4, name varchar(255), primary key (id, rev));
create table revision (id int4 not null, timestamp int8 not null, username varchar(255), primary key (id));
