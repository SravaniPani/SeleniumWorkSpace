package SeleniumFrameworksPratice.jsonObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataProviderHashMap {
	
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		
//		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "//src//test//java//SeleniumFrameworksPratice//jsonObject//dataprovider.json"),
//			StandardCharsets.UTF_8);
		
		//Delcaring for gloabla usage like for any other file, by using filePath Attribute.
		String jsonContent = FileUtils.readFileToString(new File(filePath),
		StandardCharsets.UTF_8);
		
		
		
	//Jackson data-bind will convert String to HashMap, it was new dependency.
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String ,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
				
		});
		return data;
	
	
	}
	
	
	

}
