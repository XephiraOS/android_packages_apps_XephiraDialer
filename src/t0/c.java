package T0;

import N0.i;
import N0.j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.contacts.framework.baseui.widget.FlashProgressBar;
import l0.C1287a;

/* compiled from: WebviewActivityBinding.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f3703a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f3704b;

    /* renamed from: c, reason: collision with root package name */
    public final a f3705c;

    /* renamed from: d, reason: collision with root package name */
    public final CoordinatorLayout f3706d;

    /* renamed from: e, reason: collision with root package name */
    public final FlashProgressBar f3707e;

    /* renamed from: f, reason: collision with root package name */
    public final WebView f3708f;

    public c(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, a aVar, CoordinatorLayout coordinatorLayout2, FlashProgressBar flashProgressBar, WebView webView) {
        this.f3703a = coordinatorLayout;
        this.f3704b = linearLayout;
        this.f3705c = aVar;
        this.f3706d = coordinatorLayout2;
        this.f3707e = flashProgressBar;
        this.f3708f = webView;
    }

    public static c a(View view) {
        View a10;
        int i10 = i.f1923a;
        LinearLayout linearLayout = (LinearLayout) C1287a.a(view, i10);
        if (linearLayout != null && (a10 = C1287a.a(view, (i10 = i.f1926d))) != null) {
            a a11 = a.a(a10);
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
            i10 = i.f1942t;
            FlashProgressBar flashProgressBar = (FlashProgressBar) C1287a.a(view, i10);
            if (flashProgressBar != null) {
                i10 = i.f1922D;
                WebView webView = (WebView) C1287a.a(view, i10);
                if (webView != null) {
                    return new c(coordinatorLayout, linearLayout, a11, coordinatorLayout, flashProgressBar, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(j.f1950b, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public CoordinatorLayout b() {
        return this.f3703a;
    }
}
