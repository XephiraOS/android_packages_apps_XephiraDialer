package com.android.contacts.editor;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.editor.A;
import com.android.contacts.editor.RawContactEditorView;
import com.android.contacts.framework.baseui.widget.SelectedCardView;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import q1.C1480a;

/* loaded from: classes.dex */
public class KindSectionView extends SelectedCardView implements A.a {

    /* renamed from: c, reason: collision with root package name */
    public com.customize.contacts.manager.z f15296c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<EntityDelta.ValuesDelta> f15297d;

    /* renamed from: e, reason: collision with root package name */
    public HashSet<Long> f15298e;

    /* renamed from: f, reason: collision with root package name */
    public ViewGroup f15299f;

    /* renamed from: g, reason: collision with root package name */
    public String f15300g;

    /* renamed from: h, reason: collision with root package name */
    public com.android.contacts.model.c f15301h;

    /* renamed from: i, reason: collision with root package name */
    public EntityDelta f15302i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15303j;

    /* renamed from: k, reason: collision with root package name */
    public ViewIdGenerator f15304k;

    /* renamed from: l, reason: collision with root package name */
    public LayoutInflater f15305l;

    /* renamed from: m, reason: collision with root package name */
    public int f15306m;

    /* renamed from: n, reason: collision with root package name */
    public int f15307n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15308o;

    /* renamed from: p, reason: collision with root package name */
    public RawContactEditorView.b f15309p;

    /* renamed from: q, reason: collision with root package name */
    public A f15310q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15311r;

    /* renamed from: x, reason: collision with root package name */
    public com.android.contacts.util.s f15312x;

    /* renamed from: y, reason: collision with root package name */
    public d f15313y;

    /* loaded from: classes.dex */
    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ A f15314a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f15315b;

        public a(A a10, View view) {
            this.f15314a = a10;
            this.f15315b = view;
        }

        @Override // com.android.contacts.editor.KindSectionView.e
        public void a() {
            KindSectionView.this.d(this.f15314a);
        }

