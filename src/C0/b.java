package C0;

import android.content.Context;
import kotlin.jvm.internal.i;

/* compiled from: ApplicationManager.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f319a = new b();

    public final void a(Context context) {
        i.f(context, "context");
        a b10 = b(context);
        if (b10 != null) {
            b10.a();
        }
    }

    public final a b(Context context) {
        Object applicationContext = context.getApplicationContext();
        if (applicationContext instanceof a) {
            return (a) applicationContext;
        }
        return null;
    }
}
