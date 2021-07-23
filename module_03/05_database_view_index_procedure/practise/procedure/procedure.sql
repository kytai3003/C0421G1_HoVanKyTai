use classicmodels;
DELIMITER //
create procedure findAllCustomers()
begin

  SELECT * FROM customers;

end 
// DELIMITER ;

call findAllCustomers();

DELIMITER //
drop procedure if exists `findAllCustomers`//
create procedure findAllCustomers()
begin
select * 
from customers 
where customerNumber = 175;
end 
// DELIMITER ;


call findAllCustomers();