package com.bijesh.settings.nekt.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * CircularProgressBar widget shows a progress bar which progress in a circle.
 */
public class CircularProgressBar extends View {
	
	private int mMax = 100;
	private int mProgress = 0;

	private Paint mSecondaryProgressPaint = new Paint();
	private Paint mPrimaryProgressPaint = new Paint();

	private RectF mRectF = new RectF();

	private int mBackgroundColor = Color.LTGRAY;
	private int mPrimaryColor = Color.parseColor("#6DCAEC");

	private float mStrokeWidth = 20F; // In pixels

	private OnProgressChangeListener mOnChangeListener;


	/**
	 *  Interface definition for a callback to be invoked when the progress is changed.
	 */
	public interface OnProgressChangeListener {
		/**
		 * Called when a view has been clicked..
		 *
		 * @param maxProgress The maximum progress value
		 * @param progress The current Progress Value
		 * @param rate current Rate of Progress. rate = (float)progress / duration
		 */
		public void onProgressChange(int maxProgress, int progress, float rate);
	}

	public CircularProgressBar(Context context) {
		super(context);
		initDefaults();
	}

	public CircularProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		initDefaults();
	}

	public CircularProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initDefaults();
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CircularProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initDefaults();
	}

	public void initDefaults() {
		mSecondaryProgressPaint.setColor(mBackgroundColor);
		mSecondaryProgressPaint.setDither(true);
		mSecondaryProgressPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mSecondaryProgressPaint.setAntiAlias(true);
		mSecondaryProgressPaint.setStrokeWidth(toDp(mStrokeWidth));
		mSecondaryProgressPaint.setStyle(Paint.Style.STROKE);

		mPrimaryProgressPaint.setColor(mPrimaryColor);
		mPrimaryProgressPaint.setDither(true);
		mPrimaryProgressPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mPrimaryProgressPaint.setAntiAlias(true);
		mPrimaryProgressPaint.setStrokeWidth(toDp(mStrokeWidth));
		mPrimaryProgressPaint.setStyle(Paint.Style.STROKE);
	}

	/**
	 * Sets a listener's callback to listen when the progress is changed
	 * @param _listener the callback to be invoked when the progress is changed.
	 */
	public void setOnProgressChangeListener(OnProgressChangeListener _listener) {
		mOnChangeListener = _listener;
	}
	


	/**
	 * Sets the maximum progress value. Default is 100.
	 * @param max
	 */
	public void setMax( int max ) {
		if( max < 0 ) {
			max = 0;
		}
		mMax = max;
	}
	
	/**
	 * Returns the maximum progress value.
	 */
	public int getMax() {
		return mMax;
	}
	
	/**
	 * Sets the current progress value.
	 * @param progress 
	 */
	public void setProgress( int progress ) {
		if( progress > mMax) {
			progress = mMax;
		}
		mProgress = progress;
		if( mOnChangeListener != null ) {
			mOnChangeListener.onProgressChange(mMax, progress, getRateOfProgress());
		}
		invalidate();
	}
	
	/**
	 * Returns the current progress value.
	 */
	public int getProgress() {
		return mProgress;
	}
	
	/**
	 * Sets the secondary progress color.
	 */
	public void setBackgroundColor( int color ) {
		mBackgroundColor = color;
		mSecondaryProgressPaint.setColor(mBackgroundColor);
	}
	
	/**
	 * Sets the primary progress color.
	 */
	public void setPrimaryColor( int color ) {
		mPrimaryColor = color;
		mPrimaryProgressPaint.setColor(mPrimaryColor);
	}
	
	/**
	 * Sets the width of the progress bar in Pixels
	 * @param width
	 */
	public void setCircleWidth(float width) {
		mStrokeWidth = toDp(width);
		mSecondaryProgressPaint.setStrokeWidth(mStrokeWidth);
		mPrimaryProgressPaint.setStrokeWidth(mStrokeWidth);
	}

	@Override
	protected synchronized void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int halfWidth = getWidth() / 2;
		int halfHeight = getHeight() /2;
		int radius = halfWidth < halfHeight ? halfWidth : halfHeight;
		float halfStrokeWidth = mStrokeWidth / 2;
		
		// Draw the Secondary Progress circle first.
		canvas.drawCircle(halfWidth, halfHeight, radius - halfStrokeWidth, mSecondaryProgressPaint);
		
		// Draw the Primary Progress arc over the secondary progress circle.
		mRectF.top = halfHeight - radius + halfStrokeWidth;
		mRectF.bottom = halfHeight + radius - halfStrokeWidth;
		mRectF.left = halfWidth - radius + halfStrokeWidth;
		mRectF.right = halfWidth + radius - halfStrokeWidth;
		canvas.drawArc(mRectF, -90, getRateOfProgress() * 360, false, mPrimaryProgressPaint);
	}
	
	/**
	 * Returns the Rate of Progress with respect to the Maximum and current progress.
	 */
	private float getRateOfProgress() {
		return (float)mProgress / mMax;
	}

	private float toDp(float pixels) {
		DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
		float density = metrics.density;

		return (pixels / density);
	}

}