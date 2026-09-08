package com.customize.contacts.activities;

import N3.a;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.android.contacts.group.viewmodel.GroupBrowseListViewModel;
import com.android.contacts.model.Account;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.CommonTopTitlebarActivity;
import com.customize.contacts.manager.n;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.C0814z;
import com.customize.contacts.util.M;
import com.customize.contacts.util.UiMode$ActionModeType;
import com.google.android.material.navigation.NavigationBarView;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import o1.C1393c;
import q7.C1493b;
import q7.InterfaceC1492a;

/* loaded from: classes3.dex */
public class ViewGroupActivity extends CommonTopTitlebarActivity implements a.InterfaceC0047a, M.d, Y0.a, w7.b {

    /* renamed from: C0, reason: collision with root package name */
    public l f20694C0;

    /* renamed from: D0, reason: collision with root package name */
    public CancellationSignal f20695D0;

    /* renamed from: I0, reason: collision with root package name */
    public MenuItem f20700I0;

    /* renamed from: J0, reason: collision with root package name */
    public MenuItem f20701J0;

    /* renamed from: K0, reason: collision with root package name */
    public MenuItem f20702K0;

    /* renamed from: L0, reason: collision with root package name */
    public MenuItem f20703L0;

    /* renamed from: N0, reason: collision with root package name */
    public Bundle f20705N0;

    /* renamed from: O0, reason: collision with root package name */
    public U0.h f20706O0;

    /* renamed from: P0, reason: collision with root package name */
    public COUIPopupListWindow f20707P0;

    /* renamed from: W, reason: collision with root package name */
    public Cursor f20717W;

    /* renamed from: Z, reason: collision with root package name */
    public TextView f20723Z;

    /* renamed from: a0, reason: collision with root package name */
    public ImageView f20724a0;

    /* renamed from: b0, reason: collision with root package name */
    public View f20725b0;

    /* renamed from: c0, reason: collision with root package name */
    public FrameLayout f20726c0;

    /* renamed from: d0, reason: collision with root package name */
    public COUINavigationView f20727d0;

    /* renamed from: e0, reason: collision with root package name */
    public View f20728e0;

    /* renamed from: f0, reason: collision with root package name */
    public View f20729f0;

    /* renamed from: j0, reason: collision with root package name */
    public int f20733j0;

    /* renamed from: l0, reason: collision with root package name */
    public String f20735l0;

    /* renamed from: m0, reason: collision with root package name */
    public String f20736m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f20737n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f20738o0;

    /* renamed from: p0, reason: collision with root package name */
    public e f20739p0;

    /* renamed from: s0, reason: collision with root package name */
    public Z0.b f20742s0;

    /* renamed from: t0, reason: collision with root package name */
    public Dialog f20743t0;

    /* renamed from: T, reason: collision with root package name */
    public final Object f20711T = new Object();

    /* renamed from: U, reason: collision with root package name */
    public UiMode$ActionModeType f20713U = UiMode$ActionModeType.NORMAL_MODE;

    /* renamed from: V, reason: collision with root package name */
    public P3.c f20715V = null;

    /* renamed from: X, reason: collision with root package name */
    public P3.b f20719X = null;

    /* renamed from: Y, reason: collision with root package name */
    public List<IdRecord> f20721Y = null;

    /* renamed from: g0, reason: collision with root package name */
    public int f20730g0 = 0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f20731h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    public long f20732i0 = -1;

    /* renamed from: k0, reason: collision with root package name */
    public HeaderFooterRecyclerView f20734k0 = null;

    /* renamed from: q0, reason: collision with root package name */
    public P3.h f20740q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    public N3.i<IdRecord> f20741r0 = null;

    /* renamed from: u0, reason: collision with root package name */
    public String f20744u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    public androidx.appcompat.app.b f20745v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f20746w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f20747x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public HashMap<Account, Long> f20748y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    public ArrayList<Account> f20749z0 = null;

    /* renamed from: A0, reason: collision with root package name */
    public int f20692A0 = 0;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f20693B0 = false;

    /* renamed from: E0, reason: collision with root package name */
    public androidx.appcompat.app.b f20696E0 = null;

    /* renamed from: F0, reason: collision with root package name */
    public UiMode$ActionModeType f20697F0 = null;

    /* renamed from: G0, reason: collision with root package name */
    public N3.a f20698G0 = null;

    /* renamed from: H0, reason: collision with root package name */
    public String f20699H0 = null;

    /* renamed from: M0, reason: collision with root package name */
    public boolean f20704M0 = false;

    /* renamed from: Q0, reason: collision with root package name */
    public ArrayList<PopupListItem> f20708Q0 = null;

    /* renamed from: R0, reason: collision with root package name */
    public HashMap<String, Integer> f20709R0 = null;

    /* renamed from: S0, reason: collision with root package name */
    public androidx.appcompat.app.b f20710S0 = null;

    /* renamed from: T0, reason: collision with root package name */
    public String f20712T0 = com.customize.contacts.util.K.a();

    /* renamed from: U0, reason: collision with root package name */
    public boolean f20714U0 = false;

    /* renamed from: V0, reason: collision with root package name */
    public final InterfaceC1492a f20716V0 = new C1493b();

    /* renamed from: W0, reason: collision with root package name */
    public final Handler f20718W0 = new a(Looper.getMainLooper());

