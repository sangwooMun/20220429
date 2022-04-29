package co.micol.student.service;

import java.util.List;

import co.micol.student.dto.StudentVO;

public interface StudentService {
	List<StudentVO> selectListStudent();	// 전체학생목록
	StudentVO selectStudent(StudentVO student);	//한명학생목록
	int insertStudent(StudentVO student); // 한명 추가
	int updateStudent(StudentVO student); // 한명 갱신
	int deleteStudent(StudentVO student); // 한명 삭제
}
