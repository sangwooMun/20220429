package co.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dao.DateSource;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private DateSource dateSource = DateSource.getInstance();	// Dao instance 생성
	private Connection conn = dateSource.getConnection();	// connection 연결
	private PreparedStatement psmt;	// sql 명령실행
	private ResultSet rs;	// select 결과를 담음
	
	@Override
	public List<StudentVO> selectListStudent() {
		// 전체 학생 목록 가져오기
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student;
		String sql = "SELECT * FROM STUDENT"; // 컨트롤 쉬프트 x = 대문자로 바꿔 줌
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음
			while(rs.next()) {
				student = new StudentVO(); // 초기화
				student.setStudentId(rs.getString("studentid")); // 값을 VO객체에 다시 담고
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student); // 리스트 추가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		// 한명 학생 가져오기
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setMajor(rs.getString("major"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int insertStudent(StudentVO student) {
		// 한명 추가
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {
		// 한명 정보 변경
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?,"
					+ " ADDRESS = ?, TEL = ? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(1, student.getAddress());
			psmt.setString(1, student.getTel());
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteStudent(StudentVO student) {
		// 한명 삭제
		int n = 0;
		String sql = "DELET FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

}
