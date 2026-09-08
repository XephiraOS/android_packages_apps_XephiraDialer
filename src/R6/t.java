package r6;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0847h;
import com.oplus.utils.C0848i;
import java.lang.ref.WeakReference;

/* compiled from: CallLogQueryHandler.java */
/* loaded from: classes3.dex */
public class t extends AsyncQueryHandler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f36492a;

    /* compiled from: CallLogQueryHandler.java */
    /* loaded from: classes3.dex */
    public class a extends AsyncQueryHandler.WorkerHandler {
        public a(Looper looper) {
            super(t.this, looper);
        }

        @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
            } catch (SQLiteDatabaseCorruptException | SQLiteDiskIOException | SQLiteFullException e10) {
                Log.w("CallLogQueryHandler", "Exception on background worker thread" + e10);
            } catch (Exception e11) {
                Log.w("CallLogQueryHandler", "Exception:" + e11);
            }
        }
    }

    /* compiled from: CallLogQueryHandler.java */
    /* loaded from: classes3.dex */
    public interface b {
        void d(Cursor cursor);
    }

    public t(ContentResolver contentResolver, b bVar) {
        super(contentResolver);
        this.f36492a = new WeakReference<>(bVar);
    }

    public void a(Context context, int i10, int i11, int i12) {
        cancelOperation(52);
        String a10 = C0847h.a.a(i10, i11);
        if (C0846g.c()) {
            Log.d("CallLogQueryHandler", "startQuery,where==" + a10 + " ,simID=" + i11);
        }
        startQuery(52, null, C0848i.b(context, i12), C0847h.a.f29143a, a10, null, "MAX(date) DESC");
    }

    public final void b(Cursor cursor) {
        if (C0846g.c()) {
            Log.d("CallLogQueryHandler", "updateAdapterData");
        }
        b bVar = this.f36492a.get();
        if (bVar != null) {
            bVar.d(cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.content.AsyncQueryHandler
    public Handler createHandler(Looper looper) {
        return new a(looper);
    }

    @Override // android.content.AsyncQueryHandler
    public synchronized void onQueryComplete(int i10, Object obj, Cursor cursor) {
        try {
            if (C0846g.c()) {
                Log.d("CallLogQueryHandler", "onQueryComplete->token=" + i10);
            }
            if (i10 == 52) {
                b(cursor);
            } else {
                Log.w("CallLogQueryHandler", "Unknown query completed: ignoring: " + i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
