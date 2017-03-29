package assignment2;

public class Takes {
	
	private int ID;
	private String course_id = new String();
	private int sec_id;
	private String semester = new String();
	private String year = new String();
	private String grade = new String();
	
	public void setID(int num){
		this.ID = num;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void setCourse_id(String course){
		this.course_id = course;
	}
	
	public String getCourse_id(){
		return this.course_id;
	}
	
	public void setSec_id(int section){
		this.sec_id = section;
	}
	
	public int getSec_id(){
		return this.sec_id;
	}
	
	public void setSemester(String sem){
		this.semester = sem;
	}
	
	public String getSemester(){
		return this.semester;
	}
	
	public void setYear (String newYear){
		this.year = newYear;
	}
	
	public String getYear(){
		return this.year;
	}
	
	public void setGrade(String newGrade){
		this.grade = newGrade;
	}
	
	public String getGrade(){
		return this.grade;
	}
	
	public Takes(){
		this.ID = 0;
		this.course_id = " ";
		this.sec_id = 0;
		this.semester= " ";
		this.year = " ";
		this.grade = " ";
	}
}
