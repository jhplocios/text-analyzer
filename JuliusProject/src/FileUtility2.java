import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class FileUtility2 {
	
	public Map<String, Integer> processFile(String file){
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		Map<String, Integer> results = new HashMap<String, Integer>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s;
			Integer totalChar =0;
			Integer numberOfSentence=0;
			while( (s = in.readLine()) != null) {
				String UTF8Str = new String(s.getBytes(),"UTF-8");
				System.out.println(UTF8Str.length() + " === " +   UTF8Str);
				
				if( UTF8Str.contains(".") || UTF8Str.contains("?") || UTF8Str.contains("!")) {
					numberOfSentence++;
					//UTF8Str.
				}
				//Get the number of Characters excluding spaces
				UTF8Str.replaceAll(" ", "");
				totalChar+=UTF8Str.length();
			}
			
			results.put("SETENCES", numberOfSentence);
			results.put("CHARACTERS",totalChar);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		return results; 
	}

}
