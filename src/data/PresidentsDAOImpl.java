package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

public class PresidentsDAOImpl implements PresidentsDAO {
	private Map<Integer, President> presidents;
	private ServletContext context;

	public PresidentsDAOImpl(ServletContext context) {
		this.context = context;
		this.loadPresidentsFromFile("WEB-INF/presidents.csv");
	}

	@Override
	public Map<Integer, President> getPresList() {
		return presidents;
	}

	@Override
	public President getPresident(int term) {
		return presidents.get(term);
	}
	
	private void loadPresidentsFromFile(String fileName) {
		presidents = new HashMap<>();
		try {
			InputStream is = context.getResourceAsStream(fileName);
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while((line = r.readLine()) != null) {
				String[] fields = line.split(",");
				President p = new President(Integer.parseInt(fields[0]),
								fields[1], fields[2], 
								fields[3], fields[4], 
								fields[5]);
				presidents.put(p.getTermNum(), p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("DEBUG: " + presidents);
	}
}
