use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *, max(`subject`.credit) as 'Credit lớn nhất'
from `subject`;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.sub_id, s.sub_name, s.credit, max(m.mark) as 'Điểm thi lớn nhất'
from `subject` s inner join mark m on m.sub_id = s.sub_id;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.student_id, s.student_name, s.address, s.phone, m.mark, avg(m.mark) as 'DTB'
from student s inner join Mark m on m.student_id = s.student_id
group by s.student_id
order by DTB desc;