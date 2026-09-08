package T0;

import N0.i;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.contacts.framework.baseui.widget.RecommendView;
import l0.C1287a;

/* compiled from: RecommendViewBinding.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final RecommendView f3694a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f3695b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f3696c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f3697d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f3698e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f3699f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f3700g;

    /* renamed from: h, reason: collision with root package name */
    public final View f3701h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f3702i;

    public b(RecommendView recommendView, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, ImageView imageView, View view, ConstraintLayout constraintLayout) {
        this.f3694a = recommendView;
        this.f3695b = linearLayout;
        this.f3696c = textView;
        this.f3697d = linearLayout2;
        this.f3698e = textView2;
        this.f3699f = textView3;
        this.f3700g = imageView;
        this.f3701h = view;
        this.f3702i = constraintLayout;
    }

    public static b a(View view) {
        View a10;
        int i10 = i.f1924b;
        LinearLayout linearLayout = (LinearLayout) C1287a.a(view, i10);
        if (linearLayout != null) {
            i10 = i.f1925c;
            TextView textView = (TextView) C1287a.a(view, i10);
            if (textView != null) {
                i10 = i.f1932j;
                LinearLayout linearLayout2 = (LinearLayout) C1287a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = i.f1933k;
                    TextView textView2 = (TextView) C1287a.a(view, i10);
                    if (textView2 != null) {
                        i10 = i.f1935m;
                        TextView textView3 = (TextView) C1287a.a(view, i10);
                        if (textView3 != null) {
                            i10 = i.f1939q;
                            ImageView imageView = (ImageView) C1287a.a(view, i10);
                            if (imageView != null && (a10 = C1287a.a(view, (i10 = i.f1940r))) != null) {
                                i10 = i.f1945w;
                                ConstraintLayout constraintLayout = (ConstraintLayout) C1287a.a(view, i10);
                                if (constraintLayout != null) {
                                    return new b((RecommendView) view, linearLayout, textView, linearLayout2, textView2, textView3, imageView, a10, constraintLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
