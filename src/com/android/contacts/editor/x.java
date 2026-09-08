package com.android.contacts.editor;

import X0.b;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.contacts.editor.A;
import com.android.contacts.model.EntityDelta;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q1.C1480a;

/* compiled from: CustomizeLabeledEditorView.java */
/* loaded from: classes.dex */
public abstract class x extends LinearLayout implements A {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15495a;

    /* renamed from: b, reason: collision with root package name */
    public int f15496b;

    /* renamed from: c, reason: collision with root package name */
    public com.android.contacts.model.c f15497c;

    /* renamed from: d, reason: collision with root package name */
    public EntityDelta.ValuesDelta f15498d;

    /* renamed from: e, reason: collision with root package name */
    public EntityDelta f15499e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15500f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15501g;

    /* renamed from: h, reason: collision with root package name */
    public A.a f15502h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f15503i;

    /* renamed from: j, reason: collision with root package name */
    public String f15504j;

    /* renamed from: k, reason: collision with root package name */
    public final List<b.a> f15505k;

    /* compiled from: CustomizeLabeledEditorView.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!x.this.f15503i) {
                x.this.p();
            }
        }
    }

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15495a = true;
        this.f15501g = true;
        this.f15503i = true;
        this.f15505k = new ArrayList();
        h(context);
    }

    private boolean j(String str, String str2) {
        String z10 = this.f15498d.z(str);
        if (z10 == null) {
            z10 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return !TextUtils.equals(z10, str2);
    }

    private void l(String str, String str2) {
        List<b.a> onFieldContentEditListeners = getOnFieldContentEditListeners();
        if (!onFieldContentEditListeners.isEmpty()) {
            Iterator<b.a> it = onFieldContentEditListeners.iterator();
            while (it.hasNext()) {
                it.next().onFieldContentChanged(str, str2);
            }
        }
    }

    @Override // com.android.contacts.editor.A
    public void a() {
        this.f15498d.Y();
        ((ViewGroup) getParent()).removeView(this);
    }

    public void b(b.a aVar) {
        if (aVar != null) {
            this.f15505k.add(aVar);
        }
    }

    @Override // X0.b
    public void f() {
        this.f15505k.clear();
    }

    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        i(valuesDelta);
        this.f15497c = cVar;
        this.f15498d = valuesDelta;
        this.f15499e = entityDelta;
        this.f15500f = z10;
        setId(viewIdGenerator.d(entityDelta, cVar, valuesDelta, -1));
        if (!valuesDelta.R()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        boolean q10 = com.android.contacts.model.d.q(cVar);
        setupLabelButton(q10);
        if (q10) {
            com.android.contacts.model.d.h(valuesDelta, cVar);
            n();
        }
    }

    public List<b.a> getOnFieldContentEditListeners() {
        return this.f15505k;
    }

    public final void h(Context context) {
        this.f15496b = context.getResources().getDimensionPixelSize(R.dimen.editor_min_line_item_height);
    }

    public final void i(EntityDelta.ValuesDelta valuesDelta) {
        if (valuesDelta == null) {
            return;
        }
        this.f15503i = valuesDelta.q("account_writable", Boolean.TRUE).booleanValue();
        this.f15504j = valuesDelta.z("account_name");
        valuesDelta.p0("account_writable");
        valuesDelta.p0("account_name");
        if (!this.f15503i) {
            setOnClickListener(new a());
        }
    }

    public boolean k() {
        return this.f15500f;
    }

    public void m(String str, String str2) {
        if (!j(str, str2)) {
            return;
        }
        String trim = str2.trim();
        this.f15498d.e0(str, trim);
        l(str, trim);
        A.a aVar = this.f15502h;
        if (aVar != null) {
            aVar.c(2);
        }
        boolean isEmpty = isEmpty();
        if (this.f15495a != isEmpty) {
            if (isEmpty) {
                A.a aVar2 = this.f15502h;
                if (aVar2 != null) {
                    aVar2.c(3);
                }
                if (this.f15501g) {
                    H7.b.b("CustomizeLabeledEditorView", "LabeledEditorView-----delete visuable---001");
                }
            } else {
                A.a aVar3 = this.f15502h;
                if (aVar3 != null) {
                    aVar3.c(4);
                }
                if (this.f15501g) {
                    H7.b.b("CustomizeLabeledEditorView", "LabeledEditorView-----delete un-visuable---001");
                }
            }
            this.f15495a = isEmpty;
        }
        C1480a.e(getContext(), ContactEditorFragment.r3(), this.f15499e.C(), str, this.f15497c.f17004c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f15503i) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void p() {
        A.a aVar = this.f15502h;
        if (aVar != null) {
            aVar.e(this.f15504j);
        }
    }

    @Override // com.android.contacts.editor.A
    public void setDeletable(boolean z10) {
        this.f15501g = z10;
        o();
    }

    @Override // com.android.contacts.editor.A
    public void setEditorListener(A.a aVar) {
        this.f15502h = aVar;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
    }

    private void setupLabelButton(boolean z10) {
    }

    public final void n() {
    }

    public final void o() {
    }

    public void setDeleteButtonVisible(boolean z10) {
    }
}
