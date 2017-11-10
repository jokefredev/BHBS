package bs.hackathon.group.hackathonbs.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by anveena on 09.11.17.
 */

public class LogHelper {
    public static void log(Context context, String msg) {
        if (context == null) {
            int a = 0;
        }
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
