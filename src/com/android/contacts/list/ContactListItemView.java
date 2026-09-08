package com.android.contacts.list;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.android.contacts.C0656n;
import com.android.contacts.ContactsApplication;
import com.android.contacts.V0;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.o;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.util.C0700a;
import com.android.contacts.util.z;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.U;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w0.C1643c;

/* loaded from: classes.dex */
public class ContactListItemView extends ViewGroup implements AbsListView.SelectionBoundsAdjuster {

    /* renamed from: I0, reason: collision with root package name */
    public static final PhotoPosition f16756I0 = PhotoPosition.LEFT;

    /* renamed from: J0, reason: collision with root package name */
    public static final Pattern f16757J0 = Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");

    /* renamed from: A, reason: collision with root package name */
    public boolean f16758A;

    /* renamed from: A0, reason: collision with root package name */
    public int f16759A0;

    /* renamed from: B, reason: collision with root package name */
    public final Drawable f16760B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f16761B0;

    /* renamed from: C, reason: collision with root package name */
    public final int f16762C;

    /* renamed from: C0, reason: collision with root package name */
    public final Rect f16763C0;

    /* renamed from: D, reason: collision with root package name */
    public boolean f16764D;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f16765D0;

    /* renamed from: E, reason: collision with root package name */
    public final int f16766E;

    /* renamed from: E0, reason: collision with root package name */
    public final B0.b f16767E0;

    /* renamed from: F, reason: collision with root package name */
    public final int f16768F;

    /* renamed from: F0, reason: collision with root package name */
    public final B0.c f16769F0;

    /* renamed from: G, reason: collision with root package name */
    public PhotoPosition f16770G;

    /* renamed from: G0, reason: collision with root package name */
    public CharSequence f16771G0;

    /* renamed from: H, reason: collision with root package name */
    public boolean f16772H;

    /* renamed from: H0, reason: collision with root package name */
    public ImageView f16773H0;

    /* renamed from: I, reason: collision with root package name */
    public int f16774I;

    /* renamed from: J, reason: collision with root package name */
    public TextView f16775J;

    /* renamed from: K, reason: collision with root package name */
    public ViewGroup f16776K;

    /* renamed from: L, reason: collision with root package name */
    public int f16777L;

    /* renamed from: M, reason: collision with root package name */
    public final boolean f16778M;

    /* renamed from: N, reason: collision with root package name */
    public QuickContactBadge f16779N;

    /* renamed from: O, reason: collision with root package name */
    public ImageView f16780O;

    /* renamed from: P, reason: collision with root package name */
    public TextView f16781P;

    /* renamed from: Q, reason: collision with root package name */
    public TextView f16782Q;

    /* renamed from: R, reason: collision with root package name */
    public TextView f16783R;

    /* renamed from: S, reason: collision with root package name */
    public TextView f16784S;

    /* renamed from: T, reason: collision with root package name */
    public TextView f16785T;

    /* renamed from: U, reason: collision with root package name */
    public TextView f16786U;

    /* renamed from: V, reason: collision with root package name */
    public TextView f16787V;

    /* renamed from: W, reason: collision with root package name */
    public TextView f16788W;

    /* renamed from: a, reason: collision with root package name */
    public final Context f16789a;

    /* renamed from: a0, reason: collision with root package name */
    public ImageView f16790a0;

    /* renamed from: b, reason: collision with root package name */
    public final int f16791b;

    /* renamed from: b0, reason: collision with root package name */
    public char[] f16792b0;

    /* renamed from: c, reason: collision with root package name */
    public final int f16793c;

    /* renamed from: c0, reason: collision with root package name */
    public ImageView f16794c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f16795d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f16796d0;

    /* renamed from: e, reason: collision with root package name */
    public final int f16797e;

    /* renamed from: e0, reason: collision with root package name */
    public CheckBox f16798e0;

    /* renamed from: f, reason: collision with root package name */
    public final int f16799f;

    /* renamed from: f0, reason: collision with root package name */
    public final int f16800f0;

    /* renamed from: g, reason: collision with root package name */
    public final int f16801g;

    /* renamed from: g0, reason: collision with root package name */
    public final int f16802g0;

    /* renamed from: h, reason: collision with root package name */
    public final int f16803h;

    /* renamed from: h0, reason: collision with root package name */
    public final int f16804h0;

    /* renamed from: i, reason: collision with root package name */
    public final int f16805i;

    /* renamed from: i0, reason: collision with root package name */
    public final int f16806i0;

    /* renamed from: j, reason: collision with root package name */
    public final int f16807j;

    /* renamed from: j0, reason: collision with root package name */
    public int f16808j0;

    /* renamed from: k, reason: collision with root package name */
    public final int f16809k;

    /* renamed from: k0, reason: collision with root package name */
    public int f16810k0;

    /* renamed from: l, reason: collision with root package name */
    public final int f16811l;

    /* renamed from: l0, reason: collision with root package name */
    public int f16812l0;

    /* renamed from: m, reason: collision with root package name */
    public final int f16813m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f16814m0;

    /* renamed from: n, reason: collision with root package name */
    public final ColorStateList f16815n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f16816n0;

    /* renamed from: o, reason: collision with root package name */
    public final ColorStateList f16817o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f16818o0;

