package m9;

import java.io.PrintWriter;
import java.io.StringWriter;
import r9.C1519b;

/* compiled from: Exceptions.kt */
/* loaded from: classes4.dex */
public class b {
    public static void a(Throwable th, Throwable exception) {
        kotlin.jvm.internal.i.f(th, "<this>");
        kotlin.jvm.internal.i.f(exception, "exception");
        if (th != exception) {
            C1519b.f36557a.a(th, exception);
        }
    }

    public static String b(Throwable th) {
        kotlin.jvm.internal.i.f(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.i.e(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
