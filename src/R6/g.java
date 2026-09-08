package r6;

import android.R;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.K;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0861w;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.L;
import com.oplus.utils.Z;
import h9.C1087a;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import r6.b;
import r6.t;

/* compiled from: BlockedCallsListFragment.java */
/* loaded from: classes3.dex */
public class g extends Fragment implements t.b, b.InterfaceC0348b, BlockedCallLogAndSmsListActivity.g {

    /* renamed from: A, reason: collision with root package name */
    public View f36344A;

    /* renamed from: B, reason: collision with root package name */
    public androidx.appcompat.app.b f36345B;

    /* renamed from: C, reason: collision with root package name */
    public androidx.appcompat.app.b f36346C;

    /* renamed from: D, reason: collision with root package name */
    public androidx.appcompat.app.b f36347D;

    /* renamed from: E, reason: collision with root package name */
    public f f36348E;

    /* renamed from: F, reason: collision with root package name */
    public f f36349F;

    /* renamed from: G, reason: collision with root package name */
    public f f36350G;

    /* renamed from: H, reason: collision with root package name */
    public androidx.appcompat.app.b f36351H;

    /* renamed from: I, reason: collision with root package name */
    public androidx.appcompat.app.b f36352I;

    /* renamed from: J, reason: collision with root package name */
    public int f36353J;

    /* renamed from: L, reason: collision with root package name */
    public View f36355L;

    /* renamed from: a, reason: collision with root package name */
    public COUIListView f36358a;

    /* renamed from: b, reason: collision with root package name */
    public t f36359b;

    /* renamed from: c, reason: collision with root package name */
    public r6.b f36360c;

    /* renamed from: d, reason: collision with root package name */
    public C1087a f36361d;

    /* renamed from: e, reason: collision with root package name */
    public COUIToolbar f36362e;

    /* renamed from: h, reason: collision with root package name */
    public MenuItem f36365h;

    /* renamed from: j, reason: collision with root package name */
    public BlockedCallLogAndSmsListActivity.f f36367j;

    /* renamed from: k, reason: collision with root package name */
    public v f36368k;

    /* renamed from: l, reason: collision with root package name */
    public Context f36369l;

    /* renamed from: m, reason: collision with root package name */
    public long f36370m;

    /* renamed from: n, reason: collision with root package name */
    public long f36371n;

    /* renamed from: p, reason: collision with root package name */
    public e f36373p;

    /* renamed from: q, reason: collision with root package name */
    public c f36374q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f36375r;

    /* renamed from: x, reason: collision with root package name */
    public TextView f36376x;

    /* renamed from: y, reason: collision with root package name */
    public int f36377y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f36378z;

    /* renamed from: f, reason: collision with root package name */
    public final Set<String> f36363f = G6.b.a();

    /* renamed from: g, reason: collision with root package name */
    public final Set<String> f36364g = G6.b.a();

    /* renamed from: i, reason: collision with root package name */
    public int f36366i = 0;

    /* renamed from: o, reason: collision with root package name */
    public final HashMap<String, String> f36372o = new HashMap<>();

    /* renamed from: K, reason: collision with root package name */
    public final Handler f36354K = new Handler(Looper.getMainLooper());

    /* renamed from: M, reason: collision with root package name */
    public final AbsListView.OnScrollListener f36356M = new a();

    /* renamed from: N, reason: collision with root package name */
    public final InterfaceC0859u f36357N = new b();

    /* compiled from: BlockedCallsListFragment.java */
    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<g> f36382a;