    /* renamed from: p, reason: collision with root package name */
    public final CharArrayBuffer f16819p;

    /* renamed from: p0, reason: collision with root package name */
    public int f16820p0;

    /* renamed from: q, reason: collision with root package name */
    public final CharArrayBuffer f16821q;

    /* renamed from: q0, reason: collision with root package name */
    public int f16822q0;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f16823r;

    /* renamed from: r0, reason: collision with root package name */
    public int f16824r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f16825s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f16826t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f16827u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f16828v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f16829w0;

    /* renamed from: x, reason: collision with root package name */
    public final Drawable f16830x;

    /* renamed from: x0, reason: collision with root package name */
    public int f16831x0;

    /* renamed from: y, reason: collision with root package name */
    public int f16832y;

    /* renamed from: y0, reason: collision with root package name */
    public int f16833y0;

    /* renamed from: z, reason: collision with root package name */
    public int f16834z;

    /* renamed from: z0, reason: collision with root package name */
    public final int f16835z0;

    /* loaded from: classes.dex */
    public enum PhotoPosition {
        LEFT,
        RIGHT
    }

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public ContactListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16819p = new CharArrayBuffer(128);
        this.f16821q = new CharArrayBuffer(128);
        this.f16823r = new int[]{R.attr.state_list_checked};
        this.f16758A = true;
        this.f16764D = false;
        this.f16770G = f16756I0;
        this.f16778M = false;
        this.f16818o0 = false;
        this.f16763C0 = new Rect();
        this.f16765D0 = false;
        this.f16789a = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, V0.f13480n2);
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            this.f16830x = drawable;
            Drawable drawable2 = obtainStyledAttributes.getDrawable(7);
            this.f16760B = drawable2;
            this.f16791b = obtainStyledAttributes.getDimensionPixelOffset(8, 0);
            this.f16793c = obtainStyledAttributes.getDimensionPixelOffset(9, 0);
            this.f16795d = obtainStyledAttributes.getDimensionPixelOffset(18, 4);
            this.f16797e = obtainStyledAttributes.getDimensionPixelOffset(19, 16);
            this.f16808j0 = obtainStyledAttributes.getDimensionPixelOffset(17, 0);
            this.f16799f = obtainStyledAttributes.getDimensionPixelOffset(11, 0);
            this.f16800f0 = getResources().getDimensionPixelOffset(R.dimen.list_common_margin);
            this.f16815n = getContext().getColorStateList(R.color.coui_preference_title_color);
            this.f16817o = getContext().getColorStateList(R.color.coui_preference_secondary_text_color);
            this.f16802g0 = getResources().getDimensionPixelSize(R.dimen.list_check_margin_right);
            this.f16835z0 = getResources().getDimensionPixelSize(R.dimen.DP_14);
            this.f16804h0 = getResources().getDimensionPixelOffset(R.dimen.DP_40);
            this.f16806i0 = getResources().getDimensionPixelOffset(R.dimen.DP_16);
            this.f16774I = obtainStyledAttributes.getDimensionPixelSize(10, 40);
            this.f16801g = obtainStyledAttributes.getDimensionPixelSize(5, 12);
            this.f16803h = obtainStyledAttributes.getColor(4, -16777216);
            this.f16813m = obtainStyledAttributes.getInteger(6, 5);
            this.f16811l = obtainStyledAttributes.getInteger(14, 3);
            this.f16805i = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.f16807j = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            this.f16809k = getResources().getDimensionPixelOffset(R.dimen.DP_24);
            setPadding(obtainStyledAttributes.getDimensionPixelOffset(15, 0), 0, obtainStyledAttributes.getDimensionPixelOffset(16, 0), 0);
            int a10 = r.a(getContext());
            this.f16767E0 = new B0.b(a10);
            this.f16769F0 = new B0.c(a10);
            obtainStyledAttributes.recycle();
            this.f16762C = drawable2.getIntrinsicHeight();
            if (drawable != null) {
                drawable.setCallback(this);
            }
            setForceDarkAllowed(false);
            setBackgroundResource(R.drawable.select_list_item_background_seletor);
            this.f16766E = getResources().getDimensionPixelSize(R.dimen.list_common_margin);
            this.f16768F = getResources().getDimensionPixelSize(R.dimen.TouchSearchView_width);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private static TextUtils.TruncateAt getTextEllipsis() {
        return TextUtils.TruncateAt.END;
    }

    public static void h(TextView textView, CharSequence charSequence) {
        if (charSequence == null) {
            textView.setText(ContactsApplication.h().getResources().getString(R.string.missing_name));
            return;
        }
        TextUtils.TruncateAt textEllipsis = getTextEllipsis();
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        if (textEllipsis == truncateAt) {
            if (C0637b.h()) {
                charSequence = C0637b.c(charSequence.toString());
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(truncateAt, 0, spannableString.length(), 33);
            textView.setText(spannableString);
            return;
        }
        textView.setText(charSequence);
    }

    private void setViewEnable(boolean z10) {
        CheckBox checkBox = this.f16798e0;
        if (checkBox == null) {
            CheckBox checkView = getCheckView();
            this.f16798e0 = checkView;
            checkView.setEnabled(z10);
        } else {
            checkBox.setEnabled(z10);
        }
        TextView textView = this.f16786U;
        if (textView != null) {
            textView.setEnabled(z10);
        }
        this.f16781P.setEnabled(z10);
        this.f16785T.setEnabled(z10);
    }

    public static String u(String str, int i10, int i11) {
        int i12 = i10;
        int i13 = i11;
        while (true) {
            if (i12 < str.length()) {
                if (!Character.isLetterOrDigit(str.charAt(i12))) {
                    i11 = i13;
                    break;
                }
                i13--;
                i12++;
            } else {
                i12 = i10;
                break;
            }
        }
        int i14 = i11;
        for (int i15 = i10 - 1; i15 > -1 && i11 > 0; i15--) {
            if (!Character.isLetterOrDigit(str.charAt(i15))) {
                i14 = i11;
                i10 = i15;
            }
            i11--;
        }
        int i16 = i12;
        while (i12 < str.length() && i14 > 0) {
            if (!Character.isLetterOrDigit(str.charAt(i12))) {
                i16 = i12;
            }
            i14--;
            i12++;
        }
        StringBuilder sb = new StringBuilder();
        if (i10 > 0) {
            sb.append("...");
        }
        sb.append(str.substring(i10, i16));
        if (i16 < str.length()) {
            sb.append("...");
        }
        return sb.toString();
    }

    public static List<String> v(String str) {
        Matcher matcher = f16757J0.matcher(str);
        ArrayList f10 = n.f();
        while (matcher.find()) {
            f10.add(matcher.group());
        }
        return f10;
    }

    public final void a() {
        int i10;
        if (!this.f16818o0) {
            if (this.f16780O != null) {
                this.f16810k0 = getDefaultPhotoViewSize();
                this.f16812l0 = getDefaultPhotoViewSize();
            } else {
                int defaultPhotoViewSize = getDefaultPhotoViewSize();
                if (this.f16814m0) {
                    i10 = defaultPhotoViewSize;
                } else {
                    i10 = 0;
                }
                this.f16810k0 = i10;
                if (!this.f16816n0) {
                    defaultPhotoViewSize = 0;
                }
                this.f16812l0 = defaultPhotoViewSize;
            }
            this.f16818o0 = true;
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        int i10 = rect.top;
        Rect rect2 = this.f16763C0;
        int i11 = i10 + rect2.top;
        rect.top = i11;
        rect.bottom = i11 + rect2.height();
        rect.left += this.f16832y;
        rect.right -= this.f16834z;
    }

    public int[] b(String str) {
        if (str != null && str.length() >= 12) {
            int i10 = 0;
            if (!str.startsWith("999", 0)) {
                int length = str.length();
                int[] iArr = new int[(length / 3) - 3];
                int i11 = 9;
                while (i11 < length) {
                    int i12 = i10 + 1;
                    try {
                        iArr[i10] = ((str.charAt(i11) - '0') * 100) + ((str.charAt(i11 + 1) - '0') * 10) + (str.charAt(i11 + 2) - '0');
                        i11 += 3;
                        i10 = i12;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return iArr;
            }
        }
        return null;
    }

    public boolean c(View view) {
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void d() {
        e(false, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f16761B0 && isActivated()) {
            this.f16830x.draw(canvas);
        }
        if (this.f16758A) {
            this.f16760B.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f16761B0) {
            this.f16830x.setState(getDrawableState());
        }
    }

    public void e(boolean z10, boolean z11) {
        boolean z12 = false;
        this.f16818o0 = false;
        if (z10 && U.d()) {
            z12 = true;
        }
        this.f16814m0 = z12;
        this.f16816n0 = z11;
        ImageView imageView = this.f16780O;
        if (imageView != null) {
            removeView(imageView);
            this.f16780O = null;
        }
        QuickContactBadge quickContactBadge = this.f16779N;
        if (quickContactBadge != null) {
            removeView(quickContactBadge);
            this.f16779N = null;
        }
    }

    public void f(int i10, boolean z10) {
        CheckBox checkBox = this.f16798e0;
        if (checkBox != null) {
            checkBox.setVisibility(i10);
            if (z10) {
                super.requestLayout();
            }
        }
    }

    public void g(char[] cArr, int i10) {
        if (cArr != null && i10 != 0) {
            getDataView();
            i(this.f16785T, cArr, i10);
            this.f16785T.setVisibility(0);
            if (this.f16765D0) {
                q(cArr, i10);
                return;
            }
            return;
        }
        TextView textView = this.f16785T;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public ImageView getAccountIconView() {
        if (this.f16773H0 == null) {
            ImageView imageView = new ImageView(this.f16789a);
            this.f16773H0 = imageView;
            addView(imageView);
        }
        return this.f16773H0;
    }

    public CheckBox getCheckView() {
        if (this.f16798e0 == null) {
            CheckBox checkBox = new CheckBox(this.f16789a);
            this.f16798e0 = checkBox;
            checkBox.setId(R.id.listview_scrollchoice_checkbox);
            this.f16798e0.setVisibility(8);
            this.f16798e0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f16798e0.setPadding(0, 0, 0, 0);
            this.f16798e0.setBackground(null);
            addView(this.f16798e0);
        }
        return this.f16798e0;
    }

    public TextView getCountView() {
        if (this.f16788W == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16788W = textView;
            textView.setEllipsize(getTextEllipsis());
            this.f16788W.setTextAppearance(this.f16789a, R.style.LargeTextStyle);
            this.f16788W.setTextColor(r.a(this.f16789a));
            this.f16788W.setPadding(this.f16799f, 0, 0, 0);
            this.f16788W.setTextAlignment(5);
            addView(this.f16788W);
        }
        return this.f16788W;
    }

    public TextView getDataView() {
        if (this.f16785T == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16785T = textView;
            textView.setEllipsize(getTextEllipsis());
            this.f16785T.setTextAppearance(this.f16789a, R.style.SmallTextStyle);
            this.f16785T.setTextColor(this.f16817o);
            if (ContactsApplication.f13094j) {
                this.f16785T.setTextDirection(3);
                this.f16785T.setGravity(5);
            }
            this.f16785T.setTextAlignment(5);
            this.f16785T.setActivated(isActivated());
            addView(this.f16785T);
        }
        return this.f16785T;
    }

    public int getDefaultPhotoViewSize() {
        return this.f16808j0;
    }

    public TextView getLabelView() {
        if (this.f16784S == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16784S = textView;
            textView.setEllipsize(getTextEllipsis());
            this.f16784S.setTextAppearance(this.f16789a, R.style.SmallTextStyle);
            this.f16784S.setTextColor(this.f16817o);
            if (this.f16770G == PhotoPosition.LEFT) {
                this.f16784S.setAllCaps(true);
                this.f16784S.setGravity(5);
            } else {
                TextView textView2 = this.f16784S;
                textView2.setTypeface(textView2.getTypeface(), 0);
            }
            this.f16784S.setTextAlignment(5);
            this.f16784S.setActivated(isActivated());
            addView(this.f16784S);
        }
        return this.f16784S;
    }

    public TextView getNameTextView() {
        if (this.f16781P == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16781P = textView;
            textView.setTextAlignment(5);
            this.f16781P.setEllipsize(getTextEllipsis());
            this.f16781P.setActivated(isActivated());
            this.f16781P.setGravity(16);
            this.f16781P.setTextColor(this.f16815n);
            this.f16781P.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.SP_16));
            this.f16781P.setTypeface(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
            addView(this.f16781P);
        }
        return this.f16781P;
    }

    public TextView getPhoneticNameTextView() {
        if (this.f16783R == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16783R = textView;
            textView.setEllipsize(getTextEllipsis());
            this.f16783R.setTextAppearance(this.f16789a, R.style.SmallTextStyle);
            TextView textView2 = this.f16783R;
            textView2.setTypeface(textView2.getTypeface(), 0);
            this.f16783R.setActivated(isActivated());
            this.f16783R.setPadding(this.f16799f, 0, 0, 0);
            this.f16783R.setTextAlignment(5);
            addView(this.f16783R);
        }
        return this.f16783R;
    }

    public PhotoPosition getPhotoPosition() {
        return this.f16770G;
    }

    public ImageView getPhotoView() {
        ImageView imageView;
        if (this.f16780O == null && U.d()) {
            COUIRoundImageView cOUIRoundImageView = new COUIRoundImageView(this.f16789a, null);
            this.f16780O = cOUIRoundImageView;
            cOUIRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16780O.setBackgroundDrawable(null);
            ImageView imageView2 = this.f16780O;
            if (imageView2 instanceof COUIRoundImageView) {
                ((COUIRoundImageView) imageView2).setBorderRectRadius(getResources().getDimensionPixelSize(R.dimen.DP_8));
            }
            addView(this.f16780O);
            this.f16818o0 = false;
        } else if (!U.d() && (imageView = this.f16780O) != null) {
            removeView(imageView);
            this.f16780O = null;
            this.f16818o0 = false;
        }
        return this.f16780O;
    }

    public QuickContactBadge getQuickContact() {
        if (this.f16779N == null) {
            QuickContactBadge quickContactBadge = new QuickContactBadge(this.f16789a, null, android.R.attr.quickContactBadgeStyleWindowMedium);
            this.f16779N = quickContactBadge;
            quickContactBadge.setScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView textView = this.f16781P;
            if (textView != null) {
                this.f16779N.setContentDescription(this.f16789a.getString(R.string.description_quick_contact_for, textView.getText()));
            }
            addView(this.f16779N);
            this.f16818o0 = false;
        }
        return this.f16779N;
    }

    public TextView getRcsView() {
        if (this.f16782Q == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16782Q = textView;
            textView.setTextAlignment(5);
            this.f16782Q.setEllipsize(getTextEllipsis());
            this.f16782Q.setActivated(isActivated());
            this.f16782Q.setGravity(16);
            this.f16782Q.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f16782Q.setTextColor(getContext().getColor(R.color.coui_color_white));
            this.f16782Q.setBackground(getContext().getDrawable(R.drawable.pb_bg_rcs_tag));
            this.f16782Q.setPadding(getResources().getDimensionPixelSize(R.dimen.DP_3), 0, getResources().getDimensionPixelSize(R.dimen.DP_3), 0);
            this.f16782Q.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.SP_11));
            this.f16782Q.setText("RCS");
            addView(this.f16782Q);
        }
        return this.f16782Q;
    }

    public TextView getSnippetView() {
        if (this.f16786U == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16786U = textView;
            textView.setEllipsize(getTextEllipsis());
            this.f16786U.setTextAppearance(this.f16789a, R.style.SmallTextStyle);
            this.f16786U.setActivated(isActivated());
            this.f16786U.setTextColor(this.f16817o);
            this.f16786U.setTextAlignment(5);
            addView(this.f16786U);
        }
        return this.f16786U;
    }

    public TextView getStatusView() {
        if (this.f16787V == null) {
            TextView textView = new TextView(this.f16789a);
            this.f16787V = textView;
            textView.setEllipsize(getTextEllipsis());
            this.f16787V.setTextAppearance(this.f16789a, R.style.SmallTextStyle);
            this.f16787V.setActivated(isActivated());
            this.f16787V.setTextAlignment(5);
            this.f16787V.setPadding(this.f16799f, 0, 0, 0);
            addView(this.f16787V);
        }
        return this.f16787V;
    }

    public final void i(TextView textView, char[] cArr, int i10) {
        if (getTextEllipsis() == TextUtils.TruncateAt.END) {
            h(textView, new String(cArr, 0, i10));
        } else {
            textView.setText(cArr, 0, i10);
        }
    }

    public final void j(TextView textView, CharSequence charSequence) {
        if (getTextEllipsis() == TextUtils.TruncateAt.END) {
            textView.setText(charSequence);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f16761B0) {
            this.f16830x.jumpToCurrentState();
        }
    }

    public void k(char[] cArr, int i10) {
        if (cArr != null && i10 != 0) {
            getPhoneticNameTextView();
            i(this.f16783R, cArr, i10);
            this.f16783R.setVisibility(0);
        } else {
            TextView textView = this.f16783R;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public void l(Cursor cursor, int i10) {
        cursor.copyStringToBuffer(i10, this.f16819p);
        CharArrayBuffer charArrayBuffer = this.f16819p;
        g(charArrayBuffer.data, charArrayBuffer.sizeCopied);
    }

    public void m(Cursor cursor, int i10, int i11) {
        CharSequence string = cursor.getString(i10);
        if (TextUtils.isEmpty(string)) {
            string = this.f16771G0;
        }
        h(getNameTextView(), string);
        QuickContactBadge quickContactBadge = this.f16779N;
        if (quickContactBadge != null) {
            quickContactBadge.setContentDescription(this.f16789a.getString(R.string.description_quick_contact_for, this.f16781P.getText()));
        }
    }

    public void n(Cursor cursor, int i10, long j10, int i11, int i12) {
        String str;
        int[] iArr;
        String valueOf;
        CharSequence string = cursor.getString(i10);
        if (!TextUtils.isEmpty(string)) {
            if (i12 > -1) {
                str = cursor.getString(i12);
                iArr = b(str);
            } else {
                str = null;
                iArr = null;
            }
            if (iArr != null && iArr.length > 0) {
                string = this.f16767E0.b(string, iArr);
            } else if (iArr == null && str != null) {
                B0.c cVar = this.f16769F0;
                char[] cArr = this.f16792b0;
                if (cArr == null) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(cArr);
                }
                string = cVar.a(string, valueOf);
            }
        } else {
            string = this.f16771G0;
        }
        h(getNameTextView(), string);
        QuickContactBadge quickContactBadge = this.f16779N;
        if (quickContactBadge != null) {
            quickContactBadge.setContentDescription(this.f16789a.getString(R.string.description_quick_contact_for, this.f16781P.getText()));
        }
    }

    public void o(Cursor cursor, int i10) {
        cursor.copyStringToBuffer(i10, this.f16821q);
        CharArrayBuffer charArrayBuffer = this.f16821q;
        int i11 = charArrayBuffer.sizeCopied;
        if (i11 != 0) {
            k(charArrayBuffer.data, i11);
        } else {
            k(null, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f16796d0) {
            int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
            View.mergeDrawableStates(onCreateDrawableState, this.f16823r);
            return onCreateDrawableState;
        }
        return super.onCreateDrawableState(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 1524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.list.ContactListItemView.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingLeft;
        int i12;
        int i13;
        int i14;
        int i15;
        int b10;
        int b11;
        int i16;
        int i17;
        int resolveSize = View.resolveSize(0, i10);
        this.f16820p0 = 0;
        this.f16825s0 = 0;
        this.f16826t0 = 0;
        this.f16827u0 = 0;
        this.f16759A0 = 0;
        this.f16828v0 = 0;
        this.f16829w0 = 0;
        a();
        if (this.f16810k0 <= 0 && !this.f16814m0) {
            paddingLeft = ((resolveSize - getPaddingLeft()) - getPaddingRight()) - this.f16800f0;
            i12 = this.f16802g0;
        } else {
            paddingLeft = (((resolveSize - getPaddingLeft()) - getPaddingRight()) - (this.f16810k0 + this.f16791b)) - this.f16800f0;
            i12 = this.f16802g0;
        }
        int i18 = paddingLeft - i12;
        if (c(this.f16798e0)) {
            this.f16798e0.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i13 = this.f16798e0.getMeasuredWidth();
            i18 = (i18 + this.f16802g0) - this.f16804h0;
        } else {
            i13 = 0;
        }
        if (c(this.f16794c0)) {
            this.f16794c0.measure(View.MeasureSpec.makeMeasureSpec(this.f16835z0, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f16835z0, Integer.MIN_VALUE));
            this.f16833y0 = this.f16794c0.getMeasuredHeight();
        }
        if (c(this.f16781P)) {
            int i19 = i18 - i13;
            if (c(this.f16794c0)) {
                i17 = this.f16794c0.getMeasuredWidth();
            } else {
                i17 = 0;
            }
            int i20 = i19 - i17;
            if (c(this.f16794c0)) {
                i20 -= getResources().getDimensionPixelOffset(R.dimen.DP_8);
            }
            if (c(this.f16798e0)) {
                i20 -= this.f16806i0;
            }
            this.f16781P.measure(View.MeasureSpec.makeMeasureSpec(i20, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16820p0 = this.f16781P.getMeasuredHeight();
            this.f16822q0 = this.f16781P.getMeasuredWidth();
        }
        if (c(this.f16782Q)) {
            this.f16782Q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16824r0 = this.f16782Q.getMeasuredHeight();
        }
        if (c(this.f16783R)) {
            this.f16783R.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16825s0 = this.f16783R.getMeasuredHeight();
        }
        if (c(this.f16785T)) {
            if (c(this.f16784S)) {
                int i21 = i18 - this.f16793c;
                int i22 = this.f16813m;
                int i23 = this.f16811l;
                i15 = (i21 * i22) / (i22 + i23);
                i14 = (i21 * i23) / (i22 + i23);
            } else {
                i14 = 0;
                i15 = i18;
            }
        } else if (c(this.f16784S)) {
            i15 = 0;
            i14 = i18;
        } else {
            i14 = 0;
            i15 = 0;
        }
        if (c(this.f16785T)) {
            int i24 = i15 - i13;
            if (c(this.f16798e0)) {
                i24 -= this.f16806i0;
            }
            this.f16785T.measure(View.MeasureSpec.makeMeasureSpec(i24, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16827u0 = this.f16785T.getMeasuredHeight();
        }
        if (c(this.f16784S)) {
            if (this.f16770G == PhotoPosition.LEFT) {
                i16 = 1073741824;
            } else {
                i16 = Integer.MIN_VALUE;
            }
            this.f16784S.measure(View.MeasureSpec.makeMeasureSpec(i14, i16), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16826t0 = this.f16784S.getMeasuredHeight();
        }
        this.f16759A0 = Math.max(this.f16826t0, this.f16827u0);
        if (c(this.f16786U)) {
            this.f16786U.measure(View.MeasureSpec.makeMeasureSpec(i18 - i13, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16828v0 = this.f16786U.getMeasuredHeight();
        }
        if (c(this.f16790a0)) {
            ImageView imageView = this.f16790a0;
            int i25 = this.f16797e;
            imageView.measure(i25, i25);
            this.f16829w0 = this.f16790a0.getMeasuredHeight();
        }
        if (c(this.f16787V)) {
            if (c(this.f16790a0)) {
                i18 = (i18 - this.f16790a0.getMeasuredWidth()) - this.f16795d;
            }
            this.f16787V.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16829w0 = Math.max(this.f16829w0, this.f16787V.getMeasuredHeight());
        }
        if (c(this.f16773H0)) {
            this.f16773H0.measure(this.f16805i, this.f16807j);
            this.f16831x0 = this.f16773H0.getMeasuredHeight();
        }
        int i26 = this.f16820p0 + this.f16825s0;
        int i27 = this.f16759A0;
        int i28 = this.f16828v0;
        int i29 = i26 + i27 + i28 + this.f16829w0;
        if (i27 <= 0 && i28 <= 0) {
            b10 = i29 + U.a();
            b11 = U.a();
        } else {
            b10 = i29 + U.b();
            b11 = U.b();
        }
        int max = Math.max(b10 + b11, this.f16812l0 + getPaddingTop() + getPaddingBottom());
        if (this.f16758A) {
            max += this.f16762C;
        }
        if (this.f16772H) {
            TextView textView = this.f16788W;
            if (textView != null) {
                textView.measure(View.MeasureSpec.makeMeasureSpec(resolveSize, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            this.f16776K.measure(View.MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f16777L = Math.max(this.f16777L, this.f16776K.getMeasuredHeight());
            int max2 = Math.max(this.f16774I, this.f16775J.getMeasuredHeight());
            this.f16774I = max2;
            max += max2;
        }
        ImageView imageView2 = this.f16780O;
        if (imageView2 != null) {
            imageView2.measure(View.MeasureSpec.makeMeasureSpec(this.f16810k0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f16812l0, 1073741824));
        }
        setMeasuredDimension(resolveSize, max);
    }

    public void p(Cursor cursor, int i10, int i11) {
        int i12;
        Drawable drawable;
        if (C1643c.w()) {
            return;
        }
        String str = null;
        if (!cursor.isNull(i10)) {
            i12 = cursor.getInt(i10);
            drawable = C0656n.a(getContext(), i12);
        } else {
            i12 = 0;
            drawable = null;
        }
        setPresence(drawable);
        if (i11 != 0 && !cursor.isNull(i11)) {
            str = cursor.getString(i11);
        }
        if (str == null && i12 != 0) {
            str = C0656n.b(getContext(), i12);
        }
        setStatus(str);
    }

    public final void q(char[] cArr, int i10) {
        if (FeatureOption.o() && com.android.contacts.framework.api.rcs.a.e() && com.android.contacts.framework.api.rcs.a.c(new String(cArr, 0, i10))) {
            getRcsView();
            this.f16782Q.setVisibility(0);
            setViewEnable(true);
        } else {
            getRcsView();
            this.f16782Q.setVisibility(4);
            removeView(this.f16782Q);
            this.f16782Q = null;
            setViewEnable(false);
        }
    }

    public void r(Cursor cursor, int i10, int i11, long j10, int i12) {
        String str;
        int[] iArr;
        int indexOf;
        String valueOf;
        String str2 = null;
        if (cursor.getColumnCount() <= i12) {
            setSnippet(null);
            return;
        }
        String string = cursor.getString(i10);
        Bundle extras = cursor.getExtras();
        if (i12 > -1) {
            str = cursor.getString(i12);
            iArr = b(str);
        } else {
            str = null;
            iArr = null;
        }
        if (iArr != null && iArr.length > 0) {
            h(getNameTextView(), this.f16767E0.b(cursor.getString(i11), iArr));
            setSnippet(null);
            return;
        }
        if (iArr == null && str != null && str.equals("1000")) {
            TextView nameTextView = getNameTextView();
            B0.c cVar = this.f16769F0;
            String string2 = cursor.getString(i11);
            char[] cArr = this.f16792b0;
            if (cArr == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(cArr);
            }
            h(nameTextView, cVar.a(string2, valueOf));
            setSnippet(null);
            return;
        }
        int i13 = 0;
        if (extras.getBoolean("QUERY_ALL_DATA", false)) {
            String string3 = extras.getString("deferred_snippeting_query");
            if (str != null && str.equals("9999")) {
                setMatchSnippet(w(string, string3));
                return;
            } else {
                t(cursor, string, string3);
                return;
            }
        }
        if (extras.getBoolean("deferred_snippeting")) {
            String string4 = extras.getString("deferred_snippeting_query");
            int columnIndex = cursor.getColumnIndex("display_name");
            if (columnIndex >= 0) {
                str2 = cursor.getString(columnIndex);
            }
            str2 = x(string, string4, str2);
        } else if (string != null) {
            int length = string.length();
            int indexOf2 = string.indexOf(1);
            if (indexOf2 != -1) {
                int lastIndexOf = string.lastIndexOf(10, indexOf2);
                if (lastIndexOf != -1) {
                    i13 = lastIndexOf + 1;
                }
                int lastIndexOf2 = string.lastIndexOf(1);
                if (lastIndexOf2 != -1 && (indexOf = string.indexOf(10, lastIndexOf2)) != -1) {
                    length = indexOf;
                }
                StringBuilder sb = new StringBuilder();
                while (i13 < length) {
                    char charAt = string.charAt(i13);
                    if (charAt != 1) {
                        sb.append(charAt);
                    }
                    i13++;
                }
                str2 = sb.toString();
            }
        } else {
            str2 = string;
        }
        setSnippet(str2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        forceLayout();
    }

    public void s(Cursor cursor, int i10, int i11, long j10, int i12, long j11) {
        int[] iArr;
        String valueOf;
        if (j11 != 0 && j11 != 1) {
            if (i12 > -1) {
                iArr = b(cursor.getString(i12));
            } else {
                iArr = null;
            }
            if (iArr != null && iArr.length > 0) {
                h(getNameTextView(), this.f16767E0.b(cursor.getString(i11), iArr));
                setSnippet(null);
                return;
            }
            if (iArr == null) {
                TextView nameTextView = getNameTextView();
                B0.c cVar = this.f16769F0;
                String string = cursor.getString(i11);
                char[] cArr = this.f16792b0;
                if (cArr == null) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(cArr);
                }
                h(nameTextView, cVar.a(string, valueOf));
                setSnippet(null);
                return;
            }
            return;
        }
        r(cursor, i10, i11, j10, i12);
    }

    public void setAccountIcon(String str) {
        if (!TextUtils.isEmpty(str)) {
            int a10 = C0700a.a(str);
            if (this.f16794c0 == null) {
                ImageView imageView = new ImageView(this.f16789a);
                this.f16794c0 = imageView;
                addView(imageView);
            }
            if (a10 > 0) {
                this.f16794c0.setImageDrawable(this.f16789a.getDrawable(a10));
                this.f16794c0.setVisibility(0);
                return;
            } else {
                this.f16794c0.setVisibility(8);
                return;
            }
        }
        ImageView imageView2 = this.f16794c0;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public void setActivatedStateSupported(boolean z10) {
        this.f16761B0 = z10;
    }

    public void setBottomDividerVisible(boolean z10) {
        this.f16758A = z10;
    }

    public void setChecked(boolean z10) {
        if (this.f16796d0 != z10) {
            this.f16796d0 = z10;
            refreshDrawableState();
        }
    }

    public void setCountView(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f16788W;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        getCountView();
        h(this.f16788W, charSequence);
        this.f16788W.setTextSize(0, this.f16801g);
        this.f16788W.setGravity(16);
        this.f16788W.setTextColor(this.f16803h);
        this.f16788W.setVisibility(0);
    }

    public void setDefaultPhotoViewSize(int i10) {
        this.f16808j0 = i10;
    }

    public void setDividerPaddingLeft(boolean z10) {
        this.f16764D = z10;
    }

    public void setHighlightedPrefix(char[] cArr) {
        String b10;
        char[] cArr2 = null;
        if (cArr == null) {
            b10 = null;
        } else {
            b10 = B0.a.b(String.copyValueOf(cArr));
        }
        if (!TextUtils.isEmpty(b10)) {
            cArr2 = b10.toUpperCase().toCharArray();
        }
        this.f16792b0 = cArr2;
    }

    public void setIsRcsMode(boolean z10) {
        this.f16765D0 = z10;
    }

    public void setLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f16784S;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        getLabelView();
        j(this.f16784S, charSequence);
        this.f16784S.setVisibility(0);
    }

    public void setMatchSnippet(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f16786U;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        getSnippetView().setText(charSequence);
        this.f16786U.setVisibility(0);
    }

    public void setPhoneNumber(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f16785T;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        getDataView();
        j(this.f16785T, charSequence);
        this.f16785T.setVisibility(0);
    }

    public void setPhotoPosition(PhotoPosition photoPosition) {
        this.f16770G = photoPosition;
    }

    public void setPresence(Drawable drawable) {
        if (drawable != null) {
            if (this.f16790a0 == null) {
                ImageView imageView = new ImageView(this.f16789a);
                this.f16790a0 = imageView;
                addView(imageView);
            }
            this.f16790a0.setImageDrawable(drawable);
            this.f16790a0.setScaleType(ImageView.ScaleType.CENTER);
            this.f16790a0.setVisibility(0);
            return;
        }
        ImageView imageView2 = this.f16790a0;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public void setRCSState(String str) {
        if (str == null) {
            TextView textView = this.f16782Q;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        for (String str2 : str.split(",")) {
            if (com.android.contacts.framework.api.rcs.a.e() && com.android.contacts.framework.api.rcs.a.c(str2)) {
                getRcsView();
                this.f16782Q.setVisibility(0);
                return;
            }
        }
        TextView textView2 = this.f16782Q;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    public void setSectionHeader(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f16776K == null) {
                LayoutInflater.from(this.f16789a).inflate(R.layout.contact_listitem_title, (ViewGroup) this, true);
                ViewGroup viewGroup = (ViewGroup) findViewById(R.id.header);
                this.f16776K = viewGroup;
                this.f16775J = (TextView) viewGroup.findViewById(R.id.title);
                if (A7.a.a() || o.e(this.f16789a)) {
                    this.f16776K.setBackground(null);
                }
            }
            this.f16776K.setVisibility(0);
            this.f16776K.setOnTouchListener(new a());
            if (TextUtils.equals(str, "*")) {
                this.f16775J.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.pb_ic_section_star, 0, 0, 0);
                this.f16775J.setText("");
            } else {
                this.f16775J.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                h(this.f16775J, str);
            }
            this.f16775J.setVisibility(0);
            this.f16775J.setTextAlignment(5);
            if (FeatureOption.o()) {
                this.f16775J.setAllCaps(true);
            }
            this.f16772H = true;
            return;
        }
        TextView textView = this.f16775J;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ViewGroup viewGroup2 = this.f16776K;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        this.f16772H = false;
    }

    public void setSnippet(String str) {
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.f16786U;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (C0637b.h()) {
            str = C0637b.c(str);
        }
        this.f16767E0.c(getSnippetView(), str, this.f16792b0);
        this.f16786U.setVisibility(0);
    }

    public void setStatus(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f16787V;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        getStatusView();
        h(this.f16787V, charSequence);
        this.f16787V.setVisibility(0);
    }

    public void setUnknownNameText(CharSequence charSequence) {
        this.f16771G0 = charSequence;
    }

    public final void t(Cursor cursor, String str, String str2) {
        setSnippet(str);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable != this.f16830x && !super.verifyDrawable(drawable)) {
            return false;
        }
        return true;
    }

    public final CharSequence w(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str.trim())) {
            return this.f16769F0.b(str.trim(), z.a(str2.toUpperCase()));
        }
        return null;
    }

    public final String x(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String a10 = z.a(str2.toLowerCase());
            if (!TextUtils.isEmpty(str3)) {
                Iterator<String> it = v(str3.toLowerCase()).iterator();
                while (it.hasNext()) {
                    if (it.next().startsWith(a10)) {
                        return null;
                    }
                }
            }
            z.a c10 = z.c(str, a10);
            if (c10 != null && c10.f17630b != null) {
                int integer = getResources().getInteger(R.integer.snippet_length_before_tokenize);
                if (c10.f17630b.length() > integer) {
                    return u(c10.f17630b, c10.f17629a, integer);
                }
                return c10.f17630b;
            }
        }
        return null;
    }

    public void setDividerVisible(boolean z10) {
    }

    public void setQuickContactEnabled(boolean z10) {
    }
}
