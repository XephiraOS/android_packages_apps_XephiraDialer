package t2;

import android.content.Context;
import com.android.incallui.Log;
import kotlin.jvm.internal.i;

/* compiled from: FloatingWindowController.kt */
/* renamed from: t2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1581a extends C1588h {

    /* renamed from: m, reason: collision with root package name */
    public static final C0362a f37151m = new C0362a(null);

    /* compiled from: FloatingWindowController.kt */
    /* renamed from: t2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0362a {
        public C0362a() {
        }

        public /* synthetic */ C0362a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1581a(Context context) {
        super(context);
        i.f(context, "context");
    }

    public final void F() {
        n().J();
    }

    public final boolean G() {
        return n().B();
    }

    public final boolean H() {
        return n().C();
    }

    public final void I() {
        n().D();
    }

    public final void J() {
        n().E();
    }

    public final boolean K() {
        return n().K();
    }

    public final boolean L() {
        return n().L();
    }

    public final void M() {
        if (Log.sDebug) {
            Log.d("FloatingWindowController", "switchToInCallActivity: ");
        }
        n().l();
    }
}
