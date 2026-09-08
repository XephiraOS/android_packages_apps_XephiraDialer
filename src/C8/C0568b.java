package c8;

import android.content.ContentResolver;
import android.content.Context;
import c8.C0567a;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* compiled from: FeatureOption.kt */
/* renamed from: c8.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0568b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0568b f12863a = new C0568b();

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static String f12864b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12865c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f12866d;

    public static final String a() {
        return f12864b;
    }

    public static final void b(Context context) {
        if (context == null) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        f12865c = f12863a.c("domestic");
        C0567a.C0155a c0155a = C0567a.f12862a;
        i.c(contentResolver);
        boolean b10 = c0155a.b(contentResolver, "com.oplus.phonenoareainquire.unsupport_attribution");
        f12866d = b10;
        if (!b10) {
            f12864b = c0155a.a(contentResolver, "com.oplus.phonenoareainquire.region_mark", "CN");
        }
    }

    public static final boolean d() {
        return f12866d;
    }

    public static final boolean e() {
        return f12865c;
    }

    public final boolean c(String str) {
        boolean p10;
        p10 = n.p("gdpr", str, true);
        return p10;
    }
}
