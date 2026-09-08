package com.oplus.blacklistapp.activities;

import C6.a;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.b;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.oplus.blacklistapp.n;
import com.oplus.blacklistapp.o;
import com.oplus.blacklistapp.p;
import com.oplus.utils.C0849j;
import com.oplus.widget.EmptyViewGroup;
import kotlin.jvm.internal.i;

/* compiled from: BaseNavigationActivity.kt */
/* loaded from: classes3.dex */
public abstract class BaseNavigationActivity extends BaseActivity {

    /* renamed from: e, reason: collision with root package name */
    public int f26259e;

    /* renamed from: f, reason: collision with root package name */
    public int f26260f;

    /* renamed from: g, reason: collision with root package name */
    public int f26261g;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f26262h;

    /* renamed from: i, reason: collision with root package name */
    public COUINavigationView f26263i;

    /* renamed from: j, reason: collision with root package name */
    public View f26264j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f26265k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26266l;

    public final View K0() {
        View view = this.f26264j;
        if (view != null) {
            return view;
        }
        i.q("emptyPageContentLayout");
        return null;
    }

    public final FrameLayout L0() {
        FrameLayout frameLayout = this.f26262h;
        if (frameLayout != null) {
            return frameLayout;
        }
        i.q("navigationPanelView");
        return null;
    }

    public final ImageView M0() {
        ImageView imageView = this.f26265k;
        if (imageView != null) {
            return imageView;
        }
        i.q("noContentImageView");
        return null;
    }

    public final void N0(int i10, int i11, Integer num, View.OnClickListener onClickListener) {
        View findViewById = findViewById(p.f27334F);
        i.c(findViewById);
        setEmptyPageContentLayout(findViewById);
        View findViewById2 = findViewById(p.f27391h0);
        i.c(findViewById2);
        Y0((ImageView) findViewById2);
        M0().setImageDrawable(b.e(this, i10));
        TextView textView = (TextView) findViewById(p.f27393i0);
        if (textView == null) {
            return;
        }
        textView.setText(getString(i11));
        M0().setContentDescription(textView.getText());
        if (num != null) {
            TextView textView2 = (TextView) findViewById(p.f27395j0);
            if (textView2 != null) {
                textView2.setText(getString(num.intValue()));
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
        if (onClickListener != null) {
            TextView textView3 = (TextView) findViewById(p.f27389g0);
            COUIChangeTextUtil.adaptFontSize(textView, 4);
            COUITextViewCompatUtil.setPressRippleDrawable(textView3);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            if (textView3 != null) {
                textView3.setForceDarkAllowed(false);
            }
            if (textView3 != null) {
                textView3.setOnClickListener(onClickListener);
            }
        }
    }

    public void O0() {
        View findViewById = findViewById(p.f27387f0);
        i.d(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        T0((FrameLayout) findViewById);
        View findViewById2 = findViewById(p.f27385e0);
        i.d(findViewById2, "null cannot be cast to non-null type com.coui.appcompat.bottomnavigation.COUINavigationView");
        U0((COUINavigationView) findViewById2);
        if (!this.f26266l) {
            L0().setBackgroundResource(o.f27323z);
        }
    }

    public final void Q0(int i10) {
        if (K0() instanceof EmptyViewGroup) {
            View K02 = K0();
            i.d(K02, "null cannot be cast to non-null type com.oplus.widget.EmptyViewGroup");
            ((EmptyViewGroup) K02).r(i10);
        }
    }

    public final void R0(boolean z10, ListView listView) {
        int i10;
        if (listView != null) {
            int paddingTop = listView.getPaddingTop();
            if (z10) {
                i10 = this.f26259e;
            } else {
                i10 = this.f26260f;
            }
            listView.setPadding(0, paddingTop, 0, i10);
        }
    }

    public final void T0(FrameLayout frameLayout) {
        i.f(frameLayout, "<set-?>");
        this.f26262h = frameLayout;
    }

    public final void U0(COUINavigationView cOUINavigationView) {
        i.f(cOUINavigationView, "<set-?>");
        this.f26263i = cOUINavigationView;
    }

    public final void Y0(ImageView imageView) {
        i.f(imageView, "<set-?>");
        this.f26265k = imageView;
    }

    public final void b1(boolean z10) {
        if (z10) {
            L0().setVisibility(0);
        } else {
            L0().setVisibility(8);
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f26266l = a.c(this);
        this.f26259e = getResources().getDimensionPixelSize(n.f27276a);
        this.f26260f = getResources().getDimensionPixelSize(n.f27278c);
        this.f26261g = C0849j.l(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        i.f(view, "view");
        super.setContentView(view);
        O0();
    }

    public final void setEmptyPageContentLayout(View view) {
        i.f(view, "<set-?>");
        this.f26264j = view;
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        super.setContentView(i10);
        O0();
    }
}
