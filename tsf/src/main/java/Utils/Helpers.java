package Utils;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Helpers {

	public static Timestamp calculateCurrentTimestamp() {
    	Calendar calendar = Calendar.getInstance();
        calendar.getTimeInMillis();
        // TODO: REVISAR ESTO EH
      calendar.add(Calendar.HOUR, 2);
        return new Timestamp(calendar.getTimeInMillis());
	}
}
