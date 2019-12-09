import java.io.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map; 
public class FileUtility1 {
	
	public Map<String, Object> processFile(String file, ResultType type) {
		
		Map<String, Object> results = new HashMap<String, Object>();
        FileInputStream fileStream;
		try {
			fileStream = new FileInputStream(new File(file));
			InputStreamReader input = new InputStreamReader(fileStream); 
			BufferedReader reader = new BufferedReader(input); 
			
			Integer countWord = 0; 
			Integer sentenceCount = 0; 
			Integer characterCount = 0; 
			Integer paragraphCount = 1; 
			Integer whitespaceCount = 0;
			String line="";
			while((line = reader.readLine()) != null) 
			{ 
				line = new String(line.getBytes(),"UTF-8");
				if(type == ResultType.PARAGRAPHS) {
					if(line.equals("")){ 
						paragraphCount++; 
					} 
					results.put("PARAGRAPHS", paragraphCount);
				}else if(type == ResultType.SENTENCES ) {
					if(!(line.equals(""))){ 
						String[] sentenceList = line.split("[!?.:]+"); // [!?.:]+ is the sentence delimiter in java 
						sentenceCount += sentenceList.length; 
					} 
					results.put("SENTENCES",sentenceCount);
				}else if(type == ResultType.WORDS ) {
					if(!(line.equals(""))){ 
						String[] wordList = line.split("\\s+"); //Use space as delimiter
						countWord += wordList.length; 
					}
					results.put("WORDS", countWord);
				}else if(type == ResultType.CHARACTERS ) {
					if(!(line.equals(""))){ 
						characterCount += line.length();
					}
					results.put("CHARACTERS",characterCount);
				}
			}
	
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return results;
	} 
}