        @Override // com.android.contacts.editor.KindSectionView.e
        public void b() {
            View findViewById;
            LabeledEditorView labeledEditorView;
            if (this.f15315b.hasFocus() && !TextUtils.equals(KindSectionView.this.f15301h.f17004c, "vnd.android.cursor.item/contact_event")) {
                KindSectionView kindSectionView = KindSectionView.this;
                kindSectionView.n(kindSectionView.f15299f, this.f15315b).requestFocus();
            }
            KindSectionView.this.f15299f.removeView(this.f15315b);
            if (KindSectionView.this.f15299f.getChildCount() == 1 && (labeledEditorView = (LabeledEditorView) KindSectionView.this.f15299f.getChildAt(0)) != null && (!labeledEditorView.hasWindowFocus() || !labeledEditorView.hasFocus())) {
                labeledEditorView.q(null);
            }
            if (KindSectionView.this.f15301h.f17004c.equals("vnd.android.cursor.item/contact_event")) {
                KindSectionView.this.f15306m--;
                if (KindSectionView.this.getEditorCount() > 0 && ((FeatureOption.i() || B3.a.x()) && (findViewById = KindSectionView.this.f15299f.getChildAt(0).findViewById(R.id.last_divider)) != null)) {
                    findViewById.setVisibility(0);
                }
            }
            if (KindSectionView.this.f15301h.f17004c.equals("vnd.android.cursor.item/email_v2")) {
                com.android.contacts.util.y.c().h(null, this.f15315b.getId());
            }
            View view = this.f15315b;
            if (view instanceof LabeledEditorView) {
                ((LabeledEditorView) view).setChildViewVisibilityAndSrc(KindSectionView.this.f15299f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {
        public b() {
        }

        @Override // com.android.contacts.editor.KindSectionView.d
        public void a(long j10) {
            KindSectionView.this.f15298e.remove(Long.valueOf(j10));
        }

        @Override // com.android.contacts.editor.KindSectionView.d
        public void b(long j10) {
            if (j10 != -1) {
                KindSectionView.this.f15298e.add(Long.valueOf(j10));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Date f15318a;

        /* renamed from: b, reason: collision with root package name */
        public Date f15319b;

        /* renamed from: c, reason: collision with root package name */
        public int f15320c;

        public Date a() {
            return this.f15318a;
        }

        public int b() {
            return this.f15320c;
        }

        public Date c() {
            return this.f15319b;
        }

        public boolean d() {
            if ((a() == null || c() == null) && b() > -1) {
                return true;
            }
            return false;
        }

        public void e(Date date) {
            this.f15318a = date;
        }

        public void f(int i10) {
            this.f15320c = i10;
        }

        public void g(Date date) {
            this.f15319b = date;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(long j10);

        void b(long j10);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    public KindSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15297d = new ArrayList<>();
        this.f15298e = new HashSet<>();
        this.f15306m = 0;
        this.f15307n = 0;
        this.f15308o = false;
        this.f15311r = false;
        this.f15313y = new b();
    }

    private void C() {
        int i10 = 0;
        if (!this.f15308o && getEditorCount() == 0) {
            i10 = 8;
        }
        if (getVisibility() != i10) {
            setVisibility(i10);
        }
    }

    private List<View> getEmptyEditors() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f15299f.getChildCount(); i10++) {
            KeyEvent.Callback childAt = this.f15299f.getChildAt(i10);
            if (((A) childAt).isEmpty()) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private boolean q(EntityDelta.ValuesDelta valuesDelta) {
        if (!valuesDelta.M()) {
            return false;
        }
        int size = this.f15301h.f17018q.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!TextUtils.isEmpty(valuesDelta.z(this.f15301h.f17018q.get(i10).f16953a))) {
                return false;
            }
        }
        return true;
    }

    public static boolean t(Date date, Date date2) {
        if (date == null || date2 == null || F7.b.m(date2, 1902) || F7.b.m(date, 1902) || F7.b.o(date, date2)) {
            return false;
        }
        return true;
    }

    public void A(EventFieldEditorView eventFieldEditorView) {
        EventFieldEditorView eventFieldEditorView2;
        c k10 = k();
        if (k10.b() > -1 && (eventFieldEditorView2 = (EventFieldEditorView) this.f15299f.getChildAt(k10.b())) != eventFieldEditorView) {
            eventFieldEditorView2.k0();
        }
        if (t(k10.a(), k10.c())) {
            eventFieldEditorView.v0();
        } else {
            eventFieldEditorView.k0();
        }
    }

    public void B(EventFieldEditorView eventFieldEditorView) {
        Integer v10 = eventFieldEditorView.getEntry().v("data2");
        if (v10 != null && this.f15299f != null) {
            c k10 = k();
            if (k10.d()) {
                ((EventFieldEditorView) this.f15299f.getChildAt(k10.b())).k0();
            } else if (F7.b.j(v10.intValue()) && t(k10.a(), k10.c())) {
                eventFieldEditorView.v0();
            }
        }
    }

    @Override // com.android.contacts.editor.A.a
    public void d(A a10) {
        if ("vnd.android.cursor.item/relation".equals(this.f15301h.f17004c) && (a10 instanceof TextFieldsEditorView)) {
            long j10 = ((TextFieldsEditorView) a10).f15418D;
            if (j10 != -1) {
                this.f15298e.add(Long.valueOf(j10));
            }
        }
        boolean z10 = true;
        if (getEditorCount() == 1) {
            a10.c();
        } else {
            a10.a();
        }
        if ("vnd.android.cursor.item/contact_event".equals(this.f15301h.f17004c) && (a10 instanceof EventFieldEditorView)) {
            LabeledEditorView labeledEditorView = (LabeledEditorView) a10;
            if (labeledEditorView.getType() != null) {
                if (labeledEditorView.getType().f16960a != 3) {
                    z10 = false;
                }
                u(z10);
            }
        }
        C1480a.d(getContext(), ContactEditorFragment.r3(), this.f15301h.f17004c);
    }

    @Override // com.android.contacts.editor.A.a
    public void e(String str) {
        RawContactEditorView.b bVar = this.f15309p;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public A getEditor() {
        return this.f15310q;
    }

    public int getEditorCount() {
        return this.f15299f.getChildCount();
    }

    public com.android.contacts.model.c getKind() {
        return this.f15301h;
    }

    public String getTitle() {
        return this.f15300g;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.android.contacts.model.c r0 = r6.f15301h
            int r1 = r0.f17016o
            java.lang.String r2 = "vnd.android.cursor.item/note"
            r3 = 1
            if (r1 != r3) goto L47
            java.lang.String r0 = r0.f17004c
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L1f
            com.android.contacts.model.c r0 = r6.f15301h
            java.lang.String r0 = r0.f17004c
            java.lang.String r1 = "vnd.android.cursor.item/nickname"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L26
        L1f:
            int r0 = r6.getEditorCount()
            if (r0 <= r3) goto L26
            return
        L26:
            int r0 = r6.getEditorCount()
            if (r0 != r3) goto L2d
            return
        L2d:
            com.android.contacts.model.EntityDelta r0 = r6.f15302i
            com.android.contacts.model.c r1 = r6.f15301h
            java.lang.String r1 = r1.f17004c
            java.util.ArrayList r0 = r0.D(r1)
            if (r0 == 0) goto L47
            int r1 = r0.size()
            if (r1 <= 0) goto L47
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.android.contacts.model.EntityDelta$ValuesDelta r0 = (com.android.contacts.model.EntityDelta.ValuesDelta) r0
            goto L48
        L47:
            r0 = 0
        L48:
            com.android.contacts.model.c r1 = r6.f15301h
            java.lang.String r1 = r1.f17004c
            java.lang.String r4 = "vnd.android.cursor.item/contact_event"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L5e
            int r1 = r6.getEditorCount()
            r5 = 20
            if (r1 < r5) goto L5e
            return
        L5e:
            com.android.contacts.model.c r1 = r6.f15301h
            java.lang.String r1 = r1.f17004c
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L73
            int r1 = r6.getEditorCount()
            com.android.contacts.model.c r2 = r6.f15301h
            int r2 = r2.f17016o
            if (r1 < r2) goto L73
            return
        L73:
            if (r0 == 0) goto L94
            boolean r1 = r0.P()
            if (r1 == 0) goto L7c
            goto L94
        L7c:
            com.android.contacts.model.c r1 = r6.f15301h
            java.lang.String r1 = r1.f17004c
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L9c
            int r0 = r6.f15306m
            int r0 = r0 + r3
            r6.f15306m = r0
            com.android.contacts.model.EntityDelta r0 = r6.f15302i
            com.android.contacts.model.c r1 = r6.f15301h
            com.android.contacts.model.EntityDelta$ValuesDelta r0 = com.android.contacts.model.d.t(r0, r1)
            goto L9c
        L94:
            com.android.contacts.model.EntityDelta r0 = r6.f15302i
            com.android.contacts.model.c r1 = r6.f15301h
            com.android.contacts.model.EntityDelta$ValuesDelta r0 = com.android.contacts.model.d.t(r0, r1)
        L9c:
            int r1 = r6.getEditorCount()
            android.view.View r1 = r6.m(r0, r1)
            boolean r2 = r1 instanceof com.android.contacts.editor.LabeledEditorView
            if (r2 == 0) goto Lb7
            if (r8 == 0) goto Lb1
            r8 = r1
            com.android.contacts.editor.LabeledEditorView r8 = (com.android.contacts.editor.LabeledEditorView) r8
            r8.I(r1)
            goto Lb7
        Lb1:
            r8 = r1
            com.android.contacts.editor.LabeledEditorView r8 = (com.android.contacts.editor.LabeledEditorView) r8
            r8.J()
        Lb7:
            boolean r8 = r0.K()
            if (r8 == 0) goto Lc2
            if (r7 == 0) goto Lc2
            r1.requestFocus()
        Lc2:
            r6.C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.KindSectionView.j(boolean, boolean):void");
    }

    public final c k() {
        int childCount = this.f15299f.getChildCount();
        Date date = null;
        int i10 = -1;
        Date date2 = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f15299f.getChildAt(i11);
            if (childAt instanceof EventFieldEditorView) {
                EventFieldEditorView eventFieldEditorView = (EventFieldEditorView) childAt;
                if (eventFieldEditorView.m0()) {
                    i10 = i11;
                }
                Integer v10 = eventFieldEditorView.getEntry().v("data2");
                String z10 = eventFieldEditorView.getEntry().z("data1");
                if (v10 != null && z10 != null) {
                    Date r10 = F7.b.r(z10);
                    if (v10.intValue() == 1000) {
                        date = r10;
                    } else if (v10.intValue() == 3) {
                        date2 = r10;
                    }
                }
            }
        }
        c cVar = new c();
        cVar.e(date);
        cVar.g(date2);
        cVar.f(i10);
        return cVar;
    }

    public final String l(com.android.contacts.model.c cVar, ContentValues contentValues, Context context) {
        CharSequence a10;
        AccountType.e eVar = cVar.f17013l;
        if (eVar == null || (a10 = eVar.a(context, contentValues)) == null) {
            return null;
        }
        return a10.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View m(EntityDelta.ValuesDelta valuesDelta, int i10) {
        AccountType.c type;
        try {
            boolean z10 = false;
            View inflate = this.f15305l.inflate(this.f15301h.f17002a, this.f15299f, false);
            inflate.setEnabled(isEnabled());
            if (inflate instanceof A) {
                A a10 = (A) inflate;
                this.f15310q = a10;
                if ((this.f15301h.f17004c.equals("vnd.android.cursor.item/note") && this.f15301h.f17016o != 20) || this.f15301h.f17004c.equals("vnd.android.cursor.item/nickname")) {
                    a10.setDeletable(false);
                } else {
                    a10.setDeletable(true);
                }
                boolean z11 = a10 instanceof TextFieldsEditorView;
                if (z11) {
                    TextFieldsEditorView textFieldsEditorView = (TextFieldsEditorView) a10;
                    textFieldsEditorView.setIsProfile(this.f15311r);
                    textFieldsEditorView.setOnReadyToContentAssociateListener(this.f15312x);
                }
                a10.g(this.f15301h, valuesDelta, this.f15302i, this.f15303j, this.f15304k);
                a10.setEditorListener(this);
                inflate.setTag(new a(a10, inflate));
                if (z11) {
                    ((TextFieldsEditorView) a10).i0();
                }
                if (inflate instanceof LabeledEditorView) {
                    ((LabeledEditorView) inflate).E(inflate, i10);
                }
                if ("vnd.android.cursor.item/relation".equals(this.f15301h.f17004c) && (inflate instanceof TextFieldsEditorView)) {
                    TextFieldsEditorView textFieldsEditorView2 = (TextFieldsEditorView) inflate;
                    textFieldsEditorView2.setActivityResultManeger(this.f15296c);
                    textFieldsEditorView2.setRelationStub(this.f15313y);
                }
                this.f15299f.addView(inflate);
                if (this.f15299f.getVisibility() != 0) {
                    this.f15299f.setVisibility(0);
                }
            } else {
                if ("vnd.android.cursor.item/relation".equals(this.f15301h.f17004c) && (inflate instanceof TextFieldsEditorView)) {
                    TextFieldsEditorView textFieldsEditorView3 = (TextFieldsEditorView) inflate;
                    textFieldsEditorView3.setActivityResultManeger(this.f15296c);
                    textFieldsEditorView3.setRelationStub(this.f15313y);
                }
                this.f15299f.addView(inflate);
                if (this.f15299f.getVisibility() != 0) {
                    this.f15299f.setVisibility(0);
                }
            }
            if ((inflate instanceof EventFieldEditorView) && (type = ((LabeledEditorView) inflate).getType()) != null) {
                if (type.f16960a == 3) {
                    z10 = true;
                }
                u(z10);
            }
            return inflate;
        } catch (Exception e10) {
            throw new RuntimeException("Cannot allocate editor with layout resource ID " + this.f15301h.f17002a + " for MIME type " + this.f15301h.f17004c + " with error " + e10.toString());
        }
    }

    public final View n(ViewGroup viewGroup, View view) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != view && !childAt.hasFocus()) {
                return childAt;
            }
        }
        return view;
    }

    public final boolean o() {
        if (getEmptyEditors().size() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        this.f15305l = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f15299f = (ViewGroup) findViewById(R.id.kind_editors);
    }

    public void p() {
        c k10 = k();
        if (k10.d()) {
            ((EventFieldEditorView) this.f15299f.getChildAt(k10.b())).k0();
        }
    }

    public final boolean r(EntityDelta.ValuesDelta valuesDelta) {
        String asString;
        String asString2;
        String asString3;
        String asString4;
        String asString5;
        String asString6;
        String asString7;
        String asString8;
        String asString9;
        String asString10;
        boolean z10;
        boolean z11;
        String asString11;
        boolean z12;
        boolean z13;
        String asString12;
        String asString13;
        String asString14;
        String asString15;
        String asString16;
        String asString17;
        String asString18;
        String asString19;
        if (valuesDelta.P()) {
            return true;
        }
        ArrayList<EntityDelta.ValuesDelta> arrayList = this.f15297d;
        if (arrayList != null) {
            Iterator<EntityDelta.ValuesDelta> it = arrayList.iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (this.f15302i.R() && (TextUtils.equals(l(this.f15301h, valuesDelta.p(), getContext()), l(this.f15301h, next.p(), getContext())) || !this.f15302i.e0())) {
                    if (TextUtils.equals(l(this.f15301h, valuesDelta.A(), getContext()), l(this.f15301h, next.A(), getContext()))) {
                        String str = null;
                        if (TextUtils.equals(this.f15301h.f17004c, "vnd.android.cursor.item/im")) {
                            if (valuesDelta.p() == null) {
                                asString12 = null;
                            } else {
                                asString12 = valuesDelta.p().getAsString("data5");
                            }
                            if (next.p() == null) {
                                asString13 = null;
                            } else {
                                asString13 = next.p().getAsString("data5");
                            }
                            if (TextUtils.equals(asString12, asString13) || !this.f15302i.e0()) {
                                if (valuesDelta.A() == null) {
                                    asString14 = null;
                                } else {
                                    asString14 = valuesDelta.A().getAsString("data5");
                                }
                                if (next.A() == null) {
                                    asString15 = null;
                                } else {
                                    asString15 = next.A().getAsString("data5");
                                }
                                if (TextUtils.equals(asString14, asString15)) {
                                    if (valuesDelta.p() == null) {
                                        asString16 = null;
                                    } else {
                                        asString16 = valuesDelta.p().getAsString("data6");
                                    }
                                    if (next.p() == null) {
                                        asString17 = null;
                                    } else {
                                        asString17 = next.p().getAsString("data6");
                                    }
                                    if (TextUtils.equals(asString16, asString17) || !this.f15302i.e0()) {
                                        if (valuesDelta.A() == null) {
                                            asString18 = null;
                                        } else {
                                            asString18 = valuesDelta.A().getAsString("data6");
                                        }
                                        if (next.A() == null) {
                                            asString19 = null;
                                        } else {
                                            asString19 = next.A().getAsString("data6");
                                        }
                                        if (!TextUtils.equals(asString18, asString19)) {
                                            continue;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (TextUtils.equals(this.f15301h.f17004c, "vnd.android.cursor.item/contact_event") || TextUtils.equals(this.f15301h.f17004c, "vnd.android.cursor.item/relation")) {
                            if (valuesDelta.p() == null) {
                                asString = null;
                            } else {
                                asString = valuesDelta.p().getAsString("data2");
                            }
                            if (next.p() == null) {
                                asString2 = null;
                            } else {
                                asString2 = next.p().getAsString("data2");
                            }
                            if (TextUtils.equals(asString, asString2) || !this.f15302i.e0()) {
                                if (valuesDelta.A() == null) {
                                    asString3 = null;
                                } else {
                                    asString3 = valuesDelta.A().getAsString("data2");
                                }
                                if (next.A() == null) {
                                    asString4 = null;
                                } else {
                                    asString4 = next.A().getAsString("data2");
                                }
                                if (TextUtils.equals(asString3, asString4)) {
                                    if (valuesDelta.p() == null) {
                                        asString5 = null;
                                    } else {
                                        asString5 = valuesDelta.p().getAsString("data3");
                                    }
                                    if (next.p() == null) {
                                        asString6 = null;
                                    } else {
                                        asString6 = next.p().getAsString("data3");
                                    }
                                    if (TextUtils.equals(asString5, asString6) || !this.f15302i.e0()) {
                                        if (valuesDelta.A() == null) {
                                            asString7 = null;
                                        } else {
                                            asString7 = valuesDelta.A().getAsString("data3");
                                        }
                                        if (next.A() == null) {
                                            asString8 = null;
                                        } else {
                                            asString8 = next.A().getAsString("data3");
                                        }
                                        if (!TextUtils.equals(asString7, asString8)) {
                                            continue;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (TextUtils.equals(this.f15301h.f17004c, "vnd.android.cursor.item/phone_v2")) {
                            if (valuesDelta.p() == null) {
                                asString9 = null;
                            } else {
                                asString9 = valuesDelta.p().getAsString("data2");
                            }
                            if (next.p() == null) {
                                asString10 = null;
                            } else {
                                asString10 = next.p().getAsString("data2");
                            }
                            if (!String.valueOf(4).equals(asString9) && !String.valueOf(5).equals(asString9)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!String.valueOf(4).equals(asString10) && !String.valueOf(5).equals(asString10)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z10 == z11 || !this.f15302i.e0()) {
                                if (valuesDelta.A() == null) {
                                    asString11 = null;
                                } else {
                                    asString11 = valuesDelta.A().getAsString("data2");
                                }
                                if (next.A() != null) {
                                    str = next.A().getAsString("data2");
                                }
                                if (!String.valueOf(4).equals(asString11) && !String.valueOf(5).equals(asString11)) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (!String.valueOf(4).equals(str) && !String.valueOf(5).equals(str)) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                if (z12 != z13) {
                                }
                            }
                        }
                        Boolean bool = Boolean.TRUE;
                        if (next.q("account_writable", bool).booleanValue() && valuesDelta.q("account_writable", bool).booleanValue()) {
                            next.d(valuesDelta);
                        }
                        if (!next.q("account_writable", bool).booleanValue()) {
                            next.d(valuesDelta);
                        }
                        return true;
                    }
                    continue;
                }
            }
            this.f15297d.add(valuesDelta);
        }
        return false;
    }

    public final boolean s() {
        if (getEmptyEditors().size() == 0 && (this.f15310q instanceof LabeledEditorView)) {
            return true;
        }
        return false;
    }

    public void setAlwaysVisible(boolean z10) {
        this.f15308o = z10;
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        ViewGroup viewGroup = this.f15299f;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f15299f.getChildAt(i10).setEnabled(z10);
            }
        }
    }

    public void setOnActivityResultManager(com.customize.contacts.manager.z zVar) {
        this.f15296c = zVar;
    }

    public void setOnReadyToContentAssociateListener(com.android.contacts.util.s sVar) {
        this.f15312x = sVar;
    }

    public void setShowOnlyDialogListener(RawContactEditorView.b bVar) {
        this.f15309p = bVar;
    }

    public void u(boolean z10) {
        p();
        int childCount = this.f15299f.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            EventFieldEditorView eventFieldEditorView = (EventFieldEditorView) this.f15299f.getChildAt(i10);
            if ("vnd.android.cursor.item/contact_event".equals(eventFieldEditorView.getKind().f17004c)) {
                if (z10) {
                    eventFieldEditorView.setIsLunarBirthday(false);
                }
                eventFieldEditorView.A(false);
            }
        }
    }

    public void v() {
        ArrayList<EntityDelta.ValuesDelta> D10;
        this.f15299f.removeAllViews();
        if ("vnd.android.cursor.item/contact_event".equals(this.f15301h.f17004c)) {
            ArrayList<EntityDelta.ValuesDelta> D11 = this.f15302i.D(this.f15301h.f17004c);
            if (D11 != null) {
                this.f15306m = D11.size();
            }
        } else if ((this.f15301h.f17004c.equals("vnd.android.cursor.item/note") || this.f15301h.f17004c.equals("vnd.android.cursor.item/nickname")) && (D10 = this.f15302i.D(this.f15301h.f17004c)) != null) {
            this.f15307n = D10.size();
        }
        if (this.f15302i.Q(this.f15301h.f17004c)) {
            Iterator<EntityDelta.ValuesDelta> it = this.f15302i.D(this.f15301h.f17004c).iterator();
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (r(next)) {
                    if ("vnd.android.cursor.item/contact_event".equals(this.f15301h.f17004c)) {
                        this.f15306m--;
                    }
                } else {
                    i10++;
                    if (i10 > 50 && "vnd.android.cursor.item/phone_v2".equals(this.f15301h.f17004c)) {
                        break;
                    }
                    if (next.R() && !q(next)) {
                        int i12 = i11 + 1;
                        try {
                            if ("vnd.android.cursor.item/im".equals(this.f15301h.f17004c)) {
                                Long x10 = next.x(this.f15301h.f17015n);
                                if (H7.a.b()) {
                                    H7.b.b("KindSectionView", "FeatureOption.isCNVersion() = " + FeatureOption.i());
                                }
                                if (FeatureOption.i() && (x10.longValue() == 0 || x10.longValue() == 1 || x10.longValue() == 2 || x10.longValue() == 3 || x10.longValue() == 5 || x10.longValue() == 6 || x10.longValue() == 7 || x10.longValue() == 8)) {
                                    next.e0("data5", OplusPhoneUtils.DeviceState.INVALID_STATUS);
                                    next.e0("data6", getContext().getString(ContactsContract.CommonDataKinds.Im.getProtocolLabelResource(x10.intValue())));
                                } else if (x10.longValue() == 15 && FeatureOption.o()) {
                                    next.e0("data5", OplusPhoneUtils.DeviceState.INVALID_STATUS);
                                    next.e0("data6", getContext().getString(R.string.imProtocolWeChat));
                                }
                            }
                        } catch (Exception unused) {
                            H7.b.c("KindSectionView", "IM type is wrong");
                            next.e0("data5", OplusPhoneUtils.DeviceState.INVALID_STATUS);
                            next.e0("data6", "");
                        }
                        View m10 = m(next, i11);
                        if (m10 instanceof LabeledEditorView) {
                            if (!z10 && !TextUtils.isEmpty(next.z("data1"))) {
                                z10 = true;
                            }
                            if (z10) {
                                ((LabeledEditorView) m10).J();
                            }
                        }
                        i11 = i12;
                    }
                }
            }
            if ("vnd.android.cursor.item/phone_v2".equals(this.f15301h.f17004c)) {
                HashMap hashMap = new HashMap();
                hashMap.put("counts_of_contacts", Integer.valueOf(i10));
                com.android.contacts.framework.baseui.util.A.a(getContext(), 2000310, 200030213, hashMap, false);
            }
        }
    }

    public void w(com.android.contacts.model.c cVar, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator, boolean z11) {
        String str;
        this.f15301h = cVar;
        this.f15302i = entityDelta;
        this.f15303j = z10;
        this.f15304k = viewIdGenerator;
        this.f15311r = z11;
        ArrayList<EntityDelta.ValuesDelta> arrayList = this.f15297d;
        if (arrayList != null) {
            arrayList.clear();
        }
        setId(this.f15304k.d(entityDelta, cVar, null, -1));
        int i10 = cVar.f17005d;
        if (i10 != -1 && i10 != 0) {
            str = getResources().getString(cVar.f17005d);
        } else {
            str = "";
        }
        this.f15300g = str;
        v();
        x();
        C();
        if (s()) {
            j(false, false);
        }
    }

    public void x() {
        if (!this.f15303j && this.f15301h.f17016o != 1) {
            y();
            if (!o()) {
                com.android.contacts.model.d.c(this.f15302i, this.f15301h);
            }
        }
    }

    public final void y() {
        List<View> emptyEditors = getEmptyEditors();
        if (emptyEditors.size() > 1) {
            for (int size = emptyEditors.size() - 1; size < emptyEditors.size(); size--) {
                View view = emptyEditors.get(size);
                if (view.findFocus() == null) {
                    this.f15299f.removeView(view);
                    return;
                }
            }
        }
    }

    public void z(EventFieldEditorView eventFieldEditorView) {
        if (eventFieldEditorView.getEntry().w("showReminder", 0).intValue() == 1) {
            eventFieldEditorView.v0();
        }
    }

    @Override // com.android.contacts.editor.A.a
    public void c(int i10) {
    }
}
