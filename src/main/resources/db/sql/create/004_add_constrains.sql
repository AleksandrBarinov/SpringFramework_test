alter table person_aud add constraint FKc5na6emj2l0ir751jxn1bl3ix foreign key (rev) references revision;
alter table users_roles add constraint FK15d410tj6juko0sq9k4km60xq foreign key (roles_id) references role;
alter table users_roles add constraint FK2o0jvgh89lemvvo17cbqvdxaa foreign key (user_id) references users;
