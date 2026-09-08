package r6;

import android.R;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.K;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption;
import com.oplus.utils.C;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0847h;
import com.oplus.utils.C0848i;
import com.oplus.utils.C0849j;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.Z;
import com.oplus.utils.a0;
import h9.C1087a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r6.j;
import v6.C1629c;

/* compiled from: BlockedSmsListFragment.java */
/* loaded from: classes3.dex */
public class r extends Fragment implements j.c, BlockedCallLogAndSmsListActivity.g {

    /* renamed from: A, reason: collision with root package name */
    public androidx.appcompat.app.b f36436A;

    /* renamed from: B, reason: collision with root package name */
    public h f36437B;

    /* renamed from: C, reason: collision with root package name */
    public h f36438C;

    /* renamed from: D, reason: collision with root package name */
    public h f36439D;

    /* renamed from: E, reason: collision with root package name */
    public androidx.appcompat.app.b f36440E;

    /* renamed from: F, reason: collision with root package name */
    public androidx.appcompat.app.b f36441F;

    /* renamed from: G, reason: collision with root package name */
    public int f36442G;

    /* renamed from: L, reason: collision with root package name */
    public View f36447L;

    /* renamed from: b, reason: collision with root package name */
    public COUIListView f36452b;

    /* renamed from: c, reason: collision with root package name */
    public j f36453c;

    /* renamed from: d, reason: collision with root package name */
    public C1087a f36454d;

    /* renamed from: e, reason: collision with root package name */
    public COUIToolbar f36455e;

    /* renamed from: f, reason: collision with root package name */
    public MenuItem f36456f;

    /* renamed from: j, reason: collision with root package name */
    public int f36460j;

    /* renamed from: l, reason: collision with root package name */
    public BlockedCallLogAndSmsListActivity.f f36462l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f36463m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f36464n;

    /* renamed from: o, reason: collision with root package name */
    public int f36465o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f36466p;

    /* renamed from: q, reason: collision with root package name */
    public View f36467q;

    /* renamed from: r, reason: collision with root package name */
    public Context f36468r;

    /* renamed from: x, reason: collision with root package name */
    public v f36469x;

    /* renamed from: y, reason: collision with root package name */
    public androidx.appcompat.app.b f36470y;

    /* renamed from: z, reason: collision with root package name */
    public androidx.appcompat.app.b f36471z;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<f> f36451a = new HashSet<>();

    /* renamed from: g, reason: collision with root package name */
    public final HashSet<Long> f36457g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    public final HashSet<Long> f36458h = new HashSet<>();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet<f> f36459i = new HashSet<>();

    /* renamed from: k, reason: collision with root package name */
    public final HashSet<Long> f36461k = new HashSet<>();

    /* renamed from: H, reason: collision with root package name */
    public final g f36443H = new g(Looper.getMainLooper(), this);

    /* renamed from: I, reason: collision with root package name */
    public long f36444I = 0;

    /* renamed from: J, reason: collision with root package name */
    public ExecutorService f36445J = Executors.newSingleThreadExecutor();

    /* renamed from: K, reason: collision with root package name */
    public CancellationSignal f36446K = null;

    /* renamed from: M, reason: collision with root package name */
    public final AbsListView.OnScrollListener f36448M = new a();

    /* renamed from: N, reason: collision with root package name */
    public final ContentObserver f36449N = new c(new Handler());

