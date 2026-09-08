package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.android.incallui.OplusAutoRedial;
import g0.InterfaceC1030b;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC1030b<c> {

    /* loaded from: classes.dex */
    public static class a {
        public static void c(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: Z.i
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    runnable.run();
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    public static void l(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: Z.h
            @Override // java.lang.Runnable
            public final void run() {
                androidx.profileinstaller.c.i(context);
            }
        });
    }

    @Override // g0.InterfaceC1030b
    public List<Class<? extends InterfaceC1030b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // g0.InterfaceC1030b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c b(Context context) {
        g(context.getApplicationContext());
        return new c();
    }

    public void g(final Context context) {
        a.c(new Runnable() { // from class: Z.f
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.this.i(context);
            }
        });
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void i(final Context context) {
        b.a(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: Z.g
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.l(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + OplusAutoRedial.DELAY_FIVE_SECOND);
    }
}
