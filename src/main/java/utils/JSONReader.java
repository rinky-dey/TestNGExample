package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	public void readJSON() {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resourcse");
			try {
				Object obj = jsonParser.parse(fr);
				
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
