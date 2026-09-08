package M7;

import M7.b;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import kotlin.Result;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SettingsUtils.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1807a = new c();

    public static final boolean a(Context context) {
        Object b10;
        ContentResolver contentResolver;
        try {
            Result.a aVar = Result.f34166a;
            if (context != null) {
                contentResolver = context.getContentResolver();
            } else {
                contentResolver = null;
            }
            boolean z10 = false;
            if (Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                z10 = true;
            }
            b10 = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SettingsUtils", "isAirplaneModeOn " + d10 + " " + d10.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public static final boolean b(Context context) {
        boolean z10;
        boolean y10;
        if (context == null) {
            return false;
        }
        if (b.C0045b.a(2).f1799c.a(context.getContentResolver(), "accessibility_enabled", 0) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        String e10 = b.C0045b.a(2).f1799c.e(context.getContentResolver(), "enabled_accessibility_services");
        if (!z10 || e10 == null) {
            return false;
        }
        y10 = StringsKt__StringsKt.y(e10, "com.google.android.marvin.talkback", false, 2, null);
        if (!y10) {
            return false;
        }
        return true;
    }
}
