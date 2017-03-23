package org.caworks.ca1.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.LinearLayout;

import org.caworks.android.widget.R;


/**
 * Created by Administrator on 2017/3/23 0023.
 */

public class IndicatorView extends LinearLayout {

    private Context context;
    private Paint paint;
    private int markerId;
    private Bitmap marker;

    private int indicatorValue = 0; //默认AQI值
    private int textSize = 6; //默认文字大小
    private int intervalValue = 1; //TextView之间的间隔大小,单位dp
    private int textColorId = R.color.indicator_text_color; //默认文字颜色
    private int textColor;
    private int indicatorStringsResourceId = R.array.indicator_strings;
    private int indicatorColorsResourceId = R.array.indicator_colors;

    private int indicatorViewWidth; //IndicatorView宽度
    private int indicatorViewHeight; //IndicatorView高度

    private int paddingTopInXML;

    private String[] indicatorStrings;
    int[] indicatorColorIds;

    public IndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * View initialization
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        this.setOrientation(LinearLayout.HORIZONTAL);
        //开启绘图缓存,提高绘图效率
        this.setDrawingCacheEnabled(true);

        initPaint();
        initAttrs(attrs);
        fillViewToParent(context);

        this.setWillNotDraw(false); //确保onDraw()被调用

        this.paddingTopInXML = this.getPaddingTop();
        this.setPadding(this.getPaddingLeft() + this.marker.getWidth() / 2,
                this.getPaddingTop() + this.marker.getHeight(),
                this.getPaddingRight() + this.marker.getWidth() / 2,
                this.getPaddingBottom());
    }

    /**
     * Paint initialization
     */
    private void initPaint() {
        this.paint = new Paint();
        //设置是否使用抗锯齿功能,会消耗较大资源,绘制图形速度会变慢
        this.paint.setAntiAlias(true);
        //设定是否使用图像抖动处理,会使绘制出来的图片颜色更加平滑和饱满,图像更加清晰
        this.paint.setDither(true);
    }

    /**
     * Get custom attrs
     * @param attrs
     */
    private void initAttrs(AttributeSet attrs) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSize, dm);
        this.intervalValue = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, intervalValue, dm);

        //重新获得context’ theme  styled attribute
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IndicatorView);
        this.markerId = typedArray.getResourceId(R.styleable.IndicatorView_marker, R.drawable.ic_vector_indicator_down);
        this.marker = drawableToBitmap(createVectorDrawable());

    }

    private void fillViewToParent(Context context) {
    }

    private Drawable createVectorDrawable(int drawableId, int color) {
        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(getResources(), drawableId, context.getTheme());
        if (vectorDrawableCompat == null)
            throw new NullPointerException("vectorDrawable can't be null");
        DrawableCompat.setTint(vectorDrawableCompat, color);
        DrawableCompat.setTintMode(vectorDrawableCompat, PorterDuff.Mode.SRC_IN);

        return vectorDrawableCompat;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                    Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

}
