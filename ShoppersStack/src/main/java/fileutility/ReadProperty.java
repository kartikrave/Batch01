package fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ReadProperty
{
	FileInputStream path;
	public String fetchProperty(String key)
	{
	try
	{
		path=new FileInputStream("./src/test/resources/readprop.properties");
	}
	catch (FileNotFoundException f)
	{
		Reporter.log("Path is wrong",true);
	}
	Properties obj=new Properties();
	try
	{
		obj.load(path);
	}
	catch(IOException f)
	{
		Reporter.log("Path is wrong",true);
	}
	String data=obj.getProperty(key);
	return data;
	}
}
