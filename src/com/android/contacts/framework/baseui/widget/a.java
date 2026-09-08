package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CompositeCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16124a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<C0167a> f16125b;

    /* renamed from: c, reason: collision with root package name */
    public int f16126c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16127d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16128e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16129f;

    /* compiled from: CompositeCursorAdapter.java */
    /* renamed from: com.android.contacts.framework.baseui.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0167a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f16130a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16131b;

        /* renamed from: c, reason: collision with root package name */
        public Cursor f16132c;

        /* renamed from: d, reason: collision with root package name */
        public int f16133d;

        /* renamed from: e, reason: collision with root package name */
        public int f16134e;

        public C0167a(boolean z10, boolean z11) {
            this.f16130a = z10;
            this.f16131b = z11;
        }

        public boolean a() {
            return this.f16130a;
        }
    }

    public a(Context context) {
        this(context, 2);
    }

    public abstract View A(Context context, int i10, Cursor cursor, int i11, ViewGroup viewGroup);

    public void B(int i10) {
        Cursor cursor = this.f16125b.get(i10).f16132c;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        this.f16125b.remove(i10);
        w();
        notifyDataSetChanged();
    }

    public void C(int i10, boolean z10) {
        this.f16125b.get(i10).f16131b = z10;
        w();
    }

    public void D(int i10, boolean z10) {
        this.f16125b.get(i10).f16130a = z10;
        w();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        Iterator<C0167a> it = this.f16125b.iterator();
        while (it.hasNext()) {
            if (it.next().f16131b) {
                return false;
            }
        }
        return true;
    }

    public void e(C0167a c0167a) {
        this.f16125b.add(c0167a);
        w();
        notifyDataSetChanged();
    }

    public abstract void f(View view, int i10, Cursor cursor);

    public abstract void g(View view, int i10, Cursor cursor, int i11);

    @Override // android.widget.Adapter
    public int getCount() {
        j();
        return this.f16126c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        j();
        Iterator<C0167a> it = this.f16125b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            C0167a next = it.next();
            int i12 = next.f16134e + i11;
            if (i10 >= i11 && i10 < i12) {
                int i13 = i10 - i11;
                if (next.f16131b) {
                    i13--;
                }
                if (i13 == -1) {
                    return null;
                }
                Cursor cursor = next.f16132c;
                cursor.moveToPosition(i13);
                return cursor;
            }
            i11 = i12;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        j();
        Iterator<C0167a> it = this.f16125b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            C0167a next = it.next();
            int i12 = next.f16134e + i11;
            if (i10 >= i11 && i10 < i12) {
                int i13 = i10 - i11;
                if (next.f16131b) {
                    i13--;
                }
                if (i13 == -1 || next.f16133d == -1 || (cursor = next.f16132c) == null || cursor.isClosed() || !cursor.moveToPosition(i13)) {
                    return 0L;
                }
                return cursor.getLong(next.f16133d);
            }
            i11 = i12;
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        j();
        int size = this.f16125b.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            int i13 = this.f16125b.get(i11).f16134e + i12;
            if (i10 >= i12 && i10 < i13) {
                int i14 = i10 - i12;
                if (this.f16125b.get(i11).f16131b) {
                    i14--;
                }
                if (i14 == -1) {
                    return -1;
                }
                return n(i11, i14);
            }
            i11++;
            i12 = i13;
        }
        throw new ArrayIndexOutOfBoundsException(i10);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View u10;
        j();
        int size = this.f16125b.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            int i13 = this.f16125b.get(i11).f16134e + i12;
            if (i10 >= i12 && i10 < i13) {
                int i14 = i10 - i12;
                if (this.f16125b.get(i11).f16131b) {
                    i14--;
                }
                if (i14 == -1) {
                    u10 = m(i11, this.f16125b.get(i11).f16132c, view, viewGroup);
                } else if (this.f16125b.get(i11).f16132c.moveToPosition(i14)) {
                    u10 = u(i11, this.f16125b.get(i11).f16132c, i14, view, viewGroup);
                } else {
                    throw new IllegalStateException("Couldn't move cursor to position " + i14);
                }
                if (u10 != null) {
                    return u10;
                }
                throw new NullPointerException("View should not be null, partition: " + i11 + " position: " + i14);
            }
            i11++;
            i12 = i13;
        }
        throw new ArrayIndexOutOfBoundsException(i10);
    }

    public void h(int i10, Cursor cursor) {
        Cursor cursor2 = this.f16125b.get(i10).f16132c;
        if (cursor2 != cursor) {
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
            this.f16125b.get(i10).f16132c = cursor;
            if (cursor != null) {
                this.f16125b.get(i10).f16133d = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            }
            w();
            notifyDataSetChanged();
        }
    }

    public void i() {
        Iterator<C0167a> it = this.f16125b.iterator();
        while (it.hasNext()) {
            it.next().f16132c = null;
        }
        w();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        j();
        int size = this.f16125b.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            int i13 = this.f16125b.get(i11).f16134e + i12;
            if (i10 >= i12 && i10 < i13) {
                int i14 = i10 - i12;
                if (this.f16125b.get(i11).f16131b && i14 == 0) {
                    return false;
                }
                return x(i11, i14);
            }
            i11++;
            i12 = i13;
        }
        return false;
    }

    public void j() {
        int i10;
        if (!this.f16127d) {
            this.f16126c = 0;
            Iterator<C0167a> it = this.f16125b.iterator();
            while (it.hasNext()) {
                C0167a next = it.next();
                Cursor cursor = next.f16132c;
                if (cursor != null) {
                    i10 = cursor.getCount();
                } else {
                    i10 = 0;
                }
                if (next.f16131b && (i10 != 0 || next.f16130a)) {
                    i10++;
                }
                next.f16134e = i10;
                this.f16126c += i10;
            }
            this.f16127d = true;
        }
    }

    public Context k() {
        return this.f16124a;
    }

    public Cursor l(int i10) {
        return this.f16125b.get(i10).f16132c;
    }

    public View m(int i10, Cursor cursor, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = z(this.f16124a, i10, cursor, viewGroup);
        }
        f(view, i10, cursor);
        return view;
    }

    public int n(int i10, int i11) {
        return 1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (this.f16128e) {
            this.f16129f = false;
            super.notifyDataSetChanged();
        } else {
            this.f16129f = true;
        }
    }

    public int o() {
        return 1;
    }

    public int p(int i10) {
        j();
        Iterator<C0167a> it = this.f16125b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            C0167a next = it.next();
            int i12 = next.f16134e + i11;
            if (i10 >= i11 && i10 < i12) {
                int i13 = i10 - i11;
                if (next.f16131b) {
                    return i13 - 1;
                }
                return i13;
            }
            i11 = i12;
        }
        return -1;
    }

    public C0167a q(int i10) {
        return this.f16125b.get(i10);
    }

    public int r() {
        return this.f16125b.size();
    }

    public int s(int i10) {
        j();
        int size = this.f16125b.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            int i13 = this.f16125b.get(i11).f16134e + i12;
            if (i10 >= i12 && i10 < i13) {
                return i11;
            }
            i11++;
            i12 = i13;
        }
        return -1;
    }

    public int t(int i10) {
        j();
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += this.f16125b.get(i12).f16134e;
        }
        return i11;
    }

    public View u(int i10, Cursor cursor, int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = A(this.f16124a, i10, cursor, i11, viewGroup);
        }
        g(view, i10, cursor, i11);
        return view;
    }

    public boolean v(int i10) {
        return this.f16125b.get(i10).f16131b;
    }

    public void w() {
        this.f16127d = false;
    }

    public boolean x(int i10, int i11) {
        return true;
    }

    public boolean y(int i10) {
        Cursor cursor = this.f16125b.get(i10).f16132c;
        if (cursor != null && cursor.getCount() != 0) {
            return false;
        }
        return true;
    }

    public abstract View z(Context context, int i10, Cursor cursor, ViewGroup viewGroup);

    public a(Context context, int i10) {
        this.f16126c = 0;
        this.f16127d = true;
        this.f16128e = true;
        this.f16124a = context;
        this.f16125b = new ArrayList<>();
    }
}
