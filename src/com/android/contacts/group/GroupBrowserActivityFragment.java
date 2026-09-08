package com.android.contacts.group;

import U0.m;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.contacts.framework.baseui.util.B;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.android.contacts.group.GroupBrowseListFragment;
import com.android.contacts.model.Account;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.D;
import com.android.contacts.util.x;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.ViewGroupActivity;
import com.customize.contacts.fragment.BaseActivityFragment;
import com.customize.contacts.model.GroupValueDelta;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0791b;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0814z;
import com.customize.contacts.util.G;
import com.customize.contacts.util.T;
import com.customize.contacts.widget.p;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import m9.q;
import o1.C1393c;

/* compiled from: GroupBrowserActivityFragment.kt */
/* loaded from: classes.dex */
public final class GroupBrowserActivityFragment extends BaseActivityFragment implements Y0.a {

    /* renamed from: b0, reason: collision with root package name */
    public static final a f16610b0 = new a(null);

    /* renamed from: c0, reason: collision with root package name */
    public static int f16611c0;

    /* renamed from: F, reason: collision with root package name */
    public GroupBrowseListFragment f16612F;

    /* renamed from: G, reason: collision with root package name */
    public ArrayList<Account> f16613G;

    /* renamed from: H, reason: collision with root package name */
    public d f16614H;

    /* renamed from: I, reason: collision with root package name */
    public com.customize.contacts.model.d f16615I;

    /* renamed from: J, reason: collision with root package name */
    public U0.h f16616J;

    /* renamed from: K, reason: collision with root package name */
    public Account f16617K;

    /* renamed from: M, reason: collision with root package name */
    public f<IdRecord> f16619M;

    /* renamed from: N, reason: collision with root package name */
    public e f16620N;

    /* renamed from: O, reason: collision with root package name */
    public long f16621O;

    /* renamed from: P, reason: collision with root package name */
    public String f16622P;

    /* renamed from: Q, reason: collision with root package name */
    public EntityDelta.ValuesDelta f16623Q;

    /* renamed from: R, reason: collision with root package name */
    public Context f16624R;

    /* renamed from: S, reason: collision with root package name */
    public COUINavigationView f16625S;

    /* renamed from: T, reason: collision with root package name */
    public View f16626T;

    /* renamed from: U, reason: collision with root package name */
    public ObjectAnimator f16627U;

    /* renamed from: V, reason: collision with root package name */
    public ObjectAnimator f16628V;

    /* renamed from: W, reason: collision with root package name */
    public ObjectAnimator f16629W;

    /* renamed from: X, reason: collision with root package name */
    public ObjectAnimator f16630X;

    /* renamed from: Y, reason: collision with root package name */
    public androidx.appcompat.app.b f16631Y;

    /* renamed from: a0, reason: collision with root package name */
    public U0.b f16633a0;

    /* renamed from: L, reason: collision with root package name */
    public boolean f16618L = true;

