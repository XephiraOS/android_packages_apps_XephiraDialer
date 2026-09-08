package com.customize.contacts.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.contacts.editor.A;
import com.android.contacts.editor.ViewIdGenerator;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.oplus.dialer.R;
import h1.C1074c;

/* loaded from: classes3.dex */
public class GenericEditorView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public COUIEditText f22378a;

    /* renamed from: b, reason: collision with root package name */
    public com.android.contacts.model.c f22379b;

    /* renamed from: c, reason: collision with root package name */
    public EntityDelta.ValuesDelta f22380c;

    /* renamed from: d, reason: collision with root package name */
    public EntityDelta f22381d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22382e;

    /* renamed from: f, reason: collision with root package name */
    public AccountType.c f22383f;

    /* renamed from: g, reason: collision with root package name */
    public A.a f22384g;

    /* renamed from: h, reason: collision with root package name */
    public LayoutInflater f22385h;

    public GenericEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static String c(Context context, AccountType.b bVar) {
        return context.getString(bVar.f16954b);
    }

    public final void b(COUIEditText cOUIEditText, AccountType.b bVar) {
        String str = bVar.f16953a;
        String z10 = this.f22380c.z(str);
        int i10 = 0;
        if (z10 != null && z10.length() > 20) {
            z10 = z10.substring(0, 20);
            this.f22380c.e0(str, z10);
        }
        cOUIEditText.setTag(bVar);
        if (bVar.f16954b > 0) {
            cOUIEditText.setHint(c(getContext(), bVar));
        }
        cOUIEditText.setInputType(d(this.f22383f, bVar));
        cOUIEditText.setMinLines(bVar.f16956d);
        if (d(this.f22383f, bVar) == 3) {
            cOUIEditText.setTextAlignment(5);
            cOUIEditText.setTextDirection(3);
            C1074c.d(getContext(), cOUIEditText);
            String a10 = C1074c.a(z10, null, getContext());
            if (C0637b.h()) {
                a10 = C0637b.c(a10);
            }
            cOUIEditText.setText(a10);
        } else {
            if (C0637b.h()) {
                z10 = C0637b.c(z10);
            }
            cOUIEditText.setText(z10);
        }
        cOUIEditText.setTag(bVar);
        cOUIEditText.addTextChangedListener(new a(str));
        if (!U7.f.c(z10) && bVar.f16957e) {
            i10 = 8;
        }
        cOUIEditText.setVisibility(i10);
        cOUIEditText.setEnabled(!this.f22382e);
    }

    public final int d(AccountType.c cVar, AccountType.b bVar) {
        return bVar.f16955c;
    }

    public final void e(String str, String str2) {
        this.f22380c.e0(str, str2);
        A.a aVar = this.f22384g;
        if (aVar != null) {
            aVar.c(2);
        }
    }

    public void f(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        this.f22379b = cVar;
        this.f22380c = valuesDelta;
        this.f22381d = entityDelta;
        this.f22382e = z10;
        if (viewIdGenerator != null) {
            setId(viewIdGenerator.d(entityDelta, cVar, valuesDelta, -1));
        } else if (H7.a.b()) {
            H7.b.b("GenericEditorView", "setValues(), vig = " + viewIdGenerator);
        }
        if (!valuesDelta.R()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (com.android.contacts.model.d.q(cVar)) {
            this.f22383f = com.android.contacts.model.d.h(valuesDelta, cVar);
        }
        b(this.f22378a, this.f22379b.f17018q.get(0));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f22385h = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f22378a = (COUIEditText) findViewById(R.id.phone_edit_field);
        ((ImageView) findViewById(R.id.left_icon_view)).setImageResource(R.drawable.pb_ic_call);
    }

    public void setEditorListener(A.a aVar) {
        this.f22384g = aVar;
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22386a;

        public a(String str) {
            this.f22386a = str;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            GenericEditorView.this.e(this.f22386a, charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
