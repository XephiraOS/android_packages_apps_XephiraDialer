package com.customize.contacts.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oua.util.BitmapUtil;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class FinderView extends FrameLayout {

    /* renamed from: A, reason: collision with root package name */
    public int f22352A;

    /* renamed from: B, reason: collision with root package name */
    public HashMap<Integer, Drawable> f22353B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f22354a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f22355b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f22356c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22357d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22358e;

    /* renamed from: f, reason: collision with root package name */
    public int f22359f;

    /* renamed from: g, reason: collision with root package name */
    public int f22360g;

    /* renamed from: h, reason: collision with root package name */
    public int f22361h;

    /* renamed from: i, reason: collision with root package name */
    public int f22362i;

    /* renamed from: j, reason: collision with root package name */
    public int f22363j;

    /* renamed from: k, reason: collision with root package name */
    public int f22364k;

    /* renamed from: l, reason: collision with root package name */
    public int f22365l;

    /* renamed from: m, reason: collision with root package name */
    public int f22366m;

    /* renamed from: n, reason: collision with root package name */
    public int f22367n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f22368o;

    /* renamed from: p, reason: collision with root package name */
    public int f22369p;

    /* renamed from: q, reason: collision with root package name */
    public ViewPropertyAnimator f22370q;

    /* renamed from: r, reason: collision with root package name */
    public float f22371r;

    /* renamed from: x, reason: collision with root package name */
    public int f22372x;

    /* renamed from: y, reason: collision with root package name */
    public int f22373y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f22374z;

    public FinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        int i10;
        TextView textView = new TextView(getContext());
        textView.setText(getResources().getString(R.string.qrcode_scan_tips));
        textView.setTextColor(-1);
        textView.setMaxLines(2);
        textView.setTextSize(2, 12.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setBackground(androidx.core.content.b.e(getContext(), R.drawable.pb_bg_camera_text_tip));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        Resources resources = getResources();
        if (this.f22357d) {
            i10 = R.dimen.qrcode_tip_margin_top;
        } else {
            i10 = R.dimen.qrcode_tip_unfold_margin_top;
        }
        layoutParams.topMargin = resources.getDimensionPixelSize(i10);
        this.f22368o = textView;
        addView(textView, layoutParams);
    }

    public void b(boolean z10) {
        this.f22374z = z10;
        if (z10) {
            postInvalidate();
        }
    }

    public void c(int i10, boolean z10) {
        this.f22360g = this.f22362i;
        this.f22361h = this.f22363j;
        ViewPropertyAnimator viewPropertyAnimator = this.f22370q;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        ViewPropertyAnimator animate = this.f22368o.animate();
        this.f22370q = animate;
        if (z10) {
            animate.setDuration(300L);
        } else {
            animate.setDuration(0L);
        }
        if (i10 != 0) {
            if (i10 != 90) {
                if (i10 != 180) {
                    if (i10 == 270) {
                        if (this.f22368o.getRotation() < 0.0f && this.f22369p == 180) {
                            this.f22368o.setRotation(180.0f);
                        }
                        this.f22370q.rotation(90.0f);
                        this.f22370q.translationX(((this.f22372x - this.f22368o.getHeight()) * 0.5f) - this.f22371r);
                        this.f22370q.translationY(((this.f22373y - this.f22368o.getHeight()) * 0.5f) - this.f22371r);
                        this.f22370q.start();
                    }
                } else {
                    if (this.f22369p == 90) {
                        this.f22370q.rotation(-180.0f);
                    } else {
                        this.f22370q.rotation(180.0f);
                    }
                    this.f22370q.translationX(0.0f);
                    this.f22370q.translationY(((this.f22373y - this.f22368o.getHeight()) - (this.f22371r * 2.0f)) - this.f22352A);
                    this.f22370q.start();
                }
            } else {
                if (this.f22368o.getRotation() > 0.0f && this.f22369p == 180) {
                    this.f22368o.setRotation(-180.0f);
                }
                this.f22370q.rotation(-90.0f);
                this.f22370q.translationX((((-this.f22372x) + this.f22368o.getHeight()) * 0.5f) + this.f22371r);
                this.f22370q.translationY(((this.f22373y - this.f22368o.getHeight()) * 0.5f) - this.f22371r);
                this.f22370q.start();
            }
        } else {
            this.f22370q.rotation(0.0f);
            this.f22370q.translationX(0.0f);
            this.f22370q.translationY(0.0f);
            this.f22370q.start();
        }
        this.f22369p = i10;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f22357d) {
            Drawable drawable = this.f22353B.get(0);
            this.f22356c = drawable;
            if (this.f22360g > this.f22364k) {
                this.f22360g = this.f22362i;
            }
            int i10 = this.f22360g + 10;
            this.f22360g = i10;
            if (this.f22357d && drawable != null) {
                drawable.setBounds(0, i10, DisplayUtil.f(this.f22354a, true), this.f22360g + this.f22366m);
            }
        } else {
            int i11 = this.f22369p;
            if (i11 == 90) {
                if (this.f22361h > this.f22365l) {
                    this.f22361h = this.f22363j;
                }
                this.f22361h += 10;
                Drawable drawable2 = this.f22353B.get(90);
                this.f22356c = drawable2;
                if (drawable2 != null) {
                    int i12 = this.f22361h;
                    drawable2.setBounds(i12, 0, this.f22366m + i12, DisplayUtil.e(this.f22354a, true));
                }
            } else if (i11 == 270) {
                if (this.f22361h <= 0) {
                    this.f22361h = this.f22365l;
                }
                this.f22361h -= 10;
                Drawable drawable3 = this.f22353B.get(270);
                this.f22356c = drawable3;
                if (drawable3 != null) {
                    int i13 = this.f22361h;
                    drawable3.setBounds(i13, 0, this.f22366m + i13, DisplayUtil.e(this.f22354a, true));
                }
            } else if (i11 == 180) {
                this.f22356c = this.f22353B.get(180);
                if (this.f22360g <= 0) {
                    this.f22360g = this.f22364k;
                }
                this.f22360g -= 10;
                int f10 = (DisplayUtil.f(this.f22354a, true) - this.f22372x) / 2;
                int f11 = DisplayUtil.f(this.f22354a, true) - f10;
                Drawable drawable4 = this.f22356c;
                if (drawable4 != null) {
                    int i14 = this.f22360g;
                    drawable4.setBounds(f10, i14, f11, this.f22366m + i14);
                }
            } else {
                this.f22356c = this.f22353B.get(0);
                if (this.f22360g > this.f22364k) {
                    this.f22360g = this.f22362i;
                }
                this.f22360g += 10;
                int f12 = (DisplayUtil.f(this.f22354a, true) - this.f22372x) / 2;
                int f13 = DisplayUtil.f(this.f22354a, true) - f12;
                Drawable drawable5 = this.f22356c;
                if (drawable5 != null) {
                    int i15 = this.f22360g;
                    drawable5.setBounds(f12, i15, f13, this.f22366m + i15);
                }
            }
        }
        Drawable drawable6 = this.f22356c;
        if (drawable6 != null) {
            drawable6.draw(canvas);
        }
        if (this.f22374z) {
            postInvalidate(0, 0, DisplayUtil.f(this.f22354a, true), DisplayUtil.e(this.f22354a, true) - this.f22367n);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
    }

    public void setBottomHeight(int i10) {
        if (this.f22364k == 0) {
            this.f22367n = i10;
            this.f22364k = ((DisplayUtil.e(this.f22354a, true) - this.f22367n) - 10) - this.f22366m;
            this.f22365l = ((DisplayUtil.f(this.f22354a, true) - this.f22367n) - 10) - this.f22366m;
        }
    }

    public void setFoldSideWidth(int i10) {
        if (this.f22364k == 0) {
            this.f22372x = i10;
            int e10 = DisplayUtil.e(this.f22354a, true);
            this.f22373y = e10;
            int i11 = this.f22366m;
            this.f22364k = (e10 - 10) - i11;
            this.f22365l = (this.f22372x - 10) - i11;
        }
    }

    public FinderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22374z = true;
        this.f22352A = 0;
        setWillNotDraw(false);
        this.f22355b = true;
        this.f22354a = context;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), 2131232623);
        HashMap<Integer, Drawable> hashMap = new HashMap<>();
        this.f22353B = hashMap;
        hashMap.put(0, new BitmapDrawable(context.getResources(), BitmapUtil.rotate(decodeResource, 0.0f)));
        this.f22353B.put(90, new BitmapDrawable(context.getResources(), BitmapUtil.rotate(decodeResource, 270.0f)));
        this.f22353B.put(180, new BitmapDrawable(context.getResources(), BitmapUtil.rotate(decodeResource, 180.0f)));
        this.f22353B.put(270, new BitmapDrawable(context.getResources(), BitmapUtil.rotate(decodeResource, 90.0f)));
        this.f22356c = this.f22353B.get(0);
        this.f22357d = ResponsiveUIConfig.getDefault(context).getUiConfig().getValue().getStatus() != UIConfig.Status.UNFOLD;
        this.f22358e = CommonFeatureOption.m();
        int dimensionPixelSize = this.f22357d ? getResources().getDimensionPixelSize(R.dimen.camera_layout_margin_top) : 0;
        this.f22359f = dimensionPixelSize;
        int i11 = dimensionPixelSize / 3;
        this.f22362i = i11;
        this.f22363j = 0;
        this.f22360g = i11;
        this.f22361h = 0;
        this.f22366m = getResources().getDimensionPixelSize(R.dimen.qrcode_scan_line_height);
        this.f22371r = DisplayUtil.a(context, this.f22357d ? 18 : 44);
        int f10 = DisplayUtil.f(context, true);
        this.f22372x = f10;
        this.f22373y = (f10 * 4) / 3;
        if (this.f22357d && CommonFeatureOption.k()) {
            this.f22352A = DisplayUtil.d(context) + getResources().getDimensionPixelSize(R.dimen.DP_16);
        }
    }
}
