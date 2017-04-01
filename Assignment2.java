package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Assignment2 {
	private ArrayList<Students> students;
	private ArrayList<Takes> takes;
	public static void main(String[] args){
		Assignment2 assignment = new Assignment2();
		assignment.readFromCSVFile("/Users/section11/Documents/workspace/assignment2/bin/assignment2/student.csv", "/Users/section11/Documents/workspace/assignment2/bin/assignment2/takes.csv");
		assignment.join();
		assignment.antiJoin();
		assignment.outerJoin();
		HashMap<String, List<Students>> groupByResult = assignment.groupBy("depart_name");
		HashMap<String, Integer> groupByAndAverage = assignment.groupByAndAverage(groupByResult, "total_credits");
		Random rand = new Random();
		int randomAverage = rand.nextInt(101);
		assignment.displayGroupByAndAverage(groupByAndAverage, randomAverage);
	}

	private void displayGroupByAndAverage(HashMap<String, Integer> groupByAndAverage, int randomAverage) {
		Set<Entry<String, Integer>> set = groupByAndAverage.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();
		System.out.println("Print all the department names whose total credits is greater than " + randomAverage);
		while(iterator.hasNext()) {
			Entry<String, Integer> mentry = iterator.next();
			if(mentry.getValue() > randomAverage){
				System.out.println(mentry.getKey() + " " + mentry.getValue());
			}
		}
		
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
	
	private HashMap<String, List<Students>> groupBy(String attribute){
		HashMap<String, List<Students>> hmap = new HashMap<String, List<Students>>();
		if(attribute.equals("depart_name")){
			for(Students s: students){
				if (!hmap.containsKey(s.getDept_name())) {
				    List<Students> list = new ArrayList<Students>();
				    list.add(s);
				    hmap.put(s.getDept_name(), list);
				} else {
				    hmap.get(s.getDept_name()).add(s);
				}
			}
			return hmap;
		}
		return hmap;
	}
	
	private HashMap<String, Integer> groupByAndAverage(HashMap<String, List<Students>> hmap, String attribute){
		Set<Entry<String, List<Students>>> set = hmap.entrySet();
		Iterator<Entry<String, List<Students>>> iterator = set.iterator();
		HashMap<String, Integer> groupAndAverage = new HashMap<String, Integer>();
		int avg = 0;
		while(iterator.hasNext()) {
			Entry<String, List<Students>> mentry = iterator.next();
			List<Students> list = (List<Students>) mentry.getValue();
			avg = average(attribute, list);
			groupAndAverage.put(mentry.getKey(), avg);
		}
		return groupAndAverage;
	}
	
	//Aggregate function based on attribute
	private int average(String attribute, List<Students> s){
		if (attribute.equals("total_credits")){
			int avg = 0;
			for (int i = 0; i < s.size(); i++){
				avg += s.get(i).getCredits();
			}
			int totAvg = avg/s.size();
			return totAvg;
		}else{
			System.out.println("Choose another attribute.");
			return -1;
		}
	}
	
	public void antiJoin() //Prints out students that don't correspond to any takes
	{
		for(Students s : students)
		{
			for(Takes t : takes)
			{
				if(s.getID()!=t.getID())
					System.out.println(s.getID() + ", "+s.getName()+", "+s.getDept_name()+", "+ s.getCredits());
			}
		}
	}
	
	public void outerJoin() {
		for(Students s : students)
		{
			for(Takes t : takes)
			{
				if(t.getID()!=s.getID())
					System.out.println(t.getCourse_id() + " " + t.getGrade() + " " + t.getID() + " " + t.getSec_id() + " " + t.getSemester() + " " + t.getYear());
				if(s.getID()!=t.getID())
					System.out.println(s.getID() + ", "+s.getName()+", "+s.getDept_name()+", "+ s.getCredits());
				if(s.getID()==t.getID());
					System.out.println(s.getID() + " " + s.getDept_name() + " " + s.getName() + " " + s.getCredits() + " " + t.getCourse_id() + " " + t.getGrade() + " " + t.getID() + " " + t.getSec_id() + " " + t.getSemester() + " " + t.getYear());
			}
		}
}
	
	public HashMap<String, List<Students>> IN(HashMap<String, List<Students>> students, HashMap<String, List<Takes>> takes, String attr)
	{
		HashMap<String, List<Students>> result = new HashMap<String, List<Students>>();
		HashMap<String, Integer> grouped = groupByAndAverage(students, attr);
		Iterator<Entry<String, List<Students>>> iterator = set.iterator();
		
		for(Students s: grouped)
		{
			int avg = grouped.getValue();
			for(Takes t: takes)
			{
				if(!result.containsKey(s.getDept_name()))
				{
					if(s.getDept_name()==t.getDept_name())
					{
						result.put(s.getDept_name(),avg);
					}
				}
			}
		}
		return result;
	}
}
