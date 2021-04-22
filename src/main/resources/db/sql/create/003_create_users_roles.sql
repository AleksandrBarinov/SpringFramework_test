create table role (id int4 not null, description varchar(255), name varchar(255), primary key (id));
create table users (id int4 not null, password varchar(255), username varchar(255), primary key (id));
create table users_roles (user_id int4 not null, roles_id int4 not null, primary key (user_id, roles_id));
