-- 1. Tạo database
drop database if exists demo;
create database demo;
use demo;

-- 2. Tạo bảng và insert dữ liệu
create table product(
id int primary key not null auto_increment,
product_code varchar(20),
product_name varchar(30),
product_price int,
product_amount int,
product_description varchar(100),
product_status varchar(30));

insert into product 
values (1, 'ab1', 'xe ga', '45000000', 5, 'racing boy', 'tốt'),
		(2, 'cub', 'xe số', '20000000', 10, 'racing girl', 'ok'); 

-- 3.1 Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index index_product_code
on product (product_code);

-- 3.2 Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index index_name_price
on product (product_name, product_price);

-- 3.3 Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from product;

-- 4.1 Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product_view
as select p.product_code, p.product_name, p.product_price, p.product_status
from product p;

-- 4.2 Tiến hành sửa đổi view
update product_view
set product_status = 'ok'
where product_code = 'ab1';

-- 4.3 Xóa view
drop view product_view;

-- 5.1 Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
drop procedure if exists select_all_info;
DELIMITER //
create procedure select_all_info ()
begin
	select *
    from product;
end
//DELIMITER ;

-- 5.2 Tạo store procedure thêm một sản phẩm mới
drop procedure if exists add_new_product;
DELIMITER //
create procedure add_new_product (
new_product_code varchar(30),
new_product_name varchar(30),
new_product_price int,
new_product_amount int,
new_product_dst varchar(100),
new_product_status varchar(30))
begin
	insert into product (product_code, product_name, product_price, product_amount, product_description, product_status)
    values (new_product_code, new_product_name, new_product_price, new_product_amount, new_product_dst, new_product_status);
end
// DELIMITER ;
call add_new_product('ymh', 'nvx', 50000000, 10, 'ok', 'ok');

-- 5.3 Tạo store procedure sửa thông tin sản phẩm theo id
drop procedure if exists change_product_info;
DELIMITER //
create procedure change_product_info (id_product int, new_product_code varchar(30))
begin
	update product
    set product_code = new_product_code
    where id = id_product;
end
// DELIMITER ;
call change_product_info(1, 'air blade');

-- 5.4 Tạo store procedure xoá sản phẩm theo id
drop procedure if exists delete_product;
DELIMITER //
create procedure delete_product (in id_product int)
begin
	delete 
    from product
    where id = id_product;
end
// DELIMITER ;
call delete_product(2);