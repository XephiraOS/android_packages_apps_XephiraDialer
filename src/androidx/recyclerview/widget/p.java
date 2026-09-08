package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.B;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.j;
import java.util.List;

/* compiled from: ListAdapter.java */
/* loaded from: classes.dex */
public abstract class p<T, VH extends RecyclerView.B> extends RecyclerView.Adapter<VH> {
    final d<T> mDiffer;
    private final d.b<T> mListener;

    /* compiled from: ListAdapter.java */
    /* loaded from: classes.dex */
    public class a implements d.b<T> {
        public a() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public void a(List<T> list, List<T> list2) {
            p.this.onCurrentListChanged(list, list2);
        }
    }

    public p(j.f<T> fVar) {
        a aVar = new a();
        this.mListener = aVar;
        d<T> dVar = new d<>(new b(this), new c.a(fVar).a());
        this.mDiffer = dVar;
        dVar.a(aVar);
    }

    public List<T> getCurrentList() {
        return this.mDiffer.b();
    }

    public T getItem(int i10) {
        return this.mDiffer.b().get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.b().size();
    }

    public void submitList(List<T> list) {
        this.mDiffer.e(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.mDiffer.f(list, runnable);
    }

    public p(c<T> cVar) {
        a aVar = new a();
        this.mListener = aVar;
        d<T> dVar = new d<>(new b(this), cVar);
        this.mDiffer = dVar;
        dVar.a(aVar);
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
    }
}
