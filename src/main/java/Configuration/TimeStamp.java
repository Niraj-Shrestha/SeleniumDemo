package Configuration;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeStamp {
    public String timeStamp(){
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return timestamp;
    }
}
