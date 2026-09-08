package P8;

import android.net.Uri;
import kotlin.jvm.internal.i;

/* compiled from: VideoSource.kt */
/* loaded from: classes4.dex */
public final class c {
    public static final boolean a(b<Object> bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.e() instanceof Uri) {
            return true;
        }
        if (!(bVar.e() instanceof String)) {
            return false;
        }
        Object e10 = bVar.e();
        i.d(e10, "null cannot be cast to non-null type kotlin.String");
        if (((String) e10).length() <= 0) {
            return false;
        }
        return true;
    }
}