    /* renamed from: X0, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f20720X0 = new c();

    /* renamed from: Y0, reason: collision with root package name */
    public Z3.h f20722Y0 = new d();

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10;
            if (message.what == 5) {
                n.i iVar = (n.i) message.obj;
                if (ViewGroupActivity.this.f20730g0 == 4) {
                    i10 = 3;
                } else {
                    i10 = 2;
                }
                int i11 = i10;
                if (!ViewGroupActivity.this.isDestroyed() && !ViewGroupActivity.this.isFinishing()) {
                    com.customize.contacts.manager.n.B(null, ViewGroupActivity.this, iVar, i11, false, false, null);
                } else {
                    return;
                }
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            boolean z10;
            if (ViewGroupActivity.this.f20740q0 != null) {
                P3.h hVar = ViewGroupActivity.this.f20740q0;
                if (i10 == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                hVar.s(z10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (ViewGroupActivity.this.f20740q0 != null) {
                ViewGroupActivity.this.f20740q0.s(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (C7.a.a()) {
                return;
            }
            if (ViewGroupActivity.this.f20707P0 != null) {
                ViewGroupActivity.this.f20707P0.dismiss();
            }
            Integer num = (Integer) ViewGroupActivity.this.f20709R0.get(((PopupListItem) ViewGroupActivity.this.f20708Q0.get(i10)).getTitle());
            if (num == null) {
                return;
            }
            int intValue = num.intValue();
            if (intValue != 0) {
                if (intValue != 1) {
                    if (intValue == 2) {
                        com.android.contacts.framework.baseui.util.A.a(ViewGroupActivity.this.getBaseContext(), 2000308, 200030054, null, false);
                        ViewGroupActivity.this.X3();
                        return;
                    }
                    return;
                }
                com.android.contacts.framework.baseui.util.A.a(ViewGroupActivity.this.getBaseContext(), 2000308, 200030055, null, false);
                if (com.android.contacts.util.w.k(ViewGroupActivity.this.getBaseContext(), com.android.contacts.util.w.e())) {
                    ViewGroupActivity.this.a4();
                    return;
                } else {
                    ViewGroupActivity.this.requestPermissions(new String[]{com.android.contacts.util.w.e()}, 11);
                    return;
                }
            }
            ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
            viewGroupActivity.f20713U = UiMode$ActionModeType.EDIT_MODE;
            viewGroupActivity.f20722Y0.b();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Z3.h {
        public d() {
        }

        @Override // Z3.h
        public void a(boolean z10) {
            ViewGroupActivity.this.f20571x.getMenu().clear();
            if (z10) {
                ViewGroupActivity.this.f20571x.setIsTitleCenterStyle(false);
                ViewGroupActivity.this.f20571x.setNavigationIcon(R.drawable.coui_back_arrow);
                ViewGroupActivity.this.f20571x.setNavigationContentDescription(R.string.abc_action_bar_up_description);
                ViewGroupActivity.this.f20571x.inflateMenu(R.menu.view_group_menu);
                ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
                viewGroupActivity.f20700I0 = viewGroupActivity.f20571x.getMenu().findItem(R.id.add_menu);
                ViewGroupActivity viewGroupActivity2 = ViewGroupActivity.this;
                viewGroupActivity2.f20701J0 = viewGroupActivity2.f20571x.getMenu().findItem(R.id.setting_menu);
                ViewGroupActivity viewGroupActivity3 = ViewGroupActivity.this;
                viewGroupActivity3.f20703L0 = viewGroupActivity3.f20571x.getMenu().findItem(R.id.scan_menu);
                ViewGroupActivity viewGroupActivity4 = ViewGroupActivity.this;
                viewGroupActivity4.f20702K0 = viewGroupActivity4.f20571x.getMenu().findItem(R.id.edit_menu);
                if (ViewGroupActivity.this.f20700I0 != null) {
                    ViewGroupActivity.this.f20700I0.setTitle(R.string.oplus_add_group_member);
                }
                ViewGroupActivity.this.b4();
                e();
                return;
            }
            ViewGroupActivity.this.f20571x.setIsTitleCenterStyle(true);
            ViewGroupActivity.this.f20571x.setNavigationIcon((Drawable) null);
            ViewGroupActivity.this.f20571x.inflateMenu(R.menu.cancel_select_menu);
        }

        @Override // Z3.h
        public void b() {
            ViewGroupActivity.this.f20704M0 = true;
            a(false);
            ViewGroupActivity.this.f20715V.x();
            ViewGroupActivity.this.f2(false);
            ViewGroupActivity.this.c4(true, false);
            if (ViewGroupActivity.this.f20734k0 != null) {
                boolean j10 = DisplayUtil.j(ViewGroupActivity.this);
                if ((DisplayUtil.i(ViewGroupActivity.this) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(ViewGroupActivity.this))) {
                    ViewGroupActivity.this.f20734k0.i(ViewGroupActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_145), 0, 0, 0);
                } else if (FeatureUtil.V() && !j10) {
                    ViewGroupActivity.this.f20734k0.i(ViewGroupActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_245), 0, 0, 0);
                } else {
                    ViewGroupActivity.this.f20734k0.i(ViewGroupActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_60), 0, 0, 0);
                }
            }
            ViewGroupActivity.this.f20740q0.r(true);
            ViewGroupActivity.this.f20740q0.s(true);
            ViewGroupActivity.this.f20740q0.notifyDataSetChanged();
            d();
            ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
            viewGroupActivity.f1(viewGroupActivity, false, viewGroupActivity.K0());
        }

        @Override // Z3.h
        public void c() {
            ViewGroupActivity.this.f20704M0 = false;
            ViewGroupActivity.this.f20715V.x();
            ViewGroupActivity.this.f2(false);
            ViewGroupActivity.this.U3();
            ViewGroupActivity.this.f20697F0 = null;
            a(true);
            e();
            f(true);
            ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
            viewGroupActivity.f1(viewGroupActivity, true, viewGroupActivity.K0());
            if (ViewGroupActivity.this.f20734k0 != null) {
                ViewGroupActivity.this.f20734k0.k();
            }
        }

        @Override // Z3.h
        public void d() {
            boolean z10;
            if (!ViewGroupActivity.this.f20704M0) {
                return;
            }
            if (ViewGroupActivity.this.f20744u0 == null) {
                ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
                viewGroupActivity.f20744u0 = viewGroupActivity.getString(R.string.select_items);
            }
            int a22 = ViewGroupActivity.this.a2();
            ViewGroupActivity viewGroupActivity2 = ViewGroupActivity.this;
            boolean z11 = false;
            if (a22 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            viewGroupActivity2.c4(true, z10);
            ViewGroupActivity viewGroupActivity3 = ViewGroupActivity.this;
            COUIToolbar cOUIToolbar = viewGroupActivity3.f20571x;
            if (cOUIToolbar != null) {
                if (a22 == 0) {
                    cOUIToolbar.setTitle(R.string.select_item);
                } else {
                    cOUIToolbar.setTitle(String.format(viewGroupActivity3.f20744u0, Integer.valueOf(U7.a.b(ViewGroupActivity.this.a2()))));
                }
            }
            ViewGroupActivity viewGroupActivity4 = ViewGroupActivity.this;
            if (a22 == viewGroupActivity4.b2()) {
                z11 = true;
            }
            viewGroupActivity4.f20190R = z11;
            g();
        }

        @Override // Z3.h
        public void e() {
            if (3 == ViewGroupActivity.this.f20730g0) {
                ViewGroupActivity.this.f20571x.setTitle(R.string.oplus_smart_group_no_company_title);
            } else if (6 == ViewGroupActivity.this.f20730g0) {
                ViewGroupActivity.this.f20571x.setTitle(R.string.oplus_business_card);
            } else {
                ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
                viewGroupActivity.f20571x.setTitle(viewGroupActivity.f20735l0);
            }
        }

        @Override // Z3.h
        public void f(boolean z10) {
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15 = false;
            if (4 != ViewGroupActivity.this.f20730g0 && ViewGroupActivity.this.f20730g0 != 0) {
                if (ViewGroupActivity.this.f20701J0 != null) {
                    MenuItem menuItem = ViewGroupActivity.this.f20701J0;
                    if (z10 && 6 != ViewGroupActivity.this.f20730g0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    menuItem.setVisible(z14);
                }
            } else if (ViewGroupActivity.this.f20701J0 != null) {
                if (!CommonFeatureOption.j() && 4 == ViewGroupActivity.this.f20730g0) {
                    MenuItem menuItem2 = ViewGroupActivity.this.f20701J0;
                    if (ViewGroupActivity.this.f20733j0 > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    menuItem2.setVisible(z11);
                } else {
                    ViewGroupActivity.this.f20701J0.setVisible(true);
                }
            }
            if (ViewGroupActivity.this.f20700I0 != null) {
                MenuItem menuItem3 = ViewGroupActivity.this.f20700I0;
                if (4 != ViewGroupActivity.this.f20730g0 && ViewGroupActivity.this.f20730g0 != 0) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                menuItem3.setVisible(z13);
            }
            if (ViewGroupActivity.this.f20702K0 != null) {
                MenuItem menuItem4 = ViewGroupActivity.this.f20702K0;
                if (6 == ViewGroupActivity.this.f20730g0 && z10) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                menuItem4.setVisible(z12);
            }
            if (ViewGroupActivity.this.f20703L0 != null) {
                MenuItem menuItem5 = ViewGroupActivity.this.f20703L0;
                if (6 == ViewGroupActivity.this.f20730g0) {
                    z15 = true;
                }
                menuItem5.setVisible(z15);
                if (6 == ViewGroupActivity.this.f20730g0) {
                    ViewGroupActivity.this.f20703L0.setEnabled(!ViewGroupActivity.this.isInMultiWindowMode());
                }
            }
        }

        @Override // Z3.h
        public void g() {
            ViewGroupActivity viewGroupActivity = ViewGroupActivity.this;
            COUIToolbar cOUIToolbar = viewGroupActivity.f20571x;
            if (cOUIToolbar == null) {
                return;
            }
            if (viewGroupActivity.f20190R) {
                cOUIToolbar.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
            } else {
                cOUIToolbar.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20754a;

        /* renamed from: b, reason: collision with root package name */
        public final Intent f20755b;

        /* renamed from: c, reason: collision with root package name */
        public final WeakReference<ViewGroupActivity> f20756c;

        public final void a(ArrayList<ContentProviderOperation> arrayList) {
            ViewGroupActivity viewGroupActivity = this.f20756c.get();
            if (viewGroupActivity != null && !viewGroupActivity.isFinishing() && !viewGroupActivity.isDestroyed()) {
                if (f()) {
                    if (H7.a.b()) {
                        H7.b.b("ViewGroupActivity", "applyOperation, canceled");
                        return;
                    }
                    return;
                }
                try {
                    viewGroupActivity.getContentResolver().applyBatch("com.android.contacts", arrayList);
                    arrayList.size();
                } catch (OperationApplicationException | RemoteException e10) {
                    H7.b.c("ViewGroupActivity", "applyOperation(), exception happen");
                    H7.b.c("ViewGroupActivity", "Exception e: " + e10);
                }
            }
        }

        public final ArrayList<ContentProviderOperation> b(Intent intent) {
            HashMap<Long, ArrayList<Long>> hashMap;
            HashMap<Long, ArrayList<IdRecord>> hashMap2;
            ViewGroupActivity viewGroupActivity = this.f20756c.get();
            if (viewGroupActivity == null || viewGroupActivity.isFinishing() || viewGroupActivity.isDestroyed() || !intent.hasExtra("NEW_RET_CONTACTS") || f()) {
                return null;
            }
            ArrayList<IdRecord> i10 = C7.e.i(intent, "NEW_RET_CONTACTS");
            int size = i10.size();
            viewGroupActivity.f20692A0 = size;
            if (H7.a.b()) {
                H7.b.b("ViewGroupActivity", "lstReturnRecord size = " + size);
            }
            StringBuilder sb = new StringBuilder();
            for (int i11 = 0; i11 < size; i11++) {
                sb.append(((IdRecord) i10.get(i11)).b());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                if (viewGroupActivity.f20730g0 == 4) {
                    hashMap2 = N3.b.o(viewGroupActivity.getContentResolver(), sb.toString(), viewGroupActivity.f20749z0, size);
                    hashMap = null;
                } else {
                    hashMap = N3.b.p(viewGroupActivity.getContentResolver(), sb.toString(), viewGroupActivity.f20736m0, viewGroupActivity.f20737n0, size);
                    hashMap2 = null;
                }
            } else {
                hashMap = new HashMap<>();
                hashMap2 = new HashMap<>();
            }
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            for (IdRecord idRecord : i10) {
                if (f()) {
                    return null;
                }
                if (H7.a.b()) {
                    H7.b.b("ViewGroupActivity", "member " + idRecord.b() + " is new insert---------");
                }
                if (viewGroupActivity.f20730g0 == 4) {
                    if (hashMap2 == null) {
                        return null;
                    }
                    d(arrayList, hashMap2.get(Long.valueOf(idRecord.b())));
                } else {
                    if (hashMap == null) {
                        return null;
                    }
                    c(arrayList, hashMap.get(Long.valueOf(idRecord.b())));
                }
            }
            return arrayList;
        }

        public void c(List<ContentProviderOperation> list, List<Long> list2) {
            ViewGroupActivity viewGroupActivity = this.f20756c.get();
            if (viewGroupActivity == null || viewGroupActivity.isFinishing() || viewGroupActivity.isDestroyed() || C0811w.g(list2)) {
                return;
            }
            for (Long l10 : list2) {
                if (l10 != null) {
                    ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
                    newInsert.withValue("data1", Long.valueOf(viewGroupActivity.f20732i0));
                    newInsert.withValue("mimetype", "vnd.android.cursor.item/group_membership");
                    newInsert.withValue("raw_contact_id", l10);
                    list.add(newInsert.build());
                }
            }
        }

        public final void d(List<ContentProviderOperation> list, ArrayList<IdRecord> arrayList) {
            long j10;
            ViewGroupActivity viewGroupActivity = this.f20756c.get();
            if (viewGroupActivity == null || viewGroupActivity.isFinishing() || viewGroupActivity.isDestroyed() || C0811w.g(arrayList)) {
                return;
            }
            if (viewGroupActivity.f20748y0 == null) {
                viewGroupActivity.f20748y0 = new HashMap();
            }
            Iterator<IdRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                IdRecord next = it.next();
                if (next != null) {
                    ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
                    Account d10 = next.d();
                    if (!viewGroupActivity.f20748y0.isEmpty() && viewGroupActivity.f20748y0.containsKey(d10)) {
                        Long l10 = (Long) viewGroupActivity.f20748y0.get(d10);
                        if (l10 != null) {
                            j10 = l10.longValue();
                        } else {
                            j10 = -1;
                        }
                    } else {
                        j10 = N3.b.j(viewGroupActivity, "Vip in ColorOS", d10);
                    }
                    if (j10 == -1) {
                        j10 = N3.b.h(viewGroupActivity, d10);
                        viewGroupActivity.f20748y0.put(d10, Long.valueOf(j10));
                    }
                    newInsert.withValue("data1", Long.valueOf(j10));
                    newInsert.withValue("mimetype", "vnd.android.cursor.item/group_membership");
                    newInsert.withValue("raw_contact_id", Long.valueOf(next.i()));
                    list.add(newInsert.build());
                }
                if (viewGroupActivity.f20698G0 != null) {
                    viewGroupActivity.f20698G0.a().Q(C0814z.b(viewGroupActivity.f20748y0));
                }
            }
        }

        public void e() {
            this.f20754a = true;
        }

        public boolean f() {
            return this.f20754a;
        }

        public final void g(ArrayList<ContentProviderOperation> arrayList) {
            if (arrayList.size() < 40) {
                a(arrayList);
                return;
            }
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>(40);
            Iterator<ContentProviderOperation> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentProviderOperation next = it.next();
                if (f()) {
                    if (H7.a.b()) {
                        H7.b.b("ViewGroupActivity", "splitOperationAndApplyOperation(), canceled1");
                        return;
                    }
                    return;
                } else {
                    arrayList2.add(next);
                    if (arrayList2.size() >= 40) {
                        a(arrayList2);
                        arrayList2.clear();
                    }
                }
            }
            if (arrayList2.size() > 0) {
                if (f()) {
                    if (H7.a.b()) {
                        H7.b.b("ViewGroupActivity", "splitOperationAndApplyOperation(), canceled2");
                        return;
                    }
                    return;
                }
                a(arrayList2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroupActivity viewGroupActivity = this.f20756c.get();
            if (viewGroupActivity != null && !viewGroupActivity.isFinishing() && !viewGroupActivity.isDestroyed()) {
                long currentTimeMillis = System.currentTimeMillis();
                viewGroupActivity.f20694C0.sendEmptyMessage(0);
                ArrayList<ContentProviderOperation> b10 = b(this.f20755b);
                if (!C0811w.g(b10)) {
                    g(b10);
                }
                if (viewGroupActivity.f20730g0 == 4) {
                    viewGroupActivity.f20693B0 = BlackListUtils.l(viewGroupActivity, N3.b.k());
                    N3.b.f();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (H7.a.b()) {
                    H7.b.e("ViewGroupActivity", "elapsed = " + currentTimeMillis2);
                }
                if (currentTimeMillis2 < 1100) {
                    viewGroupActivity.f20694C0.sendEmptyMessageDelayed(2, 1100 - currentTimeMillis2);
                } else {
                    viewGroupActivity.f20694C0.sendEmptyMessage(2);
                }
            }
        }

        public e(ViewGroupActivity viewGroupActivity, Intent intent) {
            this.f20754a = false;
            this.f20755b = intent;
            this.f20756c = new WeakReference<>(viewGroupActivity);
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ViewGroupActivity> f20757a;

        public f(ViewGroupActivity viewGroupActivity) {
            this.f20757a = new WeakReference<>(viewGroupActivity);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            Object obj;
            ViewGroupActivity viewGroupActivity = this.f20757a.get();
            if (viewGroupActivity != null) {
                try {
                    try {
                        viewGroupActivity.f20715V.p();
                        viewGroupActivity.f20746w0 = true;
                        synchronized (viewGroupActivity.f20711T) {
                            obj = viewGroupActivity.f20711T;
                            obj.notifyAll();
                        }
                        viewGroupActivity = obj;
                    } catch (Exception e10) {
                        H7.b.b("ViewGroupActivity", "Exception : " + e10);
                        viewGroupActivity.f20746w0 = true;
                        synchronized (viewGroupActivity.f20711T) {
                            Object obj2 = viewGroupActivity.f20711T;
                            obj2.notifyAll();
                            viewGroupActivity = obj2;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                        throw th;
                    }
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            ViewGroupActivity viewGroupActivity = this.f20757a.get();
            if (viewGroupActivity != null) {
                if (viewGroupActivity.f20745v0 != null && viewGroupActivity.f20745v0.isShowing()) {
                    viewGroupActivity.f20745v0.dismiss();
                    viewGroupActivity.f20745v0 = null;
                }
                viewGroupActivity.A3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ViewGroupActivity> f20758a;

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            ViewGroupActivity viewGroupActivity = this.f20758a.get();
            if (viewGroupActivity != null && !viewGroupActivity.isDestroyed() && !viewGroupActivity.isFinishing()) {
                Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, viewGroupActivity.f20732i0);
                if (viewGroupActivity.f20732i0 < 0) {
                    return null;
                }
                try {
                    Cursor query = viewGroupActivity.getContentResolver().query(withAppendedId, new String[]{"title", "account_name", "account_type", C0814z.a.f22206a}, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                viewGroupActivity.f20735l0 = query.getString(0);
                                viewGroupActivity.f20736m0 = query.getString(1);
                                viewGroupActivity.f20737n0 = query.getString(2);
                                viewGroupActivity.f20738o0 = query.getString(3);
                                viewGroupActivity.f20714U0 = true;
                            }
                        } finally {
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e10) {
                    H7.b.c("ViewGroupActivity", "" + e10);
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void onPostExecute(Void r12) {
            ViewGroupActivity viewGroupActivity = this.f20758a.get();
            if (viewGroupActivity != null && !viewGroupActivity.isDestroyed() && !viewGroupActivity.isFinishing()) {
                viewGroupActivity.u3();
            }
        }

        public g(ViewGroupActivity viewGroupActivity) {
            this.f20758a = new WeakReference<>(viewGroupActivity);
        }

        @Override // android.os.AsyncTask
        public final void onPreExecute() {
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ViewGroupActivity> f20759a;

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            ViewGroupActivity viewGroupActivity = this.f20759a.get();
            if (viewGroupActivity != null) {
                viewGroupActivity.f20749z0 = M3.c.f(viewGroupActivity, false, false, false);
                Long l10 = -1L;
                if (viewGroupActivity.f20748y0 != null && viewGroupActivity.f20748y0.size() > 0) {
                    Iterator it = viewGroupActivity.f20748y0.keySet().iterator();
                    if (it.hasNext()) {
                        l10 = (Long) viewGroupActivity.f20748y0.get((Account) it.next());
                    }
                }
                if (l10 != null && l10.longValue() >= 0) {
                    String D32 = viewGroupActivity.D3(viewGroupActivity, l10.longValue());
                    if (!TextUtils.isEmpty(D32)) {
                        viewGroupActivity.f20738o0 = D32;
                    }
                }
                return null;
            }
            return null;
        }

        public h(ViewGroupActivity viewGroupActivity) {
            this.f20759a = new WeakReference<>(viewGroupActivity);
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends com.android.contacts.util.D<Void, Void, Void, ViewGroupActivity> {

        /* renamed from: b, reason: collision with root package name */
        public final Intent f20760b;

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void a(ViewGroupActivity viewGroupActivity, Void... voidArr) {
            String str;
            if (viewGroupActivity == null || viewGroupActivity.isDestroyed() || viewGroupActivity.isFinishing()) {
                return null;
            }
            Uri uri = (Uri) C7.e.j(this.f20760b, "android.intent.extra.ringtone.PICKED_URI");
            try {
                try {
                    if (viewGroupActivity.f20730g0 == 4) {
                        com.customize.contacts.manager.i.q(viewGroupActivity, viewGroupActivity.f20748y0, uri);
                    } else {
                        com.customize.contacts.manager.i.o(viewGroupActivity, viewGroupActivity.f20732i0, uri);
                    }
                    Uri h10 = com.customize.contacts.manager.i.h(uri, viewGroupActivity);
                    if (h10 != null) {
                        str = h10.toString();
                    } else {
                        str = null;
                    }
                    viewGroupActivity.f20738o0 = str;
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                    }
                } catch (Exception e10) {
                    H7.b.b("ViewGroupActivity", "Exception : " + e10);
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                    }
                }
                return null;
            } catch (Throwable th) {
                viewGroupActivity.f20746w0 = true;
                synchronized (viewGroupActivity.f20711T) {
                    viewGroupActivity.f20711T.notifyAll();
                    throw th;
                }
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(ViewGroupActivity viewGroupActivity, Void r22) {
            if (viewGroupActivity != null && !viewGroupActivity.isDestroyed() && !viewGroupActivity.isFinishing() && viewGroupActivity.f20745v0 != null && viewGroupActivity.f20745v0.isShowing()) {
                viewGroupActivity.f20745v0.dismiss();
                viewGroupActivity.f20745v0 = null;
            }
        }

        public i(ViewGroupActivity viewGroupActivity, Intent intent) {
            super(viewGroupActivity);
            this.f20760b = intent;
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends com.android.contacts.util.D<Void, Void, Void, ViewGroupActivity> {
        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void a(ViewGroupActivity viewGroupActivity, Void... voidArr) {
            if (viewGroupActivity == null || viewGroupActivity.isDestroyed() || viewGroupActivity.isFinishing()) {
                return null;
            }
            try {
                try {
                    long w32 = viewGroupActivity.w3(viewGroupActivity);
                    if (w32 != -1) {
                        viewGroupActivity.f20738o0 = viewGroupActivity.D3(viewGroupActivity, w32);
                        if (H7.a.b()) {
                            H7.b.b("ViewGroupActivity", "startSetGroupRing groupId = " + w32 + " ,ringtone = " + viewGroupActivity.f20738o0);
                        }
                    }
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                    }
                } catch (Exception e10) {
                    H7.b.b("ViewGroupActivity", "Exception : " + e10);
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                    }
                }
                return null;
            } catch (Throwable th) {
                viewGroupActivity.f20746w0 = true;
                synchronized (viewGroupActivity.f20711T) {
                    viewGroupActivity.f20711T.notifyAll();
                    throw th;
                }
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(ViewGroupActivity viewGroupActivity, Void r22) {
            if (viewGroupActivity != null && !viewGroupActivity.isDestroyed() && !viewGroupActivity.isFinishing()) {
                if (viewGroupActivity.f20745v0 != null && viewGroupActivity.f20745v0.isShowing()) {
                    viewGroupActivity.f20745v0.dismiss();
                    viewGroupActivity.f20745v0 = null;
                }
                com.customize.contacts.manager.i.b(viewGroupActivity, viewGroupActivity.f20738o0, viewGroupActivity.getString(R.string.oplus_title_menu_group_ringtone_set));
            }
        }

        public j(ViewGroupActivity viewGroupActivity) {
            super(viewGroupActivity);
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ViewGroupActivity> f20761a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20762b;

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            ViewGroupActivity viewGroupActivity = this.f20761a.get();
            if (viewGroupActivity == null || viewGroupActivity.isFinishing() || viewGroupActivity.isDestroyed()) {
                return null;
            }
            try {
                try {
                    if (TextUtils.isEmpty(viewGroupActivity.f20736m0)) {
                        viewGroupActivity.f20736m0 = R0.a.f3165a;
                    }
                    if (TextUtils.isEmpty(viewGroupActivity.f20737n0)) {
                        viewGroupActivity.f20737n0 = R0.a.f3166b;
                    }
                    if (N3.b.m(viewGroupActivity, this.f20762b, new Account(viewGroupActivity.f20736m0, viewGroupActivity.f20737n0))) {
                        String string = viewGroupActivity.getString(R.string.oplus_group_name_exist);
                        viewGroupActivity.f20746w0 = true;
                        synchronized (viewGroupActivity.f20711T) {
                            viewGroupActivity.f20711T.notifyAll();
                        }
                        return string;
                    }
                    Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, viewGroupActivity.f20732i0);
                    ContentValues contentValues = new ContentValues(1);
                    contentValues.put("title", this.f20762b);
                    if (G7.c.g(viewGroupActivity.getContentResolver(), R0.d.a(withAppendedId), contentValues, null, null) != -1) {
                        viewGroupActivity.f20735l0 = this.f20762b;
                        viewGroupActivity.f20746w0 = true;
                        synchronized (viewGroupActivity.f20711T) {
                            viewGroupActivity.f20711T.notifyAll();
                        }
                        return null;
                    }
                    String string2 = viewGroupActivity.getString(R.string.operation_error);
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                    }
                    return string2;
                } catch (Exception e10) {
                    H7.b.b("ViewGroupActivity", "Exception : " + e10);
                    viewGroupActivity.f20746w0 = true;
                    synchronized (viewGroupActivity.f20711T) {
                        viewGroupActivity.f20711T.notifyAll();
                        return null;
                    }
                }
            } catch (Throwable th) {
                viewGroupActivity.f20746w0 = true;
                synchronized (viewGroupActivity.f20711T) {
                    viewGroupActivity.f20711T.notifyAll();
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void onPostExecute(String str) {
            ViewGroupActivity viewGroupActivity = this.f20761a.get();
            if (viewGroupActivity != null && !viewGroupActivity.isFinishing() && !viewGroupActivity.isDestroyed()) {
                if (viewGroupActivity.f20745v0 != null && viewGroupActivity.f20745v0.isShowing()) {
                    viewGroupActivity.f20745v0.dismiss();
                    viewGroupActivity.f20745v0 = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    com.oplus.foundation.util.ui.c.c(viewGroupActivity, str);
                } else {
                    viewGroupActivity.f20571x.setTitle(viewGroupActivity.f20735l0);
                }
            }
        }

        public k(ViewGroupActivity viewGroupActivity, String str) {
            this.f20761a = new WeakReference<>(viewGroupActivity);
            this.f20762b = str;
        }

        @Override // android.os.AsyncTask
        public final void onPreExecute() {
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ViewGroupActivity> f20763a;

        public l(ViewGroupActivity viewGroupActivity) {
            this.f20763a = new WeakReference<>(viewGroupActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ViewGroupActivity viewGroupActivity = this.f20763a.get();
            if (viewGroupActivity == null) {
                return;
            }
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    if (viewGroupActivity.f20739p0 != null) {
                        viewGroupActivity.f20696E0 = U0.k.o(viewGroupActivity, viewGroupActivity.getString(R.string.oplus_group_add_member_message));
                    }
                } else if (2 == i10) {
                    viewGroupActivity.z3();
                    if (viewGroupActivity.isFinishing()) {
                        return;
                    }
                    if (viewGroupActivity.f20730g0 == 4 && viewGroupActivity.f20693B0) {
                        if (viewGroupActivity.f20692A0 == 1) {
                            com.oplus.foundation.util.ui.c.d(viewGroupActivity, R.string.oplus_remove_from_backlist);
                        } else {
                            com.oplus.foundation.util.ui.c.d(viewGroupActivity, R.string.oplus_remove_contacts_from_backlist);
                        }
                    }
                    if (1 == viewGroupActivity.f20730g0) {
                        viewGroupActivity.Z3();
                    }
                }
            } catch (Exception e10) {
                H7.b.c("ViewGroupActivity", "Exception e: " + e10);
            }
        }
    }

    private void F3(final View view, int i10, final int i11, final int i12) {
        view.setBackgroundColor(com.android.contacts.framework.baseui.util.r.b(this));
        Cursor m10 = this.f20740q0.m();
        if (m10 == null) {
            return;
        }
        m10.moveToPosition(i10);
        final String string = m10.getString(1);
        final long j10 = m10.getLong(0);
        final String string2 = m10.getString(5);
        final String string3 = m10.getString(4);
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "contactId = " + j10 + ", lookupKey = " + string2);
        }
        CancellationSignal cancellationSignal = this.f20695D0;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        this.f20695D0 = new CancellationSignal();
        this.f20718W0.post(new Runnable() { // from class: com.customize.contacts.activities.D0
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroupActivity.this.I3(j10, view, string, string2, string3, i11, i12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean J3(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.menu_email) {
            if (itemId != R.id.menu_remove_member) {
                if (itemId == R.id.menu_sms) {
                    this.f20713U = UiMode$ActionModeType.SMS_MODE;
                    Q3();
                    return true;
                }
                return true;
            }
            this.f20713U = UiMode$ActionModeType.EDIT_MODE;
            Q3();
            return true;
        }
        this.f20713U = UiMode$ActionModeType.EMAIL_MODE;
        Q3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4(boolean z10, boolean z11) {
        m1(this.f20726c0, z10);
        k1(z10);
        if (z10) {
            boolean z12 = true;
            if (this.f20713U != this.f20697F0 && (B3.a.n() || !P7.c.f(this, "com.android.mms", true))) {
                this.f20727d0.getMenu().removeItem(R.id.menu_sms);
            }
            MenuItem findItem = this.f20727d0.getMenu().findItem(R.id.menu_sms);
            MenuItem findItem2 = this.f20727d0.getMenu().findItem(R.id.menu_email);
            MenuItem findItem3 = this.f20727d0.getMenu().findItem(R.id.menu_remove_member);
            if (findItem != null) {
                findItem.setTitle(R.string.oplus_send_group_message);
                findItem.setEnabled(z11);
            }
            if (findItem2 != null) {
                findItem2.setTitle(R.string.oplus_send_email);
                findItem2.setEnabled(z11);
            }
            if (findItem3 != null) {
                findItem3.setTitle(R.string.oplus_move_out_group);
                findItem3.setEnabled(z11);
            }
            if (findItem3 != null) {
                int i10 = this.f20730g0;
                if (3 == i10 || 2 == i10 || 1 == i10 || 6 == i10) {
                    z12 = false;
                }
                findItem3.setVisible(z12);
            }
            this.f20697F0 = this.f20713U;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z3() {
        androidx.appcompat.app.b bVar = this.f20696E0;
        if (bVar != null && bVar.isShowing()) {
            this.f20696E0.dismiss();
        }
        this.f20696E0 = null;
    }

    public final void A3() {
        this.f20747x0 = false;
        UiMode$ActionModeType uiMode$ActionModeType = UiMode$ActionModeType.SMS_MODE;
        UiMode$ActionModeType uiMode$ActionModeType2 = this.f20713U;
        if (uiMode$ActionModeType == uiMode$ActionModeType2) {
            T3();
        } else if (UiMode$ActionModeType.EMAIL_MODE == uiMode$ActionModeType2) {
            S3();
        } else {
            R3();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        this.f20571x = cOUIToolbar;
        cOUIToolbar.inflateMenu(R.menu.view_group_menu);
        this.f20701J0 = this.f20571x.getMenu().findItem(R.id.setting_menu);
        this.f20571x.setOnMenuItemClickListener(new Toolbar.g() { // from class: com.customize.contacts.activities.A0
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean K32;
                K32 = ViewGroupActivity.this.K3(menuItem);
                return K32;
            }
        });
        this.f20571x.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.activities.B0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewGroupActivity.this.L3(view);
            }
        });
        this.f20722Y0.a(true);
        b4();
    }

    public final void B3(Intent intent) {
        this.f20746w0 = false;
        C0797h.a(this, new i(intent), this.f20711T);
        if (!this.f20746w0) {
            this.f20745v0 = U0.k.o(this, getString(R.string.in_processing));
        }
    }

    public final Dialog C3() {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.customize.contacts.activities.C0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ViewGroupActivity.this.H3(dialogInterface, i10);
            }
        };
        if (1 == this.f20730g0) {
            return com.customize.contacts.manager.j.b(this, onClickListener, this.f20715V.k().size(), this.f20715V.l(), R.string.oplus_smart_company_remove_tips);
        }
        return com.customize.contacts.manager.j.a(this, onClickListener, this.f20715V.k().size(), this.f20715V.l());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0057, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r7 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r7 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r7.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String D3(android.content.Context r8, long r9) {
        /*
            r7 = this;
            r0 = 0
            int r7 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            r0 = 0
            if (r7 < 0) goto L5e
            if (r8 != 0) goto La
            goto L5e
        La:
            android.net.Uri r7 = android.provider.ContactsContract.Groups.CONTENT_URI
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r7, r9)
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r7 = com.customize.contacts.util.C0814z.a.f22206a     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String[] r3 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r5 = 0
            r6 = 0
            r4 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            if (r7 == 0) goto L34
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            if (r8 == 0) goto L34
            r8 = 0
            java.lang.String r0 = r7.getString(r8)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            goto L34
        L2f:
            r8 = move-exception
            r0 = r7
            goto L58
        L32:
            r8 = move-exception
            goto L3e
        L34:
            if (r7 == 0) goto L57
        L36:
            r7.close()
            goto L57
        L3a:
            r8 = move-exception
            goto L58
        L3c:
            r8 = move-exception
            r7 = r0
        L3e:
            java.lang.String r9 = "ViewGroupActivity"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r10.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = ""
            r10.append(r1)     // Catch: java.lang.Throwable -> L2f
            r10.append(r8)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L2f
            H7.b.c(r9, r8)     // Catch: java.lang.Throwable -> L2f
            if (r7 == 0) goto L57
            goto L36
        L57:
            return r0
        L58:
            if (r0 == 0) goto L5d
            r0.close()
        L5d:
            throw r8
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.ViewGroupActivity.D3(android.content.Context, long):java.lang.String");
    }

    public final N3.i<IdRecord> E3(List<IdRecord> list) {
        v3();
        int i10 = this.f20730g0;
        if (1 == i10) {
            return new N3.i<>(this, list, this.f20730g0, this.f20735l0);
        }
        if (i10 == 4) {
            return new N3.i<>(this, list, this.f20748y0);
        }
        return new N3.i<>(this, list, this.f20732i0);
    }

    @Override // com.customize.contacts.util.M.d
    public void G0(View view, int i10, int i11) {
        Uri lookupUri;
        if (i10 < 0) {
            H7.b.i("ViewGroupActivity", "onItemClick(), pos is invalidate(), position = " + i10);
            return;
        }
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onItemClick(), position = " + i10);
        }
        Cursor m10 = this.f20740q0.m();
        if (m10 == null) {
            H7.b.c("ViewGroupActivity", "onItemClick(), cursor is null");
            return;
        }
        m10.moveToPosition(i10);
        try {
            long j10 = m10.getLong(0);
            String string = m10.getString(5);
            if (this.f20704M0) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
                this.f20719X.b(checkBox, i10);
                com.android.contacts.util.C.b(view, checkBox.isChecked());
                return;
            }
            if (TextUtils.isEmpty(string)) {
                lookupUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10);
            } else {
                lookupUri = ContactsContract.Contacts.getLookupUri(j10, string);
            }
            Intent intent = new Intent(this, (Class<?>) CallDetailActivity.class);
            intent.setData(lookupUri);
            if (this.f20730g0 == 2) {
                try {
                    startActivityForResult(intent, 777);
                    return;
                } catch (Exception e10) {
                    H7.b.c("ViewGroupActivity", "e = " + e10);
                    return;
                }
            }
            R7.b.d(this, intent, R.string.activity_not_found);
        } catch (CursorIndexOutOfBoundsException e11) {
            H7.b.c("ViewGroupActivity", "onItemClick(), Exception = " + e11);
        }
    }

    public final void G3() {
        this.f20708Q0 = new ArrayList<>(3);
        if (this.f20709R0 == null) {
            HashMap<String, Integer> hashMap = new HashMap<>(3);
            this.f20709R0 = hashMap;
            hashMap.put(getString(R.string.oplus_menu_edit), 0);
            this.f20709R0.put(getString(R.string.oplus_title_menu_group_ringtone_set), 1);
            this.f20709R0.put(getString(R.string.oplus_rename_group_name), 2);
        }
        int i10 = this.f20730g0;
        if (3 != i10 && 2 != i10 && 1 != i10 && 6 != i10 && PrimaryUserUtils.a() && CommonFeatureOption.j()) {
            this.f20708Q0.add(com.android.contacts.framework.baseui.util.q.a(getString(R.string.oplus_title_menu_group_ringtone_set)));
        }
        if (this.f20730g0 == 0) {
            this.f20708Q0.add(com.android.contacts.framework.baseui.util.q.a(getString(R.string.oplus_rename_group_name)));
        }
        if (this.f20733j0 > 0) {
            this.f20708Q0.add(com.android.contacts.framework.baseui.util.q.a(getString(R.string.oplus_menu_edit)));
        }
    }

    public final /* synthetic */ void H3(DialogInterface dialogInterface, int i10) {
        ArrayList<IdRecord> k10 = this.f20715V.k();
        this.f20721Y = k10;
        if (k10 != null) {
            O3(k10);
            this.f20721Y = null;
            if (this.f20704M0) {
                this.f20713U = UiMode$ActionModeType.NORMAL_MODE;
                this.f20722Y0.c();
                U3();
            }
        }
        dialogInterface.dismiss();
        this.f20743t0 = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        if (r5.getCount() > 0) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void I3(long r22, android.view.View r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.ViewGroupActivity.I3(long, android.view.View, java.lang.String, java.lang.String, java.lang.String, int, int):void");
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> list) {
        int headersCount = this.f20734k0.getHeadersCount();
        for (View view : list) {
            Object tag = view.getTag(R.id.group_list_item_position);
            if (tag instanceof Integer) {
                P3(((Integer) tag).intValue() + headersCount, view);
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean K0() {
        return this.f20704M0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ boolean K3(android.view.MenuItem r6) {
        /*
            r5 = this;
            int r6 = r6.getItemId()
            r0 = 1
            r1 = 0
            switch(r6) {
                case 2131427439: goto L88;
                case 2131427618: goto L7e;
                case 2131427959: goto L74;
                case 2131428864: goto L70;
                case 2131428922: goto L6c;
                case 2131428940: goto Lb;
                default: goto L9;
            }
        L9:
            goto L99
        Lb:
            int r6 = r5.f20730g0
            if (r0 == r6) goto L62
            r2 = 2
            if (r2 == r6) goto L62
            r2 = 3
            if (r2 == r6) goto L62
            com.coui.appcompat.poplist.COUIPopupListWindow r6 = r5.f20707P0
            if (r6 == 0) goto L21
            boolean r6 = r6.isShowing()
            if (r6 == 0) goto L21
            goto L99
        L21:
            r5.G3()
            com.coui.appcompat.poplist.COUIPopupListWindow r6 = new com.coui.appcompat.poplist.COUIPopupListWindow
            r6.<init>(r5)
            r5.f20707P0 = r6
            java.util.ArrayList<com.coui.appcompat.poplist.PopupListItem> r2 = r5.f20708Q0
            r6.setItemList(r2)
            com.coui.appcompat.poplist.COUIPopupListWindow r6 = r5.f20707P0
            r6.setDismissTouchOutside(r0)
            com.coui.appcompat.poplist.COUIPopupListWindow r6 = r5.f20707P0
            android.widget.AdapterView$OnItemClickListener r2 = r5.f20720X0
            r6.setOnItemClickListener(r2)
            com.coui.appcompat.poplist.COUIPopupListWindow r6 = r5.f20707P0
            android.content.res.Resources r2 = r5.getResources()
            r3 = 2131165296(0x7f070070, float:1.7944805E38)
            int r2 = r2.getDimensionPixelOffset(r3)
            int r2 = -r2
            r6.setOffset(r1, r1, r1, r2)
            java.util.ArrayList<com.coui.appcompat.poplist.PopupListItem> r6 = r5.f20708Q0
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L99
            com.coui.appcompat.poplist.COUIPopupListWindow r6 = r5.f20707P0
            r1 = 2131428940(0x7f0b064c, float:1.8479539E38)
            android.view.View r5 = r5.findViewById(r1)
            r6.show(r5)
            goto L99
        L62:
            com.customize.contacts.util.UiMode$ActionModeType r6 = com.customize.contacts.util.UiMode$ActionModeType.EDIT_MODE
            r5.f20713U = r6
            Z3.h r5 = r5.f20722Y0
            r5.b()
            goto L99
        L6c:
            r5.d2()
            goto L99
        L70:
            com.customize.contacts.util.C0792c.p(r5)
            goto L99
        L74:
            com.customize.contacts.util.UiMode$ActionModeType r6 = com.customize.contacts.util.UiMode$ActionModeType.EDIT_MODE
            r5.f20713U = r6
            Z3.h r5 = r5.f20722Y0
            r5.b()
            goto L99
        L7e:
            com.customize.contacts.util.UiMode$ActionModeType r6 = com.customize.contacts.util.UiMode$ActionModeType.NORMAL_MODE
            r5.f20713U = r6
            Z3.h r5 = r5.f20722Y0
            r5.c()
            goto L99
        L88:
            android.content.Context r6 = r5.getBaseContext()
            r2 = 200030053(0xbec3765, float:9.098724E-32)
            r3 = 0
            r4 = 2000308(0x1e85b4, float:2.803029E-39)
            com.android.contacts.framework.baseui.util.A.a(r6, r4, r2, r3, r1)
            r5.Y3()
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.ViewGroupActivity.K3(android.view.MenuItem):boolean");
    }

    public final /* synthetic */ void L3(View view) {
        finish();
    }

    public final /* synthetic */ void M3(DialogInterface dialogInterface, int i10) {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            finish();
        } else {
            dialogInterface.dismiss();
        }
    }

    public final /* synthetic */ void N3(DialogInterface dialogInterface, int i10) {
        com.android.contacts.framework.api.appstore.appinfo.a.m(this);
    }

    public void O3(List<IdRecord> list) {
        if (C0811w.g(list)) {
            com.oplus.foundation.util.ui.c.d(this, R.string.oplus_please_select_group_members);
            return;
        }
        N3.i<IdRecord> E32 = E3(list);
        this.f20741r0 = E32;
        E32.execute(new Void[0]);
    }

    public boolean P3(int i10, View view) {
        if (view == null || !this.f20704M0) {
            return false;
        }
        if (i10 < 0) {
            H7.b.i("ViewGroupActivity", "onItemTouch(), pos is invalidate(), position = " + i10);
            return false;
        }
        int headersCount = this.f20734k0.getHeadersCount();
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onItemTouch(), position = " + i10 + " ,headerViewCount = " + headersCount);
        }
        if (i10 < headersCount) {
            this.f20740q0.getItemCount();
            return false;
        }
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
        if (checkBox == null) {
            return false;
        }
        boolean z10 = !checkBox.isChecked();
        checkBox.setChecked(z10);
        com.android.contacts.util.C.b(view, z10);
        this.f20719X.c(checkBox, i10 - headersCount);
        return true;
    }

    public void Q3() {
        if (this.f20715V.u()) {
            if (!this.f20747x0) {
                this.f20747x0 = true;
                this.f20746w0 = false;
                C0797h.a(this, new f(this), this.f20711T);
                if (!this.f20746w0) {
                    this.f20745v0 = U0.k.o(this, getString(R.string.in_processing));
                    return;
                }
                return;
            }
            return;
        }
        A3();
    }

    public final void R3() {
        if (C0811w.g(this.f20715V.k())) {
            com.oplus.foundation.util.ui.c.d(this, R.string.oplus_please_select_group_members);
            return;
        }
        Dialog dialog = this.f20743t0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.f20743t0.dismiss();
            }
            this.f20743t0 = null;
        }
        this.f20743t0 = C3();
    }

    public final void S3() {
        ArrayList<IdRecord> k10 = this.f20715V.k();
        if (C0811w.g(k10)) {
            com.oplus.foundation.util.ui.c.d(this, R.string.oplus_please_select_group_members);
            return;
        }
        int size = k10.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 != size; i10++) {
            jArr[i10] = k10.get(i10).b();
        }
        Intent intent = new Intent(this, (Class<?>) MultiContactsSendSmsActivity.class);
        intent.setAction("com.oplus.contacts.ui.GET_CONTACTS_EMAILS_FOR_EMAIL");
        intent.putExtra("CONTACTS_IDS_ARRAY", jArr);
        Q7.b.b(this, intent, 397, 0);
    }

    public final void T3() {
        ArrayList<IdRecord> k10 = this.f20715V.k();
        if (C0811w.g(k10)) {
            com.oplus.foundation.util.ui.c.d(this, R.string.oplus_please_select_group_members);
            return;
        }
        int size = k10.size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 != size; i10++) {
            jArr[i10] = k10.get(i10).b();
        }
        Intent intent = new Intent(this, (Class<?>) MultiContactsSendSmsActivity.class);
        intent.setAction("com.oplus.contacts.ui.GET_CONTACTS_PHONES_FOR_SMS_2");
        intent.putExtra("CONTACTS_IDS_ARRAY", jArr);
        int i11 = this.f20730g0;
        if (2 == i11) {
            intent.putExtra("group_mode", i11);
            intent.putExtra("group_areano", this.f20699H0);
            intent.putExtra("city_name", this.f20735l0);
        }
        Q7.b.b(this, intent, 396, 0);
    }

    public final void U3() {
        boolean z10;
        this.f20715V.x();
        f2(false);
        boolean z11 = this.f20704M0;
        if (this.f20733j0 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        c4(z11, z10);
        this.f20740q0.r(false);
        this.f20740q0.s(true);
        this.f20740q0.notifyDataSetChanged();
    }

    @Override // com.customize.contacts.util.M.d
    public boolean V0(View view, MotionEvent motionEvent) {
        return false;
    }

    public final void V3(Context context) {
        String string;
        int i10;
        String a10 = P7.d.a(context);
        if (!context.getPackageName().equals(a10)) {
            x3();
            String b10 = C0811w.b(getApplicationContext(), a10);
            COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
            cOUIAlertDialogBuilder.setTitle((CharSequence) context.getString(R.string.oplus_change_default_dialer_dialog_title));
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                string = context.getString(R.string.odialer_change_default_dialer_dialog_message_v2);
            } else {
                string = context.getString(R.string.oplus_change_to_default_dialer_tips, b10);
            }
            cOUIAlertDialogBuilder.setMessage((CharSequence) string);
            cOUIAlertDialogBuilder.setCancelable(false);
            cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.customize.contacts.activities.y0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    ViewGroupActivity.this.M3(dialogInterface, i11);
                }
            });
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                i10 = R.string.oplus_change_default_dialer_ok;
            } else {
                i10 = R.string.oplus_use_default_dialer;
            }
            cOUIAlertDialogBuilder.setPositiveButton(i10, new DialogInterface.OnClickListener() { // from class: com.customize.contacts.activities.z0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    ViewGroupActivity.this.N3(dialogInterface, i11);
                }
            });
            androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
            this.f20710S0 = show;
            show.setCanceledOnTouchOutside(false);
        }
    }

    public final void W3() {
        View view = this.f20728e0;
        if (view != null) {
            view.setVisibility(0);
            this.f20729f0.setVisibility(0);
        }
    }

    public final void X3() {
        this.f20706O0.k(this.f20706O0.o(this, R.layout.bottom_dialog_layout_with_edit_text, this, getString(R.string.oplus_rename_group_name), getString(R.string.cancel), getString(R.string.dialog_ok)), false, getString(R.string.oplus_input_group_name), false);
        this.f20706O0.j().setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        this.f20706O0.m(this.f20735l0);
    }

    public void Y3() {
        int i10 = this.f20730g0;
        if (i10 == 0 && !this.f20714U0) {
            com.oplus.foundation.util.ui.c.b(getApplicationContext(), R.string.oplus_background_is_busy);
            return;
        }
        Account account = null;
        if (i10 != 0) {
            com.android.contacts.framework.baseui.util.A.a(this, 2000308, 200030231, null, false);
        }
        Intent intent = new Intent("com.oplus.contacts.ui.SELECT_CONTACTS_ADD_TO_GROUP");
        intent.setComponent(new ComponentName(this, (Class<?>) MultiContactPickActivity.class));
        this.f20715V.o();
        ArrayList arrayList = new ArrayList(this.f20715V.i());
        arrayList.addAll(this.f20715V.k());
        this.f20715V.b();
        if (!C0811w.g(arrayList)) {
            C0810v.f(C0810v.f22183b, arrayList);
        } else {
            H7.b.i("ViewGroupActivity", "There is no members in this groups");
        }
        if (!TextUtils.isEmpty(this.f20736m0) && !TextUtils.isEmpty(this.f20737n0)) {
            account = new Account(this.f20736m0, this.f20737n0);
        }
        intent.putExtra("group_name", this.f20735l0);
        intent.putExtra("group_mode", this.f20730g0);
        if (account != null) {
            intent.putExtra("android.provider.extra.ACCOUNT", account);
        }
        ArrayList<Account> arrayList2 = this.f20749z0;
        if (arrayList2 != null && arrayList2.size() > 0) {
            intent.putParcelableArrayListExtra("writable_account", this.f20749z0);
        }
        Q7.b.b(this, intent, 888, 0);
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        return P3(i10, view);
    }

    public void Z3() {
        this.f20698G0.f(1, this.f20705N0);
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public int a2() {
        P3.c cVar = this.f20715V;
        if (cVar != null) {
            return cVar.i();
        }
        return -1;
    }

    public final void a4() {
        if (this.f20730g0 == 4) {
            C0797h.a(this, new j(), this.f20711T);
            if (!this.f20746w0) {
                this.f20745v0 = U0.k.o(this, getString(R.string.in_processing));
                return;
            }
            return;
        }
        com.customize.contacts.manager.i.b(this, this.f20738o0, getString(R.string.oplus_title_menu_group_ringtone_set));
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public int b2() {
        return this.f20715V.l();
    }

    public final void b4() {
        MenuItem menuItem;
        int i10 = this.f20730g0;
        if ((1 == i10 || 2 == i10 || 3 == i10) && (menuItem = this.f20701J0) != null) {
            menuItem.setIcon(R.drawable.pb_ic_menu_edit);
        }
    }

    @Override // com.customize.contacts.util.M.d
    public void c0(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f20730g0;
        if ((i14 != 0 && i14 != 4) || this.f20704M0) {
            return;
        }
        if (i10 < 0) {
            H7.b.c("ViewGroupActivity", "onItemLongClick(), pos is invalidate(), position = " + i10);
            return;
        }
        F3(view, i10, i12, i13);
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void d2() {
        markAllContacts();
        this.f20722Y0.g();
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void e2(boolean z10) {
        this.f20715V.w(z10);
        this.f20740q0.notifyDataSetChanged();
    }

    @Override // Y0.a
    public void g() {
        String str;
        Editable text;
        COUIEditText j10 = this.f20706O0.j();
        if (j10 != null && (text = j10.getText()) != null) {
            str = text.toString();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
        }
        if (TextUtils.isEmpty(str)) {
            com.oplus.foundation.util.ui.c.b(this, R.string.oplus_group_name_cannot_be_empty);
            this.f20706O0.g();
            return;
        }
        this.f20746w0 = false;
        C0797h.a(this, new k(str), this.f20711T);
        if (!this.f20746w0) {
            this.f20745v0 = U0.k.o(this, getString(R.string.in_processing));
        }
        this.f20706O0.g();
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void g2() {
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "updateMarkCount(), marked = " + a2());
        }
        this.f20722Y0.d();
    }

    @Override // N3.a.InterfaceC0047a
    public void l(Cursor cursor) {
        int i10;
        boolean z10;
        boolean z11;
        int i11;
        this.f20717W = cursor;
        androidx.appcompat.app.b bVar = this.f20745v0;
        if (bVar != null && bVar.isShowing()) {
            this.f20745v0.dismiss();
            this.f20745v0 = null;
        }
        P3.c cVar = this.f20715V;
        boolean z12 = true;
        if (cVar != null) {
            if (cVar.i() == 0) {
                this.f20715V.A();
                this.f20715V.q(cursor, false);
            } else {
                P3.c cVar2 = this.f20715V;
                cVar2.M(cVar2.k());
                this.f20715V.P(cursor, false);
            }
            if (this.f20715V.i() == this.f20715V.l()) {
                f2(true);
                invalidateOptionsMenu();
            }
        }
        if (this.f20731h0) {
            if (cursor != null) {
                i11 = cursor.getCount();
            } else {
                i11 = 0;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(BreenoCallContract.SummaryColumns.COUNT, String.valueOf(i11));
            if (2 == this.f20730g0) {
                com.android.contacts.framework.baseui.util.A.a(getApplicationContext(), 2000308, 200030233, hashMap, false);
            } else {
                com.android.contacts.framework.baseui.util.A.a(getApplicationContext(), 2000308, 200030230, hashMap, false);
            }
        }
        this.f20731h0 = false;
        this.f20740q0.l(cursor);
        y3();
        if (cursor != null) {
            i10 = cursor.getCount();
        } else {
            i10 = 0;
        }
        this.f20733j0 = i10;
        if (i10 <= 0) {
            this.f20725b0.setVisibility(0);
            this.f20724a0.setVisibility(0);
            this.f20723Z.setVisibility(0);
            this.f20734k0.setVisibility(8);
        } else {
            this.f20725b0.setVisibility(8);
            this.f20724a0.setVisibility(8);
            this.f20723Z.setVisibility(8);
            this.f20734k0.setVisibility(0);
        }
        if (this.f20704M0) {
            if (a2() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            c4(true, z11);
        } else {
            if (this.f20733j0 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            c4(false, z10);
        }
        if (this.f20704M0 && this.f20733j0 <= 0) {
            this.f20713U = UiMode$ActionModeType.NORMAL_MODE;
            this.f20722Y0.c();
        }
        Z3.h hVar = this.f20722Y0;
        if (this.f20733j0 <= 0) {
            z12 = false;
        }
        hVar.f(z12);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onActivityResult(), requestCode = " + i10 + ", resultCode = " + i11);
            StringBuilder sb = new StringBuilder();
            sb.append("onActivityResult(), data = ");
            sb.append(intent);
            H7.b.b("ViewGroupActivity", sb.toString());
        }
        super.onActivityResult(i10, i11, intent);
        if (889 == i10) {
            if (com.customize.contacts.manager.i.l(intent)) {
                H7.b.b("ViewGroupActivity", "onActivityResult, no need save ringTone from settings.");
                return;
            } else if (intent != null) {
                B3(intent);
                return;
            } else {
                if (com.customize.contacts.manager.i.f21553c) {
                    B3(null);
                    return;
                }
                return;
            }
        }
        if (888 == i10) {
            if (intent != null) {
                if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                    if (this.f20730g0 == 4) {
                        if (s1.i.i(this)) {
                            t3(intent);
                            return;
                        }
                        return;
                    }
                    t3(intent);
                    return;
                }
                t3(intent);
                return;
            }
            H7.b.i("ViewGroupActivity", "onActivityResult(), data is null returned from pick activity");
            return;
        }
        if (396 == i10 && -1 == i11 && intent != null) {
            ArrayList i12 = C7.e.i(intent, "SELECTED_CONTACTS");
            C0792c.i(this, i12, false, C7.e.c(intent, "click_complete", false));
            if (i12 != null && !i12.isEmpty() && this.f20704M0) {
                this.f20713U = UiMode$ActionModeType.NORMAL_MODE;
                this.f20722Y0.c();
                return;
            }
            return;
        }
        if (397 == i10 && -1 == i11 && intent != null) {
            ArrayList i13 = C7.e.i(intent, "SELECTED_CONTACTS");
            C0792c.h(this, i13);
            if (i13 != null && !i13.isEmpty() && this.f20704M0) {
                this.f20713U = UiMode$ActionModeType.NORMAL_MODE;
                this.f20722Y0.c();
                return;
            }
            return;
        }
        if (777 == i10) {
            Z3();
        }
        if (998 == i10) {
            H7.b.e("ViewGroupActivity", "onActivityResult PERMISSION_AUDIO_RESULT_CODE");
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f20704M0) {
            this.f20713U = UiMode$ActionModeType.NORMAL_MODE;
            this.f20722Y0.c();
        } else {
            super.onBackPressed();
        }
    }

    @Override // Y0.a
    public void onCancel() {
        this.f20706O0.g();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v3();
        LocaleList locales = configuration.getLocales();
        boolean z10 = false;
        if (!locales.isEmpty()) {
            String languageTag = locales.get(0).toLanguageTag();
            if (!TextUtils.equals(languageTag, this.f20712T0)) {
                H7.b.i("ViewGroupActivity", "languageTag has changed, languageTag= " + languageTag + "  currentLanguageTag=" + this.f20712T0);
                finish();
            }
            this.f20712T0 = languageTag;
        }
        MenuItem menuItem = this.f20703L0;
        if (menuItem != null && 6 == this.f20730g0) {
            menuItem.setEnabled(!isInMultiWindowMode());
        }
        if (this.f20734k0 != null) {
            z10 = true;
        }
        if (K0() & z10) {
            boolean j10 = DisplayUtil.j(this);
            if ((DisplayUtil.i(this) && !j10) || (!FeatureUtil.V() && DisplayUtil.n(this))) {
                this.f20734k0.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_145));
            } else if (FeatureUtil.V() && !j10) {
                this.f20734k0.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_245));
            } else {
                this.f20734k0.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_60));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.customize.contacts.activities.SearchAnimatorsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        boolean z10;
        boolean z11;
        super.onCreate(bundle);
        try {
            this.f20735l0 = C7.e.l(getIntent(), "group_name");
            Uri data = getIntent().getData();
            if (data != null) {
                this.f20732i0 = ContentUris.parseId(data);
            }
        } catch (Exception e10) {
            H7.b.c("ViewGroupActivity", "get group id error" + e10);
        }
        this.f20699H0 = C7.e.l(getIntent(), "SELECTION_FOR_VIEW_GROUP");
        Bundle extras = getIntent().getExtras();
        this.f20706O0 = new U0.h();
        boolean z12 = false;
        if (getApplicationContext().getResources().getInteger(R.integer.product_flavor) == 1) {
            objArr = true;
        } else {
            objArr = false;
        }
        if (extras != null) {
            this.f20730g0 = extras.getInt("group_mode", 0);
        }
        Object[] objArr2 = 0;
        if (this.f20732i0 <= 0 && getIntent().getExtras() != null) {
            if (this.f20730g0 == 4) {
                new h().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                HashMap<Account, Long> d10 = C0810v.d();
                this.f20748y0 = d10;
                if (d10 == null) {
                    this.f20748y0 = new HashMap<>();
                }
            }
        } else {
            new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        this.f20731h0 = true;
        if (this.f20732i0 <= 0 && this.f20730g0 == 0) {
            com.oplus.foundation.util.ui.c.b(this, R.string.oplus_group_is_not_exist);
            finish();
            return;
        }
        this.f20694C0 = new l(this);
        setContentView(R.layout.view_group_activity);
        c4(false, false);
        this.f20725b0 = findViewById(R.id.scroll_view);
        this.f20724a0 = (ImageView) findViewById(R.id.no_content);
        TextView textView = (TextView) findViewById(R.id.empty_view);
        this.f20723Z = textView;
        textView.setText(R.string.group_no_member_datail);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) findViewById(R.id.group_list);
        this.f20734k0 = headerFooterRecyclerView;
        headerFooterRecyclerView.setNestedScrollingEnabled(true);
        this.f20734k0.setLayoutManager(new LinearLayoutManager(this));
        this.f20734k0.addOnScrollListener(new b());
        View findViewById = findViewById(R.id.empty_view_header);
        if (this.f20730g0 == 4 && B3.a.c0()) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
            this.f20734k0.setPaddingRelative(0, dimensionPixelSize, 0, getResources().getDimensionPixelSize(R.dimen.DP_60));
            if (findViewById != null) {
                View findViewById2 = findViewById.findViewById(android.R.id.summary);
                if (findViewById2 instanceof TextView) {
                    ((TextView) findViewById2).setText(GroupBrowseListViewModel.j());
                }
                View findViewById3 = findViewById(R.id.empty_view_group);
                if (findViewById3 instanceof EmptyViewGroup) {
                    ((EmptyViewGroup) findViewById3).l(false);
                }
                ViewParent parent = findViewById.getParent();
                if (parent instanceof View) {
                    ((View) parent).setPadding(0, dimensionPixelSize, 0, 0);
                    findViewById.setVisibility(0);
                }
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.view_group_list_header, (ViewGroup) this.f20734k0, false);
            View findViewById4 = inflate.findViewById(android.R.id.summary);
            if (findViewById4 instanceof TextView) {
                ((TextView) findViewById4).setText(GroupBrowseListViewModel.j());
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.addView(inflate);
                frameLayout.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.list_padding_top));
                this.f20734k0.x(frameLayout);
            }
        } else {
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            com.android.contacts.util.C.c(this, this.f20734k0, getResources().getDimensionPixelSize(R.dimen.DP_60));
        }
        this.f20716V0.T0(this, this.f20734k0, null);
        this.f20734k0.setDragSelectListener(this);
        this.f20722Y0.e();
        this.f20728e0 = findViewById(R.id.loading);
        this.f20729f0 = findViewById(R.id.loading_view);
        W3();
        this.f20742s0 = Z0.b.g(this);
        P3.c cVar = new P3.c();
        this.f20715V = cVar;
        cVar.I(true);
        this.f20719X = new P3.b(this.f20715V, this);
        CommonTopTitlebarActivity.a c22 = c2();
        this.f20189Q = c22;
        this.f20715V.z(c22);
        P3.h hVar = new P3.h(this, this.f20715V, this.f20742s0, this);
        this.f20740q0 = hVar;
        hVar.s(true);
        P3.h hVar2 = this.f20740q0;
        int i10 = this.f20730g0;
        if (i10 != 0 && i10 != 4) {
            z10 = false;
        } else {
            z10 = true;
        }
        hVar2.t(z10);
        if (new C1393c(this).g() == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f20740q0.p(z11);
        this.f20734k0.setAdapter(this.f20740q0);
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onCreate() isDisplayAlt = " + z11);
        }
        this.f20705N0 = getIntent().getExtras();
        if (androidx.loader.app.a.c(this).d(1) != null) {
            androidx.loader.app.a.c(this).a(1);
        }
        if (2 == this.f20730g0) {
            z12 = true;
        }
        N3.a aVar = new N3.a(z12);
        this.f20698G0 = aVar;
        aVar.d(androidx.loader.app.a.c(this), getApplicationContext(), this);
        this.f20698G0.b(1, this.f20705N0);
        if (this.f20730g0 == 4) {
            if (objArr != false) {
                this.f20724a0.setImageResource(R.drawable.pb_ic_no_contact);
            }
            if (!com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                V3(this);
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onDestroy()--------------");
        }
        Z3.j.c();
        this.f20706O0.g();
        z3();
        x3();
        P3.h hVar = this.f20740q0;
        if (hVar != null) {
            hVar.q(false);
            Cursor m10 = this.f20740q0.m();
            if (m10 != null && !m10.isClosed()) {
                m10.close();
            }
        }
        P3.c cVar = this.f20715V;
        if (cVar != null) {
            cVar.A();
        }
        Z0.b.g(this).a();
        v3();
        this.f20716V0.F();
        super.onDestroy();
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f20716V0.p();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (11 == i10) {
            if (com.android.contacts.util.w.k(this, com.android.contacts.util.w.e())) {
                a4();
            } else if (!shouldShowRequestPermissionRationale(com.android.contacts.util.w.e())) {
                com.android.contacts.util.w.z(this, false, null, com.android.contacts.util.w.e(), 998);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        this.f20732i0 = bundle.getLong("key_group_id");
        this.f20748y0 = (HashMap) bundle.getSerializable("key_vip_group_ids_map");
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onRestoreInstanceState, mGroupId = " + this.f20732i0);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f20730g0 == 4 && com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            V3(this);
        }
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onResume()");
        }
        this.f20742s0.w();
        this.f20716V0.H0();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "onSaveInstanceState");
        }
        bundle.putLong("key_group_id", this.f20732i0);
        bundle.putSerializable("key_vip_group_ids_map", this.f20748y0);
        super.onSaveInstanceState(bundle);
    }

    public synchronized void t3(Intent intent) {
        this.f20739p0 = new e(intent);
        new Thread(this.f20739p0, "ViewGroupActivity").start();
    }

    public final void u3() {
        if (6 == this.f20730g0) {
            this.f20571x.setTitle(R.string.oplus_business_card);
        } else {
            this.f20571x.setTitle(this.f20735l0);
        }
    }

    public final void v3() {
        if (H7.a.b()) {
            H7.b.b("ViewGroupActivity", "cancelTask()---------------------");
        }
        e eVar = this.f20739p0;
        if (eVar != null) {
            eVar.e();
        }
        N3.i<IdRecord> iVar = this.f20741r0;
        if (iVar != null) {
            iVar.e();
        }
    }

    public final long w3(Context context) {
        boolean z10;
        if (this.f20749z0 == null) {
            ArrayList<Account> arrayList = new ArrayList<>();
            this.f20749z0 = arrayList;
            arrayList.add(new Account(R0.a.f3165a, R0.a.f3166b));
        }
        if (this.f20748y0 == null) {
            this.f20748y0 = new HashMap<>();
        }
        if (this.f20749z0.size() <= 0) {
            return -1L;
        }
        Iterator<Account> it = this.f20749z0.iterator();
        long j10 = -1;
        while (it.hasNext()) {
            Account next = it.next();
            if (next != null && !this.f20748y0.containsKey(next)) {
                j10 = N3.b.j(context, "Vip in ColorOS", next);
                if (j10 != -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    j10 = N3.b.h(context, next);
                }
                this.f20748y0.put(next, Long.valueOf(j10));
                if (H7.a.b()) {
                    H7.b.b("ViewGroupActivity", "createVipGroupIfNeeded groupId = " + j10 + " ,isVipGroupExist = " + z10);
                }
            }
        }
        return j10;
    }

    public final void x3() {
        androidx.appcompat.app.b bVar = this.f20710S0;
        if (bVar != null && bVar.isShowing()) {
            this.f20710S0.dismiss();
        }
        this.f20710S0 = null;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void y0() {
        this.f20726c0 = (FrameLayout) findViewById(R.id.navigation_view_panel);
        COUINavigationView cOUINavigationView = (COUINavigationView) findViewById(R.id.navigation_view);
        this.f20727d0 = cOUINavigationView;
        cOUINavigationView.inflateMenu(R.menu.three_action_menu);
        this.f20727d0.setOnItemSelectedListener(new NavigationBarView.c() { // from class: com.customize.contacts.activities.x0
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean J32;
                J32 = ViewGroupActivity.this.J3(menuItem);
                return J32;
            }
        });
    }

    public final void y3() {
        View view = this.f20728e0;
        if (view != null) {
            view.setVisibility(8);
            this.f20729f0.setVisibility(8);
        }
    }

    @Override // w7.b
    public void T() {
    }

    @Override // com.customize.contacts.activities.CommonTopTitlebarActivity
    public void Y1() {
    }

    @Override // w7.b
    public void p0() {
    }
}
