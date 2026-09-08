package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class u extends C0446a {
    private final a mItemDelegate;
    final RecyclerView mRecyclerView;

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public static class a extends C0446a {

        /* renamed from: a, reason: collision with root package name */
        public final u f11204a;

        /* renamed from: b, reason: collision with root package name */
        public Map<View, C0446a> f11205b = new WeakHashMap();

        public a(u uVar) {
            this.f11204a = uVar;
        }

        public C0446a a(View view) {
            return this.f11205b.remove(view);
        }

        public void b(View view) {
            C0446a j10 = K.j(view);
            if (j10 != null && j10 != this) {
                this.f11205b.put(view, j10);
            }
        }

        @Override // androidx.core.view.C0446a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0446a c0446a = this.f11205b.get(view);
            if (c0446a != null) {
                return c0446a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0446a
        public J.e getAccessibilityNodeProvider(View view) {
            C0446a c0446a = this.f11205b.get(view);
            if (c0446a != null) {
                return c0446a.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0446a c0446a = this.f11205b.get(view);
            if (c0446a != null) {
                c0446a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            if (!this.f11204a.shouldIgnore() && this.f11204a.mRecyclerView.getLayoutManager() != null) {
                this.f11204a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, dVar);
                C0446a c0446a = this.f11205b.get(view);
                if (c0446a != null) {
                    c0446a.onInitializeAccessibilityNodeInfo(view, dVar);
                    return;
                } else {
                    super.onInitializeAccessibilityNodeInfo(view, dVar);
                    return;
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, dVar);
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0446a c0446a = this.f11205b.get(view);
            if (c0446a != null) {
                c0446a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0446a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0446a c0446a = this.f11205b.get(viewGroup);
            if (c0446a != null) {
                return c0446a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (!this.f11204a.shouldIgnore() && this.f11204a.mRecyclerView.getLayoutManager() != null) {
                C0446a c0446a = this.f11205b.get(view);
                if (c0446a != null) {
                    if (c0446a.performAccessibilityAction(view, i10, bundle)) {
                        return true;
                    }
                } else if (super.performAccessibilityAction(view, i10, bundle)) {
                    return true;
                }
                return this.f11204a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i10, bundle);
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }

        @Override // androidx.core.view.C0446a
        public void sendAccessibilityEvent(View view, int i10) {
            C0446a c0446a = this.f11205b.get(view);
            if (c0446a != null) {
                c0446a.sendAccessibilityEvent(view, i10);
            } else {
                super.sendAccessibilityEvent(view, i10);
            }
        }

        @Override // androidx.core.view.C0446a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            C0446a c0446a = this.f11205b.get(view);
            if (c0446a != null) {
                c0446a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public u(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        C0446a itemDelegate = getItemDelegate();
        if (itemDelegate != null && (itemDelegate instanceof a)) {
            this.mItemDelegate = (a) itemDelegate;
        } else {
            this.mItemDelegate = new a(this);
        }
    }

    public C0446a getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.C0446a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    @Override // androidx.core.view.C0446a
    public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(dVar);
        }
    }

    @Override // androidx.core.view.C0446a
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (super.performAccessibilityAction(view, i10, bundle)) {
            return true;
        }
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i10, bundle);
        }
        return false;
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
