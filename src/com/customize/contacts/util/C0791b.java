package com.customize.contacts.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.model.Account;
import com.android.contacts.model.AccountType;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;
import java.util.ArrayList;
import n1.AbstractC1362a;

/* compiled from: AccountsListAdapter.kt */
/* renamed from: com.customize.contacts.util.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0791b extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22025a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Account> f22026b;

    /* renamed from: c, reason: collision with root package name */
    public final p.a f22027c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence[] f22028d;

    /* renamed from: e, reason: collision with root package name */
    public AccountType f22029e;

    /* renamed from: f, reason: collision with root package name */
    public a f22030f;

    /* compiled from: AccountsListAdapter.kt */
    /* renamed from: com.customize.contacts.util.b$a */
    /* loaded from: classes3.dex */
    public interface a {
        void onClick(int i10);
    }

    /* compiled from: AccountsListAdapter.kt */
    /* renamed from: com.customize.contacts.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0205b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f22031a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f22032b;

        /* renamed from: c, reason: collision with root package name */
        public final View f22033c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0205b(View view) {
            super(view);
            kotlin.jvm.internal.i.f(view, "view");
            View findViewById = view.findViewById(R.id.label);
            kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f22031a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.name);
            kotlin.jvm.internal.i.d(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f22032b = (TextView) findViewById2;
            this.f22033c = view.findViewById(R.id.bottom_divider);
        }

        public final View e() {
            return this.f22033c;
        }

        public final TextView f() {
            return this.f22031a;
        }

        public final TextView g() {
            return this.f22032b;
        }
    }

    public C0791b(Context context, ArrayList<Account> accounts, p.a aVar) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(accounts, "accounts");
        this.f22025a = context;
        this.f22026b = accounts;
        this.f22027c = aVar;
        this.f22028d = M3.c.d(context, accounts, -1, false);
    }

    public static final void h(C0791b this$0, int i10, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        p.a aVar = this$0.f22027c;
        if (aVar != null) {
            aVar.a(Integer.valueOf(i10));
        }
        a aVar2 = this$0.f22030f;
        if (aVar2 != null) {
            aVar2.onClick(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f22026b.size();
    }

    public final void i(a listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f22030f = listener;
    }

    public final void j(TextView textView, Account account, int i10) {
        CharSequence charSequence;
        CharSequence[] charSequenceArr;
        AccountType accountType = this.f22029e;
        if (accountType != null) {
            charSequence = accountType.f(this.f22025a);
        } else {
            charSequence = null;
        }
        textView.setText(charSequence);
        if (TextUtils.equals(R0.a.f3166b, account.f16942b) && (charSequenceArr = this.f22028d) != null) {
            textView.setText(charSequenceArr[i10]);
        }
        if (TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
            textView.setText(com.customize.contacts.simcontacts.b.f(this.f22025a, com.customize.contacts.simcontacts.b.j(account.f16941a)));
        }
    }

    public final void k(TextView textView, Account account, int i10) {
        if (!TextUtils.equals(R0.a.f3166b, account.f16942b) && !TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
            textView.setVisibility(0);
            CharSequence[] charSequenceArr = this.f22028d;
            if (charSequenceArr != null) {
                textView.setText(charSequenceArr[i10]);
                return;
            }
            return;
        }
        textView.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, final int i10) {
        kotlin.jvm.internal.i.f(holder, "holder");
        if (holder instanceof C0205b) {
            Account account = this.f22026b.get(i10);
            kotlin.jvm.internal.i.e(account, "accounts[position]");
            Account account2 = account;
            View view = null;
            this.f22029e = AbstractC1362a.h(this.f22025a).c(account2.f16942b, null);
            C0205b c0205b = (C0205b) holder;
            c0205b.g().setVisibility(0);
            k(c0205b.g(), account2, i10);
            j(c0205b.f(), account2, i10);
            if (i10 == getItemCount() - 1) {
                View e10 = c0205b.e();
                if (e10 != null) {
                    view = e10.findViewById(R.id.bottom_divider);
                }
                if (view != null) {
                    view.setVisibility(8);
                }
            } else {
                View e11 = c0205b.e();
                if (e11 != null) {
                    view = e11.findViewById(R.id.bottom_divider);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.util.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C0791b.h(C0791b.this, i10, view2);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f22025a).inflate(R.layout.account_select_list_item, parent, false);
        kotlin.jvm.internal.i.e(inflate, "from(context).inflate(R.…list_item, parent, false)");
        C0205b c0205b = new C0205b(inflate);
        c0205b.itemView.setBackgroundResource(R.drawable.coui_preference_bg_selector);
        return c0205b;
    }
}
