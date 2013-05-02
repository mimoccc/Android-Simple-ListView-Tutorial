package com.androidbegin.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemView extends Activity{
	String phones;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_item_view);
 
        // Displaying selected phone name
        TextView txtPhones = (TextView) findViewById(R.id.samsung_phones);
 
        // Get intent data from ListViewActivity.java
        Intent i = getIntent();
        phones = i.getStringExtra("phones");
        
        // Set the selected phone name into TextView
        txtPhones.setText(phones);
        
        // Change title according the selected phone name
        setTitle(phones);
    }
}