package edisontkp.com.justpark.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by edisontkp on 16/10/2016.
 */

public class PreferenceHelper {

    private SharedPreferences app_prefs;

    private final String PHONENUMBER = "phoneNumber";

    String phoneNumber;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("JP_pref",
                Context.MODE_PRIVATE);
    }

    public String getPhoneNumber() {
        return app_prefs.getString(PHONENUMBER, "");
    }

    public void setPhoneNumber(String phoneNumber) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(PHONENUMBER, phoneNumber);
        edit.commit();
    }

    public void removePhoneNumber() {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.remove(PHONENUMBER);
        edit.commit();
    }
}
