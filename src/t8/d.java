package t8;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import y8.C1712d;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: AtomAgent.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f37283a = Uri.parse("content://com.oplus.atom.db_sys/atom_delegate");

    public static void b(final Context context, final u8.f fVar) {
        if (fVar != null && context != null) {
            u8.b bVar = (u8.b) fVar;
            ContentValues contentValues = new ContentValues();
            contentValues.put("appId", Integer.valueOf(bVar.l()));
            contentValues.put("appPackage", C1712d.e(context));
            contentValues.put("logTag", bVar.o());
            contentValues.put("eventID", bVar.m());
            contentValues.put("logMap", bVar.n());
            try {
                context.getContentResolver().insert(f37283a, contentValues);
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        C1714f.a("AtomAgent", new InterfaceC1715g() { // from class: t8.c
            @Override // y8.InterfaceC1715g
            public final Object get() {
                String c10;
                c10 = d.c(u8.f.this, context);
                return c10;
            }
        });
    }

    public static /* synthetic */ String c(u8.f fVar, Context context) {
        return "AtomAgent add Task error -- bean or context is null--" + fVar + "," + context;
    }

    public static void d(Context context, u8.b bVar) {
        b(context, bVar);
    }
}
