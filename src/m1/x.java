package m1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.dialpad.SimInfoManager;
import com.android.contacts.framework.baseui.behavior.BaseTitleBehavior;
import com.android.contacts.framework.baseui.util.C0638c;
import com.android.contacts.list.ContactListFilter;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.manager.n;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.M;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.widget.MultiChoiceListView;
import com.customize.contacts.widget.TouchSearchView;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import h1.C1073b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import m1.AbstractC1316l;
import m1.x;
import r0.C1498a;

/* compiled from: DefaultContactBrowseListFragment.java */
/* loaded from: classes.dex */
public class x extends AbstractC1310f implements TouchSearchView.d, AbstractC1316l.a, M.d, BaseTitleBehavior.b {

    /* renamed from: d1, reason: collision with root package name */
    public static final AtomicInteger f35037d1 = new AtomicInteger();

    /* renamed from: K0, reason: collision with root package name */
    public BroadcastReceiver f35039K0;

    /* renamed from: L0, reason: collision with root package name */
    public TextView f35040L0;

    /* renamed from: M0, reason: collision with root package name */
    public MultiChoiceListView f35041M0;

    /* renamed from: N0, reason: collision with root package name */
    public Context f35042N0;

    /* renamed from: P0, reason: collision with root package name */
    public x f35044P0;

    /* renamed from: S0, reason: collision with root package name */
    public CancellationSignal f35047S0;

    /* renamed from: T0, reason: collision with root package name */
    public COUIToolbar f35048T0;

    /* renamed from: U0, reason: collision with root package name */
    public AppBarLayout f35049U0;

    /* renamed from: V0, reason: collision with root package name */
    public CoordinatorLayout.e f35050V0;

    /* renamed from: W0, reason: collision with root package name */
    public f f35051W0;

    /* renamed from: X0, reason: collision with root package name */
    public HandlerThread f35052X0;

    /* renamed from: Y0, reason: collision with root package name */
    public ThreadPoolExecutor f35053Y0;

    /* renamed from: J0, reason: collision with root package name */
    public boolean f35038J0 = false;

    /* renamed from: Q0, reason: collision with root package name */
    public T f35045Q0 = null;

    /* renamed from: R0, reason: collision with root package name */
    public boolean f35046R0 = false;

    /* renamed from: Z0, reason: collision with root package name */
    public final Handler f35054Z0 = new a(Looper.getMainLooper());

    /* renamed from: a1, reason: collision with root package name */
    public final Handler f35055a1 = new b(Looper.getMainLooper());

