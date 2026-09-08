package com.oplus.ocs.icdf.commonchannel.netty;

import a8.C0425a;
import android.app.ActivityManager;
import android.content.Context;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.TrafficClass;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class a extends com.oplus.ocs.icdf.commonchannel.c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f28457a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f28458b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28459c;

    /* renamed from: d, reason: collision with root package name */
    private final List<CommonChannel.ChannelListener> f28460d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f28461e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f28462f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f28463g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f28464h;

    /* renamed from: i, reason: collision with root package name */
    private d f28465i;

    /* renamed from: j, reason: collision with root package name */
    private b f28466j;

    /* renamed from: k, reason: collision with root package name */
    private Thread f28467k;

    /* renamed from: l, reason: collision with root package name */
    private CommonChannel.BytesListener f28468l;

    /* renamed from: m, reason: collision with root package name */
    private C0425a f28469m;

    /* renamed from: n, reason: collision with root package name */
    private int f28470n;

    /* renamed from: o, reason: collision with root package name */
    private int f28471o;

    /* renamed from: p, reason: collision with root package name */
    private int f28472p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f28473q;

    /* renamed from: r, reason: collision with root package name */
    private byte[] f28474r;

    /* renamed from: s, reason: collision with root package name */
    private final byte[] f28475s;

    /* renamed from: com.oplus.ocs.icdf.commonchannel.netty.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0266a implements Runnable {
        public RunnableC0266a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
        
            com.oplus.ocs.icdf.utils.logging.ICDFLog.i("ICDF.CommonChannelTransport", "ReceiveThread exit, peerAgent " + r4.f28476a.getPeerAgent().getAgentId());
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r4 = this;
                com.oplus.ocs.icdf.commonchannel.netty.a r0 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                com.oplus.ocs.icdf.commonchannel.netty.d r0 = com.oplus.ocs.icdf.commonchannel.netty.a.a(r0)
                if (r0 == 0) goto Lc6
                r0 = 307200(0x4b000, float:4.30479E-40)
                byte[] r0 = new byte[r0]
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "ReceiveThread start, peerAgent "
                r1.append(r2)
                com.oplus.ocs.icdf.commonchannel.netty.a r2 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                com.oplus.ocs.icdf.model.PeerAgent r2 = r2.getPeerAgent()
                java.lang.String r2 = r2.getAgentId()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "ICDF.CommonChannelTransport"
                com.oplus.ocs.icdf.utils.logging.ICDFLog.i(r2, r1)
                com.oplus.ocs.icdf.commonchannel.netty.a r1 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                java.lang.Object r1 = com.oplus.ocs.icdf.commonchannel.netty.a.b(r1)
                monitor-enter(r1)
            L34:
                com.oplus.ocs.icdf.commonchannel.netty.a r2 = com.oplus.ocs.icdf.commonchannel.netty.a.this     // Catch: java.lang.Throwable -> L54
                boolean r2 = com.oplus.ocs.icdf.commonchannel.netty.a.c(r2)     // Catch: java.lang.Throwable -> L54
                if (r2 != 0) goto L5b
                java.lang.String r2 = "ICDF.CommonChannelTransport"
                java.lang.String r3 = "ReceiveThread wait, BytesListener is null"
                com.oplus.ocs.icdf.utils.logging.ICDFLog.d(r2, r3)     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
                com.oplus.ocs.icdf.commonchannel.netty.a r2 = com.oplus.ocs.icdf.commonchannel.netty.a.this     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
                java.lang.Object r2 = com.oplus.ocs.icdf.commonchannel.netty.a.b(r2)     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
                r2.wait()     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
                java.lang.String r2 = "ICDF.CommonChannelTransport"
                java.lang.String r3 = "ReceiveThread wake up"
                com.oplus.ocs.icdf.utils.logging.ICDFLog.d(r2, r3)     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
                goto L34
            L54:
                r4 = move-exception
                goto Lc4
            L56:
                r2 = move-exception
                r2.printStackTrace()     // Catch: java.lang.Throwable -> L54
                goto L34
            L5b:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L54
            L5c:
                com.oplus.ocs.icdf.commonchannel.netty.a r1 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                com.oplus.ocs.icdf.commonchannel.netty.d r1 = com.oplus.ocs.icdf.commonchannel.netty.a.a(r1)
                if (r1 == 0) goto Lc6
                com.oplus.ocs.icdf.commonchannel.netty.a r1 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                com.oplus.ocs.icdf.commonchannel.netty.d r1 = com.oplus.ocs.icdf.commonchannel.netty.a.a(r1)
                boolean r1 = r1.b()
                if (r1 == 0) goto Lc6
                com.oplus.ocs.icdf.commonchannel.netty.a r1 = com.oplus.ocs.icdf.commonchannel.netty.a.this     // Catch: java.io.IOException -> La3
                com.oplus.ocs.icdf.commonchannel.netty.d r1 = com.oplus.ocs.icdf.commonchannel.netty.a.a(r1)     // Catch: java.io.IOException -> La3
                int r1 = r1.a(r0)     // Catch: java.io.IOException -> La3
                if (r1 > 0) goto L9d
                java.lang.String r0 = "ICDF.CommonChannelTransport"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La3
                r1.<init>()     // Catch: java.io.IOException -> La3
                java.lang.String r2 = "ReceiveThread exit, peerAgent "
                r1.append(r2)     // Catch: java.io.IOException -> La3
                com.oplus.ocs.icdf.commonchannel.netty.a r2 = com.oplus.ocs.icdf.commonchannel.netty.a.this     // Catch: java.io.IOException -> La3
                com.oplus.ocs.icdf.model.PeerAgent r2 = r2.getPeerAgent()     // Catch: java.io.IOException -> La3
                java.lang.String r2 = r2.getAgentId()     // Catch: java.io.IOException -> La3
                r1.append(r2)     // Catch: java.io.IOException -> La3
                java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> La3
                com.oplus.ocs.icdf.utils.logging.ICDFLog.i(r0, r1)     // Catch: java.io.IOException -> La3
                goto Lc6
            L9d:
                com.oplus.ocs.icdf.commonchannel.netty.a r2 = com.oplus.ocs.icdf.commonchannel.netty.a.this     // Catch: java.io.IOException -> La3
                com.oplus.ocs.icdf.commonchannel.netty.a.a(r2, r0, r1)     // Catch: java.io.IOException -> La3
                goto L5c
            La3:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "ReceiveThread exit caused by socket exception, peerAgent "
                r0.append(r1)
                com.oplus.ocs.icdf.commonchannel.netty.a r1 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                com.oplus.ocs.icdf.model.PeerAgent r1 = r1.getPeerAgent()
                java.lang.String r1 = r1.getAgentId()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "ICDF.CommonChannelTransport"
                com.oplus.ocs.icdf.utils.logging.ICDFLog.w(r1, r0)
                goto Lc6
            Lc4:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L54
                throw r4
            Lc6:
                com.oplus.ocs.icdf.commonchannel.netty.a r4 = com.oplus.ocs.icdf.commonchannel.netty.a.this
                r4.close()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.ocs.icdf.commonchannel.netty.a.RunnableC0266a.run():void");
        }
    }

    public a(Context context, PeerAgent peerAgent, d dVar) {
        super(peerAgent);
        this.f28457a = new Object();
        this.f28460d = new ArrayList();
        this.f28461e = false;
        this.f28462f = false;
        this.f28463g = true;
        this.f28464h = false;
        this.f28469m = null;
        this.f28470n = 0;
        this.f28471o = 0;
        this.f28472p = 0;
        this.f28473q = false;
        this.f28474r = null;
        this.f28475s = new byte[4];
        ICDFLog.i("ICDF.CommonChannelTransport", "CommonChannelTransport construct, peerAgent " + getPeerAgent().getAgentId());
        this.f28465i = dVar;
        this.f28458b = context;
        this.f28459c = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        this.f28466j = new b();
        Thread thread = new Thread(this.f28466j);
        this.f28467k = thread;
        thread.start();
        this.f28462f = true;
        new Thread(new RunnableC0266a()).start();
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void close() {
        synchronized (this) {
            try {
                if (this.f28464h) {
                    return;
                }
                this.f28464h = true;
                ICDFLog.i("ICDF.CommonChannelTransport", "close, peerAgent " + getPeerAgent().getAgentId());
                if (!this.f28463g) {
                    this.f28463g = true;
                    com.oplus.ocs.icdf.utils.a.a(this.f28458b).a(true);
                }
                b bVar = this.f28466j;
                if (bVar != null) {
                    bVar.a();
                    this.f28466j = null;
                }
                Thread thread = this.f28467k;
                if (thread != null) {
                    thread.interrupt();
                    this.f28467k = null;
                }
                try {
                    d dVar = this.f28465i;
                    if (dVar != null) {
                        dVar.a();
                        this.f28465i = null;
                    }
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
                Iterator<CommonChannel.ChannelListener> it = this.f28460d.iterator();
                while (it.hasNext()) {
                    it.next().onClosed(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public int getProtocol() {
        return 1;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public synchronized boolean isClosed() {
        return this.f28464h;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void sendBytes(byte[] bArr, boolean z10) {
        if (!this.f28462f) {
            ICDFLog.e("ICDF.CommonChannelTransport", "sendBytes failed, channel closed. ");
            return;
        }
        if (bArr.length > 4194304) {
            ICDFLog.e("ICDF.CommonChannelTransport", "sendBytes failed, data length too large, allowed max length 4194304");
            throw new IllegalArgumentException("data length too large");
        }
        if (z10) {
            C0425a c0425a = this.f28469m;
            if (c0425a != null) {
                bArr = c0425a.e(bArr);
            } else {
                ICDFLog.e("ICDF.CommonChannelTransport", "No security unit found!");
                bArr = null;
            }
        }
        if (bArr == null) {
            ICDFLog.e("ICDF.CommonChannelTransport", "sendBytes failed, encrypt data failed");
            return;
        }
        byte[] a10 = a(bArr.length);
        byte[] bArr2 = new byte[bArr.length + 4];
        System.arraycopy(a10, 0, bArr2, 0, a10.length);
        bArr2[a10.length] = (byte) (z10 ? 128 : 0);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        this.f28466j.a(bArr2);
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setBytesListener(CommonChannel.BytesListener bytesListener) {
        if (bytesListener == null) {
            ICDFLog.e("ICDF.CommonChannelTransport", "setBytesListener failed, listener is null.");
            return;
        }
        this.f28468l = bytesListener;
        synchronized (this.f28457a) {
            this.f28461e = true;
            this.f28457a.notifyAll();
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setChannelListener(CommonChannel.ChannelListener channelListener) {
        if (channelListener == null) {
            ICDFLog.e("ICDF.CommonChannelTransport", "setChannelListener failed, listener is null.");
            return;
        }
        synchronized (this) {
            try {
                if (this.f28464h) {
                    ICDFLog.w("ICDF.CommonChannelTransport", "setChannelListener failed, channel already closed.");
                    channelListener.onClosed(1);
                } else {
                    this.f28460d.add(channelListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public synchronized void setP2pPowerSave(boolean z10) {
        ICDFLog.v("ICDF.CommonChannelTransport", "setP2pPowerSave " + z10 + "/" + this.f28463g + ", peerAgent " + getPeerAgent().getAgentId());
        if (this.f28463g != z10) {
            this.f28463g = z10;
            com.oplus.ocs.icdf.utils.a.a(this.f28458b).a(z10);
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setTcpIpTos(TrafficClass trafficClass) {
        d dVar = this.f28465i;
        if (dVar == null) {
            ICDFLog.w("ICDF.CommonChannelTransport", "setTcpIpTos failed, transport closed");
        } else {
            dVar.a(trafficClass.getValue());
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void setTcpNoDelay(boolean z10) {
        d dVar = this.f28465i;
        if (dVar == null) {
            ICDFLog.w("ICDF.CommonChannelTransport", "setTcpNoDelay failed, transport closed");
        } else {
            dVar.a(z10);
        }
    }

    public static void a(a aVar, byte[] bArr, int i10) {
        aVar.getClass();
        int i11 = 0;
        while (i10 > 0) {
            int i12 = aVar.f28470n;
            if (i10 + i12 + aVar.f28471o <= 4) {
                System.arraycopy(bArr, i11, aVar.f28475s, i12, i10);
                aVar.f28470n += i10;
                return;
            }
            if (i12 < 4) {
                System.arraycopy(bArr, i11, aVar.f28475s, i12, 4 - i12);
                int i13 = 4 - aVar.f28470n;
                i11 += i13;
                i10 -= i13;
                aVar.f28470n = 4;
            }
            if (aVar.f28470n == 4 && aVar.f28471o == 0) {
                byte[] bArr2 = aVar.f28475s;
                int i14 = 0;
                for (int i15 = 0; i15 < 3; i15++) {
                    i14 += (bArr2[i15] & 255) << ((2 - i15) * 8);
                }
                aVar.f28472p = i14;
                aVar.f28473q = ((aVar.f28475s[3] & FastPairConstants.GO_INTENT_NOT_SET) >> 7) == 1;
                aVar.f28474r = new byte[i14];
            }
            int i16 = aVar.f28471o;
            int i17 = i10 + i16;
            int i18 = aVar.f28472p;
            if (i17 >= i18) {
                System.arraycopy(bArr, i11, aVar.f28474r, i16, i18 - i16);
                int i19 = aVar.f28472p - aVar.f28471o;
                i10 -= i19;
                i11 += i19;
                aVar.f28471o = 0;
                aVar.f28470n = 0;
                byte[] bArr3 = aVar.f28474r;
                if (aVar.f28473q) {
                    C0425a c0425a = aVar.f28469m;
                    if (c0425a != null) {
                        bArr3 = c0425a.b(bArr3);
                    } else {
                        ICDFLog.e("ICDF.CommonChannelTransport", "No security unit found!");
                        bArr3 = null;
                    }
                }
                if (bArr3 == null) {
                    ICDFLog.e("ICDF.CommonChannelTransport", "decrypt data failed");
                } else {
                    aVar.f28468l.onBytesReceived(bArr3);
                }
            } else {
                System.arraycopy(bArr, i11, aVar.f28474r, i16, i10);
                aVar.f28471o += i10;
                return;
            }
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel
    public void sendBytes(int i10, byte[] bArr, boolean z10) {
        sendBytes(bArr, z10);
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f28477a;

        /* renamed from: b, reason: collision with root package name */
        private final long f28478b;

        /* renamed from: c, reason: collision with root package name */
        private final Object f28479c;

        /* renamed from: d, reason: collision with root package name */
        private final BlockingQueue<byte[]> f28480d;

        /* renamed from: e, reason: collision with root package name */
        private volatile long f28481e;

        /* renamed from: f, reason: collision with root package name */
        private volatile boolean f28482f;

        public b() {
            long j10 = (a.this.f28459c * 4) / 5;
            this.f28477a = j10;
            this.f28478b = j10 / 2;
            this.f28479c = new Object();
            this.f28480d = new LinkedBlockingQueue(256);
            this.f28481e = 0L;
            this.f28482f = false;
        }

        public int a(byte[] bArr) {
            long j10 = (Runtime.getRuntime().totalMemory() / 1024) / 1024;
            for (int i10 = 0; i10 < 3 && j10 >= this.f28477a; i10++) {
                synchronized (this.f28479c) {
                    try {
                        try {
                            ICDFLog.d("ICDF.CommonChannelTransport", "SendThread.write() wait: curMem = " + j10 + ", curLen = " + this.f28481e + ", blockNum = " + i10);
                            this.f28482f = true;
                            if (this.f28481e < 52428800) {
                                this.f28479c.wait(1000L);
                            } else {
                                this.f28479c.wait((((this.f28481e / 50) / 1024) / 1024) * 1000);
                            }
                            this.f28482f = false;
                            ICDFLog.d("ICDF.CommonChannelTransport", "sendThread.write() wake up: curLen = " + this.f28481e);
                        } catch (InterruptedException e10) {
                            ICDFLog.e("ICDF.CommonChannelTransport", "SendThread.write() wait exception: " + e10);
                            e10.printStackTrace();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                System.gc();
                System.runFinalization();
                j10 = (Runtime.getRuntime().totalMemory() / 1024) / 1024;
                ICDFLog.d("ICDF.CommonChannelTransport", "Explicitly run GC, curMEM = " + j10 + "M");
            }
            try {
                this.f28480d.put(bArr);
                synchronized (this.f28479c) {
                    this.f28481e += bArr.length;
                }
                return bArr.length;
            } catch (InterruptedException e11) {
                ICDFLog.e("ICDF.CommonChannelTransport", "Write failed.", e11);
                return 0;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ICDFLog.i("ICDF.CommonChannelTransport", "SendThread start, peerAgent " + a.this.getPeerAgent().getAgentId());
            while (a.this.f28462f) {
                try {
                    byte[] take = this.f28480d.take();
                    a.a(a.this, take);
                    int length = take.length;
                    synchronized (this.f28479c) {
                        try {
                            this.f28481e -= length;
                            if (this.f28482f) {
                                if ((Runtime.getRuntime().totalMemory() / 1024) / 1024 > this.f28478b) {
                                    if (this.f28480d.size() == 0) {
                                    }
                                }
                                this.f28479c.notifyAll();
                            }
                        } catch (Throwable th) {
                            throw th;
                            break;
                        }
                    }
                } catch (InterruptedException unused) {
                    ICDFLog.e("ICDF.CommonChannelTransport", "SendThread interrupted.");
                }
            }
            ICDFLog.i("ICDF.CommonChannelTransport", "SendThread exit, peerAgent " + a.this.getPeerAgent().getAgentId());
        }

        public void a() {
            a.this.f28462f = false;
            this.f28480d.clear();
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.c
    public void a(byte[] bArr) {
        if (!this.f28462f) {
            ICDFLog.e("ICDF.CommonChannelTransport", "sendBytes failed, channel closed. ");
            return;
        }
        if (bArr.length <= 4194308 && bArr.length > 4) {
            byte[] a10 = a(bArr.length - 4);
            System.arraycopy(a10, 0, bArr, 0, a10.length);
            bArr[a10.length] = 0;
            this.f28466j.a(bArr);
            return;
        }
        ICDFLog.e("ICDF.CommonChannelTransport", "sendBytes failed, illegal data length");
        throw new IllegalArgumentException("illegal data length");
    }

    public void a(C0425a c0425a) {
        this.f28469m = c0425a;
    }

    public static int a(a aVar, byte[] bArr) {
        d dVar = aVar.f28465i;
        if (dVar == null) {
            ICDFLog.w("ICDF.CommonChannelTransport", "writes failed, transport closed");
            return 0;
        }
        try {
            return dVar.b(bArr);
        } catch (IOException e10) {
            ICDFLog.e("ICDF.CommonChannelTransport", " writes error!!!");
            e10.printStackTrace();
            aVar.close();
            return 0;
        }
    }

    private byte[] a(int i10) {
        return new byte[]{(byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }
}
