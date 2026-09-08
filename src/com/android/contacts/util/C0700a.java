package com.android.contacts.util;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.framework.baseui.util.k;
import com.android.contacts.list.AccountFilterActivity;
import com.android.contacts.list.ContactListFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import m1.AbstractC1316l;

/* compiled from: AccountFilterUtil.java */
/* renamed from: com.android.contacts.util.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0700a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f17555a = "a";

    /* renamed from: b, reason: collision with root package name */
    public static AbstractC1316l f17556b;

    public static int a(String str) {
        return -1;
    }

    public static String b(String str) {
        ArrayList<k.a> arrayList;
        String str2 = "";
        if (str == null) {
            return "";
        }
        try {
            arrayList = com.android.contacts.framework.baseui.util.k.b(str);
        } catch (Exception e10) {
            H7.b.c(f17555a, "getAccountNameByLookupKey error " + e10);
            arrayList = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(com.android.contacts.framework.baseui.util.k.a("com.android.oplus.sim", "SIM")), "SIM");
        hashMap.put(Integer.valueOf(com.android.contacts.framework.baseui.util.k.a("com.android.oplus.sim", "SIM1")), "SIM1");
        hashMap.put(Integer.valueOf(com.android.contacts.framework.baseui.util.k.a("com.android.oplus.sim", "SIM2")), "SIM2");
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<k.a> it = arrayList.iterator();
            while (it.hasNext()) {
                str2 = (String) hashMap.get(Integer.valueOf(it.next().f15935a));
                if (!TextUtils.isEmpty(str2)) {
                    break;
                }
            }
        }
        return str2;
    }

    public static AbstractC1316l c() {
        return f17556b;
    }

    public static void d(AbstractC1316l abstractC1316l, int i10, Intent intent) {
        ContactListFilter contactListFilter;
        if (intent == null || i10 != -1 || (contactListFilter = (ContactListFilter) C7.e.j(intent, "contactListFilter")) == null) {
            return;
        }
        if (contactListFilter.f16738b == -3) {
            abstractC1316l.h(contactListFilter.f16744h);
        } else {
            abstractC1316l.i(contactListFilter, true);
        }
    }

    public static void e(AbstractC1316l abstractC1316l) {
        f17556b = abstractC1316l;
    }

    public static void f(Fragment fragment, int i10) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            S7.b.b(fragment, new Intent(activity, (Class<?>) AccountFilterActivity.class), i10, 0);
        } else {
            H7.b.i(f17555a, "getActivity() returned null. Ignored");
        }
    }
}
