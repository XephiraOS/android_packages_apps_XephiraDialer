package g1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.omoji.view.OmojiImageView;
import com.oplus.anim.EffectiveAnimationView;
import kotlin.jvm.internal.i;

/* compiled from: OmojiPhotoAdapter.kt */
/* loaded from: classes.dex */
public final class g extends RecyclerView.B {

    /* renamed from: a, reason: collision with root package name */
    public OmojiImageView f31837a;

    /* renamed from: b, reason: collision with root package name */
    public EffectiveAnimationView f31838b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(View view) {
        super(view);
        i.f(view, "view");
        this.f31837a = (OmojiImageView) view.findViewById(e1.d.f30566b);
        this.f31838b = (EffectiveAnimationView) view.findViewById(e1.d.f30565a);
    }

    public final EffectiveAnimationView e() {
        return this.f31838b;
    }

    public final OmojiImageView f() {
        return this.f31837a;
    }
}
