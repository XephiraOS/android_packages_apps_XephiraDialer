package Z5;

import android.content.Context;
import kotlin.jvm.internal.i;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f5961a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static String f5962b;

    public static final String a(Context context) {
        i.f(context, "context");
        String str = f5962b;
        if (str == null) {
            String d10 = b.d(context, "com.oplus.aiunit.auth_style");
            f5962b = d10;
            return d10;
        }
        return str;
    }
}
