package D5;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;

/* compiled from: ProviderCursor.java */
/* loaded from: classes3.dex */
public class a extends MatrixCursor {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f460b = {"col"};

    /* renamed from: a, reason: collision with root package name */
    public Bundle f461a;

    public a(String[] strArr, Bundle bundle) {
        super(strArr);
        this.f461a = new Bundle(bundle);
    }

    public static a a(Bundle bundle) {
        return new a(f460b, bundle);
    }

    public static Bundle c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return cursor.getExtras();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.f461a;
    }
}
