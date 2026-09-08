package com.customize.contacts.util;

import com.android.contacts.model.Account;
import com.customize.contacts.model.IdRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ContactsTransportHelper.java */
/* renamed from: com.customize.contacts.util.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0810v {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f22182a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final Integer f22183b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static Map<Integer, ArrayList<IdRecord>> f22184c = null;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<Account, Long> f22185d = new HashMap<>();

    public static void a() {
        Map<Integer, ArrayList<IdRecord>> map = f22184c;
        if (map != null) {
            map.clear();
            f22184c = null;
        }
    }

    public static ArrayList<IdRecord> b(Integer num) {
        Map<Integer, ArrayList<IdRecord>> map = f22184c;
        if (map == null) {
            return null;
        }
        return map.get(num);
    }

    public static ArrayList<IdRecord> c() {
        return b(f22182a);
    }

    public static HashMap<Account, Long> d() {
        return f22185d;
    }

    public static ArrayList<IdRecord> e(Integer num) {
        Map<Integer, ArrayList<IdRecord>> map = f22184c;
        if (map == null) {
            return null;
        }
        return map.remove(num);
    }

    public static void f(Integer num, List<IdRecord> list) {
        if (f22184c == null) {
            f22184c = new HashMap(3);
        }
        if (list != null) {
            if (H7.a.b()) {
                H7.b.b("ContactsTransportHelper", "list.size" + list.size());
            }
            f22184c.put(num, new ArrayList<>(list));
        }
    }

    public static void g(List<IdRecord> list) {
        f(f22182a, list);
    }

    public static void h(Account account, long j10) {
        f22185d.put(account, Long.valueOf(j10));
    }
}
