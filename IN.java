public class IN {
	public String[][] IN(String[][] t1, String[][] t2, String attr, double avg, boolean gtlt)
	{
		String[][] result=new String  [t1.length][t1[0].length];//result will be from table t1
		String[][] t2group = new String [t2.length][t2[0].length];//group t2 acording to conditions passed
		//t2group = t2.GROUPBY(attr, avg, gtlt) gtlt=TRUE means >, gtlt=FALSE means <
		int attCol = 0; //Column that attr is, how to do this????
		int count = 0; //for counting how many current result rows there are
		
		//loop thru t2group and IF attr of t2group is IN t1, put row in result
		for(int i=0; i<t2group.length; i++ ) //t2groups rows
		{
			for(int j=0; j<t1.length; j++) //t1 rows to check against
			{
				if (t2group[i][attCol]==t1[j][attCol]) //if attr of t2group matches to t1 attr
				{
					for(int m=0; m<t1[0].length; m++) //put matching row of t1 in result
					{
						result[count][m]=t1[j][m];
						count++;
					}
				}
			}
		}
		return result;
	}
}
