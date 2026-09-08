package io.grpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class InternalChannelz {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f32310f = Logger.getLogger(InternalChannelz.class.getName());

    /* renamed from: g, reason: collision with root package name */
    public static final InternalChannelz f32311g = new InternalChannelz();

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap<Long, j9.v<Object>> f32312a = new ConcurrentSkipListMap();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap<Long, j9.v<Object>> f32313b = new ConcurrentSkipListMap();

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentMap<Long, j9.v<Object>> f32314c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentMap<Long, j9.v<Object>> f32315d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentMap<Long, ServerSocketMap> f32316e = new ConcurrentHashMap();

    /* loaded from: classes4.dex */
    public static final class ServerSocketMap extends ConcurrentSkipListMap<Long, j9.v<Object>> {
        private static final long serialVersionUID = -7883772124944661414L;

        private ServerSocketMap() {
        }
    }

    public static <T extends j9.v<?>> void a(Map<Long, T> map, T t10) {
        map.put(Long.valueOf(t10.getLogId().d()), t10);
    }

    public static <T extends j9.v<?>> boolean g(Map<Long, T> map, j9.w wVar) {
        return map.containsKey(Long.valueOf(wVar.d()));
    }

    public static long h(j9.z zVar) {
        return zVar.getLogId().d();
    }

    public static InternalChannelz i() {
        return f32311g;
    }

    public static <T extends j9.v<?>> void j(Map<Long, T> map, T t10) {
        map.remove(Long.valueOf(h(t10)));
    }

    public void b(j9.v<Object> vVar) {
        a(this.f32315d, vVar);
    }

    public void c(j9.v<Object> vVar) {
        a(this.f32313b, vVar);
    }

    public boolean containsClientSocket(j9.w wVar) {
        return g(this.f32315d, wVar);
    }

    public boolean containsServer(j9.w wVar) {
        return g(this.f32312a, wVar);
    }

    public boolean containsSubchannel(j9.w wVar) {
        return g(this.f32314c, wVar);
    }

    public void d(j9.v<Object> vVar) {
        this.f32316e.put(Long.valueOf(h(vVar)), new ServerSocketMap());
        a(this.f32312a, vVar);
    }

    public void e(j9.v<Object> vVar, j9.v<Object> vVar2) {
        a(this.f32316e.get(Long.valueOf(h(vVar))), vVar2);
    }

    public void f(j9.v<Object> vVar) {
        a(this.f32314c, vVar);
    }

    public void k(j9.v<Object> vVar) {
        j(this.f32315d, vVar);
    }

    public void l(j9.v<Object> vVar) {
        j(this.f32313b, vVar);
    }

    public void m(j9.v<Object> vVar) {
        j(this.f32312a, vVar);
        this.f32316e.remove(Long.valueOf(h(vVar)));
    }

    public void n(j9.v<Object> vVar, j9.v<Object> vVar2) {
        j(this.f32316e.get(Long.valueOf(h(vVar))), vVar2);
    }

    public void o(j9.v<Object> vVar) {
        j(this.f32314c, vVar);
    }
}
