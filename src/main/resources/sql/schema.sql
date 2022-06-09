create table user(id identity primary key, fname varchar(50), lname varchar(50),  email varchar(50), dob date);

create table food_recipes(id identity primary key, ingredients varchar(500), food varchar(50), reciper varchar(5000), userid bigint, foreign key(userid) references user(id));