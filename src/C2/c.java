package c2;

import O1.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.g;
import com.android.incallui.R;
import e2.C0966a;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: OplusAudioModeAdapter.kt */
/* loaded from: classes.dex */
public final class c<T extends C0966a> extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f12720a;

    /* renamed from: b, reason: collision with root package name */
    public final List<T> f12721b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(AppCompatActivity context, List<? extends T> datas) {
        i.f(context, "context");
        i.f(datas, "datas");
        this.f12720a = context;
        this.f12721b = datas;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T getItem(int i10) {
        return this.f12721b.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12721b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        q qVar;
        boolean z10;
        boolean z11 = false;
        if (view == null || (qVar = (q) g.f(view)) == null) {
            qVar = (q) g.h(LayoutInflater.from(this.f12720a), R.layout.item_audio_mode_dialog, viewGroup, false);
        }
        qVar.i1(getItem(i10));
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        qVar.j1(z10);
        if (i10 == this.f12721b.size() - 1) {
            z11 = true;
        }
        qVar.k1(z11);
        qVar.b1(this.f12720a);
        View K02 = qVar.K0();
        i.e(K02, "convertView\n            …      }\n            .root");
        return K02;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return this.f12721b.get(i10).d();
    }
}
