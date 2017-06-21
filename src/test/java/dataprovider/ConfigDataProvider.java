package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src=new File("./config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
		
			} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
			
		}
	}
		
		
	public String getApplicationUrl()
		{
			String url = pro.getProperty("url");
			return url;
			
		}

	public String getchromepathUrl()
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
		
	}
	
	public String getiePathUrl()
	{
		String iePath = pro.getProperty("iePath");
		return iePath;
		
	}
	

}
