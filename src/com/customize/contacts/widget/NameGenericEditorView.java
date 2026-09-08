package com.customize.contacts.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.contacts.editor.ViewIdGenerator;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class NameGenericEditorView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public COUIEditText f22394a;

    /* renamed from: b, reason: collision with root package name */
    public View f22395b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f22396c;

    /* renamed from: d, reason: collision with root package name */
    public EntityDelta.ValuesDelta f22397d;

    /* renamed from: e, reason: collision with root package name */
    public AccountType.b f22398e;

    /* renamed from: f, reason: collision with root package name */
    public String f22399f;

    /* renamed from: g, reason: collision with root package name */
    public String f22400g;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public String f22401a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f22402b = null;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f22403c;

        public a(String str) {
            this.f22403c = str;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = this.f22401a;
            if (H7.a.b()) {
                H7.b.b("NameGenericEditorView", "TextWatcher, afterTextChanged, the s is " + editable.toString() + ", the newValue is " + str);
            }
            if (TextUtils.isEmpty(str) && !"data1".equals(this.f22403c)) {
                NameGenericEditorView.this.f22397d.k0(NameGenericEditorView.this.f22398e.f16953a);
                NameGenericEditorView.this.f22397d.k0("data2");
                NameGenericEditorView.this.f22397d.k0("data3");
                if (H7.a.b()) {
                    H7.b.b("NameGenericEditorView", "setValue()2, mValues = " + NameGenericEditorView.this.f22397d);
                    return;
                }
                return;
            }
            NameGenericEditorView.this.f22397d.e0(NameGenericEditorView.this.f22398e.f16953a, str);
            NameGenericEditorView.this.f22397d.e0("data2", str);
            NameGenericEditorView.this.f22397d.k0("data3");
            NameGenericEditorView.this.f22397d.k0("data4");
            NameGenericEditorView.this.f22397d.k0("data5");
            NameGenericEditorView.this.f22397d.k0("data6");
            if (H7.a.b()) {
                H7.b.b("NameGenericEditorView", "setValue()3, mValues = " + NameGenericEditorView.this.f22397d);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            this.f22402b = charSequence.toString();
            if (H7.a.b()) {
                H7.b.b("NameGenericEditorView", "beforeTextChanged, the s is " + this.f22402b);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            String str;
            if (!TextUtils.equals("com.android.oplus.sim", NameGenericEditorView.this.f22400g)) {
                str = NameGenericEditorView.this.f22399f;
            } else {
                str = com.customize.contacts.simcontacts.b.d(NameGenericEditorView.this.f22394a.getContext(), NameGenericEditorView.this.f22399f);
            }
            int q10 = b0.q(NameGenericEditorView.this.f22394a.getContext(), null, str);
            String charSequence2 = charSequence.toString();
            int length = charSequence2.length();
            if (H7.a.b()) {
                H7.b.b("NameGenericEditorView", "the start is " + i10 + ", the count is " + i12 + ", the name is " + charSequence2 + ", strLen = " + length);
            }
            String str2 = this.f22401a;
            if (str2 != null && str2.equals(charSequence2)) {
                return;
            }
            int n10 = b0.n(charSequence2, q10);
            if (length > n10) {
                if (n10 < this.f22402b.length()) {
                    this.f22401a = this.f22402b;
                } else if (i10 + i12 <= length) {
                    if (TextUtils.isEmpty(this.f22401a)) {
                        this.f22401a = charSequence2.substring(0, n10);
                    }
                } else {
                    this.f22401a = charSequence.toString();
                }
                NameGenericEditorView.this.f22394a.setText(this.f22401a);
            } else {
                this.f22401a = charSequence.toString();
            }
            if (H7.a.b()) {
                H7.b.b("NameGenericEditorView", "TextWatcher, onTextChanged, the inputStr is " + this.f22401a + ", the maxLen is " + n10);
            }
        }
    }

    public NameGenericEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22399f = null;
        this.f22400g = null;
    }

    public void e(EntityDelta entityDelta, EntityDelta.ValuesDelta valuesDelta, AccountType accountType, AccountType.b bVar, com.android.contacts.model.c cVar, ViewIdGenerator viewIdGenerator, boolean z10) {
        this.f22397d = valuesDelta;
        this.f22398e = bVar;
        this.f22394a.setInputType(bVar.f16955c);
        this.f22394a.setTextAlignment(5);
        this.f22399f = entityDelta.N().z("account_name");
        this.f22400g = entityDelta.N().z("account_type");
        if (H7.a.b()) {
            H7.b.b("NameGenericEditorView", "setValue(), mValues = " + this.f22397d + ", mAccountName = " + this.f22399f + ", mAccountType = " + this.f22400g);
        }
        String str = bVar.f16953a;
        String z11 = valuesDelta.z(str);
        this.f22394a.addTextChangedListener(new a(str));
        this.f22394a.setText(z11);
        if (!z10) {
            this.f22394a.requestFocus();
            SoftKeyboardUtil.a().f(this.f22394a);
        }
        if (bVar.f16954b > 0) {
            this.f22394a.setHint(GenericEditorView.c(getContext(), bVar));
        }
        if (H7.a.b()) {
            H7.b.b("NameGenericEditorView", "setValue(), accountType = " + accountType.f16944a);
        }
    }

    public COUIEditText getEditText() {
        return this.f22394a;
    }

    public AccountType.b getEditfield() {
        return this.f22398e;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f22396c = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f22394a = (COUIEditText) findViewById(R.id.name_edit_field);
        this.f22395b = findViewById(R.id.name_generic_label);
        ((ImageView) findViewById(R.id.left_icon_view)).setImageResource(R.drawable.pb_ic_name);
    }
}
