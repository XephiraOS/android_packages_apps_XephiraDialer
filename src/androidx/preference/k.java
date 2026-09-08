package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.C0446a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;

/* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
@Deprecated
/* loaded from: classes.dex */
public class k extends u {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView f10620a;

    /* renamed from: b, reason: collision with root package name */
    public final C0446a f10621b;

    /* renamed from: c, reason: collision with root package name */
    public final C0446a f10622c;

    /* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public class a extends C0446a {
        public a() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            Preference j10;
            k.this.f10621b.onInitializeAccessibilityNodeInfo(view, dVar);
            int childAdapterPosition = k.this.f10620a.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = k.this.f10620a.getAdapter();
            if (!(adapter instanceof h) || (j10 = ((h) adapter).j(childAdapterPosition)) == null) {
                return;
            }
            j10.onInitializeAccessibilityNodeInfo(dVar);
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return k.this.f10621b.performAccessibilityAction(view, i10, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f10621b = super.getItemDelegate();
        this.f10622c = new a();
        this.f10620a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.u
    public C0446a getItemDelegate() {
        return this.f10622c;
    }
}
