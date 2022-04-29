package co.micol.student.dto;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class StudentVO {	// Dto 멤버변수와 겟터 셋터로만 구성돼 있는것
	private String studentId;
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;
	
	
	@Override
	public String toString() {
		System.out.print(studentId + " : ");
		System.out.print(name + " : ");
		System.out.print(birthday + " : ");
		System.out.print(major + " : ");
		System.out.print(address + " : ");
		System.out.println(tel);
		return null;
	}
}
