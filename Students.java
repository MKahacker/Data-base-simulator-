
public class Students {
	private int ID; 
	private String name;
	private String dept_name;
	private int total_credits;
	
	public void setID(int num){
		this.ID = num;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void setName(String sName){
		this.name = sName;
	}
	
	public String getName (){
		return this.name;
	}
	
	public void setDept_name(String dept){
		this.dept_name = dept;
	}

	public String getDept_name(){
		return this.dept_name;
	}
	
	public void setCredits(int credits){
		this.total_credits = credits;
	}
	
	public int getCredits(){
		return this.total_credits;
	}
	
	public void students(){
		this.ID = 0;
		this.name = " ";
		this.dept_name = " ";
		this.total_credits = 0;
	}
}
