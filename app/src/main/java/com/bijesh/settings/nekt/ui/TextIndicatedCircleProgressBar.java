package com.bijesh.settings.nekt.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * RateTextCircularProgressBar is a Widget that holds the CircularProgressBar and a TextView to indicate the Progress
 * State / Value.
 */
public class TextIndicatedCircleProgressBar extends FrameLayout implements
        CircularProgressBar.OnProgressChangeListener {

    private CircularProgressBar mCircularProgressBar;
    private TextView mRateText;

    public TextIndicatedCircleProgressBar(Context context) {
        super(context);
        init();
    }

    public TextIndicatedCircleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextIndicatedCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextIndicatedCircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mCircularProgressBar = new CircularProgressBar(getContext());
        this.addView(mCircularProgressBar);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.CENTER;
        mCircularProgressBar.setLayoutParams(lp);

        mRateText = new TextView(getContext());
        this.addView(mRateText);
        mRateText.setLayoutParams(lp);
        mRateText.setGravity(Gravity.CENTER);
        mRateText.setTextColor(Color.BLACK);
        mRateText.setTextSize(15);

        mCircularProgressBar.setOnProgressChangeListener(this);
    }

    /**
     * ?????
     */
    public void setMax(int max) {
        mCircularProgressBar.setMax(max);
    }

    /**
     * ????
     *
     * @param progress
     */
    public void setProgress(int progress) {
        mCircularProgressBar.setProgress(progress);
    }

    /**
     * ?? CircularProgressBar ??????????????
     *
     * @return
     */
    public CircularProgressBar getCircularProgressBar() {
        return mCircularProgressBar;
    }

    /**
     * ??????????????
     *
     * @param size
     */
    public void setTextSize(float size) {
        mRateText.setTextSize(size);
    }

    /**
     * ??????????????
     *
     * @param color
     */
    public void setTextColor(int color) {
        mRateText.setTextColor(color);
    }

    @Override
    public void onProgressChange(int maxProgress, int progress, float rate) {
        mRateText.setText(String.valueOf((int) (rate * 100) + "%"));
    }

}