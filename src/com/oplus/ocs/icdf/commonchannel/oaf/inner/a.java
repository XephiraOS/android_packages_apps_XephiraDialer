package com.oplus.ocs.icdf.commonchannel.oaf.inner;

import android.util.ArrayMap;
import com.android.incallui.Log;
import com.heytap.accessory.BaseAgent;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.stream.StreamTransfer;
import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private StreamTransfer f28588a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f28589b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, i.f> f28590c = new ArrayMap();

    /* renamed from: com.oplus.ocs.icdf.commonchannel.oaf.inner.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0268a implements StreamTransfer.EventListener {
        public C0268a() {
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onCancelAllCompleted(int i10, int i11) {
            ICDFLog.d("ICDF.OAFStreamSocket", "onCancelAllCompleted, transId: " + i10 + ", errCode: " + i11);
            i.f a10 = a.this.a(i10);
            if (a10 != null) {
                a10.onTransportCanceled(i10, i11);
            } else if (i11 == 0) {
                ICDFLog.i("ICDF.OAFStreamSocket", "onCancelAllCompleted, transId: " + i10);
            } else {
                ICDFLog.e("ICDF.OAFStreamSocket", "stream trans cancel all error, transId: " + i10 + ", err: " + i11);
            }
            a.this.b(i10);
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onStreamReceived(long j10, int i10, InputStream inputStream) {
            ICDFLog.i("ICDF.OAFStreamSocket", "onStreamReceived, transId: " + i10);
            i.f a10 = a.this.a(i10);
            if (a10 != null) {
                a10.a(inputStream);
            }
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onTransferCompleted(long j10, int i10, int i11) {
            ICDFLog.i("ICDF.OAFStreamSocket", "onTransferCompleted, transaction id: " + i10 + ", err: " + i11);
            i.f a10 = a.this.a(i10);
            if (a10 != null) {
                a10.onTransportCompleted(i10, i11);
            }
            a.this.b(i10);
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onTransferRequested(long j10, int i10, int i11) {
            String num = Integer.toString(i10);
            ICDFLog.i("ICDF.OAFStreamSocket", "onTransferRequested, peerAgent: " + num + ", transId: " + i11);
            a.this.a(i11, num);
            i.f a10 = a.this.a(num);
            if (a10 != null) {
                a10.a(Integer.toString(i10), j10, i11);
            }
        }
    }

    public a(BaseAgent baseAgent) {
        C0268a c0268a = new C0268a();
        ICDFLog.i("ICDF.OAFStreamSocket", "OAFStreamSocket, localAgent: " + baseAgent.getServiceProfileName() + Log.TAG_DELIMETER + baseAgent.getServiceProfileId());
        try {
            this.f28588a = new StreamTransfer(baseAgent, c0268a);
        } catch (SdkUnsupportedException e10) {
            ICDFLog.e("ICDF.OAFStreamSocket", "new oaf streamTransfer exception: " + e10);
            throw new IllegalArgumentException("new StreamTransfer failed");
        }
    }

    public i.f a(int i10) {
        synchronized (this.f28590c) {
            try {
                String str = this.f28589b.get(Integer.valueOf(i10));
                if (str == null) {
                    return null;
                }
                return this.f28590c.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(int i10) {
        synchronized (this.f28590c) {
            this.f28589b.remove(Integer.valueOf(i10));
        }
    }

    public void c(long j10, int i10) {
        this.f28588a.reject(j10, i10);
    }

    public void b() {
        if (this.f28588a != null) {
            ICDFLog.i("ICDF.OAFStreamSocket", "close");
            this.f28588a.close();
            this.f28588a = null;
        }
    }

    public i.f a(String str) {
        i.f fVar;
        synchronized (this.f28590c) {
            fVar = this.f28590c.get(str);
        }
        return fVar;
    }

    public void b(String str) {
        if (str == null) {
            ICDFLog.e("ICDF.OAFStreamSocket", "stop, invalid args");
            return;
        }
        ICDFLog.i("ICDF.OAFStreamSocket", "stop, peerAgentId " + str);
        synchronized (this.f28590c) {
            this.f28590c.remove(str);
        }
    }

    public a(BaseJobAgent baseJobAgent) {
        C0268a c0268a = new C0268a();
        ICDFLog.i("ICDF.OAFStreamSocket", "OAFStreamSocket, localAgent: " + baseJobAgent.getServiceProfileName() + Log.TAG_DELIMETER + baseJobAgent.getServiceProfileId());
        try {
            this.f28588a = new StreamTransfer(baseJobAgent, c0268a);
        } catch (SdkUnsupportedException e10) {
            ICDFLog.e("ICDF.OAFStreamSocket", "new oaf streamTransfer exception: " + e10);
            throw new IllegalArgumentException("new StreamTransfer failed");
        }
    }

    public void a(int i10, String str) {
        synchronized (this.f28590c) {
            this.f28589b.put(Integer.valueOf(i10), str);
        }
    }

    public void a(String str, i.f fVar) {
        synchronized (this.f28590c) {
            this.f28590c.put(str, fVar);
        }
    }

    public void b(long j10, int i10) {
        this.f28588a.receive(j10, i10);
    }

    public int a(PeerAgent peerAgent, InputStream inputStream) {
        int send = this.f28588a.send(peerAgent, inputStream, 64888);
        String agentId = peerAgent.getAgentId();
        synchronized (this.f28590c) {
            this.f28589b.put(Integer.valueOf(send), agentId);
        }
        return send;
    }

    public int a(PeerAgent peerAgent, FileDescriptor fileDescriptor) {
        return this.f28588a.send(peerAgent, fileDescriptor, 64888);
    }

    public void a(long j10, int i10) {
        this.f28588a.cancel(j10, i10);
    }

    public void a() {
        this.f28588a.cancelAll();
    }
}
