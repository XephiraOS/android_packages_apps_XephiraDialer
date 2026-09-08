package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.e;

/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a, reason: collision with root package name */
    public ImageFilterView.c f8567a;

    /* renamed from: b, reason: collision with root package name */
    public float f8568b;

    /* renamed from: c, reason: collision with root package name */
    public float f8569c;

    /* renamed from: d, reason: collision with root package name */
    public float f8570d;

    /* renamed from: e, reason: collision with root package name */
    public Path f8571e;

    /* renamed from: f, reason: collision with root package name */
    public ViewOutlineProvider f8572f;

    /* renamed from: g, reason: collision with root package name */
    public RectF f8573g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable[] f8574h;

    /* renamed from: i, reason: collision with root package name */
    public LayerDrawable f8575i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8576j;

    /* loaded from: classes.dex */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.f8569c) / 2.0f);
        }
    }

    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f8570d);
        }
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8567a = new ImageFilterView.c();
        this.f8568b = 0.0f;
        this.f8569c = 0.0f;
        this.f8570d = Float.NaN;
        this.f8576j = true;
        c(context, attributeSet);
    }

    private void setOverlay(boolean z10) {
        this.f8576j = z10;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f9205s3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(e.f9214t3);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == e.f9232v3) {
                    this.f8568b = obtainStyledAttributes.getFloat(index, 0.0f);
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
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f8576j));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f8574h = drawableArr;
                drawableArr[0] = getDrawable();
                this.f8574h[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f8574h);
                this.f8575i = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f8568b * 255.0f));
                super.setImageDrawable(this.f8575i);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f8567a.f8596f;
    }

    public float getCrossfade() {
        return this.f8568b;
    }

    public float getRound() {
        return this.f8570d;
    }

    public float getRoundPercent() {
        return this.f8569c;
    }

    public float getSaturation() {
        return this.f8567a.f8595e;
    }

    public float getWarmth() {
        return this.f8567a.f8597g;
    }

    public void setBrightness(float f10) {
        ImageFilterView.c cVar = this.f8567a;
        cVar.f8594d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        ImageFilterView.c cVar = this.f8567a;
        cVar.f8596f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f8568b = f10;
        if (this.f8574h != null) {
            if (!this.f8576j) {
                this.f8575i.getDrawable(0).setAlpha((int) ((1.0f - this.f8568b) * 255.0f));
            }
            this.f8575i.getDrawable(1).setAlpha((int) (this.f8568b * 255.0f));
            super.setImageDrawable(this.f8575i);
        }
    }

    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.f8570d = f10;
            float f11 = this.f8569c;
            this.f8569c = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.f8570d != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f8570d = f10;
        if (f10 != 0.0f) {
            if (this.f8571e == null) {
                this.f8571e = new Path();
            }
            if (this.f8573g == null) {
                this.f8573g = new RectF();
            }
            if (this.f8572f == null) {
                b bVar = new b();
                this.f8572f = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f8573g.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f8571e.reset();
            Path path = this.f8571e;
            RectF rectF = this.f8573g;
            float f12 = this.f8570d;
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
        if (this.f8569c != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f8569c = f10;
        if (f10 != 0.0f) {
            if (this.f8571e == null) {
                this.f8571e = new Path();
            }
            if (this.f8573g == null) {
                this.f8573g = new RectF();
            }
            if (this.f8572f == null) {
                a aVar = new a();
                this.f8572f = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f8569c) / 2.0f;
            this.f8573g.set(0.0f, 0.0f, width, height);
            this.f8571e.reset();
            this.f8571e.addRoundRect(this.f8573g, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        ImageFilterView.c cVar = this.f8567a;
        cVar.f8595e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        ImageFilterView.c cVar = this.f8567a;
        cVar.f8597g = f10;
        cVar.c(this);
    }
}
