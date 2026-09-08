package s8;

import android.content.Context;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: StatisticsExceptionHandler.java */
/* renamed from: s8.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1571n implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public Context f36894a;

    /* renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f36895b = Thread.getDefaultUncaughtExceptionHandler();

    public C1571n(Context context) {
        this.f36894a = context.getApplicationContext();
    }

    public static /* synthetic */ String c() {
        return "StatisticsExceptionHandler: get the uncaughtException.";
    }

    public final String b(Throwable th) {
        String str;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            try {
                th.printStackTrace(printWriter);
                str = stringWriter.toString();
            } catch (Exception e10) {
                C1714f.b("StatisticsExceptionHand", new C1562e(e10));
                printWriter.close();
                str = null;
            }
            return str;
        } finally {
            printWriter.close();
        }
    }

    public void d() {
        if (this == this.f36895b) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        C1714f.a("StatisticsExceptionHand", new InterfaceC1715g() { // from class: s8.m
            @Override // y8.InterfaceC1715g
            public final Object get() {
                String c10;
                c10 = C1571n.c();
                return c10;
            }
        });
        String b10 = b(th);
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(b10)) {
            u8.c cVar = new u8.c(this.f36894a);
            cVar.o(1);
            cVar.p(currentTimeMillis);
            cVar.q(b10);
            t8.g.a(this.f36894a, cVar);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f36895b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
