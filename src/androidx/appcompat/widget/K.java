package androidx.appcompat.widget;

import A.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import f.C0991a;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class K {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7724a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f7725b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f7726c;

    public K(Context context, TypedArray typedArray) {
        this.f7724a = context;
        this.f7725b = typedArray;
    }

    public static K u(Context context, int i10, int[] iArr) {
        return new K(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static K v(Context context, AttributeSet attributeSet, int[] iArr) {
        return new K(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static K w(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new K(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f7725b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f7725b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList a10;
        if (this.f7725b.hasValue(i10) && (resourceId = this.f7725b.getResourceId(i10, 0)) != 0 && (a10 = C0991a.a(this.f7724a, resourceId)) != null) {
            return a10;
        }
        return this.f7725b.getColorStateList(i10);
    }

    public float d(int i10, float f10) {
        return this.f7725b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f7725b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f7725b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        if (this.f7725b.hasValue(i10) && (resourceId = this.f7725b.getResourceId(i10, 0)) != 0) {
            return C0991a.b(this.f7724a, resourceId);
        }
        return this.f7725b.getDrawable(i10);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (this.f7725b.hasValue(i10) && (resourceId = this.f7725b.getResourceId(i10, 0)) != 0) {
            return C0433g.b().d(this.f7724a, resourceId, true);
        }
        return null;
    }

    public float i(int i10, float f10) {
        return this.f7725b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.e eVar) {
        int resourceId = this.f7725b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f7726c == null) {
            this.f7726c = new TypedValue();
        }
        return A.h.i(this.f7724a, resourceId, this.f7726c, i11, eVar);
    }

    public int k(int i10, int i11) {
        return this.f7725b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f7725b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f7725b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f7725b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f7725b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f7725b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f7725b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f7725b;
    }

    public boolean s(int i10) {
        return this.f7725b.hasValue(i10);
    }

    public int t() {
        return this.f7725b.length();
    }

    public TypedValue x(int i10) {
        return this.f7725b.peekValue(i10);
    }

    public void y() {
        this.f7725b.recycle();
    }
}
