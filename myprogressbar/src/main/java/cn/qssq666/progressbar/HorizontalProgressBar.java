package cn.qssq666.progressbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import cn.qssq666.myprogressbar.R;

/**
 * Created by qssq on 2018/4/20 qssq666@foxmail.com
 * /
 */
public class HorizontalProgressBar extends View {


    private static final String TAG = "QssqProgressBar";
    private int mProgress = 0;
    private Paint mPaint;
    private float mMaxProgress = 100;
    private int factorSize=5;

    public @interface ProgressStyleMode {
    }

    public static final int NORMAL = 0;
    public static final int SPLASH = 1;
    private int mProgressStyle;

    public void setProgressStyle(@ProgressStyleMode int mProgressStyle) {
        this.mProgressStyle = mProgressStyle;
        invalidate();
    }

    public int getProgressColor() {
        return mProgressColor;
    }

    public void setProgressColor(@ColorInt int mProgressColor) {
        this.mProgressColor = mProgressColor;
        mPaint.setColor(mProgressColor);
        invalidate();
    }

    int mProgressColor = Color.WHITE;

    public HorizontalProgressBar(Context context) {
        this(context, null);
    }


    public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs, 0);
        init(context, attrs, 0, 0);
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        init(context, attrs, defStyleAttr, defStyleAttr);
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public HorizontalProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }


    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyleAttr, int styleRes) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth((float) 4.0); // 线宽
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//填充矩形实心
        factorSize = dip2px(context, 6);

        if (attributeSet != null) {
            Resources.Theme theme = context.getTheme();

            TypedArray typedArray = theme.obtainStyledAttributes(attributeSet, R.styleable.HorizontalProgressBar, defStyleAttr, styleRes);
            this.mProgressColor = typedArray.getColor(R.styleable.HorizontalProgressBar_progressColor, Color.WHITE);  //TODO  出现问题了设置不生效
            this.mProgress = typedArray.getInt(R.styleable.HorizontalProgressBar_progress, 0);
            this.mProgressStyle = typedArray.getInt(R.styleable.HorizontalProgressBar_progressStyle, NORMAL);
            this.mMaxProgress = typedArray.getColor(R.styleable.HorizontalProgressBar_maxProgress, 100);
            typedArray.recycle();
            mPaint.setColor(mProgressColor);
        } else {
            mPaint.setColor(Color.WHITE);
            setBackgroundColor(Color.DKGRAY);

        }
            postInvalidate();

    }

    public void setProgress(int progress) {
        this.mProgress = progress;
        Log.w(TAG, "call setProgress:" + progress);
        postInvalidate();
    }


    int left = 0;
    int right = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(Color.WHITE);
        if (mProgressStyle == SPLASH && this.mProgress <= 0) {
            if (left <= 0 || right >= getMeasuredWidth()) {

                left = (getMeasuredWidth() / 2) - factorSize;
                right = (getMeasuredWidth() / 2) + factorSize;
            } else {
                left -= factorSize;
                right += factorSize;
            }

            canvas.drawRect(left, 0, right, getHeight(), mPaint);
            invalidate();
        } else {
            int shouldSetWidth = (int) ((getMeasuredWidth() / mMaxProgress) * mProgress);
            canvas.drawRect(0, 0, shouldSetWidth, getHeight(), mPaint);
            Log.w(TAG, "绘制矩形:" + left + ",right:" + right + "," + shouldSetWidth + ",maxProgress"+mMaxProgress+",progress:"+mProgress+",width:"+getMeasuredWidth());

        }
    }
}
