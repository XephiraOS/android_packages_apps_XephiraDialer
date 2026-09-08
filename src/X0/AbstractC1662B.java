package x0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.button.COUIButton;
import com.oplus.dialer.R;

/* compiled from: SceneNoAgreePermissionOrStatementBinding.java */
/* renamed from: x0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1662B extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final COUIButton f37656G;

    /* renamed from: H, reason: collision with root package name */
    public final ImageView f37657H;

    /* renamed from: I, reason: collision with root package name */
    public final ConstraintLayout f37658I;

    /* renamed from: J, reason: collision with root package name */
    public final TextView f37659J;

    /* renamed from: K, reason: collision with root package name */
    public final TextView f37660K;

    public AbstractC1662B(Object obj, View view, int i10, COUIButton cOUIButton, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(obj, view, i10);
        this.f37656G = cOUIButton;
        this.f37657H = imageView;
        this.f37658I = constraintLayout;
        this.f37659J = textView;
        this.f37660K = textView2;
    }

    public static AbstractC1662B i1(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        return j1(layoutInflater, viewGroup, z10, androidx.databinding.g.g());
    }

    @Deprecated
    public static AbstractC1662B j1(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (AbstractC1662B) ViewDataBinding.N0(layoutInflater, R.layout.scene_no_agree_permission_or_statement, viewGroup, z10, obj);
    }
}
