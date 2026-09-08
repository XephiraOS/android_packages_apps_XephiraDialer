package n7;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.google.android.material.appbar.COUICollapsingToolbarLayout;

/* compiled from: CollapsingAppbarLayoutBinding.java */
/* renamed from: n7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1374a extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final COUICollapsableAppBarLayout f35627G;

    /* renamed from: H, reason: collision with root package name */
    public final COUICollapsingToolbarLayout f35628H;

    /* renamed from: I, reason: collision with root package name */
    public final ConstraintLayout f35629I;

    /* renamed from: J, reason: collision with root package name */
    public final TextView f35630J;

    /* renamed from: K, reason: collision with root package name */
    public final COUIToolbar f35631K;

    public AbstractC1374a(Object obj, View view, int i10, COUICollapsableAppBarLayout cOUICollapsableAppBarLayout, COUICollapsingToolbarLayout cOUICollapsingToolbarLayout, ConstraintLayout constraintLayout, TextView textView, COUIToolbar cOUIToolbar) {
        super(obj, view, i10);
        this.f35627G = cOUICollapsableAppBarLayout;
        this.f35628H = cOUICollapsingToolbarLayout;
        this.f35629I = constraintLayout;
        this.f35630J = textView;
        this.f35631K = cOUIToolbar;
    }
}
