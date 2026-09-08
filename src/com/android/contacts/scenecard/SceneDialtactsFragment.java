package com.android.contacts.scenecard;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.calllog.r;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.scenecard.SceneCallLogAdapter;
import com.android.contacts.scenecard.SceneDialtactsFragment;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.customize.contacts.util.HandlerC0795f;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.lifecycle.FlowExtKt;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.text.Regex;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;

/* compiled from: SceneDialtactsFragment.kt */
/* loaded from: classes.dex */
public final class SceneDialtactsFragment extends Fragment implements r.b {

    /* renamed from: x, reason: collision with root package name */
    public static final a f17205x = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public x0.o f17206a;

    /* renamed from: b, reason: collision with root package name */
    public SceneDialPadViewController f17207b;

    /* renamed from: c, reason: collision with root package name */
    public SceneSimCardStateManager f17208c;

    /* renamed from: d, reason: collision with root package name */
    public SceneCallLogAdapter f17209d;

    /* renamed from: e, reason: collision with root package name */
    public HeaderFooterRecyclerView f17210e;

    /* renamed from: f, reason: collision with root package name */
    public com.android.contacts.calllog.r f17211f;

    /* renamed from: g, reason: collision with root package name */
    public b f17212g;

    /* renamed from: h, reason: collision with root package name */
    public SceneDialtactsHandler f17213h;

    /* renamed from: i, reason: collision with root package name */
    public E3.q f17214i;

    /* renamed from: j, reason: collision with root package name */
    public E3.o f17215j;

    /* renamed from: k, reason: collision with root package name */
    public View f17216k;

    /* renamed from: l, reason: collision with root package name */
    public String f17217l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17218m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f17219n = true;

    /* renamed from: o, reason: collision with root package name */
    public final ContentObserver f17220o = new f(new Handler(Looper.getMainLooper()));

    /* renamed from: p, reason: collision with root package name */
    public final ContentObserver f17221p = new c(new Handler(Looper.getMainLooper()));

