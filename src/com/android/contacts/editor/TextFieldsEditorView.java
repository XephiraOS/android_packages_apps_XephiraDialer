package com.android.contacts.editor;

import C3.a;
import X0.b;
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.contacts.editor.A;
import com.android.contacts.editor.KindSectionView;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.rotateview.COUIRotateView;
import com.customize.contacts.manager.z;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TextFieldsEditorView extends LabeledEditorView implements View.OnFocusChangeListener, z.a {

    /* renamed from: C, reason: collision with root package name */
    public boolean f15417C;

    /* renamed from: D, reason: collision with root package name */
    public long f15418D;

    /* renamed from: E, reason: collision with root package name */
    public COUIEditText[] f15419E;

    /* renamed from: F, reason: collision with root package name */
    public ViewGroup f15420F;

    /* renamed from: G, reason: collision with root package name */
    public View f15421G;

    /* renamed from: H, reason: collision with root package name */
    public COUIEditText f15422H;

    /* renamed from: I, reason: collision with root package name */
    public C3.a f15423I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f15424J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f15425K;

    /* renamed from: L, reason: collision with root package name */
    public View f15426L;

    /* renamed from: M, reason: collision with root package name */
    public KindSectionView.d f15427M;

    /* renamed from: N, reason: collision with root package name */
    public View f15428N;

    /* renamed from: O, reason: collision with root package name */
    public COUIRotateView f15429O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f15430P;

    /* renamed from: Q, reason: collision with root package name */
    public com.android.contacts.util.y f15431Q;

    /* renamed from: R, reason: collision with root package name */
    public volatile boolean f15432R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f15433S;

    /* renamed from: T, reason: collision with root package name */
    public LayoutInflater f15434T;

    /* renamed from: U, reason: collision with root package name */
    public com.android.contacts.util.s f15435U;

    /* renamed from: V, reason: collision with root package name */
    public final int f15436V;

    /* renamed from: W, reason: collision with root package name */
    public final List<b.a> f15437W;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f15438a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f15439b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f15440c;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15440c.length);
            parcel.writeIntArray(this.f15440c);
            parcel.writeBoolean(this.f15438a);
            parcel.writeBoolean(this.f15439b);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            int[] iArr = new int[parcel.readInt()];
            this.f15440c = iArr;
            parcel.readIntArray(iArr);
            this.f15438a = parcel.readBoolean();
            this.f15439b = parcel.readBoolean();
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id;
            View focusedChild = TextFieldsEditorView.this.f15420F.getFocusedChild();
            if (focusedChild == null) {
                id = -1;
            } else {
                id = focusedChild.getId();
            }
            TextFieldsEditorView textFieldsEditorView = TextFieldsEditorView.this;
            textFieldsEditorView.f15417C = !textFieldsEditorView.f15417C;
            textFieldsEditorView.f15432R = true;
            TextFieldsEditorView textFieldsEditorView2 = TextFieldsEditorView.this;
            if (textFieldsEditorView2.f15417C) {
                textFieldsEditorView2.f15429O.setContentDescription(TextFieldsEditorView.this.getResources().getString(R.string.contact_editor_name_expand));
            } else {
                textFieldsEditorView2.f15429O.setContentDescription(TextFieldsEditorView.this.getResources().getString(R.string.contact_editor_name_close));
            }
            if ("#displayName".equals(TextFieldsEditorView.this.f15329g.f17004c)) {
                TextFieldsEditorView textFieldsEditorView3 = TextFieldsEditorView.this;
                textFieldsEditorView3.f15331i.u0(textFieldsEditorView3.f15417C);
            }
            TextFieldsEditorView.this.f15331i.w0(true);
            TextFieldsEditorView.this.g0();
            TextFieldsEditorView.this.B();
            View findViewById = TextFieldsEditorView.this.findViewById(id);
            COUIEditText cOUIEditText = (COUIEditText) TextFieldsEditorView.this.f15420F.findViewWithTag("phonetic_name_tag");
            if (cOUIEditText != null && cOUIEditText.getVisibility() != 8) {
                findViewById = cOUIEditText;
            } else if (findViewById == null || findViewById.getVisibility() == 8) {
                findViewById = TextFieldsEditorView.this;
            }
            findViewById.requestFocus();
            TextFieldsEditorView.this.f15331i.w0(false);
        }
    }

    /* loaded from: classes.dex */
    public class c extends COUIEditText {
        public c(Context context) {
            super(context);
        }

        @Override // com.coui.appcompat.edittext.COUIEditText, android.widget.TextView, android.view.View
        public void onRestoreInstanceState(Parcelable parcelable) {
            if (!(parcelable instanceof TextView.SavedState)) {
                super.onRestoreInstanceState(parcelable);
            } else {
                super.onRestoreInstanceState(((TextView.SavedState) parcelable).getSuperState());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextView.OnEditorActionListener {
        public d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            if (i10 == 5) {
                View findViewById = TextFieldsEditorView.this.getRootView().findViewById(TextFieldsEditorView.this.getNextFocusForwardId());
                if (findViewById != null) {
                    findViewById.requestFocus();
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ COUIEditText f15453a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15454b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15455c;

        public g(COUIEditText cOUIEditText, int i10, int i11) {
            this.f15453a = cOUIEditText;
            this.f15454b = i10;
            this.f15455c = i11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f15453a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f15453a.getLineCount() > 1) {
                this.f15453a.setPaddingRelative(this.f15454b, TextFieldsEditorView.this.f15436V, this.f15455c, TextFieldsEditorView.this.f15436V);
            } else {
                this.f15453a.setPaddingRelative(this.f15454b, 0, this.f15455c, 0);
            }
        }
    }

    public TextFieldsEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15417C = true;
        this.f15418D = -1L;
        this.f15419E = null;
        this.f15420F = null;
        this.f15421G = null;
        this.f15422H = null;
        this.f15423I = null;
        this.f15424J = false;
        this.f15432R = false;
        this.f15433S = false;
        this.f15436V = getResources().getDimensionPixelSize(R.dimen.DP_19);
        this.f15437W = new ArrayList();
        this.f15423I = new C3.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        for (int i10 = 0; i10 < this.f15420F.getChildCount(); i10++) {
            View childAt = this.f15420F.getChildAt(i10);
            if (childAt instanceof COUIEditText) {
                if (!TextUtils.isEmpty(a0(((COUIEditText) childAt).getText()))) {
                    setDeleteButtonVisible(true);
                } else {
                    setDeleteButtonVisible(false);
                }
            }
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void C() {
        com.customize.contacts.manager.z zVar = this.f15324b;
        if (zVar != null) {
            zVar.e(this);
            this.f15424J = true;
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void D() {
        COUIEditText[] cOUIEditTextArr = this.f15419E;
        if (cOUIEditTextArr != null && cOUIEditTextArr.length != 0) {
            int length = cOUIEditTextArr.length;
            boolean z10 = false;
            COUIEditText cOUIEditText = null;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                COUIEditText cOUIEditText2 = cOUIEditTextArr[i10];
                if (cOUIEditText == null && cOUIEditText2.getVisibility() == 0) {
                    cOUIEditText = cOUIEditText2;
                }
                if (cOUIEditText2.hasFocus()) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (!z10 && cOUIEditText != null) {
                cOUIEditText.requestFocus();
            }
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void I(View view) {
        C3.a aVar = this.f15423I;
        if (aVar != null) {
            aVar.r(this.f15421G, this.f15422H);
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void J() {
        View view = this.f15421G;
        if (view != null) {
            view.setVisibility(0);
        }
        COUIEditText cOUIEditText = this.f15422H;
        if (cOUIEditText != null) {
            cOUIEditText.setVisibility(8);
        }
    }

    public boolean Y() {
        return !this.f15417C;
    }

    public final void Z(COUIEditText cOUIEditText) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.edit_contact_section_filed);
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    childAt.setEnabled(false);
                }
            }
        }
        cOUIEditText.setEnabled(false);
    }

    public final String a0(Editable editable) {
        if (editable == null) {
            return "";
        }
        return editable.toString();
    }

    @Override // X0.b
    public void b(b.a aVar) {
        COUIEditText[] cOUIEditTextArr;
        if (aVar != null) {
            this.f15437W.add(aVar);
        }
        if (!this.f15437W.isEmpty() && (cOUIEditTextArr = this.f15419E) != null) {
            for (COUIEditText cOUIEditText : cOUIEditTextArr) {
                f0(cOUIEditText);
            }
        }
    }

    public boolean b0() {
        COUIEditText editText;
        ViewGroup viewGroup = (ViewGroup) ((KindSectionView) this.f15337o).findViewById(R.id.kind_editors);
        if (viewGroup != null) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                TextFieldsEditorView textFieldsEditorView = (TextFieldsEditorView) viewGroup.getChildAt(childCount);
                if (textFieldsEditorView != null && textFieldsEditorView != this && (editText = textFieldsEditorView.getEditText()) != null && (editText.getText() == null || editText.getText().length() == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.android.contacts.editor.A
    public void c() {
        COUIEditText[] cOUIEditTextArr = this.f15419E;
        if (cOUIEditTextArr != null) {
            for (COUIEditText cOUIEditText : cOUIEditTextArr) {
                cOUIEditText.setText("");
            }
        }
    }

    public boolean c0() {
        return this.f15425K;
    }

    @Override // com.customize.contacts.manager.z.a
    public boolean d(int i10, int i11, Intent intent) {
        if (i10 == 1110 && -1 == i11) {
            if (this.f15421G.getVisibility() == 8 && this.f15422H.getVisibility() == 0) {
                this.f15423I.g(new f());
                this.f15423I.r(this.f15421G, this.f15422H);
            }
            COUIEditText cOUIEditText = (COUIEditText) this.f15420F.getChildAt(0);
            String l10 = C7.e.l(intent, "CONTACT_NAME");
            if (C0637b.h()) {
                l10 = C0637b.c(l10);
            }
            cOUIEditText.setText(l10);
            cOUIEditText.requestFocus();
            long f10 = C7.e.f(intent, "CONTACT_ID", -1L);
            this.f15427M.a(f10);
            if (f10 != -1) {
                EntityDelta.ValuesDelta entry = getEntry();
                this.f15418D = f10;
                entry.d0("data4", f10);
            }
        }
        l0();
        return false;
    }

    public boolean d0() {
        return this.f15430P;
    }

    @Override // X0.b
    public void e(String str, String str2) {
        for (COUIEditText cOUIEditText : this.f15419E) {
            if (str.equals(cOUIEditText.getTag(X0.b.f4269s))) {
                cOUIEditText.setText(str2);
                return;
            }
        }
    }

    public final /* synthetic */ void e0(COUIEditText cOUIEditText, View view, boolean z10) {
        f0(cOUIEditText);
    }

    @Override // X0.b
    public void f() {
        this.f15437W.clear();
    }

    public final void f0(COUIEditText cOUIEditText) {
        String str;
        String str2 = (String) cOUIEditText.getTag(X0.b.f4269s);
        if (str2 != null) {
            for (b.a aVar : getOnFieldContentEditListeners()) {
                boolean hasFocus = cOUIEditText.hasFocus();
                if (cOUIEditText.getText() != null) {
                    str = cOUIEditText.getText().toString();
                } else {
                    str = null;
                }
                aVar.onFocusStateChanged(str2, hasFocus, str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x033d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02df  */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [int] */
    /* JADX WARN: Type inference failed for: r13v9 */
    @Override // com.android.contacts.editor.LabeledEditorView, com.android.contacts.editor.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(com.android.contacts.model.c r24, com.android.contacts.model.EntityDelta.ValuesDelta r25, com.android.contacts.model.EntityDelta r26, boolean r27, com.android.contacts.editor.ViewIdGenerator r28) {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.TextFieldsEditorView.g(com.android.contacts.model.c, com.android.contacts.model.EntityDelta$ValuesDelta, com.android.contacts.model.EntityDelta, boolean, com.android.contacts.editor.ViewIdGenerator):void");
    }

    public void g0() {
        A.a aVar = this.f15337o;
        if (aVar != null) {
            aVar.c(5);
        }
    }

    public COUIEditText getEditText() {
        COUIEditText[] cOUIEditTextArr = this.f15419E;
        if (cOUIEditTextArr != null && cOUIEditTextArr.length > 0) {
            return cOUIEditTextArr[0];
        }
        return null;
    }

    public List<b.a> getOnFieldContentEditListeners() {
        return this.f15437W;
    }

    public final void h0(int i10, int i11, COUIEditText cOUIEditText) {
        cOUIEditText.getViewTreeObserver().addOnGlobalLayoutListener(new g(cOUIEditText, i10, i11));
    }

    public void i0() {
        String str = this.f15329g.f17004c;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1079210633:
                if (str.equals("vnd.android.cursor.item/note")) {
                    c10 = 0;
                    break;
                }
                break;
            case 456415478:
                if (str.equals("vnd.android.cursor.item/website")) {
                    c10 = 1;
                    break;
                }
                break;
            case 2034973555:
                if (str.equals("vnd.android.cursor.item/nickname")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
                View view = this.f15421G;
                if (view != null) {
                    view.setVisibility(0);
                }
                COUIEditText cOUIEditText = this.f15422H;
                if (cOUIEditText != null) {
                    cOUIEditText.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.android.contacts.editor.A
    public boolean isEmpty() {
        for (int i10 = 0; i10 < this.f15420F.getChildCount(); i10++) {
            View childAt = this.f15420F.getChildAt(i10);
            if (childAt instanceof COUIEditText) {
                if (!TextUtils.isEmpty(((COUIEditText) childAt).getText())) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }

    public final void j0(com.android.contacts.model.c cVar, COUIEditText cOUIEditText, boolean z10) {
        cOUIEditText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        cOUIEditText.setMinimumHeight(this.f15325c);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.DP_12);
        if (!z10 && !"vnd.android.cursor.item/organization".equals(cVar.f17004c)) {
            if ("vnd.android.cursor.item/postal-address_v2".equals(cVar.f17004c)) {
                h0(dimensionPixelSize, dimensionPixelSize, cOUIEditText);
                return;
            }
            if (!"vnd.android.cursor.item/im".equals(cVar.f17004c) && !"vnd.android.cursor.item/email_v2".equals(cVar.f17004c) && !"vnd.android.cursor.item/phone_v2".equals(cVar.f17004c)) {
                if ("vnd.android.cursor.item/note".equals(cVar.f17004c)) {
                    this.f15426L.setVisibility(8);
                    h0(0, dimensionPixelSize, cOUIEditText);
                    return;
                }
                if (!"vnd.android.cursor.item/website".equals(cVar.f17004c) && !"vnd.android.cursor.item/sip_address".equals(cVar.f17004c)) {
                    if ("vnd.android.cursor.item/nickname".equals(cVar.f17004c)) {
                        this.f15426L.setVisibility(8);
                        cOUIEditText.setPaddingRelative(0, 0, 0, 0);
                        return;
                    } else if ("vnd.android.cursor.item/relation".equals(cVar.f17004c)) {
                        cOUIEditText.setPaddingRelative(dimensionPixelSize, 0, getResources().getDimensionPixelSize(R.dimen.DP_8), 0);
                        return;
                    } else {
                        cOUIEditText.setPaddingRelative(dimensionPixelSize, 0, 0, 0);
                        return;
                    }
                }
                this.f15426L.setVisibility(8);
                cOUIEditText.setPaddingRelative(0, 0, dimensionPixelSize, 0);
                return;
            }
            cOUIEditText.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
            return;
        }
        cOUIEditText.setPaddingRelative(0, 0, 0, 0);
    }

    public void k0(boolean z10, boolean z11) {
        if (z10) {
            if (this.f15428N.getVisibility() != 0) {
                this.f15428N.setVisibility(0);
            }
            this.f15429O.setExpanded(!z11);
            return;
        }
        this.f15428N.setVisibility(8);
    }

    public void l0() {
        com.customize.contacts.manager.z zVar = this.f15324b;
        if (zVar != null) {
            zVar.f(this);
            this.f15424J = false;
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        this.f15420F = (ViewGroup) findViewById(R.id.editors);
        this.f15421G = findViewById(R.id.spinner_editor_view);
        COUIEditText cOUIEditText = (COUIEditText) findViewById(R.id.replaced_edit_field);
        this.f15422H = cOUIEditText;
        if (cOUIEditText != null && this.f15421G != null) {
            cOUIEditText.setOnFocusChangeListener(new a());
        }
        this.f15429O = (COUIRotateView) findViewById(R.id.expansion_rotate_view);
        View findViewById = findViewById(R.id.expansion_view_container);
        this.f15428N = findViewById;
        findViewById.setOnClickListener(new b());
        this.f15426L = findViewById(R.id.vertical_divider);
        this.f15430P = false;
        this.f15434T = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        View view2;
        View view3;
        if (!z10 && v() && this.f15423I.l()) {
            this.f15423I.i();
        }
        if (z10 && (view3 = this.f15421G) != null && view3.getVisibility() == 8 && !this.f15423I.l()) {
            J();
        } else if (!this.f15331i.d0() && !z10 && v() && (view2 = this.f15421G) != null && view2.getVisibility() == 0) {
            this.f15423I.j(this.f15421G, this.f15422H);
        }
        COUIEditText editText = getEditText();
        if (editText != null && "vnd.android.cursor.item/im".equals(getKind().f17004c)) {
            if (z10 && getType() != null && getType().f16960a == 4 && this.f15431Q.a() && this.f15431Q.d() != null && editText.getText() != null && editText.getText().toString().equals("")) {
                editText.setSelectAllOnFocus(true);
                editText.setText(this.f15431Q.d());
                editText.selectAll();
                this.f15431Q.g(false);
            } else {
                editText.setSelectAllOnFocus(false);
            }
        }
        if (view instanceof COUIEditText) {
            f0((COUIEditText) view);
        }
        m0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewGroup viewGroup;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15417C = savedState.f15438a;
        boolean z10 = savedState.f15439b;
        this.f15424J = z10;
        if (z10) {
            C();
        }
        int min = Math.min(this.f15419E.length, savedState.f15440c.length);
        for (int i10 = 0; i10 < min; i10++) {
            this.f15419E[i10].setVisibility(savedState.f15440c[i10]);
        }
        com.android.contacts.model.c kind = getKind();
        if (kind != null && "#displayName".equals(kind.f17004c)) {
            this.f15331i.u0(this.f15417C);
        }
        if (kind != null) {
            if (("#displayName".equals(kind.f17004c) || "#phoneticName".equals(kind.f17004c)) && (viewGroup = (ViewGroup) findViewById(R.id.editors)) != null) {
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof AppCompatImageView) {
                        childAt.setVisibility(viewGroup.getChildAt(i11 + 1).getVisibility());
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        int length;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15438a = this.f15417C;
        savedState.f15439b = this.f15424J;
        COUIEditText[] cOUIEditTextArr = this.f15419E;
        if (cOUIEditTextArr == null) {
            length = 0;
        } else {
            length = cOUIEditTextArr.length;
        }
        savedState.f15440c = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            savedState.f15440c[i10] = this.f15419E[i10].getVisibility();
        }
        return savedState;
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void q(View view) {
        C3.a aVar = this.f15423I;
        if (aVar != null) {
            aVar.j(this.f15421G, this.f15422H);
        }
    }

    @Override // com.android.contacts.editor.LabeledEditorView, android.view.View
    public void setEnabled(boolean z10) {
        boolean z11;
        super.setEnabled(z10);
        boolean z12 = true;
        if (this.f15419E != null) {
            int i10 = 0;
            while (true) {
                COUIEditText[] cOUIEditTextArr = this.f15419E;
                if (i10 >= cOUIEditTextArr.length) {
                    break;
                }
                COUIEditText cOUIEditText = cOUIEditTextArr[i10];
                if (!w() && z10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                cOUIEditText.setEnabled(z11);
                i10++;
            }
        }
        COUIRotateView cOUIRotateView = this.f15429O;
        if (w() || !z10) {
            z12 = false;
        }
        cOUIRotateView.setEnabled(z12);
    }

    public void setHideOption(boolean z10) {
        this.f15432R = z10;
    }

    public void setIsProfile(boolean z10) {
        this.f15433S = z10;
    }

    public void setOnReadyToContentAssociateListener(com.android.contacts.util.s sVar) {
        this.f15435U = sVar;
    }

    public void setRelationStub(KindSectionView.d dVar) {
        this.f15427M = dVar;
    }

    @Override // com.android.contacts.editor.LabeledEditorView
    public void x(String str, String str2) {
        A.a aVar;
        COUIEditText editText;
        if (u(str, str2)) {
            this.f15430P = true;
        }
        super.x(str, str2);
        if (!TextUtils.isEmpty(str2) && (this.f15337o instanceof KindSectionView)) {
            if (getKind() != null && "vnd.android.cursor.item/email_v2".equals(getKind().f17004c) && !com.customize.contacts.util.B.a(str2)) {
                return;
            }
            KindSectionView kindSectionView = (KindSectionView) this.f15337o;
            if (kindSectionView.getTag() != null && kindSectionView.getTag().equals("mode_quick_create")) {
                return;
            }
            int editorCount = kindSectionView.getEditorCount();
            ViewGroup viewGroup = (ViewGroup) kindSectionView.findViewById(R.id.kind_editors);
            if (viewGroup != null) {
                int i10 = editorCount - 1;
                if ((viewGroup.getChildAt(i10) instanceof TextFieldsEditorView) && ((TextFieldsEditorView) viewGroup.getChildAt(i10)).d0() && !b0()) {
                    ((KindSectionView) this.f15337o).j(false, true);
                    return;
                }
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str2) && (aVar = this.f15337o) != null && (aVar instanceof KindSectionView)) {
            KindSectionView kindSectionView2 = (KindSectionView) aVar;
            int editorCount2 = kindSectionView2.getEditorCount();
            ViewGroup viewGroup2 = (ViewGroup) kindSectionView2.findViewById(R.id.kind_editors);
            if (viewGroup2 != null && editorCount2 > 1) {
                for (int i11 = editorCount2 - 1; i11 >= 0; i11--) {
                    TextFieldsEditorView textFieldsEditorView = (TextFieldsEditorView) viewGroup2.getChildAt(i11);
                    if (textFieldsEditorView != null && textFieldsEditorView != this && (editText = textFieldsEditorView.getEditText()) != null && (editText.getText() == null || editText.getText().length() == 0)) {
                        ((KindSectionView) this.f15337o).d(textFieldsEditorView);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            TextFieldsEditorView textFieldsEditorView = TextFieldsEditorView.this;
            textFieldsEditorView.f0(textFieldsEditorView.f15422H);
            if (z10 && TextFieldsEditorView.this.f15423I.k()) {
                TextFieldsEditorView.this.f15423I.h();
            }
            if (!TextFieldsEditorView.this.f15331i.d0() && z10 && TextFieldsEditorView.this.f15421G.getVisibility() == 8 && TextFieldsEditorView.this.f15422H.getVisibility() == 0) {
                TextFieldsEditorView.this.f15423I.g(new C0162a());
                TextFieldsEditorView.this.f15423I.r(TextFieldsEditorView.this.f15421G, TextFieldsEditorView.this.f15422H);
            }
        }

        /* renamed from: com.android.contacts.editor.TextFieldsEditorView$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0162a implements a.b {
            public C0162a() {
            }

            @Override // C3.a.b
            public void onAnimationCancel(Animator animator) {
                TextFieldsEditorView.this.f15423I.q(this);
                TextFieldsEditorView.this.f15422H.setEnabled(true);
            }

            @Override // C3.a.b
            public void onAnimationEnd(Animator animator) {
                TextFieldsEditorView.this.f15423I.q(this);
                TextFieldsEditorView.this.f15422H.setEnabled(true);
            }

            @Override // C3.a.b
            public void onAnimationStart(Animator animator) {
                if (TextFieldsEditorView.this.getEditText() != null) {
                    TextFieldsEditorView.this.getEditText().requestFocus();
                    SoftKeyboardUtil.a().f(TextFieldsEditorView.this.getEditText());
                    TextFieldsEditorView.this.f15422H.setEnabled(false);
                }
            }

            @Override // C3.a.b
            public void onAnimationRepeat(Animator animator) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements a.b {
        public f() {
        }

        @Override // C3.a.b
        public void onAnimationCancel(Animator animator) {
            TextFieldsEditorView.this.f15423I.q(this);
        }

        @Override // C3.a.b
        public void onAnimationEnd(Animator animator) {
            TextFieldsEditorView.this.f15423I.q(this);
        }

        @Override // C3.a.b
        public void onAnimationStart(Animator animator) {
            if (TextFieldsEditorView.this.getEditText() != null) {
                TextFieldsEditorView.this.getEditText().requestFocus();
            }
        }

        @Override // C3.a.b
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public class e implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15446a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15447b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15448c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.android.contacts.model.c f15449d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ COUIEditText f15450e;

        public e(String str, boolean z10, String str2, com.android.contacts.model.c cVar, COUIEditText cOUIEditText) {
            this.f15446a = str;
            this.f15447b = z10;
            this.f15448c = str2;
            this.f15449d = cVar;
            this.f15450e = cOUIEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj;
            if (TextFieldsEditorView.this.f15427M != null) {
                if (TextFieldsEditorView.this.getEntry().j("data4")) {
                    TextFieldsEditorView.this.getEntry().k0("data4");
                }
                TextFieldsEditorView.this.f15427M.b(TextFieldsEditorView.this.f15418D);
                TextFieldsEditorView.this.f15418D = -1L;
            }
            TextFieldsEditorView.this.m0();
            TextFieldsEditorView textFieldsEditorView = TextFieldsEditorView.this;
            String str = this.f15446a;
            if (this.f15447b) {
                obj = this.f15448c;
            } else {
                obj = editable.toString();
            }
            textFieldsEditorView.x(str, obj);
            if ("vnd.android.cursor.item/relation".equals(this.f15449d.f17004c)) {
                TextFieldsEditorView.this.f15327e.setVisibility(0);
                if (TextUtils.isEmpty(editable.toString())) {
                    TextFieldsEditorView.this.f15328f.setImageResource(R.drawable.pb_ic_add_relation);
                    TextFieldsEditorView textFieldsEditorView2 = TextFieldsEditorView.this;
                    textFieldsEditorView2.f15328f.setContentDescription(textFieldsEditorView2.getResources().getString(R.string.description_add_contact));
                    TextFieldsEditorView.this.f15328f.setTag("relation_add");
                } else {
                    TextFieldsEditorView.this.f15328f.setImageResource(R.drawable.pb_ic_editor_delete);
                    TextFieldsEditorView textFieldsEditorView3 = TextFieldsEditorView.this;
                    textFieldsEditorView3.f15328f.setContentDescription(textFieldsEditorView3.getResources().getString(R.string.description_minus_button));
                    TextFieldsEditorView.this.f15328f.setTag("");
                }
            }
            if ("vnd.android.cursor.item/email_v2".equals(this.f15449d.f17004c)) {
                TextFieldsEditorView.this.f15431Q.h(TextFieldsEditorView.this.f15431Q.e(editable.toString()), TextFieldsEditorView.this.getId());
            }
            if (TextFieldsEditorView.this.f15435U != null && TextUtils.equals(this.f15446a, "data1") && this.f15450e.hasFocus()) {
                try {
                    TextFieldsEditorView.this.f15435U.s(this.f15449d.f17004c, editable.toString(), this.f15450e);
                } catch (Exception e10) {
                    Log.e("TextFieldsEditorView", "Exception when onReadyToContentAssociate " + e10);
                }
            }
            if ("vnd.android.cursor.item/postal-address_v2".equals(this.f15449d.f17004c) || "vnd.android.cursor.item/note".equals(this.f15449d.f17004c)) {
                int lineCount = this.f15450e.getLineCount();
                if (lineCount > 1 && this.f15450e.getPaddingBottom() == 0) {
                    COUIEditText cOUIEditText = this.f15450e;
                    cOUIEditText.setPaddingRelative(cOUIEditText.getPaddingStart(), TextFieldsEditorView.this.f15436V, this.f15450e.getPaddingEnd(), TextFieldsEditorView.this.f15436V);
                } else if (lineCount < 2 && this.f15450e.getPaddingBottom() != 0) {
                    COUIEditText cOUIEditText2 = this.f15450e;
                    cOUIEditText2.setPaddingRelative(cOUIEditText2.getPaddingStart(), 0, this.f15450e.getPaddingEnd(), 0);
                }
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
