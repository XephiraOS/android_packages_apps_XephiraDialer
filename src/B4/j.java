package b4;

import U0.k;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.framework.bttransmission.pbapclient.ClientControler;
import com.android.contacts.model.Account;
import com.coui.appcompat.progressbar.COUIHorizontalProgressBar;
import com.customize.contacts.activities.ImportContactsActivity;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.m;
import kotlin.text.n;

/* compiled from: TransportFragment.kt */
/* loaded from: classes3.dex */
public final class j extends Fragment {

    /* renamed from: k, reason: collision with root package name */
    public static final a f12150k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Account f12151a;

    /* renamed from: b, reason: collision with root package name */
    public String f12152b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f12153c;

    /* renamed from: d, reason: collision with root package name */
    public Intent f12154d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12155e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.appcompat.app.b f12156f;

    /* renamed from: g, reason: collision with root package name */
    public COUIHorizontalProgressBar f12157g;

    /* renamed from: h, reason: collision with root package name */
    public b f12158h;

    /* renamed from: i, reason: collision with root package name */
    public ClientControler f12159i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f12160j;

    /* compiled from: TransportFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TransportFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public j f12161a;

        public b(j jVar) {
            this.f12161a = jVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int i10) {
            kotlin.jvm.internal.i.f(dialog, "dialog");
            if (H7.a.b()) {
                H7.b.b("TransportCancelListener", "click " + i10);
            }
            j jVar = this.f12161a;
            if (jVar != null) {
                jVar.f12155e = true;
                jVar.f12159i.q();
                jVar.f12159i.S(false);
                dialog.dismiss();
            }
        }
    }

    /* compiled from: TransportFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            if (H7.a.b()) {
                H7.b.b("TransportFragment", "msg.what = " + msg.what);
            }
            int i10 = msg.what;
            if (i10 != 100) {
                if (i10 != 102 && i10 != 103) {
                    switch (i10) {
                        case 1000:
                        case 1001:
                            j.this.w1();
                            break;
                        case 1002:
                            j.this.u1();
                            j.this.g1();
                            j.this.f12159i.S(false);
                            break;
                    }
                } else {
                    j.this.k1();
                    j.this.g1();
                }
            } else {
                j.this.l1();
            }
            super.handleMessage(msg);
        }
    }

    public j() {
        ClientControler y10 = ClientControler.y();
        kotlin.jvm.internal.i.e(y10, "getInstance()");
        this.f12159i = y10;
        this.f12160j = new c(Looper.getMainLooper());
        n1();
        this.f12159i.S(false);
    }

    private final void o1(androidx.appcompat.app.b bVar) {
        COUIHorizontalProgressBar cOUIHorizontalProgressBar;
        Window window = bVar.getWindow();
        if (window != null) {
            cOUIHorizontalProgressBar = (COUIHorizontalProgressBar) window.findViewById(R.id.progress);
        } else {
            cOUIHorizontalProgressBar = null;
        }
        this.f12157g = cOUIHorizontalProgressBar;
    }

    private final void t1() {
        this.f12151a = new Account(R0.a.f3165a, R0.a.f3166b);
        this.f12152b = C7.e.l(this.f12154d, "android.intent.extra.STREAM");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f12152b);
        this.f12153c = arrayList;
        if (TextUtils.isEmpty(this.f12152b)) {
            H7.b.c("TransportFragment", "File name is null.");
        } else {
            v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        Context context;
        androidx.appcompat.app.b bVar = this.f12156f;
        if (bVar != null) {
            bVar.dismiss();
        }
        h1();
        ClientControler clientControler = this.f12159i;
        FragmentActivity activity = getActivity();
        String str = null;
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = null;
        }
        Intent x10 = clientControler.x(context);
        this.f12154d = x10;
        if (x10 != null) {
            str = x10.getAction();
        }
        r1(str);
    }

    private final void v1() {
        Intent intent = new Intent("com.oplus.pbap.action.do_import");
        intent.setFlags(335544320);
        intent.putExtra("import_account", this.f12151a);
        ArrayList<String> arrayList = this.f12153c;
        kotlin.jvm.internal.i.c(arrayList);
        intent.putExtra("android.intent.extra.STREAM", arrayList.get(0));
        this.f12154d = intent;
        r1("com.oplus.pbap.action.do_import");
    }

    public final void g1() {
        androidx.appcompat.app.b bVar = this.f12156f;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public final void h1() {
        if (H7.a.b()) {
            H7.b.b("TransportFragment", "send ACTION_BLUETOOTH_TRANSFER_STATE bDownloaded");
        }
        Intent intent = new Intent("com.android.bluetooth.opp.action.TRANSFER_STATE");
        intent.putExtra("com.android.bluetooth.opp.extra.STATE", 4);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.sendBroadcast(intent, R0.b.f3175i);
        }
    }

    public final void i1() {
        if (this.f12159i.J()) {
            com.oplus.foundation.util.ui.c.d(getContext(), R.string.oplus_taost_importing_is_running);
        } else {
            this.f12159i.S(true);
            this.f12159i.z();
        }
    }

    public final boolean j1() {
        return this.f12159i.J();
    }

    public final void k1() {
        androidx.appcompat.app.b bVar = this.f12156f;
        if (bVar != null) {
            bVar.dismiss();
        }
        this.f12159i.S(false);
        if (!this.f12155e) {
            r1("com.oplus.pbap.action.connect_failed");
        } else {
            this.f12155e = false;
        }
        h1();
    }

    public final void l1() {
        int i10;
        if (this.f12159i.A() > 0) {
            r1("com.oplus.pbap.action.do_transport");
            s1();
            return;
        }
        this.f12159i.S(false);
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            m mVar = m.f34245a;
            Resources resources = getResources();
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                i10 = R.string.odialer_pbap_size_zero;
            } else {
                i10 = R.string.pbap_size_zero;
            }
            String string = resources.getString(i10);
            kotlin.jvm.internal.i.e(string, "resources.getString(\n   …                        )");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f12159i.v().getName()}, 1));
            kotlin.jvm.internal.i.e(format, "format(...)");
            com.oplus.foundation.util.ui.c.e(activity, format);
        }
    }

    public final void m1() {
        boolean p10;
        boolean p11;
        Intent intent = this.f12154d;
        if (intent != null) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) ImportContactsActivity.class);
            intent2.putExtras(intent);
            intent2.putExtra("key_from_pbap", true);
            Account account = new Account(R0.a.f3165a, R0.a.f3166b);
            this.f12151a = account;
            intent2.putExtra("import_account", account);
            p10 = n.p("oplus.intent.action.importiphone_vcard", intent.getAction(), true);
            if (!p10) {
                p11 = n.p("com.oplus.pbap.action.do_import", intent.getAction(), true);
                if (p11) {
                    intent2.setAction("android.intent.action.VIEW");
                    R7.b.f(getActivity(), intent2, 0, null, 6, null);
                    return;
                }
                return;
            }
            intent2.putExtra("key_check_importing_state", true);
            t1();
        }
    }

    public final void n1() {
        this.f12159i.Q(this.f12160j);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        BluetoothDevice bluetoothDevice;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            bluetoothDevice = (BluetoothDevice) arguments.getParcelable("Device");
        } else {
            bluetoothDevice = null;
        }
        this.f12159i.R(bluetoothDevice);
        if (bundle != null) {
            this.f12154d = (Intent) bundle.getParcelable("Intent");
            this.f12159i.S(bundle.getBoolean("TransportingFlag", false));
            p1();
        }
        this.f12158h = new b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f12159i.S(false);
        this.f12159i.Q(null);
        this.f12158h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable("Intent", this.f12154d);
        outState.putBoolean("TransportingFlag", this.f12159i.J());
    }

    public final void p1() {
        if (this.f12159i.J()) {
            if (this.f12159i.u() < this.f12159i.A() && this.f12159i.u() > 0) {
                this.f12159i.w().sendEmptyMessage(1001);
            } else if (this.f12159i.u() == 0) {
                this.f12159i.w().sendEmptyMessage(1000);
            } else {
                m1();
            }
        }
    }

    public final void q1() {
        if (!isAdded()) {
            return;
        }
        if (this.f12156f == null) {
            Context requireContext = requireContext();
            String string = getString(R.string.transporting);
            kotlin.jvm.internal.i.e(string, "getString(R.string.transporting)");
            this.f12156f = k.l(requireContext, string, this.f12158h, false, 8, null);
        }
        androidx.appcompat.app.b bVar = this.f12156f;
        if (bVar != null) {
            J3.e.b(bVar);
            bVar.show();
            o1(bVar);
            COUIHorizontalProgressBar cOUIHorizontalProgressBar = this.f12157g;
            if (cOUIHorizontalProgressBar != null) {
                cOUIHorizontalProgressBar.setMax(this.f12159i.A());
            }
            COUIHorizontalProgressBar cOUIHorizontalProgressBar2 = this.f12157g;
            if (cOUIHorizontalProgressBar2 != null) {
                cOUIHorizontalProgressBar2.setProgress(this.f12159i.u());
            }
        }
    }

    public final void r1(String str) {
        boolean p10;
        boolean p11;
        boolean p12;
        boolean p13;
        p10 = n.p("com.oplus.pbap.action.do_transport", str, true);
        if (!p10) {
            p11 = n.p("com.oplus.pbap.action.do_import", str, true);
            if (!p11) {
                p12 = n.p("oplus.intent.action.importiphone_vcard", str, true);
                if (!p12) {
                    p13 = n.p("com.oplus.pbap.action.connect_failed", str, true);
                    if (p13) {
                        com.oplus.foundation.util.ui.c.b(getActivity(), R.string.failed_transport_tablet);
                        return;
                    }
                    return;
                }
                m1();
                return;
            }
            m1();
            return;
        }
        if (getContext() != null) {
            q1();
            this.f12159i.t();
        }
    }

    public final void s1() {
        Intent intent = new Intent("com.android.bluetooth.opp.action.TRANSFER_STATE");
        intent.putExtra("com.android.bluetooth.opp.extra.STATE", 3);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.sendBroadcast(intent, R0.b.f3175i);
        }
    }

    public final void w1() {
        androidx.appcompat.app.b bVar = this.f12156f;
        if (bVar != null && bVar.isShowing()) {
            COUIHorizontalProgressBar cOUIHorizontalProgressBar = this.f12157g;
            if (cOUIHorizontalProgressBar != null) {
                cOUIHorizontalProgressBar.setProgress(this.f12159i.u());
                return;
            }
            return;
        }
        q1();
    }
}
