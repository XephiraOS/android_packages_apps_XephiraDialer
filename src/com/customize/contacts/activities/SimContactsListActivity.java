package com.customize.contacts.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.model.Account;
import com.android.incallui.OplusNumberMarkUtils;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.SimContactsOrderHelper;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0806q;
import com.customize.contacts.util.C0807s;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.widget.MultiChoiceListView;
import com.customize.contacts.widget.TouchSearchView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.io.CloseableUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import m1.C1320p;

/* loaded from: classes3.dex */
public class SimContactsListActivity extends BasicActivity implements COUIStatusBarResponseUtil.StatusBarClickListener, C0806q.a, TouchSearchView.d, COUIListView.ScrollMultiChoiceListener {

    /* renamed from: A, reason: collision with root package name */
    public COUIToolbar f20608A;

    /* renamed from: B, reason: collision with root package name */
    public FrameLayout f20609B;

    /* renamed from: C, reason: collision with root package name */
    public COUINavigationView f20610C;

    /* renamed from: V, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20629V;

    /* renamed from: Z, reason: collision with root package name */
    public COUIPopupListWindow f20633Z;

    /* renamed from: d0, reason: collision with root package name */
    public HashMap<Long, IdRecord> f20637d0;

    /* renamed from: p, reason: collision with root package name */
    public TouchSearchView f20643p;

    /* renamed from: o, reason: collision with root package name */
    public final String f20642o = "SimContactsListActivity";

    /* renamed from: q, reason: collision with root package name */
    public com.customize.contacts.util.I f20644q = null;

    /* renamed from: r, reason: collision with root package name */
    public final Object f20645r = new Object();

    /* renamed from: x, reason: collision with root package name */
    public TextView f20646x = null;

    /* renamed from: y, reason: collision with root package name */
    public ImageView f20647y = null;

    /* renamed from: z, reason: collision with root package name */
    public MultiChoiceListView f20648z = null;

    /* renamed from: D, reason: collision with root package name */
    public m1.W f20611D = null;

    /* renamed from: E, reason: collision with root package name */
    public androidx.appcompat.app.b f20612E = null;

    /* renamed from: F, reason: collision with root package name */
    public boolean f20613F = false;

    /* renamed from: G, reason: collision with root package name */
    public boolean f20614G = true;

    /* renamed from: H, reason: collision with root package name */
    public C0806q f20615H = null;

    /* renamed from: I, reason: collision with root package name */
    public boolean f20616I = false;

    /* renamed from: J, reason: collision with root package name */
    public String f20617J = null;

    /* renamed from: K, reason: collision with root package name */
    public int f20618K = -1;

    /* renamed from: L, reason: collision with root package name */
    public boolean f20619L = false;

    /* renamed from: M, reason: collision with root package name */
    public boolean f20620M = false;

    /* renamed from: N, reason: collision with root package name */
    public boolean f20621N = false;

    /* renamed from: O, reason: collision with root package name */
    public int f20622O = 0;

    /* renamed from: P, reason: collision with root package name */
    public int f20623P = -1;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f20624Q = false;

    /* renamed from: R, reason: collision with root package name */
    public final ArrayList<String> f20625R = new ArrayList<>();

    /* renamed from: S, reason: collision with root package name */
    public final ArrayList<ContactParcelable> f20626S = new ArrayList<>();

    /* renamed from: T, reason: collision with root package name */
    public String f20627T = null;

    /* renamed from: U, reason: collision with root package name */
    public int f20628U = -1;

    /* renamed from: W, reason: collision with root package name */
    public boolean f20630W = false;

    /* renamed from: X, reason: collision with root package name */
    public boolean f20631X = false;

    /* renamed from: Y, reason: collision with root package name */
    public boolean f20632Y = false;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList<PopupListItem> f20634a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    public HashMap<String, Integer> f20635b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    public int f20636c0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    public View.OnTouchListener f20638e0 = new f();

    /* renamed from: f0, reason: collision with root package name */
    public final BroadcastReceiver f20639f0 = new h();

    /* renamed from: g0, reason: collision with root package name */
    public Z3.h f20640g0 = new a();

