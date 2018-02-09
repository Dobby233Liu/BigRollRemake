package com.mycompany.myapp.roll;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		showInputDialog();
	
    }
	private void showInputDialog() {
    /*@setView 装入一个EditView
     */
    final EditText editText = new EditText(MainActivity.this);
    AlertDialog.Builder inputDialog = 
	new AlertDialog.Builder(MainActivity.this);
    inputDialog.setTitle(R.string.text).setView(editText);
    inputDialog.setPositiveButton(R.string.insert, 
	new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
		((TextView)findViewById(R.id.Loremipsum)).setText(editText.getText().toString());
        }
    }).show();
	}
	public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.insert_item:
	showInputDialog();
	break;
	default:
	break;
	}
	return super.onOptionsItemSelected(item);
    }
}
