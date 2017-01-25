package other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches2 {

	public static void main(String[] args) {
		String regex = "^5(2[58]|[3-9][0-9])$";
		Pattern p =  Pattern.compile(regex);
		String line = "575";
		Matcher m = p.matcher(line);
		if (m.find())
			System.out.println(m.group(0));
		
		
	}

}
