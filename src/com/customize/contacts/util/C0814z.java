package com.customize.contacts.util;

import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CustomizeGroupConstants.java */
/* renamed from: com.customize.contacts.util.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0814z {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f22203a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f22204b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f22205c;

    /* compiled from: CustomizeGroupConstants.java */
    /* renamed from: com.customize.contacts.util.z$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f22206a = com.android.contacts.compat.data.f.c("group_ring");
    }

    static {
        Uri uri = ContactsContract.AUTHORITY_URI;
        f22203a = Uri.withAppendedPath(uri, com.android.contacts.compat.data.f.c("group_members"));
        f22204b = Uri.withAppendedPath(uri, com.android.contacts.compat.data.f.c("get_multiple_group_members"));
        f22205c = Uri.withAppendedPath(uri, com.android.contacts.compat.data.f.c("group_members") + "/members_count");
    }

    public static Uri a(boolean z10, boolean z11) {
        Uri.Builder buildUpon = f22205c.buildUpon();
        if (z10) {
            buildUpon = buildUpon.appendQueryParameter("only_phone", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        }
        if (z11) {
            buildUpon = buildUpon.appendQueryParameter("contain_email", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        }
        return buildUpon.build();
    }

    public static String b(HashMap<Account, Long> hashMap) {
        ArrayList arrayList = new ArrayList();
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<Account, Long> entry : hashMap.entrySet()) {
                if (entry.getKey() != null) {
                    arrayList.add(entry.getValue());
                }
            }
        }
        return "group_id IN " + G7.a.d(arrayList);
    }
}
