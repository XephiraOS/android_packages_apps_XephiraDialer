package androidx.preference;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.K;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceViewHolder.java */
/* loaded from: classes.dex */
public class l extends RecyclerView.B {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f10624a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f10625b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray<View> f10626c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10627d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10628e;

    public l(View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.f10626c = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        int i10 = o.f10642a;
        sparseArray.put(i10, view.findViewById(i10));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f10624a = view.getBackground();
        if (textView != null) {
            this.f10625b = textView.getTextColors();
        }
    }

    public View e(int i10) {
        View view = this.f10626c.get(i10);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i10);
        if (findViewById != null) {
            this.f10626c.put(i10, findViewById);
        }
        return findViewById;
    }

    public boolean f() {
        return this.f10627d;
    }

    public boolean g() {
        return this.f10628e;
    }

    public void h() {
        Drawable background = this.itemView.getBackground();
        Drawable drawable = this.f10624a;
        if (background != drawable) {
            K.n0(this.itemView, drawable);
        }
        TextView textView = (TextView) e(R.id.title);
        if (textView != null && this.f10625b != null && !textView.getTextColors().equals(this.f10625b)) {
            textView.setTextColor(this.f10625b);
        }
    }

    public void i(boolean z10) {
        this.f10627d = z10;
    }

    public void j(boolean z10) {
        this.f10628e = z10;
    }
}
