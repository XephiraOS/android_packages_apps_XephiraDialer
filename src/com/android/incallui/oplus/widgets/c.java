package com.android.incallui.oplus.widgets;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.incallui.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: OplusScheduledGenerator.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public ScheduledExecutorService f19165b;

    /* renamed from: a, reason: collision with root package name */
    public final Set<InterfaceC0185c> f19164a = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));

    /* renamed from: c, reason: collision with root package name */
    public Handler f19166c = new b(Looper.getMainLooper());

    /* compiled from: OplusScheduledGenerator.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.f19166c.hasMessages(1000) && !c.this.f19164a.isEmpty()) {
                c.this.f19166c.sendEmptyMessage(1000);
            }
        }
    }

    /* compiled from: OplusScheduledGenerator.java */
    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1000) {
                if (i10 == 1001) {
                    if (Log.sDebug) {
                        Log.i("OplusScheduledGenerator", "MSG_SHUT_DOWNNOW_SCHEDULED mScheduledListeners = " + c.this.f19164a);
                    }
                    if (c.this.f19164a.isEmpty()) {
                        c.this.h();
                        return;
                    }
                    return;
                }
                return;
            }
            c.this.d();
        }
    }

    /* compiled from: OplusScheduledGenerator.java */
    /* renamed from: com.android.incallui.oplus.widgets.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0185c {
        void b();
    }

    public void c(InterfaceC0185c interfaceC0185c) {
        if (Log.sDebug) {
            Log.i("OplusScheduledGenerator", "addScheduledListener listener = " + interfaceC0185c);
        }
        if (this.f19165b == null) {
            g();
        }
        this.f19164a.add(interfaceC0185c);
    }

    public void d() {
        Iterator<InterfaceC0185c> it = this.f19164a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void e(InterfaceC0185c interfaceC0185c) {
        if (this.f19164a.contains(interfaceC0185c)) {
            this.f19164a.remove(interfaceC0185c);
        }
        if (Log.sDebug) {
            Log.i("OplusScheduledGenerator", "removeScheduledListener mScheduledListeners = " + this.f19164a);
        }
        if (this.f19164a.isEmpty()) {
            f();
        }
    }

    public void f() {
        if (this.f19166c.hasMessages(1001)) {
            this.f19166c.removeMessages(1001);
        }
        this.f19166c.sendEmptyMessageDelayed(1001, 5000L);
    }

    public void g() {
        if (Log.sDebug) {
            Log.d("OplusScheduledGenerator", "startScheduledExecutor");
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f19165b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(new a(), 0L, 100L, TimeUnit.MILLISECONDS);
    }

    public final void h() {
        if (Log.sDebug) {
            Log.d("OplusScheduledGenerator", "stopScheduledExecutor");
        }
        ScheduledExecutorService scheduledExecutorService = this.f19165b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f19165b = null;
        }
    }
}
