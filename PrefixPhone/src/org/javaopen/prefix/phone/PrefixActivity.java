package org.javaopen.prefix.phone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.PhoneNumberUtils;

public class PrefixActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		String number = PhoneNumberUtils.getNumberFromIntent(intent, this);
		
		SharedPreferences sp =
				PreferenceManager.getDefaultSharedPreferences(this);
		String defValue = getString(R.string.prefix_default);
		String key = getString(R.string.prefix_key);
		String prefix = sp.getString(key, defValue);
		
		key = getString(R.string.remove_left_key);
		if (sp.getBoolean(key, false)) {
			if (number.startsWith("0")) {
				number = number.substring(1);
			}
		}

		Intent callIntent =
				new Intent(Intent.ACTION_CALL, Uri.parse("tel://" + prefix + number));
		startActivity(callIntent);
	}
}
