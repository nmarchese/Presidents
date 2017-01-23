package data;

import java.util.Map;

public interface PresidentsDAO {
	Map<Integer, President> getPresList();
	President getPresident(int term);
}
