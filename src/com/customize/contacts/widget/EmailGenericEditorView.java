package com.customize.contacts.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.editor.ViewIdGenerator;
import com.android.contacts.framework.baseui.widget.SelectedCardView;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.customize.contacts.util.A;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class EmailGenericEditorView extends SelectedCardView {

    /* renamed from: c, reason: collision with root package name */
    public COUIEditText f22306c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f22307d;

    /* renamed from: e, reason: collision with root package name */
    public EntityDelta.ValuesDelta f22308e;

    /* renamed from: f, reason: collision with root package name */
    public AccountType.b f22309f;

    /* loaded from: classes3.dex */
    public class b implements InputFilter {

        /* renamed from: a, reason: collision with root package name */
        public final Context f22312a;

        /* renamed from: b, reason: collision with root package name */
        public int f22313b;

        public b(Context context, int i10) {
            this.f22312a = context;
            this.f22313b = i10;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            int length = 38 - (spanned.length() - (i13 - i12));
            if (H7.a.b()) {
                H7.b.b("EmailGenericEditorView", "filter, keep = " + length);
            }
            if (length <= 0) {
                return "";
            }
            if (length >= i11 - i10) {
                return null;
            }
            return charSequence.subSequence(i10, length + i10);
        }
    }

    public EmailGenericEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void f(EntityDelta entityDelta, EntityDelta.ValuesDelta valuesDelta, AccountType accountType, AccountType.b bVar, com.android.contacts.model.c cVar, ViewIdGenerator viewIdGenerator, int i10) {
        this.f22308e = valuesDelta;
        this.f22309f = bVar;
        this.f22306c.setInputType(bVar.f16955c);
        if (H7.a.b()) {
            H7.b.b("EmailGenericEditorView", "setValue(), mValues1 = " + this.f22308e);
        }
        String str = bVar.f16953a;
        this.f22306c.setText(valuesDelta.z(str));
        this.f22306c.addTextChangedListener(new a(str));
        if (bVar.f16954b > 0) {
            this.f22306c.setHint(GenericEditorView.c(getContext(), bVar));
        }
        if (ContactsApplication.f13094j) {
            this.f22306c.setTextAlignment(5);
            this.f22306c.setTextDirection(3);
        }
        if (H7.a.b()) {
            H7.b.b("EmailGenericEditorView", "setValue(), accountType = " + accountType.f16944a);
        }
        if ("vnd.android.cursor.item/email_v2".equals(cVar.f17004c)) {
            A.a(this.f22306c);
        }
        COUIEditText cOUIEditText = this.f22306c;
        cOUIEditText.setFilters(new InputFilter[]{new b(cOUIEditText.getContext(), i10)});
    }

    public AccountType.b getEditfield() {
        return this.f22309f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f22307d = (LayoutInflater) getContext().getSystemService("layout_inflater");
        COUIEditText cOUIEditText = (COUIEditText) findViewById(R.id.email_edit_field);
        this.f22306c = cOUIEditText;
        cOUIEditText.setInputType(33);
        ((ImageView) findViewById(R.id.left_icon_view)).setImageResource(R.drawable.pb_ic_email);
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22310a;

        public a(String str) {
            this.f22310a = str;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj) && !"data1".equals(this.f22310a)) {
                EmailGenericEditorView.this.f22308e.k0(EmailGenericEditorView.this.f22309f.f16953a);
                if (H7.a.b()) {
                    H7.b.b("EmailGenericEditorView", "setValue()2, mValues = " + EmailGenericEditorView.this.f22308e);
                    return;
                }
                return;
            }
            EmailGenericEditorView.this.f22308e.e0(EmailGenericEditorView.this.f22309f.f16953a, obj);
            if (H7.a.b()) {
                H7.b.b("EmailGenericEditorView", "setValue()3, mValues = " + EmailGenericEditorView.this.f22308e);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
