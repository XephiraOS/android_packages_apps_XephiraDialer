package com.oplus.ocs.icdf.commonchannel.oaf;

import a8.C0425a;
import android.content.Context;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.heytap.accessory.BaseSocket;
import com.oplus.ocs.icdf.OafBaseAgentAdapter;
import com.oplus.ocs.icdf.OafBaseJobAgentAdapter;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.CommonUtil;
import com.oplus.ocs.icdf.utils.HexUtils;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public class a implements com.oplus.ocs.icdf.b {

    /* renamed from: a, reason: collision with root package name */
    private final OafBaseAgentAdapter f28497a;

    /* renamed from: b, reason: collision with root package name */
    private final OafBaseJobAgentAdapter f28498b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28499c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f28500d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, CommonChannel> f28501e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, CommonChannel> f28502f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, c> f28503g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, a.InterfaceC0265a> f28504h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Boolean> f28505i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Boolean> f28506j = new ConcurrentHashMap();

    /* renamed from: k, reason: collision with root package name */
    private com.oplus.ocs.icdf.commonchannel.oaf.inner.a f28507k = null;

    /* renamed from: com.oplus.ocs.icdf.commonchannel.oaf.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0267a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0265a f28508a;

        public RunnableC0267a(a aVar, a.InterfaceC0265a interfaceC0265a) {
            this.f28508a = interfaceC0265a;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f28508a.a();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BiConsumer<String, CommonChannel> {
        public b(a aVar) {
        }

        @Override // java.util.function.BiConsumer
        public void accept(String str, CommonChannel commonChannel) {
            commonChannel.close();
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private final a.b f28509a;

        /* renamed from: b, reason: collision with root package name */
        private final int f28510b;

        public c(a aVar, a.b bVar, int i10, int i11) {
            this.f28509a = bVar;
            this.f28510b = i10;
        }

        public a.b a() {
            return this.f28509a;
        }

        public int b() {
            return this.f28510b;
        }
    }

    public a(Context context, OafBaseAgentAdapter oafBaseAgentAdapter, int i10) {
        this.f28500d = context;
        this.f28497a = oafBaseAgentAdapter;
        this.f28499c = i10;
        oafBaseAgentAdapter.setClientAdapterListener(this);
        this.f28498b = null;
    }

    public static com.oplus.ocs.icdf.commonchannel.netty.a a(a aVar, com.oplus.ocs.icdf.model.a aVar2, String str, int i10) {
        aVar.getClass();
        String agentId = aVar2.getAgentId();
        if (i10 > 0) {
            ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "createNettyChannel response " + agentId + ", server address " + HexUtils.hideAddress(str) + ":" + i10);
            com.oplus.ocs.icdf.commonchannel.netty.d dVar = new com.oplus.ocs.icdf.commonchannel.netty.d(new Socket());
            try {
                dVar.a(str, i10);
                return new com.oplus.ocs.icdf.commonchannel.netty.a(aVar.f28500d, aVar2, dVar);
            } catch (IOException unused) {
                ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "connect server failed " + agentId);
            }
        }
        return null;
    }

    public void a(com.oplus.ocs.icdf.model.a aVar, int i10, int i11, a.b bVar) {
        String agentId = aVar.a().getAgentId();
        ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "createChannel request " + agentId + ", protocol " + i10 + ", channelType " + i11);
        CommonChannel commonChannel = this.f28501e.get(agentId);
        if (commonChannel != null && !commonChannel.isClosed()) {
            ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "channel already exist " + agentId);
            bVar.a(10005, null);
            return;
        }
        if (this.f28503g.containsKey(agentId)) {
            ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "connection request too frequently " + agentId);
            bVar.a(10009, null);
            return;
        }
        this.f28503g.put(agentId, new c(this, bVar, i10, i11));
        OafBaseAgentAdapter oafBaseAgentAdapter = this.f28497a;
        if (oafBaseAgentAdapter != null) {
            oafBaseAgentAdapter.connectOafPeerAgent(aVar);
        } else {
            this.f28498b.connectOafPeerAgent(aVar);
        }
    }

    public a(Context context, OafBaseJobAgentAdapter oafBaseJobAgentAdapter, int i10) {
        this.f28500d = context;
        this.f28498b = oafBaseJobAgentAdapter;
        this.f28499c = i10;
        oafBaseJobAgentAdapter.setClientAdapterListener(this);
        this.f28497a = null;
    }

    public void a(com.oplus.ocs.icdf.model.a aVar, int i10, a.b bVar) {
        String agentId = aVar.a().getAgentId();
        int transportType = aVar.a().getAccessory().getTransportType();
        ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "createExtraChannel request " + agentId + ", protocol " + i10 + ", transport type " + transportType);
        CommonChannel commonChannel = this.f28502f.get(agentId);
        if (commonChannel != null) {
            ICDFLog.w("ICDF.OafCommonChannelClientAdapter", "createExtraChannel failed, extraChannel already exist");
            bVar.a(10005, commonChannel);
            return;
        }
        if (transportType != 1 && transportType != 8) {
            ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "createExtraChannel failed, transport type not supported");
            bVar.a(1, null);
            return;
        }
        if (i10 != 1) {
            ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "createExtraChannel failed, protocol not supported");
            bVar.a(1, null);
            return;
        }
        if (!this.f28501e.containsKey(agentId)) {
            ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "createExtraChannel failed, cannot create extra channel without basic connection");
            bVar.a(1, null);
            return;
        }
        if (this.f28506j.containsKey(agentId)) {
            ICDFLog.w("ICDF.OafCommonChannelClientAdapter", "createExtraChannel failed, request too frequently");
            bVar.a(10009, null);
            return;
        }
        this.f28506j.put(agentId, Boolean.TRUE);
        String deviceIpAddress = aVar.getPeerAccessory().getDeviceIpAddress();
        i iVar = (i) this.f28501e.get(agentId);
        String agentId2 = aVar.a().getAgentId();
        ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "try to create ExtraNettyChannel, peerAgent " + agentId2);
        C0425a c0425a = new C0425a();
        byte[] g10 = c0425a.g();
        if (g10 == null) {
            bVar.a(1, null);
        } else {
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.a(1, CommonUtil.ipStringToInt(deviceIpAddress), g10), true);
            iVar.a(new e(this, agentId2, CommonUtil.DEFAULT_SCHEDULE_EXECUTOR.schedule(new d(this, agentId2, iVar, bVar), GrpcUtils.CREATE_CHANNEL_TIME_OUT, TimeUnit.MILLISECONDS), aVar, deviceIpAddress, iVar, bVar, c0425a));
        }
    }

    @Override // com.oplus.ocs.icdf.b
    public void a(com.oplus.ocs.icdf.model.a aVar) {
        String agentId = aVar.a().getAgentId();
        ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "destroy CommonChannel, peerAgentId " + agentId);
        this.f28501e.remove(agentId);
        CommonChannel commonChannel = this.f28502f.get(agentId);
        if (commonChannel != null) {
            commonChannel.close();
            this.f28502f.remove(agentId);
        }
        a.InterfaceC0265a interfaceC0265a = this.f28504h.get(agentId);
        if (interfaceC0265a != null) {
            CommonUtil.DEFAULT_SCHEDULE_EXECUTOR.execute(new RunnableC0267a(this, interfaceC0265a));
        }
    }

    @Override // com.oplus.ocs.icdf.b
    public void a(com.oplus.ocs.icdf.model.a aVar, BaseSocket baseSocket, int i10) {
        String agentId = aVar.a().getAgentId();
        ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "onConnectionResponse result " + i10 + ", peerAgent " + agentId);
        c cVar = this.f28503g.get(agentId);
        if (cVar == null) {
            ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "No createChannelRequestInfo found!");
            return;
        }
        if (baseSocket instanceof OAFConnectionSocket) {
            OAFConnectionSocket oAFConnectionSocket = (OAFConnectionSocket) baseSocket;
            if (this.f28507k == null) {
                OafBaseAgentAdapter oafBaseAgentAdapter = this.f28497a;
                if (oafBaseAgentAdapter != null) {
                    this.f28507k = new com.oplus.ocs.icdf.commonchannel.oaf.inner.a(oafBaseAgentAdapter);
                } else {
                    this.f28507k = new com.oplus.ocs.icdf.commonchannel.oaf.inner.a(this.f28498b);
                }
            }
            i iVar = new i(aVar, oAFConnectionSocket, this.f28507k, this.f28499c, this);
            if (cVar.b() == 0) {
                a(aVar, 0, iVar);
                return;
            }
            int transportType = aVar.a().getAccessory().getTransportType();
            if (transportType != 1 && transportType != 8) {
                a(aVar, 2, iVar);
                return;
            }
            String deviceIpAddress = aVar.getPeerAccessory().getDeviceIpAddress();
            String agentId2 = aVar.a().getAgentId();
            ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "try to create NettyChannel, peerAgent " + agentId2);
            C0425a c0425a = new C0425a();
            byte[] g10 = c0425a.g();
            if (g10 == null) {
                a(aVar, 2, iVar);
                return;
            }
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.a(0, CommonUtil.ipStringToInt(deviceIpAddress), g10), true);
            this.f28505i.put(agentId2, Boolean.TRUE);
            iVar.a(new com.oplus.ocs.icdf.commonchannel.oaf.c(this, agentId2, CommonUtil.DEFAULT_SCHEDULE_EXECUTOR.schedule(new com.oplus.ocs.icdf.commonchannel.oaf.b(this, agentId2, iVar, aVar), GrpcUtils.CREATE_CHANNEL_TIME_OUT, TimeUnit.MILLISECONDS), aVar, deviceIpAddress, iVar, c0425a, oAFConnectionSocket));
            return;
        }
        cVar.a().a(i10, null);
        if (i10 != 10009) {
            this.f28503g.remove(agentId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.oplus.ocs.icdf.model.a aVar, int i10, CommonChannel commonChannel) {
        String agentId = aVar.a().getAgentId();
        c cVar = this.f28503g.get(agentId);
        if (commonChannel.isClosed()) {
            cVar.a().a(1, null);
        } else {
            this.f28501e.put(agentId, commonChannel);
            a.b a10 = cVar.a();
            if (a10 instanceof a.InterfaceC0265a) {
                this.f28504h.put(agentId, (a.InterfaceC0265a) a10);
            }
            a10.a(i10, commonChannel);
        }
        this.f28503g.remove(agentId);
    }

    public void a() {
        ICDFLog.i("ICDF.OafCommonChannelClientAdapter", "close");
        com.oplus.ocs.icdf.commonchannel.oaf.inner.a aVar = this.f28507k;
        if (aVar != null) {
            aVar.b();
            this.f28507k = null;
        }
        this.f28502f.forEach(new b(this));
        this.f28502f.clear();
    }
}
