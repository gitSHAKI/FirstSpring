use tododb;

drop table if exists todo;

create table todo(
	id int NOT NULL primary key auto_increment,
    todo_day varchar(20),
    todo_list varchar(50)
);

select * from todo;