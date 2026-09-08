package com.android.contacts.calllog;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.MergeCursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.io.CloseableUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: GroupingListAdapter.java */
/* loaded from: classes.dex */
public abstract class F extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: b, reason: collision with root package name */
    public final ComponentActivity f13787b;

    /* renamed from: c, reason: collision with root package name */
    public final LayoutInflater f13788c;

    /* renamed from: g, reason: collision with root package name */
    public Cursor f13792g;

    /* renamed from: h, reason: collision with root package name */
    public int f13793h;

    /* renamed from: i, reason: collision with root package name */
    public HeaderFooterRecyclerView f13794i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13797l;

    /* renamed from: a, reason: collision with root package name */
    public com.android.contacts.framework.baseui.calllog.b f13786a = new com.android.contacts.framework.baseui.calllog.b();

    /* renamed from: d, reason: collision with root package name */
    public boolean f13789d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13790e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13791f = false;

    /* renamed from: j, reason: collision with root package name */
    public ContentObserver f13795j = new a(new Handler(Looper.getMainLooper()));

    /* renamed from: m, reason: collision with root package name */
    public DataSetObserver f13798m = new b();

    /* renamed from: k, reason: collision with root package name */
    public final d f13796k = new d(this);

    /* compiled from: GroupingListAdapter.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            F.this.m();
        }
    }

    /* compiled from: GroupingListAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            F.this.D();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            F.this.D();
        }
    }

    /* compiled from: GroupingListAdapter.java */
    /* loaded from: classes.dex */
    public static class c extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public o f13801a;

        public c(View view) {
            super(view);
            o a10 = o.a(this.itemView);
            this.f13801a = a10;
            this.itemView.setTag(R.id.call_log_view_key, a10);
        }
    }

    /* compiled from: GroupingListAdapter.java */
    /* loaded from: classes.dex */
    public static class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<F> f13802a;

        public d(F f10) {
            super(Looper.getMainLooper());
            this.f13802a = new WeakReference<>(f10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            F f10 = this.f13802a.get();
            int i10 = message.what;
            if (i10 != 222) {
                if (i10 != 333) {
                    if (i10 == 444) {
                        Cursor cursor = (Cursor) message.obj;
                        if (f10 != null) {
                            if (cursor == null || !cursor.isClosed()) {
                                f10.j(cursor, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (f10 != null) {
                    f10.D();
                    return;
                }
                return;
            }
            if (f10 != null) {
                if (H7.a.b()) {
                    H7.b.b("GroupingListAdapter", "MESSAGE_REQUERY.");
                }
                f10.E();
            }
        }
    }

    public F(ComponentActivity componentActivity) {
        this.f13797l = false;
        this.f13787b = componentActivity;
        this.f13788c = LayoutInflater.from(componentActivity);
        this.f13797l = DisplayUtil.h(componentActivity);
    }

    private int getChildCount(int i10) {
        return this.f13786a.i(i10);
    }

    public static int t(boolean z10) {
        if (z10) {
            return R.layout.call_log_large_text_list_item;
        }
        return R.layout.call_log_list_item;
    }

    public boolean A() {
        return this.f13786a.m();
    }

    public final boolean B(int i10) {
        if (3 == i10) {
            return true;
        }
        return false;
    }

    public final boolean C() {
        H7.b.e("GroupingListAdapter", "notifyDataChanged mAnimating:" + this.f13789d + ", mIsFling = " + this.f13790e + ", mAlphaIn = " + this.f13791f);
        if (!w() && !this.f13790e && !this.f13791f) {
            return false;
        }
        return true;
    }

    public void D() {
        if (x()) {
            H7.b.e("GroupingListAdapter", "notifyDataChanged isComputingLayout");
            l();
        } else if (C()) {
            l();
        } else {
            notifyDataSetChanged();
        }
    }

    public final void F() {
        String str;
        Cursor cursor;
        long n10 = this.f13786a.n();
        if (n10 > 0 && (cursor = this.f13792g) != null) {
            int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns.DATE);
            if (columnIndex > -1 && this.f13792g.moveToFirst()) {
                long j10 = this.f13792g.getLong(columnIndex);
                if (j10 != n10) {
                    this.f13786a.e(this.f13792g);
                    if (H7.a.b()) {
                        H7.b.b("GroupingListAdapter", "recheckGroupInfo adapter: " + this + ";itemCount: " + getItemCount());
                        H7.b.b("GroupingListAdapter", "first call timestamp different: " + n10 + "-" + j10);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("recheckGroupInfo: firstCallTimeStamp: ");
        sb.append(n10);
        if (this.f13792g != null) {
            str = "";
        } else {
            str = ", cursor: null.";
        }
        sb.append(str);
        H7.b.i("GroupingListAdapter", sb.toString());
    }

    public void G(boolean z10) {
        this.f13786a.t(z10);
    }

    public void H(HeaderFooterRecyclerView headerFooterRecyclerView) {
        this.f13794i = headerFooterRecyclerView;
    }

    public final Cursor I(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar) {
        Cursor cursor2 = this.f13792g;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ContentObserver contentObserver = this.f13795j;
            if (contentObserver != null) {
                cursor2.unregisterContentObserver(contentObserver);
            }
            DataSetObserver dataSetObserver = this.f13798m;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f13792g = cursor;
        if (bVar == null) {
            this.f13786a.e(cursor);
        } else {
            this.f13786a = bVar;
        }
        if (H7.a.b()) {
            H7.b.b("GroupingListAdapter", "swapCursor adapter: " + this + ";itemCount: " + getItemCount());
        }
        if (cursor != null) {
            ContentObserver contentObserver2 = this.f13795j;
            if (contentObserver2 != null) {
                cursor.registerContentObserver(contentObserver2);
            }
            DataSetObserver dataSetObserver2 = this.f13798m;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f13793h = cursor.getColumnIndexOrThrow(BreenoCallContract.BaseColumns._ID);
        }
        notifyDataSetChanged();
        return cursor2;
    }

    public void J() {
        com.android.contacts.framework.baseui.calllog.b bVar = this.f13786a;
        if (!bVar.f15773b) {
            bVar.e(this.f13792g);
            notifyDataSetChanged();
        }
    }

    public Object getItem(int i10) {
        Cursor cursor = this.f13792g;
        if (cursor != null && !cursor.isClosed() && this.f13792g.moveToPosition(i10)) {
            return this.f13792g;
        }
        Log.w("GroupingListAdapter", "getItemId: cursor is closed");
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13786a.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        if (getItem(i10) != null) {
            return this.f13792g.getLong(this.f13793h);
        }
        Log.w("GroupingListAdapter", "getItemId: cursor is closed return 0");
        return 0L;
    }

    public final void h(c cVar, int i10) {
        int k10 = this.f13786a.k(i10);
        if (!this.f13792g.isClosed() && this.f13792g.moveToPosition(k10)) {
            ComponentActivity componentActivity = this.f13787b;
            Cursor cursor = this.f13792g;
            i(cVar, componentActivity, cursor, u(cursor, getChildCount(i10)), i10);
        }
    }

    public abstract void i(c cVar, Context context, Cursor cursor, int i10, int i11);

    public void j(Cursor cursor, com.android.contacts.framework.baseui.calllog.b bVar) {
        if (y(cursor) && (x() || C() || z())) {
            k(cursor);
            return;
        }
        Object obj = this.f13796k.obtainMessage(444).obj;
        if (obj != null) {
            CloseableUtils.b((Cursor) obj);
        }
        this.f13796k.removeMessages(444);
        Cursor I10 = I(cursor, bVar);
        if (I10 != null && !I10.isClosed()) {
            if (I10.getColumnCount() == com.android.contacts.framework.baseui.calllog.d.a().length || (I10 instanceof MergeCursor) || !(cursor instanceof MergeCursor)) {
                CloseableUtils.b(I10);
            }
        }
    }

    public final void k(Cursor cursor) {
        Message obtainMessage = this.f13796k.obtainMessage(444);
        Object obj = obtainMessage.obj;
        if (obj != null) {
            CloseableUtils.b((Cursor) obj);
        }
        obtainMessage.what = 444;
        obtainMessage.obj = cursor;
        this.f13796k.removeMessages(444);
        this.f13796k.sendMessageDelayed(obtainMessage, 1000L);
    }

    public final void l() {
        this.f13796k.removeMessages(333);
        this.f13796k.sendEmptyMessageDelayed(333, 1000L);
    }

    public final void m() {
        if (H7.a.b()) {
            H7.b.b("GroupingListAdapter", "delayToRequery.");
        }
        this.f13796k.removeMessages(222);
        this.f13796k.sendEmptyMessageDelayed(222, 350L);
    }

    public int n(int i10) {
        return this.f13786a.d(i10);
    }

    public List<Q0.b> o() {
        return this.f13786a.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B b10, int i10) {
        if (b10 instanceof c) {
            if (i10 == 0) {
                F();
            }
            h((c) b10, i10);
        }
    }

    public Q0.b p(String str) {
        return this.f13786a.h().get(str);
    }

    public Cursor q() {
        return this.f13792g;
    }

    public j.b r() {
        return this.f13786a.l();
    }

    public com.android.contacts.framework.baseui.calllog.b s() {
        return this.f13786a;
    }

    public final int u(Cursor cursor, int i10) {
        int position = cursor.getPosition();
        int i11 = 0;
        for (int i12 = 0; i12 < i10 && B(cursor.getInt(4)); i12++) {
            i11++;
            cursor.moveToNext();
        }
        cursor.moveToPosition(position);
        if (i11 < 2) {
            return 0;
        }
        return i11;
    }

    public List<Q0.b> v() {
        return this.f13786a.o();
    }

    public boolean w() {
        return this.f13789d;
    }

    public final boolean x() {
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f13794i;
        if (headerFooterRecyclerView != null && headerFooterRecyclerView.isComputingLayout()) {
            return true;
        }
        return false;
    }

    public final boolean y(Cursor cursor) {
        if (this.f13792g == null) {
            if (cursor != null) {
                return false;
            }
        } else {
            if (cursor == null) {
                return false;
            }
            if (!cursor.isClosed() && !this.f13792g.isClosed()) {
                if (cursor.getCount() != this.f13792g.getCount()) {
                    return false;
                }
            } else {
                H7.b.e("GroupingListAdapter", "cursor or old cursor is closed");
                return false;
            }
        }
        return true;
    }

    public boolean z() {
        return false;
    }

    public void E() {
    }
}
