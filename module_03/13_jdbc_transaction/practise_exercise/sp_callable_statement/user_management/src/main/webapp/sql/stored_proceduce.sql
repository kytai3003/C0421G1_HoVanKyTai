use demo;

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

create table permision (
id int primary key,
`name` varchar(45)
);

create table user_permision (
user_id int,
permision_id int,
primary key (user_id, permision_id),
foreign key (user_id) references users (id),
foreign key (permision_id) references permision (id)
);

insert into Permision(id, `name`) values(1, 'add');
insert into Permision(id, `name`) values(2, 'edit');
insert into Permision(id, `name`) values(3, 'delete');
insert into Permision(id, `name`) values(4, 'view');

DELIMITER $$
CREATE PROCEDURE get_all_users()
BEGIN
    SELECT users.id, users.`name`, users.email, users.country
    FROM users;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE get_all_users()
BEGIN
    SELECT users.id, users.`name`, users.email, users.country
    FROM users;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_user_by_id(
IN user_id INT, 
IN user_name varchar(45), 
IN user_email varchar(45), 
In user_country varchar(45))

BEGIN
    update users
    set users.`name` = user_name,
    users.email = user_email,
    users.country = user_country
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_user_by_id(In user_id int)
BEGIN
    delete from users where users.id = user_id;
    END$$
DELIMITER ;


