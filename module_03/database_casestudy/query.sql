use resort_management;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống 
-- có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * 
from nhan_vien n inner join vi_tri v on n.id_vi_tri = v.id_vi_tri
inner join trinh_do t on n.id_trinh_do = t.id_trinh_do
inner join bo_phan b on n.id_bo_phan = b.id_bo_phan
where ho_ten like 'h%' or ho_ten like 't%' or ho_ten like 'k%'
and length(ho_ten) <= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- 		và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where year(ngay_sinh) <= 2003 and year(ngay_sinh) >= 1971
and dia_chi like '%đà nẵng' or dia_chi like '%quảng trị';

-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select k.id_khach_hang, k.ho_ten, k.ngay_sinh, k.so_cmnd, k.so_dien_thoai, k.dia_chi, l.ten_loai_khach,
count(h.id_hop_dong) as 'so_lan'
from khach_hang k inner join hop_dong h on k.id_khach_hang = h.id_khach_hang
inner join loai_khach l on k.id_loai_khach = l.id_loai_khach
where l.ten_loai_khach = 'Diamond'
group by(id_khach_hang)
order by so_lan asc;

-- 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong,
-- NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, 
-- với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phòng. 
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select k.id_khach_hang, k.ho_ten, l.ten_loai_khach, h.id_hop_dong, d.ten_dich_vu, h.ngay_lam_hop_dong,
(d.chi_phi_thue + dv.gia * hd.so_luong) as 'Tong_tien'
from hop_dong h inner join dich_vu d on h.id_dich_vu = d.id_dich_vu
inner join hop_dong_chi_tiet hd on hd.id_hop_dong = h.id_hop_dong
inner join dich_vu_di_kem dv on dv.id_dich_vu_di_kem = hd.id_dich_vu_di_kem
right join khach_hang k on k.id_khach_hang = h.id_khach_hang
inner join loai_khach l on l.id_loai_khach = k.id_loai_khach
group by(k.id_khach_hang);

-- 6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
-- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select d.id_dich_vu, d.ten_dich_vu, d.dien_tich, l.ten_loai_dich_vu
from dich_vu d inner join loai_dich_vu l on d.id_loai_dich_vu = l.id_loai_dich_vu
where not exists (select * from hop_dong h where h.id_dich_vu = d.id_dich_vu 
and h.ngay_lam_hop_dong between '2019-01-01' and '2019-03-31');

-- 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
-- nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.
select d.id_dich_vu, d.ten_dich_vu, d.dien_tich, d.so_nguoi_toi_da, d.chi_phi_thue, l.ten_loai_dich_vu
from dich_vu d inner join loai_dich_vu l on l.id_loai_dich_vu = d.id_loai_dich_vu
inner join hop_dong h on h.id_dich_vu = d.id_dich_vu
where year(h.ngay_lam_hop_dong) = '2018' and d.id_dich_vu not in(
		select h.id_dich_vu
        from hop_dong h
        where year(h.ngay_lam_hop_dong) = '2019'
        );

-- 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
-- Cách 1:
select distinct ho_ten
from khach_hang;
-- Cách 2:
select ho_ten
from khach_hang
group by id_khach_hang; 
-- Cách 3:

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(h.ngay_lam_hop_dong) as 'thang', count(h.id_hop_dong) as 'so lan'
from hop_dong h inner join khach_hang k on h.id_khach_hang = k.id_khach_hang
where year(h.ngay_lam_hop_dong) = 2019
group by thang
order by thang asc;

-- 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select h.id_hop_dong, h.ngay_lam_hop_dong, h.ngay_ket_thuc, h.tien_dat_coc,
count(hd.so_luong) as 'so luong dich vu di kem'
from hop_dong h inner join hop_dong_chi_tiet hd on h.id_hop_dong = hd.id_hop_dong
group by h.id_hop_dong;

-- 11.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
-- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dv.ten_dich_vu_di_kem, dv.gia, dv.don_vi, k.ho_ten 
from dich_vu_di_kem dv inner join hop_dong_chi_tiet hd on dv.id_dich_vu_di_kem = hd.id_dich_vu_di_kem
inner join hop_dong h on hd.id_hop_dong = h.id_hop_dong
inner join khach_hang k on h.id_khach_hang = k.id_khach_hang
inner join loai_khach l on l.id_loai_khach = k.id_loai_khach
where l.ten_loai_khach = 'Diamond' 
and k.dia_chi like '%Vinh' or '%Quảng Ngãi';

-- 12.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, 
-- TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select h.id_hop_dong, n.ho_ten, k.ho_ten, k.so_dien_thoai, d.ten_dich_vu, h.tien_dat_coc,
sum(hd.id_hop_dong_chi_tiet) as 'so luong dich vu di kem'
from khach_hang k inner join hop_dong h on k.id_khach_hang = h.id_khach_hang
inner join dich_vu d on h.id_dich_vu = d.id_dich_vu
inner join nhan_vien n on h.id_nhan_vien = n.id_nhan_vien
inner join hop_dong_chi_tiet hd on h.id_hop_dong = hd.id_hop_dong
where h.ngay_lam_hop_dong between '2019-10-01' and '2019-12-31'
and not exists (
		select *
        from hop_dong h
        where h.id_dich_vu = d.id_dich_vu
        and h.ngay_lam_hop_dong between '2019-01-01' and '2019-05-31'
        )
group by d.id_dich_vu;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
		

