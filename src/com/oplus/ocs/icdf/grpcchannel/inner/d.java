package com.oplus.ocs.icdf.grpcchannel.inner;

import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.c;
import com.oplus.ocs.icdf.grpcchannel.inner.q;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.internal.C;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.E;
import io.grpc.internal.F;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InterfaceC1128j;
import io.grpc.internal.InterfaceC1129k;
import io.grpc.internal.InterfaceC1130l;
import io.grpc.internal.InterfaceC1131m;
import io.grpc.internal.P;
import io.grpc.internal.s0;
import io.grpc.internal.u0;
import io.grpc.u;
import j9.C1203m;
import j9.InterfaceC1199i;
import j9.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class d implements InterfaceC1131m {

    /* renamed from: a, reason: collision with root package name */
    private final String f28615a;

    /* renamed from: b, reason: collision with root package name */
    private final PeerAgent f28616b;

    /* renamed from: c, reason: collision with root package name */
    private final com.oplus.ocs.icdf.grpcchannel.inner.b f28617c;

    /* renamed from: d, reason: collision with root package name */
    private final C1107a f28618d;

    /* renamed from: e, reason: collision with root package name */
    private final String f28619e;

    /* renamed from: f, reason: collision with root package name */
    private final String f28620f;

    /* renamed from: g, reason: collision with root package name */
    private final w f28621g;

    /* renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f28622h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, p> f28623i;

    /* renamed from: j, reason: collision with root package name */
    private final q.c f28624j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<Integer, f> f28625k;

    /* renamed from: l, reason: collision with root package name */
    private final E<f> f28626l;

    /* renamed from: m, reason: collision with root package name */
    private Status f28627m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f28628n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f28629o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f28630p;

    /* renamed from: q, reason: collision with root package name */
    private P.a f28631q;

    /* renamed from: r, reason: collision with root package name */
    private q f28632r;

    /* renamed from: s, reason: collision with root package name */
    private int f28633s;

    /* loaded from: classes3.dex */
    public class b extends E<f> {
        public b() {
        }

        @Override // io.grpc.internal.E
        public void handleInUse() {
            d.this.f28631q.d(true);
        }

        @Override // io.grpc.internal.E
        public void handleNotInUse() {
            d.this.f28631q.d(false);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1129k.a f28640a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Status f28641b;

        public c(d dVar, InterfaceC1129k.a aVar, Status status) {
            this.f28641b = status;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28641b.c();
            throw null;
        }
    }

    /* renamed from: com.oplus.ocs.icdf.grpcchannel.inner.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0272d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC1129k.a f28642a;

        public RunnableC0272d(d dVar, InterfaceC1129k.a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonChannel f28643a;

        public e(CommonChannel commonChannel) {
            this.f28643a = commonChannel;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                try {
                    CommonChannel commonChannel = this.f28643a;
                    if (commonChannel == null) {
                        d.f(d.this);
                        return;
                    }
                    d.this.f28632r = new q(commonChannel);
                    d.this.f28632r.a(d.this.f28624j);
                    d.this.f28632r.a(d.this.f28623i);
                    d.k(d.this);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements InterfaceC1128j {

        /* renamed from: a, reason: collision with root package name */
        private final int f28645a;

        /* renamed from: b, reason: collision with root package name */
        private final s0 f28646b;

        /* renamed from: c, reason: collision with root package name */
        private final Object f28647c;

        /* renamed from: d, reason: collision with root package name */
        private final C1108b f28648d;

        /* renamed from: e, reason: collision with root package name */
        private final u f28649e;

        /* renamed from: f, reason: collision with root package name */
        private final MethodDescriptor<?, ?> f28650f;

        /* renamed from: g, reason: collision with root package name */
        private final ArrayDeque<u0.a> f28651g;

        /* renamed from: h, reason: collision with root package name */
        private ClientStreamListener f28652h;

        /* renamed from: i, reason: collision with root package name */
        private int f28653i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f28654j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f28655k;

        /* renamed from: l, reason: collision with root package name */
        private int f28656l;

        /* renamed from: m, reason: collision with root package name */
        private volatile String f28657m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f28658n;

        public /* synthetic */ f(d dVar, int i10, MethodDescriptor methodDescriptor, u uVar, C1108b c1108b, String str, AbstractC1112f[] abstractC1112fArr, a aVar) {
            this(i10, methodDescriptor, uVar, c1108b, str, abstractC1112fArr);
        }

        public void b() {
            synchronized (this) {
                this.f28654j = false;
            }
        }

        public void c() {
            int size;
            synchronized (this) {
                size = this.f28651g.size();
            }
            synchronized (this.f28647c) {
                if (size >= 128) {
                    try {
                        ICDFLog.d("ICDF.GrpcClientStream", "clientReceiveQueue wait, receiveQueue size" + size + ", streamId " + this.f28645a);
                        this.f28658n = true;
                        this.f28647c.wait(GrpcUtils.CREATE_CHANNEL_TIME_OUT);
                    } catch (InterruptedException e10) {
                        ICDFLog.e("ICDF.GrpcClientStream", "clientReceiveQueue wait exception: " + e10);
                    }
                    this.f28658n = false;
                    ICDFLog.d("ICDF.GrpcClientStream", "clientReceiveQueue wait done, streamId " + this.f28645a);
                }
            }
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public synchronized void cancel(Status status) {
            Status r10;
            if (status != null) {
                try {
                    r10 = Status.h(status.m().c()).r(status.n());
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                r10 = null;
            }
            byte[] bArr = {com.oplus.ocs.icdf.grpcchannel.inner.c.b(r10)};
            ICDFLog.i("ICDF.GrpcClientStream", "send cmd_server_recv_cancel, streamId " + this.f28645a + ", status = " + status);
            if (!d.a(d.this, new h(this.f28650f.c(), this.f28645a, (byte) 10, bArr, 2, -1))) {
                ICDFLog.e("ICDF.GrpcClientStream", "client cancel, writeNetData failed! streamId " + this.f28645a);
            }
            a(status, new u(), ClientStreamListener.RpcProgress.PROCESSED);
        }

        public C1107a getAttributes() {
            return C1107a.f32411c;
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public synchronized void halfClose() {
            if (this.f28655k) {
                ICDFLog.w("ICDF.GrpcClientStream", "halfClose, stream already closed, streamId " + this.f28645a);
                return;
            }
            ICDFLog.i("ICDF.GrpcClientStream", "send cmd_server_recv_half_close, streamId " + this.f28645a);
            if (!d.a(d.this, new h(this.f28650f.c(), this.f28645a, (byte) 9, (byte[]) null, 2, -1))) {
                ICDFLog.e("ICDF.GrpcClientStream", "client halfClose, writeNetData failed, streamId " + this.f28645a);
            }
        }

        @Override // io.grpc.internal.t0
        public synchronized boolean isReady() {
            if (this.f28655k) {
                return false;
            }
            return this.f28654j;
        }

        @Override // io.grpc.internal.t0
        public synchronized void request(int i10) {
            int size;
            if (this.f28655k) {
                ICDFLog.w("ICDF.GrpcClientStream", "request, stream already closed, streamId " + this.f28645a);
                return;
            }
            this.f28653i += i10;
            while (this.f28653i > 0 && !this.f28651g.isEmpty()) {
                this.f28653i--;
                this.f28652h.c(this.f28651g.poll());
                synchronized (this) {
                    size = this.f28651g.size();
                }
            }
            this.f28651g.isEmpty();
            return;
            synchronized (this.f28647c) {
                try {
                    if (this.f28658n) {
                        if (size < 128) {
                            this.f28647c.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void setAuthority(String str) {
            this.f28657m = str;
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void setDeadline(C1203m c1203m) {
            u uVar = this.f28649e;
            u.g<Long> gVar = GrpcUtil.f32522d;
            uVar.f(gVar);
            this.f28649e.o(gVar, Long.valueOf(Math.max(0L, c1203m.k(TimeUnit.NANOSECONDS))));
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void setMaxInboundMessageSize(int i10) {
            ICDFLog.i("ICDF.GrpcClientStream", "setMaxInboundMessageSize: " + i10);
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void setMaxOutboundMessageSize(int i10) {
            ICDFLog.i("ICDF.GrpcClientStream", "setMaxOutboundMessageSize: " + i10);
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void start(ClientStreamListener clientStreamListener) {
            d.this.f28625k.put(Integer.valueOf(this.f28645a), this);
            synchronized (this) {
                try {
                    this.f28652h = clientStreamListener;
                    this.f28646b.c();
                    if (GrpcUtil.m(this.f28648d)) {
                        d.this.f28626l.updateObjectInUse(this, true);
                    }
                    ICDFLog.i("ICDF.GrpcClientStream", "send cmd_server_recv_head, streamId " + this.f28645a + ", methodFullName = " + this.f28650f.c());
                    String c10 = this.f28650f.c();
                    Charset charset = StandardCharsets.UTF_8;
                    byte[] a10 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(c10.getBytes(charset));
                    byte[] a11 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(io.grpc.m.c(this.f28649e));
                    byte[] a12 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(this.f28657m.getBytes(charset));
                    byte[] bArr = new byte[a10.length + a11.length + a12.length];
                    System.arraycopy(a10, 0, bArr, 0, a10.length);
                    System.arraycopy(a11, 0, bArr, a10.length, a11.length);
                    System.arraycopy(a12, 0, bArr, a11.length + a10.length, a12.length);
                    if (!d.a(d.this, new h(this.f28650f.c(), this.f28645a, (byte) 7, bArr, 0, -1))) {
                        ICDFLog.e("ICDF.GrpcClientStream", "client start, writeNetData failed! streamId " + this.f28645a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.t0
        public synchronized void writeMessage(InputStream inputStream) {
            if (this.f28655k) {
                ICDFLog.w("ICDF.GrpcClientStream", "writeMessage, stream already closed, streamId " + this.f28645a);
                return;
            }
            if (inputStream != null) {
                try {
                    int available = inputStream.available();
                    if (available > 4194309) {
                        ICDFLog.e("ICDF.GrpcClientStream", "data length too large " + available + ", allowed max length 4194304");
                        throw new IllegalArgumentException("data length too large");
                    }
                } catch (IOException e10) {
                    ICDFLog.w("ICDF.GrpcClientStream", "message.available() Exception: " + e10);
                }
            }
            ICDFLog.v("ICDF.GrpcClientStream", "send cmd_server_recv_data, streamId " + this.f28645a + ", seq " + this.f28656l);
            this.f28646b.i(this.f28656l);
            this.f28646b.j(this.f28656l, -1L, -1L);
            this.f28656l = this.f28656l + 1;
            if (!d.a(d.this, new h(this.f28650f.c(), this.f28645a, (byte) 8, inputStream, 1, this.f28656l - 1))) {
                ICDFLog.e("ICDF.GrpcClientStream", "writeMessage failed, streamId " + this.f28645a);
            }
        }

        private f(int i10, MethodDescriptor<?, ?> methodDescriptor, u uVar, C1108b c1108b, String str, AbstractC1112f[] abstractC1112fArr) {
            this.f28651g = new ArrayDeque<>();
            this.f28654j = false;
            this.f28655k = false;
            this.f28658n = false;
            if (i10 > 65535) {
                i10 -= 65535;
                d.this.f28633s = i10;
            }
            this.f28645a = i10;
            this.f28650f = (MethodDescriptor) com.google.common.base.k.p(methodDescriptor, Constants.MessagerConstants.METHOD_KEY);
            this.f28649e = (u) com.google.common.base.k.p(uVar, "headers");
            this.f28648d = (C1108b) com.google.common.base.k.p(c1108b, "callOptions");
            this.f28657m = str;
            this.f28647c = new Object();
            this.f28646b = s0.g(abstractC1112fArr, d.this.f28618d, uVar);
            ICDFLog.i("ICDF.GrpcClientStream", "create client stream, streamId " + i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Status status, u uVar, ClientStreamListener.RpcProgress rpcProgress) {
            synchronized (this) {
                try {
                    if (this.f28655k) {
                        return;
                    }
                    ICDFLog.i("ICDF.GrpcClientStream", "doClose, streamId " + this.f28645a + ", clientReceiveQueue size " + this.f28651g.size());
                    this.f28655k = true;
                    this.f28646b.m(status);
                    this.f28652h.f(status, rpcProgress, uVar);
                    d.b(d.this, this.f28645a);
                    f fVar = (f) d.this.f28625k.remove(Integer.valueOf(this.f28645a));
                    if (GrpcUtil.m(this.f28648d)) {
                        d.this.f28626l.updateObjectInUse(this, false);
                    }
                    if (!d.this.f28625k.isEmpty() || fVar == null) {
                        return;
                    }
                    synchronized (d.this) {
                        try {
                            if (d.this.f28628n) {
                                d.this.b();
                            }
                        } finally {
                        }
                    }
                } finally {
                }
            }
        }

        public void a(u uVar) {
            synchronized (this) {
                try {
                    if (this.f28655k) {
                        ICDFLog.w("ICDF.GrpcClientStream", "OnHeadersRead, stream already closed, streamId " + this.f28645a);
                        return;
                    }
                    this.f28646b.a();
                    this.f28652h.d(uVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.t0
        public void flush() {
        }

        @Override // io.grpc.internal.t0
        public void optimizeForDirectExecutor() {
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void appendTimeoutInsight(F f10) {
        }

        @Override // io.grpc.internal.t0
        public void setCompressor(InterfaceC1199i interfaceC1199i) {
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void setDecompressorRegistry(j9.o oVar) {
        }

        @Override // io.grpc.internal.InterfaceC1128j
        public void setFullStreamDecompression(boolean z10) {
        }

        public void setMessageCompression(boolean z10) {
        }

        public void a(int i10, InputStream inputStream) {
            synchronized (this) {
                try {
                    if (this.f28655k) {
                        ICDFLog.w("ICDF.GrpcClientStream", "OnMessageRead, stream already closed, streamId " + this.f28645a);
                        return;
                    }
                    this.f28646b.a();
                    this.f28652h.d(this.f28649e);
                    this.f28646b.d(i10);
                    this.f28646b.e(i10, -1L, -1L);
                    i iVar = new i(inputStream);
                    int i11 = this.f28653i;
                    if (i11 > 0) {
                        this.f28653i = i11 - 1;
                        this.f28652h.c(iVar);
                    } else {
                        this.f28651g.add(iVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(Status status, u uVar) {
            synchronized (this) {
                try {
                    if (this.f28655k) {
                        ICDFLog.w("ICDF.GrpcClientStream", "OnServerClosed, stream already closed, streamId " + this.f28645a);
                        return;
                    }
                    ICDFLog.i("ICDF.GrpcClientStream", "OnServerClosed, streamId " + this.f28645a + ", clientReceiveQueue size " + this.f28651g.size());
                    if (this.f28651g.isEmpty()) {
                        this.f28646b.b(uVar);
                        a(status, uVar, ClientStreamListener.RpcProgress.PROCESSED);
                    } else {
                        while (!this.f28651g.isEmpty()) {
                            this.f28652h.c(this.f28651g.poll());
                        }
                        this.f28646b.b(uVar);
                        a(status, uVar, ClientStreamListener.RpcProgress.PROCESSED);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(Status status) {
            ICDFLog.i("ICDF.GrpcClientStream", "call OnServerCanceled, streamId " + this.f28645a);
            a(status, new u(), ClientStreamListener.RpcProgress.PROCESSED);
        }

        public void a() {
            synchronized (this) {
                this.f28654j = true;
                this.f28652h.e();
            }
        }
    }

    public d(PeerAgent peerAgent, com.oplus.ocs.icdf.grpcchannel.inner.b bVar, Map<String, p> map, ScheduledExecutorService scheduledExecutorService, InterfaceC1130l.a aVar) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f28623i = concurrentHashMap;
        this.f28624j = new a();
        this.f28625k = new ConcurrentHashMap();
        this.f28626l = new b();
        this.f28633s = 0;
        concurrentHashMap.putAll(map);
        this.f28616b = peerAgent;
        String agentId = peerAgent.getAgentId();
        this.f28615a = agentId;
        this.f28617c = bVar;
        this.f28622h = scheduledExecutorService;
        this.f28619e = aVar.a();
        this.f28620f = GrpcUtil.g("inprocess", aVar.c());
        com.google.common.base.k.p(aVar.b(), "eagAttrs");
        this.f28618d = C1107a.c().d(C.f32462a, SecurityLevel.PRIVACY_AND_INTEGRITY).d(C.f32463b, aVar.b()).a();
        this.f28621g = w.a(d.class, peerAgent.toString());
        ICDFLog.i("ICDF.GrpcClientTransport", "ClientTransport construct, peerAgent: " + agentId);
    }

    public static boolean a(d dVar, byte[] bArr, int i10) {
        dVar.getClass();
        if (bArr != null && bArr.length >= i10 + 3) {
            f fVar = dVar.f28625k.get(Integer.valueOf(((bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[i10 + 1] & FastPairConstants.GO_INTENT_NOT_SET)));
            if (fVar == null) {
                return true;
            }
            fVar.c();
            return true;
        }
        synchronized (dVar) {
            dVar.f28632r.b();
        }
        ICDFLog.e("ICDF.GrpcClientTransport", "checkData error, data==null or copyData.length < 3");
        return false;
    }

    public static void f(d dVar) {
        dVar.getClass();
        ICDFLog.i("ICDF.GrpcClientTransport", "onDisconnected, peerAgent " + dVar.f28615a);
        synchronized (dVar) {
            try {
                dVar.shutdown(Status.f32379p);
                if (dVar.f28629o) {
                    dVar.a();
                    return;
                }
                Iterator it = new ArrayList(dVar.f28625k.values()).iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a(Status.f32379p, new u(), ClientStreamListener.RpcProgress.PROCESSED);
                }
                dVar.a();
            } finally {
            }
        }
    }

    public static void k(d dVar) {
        synchronized (dVar) {
            dVar.f28631q.c();
        }
    }

    public C1107a getAttributes() {
        return this.f28618d;
    }

    @Override // j9.z
    public w getLogId() {
        return this.f28621g;
    }

    public com.google.common.util.concurrent.f<Object> getStats() {
        com.google.common.util.concurrent.i B10 = com.google.common.util.concurrent.i.B();
        B10.A(null);
        return B10;
    }

    @Override // io.grpc.internal.InterfaceC1129k
    public synchronized InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
        if (this.f28628n) {
            return new com.oplus.ocs.icdf.grpcchannel.inner.e(this, s0.g(abstractC1112fArr, this.f28618d, uVar), this.f28627m);
        }
        uVar.o(GrpcUtil.f32530l, this.f28620f);
        int i10 = this.f28633s + 1;
        this.f28633s = i10;
        return new f(this, i10, methodDescriptor, uVar, c1108b, this.f28619e, abstractC1112fArr, null);
    }

    public synchronized void ping(InterfaceC1129k.a aVar, Executor executor) {
        try {
            if (this.f28630p) {
                executor.execute(new c(this, aVar, this.f28627m));
            } else {
                executor.execute(new RunnableC0272d(this, aVar));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // io.grpc.internal.P
    public synchronized void shutdown(Status status) {
        if (this.f28628n) {
            return;
        }
        ICDFLog.i("ICDF.GrpcClientTransport", "ClientTransport shutdown, reason: " + status + ", peerAgent " + this.f28615a);
        this.f28627m = status;
        this.f28628n = true;
        this.f28631q.b(status);
        if (this.f28625k.isEmpty()) {
            b();
        }
    }

    @Override // io.grpc.internal.P
    public void shutdownNow(Status status) {
        com.google.common.base.k.p(status, "reason");
        ICDFLog.i("ICDF.GrpcClientTransport", "ClientTransport shutdownNow, reason: " + status + ", peerAgent " + this.f28615a);
        synchronized (this) {
            try {
                shutdown(status);
                if (this.f28629o) {
                    return;
                }
                Iterator it = new ArrayList(this.f28625k.values()).iterator();
                while (it.hasNext()) {
                    ((f) it.next()).cancel(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.P
    public synchronized Runnable start(P.a aVar) {
        ICDFLog.i("ICDF.GrpcClientTransport", "ClientTransport start " + this.f28615a);
        this.f28631q = aVar;
        return new e(this.f28617c.a(this.f28616b));
    }

    public String toString() {
        return com.google.common.base.f.c(this).c("logId", this.f28621g.d()).d("peerAgent", this.f28616b.toString()).toString();
    }

    /* loaded from: classes3.dex */
    public class a implements q.c {

        /* renamed from: com.oplus.ocs.icdf.grpcchannel.inner.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0271a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ byte[] f28635a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f28636b;

            public RunnableC0271a(byte[] bArr, int i10) {
                this.f28635a = bArr;
                this.f28636b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                byte[] bArr = this.f28635a;
                int i10 = this.f28636b;
                int i11 = ((bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[i10 + 1] & FastPairConstants.GO_INTENT_NOT_SET);
                f fVar = (f) d.this.f28625k.get(Integer.valueOf(i11));
                if (fVar == null) {
                    ICDFLog.e("ICDF.GrpcClientTransport", "onRecv, not find stream, streamId " + i11);
                    return;
                }
                int i12 = this.f28636b;
                switch (bArr[i12 + 2]) {
                    case 1:
                        byte[][] a10 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(bArr, new c.a(i12 + 3));
                        if (a10 != null) {
                            ICDFLog.i("ICDF.GrpcClientTransport", "recv cmd_client_recv_head, streamId " + i11);
                            fVar.a(io.grpc.m.b(a10));
                            return;
                        }
                        ICDFLog.e("ICDF.GrpcClientTransport", "recv cmd_client_recv_head, streamId " + i11 + " Metadata = null");
                        fVar.a(new u());
                        return;
                    case 2:
                        if (bArr.length < i12 + 7) {
                            ICDFLog.e("ICDF.GrpcClientTransport", "recv cmd_client_recv_data, copyData.length < 7, streamId " + i11);
                            d.f(d.this);
                            return;
                        }
                        c.a aVar = new c.a(i12 + 3);
                        int d10 = com.oplus.ocs.icdf.grpcchannel.inner.c.d(bArr, aVar);
                        ICDFLog.v("ICDF.GrpcClientTransport", "recv cmd_client_recv_data, stream " + i11 + ", seqNo = " + d10);
                        InputStream b10 = com.oplus.ocs.icdf.grpcchannel.inner.c.b(bArr, aVar);
                        if (b10 == null) {
                            ICDFLog.e("ICDF.GrpcClientTransport", "recv cmd_client_recv_data, message = null, streamId " + i11);
                            d.f(d.this);
                            return;
                        }
                        fVar.a(d10, b10);
                        return;
                    case 3:
                        if (bArr.length < i12 + 4) {
                            ICDFLog.e("ICDF.GrpcClientTransport", "recv cmd_client_recv_close, streamId " + i11 + " data lost");
                            fVar.a(Status.f32370g, new u());
                            return;
                        }
                        byte b11 = bArr[i12 + 3];
                        if (b11 == 0) {
                            ICDFLog.i("ICDF.GrpcClientTransport", "recv cmd_client_recv_close, streamId " + i11 + " status = " + ((int) b11));
                        } else {
                            ICDFLog.w("ICDF.GrpcClientTransport", "recv cmd_client_recv_close, streamId " + i11 + " status = " + ((int) b11));
                        }
                        byte[][] a11 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(bArr, new c.a(this.f28636b + 4));
                        if (a11 != null) {
                            uVar = io.grpc.m.b(a11);
                        } else {
                            uVar = new u();
                        }
                        fVar.a(com.oplus.ocs.icdf.grpcchannel.inner.c.a(bArr[this.f28636b + 3]), uVar);
                        return;
                    case 4:
                        if (bArr.length < i12 + 4) {
                            ICDFLog.e("ICDF.GrpcClientTransport", "recv cmd_client_recv_cancel, streamId " + i11 + " data lost");
                            fVar.a(Status.f32370g);
                            return;
                        }
                        ICDFLog.i("ICDF.GrpcClientTransport", "recv cmd_client_recv_cancel, streamId " + i11 + " status = " + ((int) bArr[this.f28636b + 3]));
                        fVar.a(com.oplus.ocs.icdf.grpcchannel.inner.c.a(bArr[this.f28636b + 3]));
                        return;
                    case 5:
                        ICDFLog.v("ICDF.GrpcClientTransport", "recv cmd_client_recv_ready, streamId " + i11);
                        fVar.a();
                        return;
                    case 6:
                        ICDFLog.v("ICDF.GrpcClientTransport", "recv cmd_client_recv_unready, streamId " + i11);
                        fVar.b();
                        return;
                    default:
                        com.google.common.base.k.v(false, "client onRecv : unknown cmd!");
                        return;
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.f(d.this);
            }
        }

        public a() {
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.q.c
        public void a(byte[] bArr, int i10) {
            if (d.a(d.this, bArr, i10)) {
                d.a(d.this, new RunnableC0271a(bArr, i10));
            }
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.q.c
        public void a(int i10) {
            d.a(d.this, new b());
        }
    }

    public static void b(d dVar, int i10) {
        synchronized (dVar) {
            q qVar = dVar.f28632r;
            if (qVar != null) {
                qVar.a(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (this.f28629o) {
            return;
        }
        ICDFLog.d("ICDF.GrpcClientTransport", "terminate, peerAgent " + this.f28615a);
        this.f28629o = true;
        q qVar = this.f28632r;
        if (qVar != null) {
            qVar.b();
            this.f28632r = null;
        }
    }

    public static boolean a(d dVar, h hVar) {
        synchronized (dVar) {
            q qVar = dVar.f28632r;
            if (qVar == null) {
                return false;
            }
            return qVar.a(hVar);
        }
    }

    public static void a(d dVar, Runnable runnable) {
        dVar.getClass();
        try {
            dVar.f28622h.execute(runnable);
        } catch (Exception e10) {
            ICDFLog.w("ICDF.GrpcClientTransport", "submit task failed, msg: " + e10.getMessage());
        }
    }

    private synchronized void a() {
        if (this.f28630p) {
            return;
        }
        ICDFLog.i("ICDF.GrpcClientTransport", "notifyTerminated, peerAgent " + this.f28615a);
        this.f28630p = true;
        this.f28631q.a();
        this.f28617c.b(this.f28616b);
    }
}
