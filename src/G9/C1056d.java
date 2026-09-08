package g9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;

/* compiled from: MarkDialogAdapter.kt */
/* renamed from: g9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1056d extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31968a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31969b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f31970c;

    /* renamed from: d, reason: collision with root package name */
    public p.a f31971d;

    /* renamed from: e, reason: collision with root package name */
    public final a f31972e;

    /* compiled from: MarkDialogAdapter.kt */
    /* renamed from: g9.d$a */
    /* loaded from: classes4.dex */
    public interface a {
        void onClick(int i10);
    }

    /* compiled from: MarkDialogAdapter.kt */
    /* renamed from: g9.d$b */
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f31973a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f31974b;

        /* renamed from: c, reason: collision with root package name */
        public final RadioButton f31975c;

        /* renamed from: d, reason: collision with root package name */
        public final View f31976d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            kotlin.jvm.internal.i.f(itemView, "itemView");
            this.f31973a = (TextView) itemView.findViewById(R.id.markType);
            this.f31974b = (TextView) itemView.findViewById(R.id.markTip);
            this.f31975c = (RadioButton) itemView.findViewById(R.id.radio_button);
            this.f31976d = itemView.findViewById(R.id.bottom_divider);
        }

        public final View e() {
            return this.f31976d;
        }

        public final TextView f() {
            return this.f31973a;
        }

        public final RadioButton g() {
            return this.f31975c;
        }

        public final TextView h() {
            return this.f31974b;
        }
    }

    public C1056d(Context context, int i10, String[] labels, p.a aVar, a aVar2) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(labels, "labels");
        this.f31968a = context;
        this.f31969b = i10;
        this.f31970c = labels;
        this.f31971d = aVar;
        this.f31972e = aVar2;
    }

    public static final void h(C1056d this$0, int i10, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.f31970c.length - 1 == i10) {
            p.a aVar = this$0.f31971d;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        p.a aVar2 = this$0.f31971d;
        if (aVar2 != null) {
            aVar2.a(Integer.valueOf(i10));
        }
        a aVar3 = this$0.f31972e;
        if (aVar3 != null) {
            aVar3.onClick(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f31970c.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B viewHolder, final int i10) {
        CharSequence charSequence;
        TextView h10;
        kotlin.jvm.internal.i.f(viewHolder, "viewHolder");
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            TextView f10 = bVar.f();
            if (f10 != null) {
                f10.setText(this.f31970c[i10]);
            }
            TextView f11 = bVar.f();
            if (f11 != null) {
                charSequence = f11.getText();
            } else {
                charSequence = null;
            }
            if (charSequence != null) {
                String obj = bVar.f().getText().toString();
                String[] v10 = E0.b.v(this.f31968a);
                if (!kotlin.jvm.internal.i.b(obj, v10[3]) && !kotlin.jvm.internal.i.b(obj, v10[4]) && (h10 = bVar.h()) != null) {
                    h10.setVisibility(8);
                }
            }
            if (this.f31969b == i10) {
                RadioButton g10 = bVar.g();
                if (g10 != null) {
                    g10.setVisibility(0);
                }
                RadioButton g11 = bVar.g();
                if (g11 != null) {
                    g11.setChecked(true);
                }
            }
            if (i10 == this.f31970c.length - 1) {
                View e10 = bVar.e();
                if (e10 != null) {
                    e10.setVisibility(8);
                }
            } else {
                View e11 = bVar.e();
                if (e11 != null) {
                    e11.setVisibility(0);
                }
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: g9.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C1056d.h(C1056d.this, i10, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View view = LayoutInflater.from(this.f31968a).inflate(R.layout.mark_dialog_item, parent, false);
        view.setBackgroundResource(R.drawable.coui_preference_bg_selector);
        kotlin.jvm.internal.i.e(view, "view");
        return new b(view);
    }
}
