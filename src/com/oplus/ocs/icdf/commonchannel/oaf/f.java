package com.oplus.ocs.icdf.commonchannel.oaf;

import a8.C0425a;
import android.content.Context;
import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.OafBaseAgentAdapter;
import com.oplus.ocs.icdf.OafBaseJobAgentAdapter;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.CommonUtil;
import com.oplus.ocs.icdf.utils.HexUtils;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public class f extends com.oplus.ocs.icdf.commonchannel.b implements com.oplus.ocs.icdf.b {

    /* renamed from: a, reason: collision with root package name */
    private final OafBaseAgentAdapter f28537a;

    /* renamed from: b, reason: collision with root package name */
    private final OafBaseJobAgentAdapter f28538b;

    /* renamed from: c, reason: collision with root package name */
    private final com.oplus.ocs.icdf.commonchannel.netty.c f28539c;

    /* renamed from: d, reason: collision with root package name */
    private final int f28540d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f28541e = false;

    /* renamed from: f, reason: collision with root package name */
    private com.oplus.ocs.icdf.commonchannel.oaf.inner.a f28542f = null;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, a.b> f28543g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private Map<String, a.b> f28544h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private Map<String, CommonChannel> f28545i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private Map<String, CommonChannel> f28546j = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public class a implements BiConsumer<String, CommonChannel> {
        public a(f fVar) {
        }

        @Override // java.util.function.BiConsumer
        public void accept(String str, CommonChannel commonChannel) {
            commonChannel.close();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BiConsumer<String, CommonChannel> {
        public b(f fVar) {
        }

        @Override // java.util.function.BiConsumer
        public void accept(String str, CommonChannel commonChannel) {
            commonChannel.close();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements OAFConnectionSocket.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.oplus.ocs.icdf.model.a f28547a;

        public c(com.oplus.ocs.icdf.model.a aVar) {
            this.f28547a = aVar;
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket.b
        public void a(PeerAgent peerAgent, int i10) {
            f.this.f28539c.a(this.f28547a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.oplus.ocs.icdf.model.a f28549a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f28550b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseSocket f28551c;

        public d(com.oplus.ocs.icdf.model.a aVar, i iVar, BaseSocket baseSocket) {
            this.f28549a = aVar;
            this.f28550b = iVar;
            this.f28551c = baseSocket;
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.d
        public boolean onBytesReceived(byte[] bArr) {
            if (bArr.length != 78 || ((bArr[0] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[1] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((bArr[2] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[3] & FastPairConstants.GO_INTENT_NOT_SET) != 1768121446 || ((bArr[4] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[5] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((bArr[6] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[7] & FastPairConstants.GO_INTENT_NOT_SET) != 10) {
                return false;
            }
            int i10 = bArr[8] & FastPairConstants.GO_INTENT_NOT_SET;
            byte[] bArr2 = new byte[64];
            System.arraycopy(bArr, 10, bArr2, 0, 64);
            String ipIntToString = CommonUtil.ipIntToString(((bArr[74] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((bArr[75] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((bArr[76] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (bArr[77] & FastPairConstants.GO_INTENT_NOT_SET));
            if (i10 == 1) {
                f.a(f.this, this.f28549a, this.f28550b, bArr2, ipIntToString);
            } else {
                f.a(f.this, this.f28549a, this.f28550b, (OAFConnectionSocket) this.f28551c, bArr2, ipIntToString);
            }
            return true;
        }
    }

    public f(Context context, OafBaseAgentAdapter oafBaseAgentAdapter, int i10) {
        this.f28540d = i10;
        this.f28537a = oafBaseAgentAdapter;
        oafBaseAgentAdapter.setServerAdapterListener(this);
        this.f28539c = new com.oplus.ocs.icdf.commonchannel.netty.c(context);
        this.f28538b = null;
    }

    public static void a(f fVar, com.oplus.ocs.icdf.model.a aVar, i iVar, byte[] bArr, String str) {
        fVar.getClass();
        String agentId = aVar.a().getAgentId();
        int transportType = aVar.a().getAccessory().getTransportType();
        ICDFLog.i("ICDF.OafCommonChannelServer", "createExtraNettyChannel request " + agentId + ", transport type " + transportType);
        if (transportType != 1 && transportType != 8) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "Wifi or WiFi-P2P not connected, create NettyChannelServer failed");
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(0, 0, null), true);
            return;
        }
        C0425a c0425a = new C0425a();
        byte[] g10 = c0425a.g();
        if (g10 == null) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "generate encrypt key failed, create NettyChannelServer failed");
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(0, 0, null), true);
            return;
        }
        com.oplus.ocs.icdf.commonchannel.b a10 = fVar.f28539c.a(aVar, str);
        if (a10 == null) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "start NettyChannelServer failed");
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(0, 0, null), true);
            return;
        }
        int ipStringToInt = CommonUtil.ipStringToInt(str);
        int a11 = a10.a();
        ICDFLog.i("ICDF.OafCommonChannelServer", "NettyChannelServer , " + HexUtils.hideAddress(str) + ":" + a11);
        iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(ipStringToInt, a11, g10), true);
        a10.a(aVar, new h(fVar, agentId, c0425a, bArr));
    }

    @Override // com.oplus.ocs.icdf.commonchannel.b
    public void b(com.oplus.ocs.icdf.model.PeerAgent peerAgent, a.b bVar) {
        this.f28544h.put(((com.oplus.ocs.icdf.model.a) peerAgent).a().getAgentId(), bVar);
    }

    public synchronized boolean c() {
        ICDFLog.i("ICDF.OafCommonChannelServer", "start");
        this.f28541e = false;
        return true;
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f28541e) {
                    return;
                }
                this.f28541e = true;
                ICDFLog.i("ICDF.OafCommonChannelServer", "close");
                this.f28545i.forEach(new a(this));
                this.f28545i.clear();
                this.f28546j.forEach(new b(this));
                this.f28546j.clear();
                this.f28539c.a();
                com.oplus.ocs.icdf.commonchannel.oaf.inner.a aVar = this.f28542f;
                if (aVar != null) {
                    aVar.b();
                    this.f28542f = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public f(Context context, OafBaseJobAgentAdapter oafBaseJobAgentAdapter, int i10) {
        this.f28540d = i10;
        this.f28538b = oafBaseJobAgentAdapter;
        oafBaseJobAgentAdapter.setServerAdapterListener(this);
        this.f28539c = new com.oplus.ocs.icdf.commonchannel.netty.c(context);
        this.f28537a = null;
    }

    public static void a(f fVar, com.oplus.ocs.icdf.model.a aVar, i iVar, OAFConnectionSocket oAFConnectionSocket, byte[] bArr, String str) {
        fVar.getClass();
        String agentId = aVar.a().getAgentId();
        int transportType = aVar.a().getAccessory().getTransportType();
        ICDFLog.i("ICDF.OafCommonChannelServer", "createNettyChannel request " + agentId + ", transport type " + transportType);
        if (transportType != 1 && transportType != 8) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "Wifi or WiFi-P2P not connected, create NettyChannelServer failed");
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(0, 0, null), true);
            return;
        }
        C0425a c0425a = new C0425a();
        byte[] g10 = c0425a.g();
        if (g10 == null) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "generate encrypt key failed, create NettyChannelServer failed");
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(0, 0, null), true);
            return;
        }
        com.oplus.ocs.icdf.commonchannel.b a10 = fVar.f28539c.a(aVar, str);
        if (a10 == null) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "start NettyChannelServer failed");
            iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(0, 0, null), true);
            return;
        }
        int ipStringToInt = CommonUtil.ipStringToInt(str);
        int a11 = a10.a();
        ICDFLog.i("ICDF.OafCommonChannelServer", "NettyChannelServer , " + HexUtils.hideAddress(str) + ":" + a11);
        iVar.a(com.oplus.ocs.icdf.commonchannel.d.b(ipStringToInt, a11, g10), true);
        a10.a(aVar, new g(fVar, agentId, c0425a, bArr, iVar, oAFConnectionSocket));
    }

    @Override // com.oplus.ocs.icdf.commonchannel.b
    public void a(com.oplus.ocs.icdf.model.PeerAgent peerAgent, a.b bVar) {
        String agentId = ((com.oplus.ocs.icdf.model.a) peerAgent).a().getAgentId();
        ICDFLog.i("ICDF.OafCommonChannelServer", "accept " + agentId);
        CommonChannel commonChannel = this.f28545i.get(agentId);
        if (commonChannel != null) {
            ICDFLog.i("ICDF.OafCommonChannelServer", "channel already exist " + agentId);
            bVar.a(0, commonChannel);
            return;
        }
        this.f28543g.put(agentId, bVar);
    }

    @Override // com.oplus.ocs.icdf.b
    public void a(com.oplus.ocs.icdf.model.a aVar) {
        String agentId = aVar.a().getAgentId();
        synchronized (this) {
            try {
                if (this.f28541e) {
                    return;
                }
                ICDFLog.i("ICDF.OafCommonChannelServer", "destroy Common Channel peerAgent " + agentId);
                CommonChannel commonChannel = this.f28545i.get(agentId);
                if (commonChannel != null) {
                    commonChannel.close();
                    this.f28545i.remove(agentId);
                }
                CommonChannel commonChannel2 = this.f28546j.get(agentId);
                if (commonChannel2 != null) {
                    commonChannel2.close();
                    this.f28546j.remove(agentId);
                }
                this.f28544h.remove(agentId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.oplus.ocs.icdf.b
    public void a(com.oplus.ocs.icdf.model.a aVar, BaseSocket baseSocket, int i10) {
        String agentId = aVar.a().getAgentId();
        ICDFLog.i("ICDF.OafCommonChannelServer", "onConnectionResponse, peerAgent " + agentId + ", result " + i10);
        a.b remove = this.f28543g.remove(agentId);
        if (remove == null) {
            ICDFLog.e("ICDF.OafCommonChannelServer", "No createChannelRequest found, peerAgent " + agentId);
            return;
        }
        if (baseSocket instanceof OAFConnectionSocket) {
            OAFConnectionSocket oAFConnectionSocket = (OAFConnectionSocket) baseSocket;
            oAFConnectionSocket.a(new c(aVar));
            if (this.f28542f == null) {
                OafBaseAgentAdapter oafBaseAgentAdapter = this.f28537a;
                if (oafBaseAgentAdapter != null) {
                    this.f28542f = new com.oplus.ocs.icdf.commonchannel.oaf.inner.a(oafBaseAgentAdapter);
                } else {
                    this.f28542f = new com.oplus.ocs.icdf.commonchannel.oaf.inner.a(this.f28538b);
                }
            }
            i iVar = new i(aVar, oAFConnectionSocket, this.f28542f, this.f28540d, this);
            this.f28545i.put(agentId, iVar);
            remove.a(0, iVar);
            iVar.a(new d(aVar, iVar, baseSocket));
            return;
        }
        remove.a(i10, null);
    }
}
