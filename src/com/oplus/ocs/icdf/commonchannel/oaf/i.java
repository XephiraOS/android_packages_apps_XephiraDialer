package com.oplus.ocs.icdf.commonchannel.oaf;

import com.heytap.accessory.bean.PeerAgent;
import com.oplus.ocs.icdf.TrafficClass;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class i extends com.oplus.ocs.icdf.commonchannel.c {

    /* renamed from: a, reason: collision with root package name */
    private final com.oplus.ocs.icdf.commonchannel.oaf.inner.a f28564a;

    /* renamed from: b, reason: collision with root package name */
    private final com.oplus.ocs.icdf.b f28565b;

    /* renamed from: c, reason: collision with root package name */
    private final OAFConnectionSocket f28566c;

    /* renamed from: d, reason: collision with root package name */
    private final String f28567d;

    /* renamed from: e, reason: collision with root package name */
    private CommonChannel.StreamListener f28568e;

    /* renamed from: f, reason: collision with root package name */
    private CommonChannel.BytesListener f28569f;

    /* renamed from: g, reason: collision with root package name */
    private d f28570g;

    /* renamed from: h, reason: collision with root package name */
    private int f28571h;

    /* renamed from: i, reason: collision with root package name */
    private com.oplus.ocs.icdf.commonchannel.c f28572i;

    /* renamed from: j, reason: collision with root package name */
    private List<CommonChannel.ChannelListener> f28573j;

    /* renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Long> f28574k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f28575l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f28576m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f28577n;

    /* renamed from: o, reason: collision with root package name */
    private volatile TrafficClass f28578o;

    /* loaded from: classes3.dex */
    public class a implements e {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.e
        public void a(byte[] bArr) {
            ICDFLog.v("ICDF.OafCommonChannelTransport", "onBytes received from " + i.this.f28567d + ", length " + bArr.length);
            if (i.this.f28570g == null || !i.this.f28570g.onBytesReceived(bArr)) {
                if (i.this.f28569f != null) {
                    i.this.f28569f.onBytesReceived(bArr);
                } else {
                    ICDFLog.e("ICDF.OafCommonChannelTransport", "bytesListener is null");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements OAFConnectionSocket.b {
        public b() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket.b
        public void a(PeerAgent peerAgent, int i10) {
            i.this.a(i10);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        boolean onBytesReceived(byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(InputStream inputStream);

        void a(String str, long j10, int i10);

        void onTransportCanceled(int i10, int i11);

        void onTransportCompleted(int i10, int i11);
    }

    public i(com.oplus.ocs.icdf.model.a aVar, OAFConnectionSocket oAFConnectionSocket, com.oplus.ocs.icdf.commonchannel.oaf.inner.a aVar2, int i10, com.oplus.ocs.icdf.b bVar) {
        super(aVar);
        this.f28573j = new ArrayList();
        new ConcurrentHashMap();
        this.f28574k = new ConcurrentHashMap<>();
        this.f28575l = false;
        this.f28576m = false;
        this.f28577n = true;
        this.f28578o = TrafficClass.BEST_EFFORT;
        this.f28565b = bVar;
        this.f28566c = oAFConnectionSocket;
        this.f28571h = i10;
        this.f28564a = aVar2;
        this.f28567d = aVar.getAgentId();
        oAFConnectionSocket.a(new a());
        oAFConnectionSocket.a(new b());
        aVar2.a(getPeerAgent().getAgentId(), new c(aVar));
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void cancelAllStreamTransport() {
        this.f28564a.a();
        this.f28574k.clear();
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void cancelStreamTransport(int i10) {
        this.f28564a.a(this.f28574k.get(Integer.valueOf(i10)).longValue(), i10);
        this.f28574k.remove(Integer.valueOf(i10));
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void close() {
        a(0);
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public int getProtocol() {
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            return cVar.getProtocol();
        }
        return 0;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public synchronized boolean isClosed() {
        return this.f28575l;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void receiveStream(int i10) {
        this.f28564a.b(this.f28574k.get(Integer.valueOf(i10)).longValue(), i10);
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void rejectStream(int i10) {
        this.f28564a.c(this.f28574k.get(Integer.valueOf(i10)).longValue(), i10);
        this.f28574k.remove(Integer.valueOf(i10));
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void sendBytes(byte[] bArr, boolean z10) {
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            cVar.sendBytes(bArr, z10);
            return;
        }
        if (this.f28566c != null) {
            ICDFLog.v("ICDF.OafCommonChannelTransport", "sendBytes to " + this.f28567d + ", length " + bArr.length);
            try {
                if (z10) {
                    this.f28566c.secureSend(this.f28571h, bArr);
                } else {
                    this.f28566c.send(this.f28571h, bArr);
                }
                return;
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            }
        }
        ICDFLog.w("ICDF.OafCommonChannelTransport", "send Bytes failed. ");
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public int sendStream(InputStream inputStream) {
        int a10 = this.f28564a.a(((com.oplus.ocs.icdf.model.a) getPeerAgent()).a(), inputStream);
        ICDFLog.d("ICDF.OafCommonChannelTransport", "streamTransaction id = " + a10);
        return a10;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setBytesListener(CommonChannel.BytesListener bytesListener) {
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            cVar.setBytesListener(bytesListener);
        } else {
            this.f28569f = bytesListener;
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public synchronized void setChannelListener(CommonChannel.ChannelListener channelListener) {
        if (channelListener == null) {
            ICDFLog.e("ICDF.OafCommonChannelTransport", "setChannelListener failed, listener is null.");
        } else if (this.f28575l) {
            ICDFLog.w("ICDF.OafCommonChannelTransport", "setChannelListener failed, channel already closed.");
            channelListener.onClosed(1);
        } else {
            this.f28573j.add(channelListener);
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setP2pPowerSave(boolean z10) {
        ICDFLog.i("ICDF.OafCommonChannelTransport", "setP2pPowerSave " + z10 + ", peerAgent " + getPeerAgent().getAgentId());
        this.f28577n = z10;
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            cVar.setP2pPowerSave(z10);
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setStreamListener(CommonChannel.StreamListener streamListener) {
        ICDFLog.i("ICDF.OafCommonChannelTransport", "setStreamListener");
        this.f28568e = streamListener;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setTcpIpTos(TrafficClass trafficClass) {
        ICDFLog.i("ICDF.OafCommonChannelTransport", "setTcpIpTos " + trafficClass.toString() + ", peerAgent " + getPeerAgent().getAgentId());
        this.f28578o = trafficClass;
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            cVar.setTcpIpTos(trafficClass);
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setTcpNoDelay(boolean z10) {
        ICDFLog.i("ICDF.OafCommonChannelTransport", "setTcpNoDelay " + z10 + ", peerAgent " + getPeerAgent().getAgentId());
        this.f28576m = z10;
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            cVar.setTcpNoDelay(z10);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.oplus.ocs.icdf.model.a f28581a;

        public c(com.oplus.ocs.icdf.model.a aVar) {
            this.f28581a = aVar;
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.f
        public void a(InputStream inputStream) {
            if (i.this.f28568e != null) {
                i.this.f28568e.onStreamReceived(inputStream);
            }
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.f
        public void onTransportCanceled(int i10, int i11) {
            i.this.f28568e.onTransportCanceled(i10, i11);
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.f
        public void onTransportCompleted(int i10, int i11) {
            i.this.f28568e.onTransportCompleted(i10, i11);
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.f
        public void a(String str, long j10, int i10) {
            i.this.f28574k.put(Integer.valueOf(i10), Long.valueOf(j10));
            i.this.f28568e.onRequest(this.f28581a, i10);
        }
    }

    public void a(d dVar) {
        ICDFLog.i("ICDF.OafCommonChannelTransport", "setBytesListenerFrwk " + dVar);
        this.f28570g = dVar;
    }

    public synchronized void a(com.oplus.ocs.icdf.commonchannel.c cVar) {
        ICDFLog.i("ICDF.OafCommonChannelTransport", "setPreferedChannel " + cVar);
        if (cVar == null) {
            this.f28572i = null;
            return;
        }
        if (this.f28575l) {
            cVar.close();
            return;
        }
        this.f28572i = cVar;
        cVar.setTcpIpTos(this.f28578o);
        this.f28572i.setP2pPowerSave(this.f28577n);
        if (this.f28576m) {
            this.f28572i.setTcpNoDelay(true);
        }
        CommonChannel.BytesListener bytesListener = this.f28569f;
        if (bytesListener != null) {
            this.f28572i.setBytesListener(bytesListener);
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public int sendStream(FileDescriptor fileDescriptor) {
        int a10 = this.f28564a.a(((com.oplus.ocs.icdf.model.a) getPeerAgent()).a(), fileDescriptor);
        ICDFLog.d("ICDF.OafCommonChannelTransport", "streamTransaction id = " + a10);
        return a10;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void sendBytes(int i10, byte[] bArr, boolean z10) {
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar != null) {
            cVar.sendBytes(bArr, z10);
            return;
        }
        if (this.f28566c != null) {
            ICDFLog.v("ICDF.OafCommonChannelTransport", "sendBytes to " + this.f28567d + ", length " + bArr.length);
            if (i10 == -1) {
                i10 = this.f28571h;
            }
            try {
                if (z10) {
                    this.f28566c.secureSend(i10, bArr);
                } else {
                    this.f28566c.send(i10, bArr);
                }
                return;
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            }
        }
        ICDFLog.e("ICDF.OafCommonChannelTransport", "send Bytes through OAF failed. ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        ArrayList arrayList;
        String agentId = getPeerAgent().getAgentId();
        synchronized (this) {
            try {
                if (this.f28575l) {
                    ICDFLog.i("ICDF.OafCommonChannelTransport", "already closed, peerAgent " + agentId);
                    return;
                }
                this.f28575l = true;
                ICDFLog.i("ICDF.OafCommonChannelTransport", "close, peerAgent " + agentId + ", notify listeners " + this.f28573j.size());
                if (this.f28573j.size() > 0) {
                    arrayList = new ArrayList(this.f28573j);
                    this.f28573j.clear();
                } else {
                    arrayList = null;
                }
                com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
                if (cVar != null) {
                    cVar.close();
                    this.f28572i = null;
                }
                this.f28566c.close();
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((CommonChannel.ChannelListener) it.next()).onClosed(i10);
                    }
                }
                this.f28565b.a((com.oplus.ocs.icdf.model.a) getPeerAgent());
                this.f28564a.b(agentId);
                ICDFLog.d("ICDF.OafCommonChannelTransport", "close finished, peerAgent " + agentId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(byte[] bArr, boolean z10) {
        OAFConnectionSocket oAFConnectionSocket = this.f28566c;
        if (oAFConnectionSocket != null) {
            try {
                if (z10) {
                    oAFConnectionSocket.secureSend(this.f28571h, bArr);
                } else {
                    oAFConnectionSocket.send(this.f28571h, bArr);
                }
                return;
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            }
        }
        ICDFLog.e("ICDF.OafCommonChannelTransport", "send Bytes through OAF failed. ");
    }

    @Override // com.oplus.ocs.icdf.commonchannel.c
    public void a(byte[] bArr) {
        com.oplus.ocs.icdf.commonchannel.c cVar = this.f28572i;
        if (cVar == null) {
            ICDFLog.e("ICDF.OafCommonChannelTransport", "efficientSendBytes failed.");
        } else {
            cVar.a(bArr);
        }
    }
}
