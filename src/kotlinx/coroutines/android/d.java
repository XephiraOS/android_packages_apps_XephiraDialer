package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.jvm.internal.i;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f34362a;
    private static volatile Choreographer choreographer;

    static {
        Object b10;
        Object obj = null;
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(new HandlerContext(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        f34362a = (c) obj;
    }

    public static final Handler a(Looper looper, boolean z10) {
        if (z10) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            i.d(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        return new Handler(looper);
    }
}
