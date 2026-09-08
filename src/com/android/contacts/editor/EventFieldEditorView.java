package com.android.contacts.editor;

import C3.a;
import Z3.g;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.android.contacts.editor.A;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.lunarutil.COUILunarUtil;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.N;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.widget.COUIDatePicker;
import com.customize.contacts.widget.COUILunarDatePicker;
import com.customize.contacts.widget.EditEventDatePicker;
import com.customize.contacts.widget.LocalDatePicker;
import com.customize.contacts.widget.LocalLunarDatePicker;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class EventFieldEditorView extends LabeledEditorView {

    /* renamed from: C, reason: collision with root package name */
    public long f15224C;

    /* renamed from: D, reason: collision with root package name */
    public long f15225D;

    /* renamed from: E, reason: collision with root package name */
    public LocalLunarDatePicker f15226E;

    /* renamed from: F, reason: collision with root package name */
    public LocalDatePicker f15227F;

    /* renamed from: G, reason: collision with root package name */
    public g.c f15228G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f15229H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f15230I;

    /* renamed from: J, reason: collision with root package name */
    public String f15231J;

    /* renamed from: K, reason: collision with root package name */
    public COUIEditText f15232K;

    /* renamed from: L, reason: collision with root package name */
    public View f15233L;

    /* renamed from: M, reason: collision with root package name */
    public COUIEditText f15234M;

    /* renamed from: N, reason: collision with root package name */
    public C3.a f15235N;

    /* renamed from: O, reason: collision with root package name */
    public ViewStub f15236O;

    /* renamed from: P, reason: collision with root package name */
    public TextView f15237P;

    /* renamed from: Q, reason: collision with root package name */
    public EditEventDatePicker f15238Q;

    /* renamed from: R, reason: collision with root package name */
    public EditEventDatePicker f15239R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f15240S;

    /* renamed from: T, reason: collision with root package name */
    public int f15241T;

    /* renamed from: U, reason: collision with root package name */
    public int f15242U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f15243V;

    /* renamed from: W, reason: collision with root package name */
    public Handler f15244W;

    /* loaded from: classes.dex */
    public class a implements LocalDatePicker.a {
        public a() {
        }

        @Override // com.customize.contacts.widget.LocalDatePicker.a
        public void a() {
            EventFieldEditorView.this.f15244W.removeMessages(1);
            EventFieldEditorView.this.f15244W.sendEmptyMessageDelayed(1, 500L);
        }
    }

    /* loaded from: classes.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            EventFieldEditorView.this.f15232K.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            EventFieldEditorView.this.f15232K.setText(EventFieldEditorView.this.f15232K.getText());
        }
    }

    /* loaded from: classes.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(false);
            EventFieldEditorView.this.f15237P.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(false);
            EventFieldEditorView.this.f15237P.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(true);
            EventFieldEditorView.this.f15237P.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(false);
            EventFieldEditorView.this.f15237P.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            EventFieldEditorView.this.setReminderOccupied(true);
        }
    }

    /* loaded from: classes.dex */
    public class g extends Handler {
        public g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2 && EventFieldEditorView.this.f15228G != null && EventFieldEditorView.this.f15228G.h() != 0) {
                    EventFieldEditorView eventFieldEditorView = EventFieldEditorView.this;
                    eventFieldEditorView.r0(eventFieldEditorView.f15228G.h(), EventFieldEditorView.this.f15228G.g() + 1, EventFieldEditorView.this.f15228G.e());
                    return;
                }
                return;
            }
            if (EventFieldEditorView.this.f15228G != null && EventFieldEditorView.this.f15228G.h() != 0) {
                EventFieldEditorView eventFieldEditorView2 = EventFieldEditorView.this;
                eventFieldEditorView2.s0(eventFieldEditorView2.f15228G.h(), EventFieldEditorView.this.f15228G.g(), EventFieldEditorView.this.f15228G.e());
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnFocusChangeListener {
        public h() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            EventFieldEditorView.this.p0(z10);
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C7.a.a()) {
                EventFieldEditorView.this.u0();
                EventFieldEditorView.this.y0();
                EventFieldEditorView.this.q0();
                EventFieldEditorView.this.f15232K.requestFocus();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements ViewTreeObserver.OnGlobalLayoutListener {

        /* loaded from: classes.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z10) {
                if (z10) {
                    EventFieldEditorView.this.d0();
                    EventFieldEditorView.this.u0();
                    EventFieldEditorView.this.f15232K.requestFocus();
                } else {
                    if (EventFieldEditorView.this.f15226E != null && EventFieldEditorView.this.f15229H) {
                        EventFieldEditorView.this.i0(true);
                    }
                    if (EventFieldEditorView.this.f15227F != null && EventFieldEditorView.this.f15230I) {
                        EventFieldEditorView.this.i0(false);
                    }
                    EventFieldEditorView.this.q0();
                }
                EventFieldEditorView.this.y0();
            }
        }

        public j() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            EventFieldEditorView.this.f15232K.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            EventFieldEditorView eventFieldEditorView = EventFieldEditorView.this;
            A.a aVar = eventFieldEditorView.f15337o;
            if (aVar instanceof KindSectionView) {
                ((KindSectionView) aVar).z(eventFieldEditorView);
            }
            EventFieldEditorView.this.f15232K.setOnFocusChangeListener(new a());
        }
    }

    /* loaded from: classes.dex */
    public class m implements COUILunarDatePicker.c {
        public m() {
        }

        @Override // com.customize.contacts.widget.COUILunarDatePicker.c
        public void a(COUILunarDatePicker cOUILunarDatePicker, int i10, int i11, int i12) {
            EventFieldEditorView.this.f15228G.m(i10);
            EventFieldEditorView.this.f15228G.l(i11);
            EventFieldEditorView.this.f15228G.k(i12);
            if (EventFieldEditorView.this.f15226E.x()) {
                EventFieldEditorView.this.f15244W.removeMessages(2);
                EventFieldEditorView.this.f15244W.sendEmptyMessageDelayed(2, 500L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements LocalLunarDatePicker.a {
        public n() {
        }

        @Override // com.customize.contacts.widget.LocalLunarDatePicker.a
        public void a() {
            EventFieldEditorView.this.f15244W.removeMessages(2);
            EventFieldEditorView.this.f15244W.sendEmptyMessageDelayed(2, 500L);
        }
    }

    /* loaded from: classes.dex */
    public class o implements COUIDatePicker.d {
        public o() {
        }

        @Override // com.customize.contacts.widget.COUIDatePicker.d
        public void a(COUIDatePicker cOUIDatePicker, int i10, int i11, int i12) {
            EventFieldEditorView.this.f15228G.m(i10);
            EventFieldEditorView.this.f15228G.l(i11);
            EventFieldEditorView.this.f15228G.k(i12);
            if (EventFieldEditorView.this.f15227F.z()) {
                EventFieldEditorView.this.f15244W.removeMessages(1);
                EventFieldEditorView.this.f15244W.sendEmptyMessageDelayed(1, 500L);
            }
        }
    }

    public EventFieldEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15224C = 0L;
        this.f15225D = 0L;
        this.f15229H = false;
        this.f15230I = false;
        this.f15244W = new g();
        this.f15235N = new C3.a();
    }

    private String getBirthdayData() {
        int i10;
        A.a aVar = this.f15337o;
        if (aVar instanceof KindSectionView) {
            KindSectionView kindSectionView = (KindSectionView) aVar;
            int editorCount = kindSectionView.getEditorCount();
            ViewGroup viewGroup = (ViewGroup) kindSectionView.findViewById(R.id.kind_editors);
            if (getType() == null) {
                H7.b.b("EventFieldEditorView", "getType==null");
                return null;
            }
            int i11 = getType().f16960a;
            if (i11 == 3 || i11 == 1000) {
                for (int i12 = 0; i12 < editorCount - 2; i12++) {
                    AccountType.d type = ((EventFieldEditorView) viewGroup.getChildAt(i12)).getType();
                    if (type != null && ((i10 = type.f16960a) == 3 || i10 == 1000)) {
                        String z10 = ((EventFieldEditorView) viewGroup.getChildAt(i12)).getEntry().z("data1");
                        if (H7.a.b()) {
                            H7.b.b("EventFieldEditorView", "getBirthdayData: result = " + z10);
                        }
                        if (z10.startsWith("1900")) {
                            return null;
                        }
                        return z10;
                    }
                }
            }
        }
        return null;
    }

    public static int getDefaultHourForBirthday() {
        return 8;
    }

    public static boolean l0(Context context) {
        if (FeatureOption.i() && M7.a.h(context, "com.oplus.calendar", "date_year_ignorable", "true")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReminderOccupied(boolean z10) {
        if (z10) {
            this.f15237P.setAlpha(1.0f);
            this.f15237P.setHeight(this.f15242U);
        } else {
            this.f15237P.setAlpha(0.0f);
            this.f15237P.setHeight(0);
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void A(boolean z10) {
        super.A(z10);
        if (z10) {
            o0();
            Integer v10 = getEntry().v("data2");
            if (v10 != null && 1000 == v10.intValue()) {
                this.f15239R.setVisibility(8);
                this.f15239R.setExpanded(false);
                this.f15230I = false;
            } else {
                this.f15238Q.setVisibility(8);
                this.f15238Q.setExpanded(false);
                this.f15229H = false;
            }
            y0();
            q0();
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void D() {
        this.f15232K.requestFocus();
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void I(View view) {
        C3.a aVar = this.f15235N;
        if (aVar != null) {
            aVar.r(this.f15233L, this.f15234M);
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void J() {
        COUIEditText cOUIEditText = this.f15234M;
        if (cOUIEditText != null) {
            cOUIEditText.setVisibility(8);
        }
        View view = this.f15233L;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.android.contacts.editor.A
    public void c() {
        this.f15232K.setText((CharSequence) null);
        this.f15232K.setHint(this.f15231J);
        if (this.f15226E != null && this.f15229H) {
            i0(true);
        }
        if (this.f15227F != null && this.f15230I) {
            i0(false);
        }
        x(getKind().f17018q.get(0).f16953a, "");
    }

    public final void d0() {
        A.a aVar = this.f15337o;
        if (aVar instanceof KindSectionView) {
            KindSectionView kindSectionView = (KindSectionView) aVar;
            int editorCount = kindSectionView.getEditorCount();
            ViewGroup viewGroup = (ViewGroup) kindSectionView.findViewById(R.id.kind_editors);
            if (viewGroup != null && viewGroup.getChildAt(editorCount - 1) == this) {
                ((KindSectionView) this.f15337o).j(false, true);
            }
        }
    }

    public final void e0(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z10) {
            if (this.f15238Q.a()) {
                arrayList.add(f0(this.f15238Q, z10));
                this.f15229H = false;
            } else {
                if (this.f15239R.a()) {
                    arrayList.add(f0(this.f15239R, z10));
                    this.f15230I = false;
                }
                this.f15229H = true;
                arrayList.add(g0(this.f15238Q));
            }
        } else if (this.f15239R.a()) {
            arrayList.add(f0(this.f15239R, z10));
            this.f15230I = false;
        } else {
            if (this.f15238Q.a()) {
                arrayList.add(f0(this.f15238Q, z10));
                this.f15229H = false;
            }
            this.f15230I = true;
            arrayList.add(g0(this.f15239R));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    public final Animator f0(EditEventDatePicker editEventDatePicker, boolean z10) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(editEventDatePicker, "height", getContext().getResources().getDimensionPixelSize(R.dimen.coui_time_picker_height), 0);
        ofInt.addListener(new b(editEventDatePicker, z10));
        return ofInt;
    }

    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.A
    public void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        boolean z11 = true;
        if (cVar.f17018q.size() != 1) {
            H7.b.c("EventFieldEditorView", "kind must have 1 field");
        }
        if (cVar.f17017p != null) {
            int i10 = -1;
            for (int i11 = 0; i11 < cVar.f17017p.size(); i11++) {
                if (cVar.f17017p.get(i11).f16960a == 1000) {
                    i10 = i11;
                }
            }
            if (B3.a.P()) {
                if (i10 < 0) {
                    cVar.f17017p.add(1, new AccountType.d(1000, R.string.event_type_birthday_chinese).c(1));
                }
            } else if (i10 >= 0) {
                cVar.f17017p.remove(i10);
            }
        }
        super.g(cVar, valuesDelta, entityDelta, z10, viewIdGenerator);
        boolean z12 = !TextUtils.isEmpty(valuesDelta.z(getKind().f17018q.get(0).f16953a));
        this.f15240S = z12;
        setDeleteButtonVisible(z12);
        COUIEditText cOUIEditText = this.f15232K;
        if (!isEnabled() || z10) {
            z11 = false;
        }
        cOUIEditText.setEnabled(z11);
        o0();
    }

    public final Animator g0(EditEventDatePicker editEventDatePicker) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(editEventDatePicker, "height", 0, getContext().getResources().getDimensionPixelSize(R.dimen.coui_time_picker_height));
        ofInt.addListener(new c(editEventDatePicker));
        return ofInt;
    }

    public final void h0(String str, int i10) {
        if (F7.b.j(i10) && !TextUtils.equals(str, this.f15232K.getText().toString())) {
            A.a aVar = this.f15337o;
            if (aVar instanceof KindSectionView) {
                ((KindSectionView) aVar).A(this);
            }
        }
    }

    public final void i0(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(f0(this.f15238Q, z10));
            this.f15229H = false;
        } else {
            arrayList.add(f0(this.f15239R, z10));
            this.f15230I = false;
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    @Override // com.android.contacts.editor.A
    public boolean isEmpty() {
        return TextUtils.isEmpty(this.f15232K.getText());
    }

    public void j0(EntityDelta.ValuesDelta valuesDelta, com.android.contacts.model.c cVar) {
        String z10 = valuesDelta.z("data1");
        Integer v10 = valuesDelta.v("data2");
        if (v10 != null) {
            this.f15241T = v10.intValue();
        }
        t0(z10);
        SoftKeyboardUtil.a().b(this);
    }

    public void k0() {
        if (!m0()) {
            return;
        }
        w0();
        getEntry().b0("showReminder", 0);
    }

    public boolean m0() {
        TextView textView = this.f15237P;
        if (textView != null && textView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void n0(int i10) {
        boolean z10;
        if (i10 == getEntry().w("data10", 0).intValue()) {
            return;
        }
        getEntry().b0("data10", i10);
        if (getType().f16960a == 3) {
            if (i10 == 1000) {
                z10 = true;
            } else {
                z10 = false;
            }
            setIsLunarBirthday(z10);
        }
        A(false);
    }

    public final void o0() {
        String b10;
        String str = getKind().f17018q.get(0).f16953a;
        Integer v10 = getEntry().v("data2");
        if (v10 != null && 1000 == v10.intValue()) {
            Date r10 = F7.b.r(getEntry().z(str));
            if (r10 != null) {
                if (this.f15243V && F7.b.m(r10, 1902)) {
                    b10 = N.g(getContext(), Calendar.getInstance().get(1), r10.getMonth() + 1, r10.getDate(), false, this.f15243V);
                } else {
                    b10 = N.h(getContext(), r10.getYear() + COUIDateMonthView.MIN_YEAR, r10.getMonth() + 1, r10.getDate());
                }
            } else {
                b10 = null;
            }
        } else {
            b10 = F7.b.b(getContext(), getEntry().z(str));
        }
        if (b10 != null && v10 != null) {
            h0(b10, v10.intValue());
        }
        if (TextUtils.isEmpty(b10)) {
            this.f15232K.setHint(this.f15231J);
        } else {
            this.f15232K.setText(b10);
            this.f15232K.setTextAppearance(R.style.LargeTextStyle);
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15231J = getContext().getString(R.string.event_edit_field_hint_text);
        this.f15243V = l0(getContext());
        this.f15233L = findViewById(R.id.spinner_editor_view);
        this.f15234M = (COUIEditText) findViewById(R.id.replaced_edit_field);
        this.f15236O = (ViewStub) findViewById(R.id.view_stub);
        COUIEditText cOUIEditText = this.f15234M;
        if (cOUIEditText != null) {
            cOUIEditText.setInputType(0);
            this.f15234M.setOnFocusChangeListener(new h());
            this.f15234M.setHint(this.f15231J);
        }
        COUIEditText cOUIEditText2 = (COUIEditText) findViewById(R.id.date_view);
        this.f15232K = cOUIEditText2;
        cOUIEditText2.setSaveEnabled(false);
        this.f15238Q = (EditEventDatePicker) findViewById(R.id.lunar_date_picker);
        this.f15239R = (EditEventDatePicker) findViewById(R.id.solar_date_picker);
        this.f15232K.setOnClickListener(new i());
        this.f15232K.getViewTreeObserver().addOnGlobalLayoutListener(new j());
        this.f15232K.addTextChangedListener(new k());
        this.f15228G = new g.c(0, 0, 0);
        this.f15240S = false;
    }

    public final void p0(boolean z10) {
        if (z10 && this.f15233L.getVisibility() == 8) {
            this.f15235N.g(new l());
            this.f15235N.r(this.f15233L, this.f15234M);
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void q(View view) {
        C3.a aVar = this.f15235N;
        if (aVar != null) {
            aVar.j(this.f15233L, this.f15234M);
        }
    }

    public final void q0() {
        this.f15232K.getViewTreeObserver().addOnGlobalLayoutListener(new d());
    }

    public final void r0(int i10, int i11, int i12) {
        String a10 = g.c.a(i10, i11, i12);
        String c10 = g.c.c(i10, i11, i12);
        if (!TextUtils.isEmpty(a10)) {
            n0(1000);
            x(getKind().f17018q.get(0).f16953a, c10);
        }
        if (this.f15232K != null) {
            o0();
        }
    }

    public final void s0(int i10, int i11, int i12) {
        int i13 = i11 + 1;
        String a10 = g.c.a(i10, i13, i12);
        String c10 = g.c.c(i10, i13, i12);
        if (!TextUtils.isEmpty(a10)) {
            n0(0);
            x(getKind().f17018q.get(0).f16953a, c10);
        }
        if (this.f15232K != null) {
            o0();
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    public void setEnabled(boolean z10) {
        boolean z11;
        super.setEnabled(z10);
        COUIEditText cOUIEditText = this.f15232K;
        if (!w() && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        cOUIEditText.setEnabled(z11);
    }

    public final void t0(String str) {
        int i10;
        int i11;
        int i12;
        int i13;
        Calendar calendar = Calendar.getInstance();
        int i14 = calendar.get(1);
        String birthdayData = getBirthdayData();
        if (H7.a.b()) {
            H7.b.b("EventFieldEditorView", "showCurrentDatePicker: mFieldHasChanged = " + this.f15240S);
        }
        if (!this.f15240S && F7.b.j(this.f15241T) && !TextUtils.isEmpty(birthdayData)) {
            g.c d10 = g.c.d(birthdayData);
            i10 = d10.h();
            i11 = d10.g() - 1;
            i12 = d10.e();
        } else if (!TextUtils.isEmpty(str)) {
            g.c d11 = g.c.d(str);
            i10 = d11.h();
            i11 = d11.g() - 1;
            i12 = d11.e();
        } else {
            if (F7.b.j(this.f15241T) && this.f15243V) {
                i10 = 1900;
            } else {
                i10 = calendar.get(1);
            }
            i11 = calendar.get(2);
            i12 = calendar.get(5);
        }
        if (i10 == 1900) {
            i13 = Integer.MIN_VALUE;
        } else if (i10 > i14) {
            i14 = i10;
            i13 = i14;
        } else {
            i13 = i10;
        }
        if (this.f15241T == 1000) {
            if (this.f15226E == null || !this.f15238Q.a()) {
                LocalLunarDatePicker localLunarDatePicker = this.f15226E;
                if (localLunarDatePicker == null || localLunarDatePicker.getParent() != null) {
                    LocalLunarDatePicker localLunarDatePicker2 = (LocalLunarDatePicker) findViewById(R.id.local_lunar_date_picker);
                    this.f15226E = localLunarDatePicker2;
                    if (localLunarDatePicker2 == null) {
                        return;
                    } else {
                        localLunarDatePicker2.setYearSpinnerIgnorable(this.f15243V);
                    }
                }
                this.f15226E.setVisibility(0);
            }
            Date lunarToSolar = COUILunarUtil.lunarToSolar(1902, 1, 1, false);
            if (lunarToSolar != null) {
                this.f15226E.setMinDate(lunarToSolar.getTime());
            }
            int[] iArr = new int[3];
            if (i10 < calendar.get(1)) {
                N.c(iArr, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
                if (i10 == 1900 && TextUtils.isEmpty(str)) {
                    i11 = iArr[1] - 1;
                    i12 = iArr[2];
                }
            } else {
                N.c(iArr, i10, i11 + 1, i12);
            }
            int i15 = iArr[0];
            int f10 = D7.a.f(Integer.valueOf(i15), 12);
            if (H7.a.b()) {
                H7.b.b("EventFieldEditorView", "the lunar " + i15 + " year 12 month has " + f10 + " days.");
            }
            Date lunarToSolar2 = COUILunarUtil.lunarToSolar(i15, 12, f10, false);
            if (lunarToSolar2 != null) {
                this.f15226E.setMaxDate(lunarToSolar2.getTime());
            }
            this.f15226E.setCalendarViewShown(false);
            this.f15226E.r(i13, i11, i12, new m());
            if (TextUtils.isEmpty(str)) {
                r0(i10, i11 + 1, i12);
            }
            this.f15226E.setLunarDateChangeEndListener(new n());
            e0(true);
            com.android.contacts.framework.baseui.util.A.a(getContext(), 2000310, 200030211, null, false);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            s0(i10, i11, i12);
        }
        if (this.f15227F == null || !this.f15239R.a()) {
            LocalDatePicker localDatePicker = this.f15227F;
            if (localDatePicker == null || localDatePicker.getParent() != null) {
                LocalDatePicker localDatePicker2 = (LocalDatePicker) findViewById(R.id.local_date_picker);
                this.f15227F = localDatePicker2;
                if (localDatePicker2 == null) {
                    return;
                } else {
                    localDatePicker2.setYearSpinnerIgnorable(this.f15243V);
                }
            }
            this.f15227F.setVisibility(0);
        }
        calendar.set(1902, 1, 1);
        this.f15224C = calendar.getTimeInMillis();
        calendar.set(i14, 11, 31);
        this.f15225D = calendar.getTimeInMillis();
        this.f15227F.setMinDate(this.f15224C);
        this.f15227F.setMaxDate(this.f15225D);
        this.f15227F.setCalendarViewShown(false);
        this.f15227F.q(i13, i11, i12, new o());
        this.f15227F.setDateChangeEndListener(new a());
        e0(false);
    }

    public final void u0() {
        j0(getEntry(), getKind());
    }

    public void v0() {
        if (m0()) {
            return;
        }
        if (this.f15236O.getParent() != null) {
            this.f15237P = (TextView) this.f15236O.inflate().findViewById(R.id.difference_reminder_text);
        }
        if (this.f15242U == 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.edit_left_icon_container_width);
            this.f15237P.measure(View.MeasureSpec.makeMeasureSpec((getWidth() - dimensionPixelSize) - getResources().getDimensionPixelSize(R.dimen.DP_24), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f15242U = this.f15237P.getMeasuredHeight();
        }
        x0();
        getEntry().b0("showReminder", 1);
    }

    public final void w0() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15237P, "alpha", 1.0f, 0.0f);
        animatorSet.play(ofFloat).with(ObjectAnimator.ofInt(this.f15237P, "height", this.f15242U, 0));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new f());
        animatorSet.start();
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void x(String str, String str2) {
        if (u(str, str2)) {
            this.f15240S = true;
        }
        super.x(str, str2);
    }

    public final void x0() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15237P, "alpha", 0.0f, 1.0f);
        animatorSet.play(ofFloat).with(ObjectAnimator.ofInt(this.f15237P, "height", 0, this.f15242U));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new e());
        animatorSet.start();
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void y() {
        String str = getKind().f17018q.get(0).f16953a;
        String z10 = getEntry().z(str);
        if (!getType().d() && !TextUtils.isEmpty(z10)) {
            x(str, z10);
            o0();
        }
        A.a aVar = this.f15337o;
        if (aVar instanceof KindSectionView) {
            ((KindSectionView) aVar).B(this);
        }
    }

    public void y0() {
        boolean z10;
        if (this.f15226E != null && this.f15229H) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f15227F != null && this.f15230I) {
            z10 = true;
        }
        if (this.f15232K != null) {
            if (!z10 && this.f15240S) {
                setDeleteButtonVisible(true);
            } else {
                setDeleteButtonVisible(false);
            }
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public AccountType.d getType() {
        return (AccountType.d) super.getType();
    }

    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditEventDatePicker f15246a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15247b;

        public b(EditEventDatePicker editEventDatePicker, boolean z10) {
            this.f15246a = editEventDatePicker;
            this.f15247b = z10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15246a.setExpanded(false);
            if (this.f15247b) {
                EventFieldEditorView.this.f15226E.t();
            } else {
                EventFieldEditorView.this.f15227F.u();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public class c implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditEventDatePicker f15249a;

        public c(EditEventDatePicker editEventDatePicker) {
            this.f15249a = editEventDatePicker;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f15249a.setVisibility(0);
            this.f15249a.setExpanded(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public class l implements a.b {
        public l() {
        }

        @Override // C3.a.b
        public void onAnimationCancel(Animator animator) {
            EventFieldEditorView.this.f15235N.q(this);
        }

        @Override // C3.a.b
        public void onAnimationEnd(Animator animator) {
            EventFieldEditorView.this.f15232K.requestFocus();
            EventFieldEditorView.this.f15235N.q(this);
        }

        @Override // C3.a.b
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // C3.a.b
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public class k implements TextWatcher {
        public k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EventFieldEditorView.this.y0();
            Integer v10 = EventFieldEditorView.this.getEntry().v("data2");
            if (v10 != null) {
                EventFieldEditorView.this.f15241T = v10.intValue();
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
