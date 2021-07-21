use resort_management;

insert into vi_tri(ten_vi_tri)
values ('Le Tan'), ('Phuc vu'), ('Chuyen vien'), ('Giam sat'), ('Quan ly'), ('Giam doc');

insert into trinh_do(trinh_do)
values ('Trung cap'), ('Cao dang'), ('Dai hoc'), ('Sau dai hoc');

insert into bo_phan(ten_bo_phan)
values ('Sale-marketing'), ('Hanh chinh'), ('Phuc vu'), ('Quan ly');

insert into nhan_vien
values (1, 'Nguyen Van Nhat', '2000-12-20', '200123456', '5000000', '0909123456', 'nhat@gmail.com', 'Da Nang', 1, 2, 3);
insert into nhan_vien
values	(2, 'Đinh Tiến Hoàng', '1996-11-25', '200123457', '5500000', '0909123457', 'hoang@gmail.com', 'Quang Nam', 2, 1, 3),
	    (3, 'Hồ Thị Khải', '1993-05-15', '200123458', '6000000', '0909123458', 'khai@gmail.com', 'Quang Tri', 3, 3, 2),
	    (4, 'Nguyễn Siêu Nhân', '1997-01-13', '200123459', '9000000', '0909123459', 'nhan@gmail.com', 'Da Nang', 5, 4, 4);
       
       
insert into loai_khach (ten_loai_khach)
values ('Diamond'), ('Platinum'), ('Gold'), ('Silver'), ('Member');

insert into khach_hang
values  (1, 'Hoàng Anh Tuấn', '2001-10-20', '123456789', '0909090909', 'tuan@gmail.com', 'Thành phố Vinh, Vinh', 1),
		(2, 'Võ Văn An', '1958-05-05', '123123123', '0909123123', 'an@gmail.com', 'Đức Phổ, Quảng Ngãi', 3),
		(3, 'Lê Anh Quân', '1971-08-05', '123123890', '0909123454', 'quan@gmail.com', 'Hà Tây, Hà Nội', 1),
		(4, 'Trần Văn Hải', '1988-12-09', '123112390', '0923523454', 'hai@gmail.com', 'Lý Sơn, Quảng Ngãi', 1);
        