    /* renamed from: Z, reason: collision with root package name */
    public final p f16632Z = new p();

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class b extends D<Void, Void, ArrayList<Account>, GroupBrowserActivityFragment> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupBrowserActivityFragment target) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ArrayList<Account> a(GroupBrowserActivityFragment fragment, Void... voids) {
            kotlin.jvm.internal.i.f(fragment, "fragment");
            kotlin.jvm.internal.i.f(voids, "voids");
            FragmentActivity activity = fragment.getActivity();
            if (!C0792c.c(activity)) {
                return null;
            }
            return M3.c.f(activity, false, false, false);
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(GroupBrowserActivityFragment groupBrowserActivityFragment, ArrayList<Account> arrayList) {
            if (groupBrowserActivityFragment != null && groupBrowserActivityFragment.isAdded() && C0792c.c(groupBrowserActivityFragment.getActivity()) && arrayList != null) {
                groupBrowserActivityFragment.f16613G = arrayList;
                ArrayList arrayList2 = groupBrowserActivityFragment.f16613G;
                ArrayList arrayList3 = null;
                if (arrayList2 == null) {
                    kotlin.jvm.internal.i.q("accounts");
                    arrayList2 = null;
                }
                if (arrayList2.size() == 1) {
                    ArrayList arrayList4 = groupBrowserActivityFragment.f16613G;
                    if (arrayList4 == null) {
                        kotlin.jvm.internal.i.q("accounts");
                    } else {
                        arrayList3 = arrayList4;
                    }
                    groupBrowserActivityFragment.f16617K = (Account) arrayList3.get(0);
                    groupBrowserActivityFragment.n3();
                    return;
                }
                groupBrowserActivityFragment.Y2();
            }
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<GroupBrowserActivityFragment> f16639a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupBrowserActivityFragment fragment) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.i.f(fragment, "fragment");
            this.f16639a = new WeakReference<>(fragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            FragmentActivity activity;
            kotlin.jvm.internal.i.f(msg, "msg");
            GroupBrowserActivityFragment groupBrowserActivityFragment = this.f16639a.get();
            if (groupBrowserActivityFragment == null || !groupBrowserActivityFragment.isAdded() || (activity = groupBrowserActivityFragment.getActivity()) == null) {
                return;
            }
            int i10 = msg.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        e eVar = groupBrowserActivityFragment.f16620N;
                        if (eVar != null) {
                            eVar.cancel(true);
                        }
                        groupBrowserActivityFragment.f16620N = null;
                        groupBrowserActivityFragment.X2(GroupBrowserActivityFragment.f16611c0);
                        androidx.appcompat.app.b bVar = groupBrowserActivityFragment.f16631Y;
                        if (bVar != null) {
                            bVar.dismiss();
                            return;
                        }
                        return;
                    }
                    return;
                }
                String string = activity.getString(R.string.oplus_creating_new_group);
                kotlin.jvm.internal.i.e(string, "activity.getString(\n    …                        )");
                groupBrowserActivityFragment.f16631Y = U0.k.o(activity, string);
                return;
            }
            Object obj = msg.obj;
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
            groupBrowserActivityFragment.l3(((Boolean) obj).booleanValue());
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class e extends D<Void, Void, Integer, GroupBrowserActivityFragment> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GroupBrowserActivityFragment target) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
        }

        @Override // com.android.contacts.util.D
        public /* bridge */ /* synthetic */ void b(GroupBrowserActivityFragment groupBrowserActivityFragment, Integer num) {
            f(groupBrowserActivityFragment, num.intValue());
        }

        public final ContentProviderResult[] d(ContentResolver contentResolver, ArrayList<ContentProviderOperation> arrayList) {
            try {
                ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
                kotlin.jvm.internal.i.e(applyBatch, "resolver.applyBatch(Cont…AUTHORITY, lstOperations)");
                if (arrayList.size() <= 0) {
                    return null;
                }
                return applyBatch;
            } catch (OperationApplicationException e10) {
                H7.b.c("GroupBrowserActivityFragment", "doInBackground(), save failed");
                H7.b.c("GroupBrowserActivityFragment", "Exception e: " + e10);
                return null;
            } catch (RemoteException e11) {
                H7.b.c("GroupBrowserActivityFragment", "doInBackground(), save failed");
                H7.b.c("GroupBrowserActivityFragment", "Exception e: " + e11);
                return null;
            } catch (Exception e12) {
                H7.b.c("GroupBrowserActivityFragment", "doInBackground(), save failed");
                H7.b.c("GroupBrowserActivityFragment", "Exception e: " + e12);
                return null;
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer a(GroupBrowserActivityFragment target, Void... voids) {
            Uri uri;
            int g10;
            kotlin.jvm.internal.i.f(target, "target");
            kotlin.jvm.internal.i.f(voids, "voids");
            FragmentActivity activity = target.getActivity();
            if (activity == null) {
                return -1;
            }
            ContentResolver resolver = activity.getContentResolver();
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            com.customize.contacts.model.d dVar = target.f16615I;
            com.customize.contacts.model.d dVar2 = null;
            if (dVar == null) {
                kotlin.jvm.internal.i.q("entityState");
                dVar = null;
            }
            dVar.c(arrayList);
            kotlin.jvm.internal.i.e(resolver, "resolver");
            ContentProviderResult[] d10 = d(resolver, arrayList);
            if (d10 != null && d10.length != 0 && (uri = d10[0].uri) != null) {
                kotlin.jvm.internal.i.c(uri);
                long parseId = ContentUris.parseId(uri);
                arrayList.clear();
                com.customize.contacts.model.d dVar3 = target.f16615I;
                if (dVar3 == null) {
                    kotlin.jvm.internal.i.q("entityState");
                } else {
                    dVar2 = dVar3;
                }
                dVar2.b(activity, arrayList, parseId);
                if (arrayList.size() <= 200) {
                    int i10 = 1;
                    g10 = 2;
                    if (!arrayList.isEmpty()) {
                        try {
                            resolver.applyBatch("com.android.contacts", arrayList);
                            if (arrayList.size() > 0) {
                                i10 = 2;
                            }
                            g10 = i10;
                        } catch (OperationApplicationException e10) {
                            H7.b.c("GroupBrowserActivityFragment", "doInBackground(), save failed");
                            H7.b.c("GroupBrowserActivityFragment", "Exception e: " + e10);
                            return 3;
                        } catch (RemoteException e11) {
                            H7.b.c("GroupBrowserActivityFragment", "doInBackground(), save failed");
                            H7.b.c("GroupBrowserActivityFragment", "Exception e: " + e11);
                            return 3;
                        } catch (Exception e12) {
                            H7.b.c("GroupBrowserActivityFragment", "doInBackground(), save failed");
                            H7.b.c("GroupBrowserActivityFragment", "Exception e: " + e12);
                            return 3;
                        }
                    }
                } else {
                    g10 = g(resolver, arrayList);
                }
                return Integer.valueOf(g10);
            }
            return 3;
        }

        public void f(GroupBrowserActivityFragment groupBrowserActivityFragment, int i10) {
            if (groupBrowserActivityFragment == null || !groupBrowserActivityFragment.isAdded() || !C0792c.c(groupBrowserActivityFragment.getActivity())) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - groupBrowserActivityFragment.f16621O;
            GroupBrowserActivityFragment.f16611c0 = i10;
            if (currentTimeMillis < COUIScrollBar.SCROLLER_FADE_TIMEOUT) {
                d dVar = groupBrowserActivityFragment.f16614H;
                if (dVar != null) {
                    dVar.sendEmptyMessageDelayed(2, COUIScrollBar.SCROLLER_FADE_TIMEOUT - currentTimeMillis);
                    return;
                }
                return;
            }
            d dVar2 = groupBrowserActivityFragment.f16614H;
            if (dVar2 != null) {
                dVar2.sendEmptyMessage(2);
            }
        }

        public final int g(ContentResolver contentResolver, ArrayList<ContentProviderOperation> arrayList) {
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>(199);
            Iterator<ContentProviderOperation> it = arrayList.iterator();
            while (it.hasNext()) {
                ContentProviderOperation next = it.next();
                if (isCancelled()) {
                    return 3;
                }
                arrayList2.add(next);
                if (arrayList2.size() >= 199) {
                    ContentProviderResult[] d10 = d(contentResolver, arrayList2);
                    arrayList2.clear();
                    if (d10 == null) {
                        return 3;
                    }
                }
            }
            if (arrayList2.size() > 0 && d(contentResolver, arrayList2) == null) {
                return 3;
            }
            return 2;
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class f<T extends Z3.b> extends D<Void, Void, Void, GroupBrowserActivityFragment> {

        /* renamed from: b, reason: collision with root package name */
        public final List<T> f16640b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(GroupBrowserActivityFragment target, List<? extends T> returnedMembers) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
            kotlin.jvm.internal.i.f(returnedMembers, "returnedMembers");
            this.f16640b = returnedMembers;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void a(GroupBrowserActivityFragment fragment, Void... params) {
            kotlin.jvm.internal.i.f(fragment, "fragment");
            kotlin.jvm.internal.i.f(params, "params");
            if (!C0792c.c(fragment.getActivity())) {
                return null;
            }
            g(this.f16640b, fragment);
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(GroupBrowserActivityFragment groupBrowserActivityFragment, Void r22) {
            if (groupBrowserActivityFragment != null && groupBrowserActivityFragment.isAdded() && C0792c.c(groupBrowserActivityFragment.getActivity())) {
                groupBrowserActivityFragment.k3();
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void c(GroupBrowserActivityFragment fragment) {
            kotlin.jvm.internal.i.f(fragment, "fragment");
            if (C0792c.c(fragment.getActivity())) {
                fragment.f16621O = System.currentTimeMillis();
                d dVar = fragment.f16614H;
                if (dVar != null) {
                    dVar.sendEmptyMessage(1);
                }
            }
        }

        public final void g(List<? extends T> list, GroupBrowserActivityFragment groupBrowserActivityFragment) {
            FragmentActivity activity = groupBrowserActivityFragment.getActivity();
            com.customize.contacts.model.d d10 = com.customize.contacts.model.d.d(groupBrowserActivityFragment.f16617K);
            kotlin.jvm.internal.i.e(d10, "fromAfter(fragment.destAccount)");
            groupBrowserActivityFragment.f16615I = d10;
            groupBrowserActivityFragment.i3(groupBrowserActivityFragment.a3());
            com.customize.contacts.model.d dVar = groupBrowserActivityFragment.f16615I;
            com.customize.contacts.model.d dVar2 = null;
            if (dVar == null) {
                kotlin.jvm.internal.i.q("entityState");
                dVar = null;
            }
            List<GroupValueDelta> j10 = dVar.j();
            com.customize.contacts.model.d dVar3 = groupBrowserActivityFragment.f16615I;
            if (dVar3 == null) {
                kotlin.jvm.internal.i.q("entityState");
                dVar3 = null;
            }
            List<GroupValueDelta> g10 = dVar3.g();
            if (j10 != null) {
                j10.clear();
            }
            if (g10 != null) {
                g10.clear();
            }
            for (T t10 : list) {
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("mimetype", "vnd.android.cursor.item/group_membership");
                GroupValueDelta w02 = GroupValueDelta.w0(contentValues);
                com.customize.contacts.model.d dVar4 = groupBrowserActivityFragment.f16615I;
                if (dVar4 == null) {
                    kotlin.jvm.internal.i.q("entityState");
                    dVar4 = null;
                }
                w02.D0(dVar4);
                w02.B0(Long.valueOf(t10.b()));
                Account account = groupBrowserActivityFragment.f16617K;
                if (account != null) {
                    w02.z0(account.f16941a);
                    w02.A0(account.f16942b);
                }
                if (j10 != null) {
                    j10.add(w02);
                }
            }
            Message message = new Message();
            message.what = 0;
            com.customize.contacts.model.d dVar5 = groupBrowserActivityFragment.f16615I;
            if (dVar5 == null) {
                kotlin.jvm.internal.i.q("entityState");
            } else {
                dVar2 = dVar5;
            }
            message.obj = Boolean.valueOf(N3.b.m(activity, dVar2.i(), groupBrowserActivityFragment.f16617K));
            d dVar6 = groupBrowserActivityFragment.f16614H;
            if (dVar6 != null) {
                dVar6.sendMessage(message);
            }
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class g implements C0791b.a {
        public g() {
        }

        @Override // com.customize.contacts.util.C0791b.a
        public void onClick(int i10) {
            androidx.appcompat.app.b j10;
            U0.b bVar = GroupBrowserActivityFragment.this.f16633a0;
            if (bVar != null && (j10 = bVar.j()) != null) {
                j10.dismiss();
            }
            GroupBrowserActivityFragment groupBrowserActivityFragment = GroupBrowserActivityFragment.this;
            ArrayList arrayList = groupBrowserActivityFragment.f16613G;
            if (arrayList == null) {
                kotlin.jvm.internal.i.q("accounts");
                arrayList = null;
            }
            groupBrowserActivityFragment.f16617K = (Account) arrayList.get(i10);
            GroupBrowserActivityFragment.this.n3();
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f16643b;

        public h(View view) {
            this.f16643b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            GroupBrowserActivityFragment.this.p3();
            this.f16643b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    private final void W2() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.i.e(childFragmentManager, "childFragmentManager");
        Fragment l02 = childFragmentManager.l0(R.id.list_fragment);
        kotlin.jvm.internal.i.d(l02, "null cannot be cast to non-null type com.android.contacts.group.GroupBrowseListFragment");
        GroupBrowseListFragment groupBrowseListFragment = (GroupBrowseListFragment) l02;
        this.f16612F = groupBrowseListFragment;
        if (groupBrowseListFragment != null) {
            groupBrowseListFragment.h2(new c());
            groupBrowseListFragment.f2(E1());
        }
        q3(false, false);
    }

    public static final void Z2(GroupBrowserActivityFragment this$0, DialogInterface dialogInterface) {
        androidx.appcompat.app.b j10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        U0.b bVar = this$0.f16633a0;
        if (bVar != null && (j10 = bVar.j()) != null) {
            j10.dismiss();
        }
    }

    public static final boolean e3(GroupBrowserActivityFragment this$0, MenuItem it) {
        G P12;
        GroupBrowseListFragment groupBrowseListFragment;
        G P13;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(it, "it");
        GroupBrowseListFragment groupBrowseListFragment2 = this$0.f16612F;
        if (groupBrowseListFragment2 != null && (P12 = groupBrowseListFragment2.P1()) != null && P12.g() && (groupBrowseListFragment = this$0.f16612F) != null && (P13 = groupBrowseListFragment.P1()) != null) {
            P13.n(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n3() {
        FragmentActivity activity = getActivity();
        U0.h hVar = null;
        if (activity != null) {
            U0.h hVar2 = this.f16616J;
            if (hVar2 == null) {
                kotlin.jvm.internal.i.q("bottomDialogManager");
                hVar2 = null;
            }
            String string = getString(R.string.oplus_create_new_group);
            kotlin.jvm.internal.i.e(string, "getString(R.string.oplus_create_new_group)");
            String string2 = getString(R.string.cancel);
            kotlin.jvm.internal.i.e(string2, "getString(R.string.cancel)");
            String string3 = getString(R.string.oplus_menu_save);
            kotlin.jvm.internal.i.e(string3, "getString(R.string.oplus_menu_save)");
            View r10 = U0.h.r(hVar2, activity, R.layout.bottom_dialog_layout_with_edit_text, this, string, string2, string3, false, null, 192, null);
            U0.h hVar3 = this.f16616J;
            if (hVar3 == null) {
                kotlin.jvm.internal.i.q("bottomDialogManager");
                hVar3 = null;
            }
            String string4 = getString(R.string.oplus_input_group_name);
            kotlin.jvm.internal.i.e(string4, "getString(R.string.oplus_input_group_name)");
            hVar3.k(r10, true, string4, false);
            U0.h hVar4 = this.f16616J;
            if (hVar4 == null) {
                kotlin.jvm.internal.i.q("bottomDialogManager");
                hVar4 = null;
            }
            COUIEditText j10 = hVar4.j();
            if (j10 != null) {
                j10.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
            }
        }
        if (CommonFeatureOption.o(getContext())) {
            U0.h hVar5 = this.f16616J;
            if (hVar5 == null) {
                kotlin.jvm.internal.i.q("bottomDialogManager");
            } else {
                hVar = hVar5;
            }
            m.a(hVar.i());
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean A1() {
        return true;
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public boolean H1() {
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment != null && groupBrowseListFragment.Z1()) {
            return false;
        }
        return super.H1();
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public View K1(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle, FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.group_browser_activity, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.navigation_view);
        kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type com.coui.appcompat.bottomnavigation.COUINavigationView");
        this.f16625S = (COUINavigationView) findViewById;
        if (E1() && (inflate instanceof ViewGroup)) {
            View b10 = B.b(getContext(), A1());
            ((ViewGroup) inflate).addView(b10, 0, b10.getLayoutParams());
            AppBarLayout appBarLayout = (AppBarLayout) inflate.findViewById(R.id.appbar);
            View findViewById2 = inflate.findViewById(R.id.list_fragment);
            ViewGroup.LayoutParams layoutParams2 = null;
            if (appBarLayout != null) {
                layoutParams = appBarLayout.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (findViewById2 != null) {
                layoutParams2 = findViewById2.getLayoutParams();
            }
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                int a10 = B.a(getContext());
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = a10;
                View findViewById3 = inflate.findViewById(R.id.list_fragment);
                if (findViewById3 != null) {
                    findViewById3.setPadding(0, a10, 0, 0);
                }
                appBarLayout.setLayoutParams(layoutParams);
            }
        }
        return inflate;
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public void N1(Bundle bundle) {
        kotlin.jvm.internal.i.f(bundle, "bundle");
        this.f16617K = (Account) bundle.getParcelable("account");
        this.f16622P = bundle.getString("groupName");
    }

    public final Intent S2() {
        com.customize.contacts.model.d d10 = com.customize.contacts.model.d.d(this.f16617K);
        kotlin.jvm.internal.i.e(d10, "fromAfter(destAccount)");
        this.f16615I = d10;
        i3(this.f16622P);
        Intent intent = new Intent("com.oplus.contacts.ui.SELECT_CONTACTS_ADD_TO_GROUP");
        intent.putExtra("group_name", this.f16622P);
        intent.putExtra("android.provider.extra.ACCOUNT", this.f16617K);
        intent.putExtra("new_group", true);
        com.customize.contacts.model.d dVar = this.f16615I;
        if (dVar == null) {
            kotlin.jvm.internal.i.q("entityState");
            dVar = null;
        }
        List<GroupValueDelta> j10 = dVar.j();
        List<GroupValueDelta> list = j10;
        if (list != null && !list.isEmpty()) {
            int size = j10.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                Long x02 = j10.get(i10).x0();
                kotlin.jvm.internal.i.e(x02, "lstGroupMembers[i].contactId");
                arrayList.add(new IdRecord(x02.longValue()));
            }
            C0810v.f(C0810v.f22183b, arrayList);
        }
        return intent;
    }

    public final void T2() {
        int i10;
        Context context = this.f16624R;
        if (context == null) {
            kotlin.jvm.internal.i.q("requireContext");
            context = null;
        }
        boolean f10 = x.f(context);
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment != null) {
            if (f10) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            groupBrowseListFragment.m2(i10);
        }
    }

    public final HeaderFooterRecyclerView U2(Context context, C0791b c0791b) {
        HeaderFooterRecyclerView headerFooterRecyclerView = new HeaderFooterRecyclerView(context);
        headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        headerFooterRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        headerFooterRecyclerView.setPadding(0, 0, 0, context.getResources().getDimensionPixelOffset(R.dimen.list_common_margin));
        headerFooterRecyclerView.setAdapter(c0791b);
        return headerFooterRecyclerView;
    }

    public final void V2() {
        new b(this).execute(new Void[0]);
    }

    public final void X2(int i10) {
        if (3 == i10) {
            Context context = this.f16624R;
            if (context == null) {
                kotlin.jvm.internal.i.q("requireContext");
                context = null;
            }
            com.oplus.foundation.util.ui.c.b(context, R.string.oplus_save_failed);
        }
    }

    public final void Y2() {
        Context context = this.f16624R;
        Context context2 = null;
        if (context == null) {
            kotlin.jvm.internal.i.q("requireContext");
            context = null;
        }
        ArrayList<Account> arrayList = this.f16613G;
        if (arrayList == null) {
            kotlin.jvm.internal.i.q("accounts");
            arrayList = null;
        }
        C0791b c0791b = new C0791b(context, arrayList, null);
        c0791b.i(new g());
        DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.android.contacts.group.i
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GroupBrowserActivityFragment.Z2(GroupBrowserActivityFragment.this, dialogInterface);
            }
        };
        Context context3 = this.f16624R;
        if (context3 == null) {
            kotlin.jvm.internal.i.q("requireContext");
            context3 = null;
        }
        HeaderFooterRecyclerView U22 = U2(context3, c0791b);
        Context context4 = this.f16624R;
        if (context4 == null) {
            kotlin.jvm.internal.i.q("requireContext");
        } else {
            context2 = context4;
        }
        m3(context2, R.string.account_of_add_group, U22, onCancelListener);
    }

    public final String a3() {
        return this.f16622P;
    }

    public final Object b3(GroupBrowserActivityFragment groupBrowserActivityFragment, String str, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object e10 = F.e(new GroupBrowserActivityFragment$getResult$2(groupBrowserActivityFragment, str, null), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (e10 == c10) {
            return e10;
        }
        return q.f35511a;
    }

    public final Intent c3(Uri uri, String groupTitle) {
        boolean z10;
        String str;
        String[] b10;
        kotlin.jvm.internal.i.f(groupTitle, "groupTitle");
        Uri CONTENT_URI_VIEW_GROUP = C0814z.f22203a;
        kotlin.jvm.internal.i.e(CONTENT_URI_VIEW_GROUP, "CONTENT_URI_VIEW_GROUP");
        if (uri != null) {
            CONTENT_URI_VIEW_GROUP = ContentUris.withAppendedId(CONTENT_URI_VIEW_GROUP, ContentUris.parseId(uri));
            kotlin.jvm.internal.i.e(CONTENT_URI_VIEW_GROUP, "withAppendedId(\n        …parseId(it)\n            )");
        }
        Context context = this.f16624R;
        Context context2 = null;
        if (context == null) {
            kotlin.jvm.internal.i.q("requireContext");
            context = null;
        }
        C1393c c1393c = new C1393c(context);
        if (c1393c.g() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("URI", CONTENT_URI_VIEW_GROUP);
        if (c1393c.h() == 1) {
            str = "sort_key";
        } else {
            str = "sort_key_alt";
        }
        bundle.putString("ORDER", str);
        if (z10) {
            b10 = R0.b.c();
        } else {
            b10 = R0.b.b();
        }
        bundle.putStringArray("PROJECTION", b10);
        Context context3 = this.f16624R;
        if (context3 == null) {
            kotlin.jvm.internal.i.q("requireContext");
        } else {
            context2 = context3;
        }
        Intent intent = new Intent(context2, (Class<?>) ViewGroupActivity.class);
        intent.setData(uri);
        intent.putExtra("group_name", groupTitle);
        intent.putExtras(bundle);
        return intent;
    }

    public void d3() {
        COUINavigationView cOUINavigationView = this.f16625S;
        if (cOUINavigationView != null) {
            cOUINavigationView.inflateMenu(R.menu.one_action);
        }
        COUINavigationView cOUINavigationView2 = this.f16625S;
        if (cOUINavigationView2 != null) {
            cOUINavigationView2.setOnNavigationItemSelectedListener(new BottomNavigationView.c() { // from class: com.android.contacts.group.h
                @Override // com.google.android.material.navigation.NavigationBarView.c
                public final boolean onNavigationItemSelected(MenuItem menuItem) {
                    boolean e32;
                    e32 = GroupBrowserActivityFragment.e3(GroupBrowserActivityFragment.this, menuItem);
                    return e32;
                }
            });
        }
    }

    public final boolean f3() {
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment == null || !groupBrowseListFragment.Z1()) {
            return false;
        }
        return true;
    }

    @Override // Y0.a
    public void g() {
        Editable editable;
        String str;
        int i10;
        boolean z10;
        this.f16618L = false;
        U0.h hVar = this.f16616J;
        U0.h hVar2 = null;
        if (hVar == null) {
            kotlin.jvm.internal.i.q("bottomDialogManager");
            hVar = null;
        }
        COUIEditText j10 = hVar.j();
        if (j10 != null) {
            editable = j10.getText();
        } else {
            editable = null;
        }
        if (editable != null) {
            str = editable.toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                if (!z11) {
                    i10 = i11;
                } else {
                    i10 = length;
                }
                if (kotlin.jvm.internal.i.g(str.charAt(i10), 32) <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z11) {
                    if (!z10) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z10) {
                    break;
                } else {
                    length--;
                }
            }
            this.f16622P = str.subSequence(i11, length + 1).toString();
        }
        if (!this.f16618L) {
            Context context = this.f16624R;
            if (context == null) {
                kotlin.jvm.internal.i.q("requireContext");
                context = null;
            }
            Context context2 = this.f16624R;
            if (context2 == null) {
                kotlin.jvm.internal.i.q("requireContext");
                context2 = null;
            }
            String string = context2.getString(R.string.oplus_creating_new_group);
            kotlin.jvm.internal.i.e(string, "requireContext.getString…w_group\n                )");
            this.f16631Y = U0.k.o(context, string);
        }
        j3(this);
        U0.h hVar3 = this.f16616J;
        if (hVar3 == null) {
            kotlin.jvm.internal.i.q("bottomDialogManager");
        } else {
            hVar2 = hVar3;
        }
        hVar2.g();
    }

    public final void g3() {
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment != null && groupBrowseListFragment.Z1()) {
            groupBrowseListFragment.O1();
        }
    }

    public boolean h3() {
        Object b10;
        GroupBrowseListFragment groupBrowseListFragment;
        try {
            Result.a aVar = Result.f34166a;
            groupBrowseListFragment = this.f16612F;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        if (groupBrowseListFragment != null && groupBrowseListFragment.Z1()) {
            GroupBrowseListFragment groupBrowseListFragment2 = this.f16612F;
            if (groupBrowseListFragment2 != null) {
                groupBrowseListFragment2.O1();
            }
            return true;
        }
        b10 = Result.b(q.f35511a);
        if (Result.d(b10) != null) {
            o1();
            return true;
        }
        return false;
    }

    public final void i3(String str) {
        com.customize.contacts.model.d dVar = this.f16615I;
        if (dVar == null) {
            kotlin.jvm.internal.i.q("entityState");
            dVar = null;
        }
        EntityDelta.ValuesDelta h10 = dVar.h();
        this.f16623Q = h10;
        if (h10 != null && str != null) {
            if (h10 != null) {
                h10.e0("title", str);
                return;
            }
            return;
        }
        H7.b.b("GroupBrowserActivityFragment", "onFieldChanged(), the value haven't prepared for change");
    }

    public final void j3(GroupBrowserActivityFragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        if (!C0792c.c(fragment.getActivity())) {
            return;
        }
        this.f16622P = fragment.f16622P;
        C1248i.d(androidx.lifecycle.p.a(this), null, null, new GroupBrowserActivityFragment$queryGroupName$1(this, fragment, null), 3, null);
    }

    public final void k3() {
        f<IdRecord> fVar = this.f16619M;
        if (fVar != null) {
            fVar.cancel(true);
        }
        this.f16619M = null;
    }

    public final void l3(boolean z10) {
        if (this.f16620N != null) {
            return;
        }
        com.customize.contacts.model.d dVar = this.f16615I;
        Context context = null;
        if (dVar == null) {
            kotlin.jvm.internal.i.q("entityState");
            dVar = null;
        }
        String i10 = dVar.i();
        if (i10 != null && i10.length() != 0) {
            if (z10) {
                Context context2 = this.f16624R;
                if (context2 == null) {
                    kotlin.jvm.internal.i.q("requireContext");
                } else {
                    context = context2;
                }
                com.oplus.foundation.util.ui.c.b(context, R.string.oplus_group_name_exist);
                o1();
                return;
            }
            e eVar = this.f16620N;
            if (eVar != null) {
                eVar.cancel(true);
            }
            e eVar2 = new e(this);
            eVar2.execute(new Void[0]);
            this.f16620N = eVar2;
            return;
        }
        Context context3 = this.f16624R;
        if (context3 == null) {
            kotlin.jvm.internal.i.q("requireContext");
        } else {
            context = context3;
        }
        com.oplus.foundation.util.ui.c.b(context, R.string.oplus_group_name_cannot_be_empty);
    }

    public final void m3(Context context, int i10, View view, DialogInterface.OnCancelListener onCancelListener) {
        androidx.appcompat.app.b bVar;
        U0.b bVar2 = new U0.b(context, 2132083075);
        this.f16633a0 = bVar2;
        bVar2.setTitle(i10);
        bVar2.setView(view);
        bVar2.setOnCancelListener(onCancelListener);
        U0.b bVar3 = this.f16633a0;
        if (bVar3 != null) {
            bVar = bVar3.show();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.setCanceledOnTouchOutside(true);
        }
        if (CommonFeatureOption.o(context)) {
            m.a(this.f16633a0);
        }
    }

    public final void o3() {
        S7.b.b(this, S2(), 888, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 339) {
            if (i10 != 888 || intent == null || i11 != -1 || !intent.hasExtra("NEW_RET_CONTACTS")) {
                return;
            }
            ArrayList i12 = C7.e.i(intent, "NEW_RET_CONTACTS");
            kotlin.jvm.internal.i.d(i12, "null cannot be cast to non-null type java.util.ArrayList<com.customize.contacts.model.IdRecord>{ kotlin.collections.TypeAliasesKt.ArrayList<com.customize.contacts.model.IdRecord> }");
            f<IdRecord> fVar = this.f16619M;
            if (fVar != null) {
                fVar.cancel(true);
            }
            f<IdRecord> fVar2 = new f<>(this, i12);
            fVar2.execute(new Void[0]);
            this.f16619M = fVar2;
            return;
        }
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment != null) {
            groupBrowseListFragment.O1();
        }
        if (-1 == i11) {
            ArrayList i13 = C7.e.i(intent, "SELECTED_CONTACTS");
            kotlin.jvm.internal.i.d(i13, "null cannot be cast to non-null type java.util.ArrayList<com.coloros.contacts.common.ContactParcelable>{ kotlin.collections.TypeAliasesKt.ArrayList<com.coloros.contacts.common.ContactParcelable> }");
            Context context = this.f16624R;
            if (context == null) {
                kotlin.jvm.internal.i.q("requireContext");
                context = null;
            }
            C0792c.i(context, i13, true, C7.e.c(intent, "click_complete", false));
        }
    }

    @Override // Y0.a
    public void onCancel() {
        U0.h hVar = this.f16616J;
        if (hVar == null) {
            kotlin.jvm.internal.i.q("bottomDialogManager");
            hVar = null;
        }
        hVar.g();
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        float f10;
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (E1() && CommonFeatureOption.j()) {
            GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
            if (groupBrowseListFragment != null && groupBrowseListFragment.Z1()) {
                if (DisplayUtil.r(getActivity(), newConfig, null, 4, null)) {
                    View view = this.f16626T;
                    if (view != null) {
                        if (view != null) {
                            f10 = view.getHeight();
                        } else {
                            f10 = 0.0f;
                        }
                        view.setTranslationY(f10);
                    }
                } else {
                    View view2 = this.f16626T;
                    if (view2 != null) {
                        view2.setTranslationY(0.0f);
                    }
                }
            }
            View w12 = w1();
            if (w12 != null) {
                w12.setTranslationY(0.0f);
            }
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        this.f16624R = requireContext;
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GroupBrowseListFragment groupBrowseListFragment;
        View view;
        e eVar = this.f16620N;
        if (eVar != null) {
            eVar.cancel(true);
        }
        f<IdRecord> fVar = this.f16619M;
        if (fVar != null) {
            fVar.cancel(true);
        }
        d dVar = this.f16614H;
        if (dVar != null) {
            dVar.removeCallbacksAndMessages(null);
        }
        if (E1() && CommonFeatureOption.j() && (groupBrowseListFragment = this.f16612F) != null && groupBrowseListFragment.Z1() && (view = this.f16626T) != null) {
            view.setTranslationY(0.0f);
        }
        androidx.appcompat.app.b bVar = this.f16631Y;
        if (bVar != null) {
            bVar.dismiss();
        }
        this.f16631Y = null;
        super.onDestroy();
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f16632Z.g();
        super.onDestroyView();
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        outState.putParcelable("account", this.f16617K);
        outState.putString("groupName", this.f16622P);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        T2();
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment != null) {
            boolean z10 = false;
            if (!groupBrowseListFragment.Z1() ? groupBrowseListFragment.Q1() > 0 : groupBrowseListFragment.S1() > 0) {
                z10 = true;
            }
            q3(z10, groupBrowseListFragment.Z1());
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        View view2;
        kotlin.jvm.internal.i.f(view, "view");
        W2();
        super.onViewCreated(view, bundle);
        this.f16616J = new U0.h();
        this.f16614H = new d(this);
        d3();
        if (E1() && CommonFeatureOption.j()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                view2 = activity.findViewById(R.id.navigation_label_view);
            } else {
                view2 = null;
            }
            kotlin.jvm.internal.i.c(view2);
            this.f16626T = view2;
            View w12 = w1();
            if (w12 != null) {
                w12.getViewTreeObserver().addOnGlobalLayoutListener(new h(w12));
            }
        }
    }

    public final void p3() {
        float f10;
        View w12 = w1();
        if (w12 != null) {
            float height = w12.getHeight();
            Property property = View.TRANSLATION_Y;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(w12, (Property<View, Float>) property, height, 0.0f);
            ofFloat.setDuration(300L);
            T.a aVar = T.f21946p;
            ofFloat.setInterpolator(aVar.c());
            ofFloat.setStartDelay(100L);
            this.f16627U = ofFloat;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(w12, (Property<View, Float>) property, 0.0f, height);
            ofFloat2.setDuration(230L);
            ofFloat2.setInterpolator(aVar.b());
            this.f16628V = ofFloat2;
            View view = this.f16626T;
            if (view != null) {
                f10 = view.getHeight();
            } else {
                f10 = 0.0f;
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f16626T, (Property<View, Float>) property, f10, 0.0f);
            ofFloat3.setDuration(200L);
            ofFloat3.setStartDelay(230L);
            ofFloat3.setInterpolator(aVar.a());
            this.f16629W = ofFloat3;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f16626T, (Property<View, Float>) property, 0.0f, f10);
            ofFloat4.setDuration(200L);
            ofFloat4.setInterpolator(aVar.a());
            this.f16630X = ofFloat4;
        }
    }

    public final void q3(boolean z10, boolean z11) {
        r3(z11, z10);
    }

    public final void r3(boolean z10, boolean z11) {
        MenuItem menuItem;
        Menu menu;
        COUINavigationView cOUINavigationView = this.f16625S;
        Context context = null;
        if (cOUINavigationView != null && (menu = cOUINavigationView.getMenu()) != null) {
            menuItem = menu.findItem(R.id.delete);
        } else {
            menuItem = null;
        }
        if (z10) {
            if (menuItem != null) {
                menuItem.setEnabled(z11);
                menuItem.setTitle(R.string.delete_button);
                Context context2 = this.f16624R;
                if (context2 == null) {
                    kotlin.jvm.internal.i.q("requireContext");
                } else {
                    context = context2;
                }
                menuItem.setIcon(context.getDrawable(R.drawable.pb_dr_menu_delete));
            }
        } else if (menuItem != null) {
            menuItem.setEnabled(true);
        }
        f2(z10);
        GroupBrowseListFragment groupBrowseListFragment = this.f16612F;
        if (groupBrowseListFragment != null) {
            groupBrowseListFragment.g2(z10);
        }
    }

    /* compiled from: GroupBrowserActivityFragment.kt */
    /* loaded from: classes.dex */
    public final class c implements GroupBrowseListFragment.c {
        public c() {
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.c
        public void a() {
            boolean z10;
            GroupBrowseListFragment groupBrowseListFragment = GroupBrowserActivityFragment.this.f16612F;
            if (groupBrowseListFragment != null) {
                GroupBrowserActivityFragment groupBrowserActivityFragment = GroupBrowserActivityFragment.this;
                boolean z11 = false;
                if (!groupBrowseListFragment.Z1() ? groupBrowseListFragment.Q1() > 0 : groupBrowseListFragment.S1() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                groupBrowserActivityFragment.q3(z10, groupBrowseListFragment.Z1());
                if (groupBrowseListFragment.Q1() > 0) {
                    z11 = true;
                }
                groupBrowseListFragment.p2(z11);
            }
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.c
        public void b() {
            GroupBrowserActivityFragment.this.r3(true, false);
            if (GroupBrowserActivityFragment.this.E1() && CommonFeatureOption.j()) {
                ContactsTabActivity contactsTabActivity = null;
                if (DisplayUtil.r(GroupBrowserActivityFragment.this.getActivity(), null, null, 6, null)) {
                    FragmentActivity activity = GroupBrowserActivityFragment.this.getActivity();
                    if (activity instanceof ContactsTabActivity) {
                        contactsTabActivity = (ContactsTabActivity) activity;
                    }
                    if (contactsTabActivity != null) {
                        contactsTabActivity.g3(false);
                    }
                    View view = GroupBrowserActivityFragment.this.getView();
                    if (view != null) {
                        GroupBrowserActivityFragment groupBrowserActivityFragment = GroupBrowserActivityFragment.this;
                        Integer q12 = groupBrowserActivityFragment.q1();
                        if (q12 != null) {
                            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), q12.intValue());
                        }
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(groupBrowserActivityFragment.f16627U, groupBrowserActivityFragment.f16630X);
                        animatorSet.addListener(new a(groupBrowserActivityFragment));
                        animatorSet.start();
                    }
                }
            }
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.c
        public void c(Uri uri, String groupTitle) {
            kotlin.jvm.internal.i.f(groupTitle, "groupTitle");
            Context context = GroupBrowserActivityFragment.this.f16624R;
            if (context == null) {
                kotlin.jvm.internal.i.q("requireContext");
                context = null;
            }
            R7.b.f(context, GroupBrowserActivityFragment.this.c3(uri, groupTitle), 0, null, 6, null);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.c
        public void d() {
            boolean z10 = true;
            if (GroupBrowserActivityFragment.this.E1()) {
                if (CommonFeatureOption.j()) {
                    ContactsTabActivity contactsTabActivity = null;
                    if (DisplayUtil.r(GroupBrowserActivityFragment.this.getActivity(), null, null, 6, null)) {
                        FragmentActivity activity = GroupBrowserActivityFragment.this.getActivity();
                        if (activity instanceof ContactsTabActivity) {
                            contactsTabActivity = (ContactsTabActivity) activity;
                        }
                        if (contactsTabActivity != null) {
                            contactsTabActivity.g3(true);
                        }
                        AnimatorSet animatorSet = new AnimatorSet();
                        GroupBrowserActivityFragment groupBrowserActivityFragment = GroupBrowserActivityFragment.this;
                        animatorSet.playTogether(groupBrowserActivityFragment.f16628V, groupBrowserActivityFragment.f16629W);
                        animatorSet.addListener(new b(groupBrowserActivityFragment, this, groupBrowserActivityFragment, this));
                        animatorSet.start();
                        return;
                    }
                }
                TabActivityViewModel x12 = GroupBrowserActivityFragment.this.x1();
                if (x12 != null) {
                    x12.n(0);
                }
                View view = GroupBrowserActivityFragment.this.f16626T;
                if (view != null) {
                    view.setTranslationY(0.0f);
                }
                GroupBrowseListFragment groupBrowseListFragment = GroupBrowserActivityFragment.this.f16612F;
                if (groupBrowseListFragment != null) {
                    GroupBrowserActivityFragment groupBrowserActivityFragment2 = GroupBrowserActivityFragment.this;
                    if (groupBrowseListFragment.Q1() <= 0) {
                        z10 = false;
                    }
                    groupBrowserActivityFragment2.q3(z10, false);
                    return;
                }
                return;
            }
            TabActivityViewModel x13 = GroupBrowserActivityFragment.this.x1();
            if (x13 != null) {
                x13.n(0);
            }
            GroupBrowseListFragment groupBrowseListFragment2 = GroupBrowserActivityFragment.this.f16612F;
            if (groupBrowseListFragment2 != null) {
                GroupBrowserActivityFragment groupBrowserActivityFragment3 = GroupBrowserActivityFragment.this;
                if (groupBrowseListFragment2.Q1() <= 0) {
                    z10 = false;
                }
                groupBrowserActivityFragment3.q3(z10, false);
            }
        }

        public final void f() {
            boolean z10;
            GroupBrowserActivityFragment groupBrowserActivityFragment;
            Integer q12;
            View view = GroupBrowserActivityFragment.this.getView();
            if (view != null && (q12 = (groupBrowserActivityFragment = GroupBrowserActivityFragment.this).q1()) != null) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), q12.intValue() + groupBrowserActivityFragment.getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_unfold_height));
            }
            GroupBrowseListFragment groupBrowseListFragment = GroupBrowserActivityFragment.this.f16612F;
            if (groupBrowseListFragment != null) {
                GroupBrowserActivityFragment groupBrowserActivityFragment2 = GroupBrowserActivityFragment.this;
                if (groupBrowseListFragment.Q1() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                groupBrowserActivityFragment2.q3(z10, false);
            }
        }

        /* compiled from: Animator.kt */
        /* loaded from: classes.dex */
        public static final class a implements Animator.AnimatorListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GroupBrowserActivityFragment f16635a;

            public a(GroupBrowserActivityFragment groupBrowserActivityFragment) {
                this.f16635a = groupBrowserActivityFragment;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View w12 = this.f16635a.w1();
                if (w12 != null) {
                    w12.setVisibility(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }

        /* compiled from: Animator.kt */
        /* loaded from: classes.dex */
        public static final class b implements Animator.AnimatorListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GroupBrowserActivityFragment f16636a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f16637b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f16638c;

            public b(GroupBrowserActivityFragment groupBrowserActivityFragment, c cVar, GroupBrowserActivityFragment groupBrowserActivityFragment2, c cVar2) {
                this.f16636a = groupBrowserActivityFragment;
                this.f16637b = cVar;
                this.f16638c = cVar2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TabActivityViewModel x12 = this.f16636a.x1();
                if (x12 != null) {
                    x12.n(0);
                }
                this.f16638c.f();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TabActivityViewModel x12 = this.f16636a.x1();
                if (x12 != null) {
                    x12.n(0);
                }
                this.f16637b.f();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }
    }
}
