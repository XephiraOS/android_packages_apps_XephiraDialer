package q6;

import android.content.Context;
import android.database.Cursor;
import android.widget.ResourceCursorAdapter;
import com.oplus.utils.C0845f;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BaseBlackAndWhiteListAdapter.java */
/* renamed from: q6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractRunnableC1488a extends ResourceCursorAdapter implements Runnable, com.oplus.blacklistapp.f {
    public AbstractRunnableC1488a(Context context, int i10, Cursor cursor) {
        super(context, i10, cursor);
    }

    public abstract C0845f b(Cursor cursor);

    public abstract void c();

    public abstract void d();

    public abstract HashMap<C0845f, Boolean> e();

    public abstract boolean f();

    public abstract void g();

    public abstract void h(boolean z10);

    public abstract void i(boolean z10);

    public abstract void j(boolean z10);

    public abstract void k(ConcurrentHashMap<Long, C0845f> concurrentHashMap);

    public abstract void l(boolean z10);

    public abstract void m();

    public AbstractRunnableC1488a(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, i10, cursor, z10);
    }
}
