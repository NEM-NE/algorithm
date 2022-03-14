SELECT IF(Grades.grade > 7, Students.name, "NULL"), Grades.grade, Students.marks FROM Students
JOIN Grades
ON Students.marks >= min_mark AND Students.marks <= max_mark
ORDER BY Grades.grade DESC, Students.name;