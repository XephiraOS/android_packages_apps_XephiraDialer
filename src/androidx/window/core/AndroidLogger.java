package androidx.window.core;

import android.util.Log;
import kotlin.jvm.internal.i;

/* compiled from: SpecificationComputer.kt */
/* loaded from: classes.dex */
public final class AndroidLogger implements Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidLogger f11889a = new AndroidLogger();

    private AndroidLogger() {
    }

    @Override // androidx.window.core.Logger
    public void a(String tag, String message) {
        i.f(tag, "tag");
        i.f(message, "message");
        Log.d(tag, message);
    }
}
