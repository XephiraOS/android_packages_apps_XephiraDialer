package com.oplus.contacts.list;

import Z0.b;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import b7.C0528a;
import b7.C0529b;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.E;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.util.C;
import com.android.contacts.util.C0700a;
import com.oplus.contacts.list.viewmodel.ContactsMainListViewModel;
import com.oplus.dialer.R;
import java.util.List;
import kotlin.jvm.internal.i;
import v7.C1634a;
import x0.AbstractC1671i;
import x0.k;
import x0.m;
import x7.AbstractC1685b;
import x7.f;
import y7.C1708a;

/* compiled from: ContactsMainListAdapter.kt */
/* loaded from: classes3.dex */
public final class a extends AbstractC1685b<C1708a, f> {

    /* renamed from: E, reason: collision with root package name */
    public static final C0254a f27846E = new C0254a(null);

    /* renamed from: A, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27847A;

    /* renamed from: B, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27848B;

    /* renamed from: C, reason: collision with root package name */
    public b f27849C;

    /* renamed from: D, reason: collision with root package name */
    public w7.c f27850D;

    /* renamed from: j, reason: collision with root package name */
    public final Context f27851j;

    /* renamed from: k, reason: collision with root package name */
    public final ContactsMainListViewModel f27852k;

    /* renamed from: l, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27853l;

    /* renamed from: m, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27854m;

    /* renamed from: n, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27855n;

    /* renamed from: o, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27856o;

    /* renamed from: p, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27857p;

    /* renamed from: q, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27858q;

    /* renamed from: r, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27859r;

    /* renamed from: x, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27860x;

    /* renamed from: y, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27861y;

    /* renamed from: z, reason: collision with root package name */
    public final com.oplus.foundation.util.io.a f27862z;

    /* compiled from: ContactsMainListAdapter.kt */
    /* renamed from: com.oplus.contacts.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0254a {
        public C0254a() {
        }

        public /* synthetic */ C0254a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ContactsMainListAdapter.kt */
    /* loaded from: classes3.dex */
    public interface b {
        boolean a(Uri uri);
    }

    public a(Context context, ContactsMainListViewModel viewModel) {
        i.f(context, "context");
        i.f(viewModel, "viewModel");
        this.f27851j = context;
        this.f27852k = viewModel;
        this.f27853l = new com.oplus.foundation.util.io.a(BreenoCallContract.BaseColumns._ID, -1);
        this.f27854m = new com.oplus.foundation.util.io.a("contact_presence", -1);
        this.f27855n = new com.oplus.foundation.util.io.a("contact_status", -1);
        this.f27856o = new com.oplus.foundation.util.io.a("photo_id", -1);
        this.f27857p = new com.oplus.foundation.util.io.a("photo_thumb_uri", -1);
        this.f27858q = new com.oplus.foundation.util.io.a("lookup", -1);
        this.f27859r = new com.oplus.foundation.util.io.a("is_user_profile", -1);
        this.f27860x = new com.oplus.foundation.util.io.a("starred", -1);
        this.f27861y = new com.oplus.foundation.util.io.a("account_type", -1);
        this.f27862z = new com.oplus.foundation.util.io.a("account_name", -1);
        this.f27847A = new com.oplus.foundation.util.io.a("organization", -1);
        this.f27848B = new com.oplus.foundation.util.io.a("phonenumber", -1);
    }

