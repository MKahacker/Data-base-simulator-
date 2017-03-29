package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	private ArrayList<Students> students;
	private ArrayList<Takes> takes;
	public static void main(String[] args){
		Assignment2 assignment = new Assignment2();
		assignment.readFromCSVFile("/Users/section11/Documents/workspace/assignment2/bin/assignment2/student.csv", "/Users/section11/Documents/workspace/assignment2/bin/assignment2/takes.csv");
		assignment.join();
	}

	private void readFromCSVFile(String filename1, String filename2) {
		File file1 = new File(filename1);
		File file2 = new File(filename2);
		students = new ArrayList<Students>();
		takes = new ArrayList<Takes>();
        try{
            // -read from filePooped with Scanner class
            Scanner inputStream = new Scanner(file1);
            inputStream.useDelimiter(",");
            // hashNext() loops line-by-line
            while(inputStream.hasNext()){
                //read single line, put in string
            	Students student = new Students();
            	if(!inputStream.hasNextInt()){
            		break;
            	}
            	student.setID(inputStream.nextInt());
	            student.setName(inputStream.next());
	            student.setDept_name(inputStream.next());
	            student.setCredits(inputStream.nextInt());
	            students.add(student);
             }
            // after loop, close scanner
            inputStream.close();

            inputStream = new Scanner(file2);
            inputStream.useDelimiter(",");
            // hashNext() loops line-by-line
            while(inputStream.hasNext()){
                //read single line, put in string
            	Takes take = new Takes();
            	if(!inputStream.hasNextInt()){
            		break;
            	}
            	take.setID(inputStream.nextInt());
	            take.setCourse_id(inputStream.next());
	            take.setSec_id(inputStream.nextInt());
	            take.setSemester(inputStream.next());
	            take.setYear(inputStream.next());
	            take.setGrade(inputStream.next());
	            takes.add(take);
             }
            // after loop, close scanner
            inputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception f){
        	f.printStackTrace();
        }
	}
	//Natural Join
	public void join(){
		for(Students s : students){
				for(Takes t: takes){
					System.out.println(s.getID() + " " + s.getDept_name() + " " + s.getName() + " " + s.getCredits() + " " + t.getCourse_id() + " " + t.getGrade() + " " + t.getID() + " " + t.getSec_id() + " " + t.getSemester() + " " + t.getYear());
				}
		}
	}
}
