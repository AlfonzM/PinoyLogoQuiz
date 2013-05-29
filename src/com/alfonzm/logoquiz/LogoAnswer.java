package com.alfonzm.logoquiz;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LogoAnswer extends Activity {
	int pos;
	String answer;
	Intent toReturn = new Intent();
	
	LogoItem item;
	
	EditText input;
	Button submit;
	ImageView pic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo_answer);
		RelativeLayout v = (RelativeLayout) findViewById(R.id.layout);
		v.setBackgroundColor(0xffECECEC);
		
		Intent intent = getIntent();
		pos = (int) intent.getExtras().getInt("id");
		
		item = LogoQuiz.items.get(pos);
		input = (EditText) findViewById(R.id.etLogoanswer);
		submit = (Button) findViewById(R.id.bLogoanswersubmit);
		pic = (ImageView) findViewById(R.id.ivLogoanswerpic);
		pic.setImageResource(ImgAdapter.mThumbIds[pos]);
		
		if(item.answered)
			disableAnswer();
		
		if(item.userAnswer != null)
			input.setText(item.userAnswer);
	}
	
	@SuppressLint("DefaultLocale") // toLowerCase
	public void submitAnswer(View view){
		
		CharSequence text = "";
		answer = (input.getText().toString()).toLowerCase();
		item.userAnswer = answer;
		
		if(checkAnswer()){
			item.answered = true;
			LogoQuiz.numCorrect++;
			text = "Correct!";
			
			disableAnswer();

		    Handler handler = new Handler();
		    handler.postDelayed(new Runnable() {            
		        @Override
		        public void run() {
		            finish();                 
		        }
		    }, 1000);
		}
		else
			text = "Incorrect answer!";
			
		Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public void disableAnswer(){
		input.setEnabled(false);
		input.setBackgroundColor(Color.rgb(31, 121, 0));
		input.setTextColor(Color.WHITE);
		
		ColorMatrix matrix = new ColorMatrix();
	    matrix.setSaturation(0); //0 means grayscale
	    ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
	    pic.setColorFilter(cf);
	    
		submit.setEnabled(false);
		submit.setText("Correct!");
	}
	
	public boolean checkAnswer(){
		ArrayList<String> answers = new ArrayList<String>();
		
		switch(pos){
		case 0:
			answers.add("abs-cbn");
			answers.add("abscbn");
			answers.add("abs cbn");
			break;

		case 1:
			answers.add("chowking");
			break;

		case 2:
			answers.add("globe");
			break;

		case 3:
			answers.add("jollibee");
			break;

		case 4:
			answers.add("kopiko");
			break;

		case 5:
			answers.add("landbank");
			break;

		case 6:
			answers.add("lbc");
			break;

		case 7:
			answers.add("meralco");
			break;

		case 8:
			answers.add("smart");
			break;

		case 9:
			answers.add("bpi");
			answers.add("bank of the philippine islands");
			break;

		case 10:
			answers.add("cinema one");
			break;

		case 11:
			answers.add("ariel");
			break;

		case 12:
			answers.add("greenwich");
			break;

		case 13:
			answers.add("bear brand");
			break;

		case 14:
			answers.add("the philippine star");
			break;

		case 15:
			answers.add("air 21");
			break;

		case 16:
			answers.add("tv5");
			answers.add("tv 5");
			break;

		case 17:
			answers.add("petron");
			break;

		case 18:
			answers.add("bench");
			break;

		case 19:
			answers.add("datu puti");
			break;

		case 20:
			answers.add("2go");
			break;

		case 21:
			answers.add("philippine airlines");
			answers.add("philippine air lines");
			break;

		case 22:
			answers.add("zonrox");
			break;

		case 23:
			answers.add("airphil express");
			answers.add("airphilippines express");
			answers.add("air philippines express");
			answers.add("air philippines");
			break;

		case 24:
			answers.add("ayala land");
			break;

		case 25:
			answers.add("banco de oro");
			break;

		case 26:
			answers.add("mercury drug");
			break;

		case 27:
			answers.add("domex");
			break;

		case 28:
			answers.add("sun");
			answers.add("sun cellular");
			break;

		case 29:
			answers.add("myx");
			break;

		case 30:
			answers.add("ace hardware");
			break;

		case 31:
			answers.add("philippine basketball association");
			break;

		case 32:
			answers.add("oxygen");
			break;

		case 33:
			answers.add("cebu pacific");
			answers.add("cebu pacific air");
			break;

		case 34:
			answers.add("philippine national bank");
			break;

		case 35:
			answers.add("gma");
			break;

		case 36:
			answers.add("magnolia");
			break;

		case 37:
			answers.add("security bank");
			break;

		case 38:
			answers.add("PLDT");
			answers.add("philippine long distance telephone");
			break;

		case 39:
			answers.add("mang inasal");
			break;

		case 40:
			answers.add("metrobank");
			break;

		case 41:
			answers.add("watsons");
			answers.add("watson's");
			break;

		case 42:
			answers.add("SM");
			break;

		case 43:
			answers.add("san miguel corporations");
			answers.add("san miguel corporation");
			answers.add("san miguel corp");
			break;

		case 44:
			answers.add("national bookstore");
			break;

		case 45:
			answers.add("penshoppe");
			break;

		case 46:
			answers.add("purefoods");
			break;
			
		default:
			break;
		}
		
		if(answers.contains(answer))
			return true;
		else
			return false;
	}
	
	@Override
	public void finish() {
		toReturn.putExtra("id", pos);
		setResult(RESULT_OK, toReturn);
		super.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_logo_answer, menu);
		return true;
	}

}