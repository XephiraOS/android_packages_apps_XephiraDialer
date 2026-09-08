package x7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.collections.p;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: HeaderFooterRecyclerAdapter.kt */
/* renamed from: x7.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1687d extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: j, reason: collision with root package name */
    public static final a f38054j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView.Adapter<RecyclerView.B> f38055a;

    /* renamed from: b, reason: collision with root package name */
    public final HeaderFooterRecyclerView f38056b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f38057c;

    /* renamed from: d, reason: collision with root package name */
    public final List<b> f38058d;

    /* renamed from: e, reason: collision with root package name */
    public int f38059e;

    /* renamed from: f, reason: collision with root package name */
    public int f38060f;

    /* renamed from: g, reason: collision with root package name */
    public final PathInterpolator f38061g;

    /* renamed from: h, reason: collision with root package name */
    public final PathInterpolator f38062h;

    /* renamed from: i, reason: collision with root package name */
    public final RecyclerView.i f38063i;

    /* compiled from: HeaderFooterRecyclerAdapter.kt */
    /* renamed from: x7.d$a */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: HeaderFooterRecyclerAdapter.kt */
    /* renamed from: x7.d$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final View f38064a;

        /* renamed from: b, reason: collision with root package name */
        public final int f38065b;

        public b(View view, int i10) {
            i.f(view, "view");
            this.f38064a = view;
            this.f38065b = i10;
        }

        public final int a() {
            return this.f38065b;
        }

        public final View b() {
            return this.f38064a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (i.b(this.f38064a, bVar.f38064a) && this.f38065b == bVar.f38065b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f38064a.hashCode() * 31) + Integer.hashCode(this.f38065b);
        }

        public String toString() {
            return "FixedViewInfo(view=" + this.f38064a + ", itemViewType=" + this.f38065b + ")";
        }
    }

    /* compiled from: HeaderFooterRecyclerAdapter.kt */
    /* renamed from: x7.d$c */
    /* loaded from: classes3.dex */
    public static final class c extends RecyclerView.B {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View itemView) {
            super(itemView);
            i.f(itemView, "itemView");
        }
    }

    /* compiled from: HeaderFooterRecyclerAdapter.kt */
    /* renamed from: x7.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0382d extends RecyclerView.i {
        public C0382d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onChanged() {
            if (C1687d.this.f38056b.isComputingLayout()) {
                Log.w("HeaderFooterRecyclerAdapter", "onChanged: just return while HeaderFooterRecyclerView is computing a layout or scrolling");
            } else {
                C1687d.this.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11) {
            super.onItemRangeChanged(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeInserted(int i10, int i11) {
            C1687d c1687d = C1687d.this;
            c1687d.notifyItemRangeInserted(c1687d.t() + i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeMoved(int i10, int i11, int i12) {
            C1687d c1687d = C1687d.this;
            c1687d.notifyItemMoved(c1687d.t() + i10, C1687d.this.t() + i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeRemoved(int i10, int i11) {
            C1687d c1687d = C1687d.this;
            c1687d.notifyItemRangeRemoved(c1687d.t() + i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            C1687d c1687d = C1687d.this;
            c1687d.notifyItemRangeChanged(c1687d.t() + i10, i11, obj);
        }
    }

    /* compiled from: HeaderFooterRecyclerAdapter.kt */
    /* renamed from: x7.d$e */
    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f38068b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f38069c;

        public e(boolean z10, View view) {
            this.f38068b = z10;
            this.f38069c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            i.f(animation, "animation");
            if (C1687d.this.f38056b.isComputingLayout()) {
                return;
            }
            int i10 = 0;
            if (this.f38068b) {
                for (b bVar : C1687d.this.f38057c) {
                    int i11 = i10 + 1;
                    if (i.b(bVar.b(), this.f38069c)) {
                        C1687d.this.f38057c.remove(bVar);
                        C1687d.this.notifyItemRemoved(i10);
                        return;
                    }
                    i10 = i11;
                }
                return;
            }
            int i12 = 0;
            for (b bVar2 : C1687d.this.f38058d) {
                int i13 = i12 + 1;
                if (i.b(bVar2.b(), this.f38069c)) {
                    C1687d.this.f38058d.remove(bVar2);
                    RecyclerView.Adapter adapter = C1687d.this.f38055a;
                    if (adapter != null) {
                        i10 = adapter.getItemCount();
                    }
                    C1687d c1687d = C1687d.this;
                    c1687d.notifyItemRemoved(c1687d.t() + i10 + i12);
                    return;
                }
                i12 = i13;
            }
        }
    }

    public C1687d(RecyclerView.Adapter<RecyclerView.B> adapter, HeaderFooterRecyclerView recyclerView) {
        i.f(recyclerView, "recyclerView");
        this.f38055a = adapter;
        this.f38056b = recyclerView;
        this.f38057c = new ArrayList();
        this.f38058d = new ArrayList();
        this.f38059e = Integer.MIN_VALUE;
        this.f38060f = -2147473648;
        this.f38061g = new COUIMoveEaseInterpolator();
        this.f38062h = new PathInterpolator(0.17f, 0.17f, 0.83f, 0.83f);
        C0382d c0382d = new C0382d();
        this.f38063i = c0382d;
        RecyclerView.Adapter<RecyclerView.B> adapter2 = this.f38055a;
        if (adapter2 != null) {
            adapter2.registerAdapterDataObserver(c0382d);
        }
    }

    public static final void v(ViewGroup.LayoutParams layoutParams, View view, ValueAnimator animation) {
        i.f(view, "$view");
        i.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            layoutParams.height = ((Number) animatedValue).intValue();
            view.setLayoutParams(layoutParams);
        }
    }

    public final void A() {
        Object b10;
        RecyclerView.Adapter<RecyclerView.B> adapter;
        try {
            Result.a aVar = Result.f34166a;
            RecyclerView.Adapter<RecyclerView.B> adapter2 = this.f38055a;
            if (adapter2 != null && !adapter2.hasObservers() && (adapter = this.f38055a) != null) {
                adapter.registerAdapterDataObserver(this.f38063i);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("HeaderFooterRecyclerAdapter", "Exception when invoke block : " + d10);
        }
    }

    public final boolean B(View view, boolean z10) {
        Object obj;
        i.f(view, "view");
        Iterator<T> it = this.f38057c.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (i.b(((b) obj).b(), view)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((b) obj) == null) {
            return false;
        }
        if (z10) {
            D(view, true);
            return true;
        }
        int i10 = 0;
        for (b bVar : this.f38057c) {
            int i11 = i10 + 1;
            if (i.b(bVar.b(), view)) {
                this.f38057c.remove(bVar);
                notifyItemRemoved(i10);
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    public final void C(RecyclerView.Adapter<RecyclerView.B> adapter) {
        if (!(adapter instanceof C1687d)) {
            RecyclerView.Adapter<RecyclerView.B> adapter2 = this.f38055a;
            if (adapter2 != null) {
                adapter2.unregisterAdapterDataObserver(this.f38063i);
            }
            this.f38055a = adapter;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f38063i);
            }
            notifyDataSetChanged();
            return;
        }
        throw new IllegalArgumentException("Cannot wrap a HeaderFooterRecyclerAdapter".toString());
    }

    public final void D(View view, boolean z10) {
        Animator u10 = u(view, view.getHeight(), 0);
        Animator o10 = o(view, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(u10, o10);
        animatorSet.addListener(new e(z10, view));
        animatorSet.start();
    }

    public final void E() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f38063i);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("HeaderFooterRecyclerAdapter", "Exception when invoke block : " + d10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i10;
        int size = this.f38057c.size() + this.f38058d.size();
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = 0;
        }
        return size + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        int i11;
        if (i10 >= 0 && i10 < t()) {
            return this.f38057c.get(i10).a();
        }
        int t10 = i10 - t();
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            i11 = adapter.getItemCount();
        } else {
            i11 = 0;
        }
        RecyclerView.Adapter<RecyclerView.B> adapter2 = this.f38055a;
        if (adapter2 != null && t10 < i11) {
            return adapter2.getItemViewType(t10);
        }
        return this.f38058d.get(t10 - i11).a();
    }

    public final void l(int i10, View view, int i11) {
        if (this.f38057c.size() < 10000) {
            b bVar = new b(view, i11);
            if (i10 >= 0) {
                this.f38057c.add(i10, bVar);
                notifyItemInserted(i10);
                return;
            } else {
                this.f38057c.add(bVar);
                notifyItemInserted(t() - 1);
                return;
            }
        }
        throw new IllegalArgumentException("exceeding the maximum quantity limit of 100");
    }

    public final void m(View view, int i10) {
        Object obj;
        i.f(view, "view");
        Iterator<T> it = this.f38057c.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (i.b(view, ((b) obj).b())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((b) obj) != null) {
            Log.w("HeaderFooterRecyclerAdapter", "addHeaderView: view already add, please check. view:" + view);
            return;
        }
        l(i10, view, r(true));
    }

    public final RecyclerView.Adapter<RecyclerView.B> n() {
        return this.f38055a;
    }

    public final Animator o(View view, float f10, float f11) {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(view, "alpha", f10, f11);
        alphaAnimator.setDuration(183L);
        alphaAnimator.setInterpolator(this.f38062h);
        i.e(alphaAnimator, "alphaAnimator");
        return alphaAnimator;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        i.f(recyclerView, "recyclerView");
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, int i10) {
        i.f(holder, "holder");
        if (!y(i10) && !x(i10)) {
            int t10 = i10 - t();
            RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
            if (adapter != null) {
                adapter.onBindViewHolder(holder, t10);
                return;
            }
            return;
        }
        holder.itemView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        RecyclerView.B b10;
        Object obj;
        Object obj2;
        i.f(parent, "parent");
        Iterator<T> it = this.f38057c.iterator();
        while (true) {
            b10 = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((b) obj).a() == i10) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        b bVar = (b) obj;
        if (bVar != null) {
            return new c(bVar.b());
        }
        Iterator<T> it2 = this.f38058d.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (((b) obj2).a() == i10) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        b bVar2 = (b) obj2;
        if (bVar2 != null) {
            return new c(bVar2.b());
        }
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            b10 = adapter.onCreateViewHolder(parent, i10);
        }
        if (b10 == null) {
            c cVar = new c(parent);
            Log.e("HeaderFooterRecyclerAdapter", "view type error:" + i10 + ", head:" + t() + ", foot:" + q());
            return cVar;
        }
        return b10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        i.f(recyclerView, "recyclerView");
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.B holder) {
        i.f(holder, "holder");
        if (holder instanceof c) {
            return super.onFailedToRecycleView(holder);
        }
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            return adapter.onFailedToRecycleView(holder);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.B holder) {
        i.f(holder, "holder");
        if (holder instanceof c) {
            super.onViewAttachedToWindow(holder);
        } else {
            RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
            if (adapter != null) {
                adapter.onViewAttachedToWindow(holder);
            }
        }
        if (z(holder)) {
            w(holder, holder.getLayoutPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.B holder) {
        i.f(holder, "holder");
        if (holder instanceof c) {
            super.onViewDetachedFromWindow(holder);
            return;
        }
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.B holder) {
        i.f(holder, "holder");
        if (holder instanceof c) {
            super.onViewRecycled(holder);
            return;
        }
        RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
        if (adapter != null) {
            adapter.onViewRecycled(holder);
        }
    }

    public final List<View> p() {
        int p10;
        List<b> list = this.f38058d;
        p10 = p.p(list, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((b) it.next()).b());
        }
        return arrayList;
    }

    public final int q() {
        return this.f38058d.size();
    }

    public final int r(boolean z10) {
        Object obj;
        Object obj2;
        int i10 = -2147473648;
        if (z10) {
            int i11 = this.f38059e;
            int i12 = Integer.MIN_VALUE;
            if (i11 != Integer.MIN_VALUE) {
                i11++;
            }
            if (i11 >= -2147473648) {
                this.f38059e = Integer.MIN_VALUE;
            } else {
                i12 = i11;
            }
            while (i12 < -2147473648) {
                Iterator<T> it = this.f38057c.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((b) obj2).a() == i12) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                if (obj2 == null) {
                    this.f38059e = i12;
                    return i12;
                }
                i12++;
            }
            throw new IllegalAccessException("can not get a valid head type:" + t());
        }
        int i13 = this.f38060f;
        if (i13 != -2147473648) {
            i13++;
        }
        if (i13 >= -2147463648) {
            this.f38060f = -2147473648;
        } else {
            i10 = i13;
        }
        while (i10 < -2147463648) {
            Iterator<T> it2 = this.f38058d.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (((b) obj).a() == i10) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                this.f38060f = i10;
                return i10;
            }
            i10++;
        }
        throw new IllegalAccessException("can not get a valid footer type:" + q());
    }

    public final List<View> s() {
        int p10;
        List<b> list = this.f38057c;
        p10 = p.p(list, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((b) it.next()).b());
        }
        return arrayList;
    }

    public final int t() {
        return this.f38057c.size();
    }

    public final Animator u(final View view, int i10, int i11) {
        ValueAnimator heightAnimator = ValueAnimator.ofInt(i10, i11);
        heightAnimator.setDuration(400L);
        heightAnimator.setInterpolator(this.f38061g);
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: x7.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C1687d.v(layoutParams, view, valueAnimator);
            }
        });
        i.e(heightAnimator, "heightAnimator");
        return heightAnimator;
    }

    public final void w(RecyclerView.B b10, int i10) {
        if (y(i10) || x(i10)) {
            ViewGroup.LayoutParams layoutParams = b10.itemView.getLayoutParams();
            i.d(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).f(true);
        }
    }

    public final boolean x(int i10) {
        if (getItemCount() - i10 <= q()) {
            return true;
        }
        return false;
    }

    public final boolean y(int i10) {
        if (i10 < t()) {
            return true;
        }
        return false;
    }

    public final boolean z(RecyclerView.B b10) {
        ViewGroup.LayoutParams layoutParams = b10.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, int i10, List<Object> payloads) {
        i.f(holder, "holder");
        i.f(payloads, "payloads");
        if (!y(i10) && !x(i10)) {
            int t10 = i10 - t();
            RecyclerView.Adapter<RecyclerView.B> adapter = this.f38055a;
            if (adapter != null) {
                adapter.onBindViewHolder(holder, t10, payloads);
                return;
            }
            return;
        }
        holder.itemView.requestLayout();
    }
}
