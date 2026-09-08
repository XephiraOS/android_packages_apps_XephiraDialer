package com.customize.contacts.widget;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.android.contacts.editor.BaseRawContactEditorView;
import com.android.contacts.editor.ViewIdGenerator;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SimContactEditorView extends BaseRawContactEditorView {

    /* renamed from: A, reason: collision with root package name */
    public EmailGenericEditorView f22421A;

    /* renamed from: B, reason: collision with root package name */
    public Context f22422B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f22423C;

    /* renamed from: D, reason: collision with root package name */
    public TextView f22424D;

    /* renamed from: k, reason: collision with root package name */
    public EntityDelta f22425k;

    /* renamed from: l, reason: collision with root package name */
    public com.android.contacts.model.c f22426l;

    /* renamed from: m, reason: collision with root package name */
    public com.android.contacts.model.c f22427m;

    /* renamed from: n, reason: collision with root package name */
    public AccountType f22428n;

    /* renamed from: o, reason: collision with root package name */
    public ColorRoundLocalImageView f22429o;

    /* renamed from: p, reason: collision with root package name */
    public NameGenericEditorView f22430p;

    /* renamed from: q, reason: collision with root package name */
    public GenericEditorView f22431q;

    /* renamed from: r, reason: collision with root package name */
    public com.android.contacts.model.c f22432r;

    /* renamed from: x, reason: collision with root package name */
    public com.android.contacts.model.c f22433x;

    /* renamed from: y, reason: collision with root package name */
    public GenericEditorView f22434y;

    /* renamed from: z, reason: collision with root package name */
    public View f22435z;

    public SimContactEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22426l = null;
        this.f22427m = null;
        this.f22428n = null;
        this.f22430p = null;
        this.f22431q = null;
        this.f22432r = null;
        this.f22433x = null;
        this.f22434y = null;
        this.f22435z = null;
        this.f22421A = null;
        this.f22423C = false;
        this.f22422B = context;
    }

    private void setSimStyle(boolean z10) {
        this.f22434y.setVisibility(8);
        this.f22435z.setVisibility(8);
        this.f22421A.setVisibility(8);
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void c(EntityDelta entityDelta, AccountType accountType, ViewIdGenerator viewIdGenerator, boolean z10) {
        EntityDelta.ValuesDelta valuesDelta;
        String z11;
        EntityDelta.ValuesDelta valuesDelta2;
        String[] J10;
        String str;
        this.f22428n = accountType;
        this.f22425k = entityDelta;
        com.android.contacts.model.d.e(entityDelta, accountType, "vnd.android.cursor.item/name");
        com.android.contacts.model.d.e(this.f22425k, accountType, "vnd.android.cursor.item/phone_v2");
        this.f22426l = this.f22428n.j("vnd.android.cursor.item/name");
        this.f22427m = this.f22428n.j("vnd.android.cursor.item/phone_v2");
        EntityDelta.ValuesDelta H10 = this.f22425k.H("vnd.android.cursor.item/name");
        EntityDelta.ValuesDelta H11 = this.f22425k.H("vnd.android.cursor.item/phone_v2");
        ArrayList<EntityDelta.ValuesDelta> D10 = this.f22425k.D("vnd.android.cursor.item/phone_v2");
        if (H11 != null && TextUtils.isEmpty(H11.z("data1"))) {
            Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (next != null && !TextUtils.isEmpty(next.z("data1"))) {
                    valuesDelta = next;
                    break;
                }
            }
        }
        valuesDelta = H11;
        this.f22430p.e(this.f22425k, H10, accountType, this.f22426l.f17018q.get(0), this.f22426l, viewIdGenerator, this.f22423C);
        if (valuesDelta != null) {
            if (valuesDelta.A() != null) {
                valuesDelta.A().put(this.f22427m.f17015n, String.valueOf(2));
                valuesDelta.A().put("data3", (Integer) 1);
            }
            valuesDelta.e0(this.f22427m.f17015n, String.valueOf(2));
            valuesDelta.b0("data3", 1);
        }
        EntityDelta.ValuesDelta valuesDelta3 = valuesDelta;
        this.f22431q.f(this.f22427m, valuesDelta, this.f22425k, false, viewIdGenerator);
        EntityDelta.ValuesDelta N10 = this.f22425k.N();
        if ("com.android.oplus.sim".equals(N10.z("account_type"))) {
            z11 = com.customize.contacts.simcontacts.b.d(this.f22422B, N10.z("account_name"));
        } else {
            z11 = N10.z("account_name");
        }
        this.f22432r = this.f22428n.j("vnd.android.cursor.item/phone_v2");
        int K10 = b0.K(this.f22422B, z11);
        boolean P02 = b0.P0(this.f22422B, z11);
        ArrayList<EntityDelta.ValuesDelta> D11 = this.f22425k.D("vnd.android.cursor.item/phone_v2");
        if (FeatureOption.i()) {
            if (P02 && D11.size() < 2) {
                com.android.contacts.model.d.t(this.f22425k, accountType.j("vnd.android.cursor.item/phone_v2"));
            } else if (!P02) {
                setSimStyle(true);
            }
        } else {
            f(P02, D11, z11, accountType);
        }
        this.f22433x = this.f22428n.j("vnd.android.cursor.item/email_v2");
        com.android.contacts.model.d.e(this.f22425k, accountType, "vnd.android.cursor.item/email_v2");
        EntityDelta.ValuesDelta H12 = this.f22425k.H("vnd.android.cursor.item/email_v2");
        Iterator<EntityDelta.ValuesDelta> it2 = D11.iterator();
        while (true) {
            if (it2.hasNext()) {
                valuesDelta2 = it2.next();
                if (valuesDelta2 != valuesDelta3) {
                    break;
                }
            } else {
                valuesDelta2 = null;
                break;
            }
        }
        if (P02 && valuesDelta2 != null) {
            if (valuesDelta2.A() != null) {
                valuesDelta2.A().put(this.f22432r.f17015n, String.valueOf(2));
            }
            valuesDelta2.e0(this.f22432r.f17015n, String.valueOf(2));
            this.f22434y.f(this.f22432r, valuesDelta2, this.f22425k, false, viewIdGenerator);
        }
        this.f22421A.f(this.f22425k, H12, accountType, this.f22433x.f17018q.get(0), this.f22433x, viewIdGenerator, K10);
        if (FeatureOption.k() && TextUtils.equals("com.android.oplus.sim", N10.z("account_type"))) {
            this.f22424D.setText(com.customize.contacts.simcontacts.b.i(this.f22422B, K10));
            return;
        }
        if (B3.a.i()) {
            String string = getContext().getString(R.string.sim_contact);
            if ((K10 == 0 || K10 == 1) && (str = (J10 = b0.J(getContext()))[K10]) != null && str.length() > 0) {
                string = J10[K10];
            }
            this.f22424D.setText(string);
            return;
        }
        this.f22424D.setText(getContext().getString(R.string.sim_contact));
    }

    public void f(boolean z10, ArrayList<EntityDelta.ValuesDelta> arrayList, String str, AccountType accountType) {
        EmailGenericEditorView emailGenericEditorView;
        EmailGenericEditorView emailGenericEditorView2;
        boolean Y9 = b0.Y(this.f22422B, str);
        if (z10 && arrayList.size() < 2) {
            com.android.contacts.model.d.t(this.f22425k, accountType.j("vnd.android.cursor.item/phone_v2"));
            if (!Y9 && (emailGenericEditorView2 = this.f22421A) != null) {
                emailGenericEditorView2.setVisibility(8);
                return;
            }
            return;
        }
        if (!z10) {
            if (Y9) {
                this.f22434y.setVisibility(8);
                this.f22435z.setVisibility(8);
                return;
            } else {
                setSimStyle(true);
                return;
            }
        }
        if (!Y9 && (emailGenericEditorView = this.f22421A) != null) {
            emailGenericEditorView.setVisibility(8);
        }
    }

    public NameGenericEditorView getNameEditor() {
        return this.f22430p;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public long getRawContactId() {
        return 0L;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView, android.view.View
    public void onFinishInflate() {
        this.f22430p = (NameGenericEditorView) findViewById(R.id.name);
        this.f22429o = (ColorRoundLocalImageView) findViewById(R.id.name_edit_sim_contact_photo);
        this.f22431q = (GenericEditorView) findViewById(R.id.phone);
        this.f22434y = (GenericEditorView) findViewById(R.id.phone2);
        this.f22421A = (EmailGenericEditorView) findViewById(R.id.email);
        this.f22435z = findViewById(R.id.sim_phone2_divider);
        this.f22424D = (TextView) findViewById(R.id.account_name);
        this.f22434y.findViewById(R.id.left_icon_view).setVisibility(4);
    }

    public void setIsEditContact(boolean z10) {
        this.f22423C = z10;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void setGroupMetaData(Cursor cursor) {
    }
}
