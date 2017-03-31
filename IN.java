public class IN2 {
	public HashMap<String, List<Students>> IN(HashMap<String, List<Students>> students, HashMap<String, List<Takes>> takes, String attr)
	{
		HashMap<String, List<Students>> result = new HashMap<String, List<Students>>();
		HasMap<String, Integer> grouped = groupByAndAverage(students, attr);
		Iterator<Entry<String, List<Students>>> iterator = set.iterator();
		
		for(Students s: grouped)
		{
			List<Students> list = new ArrayList<Students>();
			list.add(s);
			for(Takes t: takes)
			{
				if(!result.containsKey(s.getDept_name()))
				{
					if(s.getDept_name()==t.getDept_name())
					{
						result.put(s.getDept_name(),list);
					}
				}
			}
		}
		return result;
	}
}
