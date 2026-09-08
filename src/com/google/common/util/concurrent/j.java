package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadFactoryBuilder.java */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public String f24659a = null;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f24660b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f24661c = null;

    /* renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f24662d = null;

    /* renamed from: e, reason: collision with root package name */
    public ThreadFactory f24663e = null;

    /* compiled from: ThreadFactoryBuilder.java */
    /* loaded from: classes3.dex */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f24664a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f24665b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f24666c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f24667d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f24668e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f24669f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f24664a = threadFactory;
            this.f24665b = str;
            this.f24666c = atomicLong;
            this.f24667d = bool;
            this.f24668e = num;
            this.f24669f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f24664a.newThread(runnable);
            Objects.requireNonNull(newThread);
            String str = this.f24665b;
            if (str != null) {
                AtomicLong atomicLong = this.f24666c;
                Objects.requireNonNull(atomicLong);
                newThread.setName(j.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f24667d;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f24668e;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24669f;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    public static ThreadFactory c(j jVar) {
        AtomicLong atomicLong;
        String str = jVar.f24659a;
        Boolean bool = jVar.f24660b;
        Integer num = jVar.f24661c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = jVar.f24662d;
        ThreadFactory threadFactory = jVar.f24663e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        ThreadFactory threadFactory2 = threadFactory;
        if (str != null) {
            atomicLong = new AtomicLong(0L);
        } else {
            atomicLong = null;
        }
        return new a(threadFactory2, str, atomicLong, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public j e(boolean z10) {
        this.f24660b = Boolean.valueOf(z10);
        return this;
    }

    public j f(String str) {
        d(str, 0);
        this.f24659a = str;
        return this;
    }
}
