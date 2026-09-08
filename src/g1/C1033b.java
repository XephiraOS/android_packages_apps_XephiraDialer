package g1;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e1.C0965b;
import kotlin.jvm.internal.i;

/* compiled from: OmojiItemDecoration.kt */
/* renamed from: g1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1033b extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    public int f31823a;

    public C1033b(Context context) {
        i.f(context, "context");
        this.f31823a = context.getResources().getDimensionPixelSize(C0965b.f30561b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        i.f(outRect, "outRect");
        i.f(view, "view");
        i.f(parent, "parent");
        i.f(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int i10 = this.f31823a;
        outRect.set(i10, i10, i10, i10);
    }
}
