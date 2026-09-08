package com.heytap.accessory.file;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.heytap.accessory.BaseAdapter;
import com.heytap.accessory.api.IDeathCallback;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.core.IFileManager;
import com.heytap.accessory.file.FileTransfer;
import com.heytap.accessory.file.h;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import m5.C1334b;
import n5.C1371a;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class FileTransferManager {

    /* renamed from: h, reason: collision with root package name */
    public static final String f25288h = "FileTransferManager";

    /* renamed from: i, reason: collision with root package name */
    public static volatile FileTransferManager f25289i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f25290j = false;

    /* renamed from: k, reason: collision with root package name */
    public static b f25291k;

    /* renamed from: d, reason: collision with root package name */
    public IFileManager f25295d;

    /* renamed from: e, reason: collision with root package name */
    public Context f25296e;

    /* renamed from: g, reason: collision with root package name */
    public IDeathCallback f25298g;

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f25292a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, FileTransfer> f25293b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, h> f25294c = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public ServiceConnection f25297f = new a();

    /* loaded from: classes3.dex */
    public static final class DeathCallbackStub extends IDeathCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final String f25299f;

        public DeathCallbackStub(String str) {
            if (str != null) {
                this.f25299f = str;
                return;
            }
            throw new IllegalArgumentException("Invalid packageName:null");
        }

        @Override // com.heytap.accessory.api.IDeathCallback
        public String y() {
            return this.f25299f;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                C1371a.g(FileTransferManager.f25288h, "inside onServiceConnected mFTServiceConn");
                FileTransferManager.this.f25295d = IFileManager.Stub.N7(iBinder);
                HandlerThread handlerThread = new HandlerThread("FileUpdateReceiverThread");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    b unused = FileTransferManager.f25291k = new b(handlerThread.getLooper());
                }
                synchronized (FileTransferManager.f25289i) {
                    boolean unused2 = FileTransferManager.f25290j = true;
                    FileTransferManager.f25289i.notifyAll();
                    C1371a.g(FileTransferManager.f25288h, "onServiceConnected: File Transfer service connected");
                }
                return;
            }
            C1371a.d(FileTransferManager.f25288h, "onServiceConnected: File Transfer service not created");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C1371a.c(FileTransferManager.f25288h, "onServiceDisconnected: File Transfer service disconnected");
            if (FileTransferManager.f25289i != null) {
                FileTransferManager.f25289i.f25296e.unbindService(this);
                FileTransferManager.f25289i.f25295d = null;
            }
            boolean unused = FileTransferManager.f25290j = false;
            if (FileTransferManager.f25291k != null) {
                FileTransferManager.f25291k.getLooper().quit();
                b unused2 = FileTransferManager.f25291k = null;
            }
            FileTransferManager.this.f25294c.clear();
            Iterator it = FileTransferManager.this.f25294c.entrySet().iterator();
            while (it.hasNext()) {
                h hVar = (h) ((Map.Entry) it.next()).getValue();
                if (hVar != null) {
                    ConcurrentHashMap<Long, ConcurrentHashMap<Integer, h.a>> g10 = hVar.g();
                    Iterator<Map.Entry<Long, ConcurrentHashMap<Integer, h.a>>> it2 = g10.entrySet().iterator();
                    while (it2.hasNext()) {
                        for (h.a aVar : it2.next().getValue().values()) {
                            hVar.f().onTransferCompleted(aVar.f25332a, aVar.f25333b, aVar.f25335d, 20001);
                        }
                    }
                    g10.clear();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }
    }

    public static FileTransferManager g(Context context) {
        if (f25289i == null) {
            synchronized (FileTransferManager.class) {
                try {
                    if (f25289i == null) {
                        f25289i = new FileTransferManager();
                        f25289i.f25296e = context;
                    }
                } finally {
                }
            }
        }
        return f25289i;
    }

    public int a(Context context, String str, FileTransfer.c cVar, PeerAgent peerAgent, String str2, String str3) {
        Bundle bundle;
        boolean z10;
        int i10;
        if (!p(peerAgent)) {
            String i11 = i(context, str);
            if (str2 != null) {
                File file = new File(str3);
                try {
                    m5.c cVar2 = new m5.c(4, new m5.f(str3, "", "", peerAgent.getAgentId(), i11, peerAgent.getAccessoryId(), file.length(), file.getName(), str2, context.getPackageName(), str).a());
                    IFileManager iFileManager = this.f25295d;
                    if (iFileManager != null) {
                        bundle = iFileManager.L4(cVar2.a().toString());
                    } else {
                        String str4 = f25288h;
                        C1371a.d(str4, "sendFile: invalid state or req is null");
                        try {
                            g(context).y();
                            IFileManager iFileManager2 = this.f25295d;
                            if (iFileManager2 != null) {
                                bundle = iFileManager2.L4(cVar2.a().toString());
                                C1371a.d(str4, " re sendCommand");
                            } else {
                                C1371a.d(str4, "mService still is null!");
                                return -1;
                            }
                        } catch (GeneralException unused) {
                            C1371a.d(f25288h, "sendFile: reconnect oaf service failed");
                            return -1;
                        }
                    }
                } catch (RemoteException | JSONException e10) {
                    C1371a.d(f25288h, "sendFile: JSONException | RemoteException：" + e10);
                    return -1;
                }
            } else {
                bundle = null;
            }
            if (bundle != null) {
                z10 = bundle.getBoolean("STATUS");
                i10 = bundle.getInt("ID");
            } else {
                z10 = false;
                i10 = 0;
            }
            if (!o(Long.parseLong(i11), 0L)) {
                C1371a.c(f25288h, "Register death callback fail.");
            }
            if (!z10 || !q(cVar, i10)) {
                return -1;
            }
            C1371a.c(f25288h, "File Pushed and Callback registered");
            return i10;
        }
        throw new UnSupportException("the peer agent doesn't support the file feature, please check");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca A[Catch: RemoteException | JSONException -> 0x00d9, TryCatch #6 {RemoteException | JSONException -> 0x00d9, blocks: (B:23:0x00bc, B:25:0x00ca, B:26:0x00db, B:28:0x00e2, B:28:0x00e2, B:30:0x00ed, B:30:0x00ed, B:31:0x00ff, B:31:0x00ff, B:33:0x0105, B:33:0x0105), top: B:22:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db A[Catch: RemoteException | JSONException -> 0x00d9, TRY_LEAVE, TryCatch #6 {RemoteException | JSONException -> 0x00d9, blocks: (B:23:0x00bc, B:25:0x00ca, B:26:0x00db, B:28:0x00e2, B:28:0x00e2, B:30:0x00ed, B:30:0x00ed, B:31:0x00ff, B:31:0x00ff, B:33:0x0105, B:33:0x0105), top: B:22:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(android.content.Context r21, java.lang.String r22, java.lang.String r23, com.heytap.accessory.file.FileTransfer.c r24, com.heytap.accessory.bean.PeerAgent r25, android.net.Uri r26) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransferManager.b(android.content.Context, java.lang.String, java.lang.String, com.heytap.accessory.file.FileTransfer$c, com.heytap.accessory.bean.PeerAgent, android.net.Uri):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[Catch: RemoteException -> 0x0020, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x0020, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x0013, B:8:0x0029, B:11:0x0030, B:16:0x0023), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: RemoteException -> 0x0020, TryCatch #1 {RemoteException -> 0x0020, blocks: (B:2:0x0000, B:4:0x0005, B:6:0x0013, B:8:0x0029, B:11:0x0030, B:16:0x0023), top: B:1:0x0000, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int c(java.lang.String r3) {
        /*
            r2 = this;
            m5.a r0 = new m5.a     // Catch: android.os.RemoteException -> L20
            r0.<init>(r3)     // Catch: android.os.RemoteException -> L20
            m5.c r3 = new m5.c     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            org.json.JSONObject r0 = r0.a()     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            r1 = 6
            r3.<init>(r1, r0)     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            com.heytap.accessory.core.IFileManager r2 = r2.f25295d     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            if (r2 == 0) goto L26
            org.json.JSONObject r3 = r3.a()     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            java.lang.String r3 = r3.toString()     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            android.os.Bundle r2 = r2.L4(r3)     // Catch: android.os.RemoteException -> L20 org.json.JSONException -> L22
            goto L27
        L20:
            r2 = move-exception
            goto L38
        L22:
            r2 = move-exception
            r2.printStackTrace()     // Catch: android.os.RemoteException -> L20
        L26:
            r2 = 0
        L27:
            if (r2 == 0) goto L30
            java.lang.String r3 = "receiveStatus"
            int r2 = r2.getInt(r3)     // Catch: android.os.RemoteException -> L20
            return r2
        L30:
            java.lang.String r2 = com.heytap.accessory.file.FileTransferManager.f25288h     // Catch: android.os.RemoteException -> L20
            java.lang.String r3 = "File Transfer Daemon could not queue request"
            n5.C1371a.g(r2, r3)     // Catch: android.os.RemoteException -> L20
            goto L3b
        L38:
            r2.printStackTrace()
        L3b:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.accessory.file.FileTransferManager.c(java.lang.String):int");
    }

    public final String i(Context context, String str) {
        String str2;
        try {
            str2 = BaseAdapter.getDefaultAdapter(context.getApplicationContext()).getLocalAgentId(str);
        } catch (GeneralException unused) {
            C1371a.d(f25288h, "Fetching from framework failed ");
            str2 = "";
        }
        C1371a.c(f25288h, "getAgentId :" + str2);
        return str2;
    }

    public void j(long j10, int i10) {
        try {
            try {
                m5.c cVar = new m5.c(3, new C1334b(j10, i10).a());
                IFileManager iFileManager = this.f25295d;
                if (iFileManager != null) {
                    iFileManager.L4(cVar.a().toString());
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } catch (RemoteException e11) {
            e11.printStackTrace();
        }
    }

    public void k(FileTransfer.c cVar, long j10, int i10, Uri uri, boolean z10) {
        m5.c cVar2;
        Bundle bundle;
        if (z10) {
            try {
                if (!q(cVar, i10)) {
                    C1371a.c(f25288h, "Could not register file event callback. Declining transfer.");
                    cVar.onTransferCompleted(j10, i10, uri.toString(), 3);
                    return;
                }
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return;
            }
        }
        if (!o(0L, j10)) {
            C1371a.c(f25288h, "Register death callback fail.");
        }
        try {
            if (uri != null) {
                cVar2 = new m5.c(5, m5.e.a(j10, i10, uri.toString(), uri.toString(), z10).c());
            } else {
                cVar2 = new m5.c(5, m5.e.b(j10, i10).c());
            }
            IFileManager iFileManager = this.f25295d;
            if (iFileManager != null) {
                bundle = iFileManager.L4(cVar2.a().toString());
            } else {
                bundle = null;
            }
            if (bundle != null) {
                int i11 = bundle.getInt("receiveStatus");
                C1371a.g(f25288h, "receiveStatus:" + i11);
                return;
            }
            C1371a.g(f25288h, "File Transfer Daemon could not queue request");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void l(FileTransfer.c cVar, long j10, int i10, String str, String str2) {
        m5.e b10;
        Bundle bundle;
        try {
            if (!q(cVar, i10)) {
                C1371a.c(f25288h, "Could not register file event callback. Declining transfer.");
                cVar.onTransferCompleted(j10, i10, str, 3);
                return;
            }
            if (!o(0L, j10)) {
                C1371a.c(f25288h, "Register death callback fail.");
            }
            try {
                if (str2 != null) {
                    b10 = m5.e.a(j10, i10, str, str2, true);
                } else {
                    b10 = m5.e.b(j10, i10);
                }
                m5.c cVar2 = new m5.c(5, b10.c());
                IFileManager iFileManager = this.f25295d;
                if (iFileManager != null) {
                    bundle = iFileManager.L4(cVar2.a().toString());
                } else {
                    bundle = null;
                }
                if (bundle != null) {
                    int i11 = bundle.getInt("receiveStatus");
                    C1371a.g(f25288h, "receiveStatus:" + i11);
                    return;
                }
                C1371a.g(f25288h, "File Transfer Daemon could not queue request");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } catch (RemoteException e11) {
            e11.printStackTrace();
        }
    }

    public final void m(String str, PeerAgent peerAgent) {
        if (!p(peerAgent)) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (str.length() <= 4096) {
                    return;
                } else {
                    throw new UnSupportException("the param fileInfo is too long!");
                }
            }
            throw new RuntimeException("current task should not use in main thread");
        }
        throw new UnSupportException("the peer agent doesn't support the file feature, please check");
    }

    public void n(String str, h hVar) {
        this.f25294c.put(str, hVar);
    }

    public boolean o(long j10, long j11) {
        if (this.f25298g == null) {
            this.f25298g = new DeathCallbackStub(f25289i.f25296e.getPackageName());
        }
        try {
            IFileManager iFileManager = this.f25295d;
            if (iFileManager != null) {
                return iFileManager.s5(this.f25298g, j10, j11);
            }
            return false;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final boolean p(PeerAgent peerAgent) {
        if (peerAgent != null && peerAgent.getAccessory() != null && peerAgent.getAccessory().supportFile()) {
            return false;
        }
        return true;
    }

    public boolean q(FileTransfer.c cVar, int i10) {
        if (cVar != null) {
            try {
                IFileManager iFileManager = this.f25295d;
                if (iFileManager != null) {
                    return iFileManager.X(i10, new FileCallbackReceiver(f25291k, cVar));
                }
                return false;
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean r(FileTransfer fileTransfer, String str) {
        if (!this.f25292a.contains(str)) {
            this.f25292a.add(str);
        }
        this.f25293b.put(str, fileTransfer);
        C1371a.g(f25288h, "register agent in map,agentName:" + str + ",streamTransfer:" + this.f25293b.hashCode());
        return true;
    }

    public h u(String str) {
        return this.f25294c.get(str);
    }

    public void x(String str) {
        this.f25292a.remove(str);
        this.f25293b.remove(str);
        if (f25289i != null) {
            if (this.f25292a.isEmpty()) {
                f25289i.f25296e.unbindService(f25289i.f25297f);
                f25289i.f25295d = null;
                f25290j = false;
                b bVar = f25291k;
                if (bVar != null) {
                    bVar.getLooper().quit();
                    f25291k = null;
                }
                C1371a.c(f25288h, "File transfer service disconnected");
                return;
            }
            C1371a.d(f25288h, "Other applications are still using this FT binding");
            return;
        }
        C1371a.d(f25288h, "FT already unbound for this package. Please check whether the calling agent was registered");
    }

    public synchronized void y() {
        if (f25289i.f25295d == null) {
            Intent intent = new Intent(FTInitializer.FILE_TRANSFER_SERVICE_INTENT);
            intent.setPackage(FTInitializer.getFileTransferPackageName(f25289i.f25296e));
            String str = f25288h;
            C1371a.g(str, "getInstance: bindService before" + intent);
            if (f25289i.f25296e.bindService(intent, f25289i.f25297f, 33)) {
                try {
                    C1371a.g(str, "SAFTAdapter: About start waiting");
                    f25289i.wait(10000L);
                } catch (InterruptedException e10) {
                    C1371a.d(f25288h, "bindOafFileService InterruptedException:" + e10);
                }
                if (f25290j) {
                    C1371a.g(f25288h, "getInstance: Woken up , FTService Connected");
                } else {
                    throw new GeneralException(20001, "Timed out trying to bind to FT Service!");
                }
            } else {
                C1371a.d(str, "[FileTransfer] bindService Failed");
            }
        }
    }

    public FileTransfer z(String str) {
        return this.f25293b.get(str);
    }
}