    /* renamed from: q, reason: collision with root package name */
    public final BroadcastReceiver f17222q = new BroadcastReceiver() { // from class: com.android.contacts.scenecard.SceneDialtactsFragment$markFlagChangeObserver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SceneDialtactsFragment.this.E1();
        }
    };

    /* renamed from: r, reason: collision with root package name */
    public final BroadcastReceiver f17223r = new BroadcastReceiver() { // from class: com.android.contacts.scenecard.SceneDialtactsFragment$updateContactsListAdapterReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null) {
                int hashCode = action.hashCode();
                if (hashCode != -322838349) {
                    if (hashCode != 628084325) {
                        if (hashCode != 1402769438 || !action.equals("com.oplus.contacts.display_settings_changed")) {
                            return;
                        }
                    } else if (!action.equals("com.oplus.contacts.force_refresh_calllog")) {
                        return;
                    }
                    if (C7.e.c(intent, "need_refresh_data", false)) {
                        SceneDialtactsFragment.SceneDialtactsHandler sceneDialtactsHandler = SceneDialtactsFragment.this.f17213h;
                        if (sceneDialtactsHandler != null) {
                            sceneDialtactsHandler.sendEmptyMessage(599);
                        }
                    } else if (C7.e.c(intent, "need_delay_update_call_log", true)) {
                        SceneDialtactsFragment.SceneDialtactsHandler sceneDialtactsHandler2 = SceneDialtactsFragment.this.f17213h;
                        if (sceneDialtactsHandler2 != null) {
                            sceneDialtactsHandler2.sendEmptyMessageDelayed(555, 1000L);
                        }
                    } else {
                        SceneDialtactsFragment.SceneDialtactsHandler sceneDialtactsHandler3 = SceneDialtactsFragment.this.f17213h;
                        if (sceneDialtactsHandler3 != null) {
                            sceneDialtactsHandler3.sendEmptyMessage(555);
                        }
                    }
                    SceneDialtactsFragment sceneDialtactsFragment = SceneDialtactsFragment.this;
                    sceneDialtactsFragment.J1(sceneDialtactsFragment.B1());
                    return;
                }
                if (action.equals("com.oplus.contacts.DETAIL_UPDATE_DONE")) {
                    SceneDialtactsFragment sceneDialtactsFragment2 = SceneDialtactsFragment.this;
                    sceneDialtactsFragment2.J1(sceneDialtactsFragment2.B1());
                }
            }
        }
    };

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class SceneDialtactsHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<SceneDialtactsFragment> f17224a;

        public SceneDialtactsHandler(SceneDialtactsFragment fragment) {
            kotlin.jvm.internal.i.f(fragment, "fragment");
            this.f17224a = new WeakReference<>(fragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            SceneDialtactsFragment sceneDialtactsFragment = this.f17224a.get();
            if (sceneDialtactsFragment == null) {
                return;
            }
            int i10 = msg.what;
            if (i10 != 999) {
                if (i10 == 1000) {
                    sceneDialtactsFragment.w1();
                }
            } else {
                Context context = sceneDialtactsFragment.getContext();
                if (context != null) {
                    C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.a(), null, new SceneDialtactsFragment$SceneDialtactsHandler$handleMessage$1$1(context, null), 2, null);
                }
            }
        }
    }

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class b extends HandlerC0795f {

        /* renamed from: f, reason: collision with root package name */
        public final WeakReference<SceneDialtactsFragment> f17225f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SceneDialtactsFragment fragment) {
            super(fragment.z1());
            kotlin.jvm.internal.i.f(fragment, "fragment");
            this.f17225f = new WeakReference<>(fragment);
        }

        @Override // com.customize.contacts.util.HandlerC0795f
        public void e(int i10, Object obj, Cursor cursor) {
            SceneDialTextEditor v10;
            SceneDialTextEditor v11;
            SceneDialTextEditor v12;
            SceneDialTextEditor v13;
            H7.b.b("SceneDialtactsFragment", "onQueryComplete token = " + i10);
            SceneDialtactsFragment sceneDialtactsFragment = this.f17225f.get();
            if (sceneDialtactsFragment == null) {
                return;
            }
            if (i10 == 0) {
                if (!sceneDialtactsFragment.isAdded()) {
                    com.oplus.foundation.util.io.e.a(cursor);
                    return;
                }
                synchronized (sceneDialtactsFragment) {
                    try {
                        if (sceneDialtactsFragment.f17209d == null) {
                            sceneDialtactsFragment.initAdapter();
                        }
                        String B12 = sceneDialtactsFragment.B1();
                        String y12 = sceneDialtactsFragment.y1(B12);
                        String x12 = sceneDialtactsFragment.x1(B12);
                        if (TextUtils.isEmpty(x12)) {
                            HeaderFooterRecyclerView headerFooterRecyclerView = sceneDialtactsFragment.f17210e;
                            if (headerFooterRecyclerView != null) {
                                headerFooterRecyclerView.setVisibility(0);
                            }
                            com.oplus.foundation.util.io.e.a(cursor);
                            return;
                        }
                        if (cursor != null) {
                            try {
                            } catch (Throwable th) {
                                th.printStackTrace();
                                H7.b.c("SceneDialtactsFragment", "onQueryComplete e = " + m9.q.f35511a);
                                com.oplus.foundation.util.io.e.a(cursor);
                            }
                            if (!cursor.isClosed() && cursor.getCount() > 0 && !TextUtils.isEmpty(x12)) {
                                H7.b.b("SceneDialtactsFragment", "mPeopleCount=" + cursor.getCount());
                                HeaderFooterRecyclerView headerFooterRecyclerView2 = sceneDialtactsFragment.f17210e;
                                if (headerFooterRecyclerView2 != null) {
                                    headerFooterRecyclerView2.setVisibility(0);
                                }
                                SceneDialPadViewController sceneDialPadViewController = sceneDialtactsFragment.f17207b;
                                if (sceneDialPadViewController != null && (v11 = sceneDialPadViewController.v()) != null) {
                                    v11.G(false);
                                }
                                SceneDialPadViewController sceneDialPadViewController2 = sceneDialtactsFragment.f17207b;
                                if (sceneDialPadViewController2 != null && (v10 = sceneDialPadViewController2.v()) != null) {
                                    v10.F(true);
                                }
                                SceneCallLogAdapter sceneCallLogAdapter = sceneDialtactsFragment.f17209d;
                                if (sceneCallLogAdapter != null) {
                                    SceneCallLogAdapter.f0(sceneCallLogAdapter, cursor, false, 2, null);
                                }
                                sceneDialtactsFragment.H1(false);
                                m9.q qVar = m9.q.f35511a;
                                return;
                            }
                        }
                        if (!TextUtils.isEmpty(y12)) {
                            SceneDialPadViewController sceneDialPadViewController3 = sceneDialtactsFragment.f17207b;
                            if (sceneDialPadViewController3 != null && (v13 = sceneDialPadViewController3.v()) != null) {
                                v13.G(true);
                            }
                            SceneDialPadViewController sceneDialPadViewController4 = sceneDialtactsFragment.f17207b;
                            if (sceneDialPadViewController4 != null && (v12 = sceneDialPadViewController4.v()) != null) {
                                v12.F(false);
                            }
                            sceneDialtactsFragment.H1(false);
                        }
                        if (cursor == null || cursor.isClosed()) {
                            SceneCallLogAdapter sceneCallLogAdapter2 = sceneDialtactsFragment.f17209d;
                            if (sceneCallLogAdapter2 != null) {
                                SceneCallLogAdapter.f0(sceneCallLogAdapter2, null, false, 2, null);
                                m9.q qVar2 = m9.q.f35511a;
                            }
                        } else {
                            SceneCallLogAdapter sceneCallLogAdapter3 = sceneDialtactsFragment.f17209d;
                            if (sceneCallLogAdapter3 != null) {
                                SceneCallLogAdapter.f0(sceneCallLogAdapter3, cursor, false, 2, null);
                                m9.q qVar3 = m9.q.f35511a;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            com.oplus.foundation.util.io.e.a(cursor);
        }
    }

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            SceneDialtactsFragment.this.E1();
        }
    }

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class d implements SceneCallLogAdapter.b {
        public d() {
        }

        @Override // com.android.contacts.scenecard.SceneCallLogAdapter.b
        public void onContentChanged() {
            SceneDialtactsHandler sceneDialtactsHandler = SceneDialtactsFragment.this.f17213h;
            if (sceneDialtactsHandler != null) {
                sceneDialtactsHandler.removeMessages(1000);
            }
            SceneDialtactsHandler sceneDialtactsHandler2 = SceneDialtactsFragment.this.f17213h;
            if (sceneDialtactsHandler2 != null) {
                sceneDialtactsHandler2.sendEmptyMessageDelayed(1000, 350L);
            }
        }
    }

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class e extends RecyclerView.s {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            SceneDialTextEditor v10;
            kotlinx.coroutines.flow.m<String> w10;
            SceneDialPadViewController sceneDialPadViewController;
            boolean z10;
            kotlin.jvm.internal.i.f(recyclerView, "recyclerView");
            SceneCallLogAdapter sceneCallLogAdapter = SceneDialtactsFragment.this.f17209d;
            if (sceneCallLogAdapter != null) {
                if (i10 == 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sceneCallLogAdapter.Z(z10);
            }
            SceneCallLogAdapter sceneCallLogAdapter2 = SceneDialtactsFragment.this.f17209d;
            if (sceneCallLogAdapter2 != null) {
                sceneCallLogAdapter2.x(i10);
            }
            String str = null;
            if (i10 != 0 && (sceneDialPadViewController = SceneDialtactsFragment.this.f17207b) != null) {
                SceneDialPadViewController.E(sceneDialPadViewController, false, 1, null);
            }
            if (i10 == 2) {
                SceneDialPadViewController sceneDialPadViewController2 = SceneDialtactsFragment.this.f17207b;
                if (sceneDialPadViewController2 != null && (v10 = sceneDialPadViewController2.v()) != null && (w10 = v10.w()) != null) {
                    str = w10.getValue();
                }
                if (str == null || str.length() == 0) {
                    E3.q qVar = SceneDialtactsFragment.this.f17214i;
                    if (qVar != null) {
                        qVar.s();
                    }
                    E3.o oVar = SceneDialtactsFragment.this.f17215j;
                    if (oVar != null) {
                        oVar.g();
                        return;
                    }
                    return;
                }
                return;
            }
            E3.q qVar2 = SceneDialtactsFragment.this.f17214i;
            if (qVar2 != null) {
                qVar2.v();
            }
            E3.o oVar2 = SceneDialtactsFragment.this.f17215j;
            if (oVar2 != null) {
                oVar2.j();
            }
        }
    }

    /* compiled from: SceneDialtactsFragment.kt */
    /* loaded from: classes.dex */
    public static final class f extends ContentObserver {
        public f(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            if (H7.a.b()) {
                H7.b.b("SceneDialtactsFragment", "time format change");
            }
            SceneCallLogAdapter sceneCallLogAdapter = SceneDialtactsFragment.this.f17209d;
            if (sceneCallLogAdapter != null) {
                sceneCallLogAdapter.h0();
                sceneCallLogAdapter.S();
            }
        }
    }

    private final int C1() {
        kotlinx.coroutines.flow.m<Integer> y10;
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null && (y10 = sceneDialPadViewController.y()) != null) {
            return y10.getValue().intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1() {
        if (H7.a.b()) {
            H7.b.b("SceneDialtactsFragment", "contact data change or mark flag change");
        }
        if (!isAdded()) {
            if (H7.a.b()) {
                H7.b.b("SceneDialtactsFragment", "refreshData isNotAdded");
            }
        } else {
            SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
            if (sceneCallLogAdapter != null) {
                sceneCallLogAdapter.P();
                sceneCallLogAdapter.S();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(boolean z10) {
        androidx.databinding.o oVar;
        int i10;
        H7.b.e("SceneDialtactsFragment", "showOrHideNoCallLogView ： " + z10);
        x0.o oVar2 = this.f17206a;
        if (oVar2 != null && (oVar = oVar2.f37749J) != null) {
            if (!oVar.j()) {
                ViewStub i11 = oVar.i();
                if (i11 != null) {
                    i11.inflate();
                }
                ViewDataBinding g10 = oVar.g();
                kotlin.jvm.internal.i.d(g10, "null cannot be cast to non-null type com.android.contacts.databinding.SceneNoCallLogBinding");
                TextView textView = ((x0.D) g10).f37664G;
                kotlin.jvm.internal.i.e(textView, "binding as SceneNoCallLogBinding).title");
                X x10 = X.f17252a;
                x10.c(textView);
                x10.b(textView);
            }
            View root = oVar.h();
            kotlin.jvm.internal.i.e(root, "root");
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            root.setVisibility(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1() {
        ContentResolver contentResolver;
        H7.b.e("SceneDialtactsFragment", "startCallsQuery");
        if (this.f17211f == null) {
            Context context = getContext();
            if (context != null) {
                contentResolver = context.getContentResolver();
            } else {
                contentResolver = null;
            }
            this.f17211f = new com.android.contacts.calllog.r(contentResolver, this);
        }
        com.android.contacts.calllog.r rVar = this.f17211f;
        if (rVar != null) {
            rVar.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = x1(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] a10 = com.android.contacts.dialpad.a.a();
        if (H7.a.b()) {
            H7.b.b("SceneDialtactsFragment", "startQueryContacts: length = " + a10.length);
        }
        Uri b10 = com.android.contacts.dialpad.d.b(C1(), str);
        boolean c10 = com.android.contacts.dialpad.d.c(C1());
        if (this.f17212g == null) {
            this.f17212g = new b(this);
        }
        b bVar = this.f17212g;
        if (bVar != null) {
            bVar.h(true);
            bVar.g(c10);
            bVar.c(0);
            bVar.i(0, null, b10, a10, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initAdapter() {
        E3.o oVar;
        if (this.f17209d == null) {
            SceneCallLogAdapter sceneCallLogAdapter = new SceneCallLogAdapter(getContext(), androidx.lifecycle.p.a(this));
            this.f17209d = sceneCallLogAdapter;
            sceneCallLogAdapter.W(new d());
        }
        this.f17214i = new E3.q(getContext(), "");
        Context context = getContext();
        if (context != null) {
            oVar = new E3.o(context);
        } else {
            oVar = null;
        }
        this.f17215j = oVar;
        SceneCallLogAdapter sceneCallLogAdapter2 = this.f17209d;
        if (sceneCallLogAdapter2 != null) {
            sceneCallLogAdapter2.b0(this.f17214i);
        }
        SceneCallLogAdapter sceneCallLogAdapter3 = this.f17209d;
        if (sceneCallLogAdapter3 != null) {
            sceneCallLogAdapter3.a0(this.f17215j);
        }
        SceneCallLogAdapter sceneCallLogAdapter4 = this.f17209d;
        if (sceneCallLogAdapter4 != null) {
            sceneCallLogAdapter4.Y(this);
        }
        SceneCallLogAdapter sceneCallLogAdapter5 = this.f17209d;
        if (sceneCallLogAdapter5 != null) {
            sceneCallLogAdapter5.X(C1());
        }
    }

    private final void registerReceiver() {
        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.a(), null, new SceneDialtactsFragment$registerReceiver$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String x1(String str) {
        if (!TextUtils.isEmpty(str)) {
            kotlin.jvm.internal.i.c(str);
            return PhoneNumberUtils.e(y1(str));
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String y1(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        kotlin.jvm.internal.i.c(str);
        return new Regex("[ \\-().]").b(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentResolver z1() {
        Context context = getContext();
        if (context != null) {
            return context.getContentResolver();
        }
        return null;
    }

    public final int A1() {
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null) {
            return sceneDialPadViewController.x();
        }
        return -1;
    }

    public final String B1() {
        String str;
        SceneDialTextEditor v10;
        kotlinx.coroutines.flow.m<String> w10;
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null && (v10 = sceneDialPadViewController.v()) != null && (w10 = v10.w()) != null) {
            str = w10.getValue();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            return "";
        }
        return str;
    }

    public final void D1(ContentResolver contentResolver) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("new", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            Integer num = null;
            if (contentResolver != null) {
                num = Integer.valueOf(contentResolver.update(R0.d.a(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL), contentValues, "new = 1", null));
            }
            b10 = Result.b(num);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.i("SceneDialtactsFragment", "Exception thrown during markNewCallsAsOld " + d10);
        }
    }

    public final void F1() {
        androidx.databinding.o oVar;
        HeaderFooterRecyclerView headerFooterRecyclerView;
        View view = null;
        if (!this.f17218m) {
            SceneStatementAndPermissionChecker sceneStatementAndPermissionChecker = SceneStatementAndPermissionChecker.f17245a;
            x0.o oVar2 = this.f17206a;
            if (oVar2 != null) {
                oVar = oVar2.f37750K;
            } else {
                oVar = null;
            }
            if (!sceneStatementAndPermissionChecker.b(oVar)) {
                x0.o oVar3 = this.f17206a;
                if (oVar3 != null) {
                    headerFooterRecyclerView = oVar3.f37751L;
                } else {
                    headerFooterRecyclerView = null;
                }
                if (headerFooterRecyclerView != null) {
                    headerFooterRecyclerView.setVisibility(8);
                }
                x0.o oVar4 = this.f17206a;
                if (oVar4 != null) {
                    view = oVar4.f37748I;
                }
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
        }
        if (this.f17219n) {
            I1();
            this.f17219n = false;
        }
        SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
        if (sceneCallLogAdapter != null && sceneCallLogAdapter.getItemCount() > 0) {
            x0.o oVar5 = this.f17206a;
            if (oVar5 != null) {
                view = oVar5.f37751L;
            }
            if (view != null) {
                view.setVisibility(0);
            }
        }
        this.f17218m = true;
    }

    public final void G1(boolean z10) {
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null) {
            sceneDialPadViewController.a0(z10);
        }
    }

    public final void K1() {
        SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
        if (sceneCallLogAdapter != null) {
            sceneCallLogAdapter.c0(true);
        }
    }

    @Override // com.android.contacts.calllog.r.b
    public void L(Cursor cursor) {
        com.oplus.foundation.util.io.e.a(cursor);
    }

    public final void L1() {
        SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
        if (sceneCallLogAdapter != null) {
            sceneCallLogAdapter.d0();
        }
    }

    public final void M1(boolean z10) {
        HeaderFooterRecyclerView headerFooterRecyclerView;
        Resources resources;
        H7.b.e("SceneDialtactsFragment", "updateHeaderViewStatus " + z10);
        View view = this.f17216k;
        if (view != null) {
            int i10 = 0;
            if (z10) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = -2;
                }
                view.setVisibility(0);
                HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f17210e;
                if (headerFooterRecyclerView2 != null) {
                    headerFooterRecyclerView2.setPadding(headerFooterRecyclerView2.getPaddingLeft(), 0, headerFooterRecyclerView2.getPaddingRight(), headerFooterRecyclerView2.getPaddingBottom());
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
            }
            view.setVisibility(8);
            HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f17210e;
            if (headerFooterRecyclerView3 != null && headerFooterRecyclerView3.getPaddingTop() == 0 && (headerFooterRecyclerView = this.f17210e) != null) {
                Context context = view.getContext();
                if (context != null && (resources = context.getResources()) != null) {
                    i10 = resources.getDimensionPixelSize(R.dimen.DP_60);
                }
                headerFooterRecyclerView.setPadding(headerFooterRecyclerView.getPaddingLeft(), i10, headerFooterRecyclerView.getPaddingRight(), headerFooterRecyclerView.getPaddingBottom());
            }
        }
    }

    public final void N1() {
        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new SceneDialtactsFragment$updateVoicemailNumber$1(this, null), 2, null);
    }

    @Override // com.android.contacts.calllog.r.b
    public void d(Cursor cursor) {
        SceneDialTextEditor v10;
        kotlinx.coroutines.flow.m<String> w10;
        boolean z10;
        H7.b.e("SceneDialtactsFragment", "onCallsFetched");
        if (isAdded()) {
            SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
            if (sceneCallLogAdapter != null) {
                SceneSimCardStateManager sceneSimCardStateManager = this.f17208c;
                if (sceneSimCardStateManager != null && sceneSimCardStateManager.j()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sceneCallLogAdapter.e0(cursor, z10);
            }
            if (cursor != null && cursor.getCount() > 6000) {
                SceneDialtactsHandler sceneDialtactsHandler = this.f17213h;
                if (sceneDialtactsHandler != null) {
                    sceneDialtactsHandler.removeMessages(999);
                }
                SceneDialtactsHandler sceneDialtactsHandler2 = this.f17213h;
                if (sceneDialtactsHandler2 != null) {
                    sceneDialtactsHandler2.sendEmptyMessageDelayed(999, 500L);
                }
            }
            m9.q qVar = null;
            r0 = null;
            r0 = null;
            String str = null;
            qVar = null;
            if (cursor != null) {
                if (cursor.isClosed() || cursor.getCount() <= 0) {
                    cursor = null;
                }
                if (cursor != null) {
                    HeaderFooterRecyclerView headerFooterRecyclerView = this.f17210e;
                    if (headerFooterRecyclerView != null) {
                        headerFooterRecyclerView.setVisibility(0);
                    }
                    SceneDialPadViewController sceneDialPadViewController = this.f17207b;
                    if (sceneDialPadViewController != null && (v10 = sceneDialPadViewController.v()) != null && (w10 = v10.w()) != null) {
                        str = w10.getValue();
                    }
                    if (str == null || str.length() == 0) {
                        M1(true);
                    }
                    H1(false);
                    qVar = m9.q.f35511a;
                }
            }
            if (qVar == null) {
                HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f17210e;
                if (headerFooterRecyclerView2 != null) {
                    headerFooterRecyclerView2.setVisibility(8);
                }
                H1(true);
            }
        }
    }

    public final boolean isDialpadShow() {
        Boolean bool;
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null) {
            bool = Boolean.valueOf(sceneDialPadViewController.J());
        } else {
            bool = null;
        }
        H7.b.e("SceneDialtactsFragment", "isDialpadShow: " + bool);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        H7.b.e("SceneDialtactsFragment", "onActivityCreated");
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        H7.b.e("SceneDialtactsFragment", "onAttach");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ContentResolver contentResolver;
        super.onCreate(bundle);
        H7.b.e("SceneDialtactsFragment", "onCreate");
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        SceneSimCardStateManager sceneSimCardStateManager = new SceneSimCardStateManager(requireContext, androidx.lifecycle.p.a(this));
        this.f17208c = sceneSimCardStateManager;
        Context requireContext2 = requireContext();
        kotlin.jvm.internal.i.e(requireContext2, "requireContext()");
        SceneDialPadViewController sceneDialPadViewController = new SceneDialPadViewController(requireContext2, sceneSimCardStateManager, androidx.lifecycle.p.a(this));
        this.f17207b = sceneDialPadViewController;
        getLifecycle().a(sceneDialPadViewController);
        getLifecycle().a(sceneSimCardStateManager);
        Context context = getContext();
        if (context != null) {
            contentResolver = context.getContentResolver();
        } else {
            contentResolver = null;
        }
        this.f17211f = new com.android.contacts.calllog.r(contentResolver, this);
        this.f17212g = new b(this);
        this.f17213h = new SceneDialtactsHandler(this);
        initAdapter();
        registerReceiver();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlinx.coroutines.flow.m<Y> h10;
        kotlinx.coroutines.flow.m<Integer> y10;
        SceneDialTextEditor v10;
        kotlinx.coroutines.flow.m<String> w10;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        H7.b.e("SceneDialtactsFragment", "onCreateView");
        x0.o i12 = x0.o.i1(inflater, viewGroup, false);
        kotlin.jvm.internal.i.e(i12, "inflate(inflater, container, false)");
        TextView textView = null;
        this.f17216k = LayoutInflater.from(getContext()).inflate(R.layout.scene_call_log_list_header_layout, (ViewGroup) null);
        HeaderFooterRecyclerView headerFooterRecyclerView = i12.f37751L;
        headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(headerFooterRecyclerView.getContext()));
        headerFooterRecyclerView.setAdapter(this.f17209d);
        View view = this.f17216k;
        if (view != null) {
            HeaderFooterRecyclerView headerFooterRecyclerView2 = i12.f37751L;
            kotlin.jvm.internal.i.e(headerFooterRecyclerView2, "rootViewBinding.recyclerView");
            HeaderFooterRecyclerView.z(headerFooterRecyclerView2, view, null, 0, 6, null);
            X x10 = X.f17252a;
            x10.c(view);
            View view2 = this.f17216k;
            if (view2 instanceof TextView) {
                textView = (TextView) view2;
            }
            x10.b(textView);
        }
        HeaderFooterRecyclerView headerFooterRecyclerView3 = i12.f37751L;
        this.f17210e = headerFooterRecyclerView3;
        if (headerFooterRecyclerView3 != null) {
            headerFooterRecyclerView3.addOnScrollListener(new e());
        }
        this.f17206a = i12;
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null) {
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            COUIFloatingButton cOUIFloatingButton = i12.f37748I;
            kotlin.jvm.internal.i.e(cOUIFloatingButton, "rootViewBinding.floatingButton");
            androidx.databinding.o oVar = i12.f37747H;
            kotlin.jvm.internal.i.e(oVar, "rootViewBinding.dialpadContainerViewStub");
            androidx.databinding.o oVar2 = i12.f37746G;
            kotlin.jvm.internal.i.e(oVar2, "rootViewBinding.dialEditTextContainerViewStub");
            sceneDialPadViewController.H(requireContext, cOUIFloatingButton, oVar, oVar2);
        }
        SceneDialPadViewController sceneDialPadViewController2 = this.f17207b;
        if (sceneDialPadViewController2 != null && (v10 = sceneDialPadViewController2.v()) != null && (w10 = v10.w()) != null) {
            FlowExtKt.a(w10, this, Lifecycle.State.CREATED, new v9.l<String, m9.q>() { // from class: com.android.contacts.scenecard.SceneDialtactsFragment$onCreateView$4
                {
                    super(1);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(String str) {
                    invoke2(str);
                    return m9.q.f35511a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    String str2;
                    HeaderFooterRecyclerView headerFooterRecyclerView4;
                    if (str == null) {
                        H7.b.e("SceneDialtactsFragment", "numberStateFlow is init value");
                        return;
                    }
                    if (H7.a.b()) {
                        H7.b.b("SceneDialtactsFragment", "numberStateFlow : " + H7.a.d(str));
                    }
                    HeaderFooterRecyclerView headerFooterRecyclerView5 = SceneDialtactsFragment.this.f17210e;
                    if (headerFooterRecyclerView5 != null) {
                        headerFooterRecyclerView5.scrollToPosition(0);
                    }
                    str2 = SceneDialtactsFragment.this.f17217l;
                    if ((str2 == null || str2.length() == 0) && (headerFooterRecyclerView4 = SceneDialtactsFragment.this.f17210e) != null) {
                        headerFooterRecyclerView4.setVisibility(8);
                    }
                    if (str.length() == 0) {
                        SceneDialtactsFragment.this.I1();
                    } else {
                        SceneDialtactsFragment.this.J1(str);
                        SceneDialtactsFragment.this.H1(false);
                        SceneDialtactsFragment.this.M1(false);
                    }
                    SceneDialtactsFragment.this.f17217l = str;
                }
            });
        }
        SceneDialPadViewController sceneDialPadViewController3 = this.f17207b;
        if (sceneDialPadViewController3 != null && (y10 = sceneDialPadViewController3.y()) != null) {
            FlowExtKt.b(y10, this, null, new v9.l<Integer, m9.q>() { // from class: com.android.contacts.scenecard.SceneDialtactsFragment$onCreateView$5
                {
                    super(1);
                }

                public final void b(int i10) {
                    SceneCallLogAdapter sceneCallLogAdapter = SceneDialtactsFragment.this.f17209d;
                    if (sceneCallLogAdapter != null) {
                        sceneCallLogAdapter.X(i10);
                    }
                    SceneDialtactsFragment sceneDialtactsFragment = SceneDialtactsFragment.this;
                    sceneDialtactsFragment.J1(sceneDialtactsFragment.B1());
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Integer num) {
                    b(num.intValue());
                    return m9.q.f35511a;
                }
            }, 2, null);
        }
        SceneSimCardStateManager sceneSimCardStateManager = this.f17208c;
        if (sceneSimCardStateManager != null && (h10 = sceneSimCardStateManager.h()) != null) {
            FlowExtKt.b(h10, this, null, new v9.l<Y, m9.q>() { // from class: com.android.contacts.scenecard.SceneDialtactsFragment$onCreateView$6
                {
                    super(1);
                }

                public final void b(Y it) {
                    kotlin.jvm.internal.i.f(it, "it");
                    SceneCallLogAdapter sceneCallLogAdapter = SceneDialtactsFragment.this.f17209d;
                    if (sceneCallLogAdapter != null) {
                        sceneCallLogAdapter.g0(it.c(), it.e(), it.h());
                    }
                    SceneCallLogAdapter sceneCallLogAdapter2 = SceneDialtactsFragment.this.f17209d;
                    if (sceneCallLogAdapter2 != null) {
                        sceneCallLogAdapter2.S();
                    }
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Y y11) {
                    b(y11);
                    return m9.q.f35511a;
                }
            }, 2, null);
        }
        View K02 = i12.K0();
        kotlin.jvm.internal.i.e(K02, "rootViewBinding.root");
        return K02;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
        if (sceneCallLogAdapter != null) {
            SceneCallLogAdapter.f0(sceneCallLogAdapter, null, false, 2, null);
        }
        super.onDestroy();
        H7.b.e("SceneDialtactsFragment", "onDestroy");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        try {
            Context context = getContext();
            if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
                contentResolver2.unregisterContentObserver(this.f17220o);
            }
            Context context2 = getContext();
            if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
                contentResolver.unregisterContentObserver(this.f17221p);
            }
            X.a.b(requireContext()).e(this.f17222q);
            X.a.b(requireContext()).e(this.f17223r);
        } catch (Exception e10) {
            H7.b.c("SceneDialtactsFragment", "exception in unregister observer " + e10);
        }
        super.onDestroyView();
        H7.b.e("SceneDialtactsFragment", "onDestroyView");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        H7.b.e("SceneDialtactsFragment", "onDetach");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H7.b.e("SceneDialtactsFragment", "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H7.b.e("SceneDialtactsFragment", "onResume");
        F1();
        SceneCallLogAdapter sceneCallLogAdapter = this.f17209d;
        if (sceneCallLogAdapter != null) {
            sceneCallLogAdapter.P();
        }
        N1();
        J1(B1());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        SceneDialPadViewController sceneDialPadViewController = this.f17207b;
        if (sceneDialPadViewController != null) {
            sceneDialPadViewController.K(outState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        H7.b.e("SceneDialtactsFragment", "onStart");
        K1();
        E3.q qVar = this.f17214i;
        if (qVar != null) {
            qVar.v();
        }
        E3.o oVar = this.f17215j;
        if (oVar != null) {
            oVar.j();
        }
        v1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        H7.b.e("SceneDialtactsFragment", "onStop");
        L1();
        E3.q qVar = this.f17214i;
        if (qVar != null) {
            qVar.y();
        }
        E3.o oVar = this.f17215j;
        if (oVar != null) {
            oVar.l();
        }
        E3.o oVar2 = this.f17215j;
        if (oVar2 != null) {
            oVar2.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        androidx.databinding.o oVar;
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        H7.b.e("SceneDialtactsFragment", "onViewCreated");
        SceneStatementAndPermissionChecker sceneStatementAndPermissionChecker = SceneStatementAndPermissionChecker.f17245a;
        x0.o oVar2 = this.f17206a;
        if (oVar2 != null) {
            oVar = oVar2.f37750K;
        } else {
            oVar = null;
        }
        boolean b10 = sceneStatementAndPermissionChecker.b(oVar);
        this.f17218m = b10;
        if (b10) {
            I1();
            this.f17219n = false;
        }
        try {
            Context context = getContext();
            if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
                contentResolver2.registerContentObserver(Settings.System.getUriFor("time_12_24"), true, this.f17220o);
            }
            Context context2 = getContext();
            if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
                contentResolver.registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.f17221p);
            }
            X.a b11 = X.a.b(requireContext());
            kotlin.jvm.internal.i.e(b11, "getInstance(requireContext())");
            b11.c(this.f17222q, new IntentFilter("com.oplus.contacts.display_settings_changed"));
        } catch (Exception e10) {
            H7.b.c("SceneDialtactsFragment", "exception in register observer " + e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            HeaderFooterRecyclerView headerFooterRecyclerView = this.f17210e;
            if (headerFooterRecyclerView != null) {
                headerFooterRecyclerView.scrollToPosition(0);
            }
            SceneDialPadViewController sceneDialPadViewController = this.f17207b;
            if (sceneDialPadViewController != null) {
                sceneDialPadViewController.M(bundle);
            }
        }
    }

    public final void v1() {
        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.b(), null, new SceneDialtactsFragment$clearNotificationAndUnreadAsync$1(this, null), 2, null);
    }

    public final void w1() {
        String B12 = B1();
        if (B12 == null || B12.length() == 0) {
            I1();
        }
    }
}
