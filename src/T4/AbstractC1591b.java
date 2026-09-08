package t4;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0977c;
import e4.C0979e;
import e4.m;
import l4.C1292a;
import u4.C1607c;

/* compiled from: BaseProgressIndicatorSpec.java */
/* renamed from: t4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1591b {

    /* renamed from: a, reason: collision with root package name */
    public int f37182a;

    /* renamed from: b, reason: collision with root package name */
    public int f37183b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f37184c = new int[0];

    /* renamed from: d, reason: collision with root package name */
    public int f37185d;

    /* renamed from: e, reason: collision with root package name */
    public int f37186e;

    /* renamed from: f, reason: collision with root package name */
    public int f37187f;

    /* renamed from: g, reason: collision with root package name */
    public int f37188g;

    public AbstractC1591b(Context context, AttributeSet attributeSet, int i10, int i11) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0979e.f30738H0);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, m.f31406h0, i10, i11, new int[0]);
        this.f37182a = C1607c.d(context, obtainStyledAttributes, m.f31505q0, dimensionPixelSize);
        this.f37183b = Math.min(C1607c.d(context, obtainStyledAttributes, m.f31494p0, 0), this.f37182a / 2);
        this.f37186e = obtainStyledAttributes.getInt(m.f31461m0, 0);
        this.f37187f = obtainStyledAttributes.getInt(m.f31417i0, 0);
        this.f37188g = obtainStyledAttributes.getDimensionPixelSize(m.f31439k0, 0);
        c(context, obtainStyledAttributes);
        d(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public boolean a() {
        if (this.f37187f != 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f37186e != 0) {
            return true;
        }
        return false;
    }

    public final void c(Context context, TypedArray typedArray) {
        int i10 = m.f31428j0;
        if (!typedArray.hasValue(i10)) {
            this.f37184c = new int[]{C1292a.b(context, C0977c.f30693t, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.f37184c = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.f37184c = intArray;
        if (intArray.length != 0) {
        } else {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    public final void d(Context context, TypedArray typedArray) {
        int i10 = m.f31483o0;
        if (typedArray.hasValue(i10)) {
            this.f37185d = typedArray.getColor(i10, -1);
            return;
        }
        this.f37185d = this.f37184c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f10 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f37185d = C1292a.a(this.f37185d, (int) (f10 * 255.0f));
    }

    public void e() {
        if (this.f37188g >= 0) {
        } else {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
