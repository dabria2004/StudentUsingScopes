package studentregistration.model;

public class ClassBean {
	
	private String classid;
	private String classname;
	private boolean isCheck;
	
	
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	@Override
	public String toString() {
		return "ClassBean [classid=" + classid + ", classname=" + classname + ", isCheck=" + isCheck + "]";
	}
	
}
