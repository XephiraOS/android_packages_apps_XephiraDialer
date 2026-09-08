package com.android.contacts.vcard;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.customize.contacts.util.C;
import com.oplus.dialer.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public class VCardService extends Service {

    /* renamed from: f, reason: collision with root package name */
    public int f17706f;

    /* renamed from: g, reason: collision with root package name */
    public String f17707g;

    /* renamed from: h, reason: collision with root package name */
    public String f17708h;

    /* renamed from: i, reason: collision with root package name */
    public String f17709i;

    /* renamed from: j, reason: collision with root package name */
    public int f17710j;

    /* renamed from: k, reason: collision with root package name */
    public int f17711k;

    /* renamed from: l, reason: collision with root package name */
    public String f17712l;

    /* renamed from: m, reason: collision with root package name */
    public Set<String> f17713m;

    /* renamed from: n, reason: collision with root package name */
    public String f17714n;

    /* renamed from: o, reason: collision with root package name */
    public b f17715o;

    /* renamed from: x, reason: collision with root package name */
    public c f17719x;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f17701a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Integer, q> f17702b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final List<a> f17703c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final Set<String> f17704d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public boolean f17705e = false;

    /* renamed from: p, reason: collision with root package name */
    public K3.a f17716p = null;

    /* renamed from: q, reason: collision with root package name */
    public int f17717q = -1;

    /* renamed from: r, reason: collision with root package name */
    public String f17718r = null;

    /* renamed from: y, reason: collision with root package name */
    public boolean f17720y = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f17721z = false;

    /* loaded from: classes.dex */
    public class a implements MediaScannerConnection.MediaScannerConnectionClient {

        /* renamed from: a, reason: collision with root package name */
        public final MediaScannerConnection f17722a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17723b;

        public a(String str) {
            this.f17722a = new MediaScannerConnection(VCardService.this, this);
            this.f17723b = str;
        }

        public void a() {
            this.f17722a.connect();
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            this.f17722a.scanFile(this.f17723b, null);
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            this.f17722a.disconnect();
            VCardService.this.r(this);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Binder {
        public b() {
        }

        public VCardService a() {
            return VCardService.this;
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f17726a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            H7.b.b("VCardService", "intent = " + intent);
            if (intent.getAction().equals("android.intent.action.MEDIA_PRE_SHARED") && !this.f17726a) {
                this.f17726a = true;
                com.android.contacts.vcard.c cVar = new com.android.contacts.vcard.c(VCardService.this.f17717q, VCardService.this.f17718r);
                H7.b.b("VCardService", "mDisplayName = ");
                VCardService.this.i(cVar, null);
            }
        }

        public c() {
            this.f17726a = false;
        }
    }

    public final synchronized void d() {
        try {
            Iterator<Map.Entry<Integer, q>> it = this.f17702b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().cancel(true);
            }
            this.f17702b.clear();
            this.f17701a.shutdown();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void e() {
        for (String str : fileList()) {
            if (str.startsWith("import_tmp_")) {
                H7.b.e("VCardService", "Remove a temporary file: " + str);
                deleteFile(str);
            }
        }
    }

    public final String f(String str) {
        int i10;
        boolean z10;
        String str2;
        int i11 = 0;
        for (int i12 = this.f17711k; i12 > 0; i12 /= 10) {
            i11++;
        }
        String format = String.format("%s%0" + i11 + "d%s", this.f17708h, 1, this.f17709i);
        if (format.length() <= 8 && this.f17712l.length() <= 3) {
            String format2 = new SimpleDateFormat("-yyyy-MM-dd").format(new Date());
            Resources resources = getResources();
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                i10 = R.string.launcher_odialer;
            } else {
                i10 = R.string.oplus_app_name;
            }
            String str3 = resources.getString(i10) + format2;
            for (int i13 = 0; i13 <= this.f17711k; i13++) {
                String str4 = null;
                for (String str5 : this.f17713m) {
                    if (i13 == 0) {
                        str2 = "";
                    } else {
                        str2 = "(" + i13 + ")";
                    }
                    String format3 = String.format("%s%s", str3, str2);
                    String format4 = String.format("%s/%s.%s", str, format3, str5);
                    synchronized (this) {
                        try {
                            if (!this.f17704d.contains(format4)) {
                                if (!new File(format4).exists()) {
                                    str4 = format3;
                                }
                            }
                        } finally {
                        }
                    }
                    z10 = false;
                    str4 = format3;
                }
                z10 = true;
                if (z10) {
                    return String.format("%s/%s.%s", str, str4, this.f17712l);
                }
            }
            H7.b.i("VCardService", "Reached vCard number limit. Maybe there are too many vCard in the storage");
            this.f17714n = getString(R.string.fail_reason_too_many_vcard);
            return null;
        }
        H7.b.c("VCardService", "This code does not allow any long file name.");
        this.f17714n = getString(R.string.fail_reason_too_long_filename, String.format("%s.%s", format, this.f17712l));
        H7.b.i("VCardService", "File name becomes too long.");
        return null;
    }

    public int g() {
        return this.f17706f - 1;
    }

    public final String h() {
        String str = C.c(this) + File.separator + getString(R.string.my_backup);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public synchronized void i(com.android.contacts.vcard.c cVar, s sVar) {
        try {
            int i10 = cVar.f17728a;
            q remove = this.f17702b.remove(Integer.valueOf(i10));
            if (remove != null) {
                remove.cancel(true);
                int a10 = remove.a();
                if (sVar != null) {
                    sVar.b(cVar, a10);
                }
                if (a10 == 2) {
                    String encodedPath = ((e) remove).e().f17750a.getEncodedPath();
                    H7.b.e("VCardService", String.format("Cancel reservation for the path %s if appropriate", encodedPath));
                    if (!this.f17704d.remove(encodedPath)) {
                        H7.b.i("VCardService", "Not reserved.");
                    }
                    File file = new File(encodedPath);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            } else {
                H7.b.i("VCardService", String.format("Tried to remove unknown job (id: %d)", Integer.valueOf(i10)));
            }
            s();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(f fVar, s sVar) {
        try {
            this.f17717q = this.f17706f;
            this.f17718r = fVar.f17750a.getLastPathSegment();
            K3.a aVar = this.f17716p;
            if (aVar != null) {
                aVar.e();
            }
            if (t(new e(this, fVar, this.f17706f, this.f17716p))) {
                String encodedPath = fVar.f17750a.getEncodedPath();
                if (!this.f17704d.add(encodedPath)) {
                    H7.b.i("VCardService", String.format("The path %s is already reserved. Reject export request", encodedPath));
                    if (sVar != null) {
                        sVar.H(fVar);
                    }
                } else {
                    if (sVar != null) {
                        sVar.N(fVar, this.f17706f);
                    }
                    this.f17706f++;
                }
            } else {
                if (sVar != null) {
                    sVar.H(fVar);
                }
                K3.a aVar2 = this.f17716p;
                if (aVar2 != null) {
                    aVar2.b(0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void k(int i10, boolean z10, Uri uri) {
        try {
            q remove = this.f17702b.remove(Integer.valueOf(i10));
            if (remove == null) {
                H7.b.i("VCardService", String.format("Tried to remove unknown job (id: %d)", Integer.valueOf(i10)));
            } else if (!(remove instanceof e)) {
                H7.b.i("VCardService", String.format("Removed job (id: %s) isn't ExportProcessor", Integer.valueOf(i10)));
            } else {
                this.f17704d.remove(((e) remove).e().f17750a.getEncodedPath());
            }
            s();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void l(int i10, boolean z10) {
        try {
            if (this.f17702b.remove(Integer.valueOf(i10)) == null) {
                H7.b.i("VCardService", String.format("Tried to remove unknown job (id: %d)", Integer.valueOf(i10)));
            }
            s();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        if (r7 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        r7.y(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m(java.util.List<com.android.contacts.vcard.k> r6, com.android.contacts.vcard.s r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r6.size()     // Catch: java.lang.Throwable -> L23
            r1 = 0
        L6:
            if (r1 >= r0) goto L33
            java.lang.Object r2 = r6.get(r1)     // Catch: java.lang.Throwable -> L23
            com.android.contacts.vcard.k r2 = (com.android.contacts.vcard.k) r2     // Catch: java.lang.Throwable -> L23
            com.android.contacts.vcard.j r3 = new com.android.contacts.vcard.j     // Catch: java.lang.Throwable -> L23
            int r4 = r5.f17706f     // Catch: java.lang.Throwable -> L23
            r3.<init>(r5, r7, r2, r4)     // Catch: java.lang.Throwable -> L23
            boolean r3 = r5.t(r3)     // Catch: java.lang.Throwable -> L23
            if (r3 == 0) goto L2e
            if (r7 == 0) goto L25
            int r3 = r5.f17706f     // Catch: java.lang.Throwable -> L23
            r7.O(r2, r3, r1)     // Catch: java.lang.Throwable -> L23
            goto L25
        L23:
            r6 = move-exception
            goto L35
        L25:
            int r2 = r5.f17706f     // Catch: java.lang.Throwable -> L23
            int r2 = r2 + 1
            r5.f17706f = r2     // Catch: java.lang.Throwable -> L23
            int r1 = r1 + 1
            goto L6
        L2e:
            if (r7 == 0) goto L33
            r7.y(r2)     // Catch: java.lang.Throwable -> L23
        L33:
            monitor-exit(r5)
            return
        L35:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.VCardService.m(java.util.List, com.android.contacts.vcard.s):void");
    }

    public synchronized void n(Messenger messenger) {
        Message obtain;
        try {
            String f10 = f(this.f17707g);
            if (f10 != null) {
                obtain = Message.obtain(null, 5, 0, 0, f10);
            } else {
                obtain = Message.obtain(null, 5, R.id.dialog_fail_to_export_with_reason, 0, this.f17714n);
            }
            try {
                messenger.send(obtain);
            } catch (RemoteException e10) {
                H7.b.i("VCardService", "Failed to send reply for available export destination request." + e10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void o() {
        this.f17707g = h();
        this.f17708h = getString(R.string.config_export_file_prefix);
        this.f17709i = getString(R.string.config_export_file_suffix);
        this.f17712l = getString(R.string.config_export_file_extension);
        HashSet hashSet = new HashSet();
        this.f17713m = hashSet;
        hashSet.add(this.f17712l);
        String string = getString(R.string.config_export_extensions_to_consider);
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split(",")) {
                String trim = str.trim();
                if (trim.length() > 0) {
                    this.f17713m.add(trim);
                }
            }
        }
        Resources resources = getResources();
        this.f17710j = resources.getInteger(R.integer.config_export_file_min_index);
        this.f17711k = resources.getInteger(R.integer.config_export_file_max_index);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            return this.f17715o;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.f17705e = extras.getBoolean("for_share_vcard");
        }
        return this.f17715o;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f17715o = new b();
        o();
        q();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d();
        e();
        u();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent != null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    this.f17705e = extras.getBoolean("for_share_vcard");
                    return 1;
                }
                return 1;
            } catch (Exception unused) {
                return 1;
            }
        }
        return 1;
    }

    public void p(K3.a aVar) {
        this.f17716p = aVar;
    }

    public final void q() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_PRE_SHARED");
        this.f17720y = true;
        if (this.f17719x == null) {
            this.f17719x = new c();
        }
        registerReceiver(this.f17719x, intentFilter, R0.b.f3175i, null, 2);
    }

    public final synchronized void r(a aVar) {
        this.f17703c.remove(aVar);
        s();
    }

    public final synchronized void s() {
        try {
            if (this.f17702b.size() > 0) {
                for (Map.Entry<Integer, q> entry : this.f17702b.entrySet()) {
                    Integer key = entry.getKey();
                    key.intValue();
                    if (entry.getValue().isDone()) {
                        this.f17702b.remove(key);
                    } else {
                        H7.b.e("VCardService", String.format("Found unfinished job (id: %d)", key));
                        return;
                    }
                }
            }
            if (!this.f17703c.isEmpty()) {
                return;
            }
            this.f17701a.shutdown();
            stopSelf();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean t(q qVar) {
        try {
            this.f17701a.execute(qVar);
            this.f17702b.put(Integer.valueOf(this.f17706f), qVar);
        } catch (RejectedExecutionException e10) {
            H7.b.i("VCardService", "Failed to excetute a job." + e10);
            return false;
        }
        return true;
    }

    public final void u() {
        c cVar = this.f17719x;
        if (cVar != null && this.f17720y) {
            unregisterReceiver(cVar);
            this.f17720y = false;
        }
    }

    public synchronized void v(String str) {
        if (this.f17701a.isShutdown()) {
            H7.b.i("VCardService", "MediaScanner update is requested after executor's being shut down. Ignoring the update request");
            return;
        }
        a aVar = new a(str);
        this.f17703c.add(aVar);
        aVar.a();
    }
}
