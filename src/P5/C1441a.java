package p5;

import android.os.Handler;
import android.os.HandlerThread;
import com.heytap.accessory.stream.StreamTransfer;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CallingAgentInfo.java */
/* renamed from: p5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1441a {

    /* renamed from: a, reason: collision with root package name */
    public StreamTransfer.EventListener f36014a;

    /* renamed from: b, reason: collision with root package name */
    public StreamTransfer.b f36015b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f36016c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f36017d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C0341a>> f36018e;

    /* compiled from: CallingAgentInfo.java */
    /* renamed from: p5.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0341a {

        /* renamed from: a, reason: collision with root package name */
        public long f36019a;

        /* renamed from: b, reason: collision with root package name */
        public int f36020b;
    }

    public C1441a(StreamTransfer.EventListener eventListener, HandlerThread handlerThread, Handler handler, StreamTransfer.b bVar, ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C0341a>> concurrentHashMap) {
        this.f36014a = eventListener;
        this.f36016c = handlerThread;
        this.f36017d = handler;
        this.f36018e = concurrentHashMap;
        this.f36015b = bVar;
    }

    public StreamTransfer.EventListener a() {
        return this.f36014a;
    }

    public Handler b() {
        return this.f36017d;
    }

    public HandlerThread c() {
        return this.f36016c;
    }

    public StreamTransfer.b d() {
        return this.f36015b;
    }

    public ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C0341a>> e() {
        return this.f36018e;
    }

    public void f(StreamTransfer.EventListener eventListener) {
        this.f36014a = eventListener;
    }

    public void g(StreamTransfer.b bVar) {
        this.f36015b = bVar;
    }
}
