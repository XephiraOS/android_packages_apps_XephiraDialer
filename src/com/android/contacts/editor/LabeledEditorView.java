package com.android.contacts.editor;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.contacts.detail.i0;
import com.android.contacts.editor.A;
import com.android.contacts.editor.KindSectionView;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.poplist.PopupListItem;
import com.customize.contacts.util.h0;
import com.customize.contacts.widget.SpinnerView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import q1.C1480a;

/* loaded from: classes.dex */
public abstract class LabeledEditorView extends LinearLayout implements A {

    /* renamed from: B, reason: collision with root package name */
    public static final AccountType.c f15321B = new AccountType.c(0, 0);

    /* renamed from: A, reason: collision with root package name */
    public SpinnerView.d f15322A;

    /* renamed from: a, reason: collision with root package name */
    public boolean f15323a;

    /* renamed from: b, reason: collision with root package name */
    public com.customize.contacts.manager.z f15324b;

    /* renamed from: c, reason: collision with root package name */
    public int f15325c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerView f15326d;

    /* renamed from: e, reason: collision with root package name */
    public View f15327e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f15328f;

    /* renamed from: g, reason: collision with root package name */
    public com.android.contacts.model.c f15329g;

    /* renamed from: h, reason: collision with root package name */
    public EntityDelta.ValuesDelta f15330h;

    /* renamed from: i, reason: collision with root package name */
    public EntityDelta f15331i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15332j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15333k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15334l;

    /* renamed from: m, reason: collision with root package name */
    public AccountType.c f15335m;

    /* renamed from: n, reason: collision with root package name */
    public ViewIdGenerator f15336n;

    /* renamed from: o, reason: collision with root package name */
    public A.a f15337o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15338p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f15339q;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f15340r;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<AccountType.c> f15341x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList<PopupListItem> f15342y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f15343z;

    /* loaded from: classes.dex */
    public class a implements SpinnerView.d {
        public a() {
        }