    /* renamed from: O, reason: collision with root package name */
    public final InterfaceC0859u f36450O = new d();

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            r.this.f36452b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            r.this.f36453c.m();
        }
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            FragmentActivity activity = r.this.getActivity();
            Log.i("BlockedSmsListFragment", "---mSmsContentObserver---");
            if (activity != null && r.this.isAdded()) {
                r.this.x0();
            }
        }
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f36477a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<r> f36478b;

        public e(r rVar, int i10) {
            this.f36478b = new WeakReference<>(rVar);
            this.f36477a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            r rVar = this.f36478b.get();
            if (rVar == null) {
                return;
            }
            int i10 = this.f36477a;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && rVar.f36436A != null) {
                        rVar.f36436A.dismiss();
                        rVar.f36436A = null;
                        return;
                    }
                    return;
                }
                if (rVar.f36471z != null) {
                    rVar.f36471z.dismiss();
                    rVar.f36471z = null;
                    return;
                }
                return;
            }
            if (rVar.f36470y != null) {
                rVar.f36470y.dismiss();
                rVar.f36470y = null;
            }
        }
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f36479a;

        /* renamed from: b, reason: collision with root package name */
        public final int f36480b;

        /* renamed from: c, reason: collision with root package name */
        public final String f36481c;

        /* renamed from: d, reason: collision with root package name */
        public final String f36482d;

        /* renamed from: e, reason: collision with root package name */
        public final String f36483e;

        /* renamed from: f, reason: collision with root package name */
        public final String f36484f;

        public f(long j10, int i10, String str, String str2, String str3, String str4) {
            this.f36479a = j10;
            this.f36480b = i10;
            this.f36481c = str;
            this.f36482d = str2;
            this.f36483e = str3;
            this.f36484f = str4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof f) && this.f36479a == ((f) obj).f36479a) {
                return true;
            }
            return false;
        }

        public String f() {
            return this.f36481c;
        }

        public int hashCode() {
            long j10 = this.f36479a;
            return ((int) (j10 ^ (j10 >>> 32))) + 17;
        }
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public class g extends a0 {

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<r> f36485b;

        @Override // com.oplus.utils.a0
        public void a(Message message, Object obj) {
            int i10;
            int i11 = message.what;
            if (i11 != 1) {
                if (i11 == 1701) {
                    Cursor cursor = (Cursor) message.obj;
                    r rVar = r.this;
                    if (cursor != null) {
                        i10 = cursor.getCount();
                    } else {
                        i10 = 0;
                    }
                    rVar.f36465o = i10;
                    r.this.d2(cursor);
                    if (r.this.f36465o == 0) {
                        r.this.f36453c.o(false);
                    }
                    r.this.f36453c.changeCursor(cursor);
                    if (C0846g.c()) {
                        Log.d("BlockedSmsListFragment", "onQueryComplete: mSmsCount = " + r.this.f36465o);
                    }
                    r rVar2 = r.this;
                    rVar2.R1(rVar2.f36470y, 1);
                    r rVar3 = r.this;
                    rVar3.R1(rVar3.f36471z, 2);
                    r rVar4 = r.this;
                    rVar4.R1(rVar4.f36436A, 3);
                    if (r.this.f36465o > 0) {
                        r.this.f36452b.setVisibility(0);
                        r.this.f36447L.setVisibility(8);
                    } else {
                        r.this.f36452b.setVisibility(8);
                        r.this.f36463m.setBackgroundResource(com.oplus.blacklistapp.o.f27318u);
                        r.this.f36464n.setText(com.oplus.blacklistapp.u.f27561R1);
                        r.this.f36463m.setContentDescription(r.this.f36464n.getText());
                        r.this.f36447L.setVisibility(0);
                    }
                    FragmentActivity activity = r.this.getActivity();
                    if (activity != null) {
                        activity.invalidateOptionsMenu();
                        return;
                    }
                    return;
                }
                return;
            }
            r rVar5 = this.f36485b.get();
            if (rVar5 != null && rVar5.isAdded()) {
                HashSet hashSet = (HashSet) message.obj;
                if (hashSet != null) {
                    r.this.f36461k.removeAll(hashSet);
                }
                r.this.E2();
            }
        }

        public g(Looper looper, r rVar) {
            super(looper, rVar);
            this.f36485b = new WeakReference<>(rVar);
        }
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public static class h extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<r> f36487a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<BlockedCallLogAndSmsListActivity> f36488b;

        /* renamed from: c, reason: collision with root package name */
        public final int f36489c;

        /* renamed from: d, reason: collision with root package name */
        public final HashSet<f> f36490d;

        /* renamed from: e, reason: collision with root package name */
        public final int f36491e;

        public h(r rVar, int i10, HashSet<f> hashSet) {
            this.f36487a = new WeakReference<>(rVar);
            this.f36488b = new WeakReference<>((BlockedCallLogAndSmsListActivity) rVar.getActivity());
            this.f36489c = i10;
            this.f36490d = hashSet;
            this.f36491e = rVar.f36451a.size();
        }

        public final void a(r rVar, Context context) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Iterator<f> it = this.f36490d.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f());
                }
                rVar.f36469x.d(context, arrayList, null);
            } catch (Exception e10) {
                Log.e("BlockedSmsListFragment", "Exception " + e10);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            f fVar;
            r rVar = this.f36487a.get();
            if (rVar == null) {
                return Boolean.FALSE;
            }
            BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity = this.f36488b.get();
            if (blockedCallLogAndSmsListActivity != null && !blockedCallLogAndSmsListActivity.isFinishing() && !blockedCallLogAndSmsListActivity.isDestroyed()) {
                int i10 = this.f36489c;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            C.f().c(blockedCallLogAndSmsListActivity, rVar.f36457g);
                        }
                    } else {
                        a(rVar, blockedCallLogAndSmsListActivity);
                    }
                } else if (rVar.Z1()) {
                    Iterator<f> it = this.f36490d.iterator();
                    if (it.hasNext()) {
                        fVar = it.next();
                    } else {
                        fVar = null;
                    }
                    if (fVar != null) {
                        C.m(blockedCallLogAndSmsListActivity, fVar.f36482d, fVar.f36484f, fVar.f36483e, fVar.f36479a);
                    }
                } else {
                    d(blockedCallLogAndSmsListActivity);
                }
                return null;
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity;
            int i10;
            String str;
            String str2;
            r rVar = this.f36487a.get();
            if (rVar != null && (blockedCallLogAndSmsListActivity = this.f36488b.get()) != null && !blockedCallLogAndSmsListActivity.isFinishing() && !blockedCallLogAndSmsListActivity.isDestroyed()) {
                int i11 = this.f36489c;
                if (i11 != 1) {
                    i10 = 2;
                    if (i11 != 2) {
                        if (i11 != 3) {
                            i10 = -1;
                            str = "";
                        } else {
                            str = "confirm_delete";
                        }
                    } else {
                        str = "confirm_add_to_allowlist";
                        i10 = 1;
                    }
                } else {
                    i10 = 0;
                    str = "confirm_recover";
                }
                if (rVar.f36453c != null) {
                    rVar.f36453c.s(true);
                }
                if (rVar.f36462l != null) {
                    rVar.f36462l.b();
                }
                int i12 = this.f36491e;
                if (i12 > 1) {
                    str2 = "multi_select_yes";
                } else {
                    str2 = "yes";
                }
                blockedCallLogAndSmsListActivity.M1(i10, str, str2, String.valueOf(i12));
            }
        }

        public final void d(Context context) {
            ArrayList arrayList = new ArrayList();
            try {
                Iterator<f> it = this.f36490d.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().f());
                }
            } catch (Exception e10) {
                Log.e("BlockedSmsListFragment", "Exception " + e10);
            }
            for (ComponentName componentName : C0849j.f(context, C0849j.f29159a)) {
                if (C1629c.f37420f.contains(componentName.getPackageName())) {
                    Intent e11 = C0849j.e(arrayList, false, false, false);
                    e11.setComponent(componentName);
                    context.sendBroadcast(e11, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            BlockedCallLogAndSmsListActivity blockedCallLogAndSmsListActivity;
            HashSet<f> hashSet;
            r rVar = this.f36487a.get();
            if (rVar != null && (blockedCallLogAndSmsListActivity = this.f36488b.get()) != null && !blockedCallLogAndSmsListActivity.isFinishing() && !blockedCallLogAndSmsListActivity.isDestroyed()) {
                int i10 = this.f36489c;
                if (i10 == 1) {
                    rVar.f36444I = System.currentTimeMillis();
                    rVar.B2();
                } else if (i10 == 2) {
                    rVar.f36444I = System.currentTimeMillis();
                    rVar.y2();
                } else if (i10 == 3 && (hashSet = this.f36490d) != null && hashSet.size() > 100) {
                    rVar.f36444I = System.currentTimeMillis();
                    rVar.z2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2() {
        Q1(this.f36470y);
        this.f36470y = com.oplus.utils.r.b(this.f36468r, getString(com.oplus.blacklistapp.u.f27546N2));
    }

    private void H2() {
        this.f36457g.clear();
        this.f36451a.clear();
        this.f36460j = 0;
    }

    private void Q1(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T1() {
        int size = this.f36457g.size();
        if (size == 0) {
            return getString(com.oplus.blacklistapp.u.f27570T2);
        }
        return getString(com.oplus.blacklistapp.u.f27574U2, Integer.valueOf(size));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(DialogInterface dialogInterface, int i10) {
        if (getActivity() != null) {
            ((BlockedCallLogAndSmsListActivity) getActivity()).M1(1, "confirm_add_to_allowlist", "no", OplusPhoneUtils.DeviceState.INVALID_STATUS);
        }
    }

    private void t2() {
        this.f36457g.clear();
        this.f36457g.addAll(this.f36458h);
        this.f36451a.clear();
        this.f36451a.addAll(this.f36459i);
        this.f36460j = this.f36461k.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        Q1(this.f36471z);
        this.f36471z = com.oplus.utils.r.b(this.f36468r, getString(com.oplus.blacklistapp.u.f27630h));
    }

    public void A2() {
        C0846g.i("BlockedSmsListFragment", "showRecoverBlockedMessagesTipsDialog");
        Q1(this.f36440E);
        COUIAlertDialogBuilder positiveButton = new S8.b(this.f36468r, X8.n.f5032d).setTitle(com.oplus.blacklistapp.u.f27542M2).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: r6.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.this.h2(dialogInterface, i10);
            }
        }).setPositiveButton((CharSequence) C0848i.l(this.f36468r, this.f36451a.size(), this.f36453c.getCount()), new DialogInterface.OnClickListener() { // from class: r6.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.this.i2(dialogInterface, i10);
            }
        });
        androidx.appcompat.app.b create = positiveButton.create();
        this.f36440E = create;
        create.show();
        positiveButton.updateViewAfterShown();
    }

    public void C2() {
        String string;
        C0846g.i("BlockedSmsListFragment", "showWhitelistTipsDialog");
        Q1(this.f36441F);
        if (this.f36451a.size() > 1) {
            string = this.f36468r.getString(com.oplus.blacklistapp.u.f27586X2);
        } else {
            string = this.f36468r.getString(com.oplus.blacklistapp.u.f27615e);
        }
        COUIAlertDialogBuilder positiveButton = new S8.b(this.f36468r, X8.n.f5032d).setTitle(com.oplus.blacklistapp.u.f27620f).setMessage((CharSequence) string).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: r6.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.this.j2(dialogInterface, i10);
            }
        }).setPositiveButton(com.oplus.blacklistapp.u.f27610d, new DialogInterface.OnClickListener() { // from class: r6.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.this.k2(dialogInterface, i10);
            }
        });
        androidx.appcompat.app.b create = positiveButton.create();
        this.f36441F = create;
        create.show();
        positiveButton.updateViewAfterShown();
    }

    public void D2() {
        j jVar = this.f36453c;
        if (jVar != null) {
            jVar.v(true);
        }
    }

    public void E2() {
        C0846g.i("BlockedSmsListFragment", "startQuery");
        if (getActivity() == null) {
            return;
        }
        CancellationSignal cancellationSignal = this.f36446K;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        this.f36446K = new CancellationSignal();
        this.f36445J.execute(new Runnable() { // from class: r6.k
            @Override // java.lang.Runnable
            public final void run() {
                r.this.l2();
            }
        });
    }

    public void F2() {
        j jVar = this.f36453c;
        if (jVar != null) {
            jVar.w();
        }
    }

    public final void G2() {
        try {
            requireActivity().getContentResolver().unregisterContentObserver(this.f36449N);
        } catch (Exception e10) {
            Log.e("BlockedSmsListFragment", "" + e10);
        }
    }

    public void L1(int i10) {
        int dimensionPixelSize;
        if (l7.b.f34743k) {
            dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27294s);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C6.f.f392f);
        }
        int i11 = dimensionPixelSize + i10;
        COUIListView cOUIListView = this.f36452b;
        cOUIListView.setPaddingRelative(cOUIListView.getPaddingStart(), this.f36452b.getPaddingTop() + i11, this.f36452b.getPaddingEnd(), this.f36452b.getPaddingBottom());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36467q.getLayoutParams();
        layoutParams.topMargin = i10;
        this.f36467q.setLayoutParams(layoutParams);
        this.f36442G = i11 + C0849j.l(this.f36468r);
    }

    public void M1() {
        C0846g.i("BlockedSmsListFragment", "blockedSmsAddToWhiteList");
        h hVar = this.f36439D;
        if (hVar != null) {
            hVar.cancel(true);
        }
        h hVar2 = new h(this, 2, this.f36451a);
        this.f36439D = hVar2;
        hVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void N1() {
        C0846g.i("BlockedSmsListFragment", "blockedSmsRestoreToSmsList");
        h hVar = this.f36438C;
        if (hVar != null) {
            hVar.cancel(true);
        }
        h hVar2 = new h(this, 1, this.f36451a);
        this.f36438C = hVar2;
        hVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void O1() {
        if (this.f36455e == null) {
            FragmentActivity activity = getActivity();
            if (activity instanceof BlockedCallLogAndSmsListActivity) {
                this.f36455e = ((BlockedCallLogAndSmsListActivity) activity).getToolbar();
            }
        }
        this.f36450O.a(!e2());
    }

    public void P1() {
        C0846g.i("BlockedSmsListFragment", "deleteSelectBlockedSms");
        h hVar = this.f36437B;
        if (hVar != null) {
            hVar.cancel(true);
        }
        h hVar2 = new h(this, 3, this.f36451a);
        this.f36437B = hVar2;
        hVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void R1(androidx.appcompat.app.b bVar, int i10) {
        if (bVar != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f36444I;
            if (currentTimeMillis < 1000) {
                this.f36443H.postDelayed(new e(this, i10), Math.min(1000 - currentTimeMillis, 1000L));
            } else {
                bVar.dismiss();
            }
        }
    }

    public void S1() {
        this.f36451a.clear();
        this.f36450O.b();
    }

    public j U1() {
        return this.f36453c;
    }

    public int V1() {
        HashSet<f> hashSet = this.f36451a;
        if (hashSet != null) {
            return hashSet.size();
        }
        return 0;
    }

    public int W1() {
        return this.f36442G;
    }

    public COUIListView X1() {
        return this.f36452b;
    }

    public boolean Y1() {
        HashSet<f> hashSet = this.f36451a;
        if (hashSet != null && hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean Z1() {
        if (Y1()) {
            Iterator<f> it = this.f36451a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null && !TextUtils.isEmpty(next.f36482d)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean a2() {
        if (this.f36465o > 0) {
            return true;
        }
        return false;
    }

    public boolean b2() {
        if (this.f36460j > 0) {
            return true;
        }
        return false;
    }

    public boolean c2() {
        if (this.f36461k.size() > 0) {
            return true;
        }
        return false;
    }

    public final void d2(Cursor cursor) {
        int i10 = -1;
        try {
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        this.f36458h.clear();
                        this.f36459i.clear();
                        cursor.moveToPosition(-1);
                        this.f36461k.clear();
                        boolean z10 = false;
                        int i11 = -1;
                        int i12 = -1;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = -1;
                        int i16 = -1;
                        while (cursor.moveToNext()) {
                            if (!z10) {
                                i11 = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
                                i12 = cursor.getColumnIndex(C0847h.c.f29151a);
                                i13 = cursor.getColumnIndex(C0847h.c.f29152b);
                                i14 = cursor.getColumnIndex("ted_service_id");
                                i15 = cursor.getColumnIndex("service_name");
                                i16 = cursor.getColumnIndex("service_number");
                                z10 = true;
                            }
                            long j10 = cursor.getLong(i11);
                            int i17 = cursor.getInt(i12);
                            f fVar = new f(j10, i17, cursor.getString(i13), cursor.getString(i14), cursor.getString(i15), cursor.getString(i16));
                            if (i17 > 0) {
                                this.f36461k.add(Long.valueOf(j10));
                            }
                            this.f36458h.add(Long.valueOf(j10));
                            this.f36459i.add(fVar);
                            i10 = -1;
                        }
                    }
                } catch (Exception e10) {
                    Log.e("BlockedSmsListFragment", "initAllThreadIds error " + e10);
                    if (cursor != null && !cursor.isClosed()) {
                        i10 = -1;
                    } else {
                        return;
                    }
                }
            }
            if (cursor == null || cursor.isClosed()) {
                return;
            }
            cursor.moveToPosition(i10);
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.moveToPosition(-1);
            }
            throw th;
        }
    }

    public boolean e2() {
        j jVar = this.f36453c;
        if (jVar != null && jVar.k()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void f2(Context context, HashSet hashSet, HashSet hashSet2) {
        HashSet<Long> n22 = n2(context, hashSet, hashSet2);
        Message obtainMessage = this.f36443H.obtainMessage();
        obtainMessage.obj = n22;
        obtainMessage.what = 1;
        obtainMessage.sendToTarget();
    }

    public final /* synthetic */ void g2() {
        if (this.f36453c != null) {
            this.f36453c.t(C.f().e(getActivity()));
        }
    }

    public final /* synthetic */ void h2(DialogInterface dialogInterface, int i10) {
        if (getActivity() != null) {
            ((BlockedCallLogAndSmsListActivity) getActivity()).M1(0, "confirm_recover", "no", OplusPhoneUtils.DeviceState.INVALID_STATUS);
        }
    }

    public final /* synthetic */ void i2(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            N1();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity.g
    public void k(boolean z10) {
        if (getActivity() instanceof BlockedCallLogAndSmsListActivity) {
            ((BlockedCallLogAndSmsListActivity) getActivity()).n2(z10);
        }
    }

    public final /* synthetic */ void k2(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            M1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void l2() {
        /*
            r10 = this;
            java.lang.String r0 = "content://message-external/blocked_conversations"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 1701(0x6a5, float:2.384E-42)
            r8 = 0
            android.content.Context r1 = r10.f36468r     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            android.content.ContentProviderClient r9 = r1.acquireUnstableContentProviderClient(r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4c
            if (r9 == 0) goto L28
            if (r2 == 0) goto L28
            java.lang.String[] r3 = com.oplus.utils.C0847h.c.f29153c     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            android.os.CancellationSignal r7 = r10.f36446K     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r9
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            goto L28
        L24:
            r1 = move-exception
            goto L7e
        L26:
            r1 = move-exception
            goto L4e
        L28:
            android.os.CancellationSignal r1 = r10.f36446K
            boolean r1 = r1.isCanceled()
            if (r1 == 0) goto L36
            if (r8 == 0) goto L43
            r8.close()
            goto L43
        L36:
            r6.r$g r10 = r10.f36443H
            android.os.Message r10 = r10.obtainMessage()
            r10.obj = r8
            r10.what = r0
            r10.sendToTarget()
        L43:
            if (r9 == 0) goto L7d
        L45:
            r9.close()
            goto L7d
        L49:
            r1 = move-exception
            r9 = r8
            goto L7e
        L4c:
            r1 = move-exception
            r9 = r8
        L4e:
            java.lang.String r2 = "BlockedSmsListFragment"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r3.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = "e = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L24
            r3.append(r1)     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L24
            android.util.Log.e(r2, r1)     // Catch: java.lang.Throwable -> L24
            android.os.CancellationSignal r1 = r10.f36446K
            boolean r1 = r1.isCanceled()
            if (r1 == 0) goto L6d
            goto L7a
        L6d:
            r6.r$g r10 = r10.f36443H
            android.os.Message r10 = r10.obtainMessage()
            r10.obj = r8
            r10.what = r0
            r10.sendToTarget()
        L7a:
            if (r9 == 0) goto L7d
            goto L45
        L7d:
            return
        L7e:
            android.os.CancellationSignal r2 = r10.f36446K
            boolean r2 = r2.isCanceled()
            if (r2 == 0) goto L87
            goto L94
        L87:
            r6.r$g r10 = r10.f36443H
            android.os.Message r10 = r10.obtainMessage()
            r10.obj = r8
            r10.what = r0
            r10.sendToTarget()
        L94:
            if (r9 == 0) goto L99
            r9.close()
        L99:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.r.l2():void");
    }

    public void m2() {
        final HashSet hashSet = new HashSet(this.f36451a);
        final HashSet hashSet2 = new HashSet(this.f36461k);
        final Context applicationContext = requireActivity().getApplicationContext();
        this.f36445J.execute(new Runnable() { // from class: r6.q
            @Override // java.lang.Runnable
            public final void run() {
                r.this.f2(applicationContext, hashSet, hashSet2);
            }
        });
    }

    public final HashSet<Long> n2(Context context, HashSet<f> hashSet, HashSet<Long> hashSet2) {
        if (hashSet != null && hashSet.size() > 0) {
            HashSet<Long> hashSet3 = new HashSet<>();
            Iterator<f> it = hashSet.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.f36480b > 0) {
                    hashSet3.add(Long.valueOf(next.f36479a));
                }
            }
            if (C0846g.c()) {
                Log.d("BlockedSmsListFragment", "mark threadIds: " + hashSet3);
            }
            if (hashSet3.size() > 0 && C.f().k(context, hashSet3)) {
                return hashSet3;
            }
            return null;
        }
        if (C.f().k(context, hashSet2)) {
            return hashSet2;
        }
        return null;
    }

    public final void o2(String str, String str2, long j10) {
        C0849j.A(getActivity(), C.b(str, str2, getString(com.oplus.blacklistapp.u.f27563S), j10));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f36452b.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f36468r = getActivity();
        this.f36454d = C1087a.e(getActivity());
        this.f36469x = new v();
        r2();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.oplus.blacklistapp.r.f27458m, viewGroup, false);
        this.f36467q = inflate.findViewById(com.oplus.blacklistapp.p.f27386f);
        COUIListView cOUIListView = (COUIListView) inflate.findViewById(com.oplus.blacklistapp.p.f27362T);
        this.f36452b = cOUIListView;
        cOUIListView.setChoiceMode(2);
        this.f36452b.setDivider(null);
        this.f36452b.setClipToPadding(false);
        this.f36452b.setVerticalFadingEdgeEnabled(false);
        K.y0(this.f36452b, true);
        j jVar = new j(getActivity(), this.f36454d, this);
        this.f36453c = jVar;
        this.f36452b.setAdapter((ListAdapter) jVar);
        this.f36452b.setOnItemClickListener(this.f36453c);
        this.f36452b.setOnItemLongClickListener(this.f36453c);
        if (CommonFeatureOption.f()) {
            this.f36452b.setVelocityScale(0.5f);
        }
        this.f36452b.setOnScrollListener(this.f36448M);
        this.f36453c.u(this);
        this.f36447L = inflate.findViewById(com.oplus.blacklistapp.p.f27334F);
        this.f36463m = (ImageView) inflate.findViewById(com.oplus.blacklistapp.p.f27391h0);
        this.f36464n = (TextView) inflate.findViewById(com.oplus.blacklistapp.p.f27393i0);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C0846g.i("BlockedSmsListFragment", "onDestroy");
        G2();
        Q1(this.f36440E);
        Q1(this.f36441F);
        Q1(this.f36470y);
        Q1(this.f36471z);
        h hVar = this.f36439D;
        if (hVar != null) {
            hVar.cancel(true);
            this.f36439D = null;
        }
        h hVar2 = this.f36438C;
        if (hVar2 != null) {
            hVar2.cancel(true);
            this.f36438C = null;
        }
        h hVar3 = this.f36437B;
        if (hVar3 != null) {
            hVar3.cancel(true);
            this.f36437B = null;
        }
        this.f36443H.removeCallbacksAndMessages(null);
        ExecutorService executorService = this.f36445J;
        if (executorService != null) {
            executorService.shutdown();
            this.f36445J = null;
        }
    }

    @Override // r6.j.c
    public void onItemClick(View view, int i10) {
        Cursor cursor;
        int i11;
        j jVar = this.f36453c;
        if (jVar != null && jVar.k()) {
            CheckBox checkBox = (CheckBox) view.findViewById(com.oplus.blacklistapp.p.f27370X);
            if (checkBox == null) {
                return;
            }
            boolean z10 = !checkBox.isChecked();
            checkBox.setChecked(z10);
            Z.a(view, z10);
            Cursor cursor2 = this.f36453c.getCursor();
            if (cursor2 != null && i10 >= 0 && i10 < cursor2.getCount()) {
                cursor2.moveToPosition(i10);
                long j10 = cursor2.getLong(cursor2.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                int i12 = cursor2.getInt(cursor2.getColumnIndex(C0847h.c.f29151a));
                f fVar = new f(j10, i12, cursor2.getString(cursor2.getColumnIndex(C0847h.c.f29152b)), cursor2.getString(cursor2.getColumnIndex("ted_service_id")), cursor2.getString(cursor2.getColumnIndex("service_name")), cursor2.getString(cursor2.getColumnIndex("service_number")));
                if (this.f36451a.contains(fVar)) {
                    this.f36451a.remove(fVar);
                } else {
                    this.f36451a.add(fVar);
                }
                if (this.f36457g.contains(Long.valueOf(j10))) {
                    if (i12 > 0 && (i11 = this.f36460j) > 0) {
                        this.f36460j = i11 - 1;
                    }
                    this.f36457g.remove(Long.valueOf(j10));
                } else {
                    if (i12 > 0) {
                        this.f36460j++;
                    }
                    this.f36457g.add(Long.valueOf(j10));
                }
                this.f36453c.p(this.f36457g);
                this.f36450O.d();
                BlockedCallLogAndSmsListActivity.f fVar2 = this.f36462l;
                if (fVar2 != null) {
                    fVar2.a();
                    return;
                }
                return;
            }
            return;
        }
        j jVar2 = this.f36453c;
        if (jVar2 != null && (cursor = jVar2.getCursor()) != null && i10 >= 0 && i10 < cursor.getCount()) {
            cursor.moveToPosition(i10);
            long j11 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            long j12 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            String string = cursor.getString(cursor.getColumnIndex("service_number"));
            String string2 = cursor.getString(cursor.getColumnIndex("ted_service_id"));
            if (C0846g.c()) {
                Log.d("BlockedSmsListFragment", "onItemClick serviceId = " + string2 + " ,threadId = " + j12);
            }
            if (this.f36461k.contains(Long.valueOf(j12))) {
                this.f36461k.remove(Long.valueOf(j12));
            }
            StatisticsUtils.d(requireActivity().getApplicationContext(), "message_detail");
            if (!TextUtils.isEmpty(string2)) {
                if (l7.b.k() && C.h(string2)) {
                    p2(j11);
                    return;
                } else {
                    o2(string2, string, j12);
                    return;
                }
            }
            p2(j11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C0846g.i("BlockedSmsListFragment", "onResume");
        j jVar = this.f36453c;
        if (jVar != null) {
            jVar.j();
            this.f36453c.v(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f36445J.execute(new Runnable() { // from class: r6.l
            @Override // java.lang.Runnable
            public final void run() {
                r.this.g2();
            }
        });
        E2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        C0846g.i("BlockedSmsListFragment", "onStop");
        j jVar = this.f36453c;
        if (jVar != null) {
            jVar.w();
        }
    }

    public final void p2(long j10) {
        C0849j.A(getActivity(), C.a(j10));
    }

    public void q2() {
        this.f36460j = 0;
        this.f36451a.clear();
        this.f36450O.c();
    }

    public final void r2() {
        try {
            requireActivity().getContentResolver().registerContentObserver(Uri.parse("content://message-external/blocked_conversations"), false, this.f36449N);
        } catch (Exception e10) {
            Log.e("BlockedSmsListFragment", "" + e10);
        }
    }

    public void s2() {
        if (this.f36457g.size() == this.f36453c.getCount()) {
            H2();
        } else {
            t2();
        }
        this.f36450O.d();
        this.f36453c.p(this.f36457g);
        this.f36453c.o(false);
        this.f36453c.notifyDataSetChanged();
    }

    public void u2(BlockedCallLogAndSmsListActivity.f fVar) {
        this.f36462l = fVar;
    }

    public void v2(int i10) {
        this.f36442G = i10;
    }

    public void w2(TextView textView) {
        this.f36466p = textView;
    }

    @Override // r6.j.c
    public void x0() {
        if (C0846g.c()) {
            Log.d("BlockedSmsListFragment", "--fetchSms--");
        }
        E2();
    }

    public void x2(COUIToolbar cOUIToolbar) {
        this.f36455e = cOUIToolbar;
    }

    public final void z2() {
        Q1(this.f36436A);
        this.f36436A = com.oplus.utils.r.b(this.f36468r, getString(com.oplus.blacklistapp.u.f27556Q0));
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public class d implements InterfaceC0859u {

        /* compiled from: BlockedSmsListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (r.this.getActivity() != null) {
                    r.this.getActivity().finish();
                }
            }
        }

        public d() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            r.this.f36455e.getMenu().clear();
            Menu menu = r.this.f36455e.getMenu();
            if (z10) {
                r.this.f36455e.setNavigationIcon(X8.g.f4850c);
                r.this.f36455e.setNavigationContentDescription(e.h.f30261a);
                r.this.f36455e.setNavigationOnClickListener(new a());
                r.this.f36455e.setIsTitleCenterStyle(false);
                e();
                r.this.requireActivity().invalidateOptionsMenu();
                return;
            }
            r.this.getActivity().getMenuInflater().inflate(com.oplus.blacklistapp.s.f27475d, menu);
            r.this.f36455e.setIsTitleCenterStyle(true);
            r.this.f36455e.setNavigationIcon((Drawable) null);
            r rVar = r.this;
            rVar.f36456f = rVar.f36455e.getMenu().findItem(com.oplus.blacklistapp.p.f27327B0);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            a(false);
            d();
            r.this.f36453c.q(true);
            r.this.f36453c.notifyDataSetChanged();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            a(true);
            r.this.f36457g.clear();
            r.this.f36453c.q(false);
            r.this.f36453c.notifyDataSetChanged();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            r.this.f36466p.setText(r.this.T1());
            r.this.f36455e.setTitle(r.this.T1());
            g();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            r.this.f36455e.setTitle(com.oplus.blacklistapp.u.f27563S);
        }

        public void g() {
            int size = r.this.f36457g.size();
            int count = r.this.f36453c.getCount();
            if (r.this.f36456f != null) {
                if (size < count) {
                    r.this.f36456f.setTitle(com.oplus.blacklistapp.u.f27562R2);
                } else {
                    r.this.f36456f.setTitle(com.oplus.blacklistapp.u.f27644j3);
                }
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
        }
    }

    /* compiled from: BlockedSmsListFragment.java */
    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (r.this.f36453c != null) {
                r.this.f36453c.f(i10);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
