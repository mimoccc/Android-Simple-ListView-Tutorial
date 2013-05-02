package com.androidbegin.listview;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

public class ListViewActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// Set title for the ListView
    	setTitle("Samsung Phones");
    	super.onCreate(savedInstanceState);
 
        // Storing string resources into Array
        String[] SamsungPhones = new String[] {"Galaxy S", "Galaxy S2", "Galaxy Note",
                "Galaxy Beam", "Galaxy Ace Plus", "Galaxy S3", "Galaxy S Advance", "Galaxy Wave 3",
                "Galaxy Wave Y", "Galaxy Nexus", "Galaxy W", "Galaxy Y", "Galaxy Mini", "Galaxy Gio",
                "Galaxy Wave", "Galaxy Wave 2", "Galaxy Wave 2"};
 
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_view_item, R.id.label, SamsungPhones));
 
        ListView view = getListView();
 
        // Listening to ListView item click
        view.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
 
              // On Item Selected
              String phones = ((TextView) view).getText().toString();
 
              // Launch SingleItemView.java on selecting ListView Item
              Intent i = new Intent(getApplicationContext(), SingleItemView.class);
              
              // Send data to SingleItemView.java using intent
              i.putExtra("phones", phones);
              
              // Start SingleItemView
              startActivity(i);
 
          }
        });
    }
    
    // Not using options menu for this tutorial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list_view, menu);
        return true;
    }
}
