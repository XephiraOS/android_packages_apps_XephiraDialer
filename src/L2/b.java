package l2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: RecyclerItemDecoration.kt */
/* loaded from: classes.dex */
public final class b extends RecyclerView.n {

    /* renamed from: d, reason: collision with root package name */
    public static final a f34673d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f34674a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34675b;

    /* renamed from: c, reason: collision with root package name */
    public int f34676c;

    /* compiled from: RecyclerItemDecoration.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b(int i10, int i11, int i12) {
        this.f34674a = i10;
        this.f34675b = i11;
        this.f34676c = i12;
    }

    public final void d(int i10) {
        this.f34676c = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        int itemCount;
        int i10;
        i.f(outRect, "outRect");
        i.f(view, "view");
        i.f(parent, "parent");
        i.f(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null || (itemCount = adapter.getItemCount()) <= 0) {
            return;
        }
        int i11 = this.f34674a;
        if (itemCount % i11 == 0) {
            i10 = itemCount / i11;
        } else {
            i10 = (itemCount / i11) + 1;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i12 = this.f34674a;
        int i13 = childAdapterPosition / i12;
        int i14 = childAdapterPosition % i12;
        int i15 = this.f34675b;
        outRect.left = (i14 * i15) / i12;
        outRect.right = i15 - (((i14 + 1) * i15) / i12);
        int i16 = this.f34676c;
        outRect.top = (i13 * i16) / i10;
        outRect.bottom = i16 - (((i13 + 1) * i16) / i10);
    }
}
