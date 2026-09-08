package com.oplus.ocs.icdf.grpcchannel.inner;

import android.os.ParcelFileDescriptor;
import android.util.ArrayMap;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.c;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, p> f28741a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f28742b;

    /* renamed from: c, reason: collision with root package name */
    private final a f28743c;

    /* renamed from: d, reason: collision with root package name */
    private final PeerAgent f28744d;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final o f28745a = new o();

        /* renamed from: b, reason: collision with root package name */
        private final CommonChannel f28746b;

        /* renamed from: com.oplus.ocs.icdf.grpcchannel.inner.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0274a implements CommonChannel.BytesListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f28748a;

            public C0274a(c cVar) {
                this.f28748a = cVar;
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.BytesListener
            public void onBytesReceived(byte[] bArr) {
                if (a.this.f28746b.getProtocol() == 1) {
                    this.f28748a.a(bArr, 8);
                    return;
                }
                byte[] a10 = a.this.f28745a.a(bArr);
                if (a10 != null) {
                    this.f28748a.a(a10, 8);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements CommonChannel.ChannelListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f28750a;

            public b(a aVar, c cVar) {
                this.f28750a = cVar;
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
            public void onClosed(int i10) {
                ICDFLog.i("ICDF.BytesTransfer", "onClosed, reason " + i10);
                this.f28750a.a(i10);
            }
        }

        public a(CommonChannel commonChannel) {
            this.f28746b = commonChannel;
        }

        public void a(c cVar) {
            this.f28746b.setBytesListener(new C0274a(cVar));
            this.f28746b.setChannelListener(new b(this, cVar));
            ICDFLog.d("ICDF.BytesTransfer", "start " + q.this.f28744d.getAgentId());
        }

        public void a() {
            ICDFLog.d("ICDF.BytesTransfer", "stop " + q.this.f28744d.getAgentId());
            this.f28746b.close();
        }

        public static boolean a(a aVar, int i10, h hVar, boolean z10) {
            if (aVar.f28746b.getProtocol() != 1) {
                byte[] a10 = hVar.a(false);
                if (a10.length <= 64888) {
                    try {
                        aVar.f28746b.sendBytes(i10, a10, z10);
                    } catch (UnSupportException e10) {
                        e10.printStackTrace();
                    }
                } else {
                    int length = a10.length;
                    int i11 = 0;
                    do {
                        int i12 = length >= 64888 ? 64888 : length;
                        byte[] bArr = new byte[i12];
                        System.arraycopy(a10, i11, bArr, 0, i12);
                        i11 += i12;
                        length -= i12;
                        try {
                            aVar.f28746b.sendBytes(i10, bArr, z10);
                        } catch (UnSupportException e11) {
                            e11.printStackTrace();
                        }
                    } while (length != 0);
                }
            } else if (z10) {
                aVar.f28746b.sendBytes(hVar.a(false), z10);
            } else {
                ((com.oplus.ocs.icdf.commonchannel.c) aVar.f28746b).a(hVar.a(true));
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i10);

        void a(byte[] bArr, int i10);
    }

    public q(CommonChannel commonChannel) {
        this.f28742b = new b(commonChannel);
        this.f28743c = new a(commonChannel);
        this.f28744d = commonChannel.getPeerAgent();
    }

    public PeerAgent a() {
        return this.f28744d;
    }

    public void b() {
        ICDFLog.d("ICDF.TransportAdapter", "stop " + this.f28744d.getAgentId());
        this.f28743c.a();
        this.f28742b.a();
    }

    public void a(c cVar) {
        if (cVar == null) {
            ICDFLog.e("ICDF.TransportAdapter", "start failed, listener is null");
            return;
        }
        this.f28743c.a(cVar);
        this.f28742b.a(cVar);
        ICDFLog.d("ICDF.TransportAdapter", "start " + this.f28744d.getAgentId());
    }

    public boolean a(h hVar) {
        int i10;
        int i11;
        boolean z10;
        p pVar = this.f28741a.get(hVar.a());
        if (pVar != null) {
            i11 = pVar.f28737b;
            i10 = pVar.f28738c;
            z10 = pVar.f28740e;
        } else {
            i10 = -1;
            i11 = 1;
            z10 = false;
        }
        if (i11 == 2) {
            return this.f28742b.a(hVar.c(), hVar.a(false), hVar.b());
        }
        a.a(this.f28743c, i10, hVar, z10);
        return true;
    }

    public void a(int i10) {
        this.f28742b.a(i10);
    }

    public void a(byte[] bArr, int i10) {
        ICDFLog.i("ICDF.TransportAdapter", "sync rpc method configs from consumer");
        c.a aVar = new c.a(i10);
        int d10 = com.oplus.ocs.icdf.grpcchannel.inner.c.d(bArr, aVar);
        if (d10 <= 0) {
            ICDFLog.e("ICDF.TransportAdapter", "invalid rpc method number");
            return;
        }
        for (int i11 = 0; i11 < d10; i11++) {
            byte[] c10 = com.oplus.ocs.icdf.grpcchannel.inner.c.c(bArr, aVar);
            if (c10 == null) {
                ICDFLog.e("ICDF.TransportAdapter", "invalid rpc name");
                return;
            }
            String str = new String(c10, StandardCharsets.UTF_8);
            short e10 = com.oplus.ocs.icdf.grpcchannel.inner.c.e(bArr, aVar);
            if (e10 == -1) {
                ICDFLog.e("ICDF.TransportAdapter", "invalid rpc type");
                return;
            }
            short e11 = com.oplus.ocs.icdf.grpcchannel.inner.c.e(bArr, aVar);
            if (e11 == -1) {
                ICDFLog.e("ICDF.TransportAdapter", "invalid rpc channel");
                return;
            }
            int d11 = com.oplus.ocs.icdf.grpcchannel.inner.c.d(bArr, aVar);
            if (d11 == -1) {
                ICDFLog.e("ICDF.TransportAdapter", "invalid rpc optMask");
                return;
            }
            boolean z10 = (d11 & 1) != 0;
            boolean z11 = (d11 & 2) != 0;
            if (com.oplus.ocs.icdf.grpcchannel.inner.c.d(bArr, aVar) == -1) {
                ICDFLog.e("ICDF.TransportAdapter", "invalid rpc reserved");
                return;
            }
            boolean z12 = z11;
            this.f28741a.put(str, new p(str, e10, e11, z10, z12));
            ICDFLog.i("ICDF.TransportAdapter", "cfg rpc method " + str + ",type " + ((int) e10) + ",channelId " + ((int) e11) + ",compress " + z10 + ",encrypt " + z12);
        }
    }

    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: c, reason: collision with root package name */
        private final CommonChannel f28753c;

        /* renamed from: d, reason: collision with root package name */
        private final String f28754d;

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, d> f28751a = new ArrayMap();

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f28752b = new AtomicInteger(0);

        /* renamed from: e, reason: collision with root package name */
        private boolean f28755e = false;

        /* loaded from: classes3.dex */
        public class a implements CommonChannel.StreamListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f28757a;

            /* renamed from: com.oplus.ocs.icdf.grpcchannel.inner.q$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0275a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ InputStream f28759a;

                public RunnableC0275a(InputStream inputStream) {
                    this.f28759a = inputStream;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    b.a(b.this, this.f28759a, aVar.f28757a);
                }
            }

            public a(c cVar) {
                this.f28757a = cVar;
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.StreamListener
            public void onRequest(PeerAgent peerAgent, int i10) {
                String agentId = peerAgent.getAgentId();
                ICDFLog.i("ICDF.StreamTransfer", "onTransferRequested, peerAgent: " + agentId + ", transId: " + i10);
                if (q.this.f28742b == null) {
                    ICDFLog.e("ICDF.StreamTransfer", "streamTransfer obj is null, ignore");
                } else if (agentId != null && agentId.equals(b.this.f28754d)) {
                    b.this.f28753c.receiveStream(i10);
                } else {
                    ICDFLog.e("ICDF.StreamTransfer", "nobody listening socket event, reject transfer request");
                    b.this.f28753c.rejectStream(i10);
                }
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.StreamListener
            public void onStreamReceived(InputStream inputStream) {
                new Thread(new RunnableC0275a(inputStream)).start();
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.StreamListener
            public void onTransportCanceled(int i10, int i11) {
                if (i11 == 0) {
                    ICDFLog.i("ICDF.StreamTransfer", "onCancelAllCompleted, transId: " + i10);
                } else {
                    ICDFLog.e("ICDF.StreamTransfer", "stream trans cancel all error, transId: " + i10 + ", err: " + i11);
                }
                b.a(b.this, i10);
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.StreamListener
            public void onTransportCompleted(int i10, int i11) {
                if (i11 == 0) {
                    ICDFLog.i("ICDF.StreamTransfer", "onTransferCompleted, transaction id: " + i10);
                } else {
                    ICDFLog.e("ICDF.StreamTransfer", "stream trans error, transaction id: " + i10 + ", err: " + i11);
                }
                b.a(b.this, i10);
            }
        }

        /* renamed from: com.oplus.ocs.icdf.grpcchannel.inner.q$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0276b implements CommonChannel.ChannelListener {
            public C0276b() {
            }

            @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
            public void onClosed(int i10) {
                ICDFLog.i("ICDF.StreamTransfer", "onClosed, reason " + i10);
                b.this.a();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements BiConsumer<String, d> {
            public c(b bVar) {
            }

            @Override // java.util.function.BiConsumer
            public void accept(String str, d dVar) {
                dVar.a();
            }
        }

        /* loaded from: classes3.dex */
        public class d {

            /* renamed from: a, reason: collision with root package name */
            private final int f28762a;

            /* renamed from: b, reason: collision with root package name */
            private int f28763b;

            /* renamed from: c, reason: collision with root package name */
            private OutputStream f28764c;

            /* renamed from: d, reason: collision with root package name */
            private InputStream f28765d;

            public d(b bVar, int i10) {
                ICDFLog.i("ICDF.StreamParcel", "StreamParcel construct, streamId " + i10);
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    this.f28765d = new ParcelFileDescriptor.AutoCloseInputStream(createPipe[0]);
                    this.f28764c = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
                    this.f28762a = i10;
                } catch (IOException e10) {
                    ICDFLog.e("ICDF.StreamParcel", "new StreamParcel exception: " + e10);
                    throw new IllegalArgumentException("new StreamParcel failed");
                }
            }

            public void a() {
                ICDFLog.i("ICDF.StreamParcel", "StreamParcel close, streamId " + this.f28762a);
                OutputStream outputStream = this.f28764c;
                InputStream inputStream = this.f28765d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        this.f28765d = null;
                    } catch (IOException e10) {
                        ICDFLog.e("ICDF.StreamParcel", "Input/Output Stream close exception: " + e10);
                        return;
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                    this.f28764c = null;
                }
            }

            public void b() {
                OutputStream outputStream = this.f28764c;
                if (outputStream != null) {
                    try {
                        ICDFLog.i("ICDF.StreamParcel", "write done, streamId " + this.f28762a);
                        outputStream.flush();
                        outputStream.close();
                        this.f28764c = null;
                    } catch (IOException e10) {
                        ICDFLog.e("ICDF.StreamParcel", "outputStream flush/close exception: " + e10);
                    }
                }
            }

            public boolean a(byte[] bArr) {
                OutputStream outputStream = this.f28764c;
                if (outputStream == null) {
                    ICDFLog.e("ICDF.StreamParcel", "outputStream is null");
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    outputStream.write(bArr, 0, bArr.length);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 < GrpcUtils.CREATE_CHANNEL_TIME_OUT) {
                        return true;
                    }
                    ICDFLog.w("ICDF.StreamParcel", "outputStream write blocked " + currentTimeMillis2 + "(ms)");
                    return true;
                } catch (IOException e10) {
                    ICDFLog.e("ICDF.StreamParcel", "outputStream write exception: " + e10);
                    return false;
                }
            }

            public void a(int i10) {
                this.f28763b = i10;
            }
        }

        public b(CommonChannel commonChannel) {
            this.f28753c = commonChannel;
            this.f28754d = commonChannel.getPeerAgent().getAgentId();
        }

        public static void a(b bVar, InputStream inputStream, c cVar) {
            int i10;
            bVar.getClass();
            ICDFLog.i("ICDF.StreamTransfer", "start process inputStream from " + bVar.f28754d + ", curSize " + bVar.f28752b.addAndGet(1));
            int i11 = 0;
            while (true) {
                byte[] a10 = bVar.a(inputStream, 8);
                if (a10 != null) {
                    i11 += 8;
                    int i12 = ((a10[0] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((a10[1] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((a10[2] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (a10[3] & FastPairConstants.GO_INTENT_NOT_SET);
                    if (1229145158 != i12) {
                        ICDFLog.e("ICDF.StreamTransfer", "invalid msg header flag " + i12 + " stop receive");
                        break;
                    }
                    i10 = ((a10[4] & FastPairConstants.GO_INTENT_NOT_SET) << 24) + ((a10[5] & FastPairConstants.GO_INTENT_NOT_SET) << 16) + ((a10[6] & FastPairConstants.GO_INTENT_NOT_SET) << 8) + (a10[7] & FastPairConstants.GO_INTENT_NOT_SET);
                    if (i10 <= 0 || i10 > 4195328) {
                        break;
                    }
                    byte[] a11 = bVar.a(inputStream, i10);
                    if (a11 != null) {
                        i11 += i10;
                        cVar.a(a11, 0);
                    }
                }
            }
            ICDFLog.e("ICDF.StreamTransfer", "invalid msg len " + i10 + " stop receive");
            try {
                inputStream.close();
            } catch (IOException e10) {
                ICDFLog.e("ICDF.StreamTransfer", "close input stream exception: " + e10);
            }
            ICDFLog.i("ICDF.StreamTransfer", "receive complete, totalLen " + i11 + ", curSize " + bVar.f28752b.addAndGet(-1));
        }

        public void a(c cVar) {
            ICDFLog.i("ICDF.StreamTransfer", "start, peerAgentId " + this.f28754d);
            synchronized (this) {
                this.f28755e = true;
            }
            this.f28753c.setStreamListener(new a(cVar));
            this.f28753c.setChannelListener(new C0276b());
        }

        public synchronized void a() {
            if (!this.f28755e) {
                ICDFLog.i("ICDF.StreamTransfer", "already stopped");
                return;
            }
            this.f28755e = false;
            ICDFLog.i("ICDF.StreamTransfer", "stop, peerAgentId " + this.f28754d);
            this.f28751a.forEach(new c(this));
            this.f28751a.clear();
        }

        public void a(int i10) {
            synchronized (this) {
                try {
                    d dVar = this.f28751a.get(this.f28753c.getPeerAgent().getAgentId() + "_" + i10);
                    if (dVar != null) {
                        dVar.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public static void a(b bVar, int i10) {
            synchronized (bVar) {
                try {
                    Iterator<Map.Entry<String, d>> it = bVar.f28751a.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, d> next = it.next();
                        if (i10 == next.getValue().f28763b) {
                            next.getValue().a();
                            it.remove();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean a(int i10, byte[] bArr, int i11) {
            int i12;
            if (bArr != null && bArr.length != 0) {
                String agentId = this.f28753c.getPeerAgent().getAgentId();
                String str = agentId + "_" + i10;
                synchronized (this) {
                    try {
                        if (!this.f28755e) {
                            ICDFLog.w("ICDF.StreamTransfer", "refuse to send stream message on " + str);
                            return false;
                        }
                        d dVar = this.f28751a.get(str);
                        if (dVar == null) {
                            ICDFLog.i("ICDF.StreamTransfer", "stream start to peerAgent " + agentId + ", streamId " + i10 + ", stage " + i11);
                            dVar = new d(this, i10);
                            try {
                                i12 = this.f28753c.sendStream(dVar.f28765d);
                            } catch (UnSupportException e10) {
                                ICDFLog.e("ICDF.StreamTransfer", "streamTransfer.send exception: " + e10);
                                i12 = -1;
                            }
                            if (-1 == i12) {
                                ICDFLog.e("ICDF.StreamTransfer", "send stream data failed");
                                dVar.a();
                                return false;
                            }
                            ICDFLog.i("ICDF.StreamTransfer", "stream transaction id " + i12);
                            dVar.a(i12);
                            this.f28751a.put(str, dVar);
                        }
                        if (dVar.a(bArr)) {
                            if (2 != i11) {
                                return true;
                            }
                            dVar.b();
                            return true;
                        }
                        ICDFLog.e("ICDF.StreamTransfer", "write data failed, peerAgent " + agentId + ", streamId " + i10);
                        dVar.a();
                        synchronized (this) {
                            this.f28751a.remove(str);
                        }
                        return false;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            ICDFLog.e("ICDF.StreamTransfer", "write failed, invalid args");
            return false;
        }

        private byte[] a(InputStream inputStream, int i10) {
            byte[] bArr = new byte[i10];
            int i11 = 0;
            do {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    int read = inputStream.read(bArr, i11, i10 - i11);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 >= GrpcUtils.CREATE_CHANNEL_TIME_OUT) {
                        ICDFLog.w("ICDF.StreamTransfer", "inputStream.read blocked " + currentTimeMillis2 + "(ms)");
                    }
                    if (-1 == read) {
                        ICDFLog.i("ICDF.StreamTransfer", "inputStream read end");
                        return null;
                    }
                    i11 += read;
                } catch (IOException e10) {
                    ICDFLog.e("ICDF.StreamTransfer", "inputStream read error: " + e10);
                    return null;
                }
            } while (i11 < i10);
            return bArr;
        }
    }

    public void a(Map<String, p> map) {
        if (map.size() == 0) {
            return;
        }
        this.f28741a.putAll(map);
    }
}
