package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.e;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;
import t.C1573a;

/* compiled from: TouchResponse.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: v, reason: collision with root package name */
    public static final float[][] f8170v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: w, reason: collision with root package name */
    public static final float[][] f8171w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: m, reason: collision with root package name */
    public float f8184m;

    /* renamed from: n, reason: collision with root package name */
    public float f8185n;

    /* renamed from: o, reason: collision with root package name */
    public final MotionLayout f8186o;

    /* renamed from: a, reason: collision with root package name */
    public int f8172a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f8173b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f8174c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f8175d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f8176e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f8177f = -1;

    /* renamed from: g, reason: collision with root package name */
    public float f8178g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    public float f8179h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    public float f8180i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f8181j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8182k = false;

    /* renamed from: l, reason: collision with root package name */
    public float[] f8183l = new float[2];

    /* renamed from: p, reason: collision with root package name */
    public float f8187p = 4.0f;

    /* renamed from: q, reason: collision with root package name */
    public float f8188q = 1.2f;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8189r = true;

    /* renamed from: s, reason: collision with root package name */
    public float f8190s = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    public int f8191t = 0;

    /* renamed from: u, reason: collision with root package name */
    public float f8192u = 10.0f;

    /* compiled from: TouchResponse.java */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public b(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f8186o = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    public float a(float f10, float f11) {
        return (f10 * this.f8180i) + (f11 * this.f8181j);
    }

    public final void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index == e.f9124j7) {
                this.f8175d = typedArray.getResourceId(index, this.f8175d);
            } else if (index == e.f9134k7) {
                int i11 = typedArray.getInt(index, this.f8172a);
                this.f8172a = i11;
                float[] fArr = f8170v[i11];
                this.f8179h = fArr[0];
                this.f8178g = fArr[1];
            } else if (index == e.f9034a7) {
                int i12 = typedArray.getInt(index, this.f8173b);
                this.f8173b = i12;
                float[] fArr2 = f8171w[i12];
                this.f8180i = fArr2[0];
                this.f8181j = fArr2[1];
            } else if (index == e.f9084f7) {
                this.f8187p = typedArray.getFloat(index, this.f8187p);
            } else if (index == e.f9074e7) {
                this.f8188q = typedArray.getFloat(index, this.f8188q);
            } else if (index == e.f9094g7) {
                this.f8189r = typedArray.getBoolean(index, this.f8189r);
            } else if (index == e.f9044b7) {
                this.f8190s = typedArray.getFloat(index, this.f8190s);
            } else if (index == e.f9054c7) {
                this.f8192u = typedArray.getFloat(index, this.f8192u);
            } else if (index == e.f9144l7) {
                this.f8176e = typedArray.getResourceId(index, this.f8176e);
            } else if (index == e.f9114i7) {
                this.f8174c = typedArray.getInt(index, this.f8174c);
            } else if (index == e.f9104h7) {
                this.f8191t = typedArray.getInteger(index, 0);
            } else if (index == e.f9064d7) {
                this.f8177f = typedArray.getResourceId(index, 0);
            }
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f9024Z6);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public int d() {
        return this.f8191t;
    }

    public RectF e(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f8177f;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public float f() {
        return this.f8188q;
    }

    public float g() {
        return this.f8187p;
    }

    public boolean h() {
        return this.f8189r;
    }

    public float i(float f10, float f11) {
        this.f8186o.M(this.f8175d, this.f8186o.getProgress(), this.f8179h, this.f8178g, this.f8183l);
        float f12 = this.f8180i;
        if (f12 != 0.0f) {
            float[] fArr = this.f8183l;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f10 * f12) / fArr[0];
        }
        float[] fArr2 = this.f8183l;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f11 * this.f8181j) / fArr2[1];
    }

    public RectF j(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f8176e;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public int k() {
        return this.f8176e;
    }

    public void l(MotionEvent motionEvent, MotionLayout.f fVar, int i10, androidx.constraintlayout.motion.widget.a aVar) {
        float f10;
        float f11;
        int i11;
        float f12;
        float f13;
        float f14;
        fVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.f8185n;
                    float rawX = motionEvent.getRawX() - this.f8184m;
                    if (Math.abs((this.f8180i * rawX) + (this.f8181j * rawY)) > this.f8192u || this.f8182k) {
                        float progress = this.f8186o.getProgress();
                        if (!this.f8182k) {
                            this.f8182k = true;
                            this.f8186o.setProgress(progress);
                        }
                        int i12 = this.f8175d;
                        if (i12 != -1) {
                            this.f8186o.M(i12, progress, this.f8179h, this.f8178g, this.f8183l);
                        } else {
                            float min = Math.min(this.f8186o.getWidth(), this.f8186o.getHeight());
                            float[] fArr = this.f8183l;
                            fArr[1] = this.f8181j * min;
                            fArr[0] = min * this.f8180i;
                        }
                        float f15 = this.f8180i;
                        float[] fArr2 = this.f8183l;
                        if (Math.abs(((f15 * fArr2[0]) + (this.f8181j * fArr2[1])) * this.f8190s) < 0.01d) {
                            float[] fArr3 = this.f8183l;
                            fArr3[0] = 0.01f;
                            fArr3[1] = 0.01f;
                        }
                        if (this.f8180i != 0.0f) {
                            f13 = rawX / this.f8183l[0];
                        } else {
                            f13 = rawY / this.f8183l[1];
                        }
                        float max = Math.max(Math.min(progress + f13, 1.0f), 0.0f);
                        if (max != this.f8186o.getProgress()) {
                            this.f8186o.setProgress(max);
                            fVar.e(1000);
                            float d10 = fVar.d();
                            float c10 = fVar.c();
                            if (this.f8180i != 0.0f) {
                                f14 = d10 / this.f8183l[0];
                            } else {
                                f14 = c10 / this.f8183l[1];
                            }
                            this.f8186o.f8038c = f14;
                        } else {
                            this.f8186o.f8038c = 0.0f;
                        }
                        this.f8184m = motionEvent.getRawX();
                        this.f8185n = motionEvent.getRawY();
                        return;
                    }
                    return;
                }
                return;
            }
            this.f8182k = false;
            fVar.e(1000);
            float d11 = fVar.d();
            float c11 = fVar.c();
            float progress2 = this.f8186o.getProgress();
            int i13 = this.f8175d;
            if (i13 != -1) {
                this.f8186o.M(i13, progress2, this.f8179h, this.f8178g, this.f8183l);
            } else {
                float min2 = Math.min(this.f8186o.getWidth(), this.f8186o.getHeight());
                float[] fArr4 = this.f8183l;
                fArr4[1] = this.f8181j * min2;
                fArr4[0] = min2 * this.f8180i;
            }
            float f16 = this.f8180i;
            float[] fArr5 = this.f8183l;
            float f17 = fArr5[0];
            float f18 = fArr5[1];
            if (f16 != 0.0f) {
                f10 = d11 / f17;
            } else {
                f10 = c11 / f18;
            }
            if (!Float.isNaN(f10)) {
                f11 = (f10 / 3.0f) + progress2;
            } else {
                f11 = progress2;
            }
            if (f11 != 0.0f && f11 != 1.0f && (i11 = this.f8174c) != 3) {
                MotionLayout motionLayout = this.f8186o;
                if (f11 < 0.5d) {
                    f12 = 0.0f;
                } else {
                    f12 = 1.0f;
                }
                motionLayout.Z(i11, f12, f10);
                if (0.0f >= progress2 || 1.0f <= progress2) {
                    this.f8186o.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            if (0.0f >= f11 || 1.0f <= f11) {
                this.f8186o.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        this.f8184m = motionEvent.getRawX();
        this.f8185n = motionEvent.getRawY();
        this.f8182k = false;
    }

    public void m(float f10, float f11) {
        float f12;
        float progress = this.f8186o.getProgress();
        if (!this.f8182k) {
            this.f8182k = true;
            this.f8186o.setProgress(progress);
        }
        this.f8186o.M(this.f8175d, progress, this.f8179h, this.f8178g, this.f8183l);
        float f13 = this.f8180i;
        float[] fArr = this.f8183l;
        if (Math.abs((f13 * fArr[0]) + (this.f8181j * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f8183l;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f14 = this.f8180i;
        if (f14 != 0.0f) {
            f12 = (f10 * f14) / this.f8183l[0];
        } else {
            f12 = (f11 * this.f8181j) / this.f8183l[1];
        }
        float max = Math.max(Math.min(progress + f12, 1.0f), 0.0f);
        if (max != this.f8186o.getProgress()) {
            this.f8186o.setProgress(max);
        }
    }

    public void n(float f10, float f11) {
        float f12;
        boolean z10;
        boolean z11 = false;
        this.f8182k = false;
        float progress = this.f8186o.getProgress();
        this.f8186o.M(this.f8175d, progress, this.f8179h, this.f8178g, this.f8183l);
        float f13 = this.f8180i;
        float[] fArr = this.f8183l;
        float f14 = fArr[0];
        float f15 = this.f8181j;
        float f16 = fArr[1];
        float f17 = 0.0f;
        if (f13 != 0.0f) {
            f12 = (f10 * f13) / f14;
        } else {
            f12 = (f11 * f15) / f16;
        }
        if (!Float.isNaN(f12)) {
            progress += f12 / 3.0f;
        }
        if (progress != 0.0f) {
            if (progress != 1.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i10 = this.f8174c;
            if (i10 != 3) {
                z11 = true;
            }
            if (z11 & z10) {
                MotionLayout motionLayout = this.f8186o;
                if (progress >= 0.5d) {
                    f17 = 1.0f;
                }
                motionLayout.Z(i10, f17, f12);
            }
        }
    }

    public void o(float f10, float f11) {
        this.f8184m = f10;
        this.f8185n = f11;
    }

    public void p(boolean z10) {
        if (z10) {
            float[][] fArr = f8171w;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = f8170v;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f8171w;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = f8170v;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = f8170v[this.f8172a];
        this.f8179h = fArr5[0];
        this.f8178g = fArr5[1];
        float[] fArr6 = f8171w[this.f8173b];
        this.f8180i = fArr6[0];
        this.f8181j = fArr6[1];
    }

    public void q(float f10, float f11) {
        this.f8184m = f10;
        this.f8185n = f11;
        this.f8182k = false;
    }

    public void r() {
        View view;
        int i10 = this.f8175d;
        if (i10 != -1) {
            view = this.f8186o.findViewById(i10);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + C1573a.b(this.f8186o.getContext(), this.f8175d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new a());
            nestedScrollView.setOnScrollChangeListener(new C0104b());
        }
    }

    public String toString() {
        return this.f8180i + " , " + this.f8181j;
    }

    /* compiled from: TouchResponse.java */
    /* renamed from: androidx.constraintlayout.motion.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0104b implements NestedScrollView.e {
        public C0104b() {
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        }
    }
}
