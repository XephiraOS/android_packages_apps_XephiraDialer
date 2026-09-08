package b;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.i;

/* compiled from: ContextAwareHelper.kt */
/* renamed from: b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0512a {

    /* renamed from: a, reason: collision with root package name */
    public final Set<InterfaceC0513b> f12080a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f12081b;

    public final void a(InterfaceC0513b listener) {
        i.f(listener, "listener");
        Context context = this.f12081b;
        if (context != null) {
            listener.a(context);
        }
        this.f12080a.add(listener);
    }

    public final void b() {
        this.f12081b = null;
    }

    public final void c(Context context) {
        i.f(context, "context");
        this.f12081b = context;
        Iterator<InterfaceC0513b> it = this.f12080a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    public final Context d() {
        return this.f12081b;
    }

    public final void e(InterfaceC0513b listener) {
        i.f(listener, "listener");
        this.f12080a.remove(listener);
    }
}
