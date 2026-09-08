package com.android.contacts;

import android.content.Context;
import android.content.Intent;
import com.android.incallui.OplusPhoneUtils;
import java.util.Map;

/* compiled from: DialerStatistics.java */
/* renamed from: com.android.contacts.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0710y {
    public static void a(Context context, int i10) {
        if (context != null) {
            Map<String, String> b02 = com.customize.contacts.util.h0.b0(context);
            b02.put("input_count", String.valueOf(i10));
            com.android.contacts.framework.baseui.util.A.a(context, 2000305, 200031802, b02, false);
        }
    }

    public static void b(Context context, Intent intent, int i10, String str, String str2) {
        String str3;
        if (context != null) {
            Map<String, String> b02 = com.customize.contacts.util.h0.b0(context);
            if (str2 != null) {
                b02.put("number_type", String.valueOf(0));
            } else {
                boolean y10 = E0.b.y(str);
                b02.put("number_flag", String.valueOf(E0.b.o(str)));
                if (y10) {
                    b02.put("number_type", String.valueOf(2));
                } else {
                    b02.put("number_type", String.valueOf(1));
                }
            }
            b02.put("number_position", String.valueOf(i10 + 1));
            if (com.customize.contacts.util.b0.i(context)) {
                str3 = "yes";
            } else {
                str3 = "no";
            }
            b02.put("last_sim", str3);
            b02.put("number_time", String.valueOf((System.currentTimeMillis() - C7.e.f(intent, "number_time", -1L)) / 86400000));
            com.android.contacts.framework.baseui.util.A.a(context, 2000305, 200031803, b02, false);
        }
    }

    public static void c(Context context, com.android.contacts.calllog.G g10, int i10) {
        Intent b10;
        String str;
        if (context != null && g10 != null && (b10 = g10.b(context)) != null) {
            Map<String, String> b02 = com.customize.contacts.util.h0.b0(context);
            boolean c10 = C7.e.c(b10, "isSpecialNumber", false);
            if (b10.getData() == null) {
                if (c10) {
                    str = "2";
                } else {
                    str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
                }
            } else {
                str = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
            }
            b02.put("call_number_type", str);
            b02.put("call_number_position", String.valueOf(i10));
            com.android.contacts.framework.baseui.util.A.a(context, 2000305, 200030023, b02, false);
        }
    }

    public static void d(Context context, Intent intent, int i10, int i11, String str) {
        String str2;
        if (context != null) {
            Map<String, String> b02 = com.customize.contacts.util.h0.b0(context);
            if (str == null) {
                str2 = "2";
            } else {
                str2 = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
            }
            b02.put("call_number_type", str2);
            b02.put("dialpad_input_count", String.valueOf(i11));
            b02.put("call_number_position", String.valueOf(i10));
            b02.put("state", String.valueOf(C7.e.d(intent, "state", -1)));
            b02.put("start_position", String.valueOf(C7.e.d(intent, "start_position", -1)));
            b02.put("search_type", String.valueOf(C7.e.d(intent, "search_type", 0)));
            com.android.contacts.framework.baseui.util.A.a(context, 2000307, 200030033, b02, false);
        }
    }
}
