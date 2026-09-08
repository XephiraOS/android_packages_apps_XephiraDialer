package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.view.InterfaceC0468x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import t.C1573a;
import t.C1574b;
import t.n;
import t.o;
import v.C1616b;
import v.InterfaceC1615a;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements InterfaceC0468x {

    /* renamed from: v0, reason: collision with root package name */
    public static boolean f8010v0;

    /* renamed from: A, reason: collision with root package name */
    public float f8011A;

    /* renamed from: B, reason: collision with root package name */
    public int f8012B;

    /* renamed from: C, reason: collision with root package name */
    public d f8013C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f8014D;

    /* renamed from: E, reason: collision with root package name */
    public s.g f8015E;

    /* renamed from: F, reason: collision with root package name */
    public c f8016F;

    /* renamed from: G, reason: collision with root package name */
    public C1574b f8017G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f8018H;

    /* renamed from: I, reason: collision with root package name */
    public int f8019I;

    /* renamed from: J, reason: collision with root package name */
    public int f8020J;

    /* renamed from: K, reason: collision with root package name */
    public int f8021K;

    /* renamed from: L, reason: collision with root package name */
    public int f8022L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f8023M;

    /* renamed from: N, reason: collision with root package name */
    public float f8024N;

    /* renamed from: O, reason: collision with root package name */
    public float f8025O;

    /* renamed from: P, reason: collision with root package name */
    public long f8026P;

    /* renamed from: Q, reason: collision with root package name */
    public float f8027Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f8028R;

    /* renamed from: S, reason: collision with root package name */
    public ArrayList<MotionHelper> f8029S;

    /* renamed from: T, reason: collision with root package name */
    public ArrayList<MotionHelper> f8030T;

    /* renamed from: U, reason: collision with root package name */
    public ArrayList<i> f8031U;

    /* renamed from: V, reason: collision with root package name */
    public int f8032V;

    /* renamed from: W, reason: collision with root package name */
    public long f8033W;

    /* renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.motion.widget.a f8034a;

    /* renamed from: a0, reason: collision with root package name */
    public float f8035a0;

    /* renamed from: b, reason: collision with root package name */
    public Interpolator f8036b;

    /* renamed from: b0, reason: collision with root package name */
    public int f8037b0;

    /* renamed from: c, reason: collision with root package name */
    public float f8038c;

    /* renamed from: c0, reason: collision with root package name */
    public float f8039c0;

    /* renamed from: d, reason: collision with root package name */
    public int f8040d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f8041d0;

    /* renamed from: e, reason: collision with root package name */
    public int f8042e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f8043e0;

    /* renamed from: f, reason: collision with root package name */
    public int f8044f;

    /* renamed from: f0, reason: collision with root package name */
    public int f8045f0;

    /* renamed from: g, reason: collision with root package name */
    public int f8046g;

    /* renamed from: g0, reason: collision with root package name */
    public int f8047g0;

    /* renamed from: h, reason: collision with root package name */
    public int f8048h;

    /* renamed from: h0, reason: collision with root package name */
    public int f8049h0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8050i;

    /* renamed from: i0, reason: collision with root package name */
    public int f8051i0;

    /* renamed from: j, reason: collision with root package name */
    public HashMap<View, n> f8052j;

    /* renamed from: j0, reason: collision with root package name */
    public int f8053j0;

    /* renamed from: k, reason: collision with root package name */
    public long f8054k;

    /* renamed from: k0, reason: collision with root package name */
    public int f8055k0;

    /* renamed from: l, reason: collision with root package name */
    public float f8056l;

    /* renamed from: l0, reason: collision with root package name */
    public float f8057l0;

    /* renamed from: m, reason: collision with root package name */
    public float f8058m;

    /* renamed from: m0, reason: collision with root package name */
    public t.e f8059m0;

    /* renamed from: n, reason: collision with root package name */
    public float f8060n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f8061n0;

    /* renamed from: o, reason: collision with root package name */
    public long f8062o;

    /* renamed from: o0, reason: collision with root package name */
    public h f8063o0;

    /* renamed from: p, reason: collision with root package name */
    public float f8064p;

    /* renamed from: p0, reason: collision with root package name */
    public TransitionState f8065p0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8066q;

    /* renamed from: q0, reason: collision with root package name */
    public e f8067q0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8068r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f8069r0;

    /* renamed from: s0, reason: collision with root package name */
    public RectF f8070s0;

    /* renamed from: t0, reason: collision with root package name */
    public View f8071t0;

    /* renamed from: u0, reason: collision with root package name */
    public ArrayList<Integer> f8072u0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8073x;

    /* renamed from: y, reason: collision with root package name */
    public i f8074y;

    /* renamed from: z, reason: collision with root package name */
    public float f8075z;

    /* loaded from: classes.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8081a;

        public a(View view) {
            this.f8081a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8081a.setNestedScrollingEnabled(true);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8083a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f8083a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8083a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8083a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8083a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends o {

        /* renamed from: a, reason: collision with root package name */
        public float f8084a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f8085b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f8086c;

        public c() {
        }

        @Override // t.o
        public float a() {
            return MotionLayout.this.f8038c;
        }

        public void b(float f10, float f11, float f12) {
            this.f8084a = f10;
            this.f8085b = f11;
            this.f8086c = f12;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11;
            float f12;
            float f13 = this.f8084a;
            if (f13 > 0.0f) {
                float f14 = this.f8086c;
                if (f13 / f14 < f10) {
                    f10 = f13 / f14;
                }
                MotionLayout.this.f8038c = f13 - (f14 * f10);
                f11 = (f13 * f10) - (((f14 * f10) * f10) / 2.0f);
                f12 = this.f8085b;
            } else {
                float f15 = this.f8086c;
                if ((-f13) / f15 < f10) {
                    f10 = (-f13) / f15;
                }
                MotionLayout.this.f8038c = (f15 * f10) + f13;
                f11 = (f13 * f10) + (((f15 * f10) * f10) / 2.0f);
                f12 = this.f8085b;
            }
            return f11 + f12;
        }
    }

    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public float[] f8088a;

        /* renamed from: b, reason: collision with root package name */
        public int[] f8089b;

        /* renamed from: c, reason: collision with root package name */
        public float[] f8090c;

        /* renamed from: d, reason: collision with root package name */
        public Path f8091d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f8092e;

        /* renamed from: f, reason: collision with root package name */
        public Paint f8093f;

        /* renamed from: g, reason: collision with root package name */
        public Paint f8094g;

        /* renamed from: h, reason: collision with root package name */
        public Paint f8095h;

        /* renamed from: i, reason: collision with root package name */
        public Paint f8096i;

        /* renamed from: j, reason: collision with root package name */
        public float[] f8097j;

        /* renamed from: p, reason: collision with root package name */
        public DashPathEffect f8103p;

        /* renamed from: q, reason: collision with root package name */
        public int f8104q;

        /* renamed from: t, reason: collision with root package name */
        public int f8107t;

        /* renamed from: k, reason: collision with root package name */
        public final int f8098k = -21965;

        /* renamed from: l, reason: collision with root package name */
        public final int f8099l = -2067046;

        /* renamed from: m, reason: collision with root package name */
        public final int f8100m = -13391360;

        /* renamed from: n, reason: collision with root package name */
        public final int f8101n = 1996488704;

        /* renamed from: o, reason: collision with root package name */
        public final int f8102o = 10;

        /* renamed from: r, reason: collision with root package name */
        public Rect f8105r = new Rect();

        /* renamed from: s, reason: collision with root package name */
        public boolean f8106s = false;

        public d() {
            this.f8107t = 1;
            Paint paint = new Paint();
            this.f8092e = paint;
            paint.setAntiAlias(true);
            this.f8092e.setColor(-21965);
            this.f8092e.setStrokeWidth(2.0f);
            Paint paint2 = this.f8092e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f8093f = paint3;
            paint3.setAntiAlias(true);
            this.f8093f.setColor(-2067046);
            this.f8093f.setStrokeWidth(2.0f);
            this.f8093f.setStyle(style);
            Paint paint4 = new Paint();
            this.f8094g = paint4;
            paint4.setAntiAlias(true);
            this.f8094g.setColor(-13391360);
            this.f8094g.setStrokeWidth(2.0f);
            this.f8094g.setStyle(style);
            Paint paint5 = new Paint();
            this.f8095h = paint5;
            paint5.setAntiAlias(true);
            this.f8095h.setColor(-13391360);
            this.f8095h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f8097j = new float[8];
            Paint paint6 = new Paint();
            this.f8096i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f8103p = dashPathEffect;
            this.f8094g.setPathEffect(dashPathEffect);
            this.f8090c = new float[100];
            this.f8089b = new int[50];
            if (this.f8106s) {
                this.f8092e.setStrokeWidth(8.0f);
                this.f8096i.setStrokeWidth(8.0f);
                this.f8093f.setStrokeWidth(8.0f);
                this.f8107t = 4;
            }
        }

        public void a(Canvas canvas, HashMap<View, n> hashMap, int i10, int i11) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i11 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f8044f) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f8095h);
                    canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f8092e);
                }
                for (n nVar : hashMap.values()) {
                    int h10 = nVar.h();
                    if (i11 > 0 && h10 == 0) {
                        h10 = 1;
                    }
                    if (h10 != 0) {
                        this.f8104q = nVar.c(this.f8090c, this.f8089b);
                        if (h10 >= 1) {
                            int i12 = i10 / 16;
                            float[] fArr = this.f8088a;
                            if (fArr == null || fArr.length != i12 * 2) {
                                this.f8088a = new float[i12 * 2];
                                this.f8091d = new Path();
                            }
                            int i13 = this.f8107t;
                            canvas.translate(i13, i13);
                            this.f8092e.setColor(1996488704);
                            this.f8096i.setColor(1996488704);
                            this.f8093f.setColor(1996488704);
                            this.f8094g.setColor(1996488704);
                            nVar.d(this.f8088a, i12);
                            b(canvas, h10, this.f8104q, nVar);
                            this.f8092e.setColor(-21965);
                            this.f8093f.setColor(-2067046);
                            this.f8096i.setColor(-2067046);
                            this.f8094g.setColor(-13391360);
                            int i14 = this.f8107t;
                            canvas.translate(-i14, -i14);
                            b(canvas, h10, this.f8104q, nVar);
                            if (h10 == 5) {
                                j(canvas, nVar);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i10, int i11, n nVar) {
            if (i10 == 4) {
                d(canvas);
            }
            if (i10 == 2) {
                g(canvas);
            }
            if (i10 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i10, i11, nVar);
        }

        public final void c(Canvas canvas) {
            canvas.drawLines(this.f8088a, this.f8092e);
        }

        public final void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f8104q; i10++) {
                int i11 = this.f8089b[i10];
                if (i11 == 1) {
                    z10 = true;
                }
                if (i11 == 2) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        public final void e(Canvas canvas) {
            float[] fArr = this.f8088a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f8094g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f8094g);
        }

        public final void f(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f8088a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float min = Math.min(f12, f14);
            float max = Math.max(f13, f15);
            float min2 = f10 - Math.min(f12, f14);
            float max2 = Math.max(f13, f15) - f11;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f14 - f12)) + 0.5d)) / 100.0f);
            l(str, this.f8095h);
            canvas.drawText(str, ((min2 / 2.0f) - (this.f8105r.width() / 2)) + min, f11 - 20.0f, this.f8095h);
            canvas.drawLine(f10, f11, Math.min(f12, f14), f11, this.f8094g);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f15 - f13)) + 0.5d)) / 100.0f);
            l(str2, this.f8095h);
            canvas.drawText(str2, f10 + 5.0f, max - ((max2 / 2.0f) - (this.f8105r.height() / 2)), this.f8095h);
            canvas.drawLine(f10, f11, f10, Math.max(f13, f15), this.f8094g);
        }

        public final void g(Canvas canvas) {
            float[] fArr = this.f8088a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f8094g);
        }

        public final void h(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f8088a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f12 - f14, f13 - f15);
            float f16 = f14 - f12;
            float f17 = f15 - f13;
            float f18 = (((f10 - f12) * f16) + ((f11 - f13) * f17)) / (hypot * hypot);
            float f19 = f12 + (f16 * f18);
            float f20 = f13 + (f18 * f17);
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f19, f20);
            float hypot2 = (float) Math.hypot(f19 - f10, f20 - f11);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            l(str, this.f8095h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.f8105r.width() / 2), -20.0f, this.f8095h);
            canvas.drawLine(f10, f11, f19, f20, this.f8094g);
        }

        public final void i(Canvas canvas, float f10, float f11, int i10, int i11) {
            String str = "" + (((int) ((((f10 - (i10 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i10)) + 0.5d)) / 100.0f);
            l(str, this.f8095h);
            canvas.drawText(str, ((f10 / 2.0f) - (this.f8105r.width() / 2)) + 0.0f, f11 - 20.0f, this.f8095h);
            canvas.drawLine(f10, f11, Math.min(0.0f, 1.0f), f11, this.f8094g);
            String str2 = "" + (((int) ((((f11 - (i11 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i11)) + 0.5d)) / 100.0f);
            l(str2, this.f8095h);
            canvas.drawText(str2, f10 + 5.0f, 0.0f - ((f11 / 2.0f) - (this.f8105r.height() / 2)), this.f8095h);
            canvas.drawLine(f10, f11, f10, Math.max(0.0f, 1.0f), this.f8094g);
        }

        public final void j(Canvas canvas, n nVar) {
            this.f8091d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                nVar.e(i10 / 50, this.f8097j, 0);
                Path path = this.f8091d;
                float[] fArr = this.f8097j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f8091d;
                float[] fArr2 = this.f8097j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f8091d;
                float[] fArr3 = this.f8097j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f8091d;
                float[] fArr4 = this.f8097j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f8091d.close();
            }
            this.f8092e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f8091d, this.f8092e);
            canvas.translate(-2.0f, -2.0f);
            this.f8092e.setColor(-65536);
            canvas.drawPath(this.f8091d, this.f8092e);
        }

        public final void k(Canvas canvas, int i10, int i11, n nVar) {
            int i12;
            int i13;
            int i14;
            float f10;
            float f11;
            View view = nVar.f37062a;
            if (view != null) {
                i12 = view.getWidth();
                i13 = nVar.f37062a.getHeight();
            } else {
                i12 = 0;
                i13 = 0;
            }
            for (int i15 = 1; i15 < i11 - 1; i15++) {
                if (i10 != 4 || this.f8089b[i15 - 1] != 0) {
                    float[] fArr = this.f8090c;
                    int i16 = i15 * 2;
                    float f12 = fArr[i16];
                    float f13 = fArr[i16 + 1];
                    this.f8091d.reset();
                    this.f8091d.moveTo(f12, f13 + 10.0f);
                    this.f8091d.lineTo(f12 + 10.0f, f13);
                    this.f8091d.lineTo(f12, f13 - 10.0f);
                    this.f8091d.lineTo(f12 - 10.0f, f13);
                    this.f8091d.close();
                    int i17 = i15 - 1;
                    nVar.k(i17);
                    if (i10 == 4) {
                        int i18 = this.f8089b[i17];
                        if (i18 == 1) {
                            h(canvas, f12 - 0.0f, f13 - 0.0f);
                        } else if (i18 == 2) {
                            f(canvas, f12 - 0.0f, f13 - 0.0f);
                        } else if (i18 == 3) {
                            i14 = 3;
                            f10 = f13;
                            f11 = f12;
                            i(canvas, f12 - 0.0f, f13 - 0.0f, i12, i13);
                            canvas.drawPath(this.f8091d, this.f8096i);
                        }
                        i14 = 3;
                        f10 = f13;
                        f11 = f12;
                        canvas.drawPath(this.f8091d, this.f8096i);
                    } else {
                        i14 = 3;
                        f10 = f13;
                        f11 = f12;
                    }
                    if (i10 == 2) {
                        h(canvas, f11 - 0.0f, f10 - 0.0f);
                    }
                    if (i10 == i14) {
                        f(canvas, f11 - 0.0f, f10 - 0.0f);
                    }
                    if (i10 == 6) {
                        i(canvas, f11 - 0.0f, f10 - 0.0f, i12, i13);
                    }
                    canvas.drawPath(this.f8091d, this.f8096i);
                }
            }
            float[] fArr2 = this.f8088a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f8093f);
                float[] fArr3 = this.f8088a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f8093f);
            }
        }

        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f8105r);
        }
    }

    /* loaded from: classes.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public androidx.constraintlayout.solver.widgets.d f8109a = new androidx.constraintlayout.solver.widgets.d();

        /* renamed from: b, reason: collision with root package name */
        public androidx.constraintlayout.solver.widgets.d f8110b = new androidx.constraintlayout.solver.widgets.d();

        /* renamed from: c, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f8111c = null;

        /* renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.b f8112d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f8113e;

        /* renamed from: f, reason: collision with root package name */
        public int f8114f;

        public e() {
        }

        public void a() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f8052j.clear();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = MotionLayout.this.getChildAt(i10);
                MotionLayout.this.f8052j.put(childAt, new n(childAt));
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt2 = MotionLayout.this.getChildAt(i11);
                n nVar = MotionLayout.this.f8052j.get(childAt2);
                if (nVar != null) {
                    if (this.f8111c != null) {
                        ConstraintWidget c10 = c(this.f8109a, childAt2);
                        if (c10 != null) {
                            nVar.t(c10, this.f8111c);
                        } else if (MotionLayout.this.f8012B != 0) {
                            Log.e("MotionLayout", C1573a.a() + "no widget for  " + C1573a.c(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.f8112d != null) {
                        ConstraintWidget c11 = c(this.f8110b, childAt2);
                        if (c11 != null) {
                            nVar.q(c11, this.f8112d);
                        } else if (MotionLayout.this.f8012B != 0) {
                            Log.e("MotionLayout", C1573a.a() + "no widget for  " + C1573a.c(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        public void b(androidx.constraintlayout.solver.widgets.d dVar, androidx.constraintlayout.solver.widgets.d dVar2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> e12 = dVar.e1();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(dVar, dVar2);
            dVar2.e1().clear();
            dVar2.m(dVar, hashMap);
            Iterator<ConstraintWidget> it = e12.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.solver.widgets.a) {
                    constraintWidget = new androidx.constraintlayout.solver.widgets.a();
                } else if (next instanceof androidx.constraintlayout.solver.widgets.f) {
                    constraintWidget = new androidx.constraintlayout.solver.widgets.f();
                } else if (next instanceof androidx.constraintlayout.solver.widgets.e) {
                    constraintWidget = new androidx.constraintlayout.solver.widgets.e();
                } else if (next instanceof InterfaceC1615a) {
                    constraintWidget = new C1616b();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                dVar2.a(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = e12.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).m(next2, hashMap);
            }
        }

        public ConstraintWidget c(androidx.constraintlayout.solver.widgets.d dVar, View view) {
            if (dVar.t() == view) {
                return dVar;
            }
            ArrayList<ConstraintWidget> e12 = dVar.e1();
            int size = e12.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = e12.get(i10);
                if (constraintWidget.t() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void d(androidx.constraintlayout.solver.widgets.d dVar, androidx.constraintlayout.widget.b bVar, androidx.constraintlayout.widget.b bVar2) {
            this.f8111c = bVar;
            this.f8112d = bVar2;
            this.f8109a = new androidx.constraintlayout.solver.widgets.d();
            this.f8110b = new androidx.constraintlayout.solver.widgets.d();
            this.f8109a.J1(((ConstraintLayout) MotionLayout.this).mLayoutWidget.w1());
            this.f8110b.J1(((ConstraintLayout) MotionLayout.this).mLayoutWidget.w1());
            this.f8109a.h1();
            this.f8110b.h1();
            b(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f8109a);
            b(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f8110b);
            if (MotionLayout.this.f8060n > 0.5d) {
                if (bVar != null) {
                    i(this.f8109a, bVar);
                }
                i(this.f8110b, bVar2);
            } else {
                i(this.f8110b, bVar2);
                if (bVar != null) {
                    i(this.f8109a, bVar);
                }
            }
            this.f8109a.L1(MotionLayout.this.isRtl());
            this.f8109a.N1();
            this.f8110b.L1(MotionLayout.this.isRtl());
            this.f8110b.N1();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.solver.widgets.d dVar2 = this.f8109a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar2.D0(dimensionBehaviour);
                    this.f8110b.D0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.solver.widgets.d dVar3 = this.f8109a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar3.U0(dimensionBehaviour2);
                    this.f8110b.U0(dimensionBehaviour2);
                }
            }
        }

        public boolean e(int i10, int i11) {
            if (i10 == this.f8113e && i11 == this.f8114f) {
                return false;
            }
            return true;
        }

        public void f(int i10, int i11) {
            boolean z10;
            boolean z11;
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f8053j0 = mode;
            motionLayout.f8055k0 = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.f8042e == motionLayout2.getStartState()) {
                MotionLayout.this.resolveSystem(this.f8110b, optimizationLevel, i10, i11);
                if (this.f8111c != null) {
                    MotionLayout.this.resolveSystem(this.f8109a, optimizationLevel, i10, i11);
                }
            } else {
                if (this.f8111c != null) {
                    MotionLayout.this.resolveSystem(this.f8109a, optimizationLevel, i10, i11);
                }
                MotionLayout.this.resolveSystem(this.f8110b, optimizationLevel, i10, i11);
            }
            boolean z12 = true;
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.f8053j0 = mode;
                motionLayout3.f8055k0 = mode2;
                if (motionLayout3.f8042e == motionLayout3.getStartState()) {
                    MotionLayout.this.resolveSystem(this.f8110b, optimizationLevel, i10, i11);
                    if (this.f8111c != null) {
                        MotionLayout.this.resolveSystem(this.f8109a, optimizationLevel, i10, i11);
                    }
                } else {
                    if (this.f8111c != null) {
                        MotionLayout.this.resolveSystem(this.f8109a, optimizationLevel, i10, i11);
                    }
                    MotionLayout.this.resolveSystem(this.f8110b, optimizationLevel, i10, i11);
                }
                MotionLayout.this.f8045f0 = this.f8109a.U();
                MotionLayout.this.f8047g0 = this.f8109a.y();
                MotionLayout.this.f8049h0 = this.f8110b.U();
                MotionLayout.this.f8051i0 = this.f8110b.y();
                MotionLayout motionLayout4 = MotionLayout.this;
                if (motionLayout4.f8045f0 == motionLayout4.f8049h0 && motionLayout4.f8047g0 == motionLayout4.f8051i0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                motionLayout4.f8043e0 = z10;
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            int i12 = motionLayout5.f8045f0;
            int i13 = motionLayout5.f8047g0;
            int i14 = motionLayout5.f8053j0;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i12 = (int) (i12 + (motionLayout5.f8057l0 * (motionLayout5.f8049h0 - i12)));
            }
            int i15 = motionLayout5.f8055k0;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                i13 = (int) (i13 + (motionLayout5.f8057l0 * (motionLayout5.f8051i0 - i13)));
            }
            if (!this.f8109a.E1() && !this.f8110b.E1()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!this.f8109a.C1() && !this.f8110b.C1()) {
                z12 = false;
            }
            MotionLayout.this.resolveMeasuredDimension(i10, i11, i12, i13, z11, z12);
        }

        public void g() {
            f(MotionLayout.this.f8046g, MotionLayout.this.f8048h);
            MotionLayout.this.Y();
        }

        public void h(int i10, int i11) {
            this.f8113e = i10;
            this.f8114f = i11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void i(androidx.constraintlayout.solver.widgets.d dVar, androidx.constraintlayout.widget.b bVar) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, dVar);
            sparseArray.put(MotionLayout.this.getId(), dVar);
            Iterator<ConstraintWidget> it = dVar.e1().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.t()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = dVar.e1().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.t();
                bVar.g(view.getId(), layoutParams);
                next2.Y0(bVar.v(view.getId()));
                next2.z0(bVar.q(view.getId()));
                if (view instanceof ConstraintHelper) {
                    bVar.e((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).v();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (bVar.u(view.getId()) == 1) {
                    next2.X0(view.getVisibility());
                } else {
                    next2.X0(bVar.t(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = dVar.e1().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof androidx.constraintlayout.solver.widgets.h) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) next3.t();
                    InterfaceC1615a interfaceC1615a = (InterfaceC1615a) next3;
                    constraintHelper.t(dVar, interfaceC1615a, sparseArray);
                    ((androidx.constraintlayout.solver.widgets.h) interfaceC1615a).h1();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(MotionEvent motionEvent);

        void b();

        float c();

        float d();

        void e(int i10);
    }

    /* loaded from: classes.dex */
    public static class g implements f {

        /* renamed from: b, reason: collision with root package name */
        public static g f8116b = new g();

        /* renamed from: a, reason: collision with root package name */
        public VelocityTracker f8117a;

        public static g f() {
            f8116b.f8117a = VelocityTracker.obtain();
            return f8116b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f8117a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public void b() {
            VelocityTracker velocityTracker = this.f8117a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f8117a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public float c() {
            VelocityTracker velocityTracker = this.f8117a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public float d() {
            VelocityTracker velocityTracker = this.f8117a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.f
        public void e(int i10) {
            VelocityTracker velocityTracker = this.f8117a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i10);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        public float f8118a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        public float f8119b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        public int f8120c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f8121d = -1;

        /* renamed from: e, reason: collision with root package name */
        public final String f8122e = "motion.progress";

        /* renamed from: f, reason: collision with root package name */
        public final String f8123f = "motion.velocity";

        /* renamed from: g, reason: collision with root package name */
        public final String f8124g = "motion.StartState";

        /* renamed from: h, reason: collision with root package name */
        public final String f8125h = "motion.EndState";

        public h() {
        }

        public void a() {
            int i10 = this.f8120c;
            if (i10 != -1 || this.f8121d != -1) {
                if (i10 == -1) {
                    MotionLayout.this.c0(this.f8121d);
                } else {
                    int i11 = this.f8121d;
                    if (i11 == -1) {
                        MotionLayout.this.setState(i10, -1, -1);
                    } else {
                        MotionLayout.this.X(i10, i11);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f8119b)) {
                if (Float.isNaN(this.f8118a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f8118a);
            } else {
                MotionLayout.this.W(this.f8118a, this.f8119b);
                this.f8118a = Float.NaN;
                this.f8119b = Float.NaN;
                this.f8120c = -1;
                this.f8121d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f8118a);
            bundle.putFloat("motion.velocity", this.f8119b);
            bundle.putInt("motion.StartState", this.f8120c);
            bundle.putInt("motion.EndState", this.f8121d);
            return bundle;
        }

        public void c() {
            this.f8121d = MotionLayout.this.f8044f;
            this.f8120c = MotionLayout.this.f8040d;
            this.f8119b = MotionLayout.this.getVelocity();
            this.f8118a = MotionLayout.this.getProgress();
        }

        public void d(int i10) {
            this.f8121d = i10;
        }

        public void e(float f10) {
            this.f8118a = f10;
        }

        public void f(int i10) {
            this.f8120c = i10;
        }

        public void g(Bundle bundle) {
            this.f8118a = bundle.getFloat("motion.progress");
            this.f8119b = bundle.getFloat("motion.velocity");
            this.f8120c = bundle.getInt("motion.StartState");
            this.f8121d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f8119b = f10;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(MotionLayout motionLayout, int i10, int i11, float f10);

        void b(MotionLayout motionLayout, int i10, int i11);

        void c(MotionLayout motionLayout, int i10, boolean z10, float f10);

        void d(MotionLayout motionLayout, int i10);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8038c = 0.0f;
        this.f8040d = -1;
        this.f8042e = -1;
        this.f8044f = -1;
        this.f8046g = 0;
        this.f8048h = 0;
        this.f8050i = true;
        this.f8052j = new HashMap<>();
        this.f8054k = 0L;
        this.f8056l = 1.0f;
        this.f8058m = 0.0f;
        this.f8060n = 0.0f;
        this.f8064p = 0.0f;
        this.f8068r = false;
        this.f8073x = false;
        this.f8012B = 0;
        this.f8014D = false;
        this.f8015E = new s.g();
        this.f8016F = new c();
        this.f8018H = true;
        this.f8023M = false;
        this.f8028R = false;
        this.f8029S = null;
        this.f8030T = null;
        this.f8031U = null;
        this.f8032V = 0;
        this.f8033W = -1L;
        this.f8035a0 = 0.0f;
        this.f8037b0 = 0;
        this.f8039c0 = 0.0f;
        this.f8041d0 = false;
        this.f8043e0 = false;
        this.f8059m0 = new t.e();
        this.f8061n0 = false;
        this.f8065p0 = TransitionState.UNDEFINED;
        this.f8067q0 = new e();
        this.f8069r0 = false;
        this.f8070s0 = new RectF();
        this.f8071t0 = null;
        this.f8072u0 = new ArrayList<>();
        Q(attributeSet);
    }

    public static boolean e0(float f10, float f11, float f12) {
        if (f10 > 0.0f) {
            float f13 = f10 / f12;
            if (f11 + ((f10 * f13) - (((f12 * f13) * f13) / 2.0f)) <= 1.0f) {
                return false;
            }
            return true;
        }
        float f14 = (-f10) / f12;
        if (f11 + (f10 * f14) + (((f12 * f14) * f14) / 2.0f) >= 0.0f) {
            return false;
        }
        return true;
    }

    public void C(float f10) {
        if (this.f8034a == null) {
            return;
        }
        float f11 = this.f8060n;
        float f12 = this.f8058m;
        if (f11 != f12 && this.f8066q) {
            this.f8060n = f12;
        }
        float f13 = this.f8060n;
        if (f13 == f10) {
            return;
        }
        this.f8014D = false;
        this.f8064p = f10;
        this.f8056l = r0.m() / 1000.0f;
        setProgress(this.f8064p);
        this.f8036b = this.f8034a.p();
        this.f8066q = false;
        this.f8054k = getNanoTime();
        this.f8068r = true;
        this.f8058m = f13;
        this.f8060n = f13;
        invalidate();
    }

    public final void D() {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int x10 = aVar.x();
        androidx.constraintlayout.motion.widget.a aVar2 = this.f8034a;
        E(x10, aVar2.i(aVar2.x()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<a.b> it = this.f8034a.l().iterator();
        while (it.hasNext()) {
            a.b next = it.next();
            if (next == this.f8034a.f8129c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            F(next);
            int B10 = next.B();
            int z10 = next.z();
            String b10 = C1573a.b(getContext(), B10);
            String b11 = C1573a.b(getContext(), z10);
            if (sparseIntArray.get(B10) == z10) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + b10 + "->" + b11);
            }
            if (sparseIntArray2.get(z10) == B10) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + b10 + "->" + b11);
            }
            sparseIntArray.put(B10, z10);
            sparseIntArray2.put(z10, B10);
            if (this.f8034a.i(B10) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + b10);
            }
            if (this.f8034a.i(z10) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + b10);
            }
        }
    }

    public final void E(int i10, androidx.constraintlayout.widget.b bVar) {
        String b10 = C1573a.b(getContext(), i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id = childAt.getId();
            if (id == -1) {
                Log.w("MotionLayout", "CHECK: " + b10 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (bVar.p(id) == null) {
                Log.w("MotionLayout", "CHECK: " + b10 + " NO CONSTRAINTS for " + C1573a.c(childAt));
            }
        }
        int[] r10 = bVar.r();
        for (int i12 = 0; i12 < r10.length; i12++) {
            int i13 = r10[i12];
            String b11 = C1573a.b(getContext(), i13);
            if (findViewById(r10[i12]) == null) {
                Log.w("MotionLayout", "CHECK: " + b10 + " NO View matches id " + b11);
            }
            if (bVar.q(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + b10 + "(" + b11 + ") no LAYOUT_HEIGHT");
            }
            if (bVar.v(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + b10 + "(" + b11 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    public final void F(a.b bVar) {
        Log.v("MotionLayout", "CHECK: transition = " + bVar.u(getContext()));
        Log.v("MotionLayout", "CHECK: transition.setDuration = " + bVar.y());
        if (bVar.B() == bVar.z()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    public final void G() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            n nVar = this.f8052j.get(childAt);
            if (nVar != null) {
                nVar.s(childAt);
            }
        }
    }

    public void H(boolean z10) {
        float f10;
        boolean z11;
        boolean z12;
        int i10;
        float interpolation;
        if (this.f8062o == -1) {
            this.f8062o = getNanoTime();
        }
        float f11 = this.f8060n;
        if (f11 > 0.0f && f11 < 1.0f) {
            this.f8042e = -1;
        }
        boolean z13 = true;
        boolean z14 = false;
        if (this.f8028R || (this.f8068r && (z10 || this.f8064p != f11))) {
            float signum = Math.signum(this.f8064p - f11);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.f8036b;
            if (!(interpolator instanceof o)) {
                f10 = ((((float) (nanoTime - this.f8062o)) * signum) * 1.0E-9f) / this.f8056l;
                this.f8038c = f10;
            } else {
                f10 = 0.0f;
            }
            float f12 = this.f8060n + f10;
            if (this.f8066q) {
                f12 = this.f8064p;
            }
            if ((signum > 0.0f && f12 >= this.f8064p) || (signum <= 0.0f && f12 <= this.f8064p)) {
                f12 = this.f8064p;
                this.f8068r = false;
                z11 = true;
            } else {
                z11 = false;
            }
            this.f8060n = f12;
            this.f8058m = f12;
            this.f8062o = nanoTime;
            if (interpolator != null && !z11) {
                if (this.f8014D) {
                    interpolation = interpolator.getInterpolation(((float) (nanoTime - this.f8054k)) * 1.0E-9f);
                    this.f8060n = interpolation;
                    this.f8062o = nanoTime;
                    Interpolator interpolator2 = this.f8036b;
                    if (interpolator2 instanceof o) {
                        float a10 = ((o) interpolator2).a();
                        this.f8038c = a10;
                        if (Math.abs(a10) * this.f8056l <= 1.0E-5f) {
                            this.f8068r = false;
                        }
                        if (a10 > 0.0f && interpolation >= 1.0f) {
                            this.f8060n = 1.0f;
                            this.f8068r = false;
                            interpolation = 1.0f;
                        }
                        if (a10 < 0.0f && interpolation <= 0.0f) {
                            this.f8060n = 0.0f;
                            this.f8068r = false;
                            f12 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f12);
                    Interpolator interpolator3 = this.f8036b;
                    if (interpolator3 instanceof o) {
                        this.f8038c = ((o) interpolator3).a();
                    } else {
                        this.f8038c = ((interpolator3.getInterpolation(f12 + f10) - interpolation) * signum) / f10;
                    }
                }
                f12 = interpolation;
            }
            if (Math.abs(this.f8038c) > 1.0E-5f) {
                setState(TransitionState.MOVING);
            }
            if ((signum > 0.0f && f12 >= this.f8064p) || (signum <= 0.0f && f12 <= this.f8064p)) {
                f12 = this.f8064p;
                this.f8068r = false;
            }
            if (f12 >= 1.0f || f12 <= 0.0f) {
                this.f8068r = false;
                setState(TransitionState.FINISHED);
            }
            int childCount = getChildCount();
            this.f8028R = false;
            long nanoTime2 = getNanoTime();
            this.f8057l0 = f12;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                n nVar = this.f8052j.get(childAt);
                if (nVar != null) {
                    this.f8028R = nVar.o(childAt, f12, nanoTime2, this.f8059m0) | this.f8028R;
                }
            }
            if ((signum > 0.0f && f12 >= this.f8064p) || (signum <= 0.0f && f12 <= this.f8064p)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!this.f8028R && !this.f8068r && z12) {
                setState(TransitionState.FINISHED);
            }
            if (this.f8043e0) {
                requestLayout();
            }
            this.f8028R = (!z12) | this.f8028R;
            if (f12 <= 0.0f && (i10 = this.f8040d) != -1 && this.f8042e != i10) {
                this.f8042e = i10;
                this.f8034a.i(i10).c(this);
                setState(TransitionState.FINISHED);
                z14 = true;
            }
            if (f12 >= 1.0d) {
                int i12 = this.f8042e;
                int i13 = this.f8044f;
                if (i12 != i13) {
                    this.f8042e = i13;
                    this.f8034a.i(i13).c(this);
                    setState(TransitionState.FINISHED);
                    z14 = true;
                }
            }
            if (!this.f8028R && !this.f8068r) {
                if ((signum > 0.0f && f12 == 1.0f) || (signum < 0.0f && f12 == 0.0f)) {
                    setState(TransitionState.FINISHED);
                }
            } else {
                invalidate();
            }
            if ((!this.f8028R && this.f8068r && signum > 0.0f && f12 == 1.0f) || (signum < 0.0f && f12 == 0.0f)) {
                T();
            }
        }
        float f13 = this.f8060n;
        if (f13 >= 1.0f) {
            int i14 = this.f8042e;
            int i15 = this.f8044f;
            if (i14 == i15) {
                z13 = z14;
            }
            this.f8042e = i15;
        } else {
            if (f13 <= 0.0f) {
                int i16 = this.f8042e;
                int i17 = this.f8040d;
                if (i16 == i17) {
                    z13 = z14;
                }
                this.f8042e = i17;
            }
            this.f8069r0 |= z14;
            if (z14 && !this.f8061n0) {
                requestLayout();
            }
            this.f8058m = this.f8060n;
        }
        z14 = z13;
        this.f8069r0 |= z14;
        if (z14) {
            requestLayout();
        }
        this.f8058m = this.f8060n;
    }

    public final void I() {
        float f10;
        boolean z10;
        float signum = Math.signum(this.f8064p - this.f8060n);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f8036b;
        if (!(interpolator instanceof s.g)) {
            f10 = ((((float) (nanoTime - this.f8062o)) * signum) * 1.0E-9f) / this.f8056l;
        } else {
            f10 = 0.0f;
        }
        float f11 = this.f8060n + f10;
        if (this.f8066q) {
            f11 = this.f8064p;
        }
        if ((signum > 0.0f && f11 >= this.f8064p) || (signum <= 0.0f && f11 <= this.f8064p)) {
            f11 = this.f8064p;
            z10 = true;
        } else {
            z10 = false;
        }
        if (interpolator != null && !z10) {
            if (this.f8014D) {
                f11 = interpolator.getInterpolation(((float) (nanoTime - this.f8054k)) * 1.0E-9f);
            } else {
                f11 = interpolator.getInterpolation(f11);
            }
        }
        if ((signum > 0.0f && f11 >= this.f8064p) || (signum <= 0.0f && f11 <= this.f8064p)) {
            f11 = this.f8064p;
        }
        this.f8057l0 = f11;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            n nVar = this.f8052j.get(childAt);
            if (nVar != null) {
                nVar.o(childAt, f11, nanoTime2, this.f8059m0);
            }
        }
        if (this.f8043e0) {
            requestLayout();
        }
    }

    public final void J() {
        ArrayList<i> arrayList;
        if ((this.f8074y != null || ((arrayList = this.f8031U) != null && !arrayList.isEmpty())) && this.f8039c0 != this.f8058m) {
            if (this.f8037b0 != -1) {
                i iVar = this.f8074y;
                if (iVar != null) {
                    iVar.b(this, this.f8040d, this.f8044f);
                }
                ArrayList<i> arrayList2 = this.f8031U;
                if (arrayList2 != null) {
                    Iterator<i> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.f8040d, this.f8044f);
                    }
                }
                this.f8041d0 = true;
            }
            this.f8037b0 = -1;
            float f10 = this.f8058m;
            this.f8039c0 = f10;
            i iVar2 = this.f8074y;
            if (iVar2 != null) {
                iVar2.a(this, this.f8040d, this.f8044f, f10);
            }
            ArrayList<i> arrayList3 = this.f8031U;
            if (arrayList3 != null) {
                Iterator<i> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.f8040d, this.f8044f, this.f8058m);
                }
            }
            this.f8041d0 = true;
        }
    }

    public void K() {
        int i10;
        ArrayList<i> arrayList;
        if ((this.f8074y != null || ((arrayList = this.f8031U) != null && !arrayList.isEmpty())) && this.f8037b0 == -1) {
            this.f8037b0 = this.f8042e;
            if (!this.f8072u0.isEmpty()) {
                i10 = this.f8072u0.get(r0.size() - 1).intValue();
            } else {
                i10 = -1;
            }
            int i11 = this.f8042e;
            if (i10 != i11 && i11 != -1) {
                this.f8072u0.add(Integer.valueOf(i11));
            }
        }
        U();
    }

    public void L(int i10, boolean z10, float f10) {
        i iVar = this.f8074y;
        if (iVar != null) {
            iVar.c(this, i10, z10, f10);
        }
        ArrayList<i> arrayList = this.f8031U;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(this, i10, z10, f10);
            }
        }
    }

    public void M(int i10, float f10, float f11, float f12, float[] fArr) {
        String resourceName;
        HashMap<View, n> hashMap = this.f8052j;
        View viewById = getViewById(i10);
        n nVar = hashMap.get(viewById);
        if (nVar != null) {
            nVar.g(f10, f11, f12, fArr);
            float y10 = viewById.getY();
            this.f8075z = f10;
            this.f8011A = y10;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i10;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i10);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    public a.b N(int i10) {
        return this.f8034a.y(i10);
    }

    public void O(View view, float f10, float f11, float[] fArr, int i10) {
        float f12;
        float f13 = this.f8038c;
        float f14 = this.f8060n;
        if (this.f8036b != null) {
            float signum = Math.signum(this.f8064p - f14);
            float interpolation = this.f8036b.getInterpolation(this.f8060n + 1.0E-5f);
            f12 = this.f8036b.getInterpolation(this.f8060n);
            f13 = (signum * ((interpolation - f12) / 1.0E-5f)) / this.f8056l;
        } else {
            f12 = f14;
        }
        Interpolator interpolator = this.f8036b;
        if (interpolator instanceof o) {
            f13 = ((o) interpolator).a();
        }
        n nVar = this.f8052j.get(view);
        if ((i10 & 1) == 0) {
            nVar.l(f12, view.getWidth(), view.getHeight(), f10, f11, fArr);
        } else {
            nVar.g(f12, f10, f11, fArr);
        }
        if (i10 < 2) {
            fArr[0] = fArr[0] * f13;
            fArr[1] = fArr[1] * f13;
        }
    }

    public final boolean P(float f10, float f11, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (P(view.getLeft() + f10, view.getTop() + f11, viewGroup.getChildAt(i10), motionEvent)) {
                    return true;
                }
            }
        }
        this.f8070s0.set(view.getLeft() + f10, view.getTop() + f11, f10 + view.getRight(), f11 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.f8070s0.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public final void Q(AttributeSet attributeSet) {
        androidx.constraintlayout.motion.widget.a aVar;
        int i10;
        f8010v0 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f8871I6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == androidx.constraintlayout.widget.e.f8898L6) {
                    this.f8034a = new androidx.constraintlayout.motion.widget.a(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == androidx.constraintlayout.widget.e.f8889K6) {
                    this.f8042e = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == androidx.constraintlayout.widget.e.f8916N6) {
                    this.f8064p = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f8068r = true;
                } else if (index == androidx.constraintlayout.widget.e.f8880J6) {
                    z10 = obtainStyledAttributes.getBoolean(index, z10);
                } else if (index == androidx.constraintlayout.widget.e.f8925O6) {
                    if (this.f8012B == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i10 = 2;
                        } else {
                            i10 = 0;
                        }
                        this.f8012B = i10;
                    }
                } else if (index == androidx.constraintlayout.widget.e.f8907M6) {
                    this.f8012B = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f8034a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.f8034a = null;
            }
        }
        if (this.f8012B != 0) {
            D();
        }
        if (this.f8042e == -1 && (aVar = this.f8034a) != null) {
            this.f8042e = aVar.x();
            this.f8040d = this.f8034a.x();
            this.f8044f = this.f8034a.n();
        }
    }

    public boolean R() {
        return this.f8050i;
    }

    public f S() {
        return g.f();
    }

    public void T() {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null) {
            return;
        }
        if (aVar.f(this, this.f8042e)) {
            requestLayout();
            return;
        }
        int i10 = this.f8042e;
        if (i10 != -1) {
            this.f8034a.e(this, i10);
        }
        if (this.f8034a.Q()) {
            this.f8034a.O();
        }
    }

    public final void U() {
        ArrayList<i> arrayList;
        if (this.f8074y == null && ((arrayList = this.f8031U) == null || arrayList.isEmpty())) {
            return;
        }
        this.f8041d0 = false;
        Iterator<Integer> it = this.f8072u0.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            i iVar = this.f8074y;
            if (iVar != null) {
                iVar.d(this, next.intValue());
            }
            ArrayList<i> arrayList2 = this.f8031U;
            if (arrayList2 != null) {
                Iterator<i> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().d(this, next.intValue());
                }
            }
        }
        this.f8072u0.clear();
    }

    public void V() {
        this.f8067q0.g();
        invalidate();
    }

    public void W(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.f8063o0 == null) {
                this.f8063o0 = new h();
            }
            this.f8063o0.e(f10);
            this.f8063o0.h(f11);
            return;
        }
        setProgress(f10);
        setState(TransitionState.MOVING);
        this.f8038c = f11;
        C(1.0f);
    }

    public void X(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f8063o0 == null) {
                this.f8063o0 = new h();
            }
            this.f8063o0.f(i10);
            this.f8063o0.d(i11);
            return;
        }
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null) {
            this.f8040d = i10;
            this.f8044f = i11;
            aVar.M(i10, i11);
            this.f8067q0.d(this.mLayoutWidget, this.f8034a.i(i10), this.f8034a.i(i11));
            V();
            this.f8060n = 0.0f;
            b0();
        }
    }

    public final void Y() {
        float f10;
        float f11;
        int childCount = getChildCount();
        this.f8067q0.a();
        boolean z10 = true;
        this.f8068r = true;
        int width = getWidth();
        int height = getHeight();
        int h10 = this.f8034a.h();
        int i10 = 0;
        if (h10 != -1) {
            for (int i11 = 0; i11 < childCount; i11++) {
                n nVar = this.f8052j.get(getChildAt(i11));
                if (nVar != null) {
                    nVar.r(h10);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            n nVar2 = this.f8052j.get(getChildAt(i12));
            if (nVar2 != null) {
                this.f8034a.q(nVar2);
                nVar2.v(width, height, this.f8056l, getNanoTime());
            }
        }
        float w10 = this.f8034a.w();
        if (w10 != 0.0f) {
            if (w10 >= 0.0d) {
                z10 = false;
            }
            float abs = Math.abs(w10);
            float f12 = -3.4028235E38f;
            float f13 = Float.MAX_VALUE;
            float f14 = -3.4028235E38f;
            float f15 = Float.MAX_VALUE;
            for (int i13 = 0; i13 < childCount; i13++) {
                n nVar3 = this.f8052j.get(getChildAt(i13));
                if (!Float.isNaN(nVar3.f37072k)) {
                    for (int i14 = 0; i14 < childCount; i14++) {
                        n nVar4 = this.f8052j.get(getChildAt(i14));
                        if (!Float.isNaN(nVar4.f37072k)) {
                            f13 = Math.min(f13, nVar4.f37072k);
                            f12 = Math.max(f12, nVar4.f37072k);
                        }
                    }
                    while (i10 < childCount) {
                        n nVar5 = this.f8052j.get(getChildAt(i10));
                        if (!Float.isNaN(nVar5.f37072k)) {
                            nVar5.f37074m = 1.0f / (1.0f - abs);
                            if (z10) {
                                nVar5.f37073l = abs - (((f12 - nVar5.f37072k) / (f12 - f13)) * abs);
                            } else {
                                nVar5.f37073l = abs - (((nVar5.f37072k - f13) * abs) / (f12 - f13));
                            }
                        }
                        i10++;
                    }
                    return;
                }
                float i15 = nVar3.i();
                float j10 = nVar3.j();
                if (z10) {
                    f11 = j10 - i15;
                } else {
                    f11 = j10 + i15;
                }
                f15 = Math.min(f15, f11);
                f14 = Math.max(f14, f11);
            }
            while (i10 < childCount) {
                n nVar6 = this.f8052j.get(getChildAt(i10));
                float i16 = nVar6.i();
                float j11 = nVar6.j();
                if (z10) {
                    f10 = j11 - i16;
                } else {
                    f10 = j11 + i16;
                }
                nVar6.f37074m = 1.0f / (1.0f - abs);
                nVar6.f37073l = abs - (((f10 - f15) * abs) / (f14 - f15));
                i10++;
            }
        }
    }

    public void Z(int i10, float f10, float f11) {
        if (this.f8034a == null || this.f8060n == f10) {
            return;
        }
        this.f8014D = true;
        this.f8054k = getNanoTime();
        float m10 = this.f8034a.m() / 1000.0f;
        this.f8056l = m10;
        this.f8064p = f10;
        this.f8068r = true;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            if (i10 != 4) {
                if (i10 == 5) {
                    if (e0(f11, this.f8060n, this.f8034a.r())) {
                        this.f8016F.b(f11, this.f8060n, this.f8034a.r());
                        this.f8036b = this.f8016F;
                    } else {
                        this.f8015E.c(this.f8060n, f10, f11, this.f8056l, this.f8034a.r(), this.f8034a.s());
                        this.f8038c = 0.0f;
                        int i11 = this.f8042e;
                        this.f8064p = f10;
                        this.f8042e = i11;
                        this.f8036b = this.f8015E;
                    }
                }
            } else {
                this.f8016F.b(f11, this.f8060n, this.f8034a.r());
                this.f8036b = this.f8016F;
            }
        } else {
            if (i10 == 1) {
                f10 = 0.0f;
            } else if (i10 == 2) {
                f10 = 1.0f;
            }
            this.f8015E.c(this.f8060n, f10, f11, m10, this.f8034a.r(), this.f8034a.s());
            int i12 = this.f8042e;
            this.f8064p = f10;
            this.f8042e = i12;
            this.f8036b = this.f8015E;
        }
        this.f8066q = false;
        this.f8054k = getNanoTime();
        invalidate();
    }

    public void a0() {
        C(1.0f);
    }

    public void b0() {
        C(0.0f);
    }

    public void c0(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f8063o0 == null) {
                this.f8063o0 = new h();
            }
            this.f8063o0.d(i10);
            return;
        }
        d0(i10, -1, -1);
    }

    public void d0(int i10, int i11, int i12) {
        androidx.constraintlayout.widget.f fVar;
        int a10;
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null && (fVar = aVar.f8128b) != null && (a10 = fVar.a(this.f8042e, i10, i11, i12)) != -1) {
            i10 = a10;
        }
        int i13 = this.f8042e;
        if (i13 == i10) {
            return;
        }
        if (this.f8040d == i10) {
            C(0.0f);
            return;
        }
        if (this.f8044f == i10) {
            C(1.0f);
            return;
        }
        this.f8044f = i10;
        if (i13 != -1) {
            X(i13, i10);
            C(1.0f);
            this.f8060n = 0.0f;
            a0();
            return;
        }
        this.f8014D = false;
        this.f8064p = 1.0f;
        this.f8058m = 0.0f;
        this.f8060n = 0.0f;
        this.f8062o = getNanoTime();
        this.f8054k = getNanoTime();
        this.f8066q = false;
        this.f8036b = null;
        this.f8056l = this.f8034a.m() / 1000.0f;
        this.f8040d = -1;
        this.f8034a.M(-1, this.f8044f);
        this.f8034a.x();
        int childCount = getChildCount();
        this.f8052j.clear();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            this.f8052j.put(childAt, new n(childAt));
        }
        this.f8068r = true;
        this.f8067q0.d(this.mLayoutWidget, null, this.f8034a.i(i10));
        V();
        this.f8067q0.a();
        G();
        int width = getWidth();
        int height = getHeight();
        for (int i15 = 0; i15 < childCount; i15++) {
            n nVar = this.f8052j.get(getChildAt(i15));
            this.f8034a.q(nVar);
            nVar.v(width, height, this.f8056l, getNanoTime());
        }
        float w10 = this.f8034a.w();
        if (w10 != 0.0f) {
            float f10 = Float.MAX_VALUE;
            float f11 = -3.4028235E38f;
            for (int i16 = 0; i16 < childCount; i16++) {
                n nVar2 = this.f8052j.get(getChildAt(i16));
                float j10 = nVar2.j() + nVar2.i();
                f10 = Math.min(f10, j10);
                f11 = Math.max(f11, j10);
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                n nVar3 = this.f8052j.get(getChildAt(i17));
                float i18 = nVar3.i();
                float j11 = nVar3.j();
                nVar3.f37074m = 1.0f / (1.0f - w10);
                nVar3.f37073l = w10 - ((((i18 + j11) - f10) * w10) / (f11 - f10));
            }
        }
        this.f8058m = 0.0f;
        this.f8060n = 0.0f;
        this.f8068r = true;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        String d10;
        H(false);
        super.dispatchDraw(canvas);
        if (this.f8034a == null) {
            return;
        }
        if ((this.f8012B & 1) == 1 && !isInEditMode()) {
            this.f8032V++;
            long nanoTime = getNanoTime();
            long j10 = this.f8033W;
            if (j10 != -1) {
                if (nanoTime - j10 > 200000000) {
                    this.f8035a0 = ((int) ((this.f8032V / (((float) r5) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.f8032V = 0;
                    this.f8033W = nanoTime;
                }
            } else {
                this.f8033W = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.f8035a0 + " fps " + C1573a.d(this, this.f8040d) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(C1573a.d(this, this.f8044f));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i10 = this.f8042e;
            if (i10 == -1) {
                d10 = "undefined";
            } else {
                d10 = C1573a.d(this, i10);
            }
            sb.append(d10);
            String sb2 = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.f8012B > 1) {
            if (this.f8013C == null) {
                this.f8013C = new d();
            }
            this.f8013C.a(canvas, this.f8052j, this.f8034a.m(), this.f8012B);
        }
    }

    public int[] getConstraintSetIds() {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null) {
            return null;
        }
        return aVar.k();
    }

    public int getCurrentState() {
        return this.f8042e;
    }

    public ArrayList<a.b> getDefinedTransitions() {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null) {
            return null;
        }
        return aVar.l();
    }

    public C1574b getDesignTool() {
        if (this.f8017G == null) {
            this.f8017G = new C1574b(this);
        }
        return this.f8017G;
    }

    public int getEndState() {
        return this.f8044f;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f8060n;
    }

    public int getStartState() {
        return this.f8040d;
    }

    public float getTargetPosition() {
        return this.f8064p;
    }

    public Bundle getTransitionState() {
        if (this.f8063o0 == null) {
            this.f8063o0 = new h();
        }
        this.f8063o0.c();
        return this.f8063o0.b();
    }

    public long getTransitionTimeMs() {
        if (this.f8034a != null) {
            this.f8056l = r0.m() / 1000.0f;
        }
        return this.f8056l * 1000.0f;
    }

    public float getVelocity() {
        return this.f8038c;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i10) {
        if (i10 != 0) {
            try {
                this.f8034a = new androidx.constraintlayout.motion.widget.a(getContext(), this, i10);
                if (isAttachedToWindow()) {
                    this.f8034a.J(this);
                    this.f8067q0.d(this.mLayoutWidget, this.f8034a.i(this.f8040d), this.f8034a.i(this.f8044f));
                    V();
                    this.f8034a.L(isRtl());
                    return;
                }
                return;
            } catch (Exception e10) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e10);
            }
        }
        this.f8034a = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        a.b bVar;
        int i10;
        super.onAttachedToWindow();
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null && (i10 = this.f8042e) != -1) {
            androidx.constraintlayout.widget.b i11 = aVar.i(i10);
            this.f8034a.J(this);
            if (i11 != null) {
                i11.d(this);
            }
            this.f8040d = this.f8042e;
        }
        T();
        h hVar = this.f8063o0;
        if (hVar != null) {
            hVar.a();
            return;
        }
        androidx.constraintlayout.motion.widget.a aVar2 = this.f8034a;
        if (aVar2 != null && (bVar = aVar2.f8129c) != null && bVar.x() == 4) {
            a0();
            setState(TransitionState.SETUP);
            setState(TransitionState.MOVING);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a.b bVar;
        androidx.constraintlayout.motion.widget.b C10;
        int k10;
        RectF j10;
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null && this.f8050i && (bVar = aVar.f8129c) != null && bVar.D() && (C10 = bVar.C()) != null && ((motionEvent.getAction() != 0 || (j10 = C10.j(this, new RectF())) == null || j10.contains(motionEvent.getX(), motionEvent.getY())) && (k10 = C10.k()) != -1)) {
            View view = this.f8071t0;
            if (view == null || view.getId() != k10) {
                this.f8071t0 = findViewById(k10);
            }
            if (this.f8071t0 != null) {
                this.f8070s0.set(r0.getLeft(), this.f8071t0.getTop(), this.f8071t0.getRight(), this.f8071t0.getBottom());
                if (this.f8070s0.contains(motionEvent.getX(), motionEvent.getY()) && !P(0.0f, 0.0f, this.f8071t0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f8061n0 = true;
        try {
            if (this.f8034a == null) {
                super.onLayout(z10, i10, i11, i12, i13);
                return;
            }
            int i14 = i12 - i10;
            int i15 = i13 - i11;
            if (this.f8021K != i14 || this.f8022L != i15) {
                V();
                H(true);
            }
            this.f8021K = i14;
            this.f8022L = i15;
            this.f8019I = i14;
            this.f8020J = i15;
        } finally {
            this.f8061n0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        if (this.f8034a == null) {
            super.onMeasure(i10, i11);
            return;
        }
        boolean z11 = false;
        if (this.f8046g == i10 && this.f8048h == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f8069r0) {
            this.f8069r0 = false;
            T();
            U();
            z10 = true;
        }
        if (this.mDirtyHierarchy) {
            z10 = true;
        }
        this.f8046g = i10;
        this.f8048h = i11;
        int x10 = this.f8034a.x();
        int n10 = this.f8034a.n();
        if ((z10 || this.f8067q0.e(x10, n10)) && this.f8040d != -1) {
            super.onMeasure(i10, i11);
            this.f8067q0.d(this.mLayoutWidget, this.f8034a.i(x10), this.f8034a.i(n10));
            this.f8067q0.g();
            this.f8067q0.h(x10, n10);
        } else {
            z11 = true;
        }
        if (this.f8043e0 || z11) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int U10 = this.mLayoutWidget.U() + getPaddingLeft() + getPaddingRight();
            int y10 = this.mLayoutWidget.y() + paddingTop;
            int i12 = this.f8053j0;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                U10 = (int) (this.f8045f0 + (this.f8057l0 * (this.f8049h0 - r7)));
                requestLayout();
            }
            int i13 = this.f8055k0;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                y10 = (int) (this.f8047g0 + (this.f8057l0 * (this.f8051i0 - r7)));
                requestLayout();
            }
            setMeasuredDimension(U10, y10);
        }
        I();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        a.b bVar;
        androidx.constraintlayout.motion.widget.b C10;
        int k10;
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null || (bVar = aVar.f8129c) == null || !bVar.D()) {
            return;
        }
        a.b bVar2 = this.f8034a.f8129c;
        if (bVar2 != null && bVar2.D() && (C10 = bVar2.C()) != null && (k10 = C10.k()) != -1 && view.getId() != k10) {
            return;
        }
        androidx.constraintlayout.motion.widget.a aVar2 = this.f8034a;
        if (aVar2 != null && aVar2.t()) {
            float f10 = this.f8058m;
            if ((f10 == 1.0f || f10 == 0.0f) && view.canScrollVertically(-1)) {
                return;
            }
        }
        if (bVar2.C() != null && (this.f8034a.f8129c.C().d() & 1) != 0) {
            float u10 = this.f8034a.u(i10, i11);
            float f11 = this.f8060n;
            if ((f11 <= 0.0f && u10 < 0.0f) || (f11 >= 1.0f && u10 > 0.0f)) {
                view.setNestedScrollingEnabled(false);
                view.post(new a(view));
                return;
            }
        }
        float f12 = this.f8058m;
        long nanoTime = getNanoTime();
        float f13 = i10;
        this.f8024N = f13;
        float f14 = i11;
        this.f8025O = f14;
        this.f8027Q = (float) ((nanoTime - this.f8026P) * 1.0E-9d);
        this.f8026P = nanoTime;
        this.f8034a.F(f13, f14);
        if (f12 != this.f8058m) {
            iArr[0] = i10;
            iArr[1] = i11;
        }
        H(false);
        if (iArr[0] != 0 || iArr[1] != 0) {
            this.f8023M = true;
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null) {
            aVar.L(isRtl());
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        a.b bVar;
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null && (bVar = aVar.f8129c) != null && bVar.C() != null && (this.f8034a.f8129c.C().d() & 2) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onStopNestedScroll(View view, int i10) {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null) {
            return;
        }
        float f10 = this.f8024N;
        float f11 = this.f8027Q;
        aVar.G(f10 / f11, this.f8025O / f11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar != null && this.f8050i && aVar.Q()) {
            a.b bVar = this.f8034a.f8129c;
            if (bVar != null && !bVar.D()) {
                return super.onTouchEvent(motionEvent);
            }
            this.f8034a.H(motionEvent, getCurrentState(), this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f8031U == null) {
                this.f8031U = new ArrayList<>();
            }
            this.f8031U.add(motionHelper);
            if (motionHelper.x()) {
                if (this.f8029S == null) {
                    this.f8029S = new ArrayList<>();
                }
                this.f8029S.add(motionHelper);
            }
            if (motionHelper.w()) {
                if (this.f8030T == null) {
                    this.f8030T = new ArrayList<>();
                }
                this.f8030T.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f8029S;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f8030T;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        androidx.constraintlayout.motion.widget.a aVar;
        a.b bVar;
        if (!this.f8043e0 && this.f8042e == -1 && (aVar = this.f8034a) != null && (bVar = aVar.f8129c) != null && bVar.A() == 0) {
            return;
        }
        super.requestLayout();
    }

    public void setDebugMode(int i10) {
        this.f8012B = i10;
        invalidate();
    }

    public void setInteractionEnabled(boolean z10) {
        this.f8050i = z10;
    }

    public void setInterpolatedProgress(float f10) {
        if (this.f8034a != null) {
            setState(TransitionState.MOVING);
            Interpolator p10 = this.f8034a.p();
            if (p10 != null) {
                setProgress(p10.getInterpolation(f10));
                return;
            }
        }
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<MotionHelper> arrayList = this.f8030T;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f8030T.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<MotionHelper> arrayList = this.f8029S;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f8029S.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f8063o0 == null) {
                this.f8063o0 = new h();
            }
            this.f8063o0.e(f10);
            return;
        }
        if (f10 <= 0.0f) {
            this.f8042e = this.f8040d;
            if (this.f8060n == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            this.f8042e = this.f8044f;
            if (this.f8060n == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f8042e = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f8034a == null) {
            return;
        }
        this.f8066q = true;
        this.f8064p = f10;
        this.f8058m = f10;
        this.f8062o = -1L;
        this.f8054k = -1L;
        this.f8036b = null;
        this.f8068r = true;
        invalidate();
    }

    public void setScene(androidx.constraintlayout.motion.widget.a aVar) {
        this.f8034a = aVar;
        aVar.L(isRtl());
        V();
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.f8042e == -1) {
            return;
        }
        TransitionState transitionState3 = this.f8065p0;
        this.f8065p0 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            J();
        }
        int i10 = b.f8083a[transitionState3.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3 && transitionState == transitionState2) {
                K();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            J();
        }
        if (transitionState == transitionState2) {
            K();
        }
    }

    public void setTransition(int i10) {
        float f10;
        if (this.f8034a != null) {
            a.b N10 = N(i10);
            this.f8040d = N10.B();
            this.f8044f = N10.z();
            if (!isAttachedToWindow()) {
                if (this.f8063o0 == null) {
                    this.f8063o0 = new h();
                }
                this.f8063o0.f(this.f8040d);
                this.f8063o0.d(this.f8044f);
                return;
            }
            int i11 = this.f8042e;
            if (i11 == this.f8040d) {
                f10 = 0.0f;
            } else {
                f10 = i11 == this.f8044f ? 1.0f : Float.NaN;
            }
            this.f8034a.N(N10);
            this.f8067q0.d(this.mLayoutWidget, this.f8034a.i(this.f8040d), this.f8034a.i(this.f8044f));
            V();
            this.f8060n = Float.isNaN(f10) ? 0.0f : f10;
            if (Float.isNaN(f10)) {
                Log.v("MotionLayout", C1573a.a() + " transitionToStart ");
                b0();
                return;
            }
            setProgress(f10);
        }
    }

    public void setTransitionDuration(int i10) {
        androidx.constraintlayout.motion.widget.a aVar = this.f8034a;
        if (aVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            aVar.K(i10);
        }
    }

    public void setTransitionListener(i iVar) {
        this.f8074y = iVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f8063o0 == null) {
            this.f8063o0 = new h();
        }
        this.f8063o0.g(bundle);
        if (isAttachedToWindow()) {
            this.f8063o0.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return C1573a.b(context, this.f8040d) + "->" + C1573a.b(context, this.f8044f) + " (pos:" + this.f8060n + " Dpos/Dt:" + this.f8038c;
    }

    @Override // androidx.core.view.InterfaceC0468x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (this.f8023M || i10 != 0 || i11 != 0) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.f8023M = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i10, int i11, int i12) {
        setState(TransitionState.SETUP);
        this.f8042e = i10;
        this.f8040d = -1;
        this.f8044f = -1;
        androidx.constraintlayout.widget.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.d(i10, i11, i12);
            return;
        }
        androidx.constraintlayout.motion.widget.a aVar2 = this.f8034a;
        if (aVar2 != null) {
            aVar2.i(i10).d(this);
        }
    }

    public void setTransition(a.b bVar) {
        this.f8034a.N(bVar);
        setState(TransitionState.SETUP);
        if (this.f8042e == this.f8034a.n()) {
            this.f8060n = 1.0f;
            this.f8058m = 1.0f;
            this.f8064p = 1.0f;
        } else {
            this.f8060n = 0.0f;
            this.f8058m = 0.0f;
            this.f8064p = 0.0f;
        }
        this.f8062o = bVar.E(1) ? -1L : getNanoTime();
        int x10 = this.f8034a.x();
        int n10 = this.f8034a.n();
        if (x10 == this.f8040d && n10 == this.f8044f) {
            return;
        }
        this.f8040d = x10;
        this.f8044f = n10;
        this.f8034a.M(x10, n10);
        this.f8067q0.d(this.mLayoutWidget, this.f8034a.i(this.f8040d), this.f8034a.i(this.f8044f));
        this.f8067q0.h(this.f8040d, this.f8044f);
        this.f8067q0.g();
        V();
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
    }
}
