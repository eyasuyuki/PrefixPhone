package org.javaopen.prefix.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;

public class PrefixActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		String number = PhoneNumberUtils.getNumberFromIntent(intent, this);

		Intent callIntent =
				new Intent(Intent.ACTION_CALL, Uri.parse("tel://003766" + number));
		startActivity(callIntent);
	}
}
