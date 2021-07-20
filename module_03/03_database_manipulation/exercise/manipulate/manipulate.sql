use sale_management;

-- Thêm dữ liệu
insert into customer (customer_name, customer_age)
value ('Minh Quan', 10);
insert into customer (customer_name, customer_age)
value ('Ngoc Oanh', 20);
insert into customer (customer_name, customer_age)
value ('Hong Ha', 50);

insert into `order` (customer_id, order_date)
value (1, '2006-03-21');
insert into `order` (customer_id, order_date)
value (2, '2006-03-23');
insert into `order` (customer_id, order_date)
value (1, '2006-03-16');

insert into product (product_name, product_price)
value ('May Giat', 3);
insert into product (product_name, product_price)
value ('Tu Lanh', 5);
insert into product (product_name, product_price)
value ('Dieu Hoa', 7);
insert into product (product_name, product_price)
value ('Quat', 1);
insert into product (product_name, product_price)
value ('Bep Dien', 2);

insert into order_detail (order_id, product_id, order_quantity)
value (1,1,3);
insert into order_detail (order_id, product_id, order_quantity)
value (1,3,7);
insert into order_detail (order_id, product_id, order_quantity)
value (1,4,2);
insert into order_detail (order_id, product_id, order_quantity)
value (2,1,1);
insert into order_detail (order_id, product_id, order_quantity)
value (3,1,8);
insert into order_detail (order_id, product_id, order_quantity)
value (2,5,4);
insert into order_detail (order_id, product_id, order_quantity)
value (2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select * from `order` o inner join order_detail od on o.order_id = od.order_id;

-- Hiển thị danh sách các khách hàng đã mua hàng,
select distinct c.customer_name from customer c inner join `order` o on o.customer_id = c.customer_id;
--  và danh sách sản phẩm được mua bởi các khách
select p.product_name, o.order_date, od.order_quantity
from product p inner join order_detail od on p.product_id = od.product_id 
inner join `order` o on o.order_id = od.order_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select * from customer c where not exists (select * from `order` o where o.customer_id = c.customer_id);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select o.order_id, o.order_date, od.order_quantity * p.product_price as 'Tổng tiền'
from `order` o inner join order_detail od on o.order_id = od.order_id
inner join product p on od.product_id = p.product_id;