    /* renamed from: b1, reason: collision with root package name */
    public final View.OnFocusChangeListener f35056b1 = new View.OnFocusChangeListener() { // from class: m1.v
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z10) {
            x.this.o3(view, z10);
        }
    };

    /* renamed from: c1, reason: collision with root package name */
    public final BroadcastReceiver f35057c1 = new c();

    /* renamed from: O0, reason: collision with root package name */
    public int f35043O0 = f35037d1.getAndIncrement();

    /* compiled from: DefaultContactBrowseListFragment.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                x.this.p3();
            }
        }
    }

    /* compiled from: DefaultContactBrowseListFragment.java */
    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final /* synthetic */ void b() {
            EditText editText = x.this.f34970k;
            if (editText != null) {
                editText.clearFocus();
            }
            T t10 = x.this.f34952b;
            if (t10 != 0) {
                ((AbstractC1315k) t10).notifyDataSetChanged();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 5) {
                n.i iVar = (n.i) message.obj;
                n.h hVar = new n.h() { // from class: m1.y
                    @Override // com.customize.contacts.manager.n.h
                    public final void a() {
                        x.b.this.b();
                    }
                };
                if (x.this.getActivity() != null && !x.this.getActivity().isDestroyed() && !x.this.getActivity().isFinishing()) {
                    x xVar = x.this;
                    com.customize.contacts.manager.n.B(xVar, xVar.f35042N0, iVar, 1, true, xVar.l3(), hVar);
                } else {
                    return;
                }
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: DefaultContactBrowseListFragment.java */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            H7.b.b("DefaultListFragment", "intent.getAction() = " + intent.getAction());
            if ("android.intent.action.SIM_STATE_CHANGED".equals(intent.getAction())) {
                x.this.f35054Z0.removeMessages(11);
                x.this.f35054Z0.sendEmptyMessageDelayed(11, 1000L);
                String l10 = C7.e.l(intent, "reason");
                String l11 = C7.e.l(intent, "ss");
                ContactListFilter A22 = x.this.A2();
                if (!"PLUGOUT".equals(l10) && !"ABSENT".equals(l11)) {
                    if (A22.f16746j) {
                        A22.f16746j = false;
                        x.this.I2();
                        T t10 = x.this.f34952b;
                        if (t10 != 0) {
                            ((AbstractC1315k) t10).y0(A22);
                            x.this.V1();
                        }
                        H7.b.e("DefaultListFragment", "load sim contacts!");
                        return;
                    }
                    return;
                }
                if (!A22.f16746j) {
                    A22.f16746j = true;
                    A22.f16745i = true;
                    T t11 = x.this.f34952b;
                    if (t11 != 0) {
                        ((AbstractC1315k) t11).y0(A22);
                        x.this.V1();
                    }
                    H7.b.e("DefaultListFragment", "pull out sim contacts!");
                    return;
                }
                return;
            }
            if (TextUtils.equals(intent.getAction(), C1498a.f36265x)) {
                x.this.f35054Z0.removeMessages(11);
                x.this.f35054Z0.sendEmptyMessageDelayed(11, 1000L);
            }
        }
    }

    /* compiled from: DefaultContactBrowseListFragment.java */
    /* loaded from: classes.dex */
    public final class d implements L {
        @Override // m1.L
        public void b(Uri uri) {
            Intent intent = new Intent(x.this.f35042N0, (Class<?>) CallDetailActivity.class);
            intent.setData(uri);
            if (CommonFeatureOption.o(x.this.getContext())) {
                x.this.w3(intent);
            } else {
                R7.b.d(x.this.getActivity(), intent, R.string.activity_not_found);
            }
        }

        @Override // m1.L
        public void c(String str) {
            x.this.u3(str);
        }

        @Override // m1.L
        public void d() {
            ContactListFilter A22 = x.this.f35044P0.A2();
            if (A22 != null && A22.f16738b == -6) {
                x.this.f35044P0.O2(ContactListFilter.h(-2));
            } else {
                x.this.f35044P0.P2(ContactListFilter.h(-6), false);
            }
        }

        public d() {
        }

        @Override // m1.L
        public void a() {
        }
    }

    /* compiled from: DefaultContactBrowseListFragment.java */
    /* loaded from: classes.dex */
    public final class e extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            H7.b.b("DefaultListFragment", "Get Broadcast: " + action);
            boolean z10 = false;
            if ("com.oplus.contacts.DETAIL_UPDATE_DONE".equals(action)) {
                if (C7.e.c(intent, "notInsertVipToBlackList", false)) {
                    com.oplus.foundation.util.ui.c.b(x.this.getActivity(), R.string.oplus_not_add_to_backlist_in_vip);
                }
            } else {
                if ("oplus.intent.action.DELETE_CONTACT_COMPLET".equals(action)) {
                    return;
                }
                if (C7.e.c(intent, "force_refresh", false)) {
                    x.this.f35046R0 = true;
                }
                if ("oplus.intent.action.ACTION_RESTORE_FILTER".equals(action)) {
                    x.this.I2();
                    z10 = true;
                }
                if ("com.oplus.contacts.display_settings_changed".equals(action) || z10) {
                    x.this.f35044P0.V1();
                }
            }
        }

        public e() {
        }
    }

    /* compiled from: DefaultContactBrowseListFragment.java */
    /* loaded from: classes.dex */
    public static class f extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<x> f35063a;

        public f(Looper looper, x xVar) {
            super(looper);
            this.f35063a = new WeakReference<>(xVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            x xVar = this.f35063a.get();
            if (xVar != null && message.what == 1) {
                xVar.s3();
                xVar.r3();
            }
        }
    }

    public x() {
        k2(true);
        p2(true);
        t2(true);
        this.f35044P0 = this;
    }

    private void d3() {
        this.f35044P0.Q2(new d());
        this.f35044P0.c2(1);
    }

    private void i3() {
        ImageView imageView = this.f34974m;
        if (imageView instanceof EffectiveAnimationView) {
            ((EffectiveAnimationView) imageView).cancelAnimation();
        }
        this.f34976n.setVisibility(8);
    }

    private void q3() {
        this.f35051W0.removeCallbacksAndMessages(null);
        this.f35051W0.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3() {
        if (!this.f35038J0 && this.f35042N0 != null) {
            H7.b.b("DefaultListFragment", "registerSimStateChangeReceiver");
            IntentFilter intentFilter = new IntentFilter();
            C0811w.j(this.f35042N0, this.f35057c1, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
            intentFilter.addAction("android.intent.action.SIM_SETTING_INFO_CHANGED");
            intentFilter.addAction(C1498a.f36265x);
            this.f35042N0.registerReceiver(this.f35057c1, intentFilter, R0.b.f3175i, null, 2);
            this.f35038J0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        this.f35039K0 = new e();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oplus.contacts.display_settings_changed");
        intentFilter.addAction("com.oplus.contacts.DETAIL_UPDATE_DONE");
        intentFilter.addAction("oplus.intent.action.DELETE_CONTACT_COMPLET");
        intentFilter.addAction("oplus.intent.action.ACTION_RESTORE_FILTER");
        X.a.b(requireContext()).c(this.f35039K0, intentFilter);
    }

    private void t3(int i10) {
        MultiChoiceListView multiChoiceListView = this.f35041M0;
        if (multiChoiceListView == null) {
            return;
        }
        multiChoiceListView.setPadding(0, i10, 0, multiChoiceListView.getPaddingBottom());
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior.b
    public void A(ViewGroup viewGroup, int i10) {
        ((AbstractC1315k) this.f34952b).d1(false);
        if (i10 != 2 && i10 != 1) {
            T t10 = this.f35045Q0;
            if (t10 != null) {
                t10.b0(false);
                if (this.f35045Q0.U()) {
                    this.f35045Q0.p();
                    this.f35045Q0.Y(false);
                }
            }
        } else {
            T t11 = this.f35045Q0;
            if (t11 != null) {
                t11.b0(true);
            }
        }
        if (viewGroup instanceof AbsListView) {
            super.onScrollStateChanged((AbsListView) viewGroup, i10);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        this.f35048T0 = (COUIToolbar) view.findViewById(R.id.toolbar);
        this.f35049U0 = (AppBarLayout) view.findViewById(R.id.appbar);
        this.f34978o = view.findViewById(R.id.search_line);
        k3(view);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public boolean E1() {
        return true;
    }

    @Override // com.customize.contacts.util.M.d
    public void G0(View view, int i10, int i11) {
        int e32 = e3(i10, i11);
        H7.b.b("DefaultListFragment", "onListItemClick position = " + i10 + " ,partition = " + i11 + " ,adjPosition = " + e32);
        if (e32 < 0) {
            return;
        }
        T t10 = this.f34952b;
        if (t10 != 0 && e32 > ((AbstractC1315k) t10).getCount()) {
            return;
        }
        R1(e32, 0L);
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior.b
    public void K0(ViewGroup viewGroup, int i10, int i11, int i12) {
        ((AbstractC1315k) this.f34952b).d1(false);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, m1.AbstractC1316l.a
    public void M0() {
        O2(this.f34929F.e());
        super.M0();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void R1(int i10, long j10) {
        AbstractC1315k m12;
        if (this.f34960f) {
            HashMap hashMap = new HashMap();
            hashMap.put("search_input_count", Integer.valueOf(this.f34970k.getText().length()));
            hashMap.put("search_result_count", Integer.valueOf(((AbstractC1315k) this.f34952b).getCount() - 1));
            hashMap.put("view_position", Integer.valueOf(i10 - 1));
            hashMap.put("search_type", Integer.valueOf(g3((Cursor) ((AbstractC1315k) this.f34952b).getItem(i10))));
            com.android.contacts.framework.baseui.util.A.a(getContext(), 2000307, 200030045, hashMap, false);
        }
        if ((!C7.a.a() || DisplayUtil.n(requireActivity())) && (m12 = m1()) != null) {
            S2(m12.S0(i10));
        }
    }

    @Override // m1.AbstractC1310f, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        if (cursor == null) {
            return;
        }
        if (!(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        if (!cursor.isClosed()) {
            int count = cursor.getCount();
            if (H7.a.b()) {
                H7.b.e("DefaultListFragment", "count = " + count);
            }
        }
        super.S0(cVar, cursor);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void U1() {
        EditText editText = this.f34970k;
        if (editText == null) {
            return;
        }
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.f34962g = false;
            x3(false, 0);
            v2();
        } else {
            this.f34962g = true;
            y1();
        }
        this.f34885q0.c(obj);
        if (!CommonFeatureOption.j()) {
            o0.f.f(getActivity(), C1073b.b(obj), obj);
        }
    }

    @Override // com.customize.contacts.util.M.d
    public boolean V0(View view, MotionEvent motionEvent) {
        T t10 = this.f34952b;
        if (t10 != 0) {
            ((AbstractC1315k) t10).d1(false);
        }
        return onTouch(view, motionEvent);
    }

    @Override // com.customize.contacts.util.M.d
    public void c0(View view, int i10, int i11, int i12, int i13) {
        int e32 = e3(i10, i11);
        H7.b.b("DefaultListFragment", "onLongClick position = " + i10 + " ,partition = " + i11 + " ,adjPosition = " + e32);
        T t10 = this.f34952b;
        if (t10 != 0) {
            int r10 = ((AbstractC1315k) t10).r();
            if (i11 >= 0 && i11 < r10) {
                long b10 = ((D) ((AbstractC1315k) this.f34952b).q(i11)).b();
                H7.b.b("DefaultListFragment", "the partition is " + i11 + ", the directoryId is " + b10);
                if (b10 > 0) {
                    return;
                }
            } else {
                H7.b.c("DefaultListFragment", "partition =" + i11 + ", partitionCount =" + r10);
                return;
            }
        }
        if (e32 >= 0) {
            Context context = this.f35042N0;
            if (context instanceof ContactsTabActivity) {
                ((ContactsTabActivity) context).g3(false);
            }
            h3(view, e32, i12, i13);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    /* renamed from: c3 */
    public AbstractC1315k k1() {
        C1304B c1304b = new C1304B(getContext());
        c1304b.P(K1());
        c1304b.w0(true);
        c1304b.D0(false);
        c1304b.w1(true);
        c1304b.x1(this);
        return c1304b;
    }

    public final int e3(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        T t10 = this.f34952b;
        int i15 = 0;
        if (t10 != 0) {
            i13 = ((AbstractC1315k) t10).r();
            if (i11 >= 0 && i11 < i13) {
                int i16 = 0;
                int i17 = 0;
                for (int i18 = 0; i18 <= i11; i18++) {
                    if (((AbstractC1315k) this.f34952b).v(i18) && ((((AbstractC1315k) this.f34952b).l(i18) != null && ((AbstractC1315k) this.f34952b).l(i18).getCount() > 0) || ((AbstractC1315k) this.f34952b).q(i18).a())) {
                        i16++;
                    }
                    if (i18 > 0) {
                        int i19 = i18 - 1;
                        if (((AbstractC1315k) this.f34952b).l(i19) != null) {
                            i14 = ((AbstractC1315k) this.f34952b).l(i19).getCount();
                        } else {
                            i14 = 0;
                        }
                        i17 += i14;
                    }
                }
                i12 = i16 + i17 + i10;
                i15 = i17;
            } else {
                return -1;
            }
        } else {
            i12 = i10;
            i13 = 0;
        }
        H7.b.b("DefaultListFragment", "getAdjPosition position = " + i10 + ", partition = " + i11 + ", adjPosition = " + i12 + ", offset = " + i15 + ", partitionCount = " + i13);
        return i12;
    }

    public final int f3() {
        return com.android.contacts.framework.baseui.util.B.a(this.f35042N0) + this.f35042N0.getResources().getDimensionPixelOffset(R.dimen.large_toolbar_height);
    }

    public int g3(Cursor cursor) {
        if (cursor == null) {
            return -1;
        }
        try {
            int charAt = cursor.getString(cursor.getColumnIndex("highlights")).charAt(8) - '0';
            if (charAt != 1 && charAt != 2) {
                return 0;
            }
            return charAt;
        } catch (Exception unused) {
            H7.b.c("DefaultListFragment", "get search type error");
            return -1;
        }
    }

    public void h3(final View view, int i10, final int i11, final int i12) {
        Uri S02;
        AbstractC1315k m12 = m1();
        if (m12 == null || (S02 = m12.S0(i10)) == null) {
            return;
        }
        view.setBackgroundColor(com.android.contacts.framework.baseui.util.r.b(getContext()));
        final long parseId = ContentUris.parseId(S02);
        H7.b.b("DefaultListFragment", "handleItemLongClick contactId = " + parseId);
        final String Q02 = m12.Q0(i10);
        final String R02 = m12.R0(i10);
        final String P02 = m12.P0(i10);
        final boolean a12 = m12.a1(i10);
        CancellationSignal cancellationSignal = this.f35047S0;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        this.f35047S0 = new CancellationSignal();
        this.f35053Y0.execute(new Runnable() { // from class: m1.w
            @Override // java.lang.Runnable
            public final void run() {
                x.this.m3(parseId, view, Q02, R02, P02, a12, i11, i12);
            }
        });
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public W.b j1() {
        Context activity;
        if (getActivity() == null) {
            activity = getContext();
        } else {
            activity = getActivity();
        }
        T t10 = new T(activity);
        this.f35045Q0 = t10;
        return t10;
    }

    public void j3(View view) {
        this.f34976n = view.findViewById(R.id.empty_view_group);
        this.f35040L0 = (TextView) view.findViewById(R.id.empty_view);
        this.f34974m = (ImageView) view.findViewById(R.id.no_content);
        this.f35040L0.setText(R.string.search_no_result);
    }

    public void k3(View view) {
        if (this.f35041M0 != null) {
            return;
        }
        j3(view);
        MultiChoiceListView multiChoiceListView = (MultiChoiceListView) u1();
        this.f35041M0 = multiChoiceListView;
        multiChoiceListView.setVisibility(4);
        View findViewById = view.findViewById(R.id.contact_list_view);
        this.f35041M0.setNestedScrollingEnabled(true);
        this.f35041M0.setTag(findViewById);
        this.f35041M0.setOnScrollListener(this);
        this.f35041M0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: m1.t
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                x.this.n3(adapterView, view2, i10, j10);
            }
        });
        this.f35041M0.setOnTouchListener(new View.OnTouchListener() { // from class: m1.u
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return x.this.V0(view2, motionEvent);
            }
        });
        this.f35041M0.setItemsCanFocus(true);
        C0811w.m(this.f35041M0);
    }

    public boolean l3() {
        return this.f34960f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        if (r5.getCount() > 0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void m3(long r22, android.view.View r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, boolean r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.x.m3(long, android.view.View, java.lang.String, java.lang.String, java.lang.String, boolean, int, int):void");
    }

    public final /* synthetic */ void n3(AdapterView adapterView, View view, int i10, long j10) {
        G0(view, ((Integer) view.getTag(R.id.contacts_list_item_position)).intValue(), ((Integer) view.getTag(R.id.contacts_list_item_partition)).intValue());
    }

    public final /* synthetic */ void o3(View view, boolean z10) {
        if ((view instanceof SearchView) && !z10 && this.f34962g) {
            SoftKeyboardUtil.a().b(this.f34970k);
        }
    }

    @Override // m1.AbstractC1310f, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f35042N0 = activity;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H7.b.e("DefaultListFragment", "onCreate --------");
        d3();
        this.f35053Y0 = N7.a.a();
        HandlerThread handlerThread = new HandlerThread("contacts_register_thread");
        this.f35052X0 = handlerThread;
        handlerThread.start();
        this.f35051W0 = new f(this.f35052X0.getLooper(), this);
        q3();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onDestroy() {
        y3();
        Z0.b.g(getActivity()).a();
        z3();
        super.onDestroy();
        C0810v.a();
        T t10 = this.f34952b;
        if (t10 != 0) {
            ((AbstractC1315k) t10).R(null);
        }
        U0.n.e();
        HandlerThread handlerThread = this.f35052X0;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        f fVar = this.f35051W0;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        ThreadPoolExecutor threadPoolExecutor = this.f35053Y0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f35053Y0 = null;
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f35046R0) {
            this.f35046R0 = false;
            this.f35044P0.V1();
        }
        C0638c.f15889a.e();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        ((AbstractC1315k) this.f34952b).d1(false);
        super.onScroll(absListView, i10, i11, i12);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        ((AbstractC1315k) this.f34952b).d1(false);
        if (i10 != 2 && i10 != 1) {
            T t10 = this.f35045Q0;
            if (t10 != null) {
                t10.b0(false);
                if (this.f35045Q0.U()) {
                    this.f35045Q0.p();
                    this.f35045Q0.Y(false);
                }
            }
        } else {
            T t11 = this.f35045Q0;
            if (t11 != null) {
                t11.b0(true);
            }
        }
        super.onScrollStateChanged(absListView, i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Z3.j.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View b10 = com.android.contacts.framework.baseui.util.B.b(getContext(), false);
        this.f35049U0.addView(b10, 0, b10.getLayoutParams());
        this.f35050V0 = (CoordinatorLayout.e) this.f35049U0.getLayoutParams();
        t3(f3());
    }

    public final void p3() {
        if (getActivity() == null) {
            return;
        }
        SimInfoManager simInfoManager = new SimInfoManager();
        simInfoManager.h(getActivity().getApplicationContext(), null);
        simInfoManager.a();
        T t10 = this.f34952b;
        if (t10 != 0) {
            ((AbstractC1315k) t10).notifyDataSetChanged();
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public ListView u1() {
        return super.u1();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void u2(int i10, Cursor cursor) {
        Editable editable;
        AbstractC1315k m12 = m1();
        if (m12 == null) {
            return;
        }
        int count = m12.getCount();
        EditText editText = this.f34970k;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        x3(!TextUtils.isEmpty(editable), count);
    }

    public final void u3(String str) {
        this.f35044P0.m2(str, true);
        this.f35044P0.t2(!r2.J1());
    }

    public void v3(Context context, COUISearchBar cOUISearchBar) {
        this.f34972l = cOUISearchBar;
        if (cOUISearchBar != null) {
            this.f34970k = cOUISearchBar.getSearchEditText();
            this.f34972l.addOnStateChangeListener(this);
            this.f34970k.addTextChangedListener(this.f34981p0);
            this.f34970k.setOnFocusChangeListener(this.f35056b1);
            com.android.contacts.util.z.e(this.f34970k, 50);
        }
        String string = context.getString(R.string.menu_search);
        EditText editText = this.f34970k;
        if (editText != null && this.f34972l != null) {
            editText.setHint(string);
        }
    }

    public void x3(boolean z10, int i10) {
        int i11;
        if (this.f35040L0 == null) {
            return;
        }
        if (z10) {
            if (i10 <= 0) {
                if (A7.a.a()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34974m.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    this.f34974m.setLayoutParams(layoutParams);
                    this.f34974m.setImageDrawable(requireContext().getDrawable(R.drawable.pb_ic_no_searched_contact));
                } else if (this.f34976n.getVisibility() != 0) {
                    ImageView imageView = this.f34974m;
                    if (imageView instanceof EffectiveAnimationView) {
                        EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) imageView;
                        if (com.android.contacts.framework.baseui.util.o.e(this.f35042N0)) {
                            i11 = R.raw.no_search_result_night;
                        } else {
                            i11 = R.raw.no_search_result;
                        }
                        effectiveAnimationView.setAnimation(i11);
                        ((EffectiveAnimationView) this.f34974m).playAnimation();
                    }
                }
                this.f34976n.setVisibility(0);
                return;
            }
            i3();
            return;
        }
        i3();
    }

    public final void y3() {
        try {
            if (this.f35039K0 != null) {
                X.a.b(requireContext()).e(this.f35039K0);
            }
        } catch (Exception e10) {
            H7.b.c("DefaultListFragment", "" + e10);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.contact_main_list_content, (ViewGroup) null);
    }

    public final void z3() {
        Context context;
        try {
            if (this.f35038J0 && (context = this.f35042N0) != null) {
                context.unregisterReceiver(this.f35057c1);
                this.f35038J0 = false;
            }
        } catch (Exception e10) {
            H7.b.c("DefaultListFragment", "" + e10);
        }
    }

    public void w3(Intent intent) {
    }
}
