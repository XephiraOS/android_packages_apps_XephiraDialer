package x0;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.dialpad.view.DialEditText;
import com.customize.contacts.widget.DialDeleteImageButton;
import com.customize.contacts.widget.DigitsContainer;

/* compiled from: SceneDialEditTextContainerBinding.java */
/* loaded from: classes.dex */
public abstract class t extends ViewDataBinding {

    /* renamed from: G, reason: collision with root package name */
    public final View f37782G;

    /* renamed from: H, reason: collision with root package name */
    public final DialDeleteImageButton f37783H;

    /* renamed from: I, reason: collision with root package name */
    public final DialEditText f37784I;

    /* renamed from: J, reason: collision with root package name */
    public final DigitsContainer f37785J;

    /* renamed from: K, reason: collision with root package name */
    public final TextView f37786K;

    public t(Object obj, View view, int i10, View view2, DialDeleteImageButton dialDeleteImageButton, DialEditText dialEditText, DigitsContainer digitsContainer, TextView textView) {
        super(obj, view, i10);
        this.f37782G = view2;
        this.f37783H = dialDeleteImageButton;
        this.f37784I = dialEditText;
        this.f37785J = digitsContainer;
        this.f37786K = textView;
    }
}
