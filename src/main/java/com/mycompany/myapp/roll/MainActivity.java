package com.mycompany.myapp.roll;
/**
   Copyright 2018 Liu Wenyuan <papaqi1234567@163.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
**/
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
    	ActionBar actionBar = getActionBar();
	    actionBar.setDisplayUseLogoEnabled(false);
	    actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
	((TextView)findViewById(R.id.Loremipsum)).setOnClickListener(new View.OnClickListener(){
		public void onClick(View p1){
		Toast.makeText(MainActivity.this,R.string.long_press_to_copy,Toast.LENGTH_LONG).show();
		}
	});
	((TextView)findViewById(R.id.Loremipsum)).setOnLongClickListener(new View.OnLongClickListener(){

		@Override
		public boolean onLongClick(View p1)
		{
		ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		cm.setText(((TextView)findViewById(R.id.Loremipsum)).getText().toString());
		Toast.makeText(MainActivity.this,R.string.copied,Toast.LENGTH_LONG).show();
		return true;
		}
	});
		showInputDialog();
    }
	private void showInputDialog() {
    /*@setView 装入一个EditView
     */
    final EditText editText = new EditText(MainActivity.this);
	editText.setText(((TextView)findViewById(R.id.Loremipsum)).getText());
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
