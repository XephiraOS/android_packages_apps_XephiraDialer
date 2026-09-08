package O1;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.R;
import com.android.incallui.mvvm.view_model.DialpadViewModel;
import com.android.incallui.mvvm.widget.SuitableSizeEditText;

/* compiled from: OplusDialpadFragmentBinding.java */
/* loaded from: classes.dex */
public abstract class w extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final SuitableSizeEditText f2645G;

    /* renamed from: H, reason: collision with root package name */
    public final RecyclerView f2646H;

    /* renamed from: I, reason: collision with root package name */
    public DialpadViewModel f2647I;

    public w(Object obj, View view, int i10, SuitableSizeEditText suitableSizeEditText, RecyclerView recyclerView) {
        super(obj, view, i10);
        this.f2645G = suitableSizeEditText;
        this.f2646H = recyclerView;
    }

    public static w i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static w j1(View view, Object obj) {
        return (w) ViewDataBinding.y0(obj, view, R.layout.oplus_dialpad_fragment);
    }

    public abstract void k1(DialpadViewModel dialpadViewModel);
}
