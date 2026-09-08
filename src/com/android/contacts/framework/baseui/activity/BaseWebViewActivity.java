package com.android.contacts.framework.baseui.activity;

import N0.g;
import T0.c;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import com.android.contacts.framework.baseui.activity.BaseWebViewActivity;
import com.android.contacts.framework.baseui.util.B;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import m9.q;

/* compiled from: BaseWebViewActivity.kt */
/* loaded from: classes.dex */
public class BaseWebViewActivity extends BasicActivity {

    /* renamed from: r, reason: collision with root package name */
    public static final a f15655r = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public c f15656o;

    /* renamed from: p, reason: collision with root package name */
    public String f15657p;

    /* renamed from: q, reason: collision with root package name */
    public int f15658q;

    /* compiled from: BaseWebViewActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: BaseWebViewActivity.kt */
    /* loaded from: classes.dex */
    public static final class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            BaseWebViewActivity.this.A1(i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            boolean q10;
            super.onReceivedTitle(webView, str);
            if (BaseWebViewActivity.this.f15658q == 0 && str != null) {
                q10 = n.q(str);
                if (!q10) {
                    BaseWebViewActivity.this.u1().f3705c.f3693d.setTitle(str);
                }
            }
        }
    }

    public static final void w1(BaseWebViewActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final X y1(View view, X insets) {
        i.f(view, "view");
        i.f(insets, "insets");
        B.b f10 = insets.f(X.k.f());
        i.e(f10, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), f10.f210d);
        return insets;
    }

    public final void A1(int i10) {
        u1().f3707e.setProgress(i10);
        if (i10 == 100) {
            u1().f3707e.setVisibility(8);
        } else {
            u1().f3707e.setVisibility(0);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = u1().f3705c.f3693d;
        int i10 = this.f15658q;
        if (i10 > 0) {
            cOUIToolbar.setTitle(i10);
        }
        cOUIToolbar.setNavigationIcon(g.f1901a);
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: O0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseWebViewActivity.w1(BaseWebViewActivity.this, view);
            }
        });
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void j1() {
        h1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        q qVar;
        super.onCreate(bundle);
        c c10 = c.c(LayoutInflater.from(this));
        i.e(c10, "inflate(LayoutInflater.from(this))");
        z1(c10);
        setContentView(u1().b());
        if (T0()) {
            K.z0(u1().b(), new z() { // from class: O0.b
                @Override // androidx.core.view.z
                public final X onApplyWindowInsets(View view, X x10) {
                    X y12;
                    y12 = BaseWebViewActivity.y1(view, x10);
                    return y12;
                }
            });
        }
        v1();
        x1();
        t1();
        B0();
        String str = this.f15657p;
        if (str != null) {
            u1().f3708f.loadUrl(str);
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            finish();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        u1().f3708f.stopLoading();
        u1().f3708f.destroy();
        super.onDestroy();
    }

    public final void t1() {
        ViewGroup viewGroup;
        ViewGroup.LayoutParams layoutParams = u1().f3706d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = DisplayUtil.g(this);
            u1().f3706d.setLayoutParams(layoutParams);
            ViewParent parent = u1().f3706d.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.addView(B.b(this, H0()));
            }
        }
    }

    public final c u1() {
        c cVar = this.f15656o;
        if (cVar != null) {
            return cVar;
        }
        i.q("viewBinding");
        return null;
    }

    public void v1() {
        this.f15658q = getIntent().getIntExtra("title_res_id", 0);
        this.f15657p = getIntent().getStringExtra("url");
    }

    public void x1() {
        WebSettings settings = u1().f3708f.getSettings();
        i.e(settings, "viewBinding.webView.settings");
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setDomStorageEnabled(false);
        settings.setAllowFileAccess(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        u1().f3708f.setWebChromeClient(new b());
    }

    public final void z1(c cVar) {
        i.f(cVar, "<set-?>");
        this.f15656o = cVar;
    }
}
