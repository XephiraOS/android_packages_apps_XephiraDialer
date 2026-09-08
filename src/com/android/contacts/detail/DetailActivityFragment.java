package com.android.contacts.detail;

import a4.C0421a;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.android.contacts.ContactLoader;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.detail.CallDetailUnfamiliarNumberFragment;
import com.android.contacts.detail.ContactLoaderFragment;
import com.android.contacts.detail.DetailActivityFragment;
import com.android.contacts.detail.i0;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.dialog.adapter.COUIListDialogAdapter;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.COUISubMenuClickListener;
import com.coui.appcompat.poplist.PopupListItem;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.fragment.BaseActivityFragment;
import com.customize.contacts.model.NewCallRepository;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.ContactDataUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Result;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.C1248i;
import m1.AbstractC1316l;
import n1.AbstractC1362a;
import r0.C1498a;
import r0.C1501d;
import w0.C1641a;
import w0.C1643c;

/* compiled from: DetailActivityFragment.kt */
/* loaded from: classes.dex */
public class DetailActivityFragment extends BaseActivityFragment {

    /* renamed from: G0, reason: collision with root package name */
    public static final a f14397G0 = new a(null);

    /* renamed from: H0, reason: collision with root package name */
    public static c f14398H0;

    /* renamed from: A0, reason: collision with root package name */
    public Intent f14399A0;

    /* renamed from: B0, reason: collision with root package name */
    public MenuItem f14400B0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f14404F;

    /* renamed from: G, reason: collision with root package name */
    public ContactLoaderFragment f14406G;

    /* renamed from: I, reason: collision with root package name */
    public boolean f14408I;

    /* renamed from: J, reason: collision with root package name */
    public int f14409J;

    /* renamed from: K, reason: collision with root package name */
    public ContactLoader.Result f14410K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f14411L;

    /* renamed from: M, reason: collision with root package name */
    public z0 f14412M;

    /* renamed from: N, reason: collision with root package name */
    public CallDetailUnfamiliarNumberFragment f14413N;

    /* renamed from: O, reason: collision with root package name */
    public CallDetailUnfamiliarNumberFragment f14414O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f14415P;

    /* renamed from: Q, reason: collision with root package name */
    public Uri f14416Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f14417R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f14418S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f14419T;

    /* renamed from: U, reason: collision with root package name */
    public Handler f14420U;

    /* renamed from: V, reason: collision with root package name */
    public final boolean f14421V;

    /* renamed from: W, reason: collision with root package name */
    public long f14422W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f14423X;

    /* renamed from: Z, reason: collision with root package name */
    public b f14425Z;

    /* renamed from: b0, reason: collision with root package name */
    public Context f14427b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f14428c0;

    /* renamed from: d0, reason: collision with root package name */
    public Dialog f14429d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f14430e0;

    /* renamed from: f0, reason: collision with root package name */
    public COUIPopupListWindow f14431f0;

    /* renamed from: g0, reason: collision with root package name */
    public HashMap<String, Integer> f14432g0;

    /* renamed from: h0, reason: collision with root package name */
    public ArrayList<PopupListItem> f14433h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f14434i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f14435j0;

    /* renamed from: k0, reason: collision with root package name */
    public COUIPopupListWindow f14436k0;

    /* renamed from: l0, reason: collision with root package name */
    public COUIPopupListWindow f14437l0;

    /* renamed from: m0, reason: collision with root package name */
    public Integer f14438m0;

    /* renamed from: n0, reason: collision with root package name */
    public COUINavigationView f14439n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f14440o0;

    /* renamed from: p0, reason: collision with root package name */
    public CallDetailUnfamiliarNumberFragment f14441p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f14442q0;

    /* renamed from: r0, reason: collision with root package name */
    public ThreadPoolExecutor f14443r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f14444s0;

    /* renamed from: t0, reason: collision with root package name */
    public S3.n f14445t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f14446u0;

    /* renamed from: v0, reason: collision with root package name */
    public String f14447v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f14448w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f14449x0;

    /* renamed from: y0, reason: collision with root package name */
    public MenuItem f14450y0;

    /* renamed from: H, reason: collision with root package name */
    public ArrayList<String> f14407H = new ArrayList<>();

    /* renamed from: Y, reason: collision with root package name */
    public boolean f14424Y = true;

    /* renamed from: a0, reason: collision with root package name */
    public final Object f14426a0 = new Object();

    /* renamed from: z0, reason: collision with root package name */
    public CallDetailUnfamiliarNumberFragment.i f14451z0 = new CallDetailUnfamiliarNumberFragment.i();

    /* renamed from: C0, reason: collision with root package name */
    public final ContactLoaderFragment.d f14401C0 = new DetailActivityFragment$mLoaderFragmentListener$1(this);

    /* renamed from: D0, reason: collision with root package name */
    public final BroadcastReceiver f14402D0 = new BroadcastReceiver() { // from class: com.android.contacts.detail.DetailActivityFragment$mUpdateRingtoneReceiver$1
        /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
        
            r3 = r5.f14467a.f14428c0;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
                r5 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.i.f(r6, r0)
                java.lang.String r6 = "intent"
                kotlin.jvm.internal.i.f(r7, r6)
                java.lang.String r6 = r7.getAction()
                java.lang.String r0 = "com.oplus.contacts.DETAIL_UPDATE_DONE"
                boolean r6 = kotlin.jvm.internal.i.b(r6, r0)
                if (r6 == 0) goto Lc4
                java.lang.String r6 = "vip_remove_blacklist_tips"
                r0 = 0
                boolean r6 = C7.e.c(r7, r6, r0)
                java.lang.String r1 = "insertToBlackList"
                boolean r1 = C7.e.c(r7, r1, r0)
                java.lang.String r2 = "insertToWhiteList"
                boolean r2 = C7.e.c(r7, r2, r0)
                if (r1 == 0) goto L39
                com.android.contacts.detail.DetailActivityFragment r3 = com.android.contacts.detail.DetailActivityFragment.this
                java.lang.String r3 = com.android.contacts.detail.DetailActivityFragment.G2(r3)
                if (r3 == 0) goto L39
                com.android.contacts.detail.DetailActivityFragment r4 = com.android.contacts.detail.DetailActivityFragment.this
                com.android.contacts.detail.DetailActivityFragment.Y2(r4, r3)
            L39:
                if (r6 == 0) goto L48
                com.android.contacts.detail.DetailActivityFragment r5 = com.android.contacts.detail.DetailActivityFragment.this
                android.content.Context r5 = r5.o3()
                r6 = 2132019276(0x7f14084c, float:1.9676882E38)
                com.oplus.foundation.util.ui.c.b(r5, r6)
                return
            L48:
                java.lang.String r6 = "notInsertVipToBlackList"
                boolean r6 = C7.e.c(r7, r6, r0)
                if (r6 == 0) goto L5f
                com.android.contacts.detail.DetailActivityFragment r6 = com.android.contacts.detail.DetailActivityFragment.this
                android.content.Context r6 = r6.o3()
                r7 = 2132019214(0x7f14080e, float:1.9676757E38)
                com.oplus.foundation.util.ui.c.b(r6, r7)
                if (r1 != 0) goto L5f
                return
            L5f:
                boolean r6 = H7.a.b()
                java.lang.String r7 = "DetailActivityFragment"
                if (r6 == 0) goto L81
                com.android.contacts.detail.DetailActivityFragment r6 = com.android.contacts.detail.DetailActivityFragment.this
                boolean r6 = com.android.contacts.detail.DetailActivityFragment.F2(r6)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "mIsFromCallLog = "
                r0.append(r3)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                H7.b.e(r7, r6)
            L81:
                com.android.contacts.detail.DetailActivityFragment r6 = com.android.contacts.detail.DetailActivityFragment.this
                boolean r6 = com.android.contacts.detail.DetailActivityFragment.F2(r6)
                if (r6 == 0) goto L8e
                com.android.contacts.detail.DetailActivityFragment r6 = com.android.contacts.detail.DetailActivityFragment.this
                r6.h4(r1, r2)
            L8e:
                com.android.contacts.detail.DetailActivityFragment r6 = com.android.contacts.detail.DetailActivityFragment.this
                boolean r6 = com.android.contacts.detail.DetailActivityFragment.F2(r6)
                if (r6 == 0) goto L97
                return
            L97:
                com.android.contacts.detail.DetailActivityFragment r5 = com.android.contacts.detail.DetailActivityFragment.this
                kotlin.Result$a r6 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> La7
                com.android.contacts.detail.ContactLoaderFragment r5 = r5.w3()     // Catch: java.lang.Throwable -> La7
                if (r5 == 0) goto La9
                r5.r1()     // Catch: java.lang.Throwable -> La7
                m9.q r5 = m9.q.f35511a     // Catch: java.lang.Throwable -> La7
                goto Laa
            La7:
                r5 = move-exception
                goto Laf
            La9:
                r5 = 0
            Laa:
                java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> La7
                goto Lb9
            Laf:
                kotlin.Result$a r6 = kotlin.Result.f34166a
                java.lang.Object r5 = kotlin.b.a(r5)
                java.lang.Object r5 = kotlin.Result.b(r5)
            Lb9:
                java.lang.Throwable r5 = kotlin.Result.d(r5)
                if (r5 == 0) goto Lc4
                java.lang.String r5 = "mUpdateRingtoneReceiver exception"
                H7.b.c(r7, r5)
            Lc4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.DetailActivityFragment$mUpdateRingtoneReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* renamed from: E0, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f14403E0 = new AdapterView.OnItemClickListener() { // from class: com.android.contacts.detail.G
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            DetailActivityFragment.L3(DetailActivityFragment.this, adapterView, view, i10, j10);
        }
    };

    /* renamed from: F0, reason: collision with root package name */
    public final PhoneStateListener f14405F0 = new h();

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public DetailActivityFragment f14452a;

        public b(DetailActivityFragment detailActivityFragment) {
            this.f14452a = detailActivityFragment;
        }

        public final void a() {
            this.f14452a = null;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int i10) {
            String str;
            kotlin.jvm.internal.i.f(dialog, "dialog");
            DetailActivityFragment detailActivityFragment = this.f14452a;
            if (detailActivityFragment == null) {
                return;
            }
            if (i10 == -3) {
                detailActivityFragment.f14418S = true;
                c cVar = new c(detailActivityFragment, detailActivityFragment.f14422W);
                cVar.i();
                DetailActivityFragment.f14398H0 = cVar;
                str = "yes";
            } else {
                str = "no";
            }
            Context context = detailActivityFragment.getContext();
            if (context != null) {
                if (detailActivityFragment.K3()) {
                    com.customize.contacts.util.h0.B(context, str);
                } else {
                    com.customize.contacts.util.h0.x(context, "double_check", str);
                }
            }
        }
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class c extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public long f14453a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<DetailActivityFragment> f14454b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14455c;

        public c(DetailActivityFragment fragment, long j10) {
            boolean z10;
            kotlin.jvm.internal.i.f(fragment, "fragment");
            this.f14453a = j10;
            this.f14454b = new WeakReference<>(fragment);
            ContactLoader.Result n32 = fragment.n3();
            ContactListFilter e10 = AbstractC1316l.f(fragment.o3()).e();
            if (e10.f16738b == 0 && n32 != null && n32.l(e10.f16740d)) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f14455c = z10;
        }

        public static final void f(DetailActivityFragment fragment, FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.i.f(fragment, "$fragment");
            if (!fragment.D1()) {
                com.oplus.foundation.util.ui.c.b(fragmentActivity, R.string.oplus_delete_contacts_failed);
            }
        }

        public static final void g(DetailActivityFragment fragment, FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.i.f(fragment, "$fragment");
            if (!fragment.D1()) {
                com.oplus.foundation.util.ui.c.b(fragmentActivity, R.string.oplus_delete_contacts_failed);
            }
        }

        public static final void h(DetailActivityFragment fragment, FragmentActivity fragmentActivity) {
            kotlin.jvm.internal.i.f(fragment, "$fragment");
            if (!fragment.D1()) {
                com.oplus.foundation.util.ui.c.b(fragmentActivity, R.string.oplus_delete_contacts_failed);
            }
        }

