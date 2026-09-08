package r0;

import com.oplus.foundation.util.OsUtils;

/* compiled from: Packages.kt */
/* renamed from: r0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1501d {

    /* renamed from: a, reason: collision with root package name */
    public static final C1501d f36272a = new C1501d();

    /* renamed from: b, reason: collision with root package name */
    public static final String f36273b = com.android.contacts.framework.api.appstore.appinfo.a.c();

    /* renamed from: c, reason: collision with root package name */
    public static final String f36274c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f36275d;

    /* renamed from: e, reason: collision with root package name */
    public static String f36276e;

    static {
        String str;
        String str2;
        if (OsUtils.f28275a.j()) {
            str = "com.oplus.camera";
        } else {
            str = "com.oppo.camera";
        }
        f36274c = str;
        f36275d = com.android.contacts.framework.api.appstore.appinfo.a.j();
        if (OsUtils.m()) {
            str2 = "com.oplus.wirelesssettings";
        } else {
            str2 = "com.coloros.wirelesssettings";
        }
        f36276e = str2;
    }
}
