package E8;

import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;

/* compiled from: ProviderCursor.java */
/* loaded from: classes3.dex */
public class a extends MatrixCursor {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f740b = {"col"};

    /* renamed from: c, reason: collision with root package name */
    public static volatile a f741c = null;

    /* renamed from: a, reason: collision with root package name */
    public Bundle f742a;

    public a(String[] strArr, IBinder iBinder) {
        super(strArr);
        Bundle bundle = new Bundle();
        this.f742a = bundle;
        bundle.putBinder("IBinder", iBinder);
    }

    public static a a(IBinder iBinder) {
        if (f741c == null) {
            synchronized (a.class) {
                try {
                    if (f741c == null) {
                        f741c = new a(f740b, iBinder);
                    }
                } finally {
                }
            }
        }
        return f741c;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.f742a;
    }
}
