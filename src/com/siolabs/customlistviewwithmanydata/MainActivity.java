package com.siolabs.customlistviewwithmanydata;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	String[] titles;
	String[] desc;
	int[] images = {R.drawable.monday, R.drawable.tuesday,R.drawable.wednesday,R.drawable.thursday,R.drawable.friday,R.drawable.saturday,R.drawable.sunday};
	
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Resources res = getResources();
		titles = res.getStringArray(R.array.titles);
		desc = res.getStringArray(R.array.description);
		
		list = (ListView) findViewById(R.id.listView1);
		
		myAdapter adapter = new myAdapter(this, titles, images, desc);
		list.setAdapter(adapter);
		
	}
}


class myAdapter extends ArrayAdapter{
	
	
	Context ctx;
	String[] title;
	String[] desc;
	int[] images;
	
	public myAdapter(Context ctx, String[] data, int[] image, String[] descr){
		super(ctx,R.layout.single_row, R.id.textView1,data);
		this.ctx = ctx;
		this.images = image;
		this.title = data;
		this.desc = descr;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row= inflater.inflate(R.layout.single_row, parent, false);
		
		ImageView myImage =(ImageView) row.findViewById(R.id.imageView1);
		TextView titleView = (TextView)row.findViewById(R.id.textView1);
		TextView descView = (TextView)row.findViewById(R.id.textView2);
		
		myImage.setImageResource(images[position]);
		titleView.setText(title[position]);
		descView.setText(desc[position]);
		
		
		return row;
	}
}
