create table employee  (id uuid not null, created timestamp, name varchar(255), primary key (id));
create table supplier  (id uuid not null, created timestamp, name varchar(255), primary key (id));
create table candidate (id uuid not null, created timestamp, name varchar(255), primary key (id));


