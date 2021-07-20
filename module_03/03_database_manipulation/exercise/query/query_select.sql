use quan_ly_sinh_vien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’-- 
select * from student where StudentName like 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select * from `class` where StartDate >= '2008-12-01 00:00:00' and StartDate <= '2008-12-31 23:59:59';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from `subject` where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set SQL_SAFE_UPDATES = 0;
update Student set ClassId = 2 where StudentName =  'Hung';
set SQL_SAFE_UPDATES = 1;

-- Hiển thị các thông tin: StudentName, SubName, Mark. 
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần, nếu trùng sắp theo tên tăng dần.
select s.StudentName, su.SubName, m.Mark
from student s inner join Mark m on s.StudentId = m.StudentId inner join `subject` su on su.SubId = m.SubId
order by mark desc;

select s.StudentName, su.SubName, m.Mark
from student s inner join Mark m on s.StudentId = m.StudentId inner join `subject` su on su.SubId = m.SubId
order by StudentName asc;