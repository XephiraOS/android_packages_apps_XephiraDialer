package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.ProxiedSocketAddress;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.q0;
import io.grpc.internal.u0;
import io.grpc.m;
import io.grpc.q;
import io.grpc.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class GrpcUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f32519a = Logger.getLogger(GrpcUtil.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Set<Status.Code> f32520b = Collections.unmodifiableSet(EnumSet.of(Status.Code.OK, Status.Code.INVALID_ARGUMENT, Status.Code.NOT_FOUND, Status.Code.ALREADY_EXISTS, Status.Code.FAILED_PRECONDITION, Status.Code.ABORTED, Status.Code.OUT_OF_RANGE, Status.Code.DATA_LOSS));

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f32521c = Charset.forName("US-ASCII");

    /* renamed from: d, reason: collision with root package name */
    public static final u.g<Long> f32522d = u.g.c("grpc-timeout", new TimeoutMarshaller());

    /* renamed from: e, reason: collision with root package name */
    public static final u.g<String> f32523e;

    /* renamed from: f, reason: collision with root package name */
    public static final u.g<byte[]> f32524f;

    /* renamed from: g, reason: collision with root package name */
    public static final u.g<String> f32525g;

    /* renamed from: h, reason: collision with root package name */
    public static final u.g<byte[]> f32526h;

    /* renamed from: i, reason: collision with root package name */
    public static final u.g<String> f32527i;

    /* renamed from: j, reason: collision with root package name */
    public static final u.g<String> f32528j;

    /* renamed from: k, reason: collision with root package name */
    public static final u.g<String> f32529k;

    /* renamed from: l, reason: collision with root package name */
    public static final u.g<String> f32530l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.common.base.l f32531m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f32532n;

    /* renamed from: o, reason: collision with root package name */
    public static final long f32533o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f32534p;

    /* renamed from: q, reason: collision with root package name */
    public static final j9.E f32535q;

    /* renamed from: r, reason: collision with root package name */
    public static final j9.E f32536r;

    /* renamed from: s, reason: collision with root package name */
    public static final C1108b.c<Boolean> f32537s;

    /* renamed from: t, reason: collision with root package name */
    public static final AbstractC1112f f32538t;

    /* renamed from: u, reason: collision with root package name */
    public static final q0.d<Executor> f32539u;

    /* renamed from: v, reason: collision with root package name */
    public static final q0.d<ScheduledExecutorService> f32540v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.google.common.base.o<com.google.common.base.m> f32541w;

    /* loaded from: classes4.dex */
    public static class TimeoutMarshaller implements u.d<Long> {
        @Override // io.grpc.u.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            boolean z10;
            boolean z11;
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.e(z10, "empty timeout");
            if (str.length() <= 9) {
                z11 = true;
            } else {
                z11 = false;
            }
            com.google.common.base.k.e(z11, "bad timeout format");
            long parseLong = Long.parseLong(str.substring(0, str.length() - 1));
            char charAt = str.charAt(str.length() - 1);
            if (charAt != 'H') {
                if (charAt != 'M') {
                    if (charAt != 'S') {
                        if (charAt != 'u') {
                            if (charAt != 'm') {
                                if (charAt == 'n') {
                                    return Long.valueOf(parseLong);
                                }
                                throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(charAt)));
                            }
                            return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(parseLong));
                        }
                        return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(parseLong));
                    }
                    return Long.valueOf(TimeUnit.SECONDS.toNanos(parseLong));
                }
                return Long.valueOf(TimeUnit.MINUTES.toNanos(parseLong));
            }
            return Long.valueOf(TimeUnit.HOURS.toNanos(parseLong));
        }

        @Override // io.grpc.u.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l10) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l10.longValue() >= 0) {
                if (l10.longValue() < 100000000) {
                    return l10 + "n";
                }
                if (l10.longValue() < 100000000000L) {
                    return timeUnit.toMicros(l10.longValue()) + "u";
                }
                if (l10.longValue() < 100000000000000L) {
                    return timeUnit.toMillis(l10.longValue()) + "m";
                }
                if (l10.longValue() < 100000000000000000L) {
                    return timeUnit.toSeconds(l10.longValue()) + "S";
                }
                if (l10.longValue() < 6000000000000000000L) {
                    return timeUnit.toMinutes(l10.longValue()) + "M";
                }
                return timeUnit.toHours(l10.longValue()) + "H";
            }
            throw new IllegalArgumentException("Timeout too small");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements j9.E {
        @Override // j9.E
        public ProxiedSocketAddress a(SocketAddress socketAddress) {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AbstractC1112f {
    }

    /* loaded from: classes4.dex */
    public class c implements q0.d<Executor> {
        @Override // io.grpc.internal.q0.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // io.grpc.internal.q0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Executor create() {
            return Executors.newCachedThreadPool(GrpcUtil.i("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    /* loaded from: classes4.dex */
    public class d implements q0.d<ScheduledExecutorService> {
        @Override // io.grpc.internal.q0.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // io.grpc.internal.q0.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService create() {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, GrpcUtil.i("grpc-timer-%d", true));
            try {
                newScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(newScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
            return Executors.unconfigurableScheduledExecutorService(newScheduledThreadPool);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements com.google.common.base.o<com.google.common.base.m> {
        @Override // com.google.common.base.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.base.m get() {
            return com.google.common.base.m.c();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements InterfaceC1129k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1112f.a f32542a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1129k f32543b;

        public f(AbstractC1112f.a aVar, InterfaceC1129k interfaceC1129k) {
            this.f32542a = aVar;
            this.f32543b = interfaceC1129k;
        }

        @Override // j9.z
        public j9.w getLogId() {
            return this.f32543b.getLogId();
        }

        @Override // io.grpc.internal.InterfaceC1129k
        public InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
            boolean z10;
            AbstractC1112f a10 = this.f32542a.a(AbstractC1112f.b.a().b(c1108b).a(), uVar);
            if (abstractC1112fArr[abstractC1112fArr.length - 1] == GrpcUtil.f32538t) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "lb tracer already assigned");
            abstractC1112fArr[abstractC1112fArr.length - 1] = a10;
            return this.f32543b.newStream(methodDescriptor, uVar, c1108b, abstractC1112fArr);
        }
    }

    /* loaded from: classes4.dex */
    public static final class g implements m.a<byte[]> {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // io.grpc.u.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.u.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(byte[] bArr) {
            return bArr;
        }
    }

    static {
        u.d<String> dVar = io.grpc.u.f33499e;
        f32523e = u.g.c("grpc-encoding", dVar);
        a aVar = null;
        f32524f = io.grpc.m.a("grpc-accept-encoding", new g(aVar));
        f32525g = u.g.c("content-encoding", dVar);
        f32526h = io.grpc.m.a("accept-encoding", new g(aVar));
        f32527i = u.g.c("content-length", dVar);
        f32528j = u.g.c("content-type", dVar);
        f32529k = u.g.c("te", dVar);
        f32530l = u.g.c("user-agent", dVar);
        f32531m = com.google.common.base.l.e(',').i();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f32532n = timeUnit.toNanos(20L);
        f32533o = TimeUnit.HOURS.toNanos(2L);
        f32534p = timeUnit.toNanos(20L);
        f32535q = new Z();
        f32536r = new a();
        f32537s = C1108b.c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f32538t = new b();
        f32539u = new c();
        f32540v = new d();
        f32541w = new e();
    }

    public static URI b(String str) {
        com.google.common.base.k.p(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e10) {
            throw new IllegalArgumentException("Invalid authority: " + str, e10);
        }
    }

    public static String c(String str) {
        boolean z10;
        if (b(str).getAuthority().indexOf(64) == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.k(z10, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void d(u0.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next != null) {
                e(next);
            } else {
                return;
            }
        }
    }

    public static void e(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            f32519a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e10);
        }
    }

    public static AbstractC1112f[] f(C1108b c1108b, io.grpc.u uVar, int i10, boolean z10) {
        List<AbstractC1112f.a> i11 = c1108b.i();
        int size = i11.size();
        AbstractC1112f[] abstractC1112fArr = new AbstractC1112f[size + 1];
        AbstractC1112f.b a10 = AbstractC1112f.b.a().b(c1108b).d(i10).c(z10).a();
        for (int i12 = 0; i12 < i11.size(); i12++) {
            abstractC1112fArr[i12] = i11.get(i12).a(a10, uVar);
        }
        abstractC1112fArr[size] = f32538t;
        return abstractC1112fArr;
    }

    public static String g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append('/');
        sb.append("1.61.0");
        return sb.toString();
    }

    public static String h(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory i(String str, boolean z10) {
        return new com.google.common.util.concurrent.j().e(z10).f(str).b();
    }

    public static InterfaceC1129k j(q.f fVar, boolean z10) {
        InterfaceC1129k interfaceC1129k;
        q.i c10 = fVar.c();
        if (c10 != null) {
            interfaceC1129k = ((w0) c10.e()).a();
        } else {
            interfaceC1129k = null;
        }
        if (interfaceC1129k != null) {
            AbstractC1112f.a b10 = fVar.b();
            if (b10 == null) {
                return interfaceC1129k;
            }
            return new f(b10, interfaceC1129k);
        }
        if (!fVar.a().o()) {
            if (fVar.d()) {
                return new C1139v(l(fVar.a()), ClientStreamListener.RpcProgress.DROPPED);
            }
            if (!z10) {
                return new C1139v(l(fVar.a()), ClientStreamListener.RpcProgress.PROCESSED);
            }
        }
        return null;
    }

    public static <T> boolean k(Iterable<T> iterable, T t10) {
        if (iterable instanceof Collection) {
            try {
                return ((Collection) iterable).contains(t10);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (com.google.common.base.h.a(it.next(), t10)) {
                return true;
            }
        }
        return false;
    }

    public static Status l(Status status) {
        boolean z10;
        if (status != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.d(z10);
        if (f32520b.contains(status.m())) {
            return Status.f32382s.r("Inappropriate status code from control plane: " + status.m() + " " + status.n()).q(status.l());
        }
        return status;
    }

    public static boolean m(C1108b c1108b) {
        return !Boolean.TRUE.equals(c1108b.h(f32537s));
    }
}
