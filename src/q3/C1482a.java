package q3;

import com.bumptech.glide.load.DataSource;
import q3.InterfaceC1483b;

/* compiled from: NoTransition.java */
/* renamed from: q3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1482a<R> implements InterfaceC1483b<R> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1482a<?> f36130a = new C1482a<>();

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC1484c<?> f36131b = new C0342a();

    /* compiled from: NoTransition.java */
    /* renamed from: q3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0342a<R> implements InterfaceC1484c<R> {
        @Override // q3.InterfaceC1484c
        public InterfaceC1483b<R> a(DataSource dataSource, boolean z10) {
            return C1482a.f36130a;
        }
    }

    public static <R> InterfaceC1484c<R> b() {
        return (InterfaceC1484c<R>) f36131b;
    }

    @Override // q3.InterfaceC1483b
    public boolean a(Object obj, InterfaceC1483b.a aVar) {
        return false;
    }
}
