package com.heytap.accessory.stream;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.heytap.accessory.BaseAdapter;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.core.IStreamManager;
import com.heytap.accessory.stream.StreamTransfer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import n5.C1371a;
import org.json.JSONException;
import p5.C1441a;
import p5.C1443c;
import p5.e;
import p5.f;
import p5.g;
import q5.C1487a;

/* compiled from: StreamTransferManager.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final String f25339d = "StreamTransferManager";

    /* renamed from: h, reason: collision with root package name */
    public static volatile a f25343h;

    /* renamed from: j, reason: collision with root package name */
    public static b f25345j;

    /* renamed from: a, reason: collision with root package name */
    public IStreamManager f25346a;

    /* renamed from: b, reason: collision with root package name */
    public Context f25347b;

    /* renamed from: c, reason: collision with root package name */
    public ServiceConnection f25348c = new ServiceConnectionC0227a();

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, C1441a> f25340e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public static List<String> f25341f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, StreamTransfer> f25342g = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    public static boolean f25344i = false;

    /* compiled from: StreamTransferManager.java */
    /* renamed from: com.heytap.accessory.stream.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ServiceConnectionC0227a implements ServiceConnection {
        public ServiceConnectionC0227a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                C1371a.g(a.f25339d, "inside onServiceConnected mSTServiceConn");
                a.this.f25346a = IStreamManager.Stub.N7(iBinder);
                HandlerThread handlerThread = new HandlerThread("StreamUpdateReceiverThread");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    b unused = a.f25345j = new b(handlerThread.getLooper());
                }
                if (a.f25343h != null) {
                    synchronized (a.f25343h) {
                        boolean unused2 = a.f25344i = true;
                        a.f25343h.notifyAll();
                        C1371a.g(a.f25339d, "onServiceConnected: Stream Transfer service connected");
                    }
                    return;
                }
                return;
            }
            C1371a.d(a.f25339d, "onServiceConnected: Stream Transfer service not created");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1371a.c(a.f25339d, "onServiceDisconnected: Stream Transfer service disconnected");
            if (a.f25343h != null) {
                a.f25343h.f25347b.unbindService(this);
                a.f25343h.f25346a = null;
            }
            boolean unused = a.f25344i = false;
            if (a.f25345j != null) {
                a.f25345j.getLooper().quit();
                b unused2 = a.f25345j = null;
            }
            Iterator it = a.f25340e.entrySet().iterator();
            while (it.hasNext()) {
                C1441a c1441a = (C1441a) ((Map.Entry) it.next()).getValue();
                if (c1441a != null) {
                    ConcurrentHashMap<Long, ConcurrentHashMap<Integer, C1441a.C0341a>> e10 = c1441a.e();
                    Iterator<Map.Entry<Long, ConcurrentHashMap<Integer, C1441a.C0341a>>> it2 = e10.entrySet().iterator();
                    while (it2.hasNext()) {
                        for (C1441a.C0341a c0341a : it2.next().getValue().values()) {
                            c1441a.d().onTransferCompleted(c0341a.f36019a, c0341a.f36020b, 20001);
                        }
                    }
                    e10.clear();
                }
            }
            a.f25340e.clear();
        }
    }

    /* compiled from: StreamTransferManager.java */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }
    }

    public static a i(Context context) {
        if (f25343h == null) {
            synchronized (a.class) {
                try {
                    if (f25343h == null) {
                        f25343h = new a();
                        f25343h.f25347b = context;
                    }
                } finally {
                }
            }
        }
        return f25343h;
    }

    public static void l(String str, C1441a c1441a) {
        f25340e.put(str, c1441a);
    }

    public static C1441a q(String str) {
        return f25340e.get(str);
    }

    public static StreamTransfer w(String str) {
        return f25342g.get(str);
    }

    public int a(Context context, String str, StreamTransfer.b bVar, PeerAgent peerAgent, ParcelFileDescriptor parcelFileDescriptor) {
        e eVar;
        boolean z10;
        g gVar = new g(peerAgent.getAgentId(), v(context, str), peerAgent.getAccessoryId(), context.getPackageName(), str);
        Bundle bundle = null;
        try {
            eVar = new e(4, gVar.a());
        } catch (JSONException e10) {
            e10.printStackTrace();
            eVar = null;
        }
        try {
            if (this.f25346a != null && eVar != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("BUNDLE_KEY_SOURCE", parcelFileDescriptor);
                bundle = this.f25346a.I2(eVar.a().toString(), bundle2);
            } else {
                C1371a.d(f25339d, "sendInputStream: invalid state or req is null");
            }
        } catch (RemoteException | JSONException e11) {
            e11.printStackTrace();
        }
        int i10 = -1;
        if (bundle != null) {
            z10 = bundle.getBoolean("STATUS");
            i10 = bundle.getInt("ID", -1);
        } else {
            z10 = false;
        }
        if (z10 && m(bVar, i10)) {
            C1371a.c(f25339d, "Stream Pushed and Callback registered");
        }
        return i10;
    }

    public int b(Context context, String str, StreamTransfer.b bVar, PeerAgent peerAgent, FileDescriptor fileDescriptor) {
        try {
            return a(context, str, bVar, peerAgent, ParcelFileDescriptor.dup(fileDescriptor));
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public int c(Context context, String str, StreamTransfer.b bVar, PeerAgent peerAgent, InputStream inputStream) {
        ParcelFileDescriptor b10;
        if (inputStream != null) {
            try {
                b10 = C1487a.b(inputStream, peerAgent.getAccessory().getTransportType());
            } catch (IOException e10) {
                e10.printStackTrace();
                return -1;
            }
        } else {
            b10 = null;
        }
        return a(context, str, bVar, peerAgent, b10);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056 A[Catch: RemoteException -> 0x0045, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x0045, blocks: (B:3:0x0020, B:5:0x0025, B:7:0x0033, B:9:0x004e, B:12:0x0056, B:17:0x0048), top: B:2:0x0020, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004e A[Catch: RemoteException -> 0x0045, TryCatch #1 {RemoteException -> 0x0045, blocks: (B:3:0x0020, B:5:0x0025, B:7:0x0033, B:9:0x004e, B:12:0x0056, B:17:0x0048), top: B:2:0x0020, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = com.heytap.accessory.stream.a.f25339d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[cancelAll] cancelAllTransactions, agentId:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ",connectionId:"
            r1.append(r2)
            r2 = 0
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            n5.C1371a.c(r0, r1)
            p5.b r0 = new p5.b     // Catch: android.os.RemoteException -> L45
            r0.<init>(r5, r2)     // Catch: android.os.RemoteException -> L45
            p5.e r5 = new p5.e     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            org.json.JSONObject r0 = r0.a()     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            r1 = 6
            r5.<init>(r1, r0)     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            com.heytap.accessory.core.IStreamManager r4 = r4.f25346a     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            if (r4 == 0) goto L4b
            org.json.JSONObject r5 = r5.a()     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            java.lang.String r5 = r5.toString()     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            android.os.Bundle r0 = new android.os.Bundle     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            r0.<init>()     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            android.os.Bundle r4 = r4.I2(r5, r0)     // Catch: android.os.RemoteException -> L45 org.json.JSONException -> L47
            goto L4c
        L45:
            r4 = move-exception
            goto L5e
        L47:
            r4 = move-exception
            r4.printStackTrace()     // Catch: android.os.RemoteException -> L45
        L4b:
            r4 = 0
        L4c:
            if (r4 == 0) goto L56
            java.lang.String r5 = "receiveStatus"
            r0 = -1
            int r4 = r4.getInt(r5, r0)     // Catch: android.os.RemoteException -> L45
            return r4
        L56:
            java.lang.String r4 = com.heytap.accessory.stream.a.f25339d     // Catch: android.os.RemoteException -> L45
            java.lang.String r5 = "Stream Transfer Daemon could not queue request"
            n5.C1371a.g(r4, r5)     // Catch: android.os.RemoteException -> L45
            goto L61
        L5e:
            r4.printStackTrace()
        L61:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.stream.a.d(java.lang.String):int");
    }

    public ParcelFileDescriptor f(StreamTransfer.b bVar, long j10, int i10, boolean z10) {
        Bundle bundle;
        String str = f25339d;
        C1371a.c(str, "receiveStream connectionId:" + j10 + " +transId:" + i10 + " isAccept:" + z10);
        if (z10) {
            try {
                if (!m(bVar, i10)) {
                    C1371a.c(str, "Could not register stream event callback. Declining transfer.");
                    bVar.onTransferCompleted(j10, i10, 3);
                    return null;
                }
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        try {
            e eVar = new e(5, new f(j10, i10, z10, 0).a());
            IStreamManager iStreamManager = this.f25346a;
            if (iStreamManager != null) {
                bundle = iStreamManager.I2(eVar.a().toString(), new Bundle());
            } else {
                bundle = null;
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        if (bundle != null) {
            C1371a.g(str, "receiveStatus:" + bundle.getInt("receiveStatus"));
            return (ParcelFileDescriptor) bundle.getParcelable(StreamTransfer.RECEIVE_PFD);
        }
        C1371a.g(str, "Stream Transfer Daemon could not queue request");
        return null;
    }

    public void k(long j10, int i10) {
        try {
            try {
                e eVar = new e(3, new C1443c(j10, i10).a());
                IStreamManager iStreamManager = this.f25346a;
                if (iStreamManager != null) {
                    iStreamManager.I2(eVar.a().toString(), new Bundle());
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } catch (RemoteException e11) {
            e11.printStackTrace();
        }
    }

    public boolean m(StreamTransfer.b bVar, int i10) {
        if (bVar != null) {
            try {
                IStreamManager iStreamManager = this.f25346a;
                if (iStreamManager != null) {
                    return iStreamManager.X(i10, new StreamCallbackReceiver(f25345j, bVar));
                }
                return false;
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean n(StreamTransfer streamTransfer, String str) {
        if (!f25341f.contains(str)) {
            f25341f.add(str);
        }
        f25342g.put(str, streamTransfer);
        C1371a.g(f25339d, "register agent in map,agentName:" + str + ",streamTransfer:" + streamTransfer.hashCode());
        return true;
    }

    public void s(String str) {
        String str2 = f25339d;
        C1371a.g(str2, "unregister: remove agent in map:" + str);
        f25342g.remove(str);
        f25341f.remove(str);
        if (f25343h != null) {
            if (f25341f.isEmpty()) {
                try {
                    f25343h.f25347b.unbindService(f25343h.f25348c);
                    f25343h.f25346a = null;
                } catch (Exception e10) {
                    C1371a.d(f25339d, "unbindService failed，error:" + e10);
                }
                f25344i = false;
                b bVar = f25345j;
                if (bVar != null) {
                    bVar.getLooper().quit();
                    f25345j = null;
                }
                C1371a.c(f25339d, "Stream transfer service disconnected");
                return;
            }
            C1371a.d(str2, "Other applications are still using this FT binding");
            return;
        }
        C1371a.d(str2, "FT already unbound for this package. Please check whether the calling agent was registered");
    }

    public synchronized void u() {
        if (f25343h.f25346a == null) {
            Intent intent = new Intent(StreamInitializer.STREAM_TRANSFER_SERVICE_INTENT);
            intent.setPackage(StreamInitializer.getStreamMsgPackageName(f25343h.f25347b));
            String str = f25339d;
            C1371a.g(str, "getInstance: bindService before" + intent);
            if (f25343h.f25347b.bindService(intent, f25343h.f25348c, 33)) {
                try {
                    C1371a.g(str, "SAFTAdapter: About start waiting");
                    f25343h.wait(10000L);
                } catch (InterruptedException e10) {
                    C1371a.d(f25339d, "bindOafStreamService:" + e10);
                }
                if (f25344i) {
                    C1371a.g(f25339d, "getInstance: Woken up , FTService Connected");
                } else {
                    throw new GeneralException(20001, "Timed out trying to bind to FT Service!");
                }
            } else {
                C1371a.d(str, "[FileTransfer] bindService Failed");
            }
        }
    }

    public String v(Context context, String str) {
        String str2;
        try {
            str2 = BaseAdapter.getDefaultAdapter(context.getApplicationContext()).getLocalAgentId(str);
        } catch (GeneralException unused) {
            C1371a.d(f25339d, "Fetching from framework failed ");
            str2 = "";
        }
        C1371a.k(f25339d, "getAgentId :" + str2);
        return str2;
    }
}
