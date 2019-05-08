package com.example.immanuel.flashtalk;

/**
 * Created by Immanuel on 2/4/19.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircularImageView extends ImageView {

    Context cont;

    public CircularImageView(Context context) {
        super(context);
        cont=context;
    }

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        cont=context;
    }

    public CircularImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        cont=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();

        Bitmap roundBitmap = getRoundBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);

    }

    public Bitmap getRoundBitmap(Bitmap bmp, int radius) {
        Bitmap sBmp;

        if (bmp.getWidth() != radius || bmp.getHeight() != radius) {
            float smallest = Math.min(bmp.getWidth(), bmp.getHeight());
            float factor = smallest / radius;
            sBmp = Bitmap.createScaledBitmap(bmp, (int) (bmp.getWidth() / factor), (int) (bmp.getHeight() / factor), false);
        } else {
            sBmp = bmp;
        }

        Bitmap output = Bitmap.createBitmap(radius, radius,
                Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(output);

        final String color = "#000000";
        final Paint paint = new Paint();
        final Paint stroke = new Paint();
        final Rect rect = new Rect(0, 0, radius, radius);

        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        stroke.setAntiAlias(true);
        stroke.setFilterBitmap(true);
        stroke.setDither(true);

        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor(color));
        stroke.setColor(Color.parseColor("#3CB371"));
        stroke.setStyle(Paint.Style.STROKE);
        //Toast.makeText(bmp.getClass(),Toast.LENGTH_LONG).show();

        int x=cont.getResources().getInteger(R.integer.circular_image_view_width);
        stroke.setStrokeWidth((float)x);

        canvas.drawCircle(radius / 2 + 0.5f, radius / 2 + 0.5f, radius / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sBmp, rect, rect, paint);

        canvas.drawCircle(radius / 2 + 0.5f,
                radius / 2 + 0.5f, radius / 2 - stroke.getStrokeWidth()/2 +0.1f, stroke);




        return output;
    }
}