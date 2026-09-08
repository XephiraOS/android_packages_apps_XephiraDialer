package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.framework.baseui.util.r;

/* compiled from: ContactsRecommendView.kt */
/* loaded from: classes.dex */
public final class ContactsRecommendView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public static final a f15999i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public TextView f16000a;

    /* renamed from: b, reason: collision with root package name */
    public View f16001b;

    /* renamed from: c, reason: collision with root package name */
    public View f16002c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f16003d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f16004e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f16005f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f16006g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f16007h;

    /* compiled from: ContactsRecommendView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public ContactsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static final void c(ContactsRecommendView this$0, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        TextView textView = this$0.f16000a;
        View view = null;
        if (textView == null) {
            kotlin.jvm.internal.i.q("recommendText");
            textView = null;
        }
        textView.setLayoutParams(layoutParams);
        View view2 = this$0.f16001b;
        if (view2 == null) {
            kotlin.jvm.internal.i.q("actionLayout");
        } else {
            view = view2;
        }
        view.setLayoutParams(layoutParams2);
    }

    public static final boolean d(View view, MotionEvent motionEvent) {
        return true;
    }

    public final void e(int i10, String title, int i11, int i12) {
        kotlin.jvm.internal.i.f(title, "title");
        if (i10 > 0 && i11 > 0 && i12 > 0) {
            ImageView imageView = this.f16003d;
            TextView textView = null;
            if (imageView == null) {
                kotlin.jvm.internal.i.q("icon");
                imageView = null;
            }
            imageView.setImageResource(i10);
            TextView textView2 = this.f16000a;
            if (textView2 == null) {
                kotlin.jvm.internal.i.q("recommendText");
                textView2 = null;
            }
            textView2.setText(title);
            TextView textView3 = this.f16005f;
            if (textView3 == null) {
                kotlin.jvm.internal.i.q("actionText");
                textView3 = null;
            }
            textView3.setText(i11);
            TextView textView4 = this.f16004e;
            if (textView4 == null) {
                kotlin.jvm.internal.i.q("dismissText");
            } else {
                textView = textView4;
            }
            textView.setText(i12);
        }
    }

    public final View.OnClickListener getActionViewClickListener() {
        return this.f16006g;
    }

    public final View.OnClickListener getDismissViewClickListener() {
        return this.f16007h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        View.OnClickListener onClickListener;
        kotlin.jvm.internal.i.f(v10, "v");
        int id = v10.getId();
        if (id == N0.i.f1925c) {
            View.OnClickListener onClickListener2 = this.f16006g;
            if (onClickListener2 != null) {
                onClickListener2.onClick(v10);
                return;
            }
            return;
        }
        if (id == N0.i.f1935m && (onClickListener = this.f16007h) != null) {
            onClickListener.onClick(v10);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(N0.i.f1944v);
        kotlin.jvm.internal.i.c(findViewById);
        this.f16000a = (TextView) findViewById;
        View findViewById2 = findViewById(N0.i.f1921C);
        kotlin.jvm.internal.i.c(findViewById2);
        this.f16001b = findViewById2;
        View findViewById3 = findViewById(N0.i.f1930h);
        kotlin.jvm.internal.i.c(findViewById3);
        this.f16002c = findViewById3;
        View findViewById4 = findViewById(N0.i.f1935m);
        kotlin.jvm.internal.i.c(findViewById4);
        this.f16004e = (TextView) findViewById4;
        View findViewById5 = findViewById(N0.i.f1925c);
        kotlin.jvm.internal.i.c(findViewById5);
        this.f16005f = (TextView) findViewById5;
        View findViewById6 = findViewById(N0.i.f1939q);
        kotlin.jvm.internal.i.c(findViewById6);
        this.f16003d = (ImageView) findViewById6;
        TextView textView = this.f16004e;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.i.q("dismissText");
            textView = null;
        }
        textView.setOnClickListener(this);
        TextView textView3 = this.f16005f;
        if (textView3 == null) {
            kotlin.jvm.internal.i.q("actionText");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(this);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        TextView textView = this.f16000a;
        TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.i.q("recommendText");
            textView = null;
        }
        int width = textView.getWidth();
        View view = this.f16001b;
        if (view == null) {
            kotlin.jvm.internal.i.q("actionLayout");
            view = null;
        }
        int width2 = view.getWidth();
        View view2 = this.f16002c;
        if (view2 == null) {
            kotlin.jvm.internal.i.q("container");
            view2 = null;
        }
        int width3 = view2.getWidth();
        int dimensionPixelSize = getResources().getDimensionPixelSize(N0.f.f1874J);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(N0.f.f1873I);
        TextView textView3 = this.f16000a;
        if (textView3 == null) {
            kotlin.jvm.internal.i.q("recommendText");
            textView3 = null;
        }
        final ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
        View view3 = this.f16001b;
        if (view3 == null) {
            kotlin.jvm.internal.i.q("actionLayout");
            view3 = null;
        }
        final ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
        ImageView imageView = this.f16003d;
        if (imageView == null) {
            kotlin.jvm.internal.i.q("icon");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (layoutParams2 instanceof ViewGroup.MarginLayoutParams) && (layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
            if (width + width2 > (width3 - dimensionPixelSize) - dimensionPixelSize2) {
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(N0.f.f1883i);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i14 = marginLayoutParams.topMargin + dimensionPixelSize3;
                TextView textView4 = this.f16000a;
                if (textView4 == null) {
                    kotlin.jvm.internal.i.q("recommendText");
                } else {
                    textView2 = textView4;
                }
                int height = i14 + textView2.getHeight();
                if (marginLayoutParams.bottomMargin != dimensionPixelSize3 || ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin != height) {
                    marginLayoutParams.bottomMargin = dimensionPixelSize3;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = height;
                } else {
                    return;
                }
            } else {
                int dimensionPixelSize4 = getResources().getDimensionPixelSize(N0.f.f1877c);
                int dimensionPixelSize5 = getResources().getDimensionPixelSize(N0.f.f1876b);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams2.bottomMargin != dimensionPixelSize4 || ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin != dimensionPixelSize5) {
                    marginLayoutParams2.bottomMargin = dimensionPixelSize4;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelSize5;
                } else {
                    return;
                }
            }
            post(new Runnable() { // from class: com.android.contacts.framework.baseui.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsRecommendView.c(ContactsRecommendView.this, layoutParams, layoutParams2);
                }
            });
        }
    }

    public final void setActionViewClickListener(View.OnClickListener onClickListener) {
        this.f16006g = onClickListener;
    }

    public final void setDismissViewClickListener(View.OnClickListener onClickListener) {
        this.f16007h = onClickListener;
    }

    public final void setEditMode(boolean z10) {
        TextView textView = null;
        if (z10) {
            ImageView imageView = this.f16003d;
            if (imageView == null) {
                kotlin.jvm.internal.i.q("icon");
                imageView = null;
            }
            imageView.setAlpha(0.6f);
            TextView textView2 = this.f16005f;
            if (textView2 == null) {
                kotlin.jvm.internal.i.q("actionText");
                textView2 = null;
            }
            Context context = getContext();
            int i10 = N0.e.f1853b;
            textView2.setTextColor(context.getColor(i10));
            TextView textView3 = this.f16004e;
            if (textView3 == null) {
                kotlin.jvm.internal.i.q("dismissText");
                textView3 = null;
            }
            textView3.setTextColor(getContext().getColor(i10));
            setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.framework.baseui.widget.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean d10;
                    d10 = ContactsRecommendView.d(view, motionEvent);
                    return d10;
                }
            });
        } else {
            ImageView imageView2 = this.f16003d;
            if (imageView2 == null) {
                kotlin.jvm.internal.i.q("icon");
                imageView2 = null;
            }
            imageView2.setAlpha(1.0f);
            TextView textView4 = this.f16005f;
            if (textView4 == null) {
                kotlin.jvm.internal.i.q("actionText");
                textView4 = null;
            }
            textView4.setTextColor(r.a(getContext()));
            TextView textView5 = this.f16004e;
            if (textView5 == null) {
                kotlin.jvm.internal.i.q("dismissText");
                textView5 = null;
            }
            textView5.setTextColor(r.a(getContext()));
            setOnTouchListener(null);
        }
        TextView textView6 = this.f16005f;
        if (textView6 == null) {
            kotlin.jvm.internal.i.q("actionText");
            textView6 = null;
        }
        textView6.setEnabled(!z10);
        TextView textView7 = this.f16004e;
        if (textView7 == null) {
            kotlin.jvm.internal.i.q("dismissText");
        } else {
            textView = textView7;
        }
        textView.setEnabled(!z10);
    }
}
