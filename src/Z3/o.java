package Z3;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.AiCallTranslateStateController;
import com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil;
import com.android.contacts.framework.baseui.util.q;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.android.contacts.model.Account;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.BusinessCardCaptureActivity;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.ServiceNumberActivity;
import com.customize.contacts.activities.SimAccountsListActivity;
import com.customize.contacts.activities.SimContactsListActivity;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.h0;
import com.customize.contacts.util.k0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.ArrayList;
import java.util.HashMap;
import r0.C1501d;
import v9.InterfaceC1637a;
import w0.C1641a;
import w0.C1643c;

/* compiled from: MorePopupMenuTool.kt */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: i, reason: collision with root package name */
    public static final a f5939i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Activity f5940a;

    /* renamed from: b, reason: collision with root package name */
    public final TabActivityViewModel f5941b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1637a<Boolean> f5942c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<PopupListItem> f5943d;

    /* renamed from: e, reason: collision with root package name */
    public COUIPopupListWindow f5944e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap<String, Integer> f5945f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5946g;

    /* renamed from: h, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f5947h;

    /* compiled from: MorePopupMenuTool.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public o(Activity activity, TabActivityViewModel viewModel, InterfaceC1637a<Boolean> interfaceC1637a) {
        int i10;
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(viewModel, "viewModel");
        this.f5940a = activity;
        this.f5941b = viewModel;
        this.f5942c = interfaceC1637a;
        this.f5943d = new ArrayList<>();
        int e10 = e();
        this.f5946g = e10;
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        this.f5945f = hashMap;
        hashMap.put(g(R.string.oplus_menu_edit), 9);
        hashMap.put(g(R.string.oplus_black_list), 0);
        hashMap.put(g(R.string.scan_business_card_description), 1);
        hashMap.put(g(R.string.oplus_button_set), 2);
        hashMap.put(g(R.string.oplus_business_card), 4);
        hashMap.put(g(R.string.oplus_my_groups), 5);
        hashMap.put(g(R.string.oplus_sdn_serviceNumber), 6);
        hashMap.put(g(R.string.oplus_rcs_group_chat), 7);
        hashMap.put(g(R.string.adn_dialog_title), 8);
        hashMap.put(g(R.string.menu_contact_manage), 10);
        hashMap.put(g(R.string.menu_refresh), 11);
        hashMap.put(g(R.string.menu_title_chaken), 13);
        hashMap.put(g(R.string.menu_tile_chaken_contacts), 14);
        if (C0811w.f()) {
            i10 = R.string.no_network_title_v2_rlm;
        } else {
            i10 = R.string.no_network_title_v2;
        }
        hashMap.put(g(i10), 15);
        if (e10 != 0) {
            hashMap.put(g(e10), 12);
        }
        this.f5947h = new AdapterView.OnItemClickListener() { // from class: Z3.l
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                o.j(o.this, adapterView, view, i11, j10);
            }
        };
    }

    public static final void j(final o this$0, AdapterView adapterView, final View view, int i10, long j10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (C7.a.a()) {
            return;
        }
        PopupListItem popupListItem = this$0.f5943d.get(i10);
        kotlin.jvm.internal.i.e(popupListItem, "menuItemList[position]");
        PopupListItem popupListItem2 = popupListItem;
        Integer num = this$0.f5945f.get(popupListItem2.getTitle());
        if (num != null && num.intValue() == 9) {
            if (!view.isEnabled()) {
                return;
            }
            InterfaceC1637a<Boolean> interfaceC1637a = this$0.f5942c;
            if (interfaceC1637a != null) {
                interfaceC1637a.invoke();
            }
            h0.Z(view.getContext(), "edit", this$0.f());
        } else {
            if (num != null && num.intValue() == 0) {
                if (!PrimaryUserUtils.a()) {
                    return;
                }
                Activity activity = this$0.f5940a;
                String str = C1501d.f36273b;
                if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                    this$0.d();
                    com.android.contacts.framework.baseui.util.l.f(this$0.f5940a, str, null, kotlin.jvm.internal.i.b(this$0.f(), TabActivityViewModel.TabFragment.Dialer.b()) ? 1 : 0);
                    return;
                }
                com.android.contacts.framework.api.appstore.appinfo.a.a(this$0.f5940a, new Runnable() { // from class: Z3.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.k(view, this$0);
                    }
                });
            } else {
                if (num != null && num.intValue() == 1) {
                    if (popupListItem2.isEnable()) {
                        A.a(view.getContext(), 2000306, 200030287, null, false);
                        this$0.o();
                        COUIPopupListWindow cOUIPopupListWindow = this$0.f5944e;
                        View contentView = cOUIPopupListWindow != null ? cOUIPopupListWindow.getContentView() : null;
                        if (contentView != null) {
                            contentView.postDelayed(new Runnable() { // from class: Z3.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    o.l(o.this);
                                }
                            }, 100);
                        }
                        h0.Z(view.getContext(), "scan_card", this$0.f());
                        return;
                    }
                    return;
                }
                if (num != null && num.intValue() == 10) {
                    if (!PrimaryUserUtils.a()) {
                        return;
                    }
                    C0792c.k(this$0.f5940a, 1, -1);
                    h0.Z(view.getContext(), "contact_manager", this$0.f());
                } else if (num != null && num.intValue() == 12) {
                    if (!FeatureOption.g() || !PrimaryUserUtils.a()) {
                        return;
                    }
                    this$0.m();
                    h0.Z(view.getContext(), "service_hall_manager", this$0.f());
                } else if (num != null && num.intValue() == 2) {
                    if (!PrimaryUserUtils.a()) {
                        return;
                    }
                    if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                        com.android.contacts.framework.api.appstore.appinfo.a.n(this$0.f5940a);
                    } else {
                        C0792c.k(this$0.f5940a, 0, -1);
                    }
                    h0.Z(view.getContext(), "setting", this$0.f());
                } else if (num != null && num.intValue() == 11) {
                    if (!PrimaryUserUtils.a()) {
                        return;
                    }
                    if (C1643c.q()) {
                        C1643c.z(this$0.f5940a);
                        h0.Z(view.getContext(), "voice_mail_refresh", this$0.f());
                    }
                } else if (num != null && num.intValue() == 6) {
                    ArrayList<Account> m10 = M3.c.m(view.getContext());
                    int size = m10.size();
                    if (size == 1) {
                        Intent intent = new Intent(this$0.f5940a, (Class<?>) ServiceNumberActivity.class);
                        intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, m10.get(0).f16941a);
                        R7.b.f(this$0.f5940a, intent, 0, null, 6, null);
                    } else if (size > 1) {
                        Intent intent2 = new Intent(view.getContext(), (Class<?>) SimAccountsListActivity.class);
                        intent2.putExtra("show_sdn_service_number", true);
                        R7.b.f(this$0.f5940a, intent2, 0, null, 6, null);
                    }
                    h0.Z(view.getContext(), "SDN_number", this$0.f());
                } else if (num != null && num.intValue() == 7) {
                    Intent intent3 = new Intent("com.suntek.mway.rcs.nativeui.ACTION_LUNCH_RCS_GROUPCHALIST");
                    intent3.putExtra("isFromContact", true);
                    R7.b.f(this$0.f5940a, intent3, 0, null, 6, null);
                    h0.Z(view.getContext(), "RCS_group", this$0.f());
                } else if (num != null && num.intValue() == 8) {
                    ArrayList<Account> m11 = M3.c.m(view.getContext());
                    int size2 = m11.size();
                    if (size2 == 1) {
                        Intent intent4 = new Intent(view.getContext(), (Class<?>) SimContactsListActivity.class);
                        intent4.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, m11.get(0).f16941a);
                        R7.b.f(this$0.f5940a, intent4, 0, null, 6, null);
                    } else if (size2 > 1) {
                        R7.b.f(this$0.f5940a, new Intent(view.getContext(), (Class<?>) SimAccountsListActivity.class), 0, null, 6, null);
                    } else if (b0.O() > 0) {
                        com.oplus.foundation.util.ui.c.b(view.getContext(), R.string.oplus_refreshing_sim_data);
                    } else {
                        com.oplus.foundation.util.ui.c.b(view.getContext(), R.string.simcard_abnormal_please_check_and_try_again);
                    }
                    h0.Z(view.getContext(), "sim_card_contact", this$0.f());
                } else if (num != null && num.intValue() == 13) {
                    Intent intent5 = new Intent("com.oplus.chaken.start.action");
                    intent5.putExtra("chaken_start_type", 13);
                    R7.b.f(this$0.f5940a, intent5, 0, null, 6, null);
                } else if (num != null && num.intValue() == 14) {
                    Intent intent6 = new Intent("com.oplus.chaken.start.action");
                    intent6.putExtra("chaken_start_type", 14);
                    R7.b.f(this$0.f5940a, intent6, 0, null, 6, null);
                } else if (num != null && num.intValue() == 15) {
                    if (!view.isEnabled()) {
                        return;
                    }
                    NoNetworkCommUiStateUtil.f15861a.p(this$0.f5940a);
                    h0.Z(view.getContext(), "beacon_link", this$0.f());
                }
            }
        }
        COUIPopupListWindow cOUIPopupListWindow2 = this$0.f5944e;
        if (cOUIPopupListWindow2 != null) {
            cOUIPopupListWindow2.dismiss();
        }
    }

    public static final void k(View view, o this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        A.a(view.getContext(), 2000303, 200030288, null, false);
        Intent intent = new Intent();
        intent.setAction(k0.f22138b);
        intent.putExtra("start_from_callLog", true);
        String c10 = com.android.contacts.framework.api.appstore.appinfo.a.c();
        if (c10.length() > 0) {
            intent.setPackage(c10);
        }
        R7.b.f(this$0.f5940a, intent, 0, null, 6, null);
        h0.Z(view.getContext(), "block_filter", this$0.f());
    }

    public static final void l(o this$0) {
        COUIPopupListWindow cOUIPopupListWindow;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (!this$0.f5940a.isFinishing() && !this$0.f5940a.isDestroyed() && (cOUIPopupListWindow = this$0.f5944e) != null) {
            cOUIPopupListWindow.dismiss();
        }
    }

    public final void d() {
        COUIPopupListWindow cOUIPopupListWindow = this.f5944e;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            COUIPopupListWindow cOUIPopupListWindow2 = this.f5944e;
            if (cOUIPopupListWindow2 != null) {
                cOUIPopupListWindow2.dismiss();
            }
            this.f5944e = null;
        }
    }

    public final int e() {
        if (FeatureOption.g()) {
            return com.android.contacts.framework.api.businesshall.a.d();
        }
        return 0;
    }

    public final String f() {
        TabActivityViewModel.TabFragment value = this.f5941b.j().getValue();
        if (value != null) {
            return value.b();
        }
        return null;
    }

    public final String g(int i10) {
        String string = P7.a.f2961a.a().getString(i10);
        kotlin.jvm.internal.i.e(string, "ContextGetter.context.getString(resId)");
        return string;
    }

    public final void h(boolean z10) {
        int i10;
        boolean z11;
        int i11;
        this.f5943d.clear();
        ArrayList<PopupListItem> arrayList = this.f5943d;
        if (z10) {
            arrayList.add(q.e(g(R.string.oplus_menu_edit), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        if (kotlin.jvm.internal.i.b(NoNetworkCommUiStateUtil.i().getValue(), Boolean.TRUE)) {
            if (C0811w.f()) {
                i11 = R.string.no_network_title_v2_rlm;
            } else {
                i11 = R.string.no_network_title_v2;
            }
            arrayList.add(q.e(g(i11), PrimaryUserUtils.a(), false, 0, null, null, 0, null, null, null, 0, 2040, null));
        }
        if (!B3.a.q(this.f5940a)) {
            Activity activity = this.f5940a;
            if (activity != null) {
                z11 = activity.isInMultiWindowMode();
            } else {
                z11 = false;
            }
            arrayList.add(q.e(g(R.string.scan_business_card_description), !z11, false, 0, null, null, 0, null, null, null, 0, 2044, null));
        }
        if (B3.a.F()) {
            arrayList.add(q.e(g(R.string.oplus_black_list), PrimaryUserUtils.a(), false, 0, null, null, 0, null, null, null, 0, 2044, null));
        }
        arrayList.add(q.e(g(R.string.menu_contact_manage), PrimaryUserUtils.a(), false, 0, null, null, 0, null, null, null, 0, 2044, null));
        if (C1643c.q()) {
            Activity activity2 = this.f5940a;
            kotlin.jvm.internal.i.d(activity2, "null cannot be cast to non-null type com.customize.contacts.activities.ContactsTabActivity");
            if (((ContactsTabActivity) activity2).k2() == 2) {
                arrayList.add(q.e(g(R.string.menu_refresh), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
        }
        if (this.f5946g != 0 && !com.android.contacts.framework.baseui.util.m.a(this.f5940a)) {
            arrayList.add(q.e(g(this.f5946g), PrimaryUserUtils.a(), false, 0, null, null, 0, null, null, null, 0, 2044, null));
        }
        if (B3.a.J()) {
            arrayList.add(q.e(g(R.string.menu_title_chaken), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            arrayList.add(q.e(g(R.string.menu_tile_chaken_contacts), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        if (C1641a.x(this.f5940a)) {
            arrayList.add(q.e(g(R.string.oplus_sdn_serviceNumber), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        if (B3.a.s(this.f5940a)) {
            arrayList.add(q.e(g(R.string.oplus_rcs_group_chat), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        if (CommonFeatureOption.j()) {
            PopupListItem e10 = q.e(g(R.string.oplus_button_set), PrimaryUserUtils.a(), false, 0, null, null, 0, null, null, null, 0, 2044, null);
            if (AiCallTranslateStateController.f15829b.a().f(P7.a.f2961a.a())) {
                i10 = 0;
            } else {
                i10 = -1;
            }
            e10.setRedDotAmount(i10);
            e10.setHintType(0);
            arrayList.add(e10);
        }
    }

    public final boolean i() {
        COUIPopupListWindow cOUIPopupListWindow = this.f5944e;
        if (cOUIPopupListWindow == null || !cOUIPopupListWindow.isShowing()) {
            return false;
        }
        return true;
    }

    public final void m() {
        com.android.contacts.framework.api.businesshall.a.k(this.f5940a);
    }

    public final boolean n(View view, boolean z10) {
        if (!C0792c.c(this.f5940a)) {
            return false;
        }
        if (i()) {
            d();
            H7.b.c("MorePopupMenuTool", "showMorePopupMenu isPopupMenuShowing");
            return false;
        }
        if (H7.a.b()) {
            H7.b.b("MorePopupMenuTool", "start showMorePopupMenu");
        }
        h(z10);
        COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(this.f5940a);
        cOUIPopupListWindow.setItemList(this.f5943d);
        cOUIPopupListWindow.setDismissTouchOutside(true);
        cOUIPopupListWindow.setOnItemClickListener(this.f5947h);
        cOUIPopupListWindow.setOffset(0, 0, 0, -this.f5940a.getResources().getDimensionPixelOffset(R.dimen.DP_9));
        cOUIPopupListWindow.setAlwaysBelowAnchor(true);
        cOUIPopupListWindow.show(view);
        this.f5944e = cOUIPopupListWindow;
        return true;
    }

    public final void o() {
        Intent intent = new Intent(this.f5940a, (Class<?>) BusinessCardCaptureActivity.class);
        intent.putExtra("mode", "from_main_activity");
        R7.b.f(this.f5940a, intent, 0, null, 6, null);
    }
}
