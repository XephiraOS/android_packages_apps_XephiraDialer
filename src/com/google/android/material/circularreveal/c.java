package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;
import r4.C1509a;

/* compiled from: CircularRevealWidget.java */
/* loaded from: classes3.dex */
public interface c extends b.a {

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes3.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f23088b = new b();

        /* renamed from: a, reason: collision with root package name */
        public final e f23089a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f23089a.b(C1509a.d(eVar.f23092a, eVar2.f23092a, f10), C1509a.d(eVar.f23093b, eVar2.f23093b, f10), C1509a.d(eVar.f23094c, eVar2.f23094c, f10));
            return this.f23089a;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0213c extends Property<c, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f23090a = new C0213c("circularReveal");

        public C0213c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes3.dex */
    public static class d extends Property<c, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f23091a = new d("circularRevealScrimColor");

        public d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f23092a;

        /* renamed from: b, reason: collision with root package name */
        public float f23093b;

        /* renamed from: c, reason: collision with root package name */
        public float f23094c;

        public e() {
        }

        public boolean a() {
            if (this.f23094c == Float.MAX_VALUE) {
                return true;
            }
            return false;
        }

        public void b(float f10, float f11, float f12) {
            this.f23092a = f10;
            this.f23093b = f11;
            this.f23094c = f12;
        }

        public void c(e eVar) {
            b(eVar.f23092a, eVar.f23093b, eVar.f23094c);
        }

        public e(float f10, float f11, float f12) {
            this.f23092a = f10;
            this.f23093b = f11;
            this.f23094c = f12;
        }

        public e(e eVar) {
            this(eVar.f23092a, eVar.f23093b, eVar.f23094c);
        }
    }
}
