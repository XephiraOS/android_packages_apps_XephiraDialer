package com.oplus.blacklistapp.activities;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.rotateview.COUIRotateView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.PhoneNoInquireActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.o;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.t;
import com.oplus.blacklistapp.u;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import com.oplus.utils.C0861w;
import com.oplus.utils.C0863y;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.N;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.utils.Z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import v6.C1632f;

/* loaded from: classes3.dex */
public class PhoneNoInquireActivity extends BaseNavigationActivity implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener, CallInterceptController.b, View.OnClickListener {

    /* renamed from: P, reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f26388P;

    /* renamed from: Q, reason: collision with root package name */
    public static final ThreadPoolExecutor f26389Q;

    /* renamed from: A, reason: collision with root package name */
    public COUIToolbar f26390A;

    /* renamed from: C, reason: collision with root package name */
    public AppBarLayout f26392C;

    /* renamed from: D, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26393D;

    /* renamed from: E, reason: collision with root package name */
    public MenuItem f26394E;

    /* renamed from: F, reason: collision with root package name */
    public MenuItem f26395F;

    /* renamed from: G, reason: collision with root package name */
    public MenuItem f26396G;

    /* renamed from: H, reason: collision with root package name */
    public COUISwitch f26397H;

    /* renamed from: I, reason: collision with root package name */
    public COUICardListSelectedItemLayout f26398I;

    /* renamed from: L, reason: collision with root package name */
    public COUIAlertDialogBuilder f26401L;

    /* renamed from: r, reason: collision with root package name */
    public ExpandableListView f26410r;

    /* renamed from: x, reason: collision with root package name */
    public h f26411x;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<N.b> f26405m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    public View f26406n = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f26407o = false;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem f26408p = null;

    /* renamed from: q, reason: collision with root package name */
    public k f26409q = new k();

    /* renamed from: y, reason: collision with root package name */
    public int f26412y = 0;

    /* renamed from: z, reason: collision with root package name */
    public int f26413z = 0;

    /* renamed from: B, reason: collision with root package name */
    public boolean f26391B = false;

    /* renamed from: J, reason: collision with root package name */
    public ContentObserver f26399J = null;

    /* renamed from: K, reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f26400K = null;

    /* renamed from: M, reason: collision with root package name */
    public final Handler f26402M = new a(Looper.getMainLooper());

    /* renamed from: N, reason: collision with root package name */
    public final Handler f26403N = new i();

