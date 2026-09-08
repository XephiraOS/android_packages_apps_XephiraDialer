package androidx.appcompat.widget;

import A.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper.java */
/* renamed from: androidx.appcompat.widget.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0443q {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7886a;

    /* renamed from: b, reason: collision with root package name */
    public I f7887b;

    /* renamed from: c, reason: collision with root package name */
    public I f7888c;

    /* renamed from: d, reason: collision with root package name */
    public I f7889d;

    /* renamed from: e, reason: collision with root package name */
    public I f7890e;

    /* renamed from: f, reason: collision with root package name */
    public I f7891f;

    /* renamed from: g, reason: collision with root package name */
    public I f7892g;

    /* renamed from: h, reason: collision with root package name */
    public I f7893h;

    /* renamed from: i, reason: collision with root package name */
    public final r f7894i;

    /* renamed from: j, reason: collision with root package name */
    public int f7895j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f7896k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f7897l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7898m;

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: androidx.appcompat.widget.q$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f7903a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f7904b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f7905c;

        public b(TextView textView, Typeface typeface, int i10) {
            this.f7903a = textView;
            this.f7904b = typeface;
            this.f7905c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7903a.setTypeface(this.f7904b, this.f7905c);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: androidx.appcompat.widget.q$c */
    /* loaded from: classes.dex */
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: androidx.appcompat.widget.q$d */
    /* loaded from: classes.dex */
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        public static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: androidx.appcompat.widget.q$e */
    /* loaded from: classes.dex */
    public static class e {
        public static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    public C0443q(TextView textView) {
        this.f7886a = textView;
        this.f7894i = new r(textView);
    }

    public static I d(Context context, C0433g c0433g, int i10) {
        ColorStateList f10 = c0433g.f(context, i10);
        if (f10 != null) {
            I i11 = new I();
            i11.f7722d = true;
            i11.f7719a = f10;
            return i11;
        }
        return null;
    }

    public void A(int i10, float f10) {
        if (!S.f7793a && !l()) {
            B(i10, f10);
        }
    }

    public final void B(int i10, float f10) {
        this.f7894i.t(i10, f10);
    }

    public final void C(Context context, K k10) {
        String o10;
        boolean z10;
        boolean z11;
        this.f7895j = k10.k(e.j.f30444f3, this.f7895j);
        int k11 = k10.k(e.j.f30459i3, -1);
        this.f7896k = k11;
        if (k11 != -1) {
            this.f7895j &= 2;
        }
        int i10 = e.j.f30454h3;
        boolean z12 = true;
        if (!k10.s(i10) && !k10.s(e.j.f30464j3)) {
            int i11 = e.j.f30439e3;
            if (k10.s(i11)) {
                this.f7898m = false;
                int k12 = k10.k(i11, 1);
                if (k12 != 1) {
                    if (k12 != 2) {
                        if (k12 == 3) {
                            this.f7897l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f7897l = Typeface.SERIF;
                    return;
                }
                this.f7897l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f7897l = null;
        int i12 = e.j.f30464j3;
        if (k10.s(i12)) {
            i10 = i12;
        }
        int i13 = this.f7896k;
        int i14 = this.f7895j;
        if (!context.isRestricted()) {
            try {
                Typeface j10 = k10.j(i10, this.f7895j, new a(i13, i14, new WeakReference(this.f7886a)));
                if (j10 != null) {
                    if (this.f7896k != -1) {
                        Typeface create = Typeface.create(j10, 0);
                        int i15 = this.f7896k;
                        if ((this.f7895j & 2) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        this.f7897l = e.a(create, i15, z11);
                    } else {
                        this.f7897l = j10;
                    }
                }
                if (this.f7897l == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f7898m = z10;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f7897l == null && (o10 = k10.o(i10)) != null) {
            if (this.f7896k != -1) {
                Typeface create2 = Typeface.create(o10, 0);
                int i16 = this.f7896k;
                if ((this.f7895j & 2) == 0) {
                    z12 = false;
                }
                this.f7897l = e.a(create2, i16, z12);
                return;
            }
            this.f7897l = Typeface.create(o10, this.f7895j);
        }
    }

    public final void a(Drawable drawable, I i10) {
        if (drawable != null && i10 != null) {
            C0433g.i(drawable, i10, this.f7886a.getDrawableState());
        }
    }

    public void b() {
        if (this.f7887b != null || this.f7888c != null || this.f7889d != null || this.f7890e != null) {
            Drawable[] compoundDrawables = this.f7886a.getCompoundDrawables();
            a(compoundDrawables[0], this.f7887b);
            a(compoundDrawables[1], this.f7888c);
            a(compoundDrawables[2], this.f7889d);
            a(compoundDrawables[3], this.f7890e);
        }
        if (this.f7891f != null || this.f7892g != null) {
            Drawable[] compoundDrawablesRelative = this.f7886a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f7891f);
            a(compoundDrawablesRelative[2], this.f7892g);
        }
    }

    public void c() {
        this.f7894i.a();
    }

    public int e() {
        return this.f7894i.f();
    }

    public int f() {
        return this.f7894i.g();
    }

    public int g() {
        return this.f7894i.h();
    }

    public int[] h() {
        return this.f7894i.i();
    }

    public int i() {
        return this.f7894i.j();
    }

    public ColorStateList j() {
        I i10 = this.f7893h;
        if (i10 != null) {
            return i10.f7719a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        I i10 = this.f7893h;
        if (i10 != null) {
            return i10.f7720b;
        }
        return null;
    }

    public boolean l() {
        return this.f7894i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0443q.m(android.util.AttributeSet, int):void");
    }

    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f7898m) {
            this.f7897l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f7895j));
                } else {
                    textView.setTypeface(typeface, this.f7895j);
                }
            }
        }
    }

    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (!S.f7793a) {
            c();
        }
    }

    public void p() {
        b();
    }

    public void q(Context context, int i10) {
        String o10;
        K u10 = K.u(context, i10, e.j.f30428c3);
        int i11 = e.j.f30474l3;
        if (u10.s(i11)) {
            s(u10.a(i11, false));
        }
        int i12 = e.j.f30434d3;
        if (u10.s(i12) && u10.f(i12, -1) == 0) {
            this.f7886a.setTextSize(0, 0.0f);
        }
        C(context, u10);
        int i13 = e.j.f30469k3;
        if (u10.s(i13) && (o10 = u10.o(i13)) != null) {
            d.d(this.f7886a, o10);
        }
        u10.y();
        Typeface typeface = this.f7897l;
        if (typeface != null) {
            this.f7886a.setTypeface(typeface, this.f7895j);
        }
    }

    public void s(boolean z10) {
        this.f7886a.setAllCaps(z10);
    }

    public void t(int i10, int i11, int i12, int i13) {
        this.f7894i.p(i10, i11, i12, i13);
    }

    public void u(int[] iArr, int i10) {
        this.f7894i.q(iArr, i10);
    }

    public void v(int i10) {
        this.f7894i.r(i10);
    }

    public void w(ColorStateList colorStateList) {
        boolean z10;
        if (this.f7893h == null) {
            this.f7893h = new I();
        }
        I i10 = this.f7893h;
        i10.f7719a = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        i10.f7722d = z10;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        boolean z10;
        if (this.f7893h == null) {
            this.f7893h = new I();
        }
        I i10 = this.f7893h;
        i10.f7720b = mode;
        if (mode != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        i10.f7721c = z10;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] compoundDrawablesRelative = this.f7886a.getCompoundDrawablesRelative();
                Drawable drawable7 = compoundDrawablesRelative[0];
                if (drawable7 == null && compoundDrawablesRelative[2] == null) {
                    Drawable[] compoundDrawables = this.f7886a.getCompoundDrawables();
                    TextView textView = this.f7886a;
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative[1];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative[3];
                }
                this.f7886a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative[2], drawable4);
                return;
            }
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f7886a.getCompoundDrawablesRelative();
        if (drawable5 == null) {
            drawable5 = compoundDrawablesRelative2[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawablesRelative2[1];
        }
        if (drawable6 == null) {
            drawable6 = compoundDrawablesRelative2[2];
        }
        TextView textView2 = this.f7886a;
        if (drawable4 == null) {
            drawable4 = compoundDrawablesRelative2[3];
        }
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
    }

    public final void z() {
        I i10 = this.f7893h;
        this.f7887b = i10;
        this.f7888c = i10;
        this.f7889d = i10;
        this.f7890e = i10;
        this.f7891f = i10;
        this.f7892g = i10;
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: androidx.appcompat.widget.q$a */
    /* loaded from: classes.dex */
    public class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7899a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7900b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f7901c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f7899a = i10;
            this.f7900b = i11;
            this.f7901c = weakReference;
        }

        @Override // A.h.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            boolean z10;
            int i10 = this.f7899a;
            if (i10 != -1) {
                if ((this.f7900b & 2) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                typeface = e.a(typeface, i10, z10);
            }
            C0443q.this.n(this.f7901c, typeface);
        }

        @Override // A.h.e
        /* renamed from: h */
        public void f(int i10) {
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
    }
}
