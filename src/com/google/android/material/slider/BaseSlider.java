package com.google.android.material.slider;

import J.d;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.core.view.K;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import e4.C0977c;
import e4.C0978d;
import e4.C0979e;
import e4.k;
import e4.l;
import e4.m;
import f.C0991a;
import f4.C1001b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import n4.C1370a;
import s4.C1550i;
import u4.C1607c;
import x4.i;
import x4.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {

    /* renamed from: A0, reason: collision with root package name */
    public static final String f23688A0 = "BaseSlider";

    /* renamed from: B0, reason: collision with root package name */
    public static final int f23689B0 = l.f31014P;

    /* renamed from: C0, reason: collision with root package name */
    public static final int f23690C0 = C0977c.f30651W;

    /* renamed from: D0, reason: collision with root package name */
    public static final int f23691D0 = C0977c.f30654Z;

    /* renamed from: E0, reason: collision with root package name */
    public static final int f23692E0 = C0977c.f30662d0;

    /* renamed from: F0, reason: collision with root package name */
    public static final int f23693F0 = C0977c.f30658b0;

    /* renamed from: A, reason: collision with root package name */
    public int f23694A;

    /* renamed from: B, reason: collision with root package name */
    public int f23695B;

    /* renamed from: C, reason: collision with root package name */
    public int f23696C;

    /* renamed from: D, reason: collision with root package name */
    public int f23697D;

    /* renamed from: E, reason: collision with root package name */
    public int f23698E;

    /* renamed from: F, reason: collision with root package name */
    public int f23699F;

    /* renamed from: G, reason: collision with root package name */
    public int f23700G;

    /* renamed from: H, reason: collision with root package name */
    public int f23701H;

    /* renamed from: I, reason: collision with root package name */
    public int f23702I;

    /* renamed from: J, reason: collision with root package name */
    public int f23703J;

    /* renamed from: K, reason: collision with root package name */
    public int f23704K;

    /* renamed from: L, reason: collision with root package name */
    public int f23705L;

    /* renamed from: M, reason: collision with root package name */
    public int f23706M;

    /* renamed from: N, reason: collision with root package name */
    public int f23707N;

    /* renamed from: O, reason: collision with root package name */
    public int f23708O;

    /* renamed from: P, reason: collision with root package name */
    public int f23709P;

    /* renamed from: Q, reason: collision with root package name */
    public int f23710Q;

    /* renamed from: R, reason: collision with root package name */
    public int f23711R;

    /* renamed from: S, reason: collision with root package name */
    public float f23712S;

    /* renamed from: T, reason: collision with root package name */
    public MotionEvent f23713T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f23714U;

    /* renamed from: V, reason: collision with root package name */
    public float f23715V;

    /* renamed from: W, reason: collision with root package name */
    public float f23716W;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f23717a;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList<Float> f23718a0;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f23719b;

    /* renamed from: b0, reason: collision with root package name */
    public int f23720b0;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f23721c;

    /* renamed from: c0, reason: collision with root package name */
    public int f23722c0;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f23723d;

    /* renamed from: d0, reason: collision with root package name */
    public float f23724d0;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f23725e;

    /* renamed from: e0, reason: collision with root package name */
    public float[] f23726e0;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f23727f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f23728f0;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f23729g;

    /* renamed from: g0, reason: collision with root package name */
    public int f23730g0;

    /* renamed from: h, reason: collision with root package name */
    public final e f23731h;

    /* renamed from: h0, reason: collision with root package name */
    public int f23732h0;

    /* renamed from: i, reason: collision with root package name */
    public final AccessibilityManager f23733i;

    /* renamed from: i0, reason: collision with root package name */
    public int f23734i0;

    /* renamed from: j, reason: collision with root package name */
    public BaseSlider<S, L, T>.d f23735j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f23736j0;

    /* renamed from: k, reason: collision with root package name */
    public int f23737k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f23738k0;

    /* renamed from: l, reason: collision with root package name */
    public final List<C4.a> f23739l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f23740l0;

    /* renamed from: m, reason: collision with root package name */
    public final List<L> f23741m;

    /* renamed from: m0, reason: collision with root package name */
    public ColorStateList f23742m0;

    /* renamed from: n, reason: collision with root package name */
    public final List<T> f23743n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorStateList f23744n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f23745o;

    /* renamed from: o0, reason: collision with root package name */
    public ColorStateList f23746o0;

    /* renamed from: p, reason: collision with root package name */
    public ValueAnimator f23747p;

    /* renamed from: p0, reason: collision with root package name */
    public ColorStateList f23748p0;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f23749q;

    /* renamed from: q0, reason: collision with root package name */
    public ColorStateList f23750q0;

    /* renamed from: r, reason: collision with root package name */
    public final int f23751r;

    /* renamed from: r0, reason: collision with root package name */
    public final Path f23752r0;

    /* renamed from: s0, reason: collision with root package name */
    public final RectF f23753s0;

    /* renamed from: t0, reason: collision with root package name */
    public final RectF f23754t0;

    /* renamed from: u0, reason: collision with root package name */
    public final i f23755u0;

    /* renamed from: v0, reason: collision with root package name */
    public Drawable f23756v0;

    /* renamed from: w0, reason: collision with root package name */
    public List<Drawable> f23757w0;

    /* renamed from: x, reason: collision with root package name */
    public int f23758x;

    /* renamed from: x0, reason: collision with root package name */
    public float f23759x0;

    /* renamed from: y, reason: collision with root package name */
    public int f23760y;

    /* renamed from: y0, reason: collision with root package name */
    public int f23761y0;

    /* renamed from: z, reason: collision with root package name */
    public int f23762z;

    /* renamed from: z0, reason: collision with root package name */
    public final ViewTreeObserver.OnScrollChangedListener f23763z0;

    /* loaded from: classes3.dex */
    public enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    /* loaded from: classes3.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public float f23769a;

        /* renamed from: b, reason: collision with root package name */
        public float f23770b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<Float> f23771c;

        /* renamed from: d, reason: collision with root package name */
        public float f23772d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f23773e;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i10) {
                return new SliderState[i10];
            }
        }

        public /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.f23769a);
            parcel.writeFloat(this.f23770b);
            parcel.writeList(this.f23771c);
            parcel.writeFloat(this.f23772d);
            parcel.writeBooleanArray(new boolean[]{this.f23773e});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        public SliderState(Parcel parcel) {
            super(parcel);
            this.f23769a = parcel.readFloat();
            this.f23770b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f23771c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f23772d = parcel.readFloat();
            this.f23773e = parcel.createBooleanArray()[0];
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.f23739l.iterator();
            while (it.hasNext()) {
                ((C4.a) it.next()).l(floatValue);
            }
            K.Z(BaseSlider.this);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(BaseSlider.this);
            Iterator it = BaseSlider.this.f23739l.iterator();
            while (it.hasNext()) {
                contentViewOverlay.remove((C4.a) it.next());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23776a;

        static {
            int[] iArr = new int[FullCornerDirection.values().length];
            f23776a = iArr;
            try {
                iArr[FullCornerDirection.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23776a[FullCornerDirection.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23776a[FullCornerDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23776a[FullCornerDirection.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends androidx.customview.widget.a {

        /* renamed from: a, reason: collision with root package name */
        public final BaseSlider<?, ?, ?> f23779a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f23780b;

        public e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f23780b = new Rect();
            this.f23779a = baseSlider;
        }

        public final String a(int i10) {
            if (i10 == this.f23779a.getValues().size() - 1) {
                return this.f23779a.getContext().getString(k.f30985m);
            }
            if (i10 == 0) {
                return this.f23779a.getContext().getString(k.f30986n);
            }
            return "";
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            for (int i10 = 0; i10 < this.f23779a.getValues().size(); i10++) {
                this.f23779a.n0(i10, this.f23780b);
                if (this.f23780b.contains((int) f10, (int) f11)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i10 = 0; i10 < this.f23779a.getValues().size(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (!this.f23779a.isEnabled()) {
                return false;
            }
            if (i11 == 4096 || i11 == 8192) {
                float l10 = this.f23779a.l(20);
                if (i11 == 8192) {
                    l10 = -l10;
                }
                if (this.f23779a.N()) {
                    l10 = -l10;
                }
                if (this.f23779a.l0(i10, E.a.a(this.f23779a.getValues().get(i10).floatValue() + l10, this.f23779a.getValueFrom(), this.f23779a.getValueTo()))) {
                    this.f23779a.o0();
                    this.f23779a.postInvalidate();
                    invalidateVirtualView(i10);
                    return true;
                }
                return false;
            }
            if (i11 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (this.f23779a.l0(i10, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    this.f23779a.o0();
                    this.f23779a.postInvalidate();
                    invalidateVirtualView(i10);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, J.d dVar) {
            dVar.b(d.a.f1379L);
            List<Float> values = this.f23779a.getValues();
            float floatValue = values.get(i10).floatValue();
            float valueFrom = this.f23779a.getValueFrom();
            float valueTo = this.f23779a.getValueTo();
            if (this.f23779a.isEnabled()) {
                if (floatValue > valueFrom) {
                    dVar.a(8192);
                }
                if (floatValue < valueTo) {
                    dVar.a(4096);
                }
            }
            dVar.B0(d.g.a(1, valueFrom, valueTo, floatValue));
            dVar.h0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f23779a.getContentDescription() != null) {
                sb.append(this.f23779a.getContentDescription());
                sb.append(",");
            }
            String A10 = this.f23779a.A(floatValue);
            String string = this.f23779a.getContext().getString(k.f30987o);
            if (values.size() > 1) {
                string = a(i10);
            }
            sb.append(String.format(Locale.US, "%s, %s", string, A10));
            dVar.l0(sb.toString());
            this.f23779a.n0(i10, this.f23780b);
            dVar.c0(this.f23780b);
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30680m0);
    }

    public static float B(ValueAnimator valueAnimator, float f10) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
            return floatValue;
        }
        return f10;
    }

    public static boolean K(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            return false;
        }
        return true;
    }

    private float[] getActiveRange() {
        float floatValue = this.f23718a0.get(0).floatValue();
        ArrayList<Float> arrayList = this.f23718a0;
        float floatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (this.f23718a0.size() == 1) {
            floatValue = this.f23715V;
        }
        float Y9 = Y(floatValue);
        float Y10 = Y(floatValue2);
        if (N()) {
            return new float[]{Y10, Y9};
        }
        return new float[]{Y9, Y10};
    }

    private float getValueOfTouchPosition() {
        double k02 = k0(this.f23759x0);
        if (N()) {
            k02 = 1.0d - k02;
        }
        float f10 = this.f23716W;
        return (float) ((k02 * (f10 - r4)) + this.f23715V);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f10 = this.f23759x0;
        if (N()) {
            f10 = 1.0f - f10;
        }
        float f11 = this.f23716W;
        float f12 = this.f23715V;
        return (f10 * (f11 - f12)) + f12;
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.f23718a0.size() == arrayList.size() && this.f23718a0.equals(arrayList)) {
                return;
            }
            this.f23718a0 = arrayList;
            this.f23740l0 = true;
            this.f23722c0 = 0;
            o0();
            o();
            s();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    public final String A(float f10) {
        String str;
        if (!G()) {
            if (((int) f10) == f10) {
                str = "%.0f";
            } else {
                str = "%.2f";
            }
            return String.format(str, Float.valueOf(f10));
        }
        throw null;
    }

    public final float A0(float f10) {
        return (Y(f10) * this.f23734i0) + this.f23702I;
    }

    public final void B0() {
        float f10 = this.f23724d0;
        if (f10 == 0.0f) {
            return;
        }
        if (((int) f10) != f10) {
            Log.w(f23688A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f10)));
        }
        float f11 = this.f23715V;
        if (((int) f11) != f11) {
            Log.w(f23688A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f11)));
        }
        float f12 = this.f23716W;
        if (((int) f12) != f12) {
            Log.w(f23688A0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f12)));
        }
    }

    public final float C(int i10, float f10) {
        float floatValue;
        float floatValue2;
        float minSeparation = getMinSeparation();
        if (this.f23761y0 == 0) {
            minSeparation = q(minSeparation);
        }
        if (N()) {
            minSeparation = -minSeparation;
        }
        int i11 = i10 + 1;
        if (i11 >= this.f23718a0.size()) {
            floatValue = this.f23716W;
        } else {
            floatValue = this.f23718a0.get(i11).floatValue() - minSeparation;
        }
        int i12 = i10 - 1;
        if (i12 < 0) {
            floatValue2 = this.f23715V;
        } else {
            floatValue2 = this.f23718a0.get(i12).floatValue() + minSeparation;
        }
        return E.a.a(f10, floatValue2, floatValue);
    }

    public final int D(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final float[] E(float f10, float f11) {
        return new float[]{f10, f10, f11, f11, f11, f11, f10, f10};
    }

    public final boolean F() {
        if (this.f23706M > 0) {
            return true;
        }
        return false;
    }

    public boolean G() {
        return false;
    }

    public final Drawable H(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        h(newDrawable);
        return newDrawable;
    }

    public final void I() {
        this.f23717a.setStrokeWidth(this.f23701H);
        this.f23719b.setStrokeWidth(this.f23701H);
    }

    public final boolean J() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean L(double d10) {
        if (Math.abs(Math.round(r2) - new BigDecimal(Double.toString(d10)).divide(new BigDecimal(Float.toString(this.f23724d0)), MathContext.DECIMAL64).doubleValue()) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    public final boolean M(MotionEvent motionEvent) {
        if (!K(motionEvent) && J()) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    public final boolean O() {
        Rect rect = new Rect();
        ViewUtils.getContentView(this).getHitRect(rect);
        return getLocalVisibleRect(rect);
    }

    public final void P(Resources resources) {
        this.f23698E = resources.getDimensionPixelSize(C0979e.f30754P0);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C0979e.f30752O0);
        this.f23758x = dimensionPixelOffset;
        this.f23702I = dimensionPixelOffset;
        this.f23760y = resources.getDimensionPixelSize(C0979e.f30744K0);
        this.f23762z = resources.getDimensionPixelSize(C0979e.f30750N0);
        int i10 = C0979e.f30748M0;
        this.f23694A = resources.getDimensionPixelSize(i10);
        this.f23695B = resources.getDimensionPixelSize(i10);
        this.f23696C = resources.getDimensionPixelSize(C0979e.f30746L0);
        this.f23711R = resources.getDimensionPixelSize(C0979e.f30742J0);
    }

    public final void Q() {
        if (this.f23724d0 <= 0.0f) {
            return;
        }
        t0();
        int min = Math.min((int) (((this.f23716W - this.f23715V) / this.f23724d0) + 1.0f), (this.f23734i0 / this.f23696C) + 1);
        float[] fArr = this.f23726e0;
        if (fArr == null || fArr.length != min * 2) {
            this.f23726e0 = new float[min * 2];
        }
        float f10 = this.f23734i0 / (min - 1);
        for (int i10 = 0; i10 < min * 2; i10 += 2) {
            float[] fArr2 = this.f23726e0;
            fArr2[i10] = this.f23702I + ((i10 / 2.0f) * f10);
            fArr2[i10 + 1] = m();
        }
    }

    public final void R(Canvas canvas, int i10, int i11) {
        if (i0()) {
            canvas.drawCircle((int) (this.f23702I + (Y(this.f23718a0.get(this.f23722c0).floatValue()) * i10)), i11, this.f23705L, this.f23723d);
        }
    }

    public final void S(Canvas canvas, int i10) {
        if (this.f23709P <= 0) {
            return;
        }
        if (this.f23718a0.size() >= 1) {
            ArrayList<Float> arrayList = this.f23718a0;
            float floatValue = arrayList.get(arrayList.size() - 1).floatValue();
            float f10 = this.f23716W;
            if (floatValue < f10) {
                canvas.drawPoint(A0(f10), i10, this.f23729g);
            }
        }
        if (this.f23718a0.size() > 1) {
            float floatValue2 = this.f23718a0.get(0).floatValue();
            float f11 = this.f23715V;
            if (floatValue2 > f11) {
                canvas.drawPoint(A0(f11), i10, this.f23729g);
            }
        }
    }

    public final void T(Canvas canvas) {
        if (this.f23728f0 && this.f23724d0 > 0.0f) {
            float[] activeRange = getActiveRange();
            int ceil = (int) Math.ceil(activeRange[0] * ((this.f23726e0.length / 2.0f) - 1.0f));
            int floor = (int) Math.floor(activeRange[1] * ((this.f23726e0.length / 2.0f) - 1.0f));
            if (ceil > 0) {
                canvas.drawPoints(this.f23726e0, 0, ceil * 2, this.f23725e);
            }
            if (ceil <= floor) {
                canvas.drawPoints(this.f23726e0, ceil * 2, ((floor - ceil) + 1) * 2, this.f23727f);
            }
            int i10 = (floor + 1) * 2;
            float[] fArr = this.f23726e0;
            if (i10 < fArr.length) {
                canvas.drawPoints(fArr, i10, fArr.length - i10, this.f23725e);
            }
        }
    }

    public final boolean U() {
        int max = this.f23758x + Math.max(Math.max(Math.max((this.f23703J / 2) - this.f23760y, 0), Math.max((this.f23701H - this.f23762z) / 2, 0)), Math.max(Math.max(this.f23730g0 - this.f23694A, 0), Math.max(this.f23732h0 - this.f23695B, 0)));
        if (this.f23702I == max) {
            return false;
        }
        this.f23702I = max;
        if (K.O(this)) {
            r0(getWidth());
            return true;
        }
        return true;
    }

    public final boolean V() {
        int max = Math.max(this.f23698E, Math.max(this.f23701H + getPaddingTop() + getPaddingBottom(), this.f23704K + getPaddingTop() + getPaddingBottom()));
        if (max == this.f23699F) {
            return false;
        }
        this.f23699F = max;
        return true;
    }

    public final boolean W(int i10) {
        int i11 = this.f23722c0;
        int c10 = (int) E.a.c(i11 + i10, 0L, this.f23718a0.size() - 1);
        this.f23722c0 = c10;
        if (c10 == i11) {
            return false;
        }
        if (this.f23720b0 != -1) {
            this.f23720b0 = c10;
        }
        o0();
        postInvalidate();
        return true;
    }

    public final boolean X(int i10) {
        if (N()) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = -i10;
            }
        }
        return W(i10);
    }

    public final float Y(float f10) {
        float f11 = this.f23715V;
        float f12 = (f10 - f11) / (this.f23716W - f11);
        if (N()) {
            return 1.0f - f12;
        }
        return f12;
    }

    public final Boolean Z(int i10, KeyEvent keyEvent) {
        if (i10 != 61) {
            if (i10 != 66) {
                if (i10 != 81) {
                    if (i10 != 69) {
                        if (i10 != 70) {
                            switch (i10) {
                                case 21:
                                    X(-1);
                                    return Boolean.TRUE;
                                case 22:
                                    X(1);
                                    return Boolean.TRUE;
                                case 23:
                                    break;
                                default:
                                    return null;
                            }
                        }
                    } else {
                        W(-1);
                        return Boolean.TRUE;
                    }
                }
                W(1);
                return Boolean.TRUE;
            }
            this.f23720b0 = this.f23722c0;
            postInvalidate();
            return Boolean.TRUE;
        }
        if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(W(1));
        }
        if (keyEvent.isShiftPressed()) {
            return Boolean.valueOf(W(-1));
        }
        return Boolean.FALSE;
    }

    public final void a0() {
        Iterator<T> it = this.f23743n.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void b0() {
        Iterator<T> it = this.f23743n.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public boolean c0() {
        boolean z10;
        if (this.f23720b0 != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float A02 = A0(valueOfTouchPositionAbsolute);
        this.f23720b0 = 0;
        float abs = Math.abs(this.f23718a0.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i10 = 1; i10 < this.f23718a0.size(); i10++) {
            float abs2 = Math.abs(this.f23718a0.get(i10).floatValue() - valueOfTouchPositionAbsolute);
            float A03 = A0(this.f23718a0.get(i10).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            if (!N() ? A03 - A02 < 0.0f : A03 - A02 > 0.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.f23720b0 = i10;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(A03 - A02) < this.f23751r) {
                        this.f23720b0 = -1;
                        return false;
                    }
                    if (z10) {
                        this.f23720b0 = i10;
                    }
                }
            }
            abs = abs2;
        }
        if (this.f23720b0 != -1) {
            return true;
        }
        return false;
    }

    public final void d0(C4.a aVar, float f10) {
        int Y9 = (this.f23702I + ((int) (Y(f10) * this.f23734i0))) - (aVar.getIntrinsicWidth() / 2);
        int m10 = m() - (this.f23711R + (this.f23704K / 2));
        aVar.setBounds(Y9, m10 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + Y9, m10);
        Rect rect = new Rect(aVar.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        aVar.setBounds(rect);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.f23731h.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f23717a.setColor(D(this.f23750q0));
        this.f23719b.setColor(D(this.f23748p0));
        this.f23725e.setColor(D(this.f23746o0));
        this.f23727f.setColor(D(this.f23744n0));
        this.f23729g.setColor(D(this.f23748p0));
        for (C4.a aVar : this.f23739l) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.f23755u0.isStateful()) {
            this.f23755u0.setState(getDrawableState());
        }
        this.f23723d.setColor(D(this.f23742m0));
        this.f23723d.setAlpha(63);
    }

    public final void e0(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        int i12;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, m.f31536s9, i10, f23689B0, new int[0]);
        this.f23737k = obtainStyledAttributes.getResourceId(m.f31054A9, l.f31017S);
        this.f23715V = obtainStyledAttributes.getFloat(m.f31569v9, 0.0f);
        this.f23716W = obtainStyledAttributes.getFloat(m.f31580w9, 1.0f);
        setValues(Float.valueOf(this.f23715V));
        this.f23724d0 = obtainStyledAttributes.getFloat(m.f31558u9, 0.0f);
        this.f23697D = (int) Math.ceil(obtainStyledAttributes.getDimension(m.f31065B9, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        int i13 = m.f31230Q9;
        boolean hasValue = obtainStyledAttributes.hasValue(i13);
        if (hasValue) {
            i11 = i13;
        } else {
            i11 = m.f31252S9;
        }
        if (!hasValue) {
            i13 = m.f31241R9;
        }
        ColorStateList a10 = C1607c.a(context, obtainStyledAttributes, i11);
        if (a10 == null) {
            a10 = C0991a.a(context, C0978d.f30717k);
        }
        setTrackInactiveTintList(a10);
        ColorStateList a11 = C1607c.a(context, obtainStyledAttributes, i13);
        if (a11 == null) {
            a11 = C0991a.a(context, C0978d.f30714h);
        }
        setTrackActiveTintList(a11);
        this.f23755u0.setFillColor(C1607c.a(context, obtainStyledAttributes, m.f31076C9));
        int i14 = m.f31120G9;
        if (obtainStyledAttributes.hasValue(i14)) {
            setThumbStrokeColor(C1607c.a(context, obtainStyledAttributes, i14));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(m.f31131H9, 0.0f));
        ColorStateList a12 = C1607c.a(context, obtainStyledAttributes, m.f31591x9);
        if (a12 == null) {
            a12 = C0991a.a(context, C0978d.f30715i);
        }
        setHaloTintList(a12);
        this.f23728f0 = obtainStyledAttributes.getBoolean(m.f31219P9, true);
        int i15 = m.f31164K9;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i15);
        if (hasValue2) {
            i12 = i15;
        } else {
            i12 = m.f31186M9;
        }
        if (!hasValue2) {
            i15 = m.f31175L9;
        }
        ColorStateList a13 = C1607c.a(context, obtainStyledAttributes, i12);
        if (a13 == null) {
            a13 = C0991a.a(context, C0978d.f30716j);
        }
        setTickInactiveTintList(a13);
        ColorStateList a14 = C1607c.a(context, obtainStyledAttributes, i15);
        if (a14 == null) {
            a14 = C0991a.a(context, C0978d.f30713g);
        }
        setTickActiveTintList(a14);
        setThumbTrackGapSize(obtainStyledAttributes.getDimensionPixelSize(m.f31142I9, 0));
        setTrackStopIndicatorSize(obtainStyledAttributes.getDimensionPixelSize(m.f31285V9, 0));
        setTrackInsideCornerSize(obtainStyledAttributes.getDimensionPixelSize(m.f31274U9, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(m.f31109F9, 0) * 2;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(m.f31153J9, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(m.f31098E9, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(m.f31602y9, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(m.f31087D9, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(m.f31263T9, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(m.f31197N9, this.f23709P / 2));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(m.f31208O9, this.f23709P / 2));
        setLabelBehavior(obtainStyledAttributes.getInt(m.f31613z9, 0));
        if (!obtainStyledAttributes.getBoolean(m.f31547t9, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    public final void f0(int i10) {
        BaseSlider<S, L, T>.d dVar = this.f23735j;
        if (dVar == null) {
            this.f23735j = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.f23735j.a(i10);
        postDelayed(this.f23735j, 200L);
    }

    public final void g0(C4.a aVar, float f10) {
        aVar.m(A(f10));
        d0(aVar, f10);
        ViewUtils.getContentViewOverlay(this).add(aVar);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f23731h.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.f23720b0;
    }

    public int getFocusedThumbIndex() {
        return this.f23722c0;
    }

    public int getHaloRadius() {
        return this.f23705L;
    }

    public ColorStateList getHaloTintList() {
        return this.f23742m0;
    }

    public int getLabelBehavior() {
        return this.f23700G;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.f23724d0;
    }

    public float getThumbElevation() {
        return this.f23755u0.getElevation();
    }

    public int getThumbHeight() {
        return this.f23704K;
    }

    public int getThumbRadius() {
        return this.f23703J / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f23755u0.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.f23755u0.getStrokeWidth();
    }

    public ColorStateList getThumbTintList() {
        return this.f23755u0.getFillColor();
    }

    public int getThumbTrackGapSize() {
        return this.f23706M;
    }

    public int getThumbWidth() {
        return this.f23703J;
    }

    public int getTickActiveRadius() {
        return this.f23730g0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f23744n0;
    }

    public int getTickInactiveRadius() {
        return this.f23732h0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f23746o0;
    }

    public ColorStateList getTickTintList() {
        if (this.f23746o0.equals(this.f23744n0)) {
            return this.f23744n0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f23748p0;
    }

    public int getTrackHeight() {
        return this.f23701H;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f23750q0;
    }

    public int getTrackInsideCornerSize() {
        return this.f23710Q;
    }

    public int getTrackSidePadding() {
        return this.f23702I;
    }

    public int getTrackStopIndicatorSize() {
        return this.f23709P;
    }

    public ColorStateList getTrackTintList() {
        if (this.f23750q0.equals(this.f23748p0)) {
            return this.f23748p0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f23734i0;
    }

    public float getValueFrom() {
        return this.f23715V;
    }

    public float getValueTo() {
        return this.f23716W;
    }

    public List<Float> getValues() {
        return new ArrayList(this.f23718a0);
    }

    public final void h(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.f23703J, this.f23704K);
        } else {
            float max = Math.max(this.f23703J, this.f23704K) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    public final boolean h0() {
        if (this.f23700G == 3) {
            return true;
        }
        return false;
    }

    public final void i(C4.a aVar) {
        aVar.k(ViewUtils.getContentView(this));
    }

    public final boolean i0() {
        if (!this.f23736j0 && (getBackground() instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    public final Float j(int i10) {
        float k10;
        if (this.f23738k0) {
            k10 = l(20);
        } else {
            k10 = k();
        }
        if (i10 != 21) {
            if (i10 != 22) {
                if (i10 != 69) {
                    if (i10 != 70 && i10 != 81) {
                        return null;
                    }
                    return Float.valueOf(k10);
                }
                return Float.valueOf(-k10);
            }
            if (N()) {
                k10 = -k10;
            }
            return Float.valueOf(k10);
        }
        if (!N()) {
            k10 = -k10;
        }
        return Float.valueOf(k10);
    }

    public final boolean j0(float f10) {
        return l0(this.f23720b0, f10);
    }

    public final float k() {
        float f10 = this.f23724d0;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        return f10;
    }

    public final double k0(float f10) {
        float f11 = this.f23724d0;
        if (f11 > 0.0f) {
            return Math.round(f10 * r2) / ((int) ((this.f23716W - this.f23715V) / f11));
        }
        return f10;
    }

    public final float l(int i10) {
        float k10 = k();
        if ((this.f23716W - this.f23715V) / k10 <= i10) {
            return k10;
        }
        return Math.round(r1 / r2) * k10;
    }

    public final boolean l0(int i10, float f10) {
        this.f23722c0 = i10;
        if (Math.abs(f10 - this.f23718a0.get(i10).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.f23718a0.set(i10, Float.valueOf(C(i10, f10)));
        r(i10);
        return true;
    }

    public final int m() {
        int i10 = this.f23699F / 2;
        int i11 = 0;
        if (this.f23700G == 1 || h0()) {
            i11 = this.f23739l.get(0).getIntrinsicHeight();
        }
        return i10 + i11;
    }

    public final boolean m0() {
        return j0(getValueOfTouchPosition());
    }

    public final ValueAnimator n(boolean z10) {
        float f10;
        ValueAnimator valueAnimator;
        int f11;
        TimeInterpolator g10;
        float f12 = 1.0f;
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (z10) {
            valueAnimator = this.f23749q;
        } else {
            valueAnimator = this.f23747p;
        }
        float B10 = B(valueAnimator, f10);
        if (!z10) {
            f12 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(B10, f12);
        if (z10) {
            f11 = C1550i.f(getContext(), f23690C0, 83);
            g10 = C1550i.g(getContext(), f23692E0, C1001b.f31706e);
        } else {
            f11 = C1550i.f(getContext(), f23691D0, 117);
            g10 = C1550i.g(getContext(), f23693F0, C1001b.f31704c);
        }
        ofFloat.setDuration(f11);
        ofFloat.setInterpolator(g10);
        ofFloat.addUpdateListener(new a());
        return ofFloat;
    }

    public void n0(int i10, Rect rect) {
        int Y9 = this.f23702I + ((int) (Y(getValues().get(i10).floatValue()) * this.f23734i0));
        int m10 = m();
        int max = Math.max(this.f23703J / 2, this.f23697D / 2);
        int max2 = Math.max(this.f23704K / 2, this.f23697D / 2);
        rect.set(Y9 - max, m10 - max2, Y9 + max, m10 + max2);
    }

    public final void o() {
        int i10;
        if (this.f23739l.size() > this.f23718a0.size()) {
            List<C4.a> subList = this.f23739l.subList(this.f23718a0.size(), this.f23739l.size());
            for (C4.a aVar : subList) {
                if (K.N(this)) {
                    p(aVar);
                }
            }
            subList.clear();
        }
        while (true) {
            i10 = 0;
            if (this.f23739l.size() >= this.f23718a0.size()) {
                break;
            }
            C4.a e10 = C4.a.e(getContext(), null, 0, this.f23737k);
            this.f23739l.add(e10);
            if (K.N(this)) {
                i(e10);
            }
        }
        if (this.f23739l.size() != 1) {
            i10 = 1;
        }
        Iterator<C4.a> it = this.f23739l.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i10);
        }
    }

    public final void o0() {
        if (!i0() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int Y9 = (int) ((Y(this.f23718a0.get(this.f23722c0).floatValue()) * this.f23734i0) + this.f23702I);
                int m10 = m();
                int i10 = this.f23705L;
                C.a.l(background, Y9 - i10, m10 - i10, Y9 + i10, m10 + i10);
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.f23763z0);
        Iterator<C4.a> it = this.f23739l.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.f23735j;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.f23745o = false;
        Iterator<C4.a> it = this.f23739l.iterator();
        while (it.hasNext()) {
            p(it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.f23763z0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f23740l0) {
            t0();
            Q();
        }
        super.onDraw(canvas);
        int m10 = m();
        float floatValue = this.f23718a0.get(0).floatValue();
        ArrayList<Float> arrayList = this.f23718a0;
        float floatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (floatValue2 < this.f23716W || (this.f23718a0.size() > 1 && floatValue > this.f23715V)) {
            u(canvas, this.f23734i0, m10);
        }
        if (floatValue2 > this.f23715V) {
            t(canvas, this.f23734i0, m10);
        }
        T(canvas);
        S(canvas, m10);
        if ((this.f23714U || isFocused()) && isEnabled()) {
            R(canvas, this.f23734i0, m10);
        }
        p0();
        w(canvas, this.f23734i0, m10);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!z10) {
            this.f23720b0 = -1;
            this.f23731h.clearKeyboardFocusForVirtualView(this.f23722c0);
        } else {
            z(i10);
            this.f23731h.requestKeyboardFocusForVirtualView(this.f23722c0);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.f23718a0.size() == 1) {
            this.f23720b0 = 0;
        }
        if (this.f23720b0 == -1) {
            Boolean Z9 = Z(i10, keyEvent);
            if (Z9 != null) {
                return Z9.booleanValue();
            }
            return super.onKeyDown(i10, keyEvent);
        }
        this.f23738k0 |= keyEvent.isLongPress();
        Float j10 = j(i10);
        if (j10 != null) {
            if (j0(this.f23718a0.get(this.f23720b0).floatValue() + j10.floatValue())) {
                o0();
                postInvalidate();
            }
            return true;
        }
        if (i10 != 23) {
            if (i10 != 61) {
                if (i10 != 66) {
                    return super.onKeyDown(i10, keyEvent);
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    return W(1);
                }
                if (!keyEvent.isShiftPressed()) {
                    return false;
                }
                return W(-1);
            }
        }
        this.f23720b0 = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        this.f23738k0 = false;
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f23699F;
        int i13 = 0;
        if (this.f23700G == 1 || h0()) {
            i13 = this.f23739l.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i12 + i13, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f23715V = sliderState.f23769a;
        this.f23716W = sliderState.f23770b;
        setValuesInternal(sliderState.f23771c);
        this.f23724d0 = sliderState.f23772d;
        if (sliderState.f23773e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f23769a = this.f23715V;
        sliderState.f23770b = this.f23716W;
        sliderState.f23771c = new ArrayList<>(this.f23718a0);
        sliderState.f23772d = this.f23724d0;
        sliderState.f23773e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        r0(i10);
        o0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r2 != 3) goto L56;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        ViewOverlayImpl contentViewOverlay;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 || (contentViewOverlay = ViewUtils.getContentViewOverlay(this)) == null) {
            return;
        }
        Iterator<C4.a> it = this.f23739l.iterator();
        while (it.hasNext()) {
            contentViewOverlay.remove(it.next());
        }
    }

    public final void p(C4.a aVar) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(aVar);
            aVar.g(ViewUtils.getContentView(this));
        }
    }

    public final void p0() {
        int i10 = this.f23700G;
        if (i10 != 0 && i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    if (isEnabled() && O()) {
                        x();
                        return;
                    } else {
                        y();
                        return;
                    }
                }
                throw new IllegalArgumentException("Unexpected labelBehavior: " + this.f23700G);
            }
            y();
            return;
        }
        if (this.f23720b0 != -1 && isEnabled()) {
            x();
        } else {
            y();
        }
    }

    public final float q(float f10) {
        if (f10 == 0.0f) {
            return 0.0f;
        }
        float f11 = (f10 - this.f23702I) / this.f23734i0;
        float f12 = this.f23715V;
        return (f11 * (f12 - this.f23716W)) + f12;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q0(android.graphics.Canvas r9, android.graphics.Paint r10, android.graphics.RectF r11, com.google.android.material.slider.BaseSlider.FullCornerDirection r12) {
        /*
            r8 = this;
            int r0 = r8.f23701H
            float r1 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r0 = (float) r0
            float r0 = r0 / r2
            int[] r3 = com.google.android.material.slider.BaseSlider.c.f23776a
            int r4 = r12.ordinal()
            r4 = r3[r4]
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == r7) goto L22
            if (r4 == r6) goto L1e
            if (r4 == r5) goto L1a
            goto L26
        L1a:
            int r1 = r8.f23710Q
            float r1 = (float) r1
            goto L26
        L1e:
            int r0 = r8.f23710Q
        L20:
            float r0 = (float) r0
            goto L26
        L22:
            int r0 = r8.f23710Q
            float r1 = (float) r0
            goto L20
        L26:
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.BUTT
            r10.setStrokeCap(r4)
            r10.setAntiAlias(r7)
            android.graphics.Path r4 = r8.f23752r0
            r4.reset()
            float r4 = r11.width()
            float r7 = r1 + r0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 < 0) goto L53
            android.graphics.Path r12 = r8.f23752r0
            float[] r0 = r8.E(r1, r0)
            android.graphics.Path$Direction r1 = android.graphics.Path.Direction.CW
            r12.addRoundRect(r11, r0, r1)
            android.graphics.Path r8 = r8.f23752r0
            r9.drawPath(r8, r10)
            goto Lac
        L53:
            float r4 = java.lang.Math.min(r1, r0)
            float r0 = java.lang.Math.max(r1, r0)
            r9.save()
            android.graphics.Path r1 = r8.f23752r0
            android.graphics.Path$Direction r7 = android.graphics.Path.Direction.CW
            r1.addRoundRect(r11, r4, r4, r7)
            android.graphics.Path r1 = r8.f23752r0
            r9.clipPath(r1)
            int r12 = r12.ordinal()
            r12 = r3[r12]
            if (r12 == r6) goto L97
            if (r12 == r5) goto L88
            android.graphics.RectF r12 = r8.f23754t0
            float r1 = r11.centerX()
            float r1 = r1 - r0
            float r2 = r11.top
            float r3 = r11.centerX()
            float r3 = r3 + r0
            float r11 = r11.bottom
            r12.set(r1, r2, r3, r11)
            goto La4
        L88:
            android.graphics.RectF r12 = r8.f23754t0
            float r1 = r11.right
            float r2 = r2 * r0
            float r2 = r1 - r2
            float r3 = r11.top
            float r11 = r11.bottom
            r12.set(r2, r3, r1, r11)
            goto La4
        L97:
            android.graphics.RectF r12 = r8.f23754t0
            float r1 = r11.left
            float r3 = r11.top
            float r2 = r2 * r0
            float r2 = r2 + r1
            float r11 = r11.bottom
            r12.set(r1, r3, r2, r11)
        La4:
            android.graphics.RectF r8 = r8.f23754t0
            r9.drawRoundRect(r8, r0, r0, r10)
            r9.restore()
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.q0(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    public final void r(int i10) {
        Iterator<L> it = this.f23741m.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f23718a0.get(i10).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f23733i;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            f0(i10);
        }
    }

    public final void r0(int i10) {
        this.f23734i0 = Math.max(i10 - (this.f23702I * 2), 0);
        Q();
    }

    public final void s() {
        for (L l10 : this.f23741m) {
            Iterator<Float> it = this.f23718a0.iterator();
            while (it.hasNext()) {
                l10.a(this, it.next().floatValue(), false);
            }
        }
    }

    public final void s0() {
        boolean V10 = V();
        boolean U10 = U();
        if (V10) {
            requestLayout();
        } else if (U10) {
            postInvalidate();
        }
    }

    public void setActiveThumbIndex(int i10) {
        this.f23720b0 = i10;
    }

    public void setCustomThumbDrawable(int i10) {
        setCustomThumbDrawable(getResources().getDrawable(i10));
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            drawableArr[i10] = getResources().getDrawable(iArr[i10]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        int i10;
        super.setEnabled(z10);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        setLayerType(i10, null);
    }

    public void setFocusedThumbIndex(int i10) {
        if (i10 >= 0 && i10 < this.f23718a0.size()) {
            this.f23722c0 = i10;
            this.f23731h.requestKeyboardFocusForVirtualView(i10);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(int i10) {
        if (i10 == this.f23705L) {
            return;
        }
        this.f23705L = i10;
        Drawable background = getBackground();
        if (!i0() && (background instanceof RippleDrawable)) {
            C1370a.m((RippleDrawable) background, this.f23705L);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(int i10) {
        setHaloRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f23742m0)) {
            return;
        }
        this.f23742m0 = colorStateList;
        Drawable background = getBackground();
        if (!i0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f23723d.setColor(D(colorStateList));
        this.f23723d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i10) {
        if (this.f23700G != i10) {
            this.f23700G = i10;
            requestLayout();
        }
    }

    public void setSeparationUnit(int i10) {
        this.f23761y0 = i10;
        this.f23740l0 = true;
        postInvalidate();
    }

    public void setStepSize(float f10) {
        if (f10 >= 0.0f) {
            if (this.f23724d0 != f10) {
                this.f23724d0 = f10;
                this.f23740l0 = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f10), Float.valueOf(this.f23715V), Float.valueOf(this.f23716W)));
    }

    public void setThumbElevation(float f10) {
        this.f23755u0.setElevation(f10);
    }

    public void setThumbElevationResource(int i10) {
        setThumbElevation(getResources().getDimension(i10));
    }

    public void setThumbHeight(int i10) {
        if (i10 == this.f23704K) {
            return;
        }
        this.f23704K = i10;
        this.f23755u0.setBounds(0, 0, this.f23703J, i10);
        Drawable drawable = this.f23756v0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator<Drawable> it = this.f23757w0.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
        s0();
    }

    public void setThumbHeightResource(int i10) {
        setThumbHeight(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbRadius(int i10) {
        int i11 = i10 * 2;
        setThumbWidth(i11);
        setThumbHeight(i11);
    }

    public void setThumbRadiusResource(int i10) {
        setThumbRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f23755u0.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeColor(C0991a.a(getContext(), i10));
        }
    }

    public void setThumbStrokeWidth(float f10) {
        this.f23755u0.setStrokeWidth(f10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i10));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f23755u0.getFillColor())) {
            return;
        }
        this.f23755u0.setFillColor(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(int i10) {
        if (this.f23706M == i10) {
            return;
        }
        this.f23706M = i10;
        invalidate();
    }

    public void setThumbWidth(int i10) {
        if (i10 == this.f23703J) {
            return;
        }
        this.f23703J = i10;
        this.f23755u0.setShapeAppearanceModel(n.a().q(0, this.f23703J / 2.0f).m());
        this.f23755u0.setBounds(0, 0, this.f23703J, this.f23704K);
        Drawable drawable = this.f23756v0;
        if (drawable != null) {
            h(drawable);
        }
        Iterator<Drawable> it = this.f23757w0.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
        s0();
    }

    public void setThumbWidthResource(int i10) {
        setThumbWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setTickActiveRadius(int i10) {
        if (this.f23730g0 != i10) {
            this.f23730g0 = i10;
            this.f23727f.setStrokeWidth(i10 * 2);
            s0();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f23744n0)) {
            return;
        }
        this.f23744n0 = colorStateList;
        this.f23727f.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i10) {
        if (this.f23732h0 != i10) {
            this.f23732h0 = i10;
            this.f23725e.setStrokeWidth(i10 * 2);
            s0();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f23746o0)) {
            return;
        }
        this.f23746o0 = colorStateList;
        this.f23725e.setColor(D(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z10) {
        if (this.f23728f0 != z10) {
            this.f23728f0 = z10;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f23748p0)) {
            return;
        }
        this.f23748p0 = colorStateList;
        this.f23719b.setColor(D(colorStateList));
        this.f23729g.setColor(D(this.f23748p0));
        invalidate();
    }

    public void setTrackHeight(int i10) {
        if (this.f23701H != i10) {
            this.f23701H = i10;
            I();
            s0();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f23750q0)) {
            return;
        }
        this.f23750q0 = colorStateList;
        this.f23717a.setColor(D(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i10) {
        if (this.f23710Q == i10) {
            return;
        }
        this.f23710Q = i10;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i10) {
        if (this.f23709P == i10) {
            return;
        }
        this.f23709P = i10;
        this.f23729g.setStrokeWidth(i10);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f10) {
        this.f23715V = f10;
        this.f23740l0 = true;
        postInvalidate();
    }

    public void setValueTo(float f10) {
        this.f23716W = f10;
        this.f23740l0 = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.graphics.Canvas r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.t(android.graphics.Canvas, int, int):void");
    }

    public final void t0() {
        if (this.f23740l0) {
            w0();
            x0();
            v0();
            y0();
            u0();
            B0();
            this.f23740l0 = false;
        }
    }

    public final void u(Canvas canvas, int i10, int i11) {
        float[] activeRange = getActiveRange();
        float f10 = i10;
        float f11 = this.f23702I + (activeRange[1] * f10);
        if (f11 < r1 + i10) {
            if (F()) {
                float f12 = i11;
                int i12 = this.f23701H;
                this.f23753s0.set(f11 + this.f23706M, f12 - (i12 / 2.0f), this.f23702I + i10 + (i12 / 2.0f), f12 + (i12 / 2.0f));
                q0(canvas, this.f23717a, this.f23753s0, FullCornerDirection.RIGHT);
            } else {
                this.f23717a.setStyle(Paint.Style.STROKE);
                this.f23717a.setStrokeCap(Paint.Cap.ROUND);
                float f13 = i11;
                canvas.drawLine(f11, f13, this.f23702I + i10, f13, this.f23717a);
            }
        }
        int i13 = this.f23702I;
        float f14 = i13 + (activeRange[0] * f10);
        if (f14 > i13) {
            if (F()) {
                RectF rectF = this.f23753s0;
                float f15 = this.f23702I;
                int i14 = this.f23701H;
                float f16 = i11;
                rectF.set(f15 - (i14 / 2.0f), f16 - (i14 / 2.0f), f14 - this.f23706M, f16 + (i14 / 2.0f));
                q0(canvas, this.f23717a, this.f23753s0, FullCornerDirection.LEFT);
                return;
            }
            this.f23717a.setStyle(Paint.Style.STROKE);
            this.f23717a.setStrokeCap(Paint.Cap.ROUND);
            float f17 = i11;
            canvas.drawLine(this.f23702I, f17, f14, f17, this.f23717a);
        }
    }

    public final void u0() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= 0.0f) {
            float f10 = this.f23724d0;
            if (f10 > 0.0f && minSeparation > 0.0f) {
                if (this.f23761y0 == 1) {
                    if (minSeparation < f10 || !L(minSeparation)) {
                        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f23724d0), Float.valueOf(this.f23724d0)));
                    }
                    return;
                }
                throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f23724d0)));
            }
            return;
        }
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
    }

    public final void v(Canvas canvas, int i10, int i11, float f10, Drawable drawable) {
        canvas.save();
        canvas.translate((this.f23702I + ((int) (Y(f10) * i10))) - (drawable.getBounds().width() / 2.0f), i11 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void v0() {
        if (this.f23724d0 > 0.0f && !z0(this.f23716W)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.f23724d0), Float.valueOf(this.f23715V), Float.valueOf(this.f23716W)));
        }
    }

    public final void w(Canvas canvas, int i10, int i11) {
        for (int i12 = 0; i12 < this.f23718a0.size(); i12++) {
            float floatValue = this.f23718a0.get(i12).floatValue();
            Drawable drawable = this.f23756v0;
            if (drawable != null) {
                v(canvas, i10, i11, floatValue, drawable);
            } else if (i12 < this.f23757w0.size()) {
                v(canvas, i10, i11, floatValue, this.f23757w0.get(i12));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.f23702I + (Y(floatValue) * i10), i11, getThumbRadius(), this.f23721c);
                }
                v(canvas, i10, i11, floatValue, this.f23755u0);
            }
        }
    }

    public final void w0() {
        if (this.f23715V < this.f23716W) {
        } else {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.f23715V), Float.valueOf(this.f23716W)));
        }
    }

    public final void x() {
        if (!this.f23745o) {
            this.f23745o = true;
            ValueAnimator n10 = n(true);
            this.f23747p = n10;
            this.f23749q = null;
            n10.start();
        }
        Iterator<C4.a> it = this.f23739l.iterator();
        for (int i10 = 0; i10 < this.f23718a0.size() && it.hasNext(); i10++) {
            if (i10 != this.f23722c0) {
                g0(it.next(), this.f23718a0.get(i10).floatValue());
            }
        }
        if (it.hasNext()) {
            g0(it.next(), this.f23718a0.get(this.f23722c0).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f23739l.size()), Integer.valueOf(this.f23718a0.size())));
    }

    public final void x0() {
        if (this.f23716W > this.f23715V) {
        } else {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.f23716W), Float.valueOf(this.f23715V)));
        }
    }

    public final void y() {
        if (this.f23745o) {
            this.f23745o = false;
            ValueAnimator n10 = n(false);
            this.f23749q = n10;
            this.f23747p = null;
            n10.addListener(new b());
            this.f23749q.start();
        }
    }

    public final void y0() {
        Iterator<Float> it = this.f23718a0.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() >= this.f23715V && next.floatValue() <= this.f23716W) {
                if (this.f23724d0 > 0.0f && !z0(next.floatValue())) {
                    throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", next, Float.valueOf(this.f23715V), Float.valueOf(this.f23724d0), Float.valueOf(this.f23724d0)));
                }
            } else {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", next, Float.valueOf(this.f23715V), Float.valueOf(this.f23716W)));
            }
        }
    }

    public final void z(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 == 66) {
                        X(Integer.MIN_VALUE);
                        return;
                    }
                    return;
                }
                X(Integer.MAX_VALUE);
                return;
            }
            W(Integer.MIN_VALUE);
            return;
        }
        W(Integer.MAX_VALUE);
    }

    public final boolean z0(float f10) {
        return L(new BigDecimal(Float.toString(f10)).subtract(new BigDecimal(Float.toString(this.f23715V)), MathContext.DECIMAL64).doubleValue());
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f23777a;

        public d() {
            this.f23777a = -1;
        }

        public void a(int i10) {
            this.f23777a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f23731h.sendEventForVirtualView(this.f23777a, 4);
        }

        public /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i10) {
        super(B4.a.c(context, attributeSet, i10, f23689B0), attributeSet, i10);
        this.f23739l = new ArrayList();
        this.f23741m = new ArrayList();
        this.f23743n = new ArrayList();
        this.f23745o = false;
        this.f23707N = -1;
        this.f23708O = -1;
        this.f23714U = false;
        this.f23718a0 = new ArrayList<>();
        this.f23720b0 = -1;
        this.f23722c0 = -1;
        this.f23724d0 = 0.0f;
        this.f23728f0 = true;
        this.f23738k0 = false;
        this.f23752r0 = new Path();
        this.f23753s0 = new RectF();
        this.f23754t0 = new RectF();
        i iVar = new i();
        this.f23755u0 = iVar;
        this.f23757w0 = Collections.emptyList();
        this.f23761y0 = 0;
        this.f23763z0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                BaseSlider.this.p0();
            }
        };
        Context context2 = getContext();
        this.f23717a = new Paint();
        this.f23719b = new Paint();
        Paint paint = new Paint(1);
        this.f23721c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.f23723d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f23725e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f23727f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.f23729g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        P(context2.getResources());
        e0(context2, attributeSet, i10);
        setFocusable(true);
        setClickable(true);
        iVar.setShadowCompatibilityMode(2);
        this.f23751r = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.f23731h = eVar;
        K.j0(this, eVar);
        this.f23733i = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        this.f23756v0 = H(drawable);
        this.f23757w0.clear();
        postInvalidate();
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f23756v0 = null;
        this.f23757w0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.f23757w0.add(H(drawable));
        }
        postInvalidate();
    }

    public void setLabelFormatter(com.google.android.material.slider.d dVar) {
    }
}
