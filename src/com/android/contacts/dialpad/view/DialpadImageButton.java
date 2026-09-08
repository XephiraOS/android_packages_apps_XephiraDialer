package com.android.contacts.dialpad.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.dialpad.view.DialpadView;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class DialpadImageButton extends FrameLayout {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f14982q = {5, 6, 7, 8};

    /* renamed from: a, reason: collision with root package name */
    public AccessibilityManager f14983a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f14984b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14985c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f14986d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f14987e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f14988f;

    /* renamed from: g, reason: collision with root package name */
    public View f14989g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f14990h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f14991i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f14992j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14993k;

    /* renamed from: l, reason: collision with root package name */
    public double f14994l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14995m;

    /* renamed from: n, reason: collision with root package name */
    public DialpadView.DialpadMode f14996n;

    /* renamed from: o, reason: collision with root package name */
    public int f14997o;

    /* renamed from: p, reason: collision with root package name */
    public b f14998p;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14999a;

        static {
            int[] iArr = new int[DialpadView.DialpadMode.values().length];
            f14999a = iArr;
            try {
                iArr[DialpadView.DialpadMode.PINYIN_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14999a[DialpadView.DialpadMode.INDONESIAN_MODE_EXP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14999a[DialpadView.DialpadMode.TAVEN_MODE_EXP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14999a[DialpadView.DialpadMode.VIETNAMESE_MODE_EXP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14999a[DialpadView.DialpadMode.UKRAINIAN_MODE_EXP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14999a[DialpadView.DialpadMode.RUSSIAN_MODE_EXP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void g0(View view, boolean z10);
    }

    public DialpadImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14984b = new RectF();
        this.f14993k = false;
        this.f14994l = 0.33d;
        this.f14995m = false;
        this.f14997o = 0;
        b(context);
    }

    private void setPlaceHolderHeight(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14989g.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelOffset(i10);
        this.f14989g.setLayoutParams(layoutParams);
        this.f14989g.setVisibility(0);
    }

    public final void a(DialpadView.DialpadMode dialpadMode, int i10) {
        if (this.f14995m) {
            this.f14988f.setLineSpacing(0.0f, 1.0f);
            if (i10 == 0) {
                if (dialpadMode != DialpadView.DialpadMode.PINYIN_MODE && dialpadMode != DialpadView.DialpadMode.INDONESIAN_MODE_EXP && dialpadMode != DialpadView.DialpadMode.VIETNAMESE_MODE_EXP) {
                    if (dialpadMode != DialpadView.DialpadMode.TAIWAN_MODE_EXP && dialpadMode != DialpadView.DialpadMode.TAVEN_MODE_EXP) {
                        if (dialpadMode == DialpadView.DialpadMode.RUSSIAN_MODE_EXP || dialpadMode == DialpadView.DialpadMode.UKRAINIAN_MODE_EXP) {
                            setPlaceHolderHeight(R.dimen.DP_26);
                            return;
                        }
                        return;
                    }
                    setPlaceHolderHeight(R.dimen.DP_12);
                    return;
                }
                setPlaceHolderHeight(R.dimen.DP_14);
                return;
            }
            if (i10 == 9 || i10 == 11) {
                if (dialpadMode != DialpadView.DialpadMode.TAIWAN_MODE_EXP && dialpadMode != DialpadView.DialpadMode.TAVEN_MODE_EXP) {
                    if (dialpadMode == DialpadView.DialpadMode.PINYIN_MODE || dialpadMode == DialpadView.DialpadMode.INDONESIAN_MODE_EXP || dialpadMode == DialpadView.DialpadMode.RUSSIAN_MODE_EXP || dialpadMode == DialpadView.DialpadMode.UKRAINIAN_MODE_EXP || dialpadMode == DialpadView.DialpadMode.VIETNAMESE_MODE_EXP || dialpadMode == DialpadView.DialpadMode.STROKE_MODE) {
                        setPlaceHolderHeight(R.dimen.DP_2);
                        return;
                    }
                    return;
                }
                setPlaceHolderHeight(R.dimen.DP_14);
            }
        }
    }

    public final void b(Context context) {
        this.f14983a = (AccessibilityManager) context.getSystemService("accessibility");
        this.f14997o = context.getResources().getDimensionPixelSize(R.dimen.DP_28);
    }

    public final boolean c(int i10) {
        for (int i11 : f14982q) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public final void d(boolean z10) {
        b bVar = this.f14998p;
        if (bVar != null) {
            bVar.g0(this, z10);
        }
    }

    public void e(int i10, int i11, String str) {
        if (A7.a.a() && !this.f14995m) {
            this.f14986d.setImageResource(i10);
            this.f14986d.setVisibility(0);
            this.f14987e.setVisibility(8);
        } else if (i11 > 8 && i11 != 10) {
            this.f14986d.setImageResource(i10);
            this.f14986d.setVisibility(0);
            this.f14987e.setVisibility(8);
        } else {
            this.f14987e.setText(str);
            this.f14986d.setVisibility(8);
            this.f14987e.setVisibility(0);
        }
    }

    public void f(DialpadView.DialpadMode dialpadMode, int i10) {
        setMode(dialpadMode);
        if (i10 == 0) {
            switch (a.f14999a[dialpadMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    setPlaceHolderHeight(R.dimen.DP_2);
                    break;
                case 5:
                case 6:
                    setPlaceHolderHeight(R.dimen.dialpad_place_holder_height_russia);
                    break;
                default:
                    this.f14989g.setVisibility(8);
                    break;
            }
        } else {
            this.f14989g.setVisibility(8);
            if (dialpadMode == DialpadView.DialpadMode.STROKE_MODE && c(i10)) {
                setPlaceHolderHeight(R.dimen.dialpad_place_holder_height_stroke);
            }
        }
        a(dialpadMode, i10);
    }

    public final void g() {
        if (this.f14985c) {
            return;
        }
        this.f14985c = true;
        d(true);
        performClick();
        this.f14985c = false;
    }

    public final void h(int i10, int i11, int i12, int i13) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14990h.getLayoutParams();
        layoutParams.gravity = i10;
        layoutParams.setMarginStart(i11);
        this.f14990h.setLayoutParams(layoutParams);
        this.f14990h.setOrientation(i12);
        this.f14990h.setGravity(i13);
    }

    public void i(boolean z10, boolean z11, int i10) {
        if (z10) {
            if (getWidth() > 0) {
                h(16, (int) (getWidth() * this.f14994l), 0, 16);
            } else {
                this.f14993k = true;
            }
            this.f14990h.setOrientation(0);
            this.f14990h.setGravity(16);
            this.f14988f.setGravity(8388611);
            k(0);
            j(getResources().getDimensionPixelSize(R.dimen.dialpad_button_letter_view_margin), 8388611);
            if (z11) {
                m((int) (getResources().getDimensionPixelSize(R.dimen.DP_18) * 0.875d), (int) (getResources().getDimensionPixelSize(R.dimen.DP_24) * 0.875d));
            } else {
                m(-2, -2);
            }
        } else {
            h(17, 0, 1, 1);
            this.f14988f.setGravity(17);
            if (A7.a.a() && !this.f14995m) {
                k(getResources().getDimensionPixelSize(R.dimen.dialpad_button_letter_view_margin));
            } else {
                k(0);
            }
            j(0, 1);
            m(-2, -2);
        }
        n(i10, z10);
        l(z11);
    }

    public final void j(int i10, int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14991i.getLayoutParams();
        layoutParams.setMarginStart(i10);
        this.f14991i.setLayoutParams(layoutParams);
        this.f14991i.setGravity(i11);
    }

    public final void k(int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14992j.getLayoutParams();
        layoutParams.topMargin = i10;
        this.f14992j.setLayoutParams(layoutParams);
    }

    public final void l(boolean z10) {
        if (A7.a.a() && !this.f14995m) {
            return;
        }
        if (z10) {
            this.f14987e.setTextSize(0, (int) (this.f14997o * 0.875d));
        } else {
            this.f14987e.setTextSize(0, this.f14997o);
        }
    }

    public final void m(int i10, int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14986d.getLayoutParams();
        layoutParams.height = i11;
        layoutParams.width = i10;
        this.f14986d.setLayoutParams(layoutParams);
    }

    public void n(int i10, boolean z10) {
        if (A7.a.a() && !this.f14995m) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14987e.getLayoutParams();
        if (z10) {
            layoutParams.bottomMargin = 0;
        } else if (this.f14996n == DialpadView.DialpadMode.STROKE_MODE) {
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.bottomMargin = -getResources().getDimensionPixelSize(R.dimen.DP_6);
        }
        this.f14987e.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f14986d.getLayoutParams();
        if (z10) {
            layoutParams2.bottomMargin = 0;
            layoutParams2.topMargin = 0;
        } else if (i10 != 9 && i10 != 11) {
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
        } else {
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.DP_6);
            layoutParams2.bottomMargin = -getResources().getDimensionPixelSize(R.dimen.DP_8);
        }
        this.f14986d.setLayoutParams(layoutParams2);
        if (z10) {
            this.f14988f.setPaddingRelative(0, 0, 0, 0);
            return;
        }
        if (i10 == 9) {
            this.f14988f.setPaddingRelative(0, getResources().getDimensionPixelSize(R.dimen.DP_3), 0, 0);
        } else if (i10 == 11) {
            this.f14988f.setPaddingRelative(0, getResources().getDimensionPixelSize(R.dimen.DP_6), 0, 0);
        } else {
            this.f14988f.setPaddingRelative(0, 0, 0, 0);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f14986d = (ImageView) findViewById(R.id.dialpad_key_num);
        this.f14987e = (TextView) findViewById(R.id.number_text);
        this.f14988f = (TextView) findViewById(R.id.dialpad_key_letter);
        this.f14989g = findViewById(R.id.place_holder);
        this.f14990h = (LinearLayout) findViewById(R.id.dialpad_button);
        this.f14991i = (LinearLayout) findViewById(R.id.dialpad_key_letter_container);
        this.f14992j = (ImageView) findViewById(R.id.dialpad_key_icon);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.f14983a.isEnabled() && this.f14983a.isTouchExplorationEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 9) {
                if (actionMasked == 10) {
                    if (this.f14984b.contains(motionEvent.getX(), motionEvent.getY())) {
                        g();
                    }
                    setClickable(true);
                }
            } else {
                setClickable(false);
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f14984b.left = getPaddingLeft();
        this.f14984b.right = i10 - getPaddingRight();
        this.f14984b.top = getPaddingTop();
        this.f14984b.bottom = i11 - getPaddingBottom();
        if (this.f14993k) {
            h(16, (int) (i10 * this.f14994l), 0, 16);
            this.f14993k = false;
        }
    }

    public void setLetterIcon(int i10) {
        if (i10 < 0) {
            this.f14992j.setVisibility(8);
        } else {
            this.f14992j.setImageResource(i10);
            this.f14992j.setVisibility(0);
        }
    }

    public void setLetterText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f14988f.setVisibility(8);
        } else {
            this.f14988f.setText(charSequence);
            this.f14988f.setVisibility(0);
        }
    }

    public void setLetterTextColor(ColorStateList colorStateList) {
        this.f14988f.setTextColor(colorStateList);
    }

    public void setMode(DialpadView.DialpadMode dialpadMode) {
        this.f14996n = dialpadMode;
        if (dialpadMode == DialpadView.DialpadMode.STROKE_MODE) {
            this.f14994l = 0.38d;
            return;
        }
        if (dialpadMode == DialpadView.DialpadMode.PINYIN_MODE) {
            this.f14994l = 0.33d;
        } else if (dialpadMode != DialpadView.DialpadMode.TAIWAN_MODE_EXP && dialpadMode != DialpadView.DialpadMode.RUSSIAN_MODE_EXP && dialpadMode != DialpadView.DialpadMode.UKRAINIAN_MODE_EXP) {
            this.f14994l = 0.33d;
        } else {
            this.f14994l = 0.27d;
        }
    }

    public void setNumberTextColor(ColorStateList colorStateList) {
        this.f14987e.setTextColor(colorStateList);
    }

    public void setNumberTextSize(int i10) {
        this.f14987e.setTextSize(0, i10);
    }

    public void setOnPressedListener(b bVar) {
        this.f14998p = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        super.setPressed(z10);
        d(z10);
    }

    public void setScene(boolean z10) {
        this.f14995m = z10;
    }
}
