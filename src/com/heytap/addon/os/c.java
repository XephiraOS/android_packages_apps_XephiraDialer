package com.heytap.addon.os;

import android.content.Context;
import com.oplus.os.OplusUsbEnvironment;
import com.oppo.os.OppoUsbEnvironment;

/* compiled from: OplusUsbEnvironment.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f25389a;

    /* renamed from: b, reason: collision with root package name */
    public static int f25390b;

    /* renamed from: c, reason: collision with root package name */
    public static int f25391c;

    /* renamed from: d, reason: collision with root package name */
    public static int f25392d;

    /* renamed from: e, reason: collision with root package name */
    public static String f25393e;

    static {
        if (A5.a.b()) {
            f25389a = -1;
            f25390b = 1;
            f25391c = 2;
            f25392d = 3;
            f25393e = "mounted";
            return;
        }
        f25389a = -1;
        f25390b = 1;
        f25391c = 2;
        f25392d = 3;
        f25393e = "mounted";
    }

    public static String a(Context context) {
        if (A5.a.b()) {
            return OplusUsbEnvironment.getExternalPath(context);
        }
        return OppoUsbEnvironment.getExternalPath(context);
    }

    public static String b(Context context) {
        if (A5.a.b()) {
            return OplusUsbEnvironment.getInternalPath(context);
        }
        return OppoUsbEnvironment.getInternalPath(context);
    }
}
