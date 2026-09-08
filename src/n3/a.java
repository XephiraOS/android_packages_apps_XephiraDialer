package N3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.loader.app.a;
import com.android.contacts.group.l;
import java.lang.ref.WeakReference;

/* compiled from: GroupCursorLoader.java */
/* loaded from: classes3.dex */
public class a implements a.InterfaceC0129a<Cursor> {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f2296a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.loader.app.a f2297b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0047a f2298c;

    /* renamed from: d, reason: collision with root package name */
    public W.b f2299d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2300e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f2301f;

    /* compiled from: GroupCursorLoader.java */
    /* renamed from: N3.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0047a {
        void l(Cursor cursor);
    }

    public a(boolean z10) {
        this.f2300e = z10;
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    public W.c<Cursor> Z(int i10, Bundle bundle) {
        Context context = this.f2296a.get();
        if (this.f2300e && i10 == 1 && !l.g()) {
            this.f2301f = bundle;
            return new W.b(context, R0.d.f3226m, R0.b.a(), null, null, null);
        }
        W.b bVar = new W.b(context, (Uri) bundle.getParcelable("URI"), bundle.getStringArray("PROJECTION"), bundle.getString("SELECTION"), bundle.getStringArray("SELECTION_ARGS"), bundle.getString("ORDER"));
        this.f2299d = bVar;
        return bVar;
    }

    public W.b a() {
        return this.f2299d;
    }

    public void b(int i10, Bundle bundle) {
        this.f2297b.e(i10, bundle, this);
    }

    public final void c(Cursor cursor) {
        String[] strArr;
        int count = cursor.getCount();
        if (count > 0) {
            cursor.moveToPosition(-1);
            strArr = new String[count * 6];
            for (int i10 = 0; i10 < count && cursor.moveToNext(); i10++) {
                int i11 = i10 * 6;
                strArr[i11] = cursor.getString(0);
                strArr[i11 + 1] = cursor.getString(1);
                strArr[i11 + 2] = cursor.getString(2);
                strArr[i11 + 3] = cursor.getString(3);
                strArr[i11 + 4] = cursor.getString(4);
                strArr[i11 + 5] = cursor.getString(5);
            }
        } else {
            strArr = null;
        }
        this.f2301f.putStringArray("SELECTION_ARGS", strArr);
        this.f2297b.g(2, this.f2301f, this);
    }

    public void d(androidx.loader.app.a aVar, Context context, InterfaceC0047a interfaceC0047a) {
        this.f2296a = new WeakReference<>(context);
        this.f2297b = aVar;
        this.f2298c = interfaceC0047a;
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        if (this.f2300e && cVar.j() == 1 && !l.g()) {
            c(cursor);
        } else {
            this.f2298c.l(cursor);
        }
    }

    public void f(int i10, Bundle bundle) {
        this.f2297b.g(i10, bundle, this);
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    public void Q(W.c<Cursor> cVar) {
    }
}
