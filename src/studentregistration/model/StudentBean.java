package studentregistration.model;

import java.util.Arrays;

public class StudentBean {
	private String studentid;
	private String studentname;
	private String dob;
	private String gender;
	private String phone;
	private String education;
	private String[] courses;
	
	public StudentBean(String studentid, String studentname, String dob, String gender, String phone, String education,
			String[] courses) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.education = education;
		this.courses = courses;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentBean [studentid=" + studentid + ", studentname=" + studentname + ", dob=" + dob + ", gender="
				+ gender + ", phone=" + phone + ", education=" + education + ", courses=" + Arrays.toString(courses)
				+ "]";
	}
}
