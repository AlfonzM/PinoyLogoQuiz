package com.alfonzm.logoquiz;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LogoQuiz extends Activity {
	
	public static ArrayList<LogoItem> items;
	public static int numCorrect;
	TextView correct;
	ImgAdapter imgAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo_quiz);
		LinearLayout v = (LinearLayout) findViewById(R.id.layout);
		v.setBackgroundColor(0xffECECEC);
		
		
		// Initialize stuff
		imgAdapter = new ImgAdapter(this);
		
		items = new ArrayList<LogoItem>();
		for(int i = 0; i < ImgAdapter.mThumbIds.length; i++)
			items.add(new LogoItem(i));
		
		numCorrect = 0;
		
		// Progress bar
		correct = (TextView) findViewById(R.id.tvNumCorrect);
		correct.setText("Progress: 0%");

		GridView gridview = (GridView) findViewById(R.id.logoquiz);
		gridview.setAdapter(imgAdapter);
		gridview.setVerticalScrollBarEnabled(false);
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent intent = new Intent(LogoQuiz.this, LogoAnswer.class);
				intent.putExtra("id", position);
				
				startActivityForResult(intent, position);
			}
		});
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent i) {
		
		int id = i.getExtras().getInt("id");
		if(items.get(id).answered){
			imgAdapter.notifyDataSetChanged();
			correct = (TextView) findViewById(R.id.tvNumCorrect);
			int progress = (Integer) 100 * (numCorrect/ImgAdapter.mThumbIds.length);
			correct.setText("Progress: " + progress + "%");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_logo_quiz, menu);
		return true;
	}

}