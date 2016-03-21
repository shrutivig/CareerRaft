package careerraft.app.android.sec.com.careerraft.Utils;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by shruti.vig on 3/14/16.
 */
public class JsonUtility {

    public static JSONObject getJsonForServerLogValues(String screenName, String eventName) {

        JSONObject prop = new JSONObject();
        /*try {
            //prop.put(AnalyticsConstants.SCREEN_NAME, screenName);
            //prop.put(AnalyticsConstants.EVENT_NAME, eventName);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        return prop;

    }
}
