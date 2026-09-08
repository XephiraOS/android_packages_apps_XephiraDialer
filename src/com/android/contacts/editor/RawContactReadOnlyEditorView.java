package com.android.contacts.editor;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import h1.C1074c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RawContactReadOnlyEditorView extends BaseRawContactEditorView implements View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public a f15400A;

    /* renamed from: k, reason: collision with root package name */
    public LayoutInflater f15401k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f15402l;

    /* renamed from: m, reason: collision with root package name */
    public Button f15403m;

    /* renamed from: n, reason: collision with root package name */
    public ViewGroup f15404n;

    /* renamed from: o, reason: collision with root package name */
    public ViewGroup f15405o;

    /* renamed from: p, reason: collision with root package name */
    public View f15406p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f15407q;

    /* renamed from: r, reason: collision with root package name */
    public String f15408r;

    /* renamed from: x, reason: collision with root package name */
    public String f15409x;

    /* renamed from: y, reason: collision with root package name */
    public String f15410y;

    /* renamed from: z, reason: collision with root package name */
    public long f15411z;

    /* loaded from: classes.dex */
    public interface a {
        void E(AccountWithDataSet accountWithDataSet, Uri uri);
    }

    public RawContactReadOnlyEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15411z = -1L;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void c(EntityDelta entityDelta, AccountType accountType, ViewIdGenerator viewIdGenerator, boolean z10) {
        String string;
        int i10;
        int i11;
        CharSequence charSequence;
        boolean z11;
        boolean z12;
        int i12;
        String formatNumber;
        CharSequence charSequence2;
        boolean z13;
        boolean z14;
        int i13;
        boolean z15;
        this.f15404n.removeAllViews();
        this.f15405o.removeAllViews();
        if (entityDelta != null && accountType != null) {
            com.android.contacts.model.d.e(entityDelta, accountType, "vnd.android.cursor.item/name");
            EntityDelta.ValuesDelta N10 = entityDelta.N();
            this.f15408r = N10.z("account_name");
            this.f15409x = N10.z("account_type");
            this.f15410y = N10.z("data_set");
            if (z10) {
                if (TextUtils.isEmpty(this.f15408r)) {
                    this.f15407q.setVisibility(8);
                } else {
                    this.f15407q.setText(this.f15408r);
                    this.f15407q.setVisibility(8);
                }
            } else {
                if (!TextUtils.isEmpty(this.f15408r)) {
                    this.f15407q.setVisibility(0);
                    this.f15407q.setText(getContext().getString(R.string.from_account_format, this.f15408r));
                } else {
                    this.f15407q.setVisibility(8);
                }
                if (TextUtils.equals(R0.a.f3165a, this.f15408r)) {
                    this.f15407q.setText(getContext().getString(R.string.contact_editor_account_storage_phone));
                }
            }
            this.f15411z = N10.x(BreenoCallContract.BaseColumns._ID).longValue();
            com.android.contacts.model.c j10 = accountType.j("vnd.android.cursor.item/photo");
            if (j10 != null) {
                com.android.contacts.model.d.e(entityDelta, accountType, "vnd.android.cursor.item/photo");
                if (accountType.j("vnd.android.cursor.item/photo") != null) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                setHasPhotoEditor(z15);
                getPhotoEditor().g(j10, entityDelta.H("vnd.android.cursor.item/photo"), entityDelta, !accountType.b(), viewIdGenerator);
            }
            EntityDelta.ValuesDelta H10 = entityDelta.H("vnd.android.cursor.item/name");
            TextView textView = this.f15402l;
            if (H10 != null) {
                string = H10.z("data1");
            } else {
                string = getContext().getString(R.string.missing_name);
            }
            textView.setText(string);
            CharSequence charSequence3 = null;
            if (accountType.g() != null) {
                this.f15406p.setBackgroundDrawable(null);
                this.f15406p.setEnabled(false);
                this.f15403m.setVisibility(0);
            } else {
                this.f15403m.setVisibility(8);
            }
            Resources resources = getContext().getResources();
            ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D("vnd.android.cursor.item/phone_v2");
            int i14 = R.layout.editor_separator;
            String str = "data3";
            String str2 = "data2";
            if (D10 != null) {
                boolean z16 = false;
                int i15 = 0;
                while (i15 < D10.size()) {
                    EntityDelta.ValuesDelta valuesDelta = D10.get(i15);
                    if (FeatureOption.i()) {
                        formatNumber = PhoneNumberUtils.formatNumber(valuesDelta.z("data1"), valuesDelta.z("data4"), "CN");
                    } else {
                        formatNumber = PhoneNumberUtils.formatNumber(valuesDelta.z("data1"), valuesDelta.z("data4"), C1074c.b(getContext()));
                    }
                    if (valuesDelta.j(str2)) {
                        Integer v10 = valuesDelta.v(str2);
                        if (v10 != null) {
                            i13 = v10.intValue();
                        } else {
                            i13 = 2;
                        }
                        charSequence2 = ContactsContract.CommonDataKinds.Phone.getTypeLabel(resources, i13, valuesDelta.z(str));
                    } else {
                        charSequence2 = charSequence3;
                    }
                    if (!z16) {
                        ViewGroup viewGroup = this.f15404n;
                        viewGroup.addView(this.f15401k.inflate(i14, viewGroup, false));
                        z13 = true;
                    } else {
                        z13 = z16;
                    }
                    CharSequence text = getContext().getText(R.string.phoneLabelsGroup);
                    ViewGroup viewGroup2 = this.f15404n;
                    if (i15 == 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    f(text, formatNumber, charSequence2, viewGroup2, R.drawable.pb_ic_call, z14);
                    i15++;
                    z16 = z13;
                    str2 = str2;
                    i14 = i14;
                    str = str;
                    charSequence3 = null;
                }
            }
            String str3 = str2;
            String str4 = str;
            int i16 = i14;
            ArrayList<EntityDelta.ValuesDelta> D11 = entityDelta.D("vnd.android.cursor.item/email_v2");
            if (D11 != null) {
                boolean z17 = false;
                int i17 = 0;
                while (i17 < D11.size()) {
                    EntityDelta.ValuesDelta valuesDelta2 = D11.get(i17);
                    String z18 = valuesDelta2.z("data1");
                    if (valuesDelta2.j(str3)) {
                        Integer v11 = valuesDelta2.v(str3);
                        if (v11 != null) {
                            i12 = v11.intValue();
                        } else {
                            i12 = 4;
                        }
                        charSequence = ContactsContract.CommonDataKinds.Email.getTypeLabel(resources, i12, valuesDelta2.z(str4));
                    } else {
                        charSequence = null;
                    }
                    if (!z17) {
                        ViewGroup viewGroup3 = this.f15405o;
                        viewGroup3.addView(this.f15401k.inflate(i16, viewGroup3, false));
                        z11 = true;
                    } else {
                        z11 = z17;
                    }
                    CharSequence text2 = getContext().getText(R.string.emailLabelsGroup);
                    ViewGroup viewGroup4 = this.f15405o;
                    if (i17 == 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    f(text2, z18, charSequence, viewGroup4, R.drawable.pb_ic_email, z12);
                    i17++;
                    z17 = z11;
                }
            }
            ViewGroup viewGroup5 = this.f15404n;
            if (viewGroup5.getChildCount() > 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            viewGroup5.setVisibility(i10);
            ViewGroup viewGroup6 = this.f15405o;
            if (viewGroup6.getChildCount() > 0) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            viewGroup6.setVisibility(i11);
        }
    }

    public final void f(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, ViewGroup viewGroup, int i10, boolean z10) {
        View inflate = this.f15401k.inflate(R.layout.item_read_only_field, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.data)).setText(charSequence2);
        TextView textView = (TextView) inflate.findViewById(R.id.type);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.left_icon_view);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.editor_divider);
        imageView.setImageResource(i10);
        if (TextUtils.isEmpty(charSequence3)) {
            textView.setText(charSequence);
        } else {
            textView.setText(charSequence3);
        }
        if (z10) {
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        } else {
            imageView.setVisibility(4);
            imageView2.setVisibility(0);
        }
        viewGroup.addView(inflate);
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public long getRawContactId() {
        return this.f15411z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.getId() == R.id.button_edit_externally && (aVar = this.f15400A) != null) {
            aVar.E(new AccountWithDataSet(this.f15408r, this.f15409x, this.f15410y), ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, this.f15411z));
        }
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15401k = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f15402l = (TextView) findViewById(R.id.read_only_name);
        Button button = (Button) findViewById(R.id.button_edit_externally);
        this.f15403m = button;
        button.setOnClickListener(this);
        this.f15404n = (ViewGroup) findViewById(R.id.phone_sect_general);
        this.f15405o = (ViewGroup) findViewById(R.id.email_sect_general);
        this.f15406p = findViewById(R.id.account_container);
        this.f15407q = (TextView) findViewById(R.id.account_name);
    }

    public void setListener(a aVar) {
        this.f15400A = aVar;
    }
}
