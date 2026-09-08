package com.customize.contacts.util;

import android.content.Context;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import java.text.DateFormat;

/* compiled from: CallLogDateFormatUtils.java */
/* renamed from: com.customize.contacts.util.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0799j {

    /* renamed from: a, reason: collision with root package name */
    public static DateFormat f22132a;

    /* renamed from: b, reason: collision with root package name */
    public static DateFormat f22133b;

    public static String a(Context context, long j10) {
        String str;
        DateFormat dateFormat = f22133b;
        String str2 = "";
        if (dateFormat == null) {
            str = "";
        } else {
            str = dateFormat.format(Long.valueOf(j10));
        }
        DateFormat dateFormat2 = f22132a;
        if (dateFormat2 != null) {
            str2 = dateFormat2.format(Long.valueOf(j10));
        }
        return str + " " + str2;
    }

    public static String b(Context context, int i10, int i11) {
        boolean z10;
        int i12 = i10 % 60;
        int i13 = (i10 / 60) % 60;
        int i14 = i10 / 3600;
        H7.b.b("CallLogDateFormatUtils", "second::" + i12 + " minute::" + i13 + " hour::" + i14);
        StringBuilder sb = new StringBuilder();
        if (i10 == 0) {
            if (VirtualSupportUtils.m() && i11 == 7) {
                sb.append("");
            } else {
                sb.append(context.getString(R.string.oplus_calls_cannot_reach));
            }
            return sb.toString();
        }
        String a10 = K.a();
        if (!a10.startsWith("ja") && !a10.startsWith("ko") && !a10.startsWith("el")) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i14 != 0) {
            sb.append(" ");
            sb.append(U7.a.b(i14));
            if (!z10) {
                sb.append(" ");
            }
            sb.append(context.getString(R.string.call_log_hour));
        }
        if (i13 != 0) {
            if (i14 == 0 || !z10) {
                sb.append(" ");
            }
            sb.append(U7.a.b(i13));
            if (!z10) {
                sb.append(" ");
            }
            sb.append(context.getString(R.string.call_log_minute));
        }
        if (i13 == 0 || !z10) {
            sb.append(" ");
        }
        sb.append(U7.a.b(i12));
        if (!z10) {
            sb.append(" ");
        }
        sb.append(context.getString(R.string.call_log_second));
        return sb.toString();
    }

    public static void c(DateFormat dateFormat) {
        f22133b = dateFormat;
    }

    public static void d(DateFormat dateFormat) {
        f22132a = dateFormat;
    }
}
