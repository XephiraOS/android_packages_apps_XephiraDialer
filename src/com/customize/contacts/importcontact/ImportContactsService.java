package com.customize.contacts.importcontact;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.android.contacts.model.Account;
import com.customize.contacts.cleaner.RawCleanerJobService;
import com.customize.contacts.util.C;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ImportContactsService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public e f21361b;

    /* renamed from: f, reason: collision with root package name */
    public com.customize.contacts.importcontact.d f21365f;

    /* renamed from: g, reason: collision with root package name */
    public int f21366g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<String> f21367h;

    /* renamed from: i, reason: collision with root package name */
    public Account f21368i;

    /* renamed from: l, reason: collision with root package name */
    public g f21371l;

    /* renamed from: m, reason: collision with root package name */
    public n f21372m;

    /* renamed from: n, reason: collision with root package name */
    public i f21373n;

    /* renamed from: o, reason: collision with root package name */
    public k f21374o;

    /* renamed from: a, reason: collision with root package name */
    public String f21360a = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21362c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21363d = false;

    /* renamed from: e, reason: collision with root package name */
    public d f21364e = new d();

    /* renamed from: j, reason: collision with root package name */
    public boolean f21369j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21370k = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21375p = false;

    /* renamed from: q, reason: collision with root package name */
    public BroadcastReceiver f21376q = new a();

    /* renamed from: r, reason: collision with root package name */
    public final BroadcastReceiver f21377r = new b();

    /* renamed from: x, reason: collision with root package name */
    public j f21378x = new c();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.PHONE_STATE".equals(intent.getAction())) {
                String l10 = C7.e.l(intent, "state");
                if (TelephonyManager.EXTRA_STATE_IDLE.equals(l10)) {
                    ImportContactsService.this.i(false);
                } else if (TelephonyManager.EXTRA_STATE_RINGING.equals(l10)) {
                    ImportContactsService.this.i(true);
                } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(l10)) {
                    ImportContactsService.this.i(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.MEDIA_EJECT")) {
                ImportContactsService importContactsService = ImportContactsService.this;
                if (importContactsService.f21360a != null && C.a(importContactsService.getApplicationContext()) != null) {
                    ImportContactsService importContactsService2 = ImportContactsService.this;
                    if (!importContactsService2.f21360a.contains(C.a(importContactsService2.getApplicationContext()).getAbsolutePath())) {
                        ImportContactsService.this.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends j {
        public c() {
        }

        public final String h(int i10) {
            return ImportContactsService.this.getString(i10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String format;
            int i10 = message.what;
            if (2 == i10) {
                int d10 = ImportContactsService.this.f21372m.d();
                if (d10 <= 0) {
                    format = h(R.string.oplus_toast_imported_nothing);
                } else {
                    format = String.format(h(R.string.aleady_imported), U7.a.b(d10));
                    com.android.contacts.framework.api.infocollection.a.c();
                }
                Q3.b.c();
                com.oplus.foundation.util.ui.c.c(ImportContactsService.this, format);
                ImportContactsService.this.stopSelf();
                RawCleanerJobService.b(ImportContactsService.this, false, true);
                H7.b.e("ImportContactsService", "MESSAGE_THREAD_FINISH Import finish. releaseCpuLock");
                Z3.c.b();
                return;
            }
            if (4 == i10) {
                ImportContactsService.this.stopSelf();
                H7.b.e("ImportContactsService", "MESSAGE_THREAD_CANCELED Import finish. releaseCpuLock");
                Z3.c.b();
                return;
            }
            if (3 == i10) {
                if (ImportContactsService.this.f21370k) {
                    com.oplus.foundation.util.ui.c.c(ImportContactsService.this, ImportContactsService.this.f21373n.c(message.arg1, message.arg2));
                }
                if (H7.a.b()) {
                    H7.b.b("ImportContactsService", "Error happen: " + message.arg1);
                }
                ImportContactsService.this.stopSelf();
                H7.b.e("ImportContactsService", "MESSAGE_THREAD_ERROR Import finish. releaseCpuLock");
                Z3.c.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends Binder implements n {
        public d() {
        }

        @Override // com.customize.contacts.importcontact.n
        public int a() {
            return ImportContactsService.this.f21372m.a();
        }

        @Override // com.customize.contacts.importcontact.n
        public int b() {
            return ImportContactsService.this.f21372m.b();
        }

        @Override // com.customize.contacts.importcontact.n
        public int c() {
            return ImportContactsService.this.f21372m.c();
        }

        @Override // com.customize.contacts.importcontact.n
        public int d() {
            return ImportContactsService.this.f21372m.d();
        }

        public ImportContactsService e() {
            return ImportContactsService.this;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21383a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (H7.a.b()) {
                H7.b.b("ImportContactsService", "intent = " + intent);
            }
            if (intent.getAction().equals("android.intent.action.MEDIA_PRE_SHARED") && !this.f21383a) {
                this.f21383a = true;
                ImportContactsService.this.d();
            }
        }

        public e() {
            this.f21383a = false;
        }
    }

    public void d() {
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "cancel()------------------");
        }
        k kVar = this.f21374o;
        if (kVar != null) {
            kVar.f(0);
        }
        com.customize.contacts.importcontact.d dVar = this.f21365f;
        if (dVar != null) {
            dVar.d();
        }
        Q3.b.c();
    }

    public final void e() {
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "registerMoveSDReceiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f21377r, intentFilter, R0.b.f3175i, null, 2);
        this.f21375p = true;
    }

    public final void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(this.f21376q, intentFilter, R0.b.f3175i, null, 2);
        this.f21363d = true;
    }

    public final void g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_PRE_SHARED");
        this.f21362c = true;
        if (this.f21361b == null) {
            this.f21361b = new e();
        }
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "registerUsbReceiver");
        }
        registerReceiver(this.f21361b, intentFilter, R0.b.f3175i, null, 2);
    }

    public void h() {
        this.f21371l.o(555);
        com.customize.contacts.importcontact.d dVar = this.f21365f;
        new Thread(dVar, dVar.e()).start();
    }

    public void i(boolean z10) {
        com.customize.contacts.importcontact.d dVar = this.f21365f;
        if (dVar != null) {
            dVar.o(z10);
        }
    }

    public void j(k kVar) {
        this.f21370k = false;
        this.f21374o = kVar;
        com.customize.contacts.importcontact.d dVar = this.f21365f;
        if (dVar != null) {
            dVar.n(kVar);
        }
    }

    public final void k() {
        if (this.f21377r != null && this.f21375p) {
            if (H7.a.b()) {
                H7.b.b("ImportContactsService", "unRegisterMoveSDReceiver");
            }
            unregisterReceiver(this.f21377r);
            this.f21375p = false;
        }
    }

    public final void l() {
        BroadcastReceiver broadcastReceiver = this.f21376q;
        if (broadcastReceiver != null && this.f21363d) {
            unregisterReceiver(broadcastReceiver);
            this.f21363d = false;
        }
    }

    public final void m() {
        if (this.f21361b != null && this.f21362c) {
            if (H7.a.b()) {
                H7.b.b("ImportContactsService", "unRegisterUsbReceiver");
            }
            unregisterReceiver(this.f21361b);
            this.f21362c = false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (H7.a.b()) {
            boolean c10 = C7.e.c(intent, "key_check_importing_state", false);
            H7.b.b("ImportContactsService", "onBind, intent =  " + intent);
            H7.b.b("ImportContactsService", "onBind, mbCheckState =  " + c10);
        }
        return this.f21364e;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (H7.a.b()) {
            H7.b.e("ImportContactsService", "onCreate----------------");
        }
        g gVar = new g(this);
        this.f21371l = gVar;
        this.f21372m = gVar;
        this.f21373n = new i(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "onDestroy()----------------");
        }
        this.f21374o = null;
        m();
        l();
        k();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "onRebind(), intent = " + intent);
        }
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            H7.b.b("ImportContactsService", "intent is null");
            return 2;
        }
        this.f21369j = C7.e.c(intent, "key_from_pbap", false);
        if (C7.e.c(intent, "key_check_importing_state", false)) {
            return 2;
        }
        g();
        f();
        e();
        int c10 = this.f21372m.c();
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "onStartCommand intent " + intent);
            H7.b.b("ImportContactsService", "onStartCommand, importStatus = " + c10);
        }
        if (666 == c10) {
            this.f21367h = C7.e.k(intent, "FILE_NAME");
            this.f21368i = (Account) C7.e.j(intent, "import_account");
            this.f21366g = C7.e.d(intent, "key_file_type", -1);
            if (H7.a.b()) {
                H7.b.e("ImportContactsService", "onStartCommand fileType " + this.f21366g + "action: " + intent.getAction());
                StringBuilder sb = new StringBuilder();
                sb.append("onStartCommand account = ");
                sb.append(this.f21368i);
                H7.b.e("ImportContactsService", sb.toString());
            }
            if (this.f21368i == null) {
                this.f21368i = new Account(R0.a.f3165a, R0.a.f3166b);
            }
            com.customize.contacts.importcontact.d dVar = new com.customize.contacts.importcontact.d(this, this.f21367h, this.f21368i, this.f21371l, this.f21366g, this.f21369j);
            this.f21365f = dVar;
            dVar.n(this.f21378x);
        } else if (H7.a.b()) {
            H7.b.b("ImportContactsService", "Service is running, don't start another import thread again");
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (H7.a.b()) {
            H7.b.b("ImportContactsService", "onUnbind(), intent = " + intent);
            return false;
        }
        return false;
    }
}
