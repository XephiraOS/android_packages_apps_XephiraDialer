package com.customize.contacts.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.detail.CallLogDeleteHelper;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.calllog.CallRecordingsCache;
import com.android.contacts.util.C0703d;
import com.android.contacts.util.InterfaceC0702c;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.MoreCallLogActivity;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0799j;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0811w;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import q7.C1493b;
import q7.InterfaceC1492a;
import w0.C1643c;

/* loaded from: classes3.dex */
public class MoreCallLogActivity extends BasicActivity implements w7.b, Y0.b {

    /* renamed from: a0, reason: collision with root package name */
    public static final String[] f20406a0 = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "ring_time", "features", "simid", "formatted_number"};

    /* renamed from: b0, reason: collision with root package name */
    public static final String[] f20407b0 = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "ring_time", "features", "simid", "formatted_number", "transcript_count"};

    /* renamed from: c0, reason: collision with root package name */
    public static final String[] f20408c0 = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "ring_time", "features", "simid", "formatted_number", "call_log_mapping"};

    /* renamed from: d0, reason: collision with root package name */
    public static final String[] f20409d0 = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "ring_time", "features", "simid", "formatted_number", "call_log_mapping", "transcript_count"};

    /* renamed from: D, reason: collision with root package name */
    public int f20413D;

    /* renamed from: G, reason: collision with root package name */
    public com.customize.contacts.util.O f20416G;

    /* renamed from: H, reason: collision with root package name */
    public MenuItem f20417H;

    /* renamed from: O, reason: collision with root package name */
    public RecordPlayerPresenter f20424O;

    /* renamed from: Q, reason: collision with root package name */
    public COUIToolbar f20426Q;

    /* renamed from: R, reason: collision with root package name */
    public FrameLayout f20427R;

    /* renamed from: S, reason: collision with root package name */
    public COUINavigationView f20428S;

    /* renamed from: T, reason: collision with root package name */
    public ContentObserver f20429T;

    /* renamed from: p, reason: collision with root package name */
    public InterfaceC0702c f20437p;

    /* renamed from: q, reason: collision with root package name */
    public i f20438q;

    /* renamed from: r, reason: collision with root package name */
    public E3.n f20439r;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20436o = true;

    /* renamed from: x, reason: collision with root package name */
    public final HashMap<String, String> f20440x = new HashMap<>();

    /* renamed from: y, reason: collision with root package name */
    public BroadcastReceiver f20441y = null;

    /* renamed from: z, reason: collision with root package name */
    public boolean f20442z = true;

    /* renamed from: A, reason: collision with root package name */
    public final HashMap<Integer, SubscriptionInfo> f20410A = new HashMap<>();

    /* renamed from: B, reason: collision with root package name */
    public String f20411B = null;

    /* renamed from: C, reason: collision with root package name */
    public String f20412C = null;

    /* renamed from: E, reason: collision with root package name */
    public int f20414E = 0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f20415F = false;

    /* renamed from: I, reason: collision with root package name */
    public boolean f20418I = false;

    /* renamed from: J, reason: collision with root package name */
    public String[] f20419J = null;

    /* renamed from: K, reason: collision with root package name */
    public String[] f20420K = null;

    /* renamed from: L, reason: collision with root package name */
    public String f20421L = null;

    /* renamed from: M, reason: collision with root package name */
    public PhoneCallDetails[] f20422M = null;

    /* renamed from: N, reason: collision with root package name */
    public Handler f20423N = null;

    /* renamed from: P, reason: collision with root package name */
    public HeaderFooterRecyclerView f20425P = null;

    /* renamed from: U, reason: collision with root package name */
    public boolean f20430U = false;

    /* renamed from: V, reason: collision with root package name */
    public Handler f20431V = null;

    /* renamed from: W, reason: collision with root package name */
    public HandlerThread f20432W = null;

    /* renamed from: X, reason: collision with root package name */
    public final InterfaceC1492a f20433X = new C1493b();

    /* renamed from: Y, reason: collision with root package name */
    public final androidx.lifecycle.w<Boolean> f20434Y = new androidx.lifecycle.w() { // from class: com.customize.contacts.activities.Z
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            MoreCallLogActivity.this.U1((Boolean) obj);
        }
    };

    /* renamed from: Z, reason: collision with root package name */
    public final Z3.h f20435Z = new f();

    /* loaded from: classes3.dex */
    public enum Tasks {
        UPDATE_PHONE_CALL_DETAILS,
        REMOVE_FROM_CALL_LOG
    }

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.s {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            boolean z10;
            if (MoreCallLogActivity.this.f20439r != null && MoreCallLogActivity.this.K0()) {
                E3.n nVar = MoreCallLogActivity.this.f20439r;
                if (i10 == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                nVar.t(z10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (MoreCallLogActivity.this.f20439r != null && MoreCallLogActivity.this.K0()) {
                MoreCallLogActivity.this.f20439r.t(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            H7.b.b("MoreCallLogActivity", "ContentObserver updateData");
            MoreCallLogActivity.this.d2(null);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public static /* synthetic */ void b(MoreCallLogActivity moreCallLogActivity, PhoneCallDetails[] phoneCallDetailsArr) {
            MoreCallLogActivity.W1(moreCallLogActivity, phoneCallDetailsArr, false, true, "WorkerHandler");
            moreCallLogActivity.f20430U = false;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10;
            H7.b.e("MoreCallLogActivity", "handleMessage: " + message.what);
            final MoreCallLogActivity moreCallLogActivity = MoreCallLogActivity.this;
            if (message.what == 1 && C0792c.c(moreCallLogActivity)) {
                final PhoneCallDetails[] Q12 = MoreCallLogActivity.Q1(moreCallLogActivity);
                StringBuilder sb = new StringBuilder();
                sb.append("RELOAD_CALLS: count: ");
                if (Q12 != null) {
                    i10 = Q12.length;
                } else {
                    i10 = 0;
                }
                sb.append(i10);
                H7.b.e("MoreCallLogActivity", sb.toString());
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.customize.contacts.activities.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MoreCallLogActivity.c.b(MoreCallLogActivity.this, Q12);
                    }
                });
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Toolbar.g {
        public d() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId != R.id.cancel) {
                if (itemId != R.id.more_menu) {
                    if (itemId == R.id.select_all) {
                        MoreCallLogActivity.this.Y1();
                        return true;
                    }
                    return true;
                }
                MoreCallLogActivity.this.f20435Z.b();
                return true;
            }
            MoreCallLogActivity.this.f20435Z.c();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements CallLogDeleteHelper.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f20450a;

        public e(ArrayList arrayList) {
            this.f20450a = arrayList;
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void a(Dialog dialog) {
            U0.n.d(dialog);
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void onClick(int i10, boolean z10) {
            MoreCallLogActivity.this.N1(this.f20450a, z10);
            MoreCallLogActivity.this.f20435Z.c();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Z3.h {
        public f() {
        }

        @Override // Z3.h
        public void a(boolean z10) {
            MoreCallLogActivity.this.f20426Q.getMenu().clear();
            if (z10) {
                MoreCallLogActivity.this.f20426Q.setIsTitleCenterStyle(false);
                MoreCallLogActivity.this.f20426Q.setNavigationIcon(R.drawable.coui_back_arrow);
                MoreCallLogActivity.this.f20426Q.setNavigationContentDescription(R.string.abc_action_bar_up_description);
                MoreCallLogActivity.this.f20426Q.inflateMenu(R.menu.more_calllog_menu);
                MoreCallLogActivity moreCallLogActivity = MoreCallLogActivity.this;
                moreCallLogActivity.f20417H = moreCallLogActivity.f20426Q.getMenu().findItem(R.id.more_menu);
                e();
                return;
            }
            MoreCallLogActivity.this.f20426Q.setNavigationIcon((Drawable) null);
            MoreCallLogActivity.this.f20426Q.setIsTitleCenterStyle(true);
            MoreCallLogActivity.this.f20426Q.inflateMenu(R.menu.cancel_select_menu);
        }

        @Override // Z3.h
        public void b() {
            MoreCallLogActivity.this.f20418I = true;
            MoreCallLogActivity.this.f20416G.o(true);
            MoreCallLogActivity.this.f20439r.t(true);
            MoreCallLogActivity.this.f20439r.notifyDataSetChanged();
            a(false);
            d();
            MoreCallLogActivity.this.f20424O.n0();
            MoreCallLogActivity.this.f2(true, false);
            MoreCallLogActivity moreCallLogActivity = MoreCallLogActivity.this;
            moreCallLogActivity.f1(moreCallLogActivity, false, moreCallLogActivity.K0());
            if (MoreCallLogActivity.this.f20425P != null) {
                boolean j10 = DisplayUtil.j(MoreCallLogActivity.this);
                if ((DisplayUtil.i(MoreCallLogActivity.this) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(MoreCallLogActivity.this))) {
                    MoreCallLogActivity.this.f20425P.i(MoreCallLogActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_145), 0, 0, 0);
                } else if (FeatureUtil.V() && !j10) {
                    MoreCallLogActivity.this.f20425P.i(MoreCallLogActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_245), 0, 0, 0);
                } else {
                    MoreCallLogActivity.this.f20425P.i(MoreCallLogActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_60), 0, 0, 0);
                }
            }
        }

        @Override // Z3.h
        public void c() {
            MoreCallLogActivity.this.f20418I = false;
            MoreCallLogActivity.this.f20416G.o(false);
            MoreCallLogActivity.this.f20416G.l();
            a(true);
            MoreCallLogActivity.this.f20439r.u(true);
            MoreCallLogActivity.this.f20439r.notifyDataSetChanged();
            MoreCallLogActivity.this.f2(false, false);
            MoreCallLogActivity moreCallLogActivity = MoreCallLogActivity.this;
            moreCallLogActivity.f1(moreCallLogActivity, true, moreCallLogActivity.K0());
            if (MoreCallLogActivity.this.f20425P != null) {
                MoreCallLogActivity.this.f20425P.k();
            }
        }

        @Override // Z3.h
        public void d() {
            MoreCallLogActivity.this.f20426Q.setTitle(MoreCallLogActivity.this.f20416G.c());
            g();
        }

        @Override // Z3.h
        public void e() {
            MoreCallLogActivity.this.f20426Q.setTitle(R.string.recentCallsIconLabel);
        }

        @Override // Z3.h
        public void f(boolean z10) {
            if (MoreCallLogActivity.this.f20417H != null) {
                MoreCallLogActivity.this.f20417H.setVisible(z10);
            }
        }

        @Override // Z3.h
        public void g() {
            if (MoreCallLogActivity.this.f20426Q != null) {
                if (MoreCallLogActivity.this.f20416G.g()) {
                    MoreCallLogActivity.this.f20426Q.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
                } else {
                    MoreCallLogActivity.this.f20426Q.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<MoreCallLogActivity> f20453a;

        public g(MoreCallLogActivity moreCallLogActivity) {
            this.f20453a = new WeakReference<>(moreCallLogActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MoreCallLogActivity moreCallLogActivity = this.f20453a.get();
            if (moreCallLogActivity != null && message.what == 3) {
                moreCallLogActivity.a2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action) || "android.intent.action.SIM_SETTING_INFO_CHANGED".equals(action)) {
                if (MoreCallLogActivity.this.f20423N == null) {
                    MoreCallLogActivity.this.f20423N = new g(MoreCallLogActivity.this);
                }
                MoreCallLogActivity.this.f20423N.removeMessages(3);
                MoreCallLogActivity.this.f20423N.sendEmptyMessageDelayed(3, 1000L);
            }
        }

        public h() {
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends com.android.contacts.util.D<Void, Void, PhoneCallDetails[], MoreCallLogActivity> {

        /* renamed from: b, reason: collision with root package name */
        public final CancellationSignal f20455b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<Q0.b> f20456c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f20457d;

        /* loaded from: classes3.dex */
        public class a implements com.android.contacts.framework.baseui.util.t {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MoreCallLogActivity f20458a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Handler f20459b;

            public a(MoreCallLogActivity moreCallLogActivity, Handler handler) {
                this.f20458a = moreCallLogActivity;
                this.f20459b = handler;
            }

            @Override // com.android.contacts.framework.baseui.util.t
            public void a(int i10, Object obj, Object obj2) {
                int i11;
                boolean b10 = ThreadUtilsKt.b();
                H7.b.e("MoreCallLogActivity", "SimpleCallback: code: " + i10 + ", " + obj + ", " + obj2 + ", " + b10);
                if (!b10) {
                    final PhoneCallDetails[] Q12 = MoreCallLogActivity.Q1(this.f20458a);
                    StringBuilder sb = new StringBuilder();
                    sb.append("SimpleCallback: count: ");
                    if (Q12 != null) {
                        i11 = Q12.length;
                    } else {
                        i11 = 0;
                    }
                    sb.append(i11);
                    H7.b.e("MoreCallLogActivity", sb.toString());
                    Handler handler = this.f20459b;
                    final MoreCallLogActivity moreCallLogActivity = this.f20458a;
                    handler.post(new Runnable() { // from class: com.customize.contacts.activities.c0
                        @Override // java.lang.Runnable
                        public final void run() {
                            MoreCallLogActivity.i.a.this.c(moreCallLogActivity, Q12);
                        }
                    });
                    return;
                }
                if (this.f20458a.f20431V != null) {
                    this.f20458a.f20431V.sendEmptyMessage(1);
                } else {
                    H7.b.i("MoreCallLogActivity", "WorkerHandler is null.");
                }
            }

            public final /* synthetic */ void c(MoreCallLogActivity moreCallLogActivity, PhoneCallDetails[] phoneCallDetailsArr) {
                MoreCallLogActivity.W1(moreCallLogActivity, phoneCallDetailsArr, i.this.isCancelled(), true, "SimpleCallback");
                moreCallLogActivity.f20430U = false;
            }
        }

        public static long[] f(ArrayList<Q0.b> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<Q0.b> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Q0.d> a10 = it.next().a();
                if (!a10.isEmpty()) {
                    Iterator<Q0.d> it2 = a10.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(Long.valueOf(it2.next().a()));
                    }
                }
            }
            long[] jArr = new long[arrayList2.size()];
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                jArr[i10] = ((Long) arrayList2.get(i10)).longValue();
            }
            return jArr;
        }

        public static String g(long[] jArr) {
            if (jArr.length == 0) {
                return "";
            }
            Arrays.sort(jArr);
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat simpleDateFormat = F7.b.f1009g;
            sb.append(simpleDateFormat.format(new Date(jArr[0])));
            sb.append("-");
            sb.append(simpleDateFormat.format(new Date(jArr[jArr.length - 1])));
            return sb.toString();
        }

        public void d() {
            H7.b.e("MoreCallLogActivity", "UpdateContactDetailsTask: cancel: " + System.identityHashCode(this));
            cancel(false);
            CancellationSignal cancellationSignal = this.f20455b;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public PhoneCallDetails[] a(MoreCallLogActivity moreCallLogActivity, Void... voidArr) {
            a aVar;
            PhoneCallDetails[] phoneCallDetailsArr = null;
            if (!isCancelled() && C0792c.c(moreCallLogActivity)) {
                ArrayList<Q0.b> arrayList = this.f20456c;
                int i10 = 0;
                if (arrayList == null || arrayList.size() <= 0) {
                    PhoneCallDetails[] Q12 = MoreCallLogActivity.Q1(moreCallLogActivity);
                    StringBuilder sb = new StringBuilder();
                    sb.append("doInBackground: 2-count: ");
                    if (Q12 != null) {
                        i10 = Q12.length;
                    }
                    sb.append(i10);
                    sb.append(", ");
                    sb.append(System.identityHashCode(this));
                    H7.b.e("MoreCallLogActivity", sb.toString());
                    return Q12;
                }
                com.android.contacts.detail.D d10 = new com.android.contacts.detail.D(2, 2, g(f(this.f20456c)));
                H7.b.e("MoreCallLogActivity", "doInBackground: mFinishInCallback: " + moreCallLogActivity.f20430U);
                Handler handler = new Handler(Looper.getMainLooper());
                ArrayList<Q0.b> arrayList2 = this.f20456c;
                boolean z10 = this.f20457d;
                if (moreCallLogActivity.f20430U) {
                    aVar = new a(moreCallLogActivity, handler);
                } else {
                    aVar = null;
                }
                CallLogDeleteHelper.f(moreCallLogActivity, arrayList2, z10, d10, aVar);
                B3.c.d().h();
                if (!moreCallLogActivity.f20430U) {
                    phoneCallDetailsArr = MoreCallLogActivity.Q1(moreCallLogActivity);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("doInBackground: 1-count: ");
                if (phoneCallDetailsArr != null) {
                    i10 = phoneCallDetailsArr.length;
                }
                sb2.append(i10);
                sb2.append(", ");
                sb2.append(System.identityHashCode(this));
                H7.b.e("MoreCallLogActivity", sb2.toString());
                return phoneCallDetailsArr;
            }
            H7.b.i("MoreCallLogActivity", "UpdateContactDetailsTask: doInBackground: task is cancelled or activity is finished!");
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void b(MoreCallLogActivity moreCallLogActivity, PhoneCallDetails[] phoneCallDetailsArr) {
            H7.b.b("MoreCallLogActivity", "onPostExecute: mFinishInCallback: " + moreCallLogActivity.f20430U + ", " + System.identityHashCode(this));
            if (!moreCallLogActivity.f20430U) {
                MoreCallLogActivity.W1(moreCallLogActivity, phoneCallDetailsArr, isCancelled(), false, "onPostExecute:" + System.identityHashCode(this));
            }
        }

        public i(MoreCallLogActivity moreCallLogActivity, ArrayList<Q0.b> arrayList, boolean z10) {
            super(moreCallLogActivity);
            this.f20455b = new CancellationSignal();
            this.f20456c = arrayList;
            this.f20457d = z10;
        }
    }

    private void M1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(4, 4);
            supportActionBar.w(false);
        }
    }

    public static String[] O1() {
        String[] strArr;
        if (!AppMetaFeatures.b()) {
            strArr = f20406a0;
        } else {
            strArr = f20408c0;
        }
        if (FeatureOption.p()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            arrayList.add("virtual_call_id");
            return (String[]) arrayList.toArray(new String[0]);
        }
        return strArr;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0050: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:81), block:B:60:0x0050 */
    public static PhoneCallDetails[] Q1(MoreCallLogActivity moreCallLogActivity) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        String str;
        int i10;
        int i11;
        int i12;
        try {
            try {
                cursor2 = b2(moreCallLogActivity);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst() && cursor2.getCount() != 0) {
                            int count = cursor2.getCount();
                            if (H7.a.b()) {
                                H7.b.b("MoreCallLogActivity", "getPhoneCallDetailsForUri: mSimCount = " + moreCallLogActivity.f20413D + ", mNumber = " + H7.a.d(moreCallLogActivity.f20411B) + ", calls count = " + count);
                            }
                            PhoneCallDetails[] phoneCallDetailsArr = new PhoneCallDetails[count];
                            int i13 = 1;
                            moreCallLogActivity.f20411B = cursor2.getString(1);
                            int columnIndex = cursor2.getColumnIndex("virtual_call_id");
                            int i14 = 0;
                            int i15 = 0;
                            while (i15 < count) {
                                String string = cursor2.getString(i13);
                                String string2 = cursor2.getString(8);
                                long j10 = cursor2.getLong(i14);
                                long j11 = cursor2.getLong(2);
                                long j12 = cursor2.getLong(3);
                                int i16 = cursor2.getInt(4);
                                int i17 = cursor2.getInt(6);
                                int i18 = cursor2.getInt(5);
                                int i19 = cursor2.getInt(7);
                                if (AppMetaFeatures.b()) {
                                    str = cursor2.getString(9);
                                } else {
                                    str = null;
                                }
                                if (moreCallLogActivity.f20413D > i13) {
                                    SubscriptionInfo subscriptionInfo = moreCallLogActivity.f20410A.get(Integer.valueOf(i19));
                                    if (subscriptionInfo != null) {
                                        i12 = subscriptionInfo.getSimSlotIndex();
                                    } else {
                                        i12 = -1;
                                    }
                                    i10 = 9;
                                    phoneCallDetailsArr[i15] = new PhoneCallDetails(string, string2, i16, j11, j12, "", null, i18, j10, i19, i17, i12, str, false);
                                } else {
                                    i10 = 9;
                                    phoneCallDetailsArr[i15] = new PhoneCallDetails(string, string2, i16, j11, j12, null, null, i18, j10, -1, i17, -1, str, false);
                                }
                                if (columnIndex != -1) {
                                    phoneCallDetailsArr[i15].f13183q = cursor2.getString(columnIndex);
                                }
                                if (C1643c.w()) {
                                    if (AppMetaFeatures.b()) {
                                        i11 = cursor2.getInt(10);
                                    } else {
                                        i11 = cursor2.getInt(i10);
                                    }
                                    phoneCallDetailsArr[i15].f13181o = i11;
                                }
                                if (C0801l.q(i17)) {
                                    phoneCallDetailsArr[i15].f13180n = PhoneNumberUtils.isEmergencyNumber(string);
                                }
                                if (!cursor2.isLast()) {
                                    cursor2.moveToNext();
                                }
                                i15++;
                                i13 = 1;
                                i14 = 0;
                            }
                            com.oplus.foundation.util.io.e.a(cursor2);
                            return phoneCallDetailsArr;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        H7.b.i("MoreCallLogActivity", "getPhoneCallDetailsForUri: Exception: " + e);
                        com.oplus.foundation.util.io.e.a(cursor2);
                        return null;
                    }
                }
                H7.b.e("MoreCallLogActivity", "getPhoneCallDetailsForUri: no data, return null.");
                com.oplus.foundation.util.io.e.a(cursor2);
                return null;
            } catch (Throwable th) {
                th = th;
                cursor = cursor3;
                com.oplus.foundation.util.io.e.a(cursor);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.oplus.foundation.util.io.e.a(cursor);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(Boolean bool) {
        boolean p10 = CallRecordingsCache.f15754a.p();
        H7.b.e("MoreCallLogActivity", "Call recordings loaded: " + bool + ", hasChanged: " + p10);
        if (p10) {
            d2(null);
        }
    }

    public static void W1(MoreCallLogActivity moreCallLogActivity, PhoneCallDetails[] phoneCallDetailsArr, boolean z10, boolean z11, String str) {
        boolean z12;
        StringBuilder sb = new StringBuilder();
        sb.append("notifyFinished: has details: ");
        boolean z13 = false;
        if (phoneCallDetailsArr != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        sb.append(z12);
        sb.append(", cancelled: ");
        sb.append(z10);
        sb.append(", ignoreCancel: ");
        sb.append(z11);
        sb.append(", mFinishInCallback: ");
        sb.append(moreCallLogActivity.f20430U);
        sb.append(" [");
        sb.append(str);
        sb.append("]");
        H7.b.e("MoreCallLogActivity", sb.toString());
        if (!C0792c.c(moreCallLogActivity)) {
            H7.b.i("MoreCallLogActivity", "notifyFinished: activity is not alive, return.");
            return;
        }
        if (!z11 && z10) {
            H7.b.i("MoreCallLogActivity", "notifyFinished: task cancelled, return.");
            return;
        }
        if (phoneCallDetailsArr == null) {
            H7.b.e("MoreCallLogActivity", "notifyFinished: no calls, finish activity.");
            moreCallLogActivity.setResult(20);
            moreCallLogActivity.finish();
            return;
        }
        moreCallLogActivity.f20422M = phoneCallDetailsArr;
        E3.n nVar = moreCallLogActivity.f20439r;
        if (moreCallLogActivity.f20413D > 1) {
            z13 = true;
        }
        nVar.v(z13);
        moreCallLogActivity.f20439r.q(phoneCallDetailsArr);
        if (H7.a.b()) {
            H7.b.b("MoreCallLogActivity", "notifyFinished: end: details.length = " + phoneCallDetailsArr.length);
        }
        moreCallLogActivity.f20439r.notifyDataSetChanged();
    }

    public static Cursor b2(MoreCallLogActivity moreCallLogActivity) {
        String[] strArr;
        Uri uri;
        String str;
        String str2;
        if (!AppMetaFeatures.b()) {
            strArr = f20406a0;
            uri = CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL;
        } else {
            strArr = f20408c0;
            uri = R0.b.f3176j;
        }
        Uri uri2 = uri;
        if (C1643c.w()) {
            if (!AppMetaFeatures.b()) {
                strArr = f20407b0;
            } else {
                strArr = f20409d0;
            }
        }
        if (FeatureOption.p()) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            arrayList.add("virtual_call_id");
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        String[] strArr2 = strArr;
        String[] strArr3 = moreCallLogActivity.f20420K;
        if (strArr3 != null && strArr3.length > 0) {
            return G7.c.e(moreCallLogActivity.getContentResolver(), uri2, strArr2, "(number IN (" + U7.f.a(moreCallLogActivity.f20420K) + ")) OR (" + BreenoCallContract.BaseColumns.NORMALIZED_NUMBER + " IN (" + U7.f.a(moreCallLogActivity.f20419J) + "))", null, "date DESC");
        }
        if (TextUtils.isEmpty(moreCallLogActivity.f20421L)) {
            moreCallLogActivity.f20421L = PhoneNumberUtils.formatNumberToE164(moreCallLogActivity.f20411B, moreCallLogActivity.f20412C);
        }
        if (TextUtils.isEmpty(moreCallLogActivity.f20421L)) {
            str = moreCallLogActivity.f20411B;
        } else {
            str = moreCallLogActivity.f20421L;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(moreCallLogActivity.f20421L)) {
                str2 = "normalized_number='" + moreCallLogActivity.f20421L + "'";
            } else {
                str2 = "normalized_number='" + str + "'";
            }
            if (moreCallLogActivity.f20414E != 0 || moreCallLogActivity.f20415F) {
                str2 = str2 + C0801l.b(moreCallLogActivity.f20414E);
            }
            return G7.c.e(moreCallLogActivity.getContentResolver(), uri2, strArr2, str2, null, "date DESC");
        }
        if (moreCallLogActivity.getIntent().getExtras() != null) {
            moreCallLogActivity.f20411B = moreCallLogActivity.getIntent().getExtras().getString("call_log_phone_num", "");
            if (H7.a.b()) {
                H7.b.b("MoreCallLogActivity", "mIsFromGlobalSearch mNumber = " + H7.a.d(moreCallLogActivity.f20411B));
            }
        }
        try {
            if (moreCallLogActivity.getIntent().getData() != null) {
                return moreCallLogActivity.getContentResolver().query(uri2, strArr2, "_id ='" + ContentUris.parseId(moreCallLogActivity.getIntent().getData()) + "'", null, "date DESC");
            }
        } catch (Exception e10) {
            H7.b.c("MoreCallLogActivity", "startCallQuery query error" + e10);
        }
        return null;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        this.f20426Q = cOUIToolbar;
        cOUIToolbar.setOnMenuItemClickListener(new d());
        this.f20426Q.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.activities.W
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoreCallLogActivity.this.T1(view);
            }
        });
        this.f20435Z.a(true);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> list) {
        Iterator<? extends View> it = list.iterator();
        while (it.hasNext()) {
            X1(it.next());
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean K0() {
        return this.f20418I;
    }

    public final void N1(ArrayList<Q0.b> arrayList, boolean z10) {
        boolean z11;
        if (arrayList != null && !arrayList.isEmpty() && z10 && AppMetaFeatures.b()) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f20430U = z11;
        H7.b.e("MoreCallLogActivity", "deleteCallLog: deleteAssociateFiles: " + z10 + ", mFinishInCallback: " + this.f20430U);
        e2(arrayList, z10);
    }

    public final void P1() {
        int size;
        String str;
        if (B3.a.i()) {
            List<SubscriptionInfo> e10 = com.customize.contacts.util.b0.e(this);
            if (e10.isEmpty()) {
                size = 0;
            } else {
                size = e10.size();
            }
            this.f20413D = size;
            if (H7.a.b()) {
                H7.b.b("MoreCallLogActivity", "getdualSimInfoList(): mSimCount = " + this.f20413D);
            }
            if (this.f20413D > 1) {
                this.f20410A.clear();
                this.f20440x.clear();
                for (int i10 = 0; i10 < e10.size(); i10++) {
                    SubscriptionInfo subscriptionInfo = e10.get(i10);
                    String l10 = Long.toString(subscriptionInfo.getSubscriptionId());
                    this.f20410A.put(Integer.valueOf(subscriptionInfo.getSubscriptionId()), subscriptionInfo);
                    if (!this.f20440x.containsKey(l10)) {
                        CharSequence displayName = subscriptionInfo.getDisplayName();
                        if (displayName != null) {
                            str = displayName.toString();
                        } else {
                            str = "";
                        }
                        this.f20440x.put(l10, str);
                    }
                }
                return;
            }
            return;
        }
        this.f20413D = com.customize.contacts.util.b0.T(this) ? 1 : 0;
        if (H7.a.b()) {
            H7.b.b("MoreCallLogActivity", "getsingleSimInfoList(): mSimCount = " + this.f20413D);
        }
    }

    public final void R1() {
        try {
            HandlerThread handlerThread = new HandlerThread("MoreCallLogWorkerThread");
            this.f20432W = handlerThread;
            handlerThread.start();
            this.f20431V = new c(this.f20432W.getLooper());
        } catch (Exception e10) {
            H7.b.c("MoreCallLogActivity", "initWorkerHandler: Exception: " + e10);
            this.f20431V = null;
            HandlerThread handlerThread2 = this.f20432W;
            if (handlerThread2 != null) {
                handlerThread2.quitSafely();
            }
        }
    }

    public final /* synthetic */ boolean S1(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_delete) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("call_log_details", new ArrayList<>(this.f20416G.b()));
            showDialog(100, bundle);
            return true;
        }
        return true;
    }

    public final /* synthetic */ void T1(View view) {
        if (this.f20418I) {
            this.f20435Z.c();
        } else {
            finish();
        }
    }

    public final /* synthetic */ void V1(String str) {
        H7.b.b("MoreCallLogActivity", "onCallRecordChange updateData");
        if (AppMetaFeatures.b()) {
            CallRecordingsCache.f15754a.s();
        }
        d2(null);
    }

    public boolean X1(View view) {
        if (view == null) {
            return false;
        }
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
        this.f20416G.j(checkBox, true);
        com.android.contacts.util.C.b(view, checkBox.isChecked());
        return true;
    }

    public void Y1() {
        this.f20416G.k();
        this.f20435Z.g();
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        return X1(view);
    }

    public final void Z1() {
        this.f20441y = new h();
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(this, this.f20441y, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction("android.intent.action.SIM_SETTING_INFO_CHANGED");
        try {
            registerReceiver(this.f20441y, intentFilter, R0.b.f3175i, null, 2);
        } catch (Exception e10) {
            H7.b.c("MoreCallLogActivity", "registerSimStateChangedReceiver Exception: " + e10);
            this.f20441y = null;
        }
    }

    public final void a2() {
        if (H7.a.b()) {
            H7.b.b("MoreCallLogActivity", "sim state has changed mIsFirstSimStateChangeBroadcast = " + this.f20436o);
        }
        if (!this.f20436o) {
            this.f20440x.clear();
            this.f20410A.clear();
            P1();
            d2(null);
            return;
        }
        this.f20436o = false;
    }

    public final void c2() {
        BroadcastReceiver broadcastReceiver = this.f20441y;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
                this.f20441y = null;
            } catch (IllegalArgumentException e10) {
                H7.b.c("MoreCallLogActivity", "unregisterSimStateChangedReceiver IllegalArgumentException: " + e10);
            }
        }
    }

    public final void d2(ArrayList<Q0.b> arrayList) {
        e2(arrayList, false);
    }

    public final void e2(ArrayList<Q0.b> arrayList, boolean z10) {
        String str;
        boolean z11;
        i iVar = this.f20438q;
        if (iVar != null) {
            iVar.d();
            str = "cancel task: " + System.identityHashCode(this.f20438q) + ", ";
        } else {
            str = "";
        }
        this.f20438q = new i(arrayList, z10);
        StringBuilder sb = new StringBuilder();
        sb.append("updateData: has details: ");
        if (arrayList != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        sb.append(z11);
        sb.append(", deleteAssociatedFiles: ");
        sb.append(z10);
        sb.append(", ");
        sb.append(str);
        sb.append("new task: ");
        sb.append(System.identityHashCode(this.f20438q));
        H7.b.e("MoreCallLogActivity", sb.toString());
        this.f20437p.a(Tasks.UPDATE_PHONE_CALL_DETAILS, this.f20438q, new Void[0]);
    }

    public void f2(boolean z10, boolean z11) {
        if (z10) {
            this.f20428S.getMenu().findItem(R.id.menu_delete).setEnabled(z11);
        }
        m1(this.f20427R, z10);
        k1(z10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f20418I) {
            this.f20435Z.c();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z10;
        super.onConfigurationChanged(configuration);
        if (this.f20425P != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 & K0()) {
            boolean j10 = DisplayUtil.j(this);
            if ((DisplayUtil.i(this) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(this))) {
                this.f20425P.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_145));
            } else if (FeatureUtil.V() && !j10) {
                this.f20425P.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_245));
            } else {
                this.f20425P.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_60));
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f20411B = extras.getString("number", "");
            this.f20412C = extras.getString("countryiso", "");
            this.f20414E = extras.getInt(OplusAutoRedialNotificationUI.TYPE);
            this.f20420K = extras.getStringArray("calllog_numbers");
            this.f20419J = extras.getStringArray("calllog_normalized_numbers");
            this.f20421L = extras.getString(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER);
            this.f20415F = extras.getBoolean("isUnfamiliarNumber");
        }
        this.f20437p = C0703d.c();
        P1();
        d2(null);
        this.f20442z = true;
        setContentView(R.layout.more_call_log_activity);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) findViewById(R.id.list);
        this.f20425P = headerFooterRecyclerView;
        com.android.contacts.util.C.c(this, headerFooterRecyclerView, getResources().getDimensionPixelSize(R.dimen.DP_60));
        this.f20425P.setScrollBarStyle(33554432);
        this.f20425P.setNestedScrollingEnabled(true);
        this.f20425P.setLayoutManager(new LinearLayoutManager(this));
        this.f20425P.setItemAnimator(null);
        this.f20425P.setDragSelectListener(this);
        this.f20425P.addOnScrollListener(new a());
        this.f20433X.T0(this, this.f20425P, null);
        M1();
        E3.n nVar = new E3.n(this, this.f20415F);
        this.f20439r = nVar;
        nVar.r(this);
        com.customize.contacts.util.O o10 = new com.customize.contacts.util.O(this, this.f20439r, this.f20435Z);
        this.f20416G = o10;
        this.f20439r.p(o10);
        this.f20425P.setAdapter(this.f20439r);
        this.f20436o = true;
        Z1();
        RecordPlayerPresenter X10 = RecordPlayerPresenter.X(this);
        this.f20424O = X10;
        X10.I0(new RecordPlayerPresenter.a() { // from class: com.customize.contacts.activities.Y
            @Override // com.customize.contacts.mediaplayer.RecordPlayerPresenter.a
            public final void a(String str) {
                MoreCallLogActivity.this.V1(str);
            }
        });
        this.f20439r.s(this.f20424O);
        this.f20429T = new b(new Handler());
        try {
            getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, false, this.f20429T);
        } catch (Exception e10) {
            H7.b.c("MoreCallLogActivity", "registerContentObserver: exception: " + e10);
        }
        if (AppMetaFeatures.b()) {
            CallRecordingsCache.f15754a.o().i(this, this.f20434Y);
            R1();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        PhoneCallDetails[] phoneCallDetailsArr;
        if (i10 != 100 || (phoneCallDetailsArr = this.f20422M) == null) {
            return null;
        }
        int length = phoneCallDetailsArr.length;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("call_log_details");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            if (this.f20411B == null) {
                H7.b.c("MoreCallLogActivity", "Call number is empty!");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                PhoneCallDetails phoneCallDetails = (PhoneCallDetails) it.next();
                arrayList.add(new Q0.d(phoneCallDetails.f13175i, phoneCallDetails.f13170d, phoneCallDetails.f13169c, phoneCallDetails.b(), phoneCallDetails.f13183q));
            }
            Q0.b bVar = new Q0.b(this.f20411B, null, null, null, null, new ArrayList());
            bVar.a().addAll(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bVar);
            CallLogDeleteHelper.i(this, this.f20411B, arrayList, parcelableArrayList.size(), length, new e(arrayList2));
            return null;
        }
        H7.b.c("MoreCallLogActivity", "Single call list is empty!");
        return null;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        c2();
        try {
            getContentResolver().unregisterContentObserver(this.f20429T);
        } catch (Exception e10) {
            H7.b.c("MoreCallLogActivity", "unregisterContentObserver: exception: " + e10);
        }
        Handler handler = this.f20423N;
        if (handler != null) {
            handler.removeMessages(3);
        }
        i iVar = this.f20438q;
        if (iVar != null) {
            iVar.d();
        }
        this.f20424O.l0();
        super.onDestroy();
        try {
            Handler handler2 = this.f20431V;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread = this.f20432W;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
        } catch (Exception e11) {
            H7.b.c("MoreCallLogActivity", "BackgroundThread.quitSafely: exception: " + e11);
        }
        this.f20433X.F();
        if (isChangingConfigurations()) {
            com.android.contacts.calllog.x.b(this).a();
        }
    }

    @Override // Y0.b
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (H7.a.b()) {
            H7.b.b("MoreCallLogActivity", "onItemClick: id = " + j10);
        }
        if (view != null) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
            this.f20416G.j(checkBox, true);
            com.android.contacts.util.C.b(view, checkBox.isChecked());
        }
    }

    @Override // Y0.b
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (!this.f20416G.f() && view != null) {
            this.f20435Z.b();
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
            PhoneCallDetails[] phoneCallDetailsArr = this.f20422M;
            if (phoneCallDetailsArr != null && i10 < phoneCallDetailsArr.length) {
                checkBox.setTag(phoneCallDetailsArr[i10]);
                this.f20416G.j(checkBox, true);
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f20424O.m0();
        super.onPause();
        this.f20433X.p();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.f20424O.o0();
        super.onResume();
        this.f20433X.H0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C0799j.c(F7.b.e(this));
        C0799j.d(DateFormat.getTimeFormat(this));
        if (!this.f20442z) {
            d2(null);
        }
        this.f20442z = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        RecordPlayerPresenter recordPlayerPresenter = this.f20424O;
        if (recordPlayerPresenter != null) {
            recordPlayerPresenter.p0();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        this.f20427R = (FrameLayout) findViewById(R.id.navigation_view_panel);
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        this.f20428S = cOUINavigationView;
        cOUINavigationView.inflateMenu(R.menu.delete_action_mode);
        MenuItem findItem = this.f20428S.getMenu().findItem(R.id.menu_delete);
        findItem.setTitle(R.string.delete_description);
        findItem.setEnabled(true);
        this.f20428S.setOnItemSelectedListener(new NavigationBarView.c() { // from class: com.customize.contacts.activities.X
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean S12;
                S12 = MoreCallLogActivity.this.S1(menuItem);
                return S12;
            }
        });
        FrameLayout frameLayout = this.f20427R;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // w7.b
    public void T() {
    }

    @Override // w7.b
    public void p0() {
    }
}
