package aula.android.aula05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MensagemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Intent intent = getIntent();
		String text = intent.getStringExtra("aula.android.aula05.MAINACTIVITY");
		
		TextView tv = new TextView(this);
		System.out.println(text);
		
		tv.setText(text);
		setContentView(tv);
		
	}
}
