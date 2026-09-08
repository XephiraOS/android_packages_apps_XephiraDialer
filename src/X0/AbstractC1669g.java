package x0;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.dialer.R;

/* compiled from: ContactsMainListHeaderViewBinding.java */
/* renamed from: x0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1669g extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final RelativeLayout f37707G;

    /* renamed from: H, reason: collision with root package name */
    public final COUIRoundImageView f37708H;

    /* renamed from: I, reason: collision with root package name */
    public final TextView f37709I;

    /* renamed from: J, reason: collision with root package name */
    public final RelativeLayout f37710J;

    /* renamed from: K, reason: collision with root package name */
    public final COUIRoundImageView f37711K;

    /* renamed from: L, reason: collision with root package name */
    public final TextView f37712L;

    /* renamed from: M, reason: collision with root package name */
    public Boolean f37713M;

    public AbstractC1669g(Object obj, View view, int i10, RelativeLayout relativeLayout, COUIRoundImageView cOUIRoundImageView, TextView textView, RelativeLayout relativeLayout2, COUIRoundImageView cOUIRoundImageView2, TextView textView2) {
        super(obj, view, i10);
        this.f37707G = relativeLayout;
        this.f37708H = cOUIRoundImageView;
        this.f37709I = textView;
        this.f37710J = relativeLayout2;
        this.f37711K = cOUIRoundImageView2;
        this.f37712L = textView2;
    }

    public static AbstractC1669g i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static AbstractC1669g j1(View view, Object obj) {
        return (AbstractC1669g) ViewDataBinding.y0(obj, view, R.layout.contacts_main_list_header_view);
    }

    public abstract void k1(Boolean bool);
}
