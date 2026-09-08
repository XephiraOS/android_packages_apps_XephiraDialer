package com.customize.contacts.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.dialer.R;

/* compiled from: ClipboardUtils.java */
/* renamed from: com.customize.contacts.util.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0803n {
    public static void a(Context context, String str, String[] strArr, String str2) {
        b(context, str, strArr, str2, false);
    }

    public static void b(Context context, String str, String[] strArr, String str2, boolean z10) {
        if (!TextUtils.isEmpty(str2) && context != null && !TextUtils.isEmpty(str) && strArr != null) {
            c((ClipboardManager) context.getSystemService("clipboard"), new ClipData(str, strArr, new ClipData.Item(str2)));
            if (z10) {
                com.oplus.foundation.util.ui.c.b(context, R.string.toast_text_copied);
            } else {
                com.oplus.foundation.util.ui.c.d(context, R.string.toast_text_copied);
            }
        }
    }

    public static void c(ClipboardManager clipboardManager, ClipData clipData) {
        try {
            clipboardManager.setPrimaryClip(clipData);
        } catch (Exception e10) {
            H7.b.c("ClipboardUtils", "fail to set the current primary clip on the clipboard.");
            H7.b.c("ClipboardUtils", "Exception e: " + e10);
        }
    }

    public static void d(Context context, ClipData clipData) {
        c((ClipboardManager) context.getSystemService("clipboard"), clipData);
    }
}
