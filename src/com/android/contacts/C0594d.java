package com.android.contacts;

import java.util.Iterator;
import java.util.List;

/* compiled from: Collapser.java */
/* renamed from: com.android.contacts.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0594d {

    /* compiled from: Collapser.java */
    /* renamed from: com.android.contacts.d$a */
    /* loaded from: classes.dex */
    public interface a<T> {
        boolean a(T t10);

        boolean b(T t10);
    }

    public static <T extends a<T>> void a(List<T> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = list.get(i10);
            if (t10 != null) {
                for (int i11 = i10 + 1; i11 < size; i11++) {
                    T t11 = list.get(i11);
                    if (t11 != null && t10.b(t11)) {
                        t10.a(t11);
                        list.set(i11, null);
                    }
                }
            }
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
    }
}
