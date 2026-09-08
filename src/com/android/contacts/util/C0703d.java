package com.android.contacts.util;

import android.os.AsyncTask;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: AsyncTaskExecutors.java */
/* renamed from: com.android.contacts.util.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0703d {

    /* compiled from: AsyncTaskExecutors.java */
    /* renamed from: com.android.contacts.util.d$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: AsyncTaskExecutors.java */
    /* renamed from: com.android.contacts.util.d$b */
    /* loaded from: classes.dex */
    public static class b implements InterfaceC0702c {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f17566a;

        public b(Executor executor) {
            this.f17566a = executor;
        }

        @Override // com.android.contacts.util.InterfaceC0702c
        public <T> AsyncTask<T, ?, ?> a(Object obj, AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            C0703d.a();
            return asyncTask.executeOnExecutor(this.f17566a, tArr);
        }
    }

    public static void a() {
        boolean z10;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "submit method must be called from ui thread, was: " + Thread.currentThread());
    }

    public static InterfaceC0702c b() {
        b bVar;
        synchronized (C0703d.class) {
            bVar = new b(AsyncTask.SERIAL_EXECUTOR);
        }
        return bVar;
    }

    public static InterfaceC0702c c() {
        b bVar;
        synchronized (C0703d.class) {
            bVar = new b(Executors.newCachedThreadPool());
        }
        return bVar;
    }

    public static void setFactoryForTest(a aVar) {
        synchronized (C0703d.class) {
        }
    }
}
