package com.android.contacts.calllog;

import a4.C0421a;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.ContactsContract;
import android.telecom.PhoneAccountHandle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.T0;
import com.android.contacts.ViewOnClickListenerC0694u0;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.calllog.F;
import com.android.contacts.calllog.k;
import com.android.contacts.calllog.z;
import com.android.contacts.detail.CallLogDeleteHelper;
import com.android.contacts.dialpad.HighLightNumber;
import com.android.contacts.dialpad.view.HighLightView;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.LocationUtils;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.fragment.DialtactsUnfoldFragment;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.C0803n;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.M;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import com.customize.contacts.util.h0;
import com.customize.contacts.util.k0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import com.ted.number.ui.ErrorRecoveryActivity;
import com.ted.number.ui.MarkDialogActivity;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import r0.C1501d;
import w0.C1641a;
import w0.C1643c;

/* compiled from: CallLogAdapter.java */
/* loaded from: classes.dex */
public class k extends F implements View.OnClickListener {

    /* renamed from: t0, reason: collision with root package name */
    public static long f13898t0 = -1;

    /* renamed from: u0, reason: collision with root package name */
    public static int f13899u0;

    /* renamed from: A, reason: collision with root package name */
    public final int f13900A;

    /* renamed from: B, reason: collision with root package name */
    public final int f13901B;

    /* renamed from: C, reason: collision with root package name */
    public final ViewOnClickListenerC0694u0 f13902C;

    /* renamed from: D, reason: collision with root package name */
    public final Handler f13903D;

    /* renamed from: E, reason: collision with root package name */
    public final HandlerThread f13904E;

    /* renamed from: F, reason: collision with root package name */
    public final Handler f13905F;

    /* renamed from: G, reason: collision with root package name */
    public final Z3.f f13906G;

    /* renamed from: H, reason: collision with root package name */
    public final T0 f13907H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f13908I;

    /* renamed from: J, reason: collision with root package name */
    public com.android.contacts.framework.baseui.util.w f13909J;

    /* renamed from: K, reason: collision with root package name */
    public int f13910K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f13911L;

    /* renamed from: M, reason: collision with root package name */
    public String f13912M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f13913N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f13914O;

    /* renamed from: P, reason: collision with root package name */
    public int f13915P;

    /* renamed from: Q, reason: collision with root package name */
    public int f13916Q;

    /* renamed from: R, reason: collision with root package name */
    public DateFormat f13917R;

    /* renamed from: S, reason: collision with root package name */
    public DateFormat f13918S;

    /* renamed from: T, reason: collision with root package name */
    public HashMap<String, Integer> f13919T;

    /* renamed from: U, reason: collision with root package name */
    public CancellationSignal f13920U;

    /* renamed from: V, reason: collision with root package name */
    public HashMap<String, String> f13921V;

    /* renamed from: W, reason: collision with root package name */
    public E3.q f13922W;

    /* renamed from: X, reason: collision with root package name */
    public E3.o f13923X;

    /* renamed from: Y, reason: collision with root package name */
    public HashMap<String, CheckBox> f13924Y;

    /* renamed from: Z, reason: collision with root package name */
    public E3.c f13925Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f13926a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f13927b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f13928c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f13929d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f13930e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f13931f0;

    /* renamed from: g0, reason: collision with root package name */
    public o f13932g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f13933h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f13934i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f13935j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f13936k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f13937l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f13938m0;

    /* renamed from: n, reason: collision with root package name */
    public final j f13939n;

    /* renamed from: n0, reason: collision with root package name */
    public int f13940n0;

    /* renamed from: o, reason: collision with root package name */
    public String f13941o;

    /* renamed from: o0, reason: collision with root package name */
    public COUIPopupListWindow f13942o0;

    /* renamed from: p, reason: collision with root package name */
    public final I f13943p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f13944p0;

    /* renamed from: q, reason: collision with root package name */
    public final z f13945q;

    /* renamed from: q0, reason: collision with root package name */
    public List<View> f13946q0;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<SpannableStringBuilder> f13947r;

    /* renamed from: r0, reason: collision with root package name */
    public final z.b f13948r0;

    /* renamed from: s0, reason: collision with root package name */
    public final LocationUtils.a f13949s0;

    /* renamed from: x, reason: collision with root package name */
    public final GregorianCalendar f13950x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f13951y;

