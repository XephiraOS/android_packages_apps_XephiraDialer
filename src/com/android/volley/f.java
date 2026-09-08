package com.android.volley;

import S2.g;
import com.android.volley.Request;
import com.android.volley.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: WaitingRequestManager.java */
/* loaded from: classes.dex */
public class f implements Request.b {

    /* renamed from: b, reason: collision with root package name */
    public final g f19261b;

    /* renamed from: d, reason: collision with root package name */
    public final b f19263d;

    /* renamed from: e, reason: collision with root package name */
    public final BlockingQueue<Request<?>> f19264e;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, List<Request<?>>> f19260a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final S2.f f19262c = null;

    public f(b bVar, BlockingQueue<Request<?>> blockingQueue, g gVar) {
        this.f19261b = gVar;
        this.f19263d = bVar;
        this.f19264e = blockingQueue;
    }

    @Override // com.android.volley.Request.b
    public synchronized void a(Request<?> request) {
        BlockingQueue<Request<?>> blockingQueue;
        try {
            String m10 = request.m();
            List<Request<?>> remove = this.f19260a.remove(m10);
            if (remove != null && !remove.isEmpty()) {
                if (e.f19252b) {
                    e.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), m10);
                }
                Request<?> remove2 = remove.remove(0);
                this.f19260a.put(m10, remove);
                remove2.I(this);
                S2.f fVar = this.f19262c;
                if (fVar != null) {
                    fVar.f(remove2);
                } else if (this.f19263d != null && (blockingQueue = this.f19264e) != null) {
                    try {
                        blockingQueue.put(remove2);
                    } catch (InterruptedException e10) {
                        e.c("Couldn't add request to queue. %s", e10.toString());
                        Thread.currentThread().interrupt();
                        this.f19263d.d();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.android.volley.Request.b
    public void b(Request<?> request, d<?> dVar) {
        List<Request<?>> remove;
        a.C0186a c0186a = dVar.f19248b;
        if (c0186a != null && !c0186a.a()) {
            String m10 = request.m();
            synchronized (this) {
                remove = this.f19260a.remove(m10);
            }
            if (remove != null) {
                if (e.f19252b) {
                    e.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), m10);
                }
                Iterator<Request<?>> it = remove.iterator();
                while (it.hasNext()) {
                    this.f19261b.a(it.next(), dVar);
                }
                return;
            }
            return;
        }
        a(request);
    }

    public synchronized boolean c(Request<?> request) {
        try {
            String m10 = request.m();
            if (this.f19260a.containsKey(m10)) {
                List<Request<?>> list = this.f19260a.get(m10);
                if (list == null) {
                    list = new ArrayList<>();
                }
                request.b("waiting-for-response");
                list.add(request);
                this.f19260a.put(m10, list);
                if (e.f19252b) {
                    e.b("Request for cacheKey=%s is in flight, putting on hold.", m10);
                }
                return true;
            }
            this.f19260a.put(m10, null);
            request.I(this);
            if (e.f19252b) {
                e.b("new request, sending to network %s", m10);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }
}
