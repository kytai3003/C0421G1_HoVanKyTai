use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *, max(`subject`.credit) as 'Credit lớn nhất'
from `subject`;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.SubId, s.SubName, s.Credit, max(m.mark) as 'Điểm thi lớn nhất'
from `subject` s inner join Mark m on m.SubId = s.SubId;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.StudentId, s.StudentName, s.Address, s.Phone, m.Mark / m.Examtimes as 'DTB' 
from student s inner join Mark m on m.StudentId = s.StudentId
order by DTB desc;