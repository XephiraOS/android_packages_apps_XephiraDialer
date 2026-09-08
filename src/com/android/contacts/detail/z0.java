package com.android.contacts.detail;

import Z0.b;
import a4.C0421a;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.C0594d;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsApplication;
import com.android.contacts.M0;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.detail.E0;
import com.android.contacts.detail.i0;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import com.android.contacts.framework.omoji.viewmodel.OmojiRepository;
import com.android.contacts.model.Account;
import com.android.contacts.model.AccountType;
import com.android.contacts.util.o;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.adapter.COUIListDialogAdapter;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.fragment.BaseActivityFragment;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.model.NewCallRepository;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.widget.MultiChoiceListView;
import com.google.common.collect.HashMultimap;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.omoji.ui.OmojiPanelFragment;
import h1.C1074c;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import n1.AbstractC1362a;
import r0.C1501d;
import w0.C1643c;

/* compiled from: DetailFragment.java */
/* loaded from: classes.dex */
public abstract class z0 extends Fragment implements CallDetailActivityFragment.e, AdapterView.OnItemClickListener, COUIStatusBarResponseUtil.StatusBarClickListener, E0.f {

    /* renamed from: A0, reason: collision with root package name */
    public RecordPlayerPresenter f14694A0;

    /* renamed from: C0, reason: collision with root package name */
    public Dialog f14698C0;

    /* renamed from: M0, reason: collision with root package name */
    public AutoCallSummaryTipManager f14718M0;

    /* renamed from: O, reason: collision with root package name */
    public SimContactInfo f14721O;

    /* renamed from: R, reason: collision with root package name */
    public View f14727R;

    /* renamed from: S, reason: collision with root package name */
    public Uri f14729S;

    /* renamed from: T, reason: collision with root package name */
    public h f14731T;

    /* renamed from: a, reason: collision with root package name */
    public Context f14738a;

    /* renamed from: a0, reason: collision with root package name */
    public String f14739a0;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f14740b;

    /* renamed from: b0, reason: collision with root package name */
    public View f14741b0;

    /* renamed from: c0, reason: collision with root package name */
    public Parcelable f14743c0;

    /* renamed from: d, reason: collision with root package name */
    public ContactLoader.Result f14744d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f14745d0;

    /* renamed from: e, reason: collision with root package name */
    public MultiChoiceListView f14746e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f14747e0;

    /* renamed from: f, reason: collision with root package name */
    public E0 f14748f;

    /* renamed from: k0, reason: collision with root package name */
    public COUIStatusBarResponseUtil f14759k0;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<Long> f14762m;

    /* renamed from: w0, reason: collision with root package name */
    public ThreadPoolExecutor f14778w0;

    /* renamed from: y0, reason: collision with root package name */
    public ImageView f14782y0;

    /* renamed from: z0, reason: collision with root package name */
    public Z0.b f14784z0;

    /* renamed from: c, reason: collision with root package name */
    public final Map<AccountType, List<i0.f>> f14742c = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public Uri f14750g = null;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<i0.f> f14752h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<i0.f> f14754i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<i0.f> f14756j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<i0.f> f14758k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public final com.google.common.collect.p<Account, Long> f14760l = HashMultimap.w();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList<i0.f> f14764n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public CopyOnWriteArrayList<i0.f> f14766o = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList<i0.f> f14768p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<i0.f> f14770q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<i0.f> f14772r = new ArrayList<>();

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList<i0.f> f14779x = new ArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList<i0.f> f14781y = new ArrayList<>();

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList<i0.f> f14783z = new ArrayList<>();

    /* renamed from: A, reason: collision with root package name */
    public final ArrayList<i0.f> f14693A = new ArrayList<>();

    /* renamed from: B, reason: collision with root package name */
    public final ArrayList<i0.f> f14695B = new ArrayList<>();

    /* renamed from: C, reason: collision with root package name */
    public final ArrayList<i0.f> f14697C = new ArrayList<>();

    /* renamed from: D, reason: collision with root package name */
    public final ArrayList<i0.f> f14699D = new ArrayList<>();

    /* renamed from: E, reason: collision with root package name */
    public final ArrayList<i0.f> f14701E = new ArrayList<>();

    /* renamed from: F, reason: collision with root package name */
    public final ArrayList<i0.f> f14703F = new ArrayList<>();

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList<i0.f> f14705G = new ArrayList<>();

    /* renamed from: H, reason: collision with root package name */
    public final ArrayList<i0.f> f14707H = new ArrayList<>();

    /* renamed from: I, reason: collision with root package name */
    public final ArrayList<i0.f> f14709I = new ArrayList<>();

    /* renamed from: J, reason: collision with root package name */
    public final ArrayList<i0.m> f14711J = new ArrayList<>();

    /* renamed from: K, reason: collision with root package name */
    public ArrayList<i0.d> f14713K = new ArrayList<>();

    /* renamed from: L, reason: collision with root package name */
    public final ArrayList<i0.f> f14715L = new ArrayList<>();

    /* renamed from: M, reason: collision with root package name */
    public final ArrayList<i0.f> f14717M = new ArrayList<>();

    /* renamed from: N, reason: collision with root package name */
    public boolean f14719N = false;

    /* renamed from: P, reason: collision with root package name */
    public int f14723P = 0;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f14725Q = false;

    /* renamed from: U, reason: collision with root package name */
    public int f14732U = 0;

    /* renamed from: V, reason: collision with root package name */
    public String f14733V = "CN";

    /* renamed from: W, reason: collision with root package name */
    public String f14734W = R0.a.f3166b;

    /* renamed from: X, reason: collision with root package name */
    public String f14735X = R0.a.f3165a;

    /* renamed from: Y, reason: collision with root package name */
    public final ArrayList<String> f14736Y = new ArrayList<>();

    /* renamed from: Z, reason: collision with root package name */
    public final ArrayList<String> f14737Z = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    public int f14749f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f14751g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f14753h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f14755i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public final ArrayList<String> f14757j0 = new ArrayList<>();

    /* renamed from: l0, reason: collision with root package name */
    public com.customize.contacts.widget.i f14761l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    public GestureDetector f14763m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    public g f14765n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    public View.OnTouchListener f14767o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f14769p0 = false;

    /* renamed from: q0, reason: collision with root package name */
    public int f14771q0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f14773r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f14774s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    public Uri f14775t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    public Uri f14776u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f14777v0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f14780x0 = false;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f14696B0 = false;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f14700D0 = false;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f14702E0 = false;

    /* renamed from: F0, reason: collision with root package name */
    public com.customize.contacts.util.i0 f14704F0 = null;

    /* renamed from: G0, reason: collision with root package name */
    public com.android.contacts.util.o f14706G0 = null;

    /* renamed from: H0, reason: collision with root package name */
    public Bundle f14708H0 = null;

    /* renamed from: I0, reason: collision with root package name */
    public androidx.appcompat.app.b f14710I0 = null;

    /* renamed from: J0, reason: collision with root package name */
    public boolean f14712J0 = true;

    /* renamed from: K0, reason: collision with root package name */
    public boolean f14714K0 = false;

    /* renamed from: L0, reason: collision with root package name */
    public boolean f14716L0 = false;

    /* renamed from: N0, reason: collision with root package name */
    public boolean f14720N0 = true;

    /* renamed from: O0, reason: collision with root package name */
    public boolean f14722O0 = true;

    /* renamed from: P0, reason: collision with root package name */
    public boolean f14724P0 = true;

    /* renamed from: Q0, reason: collision with root package name */
    public NewCallRepository f14726Q0 = null;

    /* renamed from: R0, reason: collision with root package name */
    public com.android.contacts.framework.baseui.util.t f14728R0 = new a();

