package com.android.contacts.list;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.compat.data.WashManager;
import com.android.contacts.util.g;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: FilterListAdapter.kt */
/* loaded from: classes.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: k, reason: collision with root package name */
    public static final a f16885k = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f16886a;

    /* renamed from: b, reason: collision with root package name */
    public List<ContactListFilter> f16887b;

    /* renamed from: c, reason: collision with root package name */
    public ContactListFilter f16888c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0172c f16889d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16890e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f16891f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f16892g;

    /* renamed from: h, reason: collision with root package name */
    public Thread f16893h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16894i;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f16895j;

    /* compiled from: FilterListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FilterListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<c> f16896a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f16897b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c adapter) {
            super("FilterListAdapter.ContactsCountThread");
            i.f(adapter, "adapter");
            this.f16897b = new Object();
            this.f16896a = new WeakReference<>(adapter);
        }

        /* JADX WARN: Code restructure failed: missing block: B:84:0x017a, code lost:
        
            if (r2 != null) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x017c, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x019d, code lost:
        
            if (H7.a.b() == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x019f, code lost:
        
            H7.b.b("FilterListAdapter", "run() ----------REDRAW ");
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x01a6, code lost:
        
            r0.f16895j.sendEmptyMessage(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x01ae, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0196, code lost:
        
            if (0 == 0) goto L83;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 439
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.list.c.b.run():void");
        }
    }

    /* compiled from: FilterListAdapter.kt */
    /* renamed from: com.android.contacts.list.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0172c {
        void onItemClick(View view, int i10);
    }

    /* compiled from: FilterListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class d extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final ContactListFilterView f16898a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            i.f(view, "view");
            this.f16898a = (ContactListFilterView) view;
        }

        public final ContactListFilterView e() {
            return this.f16898a;
        }
    }

    /* compiled from: FilterListAdapter.kt */
    /* loaded from: classes.dex */
    public static final class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            i.f(msg, "msg");
            int i10 = msg.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    c.this.t();
                    return;
                } else {
                    H7.b.c("FilterListAdapter", "Should not reach here!");
                    return;
                }
            }
            c.this.notifyDataSetChanged();
        }
    }

    public c(Context context, List<ContactListFilter> filterList, ContactListFilter contactListFilter, InterfaceC0172c itemClickListener) {
        i.f(context, "context");
        i.f(filterList, "filterList");
        i.f(itemClickListener, "itemClickListener");
        this.f16886a = context;
        this.f16887b = filterList;
        this.f16888c = contactListFilter;
        this.f16889d = itemClickListener;
        this.f16895j = new e(Looper.getMainLooper());
        this.f16891f = new int[this.f16887b.size()];
        this.f16892g = new int[this.f16887b.size()];
        int size = this.f16887b.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f16891f[i10] = -1;
            this.f16892g[i10] = -1;
        }
        v();
    }

    public static final void p(c this$0, ContactListFilterView view, int i10, View view2) {
        i.f(this$0, "this$0");
        i.f(view, "$view");
        this$0.f16889d.onItemClick(view, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16887b.size();
    }

    public final boolean m(ContactListFilter contactListFilter, ContactListFilter contactListFilter2) {
        String g10;
        String g11;
        if (contactListFilter == contactListFilter2) {
            return true;
        }
        if (TextUtils.isEmpty(contactListFilter.f16740d)) {
            g10 = contactListFilter.f16740d;
        } else {
            String str = contactListFilter.f16740d;
            i.e(str, "oldFilter.mAccountName");
            g10 = WashManager.g(str);
        }
        if (TextUtils.isEmpty(contactListFilter.f16739c)) {
            g11 = contactListFilter.f16739c;
        } else {
            String str2 = contactListFilter.f16739c;
            i.e(str2, "oldFilter.mAccountType");
            g11 = WashManager.g(str2);
        }
        if (contactListFilter2 != null && contactListFilter.f16738b == contactListFilter2.f16738b && TextUtils.equals(g10, contactListFilter2.f16740d) && TextUtils.equals(g11, contactListFilter2.f16739c) && TextUtils.equals(contactListFilter.f16741e, contactListFilter2.f16741e)) {
            return true;
        }
        return false;
    }

    public final Context n() {
        return this.f16886a;
    }

    public final List<ContactListFilter> o() {
        return this.f16887b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, final int i10) {
        String a10;
        i.f(holder, "holder");
        if (holder instanceof d) {
            ContactListFilter contactListFilter = this.f16887b.get(i10);
            final ContactListFilterView e10 = ((d) holder).e();
            e10.setContactListFilter(contactListFilter);
            e10.b(true);
            e10.setCountText(this.f16892g[i10]);
            if (this.f16894i) {
                e10.getRadioButton().setVisibility(0);
            }
            if (m(contactListFilter, this.f16888c)) {
                e10.setRadioStatus(true);
                ContactListFilter contactListFilter2 = this.f16888c;
                if (contactListFilter2 != null && contactListFilter2.f16738b == -3) {
                    a10 = g.a(e10.getContext(), this.f16892g[i10], this.f16891f[i10], true, contactListFilter.k());
                } else {
                    a10 = g.a(e10.getContext(), this.f16892g[i10], this.f16891f[i10], false, contactListFilter.k());
                }
                e10.c(a10);
            } else {
                e10.setRadioStatus(false);
            }
            e10.setTag(contactListFilter);
            if (i10 == getItemCount() - 1) {
                e10.getBottomDivider().setVisibility(8);
            } else {
                e10.getBottomDivider().setVisibility(0);
            }
            e10.setOnClickListener(new View.OnClickListener() { // from class: m1.H
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.android.contacts.list.c.p(com.android.contacts.list.c.this, e10, i10, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f16886a).inflate(R.layout.contact_list_filter_item, parent, false);
        i.e(inflate, "from(context).inflate(R.…lter_item, parent, false)");
        d dVar = new d(inflate);
        dVar.itemView.setBackgroundResource(R.drawable.coui_preference_bg_selector);
        return dVar;
    }

    public final void q(ContactListFilter contactListFilter) {
        this.f16888c = contactListFilter;
    }

    public final void r(List<ContactListFilter> list) {
        i.f(list, "list");
        this.f16887b = list;
        this.f16891f = new int[list.size()];
        this.f16892g = new int[list.size()];
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f16891f[i10] = -1;
            this.f16892g[i10] = -1;
        }
    }

    public final void s(boolean z10) {
        this.f16894i = z10;
    }

    public final void t() {
        H7.b.e("FilterListAdapter", "startRequestProcessing()--------");
        Thread thread = this.f16893h;
        if (thread != null && thread != null && thread.isAlive()) {
            this.f16890e = true;
            Thread thread2 = this.f16893h;
            if (thread2 != null) {
                thread2.interrupt();
            }
            H7.b.e("FilterListAdapter", "startRequestProcessing() ,mContactsCountThread.isAlive() ------");
            return;
        }
        b bVar = new b(this);
        this.f16893h = bVar;
        bVar.setPriority(1);
        Thread thread3 = this.f16893h;
        if (thread3 != null) {
            thread3.start();
        }
        this.f16890e = false;
    }

    public final void u() {
        Thread thread = this.f16893h;
        if (thread != null) {
            this.f16890e = true;
            thread.interrupt();
            this.f16893h = null;
        }
    }

    public final void v() {
        Thread thread = this.f16893h;
        if (thread == null || thread == null || !thread.isAlive()) {
            H7.b.e("FilterListAdapter", "updateContactsCount Send Message START_THREAD.");
            this.f16895j.sendEmptyMessage(2);
        }
    }
}
