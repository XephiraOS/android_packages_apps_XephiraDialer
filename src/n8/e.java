package N8;

import android.content.Context;
import android.os.HandlerThread;

/* compiled from: VideoShowPlayerCreator.kt */
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2391a = new e();

    public final d a(Context context, O8.c videoStateListener) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(videoStateListener, "videoStateListener");
        HandlerThread handlerThread = new HandlerThread("video_show_handler_thread");
        handlerThread.setPriority(10);
        handlerThread.start();
        return new h(context, handlerThread, videoStateListener);
    }
}
