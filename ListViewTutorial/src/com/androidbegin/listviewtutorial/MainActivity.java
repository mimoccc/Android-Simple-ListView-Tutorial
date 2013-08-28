package com.androidbegin.listviewtutorial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

public class MainActivity extends Activity {
	// Declare variables
	ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.listview_main);

		// Store string resources into an Array
		String[] SamsungPhones = new String[] { "Galaxy S", "Galaxy S2",
				"Galaxy Note", "Galaxy Beam", "Galaxy Ace Plus", "Galaxy S3",
				"Galaxy S Advance", "Galaxy Wave 3", "Galaxy Wave Y",
				"Galaxy Nexus", "Galaxy W", "Galaxy Y", "Galaxy Mini",
				"Galaxy Gio", "Galaxy Wave", "Galaxy Wave 2" };

		// Locate ListView in listview_main.xml
		listView = (ListView) findViewById(R.id.listview);

		// Bind array strings into an adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				SamsungPhones);
		listView.setAdapter(adapter);

		// Capture ListView item click
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				// Capture the click position and set it into a string
				String phones = (String) listView.getItemAtPosition(position);

				// Launch SingleItemView.java using intent
				Intent i = new Intent(MainActivity.this, SingleItemView.class);

				// Send captured string to SingleItemView.java
				i.putExtra("phones", phones);

				// Start SingleItemView.java
				startActivity(i);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_list_view, menu);
		return true;
	}
}
