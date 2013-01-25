package net.jstyleconcept.android.passwordtransformation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText passwordEditText;
	CheckBox passwordCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mainactivity);
		passwordEditText=(EditText)findViewById(R.id.editText1);
		passwordCheckBox=(CheckBox)findViewById(R.id.checkBox1);
		passwordCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				if(isChecked) {
					passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				}
				else {
					passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.layout_mainactivity,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(MainActivity.this,SourceCodeActivity.class);
		switch(item.getOrder()) {
			case 0:
				startActivity(intent);
				break;
			case 1:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
