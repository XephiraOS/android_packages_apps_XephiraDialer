package androidx.window.layout;

import android.app.Activity;
import java.util.concurrent.Executor;

/* compiled from: WindowBackend.kt */
/* loaded from: classes.dex */
public interface WindowBackend {
    void a(I.a<WindowLayoutInfo> aVar);

    void b(Activity activity, Executor executor, I.a<WindowLayoutInfo> aVar);
}
