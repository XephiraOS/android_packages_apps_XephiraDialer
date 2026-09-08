package e0;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface g extends Closeable {
    void D();

    void F();

    void P();

    Cursor b(String str);

    Cursor b0(j jVar, CancellationSignal cancellationSignal);

    String d();

    boolean e0();

    void h();

    List<Pair<String, String>> i();

    boolean isOpen();

    Cursor j(j jVar);

    boolean k0();

    void m(String str);

    k q(String str);
}
