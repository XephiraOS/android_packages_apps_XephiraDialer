package com.ted.number;

import a4.C0421a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.contacts.framework.api.numberidentify.interfaces.IRelevantNumber;
import com.customize.contacts.util.C0802m;
import com.ted.number.ui.RelevantNumberActivity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LaunchHelper.java */
/* loaded from: classes4.dex */
public class s {
    public static void a(Context context, String str) {
        Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", str, null));
        intent.putExtra("dialer_from", "launch");
        C0802m.a(context, intent);
    }

    public static void b(Context context, String str, List<IRelevantNumber> list, int i10) {
        if (list != null && !list.isEmpty()) {
            Intent intent = new Intent(context, (Class<?>) RelevantNumberActivity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("extra_relevant_name", str);
            }
            intent.putParcelableArrayListExtra("extra_relevant_list", new ArrayList<>(list));
            R7.b.c(context, intent);
        }
    }

    public static void c(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", str, null));
        intent.addFlags(67108864);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("sms_body", str2);
        }
        R7.b.c(context, intent);
    }
}
