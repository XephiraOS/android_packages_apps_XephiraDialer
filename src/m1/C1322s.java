package m1;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;
import com.oplus.foundation.util.io.CloseableUtils;

/* compiled from: CustomizeCursor.java */
/* renamed from: m1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1322s extends CursorWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final int f35023a;

    /* renamed from: b, reason: collision with root package name */
    public a f35024b;

    /* compiled from: CustomizeCursor.java */
    /* renamed from: m1.s$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(Throwable th, int i10);
    }

    public C1322s(Cursor cursor) {
        super(cursor);
        this.f35024b = null;
        this.f35023a = 0;
    }

    public final void a(Throwable th) {
        a aVar = this.f35024b;
        if (aVar != null) {
            aVar.a(th, this.f35023a);
        }
    }

    public void c(a aVar) {
        this.f35024b = aVar;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            CloseableUtils.b(getWrappedCursor());
        } catch (Throwable th) {
            H7.b.c("CustomizeCursor", "close" + th);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
        try {
            super.copyStringToBuffer(i10, charArrayBuffer);
        } catch (Throwable th) {
            a(th);
            H7.b.c("CustomizeCursor", "copyStringToBuffer error" + th);
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public byte[] getBlob(int i10) {
        try {
            return super.getBlob(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getBlob error" + th);
            return new byte[0];
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndex(String str) {
        try {
            return super.getColumnIndex(str);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getColumnIndex error" + th);
            return -1;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getCount() {
        try {
            return super.getCount();
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getCount error" + th);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public double getDouble(int i10) {
        try {
            return super.getDouble(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getDouble error" + th);
            return 0.0d;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public float getFloat(int i10) {
        try {
            return super.getFloat(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getFloat error" + th);
            return 0.0f;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getInt(int i10) {
        try {
            return super.getInt(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getInt error" + th);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public long getLong(int i10) {
        try {
            return super.getLong(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getLong error" + th);
            return 0L;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public short getShort(int i10) {
        try {
            return super.getShort(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getShort error" + th);
            return (short) 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getString(int i10) {
        try {
            return super.getString(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getString error" + th);
            return "";
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getType(int i10) {
        try {
            return super.getType(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "getType error" + th);
            return 0;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isClosed() {
        try {
            if (getWrappedCursor() == null) {
                return true;
            }
            return super.isClosed();
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "isClosed error" + th);
            return true;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isNull(int i10) {
        try {
            return super.isNull(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "isNull error" + th);
            return true;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToNext() {
        try {
            return super.moveToNext();
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "moveToNext error" + th);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToPosition(int i10) {
        try {
            return super.moveToPosition(i10);
        } catch (Throwable th) {
            this.a(th);
            H7.b.c("CustomizeCursor", "moveToPosition error" + th);
            return false;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean requery() {
        if (this.f35024b != null) {
            H7.b.e("CustomizeCursor", "requery trace = " + Log.getStackTraceString(new Throwable()));
        }
        return super.requery();
    }

    public C1322s(Cursor cursor, int i10) {
        super(cursor);
        this.f35024b = null;
        this.f35023a = i10;
    }
}