    /* renamed from: S0, reason: collision with root package name */
    public final androidx.lifecycle.w<Boolean> f14730S0 = new androidx.lifecycle.w() { // from class: com.android.contacts.detail.v0
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            z0.this.z2((Boolean) obj);
        }
    };

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.android.contacts.framework.baseui.util.t {
        public a() {
        }

        @Override // com.android.contacts.framework.baseui.util.t
        public void a(int i10, Object obj, Object obj2) {
            if (z0.this.f14748f != null) {
                H7.b.e("DetailFragment", "onCall: code: " + i10);
                boolean z10 = true;
                if (i10 == 1) {
                    boolean x22 = z0.this.x2();
                    if (z0.this.f14721O == null) {
                        z10 = false;
                    }
                    if (H7.a.b()) {
                        H7.b.b("DetailFragment", "isUserProfile: " + x22 + ", simContact: " + z10);
                    }
                    if (!x22 && !z10 && !z0.this.s2() && !z0.this.r2()) {
                        z0.this.f14711J.add(0, new i0.e());
                        z0.this.b2();
                        return;
                    }
                    return;
                }
                if (i10 == 0 && z0.this.P2()) {
                    z0.this.b2();
                }
            }
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i0.m mVar;
            if (z0.this.f14731T == null || (mVar = (i0.m) view.getTag()) == null) {
                return;
            }
            if (z0.this.f14761l0 != null && z0.this.f14761l0.i()) {
                return;
            }
            mVar.c(view, z0.this.f14731T);
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent;
            if (z0.this.f14731T == null || view == null) {
                return;
            }
            i0.m mVar = (i0.m) view.getTag();
            if (!(mVar instanceof i0.f) || (intent = ((i0.f) mVar).f14630t) == null) {
                return;
            }
            z0.this.f14731T.d(intent);
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent;
            if (z0.this.f14731T == null || view == null) {
                return;
            }
            i0.m mVar = (i0.m) view.getTag();
            if (!(mVar instanceof i0.f) || (intent = ((i0.f) mVar).f14631u) == null) {
                return;
            }
            z0.this.f14731T.d(intent);
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.call /* 2131427563 */:
                case R.id.layout_call /* 2131428245 */:
                    if (CommonFeatureOption.j()) {
                        com.customize.contacts.util.h0.s(z0.this.f14738a, "call", com.customize.contacts.util.h0.b0(z0.this.f14738a));
                        z0.this.Z1();
                        return;
                    }
                    return;
                case R.id.detail_photo /* 2131427870 */:
                    z0 z0Var = z0.this;
                    if (z0Var.f14744d != null && !AbstractC1362a.h(z0Var.f14738a).c(z0.this.f14744d.p(), null).b()) {
                        return;
                    }
                    com.customize.contacts.util.h0.o(z0.this.f14738a, "profile_photo");
                    if (!C7.a.a()) {
                        z0.this.V2();
                        return;
                    } else {
                        H7.b.e("DetailFragment", "OnClickListener Invalid click return --------------");
                        return;
                    }
                case R.id.layout_sms /* 2131428248 */:
                case R.id.sms /* 2131429015 */:
                    if (CommonFeatureOption.j()) {
                        com.customize.contacts.util.h0.r(z0.this.f14738a, "message");
                        z0.this.a2();
                        return;
                    }
                    return;
                case R.id.layout_video /* 2131428250 */:
                case R.id.video_call /* 2131429348 */:
                    if (CommonFeatureOption.j()) {
                        com.customize.contacts.util.h0.s(z0.this.f14738a, "video_call", com.customize.contacts.util.h0.b0(z0.this.f14738a));
                        if (z0.this.f14766o.size() != 1) {
                            z0.this.f3(3);
                            return;
                        }
                        Intent intent = z0.this.f14766o.get(0).f14631u;
                        intent.putExtra("dialer_from", "detail");
                        C0802m.a(z0.this.getActivity(), intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14790a;

        public f(Context context) {
            this.f14790a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            int i11;
            Context context = this.f14790a;
            if (z0.this.x2()) {
                i11 = 3;
            } else {
                i11 = 1;
            }
            com.customize.contacts.util.h0.T(context, i11, "state", "5");
            z0.this.P1();
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public View f14792a;

        public void a(View view) {
            this.f14792a = view;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (!C0637b.h()) {
                z0.this.i3(this.f14792a, motionEvent);
            }
        }

        public g() {
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public interface h {
        boolean a();

        boolean b();

        boolean c();

        void d(Intent intent);
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public static class i extends AsyncTask<String, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<z0> f14794a;

        /* renamed from: b, reason: collision with root package name */
        public final Collection<Long> f14795b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f14796c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f14797d;

        public i(z0 z0Var, Collection<Long> collection, Uri uri, Bundle bundle) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f14795b = copyOnWriteArrayList;
            this.f14794a = new WeakReference<>(z0Var);
            copyOnWriteArrayList.addAll(collection);
            this.f14796c = uri;
            this.f14797d = bundle;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            Bitmap bitmap;
            H7.b.e("DetailFragment", "doInBackground mResultUri: " + this.f14796c);
            z0 z0Var = this.f14794a.get();
            if (z0Var != null && z0Var.isAdded()) {
                boolean x22 = z0Var.x2();
                Context context = z0Var.getContext();
                if (context == null) {
                    return null;
                }
                try {
                    bitmap = I7.a.e(context, this.f14796c);
                } catch (FileNotFoundException e10) {
                    H7.b.c("DetailFragment", "e = " + e10);
                    bitmap = null;
                }
                context.getContentResolver().delete(this.f14796c, null, null);
                for (Long l10 : this.f14795b) {
                    if (bitmap != null) {
                        z0.T2(context, l10.longValue(), bitmap, x22);
                        OmojiRepository.c(context, l10.longValue(), x22, this.f14797d);
                    }
                }
                if (x22) {
                    com.customize.contacts.util.W.h(context);
                    com.customize.contacts.util.W.e(context);
                }
            }
            return null;
        }
    }

    /* compiled from: DetailFragment.java */
    /* loaded from: classes.dex */
    public class j implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            FragmentActivity activity = z0.this.getActivity();
            int i11 = 3;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("view_position", 4);
                        com.android.contacts.framework.baseui.util.A.a(z0.this.f14738a, 2000311, 200030178, hashMap, false);
                        return;
                    } else {
                        if (!z0.this.x2()) {
                            i11 = 1;
                        }
                        com.customize.contacts.util.h0.T(activity, i11, "add_way", "delete");
                        z0.this.showDeletePhotoDialog();
                        return;
                    }
                }
                if (!z0.this.x2()) {
                    i11 = 1;
                }
                com.customize.contacts.util.h0.T(activity, i11, "add_way", "photo");
                z0 z0Var = z0.this;
                com.customize.contacts.util.h0.y(z0Var.f14738a, "photo", z0Var.x2());
                z0.this.f14777v0 = false;
                z0 z0Var2 = z0.this;
                Intent o10 = com.android.contacts.util.i.o(z0Var2.f14738a, z0Var2.f14776u0);
                try {
                    if (P7.c.b(o10, z0.this.f14738a, true) != null) {
                        S7.b.b(z0.this, o10, 2, R.string.activity_not_found);
                    } else {
                        S7.b.b(z0.this, com.android.contacts.util.i.m(), 1004, R.string.activity_not_found);
                    }
                    C0636a.a(z0.this.getActivity());
                    return;
                } catch (Exception e10) {
                    Log.e("DetailFragment", "" + e10);
                    com.oplus.foundation.util.ui.c.b(z0.this.f14738a, R.string.phone_no_photo);
                    return;
                }
            }
            if (!z0.this.x2()) {
                i11 = 1;
            }
            com.customize.contacts.util.h0.T(activity, i11, "add_way", "camera");
            z0.this.f14777v0 = true;
            if (activity != null) {
                String str = C1501d.f36274c;
                if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                    com.android.contacts.framework.baseui.util.l.f(activity, str, null, 0);
                    return;
                }
            }
            if (com.android.contacts.util.w.k(z0.this.f14738a, "android.permission.CAMERA")) {
                z0 z0Var3 = z0.this;
                com.customize.contacts.util.h0.y(z0Var3.f14738a, "camera", z0Var3.x2());
                z0 z0Var4 = z0.this;
                z0Var4.j3(z0Var4.f14776u0, true);
                return;
            }
            z0.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
        }

        public j() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2() {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            Context context = getContext();
            if (context != null) {
                boolean f10 = com.android.contacts.framework.api.appstore.simcard.a.f(context);
                this.f14751g0 = f10;
                this.f14753h0 = false;
                this.f14755i0 = f10;
            }
        } else {
            h hVar = this.f14731T;
            if (hVar != null && hVar.c()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f14751g0 = z10;
            h hVar2 = this.f14731T;
            if (hVar2 != null && hVar2.b()) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f14753h0 = z11;
            if (this.f14751g0) {
                h hVar3 = this.f14731T;
                if (hVar3 != null && hVar3.a()) {
                    z12 = true;
                }
                this.f14755i0 = z12;
            }
        }
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.l0
                @Override // java.lang.Runnable
                public final void run() {
                    z0.this.G2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2() {
        if (isAdded()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof BaseActivityFragment) {
                ((BaseActivityFragment) parentFragment).z1();
            } else {
                requireActivity().invalidateOptionsMenu();
            }
        }
    }

    public static void S1(Context context, i0.f fVar, ContentValues contentValues) {
        int intValue;
        int intValue2;
        boolean equals = "vnd.android.cursor.item/email_v2".equals(contentValues.getAsString("mimetype"));
        if (!equals && !v2(contentValues)) {
            return;
        }
        String asString = contentValues.getAsString("data1");
        if (TextUtils.isEmpty(asString)) {
            return;
        }
        if (equals) {
            intValue = 5;
        } else {
            intValue = contentValues.getAsInteger("data5").intValue();
        }
        if (intValue == 5) {
            Integer asInteger = contentValues.getAsInteger("chat_capability");
            if (asInteger == null) {
                intValue2 = 0;
            } else {
                intValue2 = asInteger.intValue();
            }
            fVar.f14636z = intValue2;
            fVar.f14617g = ContactsContract.CommonDataKinds.Im.getProtocolLabel(context.getResources(), 5, null).toString();
            if ((intValue2 & 4) != 0) {
                fVar.f14629s = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + asString + "?message"));
                fVar.f14630t = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + asString + "?call"));
            } else if ((intValue2 & 1) != 0) {
                fVar.f14629s = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + asString + "?message"));
                fVar.f14630t = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + asString + "?call"));
            } else {
                fVar.f14629s = new Intent("android.intent.action.SENDTO", Uri.parse("xmpp:" + asString + "?message"));
            }
            fVar.f14644b = true;
            return;
        }
        String asString2 = contentValues.getAsString("data6");
        if (intValue != -1) {
            asString2 = S0.b.a(intValue);
        }
        if (!TextUtils.isEmpty(asString2)) {
            fVar.f14629s = new Intent("android.intent.action.SENDTO", new Uri.Builder().scheme("imto").authority(asString2.toLowerCase()).appendPath(asString).build());
            if ("QQ".equals(S0.b.a(intValue))) {
                fVar.f14629s.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            }
            fVar.f14644b = true;
        }
    }

    public static void T2(Context context, long j10, Bitmap bitmap, boolean z10) {
        Uri uri;
        byte[] d10 = com.android.contacts.util.i.d(bitmap);
        if (d10 == null) {
            H7.b.i("DetailFragment", "could not create scaled and compressed Bitmap");
            return;
        }
        if (z10) {
            uri = ContactsContract.Profile.CONTENT_URI.buildUpon().appendPath("data").build();
        } else {
            uri = ContactsContract.Data.CONTENT_URI;
        }
        int i10 = -1;
        try {
            Cursor query = context.getContentResolver().query(uri, null, "raw_contact_id = " + j10 + " AND mimetype='vnd.android.cursor.item/photo'", null, null);
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow(BreenoCallContract.BaseColumns._ID);
                if (query.moveToFirst()) {
                    i10 = query.getInt(columnIndexOrThrow);
                }
                query.close();
            } finally {
            }
        } catch (Exception e10) {
            H7.b.c("DetailFragment", "" + e10);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("raw_contact_id", Long.valueOf(j10));
        contentValues.put("is_primary", (Integer) 1);
        contentValues.put("is_super_primary", (Integer) 1);
        contentValues.put("mimetype", "vnd.android.cursor.item/photo");
        contentValues.put("data15", d10);
        if (i10 >= 0) {
            G7.c.g(context.getContentResolver(), R0.d.a(uri), contentValues, "_id = " + i10, null);
            return;
        }
        G7.c.d(context.getContentResolver(), R0.d.a(uri), contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3(final int i10) {
        U0.b bVar = new U0.b(requireActivity(), 2132083073);
        String[] strArr = new String[this.f14766o.size()];
        boolean h10 = C0637b.h();
        for (int i11 = 0; i11 < this.f14766o.size(); i11++) {
            i0.f fVar = this.f14766o.get(i11);
            if (fVar.f14626p && i10 == 1) {
                FragmentActivity activity = getActivity();
                Intent intent = fVar.f14629s;
                C0794e.b(activity, intent, intent.getData().getSchemeSpecificPart());
                fVar.f14629s.putExtra("dialer_from", "detail");
                C0802m.a(getActivity(), fVar.f14629s);
                return;
            }
            String str = fVar.f14623m;
            strArr[i11] = str;
            if (h10) {
                strArr[i11] = C0637b.d(str);
            }
        }
        bVar.setTitle(R.string.select_phonenumber);
        bVar.setItems((CharSequence[]) strArr, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.m0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                z0.this.L2(i10, dialogInterface, i12);
            }
        });
        bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        bVar.setWindowAnimStyle(2132082730);
        bVar.show();
    }

    private Intent i2() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof BaseActivityFragment) {
            return ((BaseActivityFragment) parentFragment).t1();
        }
        return requireActivity().getIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(View view, MotionEvent motionEvent) {
        com.customize.contacts.widget.i iVar = this.f14761l0;
        if (iVar != null) {
            iVar.x(view);
            if (view instanceof ActionsViewContainer) {
                this.f14761l0.l(this.f14746e.getItemIdAtPosition(((ActionsViewContainer) view).getPosition()));
            }
            this.f14761l0.p(this.f14747e0);
            this.f14761l0.q(this.f14745d0);
            this.f14761l0.s(this.f14721O);
            this.f14761l0.n(this.f14737Z);
            this.f14761l0.o(this.f14736Y);
            this.f14761l0.r(x2());
            this.f14761l0.v(view, (int) motionEvent.getX(), (int) motionEvent.getY(), false);
        }
    }

    private void k3() {
        if (this.f14714K0) {
            this.f14746e.setIsParentChildHierarchy(this.f14716L0);
        } else {
            this.f14746e.setIsParentChildHierarchy(false);
        }
    }

    public static boolean v2(ContentValues contentValues) {
        String asString = contentValues.getAsString("data5");
        if (asString == null) {
            return false;
        }
        try {
            Integer.valueOf(asString);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final /* synthetic */ boolean A2() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof CallDetailActivityFragment) {
            return ((CallDetailActivityFragment) parentFragment).Q5();
        }
        return true;
    }

    public final /* synthetic */ boolean B2() {
        return this.f14694A0.g0();
    }

    @Override // com.android.contacts.detail.E0.f
    public View.OnClickListener C() {
        return new b();
    }

    public final /* synthetic */ boolean C2(View view, MotionEvent motionEvent) {
        this.f14765n0.a(view);
        return this.f14763m0.onTouchEvent(motionEvent);
    }

    public final /* synthetic */ boolean D2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            t2();
            return false;
        }
        return false;
    }

    public final /* synthetic */ void E2() {
        OmojiUtils.m(getContext());
    }

    public final /* synthetic */ boolean F2() {
        if (this.f14714K0) {
            return this.f14716L0;
        }
        return false;
    }

    public final /* synthetic */ void G2() {
        if (this.f14748f != null && !this.f14700D0) {
            b2();
        }
    }

    public final void H1(AbstractC1362a abstractC1362a) {
        StringBuilder sb = new StringBuilder();
        Set<Account> keySet = this.f14760l.keySet();
        int size = keySet.size();
        if (size <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(size);
        for (Account account : keySet) {
            if (size == 1 && TextUtils.equals(R0.a.f3166b, account.f16942b)) {
                return;
            } else {
                arrayList.add(account);
            }
        }
        String string = this.f14738a.getString(R.string.contact_detail_comma);
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb.append(string);
            }
            O1(sb, abstractC1362a, (Account) arrayList.get(i10));
        }
        this.f14703F.add(i0.f.h(this.f14738a, getString(R.string.oplus_accounts), sb.toString()));
    }

    @Override // com.android.contacts.detail.E0.f
    public View.OnClickListener I() {
        return new c();
    }

    public final void I1() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<i0.f> it = this.f14709I.iterator();
        while (it.hasNext()) {
            i0.f next = it.next();
            int i10 = next.f14615e;
            if (i10 == 0) {
                List list = (List) hashMap2.get(next.f14617g);
                if (list == null) {
                    list = new ArrayList();
                }
                i0.f l10 = i0.f.l(this.f14738a, next.f14617g, next.f14615e, next.f14618h, next.f14609B);
                list.add(l10);
                hashMap2.put(l10.f14617g, list);
            } else {
                List list2 = (List) hashMap.get(Integer.valueOf(i10));
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                i0.f l11 = i0.f.l(this.f14738a, next.f14617g, next.f14615e, next.f14618h, next.f14609B);
                list2.add(l11);
                hashMap.put(Integer.valueOf(l11.f14615e), list2);
            }
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (it2.hasNext()) {
            this.f14711J.addAll((Collection) ((Map.Entry) it2.next()).getValue());
        }
        Iterator it3 = hashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            this.f14711J.addAll((Collection) ((Map.Entry) it3.next()).getValue());
        }
        this.f14709I.clear();
        hashMap.clear();
        hashMap2.clear();
    }

    public final /* synthetic */ void I2() {
        this.f14738a.getContentResolver().delete(this.f14776u0, null, null);
    }

    public final void J1() {
        this.f14707H.add(i0.f.k(this.f14738a));
    }

    public final /* synthetic */ void J2(boolean z10) {
        if (z10) {
            g3();
        } else {
            h3();
        }
    }

    public final void K1() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<i0.f> it = this.f14701E.iterator();
        while (it.hasNext()) {
            i0.f next = it.next();
            int i10 = next.f14615e;
            if (i10 == 0) {
                List list = (List) hashMap2.get(next.f14617g);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(next);
                hashMap2.put(next.f14617g, list);
            } else {
                List list2 = (List) hashMap.get(Integer.valueOf(i10));
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                i0.f l10 = i0.f.l(this.f14738a, next.f14617g, next.f14615e, next.f14618h, next.f14609B);
                list2.add(l10);
                hashMap.put(Integer.valueOf(l10.f14615e), list2);
            }
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (it2.hasNext()) {
            this.f14711J.addAll((List) ((Map.Entry) it2.next()).getValue());
        }
        Iterator it3 = hashMap2.entrySet().iterator();
        while (it3.hasNext()) {
            this.f14711J.addAll((List) ((Map.Entry) it3.next()).getValue());
        }
        this.f14701E.clear();
        hashMap.clear();
        hashMap2.clear();
    }

    public final /* synthetic */ void K2(String str, Bundle bundle) {
        String str2;
        int i10 = bundle.getInt("panel_request_type", -1);
        if (i10 == 0) {
            P1();
            return;
        }
        if (i10 == 1) {
            boolean z10 = bundle.getBoolean("delete_temp_photo_uri");
            boolean z11 = bundle.getBoolean("is_from_document");
            this.f14708H0 = null;
            String string = bundle.getString("new_crop_photo_uri");
            if (z11 && string != null) {
                this.f14775t0 = Uri.parse(string);
            }
            R2(z10);
            return;
        }
        if (i10 == 2) {
            String string2 = bundle.getString("contact_photo_uri");
            String string3 = bundle.getString("dial_photo_uri");
            String string4 = bundle.getString("dial_photo_bg_color");
            if (string2 != null) {
                com.android.contacts.util.i.u(this.f14738a, Uri.parse(string2), this.f14775t0, false);
                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    ContactLoader.Result result = this.f14744d;
                    if (result != null) {
                        str2 = result.x("vnd.android.cursor.item/omoji_photo", "data1");
                    } else {
                        str2 = null;
                    }
                    Bundle d10 = OmojiUtils.d(str2, null, string4);
                    this.f14708H0 = d10;
                    com.android.contacts.util.i.u(this.f14738a.getApplicationContext(), Uri.parse(string3), (Uri) d10.getParcelable("output_uri"), false);
                }
                R2(false);
            }
            OmojiUtils.m(getContext());
            return;
        }
        H7.b.c("DetailFragment", "onFragmentResult ERROR");
    }

    public final void L1() {
        this.f14705G.add(i0.f.n(this.f14738a));
    }

    public final /* synthetic */ void L2(int i10, DialogInterface dialogInterface, int i11) {
        CopyOnWriteArrayList<i0.f> copyOnWriteArrayList = this.f14766o;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > i11) {
            if (i10 == 1) {
                Intent intent = copyOnWriteArrayList.get(i11).f14629s;
                C0794e.b(getActivity(), intent, intent.getData().getSchemeSpecificPart());
                intent.putExtra("dialer_from", "detail");
                C0802m.a(getActivity(), intent);
                return;
            }
            if (i10 == 2) {
                Intent intent2 = copyOnWriteArrayList.get(i11).f14630t;
                intent2.putExtra("open_from_dialog", false);
                R7.b.d(this.f14738a, intent2, R.string.activity_not_found);
            } else {
                Intent intent3 = copyOnWriteArrayList.get(i11).f14631u;
                intent3.putExtra("dialer_from", "detail");
                C0802m.a(getActivity(), intent3);
            }
        }
    }

    @Override // com.android.contacts.detail.E0.f
    public View.OnClickListener M() {
        return new d();
    }

    public void M1() {
        this.f14711J.add(new i0.b());
    }

    public final /* synthetic */ void M2(DialogInterface dialogInterface) {
        HashMap hashMap = new HashMap();
        hashMap.put("view_position", 4);
        com.android.contacts.framework.baseui.util.A.a(this.f14738a, 2000311, 200030178, hashMap, false);
    }

    public final void N1() {
        boolean z10 = !TextUtils.isEmpty(F.a(this.f14738a, this.f14744d));
        int size = this.f14742c.keySet().size();
        if (!z10 && size == 0) {
            return;
        }
        for (Map.Entry<AccountType, List<i0.f>> entry : this.f14742c.entrySet()) {
            if (entry.getKey() == null) {
                return;
            }
            this.f14711J.add(i0.k.g(this.f14738a, entry.getKey()));
            this.f14711J.addAll(entry.getValue());
        }
        this.f14742c.clear();
    }

    public void N2() {
        b2();
    }

    @Override // com.android.contacts.detail.E0.f
    public View.OnClickListener O() {
        return new e();
    }

    public final void O1(StringBuilder sb, AbstractC1362a abstractC1362a, Account account) {
        if (TextUtils.equals(R0.a.f3166b, account.f16942b)) {
            sb.append(getString(R.string.contact_editor_account_storage_phone));
        } else if ("com.android.oplus.sim".equals(account.f16942b)) {
            sb.append(com.customize.contacts.simcontacts.b.f(this.f14738a, com.customize.contacts.simcontacts.b.j(account.f16941a)));
        } else {
            sb.append(abstractC1362a.c(account.f16942b, null).f(this.f14738a));
        }
    }

    @Override // com.android.contacts.detail.E0.f
    public void P(E0.c cVar) {
        String str;
        int width;
        CharSequence d10 = F.d(this.f14738a, this.f14744d);
        if (C0637b.h() && d10 != null) {
            d10 = C0637b.c(d10.toString());
        }
        ContactLoader.Result result = this.f14744d;
        if (result != null) {
            str = F.b(this.f14738a, result);
        } else {
            str = "";
        }
        cVar.f14517f.setVisibility(8);
        TextView textView = cVar.f14513b;
        if (textView != null) {
            if (ContactsApplication.f13094j) {
                textView.setTextDirection(3);
            }
            cVar.f14513b.setText(d10);
            TextView textView2 = cVar.f14513b;
            Context context = this.f14738a;
            textView2.setTag(i0.f.o(context, F.d(context, this.f14744d)));
            cVar.f14513b.setOnTouchListener(this.f14767o0);
            cVar.f14513b.setOnClickListener(null);
            if (cVar.f14517f.getVisibility() == 0 && !this.f14696B0 && (width = cVar.f14518g.getWidth()) != 0 && cVar.f14513b.getWidth() + (DisplayUtil.a(this.f14738a, 10.0f) * 2) > width) {
                cVar.f14513b.setMaxWidth(width - (DisplayUtil.a(this.f14738a, 10.0f) * 2));
                this.f14696B0 = true;
            }
        }
        if (cVar.f14516e != null) {
            if (!TextUtils.isEmpty(str)) {
                cVar.f14516e.setText(str);
                cVar.f14516e.setVisibility(0);
            } else {
                cVar.f14516e.setVisibility(8);
            }
        }
        TextView textView3 = cVar.f14515d;
        if (textView3 != null) {
            if (!this.f14769p0) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(getString(R.string.oplus_vip_group));
                cVar.f14515d.setVisibility(0);
            }
        }
        if (cVar.f14514c != null) {
            String g10 = F.g(this.f14738a, this.f14744d);
            if (TextUtils.isEmpty(g10)) {
                cVar.f14514c.setVisibility(8);
            } else {
                cVar.f14514c.setText(g10);
                cVar.f14514c.setVisibility(0);
            }
        }
        if (cVar.f14526o != null) {
            if (x2()) {
                cVar.f14526o.setVisibility(8);
            } else {
                cVar.f14526o.setVisibility(0);
            }
        }
        if (cVar.f14526o != null && C1643c.w()) {
            cVar.f14526o.setVisibility(8);
        }
    }

    public final void P1() {
        this.f14778w0.execute(new Runnable() { // from class: com.android.contacts.detail.o0
            @Override // java.lang.Runnable
            public final void run() {
                z0.this.y2();
            }
        });
    }

    public final boolean P2() {
        i0.m mVar;
        boolean z10;
        Iterator<i0.m> it = this.f14711J.iterator();
        while (true) {
            if (it.hasNext()) {
                mVar = it.next();
                if (mVar instanceof i0.e) {
                    break;
                }
            } else {
                mVar = null;
                break;
            }
        }
        boolean z11 = false;
        if (mVar != null && this.f14711J.remove(mVar)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeAutoCallSummaryTip: ");
            sb.append(z10);
            sb.append(", ");
            if (mVar != null) {
                z11 = true;
            }
            sb.append(z11);
            H7.b.b("DetailFragment", sb.toString());
        }
        return z10;
    }

    public void Q1() {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.f14727R == null) {
            return;
        }
        if (isAdded()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof BaseActivityFragment) {
                ((BaseActivityFragment) parentFragment).z1();
            } else {
                requireActivity().invalidateOptionsMenu();
            }
        }
        if (this.f14744d == null) {
            this.f14727R.setVisibility(4);
            this.f14711J.clear();
            b2();
            return;
        }
        R1();
        if (this.f14732U <= 0) {
            this.f14706G0.i(null);
        }
        C0594d.a(this.f14764n);
        u2();
        C0594d.a(this.f14768p);
        C0594d.a(this.f14770q);
        C0594d.a(this.f14772r);
        C0594d.a(this.f14779x);
        C0594d.a(this.f14695B);
        C0594d.a(this.f14781y);
        C0594d.a(this.f14697C);
        C0594d.a(this.f14699D);
        C0594d.a(this.f14693A);
        C0594d.a(this.f14701E);
        C0594d.a(this.f14709I);
        Iterator<Map.Entry<AccountType, List<i0.f>>> it = this.f14742c.entrySet().iterator();
        while (it.hasNext()) {
            C0594d.a(it.next().getValue());
        }
        if (this.f14764n.size() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f14745d0 = z10;
        if (this.f14770q.size() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f14747e0 = z11;
        d3();
        if (this.f14700D0 && !this.f14702E0 && this.f14729S == null) {
            return;
        }
        if (this.f14748f == null && getActivity() != null) {
            E0 e02 = new E0(getActivity(), this.f14711J, this.f14767o0, this, this.f14718M0);
            this.f14748f = e02;
            this.f14746e.setAdapter((ListAdapter) e02);
        }
        Parcelable parcelable = this.f14743c0;
        if (parcelable != null) {
            this.f14746e.onRestoreInstanceState(parcelable);
            this.f14743c0 = null;
        }
        E0 e03 = this.f14748f;
        if (e03 != null) {
            if (this.f14766o.size() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            e03.E(z12);
            if (this.f14724P0) {
                this.f14724P0 = false;
                c2(true);
            } else {
                b2();
            }
        }
        this.f14746e.setEmptyView(this.f14741b0);
        this.f14727R.setVisibility(0);
    }

    public void Q2() {
        MultiChoiceListView multiChoiceListView = this.f14746e;
        if (multiChoiceListView != null) {
            multiChoiceListView.setAdapter((ListAdapter) this.f14748f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x074f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R1() {
        /*
            Method dump skipped, instructions count: 2237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.z0.R1():void");
    }

    public final void R2(boolean z10) {
        if (z10) {
            try {
                this.f14778w0.execute(new Runnable() { // from class: com.android.contacts.detail.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        z0.this.I2();
                    }
                });
            } catch (Exception e10) {
                H7.b.c("DetailFragment", "Cannot save photo" + e10);
                return;
            }
        }
        S2(this.f14762m, this.f14775t0, this.f14708H0);
        com.customize.contacts.util.h0.U(new HashMap(), this.f14777v0, this.f14738a);
    }

    public final void S2(Collection<Long> collection, Uri uri, Bundle bundle) {
        if (collection != null) {
            new i(this, collection, uri, bundle).execute("");
        }
    }

    public void U1(int i10) {
        if (this.f14720N0) {
            this.f14720N0 = false;
            E0 e02 = this.f14748f;
            if (e02 != null) {
                e02.d(i10);
            }
        }
    }

    public void U2(String str) {
        this.f14739a0 = str;
    }

    public void V1(ContactLoader.Result result) {
        E0 e02;
        if (result != null && (e02 = this.f14748f) != null) {
            e02.e(result);
        }
    }

    public final void V2() {
        if (this.f14721O != null || TextUtils.equals(this.f14734W, "com.android.oplus.sim")) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !OsUtils.k() && activity.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") != 0) {
            if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                activity.requestPermissions(new String[]{"android.permission.ACCESS_MEDIA_LOCATION"}, 0);
            } else {
                com.android.contacts.util.w.y(activity, false, null, "android.permission.ACCESS_MEDIA_LOCATION");
                return;
            }
        }
        OmojiUtils.a(getContext(), new f1.d() { // from class: com.android.contacts.detail.n0
            @Override // f1.d
            public final void a(boolean z10) {
                z0.this.J2(z10);
            }
        });
    }

    @Override // com.android.contacts.detail.E0.f
    public boolean W() {
        return this.f14745d0;
    }

    public final void W1() {
        this.f14723P = this.f14764n.size() + this.f14770q.size() + this.f14779x.size() + this.f14697C.size() + this.f14699D.size() + this.f14772r.size() + this.f14701E.size() + this.f14709I.size() + this.f14693A.size() + this.f14695B.size();
        if (!x2() && this.f14721O == null) {
            this.f14723P = this.f14723P + this.f14752h.size() + this.f14717M.size();
        }
    }

    public void W2(Uri uri, ContactLoader.Result result) {
        com.customize.contacts.widget.i iVar;
        this.f14729S = uri;
        this.f14744d = result;
        if (result.f0() && (iVar = this.f14761l0) != null) {
            iVar.t(true);
        }
        ArrayList<String> P10 = this.f14744d.P();
        if (this.f14718M0 != null && P10 != null && !this.f14744d.f0()) {
            this.f14718M0.asyncLoad(this.f14744d.B(), P10, this.f14744d.f13035P);
        }
        Q1();
        NewCallRepository newCallRepository = this.f14726Q0;
        if (newCallRepository != null) {
            newCallRepository.n(this.f14744d.P());
        }
    }

    public final void X1() {
        this.f14749f0 = this.f14764n.size() + this.f14768p.size() + this.f14770q.size() + this.f14779x.size() + this.f14697C.size() + this.f14699D.size() + this.f14772r.size() + this.f14701E.size() + this.f14709I.size() + this.f14783z.size() + this.f14693A.size() + this.f14695B.size();
        if (!x2() && this.f14721O == null) {
            this.f14749f0 = this.f14749f0 + this.f14752h.size() + this.f14717M.size();
        }
    }

    public final void X2() {
        getParentFragmentManager().B1("panel_request_key_for_detail", this, new androidx.fragment.app.x() { // from class: com.android.contacts.detail.k0
            @Override // androidx.fragment.app.x
            public final void a(String str, Bundle bundle) {
                z0.this.K2(str, bundle);
            }
        });
    }

    @Override // com.android.contacts.detail.E0.f
    public String Y0() {
        return this.f14739a0;
    }

    public boolean Y1() {
        if (!this.f14722O0) {
            return false;
        }
        this.f14722O0 = false;
        return true;
    }

    public void Y2(boolean z10) {
        this.f14780x0 = z10;
    }

    public void Z1() {
        if (this.f14766o.size() == 1) {
            Intent intent = this.f14766o.get(0).f14629s;
            C0794e.b(getActivity(), intent, intent.getData().getSchemeSpecificPart());
            intent.putExtra("dialer_from", "detail");
            C0802m.a(getActivity(), intent);
            return;
        }
        f3(1);
    }

    public void Z2(boolean z10) {
        this.f14725Q = z10;
    }

    @Override // com.android.contacts.detail.E0.f
    public boolean a() {
        return this.f14755i0;
    }

    public void a2() {
        if (this.f14766o.size() == 1) {
            Intent intent = this.f14766o.get(0).f14630t;
            if (intent == null) {
                com.oplus.foundation.util.ui.c.d(getContext(), R.string.activity_not_found);
                return;
            } else {
                intent.putExtra("open_from_dialog", false);
                R7.b.d(this.f14738a, intent, R.string.activity_not_found);
                return;
            }
        }
        f3(2);
    }

    public void a3(boolean z10) {
        this.f14714K0 = z10;
    }

    @Override // com.android.contacts.detail.E0.f
    public boolean b() {
        return this.f14753h0;
    }

    public void b2() {
        c2(false);
    }

    public void b3(h hVar) {
        this.f14731T = hVar;
    }

    @Override // com.android.contacts.detail.E0.f
    public boolean c() {
        return this.f14751g0;
    }

    public void c2(boolean z10) {
        E0 e02 = this.f14748f;
        if (e02 != null) {
            if (z10) {
                e02.D(this.f14711J);
                return;
            }
            Fragment parentFragment = getParentFragment();
            if ((parentFragment instanceof BaseActivityFragment) && !((BaseActivityFragment) parentFragment).C1()) {
                this.f14748f.D(this.f14711J);
            }
        }
    }

    public void c3(boolean z10) {
        this.f14773r0 = z10;
    }

    public final void d2() {
        Uri uri;
        Uri uri2;
        long parseId = ContentUris.parseId(this.f14729S);
        boolean x22 = x2();
        if (x22) {
            uri = ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI;
        } else {
            uri = ContactsContract.RawContacts.CONTENT_URI;
        }
        Uri uri3 = uri;
        Cursor cursor = null;
        try {
            try {
                cursor = this.f14738a.getContentResolver().query(uri3, new String[]{BreenoCallContract.BaseColumns._ID}, "contact_id=" + parseId, null, null);
            } catch (Exception e10) {
                H7.b.c("DetailFragment", "Exception e: " + e10);
            }
            if (cursor == null) {
                com.oplus.foundation.util.io.e.a(cursor);
                return;
            }
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                long j10 = cursor.getLong(0);
                ContentResolver contentResolver = this.f14738a.getContentResolver();
                if (x22) {
                    uri2 = ContactsContract.Profile.CONTENT_URI.buildUpon().appendPath("data").build();
                } else {
                    uri2 = ContactsContract.Data.CONTENT_URI;
                }
                contentResolver.delete(uri2, "mimetype IN (?, ?) AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/photo", "vnd.android.cursor.item/omoji_photo", String.valueOf(j10)});
            }
            if (x22) {
                com.customize.contacts.util.W.h(this.f14738a);
                com.customize.contacts.util.W.e(this.f14738a);
            }
            com.oplus.foundation.util.io.e.a(cursor);
        } catch (Throwable th) {
            com.oplus.foundation.util.io.e.a(null);
            throw th;
        }
    }

    public abstract void d3();

    public final void dismissDeletePhotoDialog() {
        androidx.appcompat.app.b bVar = this.f14710I0;
        if (bVar != null && bVar.isShowing()) {
            this.f14710I0.dismiss();
        }
        this.f14710I0 = null;
    }

    public final void e2(Intent intent) {
        try {
            S7.b.b(this, intent, 1003, R.string.activity_not_found);
        } catch (Exception e10) {
            H7.b.c("DetailFragment", "Cannot crop image" + e10);
            com.oplus.foundation.util.ui.c.b(this.f14738a, R.string.phone_no_photo);
        }
    }

    public void e3() {
        this.f14749f0 = 0;
        this.f14723P = 0;
        X1();
        W1();
        if (this.f14700D0 && !x2() && this.f14721O == null) {
            T1();
        }
        f2(this.f14764n);
        f2(this.f14768p);
        f2(this.f14770q);
        f2(this.f14783z);
        f2(this.f14772r);
        f2(this.f14779x);
        f2(this.f14699D);
        K1();
        I1();
        f2(this.f14693A);
        f2(this.f14781y);
        f2(this.f14697C);
        if (this.f14781y.size() > 0) {
            this.f14781y.clear();
        }
        f2(this.f14695B);
        if (!x2() && this.f14721O == null) {
            if (CommonFeatureOption.j()) {
                f2(this.f14752h);
                f2(this.f14717M);
            }
            f2(this.f14715L);
            N1();
            f2(this.f14703F);
            if (!this.f14700D0) {
                T1();
                return;
            }
            return;
        }
        if (CommonFeatureOption.j() && x2()) {
            M1();
            f2(this.f14707H);
            f2(this.f14705G);
        }
    }

    @Override // com.android.contacts.detail.E0.f
    public void f0(String str) {
        this.f14706G0.i(str);
    }

    public void f2(ArrayList<i0.f> arrayList) {
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f14711J.add(arrayList.get(i10));
        }
        arrayList.clear();
    }

    public i0.f g2() {
        if (this.f14754i.size() > 0) {
            return this.f14754i.get(0);
        }
        return null;
    }

    public final void g3() {
        int i10;
        if (!isAdded()) {
            return;
        }
        OmojiPanelFragment omojiPanelFragment = new OmojiPanelFragment();
        Uri uri = this.f14776u0;
        Uri uri2 = this.f14775t0;
        boolean z10 = this.f14774s0;
        boolean x22 = x2();
        if (x2()) {
            i10 = 3;
        } else {
            i10 = 1;
        }
        omojiPanelFragment.init(uri, uri2, z10, x22, i10);
        omojiPanelFragment.showPanelFragment(getParentFragmentManager(), omojiPanelFragment);
    }

    public b.c h2() {
        b.c cVar = new b.c(F.e(this.f14738a, this.f14744d).toString(), F.c(this.f14738a, this.f14744d), true);
        cVar.f5789g = 3;
        return cVar;
    }

    public void h3() {
        String[] strArr;
        int[] iArr;
        Dialog dialog = this.f14698C0;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        if (this.f14774s0) {
            strArr = new String[]{getString(R.string.oplus_contact_edit_photo_from_camera), getString(R.string.oplus_contact_edit_photo_from_picture), getString(R.string.delete_photo)};
            iArr = new int[]{R.style.DialogButtonStyle, R.style.DialogButtonStyle, R.style.DialogButtonWarningStyle};
        } else {
            strArr = new String[]{getString(R.string.oplus_contact_edit_photo_from_camera), getString(R.string.oplus_contact_edit_photo_from_picture)};
            iArr = new int[]{R.style.DialogButtonStyle, R.style.DialogButtonStyle};
        }
        COUIListDialogAdapter cOUIListDialogAdapter = new COUIListDialogAdapter(getContext(), strArr, iArr);
        U0.b bVar = new U0.b(this.f14738a, 2132083073);
        j jVar = new j();
        bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) jVar).setAdapter((ListAdapter) cOUIListDialogAdapter, (DialogInterface.OnClickListener) jVar).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.contacts.detail.p0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                z0.this.M2(dialogInterface);
            }
        });
        bVar.setOnCancelListener(null);
        this.f14698C0 = bVar.create();
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            this.f14698C0.show();
            bVar.updateViewAfterShown();
        }
    }

    public ListView j2() {
        return this.f14746e;
    }

    public final void j3(Uri uri, boolean z10) {
        int i10;
        Intent p10 = com.android.contacts.util.i.p(uri);
        if (z10) {
            i10 = R.string.activity_not_found;
        } else {
            i10 = 0;
        }
        S7.b.b(this, p10, 1, i10);
    }

    public final String k2() {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < this.f14757j0.size(); i10++) {
            sb.append("\"");
            sb.append(this.f14757j0.get(i10));
            sb.append("\"");
            if (i10 != this.f14757j0.size() - 1) {
                sb.append(getString(R.string.punctuation_comma));
            }
        }
        return sb.toString();
    }

    public NewCallRepository l2() {
        return this.f14726Q0;
    }

    public void l3() {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            Context context = getContext();
            if (context != null) {
                boolean f10 = com.android.contacts.framework.api.appstore.simcard.a.f(context);
                this.f14751g0 = f10;
                this.f14753h0 = false;
                this.f14755i0 = f10;
            }
        } else {
            h hVar = this.f14731T;
            if (hVar != null && hVar.c()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f14751g0 = z10;
            h hVar2 = this.f14731T;
            if (hVar2 != null && hVar2.b()) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f14753h0 = z11;
            if (this.f14751g0) {
                h hVar3 = this.f14731T;
                if (hVar3 != null && hVar3.a()) {
                    z12 = true;
                }
                this.f14755i0 = z12;
            }
        }
        b2();
    }

    public com.google.common.collect.p<Account, Long> m2() {
        return this.f14760l;
    }

    @Override // com.android.contacts.detail.E0.f
    public boolean n0() {
        return this.f14773r0;
    }

    public i0.f n2() {
        if (this.f14758k.size() > 0) {
            return this.f14758k.get(0);
        }
        return null;
    }

    @Override // com.android.contacts.detail.E0.f
    public boolean o0() {
        return this.f14725Q;
    }

    public final Intent o2(String str) {
        Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", str, null));
        intent.putExtra("android.telecom.extra.START_CALL_WITH_VIDEO_STATE", 3);
        ContactLoader.Result result = this.f14744d;
        if (result != null && result.t() != null) {
            intent.putExtra("countryiso", this.f14744d.t().get(str));
        }
        return intent;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri uri;
        int i12;
        String str;
        int i13 = 3;
        boolean z10 = true;
        if (i10 != 1 && i10 != 2) {
            if (i10 != 999) {
                if (i10 != 1003) {
                    if (i10 != 1004) {
                        return;
                    }
                } else {
                    if (i11 != -1) {
                        com.customize.contacts.util.h0.X(this.f14738a);
                        return;
                    }
                    this.f14719N = true;
                    if (intent != null && intent.getData() != null) {
                        com.android.contacts.util.i.u(this.f14738a, intent.getData(), this.f14775t0, false);
                    }
                    Context context = getContext();
                    if (!x2()) {
                        i13 = 1;
                    }
                    if (this.f14777v0) {
                        str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
                    } else {
                        str = "2";
                    }
                    com.customize.contacts.util.h0.T(context, i13, "state", str);
                    R2(true);
                    return;
                }
            } else {
                FragmentActivity activity = getActivity();
                if (activity != null && !activity.isFinishing() && !com.android.contacts.util.w.k(activity, "android.permission.CAMERA")) {
                    if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                        requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
                        return;
                    }
                    if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                        i12 = R.string.launcher_odialer;
                    } else {
                        i12 = R.string.people;
                    }
                    com.android.contacts.util.w.C(activity, false, getString(i12), null, new String[]{"android.permission.CAMERA"});
                    return;
                }
                return;
            }
        }
        if (i11 != -1) {
            com.customize.contacts.util.h0.X(this.f14738a);
            return;
        }
        if (intent != null && intent.getData() != null) {
            uri = intent.getData();
            z10 = false;
        } else {
            uri = this.f14776u0;
        }
        if (!z10) {
            Uri uri2 = this.f14776u0;
            try {
                if (!com.android.contacts.util.i.u(this.f14738a, uri, uri2, false)) {
                    return;
                } else {
                    uri = uri2;
                }
            } catch (SecurityException unused) {
                if (Log.isLoggable("DetailFragment", 3)) {
                    H7.b.b("DetailFragment", "Did not have read-access to uri : " + uri);
                    return;
                }
                return;
            }
        }
        Intent l10 = com.android.contacts.util.i.l(uri, this.f14775t0);
        ResolveInfo b10 = P7.c.b(l10, this.f14738a, false);
        if (b10 != null) {
            l10.setPackage(b10.activityInfo.packageName);
            e2(l10);
        } else {
            this.f14775t0 = uri;
            R2(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f14738a = context;
        this.f14733V = C1074c.b(context);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14716L0 = DisplayUtil.n(getActivity());
        k3();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NewCallRepository newCallRepository = new NewCallRepository(getContext(), getLifecycle());
        this.f14726Q0 = newCallRepository;
        newCallRepository.k().i(this, this.f14730S0);
        this.f14694A0 = RecordPlayerPresenter.X(requireActivity());
        com.android.contacts.util.o oVar = new com.android.contacts.util.o();
        this.f14706G0 = oVar;
        oVar.j(new o.b() { // from class: com.android.contacts.detail.s0
            @Override // com.android.contacts.util.o.b
            public final boolean a() {
                boolean A22;
                A22 = z0.this.A2();
                return A22;
            }
        });
        this.f14706G0.k(new o.c() { // from class: com.android.contacts.detail.t0
            @Override // com.android.contacts.util.o.c
            public final boolean a() {
                boolean B22;
                B22 = z0.this.B2();
                return B22;
            }
        });
        if (bundle != null) {
            this.f14729S = (Uri) bundle.getParcelable("contactUri");
            this.f14743c0 = bundle.getParcelable("list_state");
            this.f14776u0 = Uri.parse(bundle.getString("temp_photo_uri"));
            this.f14775t0 = Uri.parse(bundle.getString("cropped_photo_uri"));
            this.f14777v0 = bundle.getBoolean("take_photo", false);
            try {
                this.f14762m = (ArrayList) bundle.getSerializable("raw_contact_id_list");
            } catch (Exception e10) {
                this.f14762m = new ArrayList<>();
                Log.e("DetailFragment", "getSerializable KEY_RAW_CONTACT_ID_LIST error " + e10);
            }
            try {
                ArrayList arrayList = (ArrayList) bundle.getSerializable("fraud_numbers_from_nafc");
                if (arrayList != null && arrayList.size() > 0) {
                    this.f14757j0.clear();
                    this.f14757j0.addAll(arrayList);
                }
            } catch (Exception e11) {
                Log.e("DetailFragment", "getSerializable KEY_FRAUD_NUMBERS_FROM_NAFC error " + e11);
            }
        } else {
            this.f14776u0 = com.android.contacts.util.i.i(this.f14738a);
            this.f14775t0 = com.android.contacts.util.i.g(this.f14738a);
            this.f14762m = new ArrayList<>();
        }
        if (getParentFragment() != null && i2() != null) {
            this.f14721O = (SimContactInfo) C7.e.j(i2(), "sim_contacts_info");
            this.f14771q0 = C7.e.d(i2(), OplusAutoRedialNotificationUI.TYPE, 0);
            this.f14700D0 = C7.e.c(i2(), "from_dialer", false);
        }
        if (bundle != null) {
            this.f14700D0 = bundle.getBoolean("from_dialer", false);
        }
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(getActivity());
        this.f14759k0 = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        this.f14765n0 = new g();
        this.f14763m0 = new GestureDetector(this.f14738a, this.f14765n0);
        com.customize.contacts.widget.i iVar = new com.customize.contacts.widget.i(this.f14738a);
        this.f14761l0 = iVar;
        iVar.u(!this.f14700D0 ? 1 : 0);
        this.f14767o0 = new View.OnTouchListener() { // from class: com.android.contacts.detail.u0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean C22;
                C22 = z0.this.C2(view, motionEvent);
                return C22;
            }
        };
        X2();
        this.f14718M0 = new AutoCallSummaryTipManager(this.f14738a, getLifecycle(), this.f14728R0);
        getLifecycle().a(this.f14718M0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f14740b = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.contact_detail_fragment, viewGroup, false);
        this.f14727R = inflate;
        MultiChoiceListView multiChoiceListView = (MultiChoiceListView) inflate.findViewById(android.R.id.list);
        this.f14746e = multiChoiceListView;
        multiChoiceListView.setFocusable(false);
        this.f14746e.setScrollBarStyle(33554432);
        this.f14746e.setOnItemClickListener(this);
        this.f14746e.setItemsCanFocus(true);
        this.f14746e.setDivider(null);
        this.f14746e.setNestedScrollingEnabled(true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
        this.f14746e.setPadding(0, dimensionPixelSize, 0, 0);
        this.f14746e.smoothScrollByOffset(-dimensionPixelSize);
        com.android.contacts.util.C.a(requireContext(), this.f14746e);
        this.f14746e.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.detail.j0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean D22;
                D22 = z0.this.D2(view, motionEvent);
                return D22;
            }
        });
        this.f14741b0 = this.f14727R.findViewById(android.R.id.empty);
        if (this.f14744d != null) {
            this.f14727R.setVisibility(4);
            Q1();
        } else {
            if (this.f14748f == null && getActivity() != null) {
                E0 e02 = new E0(getActivity(), this.f14711J, this.f14767o0, this, this.f14718M0);
                this.f14748f = e02;
                this.f14746e.setAdapter((ListAdapter) e02);
                this.f14748f.F(this.f14694A0);
            }
            this.f14711J.clear();
            b2();
            this.f14727R.setVisibility(0);
        }
        this.f14727R.post(new Runnable() { // from class: com.android.contacts.detail.q0
            @Override // java.lang.Runnable
            public final void run() {
                z0.this.E2();
            }
        });
        this.f14716L0 = DisplayUtil.n(getActivity());
        k3();
        this.f14746e.setFragmentStateListener(new MultiChoiceListView.a() { // from class: com.android.contacts.detail.r0
            @Override // com.customize.contacts.widget.MultiChoiceListView.a
            public final boolean a() {
                boolean F22;
                F22 = z0.this.F2();
                return F22;
            }
        });
        return this.f14727R;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ImageView imageView;
        this.f14694A0.l0();
        super.onDestroy();
        Z0.b bVar = this.f14784z0;
        if (bVar != null && (imageView = this.f14782y0) != null) {
            bVar.v(imageView);
        }
        ThreadPoolExecutor threadPoolExecutor = this.f14778w0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f14778w0 = null;
        }
        Dialog dialog = this.f14698C0;
        if (dialog != null) {
            dialog.dismiss();
            this.f14698C0 = null;
        }
        dismissDeletePhotoDialog();
        getParentFragmentManager().v("panel_request_key_for_detail");
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        i0.m mVar;
        if (this.f14731T == null) {
            return;
        }
        E0 e02 = this.f14748f;
        if (e02 != null) {
            mVar = e02.getItem(i10);
        } else {
            mVar = null;
        }
        if (mVar == null) {
            return;
        }
        mVar.c(view, this.f14731T);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f14694A0.m0();
        if (com.android.contacts.util.o.l()) {
            this.f14706G0.m(getActivity());
        }
        super.onPause();
        if (H7.a.b()) {
            H7.b.b("DetailFragment", "onPause");
        }
        Fragment parentFragment = getParentFragment();
        if ((parentFragment instanceof CallDetailActivityFragment) && ((CallDetailActivityFragment) parentFragment).E1()) {
            com.customize.contacts.util.i0 i0Var = this.f14704F0;
            if (i0Var != null) {
                i0Var.a();
            }
        } else {
            com.customize.contacts.util.i0.b();
        }
        this.f14759k0.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        boolean z10;
        int i11;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            int length = iArr.length;
            int i12 = 0;
            while (true) {
                if (i12 < length) {
                    if (iArr[i12] != 0) {
                        z10 = false;
                        break;
                    }
                    i12++;
                } else {
                    z10 = true;
                    break;
                }
            }
            if (i10 == 1) {
                if (z10) {
                    j3(this.f14776u0, false);
                } else if (!shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                    if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                        i11 = R.string.launcher_odialer;
                    } else {
                        i11 = R.string.people;
                    }
                    com.android.contacts.util.w.D(activity, false, getString(i11), null, new String[]{"android.permission.CAMERA"}, getActivity() instanceof ContactsTabActivity);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.f14694A0.o0();
        super.onResume();
        if (H7.a.b()) {
            H7.b.b("DetailFragment", "onResume");
        }
        this.f14759k0.onResume();
        if (com.android.contacts.util.o.l()) {
            this.f14706G0.h(requireActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("contactUri", this.f14729S);
        MultiChoiceListView multiChoiceListView = this.f14746e;
        if (multiChoiceListView != null) {
            bundle.putParcelable("list_state", multiChoiceListView.onSaveInstanceState());
        }
        Uri uri = this.f14776u0;
        if (uri != null) {
            bundle.putString("temp_photo_uri", uri.toString());
        }
        Uri uri2 = this.f14775t0;
        if (uri2 != null) {
            bundle.putString("cropped_photo_uri", uri2.toString());
        }
        ArrayList<Long> arrayList = this.f14762m;
        if (arrayList != null) {
            bundle.putSerializable("raw_contact_id_list", arrayList);
        }
        bundle.putBoolean("take_photo", this.f14777v0);
        if (this.f14757j0.size() > 0) {
            bundle.putSerializable("fraud_numbers_from_nafc", this.f14757j0);
        }
        bundle.putBoolean("from_dialer", this.f14700D0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        Fragment parentFragment = getParentFragment();
        if ((parentFragment instanceof CallDetailActivityFragment) && ((CallDetailActivityFragment) parentFragment).E1()) {
            FragmentActivity activity = getActivity();
            if (activity instanceof ContactsTabActivity) {
                String tag = parentFragment.getTag();
                if (tag == null) {
                    return;
                }
                tag.hashCode();
                char c10 = 65535;
                switch (tag.hashCode()) {
                    case -597857128:
                        if (tag.equals("right_fragment_tag_show_profile")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 41542742:
                        if (tag.equals("unfold_dial_contact")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 1842060162:
                        if (tag.equals("right_fragment_tag_show_detail")) {
                            c10 = 2;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                    case 2:
                        if (((ContactsTabActivity) activity).C2()) {
                            if (this.f14704F0 == null) {
                                this.f14704F0 = new com.customize.contacts.util.i0();
                            }
                            this.f14704F0.c(this.f14746e);
                            break;
                        }
                        break;
                    case 1:
                        if (((ContactsTabActivity) activity).E2()) {
                            if (this.f14704F0 == null) {
                                this.f14704F0 = new com.customize.contacts.util.i0();
                            }
                            this.f14704F0.c(this.f14746e);
                            break;
                        }
                        break;
                }
            }
        } else {
            com.customize.contacts.util.i0.d(getActivity(), this.f14746e);
        }
        t2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        t2();
        RecordPlayerPresenter recordPlayerPresenter = this.f14694A0;
        if (recordPlayerPresenter != null) {
            recordPlayerPresenter.p0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        N7.a a10 = N7.a.a();
        this.f14778w0 = a10;
        a10.execute(new Runnable() { // from class: com.android.contacts.detail.w0
            @Override // java.lang.Runnable
            public final void run() {
                z0.this.H2();
            }
        });
    }

    public i0.f p2() {
        if (this.f14756j.size() > 0) {
            return this.f14756j.get(0);
        }
        return null;
    }

    @Override // com.android.contacts.detail.CallDetailActivityFragment.e
    public boolean q0(int i10) {
        TelecomManager telecomManager;
        i0.m mVar;
        i0.f fVar;
        Intent intent;
        if (i10 != 5 || !CommonFeatureOption.j() || getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed() || ((telecomManager = (TelecomManager) getActivity().getSystemService("telecom")) != null && !telecomManager.isInCall())) {
            return false;
        }
        int selectedItemPosition = this.f14746e.getSelectedItemPosition();
        if (selectedItemPosition != -1) {
            E0 e02 = this.f14748f;
            if (e02 != null) {
                mVar = e02.getItem(selectedItemPosition);
            } else {
                mVar = null;
            }
            if ((mVar instanceof i0.f) && (fVar = (i0.f) this.f14748f.getItem(selectedItemPosition)) != null && (intent = fVar.f14629s) != null && intent.getAction().equals(C0421a.f6395a)) {
                R7.b.d(this.f14738a, fVar.f14629s, R.string.activity_not_found);
                return true;
            }
        } else if (this.f14750g != null) {
            R7.b.d(this.f14738a, new Intent(C0421a.f6395a, this.f14750g), R.string.activity_not_found);
            return true;
        }
        return false;
    }

    public final void q2(ArrayList<String> arrayList, List<M0> list, long j10) {
        if (list == null) {
            return;
        }
        for (M0 m02 : list) {
            if (m02.f13151d == j10) {
                String a10 = m02.a();
                if (!arrayList.contains(a10)) {
                    arrayList.add(a10);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.android.contacts.detail.E0.f
    public void r0(E0.c cVar) {
        Uri parse;
        b.c cVar2;
        ImageView imageView = cVar.f14512a;
        if (imageView != null) {
            this.f14782y0 = imageView;
            if ("com.oplus.contacts.sim".equals(this.f14734W)) {
                cVar.f14512a.setImageResource(R.drawable.pb_ic_default_large_photo);
                return;
            }
            long S10 = this.f14744d.S();
            String T10 = this.f14744d.T();
            if (TextUtils.isEmpty(T10)) {
                parse = null;
            } else {
                parse = Uri.parse(T10);
            }
            this.f14784z0 = Z0.b.g(this.f14738a);
            if (H7.a.b()) {
                H7.b.b("DetailFragment", "photoUri = " + parse + " photoId = " + S10);
            }
            if (parse == null) {
                cVar2 = h2();
            } else {
                cVar2 = null;
            }
            if (parse != null && !T10.endsWith("photo")) {
                this.f14784z0.k(cVar.f14512a, parse, S10, new Account(this.f14735X, this.f14734W), this.f14738a.getResources().getDimensionPixelSize(R.dimen.color_detail_photo_size), false, false, null);
                this.f14774s0 = true;
            } else {
                if (S10 > 0) {
                    if (this.f14719N) {
                        this.f14784z0.b(S10);
                        this.f14719N = false;
                    }
                    this.f14784z0.o(cVar.f14512a, S10, new Account(this.f14735X, this.f14734W), false, false, cVar2);
                    this.f14774s0 = true;
                    return;
                }
                if (x2()) {
                    cVar.f14512a.setImageDrawable(this.f14738a.getResources().getDrawable(R.drawable.pb_ic_my_profile_large, this.f14738a.getTheme()));
                } else {
                    this.f14784z0.m(cVar.f14512a, parse, new Account(this.f14735X, this.f14734W), this.f14738a.getResources().getDimensionPixelSize(R.dimen.color_detail_photo_size), false, false, cVar2);
                }
                this.f14774s0 = false;
            }
        }
    }

    public final boolean r2() {
        boolean z10;
        Iterator<i0.m> it = this.f14711J.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next() instanceof i0.e) {
                    z10 = true;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (H7.a.b()) {
            H7.b.b("DetailFragment", "hasAutoCallSummaryTip: " + z10);
        }
        return z10;
    }

    public final boolean s2() {
        boolean z10;
        Iterator<i0.m> it = this.f14711J.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next() instanceof i0.j) {
                    z10 = true;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (H7.a.b()) {
            H7.b.b("DetailFragment", "hasNafcTip: " + z10);
        }
        return z10;
    }

    public final void showDeletePhotoDialog() {
        int i10;
        if (!isAdded()) {
            return;
        }
        dismissDeletePhotoDialog();
        Context context = getContext();
        if (context == null) {
            return;
        }
        U0.b bVar = new U0.b(context, 2132083073);
        if (x2()) {
            i10 = R.string.delete_my_business_card_icon;
        } else {
            i10 = R.string.delete_contact_photo;
        }
        bVar.setTitle(i10).setNeutralButton(R.string.delete_button, (DialogInterface.OnClickListener) new f(context)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        this.f14710I0 = bVar.show();
    }

    public boolean t2() {
        com.customize.contacts.widget.i iVar = this.f14761l0;
        if (iVar != null && iVar.i()) {
            this.f14761l0.h();
            return true;
        }
        return false;
    }

    @Override // com.android.contacts.detail.E0.f
    public void u0(E0.d dVar) {
        if (((Boolean) w2().first).booleanValue()) {
            dVar.f14531b.setText(getString(R.string.contact_numbers_marked_fraud_by_nafc_caution, w2().second));
            dVar.f14531b.setVisibility(0);
            dVar.f14532c.setVisibility(0);
            dVar.f14530a.setVisibility(0);
            return;
        }
        dVar.f14531b.setVisibility(8);
        dVar.f14532c.setVisibility(8);
        dVar.f14530a.setVisibility(8);
    }

    public final void u2() {
        this.f14766o.clear();
        this.f14766o.addAll(this.f14764n);
    }

    public Pair<Boolean, String> w2() {
        boolean d10 = E0.a.d();
        if (H7.a.b()) {
            H7.b.b("DetailFragment", "isShowNAFCTips, isNAFCEnable =" + d10);
        }
        ArrayList<String> G10 = this.f14744d.G();
        if (G10 != null && G10.size() > 0) {
            this.f14757j0.clear();
            this.f14757j0.addAll(G10);
        }
        boolean z10 = false;
        String str = "";
        if (d10 && this.f14757j0.size() > 0) {
            str = k2();
            z10 = !TextUtils.isEmpty(str);
        }
        return Pair.create(Boolean.valueOf(z10), str);
    }

    public boolean x2() {
        ContactLoader.Result result = this.f14744d;
        if (result != null && result.g0()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void y2() {
        try {
            H7.b.b("DetailFragment", "delete contact photo");
            com.customize.contacts.util.h0.y(this.f14738a, "delete", x2());
            d2();
        } catch (Exception unused) {
            H7.b.c("DetailFragment", "Exception when delete contact photo");
        }
    }

    public final /* synthetic */ void z2(Boolean bool) {
        H7.b.e("DetailFragment", "OnChange: hasMessage: " + bool);
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.y0
                @Override // java.lang.Runnable
                public final void run() {
                    z0.this.O2();
                }
            });
        }
    }

    public void T1() {
    }
}
