package com.google.common.util.concurrent;

import java.io.PrintStream;
import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class UncaughtExceptionHandlers$Exiter implements Thread.UncaughtExceptionHandler {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f24657b = Logger.getLogger(UncaughtExceptionHandlers$Exiter.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Runtime f24658a;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                f24657b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } catch (Error | RuntimeException e10) {
                PrintStream printStream = System.err;
                printStream.println(th.getMessage());
                printStream.println(e10.getMessage());
            }
        } finally {
            this.f24658a.exit(1);
        }
    }
}
