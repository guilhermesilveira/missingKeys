import java.io.*;
import java.util.*;

public class MissingKeys {
	public static void main(String[] args) throws IOException {
		Properties en = new Properties();
		en.load(new FileInputStream("src/main/resources/messages.properties"));

		Properties base = new Properties();
		base.load(new FileInputStream("src/main/resources/messages_pt_BR.properties"));
		
		TreeSet<String> missing = new TreeSet<String>();
		for(Object key : base.keySet()) {
			if(en.getProperty((String) key)==null) {
				missing.add((String) key);
			}
		}
		if(!missing.isEmpty()) {
			System.out.println("Missing keys found!!!!");
			for(String key : missing) {
				System.out.println(key + " = " + base.getProperty(key));
			}
			System.exit(1);
		}
	}
}