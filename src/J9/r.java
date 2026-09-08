package j9;

import j9.J;
import java.util.List;

/* compiled from: GlobalInterceptors.java */
/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static List<InterfaceC1196f> f34040a;

    /* renamed from: b, reason: collision with root package name */
    public static List<io.grpc.C> f34041b;

    /* renamed from: c, reason: collision with root package name */
    public static List<J.a> f34042c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f34043d;

    public static synchronized List<InterfaceC1196f> a() {
        List<InterfaceC1196f> list;
        synchronized (r.class) {
            f34043d = true;
            list = f34040a;
        }
        return list;
    }

    public static synchronized List<io.grpc.C> b() {
        List<io.grpc.C> list;
        synchronized (r.class) {
            f34043d = true;
            list = f34041b;
        }
        return list;
    }

    public static synchronized List<J.a> c() {
        List<J.a> list;
        synchronized (r.class) {
            f34043d = true;
            list = f34042c;
        }
        return list;
    }
}
