package V;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.i;

/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<b<?>, Object> f3956a = new LinkedHashMap();

    /* compiled from: CreationExtras.kt */
    /* renamed from: V.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0073a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0073a f3957b = new C0073a();

        @Override // V.a
        public <T> T a(b<T> key) {
            i.f(key, "key");
            return null;
        }
    }

    /* compiled from: CreationExtras.kt */
    /* loaded from: classes.dex */
    public interface b<T> {
    }

    public abstract <T> T a(b<T> bVar);

    public final Map<b<?>, Object> b() {
        return this.f3956a;
    }
}
