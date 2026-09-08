package x7;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.B;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.oplus.foundation.util.io.CloseableUtils;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: CursorRecyclerAdapter.kt */
/* renamed from: x7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1684a<VH extends RecyclerView.B> extends RecyclerView.Adapter<VH> {

    /* renamed from: g, reason: collision with root package name */
    public static final b f38043g = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public boolean f38044a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f38045b;

    /* renamed from: c, reason: collision with root package name */
    public int f38046c;

    /* renamed from: d, reason: collision with root package name */
    public AbstractC1684a<VH>.C0381a f38047d;

    /* renamed from: e, reason: collision with root package name */
    public DataSetObserver f38048e;

    /* renamed from: f, reason: collision with root package name */
    public Cursor f38049f;

    /* compiled from: CursorRecyclerAdapter.kt */
    /* renamed from: x7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0381a extends ContentObserver {
        public C0381a() {
            super(new Handler(Looper.getMainLooper()));
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            AbstractC1684a.this.k();
        }
    }

    /* compiled from: CursorRecyclerAdapter.kt */
    /* renamed from: x7.a$b */
    /* loaded from: classes3.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CursorRecyclerAdapter.kt */
    /* renamed from: x7.a$c */
    /* loaded from: classes3.dex */
    public final class c extends DataSetObserver {
        public c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC1684a.this.f38044a = true;
            AbstractC1684a.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC1684a.this.f38044a = false;
            Log.w("CursorRecyclerAdapter", "onInvalidated, data valid");
            AbstractC1684a.this.notifyDataSetChanged();
        }
    }

    public AbstractC1684a(int i10) {
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f38045b = true;
        } else {
            this.f38045b = false;
        }
        if ((i10 & 2) == 2) {
            this.f38047d = new C0381a();
            this.f38048e = new c();
        } else {
            this.f38047d = null;
            this.f38048e = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Cursor cursor;
        if (!this.f38044a || (cursor = this.f38049f) == null) {
            return 0;
        }
        return com.oplus.foundation.util.io.b.a(cursor);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        if (!this.f38044a) {
            return 0L;
        }
        Cursor cursor = this.f38049f;
        if (cursor != null) {
            if (!cursor.isClosed()) {
                if (cursor.moveToPosition(i10)) {
                    return cursor.getLong(this.f38046c);
                }
                Log.w("CursorRecyclerAdapter", "getItemId: move to position fail:" + i10);
            } else {
                Log.w("CursorRecyclerAdapter", "getItemId: cursor is closed");
            }
        } else {
            Log.w("CursorRecyclerAdapter", "getItemId: cursor is null");
        }
        return 0L;
    }

    public void h(Cursor cursor) {
        CloseableUtils.b(l(cursor));
    }

    public abstract void i(VH vh, Cursor cursor, int i10);

    public abstract void j(VH vh, Cursor cursor, int i10, List<Object> list);

    public final void k() {
        if (this.f38045b) {
            Cursor cursor = this.f38049f;
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    this.f38044a = cursor.requery();
                    return;
                } else {
                    Log.w("CursorRecyclerAdapter", "onContentChanged: cursor is closed");
                    return;
                }
            }
            Log.w("CursorRecyclerAdapter", "onContentChanged: cursor is null");
        }
    }

    public final Cursor l(Cursor cursor) {
        Cursor cursor2 = this.f38049f;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            AbstractC1684a<VH>.C0381a c0381a = this.f38047d;
            if (c0381a != null) {
                cursor2.unregisterContentObserver(c0381a);
            }
            DataSetObserver dataSetObserver = this.f38048e;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f38049f = cursor;
        boolean z10 = false;
        if (cursor != null) {
            AbstractC1684a<VH>.C0381a c0381a2 = this.f38047d;
            if (c0381a2 != null) {
                cursor.registerContentObserver(c0381a2);
            }
            DataSetObserver dataSetObserver2 = this.f38048e;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            this.f38046c = columnIndex;
            if (columnIndex != -1) {
                z10 = true;
            }
            this.f38044a = z10;
            notifyDataSetChanged();
        } else {
            this.f38046c = -1;
            this.f38044a = false;
            Log.w("CursorRecyclerAdapter", "swapCursor, data valid");
            notifyDataSetChanged();
        }
        return cursor2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH holder, int i10) {
        i.f(holder, "holder");
        if (this.f38044a) {
            Cursor cursor = this.f38049f;
            if (cursor != null && !cursor.isClosed()) {
                if (cursor.moveToPosition(i10)) {
                    Cursor cursor2 = this.f38049f;
                    if (cursor2 != null) {
                        if (!cursor2.isClosed()) {
                            i(holder, cursor2, i10);
                            return;
                        } else {
                            Log.w("CursorRecyclerAdapter", "onBindViewHolder: cursor is closed");
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalStateException(("couldn't move cursor to position " + i10).toString());
            }
            throw new IllegalStateException("the cursor is invalid state:" + (cursor != null ? Boolean.valueOf(cursor.isClosed()) : null));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid".toString());
    }

    public /* synthetic */ AbstractC1684a(int i10, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH holder, int i10, List<Object> payloads) {
        i.f(holder, "holder");
        i.f(payloads, "payloads");
        if (this.f38044a) {
            Cursor cursor = this.f38049f;
            if (cursor != null && !cursor.isClosed()) {
                if (cursor.moveToPosition(i10)) {
                    Cursor cursor2 = this.f38049f;
                    if (cursor2 != null) {
                        if (!cursor2.isClosed()) {
                            j(holder, cursor2, i10, payloads);
                            return;
                        } else {
                            Log.w("CursorRecyclerAdapter", "onBindViewHolder: cursor is closed");
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalStateException(("couldn't move cursor to position " + i10).toString());
            }
            throw new IllegalStateException("the cursor is invalid state:" + (cursor != null ? Boolean.valueOf(cursor.isClosed()) : null));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid".toString());
    }
}
