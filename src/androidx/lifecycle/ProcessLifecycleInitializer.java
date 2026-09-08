package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.A;
import g0.C1029a;
import g0.InterfaceC1030b;
import java.util.List;

/* compiled from: ProcessLifecycleInitializer.kt */
/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements InterfaceC1030b<InterfaceC0492o> {
    @Override // g0.InterfaceC1030b
    public List<Class<? extends InterfaceC1030b<?>>> a() {
        List<Class<? extends InterfaceC1030b<?>>> h10;
        h10 = kotlin.collections.o.h();
        return h10;
    }

    @Override // g0.InterfaceC1030b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC0492o b(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        C1029a e10 = C1029a.e(context);
        kotlin.jvm.internal.i.e(e10, "getInstance(context)");
        if (e10.g(ProcessLifecycleInitializer.class)) {
            C0488k.a(context);
            A.b bVar = A.f10220i;
            bVar.b(context);
            return bVar.a();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }
}
