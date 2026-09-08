package m1;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CheckBox;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.list.ContactListItemView;
import com.android.contacts.model.Account;
import com.android.contacts.util.C0700a;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.C0806q;
import com.customize.contacts.util.M;
import com.oplus.dialer.R;
import h1.C1074c;
import java.util.ArrayList;

/* compiled from: DefaultContactListAdapter.java */
/* renamed from: m1.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1304B extends AbstractC1315k {

    /* renamed from: Y, reason: collision with root package name */
    public Context f34800Y;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f34801Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f34802a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f34803b0;

    /* renamed from: c0, reason: collision with root package name */
    public Account f34804c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f34805d0;

    /* renamed from: e0, reason: collision with root package name */
    public Intent f34806e0;

    /* renamed from: f0, reason: collision with root package name */
    public P3.c f34807f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f34808g0;

    /* renamed from: h0, reason: collision with root package name */
    public long f34809h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f34810i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f34811j0;

    /* renamed from: k0, reason: collision with root package name */
    public ArrayList<Account> f34812k0;

    /* renamed from: l0, reason: collision with root package name */
    public M.d f34813l0;

    /* renamed from: m0, reason: collision with root package name */
    public d f34814m0;

    /* compiled from: DefaultContactListAdapter.java */
    /* renamed from: m1.B$c */
    /* loaded from: classes.dex */
    public class c implements M.e {
        public c() {
        }

        @Override // com.customize.contacts.util.M.e
        public void onClick(View view) {
            C1304B.this.f34813l0.G0(view, ((Integer) view.getTag(R.id.contacts_list_item_position)).intValue(), ((Integer) view.getTag(R.id.contacts_list_item_partition)).intValue());
        }

        @Override // com.customize.contacts.util.M.e
        public void onLongClick(View view, int i10, int i11) {
            if (C7.a.a()) {
                return;
            }
            C1304B.this.f34813l0.c0(view, ((Integer) view.getTag(R.id.contacts_list_item_position)).intValue(), ((Integer) view.getTag(R.id.contacts_list_item_partition)).intValue(), i10, i11);
        }

        @Override // com.customize.contacts.util.M.e
        public boolean onTouch(View view, MotionEvent motionEvent) {
            C1304B.this.f34813l0.V0(view, motionEvent);
            return false;
        }
    }

    /* compiled from: DefaultContactListAdapter.java */
    /* renamed from: m1.B$d */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(Uri uri);
    }

    public C1304B(Context context) {
        super(context);
        this.f34801Z = false;
        this.f34802a0 = false;
        this.f34803b0 = false;
        this.f34804c0 = null;
        this.f34805d0 = false;
        this.f34806e0 = null;
        this.f34808g0 = false;
        this.f34809h0 = 0L;
        this.f34810i0 = null;
        this.f34812k0 = null;
        this.f34813l0 = null;
        this.f34814m0 = null;
        this.f34800Y = context;
    }

    public void A1(Intent intent) {
        this.f34806e0 = intent;
    }

    public void B1(ArrayList<Account> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f34812k0 = arrayList;
        }
    }

    @Override // m1.AbstractC1311g
    public void V(W.b bVar, long j10) {
        ContactListFilter contactListFilter;
        String str;
        boolean z10;
        String str2;
        boolean z11;
        long l12 = l1();
        if (l12 <= 0) {
            contactListFilter = c0();
        } else {
            contactListFilter = null;
        }
        ContactListFilter contactListFilter2 = contactListFilter;
        boolean z12 = false;
        if (bVar instanceof T) {
            T t10 = (T) bVar;
            t10.a0(false);
            if (!n0() && l12 <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            t10.Z(z11);
        }
        if (n0()) {
            String d10 = PhoneNumberUtils.d(h0(), C1074c.b(this.f34800Y));
            if (d10 == null) {
                d10 = "";
            }
            String trim = d10.trim();
            if (TextUtils.isEmpty(trim)) {
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                if (l12 > 0) {
                    Uri.Builder buildUpon = uri.buildUpon();
                    buildUpon.appendQueryParameter("group_id", String.valueOf(l12));
                    uri = buildUpon.build();
                }
                bVar.T(m1(uri));
                bVar.P(V0(false));
                bVar.Q(n1(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE));
            } else {
                Uri.Builder buildUpon2 = ContactsContract.Contacts.CONTENT_FILTER_URI.buildUpon();
                buildUpon2.appendPath(trim);
                buildUpon2.appendQueryParameter("directory", String.valueOf(j10));
                if (j10 != 0 && j10 != 1) {
                    buildUpon2.appendQueryParameter("limit", String.valueOf(b0()));
                }
                buildUpon2.appendQueryParameter("snippet_args", "\u0001,\u0001,…,5");
                String str3 = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
                buildUpon2.appendQueryParameter("deferred_snippeting", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                buildUpon2.appendQueryParameter("QUERY_ALL_DATA", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                if (Y() == 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                buildUpon2.appendQueryParameter("is_display_alt", String.valueOf(z10));
                bVar.P(V0(true));
                if (contactListFilter2 != null && this.f34806e0 == null) {
                    z12 = contactListFilter2.f16744h;
                    int i10 = contactListFilter2.f16738b;
                    if (i10 != -3) {
                        if (i10 != -2) {
                            if (i10 == 0 && (str2 = contactListFilter2.f16740d) != null && contactListFilter2.f16739c != null) {
                                buildUpon2.appendQueryParameter("account_name", str2);
                                buildUpon2.appendQueryParameter("account_type", contactListFilter2.f16739c);
                            }
                        } else {
                            Account account = this.f34804c0;
                            if (account != null && !TextUtils.equals(R0.a.f3166b, account.f16942b)) {
                                buildUpon2.appendQueryParameter("account_name", this.f34804c0.f16941a);
                                buildUpon2.appendQueryParameter("account_type", this.f34804c0.f16942b);
                            }
                        }
                    } else {
                        buildUpon2.appendQueryParameter("in_visible_group", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                        str3 = "in_visible_group=1";
                    }
                }
                if (z12 || this.f34808g0) {
                    str3 = str3 + " AND has_phone_number=1";
                }
                if (l12 > 0) {
                    buildUpon2.appendQueryParameter("group_id", String.valueOf(l12));
                }
                if (contactListFilter2 != null && contactListFilter2.f16745i) {
                    if (R0.a.f3166b == null) {
                        str3 = str3 + " AND (account_type <> 'com.android.oplus.sim' OR account_type IS NULL)";
                    } else {
                        str3 = str3 + " AND account_type <> 'com.android.oplus.sim'";
                    }
                }
                String n12 = n1(str3);
                bVar.T(m1(buildUpon2.build()));
                bVar.Q(n12);
            }
        } else {
            k1(bVar, j10, contactListFilter2, l12);
            bVar.P(V0(false));
            j1(bVar, j10, contactListFilter2);
        }
        if (i0() == 1) {
            str = "sort_key";
        } else {
            str = "sort_key_alt";
        }
        bVar.S(str);
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        char[] cArr;
        boolean z10;
        ContactListItemView contactListItemView = (ContactListItemView) view;
        d dVar = this.f34814m0;
        if (dVar != null) {
            if (dVar.a(T0(i10, cursor))) {
                contactListItemView.setBackgroundColor(com.android.contacts.framework.baseui.util.r.b(this.f472i));
            } else {
                Object tag = contactListItemView.getTag(R.id.list_item_long_clicked);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    com.android.contacts.framework.baseui.util.E.a(contactListItemView);
                } else {
                    contactListItemView.setBackgroundResource(R.drawable.select_list_item_background_seletor);
                }
            }
        }
        if (n0()) {
            cArr = j0();
        } else {
            cArr = null;
        }
        contactListItemView.setHighlightedPrefix(cArr);
        if (o0()) {
            contactListItemView.setActivated(b1(i10, cursor));
        }
        N0(contactListItemView, i11, cursor);
        K0(contactListItemView, i10, cursor);
        J0(contactListItemView, cursor);
        if (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) {
            i1(contactListItemView, cursor);
        }
        g1(contactListItemView, cursor);
        h1(contactListItemView, cursor);
        L0(contactListItemView, cursor);
        boolean z11 = false;
        long j10 = cursor.getLong(0);
        IdRecord idRecord = (IdRecord) contactListItemView.getTag();
        if (idRecord == null) {
            idRecord = new IdRecord(j10);
            contactListItemView.setTag(idRecord);
        } else {
            idRecord.m(j10);
        }
        if (this.f34801Z) {
            CheckBox checkView = contactListItemView.getCheckView();
            checkView.setTag(idRecord);
            if (this.f34802a0) {
                checkView.setVisibility(0);
                P3.c cVar = this.f34807f0;
                if ((cVar.f2890b && !cVar.f(j10)) || this.f34807f0.e(j10)) {
                    z11 = true;
                }
                checkView.setChecked(z11);
            } else {
                checkView.setVisibility(4);
            }
            contactListItemView.setChecked(checkView.isChecked());
        } else if (o1()) {
            CheckBox checkView2 = contactListItemView.getCheckView();
            if (this.f34992T) {
                AnimationAnimationListenerC0813y.i(this.f472i, null, 0).u(false, new a(contactListItemView), contactListItemView.getCheckView());
            } else {
                checkView2.clearAnimation();
                checkView2.setVisibility(0);
            }
            if ((this.f34990R.f().f2890b && !this.f34990R.f().f(j10)) || this.f34990R.f().e(j10)) {
                z10 = true;
            } else {
                z10 = false;
            }
            contactListItemView.getCheckView().setChecked(z10);
            contactListItemView.setChecked(z10);
            checkView2.setTag(idRecord);
            checkView2.setVisibility(0);
        } else {
            if (contactListItemView.getCheckView().getVisibility() == 0 && this.f34992T) {
                AnimationAnimationListenerC0813y.n(this.f472i, null, 8).u(false, new b(contactListItemView), contactListItemView.getCheckView());
            } else {
                contactListItemView.getCheckView().clearAnimation();
                contactListItemView.f(8, false);
            }
            contactListItemView.getCheckView().setChecked(false);
            contactListItemView.setChecked(false);
        }
        long b10 = ((D) q(i10)).b();
        if (n0()) {
            M0(contactListItemView, cursor, j10, b10);
        } else {
            contactListItemView.setSnippet(null);
        }
        if (this.f34813l0 != null) {
            contactListItemView.setTag(R.id.contacts_list_item_position, Integer.valueOf(cursor.getPosition()));
            contactListItemView.setTag(R.id.contacts_list_item_partition, Integer.valueOf(i10));
            com.customize.contacts.util.M.d(contactListItemView, o1(), new c());
        }
        r0(contactListItemView, !cursor.isLast());
    }

    public void g1(ContactListItemView contactListItemView, Cursor cursor) {
        if (cursor == null) {
            return;
        }
        contactListItemView.setAccountIcon(C0700a.b(cursor.getString(6)));
    }

    public boolean h1(ContactListItemView contactListItemView, Cursor cursor) {
        if (cursor == null) {
            H7.b.b("DefaultContactAdapter", "when bind company ,the cursor is null, just return");
            return false;
        }
        if (TextUtils.equals(cursor.getString(9), "com.android.oplus.sim") && FeatureOption.k()) {
            String h10 = com.customize.contacts.simcontacts.b.h(this.f472i, cursor.getString(cursor.getColumnIndex("account_name")));
            if (TextUtils.isEmpty(h10)) {
                H7.b.b("DefaultContactAdapter", "the label is empty ,return");
                contactListItemView.setPhoneNumber("");
                return false;
            }
            contactListItemView.setPhoneNumber(h10);
            return true;
        }
        if (!n0() && this.f34811j0) {
            contactListItemView.setPhoneNumber(cursor.getString(11));
            return !TextUtils.isEmpty(r5);
        }
        contactListItemView.setPhoneNumber("");
        return false;
    }

    public void i1(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.setRCSState(cursor.getString((n0() ? 1 : 0) + 12));
    }

    public void j1(W.b bVar, long j10, ContactListFilter contactListFilter) {
        if (contactListFilter == null || j10 != 0) {
            return;
        }
        boolean z10 = contactListFilter.f16744h;
        boolean z11 = contactListFilter.f16745i;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int i10 = contactListFilter.f16738b;
        if (i10 != -6) {
            if (i10 != -5) {
                if (i10 != -4) {
                    if (i10 != -3) {
                        if (i10 != -2) {
                            if (i10 == 0) {
                                if (contactListFilter.f16740d == null && contactListFilter.f16739c == null) {
                                    sb.append("_id IN (SELECT contact_id FROM raw_contacts WHERE account_id IN (SELECT _id FROM accounts WHERE account_name IS NULL AND account_type IS NULL))");
                                } else {
                                    sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                                }
                                if (z10 || this.f34808g0) {
                                    sb.append(" AND has_phone_number=1");
                                }
                            }
                        } else {
                            sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
                            if (z10 || this.f34808g0) {
                                sb.append(" AND has_phone_number=1");
                            }
                            if (z11) {
                                if (R0.a.f3166b == null) {
                                    sb.append(" AND (account_type <> 'com.android.oplus.sim' OR ");
                                    sb.append("account_type IS NULL)");
                                } else {
                                    sb.append(" AND account_type <> 'com.android.oplus.sim'");
                                }
                            }
                        }
                    } else {
                        sb.append("in_visible_group=1");
                        if (H7.a.b()) {
                            H7.b.e("DefaultContactAdapter", "showHasPhones = " + z10);
                        }
                        if (z10 || this.f34808g0) {
                            sb.append(" AND has_phone_number=1");
                        }
                    }
                } else {
                    sb.append("starred!=0");
                }
            } else {
                sb.append("has_phone_number=1");
            }
        } else {
            sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        }
        if ((bVar instanceof T) && ((T) bVar).V() && sb.length() > 0) {
            sb.append(" AND starred=0");
        }
        bVar.Q(n1(sb.toString()));
        bVar.R((String[]) arrayList.toArray(new String[0]));
    }

    public void k1(W.b bVar, long j10, ContactListFilter contactListFilter, long j11) {
        int i10;
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        if (contactListFilter != null && contactListFilter.f16738b == -6) {
            String Y02 = Y0();
            uri = Y02 != null ? Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, Y02) : ContentUris.withAppendedId(uri, X0());
        }
        if (j10 == 0 && M()) {
            uri = AbstractC1315k.O0(uri);
        }
        if (contactListFilter != null && (i10 = contactListFilter.f16738b) != -3 && i10 != -6) {
            Uri.Builder buildUpon = uri.buildUpon();
            buildUpon.appendQueryParameter("directory", String.valueOf(0L));
            if (contactListFilter.f16738b == 0 && this.f34806e0 == null) {
                contactListFilter.b(buildUpon);
            }
            uri = buildUpon.build();
        }
        if (j11 > 0) {
            Uri.Builder buildUpon2 = uri.buildUpon();
            buildUpon2.appendQueryParameter("group_id", String.valueOf(j11));
            uri = buildUpon2.build();
        }
        bVar.T(m1(uri));
    }

    public final long l1() {
        return this.f34809h0;
    }

    public String n1(String str) {
        if (TextUtils.isEmpty(str.trim())) {
            str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        }
        if (!TextUtils.isEmpty(this.f34810i0)) {
            str = str + " AND " + this.f34810i0;
        }
        Account account = this.f34804c0;
        if (account != null) {
            String str2 = R0.a.f3166b;
            if (TextUtils.equals(str2, account.f16942b)) {
                if (str2 == null) {
                    return str + " AND (_id IN (SELECT contact_id FROM raw_contacts WHERE account_id IN (SELECT _id FROM accounts WHERE (account_type is NULL))))";
                }
                return str + " AND (_id IN (SELECT contact_id FROM raw_contacts WHERE account_id IN (SELECT _id FROM accounts WHERE (account_type='" + str2 + "'))))";
            }
            return str + " AND (_id IN (SELECT contact_id FROM raw_contacts WHERE account_id=(SELECT _id FROM accounts WHERE (account_name='" + this.f34804c0.f16941a + "' AND account_type='" + this.f34804c0.f16942b + "'))))";
        }
        Intent intent = this.f34806e0;
        if (intent != null) {
            if (intent.getAction() == "com.oplus.contacts.ui.LIST_RELATION_CONTACTS") {
                String str3 = R0.a.f3166b;
                if (str3 == null) {
                    str = "account_type IS NULL AND account_name IS NULL  AND ( " + str + ")";
                } else {
                    str = "account_type='" + str3 + "' AND account_name='" + R0.a.f3165a + "'  AND ( " + str + ")";
                }
            }
            if (H7.a.b()) {
                H7.b.b("DefaultContactAdapter", "mRelationIntent = " + this.f34806e0);
                H7.b.b("DefaultContactAdapter", "selection = " + str);
                return str;
            }
            return str;
        }
        ArrayList<Account> arrayList = this.f34812k0;
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < this.f34812k0.size(); i10++) {
                Account account2 = this.f34812k0.get(i10);
                if (account2 != null) {
                    if (!TextUtils.isEmpty(account2.f16941a) && !TextUtils.isEmpty(account2.f16942b)) {
                        sb.append("(account_name='" + account2.f16941a + "' AND account_type='" + account2.f16942b + "')");
                        if (i10 != this.f34812k0.size() - 1) {
                            sb.append(" OR ");
                        }
                    } else if (account2.d()) {
                        sb.append("(account_name IS NULL AND account_type IS NULL)");
                        if (i10 != this.f34812k0.size() - 1) {
                            sb.append(" OR ");
                        }
                    }
                }
            }
            if (sb.length() > 0) {
                str = str + " AND (_id IN (SELECT contact_id FROM raw_contacts WHERE account_id IN (SELECT _id FROM accounts WHERE (" + sb.toString() + "))))";
            }
            if (H7.a.b()) {
                H7.b.b("DefaultContactAdapter", "vip query selection: " + str);
                return str;
            }
            return str;
        }
        return str;
    }

    public final boolean o1() {
        C0806q c0806q = this.f34990R;
        if (c0806q != null && c0806q.i()) {
            return true;
        }
        return false;
    }

    public void p1(Account account) {
        if (account != null) {
            this.f34804c0 = account;
        }
    }

    public void q1(P3.c cVar) {
        this.f34807f0 = cVar;
    }

    public void r1(boolean z10) {
        this.f34801Z = z10;
    }

    public void s1(boolean z10) {
        this.f34805d0 = z10;
    }

    public void t1(boolean z10) {
        this.f34803b0 = z10;
    }

    public void u1(boolean z10) {
        this.f34802a0 = z10;
    }

    public void v1(boolean z10) {
        this.f34808g0 = z10;
    }

    public void w1(boolean z10) {
        this.f34811j0 = z10;
    }

    public void x1(M.d dVar) {
        this.f34813l0 = dVar;
    }

    public void y1(ArrayList<IdRecord> arrayList) {
        if (arrayList == null) {
            this.f34810i0 = null;
            return;
        }
        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < size; i10++) {
            IdRecord idRecord = arrayList.get(i10);
            sb.append(",");
            sb.append(idRecord.b());
        }
        if (sb.length() > 1) {
            this.f34810i0 = "_id NOT IN (" + sb.substring(1) + ") ";
            return;
        }
        this.f34810i0 = null;
    }

    public void z1(d dVar) {
        this.f34814m0 = dVar;
    }

    /* compiled from: DefaultContactListAdapter.java */
    /* renamed from: m1.B$a */
    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactListItemView f34815a;

        public a(ContactListItemView contactListItemView) {
            this.f34815a = contactListItemView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f34815a.getCheckView().setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: DefaultContactListAdapter.java */
    /* renamed from: m1.B$b */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactListItemView f34817a;

        public b(ContactListItemView contactListItemView) {
            this.f34817a = contactListItemView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f34817a.f(8, true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f34817a.f(0, false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public Uri m1(Uri uri) {
        return uri;
    }
}
