package com.customize.contacts.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class ColorRoundLocalImageView extends COUIRoundImageView {

    /* renamed from: a, reason: collision with root package name */
    public int f22280a;

    public ColorRoundLocalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22280a = Integer.MAX_VALUE;
        this.f22280a = getContext().getResources().getDimensionPixelOffset(R.dimen.color_detail_photo_size);
    }

    public final Bitmap g(Bitmap bitmap, int i10, int i11) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(i10 / width, i11 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    @Override // com.coui.appcompat.imageview.COUIRoundImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelOffset(R.dimen.color_detail_photo_size), 1073741824), View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelOffset(R.dimen.color_detail_photo_size), 1073741824));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null && bitmap.getHeight() == bitmap.getWidth()) {
            int height = bitmap.getHeight();
            int i10 = this.f22280a;
            if (height > i10) {
                bitmap = g(bitmap, i10, i10);
            }
        }
        super.setImageBitmap(bitmap);
    }

    @Override // com.coui.appcompat.imageview.COUIRoundImageView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        if (i10 == Z0.b.d(false, false)) {
            return;
        }
        super.setImageResource(i10);
    }
}
