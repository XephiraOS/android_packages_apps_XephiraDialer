package com.android.contacts.voicemail.impl.scheduling;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.android.contacts.voicemail.impl.scheduling.f;
import java.util.List;
import t1.C1580a;

/* loaded from: classes.dex */
public final class TaskExecutor {

    /* renamed from: k, reason: collision with root package name */
    public static TaskExecutor f18152k;

    /* renamed from: a, reason: collision with root package name */
    public final f f18153a;

    /* renamed from: c, reason: collision with root package name */
    public final e f18155c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f18156d;

    /* renamed from: h, reason: collision with root package name */
    public c f18160h;

    /* renamed from: b, reason: collision with root package name */
    public MessageSender f18154b = new MessageSender();

    /* renamed from: e, reason: collision with root package name */
    public final com.android.contacts.voicemail.impl.scheduling.f f18157e = new com.android.contacts.voicemail.impl.scheduling.f();

    /* renamed from: f, reason: collision with root package name */
    public boolean f18158f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18159g = false;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f18161i = new a();

    /* renamed from: j, reason: collision with root package name */
    public boolean f18162j = false;

    /* loaded from: classes.dex */
    public static class MessageSender {
        public void a(Message message) {
            message.sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            H7.b.e("VvmTaskExecutor", "Stopping service");
            if (TaskExecutor.this.o() && !TaskExecutor.this.p()) {
                TaskExecutor.this.v(0L, true);
            } else {
                H7.b.c("VvmTaskExecutor", "Service already stopped");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskExecutor.this.q();
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a();

        void b();
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final long f18165a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f18166b;

        /* renamed from: c, reason: collision with root package name */
        public int f18167c = 0;

        public d(long j10, boolean z10) {
            this.f18165a = j10;
            this.f18166b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            if (this.f18167c < 10) {
                z10 = true;
            } else {
                z10 = false;
            }
            C1580a.e(z10);
            this.f18167c++;
            if (TaskExecutor.this.f18160h.a()) {
                H7.b.e("JobFinishedPoller.run", "Job finished");
                if (!TaskExecutor.this.n().isEmpty()) {
                    TaskSchedulerJobService.e(TaskExecutor.this.f18156d, TaskExecutor.this.w(), this.f18165a, this.f18166b);
                    TaskExecutor.this.f18157e.clear();
                }
                TaskExecutor.this.y();
                return;
            }
            H7.b.i("JobFinishedPoller.run", "Job still running");
            TaskExecutor.this.f18155c.postDelayed(this, 1000L);
        }
    }

    /* loaded from: classes.dex */
    public final class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1580a.c();
            com.android.contacts.voicemail.impl.scheduling.e eVar = (com.android.contacts.voicemail.impl.scheduling.e) message.obj;
            TaskExecutor.this.n().h(eVar);
            eVar.onCompleted();
            TaskExecutor.this.f18158f = false;
            if (TaskExecutor.this.o() && !TaskExecutor.this.p()) {
                TaskExecutor.this.q();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1580a.d();
            com.android.contacts.voicemail.impl.scheduling.e eVar = (com.android.contacts.voicemail.impl.scheduling.e) message.obj;
            try {
                H7.b.e("VvmTaskExecutor", "executing task " + eVar);
                eVar.a();
            } catch (Throwable th) {
                H7.b.c("VvmTaskExecutor", "Exception while executing task " + eVar + ": throwable: " + th);
            }
            Message obtainMessage = TaskExecutor.this.f18155c.obtainMessage();
            obtainMessage.obj = eVar;
            TaskExecutor.this.f18154b.a(obtainMessage);
        }
    }

    public TaskExecutor(Context context) {
        this.f18156d = context;
        HandlerThread handlerThread = new HandlerThread("VvmTaskExecutor");
        handlerThread.start();
        this.f18153a = new f(handlerThread.getLooper());
        this.f18155c = new e(Looper.getMainLooper());
    }

    public static void k(Context context) {
        boolean z10;
        C1580a.c();
        if (f18152k == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        C1580a.e(z10);
        f18152k = new TaskExecutor(context);
    }

    public static TaskExecutor m() {
        return f18152k;
    }

    public void j(com.android.contacts.voicemail.impl.scheduling.e eVar) {
        C1580a.c();
        n().a(eVar);
        H7.b.e("VvmTaskExecutor", eVar + " added");
        this.f18155c.removeCallbacks(this.f18161i);
        q();
    }

    public final void l() {
        C1580a.e(!p());
        C1580a.c();
        H7.b.e("VvmTaskExecutor", "finishing Job");
        this.f18160h.b();
        this.f18159g = true;
        this.f18155c.removeCallbacks(this.f18161i);
    }

    public com.android.contacts.voicemail.impl.scheduling.f n() {
        C1580a.c();
        return this.f18157e;
    }

    public final boolean o() {
        if (this.f18160h != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.f18159g;
    }

    public final void q() {
        C1580a.c();
        if (this.f18158f || this.f18162j) {
            return;
        }
        u();
    }

    public void r(c cVar, List<Bundle> list) {
        H7.b.e("VvmTaskExecutor", "onStartJob");
        this.f18160h = cVar;
        this.f18157e.c(this.f18156d, list);
        q();
    }

    public void s() {
        H7.b.c("VvmTaskExecutor", "onStopJob");
        if (o() && !p()) {
            v(0L, true);
        }
    }

    public void setMessageSenderForTest(MessageSender messageSender) {
        this.f18154b = messageSender;
    }

    public void setTaskAutoRunDisabledForTest(boolean z10) {
        this.f18162j = z10;
    }

    public final void t() {
        H7.b.e("VvmTaskExecutor", "no more tasks, stopping service if no task are added in 5000 millis");
        this.f18155c.postDelayed(this.f18161i, 5000L);
    }

    public void u() {
        Long l10;
        C1580a.c();
        if (n().isEmpty()) {
            t();
            return;
        }
        f.a e10 = n().e(100L);
        com.android.contacts.voicemail.impl.scheduling.e eVar = e10.f18187a;
        if (eVar != null) {
            eVar.c();
            Message obtainMessage = this.f18153a.obtainMessage();
            obtainMessage.obj = e10.f18187a;
            this.f18158f = true;
            this.f18154b.a(obtainMessage);
            return;
        }
        H7.b.e("VvmTaskExecutor", "minimal wait time:" + e10.f18188b);
        if (!this.f18162j && (l10 = e10.f18188b) != null) {
            x(l10.longValue());
        }
    }

    public void v(long j10, boolean z10) {
        C1580a.c();
        l();
        this.f18155c.post(new d(j10, z10));
    }

    public final List<Bundle> w() {
        return n().i();
    }

    public final void x(long j10) {
        H7.b.e("VvmTaskExecutor", "sleep for " + j10 + " millis");
        if (j10 < 10000) {
            this.f18155c.postDelayed(new b(), j10);
        } else {
            v(j10, false);
        }
    }

    public void y() {
        H7.b.e("VvmTaskExecutor", "terminated");
        C1580a.c();
        this.f18160h = null;
        this.f18153a.getLooper().quit();
        f18152k = null;
        TaskReceiver.a(this.f18156d);
    }
}
