package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.e;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public c f8579a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8580b;

    /* renamed from: c, reason: collision with root package name */
    public float f8581c;

    /* renamed from: d, reason: collision with root package name */
    public float f8582d;

    /* renamed from: e, reason: collision with root package name */
    public float f8583e;

    /* renamed from: f, reason: collision with root package name */
    public Path f8584f;

    /* renamed from: g, reason: collision with root package name */
    public ViewOutlineProvider f8585g;

    /* renamed from: h, reason: collision with root package name */
    public RectF f8586h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable[] f8587i;

    /* renamed from: j, reason: collision with root package name */
    public LayerDrawable f8588j;

    /* loaded from: classes.dex */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f8582d) / 2.0f);
        }
    }

    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f8583e);
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float[] f8591a = new float[20];

        /* renamed from: b, reason: collision with root package name */
        public ColorMatrix f8592b = new ColorMatrix();

        /* renamed from: c, reason: collision with root package name */
        public ColorMatrix f8593c = new ColorMatrix();

        /* renamed from: d, reason: collision with root package name */
        public float f8594d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f8595e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f8596f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f8597g = 1.0f;

        public final void a(float f10) {
            float[] fArr = this.f8591a;
            fArr[0] = f10;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f10;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void b(float f10) {
            float f11 = 1.0f - f10;
            float f12 = 0.2999f * f11;
            float f13 = 0.587f * f11;
            float f14 = f11 * 0.114f;
            float[] fArr = this.f8591a;
            fArr[0] = f12 + f10;
            fArr[1] = f13;
            fArr[2] = f14;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f12;
            fArr[6] = f13 + f10;
            fArr[7] = f14;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f12;
            fArr[11] = f13;
            fArr[12] = f14 + f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void c(ImageView imageView) {
            boolean z10;
            this.f8592b.reset();
            float f10 = this.f8595e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                b(f10);
                this.f8592b.set(this.f8591a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f8596f;
            if (f11 != 1.0f) {
                this.f8593c.setScale(f11, f11, f11, 1.0f);
                this.f8592b.postConcat(this.f8593c);
                z10 = true;
            }
            float f12 = this.f8597g;
            if (f12 != 1.0f) {
                d(f12);
                this.f8593c.set(this.f8591a);
                this.f8592b.postConcat(this.f8593c);
            } else {
                z11 = z10;
            }
            float f13 = this.f8594d;
            if (f13 != 1.0f) {
                a(f13);
                this.f8593c.set(this.f8591a);
                this.f8592b.postConcat(this.f8593c);
            } else if (!z11) {
                imageView.clearColorFilter();
                return;
            }
            imageView.setColorFilter(new ColorMatrixColorFilter(this.f8592b));
        }

        public final void d(float f10) {
            float log;
            float f11;
            float f12;
            if (f10 <= 0.0f) {
                f10 = 0.01f;
            }
            float f13 = (5000.0f / f10) / 100.0f;
            if (f13 > 66.0f) {
                double d10 = f13 - 60.0f;
                f11 = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d10, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f13)) * 99.4708f) - 161.11957f;
                f11 = 255.0f;
            }
            if (f13 < 66.0f) {
                if (f13 > 19.0f) {
                    f12 = (((float) Math.log(f13 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f12 = 0.0f;
                }
            } else {
                f12 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f11, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f12, 0.0f));
            float log2 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log3 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log2, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max(log3, 0.0f));
            float[] fArr = this.f8591a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8579a = new c();
        this.f8580b = true;
        this.f8581c = 0.0f;
        this.f8582d = 0.0f;
        this.f8583e = Float.NaN;
        i(context, attributeSet);
    }

    private void i(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f9205s3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(e.f9214t3);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9232v3) {
                    this.f8581c = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == e.f8796A3) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == e.f9268z3) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == e.f9223u3) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == e.f9250x3) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == e.f9259y3) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == e.f9241w3) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f8580b));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f8587i = drawableArr;
                drawableArr[0] = getDrawable();
                this.f8587i[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f8587i);
                this.f8588j = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f8581c * 255.0f));
                super.setImageDrawable(this.f8588j);
            }
        }
    }

    private void setOverlay(boolean z10) {
        this.f8580b = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f8579a.f8594d;
    }

    public float getContrast() {
        return this.f8579a.f8596f;
    }

    public float getCrossfade() {
        return this.f8581c;
    }

    public float getRound() {
        return this.f8583e;
    }

    public float getRoundPercent() {
        return this.f8582d;
    }

    public float getSaturation() {
        return this.f8579a.f8595e;
    }

    public float getWarmth() {
        return this.f8579a.f8597g;
    }

    public void setBrightness(float f10) {
        c cVar = this.f8579a;
        cVar.f8594d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        c cVar = this.f8579a;
        cVar.f8596f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f8581c = f10;
        if (this.f8587i != null) {
            if (!this.f8580b) {
                this.f8588j.getDrawable(0).setAlpha((int) ((1.0f - this.f8581c) * 255.0f));
            }
            this.f8588j.getDrawable(1).setAlpha((int) (this.f8581c * 255.0f));
            super.setImageDrawable(this.f8588j);
        }
    }

    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.f8583e = f10;
            float f11 = this.f8582d;
            this.f8582d = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.f8583e != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f8583e = f10;
        if (f10 != 0.0f) {
            if (this.f8584f == null) {
                this.f8584f = new Path();
            }
            if (this.f8586h == null) {
                this.f8586h = new RectF();
            }
            if (this.f8585g == null) {
                b bVar = new b();
                this.f8585g = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f8586h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f8584f.reset();
            Path path = this.f8584f;
            RectF rectF = this.f8586h;
            float f12 = this.f8583e;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10;
        if (this.f8582d != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f8582d = f10;
        if (f10 != 0.0f) {
            if (this.f8584f == null) {
                this.f8584f = new Path();
            }
            if (this.f8586h == null) {
                this.f8586h = new RectF();
            }
            if (this.f8585g == null) {
                a aVar = new a();
                this.f8585g = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f8582d) / 2.0f;
            this.f8586h.set(0.0f, 0.0f, width, height);
            this.f8584f.reset();
            this.f8584f.addRoundRect(this.f8586h, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        c cVar = this.f8579a;
        cVar.f8595e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        c cVar = this.f8579a;
        cVar.f8597g = f10;
        cVar.c(this);
    }
}
