package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import w9.InterfaceC1658a;

/* compiled from: ViewGroup.kt */
/* loaded from: classes.dex */
public final class N {

    /* compiled from: ViewGroup.kt */
    /* loaded from: classes.dex */
    public static final class a implements kotlin.sequences.e<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9451a;

        public a(ViewGroup viewGroup) {
            this.f9451a = viewGroup;
        }

        @Override // kotlin.sequences.e
        public Iterator<View> iterator() {
            return N.c(this.f9451a);
        }
    }

    /* compiled from: ViewGroup.kt */
    /* loaded from: classes.dex */
    public static final class b implements Iterator<View>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public int f9452a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9453b;

        public b(ViewGroup viewGroup) {
            this.f9453b = viewGroup;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.f9453b;
            int i10 = this.f9452a;
            this.f9452a = i10 + 1;
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9452a < this.f9453b.getChildCount()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f9453b;
            int i10 = this.f9452a - 1;
            this.f9452a = i10;
            viewGroup.removeViewAt(i10);
        }
    }

    public static final View a(ViewGroup viewGroup, int i10) {
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + viewGroup.getChildCount());
    }

    public static final kotlin.sequences.e<View> b(ViewGroup viewGroup) {
        return new a(viewGroup);
    }

    public static final Iterator<View> c(ViewGroup viewGroup) {
        return new b(viewGroup);
    }
}
