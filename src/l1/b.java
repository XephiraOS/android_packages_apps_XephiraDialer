package L1;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.android.incallui.OplusInCallApp;
import kotlin.jvm.internal.i;

/* compiled from: LocalBroadcastHelper.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1710a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final X.a f1711b;

    static {
        X.a b10 = X.a.b(OplusInCallApp.getAppContext());
        i.e(b10, "getInstance(OplusInCallApp.getAppContext())");
        f1711b = b10;
    }

    public static final boolean a(Intent intent) {
        return D2.d.a(intent, "InCallBroadcast.video_upgrade_request_notify", false);
    }

    public static final void b(BroadcastReceiver receiver) {
        i.f(receiver, "receiver");
        f1711b.c(receiver, new IntentFilter("InCallBroadcast.video_upgrade_request_notify"));
    }

    public static final void c(boolean z10) {
        Intent intent = new Intent("InCallBroadcast.video_upgrade_request_notify");
        intent.putExtra("InCallBroadcast.video_upgrade_request_notify", z10);
        f1711b.d(intent);
    }

    public static final void d(BroadcastReceiver receiver) {
        i.f(receiver, "receiver");
        f1711b.e(receiver);
    }
}
