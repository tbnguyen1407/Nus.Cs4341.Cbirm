package core;

import java.util.HashMap;

public class EdgeDirectionSearcher
{
	public String[] fileDatabase;

	public EdgeDirectionSearcher(String[] filedb)
	{
		this.fileDatabase = filedb;
	}

	public HashMap queryImage(String imagePath)
	{
		if (fileDatabase.length == 0)
		{
			return null;
		}

		HashMap resultTable = new HashMap();

		int[] queryIndex = EdgeDirection.loadImageIndex(imagePath);

		for (int i = 0; i < fileDatabase.length; i++)
		{
			String filePath = fileDatabase[i];
			int[] currentIndex = EdgeDirection.loadImageIndex(filePath);
			double diff = (double) EdgeDirection.calculateDistance(queryIndex, currentIndex);
			resultTable.put(filePath, diff);
		}
		return resultTable;
	}
}
