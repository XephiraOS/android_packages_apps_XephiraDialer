package l2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.incallui.R;
import com.android.incallui.oplus.callbutton.callbuttonview.InCallButtonItem;
import java.util.ArrayList;
import java.util.List;
import k2.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: RecyclerAdapter.kt */
/* renamed from: l2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1289a extends RecyclerView.Adapter<b> {

    /* renamed from: b, reason: collision with root package name */
    public static final C0329a f34670b = new C0329a(null);

    /* renamed from: a, reason: collision with root package name */
    public List<e> f34671a;

    /* compiled from: RecyclerAdapter.kt */
    /* renamed from: l2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0329a {
        public C0329a() {
        }

        public /* synthetic */ C0329a(f fVar) {
            this();
        }
    }

    /* compiled from: RecyclerAdapter.kt */
    /* renamed from: l2.a$b */
    /* loaded from: classes.dex */
    public static final class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public InCallButtonItem f34672a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            i.f(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.button_item);
            i.e(findViewById, "itemView.findViewById(R.id.button_item)");
            InCallButtonItem inCallButtonItem = (InCallButtonItem) findViewById;
            this.f34672a = inCallButtonItem;
            View findViewById2 = itemView.findViewById(R.id.text);
            i.e(findViewById2, "itemView.findViewById(R.id.text)");
            inCallButtonItem.setMText((TextView) findViewById2);
            InCallButtonItem inCallButtonItem2 = this.f34672a;
            View findViewById3 = itemView.findViewById(R.id.circle);
            i.e(findViewById3, "itemView.findViewById(R.id.circle)");
            inCallButtonItem2.setMCircle((ImageView) findViewById3);
            InCallButtonItem inCallButtonItem3 = this.f34672a;
            View findViewById4 = itemView.findViewById(R.id.image);
            i.e(findViewById4, "itemView.findViewById(R.id.image)");
            inCallButtonItem3.setMImage((ImageView) findViewById4);
            InCallButtonItem inCallButtonItem4 = this.f34672a;
            View findViewById5 = itemView.findViewById(R.id.image_selected);
            i.e(findViewById5, "itemView.findViewById(R.id.image_selected)");
            inCallButtonItem4.setMSelectedImage((ImageView) findViewById5);
        }

        public final InCallButtonItem e() {
            return this.f34672a;
        }
    }

    public final void g(e callButton) {
        i.f(callButton, "callButton");
        Log.d("RecyclerAdapter", "addCallButtonList = " + callButton.n());
        if (this.f34671a == null) {
            this.f34671a = new ArrayList();
        }
        List<e> list = this.f34671a;
        if (list != null) {
            list.add(callButton);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<e> list = this.f34671a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void h() {
        List<e> list = this.f34671a;
        if (list != null) {
            list.clear();
        }
    }

    public final List<e> i() {
        return this.f34671a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int i10) {
        i.f(holder, "holder");
        List<e> list = this.f34671a;
        if (list != null && list.size() > 0) {
            holder.e().a(list.get(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incall_button_item, (ViewGroup) null);
        i.e(view, "view");
        return new b(view);
    }
}