        public final void d() {
            this.f14454b = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00f9, code lost:
        
            if (G7.c.c(r7.getContentResolver(), r8, null, null) == 1) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0146, code lost:
        
            r9.R1(new com.android.contacts.detail.RunnableC0605e0(r9, r7));
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x010c, code lost:
        
            if (r9.K3() != false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x010e, code lost:
        
            com.customize.contacts.util.C0811w.n(r7, r9.f14416Q);
            com.customize.contacts.util.C0798i.b(r7.getApplicationContext());
            r8 = X.a.b(com.android.contacts.ContactsApplication.h().getApplicationContext());
            kotlin.jvm.internal.i.e(r8, "getInstance(ContactsAppl…ion().applicationContext)");
            r8.d(new android.content.Intent("com.oplus.contacts.force_refresh_calllog"));
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0137, code lost:
        
            r9.f14422W = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0140, code lost:
        
            if (r9.D1() != false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0142, code lost:
        
            r9.o1();
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0106, code lost:
        
            if (com.customize.contacts.util.c0.d(r7, r8.f14453a, r8.f14455c, "detail") != false) goto L63;
         */
        @Override // android.os.AsyncTask
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Void... r9) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.DetailActivityFragment.c.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        public final void i() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        @Override // android.os.AsyncTask
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            DetailActivityFragment detailActivityFragment;
            Context context;
            B3.c.d().h();
            WeakReference<DetailActivityFragment> weakReference = this.f14454b;
            if (weakReference != null && (detailActivityFragment = weakReference.get()) != null && (context = detailActivityFragment.getContext()) != null) {
                com.customize.contacts.util.W.h(context);
                com.customize.contacts.util.W.e(context);
            }
        }
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<DetailActivityFragment> f14456a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(DetailActivityFragment activityFragment) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.i.f(activityFragment, "activityFragment");
            this.f14456a = new WeakReference<>(activityFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            DetailActivityFragment detailActivityFragment = this.f14456a.get();
            if (detailActivityFragment != null && !detailActivityFragment.D1() && !detailActivityFragment.B1() && msg.what == 1) {
                detailActivityFragment.c5();
            }
        }
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public final class e implements COUISubMenuClickListener {
        public e() {
        }

        public static final void b(DetailActivityFragment this$0, boolean z10) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            S3.n nVar = this$0.f14445t0;
            if (nVar != null) {
                nVar.d();
            }
            com.customize.contacts.util.h0.z(this$0.o3(), "2", z10);
            com.android.contacts.framework.baseui.util.A.a(this$0.o3(), 2000324, 200032401, null, false);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            ThreadPoolExecutor threadPoolExecutor;
            COUIPopupListWindow cOUIPopupListWindow = DetailActivityFragment.this.f14431f0;
            if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
                COUIPopupListWindow cOUIPopupListWindow2 = DetailActivityFragment.this.f14431f0;
                if (cOUIPopupListWindow2 != null) {
                    cOUIPopupListWindow2.dismiss();
                }
                DetailActivityFragment.this.f14431f0 = null;
            }
            final boolean K32 = DetailActivityFragment.this.K3();
            if (DetailActivityFragment.this.K3()) {
                com.customize.contacts.util.h0.D(DetailActivityFragment.this.o3(), "share");
            } else {
                com.customize.contacts.util.h0.w(DetailActivityFragment.this.o3(), "share");
            }
            if (1 == i10) {
                DetailActivityFragment.this.g4(2);
                com.customize.contacts.util.h0.z(DetailActivityFragment.this.o3(), OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, K32);
            } else if (i10 == 0) {
                DetailActivityFragment.this.g4(1);
                com.customize.contacts.util.h0.z(DetailActivityFragment.this.o3(), OplusPhoneUtils.DeviceState.LOCK_DEVICE, K32);
            } else if (2 == i10 && (threadPoolExecutor = DetailActivityFragment.this.f14443r0) != null) {
                final DetailActivityFragment detailActivityFragment = DetailActivityFragment.this;
                threadPoolExecutor.execute(new Runnable() { // from class: com.android.contacts.detail.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DetailActivityFragment.e.b(DetailActivityFragment.this, K32);
                    }
                });
            }
        }
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public final class g implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final int f14463a;

        public g(int i10) {
            this.f14463a = i10;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialog) {
            kotlin.jvm.internal.i.f(dialog, "dialog");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int i10) {
            kotlin.jvm.internal.i.f(dialog, "dialog");
            if (-3 == i10) {
                DetailActivityFragment detailActivityFragment = DetailActivityFragment.this;
                detailActivityFragment.H3(detailActivityFragment.y3(), this.f14463a);
                DetailActivityFragment.this.n4(true);
                com.customize.contacts.util.h0.x(DetailActivityFragment.this.o3(), "double_check", "yes");
                return;
            }
            com.customize.contacts.util.h0.x(DetailActivityFragment.this.o3(), "double_check", "no");
        }
    }

    public static final void G4(final DetailActivityFragment this$0, AdapterView adapterView, View view, int i10, long j10) {
        ThreadPoolExecutor threadPoolExecutor;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        COUIPopupListWindow cOUIPopupListWindow = this$0.f14437l0;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.getContentView() != null) {
            cOUIPopupListWindow.dismiss();
            if (i10 == 0) {
                this$0.g4(1);
                com.customize.contacts.util.h0.z(this$0.o3(), OplusPhoneUtils.DeviceState.LOCK_DEVICE, this$0.K3());
            } else if (1 == i10) {
                this$0.g4(2);
                com.customize.contacts.util.h0.z(this$0.o3(), OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, this$0.K3());
            } else if (2 == i10 && (threadPoolExecutor = this$0.f14443r0) != null) {
                threadPoolExecutor.execute(new Runnable() { // from class: com.android.contacts.detail.N
                    @Override // java.lang.Runnable
                    public final void run() {
                        DetailActivityFragment.H4(DetailActivityFragment.this);
                    }
                });
            }
        }
    }

    public static final void H4(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        S3.n nVar = this$0.f14445t0;
        if (nVar != null) {
            nVar.d();
        }
        com.customize.contacts.util.h0.z(this$0.o3(), "2", this$0.K3());
        com.android.contacts.framework.baseui.util.A.a(this$0.o3(), 2000324, 200032401, null, false);
    }

    public static final void J4(DetailActivityFragment this$0, String keyword, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(keyword, "$keyword");
        if (i10 != -2) {
            if (i10 == -1) {
                com.android.contacts.framework.baseui.util.A.a(this$0.o3(), 2000320, 200030265, null, false);
                Intent intent = new Intent(com.customize.contacts.util.k0.f22142f);
                intent.putExtra("keyWord", keyword);
                R7.b.f(this$0.getContext(), intent, 0, null, 6, null);
                return;
            }
            return;
        }
        com.android.contacts.framework.baseui.util.A.a(this$0.o3(), 2000320, 200030266, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K3() {
        ContactLoader.Result result = this.f14410K;
        if (result != null) {
            return result.g0();
        }
        return false;
    }

    public static final void L3(DetailActivityFragment this$0, AdapterView adapterView, View view, int i10, long j10) {
        ArrayList<PopupListItem> arrayList;
        PopupListItem popupListItem;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        COUIPopupListWindow cOUIPopupListWindow = this$0.f14431f0;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.getContentView() != null) {
            if (cOUIPopupListWindow.isShowing() && ((arrayList = this$0.f14433h0) == null || (popupListItem = arrayList.get(i10)) == null || !popupListItem.hasSubMenu())) {
                cOUIPopupListWindow.dismiss();
            }
            ArrayList<PopupListItem> arrayList2 = this$0.f14433h0;
            if (arrayList2 != null) {
                if (i10 >= arrayList2.size()) {
                    return;
                }
                PopupListItem popupListItem2 = arrayList2.get(i10);
                kotlin.jvm.internal.i.e(popupListItem2, "itemList[position]");
                if (!popupListItem2.isEnable()) {
                    return;
                }
            }
            if (!this$0.D1() && !this$0.B1()) {
                this$0.W3(i10);
            }
        }
    }

    public static final void M4(DetailActivityFragment this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.customize.contacts.util.h0.x(this$0.o3(), "double_check", "no");
    }

    public static final void N4(DetailActivityFragment this$0, ArrayList phoneNumberList, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(phoneNumberList, "$phoneNumberList");
        com.customize.contacts.util.h0.x(this$0.o3(), "double_check", "yes");
        this$0.e4(phoneNumberList, 1);
        this$0.f14415P = true;
    }

    public static final boolean P3(DetailActivityFragment this$0, MenuItem menuItem) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(menuItem, "menuItem");
        this$0.L1(new com.customize.contacts.fragment.z(menuItem));
        return true;
    }

    public static final void P4(DetailActivityFragment this$0, int i10, Ref$IntRef callContactPos, int i11, DialogInterface dialogInterface, int i12) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(callContactPos, "$callContactPos");
        C1248i.d(androidx.lifecycle.p.a(this$0), null, null, new DetailActivityFragment$showCreateContactsShortcut$dialog$1$1(i12, i10, this$0, callContactPos, i11, null), 3, null);
    }

    private final void Q4() {
        int i10;
        Dialog dialog = this.f14429d0;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (K3()) {
            i10 = R.string.delete_my_business_card_info_v2;
        } else {
            i10 = R.string.dialog_title_delete_contact;
        }
        U0.b bVar = new U0.b(o3(), 2132083073);
        bVar.setTitle(i10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this.f14425Z).setNeutralButton(R.string.delete_button, (DialogInterface.OnClickListener) this.f14425Z);
        androidx.appcompat.app.b show = bVar.show();
        this.f14429d0 = show;
        U0.n.d(show);
        d3(bVar);
    }

    public static final void R3(boolean z10, ArrayList phoneNumberList, DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10) {
            if (phoneNumberList.size() > 0) {
                kotlin.jvm.internal.i.e(phoneNumberList, "phoneNumberList");
                this$0.L4(phoneNumberList);
                return;
            }
            return;
        }
        kotlin.jvm.internal.i.e(phoneNumberList, "phoneNumberList");
        this$0.f14407H = phoneNumberList;
        this$0.Y4(1);
    }

    private final void R4() {
        Dialog dialog = this.f14429d0;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        U0.b bVar = new U0.b(o3(), 2132083073);
        if (K3()) {
            bVar.setTitle(R.string.delete_my_business_card_info_v2);
        } else {
            bVar.setMessage(R.string.delete_contact_contain_cloud);
            bVar.setTitle(R.string.dialog_title_delete_contact);
        }
        bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this.f14425Z);
        bVar.setNeutralButton(R.string.delete_button, (DialogInterface.OnClickListener) this.f14425Z);
        androidx.appcompat.app.b show = bVar.show();
        this.f14429d0 = show;
        U0.n.d(show);
        d3(bVar);
    }

    public static final void S3(DetailActivityFragment this$0, Intent intent) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.V4(intent);
    }

    private final void S4() {
        com.android.contacts.framework.api.cloudsync.a.a("DetailActivityFragment showDeleteDialog", androidx.lifecycle.p.a(this), new Runnable() { // from class: com.android.contacts.detail.Z
            @Override // java.lang.Runnable
            public final void run() {
                DetailActivityFragment.T4(DetailActivityFragment.this);
            }
        });
    }

    public static final void T3(boolean z10, ArrayList phoneNumberList, DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10) {
            if (phoneNumberList.size() > 0) {
                this$0.e4(phoneNumberList, 2);
                this$0.f14415P = true;
                return;
            }
            return;
        }
        kotlin.jvm.internal.i.e(phoneNumberList, "phoneNumberList");
        this$0.f14407H = phoneNumberList;
        this$0.Y4(2);
    }

    public static final void T4(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.android.contacts.framework.api.cloudsync.a.e();
        if (H7.a.b()) {
            H7.b.b("DetailActivityFragment", "isCloudSyncOpen = false");
        }
        this$0.f14425Z = new b(this$0);
        ContactLoader.Result result = this$0.f14410K;
        if (result != null && (kotlin.jvm.internal.i.b("com.oplus.contacts.sim", result.p()) || kotlin.jvm.internal.i.b("com.android.oplus.sim", result.p()))) {
            this$0.Q4();
        } else if (result != null && result.a0()) {
            this$0.R4();
        } else {
            this$0.Q4();
        }
    }

    public static final void V3(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.d4(this$0.o3());
    }

    public static final void W4(DetailActivityFragment this$0, Intent intent, boolean z10, boolean z11, DialogInterface dialogInterface, int i10) {
        com.google.common.collect.p<Account, Long> pVar;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.customize.contacts.util.h0.x(this$0.o3(), "double_check", "yes");
        Parcelable j10 = C7.e.j(intent, "black_list_data");
        kotlin.jvm.internal.i.e(j10, "getParcelableExtra(inten…actsKeys.BLACK_LIST_DATA)");
        ArrayList<String> m10 = ((ContactParcelable) j10).m();
        z0 z0Var = this$0.f14412M;
        if (z0Var != null) {
            kotlin.jvm.internal.i.c(z0Var);
            pVar = z0Var.m2();
        } else {
            pVar = null;
        }
        C0797h.a(this$0.o3(), new f(this$0, z10, pVar, z11, m10), this$0.f14426a0);
        if (z11) {
            this$0.f14415P = true;
        }
    }

    public static final void X3(z0 it, DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(it, "$it");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        i0.f p22 = it.p2();
        if (p22 != null) {
            if (C7.e.c(p22.f14629s, "is_vip_group", false)) {
                com.customize.contacts.util.h0.w(this$0.o3(), "cancel_vip");
            } else {
                com.customize.contacts.util.h0.w(this$0.o3(), "vip");
            }
            this$0.Q3(p22.f14629s);
        }
    }

    public static final void X4(DetailActivityFragment this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        com.customize.contacts.util.h0.x(this$0.o3(), "double_check", "no");
    }

    public static final void Y3(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = this$0.f14441p0;
        if (callDetailUnfamiliarNumberFragment != null) {
            callDetailUnfamiliarNumberFragment.X2(false);
        }
    }

    public static final void Z3(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = this$0.f14441p0;
        if (callDetailUnfamiliarNumberFragment != null) {
            callDetailUnfamiliarNumberFragment.D2();
        }
    }

    public static final void a4(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Context o32 = this$0.o3();
        ContactLoader.Result result = this$0.f14410K;
        kotlin.jvm.internal.i.c(result);
        com.android.contacts.util.B.a(o32, result.B(), "", this$0.f14416Q);
    }

    public static final void b3(DetailActivityFragment this$0, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        COUIPopupListWindow cOUIPopupListWindow = this$0.f14436k0;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.getContentView() != null) {
            cOUIPopupListWindow.dismiss();
            if (i10 != 0) {
                if (i10 == 1) {
                    com.customize.contacts.util.h0.w(this$0.o3(), "add_old");
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = this$0.f14441p0;
                    if (callDetailUnfamiliarNumberFragment != null) {
                        callDetailUnfamiliarNumberFragment.E2();
                        return;
                    }
                    return;
                }
                return;
            }
            com.customize.contacts.util.h0.w(this$0.o3(), "add_new");
            CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment2 = this$0.f14441p0;
            if (callDetailUnfamiliarNumberFragment2 != null) {
                callDetailUnfamiliarNumberFragment2.w2(null);
            }
        }
    }

    public static final void b4(DetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.c4(this$0.o3());
        if ((C0801l.j(this$0.o3()) || C0801l.i(this$0.o3()) == 0) && com.android.contacts.util.w.k(this$0.o3(), com.android.contacts.util.w.e())) {
            B3.d.e(this$0.o3());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c5() {
        z0 z0Var = this.f14412M;
        if (z0Var != null && z0Var.isAdded()) {
            z0Var.l3();
        }
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = this.f14441p0;
        if (callDetailUnfamiliarNumberFragment != null && callDetailUnfamiliarNumberFragment.isAdded()) {
            callDetailUnfamiliarNumberFragment.h3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m4(Uri uri) {
        ContactLoaderFragment contactLoaderFragment = this.f14406G;
        if (contactLoaderFragment != null) {
            contactLoaderFragment.q1(uri);
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean A1() {
        return true;
    }

    public final CallDetailUnfamiliarNumberFragment.i A3() {
        return this.f14451z0;
    }

    public final void A4(CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment) {
        this.f14414O = callDetailUnfamiliarNumberFragment;
    }

    public final int B3() {
        return this.f14440o0;
    }

    public final void B4(CallDetailUnfamiliarNumberFragment.i iVar) {
        kotlin.jvm.internal.i.f(iVar, "<set-?>");
        this.f14451z0 = iVar;
    }

    public final CallDetailUnfamiliarNumberFragment C3() {
        return this.f14413N;
    }

    public final void C4(int i10) {
        this.f14440o0 = i10;
    }

    public final int D3() {
        Menu menu;
        if (CommonFeatureOption.o(getContext())) {
            Menu u12 = u1();
            if (u12 == null) {
                return 0;
            }
            return u12.size();
        }
        COUINavigationView cOUINavigationView = this.f14439n0;
        if (cOUINavigationView == null || (menu = cOUINavigationView.getMenu()) == null) {
            return 0;
        }
        return menu.size();
    }

    public final void D4(CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment) {
        this.f14413N = callDetailUnfamiliarNumberFragment;
    }

    public final ArrayList<PopupListItem> E3() {
        Integer[] numArr;
        S3.n nVar;
        boolean B10 = B3.a.B();
        Integer valueOf = Integer.valueOf(R.string.share_with_vcard_type);
        Integer valueOf2 = Integer.valueOf(R.string.share_with_text_type);
        if (B10 && (nVar = this.f14445t0) != null && nVar.e()) {
            numArr = new Integer[]{valueOf2, valueOf, Integer.valueOf(R.string.share_with_qr_code_type)};
        } else {
            numArr = new Integer[]{valueOf2, valueOf};
        }
        ArrayList<PopupListItem> arrayList = new ArrayList<>();
        for (Integer num : numArr) {
            arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(num.intValue()), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        return arrayList;
    }

    public final void E4(int i10) {
        this.f14409J = i10;
    }

    public boolean F3() {
        return false;
    }

    public final void F4() {
        COUIPopupListWindow cOUIPopupListWindow = this.f14437l0;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            return;
        }
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.android.contacts.detail.a0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                DetailActivityFragment.G4(DetailActivityFragment.this, adapterView, view, i10, j10);
            }
        };
        COUIPopupListWindow cOUIPopupListWindow2 = new COUIPopupListWindow(o3());
        cOUIPopupListWindow2.setItemList(E3());
        cOUIPopupListWindow2.setDismissTouchOutside(true);
        cOUIPopupListWindow2.setOnItemClickListener(onItemClickListener);
        cOUIPopupListWindow2.show(n1(R.id.menu_share));
        this.f14437l0 = cOUIPopupListWindow2;
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean G1() {
        return false;
    }

    public void G3() {
        boolean z10;
        z0 z0Var;
        NewCallRepository l22;
        LiveData<Boolean> k10;
        S3.n nVar;
        if (this.f14412M == null) {
            return;
        }
        boolean z11 = false;
        if (B3.a.B() && (nVar = this.f14445t0) != null && nVar.e()) {
            z10 = true;
        } else {
            z10 = false;
        }
        HashMap<String, Integer> hashMap = new HashMap<>(6);
        if (z10) {
            hashMap.put(getString(R.string.oplus_qr_code), 16);
        }
        hashMap.put(getString(R.string.oplus_menu_edit), 0);
        hashMap.put(getString(R.string.oplus_share), 1);
        if (CommonFeatureOption.o(getContext()) && (z0Var = this.f14412M) != null && (l22 = z0Var.l2()) != null && (k10 = l22.k()) != null && kotlin.jvm.internal.i.b(k10.getValue(), Boolean.TRUE)) {
            hashMap.put(getString(R.string.menu_message_box), 19);
        }
        hashMap.put(getString(R.string.oplus_add_contacts_to_vip), 2);
        hashMap.put(getString(R.string.oplus_remove_contacts_from_vip), 3);
        hashMap.put(getString(R.string.oplus_intercept_contact), 4);
        hashMap.put(getString(R.string.remove_from_blacklist), 5);
        hashMap.put(getString(R.string.oplus_add_contact_to_whitelist), 14);
        hashMap.put(getString(R.string.oplus_remove_contact_from_whitelist), 15);
        hashMap.put(getString(R.string.delete_button), 6);
        hashMap.put(getString(R.string.quick_dial_add_to_desktop), 17);
        hashMap.put(getString(R.string.create_contacts_shortcut), 18);
        this.f14432g0 = hashMap;
        ArrayList<PopupListItem> arrayList = new ArrayList<>();
        ContactLoader.Result result = this.f14410K;
        if (result != null && result.f0() && !com.customize.contacts.util.b0.m0(o3().getApplicationContext(), 0) && !com.customize.contacts.util.b0.m0(o3().getApplicationContext(), 1)) {
            z11 = true;
        }
        if (!this.f14442q0) {
            c3(arrayList, z10);
        }
        arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.delete_button), !z11, false, 0, null, null, 0, null, null, null, 0, 2044, null));
        this.f14433h0 = arrayList;
    }

    public final void H3(ArrayList<String> arrayList, int i10) {
        if (i10 == 1) {
            BlackListUtils.o(o3(), this.f14422W, arrayList, true, false, false);
        } else {
            BlackListUtils.p(getContext(), this.f14422W, arrayList, true, false);
        }
    }

    public final void I4(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.O
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DetailActivityFragment.J4(DetailActivityFragment.this, str, dialogInterface, i10);
            }
        };
        com.android.contacts.framework.baseui.util.A.a(o3(), 2000320, 200030267, null, false);
        androidx.appcompat.app.b show = new COUIAlertDialogBuilder(o3()).setTitle((CharSequence) getString(R.string.oplus_add_keyword_tips, str)).setNegativeButton(android.R.string.cancel, onClickListener).setPositiveButton(R.string.oplus_add_keyword, onClickListener).show();
        kotlin.jvm.internal.i.e(show, "builder.show()");
        U0.n.d(show);
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean J1(com.customize.contacts.fragment.y menu) {
        int i10;
        MenuItem k32;
        kotlin.jvm.internal.i.f(menu, "menu");
        super.J1(menu);
        if (CommonFeatureOption.o(getContext())) {
            ContactLoader.Result result = this.f14410K;
            if (result != null && result.f0()) {
                i10 = R.menu.contact_detail_menu_for_sim_contact;
            } else {
                i10 = R.menu.contact_detail_menu;
            }
        } else if (this.f14435j0) {
            i10 = R.menu.contact_detail_bottom_menu_for_unfamiliar_number;
        } else if (this.f14442q0) {
            i10 = R.menu.contact_detail_bottom_menu_for_sim_contact;
        } else {
            ContactLoader.Result result2 = this.f14410K;
            if (result2 != null && result2.g0()) {
                i10 = R.menu.contact_detail_bottom_menu_for_profile;
            } else {
                i10 = R.menu.contact_detail_bottom_menu;
            }
        }
        Integer num = this.f14438m0;
        if (num == null || num.intValue() != i10 || D3() == 0) {
            this.f14438m0 = Integer.valueOf(i10);
            if (CommonFeatureOption.o(getContext())) {
                v1().y1(i10, menu);
            } else {
                COUINavigationView cOUINavigationView = this.f14439n0;
                if (cOUINavigationView != null) {
                    cOUINavigationView.inflateMenu(i10);
                }
            }
        }
        MenuItem k33 = k3(R.id.star);
        if (k33 != null) {
            k33.setVisible(true);
        }
        this.f14450y0 = k3(R.id.menu_more);
        this.f14400B0 = k3(R.id.menu_message_box);
        if (C0637b.h() && (k32 = k3(R.id.menu_share)) != null) {
            k32.setVisible(false);
        }
        return true;
    }

    public boolean J3() {
        return false;
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public View K1(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle, FrameLayout frameLayout) {
        COUINavigationView cOUINavigationView;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.contact_detail_activity, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = null;
        if (inflate != null) {
            cOUINavigationView = (COUINavigationView) inflate.findViewById(R.id.contact_detail_navigation_tool);
        } else {
            cOUINavigationView = null;
        }
        this.f14439n0 = cOUINavigationView;
        if (!CommonFeatureOption.o(getContext())) {
            COUINavigationView cOUINavigationView2 = this.f14439n0;
            if (cOUINavigationView2 != null) {
                cOUINavigationView2.setVisibility(0);
            }
            COUINavigationView cOUINavigationView3 = this.f14439n0;
            if (cOUINavigationView3 != null) {
                cOUINavigationView3.setOnNavigationItemSelectedListener(new BottomNavigationView.c() { // from class: com.android.contacts.detail.b0
                    @Override // com.google.android.material.navigation.NavigationBarView.c
                    public final boolean onNavigationItemSelected(MenuItem menuItem) {
                        boolean P32;
                        P32 = DetailActivityFragment.P3(DetailActivityFragment.this, menuItem);
                        return P32;
                    }
                });
            }
        }
        int a10 = com.android.contacts.framework.baseui.util.B.a(o3());
        View b10 = com.android.contacts.framework.baseui.util.B.b(getContext(), true);
        if (inflate instanceof ViewGroup) {
            ((ViewGroup) inflate).addView(b10);
        }
        View findViewById = inflate.findViewById(R.id.appbar);
        if (findViewById != null) {
            layoutParams = findViewById.getLayoutParams();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a10;
        }
        View findViewById2 = inflate.findViewById(R.id.contact_detail_view);
        if (findViewById2 != null) {
            findViewById2.setPadding(0, com.android.contacts.framework.baseui.util.B.a(o3()), 0, 0);
        }
        View findViewById3 = inflate.findViewById(R.id.toolbar);
        if (findViewById3 != null) {
            findViewById3.setBackgroundResource(R.drawable.coui_with_card_toolbar_bg);
        }
        return inflate;
    }

    public final void K4() {
        com.customize.contacts.util.h0.w(o3(), "blocklist");
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = this.f14441p0;
        if (callDetailUnfamiliarNumberFragment != null) {
            callDetailUnfamiliarNumberFragment.X2(true);
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean L1(com.customize.contacts.fragment.z item) {
        NewCallRepository l22;
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment;
        NewCallRepository W12;
        NewCallRepository W13;
        kotlin.jvm.internal.i.f(item, "item");
        switch (item.a()) {
            case android.R.id.home:
                if (this.f14417R) {
                    o1();
                    return true;
                }
                o1();
                return true;
            case R.id.add /* 2131427431 */:
                if (C7.a.a()) {
                    return false;
                }
                if (CommonFeatureOption.o(getContext())) {
                    com.customize.contacts.util.h0.w(o3(), "add_new");
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment2 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment2 != null) {
                        callDetailUnfamiliarNumberFragment2.w2(null);
                        break;
                    }
                } else if (!this.f14451z0.f14365h && !F3()) {
                    a3();
                    break;
                } else {
                    com.customize.contacts.util.h0.w(o3(), "add_new");
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment3 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment3 != null) {
                        callDetailUnfamiliarNumberFragment3.w2(null);
                        break;
                    }
                }
                break;
            case R.id.menu_black_list /* 2131428369 */:
                e3();
                break;
            case R.id.menu_delete /* 2131428375 */:
                i3();
                break;
            case R.id.menu_edit /* 2131428378 */:
                this.f14401C0.b(this.f14416Q);
                if (K3()) {
                    com.customize.contacts.util.h0.D(o3(), "edit");
                    break;
                } else {
                    com.customize.contacts.util.h0.w(o3(), "edit");
                    break;
                }
            case R.id.menu_message_box /* 2131428385 */:
                if (J3()) {
                    int i10 = this.f14430e0;
                    if (i10 == 0) {
                        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment4 = this.f14413N;
                        if (callDetailUnfamiliarNumberFragment4 != null && (W13 = callDetailUnfamiliarNumberFragment4.W1()) != null) {
                            W13.p(getContext());
                            break;
                        }
                    } else if (i10 == 1 && (callDetailUnfamiliarNumberFragment = this.f14414O) != null && (W12 = callDetailUnfamiliarNumberFragment.W1()) != null) {
                        W12.p(getContext());
                        break;
                    }
                } else {
                    z0 z0Var = this.f14412M;
                    if (z0Var != null && (l22 = z0Var.l2()) != null) {
                        l22.p(getContext());
                        break;
                    }
                }
                break;
            case R.id.menu_more /* 2131428386 */:
                COUIPopupListWindow cOUIPopupListWindow = this.f14431f0;
                if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
                    return false;
                }
                G3();
                COUIPopupListWindow cOUIPopupListWindow2 = new COUIPopupListWindow(o3());
                cOUIPopupListWindow2.setItemList(this.f14433h0);
                cOUIPopupListWindow2.setDismissTouchOutside(true);
                cOUIPopupListWindow2.setOnItemClickListener(this.f14403E0);
                cOUIPopupListWindow2.setOffset(0, 0, 0, -getResources().getDimensionPixelOffset(R.dimen.DP_9));
                cOUIPopupListWindow2.setSubMenuClickListener((COUISubMenuClickListener) new e());
                cOUIPopupListWindow2.show(n1(R.id.menu_more));
                this.f14431f0 = cOUIPopupListWindow2;
                break;
            case R.id.menu_qr_code /* 2131428388 */:
                U4();
                break;
            case R.id.menu_share /* 2131428393 */:
                F4();
                break;
            case R.id.star /* 2131429050 */:
                ContactLoader.Result result = this.f14410K;
                if (result != null) {
                    ContactDataUtils.b(o3(), result.L(), true ^ result.W());
                    if (result.W()) {
                        com.customize.contacts.util.h0.w(o3(), "cancel_collect");
                        break;
                    } else {
                        com.customize.contacts.util.h0.w(o3(), "collect");
                        break;
                    }
                }
                break;
        }
        return super.L1(item);
    }

    public final void L4(final ArrayList<String> arrayList) {
        int i10;
        if (o3() instanceof Activity) {
            Context o32 = o3();
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(o32, str)) {
                Context o33 = o3();
                kotlin.jvm.internal.i.d(o33, "null cannot be cast to non-null type android.app.Activity");
                com.android.contacts.framework.baseui.util.l.f((Activity) o33, str, null, 0);
                return;
            }
        }
        if (this.f14419T) {
            i10 = R.string.dialog_title_remove_number_blacklist;
        } else {
            i10 = R.string.dialog_title_remove_blacklist;
        }
        U0.b bVar = new U0.b(o3(), 2132083073);
        bVar.setTitle(i10).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.L
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                DetailActivityFragment.M4(DetailActivityFragment.this, dialogInterface, i11);
            }
        }).setNeutralButton((CharSequence) getString(R.string.remove), new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.M
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                DetailActivityFragment.N4(DetailActivityFragment.this, arrayList, dialogInterface, i11);
            }
        });
        androidx.appcompat.app.b show = bVar.show();
        kotlin.jvm.internal.i.e(show, "builder.show()");
        U0.n.d(show);
        d3(bVar);
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean M1(com.customize.contacts.fragment.y menu) {
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment;
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment2;
        NewCallRepository W12;
        LiveData<Boolean> k10;
        NewCallRepository W13;
        LiveData<Boolean> k11;
        NewCallRepository l22;
        LiveData<Boolean> k12;
        boolean z10;
        S3.n nVar;
        kotlin.jvm.internal.i.f(menu, "menu");
        ContactLoader.Result result = this.f14410K;
        boolean z11 = true;
        if (result != null) {
            MenuItem menuItem = this.f14450y0;
            if (menuItem != null) {
                menuItem.setEnabled(true);
            }
            MenuItem k32 = k3(R.id.star);
            MenuItem k33 = k3(R.id.menu_qr_code);
            if (K3()) {
                if (k32 != null) {
                    k32.setVisible(false);
                }
                if (k33 != null) {
                    if (B3.a.B() && (nVar = this.f14445t0) != null && nVar.e()) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    k33.setVisible(z10);
                }
            } else if (k32 != null) {
                if (result.W()) {
                    k32.setIcon(R.drawable.pb_ic_starred);
                    k32.setTitle(R.string.cancel_collect_description);
                    k32.setContentDescription(getString(R.string.cancel_collect_description));
                } else {
                    k32.setIcon(R.drawable.pb_ic_unstarred);
                    k32.setContentDescription(getString(R.string.personal_collection));
                    k32.setTitle(R.string.personal_collection);
                }
            }
        }
        ContactLoader.Result result2 = this.f14410K;
        if (result2 != null && result2.b0()) {
            MenuItem menuItem2 = this.f14450y0;
            if (menuItem2 != null) {
                menuItem2.setVisible(false);
            }
            MenuItem k34 = k3(R.id.menu_edit);
            if (k34 != null) {
                k34.setVisible(false);
            }
            MenuItem k35 = k3(R.id.star);
            if (k35 != null) {
                k35.setVisible(false);
            }
        }
        MenuItem menuItem3 = this.f14400B0;
        if (menuItem3 != null) {
            z0 z0Var = this.f14412M;
            if ((z0Var == null || (l22 = z0Var.l2()) == null || (k12 = l22.k()) == null || !kotlin.jvm.internal.i.b(k12.getValue(), Boolean.TRUE)) && (((callDetailUnfamiliarNumberFragment = this.f14413N) == null || (W13 = callDetailUnfamiliarNumberFragment.W1()) == null || (k11 = W13.k()) == null || !kotlin.jvm.internal.i.b(k11.getValue(), Boolean.TRUE)) && ((callDetailUnfamiliarNumberFragment2 = this.f14414O) == null || (W12 = callDetailUnfamiliarNumberFragment2.W1()) == null || (k10 = W12.k()) == null || !kotlin.jvm.internal.i.b(k10.getValue(), Boolean.TRUE)))) {
                z11 = false;
            }
            menuItem3.setVisible(z11);
        }
        b5();
        return super.M1(menu);
    }

    public final boolean M3(String str) {
        boolean y10;
        if (str == null) {
            return false;
        }
        String[] strArr = {".color", ".opp", ".oplus.", ".heytap.", ".nearme.", ".google."};
        for (int i10 = 0; i10 < 6; i10++) {
            y10 = StringsKt__StringsKt.y(str, strArr[i10], false, 2, null);
            if (y10) {
                return true;
            }
        }
        return false;
    }

    public final boolean N3() {
        z0 z0Var = this.f14412M;
        if (z0Var != null && z0Var.t2()) {
            return true;
        }
        return false;
    }

    public final void O3() {
        i0.f g22;
        z0 z0Var = this.f14412M;
        if (z0Var != null && (g22 = z0Var.g2()) != null) {
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                String str = C1501d.f36273b;
                if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                    com.android.contacts.framework.baseui.util.l.f(getActivity(), str, null, 0);
                    return;
                }
            }
            if (C7.e.c(g22.f14629s, "is_black", false)) {
                com.customize.contacts.util.h0.w(o3(), "cancel_blocklist");
            } else {
                com.customize.contacts.util.h0.w(o3(), "blocklist");
            }
            Q3(g22.f14629s);
        }
    }

    public final void O4() {
        ArrayList<String> arrayList;
        boolean j10 = CommonFeatureOption.j();
        ContactLoader.Result result = this.f14410K;
        if (result != null) {
            arrayList = result.P();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty() && j10) {
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = 1;
            ArrayList arrayList2 = new ArrayList();
            String string = getString(R.string.viewContactDesription);
            kotlin.jvm.internal.i.e(string, "getString(R.string.viewContactDesription)");
            arrayList2.add(string);
            String string2 = getString(R.string.make_dial);
            kotlin.jvm.internal.i.e(string2, "getString(R.string.make_dial)");
            arrayList2.add(string2);
            String string3 = getString(R.string.cancel);
            kotlin.jvm.internal.i.e(string3, "getString(R.string.cancel)");
            arrayList2.add(string3);
            int size = arrayList2.size();
            int[] iArr = new int[size];
            final int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = R.style.DefaultDialogItemTextStyle;
            }
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            COUIAlertDialogBuilder title = new U0.b(requireContext, 2132083077).setTitle(R.string.shortcutActivityTitle);
            COUIListDialogAdapter cOUIListDialogAdapter = new COUIListDialogAdapter(requireContext(), (CharSequence[]) arrayList2.toArray(new String[0]), iArr);
            final int i12 = 2;
            U0.n.d(title.setAdapter((ListAdapter) cOUIListDialogAdapter, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.T
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i13) {
                    DetailActivityFragment.P4(DetailActivityFragment.this, i10, ref$IntRef, i12, dialogInterface, i13);
                }
            }).show());
            return;
        }
        H7.b.e("DetailActivityFragment", this.f14422W + " number is empty, or dialerSupport: " + j10);
        C1248i.d(androidx.lifecycle.p.a(this), null, null, new DetailActivityFragment$showCreateContactsShortcut$1(this, null), 3, null);
    }

    public final void Q3(final Intent intent) {
        Object b10;
        Object valueOf;
        if (intent == null) {
            return;
        }
        if (C7.a.a()) {
            H7.b.e("DetailActivityFragment", "Invalid click return --------------");
            return;
        }
        try {
            Result.a aVar = Result.f34166a;
            if (TextUtils.equals(intent.getAction(), "oplus.intent.contacts.action.VIEW_CALL_LOGS")) {
                valueOf = Boolean.valueOf(R7.b.f(o3(), intent, 0, null, 6, null));
            } else if (TextUtils.equals(intent.getAction(), com.customize.contacts.manager.i.f21551a)) {
                if (com.android.contacts.util.w.k(getActivity(), com.android.contacts.util.w.e())) {
                    valueOf = Boolean.valueOf(S7.b.c(this, intent, 889, 0, 4, null));
                } else {
                    this.f14399A0 = intent;
                    requestPermissions(new String[]{com.android.contacts.util.w.e()}, 1);
                    valueOf = m9.q.f35511a;
                }
            } else if (TextUtils.equals(intent.getAction(), "oplus.intent.action.settings.VIBRATE_PICKER")) {
                com.customize.contacts.manager.h.c(this, intent);
                valueOf = m9.q.f35511a;
            } else {
                if (TextUtils.equals(intent.getAction(), "com.oplus.contacts.black.action")) {
                    final boolean c10 = C7.e.c(intent, "is_black", false);
                    Parcelable j10 = C7.e.j(intent, "black_list_data");
                    kotlin.jvm.internal.i.e(j10, "getParcelableExtra(inten…actsKeys.BLACK_LIST_DATA)");
                    final ArrayList<String> m10 = ((ContactParcelable) j10).m();
                    if (m10 != null && m10.size() != 0) {
                        com.android.contacts.framework.api.appstore.appinfo.a.a(getActivity(), new Runnable() { // from class: com.android.contacts.detail.S
                            @Override // java.lang.Runnable
                            public final void run() {
                                DetailActivityFragment.R3(c10, m10, this);
                            }
                        });
                        valueOf = m9.q.f35511a;
                    }
                    com.oplus.foundation.util.ui.c.b(o3().getApplicationContext(), R.string.oplus_no_phonenumber_tips);
                    return;
                }
                if (TextUtils.equals(intent.getAction(), "oplus.intent.action.AGENDA")) {
                    g3(intent);
                    valueOf = m9.q.f35511a;
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SENDTO")) {
                    intent.putExtra("open_from_dialog", false);
                    valueOf = Boolean.valueOf(R7.b.f(getContext(), intent, 0, null, 6, null));
                } else if (TextUtils.equals(C0421a.f6395a, intent.getAction())) {
                    Context o32 = o3();
                    Uri data = intent.getData();
                    kotlin.jvm.internal.i.c(data);
                    C0794e.b(o32, intent, data.getSchemeSpecificPart());
                    if (this.f14424Y) {
                        intent.putExtra("open_from_dialog", false);
                        intent.putExtra("dialer_from", "detail");
                        C0802m.a(getActivity(), intent);
                        int d10 = C7.e.d(intent, "android.telecom.extra.START_CALL_WITH_VIDEO_STATE", -1);
                        if (d10 == 3) {
                            com.android.contacts.framework.baseui.util.A.a(o3().getApplicationContext(), 2000319, 200030175, com.customize.contacts.util.h0.b0(getActivity()), false);
                        } else {
                            H7.b.e("DetailActivityFragment", "videoState = " + d10);
                        }
                    } else {
                        H7.b.e("DetailActivityFragment", "can not place call");
                    }
                    valueOf = m9.q.f35511a;
                } else if (TextUtils.equals(intent.getAction(), "com.oplus.contacts.deletecalllog.action")) {
                    h3(null);
                    valueOf = m9.q.f35511a;
                } else if (TextUtils.equals(intent.getAction(), "com.oplus.contacts.deletecontact.action")) {
                    S4();
                    valueOf = m9.q.f35511a;
                } else if (TextUtils.equals("oplus.intent.action.VIP_GROUP", intent.getAction())) {
                    boolean c11 = C7.e.c(intent, "is_black", false);
                    boolean c12 = C7.e.c(intent, "is_vip_group", false);
                    if (c11 && !c12) {
                        com.android.contacts.framework.api.appstore.appinfo.a.a(getActivity(), new Runnable() { // from class: com.android.contacts.detail.U
                            @Override // java.lang.Runnable
                            public final void run() {
                                DetailActivityFragment.S3(DetailActivityFragment.this, intent);
                            }
                        });
                    } else {
                        V4(intent);
                    }
                    valueOf = m9.q.f35511a;
                } else {
                    if (TextUtils.equals(intent.getAction(), "com.oplus.contacts.white.action")) {
                        final boolean c13 = C7.e.c(intent, "is_white", false);
                        Parcelable j11 = C7.e.j(intent, "black_list_data");
                        kotlin.jvm.internal.i.e(j11, "getParcelableExtra(inten…actsKeys.BLACK_LIST_DATA)");
                        final ArrayList<String> m11 = ((ContactParcelable) j11).m();
                        if (m11 != null && m11.size() != 0) {
                            com.android.contacts.framework.api.appstore.appinfo.a.a(getActivity(), new Runnable() { // from class: com.android.contacts.detail.V
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DetailActivityFragment.T3(c13, m11, this);
                                }
                            });
                            valueOf = m9.q.f35511a;
                        }
                        com.oplus.foundation.util.ui.c.b(o3().getApplicationContext(), R.string.oplus_no_phonenumber_tips);
                        return;
                    }
                    if (TextUtils.equals(intent.getAction(), C1498a.f36244c)) {
                        com.customize.contacts.util.h0.D(o3(), "emergency_contacts");
                    } else if (TextUtils.equals(intent.getAction(), C1498a.f36243b)) {
                        com.customize.contacts.util.h0.D(o3(), "medical_info");
                    }
                    intent.putExtra("open_from_dialog", false);
                    valueOf = Boolean.valueOf(R7.b.f(getContext(), intent, 0, null, 6, null));
                }
            }
            b10 = Result.b(valueOf);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d11 = Result.d(b10);
        if (d11 != null) {
            H7.b.c("DetailActivityFragment", "Exception = " + d11);
        }
    }

    public boolean U3(int i10, KeyEvent keyEvent) {
        ContactLoaderFragment contactLoaderFragment = this.f14406G;
        if (contactLoaderFragment != null && contactLoaderFragment.q0(i10)) {
            return true;
        }
        z0 z0Var = this.f14412M;
        if (z0Var != null && z0Var.q0(i10)) {
            return true;
        }
        return false;
    }

    public final void U4() {
        i0.f shareEntry;
        z0 z0Var = this.f14412M;
        if (z0Var != null && (shareEntry = z0Var.n2()) != null) {
            kotlin.jvm.internal.i.e(shareEntry, "shareEntry");
            if (K3()) {
                com.customize.contacts.util.h0.D(o3(), "QR_code");
            } else {
                com.customize.contacts.util.h0.w(o3(), "QR_code");
            }
            S3.n nVar = this.f14445t0;
            if (nVar != null) {
                nVar.f(o3());
            }
        }
    }

    public final void V4(final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean c10 = C7.e.c(intent, "is_black", false);
        final boolean c11 = C7.e.c(intent, "is_vip_group", false);
        if (!c11 && (o3() instanceof Activity)) {
            Context o32 = o3();
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(o32, str)) {
                Context o33 = o3();
                kotlin.jvm.internal.i.d(o33, "null cannot be cast to non-null type android.app.Activity");
                com.android.contacts.framework.baseui.util.l.f((Activity) o33, str, null, 0);
                return;
            }
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.P
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DetailActivityFragment.W4(DetailActivityFragment.this, intent, c11, c10, dialogInterface, i10);
            }
        };
        U0.b bVar = new U0.b(o3(), 2132083073);
        bVar.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.Q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DetailActivityFragment.X4(DetailActivityFragment.this, dialogInterface, i10);
            }
        });
        if (!c11) {
            bVar.setTitle(R.string.oplus_add_contacts_to_vip);
            if (B3.a.c0()) {
                if (OSPublicFeature.F()) {
                    bVar.setMessage(R.string.oplus_add_contacts_to_vip_tips_for_drive_mode_v2);
                } else {
                    bVar.setMessage(R.string.oplus_add_contacts_to_vip_tips_without_vibrate_for_drive_mode_v2);
                }
            }
            bVar.setPositiveButton(R.string.add, onClickListener);
        } else {
            bVar.setTitle(R.string.oplus_remove_contacts_from_vip_v2);
            bVar.setNeutralButton(R.string.remove, onClickListener);
        }
        androidx.appcompat.app.b show = bVar.show();
        kotlin.jvm.internal.i.e(show, "builder.show()");
        U0.n.d(show);
        d3(bVar);
    }

    public final void W3(int i10) {
        ThreadPoolExecutor threadPoolExecutor;
        NewCallRepository l22;
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment;
        NewCallRepository W12;
        NewCallRepository W13;
        HashMap<String, Integer> hashMap;
        String title;
        ArrayList<PopupListItem> arrayList = this.f14433h0;
        int i11 = -1;
        if (arrayList != null && (hashMap = this.f14432g0) != null && (title = arrayList.get(i10).getTitle()) != null) {
            kotlin.jvm.internal.i.e(title, "title");
            Integer num = hashMap.get(title);
            if (num != null) {
                i11 = num.intValue();
            }
        }
        if (i11 != 0) {
            switch (i11) {
                case 2:
                case 3:
                    final z0 z0Var = this.f14412M;
                    if (z0Var != null) {
                        com.android.contacts.framework.api.appstore.appinfo.a.a(z0Var.getContext(), new Runnable() { // from class: com.android.contacts.detail.H
                            @Override // java.lang.Runnable
                            public final void run() {
                                DetailActivityFragment.X3(z0.this, this);
                            }
                        });
                        return;
                    }
                    return;
                case 4:
                case 5:
                    O3();
                    return;
                case 6:
                    i3();
                    return;
                case 7:
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment2 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment2 != null) {
                        callDetailUnfamiliarNumberFragment2.S1();
                        return;
                    }
                    return;
                case 8:
                    com.customize.contacts.util.h0.w(o3(), "add_old");
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment3 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment3 != null) {
                        callDetailUnfamiliarNumberFragment3.E2();
                        return;
                    }
                    return;
                case 9:
                    if (this.f14451z0.f14363f) {
                        com.customize.contacts.util.h0.w(o3(), "change_tag");
                    } else {
                        com.customize.contacts.util.h0.w(o3(), "tag");
                    }
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment4 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment4 != null) {
                        callDetailUnfamiliarNumberFragment4.t2();
                        return;
                    }
                    return;
                case 10:
                    FragmentActivity activity = getActivity();
                    if (activity != null && com.android.contacts.framework.baseui.util.l.d(activity, "com.ted.number")) {
                        com.android.contacts.framework.baseui.util.l.f(activity, "com.ted.number", null, 0);
                        return;
                    }
                    com.customize.contacts.util.h0.w(o3(), "error_correct_feedback");
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment5 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment5 != null) {
                        callDetailUnfamiliarNumberFragment5.s2();
                        return;
                    }
                    return;
                case 11:
                    K4();
                    return;
                case 12:
                    f4();
                    return;
                case 13:
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        String str = C1501d.f36273b;
                        if (com.android.contacts.framework.baseui.util.l.d(activity2, str)) {
                            com.android.contacts.framework.baseui.util.l.f(activity2, str, null, 0);
                            return;
                        }
                    }
                    CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment6 = this.f14441p0;
                    if (callDetailUnfamiliarNumberFragment6 != null) {
                        callDetailUnfamiliarNumberFragment6.P1();
                        return;
                    }
                    return;
                case 14:
                    com.customize.contacts.util.h0.w(o3(), "allowlist");
                    if (this.f14419T) {
                        com.android.contacts.framework.api.appstore.appinfo.a.a(getActivity(), new Runnable() { // from class: com.android.contacts.detail.I
                            @Override // java.lang.Runnable
                            public final void run() {
                                DetailActivityFragment.Y3(DetailActivityFragment.this);
                            }
                        });
                        return;
                    } else {
                        O3();
                        return;
                    }
                case 15:
                    com.customize.contacts.util.h0.w(o3(), "cancel_allowlist");
                    if (this.f14419T) {
                        FragmentActivity activity3 = getActivity();
                        if (activity3 != null) {
                            String str2 = C1501d.f36273b;
                            if (com.android.contacts.framework.baseui.util.l.d(activity3, str2)) {
                                com.android.contacts.framework.baseui.util.l.f(activity3, str2, null, 0);
                                return;
                            }
                        }
                        com.android.contacts.framework.api.appstore.appinfo.a.a(activity3, new Runnable() { // from class: com.android.contacts.detail.J
                            @Override // java.lang.Runnable
                            public final void run() {
                                DetailActivityFragment.Z3(DetailActivityFragment.this);
                            }
                        });
                        return;
                    }
                    O3();
                    return;
                case 16:
                    if (this.f14412M != null) {
                        U4();
                        return;
                    }
                    return;
                case 17:
                    if (this.f14410K != null && this.f14416Q != null && (threadPoolExecutor = this.f14443r0) != null) {
                        threadPoolExecutor.execute(new Runnable() { // from class: com.android.contacts.detail.K
                            @Override // java.lang.Runnable
                            public final void run() {
                                DetailActivityFragment.a4(DetailActivityFragment.this);
                            }
                        });
                        return;
                    }
                    return;
                case 18:
                    O4();
                    return;
                case 19:
                    if (J3()) {
                        int i12 = this.f14430e0;
                        if (i12 == 0) {
                            CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment7 = this.f14413N;
                            if (callDetailUnfamiliarNumberFragment7 != null && (W13 = callDetailUnfamiliarNumberFragment7.W1()) != null) {
                                W13.p(getContext());
                                return;
                            }
                            return;
                        }
                        if (i12 == 1 && (callDetailUnfamiliarNumberFragment = this.f14414O) != null && (W12 = callDetailUnfamiliarNumberFragment.W1()) != null) {
                            W12.p(getContext());
                            return;
                        }
                        return;
                    }
                    z0 z0Var2 = this.f14412M;
                    if (z0Var2 != null && (l22 = z0Var2.l2()) != null) {
                        l22.p(getContext());
                        return;
                    }
                    return;
                case 20:
                    I3();
                    com.customize.contacts.util.h0.Y(1);
                    return;
                default:
                    return;
            }
        }
        if (C7.a.a()) {
            return;
        }
        this.f14401C0.b(this.f14416Q);
    }

    public final void Y4(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (o3() instanceof Activity) {
            Context o32 = o3();
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(o32, str)) {
                Context o33 = o3();
                kotlin.jvm.internal.i.d(o33, "null cannot be cast to non-null type android.app.Activity");
                com.android.contacts.framework.baseui.util.l.f((Activity) o33, str, null, 0);
                return;
            }
        }
        if (i10 == 1) {
            boolean A10 = B3.a.A();
            i11 = R.string.dialog_title_add_blacklist;
            if (A10) {
                if (B3.a.Y()) {
                    i12 = R.string.intercept_contact_use_third_mms_tips_v2;
                } else {
                    i12 = R.string.intercept_contact_except_mms_tips_v2;
                }
            } else {
                i12 = R.string.intercept_contact_tips_v2;
            }
        } else {
            boolean A11 = B3.a.A();
            i11 = R.string.dialog_title_add_whitelist;
            if (A11) {
                i12 = R.string.oplus_insert_contact_whitelist_except_mms_tips_v2;
            } else {
                i12 = R.string.oplus_insert_contact_whitelist_tips_v2;
            }
        }
        if (this.f14419T) {
            if (i10 == 1) {
                if (B3.a.A()) {
                    if (B3.a.Y()) {
                        i14 = R.string.intercept_number_use_third_mms_tips_v2;
                    } else {
                        i14 = R.string.intercept_number_except_mms_tips_v2;
                    }
                } else {
                    i14 = R.string.intercept_number_tips_v2;
                }
                i12 = i14;
                i11 = R.string.dialog_title_add_number_blacklist;
            } else {
                if (B3.a.A()) {
                    i13 = R.string.oplus_intercept_number_whitelist_except_mms_tips_v2;
                } else {
                    i13 = R.string.oplus_intercept_number_whitelist_tips_v2;
                }
                i12 = i13;
                i11 = R.string.dialog_title_add_number_whitelist;
            }
        }
        g gVar = new g(i10);
        U0.b bVar = new U0.b(o3(), 2132083073);
        bVar.setTitle(i11).setMessage(i12).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) gVar).setNeutralButton(R.string.add, (DialogInterface.OnClickListener) gVar);
        U0.n.d(bVar.show());
        d3(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [m9.q] */
    public final Date Z4(String str) {
        Date date;
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        Date date2 = null;
        try {
            Result.a aVar = Result.f34166a;
            if (str != null) {
                date2 = dateInstance.parse(str);
                date2 = m9.q.f35511a;
                date = date2;
            } else {
                date = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Result.b(date2);
            return date;
        } catch (Throwable th2) {
            date2 = date;
            th = th2;
            Result.a aVar2 = Result.f34166a;
            Result.b(kotlin.b.a(th));
            return date2;
        }
    }

    public final void a3() {
        COUIPopupListWindow cOUIPopupListWindow = this.f14436k0;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.menu_newContact), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.add_to_saved_contacts), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.android.contacts.detail.Y
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                DetailActivityFragment.b3(DetailActivityFragment.this, adapterView, view, i10, j10);
            }
        };
        COUIPopupListWindow cOUIPopupListWindow2 = new COUIPopupListWindow(o3());
        cOUIPopupListWindow2.setItemList(arrayList);
        cOUIPopupListWindow2.setDismissTouchOutside(true);
        cOUIPopupListWindow2.setOnItemClickListener(onItemClickListener);
        cOUIPopupListWindow2.show(n1(R.id.add));
        this.f14436k0 = cOUIPopupListWindow2;
    }

    public final long a5(String str) {
        Date Z42 = Z4(F7.b.b(o3(), str));
        if (Z42 != null) {
            return Z42.getTime();
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if ((!r2.isEmpty()) == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b5() {
        /*
            r4 = this;
            boolean r0 = r4.J3()
            r1 = 0
            if (r0 == 0) goto L20
            r4.G3()
            android.view.MenuItem r0 = r4.f14450y0
            if (r0 != 0) goto Lf
            goto L20
        Lf:
            java.util.ArrayList<com.coui.appcompat.poplist.PopupListItem> r2 = r4.f14433h0
            if (r2 == 0) goto L1c
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 != r3) goto L1c
            goto L1d
        L1c:
            r3 = r1
        L1d:
            r0.setVisible(r3)
        L20:
            boolean r0 = r4.j3()
            if (r0 != 0) goto L2e
            android.view.MenuItem r4 = r4.f14450y0
            if (r4 != 0) goto L2b
            goto L2e
        L2b:
            r4.setEnabled(r1)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.DetailActivityFragment.b5():void");
    }

    public final void c3(ArrayList<PopupListItem> arrayList, boolean z10) {
        i0.f fVar;
        Intent intent;
        boolean z11;
        i0.f fVar2;
        boolean z12;
        z0 z0Var;
        NewCallRepository l22;
        LiveData<Boolean> k10;
        if (!C0637b.h()) {
            if (B3.a.B() && z10 && !K3()) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_qr_code), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
            if (CommonFeatureOption.o(getContext())) {
                PopupListItem e10 = com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_share), false, false, 0, null, null, 0, null, null, null, 0, 2046, null);
                e10.setSubMenuItemList(E3());
                arrayList.add(e10);
            }
        }
        if (!K3()) {
            z0 z0Var2 = this.f14412M;
            Intent intent2 = null;
            if (z0Var2 != null) {
                fVar = z0Var2.p2();
            } else {
                fVar = null;
            }
            if (fVar != null) {
                intent = fVar.f14629s;
            } else {
                intent = null;
            }
            boolean z13 = false;
            if (intent != null) {
                z11 = C7.e.c(fVar.f14629s, "is_vip_group", false);
            } else {
                z11 = false;
            }
            if (CommonFeatureOption.o(getContext()) && (z0Var = this.f14412M) != null && (l22 = z0Var.l2()) != null && (k10 = l22.k()) != null && kotlin.jvm.internal.i.b(k10.getValue(), Boolean.TRUE)) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.menu_message_box), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
            boolean c10 = L7.a.c();
            ContactLoader.Result result = this.f14410K;
            if (z11) {
                if (result == null || !TextUtils.equals("com.android.oplus.sim", result.p())) {
                    arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_remove_contacts_from_vip), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                }
                if (!c10 && !C0811w.f()) {
                    arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.create_contacts_shortcut), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                }
            } else {
                if (result == null || !TextUtils.equals("com.android.oplus.sim", result.p())) {
                    arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_add_contacts_to_vip), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                }
                if (!c10 && !C0811w.f()) {
                    arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.create_contacts_shortcut), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                }
                if (PrimaryUserUtils.a() && !B3.a.p() && CommonFeatureOption.j()) {
                    z0 z0Var3 = this.f14412M;
                    if (z0Var3 != null) {
                        fVar2 = z0Var3.g2();
                    } else {
                        fVar2 = null;
                    }
                    if (fVar2 != null) {
                        intent2 = fVar2.f14629s;
                    }
                    if (intent2 != null) {
                        boolean c11 = C7.e.c(fVar2.f14629s, "is_black", false);
                        z12 = C7.e.c(fVar2.f14629s, "is_white", false);
                        z13 = c11;
                    } else {
                        z12 = false;
                    }
                    if (this.f14423X) {
                        if (z12) {
                            arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_remove_contact_from_whitelist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                        } else {
                            arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_add_contact_to_whitelist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                        }
                    } else if (z13) {
                        arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.remove_from_blacklist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                    } else {
                        arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_intercept_contact), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                    }
                }
            }
            if (result != null && !TextUtils.equals("com.android.oplus.sim", result.p()) && com.android.contacts.util.B.b(getContext(), result.O())) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.quick_dial_add_to_desktop), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
        }
    }

    public final void c4(Context context) {
        Object b10;
        kotlin.jvm.internal.i.f(context, "context");
        if (!this.f14448w0 && !this.f14449x0) {
            try {
                Result.a aVar = Result.f34166a;
                if (B3.a.i()) {
                    if (D7.c.r(context, 0) >= 0) {
                        D7.c.l(context, this.f14405F0, 33, 0);
                        this.f14448w0 = true;
                    }
                    if (D7.c.r(context, 1) >= 0) {
                        D7.c.l(context, this.f14405F0, 33, 1);
                        this.f14448w0 = true;
                    }
                } else {
                    Object systemService = context.getSystemService("phone");
                    kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                    ((TelephonyManager) systemService).listen(this.f14405F0, 33);
                    this.f14448w0 = true;
                }
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            if (Result.d(b10) != null) {
                H7.b.c("DetailActivityFragment", "registerListener error");
            }
        }
    }

    public final void d3(U0.b bVar) {
        if (kotlin.jvm.internal.i.b(getTag(), "unfold_dial_contact")) {
            U0.m.b(bVar);
        } else if (kotlin.jvm.internal.i.b(getTag(), "right_fragment_tag_show_detail")) {
            U0.m.a(bVar);
        }
    }

    public final void d4(Context context) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            if (B3.a.i()) {
                D7.c.l(context, this.f14405F0, 0, 0);
                D7.c.l(context, this.f14405F0, 0, 1);
            } else {
                Object systemService = context.getSystemService("phone");
                kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                ((TelephonyManager) systemService).listen(this.f14405F0, 0);
            }
            this.f14448w0 = false;
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (Result.d(b10) != null) {
            H7.b.c("DetailActivityFragment", "removeAllListener error");
        }
    }

    public void e3() {
        H7.b.e("DetailActivityFragment", "black menu clicked, but do nothing");
    }

    public final void e4(ArrayList<String> arrayList, int i10) {
        if (i10 == 1) {
            BlackListUtils.o(o3(), this.f14422W, arrayList, false, false, false);
        } else {
            BlackListUtils.p(getContext(), this.f14422W, arrayList, false, false);
        }
    }

    public final boolean f3(Intent intent) {
        String str;
        ContactLoader.Result result = this.f14410K;
        if (result == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (result.B() != null && ((result.C() != 20 || result.B().length() > 6) && result.C() != 10)) {
            stringBuffer.append(result.B() + ":\n");
        }
        ArrayList<String> P10 = result.P();
        HashSet hashSet = new HashSet();
        Iterator<String> it = P10.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                String d10 = U7.f.d(next);
                if (!hashSet.contains(d10)) {
                    hashSet.add(d10);
                    stringBuffer.append(d10 + "；\n");
                }
            }
        }
        hashSet.clear();
        Iterator<Entity> it2 = result.D().iterator();
        while (it2.hasNext()) {
            Iterator<Entity.NamedContentValues> it3 = it2.next().getSubValues().iterator();
            while (it3.hasNext()) {
                ContentValues contentValues = it3.next().values;
                String asString = contentValues.getAsString("mimetype");
                if (asString != null && kotlin.jvm.internal.i.b(asString, "vnd.android.cursor.item/email_v2")) {
                    String asString2 = contentValues.getAsString("data1");
                    if (!hashSet.contains(asString2)) {
                        hashSet.add(asString2);
                        stringBuffer.append(asString2 + "；\n");
                    }
                }
            }
        }
        hashSet.clear();
        int length = stringBuffer.length();
        if (length > 0) {
            str = stringBuffer.substring(0, length - 1);
        } else {
            str = "";
        }
        if (H7.a.b()) {
            H7.b.b("DetailActivityFragment", "numbersBuffer = ");
        }
        if (TextUtils.isEmpty(str)) {
            com.oplus.foundation.util.ui.c.b(o3(), R.string.donot_share);
            return false;
        }
        intent.setType("text/plain");
        if (!(str instanceof CharSequence)) {
            str = null;
        }
        intent.putExtra("android.intent.extra.TEXT", (CharSequence) str);
        return true;
    }

    public final void f4() {
        com.customize.contacts.util.h0.w(o3(), "cancel_blocklist");
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = this.f14441p0;
        if (callDetailUnfamiliarNumberFragment != null) {
            callDetailUnfamiliarNumberFragment.C2();
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean g2() {
        return E1();
    }

    public final void g3(Intent intent) {
        Boolean bool;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        if (P7.c.c(o3(), "com.oplus.calendar", false)) {
            intent2.setDataAndType(Uri.parse("content://com.oplus.calendar/"), "time/epoch");
        } else {
            intent2.setType("vnd.android.cursor.item/event");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                bool = Boolean.valueOf(com.android.contacts.framework.baseui.util.l.c(activity, intent2));
            } else {
                bool = null;
            }
            kotlin.jvm.internal.i.c(bool);
            if (!bool.booleanValue()) {
                FragmentActivity requireActivity = requireActivity();
                kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
                String l32 = l3(requireActivity, intent2);
                if (!TextUtils.isEmpty(l32)) {
                    H7.b.b("DetailActivityFragment", "getDefaultCalendarPackage: " + l32);
                    if (com.android.contacts.framework.baseui.util.l.d(requireActivity(), l32)) {
                        com.android.contacts.framework.baseui.util.l.f(requireActivity(), l32, null, 0);
                        return;
                    }
                }
            }
        }
        String dataStr = C7.e.l(intent, "event_data");
        if (C7.e.c(intent, "is_lunar", false)) {
            dataStr = com.customize.contacts.util.N.i(o3(), dataStr);
        } else {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            int i10 = calendar.get(1);
            calendar.add(5, -1);
            Date time = calendar.getTime();
            if (!TextUtils.isEmpty(dataStr) && dataStr.length() > 4) {
                kotlin.jvm.internal.i.e(dataStr, "dataStr");
                String substring = dataStr.substring(4);
                kotlin.jvm.internal.i.e(substring, "substring(...)");
                dataStr = i10 + substring;
                Date r10 = F7.b.r(dataStr);
                if (r10 != null && r10.before(time)) {
                    kotlin.jvm.internal.i.e(dataStr, "dataStr");
                    String substring2 = dataStr.substring(4);
                    kotlin.jvm.internal.i.e(substring2, "substring(...)");
                    dataStr = (i10 + 1) + substring2;
                }
            }
        }
        intent2.putExtra("beginTime", a5(dataStr));
        R7.b.f(getContext(), intent2, 0, null, 6, null);
    }

    public final void g4(int i10) {
        ContactLoader.Result result = this.f14410K;
        if (result == null) {
            return;
        }
        String K10 = result.K();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("send_entrance", o3().getPackageName());
        if (i10 == 1) {
            if (!f3(intent)) {
                return;
            }
        } else {
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, K10);
            intent.setType("text/x-vcard");
            intent.putExtra("android.intent.extra.STREAM", withAppendedPath);
        }
        CharSequence text = getText(R.string.share_via);
        kotlin.jvm.internal.i.e(text, "getText(R.string.share_via)");
        R7.b.f(getContext(), Intent.createChooser(intent, text), R.string.share_account_error, null, 4, null);
        com.android.contacts.framework.api.infocollection.a.c();
    }

    public final void i3() {
        if (K3()) {
            com.customize.contacts.util.h0.D(o3(), "delete");
        } else {
            com.customize.contacts.util.h0.w(o3(), "delete");
        }
        S4();
    }

    public boolean j3() {
        return true;
    }

    public final void j4(CallDetailUnfamiliarNumberFragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f14441p0 = fragment;
    }

    public final MenuItem k3(int i10) {
        Menu menu;
        if (CommonFeatureOption.o(getContext())) {
            Menu u12 = u1();
            if (u12 == null) {
                return null;
            }
            return u12.findItem(i10);
        }
        COUINavigationView cOUINavigationView = this.f14439n0;
        if (cOUINavigationView == null || (menu = cOUINavigationView.getMenu()) == null) {
            return null;
        }
        return menu.findItem(i10);
    }

    public final void k4(boolean z10) {
        this.f14419T = z10;
    }

    public final String l3(Context context, Intent intent) {
        Object v10;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 512);
        kotlin.jvm.internal.i.e(queryIntentActivities, "context.packageManager.q…ATCH_DISABLED_COMPONENTS)");
        Object obj = null;
        if (!(!queryIntentActivities.isEmpty())) {
            return null;
        }
        Iterator<T> it = queryIntentActivities.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (M3(((ResolveInfo) next).activityInfo.packageName)) {
                obj = next;
                break;
            }
        }
        ResolveInfo resolveInfo = (ResolveInfo) obj;
        if (resolveInfo == null) {
            v10 = CollectionsKt___CollectionsKt.v(queryIntentActivities);
            resolveInfo = (ResolveInfo) v10;
        }
        return resolveInfo.activityInfo.packageName;
    }

    public final void l4(boolean z10) {
        this.f14423X = z10;
    }

    public final boolean m3() {
        return this.f14415P;
    }

    public final ContactLoader.Result n3() {
        return this.f14410K;
    }

    public final void n4(boolean z10) {
        this.f14415P = z10;
    }

    public final Context o3() {
        Context context = this.f14427b0;
        if (context != null) {
            return context;
        }
        kotlin.jvm.internal.i.q("mContext");
        return null;
    }

    public final void o4(ContactLoader.Result result) {
        this.f14410K = result;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        z0 z0Var;
        ContactLoaderFragment contactLoaderFragment;
        int i12;
        super.onActivityResult(i10, i11, intent);
        if (3 == i10) {
            if (i11 == -1) {
                if (this.f14421V) {
                    o1();
                    return;
                }
                return;
            } else {
                Context o32 = o3();
                if (this.f14421V) {
                    i12 = R.string.oplus_cancel_cut_contact;
                } else {
                    i12 = R.string.oplus_cancel_copy_contact;
                }
                com.oplus.foundation.util.ui.c.b(o32, i12);
                return;
            }
        }
        ContactLoader.Result result = null;
        if (889 == i10) {
            if (com.customize.contacts.manager.i.l(intent)) {
                H7.b.b("DetailActivityFragment", "onActivityResult, no need save ringTone from settings.");
                return;
            }
            if (intent != null && intent.hasExtra("android.intent.extra.ringtone.PICKED_URI")) {
                Uri uri = (Uri) C7.e.j(intent, "android.intent.extra.ringtone.PICKED_URI");
                if (com.customize.contacts.manager.i.f21553c) {
                    ContactLoaderFragment contactLoaderFragment2 = this.f14406G;
                    if (contactLoaderFragment2 != null) {
                        contactLoaderFragment2.k1(uri);
                        return;
                    }
                    return;
                }
                ContactLoaderFragment contactLoaderFragment3 = this.f14406G;
                if (contactLoaderFragment3 != null) {
                    contactLoaderFragment3.k1(com.customize.contacts.manager.i.h(uri, o3()));
                    return;
                }
                return;
            }
            if (com.customize.contacts.manager.i.f21553c && (contactLoaderFragment = this.f14406G) != null) {
                contactLoaderFragment.k1(null);
                return;
            }
            return;
        }
        if (989 == i10) {
            int d10 = C7.e.d(intent, "final_vibrate_type", -1);
            String l10 = C7.e.l(intent, "final_vibrate_title_res_key");
            ContactLoaderFragment contactLoaderFragment4 = this.f14406G;
            if (contactLoaderFragment4 != null) {
                contactLoaderFragment4.l1(d10, l10);
                return;
            }
            return;
        }
        if (123 == i10) {
            if (i11 == -1 && (z0Var = this.f14412M) != null) {
                z0Var.f14719N = true;
            }
            if (i11 != 20 && (i11 != -1 || intent == null || !C7.e.c(intent, "uriIsInvalidated", false))) {
                if (i11 == -1 && intent != null && C7.e.j(intent, "sim_contacts_info") != null) {
                    V1(intent);
                    ContactLoaderFragment contactLoaderFragment5 = this.f14406G;
                    if (contactLoaderFragment5 != null) {
                        Parcelable j10 = C7.e.j(intent, "sim_contacts_info");
                        kotlin.jvm.internal.i.d(j10, "null cannot be cast to non-null type com.android.contacts.framework.baseui.sim.SimContactInfo");
                        contactLoaderFragment5.m1((SimContactInfo) j10);
                        return;
                    }
                    return;
                }
                if (i11 == -1 && intent != null) {
                    V1(intent);
                    ContactLoaderFragment contactLoaderFragment6 = this.f14406G;
                    if (contactLoaderFragment6 != null) {
                        contactLoaderFragment6.n1(intent.getData());
                        return;
                    }
                    return;
                }
                return;
            }
            if (!this.f14408I) {
                this.f14418S = true;
                o1();
                return;
            }
            if (i11 == 20 && this.f14442q0) {
                this.f14418S = true;
                o1();
                return;
            }
            z0 z0Var2 = this.f14412M;
            if (z0Var2 != null) {
                if (z0Var2 != null) {
                    result = z0Var2.f14744d;
                }
                if (result == null) {
                    this.f14418S = true;
                    o1();
                    return;
                }
                return;
            }
            return;
        }
        if (133 == i10 && i11 == 20) {
            o1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        Bundle bundle;
        kotlin.jvm.internal.i.f(fragment, "fragment");
        if (fragment instanceof ContactLoaderFragment) {
            ContactLoaderFragment contactLoaderFragment = (ContactLoaderFragment) fragment;
            this.f14406G = contactLoaderFragment;
            contactLoaderFragment.p1(this.f14401C0);
            Parcelable j10 = C7.e.j(t1(), "sim_contacts_info");
            if (j10 != null && (j10 instanceof SimContactInfo)) {
                this.f14442q0 = true;
                contactLoaderFragment.m1((SimContactInfo) j10);
                return;
            }
            this.f14442q0 = false;
            Uri uri = null;
            if (C1641a.l(o3(), FeatureOption.o())) {
                Intent t12 = t1();
                if (t12 != null) {
                    bundle = t12.getExtras();
                } else {
                    bundle = null;
                }
                if (bundle != null) {
                    this.f14446u0 = bundle.getBoolean("from_calllog", false);
                    this.f14447v0 = bundle.getString("number", "");
                }
                contactLoaderFragment.o1(this.f14446u0, this.f14447v0);
            }
            Intent t13 = t1();
            if (t13 != null) {
                uri = t13.getData();
            }
            contactLoaderFragment.n1(uri);
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        p4(requireContext);
        this.f14409J = R.string.viewContactTitle;
        super.onCreate(bundle);
        this.f14417R = C7.e.c(t1(), "finishActivityOnUpSelected", false);
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Object b10;
        super.onDestroy();
        U0.n.h();
        c cVar = f14398H0;
        if (cVar != null) {
            cVar.d();
            f14398H0 = null;
        }
        b bVar = this.f14425Z;
        if (bVar != null) {
            bVar.a();
            this.f14425Z = null;
        }
        if (this.f14404F) {
            try {
                Result.a aVar = Result.f34166a;
                X.a b11 = X.a.b(o3());
                kotlin.jvm.internal.i.e(b11, "getInstance(mContext)");
                b11.e(this.f14402D0);
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("DetailActivityFragment", "Exception e: " + d10);
            }
            this.f14404F = false;
        }
        Dialog dialog = this.f14429d0;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        COUIPopupListWindow cOUIPopupListWindow = this.f14431f0;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.dismiss();
            this.f14431f0 = null;
        }
        COUIPopupListWindow cOUIPopupListWindow2 = this.f14436k0;
        if (cOUIPopupListWindow2 != null) {
            cOUIPopupListWindow2.dismiss();
        }
        this.f14436k0 = null;
        COUIPopupListWindow cOUIPopupListWindow3 = this.f14437l0;
        if (cOUIPopupListWindow3 != null) {
            cOUIPopupListWindow3.dismiss();
        }
        this.f14437l0 = null;
        ThreadPoolExecutor threadPoolExecutor = this.f14443r0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f14443r0 = null;
        }
        if (C1643c.w()) {
            C1643c.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z10) {
        super.onMultiWindowModeChanged(z10);
        U0.n.h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f14449x0 = true;
        ThreadPoolExecutor threadPoolExecutor = this.f14443r0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.android.contacts.detail.W
                @Override // java.lang.Runnable
                public final void run() {
                    DetailActivityFragment.V3(DetailActivityFragment.this);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        boolean z10;
        kotlin.jvm.internal.i.f(permissions, "permissions");
        kotlin.jvm.internal.i.f(grantResults, "grantResults");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            int length = grantResults.length;
            int i11 = 0;
            while (true) {
                if (i11 < length) {
                    if (grantResults[i11] != 0) {
                        z10 = false;
                        break;
                    }
                    i11++;
                } else {
                    z10 = true;
                    break;
                }
            }
            if (i10 == 1) {
                if (z10) {
                    Intent intent = this.f14399A0;
                    if (intent != null) {
                        S7.b.c(this, intent, 889, 0, 4, null);
                        return;
                    }
                    return;
                }
                if (!shouldShowRequestPermissionRationale(com.android.contacts.util.w.e())) {
                    com.android.contacts.util.w.y(activity, false, null, com.android.contacts.util.w.e());
                }
            }
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f14424Y = true;
        this.f14449x0 = false;
        ThreadPoolExecutor threadPoolExecutor = this.f14443r0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.android.contacts.detail.X
                @Override // java.lang.Runnable
                public final void run() {
                    DetailActivityFragment.b4(DetailActivityFragment.this);
                }
            });
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Uri uri;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        Y1(getToolbar());
        com.customize.contacts.fragment.J s12 = s1();
        if (s12 != null) {
            s12.a(true);
            s12.b(false);
        }
        if (H7.a.b()) {
            Intent t12 = t1();
            Uri uri2 = null;
            if (t12 != null) {
                uri = t12.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                Intent t13 = t1();
                if (t13 != null) {
                    uri2 = t13.getData();
                }
                H7.b.e("DetailActivityFragment", String.valueOf(uri2));
            }
        }
        if (!this.f14404F) {
            X.a b10 = X.a.b(o3());
            kotlin.jvm.internal.i.e(b10, "getInstance(mContext)");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.DETAIL_UPDATE_DONE");
            b10.c(this.f14402D0, intentFilter);
            this.f14404F = true;
        }
        this.f14420U = new d(this);
        this.f14428c0 = C7.e.l(t1(), "keyWord");
        this.f14443r0 = N7.a.a();
        if (H7.a.b()) {
            H7.b.b("DetailActivityFragment", "mKeyWord = " + this.f14428c0);
        }
    }

    public final z0 p3() {
        return this.f14412M;
    }

    public final void p4(Context context) {
        kotlin.jvm.internal.i.f(context, "<set-?>");
        this.f14427b0 = context;
    }

    public final int q3() {
        return this.f14430e0;
    }

    public final void q4(z0 z0Var) {
        this.f14412M = z0Var;
    }

    public final boolean r3() {
        return this.f14408I;
    }

    public final void r4(int i10) {
        this.f14430e0 = i10;
    }

    public final boolean s3() {
        return this.f14446u0;
    }

    public final void s4(boolean z10) {
        this.f14408I = z10;
    }

    public final boolean t3() {
        return this.f14434i0;
    }

    public final void t4(boolean z10) {
        this.f14446u0 = z10;
    }

    public final boolean u3() {
        return this.f14411L;
    }

    public final void u4(boolean z10) {
        this.f14434i0 = z10;
    }

    public final boolean v3() {
        return this.f14435j0;
    }

    public final void v4(boolean z10) {
        this.f14411L = z10;
    }

    public final ContactLoaderFragment w3() {
        return this.f14406G;
    }

    public final void w4(boolean z10) {
        this.f14435j0 = z10;
    }

    public final String x3() {
        return this.f14447v0;
    }

    public final void x4(ArrayList<PopupListItem> arrayList) {
        this.f14433h0 = arrayList;
    }

    public final ArrayList<String> y3() {
        return this.f14407H;
    }

    public final void y4(HashMap<String, Integer> hashMap) {
        this.f14432g0 = hashMap;
    }

    public final CallDetailUnfamiliarNumberFragment z3() {
        return this.f14414O;
    }

    public final void z4(String str) {
        this.f14447v0 = str;
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class f extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<DetailActivityFragment> f14458a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f14459b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14460c;

        /* renamed from: d, reason: collision with root package name */
        public com.google.common.collect.p<Account, Long> f14461d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f14462e;

        public f(DetailActivityFragment fragment, boolean z10, com.google.common.collect.p<Account, Long> pVar, boolean z11, ArrayList<String> arrayList) {
            kotlin.jvm.internal.i.f(fragment, "fragment");
            this.f14458a = new WeakReference<>(fragment);
            this.f14459b = z10;
            this.f14460c = z11;
            this.f14461d = pVar;
            this.f14462e = arrayList;
        }

        public static final void c(f this$0) {
            FragmentActivity fragmentActivity;
            kotlin.jvm.internal.i.f(this$0, "this$0");
            DetailActivityFragment detailActivityFragment = this$0.f14458a.get();
            if (detailActivityFragment != null) {
                fragmentActivity = detailActivityFragment.getActivity();
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                com.oplus.foundation.util.ui.c.b(fragmentActivity, R.string.read_only_contact_to_vip_tips_tablet);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... params) {
            FragmentActivity activity;
            com.google.common.collect.p<Account, Long> pVar;
            Object b10;
            long j10;
            HashMap<Account, Long> Z9;
            ArrayList<String> arrayList;
            long h10;
            kotlin.jvm.internal.i.f(params, "params");
            DetailActivityFragment detailActivityFragment = this.f14458a.get();
            if (detailActivityFragment != null && (activity = detailActivityFragment.getActivity()) != null && (pVar = this.f14461d) != null) {
                try {
                    if (!pVar.isEmpty()) {
                        try {
                            Result.a aVar = Result.f34166a;
                            AbstractC1362a h11 = AbstractC1362a.h(activity);
                            if (H7.a.b()) {
                                H7.b.b("DetailActivityFragment", "mIsInVipGroup = " + this.f14459b + " ,mIsInBlackList = " + this.f14460c);
                            }
                            long j11 = -1;
                            if (!this.f14459b) {
                                boolean z10 = false;
                                boolean z11 = false;
                                for (Account account : pVar.keySet()) {
                                    if (h11.c(account.f16942b, null).b()) {
                                        long j12 = N3.b.j(activity, "Vip in ColorOS", account);
                                        if (j12 != j11) {
                                            h10 = j12;
                                        } else {
                                            h10 = N3.b.h(activity, account);
                                        }
                                        if (h10 > 0) {
                                            Collection<Long> collection = pVar.get(account);
                                            kotlin.jvm.internal.i.e(collection, "rawContactIdsMap.get(account)");
                                            N3.b.a(activity, collection, h10);
                                            e();
                                        }
                                        z11 = true;
                                        j11 = -1;
                                    } else {
                                        z10 = true;
                                    }
                                }
                                if (z10 && !z11) {
                                    activity.runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.g0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            DetailActivityFragment.f.c(DetailActivityFragment.f.this);
                                        }
                                    });
                                }
                                if (this.f14460c && (arrayList = this.f14462e) != null) {
                                    kotlin.jvm.internal.i.c(arrayList);
                                    if (arrayList.size() > 0) {
                                        detailActivityFragment.e4(this.f14462e, 1);
                                    }
                                }
                            } else {
                                com.google.common.collect.p<Account, Long> pVar2 = this.f14461d;
                                kotlin.jvm.internal.i.c(pVar2);
                                for (Account account2 : pVar2.keySet()) {
                                    boolean b11 = h11.c(account2.f16942b, null).b();
                                    ContactLoader.Result n32 = detailActivityFragment.n3();
                                    if (n32 != null && (Z9 = n32.Z()) != null && (!Z9.isEmpty()) && Z9.get(account2) != null) {
                                        Long l10 = Z9.get(account2);
                                        kotlin.jvm.internal.i.c(l10);
                                        j10 = l10.longValue();
                                    } else {
                                        j10 = -1;
                                    }
                                    if (b11 && j10 > 0) {
                                        Collection<Long> collection2 = pVar.get(account2);
                                        kotlin.jvm.internal.i.e(collection2, "rawContactIdsMap.get(account)");
                                        N3.b.r(activity, collection2, j10);
                                        e();
                                    }
                                }
                            }
                            b10 = Result.b(m9.q.f35511a);
                        } catch (Throwable th) {
                            Result.a aVar2 = Result.f34166a;
                            b10 = Result.b(kotlin.b.a(th));
                        }
                        Throwable d10 = Result.d(b10);
                        if (d10 != null) {
                            H7.b.c("DetailActivityFragment", "VipGroupTask error " + d10);
                        }
                        synchronized (detailActivityFragment.f14426a0) {
                            detailActivityFragment.f14426a0.notifyAll();
                            m9.q qVar = m9.q.f35511a;
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    synchronized (detailActivityFragment.f14426a0) {
                        detailActivityFragment.f14426a0.notifyAll();
                        m9.q qVar2 = m9.q.f35511a;
                        throw th2;
                    }
                }
            }
            return null;
        }

        public final void e() {
            Context context;
            ArrayList<String> arrayList;
            DetailActivityFragment detailActivityFragment = this.f14458a.get();
            if (detailActivityFragment != null && (context = detailActivityFragment.getContext()) != null && CommonFeatureOption.o(context) && (arrayList = this.f14462e) != null && !arrayList.isEmpty()) {
                Intent intent = new Intent("com.oplus.contacts.HANDLE_VIP_FINISHED");
                intent.putStringArrayListExtra("number_list_key", this.f14462e);
                X.a b10 = X.a.b(context);
                kotlin.jvm.internal.i.e(b10, "getInstance(ctx)");
                b10.d(intent);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
        }
    }

    public void I3() {
    }

    public void h3(PhoneCallDetails[] phoneCallDetailsArr) {
    }

    public void i4(ContactLoader.Result result) {
    }

    /* compiled from: DetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class h extends PhoneStateListener {
        public h() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            kotlin.jvm.internal.i.f(serviceState, "serviceState");
            if (H7.a.b()) {
                H7.b.b("DetailActivityFragment", "mPhoneStateListener.onServiceStateChanged mSimCount = " + DetailActivityFragment.this.B3() + " ,mStateChangedCount = " + DetailActivityFragment.this.f14444s0);
            }
            if (!DetailActivityFragment.this.D1() && !DetailActivityFragment.this.B1()) {
                DetailActivityFragment.this.f14444s0++;
                if (DetailActivityFragment.this.f14444s0 > DetailActivityFragment.this.B3()) {
                    Handler handler = DetailActivityFragment.this.f14420U;
                    Handler handler2 = null;
                    if (handler == null) {
                        kotlin.jvm.internal.i.q("mHandler");
                        handler = null;
                    }
                    handler.removeMessages(1);
                    Handler handler3 = DetailActivityFragment.this.f14420U;
                    if (handler3 == null) {
                        kotlin.jvm.internal.i.q("mHandler");
                    } else {
                        handler2 = handler3;
                    }
                    handler2.sendEmptyMessageDelayed(1, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
                    return;
                }
                H7.b.b("DetailActivityFragment", "Ignore the first StateChanged, just return");
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i10, String str) {
        }
    }

    public void h4(boolean z10, boolean z11) {
    }
}
