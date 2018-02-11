package com.vladkrutlekto.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends AppCompatImageView {
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(modeDST_IN);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        image = BitmapFactory.decodeResource(getResources(), resId);
    }

    RectF rectF;
    Rect rect;

    Paint paint;
    Bitmap mask;

    Bitmap image;

    PorterDuffXfermode modeDST_IN = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    int w, h, radius = 120;

    public DrawView(Context context) {
        super(context);

        // необходимо для корректной работы
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    private void init() {
        w = getWidth();
        h = getHeight();

        mask = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mask);

        final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        setLayerType(LAYER_TYPE_HARDWARE, paint);
        rectF = new RectF(0, 0, w, h);
        canvas.drawRoundRect(rectF, radius, radius, paint);

        rect = new Rect(0, 0, w, radius);
        canvas.drawRect(rect, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        super.onDraw(canvas);
        canvas.drawBitmap(mask, null, rectF, paint);
    }
}
