package com.oplus.ocs.icdf.commonchannel.oaf.inner;

import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.bean.PeerAgent;
import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.utils.CommonUtil;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class OAFConnectionSocket extends BaseSocket {

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f28583a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f28584b;

    /* renamed from: c, reason: collision with root package name */
    private i.e f28585c;

    /* renamed from: d, reason: collision with root package name */
    private ScheduledFuture<?> f28586d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OAFConnectionSocket.this.close();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(PeerAgent peerAgent, int i10);
    }

    public OAFConnectionSocket() {
        super(OAFConnectionSocket.class.getName());
        this.f28583a = new ArrayList();
        this.f28584b = new Object();
    }

    public void a(i.e eVar) {
        this.f28585c = eVar;
    }

    @Override // com.heytap.accessory.BaseSocket
    public void onError(int i10, String str, int i11) {
        ICDFLog.e("ICDF.OAFConnectionSocket", "connection " + getConnectionId() + " error: " + i11);
    }

    @Override // com.heytap.accessory.BaseSocket
    public void onReceive(long j10, int i10, byte[] bArr) {
        i.e eVar = this.f28585c;
        if (eVar != null) {
            eVar.a(bArr);
        }
    }

    @Override // com.heytap.accessory.BaseSocket
    public void onServiceConnectionLost(long j10, int i10) {
        ICDFLog.w("ICDF.OAFConnectionSocket", "connection " + j10 + " losted, reason " + i10);
        synchronized (this.f28584b) {
            try {
                ScheduledFuture<?> scheduledFuture = this.f28586d;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    this.f28586d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator<b> it = this.f28583a.iterator();
        while (it.hasNext()) {
            it.next().a(getConnectedPeerAgent(), i10);
        }
        ICDFLog.d("ICDF.OAFConnectionSocket", "connection " + j10 + " losted, notification finished");
    }

    public void a(int i10) {
        if (!isConnected()) {
            ICDFLog.d("ICDF.OAFConnectionSocket", "oaf socket already closed");
            return;
        }
        synchronized (this.f28584b) {
            ICDFLog.d("ICDF.OAFConnectionSocket", "close oaf socket after " + i10 + "ms");
            this.f28586d = CommonUtil.DEFAULT_SCHEDULE_EXECUTOR.schedule(new a(), (long) i10, TimeUnit.MILLISECONDS);
        }
    }

    public void a(b bVar) {
        if (bVar == null) {
            ICDFLog.e("ICDF.OAFConnectionSocket", "setConnectionEventCb failed listener is null");
        } else {
            this.f28583a.add(bVar);
        }
    }
}
