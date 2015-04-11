package com.bijesh.settings.android.uidesign.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bijesh.settings.R;

public class ViewPagerAdapter extends PagerAdapter {
	// Declare Variables
	Context context;
	LayoutInflater inflater;
    private int[] mDrawables;
    private static final int YOUR_NETWORK = 0;
    private static final int ONE_ADDRESS = 1;
    private static final int WHO_MATTER = 2;
    private static final int NOTIFICATIONS = 3;

    ImageView imgflag;
    TextView txtHeader;


    public ViewPagerAdapter(Context context,int[] drawables){
        this.context = context;
        this.mDrawables = drawables;
    }

	@Override
	public int getCount() {
		return mDrawables.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((ScrollView) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		// Declare Variables


		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpager_item, container,
				false);


		// Locate the ImageView in viewpager_item.xml
		imgflag = (ImageView) itemView.findViewById(R.id.flag);
		// Capture position and set to the ImageView
		imgflag.setImageResource(mDrawables[position]);

        txtHeader = (TextView) itemView.findViewById(R.id.header_title);

        decorateViews(position);

		// Add viewpager_item.xml to ViewPager
		((ViewPager) container).addView(itemView);

		return itemView;
	}


    private void decorateHeaderText(int position){
        switch (position){
            case YOUR_NETWORK:
                String styledText = "<font color='#2f928e'>Your Network, </font> <font color='#e4af1e'><i>Your</i></font><font color='#2f928e'> Dropbox</font>";
                txtHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                break;
        }
    }


    private void decorateViews(int position){
        decorateHeaderText(position);
    }

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		((ViewPager) container).removeView((ScrollView) object);

	}
}
