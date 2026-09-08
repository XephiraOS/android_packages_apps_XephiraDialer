package com.android.contacts.detail;

import E3.j;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Entity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.android.contacts.C0656n;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsApplication;
import com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager;
import com.android.contacts.detail.i0;
import com.android.contacts.framework.api.rcs.IRcsApi;
import com.android.contacts.framework.baseui.util.C0637b;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import h1.C1073b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import w0.C1643c;

/* compiled from: ViewAdapter.java */
/* loaded from: classes.dex */
public class E0 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f14468a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f14469b;

    /* renamed from: c, reason: collision with root package name */
    public final f f14470c;

    /* renamed from: d, reason: collision with root package name */
    public final View.OnTouchListener f14471d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<i0.m> f14472e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14473f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<String, Integer> f14474g;

    /* renamed from: h, reason: collision with root package name */
    public Set<String> f14475h;

    /* renamed from: i, reason: collision with root package name */
    public RecordPlayerPresenter f14476i;

    /* renamed from: j, reason: collision with root package name */
    public int f14477j;

    /* renamed from: k, reason: collision with root package name */
    public int f14478k;

    /* renamed from: l, reason: collision with root package name */
    public AutoCallSummaryTipManager f14479l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<View> f14480m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<View> f14481n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<View> f14482o;

    /* renamed from: p, reason: collision with root package name */
    public View f14483p;

    /* renamed from: q, reason: collision with root package name */
    public View f14484q;

    /* renamed from: r, reason: collision with root package name */
    public ConcurrentHashMap<String, Drawable> f14485r;

    /* compiled from: ViewAdapter.java */
    /* loaded from: classes.dex */
    public class a implements IRcsApi.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f14486a;

        public a(b bVar) {
            this.f14486a = bVar;
        }

        @Override // com.android.contacts.framework.api.rcs.IRcsApi.a
        public void a(String str, boolean z10, String str2, boolean z11) {
            if (com.android.contacts.framework.api.rcs.a.c(str.substring(3))) {
                this.f14486a.f14494g.setVisibility(0);
            } else {
                this.f14486a.f14494g.setVisibility(8);
            }
        }
    }

    /* compiled from: ViewAdapter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f14488a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f14489b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f14490c;

        /* renamed from: d, reason: collision with root package name */
        public final TextView f14491d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f14492e;

        /* renamed from: f, reason: collision with root package name */
        public final TextView f14493f;

        /* renamed from: g, reason: collision with root package name */
        public final TextView f14494g;

        /* renamed from: h, reason: collision with root package name */
        public final TextView f14495h;

        /* renamed from: i, reason: collision with root package name */
        public final ImageView f14496i;

        /* renamed from: j, reason: collision with root package name */
        public final ImageView f14497j;

        /* renamed from: k, reason: collision with root package name */
        public final View f14498k;

        /* renamed from: l, reason: collision with root package name */
        public final View f14499l;

        /* renamed from: m, reason: collision with root package name */
        public final View f14500m;

        /* renamed from: n, reason: collision with root package name */
        public final View f14501n;

        /* renamed from: o, reason: collision with root package name */
        public final View f14502o;

        /* renamed from: p, reason: collision with root package name */
        public final View f14503p;

        /* renamed from: q, reason: collision with root package name */
        public final ImageView f14504q;

        /* renamed from: r, reason: collision with root package name */
        public final TextView f14505r;

        /* renamed from: s, reason: collision with root package name */
        public final View f14506s;

        /* renamed from: t, reason: collision with root package name */
        public final View f14507t;

        /* renamed from: u, reason: collision with root package name */
        public final View f14508u;

        /* renamed from: v, reason: collision with root package name */
        public final ImageView f14509v;

        /* renamed from: w, reason: collision with root package name */
        public final ImageView f14510w;

        /* renamed from: x, reason: collision with root package name */
        public final View f14511x;

        public b(View view, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
            this.f14488a = (TextView) view.findViewById(R.id.type);
            this.f14489b = (TextView) view.findViewById(R.id.place);
            this.f14490c = (ImageView) view.findViewById(R.id.contact_detail_item_icon);
            this.f14506s = view.findViewById(R.id.type_icon_layout);
            this.f14491d = (TextView) view.findViewById(R.id.contact_detail_item_type);
            this.f14492e = (TextView) view.findViewById(R.id.data);
            this.f14493f = (TextView) view.findViewById(R.id.recent);
            this.f14494g = (TextView) view.findViewById(R.id.rcs);
            this.f14495h = (TextView) view.findViewById(R.id.footer);
            this.f14502o = view.findViewById(R.id.primary_indicator);
            this.f14496i = (ImageView) view.findViewById(R.id.presence_icon);
            View findViewById = view.findViewById(R.id.actions_view_container);
            this.f14498k = findViewById;
            this.f14499l = view.findViewById(R.id.pre_primary_action_view_phone);
            this.f14500m = view.findViewById(R.id.primary_action_view);
            this.f14503p = view.findViewById(R.id.detail_item_layout);
            this.f14504q = (ImageView) view.findViewById(R.id.type_icon);
            this.f14505r = (TextView) view.findViewById(R.id.default_view);
            this.f14511x = view.findViewById(R.id.bottom_divider);
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.video_call_action_view_stub);
            ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.rcs_state_button_view_stub);
            if (C1643c.w()) {
                if (viewStub != null) {
                    viewStub.inflate();
                }
                if (viewStub2 != null) {
                    viewStub2.inflate();
                }
            }
            View findViewById2 = view.findViewById(R.id.ust_rcs_action_view_container);
            this.f14507t = findViewById2;
            this.f14508u = view.findViewById(R.id.ust_rcs_state_container);
            this.f14509v = (ImageView) view.findViewById(R.id.ust_rcs_state);
            this.f14510w = (ImageView) view.findViewById(R.id.ust_rcs_video_button);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(onClickListener3);
            }
            findViewById.setOnClickListener(onClickListener);
            View findViewById3 = view.findViewById(R.id.secondary_action_view_container);
            this.f14501n = findViewById3;
            findViewById3.setOnClickListener(onClickListener2);
            this.f14497j = (ImageView) view.findViewById(R.id.secondary_action_button);
        }
    }

    /* compiled from: ViewAdapter.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ImageView f14512a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f14513b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f14514c;

        /* renamed from: d, reason: collision with root package name */
        public final TextView f14515d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f14516e;

        /* renamed from: f, reason: collision with root package name */
        public final ImageView f14517f;

        /* renamed from: g, reason: collision with root package name */
        public final RelativeLayout f14518g;

        /* renamed from: h, reason: collision with root package name */
        public final int f14519h;

        /* renamed from: i, reason: collision with root package name */
        public final ImageView f14520i;

        /* renamed from: j, reason: collision with root package name */
        public final ImageView f14521j;

        /* renamed from: k, reason: collision with root package name */
        public final ImageView f14522k;

        /* renamed from: l, reason: collision with root package name */
        public final TextView f14523l;

        /* renamed from: m, reason: collision with root package name */
        public final TextView f14524m;

        /* renamed from: n, reason: collision with root package name */
        public final TextView f14525n;

        /* renamed from: o, reason: collision with root package name */
        public final View f14526o;

        /* renamed from: p, reason: collision with root package name */
        public final View f14527p;

        /* renamed from: q, reason: collision with root package name */
        public final View f14528q;

        /* renamed from: r, reason: collision with root package name */
        public final View f14529r;

        public c(View view, int i10) {
            this.f14519h = i10;
            this.f14512a = (ImageView) view.findViewById(R.id.detail_photo);
            this.f14513b = (TextView) view.findViewById(R.id.main_title);
            this.f14514c = (TextView) view.findViewById(R.id.sub_title_pinyin);
            this.f14515d = (TextView) view.findViewById(R.id.sub_title_vip);
            TextView textView = (TextView) view.findViewById(R.id.sub_title_company);
            this.f14516e = textView;
            this.f14517f = (ImageView) view.findViewById(R.id.account_icon);
            this.f14518g = (RelativeLayout) view.findViewById(R.id.name_and_icon_layout);
            this.f14520i = (ImageView) view.findViewById(R.id.call);
            this.f14521j = (ImageView) view.findViewById(R.id.sms);
            this.f14522k = (ImageView) view.findViewById(R.id.video_call);
            this.f14523l = (TextView) view.findViewById(R.id.call_text);
            this.f14524m = (TextView) view.findViewById(R.id.sms_text);
            this.f14525n = (TextView) view.findViewById(R.id.video_text);
            this.f14526o = view.findViewById(R.id.detail_header_bottom_layout);
            this.f14527p = view.findViewById(R.id.layout_call);
            this.f14528q = view.findViewById(R.id.layout_sms);
            this.f14529r = view.findViewById(R.id.layout_video);
            if (ContactsApplication.f13094j) {
                textView.setTextDirection(3);
            }
        }
    }

    /* compiled from: ViewAdapter.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final RelativeLayout f14530a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f14531b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f14532c;

        public d(View view) {
            this.f14530a = (RelativeLayout) view.findViewById(R.id.national_anti_fraud_tips);
            this.f14531b = (TextView) view.findViewById(R.id.description);
            this.f14532c = (ImageView) view.findViewById(R.id.warning_icon);
        }
    }

    /* compiled from: ViewAdapter.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f14533a;

        /* renamed from: b, reason: collision with root package name */
        public final ImageView f14534b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f14535c;

        public e(View view) {
            this.f14535c = (ImageView) view.findViewById(R.id.network_divider);
            this.f14533a = (TextView) view.findViewById(R.id.network_title);
            this.f14534b = (ImageView) view.findViewById(R.id.network_icon);
        }
    }

    /* compiled from: ViewAdapter.java */
    /* loaded from: classes.dex */
    public interface f {
        View.OnClickListener C();

        View.OnClickListener I();

        View.OnClickListener M();

        View.OnClickListener O();

        void P(c cVar);

        boolean W();

        String Y0();

        boolean a();

        boolean b();

        boolean c();

        void f0(String str);

        boolean n0();

        boolean o0();

        void r0(c cVar);

        void u0(d dVar);
    }

    public E0(ComponentActivity componentActivity, ArrayList<i0.m> arrayList, View.OnTouchListener onTouchListener, f fVar, AutoCallSummaryTipManager autoCallSummaryTipManager) {
        ArrayList<i0.m> arrayList2 = new ArrayList<>();
        this.f14472e = arrayList2;
        this.f14473f = false;
        this.f14474g = new HashMap<>();
        this.f14478k = -1;
        this.f14480m = null;
        this.f14481n = null;
        this.f14482o = null;
        this.f14483p = null;
        this.f14484q = null;
        this.f14485r = new ConcurrentHashMap<>();
        this.f14468a = componentActivity;
        this.f14469b = (LayoutInflater) componentActivity.getSystemService("layout_inflater");
        this.f14477j = componentActivity.getResources().getInteger(R.integer.product_flavor);
        arrayList2.addAll(arrayList);
        this.f14470c = fVar;
        this.f14471d = onTouchListener;
        A();
        this.f14479l = autoCallSummaryTipManager;
    }

    public final void A() {
        this.f14474g.put("vnd.android.cursor.item/phone_v2", Integer.valueOf(R.drawable.pb_ic_call));
        this.f14474g.put("vnd.android.cursor.item/email_v2", Integer.valueOf(R.drawable.pb_ic_email));
        this.f14474g.put("vnd.android.cursor.item/website", Integer.valueOf(R.drawable.pb_ic_web));
        this.f14474g.put("vnd.android.cursor.item/contact_event", Integer.valueOf(R.drawable.pb_ic_event));
        this.f14474g.put("vnd.android.cursor.item/relation", Integer.valueOf(R.drawable.pb_ic_relation));
        this.f14474g.put("vnd.android.cursor.item/postal-address_v2", Integer.valueOf(R.drawable.pb_ic_address));
        this.f14474g.put("vnd.android.cursor.item/note", Integer.valueOf(R.drawable.pb_ic_note));
        this.f14474g.put("vnd.android.cursor.item/im", Integer.valueOf(R.drawable.pb_ic_im));
        this.f14474g.put("vnd.android.cursor.item/group", Integer.valueOf(R.drawable.pb_ic_group));
        this.f14474g.put("vnd.android.cursor.item/nickname", Integer.valueOf(R.drawable.pb_ic_nickname));
        this.f14474g.put("vnd.android.cursor.item/account", Integer.valueOf(R.drawable.pb_ic_save_location));
        this.f14474g.put("vnd.android.cursor.item/custom_ringtone", Integer.valueOf(R.drawable.pb_ic_ring));
        this.f14474g.put("vnd.android.cursor.item/custom_vibration", Integer.valueOf(R.drawable.pb_ic_vibration));
        this.f14474g.put("vnd.android.cursor.item/business_card_photo", Integer.valueOf(R.drawable.pb_ic_photo));
        this.f14474g.put("vnd.android.cursor.item/first_aid", Integer.valueOf(R.drawable.pb_ic_medical_info));
        this.f14474g.put("vnd.android.cursor.item/emergency_contact", Integer.valueOf(R.drawable.pb_ic_sos_contacts));
        this.f14475h = this.f14474g.keySet();
    }

    public final /* synthetic */ void B(i0.f fVar, b bVar, View view) {
        HashMap<String, Boolean> l10 = C1643c.l(this.f14468a, fVar.f14623m);
        C1643c.C(l10, this.f14468a, bVar.f14508u, bVar.f14497j);
        C1643c.D(l10, this.f14468a, view, bVar.f14510w);
    }

    public final /* synthetic */ void C(final i0.f fVar, final b bVar, final View view, Void r52) {
        ComponentActivity componentActivity = this.f14468a;
        if (componentActivity instanceof Activity) {
            componentActivity.runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.D0
                @Override // java.lang.Runnable
                public final void run() {
                    E0.this.B(fVar, bVar, view);
                }
            });
        }
    }

    public void D(ArrayList<i0.m> arrayList) {
        this.f14472e.clear();
        this.f14472e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void E(boolean z10) {
        this.f14473f = z10;
    }

    public void F(RecordPlayerPresenter recordPlayerPresenter) {
        this.f14476i = recordPlayerPresenter;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    public void c(int i10, View view, final i0.f fVar, int i11) {
        int d10;
        View view2;
        int i12;
        final b bVar = (b) view.getTag();
        if (!TextUtils.isEmpty(fVar.f14617g)) {
            bVar.f14488a.setText(fVar.f14617g);
            bVar.f14488a.setVisibility(0);
        } else {
            bVar.f14488a.setVisibility(8);
        }
        if ("vnd.android.cursor.item/phone_v2".equals(fVar.f14621k)) {
            String str = fVar.f14622l;
            if (ContactsApplication.f13094j) {
                if (!TextUtils.isEmpty(str) && fVar.f14626p) {
                    bVar.f14489b.setText(str + "  |  ");
                    bVar.f14489b.setVisibility(0);
                    bVar.f14505r.setVisibility(0);
                } else if (!TextUtils.isEmpty(str) && !fVar.f14626p) {
                    bVar.f14489b.setText(str + "  |  ");
                    bVar.f14489b.setVisibility(0);
                    bVar.f14505r.setVisibility(8);
                } else if (TextUtils.isEmpty(str) && fVar.f14626p) {
                    bVar.f14489b.setVisibility(8);
                    bVar.f14505r.setVisibility(0);
                } else {
                    bVar.f14489b.setVisibility(8);
                    bVar.f14505r.setVisibility(8);
                }
            } else if (!TextUtils.isEmpty(str) && fVar.f14626p) {
                bVar.f14489b.setText("  |  " + str);
                bVar.f14489b.setVisibility(0);
                bVar.f14505r.setVisibility(0);
            } else if (!TextUtils.isEmpty(str) && !fVar.f14626p) {
                bVar.f14489b.setText("  |  " + str);
                bVar.f14489b.setVisibility(0);
                bVar.f14505r.setVisibility(8);
            } else if (TextUtils.isEmpty(str) && fVar.f14626p) {
                bVar.f14489b.setVisibility(8);
                bVar.f14505r.setVisibility(0);
            } else {
                bVar.f14489b.setVisibility(8);
                bVar.f14505r.setVisibility(8);
            }
            if (C0637b.h()) {
                bVar.f14489b.setVisibility(8);
            }
        } else if ("vnd.android.cursor.item/email_v2".equals(fVar.f14621k)) {
            if (fVar.f14626p) {
                bVar.f14505r.setVisibility(0);
            } else {
                bVar.f14505r.setVisibility(8);
            }
        } else {
            bVar.f14489b.setVisibility(8);
            bVar.f14505r.setVisibility(8);
        }
        if ("vnd.android.cursor.item/custom_vibration".equals(fVar.f14621k)) {
            bVar.f14492e.setText(fVar.f14618h);
            bVar.f14491d.setText(R.string.incoming_call_vibration_title);
            bVar.f14491d.setVisibility(0);
        } else if ("vnd.android.cursor.item/custom_ringtone".equals(fVar.f14621k)) {
            bVar.f14492e.setText(fVar.f14618h);
            TextView textView = bVar.f14492e;
            if (fVar.f14614G) {
                d10 = this.f14468a.getColor(R.color.coui_preference_title_color);
            } else {
                d10 = com.android.contacts.framework.baseui.util.r.d(this.f14468a);
            }
            textView.setTextColor(d10);
            bVar.f14491d.setText(R.string.oplus_incoming_ring);
            bVar.f14491d.setVisibility(0);
        } else {
            if (C0637b.h()) {
                if ("vnd.android.cursor.item/phone_v2".equals(fVar.f14621k)) {
                    bVar.f14492e.setText(C0637b.d(fVar.f14618h));
                } else {
                    bVar.f14492e.setText(fVar.f14618h);
                }
            } else {
                bVar.f14492e.setText(fVar.f14618h);
            }
            bVar.f14491d.setVisibility(8);
        }
        if (ContactsApplication.f13094j && !"vnd.android.cursor.item/first_aid".equals(fVar.f14621k)) {
            bVar.f14492e.setLayoutDirection(0);
        }
        if (!TextUtils.isEmpty(fVar.f14608A)) {
            bVar.f14495h.setText(fVar.f14608A);
            bVar.f14495h.setVisibility(0);
        } else {
            bVar.f14495h.setVisibility(8);
        }
        bVar.f14502o.setVisibility(8);
        if (bVar.f14493f != null) {
            String a10 = C1073b.a(fVar.f14623m);
            if (!this.f14470c.W() && fVar.f14623m != null && a10.equals(this.f14470c.Y0())) {
                bVar.f14493f.setVisibility(0);
                this.f14470c.f0(fVar.f14623m);
            } else {
                bVar.f14493f.setVisibility(8);
            }
        }
        if (B3.a.d0() && bVar.f14494g != null && this.f14470c.o0() && com.android.contacts.framework.api.rcs.a.e()) {
            if (H7.a.b()) {
                H7.b.b("ContactDetail", "RcsManager isLogin");
            }
            if (com.android.contacts.framework.api.rcs.a.c(fVar.f14618h)) {
                bVar.f14494g.setVisibility(0);
            } else {
                bVar.f14494g.setVisibility(8);
            }
            com.android.contacts.framework.api.rcs.a.f(fVar.f14618h, new a(bVar), true);
        }
        if (!"vnd.android.cursor.item/custom_blacklist".equals(fVar.f14621k) && !"vnd.android.cursor.item/custom_ringtone".equals(fVar.f14621k) && !"vnd.android.cursor.item/custom_vibration".equals(fVar.f14621k) && !"vnd.android.cursor.item/custom_send_contact".equals(fVar.f14621k) && !"vnd.android.cursor.item/vip_group".equals(fVar.f14621k) && !"vnd.android.cursor.item/view_calllogs".equals(fVar.f14621k)) {
            TextView textView2 = bVar.f14492e;
            textView2.setTypeface(textView2.getTypeface(), 0);
        }
        Drawable a11 = C0656n.a(this.f14468a, fVar.f14634x);
        ImageView imageView = bVar.f14496i;
        if (a11 != null) {
            imageView.setImageDrawable(a11);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = bVar.f14490c;
        int i13 = fVar.f14635y;
        if (i13 != -1) {
            imageView2.setImageResource(i13);
            imageView2.setImportantForAccessibility(2);
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        ActionsViewContainer actionsViewContainer = (ActionsViewContainer) bVar.f14498k;
        actionsViewContainer.setTag(fVar);
        actionsViewContainer.setPosition(i10);
        if (!"vnd.android.cursor.item/custom_ringtone".equals(fVar.f14621k) && !"vnd.android.cursor.item/custom_vibration".equals(fVar.f14621k) && !"vnd.android.cursor.item/view_calllogs".equals(fVar.f14621k) && !"vnd.android.cursor.item/business_card_photo".equals(fVar.f14621k) && !"vnd.android.cursor.item/emergency_contact".equals(fVar.f14621k) && !"vnd.android.cursor.item/first_aid".equals(fVar.f14621k)) {
            actionsViewContainer.setOnTouchListener(this.f14471d);
        } else {
            actionsViewContainer.setOnTouchListener(null);
        }
        View view3 = bVar.f14501n;
        final View view4 = bVar.f14507t;
        if (C1643c.w() && fVar.f14623m != null) {
            if (view3 != null) {
                view3.setVisibility(0);
            }
            w0.j jVar = new w0.j() { // from class: com.android.contacts.detail.C0
                @Override // w0.j
                public final void a(Object obj) {
                    E0.this.C(fVar, bVar, view4, (Void) obj);
                }
            };
            jVar.a(null);
            C1643c.B(this.f14468a, fVar.f14623m, jVar);
            Intent intent = fVar.f14630t;
            if (intent != null && view3 != null && intent.getBooleanExtra("sms", false)) {
                view3.setTag(fVar);
            }
            if (view4 != null) {
                view4.setTag(fVar);
            }
        }
        if (("vnd.android.cursor.item/custom_blacklist".equals(fVar.f14621k) || "vnd.android.cursor.item/custom_delete_contact".equals(fVar.f14621k) || "vnd.android.cursor.item/custom_send_contact".equals(fVar.f14621k) || "vnd.android.cursor.item/vip_group".equals(fVar.f14621k) || "vnd.android.cursor.item/view_calllogs".equals(fVar.f14621k)) && (view2 = bVar.f14500m) != null) {
            view2.setPadding(0, this.f14468a.getResources().getDimensionPixelOffset(R.dimen.padding_top), 0, this.f14468a.getResources().getDimensionPixelOffset(R.dimen.padding_bottom));
        }
        if (bVar.f14496i.getVisibility() != 0 && bVar.f14488a.getVisibility() != 0 && bVar.f14489b.getVisibility() != 0 && bVar.f14502o.getVisibility() != 0) {
            bVar.f14503p.setVisibility(8);
        }
        if (this.f14475h.contains(fVar.f14621k)) {
            if (i10 > 0) {
                i0.m mVar = this.f14472e.get(i10 - 1);
                if (mVar instanceof i0.f) {
                    i0.f fVar2 = (i0.f) mVar;
                    Drawable z10 = z(fVar.f14621k);
                    if (z10 == null) {
                        bVar.f14504q.setImageResource(this.f14474g.get(fVar.f14621k).intValue());
                    } else {
                        bVar.f14504q.setImageDrawable(z10);
                    }
                    if (fVar2.f14621k.equals(fVar.f14621k)) {
                        bVar.f14504q.setVisibility(4);
                    } else {
                        bVar.f14504q.setVisibility(0);
                    }
                    i12 = 0;
                } else {
                    Drawable z11 = z(fVar.f14621k);
                    if (z11 == null) {
                        bVar.f14504q.setImageResource(this.f14474g.get(fVar.f14621k).intValue());
                    } else {
                        bVar.f14504q.setImageDrawable(z11);
                    }
                    i12 = 0;
                    bVar.f14504q.setVisibility(0);
                }
            } else {
                i12 = 0;
                bVar.f14504q.setVisibility(0);
            }
        } else {
            i12 = 0;
            bVar.f14504q.setVisibility(0);
        }
        if (!"vnd.android.cursor.item/first_aid".equals(fVar.f14621k) && !"vnd.android.cursor.item/emergency_contact".equals(fVar.f14621k)) {
            bVar.f14506s.setMinimumHeight(i12);
        } else {
            if (this.f14478k == -1) {
                this.f14478k = this.f14468a.getResources().getDimensionPixelSize(R.dimen.DP_30);
            }
            bVar.f14506s.setMinimumHeight(this.f14478k);
        }
        if (i11 != 1 && i11 != 2) {
            bVar.f14511x.setVisibility(8);
        } else {
            bVar.f14511x.setVisibility(0);
        }
    }

    public void d(int i10) {
        if (i10 > 0) {
            this.f14483p = this.f14469b.inflate(R.layout.more_call_log_view, (ViewGroup) null, false);
        }
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(this.f14469b.inflate(R.layout.detail_call_history_item, (ViewGroup) null, false));
        }
        this.f14480m = arrayList;
    }

    public void e(ContactLoader.Result result) {
        int min;
        Integer num;
        Drawable drawable;
        Integer num2;
        Drawable drawable2;
        this.f14484q = this.f14469b.inflate(R.layout.detail_header_contact_without_updates, (ViewGroup) null, false);
        if (!TextUtils.isEmpty(result.u()) && !this.f14485r.containsKey("vnd.android.cursor.item/custom_ringtone") && (num2 = this.f14474g.get("vnd.android.cursor.item/custom_ringtone")) != null && (drawable2 = this.f14468a.getDrawable(num2.intValue())) != null) {
            this.f14485r.put("vnd.android.cursor.item/custom_ringtone", drawable2);
        }
        Iterator<Entity> it = result.D().iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            Iterator<Entity.NamedContentValues> it2 = it.next().getSubValues().iterator();
            while (it2.hasNext()) {
                ContentValues contentValues = it2.next().values;
                String asString = contentValues.getAsString("mimetype");
                if (asString != null) {
                    if (!this.f14485r.containsKey(asString)) {
                        Integer num3 = this.f14474g.get(asString);
                        if (num3 != null) {
                            Drawable drawable3 = this.f14468a.getDrawable(num3.intValue());
                            if (drawable3 != null) {
                                this.f14485r.put(asString, drawable3);
                            }
                        } else if ("vnd.android.cursor.item/group_membership".equals(asString) && (num = this.f14474g.get("vnd.android.cursor.item/group")) != null && (drawable = this.f14468a.getDrawable(num.intValue())) != null) {
                            this.f14485r.put("vnd.android.cursor.item/group_membership", drawable);
                            this.f14485r.put("vnd.android.cursor.item/group", drawable);
                        }
                    }
                    if ("vnd.android.cursor.item/phone_v2".equals(asString)) {
                        if (!TextUtils.isEmpty(contentValues.getAsString("data1"))) {
                            i10++;
                        }
                    } else {
                        i11++;
                    }
                }
            }
        }
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i12 = 0; i12 < i10; i12++) {
            arrayList.add(this.f14469b.inflate(R.layout.contact_detail_list_item_phone, (ViewGroup) null, false));
        }
        this.f14481n = arrayList;
        if (CommonFeatureOption.m()) {
            min = Math.min(10, i11);
        } else {
            min = Math.min(6, i11);
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        for (int i13 = 0; i13 < min; i13++) {
            arrayList2.add(this.f14469b.inflate(R.layout.contact_detail_list_item_note, (ViewGroup) null, false));
        }
        this.f14482o = arrayList2;
    }

    public final View f(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f14469b.inflate(R.layout.list_blank_separator, viewGroup, false);
        }
        return view;
    }

    public final View g() {
        ArrayList<View> arrayList = this.f14480m;
        if (arrayList != null && !arrayList.isEmpty()) {
            return arrayList.remove(0);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14472e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        i0.m mVar = this.f14472e.get(i10);
        if (mVar != null) {
            return mVar.d();
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return this.f14472e.get(i10).e();
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i10)) {
            case 0:
                return o(i10, view, viewGroup);
            case 1:
                return r(view, viewGroup);
            case 2:
                return t(i10, view, viewGroup);
            case 3:
                return w(i10, view, viewGroup);
            case 4:
                return q(i10, view, viewGroup);
            case 5:
            default:
                throw new IllegalStateException("Invalid view type ID " + getItemViewType(i10));
            case 6:
                return l(i10, view, viewGroup);
            case 7:
                return u(i10, view, viewGroup);
            case 8:
                return f(i10, view, viewGroup);
            case 9:
                return n(i10, view, viewGroup);
            case 10:
                return v(view, viewGroup);
            case 11:
                View tipView = this.f14479l.getTipView(view, viewGroup);
                if (tipView != null) {
                    return tipView;
                }
                H7.b.i("ViewAdapter", "Should not reach here! (summary tip view null)");
                return f(i10, view, viewGroup);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 12;
    }

    public final View h() {
        ArrayList<View> arrayList = this.f14482o;
        if (arrayList != null && !arrayList.isEmpty()) {
            return arrayList.remove(0);
        }
        return null;
    }

    public final View i() {
        View view = this.f14484q;
        this.f14484q = null;
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return getItem(i10).f();
    }

    public final View j() {
        View view = this.f14483p;
        this.f14483p = null;
        return view;
    }

    public final View k() {
        ArrayList<View> arrayList = this.f14481n;
        if (arrayList != null && !arrayList.isEmpty()) {
            return arrayList.remove(0);
        }
        return null;
    }

    public final View l(int i10, View view, ViewGroup viewGroup) {
        i0.d dVar = (i0.d) getItem(i10);
        if (view == null || ((j.f) view.getTag()).f585b != R.layout.detail_call_history_item) {
            view = null;
        }
        if (view == null) {
            view = g();
            if (view == null) {
                view = this.f14469b.inflate(R.layout.detail_call_history_item, viewGroup, false);
            }
            view.setTag(new j.f(view, R.layout.detail_call_history_item, i10));
        }
        E3.j jVar = new E3.j(this.f14468a);
        jVar.A(this.f14476i);
        int m10 = m(6, y(i10), x(i10));
        jVar.w(view, false, true, dVar.f14607f, this.f14470c.n0(), false, m10);
        COUICardListHelper.setItemCardBackground(view, m10);
        return view;
    }

    public final int m(int i10, i0.m mVar, i0.m mVar2) {
        int e10;
        int i11 = -1;
        if (mVar == null) {
            e10 = -1;
        } else {
            e10 = mVar.e();
        }
        if (mVar2 != null) {
            i11 = mVar2.e();
        }
        if (i10 == 4) {
            i10 = 0;
        }
        if (e10 == 4) {
            e10 = 0;
        }
        if (i11 == 4) {
            i11 = 0;
        }
        if (e10 != i10) {
            if (i11 != i10) {
                return 4;
            }
            return 1;
        }
        if (i11 != i10) {
            return 3;
        }
        return 2;
    }

    public final View n(int i10, View view, ViewGroup viewGroup) {
        i0.c cVar = (i0.c) getItem(i10);
        if (view == null) {
            view = this.f14469b.inflate(R.layout.call_detail_history_sim_seprator, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.sim_icon);
        TextView textView = (TextView) view.findViewById(R.id.sim_name);
        int i11 = cVar.f14604e;
        if (i11 == 0) {
            imageView.setImageResource(R.drawable.pb_ic_call_log_sim1);
            imageView.setVisibility(0);
            textView.setText(cVar.f14605f + ":");
        } else if (i11 == 1) {
            imageView.setImageResource(R.drawable.pb_ic_call_log_sim2);
            imageView.setVisibility(0);
            textView.setText(cVar.f14605f + ":");
        } else {
            imageView.setVisibility(8);
            textView.setText(this.f14468a.getString(R.string.local_invisible_directory) + ":");
        }
        view.setBackground(this.f14468a.getDrawable(R.drawable.coui_preference_bg_selector));
        return view;
    }

    public final View o(int i10, View view, ViewGroup viewGroup) {
        i0.f fVar = (i0.f) getItem(i10);
        if (view == null && (view = h()) == null) {
            view = this.f14469b.inflate(R.layout.contact_detail_list_item_note, viewGroup, false);
        }
        p(view, i10, fVar);
        return view;
    }

    public final void p(View view, int i10, i0.f fVar) {
        view.setTag(new b(view, this.f14470c.C(), this.f14470c.I(), this.f14470c.M()));
        int m10 = m(0, y(i10), x(i10));
        c(i10, view, fVar, m10);
        COUICardListHelper.setItemCardBackground(view, m10);
    }

    public final View q(int i10, View view, ViewGroup viewGroup) {
        i0.f fVar = (i0.f) getItem(i10);
        if (view == null && (view = k()) == null) {
            view = this.f14469b.inflate(R.layout.contact_detail_list_item_phone, viewGroup, false);
        }
        p(view, i10, fVar);
        return view;
    }

    public View r(View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null) {
            c cVar2 = (c) view.getTag();
            if (cVar2 == null || cVar2.f14519h != R.layout.detail_header_contact_without_updates) {
                view = null;
            }
            cVar = cVar2;
        } else {
            view = null;
        }
        boolean z10 = false;
        if (view == null) {
            view = i();
            if (view == null) {
                view = this.f14469b.inflate(R.layout.detail_header_contact_without_updates, viewGroup, false);
            }
            cVar = new c(view, R.layout.detail_header_contact_without_updates);
            view.setTag(cVar);
            view.findViewById(R.id.detail_photo).setOnClickListener(this.f14470c.O());
            cVar.f14527p.setOnClickListener(this.f14470c.O());
            cVar.f14528q.setOnClickListener(this.f14470c.O());
            cVar.f14529r.setOnClickListener(this.f14470c.O());
            cVar.f14527p.setContentDescription(this.f14468a.getString(R.string.make_dial));
            cVar.f14528q.setContentDescription(this.f14468a.getString(R.string.sms));
            cVar.f14529r.setContentDescription(this.f14468a.getString(R.string.video_call));
        }
        this.f14470c.P(cVar);
        this.f14470c.r0(cVar);
        cVar.f14527p.setEnabled(this.f14473f);
        cVar.f14523l.setEnabled(this.f14473f);
        cVar.f14520i.setEnabled(this.f14473f);
        cVar.f14528q.setEnabled(this.f14473f);
        cVar.f14524m.setEnabled(this.f14473f);
        cVar.f14521j.setEnabled(this.f14473f);
        if (PrimaryUserUtils.a() && !VirtualSupportUtils.m()) {
            cVar.f14529r.setVisibility(0);
            if (this.f14473f && this.f14470c.c() && this.f14470c.a()) {
                z10 = true;
            }
            cVar.f14529r.setEnabled(z10);
            cVar.f14525n.setEnabled(z10);
            cVar.f14522k.setEnabled(z10);
            if (B3.a.N(this.f14477j) && !cVar.f14522k.isEnabled()) {
                cVar.f14529r.setVisibility(8);
            }
        } else {
            cVar.f14529r.setVisibility(8);
        }
        if (this.f14470c.b()) {
            cVar.f14520i.setImageResource(R.drawable.pb_dr_detail_wifi_call);
            cVar.f14522k.setImageResource(R.drawable.pb_dr_video_wifi_call);
        } else {
            cVar.f14520i.setImageResource(R.drawable.pb_dr_detail_call);
            cVar.f14522k.setImageResource(R.drawable.pb_dr_video_call);
        }
        if (!CommonFeatureOption.j()) {
            cVar.f14526o.setVisibility(8);
        }
        return view;
    }

    @Override // android.widget.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public i0.m getItem(int i10) {
        if (i10 >= this.f14472e.size()) {
            return new i0.f();
        }
        return this.f14472e.get(i10);
    }

    public final View t(int i10, View view, ViewGroup viewGroup) {
        i0.h hVar = (i0.h) getItem(i10);
        if (view == null) {
            view = this.f14469b.inflate(R.layout.list_separator, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        View findViewById = view.findViewById(R.id.title_count);
        if (hVar.g() == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            textView.setText(hVar.g());
        }
        return view;
    }

    public final View u(int i10, View view, ViewGroup viewGroup) {
        i0.i iVar = (i0.i) getItem(i10);
        if (view == null) {
            view = j();
            if (view == null) {
                view = this.f14469b.inflate(R.layout.more_call_log_view, viewGroup, false);
            }
            COUITextViewCompatUtil.setPressRippleDrawable((TextView) view.findViewById(R.id.more_call_log));
        }
        ((TextView) view.findViewById(R.id.title)).setText(iVar.h());
        view.findViewById(R.id.more_call_log).setOnClickListener(iVar.g());
        return view;
    }

    public final View v(View view, ViewGroup viewGroup) {
        d dVar;
        if (view != null) {
            dVar = (d) view.getTag();
        } else {
            view = this.f14469b.inflate(R.layout.detail_header_national_anti_fraud_tips_layout, viewGroup, false);
            dVar = new d(view);
            view.setTag(dVar);
        }
        this.f14470c.u0(dVar);
        return view;
    }

    public final View w(int i10, View view, ViewGroup viewGroup) {
        e eVar;
        i0.k kVar = (i0.k) getItem(i10);
        if (view != null) {
            eVar = (e) view.getTag();
        } else {
            view = this.f14469b.inflate(R.layout.contact_detail_network_title_entry_view, viewGroup, false);
            eVar = new e(view);
            view.setTag(eVar);
            view.findViewById(R.id.primary_action_view).setOnClickListener(kVar.j());
        }
        eVar.f14533a.setText(kVar.i());
        eVar.f14534b.setImageDrawable(kVar.h());
        if (kVar.f14644b) {
            eVar.f14533a.setTextAppearance(this.f14468a, R.style.FocusTitleStyle);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.height = this.f14468a.getResources().getDimensionPixelOffset(R.dimen.coui_list_item_normal_height);
            view.setBackground(this.f14468a.getDrawable(R.drawable.coui_preference_bg_selector));
            view.setLayoutParams(layoutParams);
        } else {
            eVar.f14533a.setTextAppearance(R.style.LargeTextStyle);
        }
        eVar.f14533a.setTextSize(0, this.f14468a.getResources().getDimensionPixelSize(R.dimen.DP_12));
        eVar.f14535c.setVisibility(8);
        return view;
    }

    public final i0.m x(int i10) {
        int i11 = i10 + 1;
        if (i11 >= 0 && i11 < this.f14472e.size()) {
            return this.f14472e.get(i11);
        }
        return null;
    }

    public final i0.m y(int i10) {
        int i11 = i10 - 1;
        if (i11 >= 0 && i11 < this.f14472e.size()) {
            return this.f14472e.get(i11);
        }
        return null;
    }

    public final Drawable z(String str) {
        return this.f14485r.get(str);
    }
}
