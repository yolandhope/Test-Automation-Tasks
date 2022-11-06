package testSuites;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.ous.jtoml.ParseException;

public class ReadJason {
	//creating a json parser object
	

	public String readFromJason (String keyname) throws FileNotFoundException ,IOException,ParseException, Exception  {
	JSONParser jsonparser= new JSONParser();
	
	//parse the content
	FileReader file = new FileReader("C:\\Users\\ZIKA_\\eclipse-workspace\\seleniumAutomationDemo\\src\\test\\resources\\TestData.json");
	JSONObject jsonobject =(JSONObject) jsonparser.parse(file);
	String data =(String) jsonobject.get(keyname);
	return data;
	}


public static void main(String args[]) {
	ReadJason readjson = new ;
	
	String data=readjson.readFromJason("inputData");

}}