    @Override // x7.AbstractC1685b
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void s(C1708a holder, int i10, f item, List<Object> payloads) {
        i.f(holder, "holder");
        i.f(item, "item");
        i.f(payloads, "payloads");
        if (payloads.isEmpty()) {
            r(holder, i10, item);
            return;
        }
        Object obj = payloads.get(0);
        if (i.b(obj, "hide_photo")) {
            B(false, holder, item);
        } else if (i.b(obj, "show_photo")) {
            B(true, holder, item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(boolean z10, C1708a c1708a, f fVar) {
        int i10;
        b.c cVar;
        if (c1708a instanceof b7.d) {
            b7.d dVar = (b7.d) c1708a;
            ImageView a10 = dVar.a();
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            a10.setVisibility(i10);
            if (z10) {
                if (fVar.k() != 0) {
                    Z0.b.g(this.f27851j).o(dVar.a(), fVar.k(), fVar.a(), false, false, null);
                    return;
                }
                Uri l10 = fVar.l();
                if (l10 == null) {
                    cVar = new b.c(fVar.g(), String.valueOf(fVar.d()), false);
                } else {
                    cVar = null;
                }
                Z0.b.g(this.f27851j).i(dVar.a(), l10, fVar.a(), false, false, cVar);
            }
        }
    }

    public final int C(String str) {
        if (str == null) {
            return -1;
        }
        return C0700a.a(C0700a.b(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0489  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.oplus.contacts.list.f D(android.database.Cursor r29) {
        /*
            Method dump skipped, instructions count: 2097
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.a.D(android.database.Cursor):com.oplus.contacts.list.f");
    }

    @Override // x7.AbstractC1685b
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public f t(Cursor cursor, int i10) {
        i.f(cursor, "cursor");
        return D(cursor);
    }

    @Override // x7.AbstractC1685b
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public boolean u(f itemBean) {
        i.f(itemBean, "itemBean");
        return this.f27852k.q().getValue().e(itemBean);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C1708a onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        if (i10 != 1) {
            if (i10 != 2) {
                AbstractC1671i dataBinding = (AbstractC1671i) androidx.databinding.g.h(LayoutInflater.from(parent.getContext()), R.layout.contacts_main_list_item, parent, false);
                i.e(dataBinding, "dataBinding");
                return new C0528a(dataBinding);
            }
            k dataBinding2 = (k) androidx.databinding.g.h(LayoutInflater.from(parent.getContext()), R.layout.contacts_main_list_item_with_header, parent, false);
            i.e(dataBinding2, "dataBinding");
            return new C0529b(dataBinding2);
        }
        m dataBinding3 = (m) androidx.databinding.g.h(LayoutInflater.from(parent.getContext()), R.layout.contacts_main_list_item_with_header_star, parent, false);
        i.e(dataBinding3, "dataBinding");
        return new b7.c(dataBinding3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x7.AbstractC1685b
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void y(C1708a holder, int i10, f item, boolean z10) {
        b bVar;
        i.f(holder, "holder");
        i.f(item, "item");
        if ((holder instanceof b7.d) && (bVar = this.f27849C) != null) {
            if (bVar.a(item.i())) {
                ((b7.d) holder).c().setBackgroundColor(r.b(this.f27851j));
                return;
            }
            b7.d dVar = (b7.d) holder;
            C.b(dVar.c(), z10);
            dVar.c().setBackgroundResource(R.drawable.select_list_item_background_seletor);
        }
    }

    public final void I(w7.c cVar) {
        this.f27850D = cVar;
    }

    public final void J(b bVar) {
        this.f27849C = bVar;
    }

    @Override // x7.e
    public CheckBox b(RecyclerView.B b10) {
        if (b10 instanceof C0529b) {
            return ((C0529b) b10).e().f37731G.f37718G;
        }
        if (b10 instanceof b7.c) {
            return ((b7.c) b10).e().f37740G.f37718G;
        }
        if (b10 instanceof C0528a) {
            return ((C0528a) b10).e().f37718G;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        f.a n10 = n(i10);
        String b10 = n10.b();
        if (b10 != null && b10.length() != 0) {
            if (i.b(n10.b(), "*")) {
                return 1;
            }
            return 2;
        }
        return 3;
    }

    @Override // x7.f
    public C1634a m(Cursor cursor) {
        Bundle extras;
        if (com.oplus.foundation.util.io.b.b(cursor) || cursor == null || (extras = cursor.getExtras()) == null || !extras.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES")) {
            return null;
        }
        return new C1634a(extras.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES"), extras.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS"));
    }

    @Override // x7.AbstractC1685b
    public boolean v() {
        return this.f27852k.n().getValue().booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x7.AbstractC1685b
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void r(C1708a holder, int i10, f item) {
        Boolean bool;
        i.f(holder, "holder");
        i.f(item, "item");
        if (holder instanceof C0529b) {
            item.s(n(i10).b());
            ((C0529b) holder).e().i1(item.m());
        }
        holder.e().K0().setTag(R.id.tag_contact_main_list_item_info, item);
        holder.e().K0().setTag(R.id.tag_contact_main_list_item_position, Integer.valueOf(i10));
        if (holder instanceof b7.d) {
            if (i10 < getItemCount() - 1) {
                ((b7.d) holder).d().setVisibility(0);
            } else {
                ((b7.d) holder).d().setVisibility(8);
            }
            b7.d dVar = (b7.d) holder;
            dVar.b(item);
            B(this.f27852k.o().getValue().booleanValue(), holder, item);
            View c10 = dVar.c();
            c10.setTag(R.id.tag_contact_main_list_item_info, item);
            c10.setTag(R.id.tag_contact_main_list_item_position, Integer.valueOf(i10));
            b bVar = this.f27849C;
            if (bVar != null) {
                if (bVar.a(item.i())) {
                    c10.setBackgroundColor(r.b(this.f27851j));
                } else {
                    Object tag = c10.getTag(R.id.list_item_long_clicked);
                    if (tag instanceof Boolean) {
                        bool = (Boolean) tag;
                    } else {
                        bool = null;
                    }
                    if (i.b(bool, Boolean.TRUE)) {
                        E.a(c10);
                    } else {
                        c10.setBackgroundResource(R.drawable.select_list_item_background_seletor);
                    }
                }
            }
            new w7.d().a(c10, i10, this.f27852k.n().getValue().booleanValue(), this.f27850D);
        }
    }
}
