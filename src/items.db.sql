use ecomercedb;
create table e_items(
item_id int(11) NOT NULL AUTO_INCREMENT,
quantity int(11) NOT NULL,
item_name varchar(20),
total_price decimal(10,2),
PRIMARY KEY (`item_id`)
);

INSERT INTO e_items ( quantity, item_name,total_price) values ( 100 , "Pen" , 18900.23);