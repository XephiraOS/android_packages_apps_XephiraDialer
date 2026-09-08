package com.oplus.ocs.icdf.grpcchannel.inner;

import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.c;
import com.oplus.ocs.icdf.grpcchannel.inner.q;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.C1107a;
import io.grpc.Status;
import io.grpc.internal.U;
import io.grpc.internal.l0;
import io.grpc.internal.m0;
import io.grpc.internal.n0;
import io.grpc.internal.o0;
import io.grpc.internal.s0;
import io.grpc.internal.u0;
import io.grpc.u;
import j9.InterfaceC1199i;
import j9.InterfaceC1204n;
import j9.J;
import j9.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public class m implements n0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f28697a;

    /* renamed from: b, reason: collision with root package name */
    private final String f28698b;

    /* renamed from: c, reason: collision with root package name */
    private final d f28699c;

    /* renamed from: d, reason: collision with root package name */
    private final U<ScheduledExecutorService> f28700d;

    /* renamed from: e, reason: collision with root package name */
    private final List<J.a> f28701e;

    /* renamed from: f, reason: collision with root package name */
    private final w f28702f;

    /* renamed from: g, reason: collision with root package name */
    private q f28703g;

    /* renamed from: h, reason: collision with root package name */
    private ScheduledExecutorService f28704h;

    /* renamed from: i, reason: collision with root package name */
    private o0 f28705i;

    /* renamed from: j, reason: collision with root package name */
    private C1107a f28706j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f28708l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f28709m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f28710n;

    /* renamed from: k, reason: collision with root package name */
    private final Map<Integer, c> f28707k = new ConcurrentHashMap();

    /* renamed from: o, reason: collision with root package name */
    private final q.c f28711o = new a();

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (m.this) {
                C1107a a10 = C1107a.c().d(io.grpc.k.f33410a, new n(m.this.f28703g.a())).d(io.grpc.k.f33411b, new g(m.this.f28698b)).a();
                m mVar = m.this;
                mVar.f28706j = mVar.f28705i.c(a10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements l0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f28718a;

        /* renamed from: b, reason: collision with root package name */
        private final s0 f28719b;

        /* renamed from: d, reason: collision with root package name */
        private final String f28721d;

        /* renamed from: e, reason: collision with root package name */
        private final String f28722e;

        /* renamed from: g, reason: collision with root package name */
        private m0 f28724g;

        /* renamed from: h, reason: collision with root package name */
        private int f28725h;

        /* renamed from: k, reason: collision with root package name */
        private int f28728k;

        /* renamed from: f, reason: collision with root package name */
        private final ArrayDeque<u0.a> f28723f = new ArrayDeque<>();

        /* renamed from: i, reason: collision with root package name */
        private boolean f28726i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f28727j = false;

        /* renamed from: l, reason: collision with root package name */
        private boolean f28729l = false;

        /* renamed from: c, reason: collision with root package name */
        private final Object f28720c = new Object();

        public c(int i10, String str, u uVar, String str2) {
            this.f28718a = i10;
            this.f28719b = s0.h(m.this.f28701e, str, uVar);
            this.f28721d = str2;
            this.f28722e = str;
            ICDFLog.i("ICDF.GrpcServerStream", "ServerStream create, streamId " + i10 + ", methodFullName: " + str);
        }

        public void b() {
            ICDFLog.d("ICDF.GrpcServerStream", "OnReady, streamId " + this.f28718a);
            synchronized (this) {
                this.f28726i = true;
                this.f28724g.e();
            }
        }

        public void c() {
            ICDFLog.d("ICDF.GrpcServerStream", "OnUnReady, streamId " + this.f28718a);
            synchronized (this) {
                this.f28726i = false;
            }
        }

        @Override // io.grpc.internal.l0
        public synchronized void cancel(Status status) {
            if (this.f28727j) {
                ICDFLog.w("ICDF.GrpcServerStream", "cancel, stream already closed, streamId " + this.f28718a);
                return;
            }
            byte[] bArr = {com.oplus.ocs.icdf.grpcchannel.inner.c.b(Status.f32369f)};
            ICDFLog.i("ICDF.GrpcServerStream", "send cmd_client_recv_cancel, streamId " + this.f28718a + ", status = " + status);
            if (!m.a(m.this, new h(this.f28722e, this.f28718a, (byte) 4, bArr, 2, -1))) {
                ICDFLog.e("ICDF.GrpcServerStream", "Server cancel, writeNetData failed, streamId " + this.f28718a);
            }
            a(status, status);
        }

        @Override // io.grpc.internal.l0
        public synchronized void close(Status status, u uVar) {
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
            byte[] a10 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(io.grpc.m.c(uVar));
            byte[] bArr = new byte[a10.length + 1];
            byte b10 = com.oplus.ocs.icdf.grpcchannel.inner.c.b(r10);
            bArr[0] = b10;
            if (b10 == 0) {
                ICDFLog.i("ICDF.GrpcServerStream", "send cmd_client_recv_close, streamId " + this.f28718a + " state = " + ((int) bArr[0]));
            } else {
                ICDFLog.w("ICDF.GrpcServerStream", "send cmd_client_recv_close, streamId " + this.f28718a + " state = " + ((int) bArr[0]));
            }
            System.arraycopy(a10, 0, bArr, 1, a10.length);
            if (!m.a(m.this, new h(this.f28722e, this.f28718a, (byte) 3, bArr, 2, -1))) {
                ICDFLog.e("ICDF.GrpcServerStream", "server close, writeNetData failed, streamId " + this.f28718a);
            }
            a(Status.f32368e, status);
        }

        public void d() {
            int size;
            synchronized (this) {
                size = this.f28723f.size();
            }
            synchronized (this.f28720c) {
                if (size >= 128) {
                    try {
                        ICDFLog.d("ICDF.GrpcServerStream", "serverReceiveQueue wait, receiveQueue size" + size + ", streamId " + this.f28718a);
                        this.f28729l = true;
                        this.f28720c.wait(GrpcUtils.CREATE_CHANNEL_TIME_OUT);
                    } catch (InterruptedException e10) {
                        ICDFLog.e("ICDF.GrpcServerStream", "serverReceiveQueue wait exception: " + e10);
                    }
                    this.f28729l = false;
                    ICDFLog.d("ICDF.GrpcServerStream", "serverReceiveQueue wait done, streamId " + this.f28718a);
                }
            }
        }

        @Override // io.grpc.internal.l0
        public C1107a getAttributes() {
            return m.this.f28706j;
        }

        @Override // io.grpc.internal.l0
        public String getAuthority() {
            return this.f28721d;
        }

        @Override // io.grpc.internal.t0
        public synchronized boolean isReady() {
            if (this.f28727j) {
                return false;
            }
            return this.f28726i;
        }

        @Override // io.grpc.internal.t0
        public synchronized void request(int i10) {
            int size;
            if (this.f28727j) {
                ICDFLog.w("ICDF.GrpcServerStream", "request, stream already closed, streamId " + this.f28718a);
                return;
            }
            this.f28725h += i10;
            while (this.f28725h > 0 && !this.f28723f.isEmpty()) {
                this.f28725h--;
                u0.a poll = this.f28723f.poll();
                if (poll != null) {
                    this.f28724g.c(poll);
                }
                synchronized (this) {
                    size = this.f28723f.size();
                }
            }
            this.f28723f.isEmpty();
            return;
            synchronized (this.f28720c) {
                try {
                    if (this.f28729l) {
                        if (size < 128) {
                            this.f28720c.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }

        @Override // io.grpc.internal.l0
        public synchronized void setListener(m0 m0Var) {
            this.f28724g = m0Var;
        }

        @Override // io.grpc.internal.l0
        public s0 statsTraceContext() {
            return this.f28719b;
        }

        @Override // io.grpc.internal.l0
        public int streamId() {
            return -1;
        }

        @Override // io.grpc.internal.l0
        public synchronized void writeHeaders(u uVar, boolean z10) {
            if (this.f28727j) {
                ICDFLog.w("ICDF.GrpcServerStream", "writeHeaders, stream already closed, streamId " + this.f28718a);
                return;
            }
            byte[][] c10 = io.grpc.m.c(uVar);
            if (c10 != null) {
                ICDFLog.i("ICDF.GrpcServerStream", "writeHeaders, send cmd_client_recv_head, streamId " + this.f28718a);
            } else {
                ICDFLog.w("ICDF.GrpcServerStream", "writeHeaders, send cmd_client_recv_head, streamId " + this.f28718a + ", Metadata = null ");
            }
            if (!m.a(m.this, new h(this.f28722e, this.f28718a, (byte) 1, com.oplus.ocs.icdf.grpcchannel.inner.c.a(c10), 0, -1))) {
                ICDFLog.e("ICDF.GrpcServerStream", "writeHeaders, writeNetData failed, streamId " + this.f28718a);
            }
        }

        @Override // io.grpc.internal.t0
        public synchronized void writeMessage(InputStream inputStream) {
            if (this.f28727j) {
                ICDFLog.w("ICDF.GrpcServerStream", "writeMessage, stream already closed, streamId " + this.f28718a);
                return;
            }
            if (inputStream != null) {
                try {
                    int available = inputStream.available();
                    if (available > 4194309) {
                        ICDFLog.e("ICDF.GrpcServerStream", "data length too large " + available + ", max length 4194304");
                        throw new IllegalArgumentException("data length too large");
                    }
                } catch (IOException e10) {
                    ICDFLog.w("ICDF.GrpcServerStream", "message.available() Exception: " + e10);
                }
            }
            ICDFLog.v("ICDF.GrpcServerStream", "send cmd_client_recv_data, streamId " + this.f28718a + ", seq " + this.f28728k);
            this.f28719b.i(this.f28728k);
            this.f28719b.j(this.f28728k, -1L, -1L);
            int i10 = this.f28728k;
            this.f28728k = i10 + 1;
            if (!m.a(m.this, new h(this.f28722e, this.f28718a, (byte) 2, inputStream, 1, i10))) {
                ICDFLog.e("ICDF.GrpcServerStream", "writeMessage failed, streamId " + this.f28718a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Status status, Status status2) {
            synchronized (this) {
                try {
                    if (this.f28727j) {
                        return;
                    }
                    ICDFLog.i("ICDF.GrpcServerStream", "doClose, streamId " + this.f28718a + ", listenerStatus: " + status + ", tracerStatus: " + status2 + ", serverReceiveQueue size " + this.f28723f.size());
                    this.f28727j = true;
                    this.f28719b.m(status2);
                    this.f28724g.a(status);
                    m.a(m.this, this.f28718a);
                    c cVar = (c) m.this.f28707k.remove(Integer.valueOf(this.f28718a));
                    if (!m.this.f28707k.isEmpty() || cVar == null) {
                        return;
                    }
                    synchronized (m.this) {
                        try {
                            if (m.this.f28708l) {
                                m.this.b();
                            }
                        } finally {
                        }
                    }
                } finally {
                }
            }
        }

        public void a(int i10, InputStream inputStream) {
            synchronized (this) {
                try {
                    this.f28719b.d(i10);
                    this.f28719b.e(i10, -1L, -1L);
                    i iVar = new i(inputStream);
                    int i11 = this.f28725h;
                    if (i11 > 0) {
                        this.f28725h = i11 - 1;
                        this.f28724g.c(iVar);
                    } else {
                        this.f28723f.add(iVar);
                    }
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

        @Override // io.grpc.internal.t0
        public void setCompressor(InterfaceC1199i interfaceC1199i) {
        }

        @Override // io.grpc.internal.l0
        public void setDecompressor(InterfaceC1204n interfaceC1204n) {
        }

        public void setMessageCompression(boolean z10) {
        }

        public void a(Status status) {
            a(status, status);
        }

        public void a() {
            synchronized (this) {
                try {
                    ICDFLog.i("ICDF.GrpcServerStream", "OnClientHalfClosed, streamId " + this.f28718a + ", serverReceiveQueue size " + this.f28723f.size());
                    while (!this.f28723f.isEmpty()) {
                        u0.a poll = this.f28723f.poll();
                        if (poll != null) {
                            this.f28724g.c(poll);
                        }
                    }
                    this.f28724g.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    public m(String str, CommonChannel commonChannel, d dVar, U<ScheduledExecutorService> u10, List<J.a> list) {
        this.f28698b = str;
        String agentId = commonChannel.getPeerAgent().getAgentId();
        this.f28697a = agentId;
        this.f28699c = dVar;
        q qVar = new q(commonChannel);
        this.f28703g = qVar;
        this.f28700d = u10;
        this.f28701e = list;
        this.f28702f = w.a(m.class, qVar.toString());
        ICDFLog.i("ICDF.GrpcServerTransport", "construct, peerAgent " + agentId);
    }

    public static void f(m mVar) {
        mVar.getClass();
        ICDFLog.i("ICDF.GrpcServerTransport", "onDisconnected " + mVar.f28697a);
        synchronized (mVar) {
            try {
                mVar.shutdown();
                if (mVar.f28709m) {
                    mVar.a();
                    return;
                }
                Iterator it = new ArrayList(mVar.f28707k.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    Status status = Status.f32379p;
                    cVar.a(status, status);
                }
                mVar.a();
            } finally {
            }
        }
    }

    @Override // j9.z
    public w getLogId() {
        return this.f28702f;
    }

    @Override // io.grpc.internal.n0
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.f28704h;
    }

    public com.google.common.util.concurrent.f<Object> getStats() {
        com.google.common.util.concurrent.i B10 = com.google.common.util.concurrent.i.B();
        B10.A(null);
        return B10;
    }

    @Override // io.grpc.internal.n0
    public synchronized void shutdown() {
        if (this.f28708l) {
            return;
        }
        ICDFLog.i("ICDF.GrpcServerTransport", "shutdown " + this.f28697a);
        this.f28708l = true;
        if (this.f28707k.isEmpty()) {
            b();
        }
    }

    @Override // io.grpc.internal.n0
    public void shutdownNow(Status status) {
        ICDFLog.i("ICDF.GrpcServerTransport", "shutdownNow " + this.f28697a + " reason " + status);
        synchronized (this) {
            try {
                shutdown();
                if (this.f28709m) {
                    ICDFLog.i("ICDF.GrpcServerTransport", "already closed");
                    return;
                }
                Iterator it = new ArrayList(this.f28707k.values()).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).cancel(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements q.c {

        /* renamed from: com.oplus.ocs.icdf.grpcchannel.inner.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0273a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ byte[] f28713a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f28714b;

            public RunnableC0273a(byte[] bArr, int i10) {
                this.f28713a = bArr;
                this.f28714b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr = this.f28713a;
                int i10 = this.f28714b;
                byte b10 = bArr[i10 + 2];
                int i11 = ((bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[i10 + 1] & FastPairConstants.GO_INTENT_NOT_SET);
                c cVar = (c) m.this.f28707k.get(Integer.valueOf(i11));
                if (cVar == null && 7 != b10 && 15 != b10) {
                    ICDFLog.e("ICDF.GrpcServerTransport", "onRecv, streamId " + i11 + ", command " + ((int) b10));
                    return;
                }
                if (b10 != 15) {
                    switch (b10) {
                        case 7:
                            c.a aVar = new c.a(this.f28714b + 3);
                            byte[] c10 = com.oplus.ocs.icdf.grpcchannel.inner.c.c(bArr, aVar);
                            if (c10 == null) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_head, methodFullName = null");
                                m.f(m.this);
                                return;
                            }
                            Charset charset = StandardCharsets.UTF_8;
                            String str = new String(c10, charset);
                            ICDFLog.i("ICDF.GrpcServerTransport", "recv cmd_server_recv_head, methodFullName = " + str);
                            byte[][] a10 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(bArr, aVar);
                            if (a10 == null) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_head, headersMD = null");
                                m.f(m.this);
                                return;
                            }
                            u b11 = io.grpc.m.b(a10);
                            byte[] c11 = com.oplus.ocs.icdf.grpcchannel.inner.c.c(bArr, aVar);
                            if (c11 == null) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_head, authority = null");
                                m.f(m.this);
                                return;
                            } else {
                                m.a(m.this, i11, str, b11, new String(c11, charset));
                                return;
                            }
                        case 8:
                            int length = bArr.length;
                            int i12 = this.f28714b;
                            if (length < i12 + 7) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_data data lost, copyData.length < 7");
                                m.f(m.this);
                                return;
                            }
                            c.a aVar2 = new c.a(i12 + 3);
                            int d10 = com.oplus.ocs.icdf.grpcchannel.inner.c.d(bArr, aVar2);
                            ICDFLog.v("ICDF.GrpcServerTransport", "recv cmd_server_recv_data, streamId " + i11 + ", seqNo = " + d10);
                            InputStream b12 = com.oplus.ocs.icdf.grpcchannel.inner.c.b(bArr, aVar2);
                            if (b12 == null) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_data, streamId " + i11 + ", message = null");
                                m.f(m.this);
                                return;
                            }
                            cVar.a(d10, b12);
                            return;
                        case 9:
                            ICDFLog.i("ICDF.GrpcServerTransport", "recv cmd_server_recv_half_close, streamId " + i11);
                            cVar.a();
                            return;
                        case 10:
                            if (bArr.length < this.f28714b + 4) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_cancel, streamId " + i11 + " data lost, length < 4");
                                return;
                            }
                            ICDFLog.i("ICDF.GrpcServerTransport", "recv cmd_server_recv_cancel, streamId " + i11 + ", status = " + ((int) bArr[this.f28714b + 3]));
                            Status a11 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(bArr[this.f28714b + 3]);
                            if (a11 == null) {
                                ICDFLog.e("ICDF.GrpcServerTransport", "recv cmd_server_recv_cancel, streamId " + i11 + ", status = null");
                                m.f(m.this);
                                return;
                            }
                            cVar.a(a11);
                            return;
                        case 11:
                            ICDFLog.v("ICDF.GrpcServerTransport", "recv cmd_server_recv_ready, streamId " + i11);
                            cVar.b();
                            return;
                        case 12:
                            ICDFLog.v("ICDF.GrpcServerTransport", "recv cmd_server_recv_unready, streamId " + i11);
                            cVar.c();
                            return;
                        default:
                            ICDFLog.e("ICDF.GrpcServerTransport", "server onRecv, unknown cmd " + ((int) b10));
                            return;
                    }
                }
                ICDFLog.i("ICDF.GrpcServerTransport", "recv cmd_server_recv_rpc_cfg");
                synchronized (m.this) {
                    m.this.f28703g.a(bArr, this.f28714b + 3);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m.f(m.this);
            }
        }

        public a() {
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.q.c
        public void a(byte[] bArr, int i10) {
            if (m.a(m.this, bArr, i10)) {
                m.this.a(new RunnableC0273a(bArr, i10));
            }
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.q.c
        public void a(int i10) {
            m.this.a(new b());
        }
    }

    public static void a(m mVar, int i10) {
        synchronized (mVar) {
            q qVar = mVar.f28703g;
            if (qVar != null) {
                qVar.a(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (this.f28709m) {
            return;
        }
        ICDFLog.d("ICDF.GrpcServerTransport", "terminate, peerAgent " + this.f28697a);
        this.f28709m = true;
        q qVar = this.f28703g;
        if (qVar != null) {
            qVar.b();
            this.f28703g = null;
        }
    }

    public static boolean a(m mVar, h hVar) {
        synchronized (mVar) {
            q qVar = mVar.f28703g;
            if (qVar == null) {
                return false;
            }
            return qVar.a(hVar);
        }
    }

    public static void a(m mVar, int i10, String str, u uVar, String str2) {
        synchronized (mVar) {
            try {
                if (mVar.f28708l) {
                    ICDFLog.w("ICDF.GrpcServerTransport", "newStream, already shutdown");
                } else if (mVar.f28707k.containsKey(Integer.valueOf(i10))) {
                    ICDFLog.w("ICDF.GrpcServerTransport", "newStream failed, repeat streamId " + i10);
                } else {
                    c cVar = new c(i10, str, uVar, str2);
                    mVar.f28707k.put(Integer.valueOf(i10), cVar);
                    mVar.f28705i.b(cVar, str, uVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(m mVar, byte[] bArr, int i10) {
        boolean z10;
        synchronized (mVar) {
            try {
                z10 = false;
                if (mVar.f28710n) {
                    ICDFLog.w("ICDF.GrpcServerTransport", "onRecv, ServerTransport already terminated");
                } else {
                    if (bArr != null && bArr.length >= i10 + 3) {
                        z10 = true;
                        c cVar = mVar.f28707k.get(Integer.valueOf(((bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[i10 + 1] & FastPairConstants.GO_INTENT_NOT_SET)));
                        if (cVar != null) {
                            cVar.d();
                        }
                    }
                    ICDFLog.e("ICDF.GrpcServerTransport", "checkData error, data == null or copyData.length < 3");
                    mVar.f28703g.b();
                }
            } finally {
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable) {
        try {
            this.f28704h.execute(runnable);
        } catch (Exception e10) {
            ICDFLog.w("ICDF.GrpcServerTransport", "submit task failed, msg: " + e10.getMessage());
        }
    }

    public synchronized void a(o0 o0Var) {
        ICDFLog.i("ICDF.GrpcServerTransport", "start " + this.f28697a);
        this.f28705i = o0Var;
        this.f28704h = this.f28700d.a();
        a(new b());
        this.f28703g.a(this.f28711o);
    }

    private synchronized void a() {
        try {
            if (this.f28710n) {
                return;
            }
            ICDFLog.i("ICDF.GrpcServerTransport", "notifyTerminated " + this.f28697a);
            this.f28710n = true;
            ScheduledExecutorService scheduledExecutorService = this.f28704h;
            if (scheduledExecutorService != null) {
                this.f28704h = this.f28700d.b(scheduledExecutorService);
            }
            o0 o0Var = this.f28705i;
            if (o0Var != null) {
                o0Var.a();
            }
            j.this.f28688g.remove(this);
        } catch (Throwable th) {
            throw th;
        }
    }
}
