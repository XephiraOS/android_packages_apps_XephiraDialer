package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0433g;
import androidx.core.view.C0446a;
import androidx.core.view.C0458m;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.C0978d;
import e4.C0979e;
import f.C0991a;
import f4.C1001b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import l4.C1292a;
import s4.C1550i;
import u4.C1607c;

/* loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: H0, reason: collision with root package name */
    public static final int f23970H0 = e4.l.f31035r;

    /* renamed from: I0, reason: collision with root package name */
    public static final int[][] f23971I0 = {new int[]{16842919}, new int[0]};

    /* renamed from: A, reason: collision with root package name */
    public int f23972A;

    /* renamed from: A0, reason: collision with root package name */
    public final CollapsingTextHelper f23973A0;

    /* renamed from: B, reason: collision with root package name */
    public Fade f23974B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f23975B0;

    /* renamed from: C, reason: collision with root package name */
    public Fade f23976C;

    /* renamed from: C0, reason: collision with root package name */
    public boolean f23977C0;

    /* renamed from: D, reason: collision with root package name */
    public ColorStateList f23978D;

    /* renamed from: D0, reason: collision with root package name */
    public ValueAnimator f23979D0;

    /* renamed from: E, reason: collision with root package name */
    public ColorStateList f23980E;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f23981E0;

    /* renamed from: F, reason: collision with root package name */
    public ColorStateList f23982F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f23983F0;

    /* renamed from: G, reason: collision with root package name */
    public ColorStateList f23984G;

    /* renamed from: G0, reason: collision with root package name */
    public boolean f23985G0;

    /* renamed from: H, reason: collision with root package name */
    public boolean f23986H;

    /* renamed from: I, reason: collision with root package name */
    public CharSequence f23987I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f23988J;

    /* renamed from: K, reason: collision with root package name */
    public x4.i f23989K;

    /* renamed from: L, reason: collision with root package name */
    public x4.i f23990L;

    /* renamed from: M, reason: collision with root package name */
    public StateListDrawable f23991M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f23992N;

    /* renamed from: O, reason: collision with root package name */
    public x4.i f23993O;

    /* renamed from: P, reason: collision with root package name */
    public x4.i f23994P;

    /* renamed from: Q, reason: collision with root package name */
    public x4.n f23995Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f23996R;

    /* renamed from: S, reason: collision with root package name */
    public final int f23997S;

    /* renamed from: T, reason: collision with root package name */
    public int f23998T;

    /* renamed from: U, reason: collision with root package name */
    public int f23999U;

    /* renamed from: V, reason: collision with root package name */
    public int f24000V;

    /* renamed from: W, reason: collision with root package name */
    public int f24001W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f24002a;

    /* renamed from: a0, reason: collision with root package name */
    public int f24003a0;

    /* renamed from: b, reason: collision with root package name */
    public final y f24004b;

    /* renamed from: b0, reason: collision with root package name */
    public int f24005b0;

    /* renamed from: c, reason: collision with root package name */
    public final r f24006c;

    /* renamed from: c0, reason: collision with root package name */
    public int f24007c0;

    /* renamed from: d, reason: collision with root package name */
    public EditText f24008d;

    /* renamed from: d0, reason: collision with root package name */
    public final Rect f24009d0;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f24010e;

    /* renamed from: e0, reason: collision with root package name */
    public final Rect f24011e0;

    /* renamed from: f, reason: collision with root package name */
    public int f24012f;

    /* renamed from: f0, reason: collision with root package name */
    public final RectF f24013f0;

    /* renamed from: g, reason: collision with root package name */
    public int f24014g;

    /* renamed from: g0, reason: collision with root package name */
    public Typeface f24015g0;

    /* renamed from: h, reason: collision with root package name */
    public int f24016h;

    /* renamed from: h0, reason: collision with root package name */
    public Drawable f24017h0;

    /* renamed from: i, reason: collision with root package name */
    public int f24018i;

    /* renamed from: i0, reason: collision with root package name */
    public int f24019i0;

    /* renamed from: j, reason: collision with root package name */
    public final u f24020j;

    /* renamed from: j0, reason: collision with root package name */
    public final LinkedHashSet<f> f24021j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f24022k;

    /* renamed from: k0, reason: collision with root package name */
    public Drawable f24023k0;

    /* renamed from: l, reason: collision with root package name */
    public int f24024l;

    /* renamed from: l0, reason: collision with root package name */
    public int f24025l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f24026m;

    /* renamed from: m0, reason: collision with root package name */
    public Drawable f24027m0;

    /* renamed from: n, reason: collision with root package name */
    public e f24028n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorStateList f24029n0;

    /* renamed from: o, reason: collision with root package name */
    public TextView f24030o;

    /* renamed from: o0, reason: collision with root package name */
    public ColorStateList f24031o0;

    /* renamed from: p, reason: collision with root package name */
    public int f24032p;

    /* renamed from: p0, reason: collision with root package name */
    public int f24033p0;

    /* renamed from: q, reason: collision with root package name */
    public int f24034q;

    /* renamed from: q0, reason: collision with root package name */
    public int f24035q0;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f24036r;

    /* renamed from: r0, reason: collision with root package name */
    public int f24037r0;

    /* renamed from: s0, reason: collision with root package name */
    public ColorStateList f24038s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f24039t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f24040u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f24041v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f24042w0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f24043x;

    /* renamed from: x0, reason: collision with root package name */
    public int f24044x0;

    /* renamed from: y, reason: collision with root package name */
    public TextView f24045y;

    /* renamed from: y0, reason: collision with root package name */
    public int f24046y0;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f24047z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f24048z0;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f24049a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f24050b;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f24049a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f24049a, parcel, i10);
            parcel.writeInt(this.f24050b ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f24049a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f24050b = parcel.readInt() == 1;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f24006c.h();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f23973A0.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends C0446a {

        /* renamed from: a, reason: collision with root package name */
        public final TextInputLayout f24056a;

        public d(TextInputLayout textInputLayout) {
            this.f24056a = textInputLayout;
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            CharSequence charSequence;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            EditText editText = this.f24056a.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = this.f24056a.getHint();
            CharSequence error = this.f24056a.getError();
            CharSequence placeholderText = this.f24056a.getPlaceholderText();
            int counterMaxLength = this.f24056a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f24056a.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            boolean z10 = !isEmpty;
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(hint);
            boolean z13 = !this.f24056a.P();
            boolean z14 = !TextUtils.isEmpty(error);
            if (!z14 && TextUtils.isEmpty(counterOverflowDescription)) {
                z11 = false;
            }
            if (z12) {
                str = hint.toString();
            } else {
                str = "";
            }
            this.f24056a.f24004b.A(dVar);
            if (z10) {
                dVar.K0(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                dVar.K0(str);
                if (z13 && placeholderText != null) {
                    dVar.K0(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                dVar.K0(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                dVar.s0(str);
                dVar.G0(isEmpty);
            }
            if (charSequence == null || charSequence.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            dVar.v0(counterMaxLength);
            if (z11) {
                if (!z14) {
                    error = counterOverflowDescription;
                }
                dVar.o0(error);
            }
            View t10 = this.f24056a.f24020j.t();
            if (t10 != null) {
                dVar.t0(t10);
            }
            this.f24056a.f24006c.m().o(view, dVar);
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f24056a.f24006c.m().p(view, accessibilityEvent);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        int a(Editable editable);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i10);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30627B0);
    }

    public static Drawable H(x4.i iVar, int i10, int i11, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{C1292a.j(i11, i10, 0.1f), i10}), iVar, iVar);
    }

    public static Drawable K(Context context, x4.i iVar, int i10, int[][] iArr) {
        int c10 = C1292a.c(context, C0977c.f30697v, "TextInputLayout");
        x4.i iVar2 = new x4.i(iVar.getShapeAppearanceModel());
        int j10 = C1292a.j(i10, c10, 0.1f);
        iVar2.setFillColor(new ColorStateList(iArr, new int[]{j10, 0}));
        iVar2.setTint(c10);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{j10, c10});
        x4.i iVar3 = new x4.i(iVar.getShapeAppearanceModel());
        iVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar2, iVar3), iVar});
    }

    public static /* synthetic */ int T(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    public static void Y(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z10);
            }
        }
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f24008d;
        if ((editText instanceof AutoCompleteTextView) && !q.a(editText)) {
            int d10 = C1292a.d(this.f24008d, C0977c.f30683o);
            int i10 = this.f23998T;
            if (i10 == 2) {
                return K(getContext(), this.f23989K, d10, f23971I0);
            }
            if (i10 == 1) {
                return H(this.f23989K, this.f24007c0, d10, f23971I0);
            }
            return null;
        }
        return this.f23989K;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f23991M == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f23991M = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f23991M.addState(new int[0], G(false));
        }
        return this.f23991M;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f23990L == null) {
            this.f23990L = G(true);
        }
        return this.f23990L;
    }

    public static void l0(Context context, TextView textView, int i10, int i11, boolean z10) {
        int i12;
        if (z10) {
            i12 = e4.k.f30978f;
        } else {
            i12 = e4.k.f30977e;
        }
        textView.setContentDescription(context.getString(i12, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void setEditText(EditText editText) {
        if (this.f24008d == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f24008d = editText;
            int i10 = this.f24012f;
            if (i10 != -1) {
                setMinEms(i10);
            } else {
                setMinWidth(this.f24016h);
            }
            int i11 = this.f24014g;
            if (i11 != -1) {
                setMaxEms(i11);
            } else {
                setMaxWidth(this.f24018i);
            }
            this.f23992N = false;
            V();
            setTextInputAccessibilityDelegate(new d(this));
            this.f23973A0.setTypefaces(this.f24008d.getTypeface());
            this.f23973A0.setExpandedTextSize(this.f24008d.getTextSize());
            this.f23973A0.setExpandedLetterSpacing(this.f24008d.getLetterSpacing());
            int gravity = this.f24008d.getGravity();
            this.f23973A0.setCollapsedTextGravity((gravity & (-113)) | 48);
            this.f23973A0.setExpandedTextGravity(gravity);
            this.f24046y0 = K.x(editText);
            this.f24008d.addTextChangedListener(new a(editText));
            if (this.f24029n0 == null) {
                this.f24029n0 = this.f24008d.getHintTextColors();
            }
            if (this.f23986H) {
                if (TextUtils.isEmpty(this.f23987I)) {
                    CharSequence hint = this.f24008d.getHint();
                    this.f24010e = hint;
                    setHint(hint);
                    this.f24008d.setHint((CharSequence) null);
                }
                this.f23988J = true;
            }
            n0();
            if (this.f24030o != null) {
                k0(this.f24008d.getText());
            }
            p0();
            this.f24020j.f();
            this.f24004b.bringToFront();
            this.f24006c.bringToFront();
            C();
            this.f24006c.x0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            v0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.f23987I)) {
            this.f23987I = charSequence;
            this.f23973A0.setText(charSequence);
            if (!this.f24048z0) {
                W();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f24043x == z10) {
            return;
        }
        if (z10) {
            j();
        } else {
            a0();
            this.f24045y = null;
        }
        this.f24043x = z10;
    }

    public final Fade A() {
        Fade fade = new Fade();
        fade.setDuration(C1550i.f(getContext(), C0977c.f30653Y, 87));
        fade.setInterpolator(C1550i.g(getContext(), C0977c.f30664e0, C1001b.f31702a));
        return fade;
    }

    public void A0() {
        boolean z10;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f23989K != null && this.f23998T != 0) {
            boolean z11 = false;
            if (!isFocused() && ((editText2 = this.f24008d) == null || !editText2.hasFocus())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (isHovered() || ((editText = this.f24008d) != null && editText.isHovered())) {
                z11 = true;
            }
            if (!isEnabled()) {
                this.f24005b0 = this.f24044x0;
            } else if (d0()) {
                if (this.f24038s0 != null) {
                    z0(z10, z11);
                } else {
                    this.f24005b0 = getErrorCurrentTextColors();
                }
            } else if (this.f24026m && (textView = this.f24030o) != null) {
                if (this.f24038s0 != null) {
                    z0(z10, z11);
                } else {
                    this.f24005b0 = textView.getCurrentTextColor();
                }
            } else if (z10) {
                this.f24005b0 = this.f24037r0;
            } else if (z11) {
                this.f24005b0 = this.f24035q0;
            } else {
                this.f24005b0 = this.f24033p0;
            }
            n0();
            this.f24006c.I();
            Z();
            if (this.f23998T == 2) {
                int i10 = this.f24000V;
                if (z10 && isEnabled()) {
                    this.f24000V = this.f24003a0;
                } else {
                    this.f24000V = this.f24001W;
                }
                if (this.f24000V != i10) {
                    X();
                }
            }
            if (this.f23998T == 1) {
                if (!isEnabled()) {
                    this.f24007c0 = this.f24040u0;
                } else if (z11 && !z10) {
                    this.f24007c0 = this.f24042w0;
                } else if (z10) {
                    this.f24007c0 = this.f24041v0;
                } else {
                    this.f24007c0 = this.f24039t0;
                }
            }
            m();
        }
    }

    public final boolean B() {
        if (this.f23986H && !TextUtils.isEmpty(this.f23987I) && (this.f23989K instanceof h)) {
            return true;
        }
        return false;
    }

    public final void C() {
        Iterator<f> it = this.f24021j0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void D(Canvas canvas) {
        x4.i iVar;
        if (this.f23994P != null && (iVar = this.f23993O) != null) {
            iVar.draw(canvas);
            if (this.f24008d.isFocused()) {
                Rect bounds = this.f23994P.getBounds();
                Rect bounds2 = this.f23993O.getBounds();
                float expansionFraction = this.f23973A0.getExpansionFraction();
                int centerX = bounds2.centerX();
                bounds.left = C1001b.c(centerX, bounds2.left, expansionFraction);
                bounds.right = C1001b.c(centerX, bounds2.right, expansionFraction);
                this.f23994P.draw(canvas);
            }
        }
    }

    public final void E(Canvas canvas) {
        if (this.f23986H) {
            this.f23973A0.draw(canvas);
        }
    }

    public final void F(boolean z10) {
        ValueAnimator valueAnimator = this.f23979D0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f23979D0.cancel();
        }
        if (z10 && this.f23977C0) {
            l(0.0f);
        } else {
            this.f23973A0.setExpansionFraction(0.0f);
        }
        if (B() && ((h) this.f23989K).d()) {
            y();
        }
        this.f24048z0 = true;
        L();
        this.f24004b.l(true);
        this.f24006c.H(true);
    }

    public final x4.i G(boolean z10) {
        float f10;
        float dimensionPixelOffset;
        ColorStateList colorStateList;
        float dimensionPixelOffset2 = getResources().getDimensionPixelOffset(C0979e.f30740I0);
        if (z10) {
            f10 = dimensionPixelOffset2;
        } else {
            f10 = 0.0f;
        }
        EditText editText = this.f24008d;
        if (editText instanceof MaterialAutoCompleteTextView) {
            dimensionPixelOffset = ((MaterialAutoCompleteTextView) editText).getPopupElevation();
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(C0979e.f30735G);
        }
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(C0979e.f30821y0);
        x4.n m10 = x4.n.a().H(f10).M(f10).w(dimensionPixelOffset2).B(dimensionPixelOffset2).m();
        EditText editText2 = this.f24008d;
        if (editText2 instanceof MaterialAutoCompleteTextView) {
            colorStateList = ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList();
        } else {
            colorStateList = null;
        }
        x4.i createWithElevationOverlay = x4.i.createWithElevationOverlay(getContext(), dimensionPixelOffset, colorStateList);
        createWithElevationOverlay.setShapeAppearanceModel(m10);
        createWithElevationOverlay.setPadding(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
        return createWithElevationOverlay;
    }

    public final int I(int i10, boolean z10) {
        int compoundPaddingLeft;
        if (!z10 && getPrefixText() != null) {
            compoundPaddingLeft = this.f24004b.c();
        } else if (z10 && getSuffixText() != null) {
            compoundPaddingLeft = this.f24006c.y();
        } else {
            compoundPaddingLeft = this.f24008d.getCompoundPaddingLeft();
        }
        return i10 + compoundPaddingLeft;
    }

    public final int J(int i10, boolean z10) {
        int compoundPaddingRight;
        if (!z10 && getSuffixText() != null) {
            compoundPaddingRight = this.f24006c.y();
        } else if (z10 && getPrefixText() != null) {
            compoundPaddingRight = this.f24004b.c();
        } else {
            compoundPaddingRight = this.f24008d.getCompoundPaddingRight();
        }
        return i10 - compoundPaddingRight;
    }

    public final void L() {
        TextView textView = this.f24045y;
        if (textView != null && this.f24043x) {
            textView.setText((CharSequence) null);
            androidx.transition.y.a(this.f24002a, this.f23976C);
            this.f24045y.setVisibility(4);
        }
    }

    public boolean M() {
        return this.f24006c.F();
    }

    public boolean N() {
        return this.f24020j.A();
    }

    public boolean O() {
        return this.f24020j.B();
    }

    public final boolean P() {
        return this.f24048z0;
    }

    public final boolean Q() {
        if (!d0() && (this.f24030o == null || !this.f24026m)) {
            return false;
        }
        return true;
    }

    public boolean R() {
        return this.f23988J;
    }

    public final boolean S() {
        if (this.f23998T == 1 && this.f24008d.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void U() {
        this.f24008d.requestLayout();
    }

    public final void V() {
        p();
        r0();
        A0();
        h0();
        k();
        if (this.f23998T != 0) {
            t0();
        }
        b0();
    }

    public final void W() {
        if (!B()) {
            return;
        }
        RectF rectF = this.f24013f0;
        this.f23973A0.getCollapsedTextActualBounds(rectF, this.f24008d.getWidth(), this.f24008d.getGravity());
        if (rectF.width() > 0.0f && rectF.height() > 0.0f) {
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f24000V);
            ((h) this.f23989K).g(rectF);
        }
    }

    public final void X() {
        if (B() && !this.f24048z0) {
            y();
            W();
        }
    }

    public void Z() {
        this.f24004b.m();
    }

    public final void a0() {
        TextView textView = this.f24045y;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f24002a.addView(view, layoutParams2);
            this.f24002a.setLayoutParams(layoutParams);
            t0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    public final void b0() {
        EditText editText = this.f24008d;
        if (!(editText instanceof AutoCompleteTextView)) {
            return;
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        if (autoCompleteTextView.getDropDownBackground() == null) {
            int i10 = this.f23998T;
            if (i10 == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
            } else if (i10 == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
            }
        }
    }

    public void c0(TextView textView, int i10) {
        try {
            androidx.core.widget.k.p(textView, i10);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.k.p(textView, e4.l.f31020c);
        textView.setTextColor(androidx.core.content.b.c(getContext(), C0978d.f30708b));
    }

    public boolean d0() {
        return this.f24020j.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f24008d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f24010e != null) {
            boolean z10 = this.f23988J;
            this.f23988J = false;
            CharSequence hint = editText.getHint();
            this.f24008d.setHint(this.f24010e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f24008d.setHint(hint);
                this.f23988J = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        viewStructure.setChildCount(this.f24002a.getChildCount());
        for (int i11 = 0; i11 < this.f24002a.getChildCount(); i11++) {
            View childAt = this.f24002a.getChildAt(i11);
            ViewStructure newChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(newChild, i10);
            if (childAt == this.f24008d) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f23983F0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f23983F0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        boolean z10;
        if (this.f23981E0) {
            return;
        }
        boolean z11 = true;
        this.f23981E0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.f23973A0;
        if (collapsingTextHelper != null) {
            z10 = collapsingTextHelper.setState(drawableState);
        } else {
            z10 = false;
        }
        if (this.f24008d != null) {
            if (!K.O(this) || !isEnabled()) {
                z11 = false;
            }
            u0(z11);
        }
        p0();
        A0();
        if (z10) {
            invalidate();
        }
        this.f23981E0 = false;
    }

    public final boolean e0() {
        if ((this.f24006c.G() || ((this.f24006c.A() && M()) || this.f24006c.w() != null)) && this.f24006c.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    public final boolean f0() {
        if ((getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f24004b.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    public final void g0() {
        if (this.f24045y != null && this.f24043x && !TextUtils.isEmpty(this.f24036r)) {
            this.f24045y.setText(this.f24036r);
            androidx.transition.y.a(this.f24002a, this.f23974B);
            this.f24045y.setVisibility(0);
            this.f24045y.bringToFront();
            announceForAccessibility(this.f24036r);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f24008d;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    public x4.i getBoxBackground() {
        int i10 = this.f23998T;
        if (i10 != 1 && i10 != 2) {
            throw new IllegalStateException();
        }
        return this.f23989K;
    }

    public int getBoxBackgroundColor() {
        return this.f24007c0;
    }

    public int getBoxBackgroundMode() {
        return this.f23998T;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f23999U;
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.f23995Q.j().a(this.f24013f0);
        }
        return this.f23995Q.l().a(this.f24013f0);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.f23995Q.l().a(this.f24013f0);
        }
        return this.f23995Q.j().a(this.f24013f0);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.f23995Q.r().a(this.f24013f0);
        }
        return this.f23995Q.t().a(this.f24013f0);
    }

    public float getBoxCornerRadiusTopStart() {
        if (ViewUtils.isLayoutRtl(this)) {
            return this.f23995Q.t().a(this.f24013f0);
        }
        return this.f23995Q.r().a(this.f24013f0);
    }

    public int getBoxStrokeColor() {
        return this.f24037r0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f24038s0;
    }

    public int getBoxStrokeWidth() {
        return this.f24001W;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f24003a0;
    }

    public int getCounterMaxLength() {
        return this.f24024l;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f24022k && this.f24026m && (textView = this.f24030o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f23980E;
    }

    public ColorStateList getCounterTextColor() {
        return this.f23978D;
    }

    public ColorStateList getCursorColor() {
        return this.f23982F;
    }

    public ColorStateList getCursorErrorColor() {
        return this.f23984G;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f24029n0;
    }

    public EditText getEditText() {
        return this.f24008d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f24006c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f24006c.n();
    }

    public int getEndIconMinSize() {
        return this.f24006c.o();
    }

    public int getEndIconMode() {
        return this.f24006c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f24006c.q();
    }

    public CheckableImageButton getEndIconView() {
        return this.f24006c.r();
    }

    public CharSequence getError() {
        if (this.f24020j.A()) {
            return this.f24020j.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f24020j.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f24020j.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f24020j.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f24006c.s();
    }

    public CharSequence getHelperText() {
        if (this.f24020j.B()) {
            return this.f24020j.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f24020j.u();
    }

    public CharSequence getHint() {
        if (this.f23986H) {
            return this.f23987I;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f23973A0.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f23973A0.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.f24031o0;
    }

    public e getLengthCounter() {
        return this.f24028n;
    }

    public int getMaxEms() {
        return this.f24014g;
    }

    public int getMaxWidth() {
        return this.f24018i;
    }

    public int getMinEms() {
        return this.f24012f;
    }

    public int getMinWidth() {
        return this.f24016h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f24006c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f24006c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f24043x) {
            return this.f24036r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f23972A;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f24047z;
    }

    public CharSequence getPrefixText() {
        return this.f24004b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f24004b.b();
    }

    public TextView getPrefixTextView() {
        return this.f24004b.d();
    }

    public x4.n getShapeAppearanceModel() {
        return this.f23995Q;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f24004b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.f24004b.f();
    }

    public int getStartIconMinSize() {
        return this.f24004b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f24004b.h();
    }

    public CharSequence getSuffixText() {
        return this.f24006c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f24006c.x();
    }

    public TextView getSuffixTextView() {
        return this.f24006c.z();
    }

    public Typeface getTypeface() {
        return this.f24015g0;
    }

    public final void h0() {
        if (this.f23998T == 1) {
            if (C1607c.k(getContext())) {
                this.f23999U = getResources().getDimensionPixelSize(C0979e.f30771Z);
            } else if (C1607c.j(getContext())) {
                this.f23999U = getResources().getDimensionPixelSize(C0979e.f30770Y);
            }
        }
    }

    public void i(f fVar) {
        this.f24021j0.add(fVar);
        if (this.f24008d != null) {
            fVar.a(this);
        }
    }

    public final void i0(Rect rect) {
        x4.i iVar = this.f23993O;
        if (iVar != null) {
            int i10 = rect.bottom;
            iVar.setBounds(rect.left, i10 - this.f24001W, rect.right, i10);
        }
        x4.i iVar2 = this.f23994P;
        if (iVar2 != null) {
            int i11 = rect.bottom;
            iVar2.setBounds(rect.left, i11 - this.f24003a0, rect.right, i11);
        }
    }

    public final void j() {
        TextView textView = this.f24045y;
        if (textView != null) {
            this.f24002a.addView(textView);
            this.f24045y.setVisibility(0);
        }
    }

    public final void j0() {
        Editable text;
        if (this.f24030o != null) {
            EditText editText = this.f24008d;
            if (editText == null) {
                text = null;
            } else {
                text = editText.getText();
            }
            k0(text);
        }
    }

    public final void k() {
        if (this.f24008d != null && this.f23998T == 1) {
            if (C1607c.k(getContext())) {
                EditText editText = this.f24008d;
                K.A0(editText, K.A(editText), getResources().getDimensionPixelSize(C0979e.f30769X), K.z(this.f24008d), getResources().getDimensionPixelSize(C0979e.f30767W));
            } else if (C1607c.j(getContext())) {
                EditText editText2 = this.f24008d;
                K.A0(editText2, K.A(editText2), getResources().getDimensionPixelSize(C0979e.f30765V), K.z(this.f24008d), getResources().getDimensionPixelSize(C0979e.f30763U));
            }
        }
    }

    public void k0(Editable editable) {
        boolean z10;
        int a10 = this.f24028n.a(editable);
        boolean z11 = this.f24026m;
        int i10 = this.f24024l;
        if (i10 == -1) {
            this.f24030o.setText(String.valueOf(a10));
            this.f24030o.setContentDescription(null);
            this.f24026m = false;
        } else {
            if (a10 > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f24026m = z10;
            l0(getContext(), this.f24030o, a10, this.f24024l, this.f24026m);
            if (z11 != this.f24026m) {
                m0();
            }
            this.f24030o.setText(H.a.c().j(getContext().getString(e4.k.f30979g, Integer.valueOf(a10), Integer.valueOf(this.f24024l))));
        }
        if (this.f24008d != null && z11 != this.f24026m) {
            u0(false);
            A0();
            p0();
        }
    }

    public void l(float f10) {
        if (this.f23973A0.getExpansionFraction() == f10) {
            return;
        }
        if (this.f23979D0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f23979D0 = valueAnimator;
            valueAnimator.setInterpolator(C1550i.g(getContext(), C0977c.f30662d0, C1001b.f31703b));
            this.f23979D0.setDuration(C1550i.f(getContext(), C0977c.f30651W, 167));
            this.f23979D0.addUpdateListener(new c());
        }
        this.f23979D0.setFloatValues(this.f23973A0.getExpansionFraction(), f10);
        this.f23979D0.start();
    }

    public final void m() {
        x4.i iVar = this.f23989K;
        if (iVar == null) {
            return;
        }
        x4.n shapeAppearanceModel = iVar.getShapeAppearanceModel();
        x4.n nVar = this.f23995Q;
        if (shapeAppearanceModel != nVar) {
            this.f23989K.setShapeAppearanceModel(nVar);
        }
        if (w()) {
            this.f23989K.setStroke(this.f24000V, this.f24005b0);
        }
        int q10 = q();
        this.f24007c0 = q10;
        this.f23989K.setFillColor(ColorStateList.valueOf(q10));
        n();
        r0();
    }

    public final void m0() {
        int i10;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f24030o;
        if (textView != null) {
            if (this.f24026m) {
                i10 = this.f24032p;
            } else {
                i10 = this.f24034q;
            }
            c0(textView, i10);
            if (!this.f24026m && (colorStateList2 = this.f23978D) != null) {
                this.f24030o.setTextColor(colorStateList2);
            }
            if (this.f24026m && (colorStateList = this.f23980E) != null) {
                this.f24030o.setTextColor(colorStateList);
            }
        }
    }

    public final void n() {
        ColorStateList valueOf;
        if (this.f23993O != null && this.f23994P != null) {
            if (x()) {
                x4.i iVar = this.f23993O;
                if (this.f24008d.isFocused()) {
                    valueOf = ColorStateList.valueOf(this.f24033p0);
                } else {
                    valueOf = ColorStateList.valueOf(this.f24005b0);
                }
                iVar.setFillColor(valueOf);
                this.f23994P.setFillColor(ColorStateList.valueOf(this.f24005b0));
            }
            invalidate();
        }
    }

    public final void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f23982F;
        if (colorStateList2 == null) {
            colorStateList2 = C1292a.g(getContext(), C0977c.f30681n);
        }
        EditText editText = this.f24008d;
        if (editText != null && editText.getTextCursorDrawable() != null) {
            Drawable mutate = C.a.r(this.f24008d.getTextCursorDrawable()).mutate();
            if (Q() && (colorStateList = this.f23984G) != null) {
                colorStateList2 = colorStateList;
            }
            C.a.o(mutate, colorStateList2);
        }
    }

    public final void o(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.f23997S;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    public boolean o0() {
        boolean z10;
        if (this.f24008d == null) {
            return false;
        }
        boolean z11 = true;
        if (f0()) {
            int measuredWidth = this.f24004b.getMeasuredWidth() - this.f24008d.getPaddingLeft();
            if (this.f24017h0 == null || this.f24019i0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f24017h0 = colorDrawable;
                this.f24019i0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a10 = androidx.core.widget.k.a(this.f24008d);
            Drawable drawable = a10[0];
            Drawable drawable2 = this.f24017h0;
            if (drawable != drawable2) {
                androidx.core.widget.k.i(this.f24008d, drawable2, a10[1], a10[2], a10[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f24017h0 != null) {
                Drawable[] a11 = androidx.core.widget.k.a(this.f24008d);
                androidx.core.widget.k.i(this.f24008d, null, a11[1], a11[2], a11[3]);
                this.f24017h0 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.f24006c.z().getMeasuredWidth() - this.f24008d.getPaddingRight();
            CheckableImageButton k10 = this.f24006c.k();
            if (k10 != null) {
                measuredWidth2 = measuredWidth2 + k10.getMeasuredWidth() + C0458m.b((ViewGroup.MarginLayoutParams) k10.getLayoutParams());
            }
            Drawable[] a12 = androidx.core.widget.k.a(this.f24008d);
            Drawable drawable3 = this.f24023k0;
            if (drawable3 != null && this.f24025l0 != measuredWidth2) {
                this.f24025l0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.k.i(this.f24008d, a12[0], a12[1], this.f24023k0, a12[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f24023k0 = colorDrawable2;
                    this.f24025l0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a12[2];
                Drawable drawable5 = this.f24023k0;
                if (drawable4 != drawable5) {
                    this.f24027m0 = drawable4;
                    androidx.core.widget.k.i(this.f24008d, a12[0], a12[1], drawable5, a12[3]);
                } else {
                    z11 = z10;
                }
            }
        } else if (this.f24023k0 != null) {
            Drawable[] a13 = androidx.core.widget.k.a(this.f24008d);
            if (a13[2] == this.f24023k0) {
                androidx.core.widget.k.i(this.f24008d, a13[0], a13[1], this.f24027m0, a13[3]);
            } else {
                z11 = z10;
            }
            this.f24023k0 = null;
        } else {
            return z10;
        }
        return z11;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f23973A0.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f24006c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f23985G0 = false;
        boolean s02 = s0();
        boolean o02 = o0();
        if (s02 || o02) {
            this.f24008d.post(new Runnable() { // from class: com.google.android.material.textfield.z
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputLayout.this.U();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f24008d;
        if (editText != null) {
            Rect rect = this.f24009d0;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            i0(rect);
            if (this.f23986H) {
                this.f23973A0.setExpandedTextSize(this.f24008d.getTextSize());
                int gravity = this.f24008d.getGravity();
                this.f23973A0.setCollapsedTextGravity((gravity & (-113)) | 48);
                this.f23973A0.setExpandedTextGravity(gravity);
                this.f23973A0.setCollapsedBounds(r(rect));
                this.f23973A0.setExpandedBounds(u(rect));
                this.f23973A0.recalculate();
                if (B() && !this.f24048z0) {
                    W();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.f23985G0) {
            this.f24006c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f23985G0 = true;
        }
        w0();
        this.f24006c.x0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f24049a);
        if (savedState.f24050b) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        if (z10 != this.f23996R) {
            float a10 = this.f23995Q.r().a(this.f24013f0);
            float a11 = this.f23995Q.t().a(this.f24013f0);
            float a12 = this.f23995Q.j().a(this.f24013f0);
            float a13 = this.f23995Q.l().a(this.f24013f0);
            x4.e q10 = this.f23995Q.q();
            x4.e s10 = this.f23995Q.s();
            x4.n m10 = x4.n.a().G(s10).L(q10).v(this.f23995Q.k()).A(this.f23995Q.i()).H(a11).M(a10).w(a13).B(a12).m();
            this.f23996R = z10;
            setShapeAppearanceModel(m10);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (d0()) {
            savedState.f24049a = getError();
        }
        savedState.f24050b = this.f24006c.E();
        return savedState;
    }

    public final void p() {
        int i10 = this.f23998T;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    if (this.f23986H && !(this.f23989K instanceof h)) {
                        this.f23989K = h.c(this.f23995Q);
                    } else {
                        this.f23989K = new x4.i(this.f23995Q);
                    }
                    this.f23993O = null;
                    this.f23994P = null;
                    return;
                }
                throw new IllegalArgumentException(this.f23998T + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.f23989K = new x4.i(this.f23995Q);
            this.f23993O = new x4.i();
            this.f23994P = new x4.i();
            return;
        }
        this.f23989K = null;
        this.f23993O = null;
        this.f23994P = null;
    }

    public void p0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f24008d;
        if (editText == null || this.f23998T != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.u.a(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(C0433g.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f24026m && (textView = this.f24030o) != null) {
            background.setColorFilter(C0433g.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            C.a.c(background);
            this.f24008d.refreshDrawableState();
        }
    }

    public final int q() {
        int i10 = this.f24007c0;
        if (this.f23998T == 1) {
            return C1292a.i(C1292a.e(this, C0977c.f30697v, 0), this.f24007c0);
        }
        return i10;
    }

    public final void q0() {
        K.n0(this.f24008d, getEditTextBoxBackground());
    }

    public final Rect r(Rect rect) {
        if (this.f24008d != null) {
            Rect rect2 = this.f24011e0;
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            rect2.bottom = rect.bottom;
            int i10 = this.f23998T;
            if (i10 != 1) {
                if (i10 != 2) {
                    rect2.left = I(rect.left, isLayoutRtl);
                    rect2.top = getPaddingTop();
                    rect2.right = J(rect.right, isLayoutRtl);
                    return rect2;
                }
                rect2.left = rect.left + this.f24008d.getPaddingLeft();
                rect2.top = rect.top - v();
                rect2.right = rect.right - this.f24008d.getPaddingRight();
                return rect2;
            }
            rect2.left = I(rect.left, isLayoutRtl);
            rect2.top = rect.top + this.f23999U;
            rect2.right = J(rect.right, isLayoutRtl);
            return rect2;
        }
        throw new IllegalStateException();
    }

    public void r0() {
        EditText editText = this.f24008d;
        if (editText != null && this.f23989K != null) {
            if ((this.f23992N || editText.getBackground() == null) && this.f23998T != 0) {
                q0();
                this.f23992N = true;
            }
        }
    }

    public final int s(Rect rect, Rect rect2, float f10) {
        if (S()) {
            return (int) (rect2.top + f10);
        }
        return rect.bottom - this.f24008d.getCompoundPaddingBottom();
    }

    public final boolean s0() {
        int max;
        if (this.f24008d == null || this.f24008d.getMeasuredHeight() >= (max = Math.max(this.f24006c.getMeasuredHeight(), this.f24004b.getMeasuredHeight()))) {
            return false;
        }
        this.f24008d.setMinimumHeight(max);
        return true;
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f24007c0 != i10) {
            this.f24007c0 = i10;
            this.f24039t0 = i10;
            this.f24041v0 = i10;
            this.f24042w0 = i10;
            m();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(androidx.core.content.b.c(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f24039t0 = defaultColor;
        this.f24007c0 = defaultColor;
        this.f24040u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f24041v0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f24042w0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.f23998T) {
            return;
        }
        this.f23998T = i10;
        if (this.f24008d != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.f23999U = i10;
    }

    public void setBoxCornerFamily(int i10) {
        this.f23995Q = this.f23995Q.v().F(i10, this.f23995Q.r()).K(i10, this.f23995Q.t()).u(i10, this.f23995Q.j()).z(i10, this.f23995Q.l()).m();
        m();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f24037r0 != i10) {
            this.f24037r0 = i10;
            A0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f24033p0 = colorStateList.getDefaultColor();
            this.f24044x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f24035q0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.f24037r0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.f24037r0 != colorStateList.getDefaultColor()) {
            this.f24037r0 = colorStateList.getDefaultColor();
        }
        A0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f24038s0 != colorStateList) {
            this.f24038s0 = colorStateList;
            A0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.f24001W = i10;
        A0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f24003a0 = i10;
        A0();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f24022k != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f24030o = appCompatTextView;
                appCompatTextView.setId(e4.g.f30891n0);
                Typeface typeface = this.f24015g0;
                if (typeface != null) {
                    this.f24030o.setTypeface(typeface);
                }
                this.f24030o.setMaxLines(1);
                this.f24020j.e(this.f24030o, 2);
                C0458m.d((ViewGroup.MarginLayoutParams) this.f24030o.getLayoutParams(), getResources().getDimensionPixelOffset(C0979e.f30766V0));
                m0();
                j0();
            } else {
                this.f24020j.C(this.f24030o, 2);
                this.f24030o = null;
            }
            this.f24022k = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f24024l != i10) {
            if (i10 > 0) {
                this.f24024l = i10;
            } else {
                this.f24024l = -1;
            }
            if (this.f24022k) {
                j0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f24032p != i10) {
            this.f24032p = i10;
            m0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f23980E != colorStateList) {
            this.f23980E = colorStateList;
            m0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f24034q != i10) {
            this.f24034q = i10;
            m0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f23978D != colorStateList) {
            this.f23978D = colorStateList;
            m0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.f23982F != colorStateList) {
            this.f23982F = colorStateList;
            n0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.f23984G != colorStateList) {
            this.f23984G = colorStateList;
            if (Q()) {
                n0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f24029n0 = colorStateList;
        this.f24031o0 = colorStateList;
        if (this.f24008d != null) {
            u0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        Y(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f24006c.N(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f24006c.O(z10);
    }

    public void setEndIconContentDescription(int i10) {
        this.f24006c.P(i10);
    }

    public void setEndIconDrawable(int i10) {
        this.f24006c.R(i10);
    }

    public void setEndIconMinSize(int i10) {
        this.f24006c.T(i10);
    }

    public void setEndIconMode(int i10) {
        this.f24006c.U(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f24006c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f24006c.W(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f24006c.X(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f24006c.Y(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f24006c.Z(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f24006c.a0(z10);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f24020j.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f24020j.Q(charSequence);
        } else {
            this.f24020j.w();
        }
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        this.f24020j.E(i10);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f24020j.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f24020j.G(z10);
    }

    public void setErrorIconDrawable(int i10) {
        this.f24006c.b0(i10);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f24006c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f24006c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f24006c.f0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f24006c.g0(mode);
    }

    public void setErrorTextAppearance(int i10) {
        this.f24020j.H(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f24020j.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f23975B0 != z10) {
            this.f23975B0 = z10;
            u0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (O()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.f24020j.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f24020j.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f24020j.K(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f24020j.J(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f23986H) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f23977C0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.f23986H) {
            this.f23986H = z10;
            if (!z10) {
                this.f23988J = false;
                if (!TextUtils.isEmpty(this.f23987I) && TextUtils.isEmpty(this.f24008d.getHint())) {
                    this.f24008d.setHint(this.f23987I);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f24008d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f23987I)) {
                        setHint(hint);
                    }
                    this.f24008d.setHint((CharSequence) null);
                }
                this.f23988J = true;
            }
            if (this.f24008d != null) {
                t0();
            }
        }
    }

    public void setHintTextAppearance(int i10) {
        this.f23973A0.setCollapsedTextAppearance(i10);
        this.f24031o0 = this.f23973A0.getCollapsedTextColor();
        if (this.f24008d != null) {
            u0(false);
            t0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f24031o0 != colorStateList) {
            if (this.f24029n0 == null) {
                this.f23973A0.setCollapsedTextColor(colorStateList);
            }
            this.f24031o0 = colorStateList;
            if (this.f24008d != null) {
                u0(false);
            }
        }
    }

    public void setLengthCounter(e eVar) {
        this.f24028n = eVar;
    }

    public void setMaxEms(int i10) {
        this.f24014g = i10;
        EditText editText = this.f24008d;
        if (editText != null && i10 != -1) {
            editText.setMaxEms(i10);
        }
    }

    public void setMaxWidth(int i10) {
        this.f24018i = i10;
        EditText editText = this.f24008d;
        if (editText != null && i10 != -1) {
            editText.setMaxWidth(i10);
        }
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f24012f = i10;
        EditText editText = this.f24008d;
        if (editText != null && i10 != -1) {
            editText.setMinEms(i10);
        }
    }

    public void setMinWidth(int i10) {
        this.f24016h = i10;
        EditText editText = this.f24008d;
        if (editText != null && i10 != -1) {
            editText.setMinWidth(i10);
        }
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        this.f24006c.i0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        this.f24006c.k0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f24006c.m0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f24006c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f24006c.o0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f24045y == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f24045y = appCompatTextView;
            appCompatTextView.setId(e4.g.f30897q0);
            K.t0(this.f24045y, 2);
            Fade A10 = A();
            this.f23974B = A10;
            A10.setStartDelay(67L);
            this.f23976C = A();
            setPlaceholderTextAppearance(this.f23972A);
            setPlaceholderTextColor(this.f24047z);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f24043x) {
                setPlaceholderTextEnabled(true);
            }
            this.f24036r = charSequence;
        }
        x0();
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.f23972A = i10;
        TextView textView = this.f24045y;
        if (textView != null) {
            androidx.core.widget.k.p(textView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f24047z != colorStateList) {
            this.f24047z = colorStateList;
            TextView textView = this.f24045y;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f24004b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i10) {
        this.f24004b.o(i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f24004b.p(colorStateList);
    }

    public void setShapeAppearanceModel(x4.n nVar) {
        x4.i iVar = this.f23989K;
        if (iVar != null && iVar.getShapeAppearanceModel() != nVar) {
            this.f23995Q = nVar;
            m();
        }
    }

    public void setStartIconCheckable(boolean z10) {
        this.f24004b.q(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? C0991a.b(getContext(), i10) : null);
    }

    public void setStartIconMinSize(int i10) {
        this.f24004b.t(i10);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f24004b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f24004b.v(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f24004b.w(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f24004b.x(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f24004b.y(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f24004b.z(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f24006c.p0(charSequence);
    }

    public void setSuffixTextAppearance(int i10) {
        this.f24006c.q0(i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f24006c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f24008d;
        if (editText != null) {
            K.j0(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f24015g0) {
            this.f24015g0 = typeface;
            this.f23973A0.setTypefaces(typeface);
            this.f24020j.N(typeface);
            TextView textView = this.f24030o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final int t(Rect rect, float f10) {
        if (S()) {
            return (int) (rect.centerY() - (f10 / 2.0f));
        }
        return rect.top + this.f24008d.getCompoundPaddingTop();
    }

    public final void t0() {
        if (this.f23998T != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24002a.getLayoutParams();
            int v10 = v();
            if (v10 != layoutParams.topMargin) {
                layoutParams.topMargin = v10;
                this.f24002a.requestLayout();
            }
        }
    }

    public final Rect u(Rect rect) {
        if (this.f24008d != null) {
            Rect rect2 = this.f24011e0;
            float expandedTextHeight = this.f23973A0.getExpandedTextHeight();
            rect2.left = rect.left + this.f24008d.getCompoundPaddingLeft();
            rect2.top = t(rect, expandedTextHeight);
            rect2.right = rect.right - this.f24008d.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    public void u0(boolean z10) {
        v0(z10, false);
    }

    public final int v() {
        float collapsedTextHeight;
        if (!this.f23986H) {
            return 0;
        }
        int i10 = this.f23998T;
        if (i10 != 0) {
            if (i10 != 2) {
                return 0;
            }
            collapsedTextHeight = this.f23973A0.getCollapsedTextHeight() / 2.0f;
        } else {
            collapsedTextHeight = this.f23973A0.getCollapsedTextHeight();
        }
        return (int) collapsedTextHeight;
    }

    public final void v0(boolean z10, boolean z11) {
        boolean z12;
        ColorStateList colorStateList;
        TextView textView;
        int i10;
        boolean isEnabled = isEnabled();
        EditText editText = this.f24008d;
        boolean z13 = false;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z12 = true;
        } else {
            z12 = false;
        }
        EditText editText2 = this.f24008d;
        if (editText2 != null && editText2.hasFocus()) {
            z13 = true;
        }
        ColorStateList colorStateList2 = this.f24029n0;
        if (colorStateList2 != null) {
            this.f23973A0.setCollapsedAndExpandedTextColor(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f24029n0;
            if (colorStateList3 != null) {
                i10 = colorStateList3.getColorForState(new int[]{-16842910}, this.f24044x0);
            } else {
                i10 = this.f24044x0;
            }
            this.f23973A0.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(i10));
        } else if (d0()) {
            this.f23973A0.setCollapsedAndExpandedTextColor(this.f24020j.r());
        } else if (this.f24026m && (textView = this.f24030o) != null) {
            this.f23973A0.setCollapsedAndExpandedTextColor(textView.getTextColors());
        } else if (z13 && (colorStateList = this.f24031o0) != null) {
            this.f23973A0.setCollapsedTextColor(colorStateList);
        }
        if (!z12 && this.f23975B0 && (!isEnabled() || !z13)) {
            if (z11 || !this.f24048z0) {
                F(z10);
                return;
            }
            return;
        }
        if (z11 || this.f24048z0) {
            z(z10);
        }
    }

    public final boolean w() {
        if (this.f23998T == 2 && x()) {
            return true;
        }
        return false;
    }

    public final void w0() {
        EditText editText;
        if (this.f24045y != null && (editText = this.f24008d) != null) {
            this.f24045y.setGravity(editText.getGravity());
            this.f24045y.setPadding(this.f24008d.getCompoundPaddingLeft(), this.f24008d.getCompoundPaddingTop(), this.f24008d.getCompoundPaddingRight(), this.f24008d.getCompoundPaddingBottom());
        }
    }

    public final boolean x() {
        if (this.f24000V > -1 && this.f24005b0 != 0) {
            return true;
        }
        return false;
    }

    public final void x0() {
        Editable text;
        EditText editText = this.f24008d;
        if (editText == null) {
            text = null;
        } else {
            text = editText.getText();
        }
        y0(text);
    }

    public final void y() {
        if (B()) {
            ((h) this.f23989K).e();
        }
    }

    public final void y0(Editable editable) {
        if (this.f24028n.a(editable) == 0 && !this.f24048z0) {
            g0();
        } else {
            L();
        }
    }

    public final void z(boolean z10) {
        ValueAnimator valueAnimator = this.f23979D0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f23979D0.cancel();
        }
        if (z10 && this.f23977C0) {
            l(1.0f);
        } else {
            this.f23973A0.setExpansionFraction(1.0f);
        }
        this.f24048z0 = false;
        if (B()) {
            W();
        }
        x0();
        this.f24004b.l(false);
        this.f24006c.H(false);
    }

    public final void z0(boolean z10, boolean z11) {
        int defaultColor = this.f24038s0.getDefaultColor();
        int colorForState = this.f24038s0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f24038s0.getColorForState(new int[]{R.attr.state_activated, 16842910}, defaultColor);
        if (z10) {
            this.f24005b0 = colorForState2;
        } else if (z11) {
            this.f24005b0 = colorForState;
        } else {
            this.f24005b0 = defaultColor;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(android.content.Context r22, android.util.AttributeSet r23, int r24) {
        /*
            Method dump skipped, instructions count: 865
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f24006c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f24006c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f24006c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f24006c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f24006c.l0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f24004b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f24004b.s(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public int f24051a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f24052b;

        public a(EditText editText) {
            this.f24052b = editText;
            this.f24051a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.u0(!r0.f23983F0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f24022k) {
                textInputLayout.k0(editable);
            }
            if (TextInputLayout.this.f24043x) {
                TextInputLayout.this.y0(editable);
            }
            int lineCount = this.f24052b.getLineCount();
            int i10 = this.f24051a;
            if (lineCount != i10) {
                if (lineCount < i10) {
                    int x10 = K.x(this.f24052b);
                    int i11 = TextInputLayout.this.f24046y0;
                    if (x10 != i11) {
                        this.f24052b.setMinimumHeight(i11);
                    }
                }
                this.f24051a = lineCount;
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
