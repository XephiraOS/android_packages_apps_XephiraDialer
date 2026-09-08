package com.customize.contacts.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.V0;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.poplist.COUIPopupWindow;
import com.coui.appcompat.scrollview.COUIScrollView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class TouchSearchView extends View implements View.OnClickListener, PopupWindow.OnDismissListener {

    /* renamed from: N0, reason: collision with root package name */
    public static final String[] f22462N0 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    /* renamed from: O0, reason: collision with root package name */
    public static final int[] f22463O0 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: P0, reason: collision with root package name */
    public static int[][][] f22464P0;

    /* renamed from: Q0, reason: collision with root package name */
    public static int[][] f22465Q0;

    /* renamed from: R0, reason: collision with root package name */
    public static int f22466R0;

    /* renamed from: S0, reason: collision with root package name */
    public static final int[] f22467S0;

    /* renamed from: T0, reason: collision with root package name */
    public static final Collator f22468T0;

    /* renamed from: U0, reason: collision with root package name */
    public static final Comparator<CharSequence> f22469U0;

    /* renamed from: A, reason: collision with root package name */
    public int f22470A;

    /* renamed from: A0, reason: collision with root package name */
    public boolean f22471A0;

    /* renamed from: B, reason: collision with root package name */
    public int f22472B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f22473B0;

    /* renamed from: C, reason: collision with root package name */
    public int f22474C;

    /* renamed from: C0, reason: collision with root package name */
    public int f22475C0;

    /* renamed from: D, reason: collision with root package name */
    public PopupWindow f22476D;

    /* renamed from: D0, reason: collision with root package name */
    public TextPaint f22477D0;

    /* renamed from: E, reason: collision with root package name */
    public int f22478E;

    /* renamed from: E0, reason: collision with root package name */
    public int f22479E0;

    /* renamed from: F, reason: collision with root package name */
    public int f22480F;

    /* renamed from: F0, reason: collision with root package name */
    public int f22481F0;

    /* renamed from: G, reason: collision with root package name */
    public int f22482G;

    /* renamed from: G0, reason: collision with root package name */
    public int f22483G0;

    /* renamed from: H, reason: collision with root package name */
    public int f22484H;

    /* renamed from: H0, reason: collision with root package name */
    public boolean f22485H0;

    /* renamed from: I, reason: collision with root package name */
    public int f22486I;

    /* renamed from: I0, reason: collision with root package name */
    public int f22487I0;

    /* renamed from: J, reason: collision with root package name */
    public int f22488J;

    /* renamed from: J0, reason: collision with root package name */
    public final int[] f22489J0;

    /* renamed from: K, reason: collision with root package name */
    public int f22490K;

    /* renamed from: K0, reason: collision with root package name */
    public final List<TextView> f22491K0;

    /* renamed from: L, reason: collision with root package name */
    public int f22492L;

    /* renamed from: L0, reason: collision with root package name */
    public List<Integer> f22493L0;

    /* renamed from: M, reason: collision with root package name */
    public int f22494M;

    /* renamed from: M0, reason: collision with root package name */
    public List<int[]> f22495M0;

    /* renamed from: N, reason: collision with root package name */
    public int f22496N;

    /* renamed from: O, reason: collision with root package name */
    public int f22497O;

    /* renamed from: P, reason: collision with root package name */
    public int f22498P;

    /* renamed from: Q, reason: collision with root package name */
    public int f22499Q;

    /* renamed from: R, reason: collision with root package name */
    public int f22500R;

    /* renamed from: S, reason: collision with root package name */
    public int f22501S;

    /* renamed from: T, reason: collision with root package name */
    public int f22502T;

    /* renamed from: U, reason: collision with root package name */
    public int f22503U;

    /* renamed from: V, reason: collision with root package name */
    public int f22504V;

    /* renamed from: W, reason: collision with root package name */
    public View f22505W;

    /* renamed from: a, reason: collision with root package name */
    public Context f22506a;

    /* renamed from: a0, reason: collision with root package name */
    public View f22507a0;

    /* renamed from: b, reason: collision with root package name */
    public int f22508b;

    /* renamed from: b0, reason: collision with root package name */
    public int f22509b0;

    /* renamed from: c, reason: collision with root package name */
    public int f22510c;

    /* renamed from: c0, reason: collision with root package name */
    public Rect f22511c0;

    /* renamed from: d, reason: collision with root package name */
    public int f22512d;

    /* renamed from: d0, reason: collision with root package name */
    public int f22513d0;

    /* renamed from: e, reason: collision with root package name */
    public int f22514e;

    /* renamed from: e0, reason: collision with root package name */
    public LinearLayout f22515e0;

    /* renamed from: f, reason: collision with root package name */
    public int f22516f;

    /* renamed from: f0, reason: collision with root package name */
    public LinearLayout f22517f0;

    /* renamed from: g, reason: collision with root package name */
    public int f22518g;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f22519g0;

    /* renamed from: h, reason: collision with root package name */
    public int f22520h;

    /* renamed from: h0, reason: collision with root package name */
    public COUIScrollView f22521h0;

    /* renamed from: i, reason: collision with root package name */
    public String[] f22522i;

    /* renamed from: i0, reason: collision with root package name */
    public CharSequence f22523i0;

    /* renamed from: j, reason: collision with root package name */
    public String[] f22524j;

    /* renamed from: j0, reason: collision with root package name */
    public int f22525j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22526k;

    /* renamed from: k0, reason: collision with root package name */
    public int f22527k0;

    /* renamed from: l, reason: collision with root package name */
    public String[] f22528l;

    /* renamed from: l0, reason: collision with root package name */
    public int f22529l0;

    /* renamed from: m, reason: collision with root package name */
    public d f22530m;

    /* renamed from: m0, reason: collision with root package name */
    public Drawable f22531m0;

    /* renamed from: n, reason: collision with root package name */
    public e f22532n;

    /* renamed from: n0, reason: collision with root package name */
    public final ArrayList<c> f22533n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f22534o;

    /* renamed from: o0, reason: collision with root package name */
    public int f22535o0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f22536p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f22537p0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f22538q;

    /* renamed from: q0, reason: collision with root package name */
    public ColorStateList f22539q0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f22540r;

    /* renamed from: r0, reason: collision with root package name */
    public ColorStateList f22541r0;

    /* renamed from: s0, reason: collision with root package name */
    public ColorStateList f22542s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f22543t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f22544u0;

    /* renamed from: v0, reason: collision with root package name */
    public Typeface f22545v0;

    /* renamed from: w0, reason: collision with root package name */
    public Drawable f22546w0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f22547x;

    /* renamed from: x0, reason: collision with root package name */
    public Drawable f22548x0;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f22549y;

    /* renamed from: y0, reason: collision with root package name */
    public Drawable f22550y0;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f22551z;

    /* renamed from: z0, reason: collision with root package name */
    public Drawable f22552z0;

    /* loaded from: classes3.dex */
    public class a implements Comparator<CharSequence> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(CharSequence charSequence, CharSequence charSequence2) {
            return TouchSearchView.f22468T0.compare(charSequence, charSequence2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z10;
            int height = TouchSearchView.this.getHeight();
            boolean z11 = false;
            if (TouchSearchView.this.f22504V != height) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (TouchSearchView.this.getVisibility() == 0) {
                z11 = true;
            }
            if (z10) {
                DisplayMetrics displayMetrics = TouchSearchView.this.getResources().getDisplayMetrics();
                H7.b.e("ContactsTouchSearchView", "onGlobalLayout: visible: " + z11 + ", height changed: " + TouchSearchView.this.f22504V + " -> " + height + ", density: " + displayMetrics.density + ", densityDpi: " + displayMetrics.densityDpi);
            }
            if (z10 && z11) {
                TouchSearchView touchSearchView = TouchSearchView.this;
                if (touchSearchView.x(touchSearchView.f22505W, TouchSearchView.this.f22507a0)) {
                    TouchSearchView touchSearchView2 = TouchSearchView.this;
                    touchSearchView2.B(touchSearchView2.f22505W, TouchSearchView.this.f22507a0);
                    TouchSearchView.this.f22504V = height;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onKey(CharSequence charSequence);

        void onNameClick(CharSequence charSequence);
    }

    /* loaded from: classes3.dex */
    public interface e {
        boolean a();
    }

    static {
        int[] iArr = {R.attr.state_window_focused, 1, 16842913, 2, 16842908, 4, 16842910, 8, 16842919, 16, R.attr.state_activated, 32, R.attr.state_accelerated, 64, 16843623, 128, R.attr.state_drag_can_accept, 256, R.attr.state_drag_hovered, 512};
        f22467S0 = iArr;
        int length = V0.f13469l5.length;
        f22466R0 = length;
        int length2 = iArr.length / 2;
        if (length2 == length) {
            int length3 = iArr.length;
            int[] iArr2 = new int[length3];
            for (int i10 = 0; i10 < f22466R0; i10++) {
                int i11 = V0.f13469l5[i10];
                int i12 = 0;
                while (true) {
                    int[] iArr3 = f22467S0;
                    if (i12 < iArr3.length) {
                        if (iArr3[i12] == i11) {
                            int i13 = i10 * 2;
                            iArr2[i13] = i11;
                            iArr2[i13 + 1] = iArr3[i12 + 1];
                        }
                        i12 += 2;
                    }
                }
            }
            int i14 = 1 << length2;
            f22464P0 = new int[i14][];
            f22465Q0 = new int[i14];
            for (int i15 = 0; i15 < f22465Q0.length; i15++) {
                f22465Q0[i15] = new int[Integer.bitCount(i15)];
                int i16 = 0;
                for (int i17 = 0; i17 < length3; i17 += 2) {
                    if ((iArr2[i17 + 1] & i15) != 0) {
                        f22465Q0[i15][i16] = iArr2[i17];
                        i16++;
                    }
                }
            }
            f22468T0 = Collator.getInstance();
            f22469U0 = new a();
            return;
        }
        throw new IllegalStateException("VIEW_STATE_IDS array length does not match ViewDrawableStates style array");
    }

    public TouchSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void G(MotionEvent motionEvent) {
        int i10;
        int action = (motionEvent.getAction() & 65280) >> 8;
        int pointerId = motionEvent.getPointerId(action);
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "onSecondaryPointerUp --- pointerId = " + pointerId);
            H7.b.b("ContactsTouchSearchView", "onSecondaryPointerUp --- mActivePointerId = " + this.f22509b0);
        }
        if (pointerId == this.f22509b0) {
            if (action == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f22509b0 = motionEvent.getPointerId(i10);
            if (H7.a.b()) {
                H7.b.b("ContactsTouchSearchView", "onSecondaryPointerUp --- newPointerIndex = " + i10);
            }
        }
    }

    private void H() {
        performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
    }

    private void J() {
        this.f22533n0.clear();
        this.f22495M0.clear();
        this.f22493L0.clear();
        int[] iArr = this.f22489J0;
        iArr[0] = -1;
        iArr[1] = -1;
    }

    private void R() {
        Drawable drawable;
        int i10;
        int i11;
        Drawable drawable2;
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        this.f22510c = getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.coui_touchsearch_each_item_height);
        J();
        int length = this.f22522i.length;
        int paddingTop = getPaddingTop();
        Paint.FontMetricsInt fontMetricsInt = this.f22477D0.getFontMetricsInt();
        int i12 = (this.f22510c - (fontMetricsInt.bottom - fontMetricsInt.top)) / 2;
        int characterStartIndex = ((length - getCharacterStartIndex()) * this.f22510c) + (this.f22479E0 * (length - 1));
        if (!this.f22537p0) {
            characterStartIndex += this.f22518g;
        }
        Rect rect = this.f22511c0;
        if (rect != null) {
            int i13 = rect.left;
            int i14 = i13 + (((rect.right - i13) - this.f22516f) / 2);
            int i15 = this.f22481F0;
            this.f22512d = (i14 + i15) - ((i15 + this.f22483G0) / 2);
        }
        if (H7.a.b()) {
            H7.b.e("ContactsTouchSearchView", "updateView: keysCount: " + length + ", getCharacterStartIndex: " + getCharacterStartIndex() + ", mCellHeight: " + this.f22510c + ", mItemSpacing: " + this.f22479E0 + ", mKeyDrawableHeight: " + this.f22518g + ", totalItemHeight: " + characterStartIndex + ", exactHeight: " + height);
        }
        if (characterStartIndex > height) {
            this.f22485H0 = true;
            int i16 = this.f22479E0 + this.f22510c;
            int i17 = 1;
            while (i17 < length) {
                characterStartIndex -= i16;
                if (characterStartIndex <= height) {
                    break;
                } else {
                    i17++;
                }
            }
            int i18 = length - i17;
            int i19 = i18 - 1;
            int characterStartIndex2 = (i19 - getCharacterStartIndex()) / 2;
            if (i17 <= characterStartIndex2) {
                characterStartIndex2 = i17;
            }
            if (H7.a.b()) {
                H7.b.e("ContactsTouchSearchView", "updateView: needDrawCount =" + i18 + " realDrawDotCount = " + characterStartIndex2);
            }
            if (length > 0 && characterStartIndex2 > 0) {
                int i20 = paddingTop + (height - characterStartIndex);
                int i21 = i20 / 2;
                int i22 = characterStartIndex / length;
                ArrayList arrayList = new ArrayList(characterStartIndex2);
                if (H7.a.b()) {
                    i11 = i19;
                    StringBuilder sb = new StringBuilder();
                    i10 = i12;
                    sb.append("updateView: exactHeight: ");
                    sb.append(height);
                    sb.append(", totalItemHeight: ");
                    sb.append(characterStartIndex);
                    sb.append(", topPadding: ");
                    sb.append(i20);
                    sb.append(", y: ");
                    sb.append(i21);
                    sb.append(", realDrawDotCount: ");
                    sb.append(characterStartIndex2);
                    sb.append(", keysCount: ");
                    sb.append(length);
                    sb.append(", eachKeyTouchHeight: ");
                    sb.append(i22);
                    sb.append(", mItemSpacing: ");
                    sb.append(this.f22479E0);
                    H7.b.b("ContactsTouchSearchView", sb.toString());
                } else {
                    i10 = i12;
                    i11 = i19;
                }
                for (int i23 = 0; i23 < i17; i23++) {
                    int i24 = i23 % characterStartIndex2;
                    if (arrayList.size() == i24) {
                        arrayList.add(0);
                    }
                    arrayList.set(i24, Integer.valueOf(((Integer) arrayList.get(i24)).intValue() + 1));
                }
                if (!this.f22537p0 && (drawable2 = this.f22531m0) != null) {
                    c cVar = new c(drawable2, this.f22522i[0]);
                    cVar.g(this.f22512d);
                    cVar.h(i21);
                    cVar.f22562i = i21;
                    cVar.f22563j = this.f22518g + i21;
                    this.f22533n0.add(cVar);
                    i21 += this.f22518g + this.f22479E0;
                }
                int characterStartIndex3 = getCharacterStartIndex();
                boolean z10 = this.f22537p0;
                int i25 = 0;
                for (int characterStartIndex4 = getCharacterStartIndex(); characterStartIndex4 < i18; characterStartIndex4++) {
                    c cVar2 = new c(null, null);
                    cVar2.g(this.f22512d);
                    cVar2.h(i21 + i10);
                    if (this.f22533n0.size() % 2 == z10 && i25 < characterStartIndex2) {
                        cVar2.f22565l = true;
                        cVar2.f22560g = this.f22549y.toString();
                        cVar2.f22562i = this.f22533n0.get(characterStartIndex4 - 1).f22563j;
                        int i26 = this.f22510c;
                        cVar2.f22563j = i21 + i26 + this.f22479E0 + ((i26 - i22) / 2);
                        cVar2.f22564k.clear();
                        int i27 = 0;
                        while (i27 < ((Integer) arrayList.get(i25)).intValue() + 1) {
                            c cVar3 = new c();
                            cVar3.f22566m = characterStartIndex3;
                            cVar3.f22560g = this.f22522i[characterStartIndex3];
                            cVar2.f22564k.add(cVar3);
                            i27++;
                            characterStartIndex3++;
                        }
                        i25++;
                    } else {
                        cVar2.f22566m = characterStartIndex3;
                        int i28 = characterStartIndex3 + 1;
                        cVar2.f22560g = this.f22522i[characterStartIndex3];
                        int i29 = this.f22510c;
                        cVar2.f22562i = ((i29 - i22) / 2) + i21;
                        cVar2.f22563j = ((i29 + i22) / 2) + i21;
                        int i30 = i11;
                        if (characterStartIndex4 == i30 && characterStartIndex4 >= 1) {
                            c cVar4 = this.f22533n0.get(characterStartIndex4 - 1);
                            if (!cVar4.f22565l) {
                                int i31 = cVar2.f22563j;
                                i11 = i30;
                                int i32 = cVar4.f22562i;
                                int i33 = (i31 - i32) / 2;
                                int i34 = i32 + i33;
                                cVar4.f22563j = i34;
                                cVar2.f22562i = i34;
                                cVar2.f22563j = i34 + i33;
                                H7.b.i("ContactsTouchSearchView", "Adjust the last 2 keys touch area: , touchTop: " + cVar4.f22562i + ", touchBottom: " + cVar4.f22563j + ", last touchTop: " + cVar2.f22562i + ", touchBottom: " + cVar2.f22563j);
                                characterStartIndex3 = i28;
                            }
                        }
                        i11 = i30;
                        characterStartIndex3 = i28;
                    }
                    i21 += this.f22510c + this.f22479E0;
                    this.f22533n0.add(cVar2);
                }
            } else {
                return;
            }
        } else {
            this.f22485H0 = false;
            int i35 = (paddingTop + (height - characterStartIndex)) / 2;
            if (!this.f22537p0 && (drawable = this.f22531m0) != null) {
                c cVar5 = new c(drawable, this.f22522i[0]);
                cVar5.g(this.f22512d);
                cVar5.h(i35);
                this.f22533n0.add(cVar5);
                i35 += this.f22518g + this.f22479E0;
            }
            for (int characterStartIndex5 = getCharacterStartIndex(); characterStartIndex5 < length; characterStartIndex5++) {
                c cVar6 = new c(null, this.f22522i[characterStartIndex5]);
                cVar6.g(this.f22512d);
                cVar6.h(i35 + i12);
                this.f22533n0.add(cVar6);
                i35 += this.f22510c + this.f22479E0;
            }
        }
        this.f22487I0 = characterStartIndex;
        int size = this.f22533n0.size();
        if (H7.a.b()) {
            H7.b.e("ContactsTouchSearchView", "updateView: mKey.size: " + size + ", mHeightNotEnough: " + this.f22485H0);
        }
        for (int i36 = 0; i36 < size; i36++) {
            int[][][] iArr = f22464P0;
            int[][] iArr2 = f22465Q0;
            int[][] iArr3 = new int[iArr2.length];
            iArr[i36] = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        }
        for (int i37 = 0; i37 < size; i37++) {
            this.f22495M0.add(new int[f22466R0]);
            this.f22493L0.add(0);
            I(i37, this.f22533n0.get(i37).b());
            ColorStateList colorStateList = this.f22542s0;
            if (colorStateList != null) {
                this.f22533n0.get(i37).f22561h.setColor(colorStateList.getColorForState(u(i37), this.f22542s0.getDefaultColor()));
            }
        }
        P(size);
    }

    private int getCharacterStartIndex() {
        if (!this.f22537p0) {
            return 1;
        }
        return 0;
    }

    public static String[] getDefaultTouchKeys() {
        return f22462N0;
    }

    public static int[] o(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17;
        int i18;
        int i19 = i11 - i10;
        int i20 = i19 - (i14 * 2);
        if (i16 > i15 || i20 >= i15) {
            i17 = i15;
        } else if (i20 < i16) {
            i17 = i20;
        } else {
            i17 = i16;
        }
        if (i20 >= i17) {
            i18 = ((i20 - i17) / 2) + i14;
        } else {
            i18 = i14;
        }
        int i21 = (i18 + i10) - i12;
        int i22 = (i18 + i13) - i11;
        int[] iArr = {i21, i22};
        if (H7.a.b()) {
            H7.b.e("ContactsTouchSearchView", "updateLayoutMargins: boundsTopY: " + i10 + ", boundsBottomY: " + i11 + ", parentTopY: " + i12 + ", parentBottomY: " + i13 + ", minGap: " + i14 + ", maxDisplayHeight: " + i15 + ", boundsHeight: " + i19 + ", availableHeight: " + i20 + ", gap: " + i18 + ", calcTotalItemHeight: " + i16 + ", displayHeight: " + i17 + ", marginTop: " + i21 + ", marginBottom: " + i22);
        }
        return iArr;
    }

    private void setItemRestore(int i10) {
        K(i10, false);
        Drawable b10 = this.f22533n0.get(i10).b();
        String d10 = this.f22533n0.get(i10).d();
        I(i10, b10);
        M();
        requestLayout();
        if (d10 != null && this.f22542s0 != null) {
            int[] u10 = u(i10);
            ColorStateList colorStateList = this.f22542s0;
            this.f22533n0.get(i10).f22561h.setColor(colorStateList.getColorForState(u10, colorStateList.getDefaultColor()));
            M();
            requestLayout();
        }
    }

    public final void A(int i10, int i11, int i12, int i13) {
        int[] o10 = o(i10, i11, i12, i13, this.f22502T, this.f22503U, p());
        int i14 = (i11 - i10) - (this.f22502T * 2);
        if (i14 <= 0) {
            H7.b.i("ContactsTouchSearchView", "updateLayoutMargins: Iillegal availableHeight: " + i14);
            return;
        }
        int i15 = o10[0];
        int i16 = o10[1];
        if (i15 >= 0 && i16 >= 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                layoutParams.height = -1;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i15;
                marginLayoutParams.bottomMargin = i16;
                setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        H7.b.i("ContactsTouchSearchView", "updateLayoutMargins: Iillegal margin: [" + i15 + ", " + i16 + "]");
    }

    public final void B(View view, View view2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String str;
        String str2;
        if (getParent() instanceof View) {
            View view3 = (View) getParent();
            int c10 = com.oplus.foundation.util.ui.d.c(view3);
            int height = view3.getHeight() + c10;
            int i15 = 0;
            if (view != null) {
                i10 = com.oplus.foundation.util.ui.d.c(view);
            } else {
                i10 = 0;
            }
            if (view != null) {
                i11 = view.getHeight();
            } else {
                i11 = 0;
            }
            if (view2 != null) {
                i12 = com.oplus.foundation.util.ui.d.c(view2);
            } else {
                i12 = 0;
            }
            if (view2 != null) {
                i15 = view2.getHeight();
            }
            if (view != null) {
                i13 = i10 + i11;
            } else {
                i13 = c10;
            }
            if (view2 != null) {
                i14 = i12;
            } else {
                i14 = height;
            }
            if (H7.a.b()) {
                if (view != null) {
                    str = "topView[" + view.getClass().getSimpleName() + "], visible: " + view.getVisibility() + ", height: " + i11 + ", Y: " + i10;
                } else {
                    str = "No topView";
                }
                if (view2 != null) {
                    str2 = "bottomView[" + view2.getClass().getSimpleName() + "], visible: " + view2.getVisibility() + ", height: " + i15 + ", Y: " + i12;
                } else {
                    str2 = "No bottomView";
                }
                H7.b.e("ContactsTouchSearchView", "updateLayoutMargins: " + str + ", " + str2);
            }
            A(i13, i14, c10, height);
        }
    }

    public final void C(int i10, int i11) {
        CharSequence e10;
        int i12;
        if (!D()) {
            return;
        }
        int v10 = v(i10, i11, this.f22533n0);
        if (!this.f22540r) {
            if (this.f22485H0) {
                w(i11);
                int[] iArr = this.f22489J0;
                int i13 = iArr[0];
                if (i13 >= 0 && (i12 = iArr[1]) >= 0) {
                    this.f22525j0 = i13;
                    e10 = this.f22522i[i12];
                } else {
                    H7.b.i("ContactsTouchSearchView", "invalidateKey: mKeyIndexAndOriginalIndex not set: x: " + i10 + ", y: " + i11);
                    return;
                }
            } else {
                this.f22525j0 = v10;
                if (TextUtils.isEmpty(this.f22533n0.get(v10).f22560g)) {
                    e10 = "*";
                } else {
                    e10 = this.f22533n0.get(this.f22525j0).f22560g;
                }
            }
        } else {
            c cVar = new c();
            this.f22525j0 = v10;
            cVar.f22554a = this.f22524j[v10];
            e10 = cVar.e(i10, i11, this.f22510c, this.f22549y);
        }
        if (e10 != null && !e10.equals(this.f22549y)) {
            F(e10.toString(), this.f22533n0.get(this.f22525j0).c() - this.f22512d, this.f22533n0.get(this.f22525j0).f() - this.f22514e);
            String charSequence = e10.toString();
            this.f22551z = charSequence;
            d dVar = this.f22530m;
            if (dVar != null) {
                dVar.onKey(charSequence);
            }
            int i14 = this.f22525j0;
            if (i14 != this.f22535o0 && -1 != i14) {
                H();
            }
            if (!this.f22540r) {
                int length = this.f22522i.length;
                int i15 = this.f22525j0;
                if (i15 != this.f22535o0 && -1 != i15) {
                    this.f22471A0 = true;
                    K(i15, true);
                    Drawable b10 = this.f22533n0.get(this.f22525j0).b();
                    String d10 = this.f22533n0.get(this.f22525j0).d();
                    I(this.f22525j0, b10);
                    M();
                    requestLayout();
                    if (d10 != null && this.f22542s0 != null) {
                        int[] u10 = u(this.f22525j0);
                        ColorStateList colorStateList = this.f22542s0;
                        this.f22533n0.get(this.f22525j0).f22561h.setColor(colorStateList.getColorForState(u10, colorStateList.getDefaultColor()));
                        invalidate();
                        M();
                        requestLayout();
                    }
                }
                int i16 = this.f22535o0;
                if (-1 != i16 && this.f22525j0 != i16 && i16 < this.f22533n0.size()) {
                    setItemRestore(this.f22535o0);
                }
                this.f22535o0 = this.f22525j0;
            }
        }
    }

    public final boolean D() {
        String[] strArr = this.f22528l;
        if (strArr == null) {
            return true;
        }
        if (strArr != null && !strArr[0].equals(" ") && this.f22528l.length >= 5) {
            return true;
        }
        return false;
    }

    public int[] E(int i10, int i11) {
        int i12;
        int intValue = this.f22493L0.get(i10).intValue();
        if ((this.f22493L0.get(i10).intValue() & 16384) != 0) {
            i12 = 16;
        } else {
            i12 = 0;
        }
        if ((intValue & 32) == 0) {
            i12 |= 8;
        }
        if (hasWindowFocus()) {
            i12 |= 1;
        }
        int[] iArr = f22464P0[i10][i12];
        H7.a.b();
        if (i11 == 0) {
            return iArr;
        }
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length + i11];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return new int[i11];
    }

    public final void F(CharSequence charSequence, int i10, int i11) {
        if (this.f22476D == null) {
            return;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "onKeyChanged --- display = " + ((Object) charSequence));
        }
        this.f22519g0.setText(charSequence);
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i12 = (iArr[0] + i10) - this.f22478E;
        int i13 = (iArr[1] + i11) - (this.f22480F >> 1);
        int i14 = this.f22497O;
        if (i13 < i14) {
            i13 = i14;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "localx = " + i12);
            H7.b.b("ContactsTouchSearchView", "localy = " + i13);
        }
        if (charSequence.equals("*")) {
            this.f22517f0.setVisibility(8);
            this.f22515e0.setVisibility(8);
        }
        if (this.f22476D.isShowing()) {
            this.f22476D.update(this.f22494M, this.f22496N, this.f22478E, this.f22480F);
        } else {
            this.f22476D.showAtLocation(this, 0, this.f22494M, this.f22496N);
        }
    }

    public void I(int i10, Drawable drawable) {
        this.f22493L0.set(i10, Integer.valueOf(this.f22493L0.get(i10).intValue() | 1024));
        y(i10, drawable);
    }

    public final void K(int i10, boolean z10) {
        int i11;
        int intValue = this.f22493L0.get(i10).intValue();
        if (z10) {
            i11 = intValue | 16384;
        } else {
            i11 = intValue & (-16385);
        }
        this.f22493L0.set(i10, Integer.valueOf(i11));
    }

    public void L(Object[] objArr, int[] iArr) {
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "setSmartShowMode,the sections is " + Arrays.toString(objArr));
        }
        if (objArr != null && iArr != null) {
            if (!((String) objArr[0]).equals(" ")) {
                int length = objArr.length;
                int length2 = iArr.length;
                if (length > 27) {
                    this.f22526k = true;
                    String[] strArr = new String[27];
                    this.f22528l = strArr;
                    strArr[0] = (String) objArr[0];
                    strArr[26] = (String) objArr[length - 1];
                    int i10 = length2 - 1;
                    int[] iArr2 = (int[]) iArr.clone();
                    for (int i11 = 25; i11 > 0; i11--) {
                        int i12 = 0;
                        int i13 = 0;
                        for (int i14 = 1; i14 < i10; i14++) {
                            int i15 = iArr2[i14];
                            if (i15 > i13) {
                                i12 = i14;
                                i13 = i15;
                            }
                        }
                        iArr2[i12] = 0;
                    }
                    int i16 = 1;
                    for (int i17 = 1; i17 < i10; i17++) {
                        if (iArr2[i17] == 0) {
                            this.f22528l[i16] = (String) objArr[i17];
                            i16++;
                        }
                    }
                } else {
                    this.f22526k = false;
                    this.f22528l = new String[length];
                    int i18 = 0;
                    for (Object obj : objArr) {
                        this.f22528l[i18] = (String) obj;
                        i18++;
                    }
                }
                this.f22522i = this.f22528l;
                if (H7.a.b()) {
                    H7.b.b("ContactsTouchSearchView", "setSmartShowMode,the KEYS is " + Arrays.toString(this.f22522i));
                }
                z();
                this.f22534o = true;
                requestLayout();
                return;
            }
        }
        this.f22528l = new String[]{" "};
        this.f22534o = true;
        requestLayout();
    }

    public final void M() {
        int i10;
        S();
        if (!D() || this.f22533n0.size() <= 0) {
            return;
        }
        int size = this.f22533n0.size();
        int paddingTop = getPaddingTop();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "updateKeys --- exactHeight  = " + height);
        }
        this.f22508b = getWidth();
        int i11 = height / size;
        this.f22510c = i11;
        int i12 = paddingTop + ((height % size) >> 1);
        this.f22514e = (i11 - this.f22518g) / 2;
        int dimensionPixelSize = (getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.coui_touchsearch_each_item_height) - this.f22518g) / 2;
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "updateKeys --- mKeyPaddingY  = " + this.f22514e);
        }
        Rect rect = this.f22511c0;
        if (rect != null) {
            int i13 = rect.left;
            this.f22512d = i13 + (((rect.right - i13) - this.f22516f) / 2);
        }
        this.f22533n0.get(0).g(this.f22512d);
        this.f22533n0.get(0).h(this.f22514e + i12);
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        setLocationY(iArr[1] - getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.TouchSearchView_popup_offset));
        if (this.f22537p0) {
            i10 = this.f22510c;
        } else {
            i10 = this.f22510c - dimensionPixelSize;
        }
        int i14 = i12 + i10;
        for (int i15 = 1; i15 < size; i15++) {
            this.f22533n0.get(i15).g(this.f22512d);
            this.f22533n0.get(i15).h(this.f22514e + i14);
            i14 += this.f22510c;
        }
    }

    public final void N() {
        int i10;
        int i11;
        int i12 = this.f22470A;
        if (i12 == 0) {
            int width = getWidth();
            int i13 = this.f22513d0;
            i10 = (width - i13) / 2;
            i11 = i13 + i10;
        } else if (i12 == 2) {
            i11 = getWidth() - this.f22474C;
            i10 = i11 - this.f22513d0;
        } else {
            i10 = this.f22472B;
            i11 = i10 + this.f22513d0;
        }
        this.f22511c0 = new Rect(i10, 0, i11, getBottom() - getTop());
    }

    public void O(View view, View view2) {
        this.f22505W = view;
        this.f22507a0 = view2;
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public final void P(int i10) {
        if (i10 <= 12) {
            this.f22529l0 = 2;
        } else if (i10 <= 16) {
            this.f22529l0 = 4;
        } else {
            this.f22529l0 = 6;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "updateMaxNameNum: keyCount: " + i10 + ", mMaxNameNum: " + this.f22529l0);
        }
    }

    public final void Q() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i10 = iArr[0];
        if (ContactsApplication.f13094j) {
            this.f22494M = (i10 + this.f22499Q) - this.f22478E;
        } else {
            this.f22494M = (i10 + getWidth()) - this.f22499Q;
        }
    }

    public final void S() {
        if (!this.f22547x) {
            this.f22540r = false;
            return;
        }
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "initCellSize --- exactHeight  = " + height);
        }
        this.f22508b = getWidth();
        if (this.f22533n0.size() <= 0) {
            return;
        }
        this.f22510c = height / this.f22533n0.size();
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "initCellSize --- mCellHeight [1] = " + this.f22510c);
        }
        int i10 = this.f22510c;
        if (i10 < this.f22518g && i10 < 0) {
            this.f22518g = i10;
            this.f22516f = i10;
            this.f22540r = false;
        } else {
            this.f22540r = false;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "initCellSize --- mWhetherUnion= " + this.f22540r);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        e eVar = this.f22532n;
        if (eVar != null && !eVar.a()) {
            PopupWindow popupWindow = this.f22476D;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f22509b0 = -1;
                this.f22536p = false;
                this.f22551z = "";
                invalidate();
                r();
            }
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public PopupWindow getPopupWindow() {
        return this.f22476D;
    }

    public d getTouchSearchActionListener() {
        return this.f22530m;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            this.f22523i0 = text;
            this.f22530m.onNameClick(text);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int i10 = this.f22535o0;
        if (-1 != i10 && this.f22525j0 != i10 && i10 < this.f22533n0.size()) {
            setItemRestore(this.f22535o0);
        }
        int size = this.f22533n0.size();
        int i11 = this.f22525j0;
        if (i11 > -1 && i11 < size) {
            setItemRestore(i11);
        }
        this.f22535o0 = -1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        M();
        s(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (H7.a.b()) {
            H7.b.e("ContactsTouchSearchView", "onLayout left= " + i10 + " top= " + i11 + " right= " + i12 + " bottom= " + i13 + " mFrameChanged= " + this.f22538q + " mFirstLayout= " + this.f22534o);
        }
        if (this.f22534o || this.f22538q) {
            if (this.f22528l != null) {
                H7.b.b("ContactsTouchSearchView", "the mSections is" + Arrays.toString(this.f22528l));
            }
            N();
            R();
            if (this.f22534o) {
                this.f22534o = false;
            }
            if (this.f22538q) {
                this.f22538q = false;
            }
        }
        Q();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.f22538q = true;
        super.onSizeChanged(i10, i11, i12, i13);
        if (i11 != i13) {
            H7.b.b("ContactsTouchSearchView", "onSizeChanged: height changed: " + i13 + " -> " + i11);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerId(motionEvent.getActionIndex()) > 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            G(motionEvent);
                            if (H7.a.b()) {
                                H7.b.b("ContactsTouchSearchView", "onTouchEvent --- pointer up --- mActivePointerId = " + this.f22509b0);
                            }
                        }
                        return true;
                    }
                }
            }
            this.f22509b0 = -1;
            this.f22536p = false;
            this.f22551z = "";
            invalidate();
            return true;
        }
        Q();
        this.f22536p = true;
        this.f22509b0 = motionEvent.getPointerId(0);
        invalidate();
        int findPointerIndex = motionEvent.findPointerIndex(this.f22509b0);
        C((int) motionEvent.getX(findPointerIndex), (int) motionEvent.getY(findPointerIndex));
        return true;
    }

    public final int p() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.coui_touchsearch_each_item_height);
        int length = this.f22522i.length;
        int characterStartIndex = ((length - getCharacterStartIndex()) * dimensionPixelSize) + (this.f22479E0 * (length - 1));
        if (!this.f22537p0) {
            return characterStartIndex + this.f22518g;
        }
        return characterStartIndex;
    }

    public void q(boolean z10) {
        if (z10) {
            this.f22499Q = getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_edit_right_margin);
        } else {
            this.f22499Q = getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_right_margin);
        }
        Q();
    }

    public void r() {
        c cVar;
        int i10 = this.f22535o0;
        if (-1 != i10 && this.f22525j0 != i10 && i10 < this.f22533n0.size()) {
            setItemRestore(this.f22535o0);
        }
        if (!this.f22476D.isShowing() && !this.f22540r) {
            int size = this.f22533n0.size();
            int i11 = this.f22525j0;
            if (i11 > -1 && i11 < size && (cVar = this.f22533n0.get(i11)) != null && TextUtils.equals("*", cVar.d()) && this.f22471A0 && !this.f22473B0) {
                setItemRestore(this.f22525j0);
                this.f22471A0 = false;
                this.f22535o0 = -1;
            }
        }
        if (this.f22476D.isShowing()) {
            if (!this.f22540r) {
                int size2 = this.f22533n0.size();
                int i12 = this.f22525j0;
                if (i12 > -1 && i12 < size2) {
                    setItemRestore(i12);
                    M();
                    requestLayout();
                    this.f22535o0 = -1;
                }
            }
            this.f22476D.dismiss();
        }
    }

    public final void s(Canvas canvas) {
        if (!D()) {
            return;
        }
        if (!this.f22537p0 && this.f22533n0.size() > 0 && this.f22533n0.get(0).b() != null) {
            int c10 = this.f22533n0.get(0).c();
            int f10 = this.f22533n0.get(0).f();
            this.f22531m0.setBounds(c10, f10, this.f22516f + c10, this.f22518g + f10);
            this.f22531m0.draw(canvas);
        }
        int size = this.f22533n0.size();
        for (int characterStartIndex = getCharacterStartIndex(); characterStartIndex < size; characterStartIndex++) {
            Paint.FontMetricsInt fontMetricsInt = this.f22533n0.get(characterStartIndex).f22561h.getFontMetricsInt();
            TextPaint textPaint = this.f22533n0.get(characterStartIndex).f22561h;
            String str = this.f22533n0.get(characterStartIndex).f22560g;
            if (str != null) {
                canvas.drawText(str, this.f22533n0.get(characterStartIndex).c() + ((this.f22516f - ((int) textPaint.measureText(str))) / 2), this.f22533n0.get(characterStartIndex).f() - fontMetricsInt.top, textPaint);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(null);
    }

    public void setCharTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f22541r0 = colorStateList;
        }
    }

    public void setCharTextSize(int i10) {
        if (i10 != 0) {
            this.f22544u0 = i10;
        }
    }

    public void setFirstKeyPopupDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f22519g0.setText((CharSequence) null);
            this.f22519g0.setBackground(drawable);
        } else {
            this.f22519g0.setText(this.f22551z);
            this.f22519g0.setBackground(this.f22548x0);
        }
    }

    public void setLocationY(int i10) {
        this.f22496N = i10;
    }

    public void setName(String[] strArr) {
        int length = strArr.length;
        this.f22519g0.setBackground(this.f22548x0);
        if (length > 0) {
            if (length == 1) {
                this.f22517f0.setBackground(this.f22550y0);
                this.f22517f0.setPadding(0, this.f22488J, 0, this.f22490K);
            } else if (length > this.f22529l0) {
                this.f22517f0.setBackground(this.f22552z0);
                this.f22517f0.setPadding(0, this.f22488J, 0, this.f22490K + (this.f22492L / 2));
            } else {
                this.f22517f0.setPadding(0, this.f22488J, 0, this.f22490K);
                this.f22517f0.setBackground(this.f22552z0);
            }
            this.f22517f0.setVisibility(0);
            this.f22515e0.setVisibility(0);
        } else {
            this.f22517f0.setVisibility(8);
            this.f22515e0.setVisibility(8);
        }
        this.f22515e0.removeAllViews();
        if (length > this.f22491K0.size()) {
            LayoutInflater layoutInflater = (LayoutInflater) this.f22506a.getSystemService("layout_inflater");
            int size = length - this.f22491K0.size();
            if (H7.a.b()) {
                H7.b.b("ContactsTouchSearchView", "Name count: " + length + ", cache count: " + this.f22491K0.size() + ", add: " + size);
            }
            for (int i10 = 0; i10 < size; i10++) {
                this.f22491K0.add((TextView) layoutInflater.inflate(com.oplus.dialer.R.layout.touch_search_popup_content_item, (ViewGroup) null));
            }
        }
        if (length <= this.f22491K0.size()) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f22492L);
            int suitableFontSize = (int) COUIChangeTextUtil.getSuitableFontSize(this.f22506a.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_second_textsize), this.f22506a.getResources().getConfiguration().fontScale, 4);
            for (int i11 = 0; i11 < length; i11++) {
                TextView textView = this.f22491K0.get(i11);
                textView.setTextSize(0, suitableFontSize);
                textView.setText(strArr[i11]);
                textView.setOnClickListener(this);
                this.f22515e0.addView(textView, layoutParams);
            }
        } else {
            H7.b.c("ContactsTouchSearchView", "Should not reach here, length: " + length + ", cache count: " + this.f22491K0.size());
        }
        int i12 = this.f22529l0;
        if (length > i12) {
            int i13 = this.f22482G + this.f22484H;
            int i14 = this.f22492L;
            this.f22480F = i13 + (i12 * i14) + i14;
        } else if (length == 1) {
            this.f22480F = this.f22482G + this.f22486I;
        } else {
            this.f22480F = this.f22482G + this.f22484H + (length * this.f22492L);
        }
        this.f22521h0.fullScroll(33);
        if (this.f22476D.isShowing()) {
            this.f22476D.update(this.f22478E, this.f22480F);
        }
    }

    public void setPopupTextView(String str) {
        if (!this.f22476D.isShowing()) {
            this.f22476D.showAtLocation(this, 0, this.f22494M, this.f22496N);
        }
        this.f22519g0.setText(str);
        this.f22525j0 = str.charAt(0) - '?';
        if (str.equals("#")) {
            this.f22525j0 = 1;
        }
        int length = this.f22522i.length;
        int i10 = this.f22525j0;
        if (i10 >= 0 && i10 <= length - 1 && !this.f22540r) {
            M();
            requestLayout();
        }
    }

    public void setPopupWindowTextColor(int i10) {
        if (this.f22501S != i10) {
            this.f22501S = i10;
            this.f22519g0.setTextColor(i10);
            invalidate();
        }
    }

    public void setPopupWindowTextSize(int i10) {
        if (this.f22500R != i10) {
            this.f22500R = i10;
            this.f22519g0.setTextSize(0, i10);
            invalidate();
        }
    }

    public void setPopupWindowTopMinCoordinate(int i10) {
        if (this.f22497O != i10) {
            this.f22497O = i10;
        }
    }

    public void setTouchSearchActionListener(d dVar) {
        this.f22530m = dVar;
    }

    public void setTouchSearchShowListener(e eVar) {
        this.f22532n = eVar;
    }

    public void setUnionEnable(boolean z10) {
        if (this.f22547x != z10) {
            this.f22547x = z10;
            M();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != 0) {
            r();
        }
        super.setVisibility(i10);
    }

    public final int t(int i10, int i11, int i12, int i13, ArrayList<c> arrayList) {
        if (i12 > i13) {
            return -1;
        }
        int i14 = (i12 + i13) / 2;
        int f10 = arrayList.get(i14).f() - this.f22514e;
        int i15 = this.f22510c + f10;
        if (i11 >= f10 && i11 < i15) {
            return i14;
        }
        if (i11 < f10) {
            return t(i10, i11, i12, i14 - 1, arrayList);
        }
        return t(i10, i11, i14 + 1, i13, arrayList);
    }

    public int[] u(int i10) {
        int intValue = this.f22493L0.get(i10).intValue();
        if ((intValue & 1024) != 0) {
            this.f22495M0.set(i10, E(i10, 0));
            this.f22493L0.set(i10, Integer.valueOf(intValue & (-1025)));
        }
        return this.f22495M0.get(i10);
    }

    public final int v(int i10, int i11, ArrayList<c> arrayList) {
        int size = arrayList.size();
        if (size <= 0) {
            return -1;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "getKeyIndices ---  keyCount = " + size);
        }
        int i12 = size - 1;
        int t10 = t(i10, i11, 0, i12, arrayList);
        if (H7.a.b()) {
            H7.b.b("ContactsTouchSearchView", "getKeyIndices ---  primaryIndex = " + t10);
        }
        if (-1 == t10) {
            if (i11 < arrayList.get(0).f() - this.f22514e) {
                return 0;
            }
            if (i11 <= arrayList.get(i12).f() - this.f22514e) {
                if (i11 > arrayList.get(0).f() - this.f22514e && i11 < arrayList.get(i12).f() - this.f22514e) {
                    return size / 2;
                }
            } else {
                return i12;
            }
        }
        return t10;
    }

    public final void w(int i10) {
        int size = this.f22533n0.size();
        int[] iArr = this.f22489J0;
        iArr[0] = -1;
        iArr[1] = -1;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = this.f22533n0.get(i11);
            if (i11 == 0 && i10 < cVar.f22562i) {
                H7.b.i("ContactsTouchSearchView", "getKeyIndicesWithDots: Click outside key area, touchTop: " + cVar.f22562i + ", y: " + i10);
                return;
            }
            if (i10 >= cVar.f22562i && i10 <= cVar.f22563j) {
                int size2 = cVar.f22564k.size();
                if (size2 > 0) {
                    int i12 = cVar.f22563j;
                    int i13 = cVar.f22562i;
                    int max = Math.max(Math.min((i10 - i13) / ((i12 - i13) / size2), size2 - 1), 0);
                    int[] iArr2 = this.f22489J0;
                    iArr2[0] = i11;
                    iArr2[1] = cVar.f22564k.get(max).f22566m;
                    return;
                }
                int[] iArr3 = this.f22489J0;
                iArr3[0] = i11;
                iArr3[1] = cVar.f22566m;
                return;
            }
            if (i11 < size - 1 && i10 > cVar.f22563j) {
                int i14 = i11 + 1;
                if (i10 < this.f22533n0.get(i14).f22562i) {
                    H7.b.i("ContactsTouchSearchView", "getKeyIndicesWithDots: Click outside key area, key.touchBottom: " + cVar.f22563j + ", next touchTop: " + this.f22533n0.get(i14).f22562i + ", y: " + i10);
                    return;
                }
            }
        }
    }

    public final boolean x(View view, View view2) {
        boolean z10;
        boolean z11;
        if (view == null || view.getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (view2 == null || view2.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        H7.b.e("ContactsTouchSearchView", "hasVisibleTopAndBottomViews: topViewVisible: " + z10 + ", bottomViewVisible: " + z11);
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    public void y(int i10, Drawable drawable) {
        int[] u10 = u(i10);
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(u10);
        }
    }

    public final void z() {
        Drawable drawable;
        int length = this.f22522i.length;
        if (length <= 0) {
            return;
        }
        this.f22545v0 = Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0);
        this.f22533n0.clear();
        if (!this.f22537p0 && (drawable = this.f22531m0) != null) {
            this.f22533n0.add(new c(drawable, null));
        }
        if (!this.f22537p0 && !"*".equals(this.f22522i[0])) {
            this.f22533n0.add(new c(null, this.f22522i[0]));
        }
        for (int characterStartIndex = getCharacterStartIndex(); characterStartIndex < length; characterStartIndex++) {
            this.f22533n0.add(new c(null, this.f22522i[characterStartIndex]));
        }
        if (!this.f22537p0 && !"*".equals(this.f22522i[0])) {
            this.f22522i = new String[this.f22533n0.size()];
            for (int i10 = 0; i10 < this.f22533n0.size(); i10++) {
                this.f22522i[i10] = this.f22533n0.get(i10).f22560g;
            }
        }
        for (int i11 = 0; i11 < this.f22533n0.size(); i11++) {
            int[][][] iArr = f22464P0;
            int[][] iArr2 = f22465Q0;
            int[][] iArr3 = new int[iArr2.length];
            iArr[i11] = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        }
        this.f22495M0.clear();
        this.f22493L0.clear();
        for (int i12 = 0; i12 < this.f22533n0.size(); i12++) {
            this.f22495M0.add(new int[f22466R0]);
            this.f22493L0.add(new Integer(0));
            I(i12, this.f22533n0.get(i12).b());
            ColorStateList colorStateList = this.f22542s0;
            if (colorStateList != null) {
                this.f22533n0.get(i12).f22561h.setColor(colorStateList.getColorForState(u(i12), this.f22542s0.getDefaultColor()));
            }
        }
    }

    public TouchSearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22520h = 0;
        this.f22526k = false;
        this.f22534o = true;
        this.f22536p = false;
        this.f22538q = false;
        this.f22540r = false;
        this.f22547x = false;
        this.f22551z = "";
        this.f22504V = -1;
        this.f22509b0 = -1;
        this.f22513d0 = -1;
        this.f22525j0 = -1;
        this.f22527k0 = -1;
        this.f22529l0 = 6;
        this.f22531m0 = null;
        this.f22533n0 = new ArrayList<>();
        this.f22535o0 = -1;
        this.f22537p0 = false;
        this.f22539q0 = null;
        this.f22541r0 = null;
        this.f22542s0 = null;
        this.f22543t0 = 0;
        this.f22544u0 = 0;
        this.f22545v0 = null;
        this.f22471A0 = false;
        this.f22473B0 = false;
        this.f22491K0 = new ArrayList();
        this.f22493L0 = new ArrayList();
        this.f22495M0 = new ArrayList();
        this.f22506a = context;
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V0.f13427f5, i10, com.oplus.dialer.R.style.DefaultContactsTouchSearchView);
        this.f22547x = obtainStyledAttributes.getBoolean(13, true);
        this.f22470A = obtainStyledAttributes.getInt(0, 0);
        this.f22472B = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f22474C = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f22478E = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_default_width);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_default_height);
        this.f22480F = dimensionPixelSize;
        this.f22482G = dimensionPixelSize;
        this.f22484H = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_supplement_height);
        this.f22486I = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_60);
        this.f22488J = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_6);
        this.f22490K = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_8);
        this.f22497O = resources.getInteger(com.oplus.dialer.R.integer.contacts_touchsearch_popupwin_default_top_mincoordinate);
        this.f22500R = obtainStyledAttributes.getDimensionPixelSize(10, -1);
        this.f22501S = context.getColor(com.oplus.dialer.R.color.pb_color_touch_search_text);
        this.f22474C += resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_right_margin);
        this.f22498P = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_top_margin);
        this.f22499Q = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_right_margin);
        this.f22520h = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_char_offset);
        this.f22492L = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_popupwin_sub_height);
        this.f22475C0 = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.coui_touchsearch_min_height);
        this.f22479E0 = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_item_spacing);
        this.f22481F0 = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.coui_touchsearch_touch_padding_start);
        this.f22483G0 = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.coui_touchsearch_touch_padding_end);
        this.f22489J0 = new int[]{-1, -1};
        this.f22496N = this.f22498P;
        this.f22550y0 = context.getDrawable(2131232351);
        this.f22552z0 = context.getDrawable(2131232352);
        this.f22549y = resources.getString(com.oplus.dialer.R.string.contacts_touchsearch_dot);
        this.f22546w0 = context.getDrawable(2131232660);
        this.f22531m0 = obtainStyledAttributes.getDrawable(2);
        this.f22539q0 = obtainStyledAttributes.getColorStateList(3);
        this.f22537p0 = obtainStyledAttributes.getBoolean(1, false);
        Drawable drawable = this.f22531m0;
        if (drawable != null) {
            this.f22516f = drawable.getIntrinsicWidth();
            this.f22518g = this.f22531m0.getIntrinsicHeight();
        }
        this.f22543t0 = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_key_textsize);
        if (-1 == this.f22513d0) {
            this.f22513d0 = resources.getDimensionPixelSize(com.oplus.dialer.R.dimen.contacts_touchsearch_background_width);
        }
        if (!this.f22537p0) {
            this.f22522i = resources.getStringArray(com.oplus.dialer.R.array.contacts_normal_touchsearch_keys);
        } else {
            this.f22522i = resources.getStringArray(com.oplus.dialer.R.array.contacts_special_touchsearch_keys);
        }
        TextPaint textPaint = new TextPaint(1);
        this.f22477D0 = textPaint;
        textPaint.setTextSize(this.f22543t0);
        this.f22524j = resources.getStringArray(com.oplus.dialer.R.array.contacts_union_touchsearch_keys);
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.oplus.dialer.R.layout.touch_search_poppup_preview, (ViewGroup) null);
        COUIPopupWindow cOUIPopupWindow = new COUIPopupWindow(context);
        this.f22476D = cOUIPopupWindow;
        cOUIPopupWindow.setWidth(this.f22478E);
        this.f22476D.setHeight(this.f22480F);
        this.f22476D.setContentView(viewGroup);
        this.f22476D.setAnimationStyle(com.oplus.dialer.R.style.TouchPopupWindow);
        this.f22476D.setBackgroundDrawable(new ColorDrawable(0));
        this.f22476D.setOutsideTouchable(true);
        this.f22476D.setOnDismissListener(this);
        this.f22519g0 = (TextView) viewGroup.findViewById(com.oplus.dialer.R.id.touch_search_popup_top_text_view);
        this.f22519g0.setTextSize(0, (int) COUIChangeTextUtil.getSuitableFontSize(this.f22506a.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.SP_20), this.f22506a.getResources().getConfiguration().fontScale, 4));
        this.f22517f0 = (LinearLayout) viewGroup.findViewById(com.oplus.dialer.R.id.touch_search_popup_content);
        this.f22521h0 = (COUIScrollView) viewGroup.findViewById(com.oplus.dialer.R.id.name_scroll_view);
        this.f22515e0 = (LinearLayout) viewGroup.findViewById(com.oplus.dialer.R.id.touch_search_popup_content_name);
        obtainStyledAttributes.recycle();
        this.f22502T = (int) this.f22506a.getResources().getDimension(com.oplus.dialer.R.dimen.touch_search_view_min_margin);
        this.f22503U = (int) this.f22506a.getResources().getDimension(com.oplus.dialer.R.dimen.touch_search_view_max_height);
        z();
        this.f22548x0 = this.f22506a.getDrawable(2131232353);
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f22554a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f22555b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f22556c;

        /* renamed from: d, reason: collision with root package name */
        public int f22557d;

        /* renamed from: e, reason: collision with root package name */
        public int f22558e;

        /* renamed from: f, reason: collision with root package name */
        public Drawable f22559f;

        /* renamed from: g, reason: collision with root package name */
        public String f22560g;

        /* renamed from: h, reason: collision with root package name */
        public TextPaint f22561h;

        /* renamed from: i, reason: collision with root package name */
        public int f22562i;

        /* renamed from: j, reason: collision with root package name */
        public int f22563j;

        /* renamed from: k, reason: collision with root package name */
        public List<c> f22564k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f22565l;

        /* renamed from: m, reason: collision with root package name */
        public int f22566m;

        public c() {
            this.f22555b = null;
            this.f22556c = null;
            this.f22559f = null;
            this.f22560g = null;
            this.f22561h = null;
            this.f22564k = new ArrayList();
        }

        public Drawable b() {
            Drawable drawable = this.f22559f;
            if (drawable != null) {
                return drawable;
            }
            return null;
        }

        public int c() {
            return this.f22557d;
        }

        public String d() {
            String str = this.f22560g;
            if (str != null) {
                return str;
            }
            return null;
        }

        public CharSequence e(int i10, int i11, int i12, CharSequence charSequence) {
            if (!this.f22554a.equals(charSequence)) {
                return this.f22554a;
            }
            CharSequence charSequence2 = this.f22556c;
            if (charSequence2 == null) {
                return this.f22555b;
            }
            int i13 = this.f22558e;
            if (i11 >= i13 && i11 <= (i12 >> 1) + i13) {
                return this.f22555b;
            }
            if (i11 > i13 + (i12 >> 1)) {
                return charSequence2;
            }
            return this.f22555b;
        }

        public int f() {
            return this.f22558e;
        }

        public void g(int i10) {
            this.f22557d = i10;
        }

        public void h(int i10) {
            this.f22558e = i10;
        }

        public c(Drawable drawable, String str) {
            this.f22555b = null;
            this.f22556c = null;
            this.f22559f = null;
            this.f22560g = null;
            this.f22561h = null;
            this.f22564k = new ArrayList();
            this.f22559f = drawable;
            this.f22560g = str;
            this.f22561h = new TextPaint(1);
            this.f22561h.setTextSize(TouchSearchView.this.f22544u0 == 0 ? TouchSearchView.this.f22543t0 : r3);
            TouchSearchView.this.f22542s0 = TouchSearchView.this.f22541r0;
            if (TouchSearchView.this.f22542s0 == null) {
                TouchSearchView.this.f22542s0 = TouchSearchView.this.f22539q0;
            }
            if (TouchSearchView.this.f22545v0 != null) {
                this.f22561h.setTypeface(TouchSearchView.this.f22545v0);
            }
        }
    }

    public void setTouchBackgroundDrawable(Drawable drawable) {
    }
}
