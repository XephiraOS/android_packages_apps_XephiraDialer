package com.oua.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.oua.util.Transform;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* loaded from: classes4.dex */
public class BitmapUtil {
    private static final String TAG = "com.oua.util.BitmapUtil";

    public static Bitmap convert(Bitmap bitmap, Bitmap.Config config) {
        if (bitmap.getConfig().equals(config)) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap cropResizeRotatePad(Bitmap bitmap, Rect rect, int i10, Transform.PaddingOption paddingOption, Size size, Transform.TransformGroup transformGroup) {
        List<Transform> createTransforms = Transform.createTransforms(new Size(bitmap.getWidth(), bitmap.getHeight()), rect, size, paddingOption, i10);
        if (transformGroup == null) {
            transformGroup = new Transform.TransformGroup();
        }
        transformGroup.transforms = (List) createTransforms.stream().filter(new Predicate() { // from class: com.oua.util.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$cropResizeRotatePad$1;
                lambda$cropResizeRotatePad$1 = BitmapUtil.lambda$cropResizeRotatePad$1((Transform) obj);
                return lambda$cropResizeRotatePad$1;
            }
        }).collect(Collectors.toList());
        Size dstSize = transformGroup.getDstSize();
        if (rect == null) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        if (i10 == 0) {
            Bitmap createBitmap = Bitmap.createBitmap(dstSize.getWidth(), dstSize.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Rect calcValidRect = transformGroup.calcValidRect();
            if (paddingOption != null) {
                canvas.drawColor(Color.rgb(0, 0, 0));
            }
            canvas.drawBitmap(bitmap, rect, calcValidRect, (Paint) null);
            return createBitmap;
        }
        Matrix matrix = new Matrix();
        Transform.TransformScale transformScale = (Transform.TransformScale) createTransforms.get(1);
        if (transformScale != null) {
            matrix.postScale((float) transformScale.scaleX, (float) transformScale.scaleY);
        }
        matrix.postRotate(i10);
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
        if (paddingOption != null) {
            Bitmap createBitmap3 = Bitmap.createBitmap(dstSize.getWidth(), dstSize.getHeight(), createBitmap2.getConfig());
            Canvas canvas2 = new Canvas(createBitmap3);
            canvas2.drawColor(Color.rgb(0, 0, 0));
            canvas2.drawBitmap(createBitmap2, new Rect(0, 0, createBitmap2.getWidth(), createBitmap2.getHeight()), transformGroup.calcValidRect(), (Paint) null);
            return createBitmap3;
        }
        return createBitmap2;
    }

    public static void drawText(final Context context, Bitmap bitmap, final List<String> list, final List<Rect> list2, final int i10, final Typeface typeface) {
        Canvas canvas = new Canvas(bitmap);
        final FrameLayout frameLayout = new FrameLayout(context);
        IntStream.range(0, list2.size()).forEach(new IntConsumer() { // from class: com.oua.util.f
            @Override // java.util.function.IntConsumer
            public final void accept(int i11) {
                BitmapUtil.lambda$drawText$0(context, i10, typeface, list, list2, frameLayout, i11);
            }
        });
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(bitmap.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(bitmap.getHeight(), 1073741824));
        frameLayout.layout(0, 0, bitmap.getWidth(), bitmap.getHeight());
        frameLayout.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$cropResizeRotatePad$1(Transform transform) {
        if (transform != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$drawText$0(Context context, int i10, Typeface typeface, List list, List list2, FrameLayout frameLayout, int i11) {
        TextView textView = new TextView(context);
        textView.setVisibility(0);
        textView.setTextColor(i10);
        textView.setSingleLine(false);
        textView.setAutoSizeTextTypeUniformWithConfiguration(10, 64, 2, 0);
        textView.setTypeface(typeface);
        if (list != null && i11 < list.size()) {
            textView.setText((CharSequence) list.get(i11));
        }
        Rect rect = (Rect) list2.get(i11);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        frameLayout.addView(textView, layoutParams);
    }

    public static Bitmap loadBitmapFromAsset(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.outConfig = Bitmap.Config.ARGB_8888;
            return BitmapFactory.decodeStream(open, null, options);
        } catch (IOException e10) {
            Log.e(TAG, "Failed to read image file. " + e10);
            return null;
        }
    }

    public static Rect move(Rect rect, int i10, int i11) {
        return new Rect(rect.left + i10, rect.top + i11, rect.right + i10, rect.bottom + i11);
    }

    public static Bitmap resize(Bitmap bitmap, Size size, Transform.TransformGroup transformGroup) {
        return cropResizeRotatePad(bitmap, null, 0, null, size, transformGroup);
    }

    public static Bitmap resizeAndCrop(Bitmap bitmap, Rect rect, Size size, Transform.TransformGroup transformGroup) {
        return cropResizeRotatePad(bitmap, rect, 0, null, size, transformGroup);
    }

    public static Bitmap resizeAndPad(Bitmap bitmap, Size size, Transform.PaddingOption paddingOption, Transform.TransformGroup transformGroup) {
        return cropResizeRotatePad(bitmap, null, 0, paddingOption, size, transformGroup);
    }

    public static Bitmap rotate(Bitmap bitmap, float f10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void saveToFile(Bitmap bitmap, String str) {
        saveToFile(bitmap, str, 100);
    }

    public static void saveToFile(Bitmap bitmap, String str, int i10) {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str)));
            if (FileUtil.getExt(str).equalsIgnoreCase("png")) {
                bitmap.compress(Bitmap.CompressFormat.PNG, i10, bufferedOutputStream);
            } else if (FileUtil.getExt(str).equalsIgnoreCase("webp")) {
                bitmap.compress(Bitmap.CompressFormat.WEBP, i10, bufferedOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i10, bufferedOutputStream);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
            throw new RuntimeException("cannot save result to " + str);
        }
    }
}
