package com.customize.contacts.importcontact;

import com.android.contacts.framework.vcard.VCardEntry;
import java.util.HashSet;
import java.util.List;

/* compiled from: FatContactVerifier.java */
/* loaded from: classes3.dex */
public class f {
    public static <T> void a(List<T> list, int i10) {
        if (list != null && list.size() > i10) {
            if (i10 <= 0) {
                list.clear();
                return;
            }
            int size = list.size();
            H7.b.i("FatContactVerifier", "keep: remove count: " + (size - i10));
            list.subList(i10, size).clear();
        }
    }

    public static void b(VCardEntry vCardEntry) {
        int R10 = vCardEntry.R();
        if (R10 >= 20) {
            c(vCardEntry.W());
            c(vCardEntry.O());
            c(vCardEntry.Y());
            c(vCardEntry.V());
            c(vCardEntry.Q());
            c(vCardEntry.X());
            c(vCardEntry.c0());
            c(vCardEntry.b0());
            c(vCardEntry.T());
            c(vCardEntry.U());
            c(vCardEntry.J());
            c(vCardEntry.L());
            c(vCardEntry.P());
            c(vCardEntry.M());
        }
        if (vCardEntry.R() >= 490) {
            d(vCardEntry);
        }
        H7.b.b("FatContactVerifier", "verify: remove redundancy data count: " + (R10 - vCardEntry.R()));
    }

    public static <T> void c(List<T> list) {
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet(list);
            list.clear();
            list.addAll(hashSet);
        }
    }

    public static void d(VCardEntry vCardEntry) {
        int i10 = 0;
        a(vCardEntry.P(), 0);
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.M(), 0);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.X(), 0);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.b0(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.Q(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.J(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.T(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.c0(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.L(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.V(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.Y(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.U(), 1);
        }
        if (vCardEntry.R() >= 490) {
            a(vCardEntry.O(), 10);
        }
        int R10 = vCardEntry.R();
        if (R10 >= 490) {
            if (vCardEntry.W() != null) {
                i10 = vCardEntry.W().size();
            }
            a(vCardEntry.W(), (i10 - (R10 - 490)) - 10);
        }
    }
}
