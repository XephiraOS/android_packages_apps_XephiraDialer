package Q7;

import kotlin.Result;
import m9.q;

/* compiled from: ActivityResultLauncherExt.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final <I> boolean a(androidx.activity.result.b<I> bVar, I i10, androidx.core.app.b bVar2) {
        Object b10;
        q qVar;
        try {
            Result.a aVar = Result.f34166a;
            if (bVar != null) {
                bVar.b(i10, bVar2);
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("ActivityResultLauncherExt", "launchSafely " + d10.getMessage());
        }
        return Result.g(b10);
    }

    public static /* synthetic */ boolean b(androidx.activity.result.b bVar, Object obj, androidx.core.app.b bVar2, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            bVar2 = null;
        }
        return a(bVar, obj, bVar2);
    }
}
