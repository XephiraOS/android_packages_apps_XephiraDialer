package com.android.contacts.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.customize.contacts.util.HandlerC0795f;
import java.lang.ref.WeakReference;

/* compiled from: NotifyingAsyncQueryHandler.java */
/* loaded from: classes.dex */
public class r extends HandlerC0795f {

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<a> f17595f;

    /* compiled from: NotifyingAsyncQueryHandler.java */
    /* loaded from: classes.dex */
    public interface a {
        void j(int i10, Object obj, Cursor cursor);
    }

    /* compiled from: NotifyingAsyncQueryHandler.java */
    /* loaded from: classes.dex */
    public class b extends HandlerC0795f.b {
        public b(Looper looper) {
            super(looper);
        }

        @Override // com.customize.contacts.util.HandlerC0795f.b, android.os.Handler
        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
            } catch (SQLiteDatabaseCorruptException e10) {
                H7.b.i("NotifyingAsyncQueryHandler", "Exception on background worker thread" + e10);
            } catch (SQLiteDiskIOException e11) {
                H7.b.i("NotifyingAsyncQueryHandler", "Exception on background worker thread" + e11);
            } catch (SQLiteFullException e12) {
                H7.b.i("NotifyingAsyncQueryHandler", "Exception on background worker thread" + e12);
            } catch (RuntimeException e13) {
                H7.b.i("NotifyingAsyncQueryHandler", "Exception:" + e13);
            } catch (Exception e14) {
                H7.b.i("NotifyingAsyncQueryHandler", "Exception:" + e14);
            }
        }
    }

    public r(Context context, a aVar) {
        super(context.getContentResolver());
        k(aVar);
    }

    @Override // com.customize.contacts.util.HandlerC0795f
    public Handler d(Looper looper) {
        return new b(looper);
    }

    @Override // com.customize.contacts.util.HandlerC0795f
    public void e(int i10, Object obj, Cursor cursor) {
        a aVar = this.f17595f.get();
        if (aVar != null) {
            aVar.j(i10, obj, cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public void k(a aVar) {
        this.f17595f = new WeakReference<>(aVar);
    }
}
