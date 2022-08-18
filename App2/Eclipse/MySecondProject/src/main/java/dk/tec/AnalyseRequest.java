package dk.tec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyseRequest 
{
	MatchElev level;
	int id;
	
	public MatchElev getLevel() {
		return level;
	}

	public int getId() {
		return id;
	}

	public AnalyseRequest(String pathInfo) 
	{
		Matcher matcher = Pattern.compile("/Elev/([0-9]+)").matcher(pathInfo);
		
		if(matcher.find())
		{
			level = MatchElev.MatchElevId;
			id = Integer.parseInt(matcher.group(1));
		}
		else
		{		
			matcher = Pattern.compile("/Elev/").matcher(pathInfo);
			if(matcher.find())
			{
				level = MatchElev.MatchElev;
			}
			else
			{
				level = MatchElev.MatchNo;
			}
		}
		
	}

}
