package com.android.incallui.mvvm.usecase;

import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.f;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import d2.C0950c;
import f2.C0996a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: FragmentStateUseCase.kt */
/* loaded from: classes.dex */
public final class FragmentStateUseCase extends C0950c {

    /* renamed from: a, reason: collision with root package name */
    public static final FragmentStateUseCase f18563a = new FragmentStateUseCase();

    /* renamed from: b, reason: collision with root package name */
    public static final h<List<C0996a>> f18564b;

    /* renamed from: c, reason: collision with root package name */
    public static final y<Boolean> f18565c;

    /* renamed from: d, reason: collision with root package name */
    public static final y<Boolean> f18566d;

    static {
        List j10;
        int p10;
        j10 = o.j(1, 2, 4, 8, 16, 32, 64, 256, Integer.MIN_VALUE);
        List list = j10;
        p10 = p.p(list, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C0996a(((Number) it.next()).intValue(), false, 2, null));
        }
        h<List<C0996a>> hVar = new h<>(arrayList, false, 2, null);
        f18564b = hVar;
        f18565c = IgnoreEqualsLiveDataKt.C(hVar, false, new l<List<? extends C0996a>, Boolean>() { // from class: com.android.incallui.mvvm.usecase.FragmentStateUseCase$mActionButtonFragmentVisible$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List<C0996a> it2) {
                i.f(it2, "it");
                for (C0996a c0996a : it2) {
                    if (c0996a.a() == 16) {
                        return Boolean.valueOf(c0996a.b());
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, 1, null);
        f18566d = IgnoreEqualsLiveDataKt.C(hVar, false, new l<List<? extends C0996a>, Boolean>() { // from class: com.android.incallui.mvvm.usecase.FragmentStateUseCase$mDialpadFragmentVisible$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List<C0996a> it2) {
                i.f(it2, "it");
                for (C0996a c0996a : it2) {
                    if (c0996a.a() == 256) {
                        return Boolean.valueOf(c0996a.b());
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, 1, null);
    }

    public final void b(int i10, boolean z10) {
        h<List<C0996a>> hVar = f18564b;
        for (C0996a c0996a : hVar.getValue()) {
            if (c0996a.a() == i10) {
                c0996a.c(z10);
                f.a(hVar);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final y<Boolean> c() {
        return f18565c;
    }

    public final y<Boolean> d() {
        return f18566d;
    }

    public final void e(int i10) {
        for (C0996a c0996a : f18564b.getValue()) {
            if (c0996a.a() == i10) {
                f2.b.a(c0996a);
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
