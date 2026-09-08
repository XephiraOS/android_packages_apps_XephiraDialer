package com.oplus.blacklistapp.fragment;

import android.R;
import android.app.Dialog;
import android.content.AsyncQueryHandler;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.BlockedNumberContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.core.view.K;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import c.C0543d;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.blacklistapp.activities.CustomBlackListActivity;
import com.oplus.blacklistapp.d;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.t;
import com.oplus.blacklistapp.u;
import com.oplus.utils.B;
import com.oplus.utils.C;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0845f;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0855p;
import com.oplus.utils.C0861w;
import com.oplus.utils.E;
import com.oplus.utils.G;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.InterfaceC0862x;
import com.oplus.utils.StatisticsUtils;
import com.oplus.widget.EditModeHandler;
import com.oplus.widget.MultiChoiceListview;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import q6.AbstractRunnableC1488a;
import q6.C1491d;
import v6.C1629c;

/* compiled from: BaseBlackListFragment.java */
/* loaded from: classes3.dex */
public abstract class i extends Fragment implements S8.o, COUIListView.ScrollMultiChoiceListener {

    /* renamed from: A, reason: collision with root package name */
    public MenuItem f27111A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem f27112B;

    /* renamed from: D, reason: collision with root package name */
    public androidx.appcompat.app.b f27114D;

    /* renamed from: E, reason: collision with root package name */
    public Dialog f27115E;

    /* renamed from: F, reason: collision with root package name */
    public Dialog f27116F;

    /* renamed from: H, reason: collision with root package name */
    public int f27118H;

    /* renamed from: I, reason: collision with root package name */
    public int f27119I;

    /* renamed from: J, reason: collision with root package name */
    public S8.h f27120J;

    /* renamed from: K, reason: collision with root package name */
    public COUIPopupListWindow f27121K;

    /* renamed from: L, reason: collision with root package name */
    public int f27122L;

    /* renamed from: M, reason: collision with root package name */
    public androidx.appcompat.app.b f27123M;

    /* renamed from: P, reason: collision with root package name */
    public TextView f27126P;

    /* renamed from: Q, reason: collision with root package name */
    public COUICardListSelectedItemLayout f27127Q;

    /* renamed from: R, reason: collision with root package name */
    public TextView f27128R;

    /* renamed from: S, reason: collision with root package name */
    public COUICardListSelectedItemLayout f27129S;

    /* renamed from: T, reason: collision with root package name */
    public androidx.activity.result.b f27130T;

    /* renamed from: U, reason: collision with root package name */
    public androidx.activity.result.b f27131U;

    /* renamed from: V, reason: collision with root package name */
    public androidx.activity.result.b f27132V;

    /* renamed from: W, reason: collision with root package name */
    public androidx.activity.result.b f27133W;

    /* renamed from: X, reason: collision with root package name */
    public androidx.activity.result.b f27134X;

    /* renamed from: Y, reason: collision with root package name */
    public d.e f27135Y;

    /* renamed from: Z, reason: collision with root package name */
    public long f27136Z;

    /* renamed from: a, reason: collision with root package name */
    public AbstractRunnableC1488a f27137a;

    /* renamed from: b, reason: collision with root package name */
    public MultiChoiceListview f27139b;

    /* renamed from: c, reason: collision with root package name */
    public View f27140c;

    /* renamed from: d, reason: collision with root package name */
    public int f27141d;

    /* renamed from: e, reason: collision with root package name */
    public View f27142e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f27143f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<String, Integer> f27144g;

    /* renamed from: h, reason: collision with root package name */
    public B f27145h;

    /* renamed from: k, reason: collision with root package name */
    public COUIToolbar f27148k;

    /* renamed from: l, reason: collision with root package name */
    public EditModeHandler f27149l;

    /* renamed from: m, reason: collision with root package name */
    public COUINavigationView f27150m;

    /* renamed from: n, reason: collision with root package name */
    public FrameLayout f27151n;

    /* renamed from: o, reason: collision with root package name */
    public MenuItem f27152o;

    /* renamed from: q, reason: collision with root package name */
    public l f27154q;

    /* renamed from: r, reason: collision with root package name */
    public Handler f27155r;

    /* renamed from: x, reason: collision with root package name */
    public j f27156x;

    /* renamed from: y, reason: collision with root package name */
    public k f27157y;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<Long, C0845f> f27146i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap<Long, C0845f> f27147j = new ConcurrentHashMap<>();

    /* renamed from: p, reason: collision with root package name */
    public boolean f27153p = false;

    /* renamed from: z, reason: collision with root package name */
    public Intent f27158z = null;

    /* renamed from: C, reason: collision with root package name */
    public int f27113C = 0;

    /* renamed from: G, reason: collision with root package name */
    public boolean f27117G = false;

    /* renamed from: N, reason: collision with root package name */
    public ContentObserver f27124N = null;

    /* renamed from: O, reason: collision with root package name */
    public View f27125O = null;

