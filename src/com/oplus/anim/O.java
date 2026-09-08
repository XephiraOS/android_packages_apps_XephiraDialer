package com.oplus.anim;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p.C1416b;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes3.dex */
public class O {

    /* renamed from: a, reason: collision with root package name */
    public boolean f25827a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Set<b> f25828b = new C1416b();

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, l6.f> f25829c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Comparator<I.d<String, Float>> f25830d = new a();

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes3.dex */
    public class a implements Comparator<I.d<String, Float>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(I.d<String, Float> dVar, I.d<String, Float> dVar2) {
            float floatValue = dVar.f1296b.floatValue();
            float floatValue2 = dVar2.f1296b.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: PerformanceTracker.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(float f10);
    }

    public void a(String str, float f10) {
        if (!this.f25827a) {
            return;
        }
        l6.f fVar = this.f25829c.get(str);
        if (fVar == null) {
            fVar = new l6.f();
            this.f25829c.put(str, fVar);
        }
        fVar.a(f10);
        if (str.equals("__container")) {
            Iterator<b> it = this.f25828b.iterator();
            while (it.hasNext()) {
                it.next().a(f10);
            }
        }
    }

    public void b(boolean z10) {
        this.f25827a = z10;
    }
}
