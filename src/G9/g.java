package G9;

import java.io.InputStream;
import java.util.logging.Logger;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: JvmOkio.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f1138a = Logger.getLogger("okio.Okio");

    public static final boolean a(AssertionError assertionError) {
        String message;
        boolean y10;
        kotlin.jvm.internal.i.f(assertionError, "<this>");
        if (assertionError.getCause() != null && (message = assertionError.getMessage()) != null) {
            y10 = StringsKt__StringsKt.y(message, "getsockname failed", false, 2, null);
            if (!y10) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final n b(InputStream inputStream) {
        kotlin.jvm.internal.i.f(inputStream, "<this>");
        return new e(inputStream, new o());
    }
}
