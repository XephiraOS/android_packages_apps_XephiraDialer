package com.android.contacts.list;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class ContactListFilterView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public TextView f16748a;

    /* renamed from: b, reason: collision with root package name */
    public View f16749b;

    /* renamed from: c, reason: collision with root package name */
    public ContactListFilter f16750c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f16751d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f16752e;

    /* renamed from: f, reason: collision with root package name */
    public RadioButton f16753f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f16754g;

    /* renamed from: h, reason: collision with root package name */
    public View f16755h;

    public ContactListFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16751d = context;
    }

    public final void a(int i10, boolean z10) {
        this.f16748a.setText(i10);
        this.f16754g.setVisibility(8);
        View view = this.f16749b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void b(boolean z10) {
        int i10;
        if (this.f16748a == null) {
            this.f16748a = (TextView) findViewById(R.id.label);
            this.f16749b = findViewById(R.id.indent);
            this.f16752e = (TextView) findViewById(R.id.count);
            this.f16753f = (RadioButton) findViewById(R.id.radioBtn);
            this.f16754g = (TextView) findViewById(R.id.account_name);
            this.f16755h = findViewById(R.id.bottom_divider);
        }
        if (this.f16750c == null) {
            this.f16748a.setText(R.string.contactsList);
            return;
        }
        this.f16748a.setTextAppearance(this.f16751d, R.style.LargeTextStyle);
        ContactListFilter contactListFilter = this.f16750c;
        int i11 = contactListFilter.f16738b;
        if (i11 != -6) {
            if (i11 != -5) {
                if (i11 != -4) {
                    if (i11 != -3) {
                        if (i11 != -2) {
                            if (i11 == 0) {
                                if (TextUtils.equals(R0.a.f3166b, contactListFilter.f16739c)) {
                                    a(R.string.contact_editor_account_storage_phone, z10);
                                    return;
                                }
                                this.f16748a.setText(this.f16750c.f16743g);
                                if (TextUtils.equals(this.f16750c.f16739c, "com.android.oplus.sim")) {
                                    this.f16754g.setVisibility(8);
                                } else {
                                    this.f16754g.setVisibility(0);
                                    this.f16754g.setText(this.f16750c.f16740d);
                                }
                                if (z10) {
                                    this.f16749b.setVisibility(8);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        a(R.string.list_filter_all_accounts, z10);
                        return;
                    }
                    if (z10) {
                        i10 = R.string.list_filter_customize;
                    } else {
                        i10 = R.string.list_filter_custom;
                    }
                    a(i10, z10);
                    this.f16748a.setTextAppearance(getContext(), R.style.FocusTitleStyle);
                    return;
                }
                a(R.string.list_filter_all_starred, z10);
                return;
            }
            a(R.string.list_filter_phones, z10);
            return;
        }
        a(R.string.list_filter_single, z10);
    }

    public void c(String str) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.f16752e;
            if (-3 == this.f16750c.f16738b) {
                i10 = 8;
            } else {
                i10 = 4;
            }
            textView.setVisibility(i10);
            return;
        }
        this.f16752e.setVisibility(0);
        this.f16752e.setText(str);
    }

    public View getBottomDivider() {
        return this.f16755h;
    }

    public ContactListFilter getContactListFilter() {
        return this.f16750c;
    }

    public TextView getLableView() {
        return this.f16748a;
    }

    public RadioButton getRadioButton() {
        return this.f16753f;
    }

    public void setContactListFilter(ContactListFilter contactListFilter) {
        this.f16750c = contactListFilter;
    }

    public void setCountText(int i10) {
        int i11;
        if (i10 == -1) {
            TextView textView = this.f16752e;
            ContactListFilter contactListFilter = this.f16750c;
            if (contactListFilter != null && -3 == contactListFilter.f16738b) {
                i11 = 8;
            } else {
                i11 = 4;
            }
            textView.setVisibility(i11);
        } else {
            this.f16752e.setVisibility(0);
            if (i10 == 0) {
                this.f16752e.setText(this.f16751d.getString(R.string.no_contacts_warnning));
            } else {
                this.f16752e.setText(String.format(this.f16751d.getString(R.string.oplus_contacts_totalcount), U7.a.b(i10)));
            }
        }
        ContactListFilter contactListFilter2 = this.f16750c;
        if (contactListFilter2 != null && -3 == contactListFilter2.f16738b) {
            this.f16752e.setVisibility(8);
            this.f16754g.setVisibility(8);
        }
    }

    public void setRadioStatus(boolean z10) {
        this.f16753f.setChecked(z10);
    }
}
