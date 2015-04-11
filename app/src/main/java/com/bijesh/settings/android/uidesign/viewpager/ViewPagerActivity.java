package com.bijesh.settings.android.uidesign.viewpager;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.bijesh.settings.R;


public class ViewPagerActivity extends Activity {

	// Declare Variables
	ViewPager viewPager;
	PagerAdapter adapter;
    int[] mConnectDropBox;
	CirclePageIndicator mIndicator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from viewpager_main.xml
		setContentView(R.layout.viewpager_main);


        mConnectDropBox = new int[] {R.drawable.yournetworkyourdropbox,R.drawable.oneaddress,
        R.drawable.peoplewhomatter,R.drawable.notification};


		// Locate the ViewPager in viewpager_main.xml
		viewPager = (ViewPager) findViewById(R.id.pager);
		// Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(ViewPagerActivity.this,mConnectDropBox);
		// Binds the Adapter to the ViewPager
		viewPager.setAdapter(adapter);

		// ViewPager Indicator
		mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
//		mIndicator.setFades(false);
		mIndicator.setViewPager(viewPager);

	}
}