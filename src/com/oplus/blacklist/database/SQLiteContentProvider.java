package com.oplus.blacklist.database;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class SQLiteContentProvider extends ContentProvider implements SQLiteTransactionListener {

    /* renamed from: a, reason: collision with root package name */
    public b f26228a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f26229b;

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f26230c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Boolean> f26231d = new ThreadLocal<>();

    public final boolean a() {
        if (this.f26231d.get() != null && this.f26231d.get().booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        SQLiteDatabase writableDatabase = this.f26228a.getWritableDatabase();
        this.f26230c = writableDatabase;
        writableDatabase.beginTransactionWithListener(this);
        try {
            this.f26231d.set(Boolean.TRUE);
            int size = arrayList.size();
            ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                i10++;
                if (i10 <= e()) {
                    ContentProviderOperation contentProviderOperation = arrayList.get(i12);
                    if (i12 > 0 && contentProviderOperation.isYieldAllowed()) {
                        boolean z10 = this.f26229b;
                        if (this.f26230c.yieldIfContendedSafely(4000L)) {
                            this.f26230c = this.f26228a.getWritableDatabase();
                            this.f26229b = z10;
                            i11++;
                        }
                        i10 = 0;
                    }
                    contentProviderResultArr[i12] = contentProviderOperation.apply(this, contentProviderResultArr, i12);
                } else {
                    throw new OperationApplicationException("Too many content provider operations between yield points. The maximum number of operations per yield point is 500", i11);
                }
            }
            this.f26230c.setTransactionSuccessful();
            this.f26231d.set(Boolean.FALSE);
            this.f26230c.endTransaction();
            i();
            return contentProviderResultArr;
        } catch (Throwable th) {
            this.f26231d.set(Boolean.FALSE);
            this.f26230c.endTransaction();
            i();
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int length = contentValuesArr.length;
        SQLiteDatabase writableDatabase = this.f26228a.getWritableDatabase();
        this.f26230c = writableDatabase;
        writableDatabase.beginTransactionWithListener(this);
        for (ContentValues contentValues : contentValuesArr) {
            try {
                if (f(uri, contentValues) != null) {
                    this.f26229b = true;
                }
                boolean z10 = this.f26229b;
                SQLiteDatabase sQLiteDatabase = this.f26230c;
                sQLiteDatabase.yieldIfContendedSafely();
                this.f26230c = sQLiteDatabase;
                this.f26229b = z10;
            } catch (Throwable th) {
                this.f26230c.endTransaction();
                throw th;
            }
        }
        this.f26230c.setTransactionSuccessful();
        this.f26230c.endTransaction();
        i();
        return length;
    }

    public abstract int c(Uri uri, String str, String[] strArr);

    public abstract b d(Context context);

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        int c10;
        if (!a()) {
            SQLiteDatabase writableDatabase = this.f26228a.getWritableDatabase();
            this.f26230c = writableDatabase;
            writableDatabase.beginTransactionWithListener(this);
            try {
                c10 = c(uri, str, strArr);
                if (c10 > 0) {
                    this.f26229b = true;
                }
                this.f26230c.setTransactionSuccessful();
                this.f26230c.endTransaction();
                i();
            } catch (Throwable th) {
                this.f26230c.endTransaction();
                throw th;
            }
        } else {
            c10 = c(uri, str, strArr);
            if (c10 > 0) {
                this.f26229b = true;
            }
        }
        return c10;
    }

    public int e() {
        return 500;
    }

    public abstract Uri f(Uri uri, ContentValues contentValues);

    public abstract void g();

    public void i() {
        if (this.f26229b) {
            this.f26229b = false;
            g();
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri f10;
        if (!a()) {
            SQLiteDatabase writableDatabase = this.f26228a.getWritableDatabase();
            this.f26230c = writableDatabase;
            writableDatabase.beginTransactionWithListener(this);
            try {
                f10 = f(uri, contentValues);
                if (f10 != null) {
                    this.f26229b = true;
                }
                this.f26230c.setTransactionSuccessful();
                this.f26230c.endTransaction();
                i();
            } catch (Throwable th) {
                this.f26230c.endTransaction();
                throw th;
            }
        } else {
            f10 = f(uri, contentValues);
            if (f10 != null) {
                this.f26229b = true;
            }
        }
        return f10;
    }

    public abstract int j(Uri uri, ContentValues contentValues, String str, String[] strArr);

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onBegin() {
        h();
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onCommit() {
        b();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f26228a = d(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int j10;
        if (!a()) {
            SQLiteDatabase writableDatabase = this.f26228a.getWritableDatabase();
            this.f26230c = writableDatabase;
            writableDatabase.beginTransactionWithListener(this);
            try {
                j10 = j(uri, contentValues, str, strArr);
                if (j10 > 0) {
                    this.f26229b = true;
                }
                this.f26230c.setTransactionSuccessful();
                this.f26230c.endTransaction();
                i();
            } catch (Throwable th) {
                this.f26230c.endTransaction();
                throw th;
            }
        } else {
            j10 = j(uri, contentValues, str, strArr);
            if (j10 > 0) {
                this.f26229b = true;
            }
        }
        return j10;
    }

    public void b() {
    }

    public void h() {
    }

    @Override // android.database.sqlite.SQLiteTransactionListener
    public void onRollback() {
    }
}
