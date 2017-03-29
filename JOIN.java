
public class JOIN {//Ignore this part just copy and paste into assignment 2 functions

	public String[][] JOIN(String[][] t1, String[][] t2) //Takes in 2 tables and returns the cartesian product of them.
	{
		String[][] cartesian=new String  [t1.length*t2.length]   [t1[0].length+t2[0].length]; //times the rows add the cols
		
		for( int i= 0; i<cartesian.length;i++ )
		{
			for(int j = 0; j<cartesian[0].length;j++)
			{
				if (j<t1[0].length)//part 1 of cartesian where the 1st table's row is put down a couple times in-a-row
				{
					cartesian[i][j]=t1[i/t1.length][j];
				}
				else//just depends on how many rows in 2nd table(modulus % length)
				{
					cartesian[i][j]= t2[i%t2.length][j-t1[0].length];
				}
			}
		}
		
		return cartesian;
	}
}