    /* renamed from: O, reason: collision with root package name */
    public final InterfaceC0859u f26404O = new f();

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (101 == message.what) {
                C0849j.z(PhoneNoInquireActivity.this);
                return;
            }
            Log.w("PhoneNoInquireActivity", "Message not expected: " + message.what);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PhoneNoInquireActivity.this.f26392C.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = PhoneNoInquireActivity.this.f26392C.getMeasuredHeight() + PhoneNoInquireActivity.this.getResources().getDimensionPixelSize(n.f27290o);
            PhoneNoInquireActivity.this.f26410r.setPadding(0, measuredHeight, 0, PhoneNoInquireActivity.this.getResources().getDimensionPixelSize(n.f27278c));
            PhoneNoInquireActivity.this.f26410r.setClipToPadding(false);
            PhoneNoInquireActivity.this.f26410r.smoothScrollByOffset(-measuredHeight);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends DataSetObserver {
        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            if (PhoneNoInquireActivity.this.n0()) {
                PhoneNoInquireActivity.this.f26404O.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            PhoneNoInquireActivity.this.R1();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            N.d(PhoneNoInquireActivity.this);
            N.i(PhoneNoInquireActivity.this);
            PhoneNoInquireActivity.this.f26403N.sendEmptyMessage(0);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements InterfaceC0859u {
        public f() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            PhoneNoInquireActivity.this.f26390A.getMenu().clear();
            if (z10) {
                PhoneNoInquireActivity.this.f26390A.setNavigationIcon(X8.g.f4850c);
                PhoneNoInquireActivity.this.f26390A.setNavigationContentDescription(e.h.f30261a);
                PhoneNoInquireActivity.this.f26390A.setNavigationOnClickListener(new View.OnClickListener() { // from class: p6.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PhoneNoInquireActivity.f.this.h(view);
                    }
                });
                PhoneNoInquireActivity.this.f26390A.setIsTitleCenterStyle(false);
                PhoneNoInquireActivity.this.f26390A.inflateMenu(s.f27478g);
                PhoneNoInquireActivity phoneNoInquireActivity = PhoneNoInquireActivity.this;
                phoneNoInquireActivity.f26394E = phoneNoInquireActivity.f26390A.getMenu().findItem(p.f27330D);
                PhoneNoInquireActivity phoneNoInquireActivity2 = PhoneNoInquireActivity.this;
                phoneNoInquireActivity2.f26396G = phoneNoInquireActivity2.f26390A.getMenu().findItem(p.f27380c);
                e();
                return;
            }
            PhoneNoInquireActivity.this.getMenuInflater().inflate(s.f27475d, PhoneNoInquireActivity.this.f26390A.getMenu());
            PhoneNoInquireActivity.this.f26390A.setIsTitleCenterStyle(true);
            PhoneNoInquireActivity.this.f26390A.setNavigationIcon((Drawable) null);
            PhoneNoInquireActivity phoneNoInquireActivity3 = PhoneNoInquireActivity.this;
            phoneNoInquireActivity3.f26395F = phoneNoInquireActivity3.f26390A.getMenu().findItem(p.f27327B0);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            PhoneNoInquireActivity.this.f26391B = true;
            a(false);
            PhoneNoInquireActivity.this.f26407o = true;
            N.b();
            PhoneNoInquireActivity.this.f26411x.notifyDataSetChanged();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            PhoneNoInquireActivity.this.f26391B = false;
            a(true);
            PhoneNoInquireActivity.this.f26394E.setVisible(true);
            PhoneNoInquireActivity.this.f26396G.setVisible(true);
            N.b();
            N.n(PhoneNoInquireActivity.this.f26405m);
            PhoneNoInquireActivity phoneNoInquireActivity = PhoneNoInquireActivity.this;
            phoneNoInquireActivity.f26407o = true;
            phoneNoInquireActivity.f26411x.notifyDataSetChanged();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            if (PhoneNoInquireActivity.this.f26390A != null) {
                COUIToolbar cOUIToolbar = PhoneNoInquireActivity.this.f26390A;
                PhoneNoInquireActivity phoneNoInquireActivity = PhoneNoInquireActivity.this;
                cOUIToolbar.setTitle(phoneNoInquireActivity.F1(phoneNoInquireActivity.D1()));
            }
            i();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            if (PhoneNoInquireActivity.this.f26390A != null) {
                PhoneNoInquireActivity.this.f26390A.setTitle(u.f27667o1);
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
            if (PhoneNoInquireActivity.this.f26394E != null) {
                PhoneNoInquireActivity.this.f26394E.setVisible(z10);
            }
            if (PhoneNoInquireActivity.this.f26396G != null) {
                PhoneNoInquireActivity.this.f26396G.setVisible(z10);
            }
        }

        public final /* synthetic */ void h(View view) {
            PhoneNoInquireActivity.this.finish();
        }

        public void i() {
            int[] C12 = PhoneNoInquireActivity.this.C1();
            boolean z10 = false;
            if (C12[0] == C12[1]) {
                PhoneNoInquireActivity.this.f26395F.setTitle(u.f27644j3);
            } else {
                PhoneNoInquireActivity.this.f26395F.setTitle(u.f27562R2);
            }
            MenuItem menuItem = PhoneNoInquireActivity.this.f26408p;
            if (menuItem != null) {
                if (C12[0] > 0) {
                    z10 = true;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final int f26420a;

        public g(int i10) {
            this.f26420a = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -3) {
                new j().execute(new Void[0]);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PhoneNoInquireActivity.this.removeDialog(this.f26420a);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BaseExpandableListAdapter {

        /* renamed from: a, reason: collision with root package name */
        public Context f26422a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f26423b;

        public h(Context context) {
            this.f26422a = context;
            this.f26423b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public final /* synthetic */ void b(N.b bVar, View view) {
            bVar.h();
            PhoneNoInquireActivity.this.f26404O.d();
            PhoneNoInquireActivity.this.f26411x.notifyDataSetChanged();
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i10, int i11) {
            return PhoneNoInquireActivity.this.f26405m.get(i10).f29069d.get(i11);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i10, int i11) {
            return i11;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i10, int i11, boolean z10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f26423b.inflate(r.f27461p, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(p.f27382d);
            N.a aVar = (N.a) getChild(i10, i11);
            textView.setText(aVar.f29072b);
            textView.setEnabled(PhoneNoInquireActivity.this.f26397H.isChecked());
            CheckBox checkBox = (CheckBox) view.findViewById(p.f27402n);
            if (PhoneNoInquireActivity.this.n0()) {
                if (PhoneNoInquireActivity.this.f26407o) {
                    if (checkBox.getVisibility() != 0) {
                        if (BlackListAppUtil.f26245b) {
                            AnimationAnimationListenerC0842c.j(this.f26422a, null, 0).r(false, PhoneNoInquireActivity.this.f26409q, checkBox);
                        } else {
                            AnimationAnimationListenerC0842c.l(this.f26422a, null, 0).r(false, PhoneNoInquireActivity.this.f26409q, checkBox);
                        }
                    }
                } else {
                    checkBox.clearAnimation();
                    checkBox.setVisibility(0);
                    checkBox.setAlpha(1.0f);
                }
                checkBox.setChecked(aVar.f29073c);
                Z.a(view, aVar.f29073c);
            } else {
                if (PhoneNoInquireActivity.this.f26407o) {
                    if (BlackListAppUtil.f26245b) {
                        if (checkBox.getVisibility() == 0) {
                            AnimationAnimationListenerC0842c.k(this.f26422a, null, 8).r(false, new k(checkBox), checkBox);
                        }
                    } else if (checkBox.getVisibility() == 0) {
                        AnimationAnimationListenerC0842c.m(this.f26422a, null, 8).r(false, new k(checkBox), checkBox);
                    }
                } else {
                    checkBox.clearAnimation();
                    checkBox.setVisibility(8);
                }
                Z.a(view, false);
            }
            view.setTag(aVar);
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i10) {
            return PhoneNoInquireActivity.this.f26405m.get(i10).f29069d.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i10) {
            return PhoneNoInquireActivity.this.f26405m.get(i10);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return PhoneNoInquireActivity.this.f26405m.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public int getGroupType(int i10) {
            return 0;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public int getGroupTypeCount() {
            return 2;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup) {
            View view2;
            boolean z11 = true;
            if (view == null) {
                view2 = this.f26423b.inflate(r.f27463r, (ViewGroup) null);
            } else {
                view2 = view;
            }
            COUIRotateView cOUIRotateView = (COUIRotateView) view2.findViewById(p.f27328C);
            TextView textView = (TextView) view2.findViewById(p.f27415t0);
            TextView textView2 = (TextView) view2.findViewById(p.f27426z);
            TextView textView3 = (TextView) view2.findViewById(p.f27407p0);
            final N.b bVar = (N.b) getGroup(i10);
            if (bVar.f29071a == 0) {
                cOUIRotateView.setVisibility(0);
            } else {
                cOUIRotateView.setVisibility(8);
            }
            if (bVar.f29071a == -4) {
                textView.setPadding(0, 0, 0, 0);
                textView3.setVisibility(0);
                textView3.setEnabled(PhoneNoInquireActivity.this.f26397H.isChecked());
            } else {
                textView.setPadding(0, 4, 0, 0);
                textView3.setVisibility(8);
            }
            cOUIRotateView.setExpanded(z10);
            textView.setText(bVar.f29072b);
            textView.setEnabled(PhoneNoInquireActivity.this.f26397H.isChecked());
            String g10 = bVar.g();
            if (!PhoneNoInquireActivity.this.n0()) {
                textView2.setEnabled(PhoneNoInquireActivity.this.f26397H.isChecked());
            }
            if (TextUtils.isEmpty(g10)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(g10);
                textView2.setVisibility(0);
            }
            COUICheckBox cOUICheckBox = (COUICheckBox) view2.findViewById(p.f27402n);
            View findViewById = view2.findViewById(p.f27336G);
            if (PhoneNoInquireActivity.this.n0()) {
                PhoneNoInquireActivity phoneNoInquireActivity = PhoneNoInquireActivity.this;
                if (phoneNoInquireActivity.f26407o) {
                    int i11 = phoneNoInquireActivity.f26413z;
                    if (cOUICheckBox.getVisibility() != 0) {
                        if (BlackListAppUtil.f26245b) {
                            AnimationAnimationListenerC0842c.j(this.f26422a, null, 0).r(false, PhoneNoInquireActivity.this.f26409q, cOUICheckBox);
                        } else {
                            AnimationAnimationListenerC0842c.l(this.f26422a, null, 0).r(false, PhoneNoInquireActivity.this.f26409q, cOUICheckBox);
                            i11 = -i11;
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "translationX", 0.0f, i11);
                        ofFloat.setDuration(300L);
                        ofFloat.start();
                    } else if (BlackListAppUtil.f26245b) {
                        findViewById.setTranslationX(PhoneNoInquireActivity.this.f26413z);
                    } else {
                        findViewById.setTranslationX(-PhoneNoInquireActivity.this.f26413z);
                    }
                } else {
                    if (BlackListAppUtil.f26245b) {
                        findViewById.setTranslationX(phoneNoInquireActivity.f26413z);
                    } else {
                        findViewById.setTranslationX(-phoneNoInquireActivity.f26413z);
                    }
                    cOUICheckBox.setVisibility(0);
                }
                int g11 = N.g(this, i10, bVar);
                cOUICheckBox.setState(g11);
                if (g11 == 0) {
                    z11 = false;
                }
                Z.a(view2, z11);
            } else {
                PhoneNoInquireActivity phoneNoInquireActivity2 = PhoneNoInquireActivity.this;
                if (phoneNoInquireActivity2.f26407o) {
                    int i12 = phoneNoInquireActivity2.f26413z;
                    if (cOUICheckBox.getVisibility() == 0) {
                        if (BlackListAppUtil.f26245b) {
                            AnimationAnimationListenerC0842c.k(this.f26422a, null, 8).r(false, new k(cOUICheckBox), cOUICheckBox);
                        } else {
                            AnimationAnimationListenerC0842c.m(this.f26422a, null, 8).r(false, new k(cOUICheckBox), cOUICheckBox);
                            i12 = -i12;
                        }
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById, "translationX", i12, 0.0f);
                        ofFloat2.setDuration(300L);
                        ofFloat2.start();
                    } else {
                        findViewById.setTranslationX(0.0f);
                    }
                } else {
                    findViewById.setTranslationX(0.0f);
                    cOUICheckBox.setVisibility(8);
                }
                Z.a(view2, false);
            }
            cOUICheckBox.setOnClickListener(new View.OnClickListener() { // from class: p6.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    PhoneNoInquireActivity.h.this.b(bVar, view3);
                }
            });
            view2.setTag(bVar);
            return view2;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i10, int i11) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<PhoneNoInquireActivity> f26425a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PhoneNoInquireActivity phoneNoInquireActivity = this.f26425a.get();
            if (phoneNoInquireActivity == null) {
                return;
            }
            phoneNoInquireActivity.f26405m = new ArrayList<>(N.f29062f);
            if (phoneNoInquireActivity.n0()) {
                phoneNoInquireActivity.f26404O.d();
            }
            phoneNoInquireActivity.f26411x.notifyDataSetChanged();
            ArrayList<N.b> arrayList = phoneNoInquireActivity.f26405m;
            if (arrayList != null) {
                boolean z10 = false;
                if (arrayList.size() == 0) {
                    phoneNoInquireActivity.f26410r.setVisibility(8);
                    phoneNoInquireActivity.f26264j.setVisibility(0);
                } else {
                    phoneNoInquireActivity.f26410r.setVisibility(0);
                    phoneNoInquireActivity.f26264j.setVisibility(8);
                }
                InterfaceC0859u interfaceC0859u = phoneNoInquireActivity.f26404O;
                if (phoneNoInquireActivity.f26405m.size() > 0) {
                    z10 = true;
                }
                interfaceC0859u.f(z10);
                StatisticsUtils.b(phoneNoInquireActivity, String.valueOf(N.e(phoneNoInquireActivity.f26405m)[1]));
            }
        }

        public i(PhoneNoInquireActivity phoneNoInquireActivity) {
            this.f26425a = new WeakReference<>(phoneNoInquireActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.b f26426a = null;

        public j() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            PhoneNoInquireActivity phoneNoInquireActivity = PhoneNoInquireActivity.this;
            N.j(phoneNoInquireActivity.f26405m, phoneNoInquireActivity);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            androidx.appcompat.app.b bVar = this.f26426a;
            if (bVar != null && bVar.isShowing()) {
                this.f26426a.dismiss();
                this.f26426a = null;
            }
            PhoneNoInquireActivity.this.N1();
            PhoneNoInquireActivity.this.R1();
            C0861w.g(PhoneNoInquireActivity.this.getApplicationContext()).l();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            PhoneNoInquireActivity phoneNoInquireActivity = PhoneNoInquireActivity.this;
            this.f26426a = com.oplus.utils.r.b(phoneNoInquireActivity, phoneNoInquireActivity.getString(u.f27584X0));
        }
    }

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        f26388P = linkedBlockingQueue;
        f26389Q = new ThreadPoolExecutor(1, 1, 180L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void B1() {
        b1(true);
        O1(false);
        this.f26404O.b();
        R0(true, this.f26410r);
        s0(n0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D1() {
        return N.f(this.f26405m);
    }

    private Dialog E1(int i10) {
        int[] C12 = C1();
        if (C12[1] == 0) {
            return null;
        }
        String format = String.format(getResources().getQuantityString(t.f27488j, C12[0]), Integer.valueOf(C12[0]));
        g gVar = new g(i10);
        COUIAlertDialogBuilder neutralButton = new S8.b(this, X8.n.f5032d).setTitle((CharSequence) format).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) gVar).setNeutralButton(u.f27502C2, (DialogInterface.OnClickListener) gVar);
        this.f26401L = neutralButton;
        androidx.appcompat.app.b create = neutralButton.create();
        create.setOnDismissListener(gVar);
        return create;
    }

    private void G1() {
        this.f26390A.setOnMenuItemClickListener(new Toolbar.g() { // from class: p6.s
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean I12;
                I12 = PhoneNoInquireActivity.this.I1(menuItem);
                return I12;
            }
        });
        this.f26390A.setNavigationOnClickListener(new View.OnClickListener() { // from class: p6.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneNoInquireActivity.this.J1(view);
            }
        });
        this.f26404O.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        if (!n0()) {
            return;
        }
        b1(false);
        O1(true);
        this.f26404O.c();
        R0(false, this.f26410r);
        s0(n0());
    }

    public final int[] C1() {
        return N.e(this.f26405m);
    }

    public String F1(int i10) {
        if (i10 == 0) {
            return getString(u.f27570T2);
        }
        return getString(u.f27574U2, Integer.valueOf(i10));
    }

    public final /* synthetic */ boolean H1(MenuItem menuItem) {
        showDialog(0);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = this.f26401L;
        if (cOUIAlertDialogBuilder != null) {
            cOUIAlertDialogBuilder.updateViewAfterShown();
        }
        return false;
    }

    public final /* synthetic */ boolean I1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == p.f27330D) {
            if (BlackListAppUtil.c().a()) {
                Log.i("PhoneNoInquireActivity", "Invalid click return --------------");
                return false;
            }
            B1();
            return true;
        }
        if (itemId == p.f27400m) {
            if (n0()) {
                N1();
                return true;
            }
            return true;
        }
        if (itemId == p.f27380c) {
            Q1("add_number");
            return true;
        }
        if (itemId == p.f27327B0) {
            P1();
            this.f26411x.notifyDataSetChanged();
            return true;
        }
        return true;
    }

    public final /* synthetic */ void J1(View view) {
        finish();
    }

    public final /* synthetic */ boolean K1(AdapterView adapterView, View view, int i10, long j10) {
        Object tag;
        if (n0() || (tag = view.getTag()) == null) {
            return false;
        }
        B1();
        if (tag instanceof N.b) {
            ((N.b) tag).h();
        } else if (tag instanceof N.a) {
            N.a aVar = (N.a) tag;
            aVar.f29073c = !aVar.f29073c;
            N.m(aVar);
        }
        this.f26404O.d();
        this.f26411x.notifyDataSetChanged();
        return true;
    }

    public final /* synthetic */ void L1(SharedPreferences sharedPreferences, String str) {
        if ("harass_intercept_attribution".equals(str)) {
            S1(this.f26406n);
            this.f26411x.notifyDataSetChanged();
            this.f26402M.removeMessages(101);
            this.f26402M.sendEmptyMessageDelayed(101, 200L);
        }
    }

    public final /* synthetic */ void M1(SharedPreferences sharedPreferences, View view) {
        boolean z10 = !this.f26397H.isChecked();
        com.oplus.blacklistapp.callintercept.settings.u.d(sharedPreferences, this.f26412y, "harass_intercept_attribution", z10, 3);
        this.f26397H.setChecked(z10);
        this.f26397H.setTactileFeedbackEnabled(true);
        this.f26411x.notifyDataSetChanged();
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity
    public void O0() {
        super.O0();
        this.f26263i.inflateMenu(s.f27474c);
        MenuItem findItem = this.f26263i.getMenu().findItem(p.f27422x);
        this.f26408p = findItem;
        if (findItem != null) {
            findItem.setTitle(u.f27502C2);
            this.f26408p.setEnabled(false);
        }
        this.f26263i.setOnItemSelectedListener(new NavigationBarView.c() { // from class: p6.r
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean H12;
                H12 = PhoneNoInquireActivity.this.H1(menuItem);
                return H12;
            }
        });
    }

    public final void O1(boolean z10) {
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = this.f26398I;
        if (cOUICardListSelectedItemLayout != null) {
            cOUICardListSelectedItemLayout.setEnabled(z10);
        }
        COUISwitch cOUISwitch = this.f26397H;
        if (cOUISwitch != null) {
            cOUISwitch.setEnabled(z10);
        }
    }

    public void P1() {
        if (!n0()) {
            return;
        }
        int[] C12 = C1();
        if (C12[0] == C12[1]) {
            N.n(this.f26405m);
        } else {
            N.k(this.f26405m);
        }
        this.f26404O.d();
        this.f26411x.notifyDataSetChanged();
    }

    public final void Q1(String str) {
        Intent intent = new Intent(this, (Class<?>) PhoneNoInquireSelectActivity.class);
        intent.putExtra("slotId", this.f26412y);
        intent.putExtra("is_single_sim", C0863y.a(getIntent(), "is_single_sim", false));
        intent.putExtra("number_of_attributions", str);
        C0849j.A(this, intent);
        overridePendingTransition(com.oplus.blacklistapp.i.f27263e, com.oplus.blacklistapp.i.f27264f);
    }

    public final void R1() {
        if (n0()) {
            return;
        }
        f26389Q.execute(new e());
    }

    public final void S1(View view) {
        final SharedPreferences b10 = androidx.preference.j.b(this);
        boolean C10 = C1632f.C(b10, "harass_intercept_attribution", 3, this.f26412y);
        C0846g.i("PhoneNoInquireActivity", this.f26412y + "-refresh-isHarassInterceptAttribution : " + C10);
        COUISwitch cOUISwitch = (COUISwitch) view.findViewById(p.f27416u);
        this.f26397H = cOUISwitch;
        cOUISwitch.setChecked(C10);
        this.f26397H.setTactileFeedbackEnabled(true);
        ((TextView) view.findViewById(p.f27351N0)).setText(u.f27667o1);
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(p.f27349M0);
        this.f26398I = cOUICardListSelectedItemLayout;
        cOUICardListSelectedItemLayout.setOnClickListener(new View.OnClickListener() { // from class: p6.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhoneNoInquireActivity.this.M1(b10, view2);
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("area_count", this.f26411x.getGroupCount());
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean n0() {
        return this.f26391B;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (n0()) {
            N1();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i10, int i11, long j10) {
        if (!n0()) {
            return false;
        }
        N.a aVar = (N.a) view.getTag();
        aVar.f29073c = !aVar.f29073c;
        N.m(aVar);
        this.f26411x.notifyDataSetChanged();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Q1("add_number_blank");
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity, com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        setContentView(r.f27460o);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(null);
        }
        this.f26390A = (COUIToolbar) findViewById(p.f27363T0);
        G1();
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26392C = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        this.f26410r = expandableListView;
        expandableListView.setBackground(null);
        this.f26410r.setDivider(null);
        this.f26410r.setVerticalFadingEdgeEnabled(false);
        this.f26410r.setOnGroupClickListener(this);
        this.f26410r.setOnChildClickListener(this);
        this.f26410r.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: p6.q
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean K12;
                K12 = PhoneNoInquireActivity.this.K1(adapterView, view, i10, j10);
                return K12;
            }
        });
        this.f26410r.setGroupIndicator(null);
        this.f26410r.setNestedScrollingEnabled(true);
        View inflate = layoutInflater.inflate(r.f27450e, (ViewGroup) null);
        this.f26406n = inflate;
        this.f26410r.addHeaderView(inflate);
        h hVar = new h(this);
        this.f26411x = hVar;
        hVar.registerDataSetObserver(new c());
        this.f26410r.setAdapter(this.f26411x);
        N0(o.f27316s, u.f27553P1, Integer.valueOf(u.f27557Q1), this);
        this.f26413z = C0849j.b(this, 33.0f);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26393D = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        Intent intent = getIntent();
        int b10 = C0863y.b(intent, "slotId", 0);
        this.f26412y = b10;
        N.l(b10);
        StatisticsUtils.c(this, "attribution_setting_entry", C0863y.a(intent, "is_single_sim", false), this.f26412y);
        S1(this.f26406n);
        CallInterceptController.e().d(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 == 0) {
            return E1(i10);
        }
        return null;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (n0()) {
            N1();
        }
        StatisticsUtils.e(this, "attribution_setting_back");
        CallInterceptController.e().m(this);
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i10, long j10) {
        if (n0()) {
            N.b bVar = (N.b) this.f26411x.getGroup(i10);
            if (bVar.f29071a != 0) {
                bVar.f29073c = !bVar.f29073c;
                N.m(bVar);
                this.f26411x.notifyDataSetChanged();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.f26400K != null) {
            androidx.preference.j.b(this).registerOnSharedPreferenceChangeListener(this.f26400K);
            this.f26400K = null;
        }
        if (this.f26399J != null) {
            getContentResolver().unregisterContentObserver(this.f26399J);
            this.f26399J = null;
        }
        super.onPause();
        this.f26393D.onPause();
        T.c();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f26393D.onResume();
        this.f26407o = false;
        if (this.f26400K == null) {
            this.f26400K = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: p6.p
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    PhoneNoInquireActivity.this.L1(sharedPreferences, str);
                }
            };
        }
        androidx.preference.j.b(this).registerOnSharedPreferenceChangeListener(this.f26400K);
        if (this.f26399J == null) {
            this.f26399J = new d(this.f26403N);
        }
        getContentResolver().registerContentObserver(Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, "area_list"), true, this.f26399J);
        R1();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        T.e(this, this.f26410r);
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        C0846g.i("PhoneNoInquireActivity", "handleHotPlugOut slot = " + i10);
        finish();
    }

    /* loaded from: classes3.dex */
    public class k implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public View f26428a;

        public k(View view) {
            this.f26428a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f26428a != null && !PhoneNoInquireActivity.this.n0()) {
                View view = this.f26428a;
                if (view instanceof CheckBox) {
                    ((CheckBox) view).setChecked(false);
                } else if (view instanceof COUICheckBox) {
                    ((COUICheckBox) view).setState(0);
                }
                this.f26428a.setVisibility(8);
            }
            PhoneNoInquireActivity.this.f26407o = false;
        }

        public k() {
            this.f26428a = null;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }
}
