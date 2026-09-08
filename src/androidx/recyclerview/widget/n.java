package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    public int f11190b;

    /* renamed from: c, reason: collision with root package name */
    public int f11191c;

    /* renamed from: d, reason: collision with root package name */
    public int f11192d;

    /* renamed from: e, reason: collision with root package name */
    public int f11193e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11196h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11197i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11189a = true;

    /* renamed from: f, reason: collision with root package name */
    public int f11194f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f11195g = 0;

    public boolean a(RecyclerView.y yVar) {
        int i10 = this.f11191c;
        if (i10 >= 0 && i10 < yVar.b()) {
            return true;
        }
        return false;
    }

    public View b(RecyclerView.u uVar) {
        View o10 = uVar.o(this.f11191c);
        this.f11191c += this.f11192d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f11190b + ", mCurrentPosition=" + this.f11191c + ", mItemDirection=" + this.f11192d + ", mLayoutDirection=" + this.f11193e + ", mStartLine=" + this.f11194f + ", mEndLine=" + this.f11195g + '}';
    }
}