        public c(g gVar) {
            this.f36382a = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            g gVar = this.f36382a.get();
            if (gVar != null && message.what == 1) {
                gVar.P1();
                gVar.o2();
            }
        }
    }

    /* compiled from: BlockedCallsListFragment.java */
    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f36383a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<g> f36384b;

        public d(g gVar, int i10) {
            this.f36384b = new WeakReference<>(gVar);
            this.f36383a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = this.f36384b.get();
            if (gVar == null) {
                return;
            }
            int i10 = this.f36383a;
            if (i10 == 1) {
                gVar.G1(gVar.f36346C);
                return;
            }
            if (i10 == 2) {
                gVar.G1(gVar.f36347D);
            } else if (i10 == 3) {
                gVar.G1(gVar.f36345B);
                C0861w.g(gVar.getContext()).l();
            }
        }
    }

    /* compiled from: BlockedCallsListFragment.java */
    /* loaded from: classes3.dex */
    public class e extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action) || F6.a.p(action) || "android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE".equals(action)) {
                if (g.this.f36374q == null) {
                    g.this.f36374q = new c(g.this);
                }
                g.this.f36374q.removeMessages(1);
                g.this.f36374q.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        public e() {
        }
    }

    /* compiled from: BlockedCallsListFragment.java */
    /* loaded from: classes3.dex */
    public static class f extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<g> f36386a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<BlockedCallLogAndSmsListActivity> f36387b;

        /* renamed from: c, reason: collision with root package name */
        public final int f36388c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f36389d;

        /* renamed from: e, reason: collision with root package name */
        public long f36390e;

        /* renamed from: f, reason: collision with root package name */
        public final int f36391f;

        public f(g gVar, int i10, Set<String> set) {
            this.f36386a = new WeakReference<>(gVar);
            this.f36387b = new WeakReference<>((BlockedCallLogAndSmsListActivity) gVar.getActivity());
            this.f36388c = i10;
            this.f36389d = set;
            this.f36391f = set.size();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity;
            g gVar = this.f36386a.get();
            if (gVar == null || (blockedCallLogAndSmsListActivity = this.f36387b.get()) == null || blockedCallLogAndSmsListActivity.isFinishing() || blockedCallLogAndSmsListActivity.isDestroyed()) {
                return null;
            }
            int i10 = this.f36388c;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        gVar.f36368k.e(blockedCallLogAndSmsListActivity, gVar.f36364g, gVar.f36366i);
                    }
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f36389d.size());
                for (String str : this.f36389d) {
                    arrayList.add(str.substring(0, str.indexOf(47)));
                }
                gVar.f36368k.c(blockedCallLogAndSmsListActivity, arrayList);
                gVar.f36368k.h(blockedCallLogAndSmsListActivity, this.f36389d, gVar.f36366i);
                return Boolean.TRUE;
            }
            return Boolean.valueOf(gVar.f36368k.h(blockedCallLogAndSmsListActivity, gVar.f36364g, gVar.f36366i));
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity;
            int i10;
            String str;
            String str2;
            g gVar = this.f36386a.get();
            if (gVar != null && (blockedCallLogAndSmsListActivity = this.f36387b.get()) != null && !blockedCallLogAndSmsListActivity.isFinishing() && !blockedCallLogAndSmsListActivity.isDestroyed()) {
                int i11 = this.f36388c;
                if (i11 == 1) {
                    gVar.H1(gVar.f36346C, 1, this.f36390e);
                    i10 = 0;
                    str = "confirm_recover";
                } else {
                    i10 = 2;
                    if (i11 == 2) {
                        gVar.H1(gVar.f36347D, 2, this.f36390e);
                        str = "confirm_add_to_allowlist";
                        i10 = 1;
                    } else if (i11 == 3) {
                        gVar.H1(gVar.f36345B, 3, this.f36390e);
                        if (this.f36391f <= 100) {
                            C0861w.g(blockedCallLogAndSmsListActivity.getApplicationContext()).l();
                        }
                        str = "confirm_delete";
                    } else {
                        i10 = -1;
                        str = "";
                    }
                }
                if (gVar.f36360c != null) {
                    gVar.f36360c.x(true);
                }
                if (gVar.f36367j != null) {
                    gVar.f36367j.b();
                }
                int i12 = this.f36391f;
                if (i12 > 1) {
                    str2 = "multi_select_yes";
                } else {
                    str2 = "yes";
                }
                blockedCallLogAndSmsListActivity.M1(i10, str, str2, String.valueOf(i12));
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity;
            g gVar = this.f36386a.get();
            if (gVar != null && (blockedCallLogAndSmsListActivity = this.f36387b.get()) != null && !blockedCallLogAndSmsListActivity.isFinishing() && !blockedCallLogAndSmsListActivity.isDestroyed()) {
                int i10 = this.f36388c;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3 && this.f36389d.size() > 100) {
                            this.f36390e = System.currentTimeMillis();
                            gVar.j2(gVar.f36369l);
                            return;
                        }
                        return;
                    }
                    this.f36390e = System.currentTimeMillis();
                    gVar.i2();
                    return;
                }
                this.f36390e = System.currentTimeMillis();
                gVar.l2();
            }
        }
    }

    public static DateFormat Q1() {
        return DateFormat.getDateInstance(3);
    }

    private void d2() {
        this.f36364g.clear();
        this.f36364g.addAll(this.f36363f);
    }

    public void B1(int i10) {
        int dimensionPixelSize;
        if (l7.b.f34742j) {
            dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27294s);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C6.f.f392f);
        }
        int i11 = dimensionPixelSize + i10;
        COUIListView cOUIListView = this.f36358a;
        cOUIListView.setPaddingRelative(cOUIListView.getPaddingStart(), this.f36358a.getPaddingTop() + i11, this.f36358a.getPaddingEnd(), this.f36358a.getPaddingBottom());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36344A.getLayoutParams();
        layoutParams.topMargin = i10;
        this.f36344A.setLayoutParams(layoutParams);
        this.f36353J = i11 + C0849j.l(this.f36369l);
    }

    public void C1() {
        C0846g.i("BlockedCallsListFragment", "blockedCallsRestoreToCallLog");
        f fVar = this.f36348E;
        if (fVar != null) {
            fVar.cancel(true);
        }
        f fVar2 = new f(this, 1, this.f36364g);
        this.f36348E = fVar2;
        fVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void D1() {
        C0846g.i("BlockedCallsListFragment", "blockedNumbersAddToWhiteList");
        f fVar = this.f36349F;
        if (fVar != null) {
            fVar.cancel(true);
        }
        f fVar2 = new f(this, 2, this.f36364g);
        this.f36349F = fVar2;
        fVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void E1() {
        if (this.f36362e == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof BlockedCallLogAndSmsListActivity) {
                this.f36362e = ((BlockedCallLogAndSmsListActivity) activity).getToolbar();
            }
        }
        this.f36357N.a(!U1());
    }

    public void F1() {
        C0846g.i("BlockedCallsListFragment", "deleteCallLogs");
        f fVar = this.f36350G;
        if (fVar != null) {
            fVar.cancel(true);
        }
        f fVar2 = new f(this, 3, this.f36364g);
        this.f36350G = fVar2;
        fVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void G1(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final void H1(androidx.appcompat.app.b bVar, int i10, long j10) {
        if (bVar != null) {
            long currentTimeMillis = System.currentTimeMillis() - j10;
            if (currentTimeMillis < 1000) {
                this.f36354K.postDelayed(new d(this, i10), Math.min(1000 - currentTimeMillis, 1000L));
                return;
            }
            if (i10 == 3) {
                C0861w.g(this.f36369l).l();
            }
            bVar.dismiss();
        }
    }

    public void I1() {
        this.f36357N.b();
    }

    public final String J1() {
        int size = this.f36364g.size();
        if (size == 0) {
            return getString(com.oplus.blacklistapp.u.f27570T2);
        }
        return getString(com.oplus.blacklistapp.u.f27574U2, Integer.valueOf(size));
    }

    public r6.b K1() {
        return this.f36360c;
    }

    public int L1() {
        return this.f36364g.size();
    }

    public final String M1(String str, String str2, String str3, int i10) {
        String str4;
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str3.trim())) {
            str4 = str + "//" + str3;
        } else {
            str4 = str + "//";
        }
        if (this.f36366i > 1 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str4.trim())) {
            return str4 + "//" + i10;
        }
        return str4;
    }

    public int N1() {
        return this.f36353J;
    }

    public COUIListView O1() {
        return this.f36358a;
    }

    public final void P1() {
        int size;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (l7.b.b(activity)) {
            if (C0846g.c()) {
                Log.d("BlockedCallsListFragment", "Support Gemini");
            }
            List<SubscriptionInfo> a10 = C0849j.a(activity);
            if (a10.isEmpty()) {
                size = 0;
            } else {
                size = a10.size();
            }
            this.f36366i = size;
            for (SubscriptionInfo subscriptionInfo : a10) {
                long subscriptionId = subscriptionInfo.getSubscriptionId();
                int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                if (simSlotIndex == F6.b.a()) {
                    this.f36370m = subscriptionId;
                } else if (simSlotIndex == F6.b.b()) {
                    this.f36371n = subscriptionId;
                }
                String l10 = Long.toString(subscriptionId);
                if (!this.f36372o.containsKey(l10)) {
                    CharSequence displayName = subscriptionInfo.getDisplayName();
                    if (displayName != null) {
                        this.f36372o.put(l10, displayName.toString());
                    } else {
                        this.f36372o.put(l10, "SIM");
                    }
                }
            }
        } else {
            this.f36366i = C0849j.m(this.f36369l) ? 1 : 0;
        }
        if (C0846g.c()) {
            Log.d("BlockedCallsListFragment", "getSimInfo mSimCount = " + this.f36366i + " ,mSim1Id = " + this.f36370m + " ,mSim2Id = " + this.f36371n);
        }
        r6.b bVar = this.f36360c;
        if (bVar != null) {
            bVar.F(this.f36372o, this.f36366i, this.f36370m, this.f36371n);
        }
    }

    public boolean R1() {
        if (this.f36377y > 0) {
            return true;
        }
        return false;
    }

    public boolean S1() {
        if (this.f36364g.size() > 0) {
            return true;
        }
        return false;
    }

    public final void T1(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    this.f36363f.clear();
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(1);
                        int i10 = cursor.getInt(12);
                        this.f36363f.add(M1(string, cursor.getString(9), cursor.getString(16), i10));
                    }
                }
            } catch (Exception unused) {
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.moveToPosition(-1);
                }
                throw th;
            }
        }
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.moveToPosition(-1);
    }

    public boolean U1() {
        r6.b bVar = this.f36360c;
        if (bVar != null && bVar.p()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void V1(DialogInterface dialogInterface, int i10) {
        if (getActivity() != null) {
            ((BlockedCallLogAndSmsListActivity) getActivity()).M1(0, "confirm_recover", "no", OplusPhoneUtils.DeviceState.INVALID_STATUS);
        }
    }

    public final /* synthetic */ void W1(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            C1();
        }
    }

    public final /* synthetic */ void X1(DialogInterface dialogInterface, int i10) {
        if (getActivity() != null) {
            ((BlockedCallLogAndSmsListActivity) getActivity()).M1(1, "confirm_add_to_allowlist", "no", OplusPhoneUtils.DeviceState.INVALID_STATUS);
        }
    }

    public final /* synthetic */ void Y1(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            D1();
        }
    }

    public void Z1() {
        v.i(this.f36369l);
        v.j(this.f36369l);
    }

    public void a2() {
        this.f36357N.c();
    }

    public final void b2() {
        IntentFilter intentFilter = new IntentFilter();
        C0844e.n(getActivity(), this.f36373p, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction(F6.a.i());
        intentFilter.addAction("android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE");
        try {
            this.f36373p = new e();
            requireActivity().registerReceiver(this.f36373p, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
        } catch (Exception e10) {
            Log.e("BlockedCallsListFragment", "registerSimReceiver error " + e10);
            this.f36373p = null;
        }
    }

    public void c2() {
        if (this.f36364g.size() == this.f36360c.getCount()) {
            r2();
        } else {
            d2();
        }
        this.f36357N.d();
        this.f36360c.A(this.f36364g);
        this.f36360c.t(false);
        this.f36360c.notifyDataSetChanged();
    }

    @Override // r6.t.b
    public void d(Cursor cursor) {
        if (cursor != null) {
            this.f36377y = cursor.getCount();
        }
        if (C0846g.c()) {
            Log.d("BlockedCallsListFragment", "onCallsFetched cursor.getCount() = " + this.f36377y);
        }
        this.f36360c.y(false);
        T1(cursor);
        this.f36360c.changeCursor(cursor);
        if (this.f36377y > 0) {
            this.f36358a.setVisibility(0);
            this.f36355L.setVisibility(8);
        } else {
            this.f36358a.setVisibility(8);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f36375r.setImageDrawable(activity.getDrawable(com.oplus.blacklistapp.o.f27319v));
            }
            this.f36376x.setText(com.oplus.blacklistapp.u.f27565S1);
            this.f36375r.setContentDescription(this.f36376x.getText());
            this.f36355L.setVisibility(0);
        }
        if (getActivity() != null) {
            getActivity().invalidateOptionsMenu();
        }
    }

    public void e2(BlockedCallLogAndSmsListActivity.f fVar) {
        this.f36367j = fVar;
    }

    public void f2(int i10) {
        this.f36353J = i10;
    }

    public void g2(TextView textView) {
        this.f36378z = textView;
    }

    @Override // r6.b.InterfaceC0348b
    public void h() {
        o2();
    }

    public void h2(COUIToolbar cOUIToolbar) {
        this.f36362e = cOUIToolbar;
    }

    public final void i2() {
        Log.d("BlockedCallsListFragment", "showAddToWhiteProgressDialog");
        G1(this.f36347D);
        this.f36347D = com.oplus.utils.r.b(this.f36369l, getString(com.oplus.blacklistapp.u.f27630h));
    }

    public void j2(Context context) {
        if (context == null) {
            return;
        }
        G1(this.f36345B);
        this.f36345B = com.oplus.utils.r.b(context, getString(com.oplus.blacklistapp.u.f27556Q0));
    }

    @Override // com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity.g
    public void k(boolean z10) {
        if (getActivity() instanceof BlockedCallLogAndSmsListActivity) {
            ((BlockedCallLogAndSmsListActivity) getActivity()).n2(z10);
        }
    }

    public void k2() {
        C0846g.i("BlockedCallsListFragment", "showRecoverBlockedCallLogTipsDialog");
        G1(this.f36351H);
        COUIAlertDialogBuilder positiveButton = new S8.b(this.f36369l, X8.n.f5032d).setTitle(com.oplus.blacklistapp.u.f27538L2).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: r6.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g.this.V1(dialogInterface, i10);
            }
        }).setPositiveButton((CharSequence) C0848i.m(this.f36369l, this.f36364g.size(), this.f36360c.getCount()), new DialogInterface.OnClickListener() { // from class: r6.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g.this.W1(dialogInterface, i10);
            }
        });
        androidx.appcompat.app.b create = positiveButton.create();
        this.f36351H = create;
        create.show();
        positiveButton.updateViewAfterShown();
    }

    public final void l2() {
        G1(this.f36346C);
        this.f36346C = com.oplus.utils.r.b(this.f36369l, getString(com.oplus.blacklistapp.u.f27546N2));
    }

    public void m2() {
        String string;
        G1(this.f36352I);
        if (this.f36364g.size() > 1) {
            string = this.f36369l.getString(com.oplus.blacklistapp.u.f27586X2);
        } else {
            string = this.f36369l.getString(com.oplus.blacklistapp.u.f27615e);
        }
        COUIAlertDialogBuilder positiveButton = new S8.b(this.f36369l, X8.n.f5032d).setTitle(com.oplus.blacklistapp.u.f27620f).setMessage((CharSequence) string).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: r6.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g.this.X1(dialogInterface, i10);
            }
        }).setPositiveButton(com.oplus.blacklistapp.u.f27610d, new DialogInterface.OnClickListener() { // from class: r6.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g.this.Y1(dialogInterface, i10);
            }
        });
        androidx.appcompat.app.b create = positiveButton.create();
        this.f36352I = create;
        create.show();
        positiveButton.updateViewAfterShown();
    }

    public void n2() {
        r6.b bVar = this.f36360c;
        if (bVar != null) {
            bVar.D(true);
        }
    }

    public void o2() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (L.h(activity, "android.permission.READ_CALL_LOG") && L.h(activity, "android.permission.READ_CONTACTS") && L.h(activity, "android.permission.READ_PHONE_STATE") && L.h(activity, "android.permission.CALL_PHONE")) {
            SharedPreferences b10 = androidx.preference.j.b(activity);
            if (!L.h(activity, "android.permission.READ_MEDIA_AUDIO")) {
                if (!b10.getBoolean("show_without_audio_permission_dialog", true)) {
                    Log.i("BlockedCallsListFragment", "no read_media_audio permission but operate cancel");
                } else {
                    Log.i("BlockedCallsListFragment", "no read_media_audio permission ");
                    return;
                }
            }
            if (this.f36359b == null) {
                this.f36359b = new t(activity.getContentResolver(), this);
            }
            this.f36360c.C(android.text.format.DateFormat.getTimeFormat(activity));
            this.f36360c.v(Q1());
            this.f36360c.y(true);
            this.f36359b.a(activity, 20, -1, this.f36366i);
            return;
        }
        Log.i("BlockedCallsListFragment", "no call log or contact permission ");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f36369l = getActivity();
        this.f36361d = C1087a.e(getActivity());
        this.f36368k = new v();
        v.i(this.f36369l);
        v.j(this.f36369l);
        b2();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.oplus.blacklistapp.r.f27458m, viewGroup, false);
        this.f36344A = inflate.findViewById(com.oplus.blacklistapp.p.f27386f);
        COUIListView cOUIListView = (COUIListView) inflate.findViewById(com.oplus.blacklistapp.p.f27362T);
        this.f36358a = cOUIListView;
        cOUIListView.setChoiceMode(2);
        this.f36358a.setDivider(null);
        this.f36358a.setClipToPadding(false);
        this.f36358a.setVerticalFadingEdgeEnabled(false);
        K.y0(this.f36358a, true);
        r6.b bVar = new r6.b(getActivity(), this.f36361d, this);
        this.f36360c = bVar;
        bVar.z(this);
        this.f36358a.setAdapter((ListAdapter) this.f36360c);
        if (CommonFeatureOption.f()) {
            this.f36358a.setVelocityScale(0.5f);
        }
        this.f36358a.setOnScrollListener(this.f36356M);
        this.f36358a.setOnItemClickListener(this.f36360c);
        this.f36358a.setOnItemLongClickListener(this.f36360c);
        this.f36355L = inflate.findViewById(com.oplus.blacklistapp.p.f27334F);
        this.f36375r = (ImageView) inflate.findViewById(com.oplus.blacklistapp.p.f27391h0);
        this.f36376x = (TextView) inflate.findViewById(com.oplus.blacklistapp.p.f27393i0);
        P1();
        E1();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        C0846g.i("BlockedCallsListFragment", "onDestroy");
        super.onDestroy();
        q2();
        G1(this.f36352I);
        G1(this.f36351H);
        G1(this.f36346C);
        G1(this.f36347D);
        G1(this.f36345B);
        f fVar = this.f36348E;
        if (fVar != null) {
            fVar.cancel(true);
            this.f36348E = null;
        }
        f fVar2 = this.f36349F;
        if (fVar2 != null) {
            fVar2.cancel(true);
            this.f36349F = null;
        }
        f fVar3 = this.f36350G;
        if (fVar3 != null) {
            fVar3.cancel(true);
            this.f36350G = null;
        }
        this.f36354K.removeCallbacksAndMessages(null);
    }

    @Override // r6.b.InterfaceC0348b
    public void onItemClick(View view, int i10) {
        CheckBox checkBox;
        r6.b bVar = this.f36360c;
        if (bVar == null || !bVar.p() || (checkBox = (CheckBox) view.findViewById(com.oplus.blacklistapp.p.f27370X)) == null) {
            return;
        }
        boolean z10 = !checkBox.isChecked();
        checkBox.setChecked(z10);
        Z.a(view, z10);
        Cursor cursor = this.f36360c.getCursor();
        cursor.moveToPosition(i10);
        String M12 = M1(cursor.getString(1), cursor.getString(9), cursor.getString(16), cursor.getInt(12));
        if (this.f36364g.contains(M12)) {
            this.f36364g.remove(M12);
        } else {
            this.f36364g.add(M12);
        }
        this.f36360c.A(this.f36364g);
        this.f36357N.d();
        BlockedCallLogAndSmsListActivity.f fVar = this.f36367j;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        C0846g.i("BlockedCallsListFragment", "onResume");
        super.onResume();
        r6.b bVar = this.f36360c;
        if (bVar != null) {
            bVar.o();
            this.f36360c.D(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        o2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        C0846g.i("BlockedCallsListFragment", "onStop");
        super.onStop();
        r6.b bVar = this.f36360c;
        if (bVar != null) {
            bVar.E();
        }
    }

    public void p2() {
        r6.b bVar = this.f36360c;
        if (bVar != null) {
            bVar.E();
        }
    }

    public final void q2() {
        if (this.f36373p != null) {
            try {
                requireActivity().unregisterReceiver(this.f36373p);
                this.f36373p = null;
            } catch (Exception e10) {
                Log.e("BlockedCallsListFragment", "unRegisterSimReceiver error: " + e10);
            }
        }
    }

    public final void r2() {
        this.f36364g.clear();
    }

    /* compiled from: BlockedCallsListFragment.java */
    /* loaded from: classes3.dex */
    public class b implements InterfaceC0859u {

        /* compiled from: BlockedCallsListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.getActivity() != null) {
                    g.this.getActivity().finish();
                }
            }
        }

        public b() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            g.this.f36362e.getMenu().clear();
            Menu menu = g.this.f36362e.getMenu();
            if (z10) {
                g.this.f36362e.setNavigationIcon(X8.g.f4850c);
                g.this.f36362e.setNavigationContentDescription(e.h.f30261a);
                g.this.f36362e.setNavigationOnClickListener(new a());
                g.this.f36362e.setIsTitleCenterStyle(false);
                e();
                g.this.requireActivity().invalidateOptionsMenu();
                return;
            }
            g.this.requireActivity().getMenuInflater().inflate(com.oplus.blacklistapp.s.f27475d, menu);
            g.this.f36362e.setIsTitleCenterStyle(true);
            g.this.f36362e.setNavigationIcon((Drawable) null);
            g gVar = g.this;
            gVar.f36365h = gVar.f36362e.getMenu().findItem(com.oplus.blacklistapp.p.f27327B0);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            a(false);
            d();
            g.this.f36360c.u(true);
            g.this.f36360c.notifyDataSetChanged();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            a(true);
            g.this.f36364g.clear();
            g.this.f36360c.u(false);
            g.this.f36360c.notifyDataSetChanged();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            g.this.f36362e.setTitle(g.this.J1());
            g.this.f36378z.setText(g.this.J1());
            g();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            g.this.f36362e.setTitle(com.oplus.blacklistapp.u.f27563S);
        }

        public void g() {
            int size = g.this.f36364g.size();
            int count = g.this.f36360c.getCount();
            if (g.this.f36365h != null) {
                if (size < count) {
                    g.this.f36365h.setTitle(com.oplus.blacklistapp.u.f27562R2);
                } else {
                    g.this.f36365h.setTitle(com.oplus.blacklistapp.u.f27644j3);
                }
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
        }
    }

    /* compiled from: BlockedCallsListFragment.java */
    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (g.this.f36360c != null) {
                g.this.f36360c.g(i10);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
