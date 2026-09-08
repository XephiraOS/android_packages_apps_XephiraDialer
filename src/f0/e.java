package f0;

import android.database.sqlite.SQLiteStatement;
import e0.k;

/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
public class e extends d implements k {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f31674b;

    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f31674b = sQLiteStatement;
    }

    @Override // e0.k
    public long n0() {
        return this.f31674b.executeInsert();
    }

    @Override // e0.k
    public int p() {
        return this.f31674b.executeUpdateDelete();
    }
}
