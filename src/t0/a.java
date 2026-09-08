package T0;

import N0.i;
import android.view.View;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import l0.C1287a;

/* compiled from: AppbarToolbarLayoutBinding.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final AppBarLayout f3690a;

    /* renamed from: b, reason: collision with root package name */
    public final AppBarLayout f3691b;

    /* renamed from: c, reason: collision with root package name */
    public final View f3692c;

    /* renamed from: d, reason: collision with root package name */
    public final COUIToolbar f3693d;

    public a(AppBarLayout appBarLayout, AppBarLayout appBarLayout2, View view, COUIToolbar cOUIToolbar) {
        this.f3690a = appBarLayout;
        this.f3691b = appBarLayout2;
        this.f3692c = view;
        this.f3693d = cOUIToolbar;
    }

    public static a a(View view) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        int i10 = i.f1936n;
        View a10 = C1287a.a(view, i10);
        if (a10 != null) {
            i10 = i.f1919A;
            COUIToolbar cOUIToolbar = (COUIToolbar) C1287a.a(view, i10);
            if (cOUIToolbar != null) {
                return new a(appBarLayout, appBarLayout, a10, cOUIToolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
