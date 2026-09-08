package g7;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;

/* compiled from: ProviderCursor.java */
/* renamed from: g7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1050a extends MatrixCursor {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f31932b = {"col"};

    /* renamed from: a, reason: collision with root package name */
    public Bundle f31933a;

    public C1050a(String[] strArr, Bundle bundle) {
        super(strArr);
        this.f31933a = new Bundle(bundle);
    }

    public static C1050a a(Bundle bundle) {
        return new C1050a(f31932b, bundle);
    }

    public static Bundle c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return cursor.getExtras();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.f31933a;
    }
}
