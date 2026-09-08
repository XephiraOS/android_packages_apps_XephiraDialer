package O1;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.view.AnswerMethodDialogButton;
import com.android.incallui.oplus.answerview.view.StaticAnswerImageView;
import com.android.incallui.oplus.answerview.view.StaticAnswerMethodLayout;
import com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel;

/* compiled from: IncallStaticAnswerMethodBinding.java */
/* loaded from: classes.dex */
public abstract class o extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final StaticAnswerMethodLayout f2609G;

    /* renamed from: H, reason: collision with root package name */
    public final StaticAnswerImageView f2610H;

    /* renamed from: I, reason: collision with root package name */
    public final AnswerMethodDialogButton f2611I;

    /* renamed from: J, reason: collision with root package name */
    public final StaticAnswerImageView f2612J;

    /* renamed from: K, reason: collision with root package name */
    public final StaticAnswerImageView f2613K;

    /* renamed from: L, reason: collision with root package name */
    public StaticAnswerMethodModel f2614L;

    public o(Object obj, View view, int i10, StaticAnswerMethodLayout staticAnswerMethodLayout, StaticAnswerImageView staticAnswerImageView, AnswerMethodDialogButton answerMethodDialogButton, StaticAnswerImageView staticAnswerImageView2, StaticAnswerImageView staticAnswerImageView3) {
        super(obj, view, i10);
        this.f2609G = staticAnswerMethodLayout;
        this.f2610H = staticAnswerImageView;
        this.f2611I = answerMethodDialogButton;
        this.f2612J = staticAnswerImageView2;
        this.f2613K = staticAnswerImageView3;
    }

    public static o i1(View view) {
        return j1(view, androidx.databinding.g.g());
    }

    @Deprecated
    public static o j1(View view, Object obj) {
        return (o) ViewDataBinding.y0(obj, view, R.layout.incall_static_answer_method);
    }

    public abstract void k1(StaticAnswerMethodModel staticAnswerMethodModel);
}
