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

    private ImageView imgflag;
    private TextView txtHeader,txtDesc,txtDesc1,txtDesc2;


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
		return view == ((RelativeLayout) object);
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
        txtDesc = (TextView) itemView.findViewById(R.id.header_description);
        txtDesc1 = (TextView) itemView.findViewById(R.id.header_description1);
        txtDesc2 = (TextView) itemView.findViewById(R.id.header_description2);

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
                txtDesc1.setVisibility(View.VISIBLE);
                txtDesc2.setVisibility(View.GONE);
                break;
            case ONE_ADDRESS:
                styledText = "<font color='#2f928e'>One Address! </font>";
                txtHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                txtDesc.setTextSize(15f); txtDesc1.setTextSize(15f); txtDesc2.setTextSize(15f);
                txtDesc.setText("Tired of having information about the same person");
                txtDesc1.setText("scattered across multiple sources?Mergingcontact");
                txtDesc2.setText("information has never been this easy before.");
                txtDesc1.setVisibility(View.VISIBLE);
                txtDesc2.setVisibility(View.VISIBLE);
                break;
            case WHO_MATTER:
                styledText = "<font color='#2f928e'>New from people who matter! </font>";
                txtHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                txtDesc.setTextSize(15f); txtDesc1.setTextSize(15f); txtDesc2.setTextSize(15f);
                txtDesc.setText("Take the chore out of keeping in touch with people");
                txtDesc1.setText("who matter. Subscribe to some on NEKT");
                txtDesc1.setVisibility(View.VISIBLE);
                txtDesc2.setVisibility(View.GONE);
                break;
            case NOTIFICATIONS:
                styledText = "<font color='#2f928e'>Notifications!</font>";
                txtHeader.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                txtDesc.setText("Your friends action are now on your hand");
                txtDesc1.setVisibility(View.GONE);
                txtDesc2.setVisibility(View.GONE);
                break;
        }
    }


    private void decorateViews(int position){
        decorateHeaderText(position);
    }

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		((ViewPager) container).removeView((RelativeLayout) object);

	}
}
