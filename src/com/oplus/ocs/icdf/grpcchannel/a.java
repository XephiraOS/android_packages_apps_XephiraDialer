package com.oplus.ocs.icdf.grpcchannel;

import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.f;
import com.oplus.ocs.icdf.grpcchannel.inner.p;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.CommonUtil;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import j9.AbstractC1190B;
import j9.AbstractC1194d;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private final com.oplus.ocs.icdf.commonchannel.a f28598g;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f28592a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, AbstractC1194d> f28593b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, a.InterfaceC0265a> f28594c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, CommonChannel> f28595d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, p> f28596e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map<PeerAgent, Boolean> f28597f = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private final com.oplus.ocs.icdf.grpcchannel.inner.b f28599h = new c();

    /* renamed from: com.oplus.ocs.icdf.grpcchannel.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0269a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f28600a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.d f28601b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28602c;

        /* renamed from: com.oplus.ocs.icdf.grpcchannel.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0270a implements CommonChannel.ChannelListener {
            public C0270a() {
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
            public void onClosed(int i10) {
                ICDFLog.d("ICDF.GrpcClientAdapter", "onClosed, reason " + i10);
                a.this.f28595d.remove(C0269a.this.f28600a);
                C0269a c0269a = C0269a.this;
                a.this.a(c0269a.f28602c);
            }
        }

        public C0269a(String str, a.d dVar, PeerAgent peerAgent) {
            this.f28600a = str;
            this.f28601b = dVar;
            this.f28602c = peerAgent;
        }

        @Override // com.oplus.ocs.icdf.a.b
        public void a(int i10, CommonChannel commonChannel) {
            if (i10 != 10005 && i10 != 10009) {
                if (commonChannel == null) {
                    ICDFLog.e("ICDF.GrpcClientAdapter", "create CommonChannel failed, ret " + i10 + ", peerAgent " + this.f28600a);
                    a.this.f28592a.remove(this.f28600a);
                    this.f28601b.a(i10, null);
                    return;
                }
                ICDFLog.i("ICDF.GrpcClientAdapter", "create CommonChannel succeed, peerAgent " + this.f28600a);
                if (a.this.f28596e.size() > 0) {
                    ICDFLog.i("ICDF.GrpcClientAdapter", "send RPC Method configurations to provider");
                    commonChannel.sendBytes(a.c(a.this), true);
                }
                AbstractC1190B build = f.a(this.f28602c).a(a.this.f28599h).a(a.this.f28596e).a(5242880).idleTimeout(30L, TimeUnit.DAYS).build();
                if (build == null) {
                    ICDFLog.e("ICDF.GrpcClientAdapter", "create gRPC Channel failed, peerAgent " + this.f28600a);
                    commonChannel.close();
                    a.this.f28592a.remove(this.f28600a);
                    this.f28601b.a(1, null);
                    return;
                }
                ICDFLog.i("ICDF.GrpcClientAdapter", "create gRPC Channel succeed, peerAgent " + this.f28600a);
                a.this.f28595d.put(this.f28600a, commonChannel);
                a.this.f28593b.put(this.f28600a, build);
                a.this.f28594c.put(this.f28600a, this.f28601b);
                commonChannel.setChannelListener(new C0270a());
                a.this.f28592a.remove(this.f28600a);
                this.f28601b.a(i10, build);
                return;
            }
            ICDFLog.e("ICDF.GrpcClientAdapter", "create CommonChannel failed, ret " + i10 + ", peerAgent " + this.f28600a);
            a.this.f28592a.remove(this.f28600a);
            this.f28601b.a(3, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0265a f28605a;

        public b(a aVar, a.InterfaceC0265a interfaceC0265a) {
            this.f28605a = interfaceC0265a;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28605a.a();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements com.oplus.ocs.icdf.grpcchannel.inner.b {
        public c() {
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.b
        public CommonChannel a(PeerAgent peerAgent) {
            a.this.f28597f.put(peerAgent, Boolean.TRUE);
            return (CommonChannel) a.this.f28595d.get(peerAgent.getAgentId());
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.b
        public void b(PeerAgent peerAgent) {
            a.this.f28597f.remove(peerAgent);
            a.this.a(peerAgent);
        }
    }

    public a(com.oplus.ocs.icdf.commonchannel.a aVar) {
        this.f28598g = aVar;
    }

    public static byte[] c(a aVar) {
        int i10;
        int i11;
        int size = aVar.f28596e.size();
        int i12 = (size * 16) + 4;
        Iterator<Map.Entry<String, p>> it = aVar.f28596e.entrySet().iterator();
        while (it.hasNext()) {
            i12 += it.next().getValue().f28736a.length();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i12);
        allocate.put(com.oplus.ocs.icdf.grpcchannel.inner.c.a(size));
        Iterator<Map.Entry<String, p>> it2 = aVar.f28596e.entrySet().iterator();
        while (it2.hasNext()) {
            p value = it2.next().getValue();
            ICDFLog.d("ICDF.GrpcClientAdapter", "rpc method " + value.f28736a + ",type " + value.f28737b + ",channelId: " + value.f28738c + ",compress " + value.f28739d + ",encrypt " + value.f28740e);
            allocate.put(com.oplus.ocs.icdf.grpcchannel.inner.c.a(value.f28736a.length()));
            allocate.put(value.f28736a.getBytes(StandardCharsets.UTF_8));
            allocate.put(com.oplus.ocs.icdf.grpcchannel.inner.c.a((short) value.f28737b));
            allocate.put(com.oplus.ocs.icdf.grpcchannel.inner.c.a((short) value.f28738c));
            if (true == value.f28739d) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (true == value.f28740e) {
                i11 = 2;
            } else {
                i11 = 0;
            }
            allocate.put(com.oplus.ocs.icdf.grpcchannel.inner.c.a(i11 | i10));
            allocate.put(com.oplus.ocs.icdf.grpcchannel.inner.c.a(0));
        }
        return com.oplus.ocs.icdf.grpcchannel.inner.c.a(0, FastPairConstants.GO_INTENT_MAX, allocate.array(), false);
    }

    public void a(String str, p pVar) {
        this.f28596e.put(str, pVar);
    }

    public void a(PeerAgent peerAgent, int i10, a.d dVar) {
        String agentId = peerAgent.getAgentId();
        AbstractC1194d abstractC1194d = this.f28593b.get(agentId);
        if (abstractC1194d != null) {
            ICDFLog.d("ICDF.GrpcClientAdapter", "createChannel, grpc channel already exist, peerAgent " + agentId);
            dVar.a(10005, abstractC1194d);
            return;
        }
        if (this.f28592a.containsKey(agentId)) {
            ICDFLog.d("ICDF.GrpcClientAdapter", "createChannel, request too frequently, peerAgent " + agentId);
            dVar.a(10009, null);
            return;
        }
        this.f28592a.put(agentId, Boolean.TRUE);
        ICDFLog.i("ICDF.GrpcClientAdapter", "createChannel request " + agentId);
        this.f28598g.a(peerAgent, i10, 2, new C0269a(agentId, dVar, peerAgent));
    }

    public void a(PeerAgent peerAgent) {
        AbstractC1190B abstractC1190B;
        String agentId = peerAgent.getAgentId();
        CommonChannel commonChannel = this.f28595d.get(agentId);
        if (commonChannel != null) {
            ICDFLog.d("ICDF.GrpcClientAdapter", "destroy CommonChannel " + agentId);
            commonChannel.close();
        }
        this.f28595d.remove(agentId);
        if (this.f28597f.containsKey(peerAgent) || (abstractC1190B = (AbstractC1190B) this.f28593b.get(agentId)) == null) {
            return;
        }
        try {
            ICDFLog.d("ICDF.GrpcClientAdapter", "try to shutdown rpcChannel " + agentId);
            ICDFLog.d("ICDF.GrpcClientAdapter", "shutdown rpcChannel " + agentId + ", status " + abstractC1190B.d().c(500L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.f28593b.remove(agentId);
        a.InterfaceC0265a remove = this.f28594c.remove(agentId);
        if (remove != null) {
            CommonUtil.DEFAULT_SCHEDULE_EXECUTOR.execute(new b(this, remove));
        }
    }

    public void a() {
        ICDFLog.i("ICDF.GrpcClientAdapter", "close");
        Iterator<Map.Entry<String, CommonChannel>> it = this.f28595d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().close();
        }
        this.f28595d.clear();
    }
}