    /* renamed from: h0, reason: collision with root package name */
    public AdapterView.OnItemClickListener f20641h0 = new b();

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (C7.a.a()) {
                return;
            }
            if (SimContactsListActivity.this.f20633Z != null) {
                SimContactsListActivity.this.f20633Z.dismiss();
            }
            int intValue = ((Integer) SimContactsListActivity.this.f20635b0.get(((PopupListItem) SimContactsListActivity.this.f20634a0.get(i10)).getTitle())).intValue();
            if (intValue == 0) {
                SimContactsListActivity.this.n2(false);
                return;
            }
            if (intValue == 1) {
                SimContactsListActivity.this.F2(new Account(SimContactsListActivity.this.f20617J, "com.oplus.contacts.sim"));
                com.android.contacts.framework.baseui.util.A.a(SimContactsListActivity.this.getBaseContext(), 2000315, 200030133, null, false);
            } else if (intValue == 2) {
                SimContactsListActivity.this.f20611D.f1(true);
                SimContactsListActivity.this.f20611D.g1(true);
                SimContactsListActivity.this.f20623P = 11;
                SimContactsListActivity.this.f20615H.b();
                SimContactsListActivity.this.I2(false, true, true);
                SimContactsListActivity.this.D(true);
                com.android.contacts.framework.baseui.util.A.a(SimContactsListActivity.this.getBaseContext(), 2000315, 200030134, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SimContactsListActivity.this.D(true);
            int headerViewsCount = i10 - SimContactsListActivity.this.f20648z.getHeaderViewsCount();
            if (SimContactsListActivity.this.f20615H != null && SimContactsListActivity.this.f20615H.i()) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
                SimContactsListActivity.this.f20615H.k(checkBox);
                com.android.contacts.util.C.b(view, checkBox.isChecked());
                if (SimContactsListActivity.this.f20619L) {
                    Cursor cursor = (Cursor) SimContactsListActivity.this.f20611D.getItem(headerViewsCount);
                    CharSequence[] j22 = SimContactsListActivity.this.j2(cursor);
                    if (checkBox.isChecked()) {
                        if (j22 != null) {
                            if (j22.length > 1) {
                                SimContactsListActivity.this.E2(checkBox, cursor, j22);
                            } else {
                                SimContactsListActivity.this.f20626S.add(SimContactsListActivity.this.r2(cursor, j22));
                            }
                        }
                    } else {
                        for (int i11 = 0; i11 < SimContactsListActivity.this.f20626S.size(); i11++) {
                            Iterator it = SimContactsListActivity.this.f20626S.iterator();
                            int i12 = cursor.getInt(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
                            while (it.hasNext()) {
                                if (((ContactParcelable) it.next()).k() == i12) {
                                    it.remove();
                                }
                            }
                        }
                    }
                }
                if (12 == SimContactsListActivity.this.f20623P) {
                    SimContactsListActivity.this.f20640g0.d();
                    return;
                }
                return;
            }
            if (C7.a.a()) {
                H7.b.e("SimContactsListActivity", "---Invalid click return---");
                return;
            }
            Cursor cursor2 = (Cursor) SimContactsListActivity.this.f20611D.getItem(headerViewsCount);
            long j11 = cursor2.getInt(cursor2.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            SimContactInfo simContactInfo = new SimContactInfo(j11, cursor2.getString(cursor2.getColumnIndex("name")), cursor2.getString(cursor2.getColumnIndex("number")), cursor2.getString(cursor2.getColumnIndex("additionalNumber")), cursor2.getString(cursor2.getColumnIndex("emails")));
            simContactInfo.f(SimContactsListActivity.this.f20617J);
            simContactInfo.j(j11);
            Intent intent = new Intent(SimContactsListActivity.this, (Class<?>) CallDetailActivity.class);
            intent.putExtra("sim_contacts_info", simContactInfo);
            R7.b.c(SimContactsListActivity.this, intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemLongClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (SimContactsListActivity.this.f20619L) {
                return false;
            }
            if (SimContactsListActivity.this.f20615H == null || !SimContactsListActivity.this.f20615H.i()) {
                SimContactsListActivity.this.n2(true);
                SimContactsListActivity.this.f20615H.k((CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox));
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            SimContactsListActivity.this.f20611D.d1(false);
            SimContactsListActivity.this.f20611D.f1(false);
            SimContactsListActivity.this.f20611D.g1(false);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            SimContactsListActivity.this.f20611D.d1(false);
            if (i10 == 0) {
                SimContactsListActivity.this.f20611D.f1(true);
                SimContactsListActivity.this.f20611D.g1(true);
            } else {
                SimContactsListActivity.this.f20611D.f1(false);
                SimContactsListActivity.this.f20611D.g1(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            SimContactsListActivity.this.D2();
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cursor f20655a;

        public g(Cursor cursor) {
            this.f20655a = cursor;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20655a.close();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BroadcastReceiver {
        public h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (H7.a.b()) {
                H7.b.b("SimContactsListActivity", "action = " + action);
            }
            if ("android.intent.action.SIM_STATE_CHANGED".equals(action)) {
                com.customize.contacts.util.b0.H0();
                M3.c.m(SimContactsListActivity.this.getBaseContext());
                int K10 = com.customize.contacts.util.b0.K(SimContactsListActivity.this.getBaseContext(), SimContactsListActivity.this.f20617J);
                if (com.customize.contacts.util.b0.n0(SimContactsListActivity.this.getBaseContext(), SimContactsListActivity.this.f20617J)) {
                    if (!SimContactsListActivity.this.f20614G && SimContactsListActivity.this.f20613F && (SimContactsListActivity.this.f20615H == null || !SimContactsListActivity.this.f20615H.i())) {
                        SimContactsListActivity.this.C2(K10);
                    }
                    SimContactsListActivity.this.f20614G = false;
                }
            }
            String l10 = C7.e.l(intent, "simstate");
            String l11 = C7.e.l(intent, "slotid");
            if (H7.a.b()) {
                H7.b.b("SimContactsListActivity", "onReceivet action : " + action + ", mSlotId : " + SimContactsListActivity.this.f20618K + ", state = " + l10 + ", slotId = " + l11);
            }
            if (TextUtils.equals("local.intent.action.SUBINFO_STATE_CHANGE", action) && TextUtils.equals("PLUGOUT", l10) && TextUtils.equals(String.valueOf(SimContactsListActivity.this.f20618K), l11)) {
                H7.b.e("SimContactsListActivity", "receive SIM_PLUGOUT, mIsResumed: " + SimContactsListActivity.this.f20630W);
                if (SimContactsListActivity.this.f20630W) {
                    SimContactsListActivity.this.f20632Y = true;
                    SimContactsListActivity.this.finish();
                } else {
                    if (SimContactsListActivity.this.f20611D != null) {
                        SimContactsListActivity.this.f20611D.R(null);
                        SimContactsListActivity.this.f20611D.notifyDataSetChanged();
                    }
                    SimContactsListActivity.this.f20631X = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f20658a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20659b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CharSequence[] f20660c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f20661d;

        public i(CheckBox checkBox, int i10, CharSequence[] charSequenceArr, String str) {
            this.f20658a = checkBox;
            this.f20659b = i10;
            this.f20660c = charSequenceArr;
            this.f20661d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-2 == i10) {
                SimContactsListActivity.this.f20615H.k(this.f20658a);
                return;
            }
            if (-1 == i10) {
                i10 = 0;
            }
            if (-3 == i10) {
                i10 = 1;
            }
            ContactParcelable contactParcelable = new ContactParcelable();
            contactParcelable.q(this.f20659b);
            contactParcelable.w(this.f20660c[i10].toString());
            if (!TextUtils.isEmpty(this.f20661d)) {
                contactParcelable.t(this.f20661d);
            } else {
                contactParcelable.t(SimContactsListActivity.this.getString(android.R.string.unknownName));
            }
            SimContactsListActivity.this.f20626S.add(contactParcelable);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements BottomNavigationView.c {
        public j() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            if (menuItem != null && menuItem.getItemId() == R.id.delete && SimContactsListActivity.this.f20615H.f().i() != 0) {
                if (SimContactsListActivity.this.f20623P == 10) {
                    SimContactsListActivity simContactsListActivity = SimContactsListActivity.this;
                    simContactsListActivity.B2(simContactsListActivity.f20623P);
                }
                if (SimContactsListActivity.this.f20623P == 11) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("selected_count", Integer.valueOf(SimContactsListActivity.this.f20615H.f().i()));
                    com.android.contacts.framework.baseui.util.A.a(SimContactsListActivity.this.getBaseContext(), 2000315, 200030145, hashMap, false);
                    SimContactsListActivity.this.G2(new Account(SimContactsListActivity.this.f20617J, "com.oplus.contacts.sim"));
                }
                if (SimContactsListActivity.this.f20623P == 12) {
                    SimContactsListActivity simContactsListActivity2 = SimContactsListActivity.this;
                    simContactsListActivity2.B2(simContactsListActivity2.f20623P);
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Toolbar.g {
        public k() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x00c2, code lost:
        
            return true;
         */
        @Override // androidx.appcompat.widget.Toolbar.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onMenuItemClick(android.view.MenuItem r6) {
            /*
                r5 = this;
                com.customize.contacts.activities.SimContactsListActivity r0 = com.customize.contacts.activities.SimContactsListActivity.this
                r0.D2()
                int r6 = r6.getItemId()
                r0 = 1
                r1 = 0
                switch(r6) {
                    case 2131427439: goto L94;
                    case 2131427618: goto L8e;
                    case 2131428922: goto L88;
                    case 2131428940: goto L10;
                    default: goto Le;
                }
            Le:
                goto Lc2
            L10:
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                if (r6 == 0) goto L26
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                boolean r6 = r6.isShowing()
                if (r6 == 0) goto L26
                goto Lc2
            L26:
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.customize.contacts.activities.SimContactsListActivity.c2(r6)
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r2 = new com.coui.appcompat.poplist.COUIPopupListWindow
                com.customize.contacts.activities.SimContactsListActivity r3 = com.customize.contacts.activities.SimContactsListActivity.this
                r2.<init>(r3)
                com.customize.contacts.activities.SimContactsListActivity.O1(r6, r2)
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                com.customize.contacts.activities.SimContactsListActivity r2 = com.customize.contacts.activities.SimContactsListActivity.this
                java.util.ArrayList r2 = com.customize.contacts.activities.SimContactsListActivity.s1(r2)
                r6.setItemList(r2)
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                r6.setDismissTouchOutside(r0)
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                com.customize.contacts.activities.SimContactsListActivity r2 = com.customize.contacts.activities.SimContactsListActivity.this
                android.widget.AdapterView$OnItemClickListener r2 = com.customize.contacts.activities.SimContactsListActivity.F1(r2)
                r6.setOnItemClickListener(r2)
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                com.customize.contacts.activities.SimContactsListActivity r2 = com.customize.contacts.activities.SimContactsListActivity.this
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131165296(0x7f070070, float:1.7944805E38)
                int r2 = r2.getDimensionPixelOffset(r3)
                int r2 = -r2
                r6.setOffset(r1, r1, r1, r2)
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                com.coui.appcompat.poplist.COUIPopupListWindow r6 = com.customize.contacts.activities.SimContactsListActivity.t1(r6)
                com.customize.contacts.activities.SimContactsListActivity r5 = com.customize.contacts.activities.SimContactsListActivity.this
                r1 = 2131428940(0x7f0b064c, float:1.8479539E38)
                android.view.View r5 = r5.findViewById(r1)
                r6.show(r5)
                goto Lc2
            L88:
                com.customize.contacts.activities.SimContactsListActivity r5 = com.customize.contacts.activities.SimContactsListActivity.this
                r5.x2()
                goto Lc2
            L8e:
                com.customize.contacts.activities.SimContactsListActivity r5 = com.customize.contacts.activities.SimContactsListActivity.this
                com.customize.contacts.activities.SimContactsListActivity.d2(r5)
                goto Lc2
            L94:
                com.customize.contacts.activities.SimContactsListActivity r6 = com.customize.contacts.activities.SimContactsListActivity.this
                android.content.Context r6 = r6.getBaseContext()
                r2 = 200030130(0xbec37b2, float:9.0987694E-32)
                r3 = 0
                r4 = 2000315(0x1e85bb, float:2.803038E-39)
                com.android.contacts.framework.baseui.util.A.a(r6, r4, r2, r3, r1)
                android.content.Intent r6 = new android.content.Intent
                java.lang.String r1 = com.customize.contacts.util.k0.f22141e
                android.net.Uri r2 = android.provider.ContactsContract.Contacts.CONTENT_URI
                r6.<init>(r1, r2)
                com.customize.contacts.activities.SimContactsListActivity r1 = com.customize.contacts.activities.SimContactsListActivity.this
                java.lang.String r1 = com.customize.contacts.activities.SimContactsListActivity.x1(r1)
                java.lang.String r2 = "imsi"
                r6.putExtra(r2, r1)
                com.customize.contacts.activities.SimContactsListActivity r1 = com.customize.contacts.activities.SimContactsListActivity.this
                R7.b.c(r1, r6)
                com.customize.contacts.activities.SimContactsListActivity r5 = com.customize.contacts.activities.SimContactsListActivity.this
                com.android.contacts.framework.baseui.util.C0636a.a(r5)
            Lc2:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.SimContactsListActivity.k.onMenuItemClick(android.view.MenuItem):boolean");
        }
    }

    /* loaded from: classes3.dex */
    public class l implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -3) {
                int i11 = SimContactsListActivity.this.f20615H.f().i();
                int l10 = SimContactsListActivity.this.f20615H.f().l();
                if (i11 == l10 && l10 != 1) {
                    try {
                        Intent c10 = C0807s.c(SimContactsListActivity.this);
                        if (c10 != null) {
                            Q7.b.b(SimContactsListActivity.this, c10, 10, 0);
                            return;
                        }
                    } catch (Exception e10) {
                        H7.b.b("SimContactsListActivity", "can not get the lock ui" + e10);
                    }
                }
                SimContactsListActivity.this.l2();
            }
            SimContactsListActivity.this.removeDialog(10);
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            SimContactsListActivity.this.removeDialog(10);
        }

        public l() {
        }
    }

    /* loaded from: classes3.dex */
    public class m extends AsyncTask<Void, Void, Cursor> {

        /* renamed from: a, reason: collision with root package name */
        public final int f20666a;

        public m(int i10) {
            this.f20666a = i10;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cursor doInBackground(Void... voidArr) {
            Cursor cursor;
            try {
                try {
                    H7.b.e("SimContactsListActivity", "doInBackground-----------------");
                    cursor = W3.a.c(SimContactsListActivity.this.getApplicationContext(), this.f20666a);
                } catch (Exception e10) {
                    e = e10;
                    cursor = null;
                }
                try {
                    W3.a.d(SimContactsListActivity.this.getApplicationContext(), this.f20666a);
                    if (com.customize.contacts.util.b0.M(SimContactsListActivity.this.getApplicationContext(), this.f20666a) == -1) {
                        H7.b.c("SimContactsListActivity", "fail to get sim card storage.");
                        CloseableUtils.a(cursor);
                        SimContactsListActivity.this.f20613F = true;
                        synchronized (SimContactsListActivity.this.f20645r) {
                            SimContactsListActivity.this.f20645r.notifyAll();
                        }
                        return null;
                    }
                    H7.b.e("SimContactsListActivity", "simCursor = " + cursor);
                    if (cursor != null) {
                        SimContactsListActivity.this.f20636c0 = cursor.getCount();
                        if (H7.a.b()) {
                            H7.b.b("SimContactsListActivity", "count = " + SimContactsListActivity.this.f20636c0);
                        }
                    }
                    Cursor c10 = SimContactsOrderHelper.c(cursor);
                    SimContactsListActivity.this.f20613F = true;
                    synchronized (SimContactsListActivity.this.f20645r) {
                        SimContactsListActivity.this.f20645r.notifyAll();
                    }
                    return c10;
                } catch (Exception e11) {
                    e = e11;
                    H7.b.c("SimContactsListActivity", "Exception e: " + e);
                    H7.b.b("SimContactsListActivity", "query exception");
                    SimContactsListActivity.this.k2(cursor);
                    SimContactsListActivity.this.f20613F = true;
                    synchronized (SimContactsListActivity.this.f20645r) {
                        SimContactsListActivity.this.f20645r.notifyAll();
                    }
                    return null;
                }
            } catch (Throwable th) {
                SimContactsListActivity.this.f20613F = true;
                synchronized (SimContactsListActivity.this.f20645r) {
                    SimContactsListActivity.this.f20645r.notifyAll();
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Cursor cursor) {
            boolean z10;
            int i10;
            if (H7.a.b()) {
                H7.b.b("SimContactsListActivity", "onPostExecute()");
            }
            if (!SimContactsListActivity.this.isFinishing()) {
                SimContactsListActivity.this.m2();
                if (cursor == null) {
                    com.oplus.foundation.util.ui.c.b(SimContactsListActivity.this, R.string.simcard_abnormal_please_check_and_try_again);
                    SimContactsListActivity.this.finish();
                    return;
                }
                View findViewById = SimContactsListActivity.this.findViewById(R.id.divider_line);
                if (findViewById != null) {
                    if (cursor.getCount() == 0) {
                        i10 = 4;
                    } else {
                        i10 = 0;
                    }
                    findViewById.setVisibility(i10);
                }
                if (SimContactsListActivity.this.f20624Q) {
                    SimContactsListActivity.this.f20624Q = false;
                    HashMap hashMap = new HashMap();
                    hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(cursor.getCount()));
                    com.android.contacts.framework.baseui.util.A.a(SimContactsListActivity.this.getBaseContext(), 2000315, 200030128, hashMap, false);
                }
                if (cursor.getCount() == 0) {
                    SimContactsListActivity.this.f20648z.setVisibility(8);
                    SimContactsListActivity.this.D2();
                    SimContactsListActivity.this.f20643p.setVisibility(4);
                    SimContactsListActivity.this.f20646x.setVisibility(0);
                    SimContactsListActivity.this.f20646x.setText(R.string.noContacts);
                    SimContactsListActivity.this.f20647y.setVisibility(0);
                    SimContactsListActivity.this.f20647y.setImageDrawable(SimContactsListActivity.this.getDrawable(R.drawable.pb_ic_no_contact));
                    if (SimContactsListActivity.this.f20620M) {
                        SimContactsListActivity.this.f20623P = 11;
                        SimContactsListActivity.this.I2(false, true, true);
                        SimContactsListActivity.this.f20611D.d1(false);
                        SimContactsListActivity.this.f20615H.p(true);
                        SimContactsListActivity.this.f20611D.f1(false);
                        SimContactsListActivity.this.f20611D.g1(false);
                        if (!SimContactsListActivity.this.f20615H.i()) {
                            SimContactsListActivity.this.f20615H.b();
                        }
                    } else {
                        SimContactsListActivity simContactsListActivity = SimContactsListActivity.this;
                        simContactsListActivity.I2(false, simContactsListActivity.f20615H.i(), true);
                    }
                    if (!cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                if (!SimContactsListActivity.this.f20620M) {
                    SimContactsListActivity simContactsListActivity2 = SimContactsListActivity.this;
                    simContactsListActivity2.I2(true, simContactsListActivity2.f20615H.i(), true);
                }
                if (H7.a.b()) {
                    H7.b.b("SimContactsListActivity", "onQueryComplete() c.getCount() = " + cursor.getCount());
                    H7.b.b("SimContactsListActivity", "onQueryComplete() c.getColumnNames() = " + Arrays.toString(cursor.getColumnNames()));
                }
                SimContactsListActivity.this.f20648z.setVisibility(0);
                SimContactsListActivity.this.f20643p.setVisibility(0);
                SimContactsListActivity.this.f20646x.setVisibility(8);
                SimContactsListActivity.this.f20647y.setVisibility(8);
                SimContactsListActivity.this.f20611D.h(0, cursor);
                SimContactsListActivity.this.f20611D.notifyDataSetChanged();
                Bundle a10 = ((SimContactsOrderHelper.b) cursor).a();
                String[] stringArray = a10.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES");
                int[] intArray = a10.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS");
                com.customize.contacts.util.g0.a(SimContactsListActivity.this.f20643p, stringArray, intArray);
                SimContactsListActivity.this.f20611D.N(new C1320p(stringArray, intArray));
                com.customize.contacts.util.I i11 = SimContactsListActivity.this.f20644q;
                if (i11 != null) {
                    i11.f(a10);
                }
                if (SimContactsListActivity.this.f20615H != null && !SimContactsListActivity.this.f20615H.i()) {
                    SimContactsListActivity.this.f20615H.h(cursor);
                } else if (SimContactsListActivity.this.f20615H != null) {
                    SimContactsListActivity.this.f20615H.s(cursor, false);
                }
                if (SimContactsListActivity.this.f20619L) {
                    SimContactsListActivity.this.f20623P = 12;
                    SimContactsListActivity.this.I2(false, true, true);
                    SimContactsListActivity.this.f20611D.d1(false);
                    SimContactsListActivity.this.f20611D.f1(false);
                    SimContactsListActivity.this.f20615H.r(true);
                    if (!SimContactsListActivity.this.f20615H.i()) {
                        SimContactsListActivity.this.f20615H.b();
                    }
                }
                if (SimContactsListActivity.this.f20620M) {
                    SimContactsListActivity.this.f20623P = 11;
                    if (SimContactsListActivity.this.f20637d0 != null && !SimContactsListActivity.this.f20637d0.isEmpty()) {
                        if (H7.a.b()) {
                            H7.b.b("SimContactsListActivity", "onPostExecute mSelectedCounts is not empty, and need restore");
                        }
                        if (cursor.getCount() == SimContactsListActivity.this.f20637d0.size()) {
                            SimContactsListActivity.this.f20615H.q(true);
                        }
                        SimContactsListActivity.this.f20615H.m(SimContactsListActivity.this.f20637d0);
                        SimContactsListActivity.this.f20637d0 = null;
                    }
                    if (SimContactsListActivity.this.f20615H != null && SimContactsListActivity.this.f20615H.f().i() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    SimContactsListActivity.this.I2(z10, true, true);
                    SimContactsListActivity.this.f20611D.d1(false);
                    SimContactsListActivity.this.f20611D.f1(false);
                    SimContactsListActivity.this.f20615H.p(true);
                    if (!SimContactsListActivity.this.f20615H.i()) {
                        SimContactsListActivity.this.f20615H.b();
                        return;
                    }
                    return;
                }
                return;
            }
            CloseableUtils.a(cursor);
        }
    }

    private void H2() {
        C2(com.customize.contacts.util.b0.K(this, this.f20617J));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2() {
        androidx.appcompat.app.b bVar = this.f20612E;
        if (bVar != null && bVar.isShowing()) {
            this.f20612E.dismiss();
        }
        this.f20612E = null;
    }

    private int q2(CharSequence charSequence) {
        int i10 = 0;
        if (charSequence.equals("*")) {
            return 0;
        }
        Object[] sections = this.f20611D.getSections();
        if (sections != null && sections.length != 0) {
            String charSequence2 = charSequence.toString();
            while (true) {
                if (i10 != sections.length) {
                    if (charSequence2.equals(sections[i10].toString())) {
                        break;
                    }
                    i10++;
                } else {
                    i10 = -1;
                    break;
                }
            }
            int headerViewsCount = this.f20648z.getHeaderViewsCount();
            if (i10 != -1) {
                return this.f20611D.getPositionForSection(i10) + headerViewsCount;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2() {
        this.f20634a0 = new ArrayList<>(3);
        if (this.f20635b0 == null) {
            HashMap<String, Integer> hashMap = new HashMap<>(3);
            this.f20635b0 = hashMap;
            hashMap.put(getString(R.string.oplus_menu_edit), 0);
            this.f20635b0.put(getString(R.string.import_contacts_to_sim_tablet), 1);
            this.f20635b0.put(getString(R.string.export_contacts_from_sim_tablet), 2);
        }
        if (!C0637b.h()) {
            this.f20634a0.add(com.android.contacts.framework.baseui.util.q.a(getString(R.string.import_contacts_to_sim_tablet)));
        }
        if (this.f20636c0 > 0) {
            this.f20634a0.add(com.android.contacts.framework.baseui.util.q.a(getString(R.string.export_contacts_from_sim_tablet)));
        }
        if (this.f20636c0 > 0 && PrimaryUserUtils.a()) {
            this.f20634a0.add(com.android.contacts.framework.baseui.util.q.a(getString(R.string.oplus_menu_edit)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(View view) {
        finish();
    }

    public final void A2() {
        HashMap hashMap = new HashMap();
        hashMap.put("selected_count", Integer.valueOf(this.f20615H.e()));
        if (11 == s2()) {
            com.android.contacts.framework.baseui.util.A.a(getBaseContext(), 2000315, 200030144, hashMap, false);
        }
        if (C7.a.a()) {
            H7.b.e("SimContactsListActivity", "----quick click return----");
        } else if (!this.f20620M && !this.f20619L) {
            this.f20615H.o();
        } else {
            finish();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        this.f20608A = cOUIToolbar;
        cOUIToolbar.setOnMenuItemClickListener(new k());
        this.f20608A.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.activities.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimContactsListActivity.this.w2(view);
            }
        });
        this.f20640g0.a(true);
        this.f20640g0.e();
    }

    public final void B2(int i10) {
        if (10 == i10) {
            showDialog(10);
        } else if (12 == i10) {
            C0811w.k(this, this.f20626S);
            finish();
        }
    }

    public final void C2(int i10) {
        if (i10 < 0) {
            m2();
            this.f20646x.setVisibility(0);
            this.f20646x.setText(R.string.noContacts);
            this.f20647y.setVisibility(0);
            this.f20647y.setImageDrawable(getDrawable(R.drawable.pb_ic_no_contact));
            this.f20648z.setVisibility(8);
            D2();
            this.f20643p.setVisibility(4);
            return;
        }
        this.f20613F = false;
        C0797h.a(getBaseContext(), new m(i10), this.f20645r);
        if (!this.f20613F) {
            this.f20612E = U0.k.o(this, getString(R.string.simContacts_emptyLoading));
        }
    }

    @Override // com.customize.contacts.util.C0806q.a
    public void D(boolean z10) {
        this.f20616I = z10;
        if (z10) {
            this.f20611D.d1(false);
        }
    }

    public void D2() {
        TouchSearchView touchSearchView = this.f20643p;
        if (touchSearchView != null) {
            touchSearchView.r();
        }
    }

    public final void E2(CheckBox checkBox, Cursor cursor, CharSequence[] charSequenceArr) {
        String string = cursor.getString(cursor.getColumnIndex("name"));
        int i10 = cursor.getInt(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
        if (charSequenceArr == null) {
            return;
        }
        i iVar = new i(checkBox, i10, charSequenceArr, string);
        if (charSequenceArr.length == 2) {
            U0.b bVar = new U0.b(this, 2132083073);
            bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) iVar).setPositiveButton(charSequenceArr[0], (DialogInterface.OnClickListener) iVar).setNeutralButton(charSequenceArr[1], (DialogInterface.OnClickListener) iVar).setCancelable(false);
            Button b10 = bVar.show().b(-3);
            if (b10 != null) {
                b10.setTextColor(com.android.contacts.framework.baseui.util.r.a(this));
                return;
            }
            return;
        }
        new U0.b(this, 2132083073).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) iVar).setItems(charSequenceArr, (DialogInterface.OnClickListener) iVar).setCancelable(false).show();
    }

    public final void F2(Account account) {
        Intent intent = new Intent("com.oplus.contacts.ui.SELECT_CONTACTS_COPY_TO_SIM");
        intent.putExtra("account", account);
        intent.putExtra("title", getString(R.string.ps_import_x));
        intent.setPackage(getPackageName());
        R7.b.c(this, intent);
    }

    public void G2(Account account) {
        C0810v.g(this.f20615H.f().k());
        Account account2 = new Account(R0.a.f3165a, R0.a.f3166b);
        if (!this.f20620M && this.f20615H.i()) {
            this.f20615H.o();
        }
        Intent intent = new Intent("com.oplus.contacts.proc.COPY_CONTACTS_BETWEEN_ACCOUNTS");
        intent.setPackage(getPackageName());
        intent.putExtra("SRC_ACCOUNT", account);
        intent.putExtra("DEST_ACCOUNT", account2);
        intent.putExtra("SAME_NAME_POLICY", 0);
        intent.putExtra("title", getString(R.string.ps_export_x));
        intent.putExtra("imprort_sim_contacts", this.f20620M);
        if (this.f20620M) {
            Q7.b.b(this, intent, 1, 0);
        } else {
            R7.b.c(this, intent);
        }
    }

    public final void I2(boolean z10, boolean z11, boolean z12) {
        boolean z13;
        FrameLayout frameLayout = this.f20609B;
        boolean z14 = true;
        if (z12 && z11) {
            z13 = true;
        } else {
            z13 = false;
        }
        m1(frameLayout, z13);
        MultiChoiceListView multiChoiceListView = this.f20648z;
        if (!z12 || !z11) {
            z14 = false;
        }
        e1(multiChoiceListView, z14);
        if (z12 && z11) {
            Menu menu = this.f20610C.getMenu();
            for (int i10 = 0; i10 < menu.size(); i10++) {
                MenuItem item = menu.getItem(i10);
                item.setCheckable(false);
                item.setEnabled(z10);
                int i11 = this.f20623P;
                if (i11 == 10) {
                    item.setTitle(R.string.delete_description);
                    item.setIcon(getDrawable(R.drawable.pb_dr_menu_delete));
                } else if (i11 == 12) {
                    item.setTitle(R.string.confirm_description);
                    item.setIcon(getDrawable(R.drawable.pb_dr_menu_add));
                } else if (this.f20620M) {
                    item.setTitle(R.string.oplus_import_contacts_to_sim);
                    item.setIcon(getDrawable(R.drawable.pb_dr_menu_import));
                    if (C0637b.h()) {
                        item.setEnabled(false);
                    }
                } else {
                    item.setTitle(R.string.oplus_export_from_sim);
                    item.setIcon(getDrawable(R.drawable.pb_dr_menu_export));
                }
            }
        }
    }

    public void J2(int i10) {
        String I10 = com.customize.contacts.util.b0.I(this, i10);
        if (TextUtils.isEmpty(I10)) {
            this.f20608A.setTitle(R.string.simContacts_title);
        } else {
            this.f20608A.setTitle(I10);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean K0() {
        return this.f20615H.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            SimContactsOrderHelper.b().clear();
            if (this.f20632Y) {
                H7.b.b("SimContactsListActivity", "delay finish ");
                Thread.sleep(1000L);
            }
        } catch (Exception unused) {
            H7.b.b("SimContactsListActivity", "finish exception ");
        }
        if (H7.a.b()) {
            H7.b.b("SimContactsListActivity", "finish");
        }
        super.finish();
    }

    public CharSequence[] j2(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("number"));
        String string2 = cursor.getString(cursor.getColumnIndex("additionalNumber"));
        String string3 = cursor.getString(cursor.getColumnIndex("emails"));
        this.f20625R.clear();
        if (!TextUtils.isEmpty(string)) {
            this.f20625R.add(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            this.f20625R.add(string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            this.f20625R.add(string3);
        }
        if (this.f20625R.size() == 0) {
            return null;
        }
        int size = this.f20625R.size();
        CharSequence[] charSequenceArr = new CharSequence[size];
        for (int i10 = 0; i10 != size; i10++) {
            charSequenceArr[i10] = this.f20625R.get(i10);
        }
        return charSequenceArr;
    }

    public final void k2(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            runOnUiThread(new g(cursor));
        }
    }

    public final void l2() {
        C0810v.g(this.f20615H.f().k());
        if (this.f20615H.i()) {
            this.f20615H.o();
        }
        Intent intent = new Intent("com.oplus.contacts.proc.DELETE_SELECTED_SIM_CONTACTS");
        intent.setPackage(C7.e.g());
        intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, this.f20617J);
        R7.b.c(this, intent);
    }

    @Override // com.customize.contacts.util.C0806q.a
    public boolean m() {
        return this.f20616I;
    }

    public final void n2(boolean z10) {
        com.android.contacts.framework.baseui.util.A.a(getBaseContext(), 2000315, 200030129, null, false);
        if (!this.f20620M) {
            this.f20611D.f1(true);
            this.f20611D.g1(true);
        }
        this.f20623P = 10;
        this.f20615H.b();
        I2(z10, true, true);
        D(false);
    }

    public void o2(CharSequence charSequence) {
        int i10 = 0;
        if (charSequence.equals("*")) {
            this.f20648z.setSelection(0);
            return;
        }
        Object[] sections = this.f20611D.getSections();
        if (sections != null && sections.length != 0) {
            String charSequence2 = charSequence.toString();
            while (true) {
                if (i10 != sections.length) {
                    if (charSequence2.equals(sections[i10].toString())) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            int headerViewsCount = this.f20648z.getHeaderViewsCount();
            if (i10 != -1) {
                int positionForSection = this.f20611D.getPositionForSection(i10) + headerViewsCount;
                int i11 = this.f20628U;
                if (i11 > 0) {
                    this.f20648z.setSelectionFromTop(positionForSection + 1, i11);
                } else {
                    this.f20648z.setSelection(positionForSection + 1);
                }
                MultiChoiceListView multiChoiceListView = this.f20648z;
                multiChoiceListView.dispatchWindowVisibilityChanged(multiChoiceListView.getVisibility());
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            finish();
        } else if (i10 == 10 && i11 == -1) {
            l2();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        C0806q c0806q = this.f20615H;
        if (c0806q != null && c0806q.i()) {
            if (!this.f20620M && !this.f20619L) {
                this.f20615H.o();
                return;
            } else {
                super.onBackPressed();
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0806q c0806q;
        super.onConfigurationChanged(configuration);
        if (H7.a.b()) {
            H7.b.b("SimContactsListActivity", "onConfigurationChanged");
        }
        D2();
        TouchSearchView touchSearchView = this.f20643p;
        if (touchSearchView != null && (c0806q = this.f20615H) != null) {
            touchSearchView.q(c0806q.i());
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f20620M = C7.e.c(getIntent(), "imprort_sim_contacts", false);
        this.f20619L = C7.e.c(getIntent(), "ToSMS", false);
        super.onCreate(bundle);
        this.f20624Q = true;
        String l10 = C7.e.l(getIntent(), OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI);
        this.f20617J = l10;
        int K10 = com.customize.contacts.util.b0.K(this, l10);
        if (-1 == K10) {
            finish();
        }
        this.f20618K = K10;
        if (H7.a.b()) {
            H7.b.e("SimContactsListActivity", "onCreate: mIsImportSimContacts = " + this.f20620M + ", mToSMS = " + this.f20619L + ", mSlotId = " + this.f20618K);
        }
        setContentView(R.layout.contacts_list_layout);
        this.f20648z = (MultiChoiceListView) findViewById(android.R.id.list);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
        view.setVisibility(4);
        this.f20648z.addHeaderView(view);
        this.f20628U = dimensionPixelSize;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.f20648z.setNestedScrollingEnabled(true);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20629V = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        this.f20643p = (TouchSearchView) findViewById(R.id.spell_bar);
        TextView textView = (TextView) findViewById(R.id.empty_view);
        this.f20646x = textView;
        textView.setText(R.string.noContacts);
        this.f20647y = (ImageView) findViewById(R.id.no_content);
        if (B3.a.L()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20643p.getLayoutParams();
            layoutParams.setMarginEnd(getResources().getDimensionPixelOffset(R.dimen.curved_contactslist_margin));
            this.f20643p.setLayoutParams(layoutParams);
        }
        this.f20648z.setVisibility(8);
        this.f20643p.setVisibility(4);
        this.f20646x.setVisibility(8);
        m1.W w10 = new m1.W(this);
        this.f20611D = w10;
        this.f20648z.setAdapter((ListAdapter) w10);
        this.f20648z.setScrollMultiChoiceListener(this);
        this.f20648z.setOnTouchListener(this.f20638e0);
        this.f20648z.setOnItemClickListener(new c());
        this.f20648z.setOnItemLongClickListener(new d());
        this.f20648z.setOnScrollListener(new e());
        this.f20643p.setTouchSearchActionListener(this);
        I2(false, false, true);
        C0806q c0806q = new C0806q(this, this, this.f20640g0);
        this.f20615H = c0806q;
        this.f20611D.c1(c0806q);
        if (this.f20620M && bundle != null) {
            if (H7.a.b()) {
                H7.b.b("SimContactsListActivity", "onCreate get value from bundle by the key that is KEY_SELECTED_CONTACT_RECORDS");
            }
            Serializable serializable = bundle.getSerializable("selected_contact_records");
            if (serializable instanceof HashMap) {
                try {
                    this.f20637d0 = (HashMap) serializable;
                } catch (Exception e10) {
                    H7.b.c("SimContactsListActivity", "onCreate type cast error e:" + e10);
                }
            }
        }
        View H10 = this.f20611D.H(this, null);
        H10.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f20622O = H10.getMeasuredHeight();
        if (H7.a.b()) {
            H7.b.b("SimContactsListActivity", "regist local broadcast mSlotId : " + this.f20618K);
        }
        try {
            X.a b10 = X.a.b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("local.intent.action.SUBINFO_STATE_CHANGE");
            b10.c(this.f20639f0, intentFilter);
        } catch (Exception e11) {
            H7.b.b("SimContactsListActivity", "regist local broadcast error" + e11);
        }
        this.f20643p.O(findViewById(R.id.toolbar), null);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (10 == i10) {
            return p2();
        }
        return super.onCreateDialog(i10);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            X.a.b(this).e(this.f20639f0);
        } catch (Exception e10) {
            H7.b.b("SimContactsListActivity", "unregister local receiver error" + e10);
        }
        m2();
        super.onDestroy();
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        CheckBox checkBox;
        if (view == null) {
            return;
        }
        if (this.f20619L) {
            MultiChoiceListView multiChoiceListView = this.f20648z;
            if (multiChoiceListView != null) {
                multiChoiceListView.performItemClick(view, i10, 0L);
                return;
            }
            return;
        }
        C0806q c0806q = this.f20615H;
        if (c0806q == null || !c0806q.i() || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null) {
            return;
        }
        this.f20615H.k(checkBox);
        com.android.contacts.util.C.b(view, checkBox.isChecked());
        if (10 == this.f20623P) {
            this.f20640g0.d();
        }
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onKey(CharSequence charSequence) {
        if (this.f20643p == null) {
            return;
        }
        if (H7.a.b()) {
            H7.b.b("SimContactsListActivity", "onKey = " + ((Object) charSequence));
        }
        o2(charSequence);
        if (charSequence.equals("*")) {
            this.f20648z.setSelection(0);
            return;
        }
        if (charSequence.equals("#")) {
            this.f20643p.setName(new String[0]);
            return;
        }
        com.customize.contacts.util.I i10 = this.f20644q;
        if (i10 == null) {
            return;
        }
        i10.i(charSequence);
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onNameClick(CharSequence charSequence) {
        int q22;
        if (H7.a.b()) {
            H7.b.b("SimContactsListActivity", "onNameClick");
        }
        com.customize.contacts.util.I i10 = this.f20644q;
        if (i10 != null && (q22 = q2(i10.d()) + this.f20644q.b(charSequence)) != -1) {
            if (this.f20644q.h(charSequence)) {
                int i11 = this.f20628U;
                if (i11 > 0) {
                    this.f20648z.setSelectionFromTop(q22 + 1, i11);
                } else {
                    this.f20648z.setSelection(q22 + 1);
                }
            } else {
                int i12 = this.f20628U;
                if (i12 > 0) {
                    this.f20648z.setSelectionFromTop(q22 + 1, i12);
                } else {
                    this.f20648z.setSelectionFromTop(q22 + 1, this.f20622O);
                }
            }
            MultiChoiceListView multiChoiceListView = this.f20648z;
            multiChoiceListView.dispatchWindowVisibilityChanged(multiChoiceListView.getVisibility());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        H7.b.e("SimContactsListActivity", "onPause: ");
        this.f20630W = false;
        this.f20614G = false;
        unregisterReceiver(this.f20639f0);
        m2();
        super.onPause();
        com.customize.contacts.util.i0.b();
        com.customize.contacts.util.i0.f(null);
        this.f20629V.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (H7.a.b()) {
            H7.b.b("SimContactsListActivity", "onResume: mFinishWhenNextResumed -> " + this.f20631X);
        }
        this.f20614G = true;
        super.onResume();
        C0806q c0806q = this.f20615H;
        if (c0806q == null || !c0806q.i()) {
            if (H7.a.b()) {
                H7.b.b("SimContactsListActivity", "onResume start query");
            }
            H2();
        }
        String str = null;
        if (this.f20644q == null) {
            this.f20644q = new com.customize.contacts.util.I(this.f20643p, null, null);
        }
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(this, this.f20639f0, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        BroadcastReceiver broadcastReceiver = this.f20639f0;
        if (!OsUtils.f28279e) {
            str = R0.b.f3175i;
        }
        registerReceiver(broadcastReceiver, intentFilter, str, null, 2);
        com.customize.contacts.util.i0.f(this.f20643p);
        this.f20629V.onResume();
        this.f20630W = true;
        if (this.f20631X) {
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f20620M && this.f20615H != null) {
            if (H7.a.b()) {
                H7.b.b("SimContactsListActivity", "onSaveInstanceState to save state");
            }
            this.f20615H.n(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        com.customize.contacts.util.i0.d(this, this.f20648z);
    }

    public final Dialog p2() {
        int i10 = this.f20615H.f().i();
        int l10 = this.f20615H.f().l();
        if (l10 == 0) {
            return null;
        }
        String b10 = com.customize.contacts.util.X.b(this, i10, l10);
        l lVar = new l();
        androidx.appcompat.app.b show = ((U0.b) new U0.b(this, 2132083073).setTitle((CharSequence) b10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) lVar).setNeutralButton(com.customize.contacts.util.X.a(i10, l10), (DialogInterface.OnClickListener) lVar).setOnDismissListener(lVar)).show();
        show.setCanceledOnTouchOutside(true);
        return show;
    }

    public final ContactParcelable r2(Cursor cursor, CharSequence[] charSequenceArr) {
        ContactParcelable contactParcelable = new ContactParcelable();
        contactParcelable.q(cursor.getInt(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID)));
        contactParcelable.t(cursor.getString(cursor.getColumnIndex("name")));
        contactParcelable.w(charSequenceArr[0].toString());
        return contactParcelable;
    }

    public int s2() {
        return this.f20623P;
    }

    public int t2() {
        return this.f20618K;
    }

    public String u2(int i10) {
        if (i10 == 0) {
            return getString(R.string.select_item);
        }
        if (this.f20627T == null) {
            this.f20627T = getString(R.string.select_items);
        }
        return String.format(this.f20627T, Integer.valueOf(U7.a.b(i10)));
    }

    public void x2() {
        this.f20615H.l();
        this.f20640g0.d();
        this.f20611D.notifyDataSetChanged();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        this.f20609B = (FrameLayout) findViewById(R.id.navigation_view_panel);
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        this.f20610C = cOUINavigationView;
        cOUINavigationView.inflateMenu(R.menu.one_action);
        this.f20610C.setOnNavigationItemSelectedListener(new j());
    }

    public void y2() {
        if (this.f20621N) {
            I2(false, this.f20615H.i(), true);
            this.f20621N = false;
        }
    }

    public void z2() {
        if (!this.f20621N) {
            I2(true, this.f20615H.i(), true);
            this.f20621N = true;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Z3.h {
        public a() {
        }

        @Override // Z3.h
        public void a(boolean z10) {
            SimContactsListActivity.this.f20608A.getMenu().clear();
            if (z10) {
                SimContactsListActivity.this.f20608A.setIsTitleCenterStyle(false);
                SimContactsListActivity.this.f20608A.setNavigationIcon(R.drawable.coui_back_arrow);
                SimContactsListActivity.this.f20608A.setNavigationContentDescription(R.string.abc_action_bar_up_description);
                SimContactsListActivity.this.f20608A.inflateMenu(R.menu.sim_contact_menu);
                MenuItem findItem = SimContactsListActivity.this.f20608A.getMenu().findItem(R.id.add_menu);
                if (findItem != null) {
                    findItem.setTitle(R.string.insertContactDescription);
                }
                e();
                return;
            }
            SimContactsListActivity.this.f20608A.setNavigationIcon((Drawable) null);
            SimContactsListActivity.this.f20608A.setIsTitleCenterStyle(true);
            SimContactsListActivity.this.f20608A.inflateMenu(R.menu.cancel_select_menu);
        }

        @Override // Z3.h
        public void b() {
            a(false);
            SimContactsListActivity.this.D(false);
            TouchSearchView touchSearchView = SimContactsListActivity.this.f20643p;
            if (touchSearchView != null) {
                touchSearchView.q(true);
            }
            if (!SimContactsListActivity.this.f20620M && !SimContactsListActivity.this.f20619L) {
                SimContactsListActivity.this.f20611D.d1(true);
            } else {
                SimContactsListActivity.this.f20611D.d1(false);
            }
            SimContactsListActivity.this.f20611D.notifyDataSetChanged();
            d();
            SimContactsListActivity simContactsListActivity = SimContactsListActivity.this;
            simContactsListActivity.f1(simContactsListActivity, false, simContactsListActivity.K0());
        }

        @Override // Z3.h
        public void c() {
            if (SimContactsListActivity.this.f20619L) {
                SimContactsListActivity.this.finish();
                return;
            }
            if (SimContactsListActivity.this.f20620M) {
                SimContactsListActivity.this.finish();
                return;
            }
            TouchSearchView touchSearchView = SimContactsListActivity.this.f20643p;
            if (touchSearchView != null) {
                touchSearchView.q(false);
                SimContactsListActivity.this.f20643p.r();
            }
            SimContactsListActivity.this.f20611D.f1(true);
            SimContactsListActivity.this.f20611D.g1(true);
            a(true);
            SimContactsListActivity.this.I2(true, false, true);
            SimContactsListActivity.this.f20611D.d1(true);
            SimContactsListActivity.this.f20611D.notifyDataSetChanged();
            SimContactsListActivity simContactsListActivity = SimContactsListActivity.this;
            simContactsListActivity.f1(simContactsListActivity, true, simContactsListActivity.K0());
        }

        @Override // Z3.h
        public void d() {
            int e10 = SimContactsListActivity.this.f20615H.e();
            if (e10 == 0) {
                SimContactsListActivity.this.y2();
            } else {
                SimContactsListActivity.this.z2();
            }
            SimContactsListActivity.this.f20608A.setTitle(SimContactsListActivity.this.u2(e10));
            g();
        }

        @Override // Z3.h
        public void e() {
            if (!SimContactsListActivity.this.f20620M) {
                SimContactsListActivity simContactsListActivity = SimContactsListActivity.this;
                simContactsListActivity.J2(simContactsListActivity.t2());
            }
        }

        @Override // Z3.h
        public void g() {
            if (SimContactsListActivity.this.f20608A != null) {
                MenuItem findItem = SimContactsListActivity.this.f20608A.getMenu().findItem(R.id.select_all);
                if (SimContactsListActivity.this.f20615H.j()) {
                    findItem.setTitle(SimContactsListActivity.this.getString(R.string.oplus_option_selectcancel));
                } else {
                    findItem.setTitle(SimContactsListActivity.this.getString(R.string.oplus_option_selectall));
                }
                if (SimContactsListActivity.this.f20620M && SimContactsListActivity.this.f20615H.g() <= 0) {
                    findItem.setEnabled(false);
                } else {
                    findItem.setEnabled(true);
                }
            }
        }

        @Override // Z3.h
        public void f(boolean z10) {
        }
    }
}
