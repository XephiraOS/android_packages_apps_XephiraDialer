package com.android.contacts.voicemail;

import U0.n;
import Z3.h;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.calllog.r;
import com.android.contacts.framework.baseui.behavior.BaseTitleBehavior;
import com.android.contacts.framework.baseui.behavior.PrimaryTitleBehavior;
import com.android.contacts.framework.baseui.util.B;
import com.android.contacts.util.C;
import com.android.contacts.util.w;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.fragment.MainFragment;
import com.customize.contacts.util.C0799j;
import com.customize.contacts.util.C0807s;
import com.customize.contacts.util.U;
import com.customize.contacts.widget.MultiChoiceListView;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import s1.k;
import s1.m;
import w0.C1643c;

/* loaded from: classes.dex */
public class VisualVoicemailCallLogFragment extends MainFragment implements COUIListView.ScrollMultiChoiceListener, AdapterView.OnItemClickListener, r.b, BaseTitleBehavior.b {

    /* renamed from: A, reason: collision with root package name */
    public ViewGroup f17784A;

    /* renamed from: D, reason: collision with root package name */
    public View f17787D;

    /* renamed from: E, reason: collision with root package name */
    public BroadcastReceiver f17788E;

    /* renamed from: j, reason: collision with root package name */
    public Context f17792j;

    /* renamed from: l, reason: collision with root package name */
    public k f17794l;

    /* renamed from: m, reason: collision with root package name */
    public r f17795m;

    /* renamed from: n, reason: collision with root package name */
    public m f17796n;

    /* renamed from: o, reason: collision with root package name */
    public View f17797o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.appcompat.app.b f17798p;

    /* renamed from: q, reason: collision with root package name */
    public g f17799q;

    /* renamed from: r, reason: collision with root package name */
    public Z3.a f17800r;

    /* renamed from: x, reason: collision with root package name */
    public MultiChoiceListView f17801x;

    /* renamed from: y, reason: collision with root package name */
    public View f17802y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f17803z;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17793k = true;

    /* renamed from: B, reason: collision with root package name */
    public ContentObserver f17785B = null;

    /* renamed from: C, reason: collision with root package name */
    public final Handler f17786C = new Handler();

    /* renamed from: F, reason: collision with root package name */
    public BroadcastReceiver f17789F = new a();

    /* renamed from: G, reason: collision with root package name */
    public final Handler f17790G = new b();

    /* renamed from: H, reason: collision with root package name */
    public h f17791H = new d();

