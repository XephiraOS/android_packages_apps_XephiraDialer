package g1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.omoji.view.OmojiImageView;
import kotlin.jvm.internal.i;

/* compiled from: OmojiPhotoAdapter.kt */
/* renamed from: g1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1032a extends RecyclerView.B {

    /* renamed from: a, reason: collision with root package name */
    public OmojiImageView f31822a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1032a(View view) {
        super(view);
        i.f(view, "view");
        this.f31822a = (OmojiImageView) view.findViewById(e1.d.f30566b);
    }

    public final OmojiImageView e() {
        return this.f31822a;
    }
}
