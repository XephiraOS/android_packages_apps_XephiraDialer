package com.android.contacts.editor;

import N3.h;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.framework.baseui.widget.SelectedCardView;
import com.android.contacts.model.Account;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.customize.contacts.util.C0791b;
import com.customize.contacts.util.C0797h;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.util.h0;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GroupMembershipView extends SelectedCardView implements View.OnClickListener, DialogInterface.OnDismissListener, Y0.a {

    /* renamed from: A, reason: collision with root package name */
    public androidx.appcompat.app.b f15264A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f15265B;

    /* renamed from: C, reason: collision with root package name */
    public long f15266C;

    /* renamed from: D, reason: collision with root package name */
    public Account f15267D;

    /* renamed from: E, reason: collision with root package name */
    public U0.h f15268E;

    /* renamed from: c, reason: collision with root package name */
    public final Context f15269c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<Account> f15270d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<Long> f15271e;

    /* renamed from: f, reason: collision with root package name */
    public List<h.a> f15272f;

    /* renamed from: g, reason: collision with root package name */
    public List<EntityDelta.ValuesDelta> f15273g;

    /* renamed from: h, reason: collision with root package name */
    public N3.h f15274h;

    /* renamed from: i, reason: collision with root package name */
    public EntityDelta f15275i;

    /* renamed from: j, reason: collision with root package name */
    public Cursor f15276j;

    /* renamed from: k, reason: collision with root package name */
    public String f15277k;

    /* renamed from: l, reason: collision with root package name */
    public String f15278l;

    /* renamed from: m, reason: collision with root package name */
    public String f15279m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f15280n;

    /* renamed from: o, reason: collision with root package name */
    public View f15281o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f15282p;

    /* renamed from: q, reason: collision with root package name */
    public long f15283q;

    /* renamed from: r, reason: collision with root package name */
    public long f15284r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f15285x;

    /* renamed from: y, reason: collision with root package name */
    public String f15286y;

    /* renamed from: z, reason: collision with root package name */
    public Object f15287z;

    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public int f15288a = -1;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15289b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Account f15290c;

        public a(String str, Account account) {
            this.f15289b = str;
            this.f15290c = account;
        }

        public final void a() {
            GroupMembershipView.this.f15265B = true;
            synchronized (GroupMembershipView.this.f15287z) {
                GroupMembershipView.this.f15287z.notifyAll();
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            h.a aVar;
            int parseId;
            if (TextUtils.isEmpty(this.f15289b)) {
                a();
                return GroupMembershipView.this.getContext().getString(R.string.oplus_group_name_cannot_be_empty);
            }
            boolean m10 = N3.b.m(GroupMembershipView.this.getContext(), this.f15289b, this.f15290c);
            if (m10) {
                int i10 = 0;
                while (true) {
                    if (i10 < GroupMembershipView.this.f15272f.size()) {
                        aVar = (h.a) GroupMembershipView.this.f15272f.get(i10);
                        if (this.f15289b.equals(aVar.f2346b)) {
                            this.f15288a = i10;
                            break;
                        }
                        i10++;
                    } else {
                        aVar = null;
                        break;
                    }
                }
            } else {
                aVar = new h.a();
                aVar.f2346b = this.f15289b;
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", this.f15289b);
                contentValues.put("account_name", this.f15290c.f16941a);
                contentValues.put("account_type", this.f15290c.f16942b);
                Uri d10 = G7.c.d(GroupMembershipView.this.getContext().getContentResolver(), R0.d.a(ContactsContract.Groups.CONTENT_URI), contentValues);
                if (d10 == null) {
                    parseId = -1;
                } else {
                    parseId = (int) ContentUris.parseId(d10);
                }
                aVar.f2345a = parseId;
            }
            if (aVar == null) {
                a();
                return GroupMembershipView.this.getContext().getString(R.string.oplus_group_name_exist);
            }
            if (!m10) {
                GroupMembershipView.this.f15272f.add(aVar);
                this.f15288a = GroupMembershipView.this.f15272f.size() - 1;
            }
            a();
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (GroupMembershipView.this.f15264A != null && GroupMembershipView.this.f15264A.isShowing()) {
                GroupMembershipView.this.f15264A.dismiss();
                GroupMembershipView.this.f15264A = null;
            }
            if (str != null) {
                com.oplus.foundation.util.ui.c.c(GroupMembershipView.this.getContext(), str);
            }
            GroupMembershipView.this.I();
            if (GroupMembershipView.this.f15274h != null && GroupMembershipView.this.f15274h.isShowing()) {
                GroupMembershipView.this.f15274h.i(GroupMembershipView.this.f15272f, this.f15288a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public final Long f15294a;

        public d(Long l10) {
            this.f15294a = l10;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            try {
                GroupMembershipView.this.f15272f.clear();
                GroupMembershipView groupMembershipView = GroupMembershipView.this;
                groupMembershipView.f15272f = groupMembershipView.A(groupMembershipView.getContext());
                GroupMembershipView.this.f15265B = true;
                synchronized (GroupMembershipView.this.f15287z) {
                    GroupMembershipView.this.f15287z.notifyAll();
                }
                return null;
            } catch (Throwable th) {
                GroupMembershipView.this.f15265B = true;
                synchronized (GroupMembershipView.this.f15287z) {
                    GroupMembershipView.this.f15287z.notifyAll();
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            try {
                if (GroupMembershipView.this.f15264A != null && GroupMembershipView.this.f15264A.isShowing()) {
                    GroupMembershipView.this.f15264A.dismiss();
                    GroupMembershipView.this.f15264A = null;
                }
                GroupMembershipView groupMembershipView = GroupMembershipView.this;
                groupMembershipView.f15273g = groupMembershipView.f15275i.D("vnd.android.cursor.item/group_membership");
                GroupMembershipView.this.C();
                GroupMembershipView groupMembershipView2 = GroupMembershipView.this;
                groupMembershipView2.f15274h = groupMembershipView2.z();
                GroupMembershipView.this.f15274h.j(this.f15294a);
                if (GroupMembershipView.this.f15274h != null) {
                    GroupMembershipView.this.f15274h.show();
                }
            } catch (Exception e10) {
                H7.b.c("GroupMembershipView", "Exception e: " + e10);
            }
        }
    }

    public GroupMembershipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15270d = new ArrayList<>();
        this.f15271e = new ArrayList<>();
        this.f15287z = new Object();
        this.f15264A = null;
        this.f15265B = false;
        this.f15266C = -1L;
        this.f15267D = null;
        this.f15269c = context;
    }

    private void H() {
        U0.h hVar = this.f15268E;
        Context context = this.f15269c;
        this.f15268E.k(hVar.o(context, R.layout.bottom_dialog_layout_with_edit_text, this, context.getString(R.string.oplus_input_group_name), this.f15269c.getString(R.string.cancel), this.f15269c.getString(R.string.oplus_menu_save)), true, this.f15269c.getString(R.string.oplus_input_group_name), false);
        this.f15268E.j().setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        try {
            Cursor cursor = this.f15276j;
            if (cursor != null && !cursor.isClosed() && this.f15270d.size() != 0) {
                this.f15284r = 0L;
                this.f15283q = 0L;
                StringBuilder sb = new StringBuilder();
                this.f15276j.moveToPosition(-1);
                while (this.f15276j.moveToNext()) {
                    if (com.google.common.base.h.a(this.f15276j.getString(2), this.f15279m)) {
                        long j10 = this.f15276j.getLong(3);
                        if (!this.f15276j.isNull(6) && this.f15276j.getInt(6) != 0) {
                            this.f15284r = j10;
                        } else if (!this.f15276j.isNull(5) && this.f15276j.getInt(5) != 0) {
                            this.f15283q = j10;
                        }
                        if (j10 != this.f15284r && j10 != this.f15283q && j10 != this.f15266C && B(j10)) {
                            String string = this.f15276j.getString(4);
                            if (sb.length() != 0) {
                                sb.append(this.f15269c.getResources().getString(R.string.contact_detail_comma));
                            }
                            sb.append(string);
                        }
                    }
                }
                this.f15280n.setEnabled(isEnabled());
                if (sb.length() == 0) {
                    this.f15280n.setText(sb);
                    this.f15280n.setHint(this.f15286y);
                } else {
                    this.f15280n.setText(sb.toString());
                }
                setVisibility(0);
                if (!this.f15285x) {
                    this.f15285x = true;
                    return;
                }
                return;
            }
            setVisibility(8);
        } catch (Exception e10) {
            H7.b.c("GroupMembershipView", "updateView: " + e10);
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.f15277k == null || this.f15278l == null) {
            this.f15277k = R0.a.f3165a;
            this.f15278l = R0.a.f3166b;
        }
        this.f15267D = new Account(this.f15277k, this.f15278l);
        H();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0129 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<N3.h.a> A(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.GroupMembershipView.A(android.content.Context):java.util.List");
    }

    public final boolean B(long j10) {
        Long x10;
        if (j10 == this.f15283q && this.f15275i.Y()) {
            return true;
        }
        ArrayList<EntityDelta.ValuesDelta> D10 = this.f15275i.D("vnd.android.cursor.item/group_membership");
        if (D10 != null) {
            Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (!next.H() && (x10 = next.x("data1")) != null && x10.longValue() == j10) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void C() {
        Integer v10;
        if (!C0811w.g(this.f15273g)) {
            for (h.a aVar : this.f15272f) {
                for (EntityDelta.ValuesDelta valuesDelta : this.f15273g) {
                    if (valuesDelta != null && (v10 = valuesDelta.v("data1")) != null && aVar.f2345a == v10.intValue()) {
                        aVar.f2347c = valuesDelta;
                    }
                }
            }
            return;
        }
        H7.b.i("GroupMembershipView", "setValues(), mlstGroupValue = ");
    }

    public final void D() {
        ArrayList<Account> t10 = this.f15275i.t(true);
        if (t10.size() == 1) {
            this.f15270d.addAll(t10);
        }
        for (int i10 = 0; i10 < t10.size(); i10++) {
            Account account = t10.get(i10);
            Iterator<Account> it = this.f15270d.iterator();
            while (true) {
                if (it.hasNext()) {
                    Account next = it.next();
                    if (!TextUtils.equals(account.f16941a, next.f16941a) || !TextUtils.equals(account.f16942b, next.f16942b)) {
                    }
                } else {
                    this.f15270d.add(account);
                    this.f15271e.add(this.f15275i.v(true).get(i10));
                    break;
                }
            }
        }
    }

    public final void E(String str, Account account) {
        this.f15265B = false;
        C0797h.a(getContext(), new a(str, account), this.f15287z);
        if (!this.f15265B) {
            this.f15264A = U0.k.o(getContext(), getContext().getString(R.string.oplus_group_add_member_message));
        }
    }

    public final void F() {
        ArrayList<Account> arrayList = this.f15270d;
        if (arrayList != null && arrayList.size() > 0) {
            b bVar = new b();
            new com.customize.contacts.widget.p().m(getContext(), getResources().getString(R.string.oplus_accounts), new C0791b(getContext(), this.f15270d, bVar), 44, bVar, R.style.ActivityDialog_UpDown);
        }
    }

    public final void G(Long l10) {
        this.f15265B = false;
        C0797h.a(getContext(), new d(l10), this.f15287z);
        if (!this.f15265B) {
            this.f15264A = U0.k.o(getContext(), getContext().getString(R.string.in_processing));
        }
    }

    @Override // Y0.a
    public void g() {
        String str;
        Editable text;
        COUIEditText j10 = this.f15268E.j();
        SoftKeyboardUtil.a().b(j10);
        if (j10 != null && (text = j10.getText()) != null) {
            str = text.toString();
            if (!TextUtils.isEmpty(str)) {
                str = str.trim();
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            E(str, this.f15267D);
        }
        this.f15268E.g();
    }

    @Override // Y0.a
    public void onCancel() {
        this.f15268E.g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C7.a.a()) {
            H7.b.e("GroupMembershipView", "filter Click!");
            return;
        }
        SoftKeyboardUtil.a().b(view);
        if (this.f15270d.isEmpty()) {
            H7.b.b("GroupMembershipView", "no available accounts");
            return;
        }
        h0.M(getContext(), ContactEditorFragment.r3(), "group");
        if (this.f15270d.size() == 1) {
            this.f15277k = this.f15275i.N().z("account_name");
            this.f15278l = this.f15275i.N().z("account_type");
            G(this.f15275i.v(true).get(0));
            return;
        }
        F();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        I();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15268E = new U0.h();
        this.f15281o = findViewById(R.id.edit_group_view);
        this.f15280n = (TextView) findViewById(R.id.group_text_view);
        this.f15281o.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.left_icon_view);
        this.f15282p = imageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.pb_ic_group);
        }
        this.f15286y = getContext().getString(R.string.oplus_groups_label);
    }

    public void setBusinessCardGroupId(long j10) {
        this.f15266C = j10;
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        TextView textView = this.f15280n;
        if (textView != null) {
            textView.setEnabled(z10);
        }
    }

    public void setGroupMetaData(Cursor cursor) {
        this.f15276j = cursor;
        I();
    }

    public void setState(EntityDelta entityDelta) {
        this.f15275i = entityDelta;
        this.f15279m = entityDelta.N().z("data_set");
        this.f15285x = false;
        D();
        this.f15272f = new ArrayList();
        this.f15273g = entityDelta.D("vnd.android.cursor.item/group_membership");
        C();
        I();
    }

    public final N3.h z() {
        N3.h hVar = new N3.h(getContext(), this.f15275i, this.f15272f, R.style.ActivityDialog_UpDown, new c());
        hVar.setOnDismissListener(this);
        return hVar;
    }

    /* loaded from: classes.dex */
    public class b implements p.a {
        public b() {
        }

        @Override // com.customize.contacts.widget.p.a
        public void a(Object obj) {
            if (obj == null) {
                H7.b.c("GroupMembershipView", "showAccountsDialog onResult(null); return");
                return;
            }
            int intValue = ((Integer) obj).intValue();
            if (-2 == intValue) {
                return;
            }
            Account account = (Account) GroupMembershipView.this.f15270d.get(intValue);
            GroupMembershipView.this.f15277k = account.f16941a;
            GroupMembershipView.this.f15278l = account.f16942b;
            GroupMembershipView groupMembershipView = GroupMembershipView.this;
            groupMembershipView.G((Long) groupMembershipView.f15271e.get(intValue));
        }

        @Override // com.customize.contacts.widget.p.a
        public void b() {
        }

        @Override // com.customize.contacts.widget.p.a
        public void c() {
        }
    }

    /* loaded from: classes.dex */
    public class c implements p.a {
        public c() {
        }

        @Override // com.customize.contacts.widget.p.a
        public void c() {
            GroupMembershipView.this.y();
        }

        @Override // com.customize.contacts.widget.p.a
        public void a(Object obj) {
        }

        @Override // com.customize.contacts.widget.p.a
        public void b() {
        }
    }
}