    /* loaded from: classes.dex */
    public enum Type {
        TYPE_DELETE,
        TYPE_UPDATE
    }

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VisualVoicemailCallLogFragment.this.f17794l.h();
            VisualVoicemailCallLogFragment.this.f17794l.notifyDataSetChanged();
            VisualVoicemailCallLogFragment.this.X1();
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2 && VisualVoicemailCallLogFragment.this.isAdded() && VisualVoicemailCallLogFragment.this.f17794l != null) {
                VisualVoicemailCallLogFragment.this.J1();
                VisualVoicemailCallLogFragment.this.f17794l.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            VisualVoicemailCallLogFragment.this.f21251e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = VisualVoicemailCallLogFragment.this;
            BaseTitleBehavior baseTitleBehavior = visualVoicemailCallLogFragment.f21252f;
            if (baseTitleBehavior != null) {
                baseTitleBehavior.O(visualVoicemailCallLogFragment.f21251e, visualVoicemailCallLogFragment.f17801x);
                VisualVoicemailCallLogFragment.this.f21252f.k0();
                VisualVoicemailCallLogFragment.this.f21252f.f();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends ContentObserver {
        public e() {
            super(VisualVoicemailCallLogFragment.this.f17786C);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            if (VisualVoicemailCallLogFragment.this.isAdded() && VisualVoicemailCallLogFragment.this.f17794l != null) {
                if (VisualVoicemailCallLogFragment.this.f17790G.hasMessages(2)) {
                    VisualVoicemailCallLogFragment.this.f17790G.removeMessages(2);
                }
                VisualVoicemailCallLogFragment.this.f17790G.sendEmptyMessageDelayed(2, 100L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -3 || i10 == -1) {
                if (VisualVoicemailCallLogFragment.this.f17796n.b() == VisualVoicemailCallLogFragment.this.f17796n.c()) {
                    try {
                        Intent d10 = C0807s.d(VisualVoicemailCallLogFragment.this.f17792j);
                        if (d10 != null) {
                            S7.b.b(VisualVoicemailCallLogFragment.this, d10, 1, 0);
                            return;
                        }
                    } catch (Exception e10) {
                        H7.b.b("VisualVoicemailCallLogFragment", "get lock ui error" + e10);
                    }
                }
                VisualVoicemailCallLogFragment.this.R1(Type.TYPE_DELETE);
            }
        }

        public f() {
        }
    }

    /* loaded from: classes.dex */
    public static class g extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<VisualVoicemailCallLogFragment> f17813a;

        /* renamed from: b, reason: collision with root package name */
        public Type f17814b;

        public g(VisualVoicemailCallLogFragment visualVoicemailCallLogFragment, Type type) {
            this.f17813a = new WeakReference<>(visualVoicemailCallLogFragment);
            this.f17814b = type;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            HashSet<String> e10;
            boolean z10;
            boolean z11;
            String str;
            String str2 = "(";
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = this.f17813a.get();
            if (visualVoicemailCallLogFragment != null) {
                try {
                    if (this.f17814b == Type.TYPE_DELETE) {
                        e10 = visualVoicemailCallLogFragment.f17796n.d();
                    } else {
                        e10 = visualVoicemailCallLogFragment.f17796n.e();
                    }
                    if (this.f17814b == Type.TYPE_UPDATE && e10.size() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    StringBuilder sb = new StringBuilder("(");
                    Iterator<String> it = e10.iterator();
                    ContentValues contentValues = null;
                    int i10 = 0;
                    ContentValues contentValues2 = null;
                    while (true) {
                        z11 = z10;
                        if (!it.hasNext() || isCancelled()) {
                            break;
                        }
                        String str3 = str2;
                        sb.append("(normalized_number='" + it.next() + "')");
                        i10++;
                        if (i10 < 200 && it.hasNext()) {
                            sb.append(" OR ");
                            str = str3;
                            str2 = str;
                            z10 = z11;
                        }
                        sb.append(")");
                        sb.append(" AND (type=4)");
                        if (this.f17814b == Type.TYPE_DELETE) {
                            if (contentValues2 == null) {
                                contentValues2 = new ContentValues();
                                contentValues2.put("deleted", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                            }
                            C1.a.a("VisualVoicemailCallLogFragment", "sb.toString " + sb.toString() + " count " + visualVoicemailCallLogFragment.getActivity().getContentResolver().update(CallLog.Calls.CONTENT_URI.buildUpon().appendQueryParameter("allow_voicemails", "true").build(), contentValues2, sb.toString(), null));
                        } else {
                            if (contentValues == null) {
                                contentValues = new ContentValues();
                                contentValues.put("is_read", Boolean.TRUE);
                                contentValues.put("new", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                                contentValues.put("dirty", (Integer) 1);
                            }
                            visualVoicemailCallLogFragment.getActivity().getContentResolver().update(CallLog.Calls.CONTENT_URI.buildUpon().appendQueryParameter("allow_voicemails", "true").build(), contentValues, sb.toString(), null);
                        }
                        sb.setLength(0);
                        str = str3;
                        sb.append(str);
                        i10 = 0;
                        str2 = str;
                        z10 = z11;
                    }
                    C1.a.a("VisualVoicemailCallLogFragment", "updateAll " + z11);
                    if (z11) {
                        if (contentValues == null) {
                            contentValues = new ContentValues();
                            contentValues.put("is_read", Boolean.TRUE);
                            contentValues.put("new", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                            contentValues.put("dirty", (Integer) 1);
                        }
                        visualVoicemailCallLogFragment.getActivity().getContentResolver().update(CallLog.Calls.CONTENT_URI.buildUpon().appendQueryParameter("allow_voicemails", "true").build(), contentValues, "type=4", null);
                        return null;
                    }
                    return null;
                } catch (Exception e11) {
                    H7.b.c("VisualVoicemailCallLogFragment", "MyAsyncTask doInBackground error " + e11);
                    return null;
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = this.f17813a.get();
            if (visualVoicemailCallLogFragment != null) {
                C1.a.a("VisualVoicemailCallLogFragment", "VisualVoicemailCallLogFragment onPostExecute");
                VoicemailAsyncTaskUtil.f(visualVoicemailCallLogFragment.f17792j);
                visualVoicemailCallLogFragment.u1();
                visualVoicemailCallLogFragment.J1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(boolean z10, boolean z11) {
        ContactsTabActivity contactsTabActivity = (ContactsTabActivity) getActivity();
        if (contactsTabActivity != null) {
            contactsTabActivity.u3(z10, z11);
        }
    }

    private void initView(View view) {
        this.f21248b = (COUIToolbar) view.findViewById(R.id.toolbar);
        this.f17803z = (TextView) view.findViewById(R.id.toolbar_title);
        this.f21251e = (AppBarLayout) view.findViewById(R.id.appbar);
        View b10 = B.b(getContext(), false);
        this.f21251e.addView(b10, 0, b10.getLayoutParams());
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) this.f21251e.getLayoutParams();
        this.f21253g = eVar;
        PrimaryTitleBehavior primaryTitleBehavior = (PrimaryTitleBehavior) eVar.f();
        this.f21252f = primaryTitleBehavior;
        primaryTitleBehavior.c0(this);
        o1();
        W1();
        this.f17801x = (MultiChoiceListView) view.findViewById(R.id.vvm_list);
        int a10 = (((B.a(getContext()) + getResources().getDimensionPixelSize(R.dimen.large_toolbar_height)) + getResources().getDimensionPixelOffset(R.dimen.toolbar_title_init_height)) + getResources().getDimensionPixelOffset(R.dimen.toolbar_title_init_margin_bottom)) - getResources().getDimensionPixelOffset(R.dimen.divider_height);
        MultiChoiceListView multiChoiceListView = this.f17801x;
        multiChoiceListView.setPadding(0, a10, 0, multiChoiceListView.getPaddingBottom());
        this.f17794l = new k(getActivity(), null);
        m mVar = new m(this, this.f17791H);
        this.f17796n = mVar;
        this.f17794l.j(mVar);
        this.f17794l.l(U.d());
        this.f17797o = view.findViewById(R.id.empty_view_group);
        this.f17801x.setOnItemClickListener(this);
        this.f17801x.setScrollMultiChoiceListener(this);
        this.f17801x.setNestedScrollingEnabled(true);
        this.f17801x.setTag(view.findViewById(R.id.voicemail_layout));
        this.f17801x.setAdapter((ListAdapter) this.f17794l);
        this.f17802y = view.findViewById(R.id.divider_line);
        this.f17784A = (ViewGroup) view.findViewById(R.id.modal_message_container);
        this.f17787D = view.findViewById(R.id.tool_tip_view);
        if (C1643c.q()) {
            X1();
        }
        this.f21251e.getViewTreeObserver().addOnGlobalLayoutListener(new c());
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior.b
    public void A(ViewGroup viewGroup, int i10) {
        this.f17794l.k(false);
    }

    public void I1() {
        if (N1()) {
            u1();
        }
    }

    public final void J1() {
        if (w.o(getActivity()) && w.i(getActivity())) {
            this.f17795m.s();
        } else {
            C1.a.f("VisualVoicemailCallLogFragment", "read voicemail permission unavailable.");
        }
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior.b
    public void K0(ViewGroup viewGroup, int i10, int i11, int i12) {
        this.f17794l.k(false);
    }

    public boolean K1() {
        k kVar = this.f17794l;
        if (kVar != null && kVar.getCount() > 0) {
            return true;
        }
        return false;
    }

    public String L1(int i10) {
        if (i10 == 0) {
            return getString(R.string.select_item);
        }
        return getString(R.string.select_items, Integer.valueOf(i10));
    }

    public int M1() {
        k kVar = this.f17794l;
        if (kVar != null) {
            return kVar.getCount();
        }
        return 0;
    }

    public boolean N1() {
        m mVar = this.f17796n;
        if (mVar != null && mVar.h()) {
            return true;
        }
        return false;
    }

    public boolean O1() {
        if (N1()) {
            u1();
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity.isTaskRoot()) {
                if (!activity.moveTaskToBack(true)) {
                    activity.finish();
                }
            } else {
                activity.finish();
            }
        }
        return true;
    }

    public void P1(boolean z10, boolean z11) {
        Z1(z10, z11);
    }

    public void Q1() {
        String string;
        f fVar = new f();
        if (this.f17796n.b() == this.f17796n.c()) {
            string = getString(R.string.delete_all_voicemail);
        } else if (this.f17796n.b() > 1) {
            string = String.format(getString(R.string.delete_selected_voicemail), Integer.valueOf(this.f17796n.b()));
        } else {
            string = getString(R.string.delete_voicemail);
        }
        androidx.appcompat.app.b show = new U0.b(this.f17792j, 2132083073).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) fVar).setNeutralButton((CharSequence) string, (DialogInterface.OnClickListener) fVar).show();
        this.f17798p = show;
        n.c(show);
    }

    public final void R1(Type type) {
        g gVar = this.f17799q;
        if (gVar != null) {
            gVar.cancel(true);
            this.f17799q = null;
        }
        g gVar2 = new g(this, type);
        this.f17799q = gVar2;
        gVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void S1() {
        R1(Type.TYPE_UPDATE);
    }

    public final void T1() {
        this.f17788E = C1643c.k();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.f17788E, intentFilter, 2);
        }
    }

    public final void U1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oplus.contacts.force_refresh_calllog");
        try {
            X.a.b(getActivity()).c(this.f17789F, intentFilter);
        } catch (Exception e10) {
            H7.b.c("VisualVoicemailCallLogFragment", "Exception: " + e10);
            this.f17789F = null;
        }
    }

    public void V1(Z3.a aVar) {
        this.f17800r = aVar;
    }

    public void W1() {
        TextView textView = this.f17803z;
        if (textView != null) {
            textView.setText(R.string.voicemail);
        }
    }

    public final void X1() {
        if (this.f17784A == null) {
            return;
        }
        if (C1643c.E(getActivity(), this.f17784A)) {
            this.f17784A.setVisibility(0);
        } else {
            this.f17784A.setVisibility(8);
        }
    }

    public void Y1() {
        ActionBar supportActionBar;
        FragmentActivity activity = getActivity();
        if (activity != null && ((ContactsTabActivity) activity).H2() && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
            supportActionBar.z(R.string.oplus_voicemail_actionbar_title);
            supportActionBar.C();
        }
    }

    @Override // com.android.contacts.calllog.r.b
    public void d(Cursor cursor) {
        boolean z10;
        int i10;
        if (isAdded()) {
            this.f17794l.changeCursor(cursor);
            m mVar = this.f17796n;
            if (mVar != null) {
                mVar.m(cursor);
            }
            int i11 = 0;
            if (cursor != null && cursor.getCount() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            MultiChoiceListView multiChoiceListView = this.f17801x;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            multiChoiceListView.setVisibility(i10);
            View view = this.f17797o;
            if (z10) {
                i11 = 8;
            }
            view.setVisibility(i11);
            this.f17791H.f(z10);
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void f1() {
        this.f17791H.a(true);
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void h1() {
        m mVar = this.f17796n;
        if (mVar != null && this.f17794l != null) {
            mVar.a();
        }
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public Integer l1() {
        return Integer.valueOf(R.id.voice_mail_more_menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.f17795m = new r(getActivity().getContentResolver(), this);
        J1();
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 1 && i11 == -1) {
            R1(Type.TYPE_DELETE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f17792j = activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        U1();
        if (C1643c.q()) {
            this.f17785B = new e();
            getActivity().getContentResolver().registerContentObserver(CallLog.CONTENT_URI, true, this.f17785B);
            T1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.voicemail_layout, viewGroup, false);
        initView(inflate);
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        u1();
        g gVar = this.f17799q;
        if (gVar != null) {
            gVar.cancel(true);
            this.f17799q = null;
        }
        androidx.appcompat.app.b bVar = this.f17798p;
        if (bVar != null) {
            bVar.dismiss();
            this.f17798p = null;
        }
        if (this.f17789F != null) {
            try {
                X.a.b(getActivity()).e(this.f17789F);
                this.f17789F = null;
            } catch (IllegalArgumentException e10) {
                H7.b.c("VisualVoicemailCallLogFragment", "IllegalArgumentException: " + e10);
                this.f17789F = null;
            }
        }
        if (C1643c.q()) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            if (this.f17785B != null) {
                activity.getContentResolver().unregisterContentObserver(this.f17785B);
            }
            BroadcastReceiver broadcastReceiver = this.f17788E;
            if (broadcastReceiver != null) {
                activity.unregisterReceiver(broadcastReceiver);
            }
            C1643c.e();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f17792j = null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        m mVar = this.f17796n;
        if (mVar != null && mVar.h()) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
            this.f17796n.j(checkBox);
            C.b(view, checkBox.isChecked());
        } else {
            this.f17794l.o(i10 - this.f17801x.getHeaderViewsCount());
        }
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        CheckBox checkBox;
        m mVar = this.f17796n;
        if (mVar == null || !mVar.h() || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null) {
            return;
        }
        this.f17796n.j(checkBox);
        C.b(view, checkBox.isChecked());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!C1643c.q() || !isAdded() || this.f17784A.isShown() || this.f17787D == null) {
            return;
        }
        if (C1643c.F(getActivity(), this.f17787D)) {
            this.f17787D.setVisibility(0);
        } else {
            this.f17787D.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        C0799j.c(F7.b.e(getActivity()));
        C0799j.d(DateFormat.getTimeFormat(getActivity()));
        Y1();
        this.f17794l.l(U.d());
        this.f17794l.h();
        this.f17794l.m(false);
        if (!this.f17793k) {
            J1();
        }
        this.f17793k = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f17794l.n();
        super.onStop();
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public boolean r1() {
        ((ContactsTabActivity) getActivity()).e3(2);
        if (K1() && PrimaryUserUtils.a()) {
            return true;
        }
        return false;
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void s1() {
        this.f17796n.k();
    }

    @Override // com.customize.contacts.fragment.MainFragment
    public void u1() {
        m mVar = this.f17796n;
        if (mVar != null && mVar.h()) {
            this.f17794l.k(false);
            this.f17796n.l();
        }
    }

    /* loaded from: classes.dex */
    public class d implements h {
        public d() {
        }

        @Override // Z3.h
        public void a(boolean z10) {
            COUIToolbar cOUIToolbar = VisualVoicemailCallLogFragment.this.f21248b;
            if (cOUIToolbar != null) {
                cOUIToolbar.getMenu().clear();
                if (z10) {
                    VisualVoicemailCallLogFragment.this.f21248b.setIsTitleCenterStyle(false);
                    VisualVoicemailCallLogFragment.this.f21248b.inflateMenu(R.menu.voice_mail_menu);
                    f(VisualVoicemailCallLogFragment.this.K1());
                    e();
                    VisualVoicemailCallLogFragment.this.w1(false);
                    return;
                }
                VisualVoicemailCallLogFragment.this.f21248b.setIsTitleCenterStyle(true);
                VisualVoicemailCallLogFragment.this.f21248b.inflateMenu(R.menu.cancel_select_menu);
                VisualVoicemailCallLogFragment.this.f21248b.setNavigationIcon((Drawable) null);
                VisualVoicemailCallLogFragment.this.w1(true);
            }
        }

        @Override // Z3.h
        public void b() {
            a(false);
            VisualVoicemailCallLogFragment.this.f17794l.k(true);
            VisualVoicemailCallLogFragment.this.Z1(false, true);
            if (VisualVoicemailCallLogFragment.this.f17800r != null) {
                VisualVoicemailCallLogFragment.this.f17800r.b(VisualVoicemailCallLogFragment.this.getView());
            }
            if (VisualVoicemailCallLogFragment.this.f17794l != null) {
                VisualVoicemailCallLogFragment.this.f17794l.notifyDataSetChanged();
            }
            d();
        }

        @Override // Z3.h
        public void c() {
            a(true);
            VisualVoicemailCallLogFragment.this.f17794l.k(true);
            if (VisualVoicemailCallLogFragment.this.f17800r != null) {
                VisualVoicemailCallLogFragment.this.f17800r.a(VisualVoicemailCallLogFragment.this.getView());
            }
            if (VisualVoicemailCallLogFragment.this.f17794l != null) {
                VisualVoicemailCallLogFragment.this.f17794l.notifyDataSetChanged();
            }
        }

        @Override // Z3.h
        public void d() {
            if (VisualVoicemailCallLogFragment.this.f17803z != null) {
                TextView textView = VisualVoicemailCallLogFragment.this.f17803z;
                VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = VisualVoicemailCallLogFragment.this;
                textView.setText(visualVoicemailCallLogFragment.L1(visualVoicemailCallLogFragment.f17796n.b()));
            }
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment2 = VisualVoicemailCallLogFragment.this;
            COUIToolbar cOUIToolbar = visualVoicemailCallLogFragment2.f21248b;
            if (cOUIToolbar != null) {
                cOUIToolbar.setTitle(visualVoicemailCallLogFragment2.L1(visualVoicemailCallLogFragment2.f17796n.b()));
            }
            g();
        }

        @Override // Z3.h
        public void e() {
            VisualVoicemailCallLogFragment.this.W1();
        }

        @Override // Z3.h
        public void g() {
            boolean z10;
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment = VisualVoicemailCallLogFragment.this;
            boolean z11 = false;
            if (visualVoicemailCallLogFragment.f17796n.b() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (VisualVoicemailCallLogFragment.this.f17796n.e().size() > 0) {
                z11 = true;
            }
            visualVoicemailCallLogFragment.P1(z10, z11);
            VisualVoicemailCallLogFragment visualVoicemailCallLogFragment2 = VisualVoicemailCallLogFragment.this;
            if (visualVoicemailCallLogFragment2.f21248b != null) {
                if (visualVoicemailCallLogFragment2.f17796n.i()) {
                    VisualVoicemailCallLogFragment.this.f21248b.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
                } else {
                    VisualVoicemailCallLogFragment.this.f21248b.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
                }
            }
            if (VisualVoicemailCallLogFragment.this.f17794l != null) {
                VisualVoicemailCallLogFragment.this.f17794l.notifyDataSetChanged();
            }
        }

        @Override // Z3.h
        public void f(boolean z10) {
        }
    }

    @Override // com.android.contacts.calllog.r.b
    public void L(Cursor cursor) {
    }
}