    /* renamed from: z, reason: collision with root package name */
    public final int f13952z;

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class a implements z.b {
        public a() {
        }

        @Override // com.android.contacts.calllog.z.b
        public void a() {
            if (k.this.f13942o0 != null && k.this.f13942o0.isShowing()) {
                return;
            }
            k.this.D();
        }

        @Override // com.android.contacts.calllog.z.b
        public void i() {
            if (k.this.f13927b0) {
                return;
            }
            k.this.f13939n.i();
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13958a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f13959b;

        public d(ArrayList arrayList, m mVar) {
            this.f13958a = arrayList;
            this.f13959b = mVar;
        }

        public final /* synthetic */ void d(m mVar) {
            long j10 = mVar.f13984d;
            if (j10 >= 0) {
                k.this.b2(j10, mVar.f13981a);
            } else {
                k.this.b2(-1L, mVar.f13981a);
            }
            com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030240, null, false);
        }

        public final /* synthetic */ void e(m mVar) {
            k kVar = k.this;
            kVar.X1(kVar.f13787b, mVar, 7);
        }

        public final /* synthetic */ void f(m mVar) {
            k kVar = k.this;
            kVar.W1(kVar.f13787b, mVar);
        }

        public final void g(Intent intent, int i10) {
            if (OsUtils.f28275a.j()) {
                PhoneAccountHandle s10 = b0.s(k.this.f13787b, i10);
                if (s10 != null) {
                    intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", s10);
                    return;
                }
                return;
            }
            intent.putExtra(OplusPhoneUtils.SUBSCRIPTION_KEY, i10);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            G g10;
            Intent b10;
            Intent N10;
            Integer num = (Integer) k.this.f13919T.get(this.f13958a.get(i10));
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        k.this.z1(this.f13959b.f13982b);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030236, null, false);
                        break;
                    case 1:
                        k.this.f13902C.V3(this.f13959b.f13982b);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030237, null, false);
                        break;
                    case 2:
                        k.this.d2(this.f13959b.f13982b);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030238, null, false);
                        break;
                    case 3:
                        k.this.e2(this.f13959b.f13982b);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030239, null, false);
                        break;
                    case 4:
                        k kVar = k.this;
                        m mVar = this.f13959b;
                        kVar.b2(mVar.f13984d, mVar.f13981a);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030240, null, false);
                        break;
                    case 5:
                        ComponentActivity componentActivity = k.this.f13787b;
                        final m mVar2 = this.f13959b;
                        com.android.contacts.framework.api.appstore.appinfo.a.a(componentActivity, new Runnable() { // from class: com.android.contacts.calllog.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                k.d.this.d(mVar2);
                            }
                        });
                        break;
                    case 6:
                        k kVar2 = k.this;
                        kVar2.X1(kVar2.f13787b, this.f13959b, 6);
                        break;
                    case 7:
                        ComponentActivity componentActivity2 = k.this.f13787b;
                        final m mVar3 = this.f13959b;
                        com.android.contacts.framework.api.appstore.appinfo.a.a(componentActivity2, new Runnable() { // from class: com.android.contacts.calllog.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                k.d.this.e(mVar3);
                            }
                        });
                        break;
                    case 8:
                        Intent intent = new Intent(k.this.f13787b, (Class<?>) MarkDialogActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("number", this.f13959b.f13982b);
                        bundle.putInt(OplusNumberMarkUtils.OplusContact.OPLUS_MARK_CONTACTS_CALL_TYPE, this.f13959b.f13983c);
                        bundle.putBoolean("isInBlackList", this.f13959b.f13988h);
                        bundle.putBoolean("isInWhiteList", this.f13959b.f13990j);
                        intent.putExtras(bundle);
                        R7.b.d(k.this.f13787b, intent, R.string.activity_not_found);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030242, null, false);
                        break;
                    case 9:
                        C0803n.b(k.this.f13787b, " ", new String[]{"text/plain"}, U7.f.g(this.f13959b.f13982b), true);
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000304, 200030235, null, false);
                        break;
                    case 10:
                        k kVar3 = k.this;
                        kVar3.J0(kVar3.f13787b, this.f13959b);
                        break;
                    case 11:
                        ComponentActivity componentActivity3 = k.this.f13787b;
                        final m mVar4 = this.f13959b;
                        com.android.contacts.framework.api.appstore.appinfo.a.a(componentActivity3, new Runnable() { // from class: com.android.contacts.calllog.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                k.d.this.f(mVar4);
                            }
                        });
                        break;
                    case 12:
                        k kVar4 = k.this;
                        kVar4.a2(kVar4.f13787b, this.f13959b);
                        break;
                    case 13:
                        k kVar5 = k.this;
                        m mVar5 = this.f13959b;
                        kVar5.c2(mVar5.f13984d, mVar5.f13981a);
                        break;
                    case 14:
                        m mVar6 = this.f13959b;
                        long j11 = mVar6.f13984d;
                        if (j11 >= 0) {
                            k.this.c2(j11, mVar6.f13981a);
                            break;
                        } else {
                            k.this.c2(-1L, mVar6.f13981a);
                            break;
                        }
                    case 15:
                        k kVar6 = k.this;
                        m mVar7 = this.f13959b;
                        kVar6.w1(mVar7.f13984d, mVar7.f13981a);
                        break;
                    case 16:
                        k.this.w1(-1L, this.f13959b.f13981a);
                        break;
                    case 17:
                        ComponentActivity componentActivity4 = k.this.f13787b;
                        if (componentActivity4 != null && com.android.contacts.framework.baseui.util.l.d(componentActivity4, "com.ted.number")) {
                            com.android.contacts.framework.baseui.util.l.f(k.this.f13787b, "com.ted.number", null, 1);
                            k.this.f13942o0.dismiss();
                            return;
                        }
                        String t10 = E0.b.t(k.this.f13787b, this.f13959b.f13982b);
                        Intent intent2 = new Intent(k.this.f13787b, (Class<?>) ErrorRecoveryActivity.class);
                        intent2.putExtra("recognition_name", this.f13959b.f13985e);
                        intent2.putExtra("unknown_number", this.f13959b.f13982b);
                        intent2.putExtra("mark_type", t10);
                        R7.b.d(k.this.f13787b, intent2, R.string.activity_not_found);
                        break;
                        break;
                    case 18:
                        try {
                            ComponentActivity componentActivity5 = k.this.f13787b;
                            if (componentActivity5 instanceof Activity) {
                                String str = C1501d.f36273b;
                                if (com.android.contacts.framework.baseui.util.l.d(componentActivity5, str)) {
                                    com.android.contacts.framework.baseui.util.l.f(k.this.f13787b, str, null, 1);
                                    k.this.f13942o0.dismiss();
                                    return;
                                }
                            }
                            C0792c.l(k.this.f13902C, 6, D7.c.q(k.this.f13787b, Integer.valueOf(this.f13959b.f13987g)));
                            break;
                        } catch (Exception unused) {
                            H7.b.c("CallLogAdapter", "startCallSettingsActivity error!");
                            break;
                        }
                    case 19:
                        com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000303, 200030301, h0.b0(k.this.f13787b), false);
                        m mVar8 = this.f13959b;
                        if (mVar8.f13987g != -1) {
                            try {
                                View view2 = mVar8.f13992l.f14008a;
                                if (view2 != null && (g10 = (G) view2.getTag()) != null && (b10 = g10.b(k.this.f13902C.getActivity())) != null) {
                                    g(b10, this.f13959b.f13994n);
                                    b10.putExtra("dialer_from", "calllog");
                                    C0802m.a(k.this.f13787b, b10);
                                    break;
                                }
                            } catch (Exception unused2) {
                                H7.b.c("CallLogAdapter", "use_another_sima_card_to_call error!");
                                break;
                            }
                        } else {
                            Intent intent3 = new Intent(C0421a.f6395a, Uri.fromParts("tel", this.f13959b.f13982b, null));
                            intent3.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                            intent3.putExtra("countryiso", this.f13959b.f13991k);
                            g(intent3, this.f13959b.f13994n);
                            intent3.putExtra("dialer_from", "calllog");
                            C0802m.a(k.this.f13787b, intent3);
                            break;
                        }
                        break;
                    case 20:
                        if (C1643c.w() && !TextUtils.isEmpty(this.f13959b.f13982b) && (N10 = C1643c.N(C0421a.f6395a, this.f13959b.f13982b)) != null) {
                            N10.putExtra("dialer_from", "calllog");
                            C0802m.a(k.this.f13787b, N10);
                            com.android.contacts.framework.baseui.util.A.a(k.this.f13787b, 2000319, 200030176, h0.b0(k.this.f13787b), false);
                            break;
                        }
                        break;
                    case 21:
                        k.this.f13902C.f17430j.j(k.this.f13787b, this.f13959b.f13985e, D7.c.q(k.this.f13787b, Integer.valueOf(this.f13959b.f13987g)), 0);
                        h0.Y(0);
                        break;
                }
                k.this.f13942o0.dismiss();
            }
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f13961a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13962b;

        public e(long j10, ArrayList arrayList) {
            this.f13961a = j10;
            this.f13962b = arrayList;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            k.this.w0(this.f13961a, this.f13962b);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f13964a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13965b;

        public f(long j10, ArrayList arrayList) {
            this.f13964a = j10;
            this.f13965b = arrayList;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            k.this.x0(this.f13964a, this.f13965b);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class g implements CallLogDeleteHelper.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13967a;

        public g(ArrayList arrayList) {
            this.f13967a = arrayList;
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void a(Dialog dialog) {
            U0.n.d(dialog);
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void onClick(int i10, boolean z10) {
            k.this.N0(this.f13967a, z10);
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class h implements n {
        public h() {
        }

        @Override // com.android.contacts.calllog.k.n
        public void a(ArrayList<String> arrayList) {
            if (arrayList != null) {
                k.this.L0(arrayList);
            }
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class i implements M.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13970a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13971b;

        public i(int i10, int i11) {
            this.f13970a = i10;
            this.f13971b = i11;
        }

        @Override // com.customize.contacts.util.M.e
        public void onClick(View view) {
            k.this.f13939n.onItemClick(view, ((Integer) view.getTag(this.f13970a)).intValue(), this.f13971b);
        }

        @Override // com.customize.contacts.util.M.e
        public void onLongClick(View view, int i10, int i11) {
            if (!C7.a.a()) {
                k.this.V1(false);
                int intValue = ((Integer) view.getTag(this.f13970a)).intValue();
                if (this.f13970a == R.id.call_log_item_position) {
                    k kVar = k.this;
                    kVar.W0(kVar.f13902C.s4(), view, intValue, i10, i11);
                } else {
                    k kVar2 = k.this;
                    kVar2.X0(kVar2.f13902C.s4(), view, intValue, i10, i11);
                }
            }
        }

        @Override // com.customize.contacts.util.M.e
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public interface j {
        int b1();

        void h();

        void i();

        void onItemClick(View view, int i10, int i11);
    }

    /* compiled from: CallLogAdapter.java */
    /* renamed from: com.android.contacts.calllog.k$k, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class HandlerC0158k extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f13973a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<k> f13974b;

        public HandlerC0158k(Activity activity, k kVar) {
            this.f13973a = new WeakReference<>(activity);
            this.f13974b = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.f13974b.get();
            Activity activity = this.f13973a.get();
            if (activity != null && kVar != null && !activity.isFinishing() && !activity.isDestroyed()) {
                int i10 = message.what;
                if (i10 != 1) {
                    if (i10 == 5) {
                        kVar.Z1((m) message.obj, true);
                        return;
                    } else {
                        if (i10 == 6) {
                            kVar.Z1((m) message.obj, false);
                            return;
                        }
                        return;
                    }
                }
                if (!kVar.f13926a0) {
                    kVar.f13911L = false;
                    kVar.D();
                } else {
                    kVar.f13911L = true;
                }
            }
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public static class l extends AsyncTask<Void, ArrayList<String>, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<Q0.b> f13975a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f13976b;

        /* renamed from: c, reason: collision with root package name */
        public final ComponentActivity f13977c;

        /* renamed from: d, reason: collision with root package name */
        public final n f13978d;

        /* renamed from: e, reason: collision with root package name */
        public final com.android.contacts.detail.D f13979e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList<String> f13980f;

        public l(ComponentActivity componentActivity, ArrayList<Q0.b> arrayList, boolean z10, n nVar, com.android.contacts.detail.D d10) {
            ArrayList<Q0.b> arrayList2 = new ArrayList<>();
            this.f13975a = arrayList2;
            this.f13980f = new ArrayList<>();
            this.f13977c = componentActivity;
            arrayList2.addAll(arrayList);
            this.f13976b = z10;
            this.f13978d = nVar;
            this.f13979e = d10;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            if (this.f13978d != null && !this.f13975a.isEmpty()) {
                Iterator<Q0.b> it = this.f13975a.iterator();
                while (it.hasNext()) {
                    Q0.b next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.d())) {
                        this.f13980f.add(next.d());
                    }
                }
            }
            return Integer.valueOf(CallLogDeleteHelper.f(this.f13977c, this.f13975a, this.f13976b, this.f13979e, null));
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() > 0) {
                B3.c.d().h();
            }
            n nVar = this.f13978d;
            if (nVar != null) {
                nVar.a(this.f13980f);
            }
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<String> f13981a;

        /* renamed from: b, reason: collision with root package name */
        public String f13982b;

        /* renamed from: c, reason: collision with root package name */
        public int f13983c;

        /* renamed from: d, reason: collision with root package name */
        public long f13984d;

        /* renamed from: e, reason: collision with root package name */
        public String f13985e;

        /* renamed from: f, reason: collision with root package name */
        public String f13986f;

        /* renamed from: g, reason: collision with root package name */
        public int f13987g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13988h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f13989i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f13990j;

        /* renamed from: k, reason: collision with root package name */
        public String f13991k;

        /* renamed from: l, reason: collision with root package name */
        public com.android.contacts.calllog.o f13992l;

        /* renamed from: m, reason: collision with root package name */
        public String f13993m;

        /* renamed from: n, reason: collision with root package name */
        public int f13994n;

        /* renamed from: o, reason: collision with root package name */
        public View f13995o;

        /* renamed from: p, reason: collision with root package name */
        public int f13996p;

        /* renamed from: q, reason: collision with root package name */
        public int f13997q;

        /* renamed from: r, reason: collision with root package name */
        public long f13998r;

        /* renamed from: s, reason: collision with root package name */
        public ViewGroup f13999s;

        /* renamed from: t, reason: collision with root package name */
        public int f14000t;

        /* renamed from: u, reason: collision with root package name */
        public String f14001u;

        public m(ViewGroup viewGroup, View view, com.android.contacts.calllog.o oVar, ArrayList<String> arrayList, String str, int i10, long j10, String str2, String str3, int i11, boolean z10, boolean z11, boolean z12, String str4, String str5, int i12, int i13, int i14, long j11, int i15, String str6) {
            this.f13999s = viewGroup;
            this.f13995o = view;
            this.f13992l = oVar;
            this.f13981a = arrayList;
            this.f13982b = str;
            this.f13983c = i10;
            this.f13984d = j10;
            this.f13985e = str2;
            this.f13986f = str3;
            this.f13987g = i11;
            this.f13988h = z10;
            this.f13989i = z11;
            this.f13990j = z12;
            this.f13991k = str4;
            this.f13993m = str5;
            this.f13994n = i12;
            this.f13996p = i13;
            this.f13997q = i14;
            this.f13998r = j11;
            this.f14000t = i15;
            this.f14001u = str6;
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public interface o {
        boolean a(G g10);
    }

    public k(ComponentActivity componentActivity, j jVar, A a10, HashMap<String, String> hashMap, int i10, Z3.f fVar) {
        super(componentActivity);
        this.f13947r = new ArrayList<>();
        this.f13950x = new GregorianCalendar();
        this.f13951y = AppMetaFeatures.b();
        this.f13912M = "";
        boolean z10 = false;
        this.f13913N = false;
        this.f13914O = false;
        this.f13924Y = new HashMap<>();
        this.f13925Z = null;
        this.f13926a0 = false;
        this.f13927b0 = false;
        this.f13928c0 = true;
        this.f13929d0 = true;
        this.f13930e0 = false;
        this.f13931f0 = false;
        this.f13932g0 = null;
        this.f13933h0 = false;
        this.f13937l0 = -1;
        this.f13938m0 = -1;
        this.f13940n0 = -1;
        this.f13946q0 = null;
        a aVar = new a();
        this.f13948r0 = aVar;
        LocationUtils.a aVar2 = new LocationUtils.a() { // from class: com.android.contacts.calllog.a
            @Override // com.android.contacts.framework.baseui.util.LocationUtils.a
            public final void a(String str) {
                k.this.k1(str);
            }
        };
        this.f13949s0 = aVar2;
        this.f13941o = LocationUtils.g();
        LocationUtils.e(aVar2);
        this.f13906G = fVar;
        this.f13905F = new HandlerC0158k(componentActivity, this);
        this.f13939n = jVar;
        this.f13902C = (ViewOnClickListenerC0694u0) jVar;
        I i11 = new I(componentActivity);
        this.f13943p = i11;
        this.f13907H = new T0(this.f13787b, i11);
        this.f13909J = com.android.contacts.framework.baseui.util.w.e();
        this.f13921V = hashMap;
        this.f13910K = i10;
        z zVar = new z(this.f13787b, a10, aVar);
        this.f13945q = zVar;
        zVar.v(this.f13909J);
        int dimensionPixelSize = this.f13787b.getResources().getDimensionPixelSize(R.dimen.dialpad_location_view_max_width);
        this.f13900A = dimensionPixelSize;
        this.f13901B = dimensionPixelSize;
        this.f13915P = com.android.contacts.framework.baseui.util.r.a(componentActivity);
        f13899u0 = this.f13787b.getColor(R.color.coui_preference_secondary_text_color);
        this.f13952z = this.f13787b.getColor(R.color.coui_preference_title_color);
        HandlerThread handlerThread = new HandlerThread("more_thread");
        this.f13904E = handlerThread;
        handlerThread.start();
        this.f13903D = new Handler(handlerThread.getLooper());
        this.f13908I = false;
        f13898t0 = G0.c.f(componentActivity, 1, R0.c.f3191i, -1L);
        if (CommonOSPublicFeature.f() && com.android.contacts.framework.api.satellite.a.b()) {
            z10 = true;
        }
        this.f13944p0 = z10;
    }

    public static void O0(Context context, Intent intent, int i10) {
        HashMap hashMap = new HashMap();
        long f10 = C7.e.f(intent, "person_id", -1L);
        if (f10 > 0) {
            hashMap.put("call_number_type", 0);
        } else if (f10 == 0) {
            hashMap.put("call_number_type", 1);
        } else {
            hashMap.put("call_number_type", 2);
        }
        hashMap.put("dialpad_input_count", Integer.valueOf(i10));
        hashMap.put("call_number_position", Integer.valueOf(C7.e.d(intent, "position", -1)));
        hashMap.put("state", Integer.valueOf(C7.e.d(intent, "state", -1)));
        hashMap.put("start_position", Integer.valueOf(C7.e.d(intent, "start_position", -1)));
        hashMap.put("search_type", Integer.valueOf(C7.e.d(intent, "search_type", -1)));
        com.android.contacts.framework.baseui.util.A.a(context, 2000307, 200030034, hashMap, false);
    }

    public static boolean c1(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (str.charAt(i10) == ' ') {
                return true;
            }
        }
        return false;
    }

    public static View e1(LayoutInflater layoutInflater, boolean z10) {
        return layoutInflater.inflate(F.t(z10), (ViewGroup) null, false);
    }

    public static boolean i1(String str, String str2) {
        boolean z10;
        if (B3.a.u() && com.customize.contacts.util.J.n(str2) && E0.b.y(str)) {
            z10 = !TextUtils.isEmpty(E0.b.u(str));
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("CallLogAdapter", "isServiceNumberWithName: number: " + H7.a.d(str) + ", hasRecog: " + str2 + ", result: " + z10);
        }
        return z10;
    }

    public static /* synthetic */ void q1(Context context, m mVar) {
        N3.b.q(context, mVar.f13984d, mVar.f13981a);
    }

    public final void A0(TextView textView, String str) {
        E3.o oVar = this.f13923X;
        if (oVar != null) {
            oVar.e(textView, str);
        }
    }

    public void A1(E3.c cVar) {
        this.f13925Z = cVar;
    }

    public final void B0(E3.s sVar) {
        if (!TextUtils.isEmpty(sVar.f684j) && this.f13922W != null) {
            if (!TextUtils.isEmpty(sVar.f682h) && sVar.f678d != null && LocationUtils.l() && TextUtils.equals(this.f13941o, sVar.f678d.b())) {
                sVar.a().setText(sVar.f682h);
            } else {
                this.f13922W.q(sVar);
            }
        }
    }

    public void B1(boolean z10) {
        this.f13789d = z10;
    }

    public final void C0(TextView textView, String str, String str2, int i10, int i11) {
        E3.s sVar = new E3.s(textView);
        sVar.f684j = str;
        sVar.f681g = str2;
        sVar.f683i = false;
        sVar.f682h = null;
        sVar.f680f = i10;
        sVar.f679e = i11;
        sVar.f678d = null;
        sVar.f677c = false;
        B0(sVar);
    }

    public void C1(HashMap<String, CheckBox> hashMap) {
        this.f13924Y = hashMap;
    }

    public final void D0(ImageView imageView, G g10, String str, String str2, int i10) {
        boolean z10;
        boolean a10 = I.a(str2);
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        imageView.setTag(g10);
        imageView.setOnClickListener(this);
        imageView.setContentDescription(this.f13787b.getString(R.string.oplus_call_detail_description, Q0(str, str2)));
        if (z10) {
            imageView.setContentDescription(this.f13787b.getResources().getString(R.string.description_call_log_play_button));
            return;
        }
        if (a10) {
            imageView.setEnabled(true);
            return;
        }
        imageView.setEnabled(false);
        if ((B3.a.f0() && I.i(str2)) || (B3.a.D() && I.h(str2))) {
            imageView.setEnabled(true);
        }
    }

    public void D1(int i10) {
        this.f13916Q = i10;
    }

    @Override // com.android.contacts.calllog.F
    public void E() {
        if (this.f13927b0) {
            H7.b.e("CallLogAdapter", "mStopped is true, return");
        } else {
            this.f13939n.h();
        }
    }

    public final void E0(F.c cVar, int i10, boolean z10) {
        if (C1643c.w()) {
            ViewStub viewStub = (ViewStub) cVar.itemView.findViewById(R.id.ust_icon_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            C1643c.g((ImageView) cVar.itemView.findViewById(R.id.rtt_icon), (ImageView) cVar.itemView.findViewById(R.id.verification_icon), i10, z10);
        }
    }

    public void E1(DateFormat dateFormat) {
        this.f13918S = dateFormat;
    }

    public final void F0(F.c cVar, Cursor cursor, int i10, int i11) {
        int length = com.android.contacts.framework.baseui.calllog.d.a().length;
        if (cursor != null && cursor.getColumnCount() == length) {
            cVar.f13801a.f14014g.setPaddingRelative(this.f13787b.getResources().getDimensionPixelSize(R.dimen.DP_41), 0, this.f13787b.getResources().getDimensionPixelSize(R.dimen.DP_16), 0);
            G0(cVar, cursor, i10, i11);
        } else {
            cVar.f13801a.f14014g.setPaddingRelative(0, 0, this.f13787b.getResources().getDimensionPixelSize(R.dimen.DP_16), 0);
            H0(cVar, cursor);
        }
        if (i11 == getItemCount() - 1) {
            cVar.f13801a.f14014g.setVisibility(8);
        } else {
            cVar.f13801a.f14014g.setVisibility(0);
        }
    }

    public void F1(boolean z10) {
        this.f13930e0 = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0472  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G0(com.android.contacts.calllog.F.c r63, android.database.Cursor r64, int r65, int r66) {
        /*
            Method dump skipped, instructions count: 1347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.k.G0(com.android.contacts.calllog.F$c, android.database.Cursor, int, int):void");
    }

    public void G1(boolean z10) {
        this.f13790e = z10;
        this.f13945q.r(z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x00e7, code lost:
    
        if (r2 != (-9999)) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0404  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H0(com.android.contacts.calllog.F.c r43, android.database.Cursor r44) {
        /*
            Method dump skipped, instructions count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.k.H0(com.android.contacts.calllog.F$c, android.database.Cursor):void");
    }

    public final void H1(View view, int i10, int i11, int i12) {
        view.setTag(i10, Integer.valueOf(i11));
        M.d(view, g1(), new i(i10, i12));
    }

    public void I0(Cursor cursor) {
        j(cursor, null);
    }

    public void I1(E3.o oVar) {
        this.f13923X = oVar;
    }

    public final void J0(ComponentActivity componentActivity, m mVar) {
        Q0.b p10 = p(com.android.contacts.framework.baseui.calllog.c.a(mVar.f13982b, mVar.f13986f, mVar.f13991k));
        if (p10 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(p10);
            CallLogDeleteHelper.h(componentActivity, arrayList, arrayList.size(), getItemCount(), new g(arrayList));
        }
    }

    public void J1(boolean z10) {
        this.f13945q.s(z10);
    }

    public void K0() {
        this.f13945q.j();
    }

    public void K1(boolean z10) {
        this.f13945q.u(z10);
    }

    public void L0(ArrayList<String> arrayList) {
        if (!C0811w.g(arrayList)) {
            this.f13945q.k(arrayList);
        }
    }

    public void L1(boolean z10) {
        this.f13931f0 = z10;
    }

    public String M0(String str) {
        if (str != null && str.length() != 0) {
            String trim = str.trim();
            StringBuilder sb = new StringBuilder();
            char[] charArray = trim.toCharArray();
            for (int i10 = 0; i10 < charArray.length; i10++) {
                if (charArray[i10] == ' ' && charArray[i10 + 1] == ' ') {
                    charArray[i10] = '$';
                }
            }
            for (char c10 : charArray) {
                if (c10 != '$') {
                    sb.append(c10);
                }
            }
            return sb.toString();
        }
        return null;
    }

    public void M1(o oVar) {
        this.f13932g0 = oVar;
    }

    public final void N0(ArrayList<Q0.b> arrayList, boolean z10) {
        new l(this.f13787b, arrayList, z10, new h(), new com.android.contacts.detail.D(1, 1, null)).b();
    }

    public void N1(boolean z10) {
        this.f13926a0 = z10;
        if (this.f13911L && !z10) {
            this.f13905F.sendEmptyMessage(1);
        }
    }

    public void O1(E3.q qVar) {
        this.f13922W = qVar;
    }

    public final y P0(Cursor cursor, String str, long j10, long j11, int i10, String str2, String str3, String str4, String str5, F0.a aVar) {
        y yVar = new y();
        yVar.f14057b = U7.g.b(cursor.getString(8));
        yVar.f14058c = str4;
        if (str3 != null) {
            str = str3;
        }
        yVar.f14061f = str;
        yVar.f14066k = cursor.getLong(10);
        yVar.f14067l = U7.g.b(cursor.getString(14));
        yVar.f14062g = str2;
        yVar.f14068m = j11;
        yVar.f14069n = cursor.getInt(13);
        yVar.f14070o = j10;
        yVar.f14071p = i10;
        yVar.f14074s = str5;
        yVar.f14075t = cursor.getString(17);
        yVar.f14077v = cursor.getString(18);
        yVar.f14055A = aVar;
        return yVar;
    }

    public void P1(boolean z10) {
        this.f13914O = z10;
    }

    public final String Q0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                sb.append(charAt);
                if (charAt >= '0' && charAt <= '9') {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        return str;
    }

    public void Q1(boolean z10) {
        this.f13928c0 = z10;
    }

    public final String R0(y yVar, String str, String str2, String str3, boolean[] zArr) {
        boolean z10;
        boolean z11;
        Uri uri = yVar.f14057b;
        String str4 = yVar.f14065j;
        if (!TextUtils.isEmpty(yVar.f14058c)) {
            str2 = yVar.a();
        }
        if (yVar.f14078w) {
            return str2;
        }
        if (uri == null) {
            if (this.f13909J.c(str4)) {
                if (this.f13909J.d(str4) != null) {
                    str2 = this.f13909J.d(str4).a();
                    yVar.f14066k = this.f13909J.d(str4).b();
                }
            } else if (this.f13909J.c(str)) {
                if (this.f13909J.d(str) != null) {
                    str2 = this.f13909J.d(str).a();
                    yVar.f14066k = this.f13909J.d(str).b();
                }
            }
            z10 = true;
            if (z10 && B3.a.u() && com.customize.contacts.util.J.n(str3) && uri == null && E0.b.y(str)) {
                str2 = E0.b.u(str);
                z11 = !TextUtils.isEmpty(str2);
            } else {
                z11 = false;
            }
            if (zArr != null && zArr.length == 2) {
                zArr[0] = z10;
                zArr[1] = z11;
            }
            if (TextUtils.isEmpty(str2) && yVar.f14072q) {
                str2 = this.f13787b.getResources().getString(R.string.oplus_calllog_emergency_number);
            }
            if (!B3.a.K() && TextUtils.isEmpty(str2)) {
                return yVar.f14077v;
            }
        }
        z10 = false;
        if (z10) {
        }
        z11 = false;
        if (zArr != null) {
            zArr[0] = z10;
            zArr[1] = z11;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f13787b.getResources().getString(R.string.oplus_calllog_emergency_number);
        }
        return !B3.a.K() ? str2 : str2;
    }

    public void R1(boolean z10) {
        this.f13929d0 = z10;
    }

    public final String S0() {
        String l42 = this.f13902C.l4();
        if (l42.contains(" ")) {
            l42 = U7.f.f(l42);
        }
        if (l42.contains("-")) {
            l42 = l42.replace("-", "");
        }
        if (l42.contains("(")) {
            l42 = l42.replace("(", "");
        }
        if (l42.contains(")")) {
            return l42.replace(")", "");
        }
        return l42;
    }

    public void S1(com.android.contacts.framework.baseui.util.w wVar) {
        this.f13909J = wVar;
        this.f13945q.v(wVar);
    }

    public final Intent T0(View view) {
        try {
            G g10 = (G) view.getTag();
            if (g10 == null) {
                return null;
            }
            return g10.b(this.f13787b);
        } catch (Exception e10) {
            H7.b.c("CallLogAdapter", "getIntentFromViewTag: Exception: " + e10);
            return null;
        }
    }

    public void T1(boolean z10) {
        this.f13927b0 = z10;
    }

    public I U0() {
        return this.f13943p;
    }

    public void U1(DateFormat dateFormat) {
        this.f13917R = dateFormat;
    }

    public final Intent V0(Intent intent) {
        if (intent == null) {
            return null;
        }
        long f10 = C7.e.f(intent, "person_id", -1L);
        if (f10 > 0) {
            String l10 = C7.e.l(intent, "number");
            String l11 = C7.e.l(intent, "countryiso");
            Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, f10);
            Intent intent2 = new Intent(this.f13787b, (Class<?>) CallDetailActivity.class);
            intent2.setData(withAppendedId);
            intent2.putExtra("number", l10);
            intent2.putExtra("countryiso", l11);
            return intent2;
        }
        return intent;
    }

    public final void V1(boolean z10) {
        FragmentActivity activity = this.f13902C.getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).g3(z10);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:(2:(1:72)(1:93)|73)(6:94|(3:96|(1:98)(1:100)|99)|101|76|77|(5:79|80|81|82|83))|74|76|77|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0189, code lost:
    
        if (android.text.TextUtils.isEmpty(r30.f14058c) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0102, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0103, code lost:
    
        r22 = "CallLogAdapter";
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00c3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c4, code lost:
    
        r6 = r5;
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00cb, code lost:
    
        H7.b.b("CallLogAdapter", "e = " + r0);
        r21 = r5;
        r0 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a0 A[Catch: Exception -> 0x0191, TryCatch #6 {Exception -> 0x0191, blocks: (B:32:0x0175, B:36:0x01ed, B:39:0x0183, B:45:0x0194, B:47:0x01a0, B:48:0x01c1, B:51:0x01e6, B:57:0x01b8, B:58:0x01b4), top: B:22:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e6 A[Catch: Exception -> 0x0191, TryCatch #6 {Exception -> 0x0191, blocks: (B:32:0x0175, B:36:0x01ed, B:39:0x0183, B:45:0x0194, B:47:0x01a0, B:48:0x01c1, B:51:0x01e6, B:57:0x01b8, B:58:0x01b4), top: B:22:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c1  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W0(android.view.ViewGroup r33, android.view.View r34, int r35, int r36, int r37) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.k.W0(android.view.ViewGroup, android.view.View, int, int, int):void");
    }

    public final void W1(Context context, final m mVar) {
        if (this.f13787b instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(context, str)) {
                com.android.contacts.framework.baseui.util.l.f(context, str, null, 1);
                return;
            }
        }
        COUIAlertDialogBuilder neutralButton = new U0.b(context, 2132083073).setTitle(R.string.oplus_add_contacts_to_vip).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.add, new DialogInterface.OnClickListener() { // from class: com.android.contacts.calllog.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                k.this.m1(mVar, dialogInterface, i10);
            }
        });
        if (B3.a.c0()) {
            if (OSPublicFeature.F()) {
                neutralButton.setMessage(R.string.oplus_add_contacts_to_vip_tips_for_drive_mode_v2);
            } else {
                neutralButton.setMessage(R.string.oplus_add_contacts_to_vip_tips_without_vibrate_for_drive_mode_v2);
            }
        }
        U0.n.b(neutralButton.show());
    }

    public void X0(final ViewGroup viewGroup, final View view, int i10, final int i11, final int i12) {
        final Cursor q10 = q();
        if (q10 != null && !q10.isClosed()) {
            if (i10 < q10.getCount()) {
                q10.moveToPosition(i10);
            } else {
                q10.moveToFirst();
            }
            CancellationSignal cancellationSignal = this.f13920U;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
            this.f13920U = new CancellationSignal();
            this.f13903D.post(new Runnable() { // from class: com.android.contacts.calllog.d
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.j1(q10, viewGroup, view, i11, i12);
                }
            });
            return;
        }
        H7.b.b("CallLogAdapter", "handleItemLongClick return");
    }

    public final void X1(final Context context, final m mVar, final int i10) {
        int i11;
        ComponentActivity componentActivity = this.f13787b;
        if (componentActivity instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(componentActivity, str)) {
                com.android.contacts.framework.baseui.util.l.f(this.f13787b, str, null, 1);
                return;
            }
        }
        if (i10 == 7) {
            i11 = R.string.dialog_title_remove_number_blacklist;
        } else {
            i11 = R.string.dialog_title_remove_blacklist;
        }
        U0.n.b(new U0.b(context, 2132083073).setTitle(i11).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton((CharSequence) context.getString(R.string.remove), new DialogInterface.OnClickListener() { // from class: com.android.contacts.calllog.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                k.this.n1(i10, mVar, context, dialogInterface, i12);
            }
        }).show());
    }

    public final void Y0(HighLightView highLightView, String str, String str2, String str3) {
        if (str3 == null) {
            return;
        }
        String M02 = M0(str);
        if (!TextUtils.isEmpty(M02)) {
            String[] split = M02.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < split.length - 1; i10++) {
                sb.append(split[i10].toCharArray()[0]);
            }
            sb.append(split[split.length - 1].toCharArray()[0]);
            int indexOf = HighLightView.c(sb.toString()).indexOf(str3);
            if (indexOf != -1) {
                this.f13947r.clear();
                for (String str4 : split) {
                    this.f13947r.add(new SpannableStringBuilder(str4));
                }
                if (str3.length() != 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (str3.length() > split.length) {
                        if (indexOf == split.length - 1) {
                            for (int i11 = 0; i11 < indexOf; i11++) {
                                spannableStringBuilder.append((CharSequence) this.f13947r.get(i11));
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                            this.f13947r.get(indexOf).setSpan(new ForegroundColorSpan(this.f13915P), 0, str3.length(), 33);
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(indexOf));
                            highLightView.setText(spannableStringBuilder);
                        } else if (indexOf == 0) {
                            for (int i12 = 0; i12 < split.length - 1; i12++) {
                                this.f13947r.get(i12).setSpan(new ForegroundColorSpan(this.f13915P), 0, 1, 33);
                                spannableStringBuilder.append((CharSequence) this.f13947r.get(i12));
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                            this.f13947r.get(split.length - 1).setSpan(new ForegroundColorSpan(this.f13915P), 0, (str3.length() - split.length) + 1, 33);
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(split.length - 1));
                            highLightView.setText(spannableStringBuilder);
                        } else {
                            highLightView.f15044a = false;
                            b1(highLightView, str, str2, str3);
                        }
                    } else if (indexOf == 0) {
                        for (int i13 = 0; i13 < str3.length(); i13++) {
                            this.f13947r.get(i13).setSpan(new ForegroundColorSpan(this.f13915P), 0, 1, 33);
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(i13));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        for (int length = str3.length(); length < split.length; length++) {
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(length));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        highLightView.setText(spannableStringBuilder);
                    } else if (indexOf == split.length - 1) {
                        for (int i14 = 0; i14 < indexOf; i14++) {
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(i14));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        this.f13947r.get(indexOf).setSpan(new ForegroundColorSpan(this.f13915P), 0, str3.length(), 33);
                        spannableStringBuilder.append((CharSequence) this.f13947r.get(indexOf));
                        highLightView.setText(spannableStringBuilder);
                    } else {
                        for (int i15 = 0; i15 < str3.length(); i15++) {
                            if (indexOf < this.f13947r.size()) {
                                this.f13947r.get(indexOf).setSpan(new ForegroundColorSpan(this.f13915P), 0, 1, 33);
                                indexOf++;
                            } else {
                                ArrayList<SpannableStringBuilder> arrayList = this.f13947r;
                                arrayList.get(arrayList.size() - 1).setSpan(new ForegroundColorSpan(this.f13915P), 0, (str3.length() - i15) + 1, 33);
                            }
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(i15));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        for (int length2 = str3.length(); length2 < split.length; length2++) {
                            spannableStringBuilder.append((CharSequence) this.f13947r.get(length2));
                            spannableStringBuilder.append((CharSequence) " ");
                        }
                        highLightView.setText(spannableStringBuilder);
                    }
                    this.f13947r.clear();
                    spannableStringBuilder.clear();
                    return;
                }
                return;
            }
            highLightView.f15044a = false;
            b1(highLightView, str, str2, str3);
        }
    }

    public final void Y1(final ViewGroup viewGroup, final View view, final com.android.contacts.calllog.o oVar, final String str, final int i10, final long j10, final String str2, final String str3, final int i11, final boolean z10, final String str4, final String str5, final int i12, final int i13, final int i14, final long j11, final int i15, final String str6) {
        CancellationSignal cancellationSignal = this.f13920U;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        final boolean a10 = PrimaryUserUtils.a();
        if (I.a(str) && (a10 || j10 > 0)) {
            this.f13920U = new CancellationSignal();
            this.f13903D.post(new Runnable() { // from class: com.android.contacts.calllog.e
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.o1(j10, str, a10, viewGroup, view, oVar, i10, str2, str3, i11, z10, str4, str5, i12, i13, i14, j11, i15, str6);
                }
            });
        } else {
            this.f13905F.removeMessages(5);
            Handler handler = this.f13905F;
            handler.sendMessage(Message.obtain(handler, 5, new m(viewGroup, view, oVar, new ArrayList(), str, i10, j10, str2, str3, i11, false, z10, false, str4, str5, i12, i13, i14, j11, i15, str6)));
        }
    }

    public void Z0(HighLightView highLightView, HighLightNumber highLightNumber, String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            try {
                if (this.f13916Q != 1 && str3.length() >= 1 && str.matches("^[a-zA-Z0-9 ,]*") && c1(str)) {
                    highLightView.f15044a = true;
                    Y0(highLightView, str, str2, str3);
                } else {
                    highLightView.f15044a = false;
                    if (FeatureOption.o()) {
                        highLightView.f15045b = true;
                    }
                    b1(highLightView, str, str2, str3);
                }
            } catch (Exception e10) {
                H7.b.c("CallLogAdapter", "Exception e: " + e10);
            }
            if (highLightNumber == null) {
                return;
            }
            if (highLightView.a()) {
                highLightNumber.setNormalMode(true);
            } else if (FeatureOption.o()) {
                highLightNumber.f14872a = true;
            }
            highLightNumber.setTextPaintColor(f13899u0);
            highLightNumber.setHightTextColor(this.f13915P);
            highLightNumber.d(str2, str3, this.f13916Q);
        }
    }

    public final void Z1(final m mVar, boolean z10) {
        String string;
        String string2;
        String string3;
        String string4;
        int i10;
        String string5;
        String string6;
        Resources resources = this.f13787b.getResources();
        if (this.f13919T == null) {
            this.f13919T = new HashMap<>(20);
        }
        this.f13919T.put(resources.getString(R.string.send_sms), 0);
        this.f13919T.put(resources.getString(R.string.menu_edit_before_dial), 1);
        this.f13919T.put(resources.getString(R.string.InserContacts), 2);
        this.f13919T.put(resources.getString(R.string.add_to_saved_contacts), 3);
        this.f13919T.put(resources.getString(R.string.oplus_intercept_contact), 4);
        this.f13919T.put(resources.getString(R.string.oplus_intercept_number), 5);
        if (mVar.f13984d > 0) {
            this.f13919T.put(resources.getString(R.string.remove_from_blacklist), 6);
        } else {
            this.f13919T.put(resources.getString(R.string.remove_from_blacklist), 7);
        }
        this.f13919T.put(resources.getString(R.string.oplus_mark_unknow_number_title), 8);
        this.f13919T.put(resources.getString(R.string.ted_actionbar_correction_mark), 17);
        this.f13919T.put(resources.getString(R.string.oplus_item_copy), 9);
        this.f13919T.put(resources.getString(R.string.delete_button), 10);
        this.f13919T.put(resources.getString(R.string.oplus_add_contacts_to_vip), 11);
        this.f13919T.put(resources.getString(R.string.oplus_remove_contacts_from_vip), 12);
        this.f13919T.put(resources.getString(R.string.oplus_add_contact_to_whitelist), 13);
        this.f13919T.put(resources.getString(R.string.oplus_add_number_to_whitelist), 14);
        this.f13919T.put(resources.getString(R.string.oplus_remove_contact_from_whitelist), 15);
        this.f13919T.put(resources.getString(R.string.oplus_remove_number_from_whitelist), 16);
        this.f13919T.put(resources.getString(R.string.block_all_this_call_type), 18);
        this.f13919T.put(resources.getString(R.string.oplus_use_sim_x_to_call, mVar.f13993m), 19);
        if (C1643c.w()) {
            this.f13919T.put(resources.getString(R.string.video_call), 20);
        }
        this.f13919T.put(resources.getString(R.string.intercept_special_name_number), 21);
        ArrayList arrayList = new ArrayList(10);
        if (I.a(mVar.f13982b)) {
            boolean h10 = C0637b.h();
            if (!h10) {
                arrayList.add(resources.getString(R.string.oplus_item_copy));
            }
            arrayList.add(resources.getString(R.string.send_sms));
            if (!h10) {
                arrayList.add(resources.getString(R.string.menu_edit_before_dial));
            }
            if (!TextUtils.isEmpty(mVar.f13993m)) {
                arrayList.add(resources.getString(R.string.oplus_use_sim_x_to_call, mVar.f13993m));
            }
            if (TextUtils.isEmpty(mVar.f13985e)) {
                arrayList.add(resources.getString(R.string.InserContacts));
                arrayList.add(resources.getString(R.string.add_to_saved_contacts));
                if (PrimaryUserUtils.a() && !B3.a.p()) {
                    if (C0801l.o(mVar.f13983c)) {
                        if (!mVar.f13988h && mVar.f13990j) {
                            string6 = resources.getString(R.string.oplus_remove_number_from_whitelist);
                        } else {
                            string6 = resources.getString(R.string.oplus_add_number_to_whitelist);
                        }
                        arrayList.add(string6);
                    } else {
                        if (mVar.f13988h) {
                            string5 = resources.getString(R.string.remove_from_blacklist);
                        } else {
                            string5 = resources.getString(R.string.oplus_intercept_number);
                        }
                        arrayList.add(string5);
                    }
                }
                if (PrimaryUserUtils.a() && I.a(mVar.f13982b) && B3.a.Q() && TextUtils.isEmpty(E0.b.t(this.f13787b, mVar.f13982b))) {
                    arrayList.add(resources.getString(R.string.oplus_mark_unknow_number_title));
                }
            } else if (mVar.f13984d > 0) {
                if (mVar.f13989i) {
                    arrayList.add(resources.getString(R.string.oplus_remove_contacts_from_vip));
                } else {
                    if (!FeatureOption.k()) {
                        arrayList.add(resources.getString(R.string.oplus_add_contacts_to_vip));
                    } else if (!c0.u(this.f13787b, mVar.f13984d)) {
                        arrayList.add(resources.getString(R.string.oplus_add_contacts_to_vip));
                    }
                    if (PrimaryUserUtils.a() && !B3.a.p()) {
                        if (C0801l.o(mVar.f13983c)) {
                            if (!mVar.f13988h && mVar.f13990j) {
                                string4 = resources.getString(R.string.oplus_remove_contact_from_whitelist);
                            } else {
                                string4 = resources.getString(R.string.oplus_add_contact_to_whitelist);
                            }
                            arrayList.add(string4);
                        } else {
                            if (mVar.f13988h) {
                                string3 = resources.getString(R.string.remove_from_blacklist);
                            } else {
                                string3 = resources.getString(R.string.oplus_intercept_contact);
                            }
                            arrayList.add(string3);
                        }
                    }
                }
            } else if (PrimaryUserUtils.a() && !B3.a.p()) {
                if (C0801l.o(mVar.f13983c)) {
                    if (mVar.f13990j) {
                        string2 = resources.getString(R.string.oplus_remove_number_from_whitelist);
                    } else {
                        string2 = resources.getString(R.string.oplus_add_number_to_whitelist);
                    }
                    arrayList.add(string2);
                } else {
                    if (mVar.f13988h) {
                        string = resources.getString(R.string.remove_from_blacklist);
                    } else {
                        string = resources.getString(R.string.oplus_intercept_contact);
                    }
                    arrayList.add(string);
                }
                if (BlackListUtils.q()) {
                    arrayList.add(resources.getString(R.string.intercept_special_name_number));
                }
            }
            if (C1643c.w() && !TextUtils.isEmpty(mVar.f13982b) && this.f13933h0) {
                arrayList.add(resources.getString(R.string.video_call));
            }
            if (!TextUtils.isEmpty(mVar.f13982b)) {
                i10 = E0.b.o(mVar.f13982b);
            } else {
                i10 = 0;
            }
            try {
                int q10 = D7.c.q(this.f13787b, Integer.valueOf(mVar.f13987g));
                if (PrimaryUserUtils.a() && com.customize.contacts.util.J.r(this.f13787b, i10, q10) && TextUtils.isEmpty(mVar.f13985e)) {
                    arrayList.add(resources.getString(R.string.block_all_this_call_type));
                }
            } catch (Exception unused) {
                H7.b.c("CallLogAdapter", "startCallSettingsActivity error!");
            }
        }
        if (z10) {
            arrayList.add(resources.getString(R.string.delete_button));
        }
        this.f13942o0 = new COUIPopupListWindow(this.f13787b);
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.add(com.android.contacts.framework.baseui.util.q.a((String) arrayList.get(i11)));
        }
        this.f13942o0.setItemList(arrayList2);
        this.f13942o0.setDismissTouchOutside(true);
        this.f13942o0.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.android.contacts.calllog.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                k.this.p1(mVar);
            }
        });
        this.f13942o0.setOnItemClickListener(new d(arrayList, mVar));
        mVar.f13995o.setTag(R.id.list_item_long_clicked, Boolean.TRUE);
        mVar.f13995o.setBackgroundColor(com.android.contacts.framework.baseui.util.r.b(this.f13787b));
        this.f13942o0.show(mVar.f13995o, mVar.f13996p, mVar.f13997q);
        ViewGroup viewGroup = mVar.f13999s;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        Z3.j.b(this.f13942o0);
        V1(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:6:0x0014, B:8:0x001f, B:10:0x0027, B:12:0x003a, B:15:0x0048, B:20:0x0044, B:23:0x005b, B:25:0x006d, B:27:0x0073, B:32:0x00cc, B:34:0x00d6, B:46:0x0083, B:48:0x008b, B:52:0x0099, B:54:0x009d, B:59:0x00a4, B:61:0x00b4, B:63:0x00ba, B:67:0x00c3, B:39:0x00dd, B:41:0x00e3), top: B:5:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a1(com.android.contacts.dialpad.view.HighLightView r17, java.lang.String r18, int[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.k.a1(com.android.contacts.dialpad.view.HighLightView, java.lang.String, int[], int):void");
    }

    public final void a2(final Context context, final m mVar) {
        U0.n.b(new U0.b(context, 2132083073).setTitle(R.string.oplus_remove_contacts_from_vip_v2).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.remove, new DialogInterface.OnClickListener() { // from class: com.android.contacts.calllog.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                k.this.r1(context, mVar, dialogInterface, i10);
            }
        }).show());
    }

    public final void b1(HighLightView highLightView, String str, String str2, String str3) {
        highLightView.setTextPaintColor(this.f13952z);
        highLightView.setHightTextColor(this.f13915P);
        highLightView.q(str2, str, str3, this.f13916Q);
    }

    public final void b2(long j10, ArrayList<String> arrayList) {
        int i10;
        int i11;
        ComponentActivity componentActivity = this.f13787b;
        if (componentActivity instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(componentActivity, str)) {
                com.android.contacts.framework.baseui.util.l.f(this.f13787b, str, null, 1);
                return;
            }
        }
        if (B3.a.A()) {
            if (B3.a.Y()) {
                i10 = R.string.intercept_number_use_third_mms_tips_v2;
            } else {
                i10 = R.string.intercept_number_except_mms_tips_v2;
            }
        } else {
            i10 = R.string.intercept_number_tips_v2;
        }
        if (j10 > 0) {
            boolean A10 = B3.a.A();
            i11 = R.string.dialog_title_add_blacklist;
            if (A10) {
                if (B3.a.Y()) {
                    i10 = R.string.intercept_contact_use_third_mms_tips_v2;
                } else {
                    i10 = R.string.intercept_contact_except_mms_tips_v2;
                }
            } else {
                i10 = R.string.intercept_contact_tips_v2;
            }
        } else {
            i11 = R.string.dialog_title_add_number_blacklist;
        }
        U0.n.b(new U0.b(this.f13787b, 2132083073).setTitle(i11).setMessage(i10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.add, (DialogInterface.OnClickListener) new e(j10, arrayList)).show());
    }

    public final void c2(long j10, ArrayList<String> arrayList) {
        int i10;
        int i11;
        ComponentActivity componentActivity = this.f13787b;
        if (componentActivity instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(componentActivity, str)) {
                com.android.contacts.framework.baseui.util.l.f(this.f13787b, str, null, 1);
                return;
            }
        }
        if (B3.a.A()) {
            i10 = R.string.oplus_intercept_number_whitelist_except_mms_tips_v2;
        } else {
            i10 = R.string.oplus_intercept_number_whitelist_tips_v2;
        }
        if (j10 > 0) {
            boolean A10 = B3.a.A();
            i11 = R.string.dialog_title_add_whitelist;
            if (A10) {
                i10 = R.string.oplus_insert_contact_whitelist_except_mms_tips_v2;
            } else {
                i10 = R.string.oplus_insert_contact_whitelist_tips_v2;
            }
        } else {
            i11 = R.string.dialog_title_add_number_whitelist;
        }
        U0.n.b(new U0.b(this.f13787b, 2132083073).setTitle(i11).setMessage(i10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.add, (DialogInterface.OnClickListener) new f(j10, arrayList)).show());
    }

    public void d1() {
        ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f13902C;
        if (viewOnClickListenerC0694u0 instanceof DialtactsUnfoldFragment) {
            this.f13946q0 = (List) Objects.requireNonNullElseGet(((DialtactsUnfoldFragment) viewOnClickListenerC0694u0).R8(), new Supplier() { // from class: com.android.contacts.calllog.b
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new ArrayList();
                }
            });
        } else {
            this.f13946q0 = new ArrayList();
        }
    }

    public final void d2(String str) {
        Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("phone", str);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 1);
        }
        R7.b.d(this.f13787b, intent, R.string.activity_not_found);
        if (this.f13902C.isAdded()) {
            C0636a.a(this.f13902C.getActivity());
        }
    }

    public final void e2(String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("phone", str);
        intent.putExtra(R0.c.f3183a, true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 1);
        }
        R7.b.d(this.f13902C.getContext(), intent, R.string.activity_not_found);
    }

    public void f1() {
        this.f13945q.p();
    }

    public void f2(boolean z10) {
        this.f13945q.w(z10);
    }

    public final boolean g1() {
        E3.c cVar = this.f13925Z;
        if (cVar != null && cVar.A()) {
            return true;
        }
        return false;
    }

    public void g2() {
        this.f13945q.y();
    }

    public boolean h1() {
        return this.f13914O;
    }

    public void h2(View view, boolean z10, boolean z11) {
        String str;
        E3.c cVar;
        if (view == null) {
            H7.b.c("CallLogAdapter", "Error: view is null");
            return;
        }
        try {
            G g10 = (G) view.getTag();
            long j10 = 0;
            if (g10 == null) {
                H7.b.c("CallLogAdapter", "intentProvider == null");
                str = this.f13912M;
            } else {
                Intent b10 = g10.b(this.f13787b);
                if (b10 != null) {
                    String l10 = C7.e.l(b10, "number");
                    String l11 = C7.e.l(b10, "matched_number");
                    String l12 = C7.e.l(b10, "countryiso");
                    j10 = C7.e.f(b10, "number_time", 0L);
                    str = com.android.contacts.framework.baseui.calllog.c.a(l10, l11, l12);
                } else {
                    str = "";
                }
            }
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.check_box);
            if (z11) {
                if (this.f13924Y.size() == 0) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(!checkBox.isChecked());
                }
            }
            if (checkBox.isChecked()) {
                if (!this.f13924Y.containsKey(str)) {
                    this.f13924Y.put(str, checkBox);
                }
                u1(str, j10);
            } else {
                this.f13924Y.remove(str);
                x1(str);
            }
            com.android.contacts.util.C.b(view, checkBox.isChecked());
            if (z10 && (cVar = this.f13925Z) != null) {
                cVar.I();
            }
        } catch (ClassCastException e10) {
            H7.b.c("CallLogAdapter", "ClassCastException: " + e10);
        }
    }

    @Override // com.android.contacts.calllog.F
    public void i(F.c cVar, Context context, Cursor cursor, int i10, int i11) {
        F0(cVar, cursor, i10, i11);
    }

    public final void i2(View view, G g10) {
        o oVar = this.f13932g0;
        if (oVar != null) {
            if (g10 != null && oVar.a(g10)) {
                view.setBackgroundColor(com.android.contacts.framework.baseui.util.r.b(this.f13787b));
                return;
            }
            Object tag = view.getTag(R.id.list_item_long_clicked);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                com.android.contacts.framework.baseui.util.E.a(view);
            } else {
                view.setBackgroundResource(R.drawable.select_list_item_background_seletor);
            }
        }
    }

    @Override // com.android.contacts.calllog.F
    public void j(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar) {
        this.f13936k0 = E0.a.d();
        this.f13934i0 = C1641a.l(this.f13787b, FeatureOption.o());
        this.f13935j0 = C0637b.h();
        if (cursor != null) {
            this.f13937l0 = cursor.getColumnIndex("virtual_call_id");
            this.f13938m0 = cursor.getColumnIndex("identify_name");
            this.f13940n0 = cursor.getColumnIndex("oplus_data1");
        } else {
            this.f13937l0 = -1;
            this.f13938m0 = -1;
            this.f13940n0 = -1;
        }
        super.j(cursor, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void j1(android.database.Cursor r30, android.view.ViewGroup r31, android.view.View r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.k.j1(android.database.Cursor, android.view.ViewGroup, android.view.View, int, int):void");
    }

    public void j2(HashMap<String, String> hashMap, int i10) {
        this.f13921V = hashMap;
        this.f13910K = i10;
    }

    public final /* synthetic */ void k1(String str) {
        this.f13941o = str;
        this.f13922W.o();
        D();
    }

    public final /* synthetic */ void l1(m mVar) {
        N3.b.b(this.f13787b, mVar.f13984d, mVar.f13988h, mVar.f13981a);
    }

    public final /* synthetic */ void m1(final m mVar, DialogInterface dialogInterface, int i10) {
        this.f13903D.post(new Runnable() { // from class: com.android.contacts.calllog.j
            @Override // java.lang.Runnable
            public final void run() {
                k.this.l1(mVar);
            }
        });
        dialogInterface.dismiss();
    }

    public final /* synthetic */ void n1(int i10, m mVar, Context context, DialogInterface dialogInterface, int i11) {
        if (i10 == 6) {
            v1(mVar.f13984d, mVar.f13981a);
            com.android.contacts.framework.baseui.util.A.a(context, 2000304, 200030241, null, false);
        } else if (i10 == 7) {
            v1(-1L, mVar.f13981a);
            com.android.contacts.framework.baseui.util.A.a(context, 2000304, 200030241, null, false);
        }
    }

    public final /* synthetic */ void o1(long j10, String str, boolean z10, ViewGroup viewGroup, View view, com.android.contacts.calllog.o oVar, int i10, String str2, String str3, int i11, boolean z11, String str4, String str5, int i12, int i13, int i14, long j11, int i15, String str6) {
        boolean z12;
        boolean z13;
        ArrayList arrayList = new ArrayList();
        if (j10 > 0) {
            try {
                Cursor query = this.f13787b.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id=?", new String[]{String.valueOf(j10)}, null, this.f13920U);
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            arrayList.add(query.getString(0));
                        } finally {
                        }
                    }
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e10) {
                H7.b.c("CallLogAdapter", "exception in query numbers with contactId " + e10);
            }
        } else {
            arrayList.add(str);
        }
        if (this.f13920U.isCanceled()) {
            return;
        }
        if (!z10) {
            H7.b.b("CallLogAdapter", "not primary user, and contact id > 0, no need query black and white list.");
            z12 = false;
            z13 = false;
        } else {
            HashMap<String, Boolean> d10 = BlackListUtils.d(this.f13787b, arrayList);
            Boolean bool = Boolean.TRUE;
            boolean equals = bool.equals(d10.get("isBlackList"));
            z13 = bool.equals(d10.get("isWhiteList"));
            z12 = equals;
        }
        if (C1643c.w()) {
            this.f13933h0 = C1643c.u(this.f13787b);
        }
        this.f13905F.removeMessages(5);
        Handler handler = this.f13905F;
        handler.sendMessage(Message.obtain(handler, 5, new m(viewGroup, view, oVar, arrayList, str, i10, j10, str2, str3, i11, z12, z11, z13, str4, str5, i12, i13, i14, j11, i15, str6)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g1()) {
            return;
        }
        if (C7.a.a() && !DisplayUtil.n(this.f13787b)) {
            H7.b.i("CallLogAdapter", "Too fast clicks, just return.");
            return;
        }
        Intent T02 = T0(view);
        if (T02 == null) {
            return;
        }
        long f10 = C7.e.f(T02, "contact_id", -1L);
        if (h1()) {
            if (C1641a.k(f10)) {
                C1641a.y(this.f13787b, T02.getData());
            } else {
                this.f13902C.G7(V0(T02));
            }
            O0(this.f13787b, T02, this.f13902C.k4());
            return;
        }
        if (C1641a.k(f10)) {
            C1641a.y(this.f13787b, T02.getData());
        } else {
            this.f13902C.G7(T02);
        }
    }

    public final /* synthetic */ void p1(m mVar) {
        this.f13942o0.setOnDismissListener(null);
        ViewGroup viewGroup = mVar.f13999s;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(false);
        }
        com.android.contacts.framework.baseui.util.E.a(mVar.f13995o);
        D();
        V1(true);
    }

    public final /* synthetic */ void r1(final Context context, final m mVar, DialogInterface dialogInterface, int i10) {
        this.f13903D.post(new Runnable() { // from class: com.android.contacts.calllog.h
            @Override // java.lang.Runnable
            public final void run() {
                k.q1(context, mVar);
            }
        });
        dialogInterface.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public F.c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        View e12;
        if (this.f13946q0 == null) {
            d1();
        }
        if (!this.f13946q0.isEmpty()) {
            e12 = this.f13946q0.remove(0);
        } else {
            e12 = e1(this.f13788c, this.f13797l);
        }
        return new F.c(e12);
    }

    public void t1() {
        HandlerThread handlerThread = this.f13904E;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        LocationUtils.n(this.f13949s0);
    }

    public final void u1(String str, long j10) {
        E3.c cVar = this.f13925Z;
        if (cVar != null) {
            cVar.x().put(str, Long.valueOf(j10));
        }
    }

    public final void v1(long j10, ArrayList<String> arrayList) {
        BlackListUtils.o(this.f13787b, j10, arrayList, false, false, false);
    }

    public final void w0(long j10, ArrayList<String> arrayList) {
        BlackListUtils.o(this.f13787b, j10, arrayList, true, true, false);
    }

    public final void w1(long j10, ArrayList<String> arrayList) {
        ComponentActivity componentActivity = this.f13787b;
        if (componentActivity instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(componentActivity, str)) {
                com.android.contacts.framework.baseui.util.l.f(this.f13787b, str, null, 1);
                return;
            }
        }
        BlackListUtils.p(this.f13787b, j10, arrayList, false, false);
    }

    public final void x0(long j10, ArrayList<String> arrayList) {
        BlackListUtils.p(this.f13787b, j10, arrayList, true, true);
    }

    public final void x1(String str) {
        E3.c cVar = this.f13925Z;
        if (cVar != null) {
            cVar.x().remove(str);
        }
    }

    public final void y0(TextView textView, long j10) {
        textView.setVisibility(0);
        this.f13950x.setTimeInMillis(System.currentTimeMillis());
        String a10 = F7.b.a(j10, this.f13950x, this.f13917R, this.f13918S, this.f13787b.getString(R.string.oplus_yesterday));
        if ("-".equals(a10)) {
            textView.setText(this.f13917R.format(Long.valueOf(j10)));
        } else {
            textView.setText(a10);
        }
    }

    public void y1() {
        this.f13929d0 = false;
        this.f13789d = false;
    }

    @Override // com.android.contacts.calllog.F
    public boolean z() {
        boolean z10;
        Z3.f fVar = this.f13906G;
        if (fVar != null && fVar.n()) {
            z10 = true;
        } else {
            z10 = false;
        }
        H7.b.b("CallLogAdapter", "isDialPadAnimating: " + z10);
        return z10;
    }

    public final void z0(F.c cVar, long j10) {
        if (FeatureOption.o()) {
            ViewStub viewStub = (ViewStub) cVar.itemView.findViewById(R.id.briefcase_icon_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            C1641a.w(j10, (ImageView) cVar.itemView.findViewById(R.id.briefcase_icon));
        }
    }

    public final void z1(String str) {
        if (I.b(str)) {
            if (!TextUtils.isEmpty(str) && (str.startsWith("*72") || str.startsWith("*90") || str.startsWith("*92") || str.startsWith("*68") || str.startsWith("*74"))) {
                str = str.substring(3);
            }
            if (R7.b.d(this.f13787b, new Intent("android.intent.action.SENDTO", Uri.fromParts("sms", str, null)), R.string.activity_not_found)) {
                ViewOnClickListenerC0694u0 viewOnClickListenerC0694u0 = this.f13902C;
                if (viewOnClickListenerC0694u0 instanceof DialtactsUnfoldFragment) {
                    ((DialtactsUnfoldFragment) viewOnClickListenerC0694u0).b9();
                }
            }
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.android.contacts.calllog.o f13954a;

        public b(com.android.contacts.calllog.o oVar) {
            this.f13954a = oVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            k.this.f13928c0 = false;
            k kVar = k.this;
            kVar.f13789d = false;
            if (kVar.f13931f0) {
                k.this.D();
                k.this.f13931f0 = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            k kVar = k.this;
            kVar.f13789d = true;
            kVar.f13930e0 = false;
            this.f13954a.f14009b.setVisibility(4);
            this.f13954a.f14012e.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.android.contacts.calllog.o f13956a;

        public c(com.android.contacts.calllog.o oVar) {
            this.f13956a = oVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f13956a.f14012e.setVisibility(8);
            k.this.f13929d0 = false;
            k kVar = k.this;
            kVar.f13789d = false;
            if (kVar.f13930e0) {
                k.this.f13930e0 = false;
                k.this.E();
            }
            this.f13956a.f14009b.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            k.this.f13789d = true;
            this.f13956a.f14012e.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: CallLogAdapter.java */
    /* loaded from: classes.dex */
    public interface n {
        default void a(ArrayList<String> arrayList) {
        }
    }
}