    /* renamed from: a0, reason: collision with root package name */
    public InterfaceC0859u f27138a0 = new f();

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("com.oplus.mms.intent.RCS_CHATBOT_BLACKLIST");
            intent.setPackage("com.android.mms");
            C0849j.A(i.this.getActivity(), intent);
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class b implements InterfaceC0862x {

        /* compiled from: BaseBlackListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f27161a;

            public a(boolean z10) {
                this.f27161a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f27161a && l7.b.f34735c && l7.b.f34756x) {
                    i.this.f27126P.setVisibility(0);
                    i.this.f27127Q.setVisibility(0);
                } else {
                    i.this.f27126P.setVisibility(8);
                    i.this.f27127Q.setVisibility(8);
                }
            }
        }

        public b() {
        }

        @Override // com.oplus.utils.InterfaceC0862x
        public void a(boolean z10) {
            FragmentActivity activity;
            if (i.this.f27126P != null && i.this.f27127Q != null && (activity = i.this.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                activity.runOnUiThread(new a(z10));
            }
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class c implements B {
        public c() {
        }

        @Override // com.oplus.utils.B
        public void a() {
            StatisticsUtils.a(i.this.getContext().getApplicationContext(), 2010802, 201080004, null, false);
        }

        @Override // com.oplus.utils.B
        public void b() {
            i.this.f27146i.clear();
            i.this.f27146i.putAll(i.this.f27147j);
            i iVar = i.this;
            iVar.f27137a.k(iVar.f27146i);
            if (i.this.f27152o != null) {
                i.this.f27152o.setEnabled(true);
            }
        }

        @Override // com.oplus.utils.B
        public void c() {
            i.this.f27146i.clear();
            i iVar = i.this;
            iVar.f27137a.k(iVar.f27146i);
            if (i.this.f27152o != null) {
                i.this.f27152o.setEnabled(false);
            }
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            i.this.A2();
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class e implements BottomNavigationView.c {
        public e() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            HashMap hashMap = new HashMap();
            hashMap.put("selected_count", Integer.valueOf(i.this.f27149l.c()));
            StatisticsUtils.a(i.this.getContext(), 2010802, 201080005, hashMap, false);
            i iVar = i.this;
            iVar.z2(iVar.getContext());
            return false;
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class f implements InterfaceC0859u {

        /* compiled from: BaseBlackListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.getActivity() != null) {
                    i.this.getActivity().finish();
                }
            }
        }

        public f() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            MenuItem findItem;
            C0846g.i("BaseBlackListFragment", "configToolbar showBack:" + z10 + " mToolbar:" + i.this.f27148k);
            if (i.this.f27148k == null) {
                return;
            }
            i.this.f27148k.getMenu().clear();
            Menu menu = i.this.f27148k.getMenu();
            if (z10) {
                i.this.f27148k.setNavigationIcon(X8.g.f4850c);
                i.this.f27148k.setNavigationContentDescription(e.h.f30261a);
                i.this.f27148k.setNavigationOnClickListener(new a());
                i.this.f27148k.setIsTitleCenterStyle(false);
                i.this.f27148k.inflateMenu(s.f27478g);
                i iVar = i.this;
                iVar.f27111A = iVar.f27148k.getMenu().findItem(com.oplus.blacklistapp.p.f27330D);
                e();
                if (i.this.g2() && (findItem = i.this.f27148k.getMenu().findItem(com.oplus.blacklistapp.p.f27380c)) != null) {
                    findItem.setVisible(false);
                }
            } else {
                i.this.getActivity().getMenuInflater().inflate(s.f27475d, menu);
                i.this.f27148k.setIsTitleCenterStyle(true);
                i.this.f27148k.setNavigationIcon((Drawable) null);
                i iVar2 = i.this;
                iVar2.f27112B = iVar2.f27148k.getMenu().findItem(com.oplus.blacklistapp.p.f27327B0);
                d();
            }
            AbstractRunnableC1488a abstractRunnableC1488a = i.this.f27137a;
            if (abstractRunnableC1488a != null && abstractRunnableC1488a.getCount() > 0) {
                f(true);
            } else {
                f(false);
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            a(false);
            i iVar = i.this;
            if (iVar.f27137a != null && iVar.f27149l != null) {
                if (i.this.f27147j != null && i.this.f27137a.getCount() != i.this.f27147j.size()) {
                    i iVar2 = i.this;
                    iVar2.d2(iVar2.f27137a.getCursor());
                }
                i.this.f27137a.h(true);
                i.this.f27149l.i(i.this.f27147j);
                i.this.f27149l.m(i.this.f27146i);
                d();
                i.this.f27137a.notifyDataSetChanged();
                i.this.D2(false);
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            a(true);
            i.this.f27111A.setVisible(true);
            i iVar = i.this;
            if (iVar.f27137a != null && iVar.f27149l != null) {
                i.this.f27137a.h(false);
                i.this.f27137a.notifyDataSetChanged();
                i.this.D2(true);
                if (!i.this.f27153p) {
                    i.this.f27146i.clear();
                    i.this.f27149l.m(i.this.f27146i);
                }
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            TextView m12;
            if (l7.b.k()) {
                i iVar = i.this;
                if (iVar.f27141d != 2) {
                    CustomBlackListActivity customBlackListActivity = (CustomBlackListActivity) iVar.getActivity();
                    if (customBlackListActivity != null && (m12 = customBlackListActivity.m1()) != null) {
                        m12.setText(i.this.f27149l.b());
                    }
                    if (i.this.f27148k != null) {
                        i.this.f27148k.setTitle(i.this.f27149l.b());
                    }
                    g();
                }
            }
            if (i.this.f27148k != null) {
                i.this.f27148k.setTitle(i.this.f27149l.b());
            }
            g();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            i.this.log("updateNormalTitle current mListMode:" + i.this.f27141d);
            if (i.this.f27148k != null) {
                i iVar = i.this;
                if (iVar.f27141d == 1) {
                    iVar.f27148k.setTitle(u.f27499C);
                } else {
                    iVar.f27148k.setTitle(u.f27699u3);
                }
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
            if (i.this.f27111A != null) {
                i.this.f27111A.setVisible(z10);
            }
        }

        public void g() {
            i iVar = i.this;
            if (iVar.f27137a != null && iVar.f27149l != null) {
                int c10 = i.this.f27149l.c();
                int count = i.this.f27137a.getCount();
                if (i.this.f27112B != null) {
                    if (c10 < count) {
                        i.this.f27112B.setTitle(u.f27562R2);
                    } else {
                        i.this.f27112B.setTitle(u.f27644j3);
                    }
                }
            }
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class g implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f27168a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f27169b;

        public g(ArrayList arrayList, Context context) {
            this.f27168a = arrayList;
            this.f27169b = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int intValue = ((Integer) i.this.f27144g.get(((PopupListItem) this.f27168a.get(i10)).getTitle())).intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue == 2) {
                        Intent intent = new Intent(C0855p.f29166a);
                        intent.setPackage(C1629c.f37417c);
                        intent.putExtra("is_from_no_brand_app", F6.c.c());
                        E.a(intent, u.f27499C, this.f27169b.getPackageName());
                        try {
                            i.this.startActivityForResult(intent, 0);
                            i.this.getActivity().overridePendingTransition(com.oplus.blacklistapp.i.f27263e, com.oplus.blacklistapp.i.f27264f);
                        } catch (Exception e10) {
                            Log.e("BaseBlackListFragment", "Exception e = " + e10);
                        }
                    }
                } else if (l7.b.h(i.this.getContext())) {
                    Intent intent2 = new Intent("oplus.intent.action.black_list.edit_first_match");
                    intent2.setPackage(i.this.getContext().getPackageName());
                    intent2.putExtra("blacklist_mode", i.this.f27141d);
                    i.this.f27131U.a(intent2);
                } else {
                    i iVar = i.this;
                    iVar.Q1(iVar.getActivity());
                }
            } else if (l7.b.h(i.this.getContext())) {
                Intent intent3 = new Intent("oplus.intent.action.black_list.edit_number");
                intent3.setPackage(i.this.getContext().getPackageName());
                intent3.putExtra("blacklist_mode", i.this.f27141d);
                i.this.f27130T.a(intent3);
            } else {
                i iVar2 = i.this;
                iVar2.P1(iVar2.getActivity());
            }
            i.this.f27121K.dismiss();
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class h implements S8.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f27171a;

        public h(Context context) {
            this.f27171a = context;
        }

        @Override // S8.i
        public void g() {
            String replace = i.this.f27120J.h().getText().toString().replace(" ", "");
            if (!C0849j.t(replace)) {
                Context context = this.f27171a;
                Toast.makeText(context, context.getResources().getString(u.f27707w1, replace), 0).show();
                i.this.f27120J.g();
                return;
            }
            StatisticsUtils.a(this.f27171a, 2010802, 201080007, null, false);
            if (i.this.f27156x == null || i.this.f27156x.f27175a) {
                i.this.f27156x = new j();
                i.this.f27156x.f27178d = replace;
                i.this.f27156x.i(true);
                i.this.f27156x.execute(new Void[0]);
            }
            i.this.f27120J.g();
        }

        @Override // S8.i
        public void onCancel() {
            i.this.f27120J.g();
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* renamed from: com.oplus.blacklistapp.fragment.i$i, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0244i implements S8.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f27173a;

        public C0244i(Context context) {
            this.f27173a = context;
        }

        @Override // S8.i
        public void g() {
            String replace = i.this.f27120J.h().getText().toString().replace(" ", "");
            if (!C0849j.t(replace)) {
                Context context = this.f27173a;
                Toast.makeText(context, context.getResources().getString(u.f27707w1, replace), 0).show();
                i.this.f27120J.g();
                return;
            }
            StatisticsUtils.a(this.f27173a, 2010802, 201080014, null, false);
            if (i.this.f27157y == null || i.this.f27157y.f27185a) {
                i.this.f27157y = new k();
                i.this.f27157y.f27187c = replace;
                i.this.f27157y.execute(new Void[0]);
            }
            i.this.f27120J.g();
        }

        @Override // S8.i
        public void onCancel() {
            i.this.f27120J.g();
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class j extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f27175a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f27176b;

        /* renamed from: c, reason: collision with root package name */
        public long f27177c;

        /* renamed from: d, reason: collision with root package name */
        public String f27178d;

        /* renamed from: e, reason: collision with root package name */
        public String f27179e;

        /* renamed from: f, reason: collision with root package name */
        public int f27180f;

        /* renamed from: g, reason: collision with root package name */
        public d.e f27181g;

        /* renamed from: h, reason: collision with root package name */
        public Intent f27182h;

        /* compiled from: BaseBlackListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.isAdded()) {
                    i.this.W1();
                    j.this.j(true);
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            int i10 = 0;
            if (this.f27176b) {
                Context context = i.this.getContext();
                if (context != null) {
                    i10 = this.f27181g != null ? C0849j.C(context.getApplicationContext(), this.f27178d, i.this.f27141d, this.f27179e, this.f27180f, this.f27181g) : C0849j.o(context.getApplicationContext(), this.f27178d, i.this.f27141d, this.f27179e, this.f27180f);
                }
            } else {
                i iVar = i.this;
                int[] V12 = iVar.V1(this.f27182h, iVar.f27141d, this.f27180f);
                if (V12 != null) {
                    if (V12[0] == 1) {
                        i10 = 1;
                    } else if (V12[1] == 3) {
                        i10 = 3;
                    }
                }
            }
            i.this.A2();
            return Integer.valueOf(i10);
        }

        @Override // android.os.AsyncTask
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            long currentTimeMillis;
            Handler handler;
            a aVar;
            try {
                try {
                    C0846g.i("BaseBlackListFragment", "reject reason = " + num);
                    int intValue = num.intValue();
                    if (intValue != 1) {
                        if (intValue == 3) {
                            Toast.makeText(i.this.getContext(), u.f27571U, 0).show();
                        }
                    } else {
                        Toast.makeText(i.this.getContext(), u.f27674p3, 0).show();
                    }
                    currentTimeMillis = System.currentTimeMillis() - this.f27177c;
                    handler = i.this.f27155r;
                    aVar = new a();
                } catch (Exception e10) {
                    Log.e("BaseBlackListFragment", "e = " + e10);
                    currentTimeMillis = System.currentTimeMillis() - this.f27177c;
                    handler = i.this.f27155r;
                    aVar = new a();
                }
                handler.postDelayed(aVar, Math.min(1000 - currentTimeMillis, 1000L));
            } catch (Throwable th) {
                i.this.f27155r.postDelayed(new a(), Math.min(1000 - (System.currentTimeMillis() - this.f27177c), 1000L));
                throw th;
            }
        }

        public void i(boolean z10) {
            this.f27176b = z10;
        }

        public void j(boolean z10) {
            this.f27175a = z10;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f27177c = System.currentTimeMillis();
            i iVar = i.this;
            iVar.v2(iVar.getContext());
        }

        public j() {
            this.f27175a = false;
            this.f27176b = false;
            this.f27180f = 0;
            this.f27181g = null;
            this.f27182h = null;
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class k extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f27185a;

        /* renamed from: b, reason: collision with root package name */
        public long f27186b;

        /* renamed from: c, reason: collision with root package name */
        public String f27187c;

        /* renamed from: d, reason: collision with root package name */
        public int f27188d;

        /* renamed from: e, reason: collision with root package name */
        public long f27189e;

        /* compiled from: BaseBlackListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.isAdded()) {
                    i.this.W1();
                    k.this.g(true);
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            if (this.f27189e != -1) {
                C0849j.D(i.this.getContext(), this.f27187c, this.f27188d, this.f27189e);
            } else {
                C0849j.p(i.this.getContext(), this.f27187c, this.f27188d);
            }
            i.this.A2();
            return 0;
        }

        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            C0846g.i("BaseBlackListFragment", "reject reason = " + num);
            i.this.f27155r.postDelayed(new a(), Math.min(1000 - (System.currentTimeMillis() - this.f27186b), 1000L));
        }

        public void g(boolean z10) {
            this.f27185a = z10;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f27186b = System.currentTimeMillis();
            i iVar = i.this;
            iVar.v2(iVar.getContext());
        }

        public k() {
            this.f27185a = false;
            this.f27188d = 0;
            this.f27189e = -1L;
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public static final class l extends AsyncQueryHandler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<i> f27192a;

        public l(i iVar) {
            super(iVar.getContext().getContentResolver());
            this.f27192a = new WeakReference<>(iVar);
        }

        @Override // android.content.AsyncQueryHandler
        public void onDeleteComplete(int i10, Object obj, int i11) {
            i iVar = this.f27192a.get();
            if (iVar != null) {
                iVar.q2();
                iVar.A2();
            }
        }

        @Override // android.content.AsyncQueryHandler
        public void onInsertComplete(int i10, Object obj, Uri uri) {
            i iVar = this.f27192a.get();
            if (iVar == null) {
                return;
            }
            if (uri == null) {
                Toast.makeText(iVar.getContext(), u.f27543N, 0).show();
            }
            iVar.q2();
            iVar.A2();
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i10, Object obj, Cursor cursor) {
            i iVar = this.f27192a.get();
            C0846g.i("BaseBlackListFragment", "onQueryComplete() fragment:" + iVar);
            if (iVar == null) {
                return;
            }
            iVar.U1();
            try {
                iVar.d2(cursor);
                AbstractRunnableC1488a abstractRunnableC1488a = iVar.f27137a;
                boolean z10 = false;
                if (abstractRunnableC1488a != null) {
                    abstractRunnableC1488a.j(false);
                    iVar.f27137a.changeCursor(cursor);
                    iVar.f27137a.notifyDataSetChanged();
                }
                iVar.q2();
                if (cursor != null && !cursor.isClosed()) {
                    int count = cursor.getCount();
                    if (iVar.f27139b != null && iVar.f27140c != null) {
                        if (iVar.f27141d == 1 && iVar.Z1() == 0 && iVar.f27128R.getVisibility() == 0) {
                            iVar.f27139b.setVisibility(0);
                            if (count <= 0) {
                                iVar.f27139b.setAdapter((ListAdapter) iVar.f27137a);
                                iVar.f27139b.setSelection(0);
                            }
                        } else if (count <= 0) {
                            iVar.f27139b.setVisibility(8);
                            iVar.f27139b.setAdapter((ListAdapter) iVar.f27137a);
                            iVar.f27139b.setSelection(0);
                            iVar.f27140c.setVisibility(0);
                        } else {
                            iVar.f27139b.setVisibility(0);
                            iVar.f27140c.setVisibility(8);
                        }
                    }
                    if (iVar.f27138a0 != null) {
                        InterfaceC0859u interfaceC0859u = iVar.f27138a0;
                        if (count > 0) {
                            z10 = true;
                        }
                        interfaceC0859u.f(z10);
                    }
                }
                if (iVar.f27137a != null) {
                    iVar.F2();
                }
            } catch (Exception e10) {
                Log.e("BaseBlackListFragment", "e = " + e10);
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* compiled from: BaseBlackListFragment.java */
    /* loaded from: classes3.dex */
    public class m extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public long f27193a;

        /* compiled from: BaseBlackListFragment.java */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CustomBlackListActivity customBlackListActivity = (CustomBlackListActivity) i.this.getActivity();
                if (customBlackListActivity != null) {
                    customBlackListActivity.r1(false);
                }
            }
        }

        /* compiled from: BaseBlackListFragment.java */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.isAdded()) {
                    i.this.X1();
                    C0861w.g(i.this.getContext()).l();
                    if (i.this.a2() != 1) {
                        Toast.makeText(i.this.getContext(), u.f27510E2, 0).show();
                    } else {
                        Toast.makeText(i.this.getContext(), u.f27506D2, 0).show();
                    }
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            i.this.f27153p = true;
            ArrayList<C0845f> arrayList = new ArrayList<>();
            FragmentActivity activity = i.this.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new a());
            }
            int i10 = 0;
            for (Long l10 : i.this.f27146i.keySet()) {
                l10.longValue();
                C0845f c0845f = (C0845f) i.this.f27146i.get(l10);
                if (c0845f != null) {
                    arrayList.add(c0845f);
                    i10++;
                }
                if (arrayList.size() >= 50 || i10 >= i.this.f27146i.size()) {
                    i iVar = i.this;
                    iVar.f27137a.a(arrayList, iVar.f27141d);
                    arrayList.clear();
                }
            }
            i iVar2 = i.this;
            iVar2.f27137a.a(arrayList, iVar2.f27141d);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r62) {
            i.this.f27153p = false;
            i.this.f27146i.clear();
            i.this.f27155r.postDelayed(new b(), Math.min(1000 - (System.currentTimeMillis() - this.f27193a), 1000L));
            i.this.A2();
            FragmentActivity activity = i.this.getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            AbstractRunnableC1488a abstractRunnableC1488a = i.this.f27137a;
            if (abstractRunnableC1488a != null) {
                abstractRunnableC1488a.l(true);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f27193a = System.currentTimeMillis();
            i iVar = i.this;
            iVar.w2(iVar.getContext());
        }

        public m() {
        }
    }

    private void C2(Configuration configuration) {
        androidx.appcompat.app.b bVar;
        COUIEditText cOUIEditText;
        int i10 = configuration.orientation;
        if (this.f27122L != i10 && (bVar = this.f27123M) != null && bVar.isShowing() && (cOUIEditText = (COUIEditText) this.f27123M.findViewById(com.oplus.blacklistapp.p.f27397k0)) != null) {
            ViewGroup viewGroup = (ViewGroup) cOUIEditText.getParent();
            viewGroup.removeView(cOUIEditText);
            viewGroup.addView(cOUIEditText);
        }
        this.f27122L = i10;
    }

    private void c2() {
        EditModeHandler.Mode mode;
        LayoutInflater from = LayoutInflater.from(getContext());
        MultiChoiceListview multiChoiceListview = (MultiChoiceListview) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27362T);
        this.f27139b = multiChoiceListview;
        multiChoiceListview.setChoiceMode(2);
        this.f27139b.setDivider(null);
        this.f27139b.setVerticalFadingEdgeEnabled(false);
        K.y0(this.f27139b, true);
        this.f27151n = (FrameLayout) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27387f0);
        this.f27150m = (COUINavigationView) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27385e0);
        if (!this.f27117G) {
            this.f27151n.setBackgroundResource(com.oplus.blacklistapp.o.f27323z);
        }
        this.f27118H = getResources().getDimensionPixelOffset(com.oplus.blacklistapp.n.f27278c);
        this.f27119I = getResources().getDimensionPixelOffset(com.oplus.blacklistapp.n.f27276a);
        if (this.f27141d == 2 || Z1() == 1) {
            Space space = new Space(getContext());
            space.setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27290o)));
            this.f27139b.addHeaderView(space);
        }
        if (this.f27141d == 1 && Z1() == 0) {
            View inflate = from.inflate(com.oplus.blacklistapp.r.f27451f, (ViewGroup) null);
            this.f27125O = inflate;
            this.f27139b.addHeaderView(inflate);
            this.f27126P = (TextView) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27421w0);
            this.f27127Q = (COUICardListSelectedItemLayout) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27419v0);
            this.f27128R = (TextView) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27331D0);
            this.f27129S = (COUICardListSelectedItemLayout) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27329C0);
            this.f27127Q.setOnClickListener(new a());
            this.f27129S.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.blacklistapp.fragment.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.this.h2(view);
                }
            });
            C.f().l(getContext(), new b());
            if (l7.b.f34757y) {
                this.f27128R.setVisibility(0);
                this.f27129S.setVisibility(0);
            } else {
                this.f27128R.setVisibility(8);
                this.f27129S.setVisibility(8);
            }
        }
        if (this.f27141d == 1 && Z1() == 1 && l7.b.k()) {
            this.f27137a = new C1491d(getContext(), C0855p.d.f29178a, this.f27141d, Z1(), this);
        } else if (C0844e.f29134b && this.f27141d == 1) {
            this.f27137a = new com.oplus.blacklistapp.d(getContext(), BlockedNumberContract.BlockedNumbers.CONTENT_URI, this.f27141d, Z1(), false, this);
        } else {
            this.f27137a = new com.oplus.blacklistapp.d(getContext(), C0855p.a.f29171a, this.f27141d, Z1(), false, this);
        }
        this.f27145h = new c();
        this.f27139b.setAdapter((ListAdapter) this.f27137a);
        this.f27140c = this.f27142e.findViewById(com.oplus.blacklistapp.p.f27334F);
        TextView textView = (TextView) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27393i0);
        this.f27143f = (ImageView) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27391h0);
        if (this.f27141d == 1) {
            if (l7.b.k()) {
                if (Z1() == 1) {
                    textView.setText(u.f27585X1);
                } else {
                    textView.setText(u.f27573U1);
                }
            } else {
                textView.setText(u.f27577V1);
                x2(u.f27579W);
            }
            this.f27143f.setContentDescription(textView.getText());
            this.f27143f.setImageDrawable(getContext().getDrawable(com.oplus.blacklistapp.o.f27317t));
        } else {
            textView.setText(u.f27589Y1);
            this.f27143f.setImageDrawable(getContext().getDrawable(com.oplus.blacklistapp.o.f27322y));
            this.f27143f.setContentDescription(textView.getText());
            if (l7.b.f34742j) {
                x2(u.f27684r3);
            } else {
                x2(u.f27689s3);
            }
        }
        this.f27139b.setNestedScrollingEnabled(true);
        this.f27139b.setScrollMultiChoiceListener(this);
        this.f27154q = new l(this);
        this.f27155r = new Handler(Looper.getMainLooper());
        if (this.f27149l == null) {
            FragmentActivity activity = getActivity();
            AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
            InterfaceC0859u interfaceC0859u = this.f27138a0;
            B b10 = this.f27145h;
            if (this.f27141d == 1) {
                mode = EditModeHandler.Mode.BLACK_LIST_MODE;
            } else {
                mode = EditModeHandler.Mode.WHITE_LIST_MODE;
            }
            this.f27149l = new EditModeHandler(activity, abstractRunnableC1488a, interfaceC0859u, b10, mode);
        }
        T1();
        U1();
        R1();
        A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        C0846g.i("BaseBlackListFragment", str);
    }

    public static /* synthetic */ boolean n2(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2() {
        CustomBlackListActivity customBlackListActivity;
        AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
        if (abstractRunnableC1488a != null && abstractRunnableC1488a.getCount() == 0 && this.f27137a.f() && (customBlackListActivity = (CustomBlackListActivity) getActivity()) != null) {
            customBlackListActivity.r1(false);
        }
        InterfaceC0859u interfaceC0859u = this.f27138a0;
        if (interfaceC0859u != null) {
            interfaceC0859u.f(true);
        }
    }

    private void s2() {
        COUIEditText h10;
        S8.h hVar = this.f27120J;
        if (hVar != null && (h10 = hVar.h()) != null) {
            h10.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.oplus.blacklistapp.fragment.h
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                    boolean n22;
                    n22 = i.n2(textView, i10, keyEvent);
                    return n22;
                }
            });
        }
    }

    private void t2(boolean z10) {
        int i10;
        MultiChoiceListview multiChoiceListview = this.f27139b;
        if (multiChoiceListview != null) {
            int paddingTop = multiChoiceListview.getPaddingTop();
            if (z10) {
                i10 = this.f27119I;
            } else {
                i10 = this.f27118H;
            }
            multiChoiceListview.setPadding(0, paddingTop, 0, i10);
        }
    }

    public void A2() {
        AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
        if (abstractRunnableC1488a != null) {
            abstractRunnableC1488a.j(false);
        }
        l lVar = this.f27154q;
        if (lVar != null) {
            lVar.cancelOperation(51);
            B2(this.f27154q);
        }
    }

    public abstract void B2(l lVar);

    public final void D2(boolean z10) {
        if (this.f27141d == 1 && Z1() == 0) {
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = this.f27127Q;
            if (cOUICardListSelectedItemLayout != null) {
                cOUICardListSelectedItemLayout.setEnabled(z10);
            }
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout2 = this.f27129S;
            if (cOUICardListSelectedItemLayout2 != null) {
                cOUICardListSelectedItemLayout2.setEnabled(z10);
            }
        }
    }

    public void E2(boolean z10) {
        FrameLayout frameLayout = this.f27151n;
        if (frameLayout != null) {
            if (z10) {
                frameLayout.setVisibility(0);
            } else {
                frameLayout.setVisibility(8);
            }
        }
    }

    public final void F2() {
        ConcurrentHashMap<Long, C0845f> concurrentHashMap;
        boolean z10;
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler != null && editModeHandler.d() && this.f27147j != null && (concurrentHashMap = this.f27146i) != null && this.f27137a != null) {
            for (Long l10 : concurrentHashMap.keySet()) {
                l10.longValue();
                if (!this.f27147j.containsKey(l10)) {
                    this.f27146i.remove(l10);
                }
            }
            this.f27137a.k(this.f27146i);
            EditModeHandler editModeHandler2 = this.f27149l;
            if (editModeHandler2 != null && this.f27138a0 != null) {
                editModeHandler2.i(this.f27147j);
                this.f27149l.m(this.f27146i);
                this.f27138a0.d();
            }
            MenuItem menuItem = this.f27152o;
            if (menuItem != null) {
                if (this.f27146i.size() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    public void P1(Context context) {
        androidx.appcompat.app.b m10 = this.f27120J.m(context, com.oplus.blacklistapp.r.f27456k, new h(context), getString(u.f27595a), null, getString(u.f27716y0), getString(u.f27550O2));
        this.f27123M = m10;
        this.f27120J.i(m10, true, context.getString(u.f27662n1));
        s2();
    }

    public void Q1(Context context) {
        if (context == null) {
            return;
        }
        androidx.appcompat.app.b m10 = this.f27120J.m(context, com.oplus.blacklistapp.r.f27456k, new C0244i(context), getString(u.f27688s2), getString(u.f27683r2), getString(u.f27716y0), getString(u.f27550O2));
        this.f27123M = m10;
        this.f27120J.i(m10, true, getString(u.f27678q2));
        s2();
    }

    public void R1() {
        int i10;
        FragmentActivity activity = getActivity();
        if (activity instanceof CustomBlackListActivity) {
            i10 = ((CustomBlackListActivity) activity).n1();
        } else {
            i10 = 0;
        }
        this.f27113C = i10;
        C0846g.i("BaseBlackListFragment", "appBarOnGlobalLayout mListView:" + this.f27139b + " padding:" + this.f27113C);
        MultiChoiceListview multiChoiceListview = this.f27139b;
        if (multiChoiceListview != null) {
            multiChoiceListview.setPadding(0, i10, 0, getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27278c));
            this.f27139b.setClipToPadding(false);
            this.f27139b.smoothScrollByOffset(-i10);
        }
    }

    public void S1() {
        B b10 = this.f27145h;
        if (b10 != null) {
            b10.a();
        }
    }

    public final void T1() {
        boolean z10;
        this.f27150m.inflateMenu(s.f27474c);
        MenuItem findItem = this.f27150m.getMenu().findItem(com.oplus.blacklistapp.p.f27422x);
        this.f27152o = findItem;
        if (findItem != null) {
            if (this.f27146i.size() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            findItem.setEnabled(z10);
        }
        this.f27150m.setOnNavigationItemSelectedListener(new e());
    }

    public void U1() {
        FragmentActivity activity = getActivity();
        if ((activity instanceof CustomBlackListActivity) && Z1() == ((CustomBlackListActivity) activity).k1() && this.f27138a0 != null) {
            AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
            boolean z10 = true;
            if (abstractRunnableC1488a != null) {
                z10 = true ^ abstractRunnableC1488a.f();
            }
            this.f27138a0.a(z10);
        }
    }

    public final int[] V1(Intent intent, int i10, int i11) {
        ArrayList<H6.a> arrayList;
        ContentResolver contentResolver;
        j jVar;
        V6.a aVar;
        try {
            arrayList = F6.c.a(intent);
        } catch (Exception e10) {
            Log.e("BaseBlackListFragment", "Exception in getParcelableArrayListExtra: " + e10);
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        char c10 = 0;
        StatisticsUtils.a(getContext(), 2010802, 201080008, null, false);
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        int[] iArr = {0, 0};
        ArrayList arrayList3 = new ArrayList();
        for (int i12 = 0; i12 < arrayList.size() && ((jVar = this.f27156x) == null || !jVar.f27175a); i12++) {
            H6.a aVar2 = arrayList.get(i12);
            long id = aVar2.getId();
            String a10 = aVar2.a();
            if (a10 != null) {
                a10 = a10.replace(" ", "");
            }
            if (!TextUtils.isEmpty(a10)) {
                if (this.f27141d == 1) {
                    Context context = getContext();
                    if (context != null) {
                        aVar = C0849j.g(context, a10, id);
                        if (aVar != null && aVar.f4024o) {
                            iArr[c10] = 1;
                        } else if (C0849j.r(context, a10)) {
                            iArr[1] = 3;
                        }
                    }
                } else {
                    aVar = null;
                }
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(C0855p.a.f29171a);
                ContentValues contentValues = new ContentValues(4);
                if (aVar != null && !TextUtils.isEmpty(aVar.f4012c)) {
                    contentValues.put("name", aVar.f4012c);
                }
                contentValues.put(OplusNumberMarkUtils.OplusBlacklist.CONTACTID, Long.valueOf(id));
                if (this.f27141d == 1) {
                    contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 3);
                    c10 = 0;
                } else {
                    c10 = 0;
                    contentValues.put(OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE, (Integer) 0);
                }
                contentValues.put("number", a10);
                contentValues.put(OplusNumberMarkUtils.OplusBlacklist.LIST_TYPE, Integer.valueOf(i10));
                contentValues.put("function_type", Integer.valueOf(i11));
                newInsert.withValues(contentValues);
                arrayList2.add(newInsert.build());
                arrayList3.add(a10);
            }
        }
        if (arrayList2.size() > 0) {
            try {
                C0846g.i("BaseBlackListFragment", "mListMode: " + this.f27141d + " operationsList.size(): " + arrayList2.size());
                if (getContext() != null && (contentResolver = getContext().getContentResolver()) != null) {
                    contentResolver.applyBatch(com.oplus.blacklist.database.a.f26232a, arrayList2);
                }
                arrayList2.clear();
            } catch (Exception e11) {
                Log.e("BaseBlackListFragment", "batch insert blacklist failed." + e11);
            }
        }
        if (arrayList3.size() > 0) {
            if (this.f27141d == 1) {
                C0849j.x(getContext(), arrayList3, true, false, false, i11);
            } else {
                C0849j.x(getContext(), arrayList3, false, true, false, 0);
            }
        }
        return iArr;
    }

    public void W1() {
        Dialog dialog = this.f27115E;
        if (dialog != null) {
            dialog.dismiss();
            this.f27115E = null;
        }
    }

    public void X1() {
        Dialog dialog = this.f27116F;
        if (dialog != null) {
            dialog.dismiss();
            this.f27116F = null;
        }
    }

    public void Y1() {
        boolean z10 = true;
        E2(true);
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler != null) {
            editModeHandler.a();
        }
        t2(true);
        MenuItem menuItem = this.f27152o;
        if (menuItem != null) {
            if (this.f27146i.size() <= 0) {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
    }

    public abstract int Z1();

    public int a2() {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.getIntent() != null && F6.a.r(activity.getIntent().getAction())) {
            return 2;
        }
        return 1;
    }

    public ListView b2() {
        return this.f27139b;
    }

    public final void d2(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    this.f27147j.clear();
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        C0845f b10 = this.f27137a.b(cursor);
                        if (b10 != null) {
                            this.f27147j.put(Long.valueOf(b10.f29136a), b10);
                        }
                    }
                }
            } catch (Exception unused) {
                if (cursor == null) {
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.moveToPosition(-1);
                }
                throw th;
            }
        }
        if (cursor == null) {
            return;
        }
        cursor.moveToPosition(-1);
    }

    public final void e2(final Context context) {
        if (context == null) {
            return;
        }
        this.f27130T = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.blacklistapp.fragment.a
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.this.i2(context, (ActivityResult) obj);
            }
        });
        this.f27133W = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.blacklistapp.fragment.b
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.this.j2(context, (ActivityResult) obj);
            }
        });
        this.f27131U = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.blacklistapp.fragment.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.this.k2(context, (ActivityResult) obj);
            }
        });
        this.f27134X = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.blacklistapp.fragment.d
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.this.l2(context, (ActivityResult) obj);
            }
        });
        this.f27132V = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.blacklistapp.fragment.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.this.m2((ActivityResult) obj);
            }
        });
    }

    public boolean f2() {
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler != null) {
            return editModeHandler.d();
        }
        return false;
    }

    public boolean g2() {
        if (!l7.b.k()) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (!(activity instanceof CustomBlackListActivity) || ((CustomBlackListActivity) activity).k1() != 1 || Z1() != 1) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void h2(View view) {
        Intent intent = new Intent("com.oplus.mms.intent.SHOP_BLACKLIST");
        intent.setPackage("com.android.mms");
        C0849j.A(getActivity(), intent);
    }

    public final /* synthetic */ void i2(Context context, ActivityResult activityResult) {
        if (activityResult.d() != -1) {
            return;
        }
        String stringExtra = activityResult.b().getStringExtra("edit_number");
        String stringExtra2 = activityResult.b().getStringExtra("edit_note");
        int intExtra = activityResult.b().getIntExtra("edit_function", 0);
        if (!C0849j.t(stringExtra)) {
            Toast.makeText(context, context.getResources().getString(u.f27707w1, stringExtra), 0).show();
            return;
        }
        StatisticsUtils.a(context, 2010802, 201080007, null, false);
        j jVar = this.f27156x;
        if (jVar == null || jVar.f27175a) {
            j jVar2 = new j();
            this.f27156x = jVar2;
            jVar2.f27178d = stringExtra;
            this.f27156x.f27179e = stringExtra2;
            this.f27156x.f27180f = intExtra;
            this.f27156x.i(true);
            this.f27156x.execute(new Void[0]);
        }
    }

    public final /* synthetic */ void j2(Context context, ActivityResult activityResult) {
        if (activityResult.d() != -1) {
            return;
        }
        String stringExtra = activityResult.b().getStringExtra("edit_number");
        String stringExtra2 = activityResult.b().getStringExtra("edit_note");
        int intExtra = activityResult.b().getIntExtra("edit_function", 0);
        if (!C0849j.t(stringExtra)) {
            Toast.makeText(context, context.getResources().getString(u.f27707w1, stringExtra), 0).show();
            return;
        }
        j jVar = this.f27156x;
        if (jVar == null || jVar.f27175a) {
            j jVar2 = new j();
            this.f27156x = jVar2;
            jVar2.f27178d = stringExtra;
            this.f27156x.f27179e = stringExtra2;
            this.f27156x.f27180f = intExtra;
            this.f27156x.f27181g = this.f27135Y;
            this.f27156x.i(true);
            this.f27156x.execute(new Void[0]);
        }
    }

    public final /* synthetic */ void k2(Context context, ActivityResult activityResult) {
        if (activityResult.d() != -1) {
            return;
        }
        String stringExtra = activityResult.b().getStringExtra("edit_number");
        int intExtra = activityResult.b().getIntExtra("edit_function", 0);
        if (!C0849j.t(stringExtra)) {
            Toast.makeText(context, context.getResources().getString(u.f27707w1, stringExtra), 0).show();
            return;
        }
        StatisticsUtils.a(context, 2010802, 201080014, null, false);
        k kVar = this.f27157y;
        if (kVar == null || kVar.f27185a) {
            k kVar2 = new k();
            this.f27157y = kVar2;
            kVar2.f27187c = stringExtra;
            this.f27157y.f27188d = intExtra;
            this.f27157y.execute(new Void[0]);
        }
    }

    public final /* synthetic */ void l2(Context context, ActivityResult activityResult) {
        if (activityResult.d() != -1) {
            return;
        }
        String stringExtra = activityResult.b().getStringExtra("edit_number");
        int intExtra = activityResult.b().getIntExtra("edit_function", 0);
        if (!C0849j.t(stringExtra)) {
            Toast.makeText(context, context.getResources().getString(u.f27707w1, stringExtra), 0).show();
            return;
        }
        k kVar = this.f27157y;
        if (kVar == null || kVar.f27185a) {
            k kVar2 = new k();
            this.f27157y = kVar2;
            kVar2.f27189e = this.f27136Z;
            this.f27157y.f27187c = stringExtra;
            this.f27157y.f27188d = intExtra;
            this.f27157y.execute(new Void[0]);
        }
    }

    public final /* synthetic */ void m2(ActivityResult activityResult) {
        if (activityResult.d() != -1) {
            return;
        }
        int intExtra = activityResult.b().getIntExtra("edit_function", 0);
        j jVar = this.f27156x;
        if (jVar == null || jVar.f27175a) {
            j jVar2 = new j();
            this.f27156x = jVar2;
            jVar2.f27182h = this.f27158z;
            this.f27156x.f27180f = intExtra;
            this.f27156x.execute(new Void[0]);
        }
    }

    public final /* synthetic */ void o2(DialogInterface dialogInterface, int i10) {
        if (i10 == -3) {
            new m().execute(new Void[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        FragmentActivity activity;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0 && i11 == -1 && (activity = getActivity()) != null && !activity.isFinishing()) {
            this.f27158z = intent;
            if (l7.b.h(getContext())) {
                Intent intent2 = new Intent("oplus.intent.action.black_list.edit_function");
                intent2.setPackage(getContext().getPackageName());
                intent2.putExtra("blacklist_mode", this.f27141d);
                this.f27132V.a(intent2);
                return;
            }
            j jVar = this.f27156x;
            if (jVar == null || jVar.f27175a) {
                j jVar2 = new j();
                this.f27156x = jVar2;
                jVar2.f27182h = intent;
                this.f27156x.execute(new Void[0]);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        C0846g.i("BaseBlackListFragment", "onAttach " + this);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C2(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f27117G = C6.a.c(getContext());
        this.f27141d = a2();
        this.f27120J = new S8.h();
        C0846g.i("BaseBlackListFragment", "onCreate mListMode:" + this.f27141d);
        CustomBlackListActivity customBlackListActivity = (CustomBlackListActivity) getActivity();
        this.f27122L = getContext().getResources().getConfiguration().orientation;
        if (customBlackListActivity != null) {
            this.f27148k = customBlackListActivity.getToolbar();
        }
        e2(getContext());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0846g.i("BaseBlackListFragment", "onCreateView");
        this.f27142e = layoutInflater.inflate(com.oplus.blacklistapp.r.f27433E, viewGroup, false);
        c2();
        return this.f27142e;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.b bVar = this.f27114D;
        if (bVar != null) {
            bVar.dismiss();
            this.f27114D = null;
        }
        COUIPopupListWindow cOUIPopupListWindow = this.f27121K;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.dismiss();
            this.f27121K = null;
        }
        X1();
        W1();
        this.f27120J.g();
        AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
        if (abstractRunnableC1488a != null) {
            abstractRunnableC1488a.d();
        }
        j jVar = this.f27156x;
        if (jVar != null) {
            jVar.j(true);
        }
        k kVar = this.f27157y;
        if (kVar != null) {
            kVar.g(true);
        }
        AbstractRunnableC1488a abstractRunnableC1488a2 = this.f27137a;
        if (abstractRunnableC1488a2 != null) {
            abstractRunnableC1488a2.c();
            this.f27137a.m();
            Cursor cursor = this.f27137a.getCursor();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        Handler handler = this.f27155r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        C0846g.i("BaseBlackListFragment", "onDetach " + this);
    }

    @Override // S8.o
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        d.e eVar;
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler != null && editModeHandler.d()) {
            CheckBox checkBox = (CheckBox) view.findViewById(com.oplus.blacklistapp.p.f27370X);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(com.oplus.blacklistapp.p.f27364U);
            if (checkBox == null) {
                return;
            }
            boolean z10 = true;
            boolean z11 = !checkBox.isChecked();
            checkBox.setChecked(z11);
            Cursor cursor = this.f27137a.getCursor();
            cursor.moveToPosition(i10);
            C0845f b10 = this.f27137a.b(cursor);
            if (b10 != null) {
                if (this.f27146i.containsKey(Long.valueOf(b10.f29136a))) {
                    this.f27146i.remove(Long.valueOf(b10.f29136a));
                } else {
                    this.f27146i.put(Long.valueOf(b10.f29136a), b10);
                }
            }
            cOUICardListSelectedItemLayout.setIsSelected(z11);
            this.f27137a.k(this.f27146i);
            EditModeHandler editModeHandler2 = this.f27149l;
            if (editModeHandler2 != null) {
                editModeHandler2.m(this.f27146i);
                this.f27138a0.d();
            }
            MenuItem menuItem = this.f27152o;
            if (menuItem != null) {
                if (this.f27146i.size() <= 0) {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
                return;
            }
            return;
        }
        if (l7.b.h(getContext()) && (eVar = (d.e) view.getTag()) != null) {
            if ("3".equals(eVar.f27059b)) {
                Intent intent = new Intent("oplus.intent.action.black_list.edit_first_match");
                intent.setPackage(getContext().getPackageName());
                intent.putExtra("blacklist_mode", this.f27141d);
                intent.putExtra("edit_number", eVar.f27058a);
                intent.putExtra("edit_function", eVar.f27061d);
                this.f27136Z = eVar.f27062e;
                this.f27134X.a(intent);
                return;
            }
            Intent intent2 = new Intent("oplus.intent.action.black_list.edit_number");
            intent2.setPackage(getContext().getPackageName());
            intent2.putExtra("edit_number", eVar.f27058a);
            intent2.putExtra("edit_note", eVar.f27060c);
            intent2.putExtra("edit_function", eVar.f27061d);
            intent2.putExtra("blacklist_mode", this.f27141d);
            this.f27135Y = eVar;
            this.f27133W.a(intent2);
        }
    }

    @Override // S8.o
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler != null && editModeHandler.d()) {
            return false;
        }
        Cursor cursor = this.f27137a.getCursor();
        cursor.moveToPosition(i10);
        C0845f b10 = this.f27137a.b(cursor);
        if (b10 != null) {
            this.f27146i.put(Long.valueOf(b10.f29136a), b10);
            this.f27137a.k(this.f27146i);
        }
        CustomBlackListActivity customBlackListActivity = (CustomBlackListActivity) getActivity();
        if (customBlackListActivity != null) {
            customBlackListActivity.j1();
            return true;
        }
        return true;
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        if (view != null && this.f27137a.f()) {
            CheckBox checkBox = (CheckBox) view.findViewById(com.oplus.blacklistapp.p.f27370X);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(com.oplus.blacklistapp.p.f27364U);
            if (checkBox == null) {
                return;
            }
            boolean z10 = true;
            boolean z11 = !checkBox.isChecked();
            checkBox.setChecked(z11);
            cOUICardListSelectedItemLayout.setChecked(z11);
            int headerViewsCount = i10 - this.f27139b.getHeaderViewsCount();
            Cursor cursor = this.f27137a.getCursor();
            cursor.moveToPosition(headerViewsCount);
            C0845f b10 = this.f27137a.b(cursor);
            if (b10 != null) {
                if (this.f27146i.containsKey(Long.valueOf(b10.f29136a))) {
                    this.f27146i.remove(Long.valueOf(b10.f29136a));
                } else {
                    this.f27146i.put(Long.valueOf(b10.f29136a), b10);
                }
            }
            EditModeHandler editModeHandler = this.f27149l;
            if (editModeHandler != null) {
                editModeHandler.m(this.f27146i);
                this.f27138a0.d();
            }
            MenuItem menuItem = this.f27152o;
            if (menuItem != null) {
                if (this.f27146i.size() <= 0) {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
        if (abstractRunnableC1488a != null) {
            abstractRunnableC1488a.m();
        }
        if (this.f27124N != null) {
            getContext().getContentResolver().unregisterContentObserver(this.f27124N);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        boolean z10;
        super.onResume();
        if (this.f27137a != null) {
            int checkSelfPermission = getContext().checkSelfPermission("android.permission.READ_CONTACTS");
            AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
            if (checkSelfPermission == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            abstractRunnableC1488a.i(z10);
            this.f27137a.d();
        }
        G.f29042a.h();
        A2();
        Uri withAppendedPath = Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, OplusNumberMarkUtils.OplusBlacklist.BLACKLIST_TABLE);
        this.f27124N = new d(this.f27155r);
        getContext().getContentResolver().registerContentObserver(withAppendedPath, true, this.f27124N);
        AbstractRunnableC1488a abstractRunnableC1488a2 = this.f27137a;
        if (abstractRunnableC1488a2 != null) {
            abstractRunnableC1488a2.g();
            Iterator<C0845f> it = this.f27137a.e().keySet().iterator();
            while (it.hasNext()) {
                if (!C0849j.q(getContext(), it.next().f29138c)) {
                    it.remove();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AbstractRunnableC1488a abstractRunnableC1488a = this.f27137a;
        if (abstractRunnableC1488a != null) {
            abstractRunnableC1488a.m();
        }
    }

    public void p2() {
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler == null || !editModeHandler.d()) {
            return;
        }
        boolean z10 = false;
        E2(false);
        this.f27149l.e();
        t2(false);
        MenuItem menuItem = this.f27152o;
        if (menuItem != null) {
            if (this.f27146i.size() > 0) {
                z10 = true;
            }
            menuItem.setEnabled(z10);
        }
    }

    public void r2() {
        EditModeHandler editModeHandler = this.f27149l;
        if (editModeHandler != null) {
            editModeHandler.f();
        }
    }

    public void u2(COUIToolbar cOUIToolbar) {
        this.f27148k = cOUIToolbar;
    }

    public void v2(Context context) {
        String string;
        if (context == null) {
            return;
        }
        W1();
        if (this.f27141d == 1) {
            string = getString(u.f27625g);
        } else {
            string = getString(u.f27630h);
        }
        this.f27115E = com.oplus.utils.r.b(context, string);
    }

    public void w2(Context context) {
        String string;
        if (context == null) {
            return;
        }
        X1();
        if (this.f27141d == 1) {
            string = getString(u.f27514F2);
        } else {
            string = getString(u.f27518G2);
        }
        this.f27116F = com.oplus.utils.r.b(context, string);
    }

    public final void x2(int i10) {
        TextView textView = (TextView) this.f27142e.findViewById(com.oplus.blacklistapp.p.f27395j0);
        textView.setText(i10);
        textView.setVisibility(0);
    }

    public void y2(Context context) {
        this.f27121K = new COUIPopupListWindow(context);
        Resources resources = context.getResources();
        int i10 = u.f27564S0;
        String string = resources.getString(i10);
        Resources resources2 = context.getResources();
        int i11 = u.f27688s2;
        String string2 = resources2.getString(i11);
        Resources resources3 = context.getResources();
        int i12 = u.f27572U0;
        String string3 = resources3.getString(i12);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new PopupListItem((Drawable) null, string, true));
        if (!C0844e.f29134b && this.f27141d == 1) {
            arrayList.add(new PopupListItem((Drawable) null, string2, true));
        }
        arrayList.add(new PopupListItem((Drawable) null, string3, true));
        this.f27121K.setItemList(arrayList);
        if (this.f27144g == null) {
            this.f27144g = new HashMap<>(3);
        }
        this.f27144g.put(context.getResources().getString(i10), 0);
        this.f27144g.put(context.getResources().getString(i11), 1);
        this.f27144g.put(context.getResources().getString(i12), 2);
        this.f27121K.setOnItemClickListener(new g(arrayList, context));
        this.f27121K.setOutsideTouchable(true);
        this.f27121K.show(getActivity().findViewById(com.oplus.blacklistapp.p.f27380c));
    }

    public void z2(Context context) {
        String format;
        if (context == null) {
            return;
        }
        androidx.appcompat.app.b bVar = this.f27114D;
        if (bVar != null) {
            bVar.dismiss();
            this.f27114D = null;
        }
        if (this.f27141d == 1) {
            format = String.format(getResources().getQuantityString(t.f27486h, this.f27146i.size()), Integer.valueOf(this.f27146i.size()));
        } else {
            format = String.format(getResources().getQuantityString(t.f27490l, this.f27146i.size()), Integer.valueOf(this.f27146i.size()));
        }
        COUIAlertDialogBuilder neutralButton = new S8.b(context, X8.n.f5032d).setTitle((CharSequence) format).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(u.f27498B2, new DialogInterface.OnClickListener() { // from class: com.oplus.blacklistapp.fragment.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                i.this.o2(dialogInterface, i10);
            }
        });
        androidx.appcompat.app.b create = neutralButton.create();
        this.f27114D = create;
        create.show();
        neutralButton.updateViewAfterShown();
    }
}
