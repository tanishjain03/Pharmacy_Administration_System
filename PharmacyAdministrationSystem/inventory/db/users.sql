create table users
(userCode int primary key generated always as identity(start with 1,increment by 1),
userName char(15) not null unique,
passward char(15) not null,
masterPassward char(15) not null); 
