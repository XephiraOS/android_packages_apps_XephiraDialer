package O1;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import e2.C0967b;

/* compiled from: ItemDialpadButtonBinding.java */
/* loaded from: classes.dex */
public abstract class s extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final ConstraintLayout f2628G;

    /* renamed from: H, reason: collision with root package name */
    public final AppCompatImageView f2629H;

    /* renamed from: I, reason: collision with root package name */
    public final AppCompatTextView f2630I;

    /* renamed from: J, reason: collision with root package name */
    public final AppCompatTextView f2631J;

    /* renamed from: K, reason: collision with root package name */
    public C0967b f2632K;

    public s(Object obj, View view, int i10, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i10);
        this.f2628G = constraintLayout;
        this.f2629H = appCompatImageView;
        this.f2630I = appCompatTextView;
        this.f2631J = appCompatTextView2;
    }

    public abstract void i1(C0967b c0967b);
}