        @Override // com.customize.contacts.widget.SpinnerView.d
        public void onItemSelected(int i10) {
            LabeledEditorView.this.z(i10);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!LabeledEditorView.this.f15334l) {
                    return;
                }
                if (LabeledEditorView.this.getTag() != null && (LabeledEditorView.this.getTag() instanceof KindSectionView.e)) {
                    ((KindSectionView.e) LabeledEditorView.this.getTag()).a();
                    return;
                }
                LabeledEditorView labeledEditorView = LabeledEditorView.this;
                A.a aVar = labeledEditorView.f15337o;
                if (aVar != null) {
                    aVar.d(labeledEditorView);
                }
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ("vnd.android.cursor.item/relation".equals(LabeledEditorView.this.f15329g.f17004c) && TextUtils.equals("relation_add", (String) LabeledEditorView.this.f15328f.getTag())) {
                LabeledEditorView.this.C();
                Q7.b.b(LabeledEditorView.this.f15324b.a(), new Intent("com.oplus.contacts.ui.LIST_RELATION_CONTACTS"), 1110, 0);
                h0.M(LabeledEditorView.this.getContext(), ContactEditorFragment.r3(), "affiliated_person_select");
                return;
            }
            new Handler().post(new a());
        }
    }

    /* loaded from: classes.dex */
    public class c implements Y0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ U0.h f15347a;

        public c(U0.h hVar) {
            this.f15347a = hVar;
        }

        @Override // Y0.a
        public void g() {
            COUIEditText j10 = this.f15347a.j();
            if (j10 != null && j10.getText() != null) {
                String trim = j10.getText().toString().trim();
                if (U7.f.c(trim)) {
                    LabeledEditorView labeledEditorView = LabeledEditorView.this;
                    ArrayList<AccountType.c> m10 = com.android.contacts.model.d.m(labeledEditorView.f15331i, labeledEditorView.f15329g, null);
                    LabeledEditorView.this.f15335m = null;
                    Iterator<AccountType.c> it = m10.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AccountType.c next = it.next();
                        if (next.f16964e != null) {
                            LabeledEditorView.this.f15335m = next;
                            break;
                        }
                    }
                    if (LabeledEditorView.this.f15335m == null) {
                        this.f15347a.g();
                        return;
                    }
                    LabeledEditorView labeledEditorView2 = LabeledEditorView.this;
                    labeledEditorView2.f15330h.b0(labeledEditorView2.f15329g.f17015n, labeledEditorView2.f15335m.f16960a);
                    LabeledEditorView labeledEditorView3 = LabeledEditorView.this;
                    labeledEditorView3.f15330h.e0(labeledEditorView3.f15335m.f16964e, trim);
                    if ("vnd.android.cursor.item/contact_event".equals(LabeledEditorView.this.f15329g.f17004c) && LabeledEditorView.this.f15339q) {
                        LabeledEditorView.this.f15330h.b0("data10", 0);
                        LabeledEditorView.this.f15339q = false;
                        A.a aVar = LabeledEditorView.this.f15337o;
                        if (aVar instanceof KindSectionView) {
                            ((KindSectionView) aVar).u(false);
                        }
                    }
                    LabeledEditorView.this.A(true);
                    LabeledEditorView.this.D();
                    LabeledEditorView.this.y();
                    C1480a.c(LabeledEditorView.this.getContext(), ContactEditorFragment.r3(), LabeledEditorView.this.f15329g.f17004c);
                    this.f15347a.g();
                    return;
                }
                return;
            }
            this.f15347a.g();
        }

        @Override // Y0.a
        public void onCancel() {
            this.f15347a.g();
            LabeledEditorView.this.A(false);
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!LabeledEditorView.this.f15338p) {
                LabeledEditorView.this.K();
            }
        }
    }

    public LabeledEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15323a = false;
        this.f15333k = true;
        this.f15338p = true;
        this.f15339q = false;
        this.f15322A = new a();
        r(context);
    }

    private void H() {
        boolean z10;
        if (this.f15333k) {
            ImageView imageView = this.f15328f;
            if (!this.f15332j && isEnabled()) {
                z10 = true;
            } else {
                z10 = false;
            }
            imageView.setEnabled(z10);
            return;
        }
        this.f15327e.setVisibility(8);
    }

    private String getAccountNames() {
        HashSet d10 = com.google.common.collect.y.d();
        d10.add(this.f15330h.z("account_name"));
        ArrayList<EntityDelta.ValuesDelta> D10 = this.f15330h.D();
        if (D10 != null) {
            Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
            while (it.hasNext()) {
                d10.add(it.next().z("account_name"));
            }
        }
        return TextUtils.join("\" \"", d10);
    }

    private void r(Context context) {
        this.f15325c = context.getResources().getDimensionPixelSize(R.dimen.editor_min_line_item_height);
    }

    private void setupLabelButton(boolean z10) {
        boolean z11;
        if (z10) {
            SpinnerView spinnerView = this.f15326d;
            if (!this.f15332j && isEnabled()) {
                z11 = true;
            } else {
                z11 = false;
            }
            spinnerView.setEnabled(z11);
            this.f15326d.setVisibility(0);
            return;
        }
        this.f15326d.setVisibility(8);
    }

    private void t(EntityDelta.ValuesDelta valuesDelta) {
        if (valuesDelta == null) {
            return;
        }
        boolean booleanValue = valuesDelta.q("account_writable", Boolean.TRUE).booleanValue();
        this.f15338p = booleanValue;
        if (!booleanValue) {
            setOnClickListener(new d());
        }
    }

    public void A(boolean z10) {
        p();
        G();
        this.f15326d.setItemList(this.f15342y);
    }

    public void B() {
        g(this.f15329g, this.f15330h, this.f15331i, this.f15332j, this.f15336n);
    }

    public abstract void D();

    public void E(View view, int i10) {
        ImageView imageView = (ImageView) view.findViewById(R.id.left_icon_view);
        View findViewById = view.findViewById(R.id.editor_divider);
        if (i10 == 0) {
            imageView.setVisibility(0);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            F();
            return;
        }
        imageView.setVisibility(4);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
    }

    public final void F() {
        if ("vnd.android.cursor.item/phone_v2".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_call);
            return;
        }
        if ("vnd.android.cursor.item/email_v2".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_email);
            return;
        }
        if ("vnd.android.cursor.item/contact_event".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_event);
            return;
        }
        if ("vnd.android.cursor.item/relation".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_relation);
            return;
        }
        if ("vnd.android.cursor.item/note".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_note);
            return;
        }
        if ("vnd.android.cursor.item/im".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_im);
            return;
        }
        if ("vnd.android.cursor.item/postal-address_v2".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_address);
        } else if ("vnd.android.cursor.item/website".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_web);
        } else if ("vnd.android.cursor.item/nickname".equals(this.f15329g.f17004c)) {
            this.f15340r.setImageResource(R.drawable.pb_ic_nickname);
        }
    }

    public final void G() {
        if (this.f15335m != null) {
            String string = getContext().getString(this.f15335m.f16961b);
            String str = this.f15335m.f16964e;
            if (str != null) {
                string = this.f15330h.z(str);
            }
            this.f15326d.setText(string);
        }
    }

    public abstract void I(View view);

    public abstract void J();

    public void K() {
        A.a aVar = this.f15337o;
        if (aVar != null) {
            aVar.e(getAccountNames());
        }
    }

    @Override // com.android.contacts.editor.A
    public void a() {
        this.f15330h.Y();
        if (getTag() != null && (getTag() instanceof KindSectionView.e)) {
            ((KindSectionView.e) getTag()).b();
        }
    }

    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        boolean z11;
        t(valuesDelta);
        this.f15329g = cVar;
        this.f15330h = valuesDelta;
        this.f15331i = entityDelta;
        this.f15332j = z10;
        this.f15336n = viewIdGenerator;
        setId(viewIdGenerator.d(entityDelta, cVar, valuesDelta, -1));
        s(valuesDelta, cVar, entityDelta);
        if (!valuesDelta.R()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        boolean q10 = com.android.contacts.model.d.q(cVar);
        setupLabelButton(q10);
        SpinnerView spinnerView = this.f15326d;
        if (!z10 && isEnabled()) {
            z11 = true;
        } else {
            z11 = false;
        }
        spinnerView.setEnabled(z11);
        if (q10) {
            this.f15335m = com.android.contacts.model.d.h(valuesDelta, cVar);
            A(false);
        }
    }

    public EntityDelta.ValuesDelta getEntry() {
        return this.f15330h;
    }

    public com.android.contacts.model.c getKind() {
        return this.f15329g;
    }

    public AccountType.c getType() {
        return this.f15335m;
    }

    public final void n(ArrayList<PopupListItem> arrayList, AccountType.c cVar) {
        String string;
        boolean z10;
        if (this.f15339q && cVar.f16960a == 3) {
            string = getContext().getString(R.string.event_type_birthday_chinese);
        } else {
            string = getContext().getString(cVar.f16961b);
        }
        if (cVar == this.f15335m) {
            z10 = true;
        } else {
            z10 = false;
        }
        arrayList.add(com.android.contacts.framework.baseui.util.q.b(string, true, z10));
    }

    public final void o() {
        U0.h hVar = new U0.h();
        hVar.k(hVar.o(getContext(), R.layout.bottom_dialog_layout_with_edit_text, new c(hVar), getContext().getString(R.string.customLabelPickerTitle), getContext().getString(R.string.cancel), getContext().getString(R.string.dialog_ok)), true, getContext().getString(R.string.oplus_hint_please_input_label), true);
        hVar.j().setInputType(8193);
        hVar.j().setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        hVar.j().setSaveEnabled(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f15334l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15334l = false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        SpinnerView spinnerView = (SpinnerView) findViewById(R.id.spinner);
        this.f15326d = spinnerView;
        spinnerView.setOnItemSelectedListener(this.f15322A);
        this.f15326d.setClickable(true);
        this.f15328f = (ImageView) findViewById(R.id.delete_button);
        View findViewById = findViewById(R.id.delete_button_container);
        this.f15327e = findViewById;
        findViewById.setOnClickListener(new b());
        this.f15340r = (ImageView) findViewById(R.id.left_icon_view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f15338p) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void p() {
        String str;
        String str2;
        this.f15341x = new ArrayList<>();
        this.f15342y = new ArrayList<>();
        AccountType.c cVar = this.f15335m;
        AccountType.c cVar2 = null;
        if (cVar != null && (str2 = cVar.f16964e) != null) {
            str = this.f15330h.z(str2);
            if (str != null) {
                cVar2 = f15321B;
                this.f15343z = true;
            }
        } else {
            str = "";
        }
        ArrayList<AccountType.c> m10 = com.android.contacts.model.d.m(this.f15331i, this.f15329g, this.f15335m);
        Iterator<AccountType.c> it = m10.iterator();
        while (it.hasNext()) {
            AccountType.c next = it.next();
            if (next == m10.get(m10.size() - 1)) {
                if (cVar2 == null) {
                    this.f15341x.add(next);
                    n(this.f15342y, next);
                }
            } else {
                if (this.f15329g.f17004c.equals("vnd.android.cursor.item/contact_event") && next.f16960a == 3) {
                    next.f16961b = i0.l.c(3);
                }
                this.f15341x.add(next);
                n(this.f15342y, next);
            }
        }
        if (cVar2 != null) {
            this.f15341x.add(cVar2);
            this.f15342y.add(com.android.contacts.framework.baseui.util.q.b(str, true, true));
        }
    }

    public abstract void q(View view);

    public void s(EntityDelta.ValuesDelta valuesDelta, com.android.contacts.model.c cVar, EntityDelta entityDelta) {
        if ("vnd.android.cursor.item/contact_event".equals(cVar.f17004c)) {
            try {
                Integer v10 = valuesDelta.v(cVar.f17015n);
                if (v10 != null && 3 == v10.intValue()) {
                    boolean z10 = false;
                    Integer w10 = valuesDelta.w("data10", 0);
                    if (w10 != null && w10.intValue() == 1000) {
                        z10 = true;
                    }
                    setIsLunarBirthday(z10);
                }
            } catch (Exception e10) {
                H7.b.c("LabeledEditorView", "initIsLunarBirthday error" + e10);
            }
        }
    }

    public void setActivityResultManeger(com.customize.contacts.manager.z zVar) {
        this.f15324b = zVar;
    }

    public void setChildViewVisibilityAndSrc(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.left_icon_view);
            View findViewById = childAt.findViewById(R.id.editor_divider);
            if (imageView == null) {
                H7.b.c("LabeledEditorView", "leftIconResetVisibility not find left icon");
                return;
            }
            if (i10 == 0) {
                imageView.setVisibility(0);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                if (childAt instanceof LabeledEditorView) {
                    ((LabeledEditorView) childAt).F();
                }
            } else {
                imageView.setVisibility(4);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
            }
        }
    }

    @Override // com.android.contacts.editor.A
    public void setDeletable(boolean z10) {
        this.f15333k = z10;
        H();
    }

    public void setDeleteButtonVisible(boolean z10) {
        int i10;
        if (this.f15333k && !"vnd.android.cursor.item/relation".equals(this.f15329g.f17004c)) {
            View view = this.f15327e;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            view.setVisibility(i10);
        }
    }

    @Override // com.android.contacts.editor.A
    public void setEditorListener(A.a aVar) {
        this.f15337o = aVar;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        boolean z11;
        super.setEnabled(z10);
        SpinnerView spinnerView = this.f15326d;
        boolean z12 = false;
        if (!this.f15332j && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        spinnerView.setEnabled(z11);
        ImageView imageView = this.f15328f;
        if (!this.f15332j && z10) {
            z12 = true;
        }
        imageView.setEnabled(z12);
    }

    public void setIsLunarBirthday(boolean z10) {
        this.f15339q = z10;
    }

    public boolean u(String str, String str2) {
        String z10 = this.f15330h.z(str);
        if (z10 == null) {
            z10 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return !TextUtils.equals(z10, str2);
    }

    public boolean v() {
        Iterator<EntityDelta.ValuesDelta> it = this.f15331i.D(this.f15329g.f17004c).iterator();
        while (it.hasNext()) {
            if (!TextUtils.isEmpty(it.next().z("data1"))) {
                return false;
            }
        }
        return true;
    }

    public boolean w() {
        return this.f15332j;
    }

    public void x(String str, String str2) {
        if (!u(str, str2)) {
            return;
        }
        this.f15330h.e0(str, str2.trim());
        A.a aVar = this.f15337o;
        if (aVar != null) {
            aVar.c(2);
        }
        boolean isEmpty = isEmpty();
        if (this.f15323a != isEmpty) {
            if (isEmpty) {
                A.a aVar2 = this.f15337o;
                if (aVar2 != null) {
                    aVar2.c(3);
                }
            } else {
                A.a aVar3 = this.f15337o;
                if (aVar3 != null) {
                    aVar3.c(4);
                }
            }
            this.f15323a = isEmpty;
        }
        C1480a.e(getContext(), ContactEditorFragment.r3(), this.f15331i.C(), str, this.f15329g.f17004c);
    }

    public void z(int i10) {
        AccountType.c cVar;
        A.a aVar;
        if (i10 >= this.f15341x.size() || (cVar = this.f15341x.get(i10)) == null) {
            return;
        }
        AccountType.c cVar2 = this.f15335m;
        if (cVar2 != null && cVar2 == cVar && cVar2.f16964e == null) {
            return;
        }
        boolean z10 = true;
        if (cVar.f16964e == null && (!this.f15343z || cVar != f15321B)) {
            this.f15335m = cVar;
            this.f15330h.b0(this.f15329g.f17015n, cVar.f16960a);
            if ("vnd.android.cursor.item/contact_event".equals(this.f15329g.f17004c)) {
                this.f15330h.b0("data10", 0);
                this.f15339q = false;
            }
            A(true);
            D();
            y();
            C1480a.c(getContext(), ContactEditorFragment.r3(), this.f15329g.f17004c);
        } else {
            o();
        }
        if ((this instanceof EventFieldEditorView) && (aVar = this.f15337o) != null && (aVar instanceof KindSectionView)) {
            KindSectionView kindSectionView = (KindSectionView) aVar;
            if (this.f15335m.f16960a != 3) {
                z10 = false;
            }
            kindSectionView.u(z10);
        }
    }

    public void C() {
    }

    public void y() {
    }
}
