package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* compiled from: AppCompatCheckedTextViewHelper.java */
/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0431e {

    /* renamed from: a, reason: collision with root package name */
    public final CheckedTextView f7844a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f7845b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f7846c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7847d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7848e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7849f;

    public C0431e(CheckedTextView checkedTextView) {
        this.f7844a = checkedTextView;
    }

    public void a() {
        Drawable a10 = androidx.core.widget.b.a(this.f7844a);
        if (a10 != null) {
            if (this.f7847d || this.f7848e) {
                Drawable mutate = C.a.r(a10).mutate();
                if (this.f7847d) {
                    C.a.o(mutate, this.f7845b);
                }
                if (this.f7848e) {
                    C.a.p(mutate, this.f7846c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f7844a.getDrawableState());
                }
                this.f7844a.setCheckMarkDrawable(mutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f7845b;
    }

    public PorterDuff.Mode c() {
        return this.f7846c;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005e A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:9:0x0056, B:11:0x005e, B:12:0x0067, B:14:0x006f, B:21:0x003b, B:23:0x0043, B:25:0x0049), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:9:0x0056, B:11:0x005e, B:12:0x0067, B:14:0x006f, B:21:0x003b, B:23:0x0043, B:25:0x0049), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CheckedTextView r0 = r9.f7844a
            android.content.Context r0 = r0.getContext()
            int[] r3 = e.j.f30368R0
            r8 = 0
            androidx.appcompat.widget.K r0 = androidx.appcompat.widget.K.w(r0, r10, r3, r11, r8)
            android.widget.CheckedTextView r1 = r9.f7844a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.K.h0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = e.j.f30378T0     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L3b
            int r10 = r0.n(r10, r8)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L3b
            android.widget.CheckedTextView r11 = r9.f7844a     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            android.graphics.drawable.Drawable r10 = f.C0991a.b(r1, r10)     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            r11.setCheckMarkDrawable(r10)     // Catch: java.lang.Throwable -> L39 android.content.res.Resources.NotFoundException -> L3b
            goto L56
        L39:
            r9 = move-exception
            goto L82
        L3b:
            int r10 = e.j.f30373S0     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L56
            int r10 = r0.n(r10, r8)     // Catch: java.lang.Throwable -> L39
            if (r10 == 0) goto L56
            android.widget.CheckedTextView r11 = r9.f7844a     // Catch: java.lang.Throwable -> L39
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L39
            android.graphics.drawable.Drawable r10 = f.C0991a.b(r1, r10)     // Catch: java.lang.Throwable -> L39
            r11.setCheckMarkDrawable(r10)     // Catch: java.lang.Throwable -> L39
        L56:
            int r10 = e.j.f30383U0     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L67
            android.widget.CheckedTextView r11 = r9.f7844a     // Catch: java.lang.Throwable -> L39
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch: java.lang.Throwable -> L39
            androidx.core.widget.b.b(r11, r10)     // Catch: java.lang.Throwable -> L39
        L67:
            int r10 = e.j.f30388V0     // Catch: java.lang.Throwable -> L39
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L39
            if (r11 == 0) goto L7e
            android.widget.CheckedTextView r9 = r9.f7844a     // Catch: java.lang.Throwable -> L39
            r11 = -1
            int r10 = r0.k(r10, r11)     // Catch: java.lang.Throwable -> L39
            r11 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.u.d(r10, r11)     // Catch: java.lang.Throwable -> L39
            androidx.core.widget.b.c(r9, r10)     // Catch: java.lang.Throwable -> L39
        L7e:
            r0.y()
            return
        L82:
            r0.y()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0431e.d(android.util.AttributeSet, int):void");
    }

    public void e() {
        if (this.f7849f) {
            this.f7849f = false;
        } else {
            this.f7849f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f7845b = colorStateList;
        this.f7847d = true;
        a();
    }

    public void g(PorterDuff.Mode mode) {
        this.f7846c = mode;
        this.f7848e = true;
        a();
    }
}
