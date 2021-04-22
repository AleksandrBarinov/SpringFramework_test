alter table users_roles add constraint UK_60loxav507l5mreo05v0im1lq unique (roles_id);
alter table person_aud add constraint FK9lyxk62ui3cyr5k0w8etnfqkm foreign key (rev) references revinfo;
alter table users_roles add constraint FK15d410tj6juko0sq9k4km60xq foreign key (roles_id) references role;
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users;
