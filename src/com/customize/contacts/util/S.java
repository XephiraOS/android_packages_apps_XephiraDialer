package com.customize.contacts.util;

import android.content.Intent;

/* compiled from: NavigateUtils.java */
/* loaded from: classes3.dex */
public class S {
    public static void a(Intent intent, CharSequence charSequence) {
        intent.putExtra("android.intent.extra.ringtone.TITLE", charSequence);
        intent.putExtra("navigate_parent_package", P7.a.f2962b.getPackageName());
    }
}
