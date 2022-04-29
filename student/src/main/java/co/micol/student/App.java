package co.micol.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

//import java.sql.Connection;
//
//import co.micol.student.dao.DateSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Connection conn = DateSource.getConnection();
    	
    	StudentService dao = new StudentServiceImpl();
    	List<StudentVO> list = new ArrayList<StudentVO>();
    	list = dao.selectListStudent();
    	
    	for(StudentVO vo : list) {
    		vo.toString();
    	}
//    	System.out.println("============================");
//    	StudentVO student = new StudentVO();
//    	student.setStudentId("pack@naver.com");
//    	student = dao.selectStudent(student);
//    	student.toString();
    	
//    	StudentVO vo = new StudentVO();
//    	vo.setStudentId("leeto@naver.com");
//    	vo.setName("이투기");
//    	vo.setBirthday(Date.valueOf("2000-01-02"));
//    	vo.setMajor("무역학과");
//    	vo.setAddress("대구광역시 달서구 용산2동");
//    	vo.setTel("010-3333-4444");
//    	int n = dao.insertStudent(vo);
//    	if(n != 0) {
//    		System.out.println("정상적으로 입력이 되었습니다.");
//    		
//    	}else {
//    		System.out.println("입력이 실패되었습니다.");
//    	}
    }
}
