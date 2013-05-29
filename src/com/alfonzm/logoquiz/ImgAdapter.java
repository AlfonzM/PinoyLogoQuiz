package com.alfonzm.logoquiz;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImgAdapter extends BaseAdapter {
	private Context mContext;
	private ColorMatrixColorFilter cf;
	
	// IMAGE ADAPTER FOR LOGO QUIZ GAME

	public ImgAdapter(Context c) {
		mContext = c;
		ColorMatrix matrix = new ColorMatrix();
	    matrix.setSaturation(0); //0 means grayscale
	    cf = new ColorMatrixColorFilter(matrix);
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;

		imageView = (ImageView) convertView;
		imageView = new ImageView(mContext);
		imageView.setLayoutParams(new GridView.LayoutParams(80, 80));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		imageView.setImageResource(mThumbIds[position]);
		
		if(LogoQuiz.items.get(position).answered){
		    imageView.setColorFilter(cf);
		    imageView.setAlpha(175);
		}
		
		return imageView;
	}

	public static Integer[] mThumbIds = 
	{
		R.drawable.abscbn,
		R.drawable.chowking,
		R.drawable.globe,
		R.drawable.jollibee,
		R.drawable.kopiko,
		R.drawable.landbank,
		R.drawable.lbc,
		R.drawable.meralco,
		R.drawable.smart,
		R.drawable.bpi,
		R.drawable.cinemaone,
		R.drawable.ariel,
		R.drawable.greenwich,
		R.drawable.bearbrand,
		R.drawable.thephilstar,
		R.drawable.air21,
		R.drawable.tv5,
		R.drawable.petron,
		R.drawable.bench,
		R.drawable.datuputi,
		R.drawable.go2,
		R.drawable.pal,
		R.drawable.zonrox,
		R.drawable.airphil,
		R.drawable.ayalalands,
		R.drawable.bdo,
		R.drawable.mercurydrug,
		R.drawable.domex,
		R.drawable.sun,
		R.drawable.myx,
		R.drawable.acehardware,
		R.drawable.pba,
		R.drawable.oxygen,
		R.drawable.cebupacific,
		R.drawable.pnb,
		R.drawable.gma,
		R.drawable.magnolia,
		R.drawable.securitybank,
		R.drawable.pldt,
		R.drawable.manginasal,
		R.drawable.metrobank,
		R.drawable.watsons,
		R.drawable.sm,
		R.drawable.sanmiguelcorporations,
		R.drawable.nationalbookstore,
		R.drawable.penshoppe,
		R.drawable.purefoods
	};
	
}