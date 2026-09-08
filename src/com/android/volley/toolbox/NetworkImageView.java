package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;
import com.android.volley.d;

/* loaded from: classes.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public String f19265a;

    /* renamed from: b, reason: collision with root package name */
    public int f19266b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f19267c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f19268d;

    /* renamed from: e, reason: collision with root package name */
    public int f19269e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f19270f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f19271g;

    /* loaded from: classes.dex */
    public class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19272a;

        public a(boolean z10) {
            this.f19272a = z10;
        }

        @Override // com.android.volley.d.a
        public void b(VolleyError volleyError) {
            if (NetworkImageView.this.f19269e != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f19269e);
            } else if (NetworkImageView.this.f19270f != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f19270f);
            } else if (NetworkImageView.this.f19271g != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f19271g);
            }
        }
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void d(boolean z10) {
        boolean z11;
        boolean z12;
        int width = getWidth();
        int height = getHeight();
        getScaleType();
        boolean z13 = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width == -2) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (getLayoutParams().height == -2) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            z11 = false;
            z12 = false;
        }
        if (!z11 || !z12) {
            z13 = false;
        }
        if (width == 0 && height == 0 && !z13) {
            return;
        }
        if (TextUtils.isEmpty(this.f19265a)) {
            e();
        } else {
            new a(z10);
            throw null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final void e() {
        int i10 = this.f19266b;
        if (i10 != 0) {
            setImageResource(i10);
            return;
        }
        Drawable drawable = this.f19267c;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.f19268d;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        d(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.f19266b = 0;
        this.f19267c = null;
        this.f19268d = bitmap;
    }

    public void setDefaultImageDrawable(Drawable drawable) {
        this.f19266b = 0;
        this.f19268d = null;
        this.f19267c = drawable;
    }

    public void setDefaultImageResId(int i10) {
        this.f19268d = null;
        this.f19267c = null;
        this.f19266b = i10;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.f19269e = 0;
        this.f19270f = null;
        this.f19271g = bitmap;
    }

    public void setErrorImageDrawable(Drawable drawable) {
        this.f19269e = 0;
        this.f19271g = null;
        this.f19270f = drawable;
    }

    public void setErrorImageResId(int i10) {
        this.f19271g = null;
        this.f19270f = null;
        this.f19269e = i10;
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
