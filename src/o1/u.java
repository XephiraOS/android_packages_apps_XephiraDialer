package O1;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.CallButtonViewModel;
import com.android.incallui.oplus.widgets.OplusGoneIncallUIImageView;

/* compiled from: OplusCallButtonFragmentBinding.java */
/* loaded from: classes.dex */
public abstract class u extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final FrameLayout f2638G;

    /* renamed from: H, reason: collision with root package name */
    public final RecyclerView f2639H;

    /* renamed from: I, reason: collision with root package name */
    public final OplusGoneIncallUIImageView f2640I;

    /* renamed from: J, reason: collision with root package name */
    public CallButtonViewModel f2641J;

    public u(Object obj, View view, int i10, FrameLayout frameLayout, RecyclerView recyclerView, OplusGoneIncallUIImageView oplusGoneIncallUIImageView) {
        super(obj, view, i10);
        this.f2638G = frameLayout;
        this.f2639H = recyclerView;
        this.f2640I = oplusGoneIncallUIImageView;
    }

    public static u i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static u j1(View view, Object obj) {
        return (u) ViewDataBinding.y0(obj, view, R.layout.oplus_call_button_fragment);
    }

    public abstract void k1(CallButtonViewModel callButtonViewModel);
}
