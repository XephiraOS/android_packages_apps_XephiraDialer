package W;

import F.d;
import W.c;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* compiled from: CursorLoader.java */
/* loaded from: classes.dex */
public class b extends a<Cursor> {

    /* renamed from: p, reason: collision with root package name */
    public final c<Cursor>.a f4105p;

    /* renamed from: q, reason: collision with root package name */
    public Uri f4106q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f4107r;

    /* renamed from: s, reason: collision with root package name */
    public String f4108s;

    /* renamed from: t, reason: collision with root package name */
    public String[] f4109t;

    /* renamed from: u, reason: collision with root package name */
    public String f4110u;

    /* renamed from: v, reason: collision with root package name */
    public Cursor f4111v;

    /* renamed from: w, reason: collision with root package name */
    public d f4112w;

    public b(Context context) {
        super(context);
        this.f4105p = new c.a();
    }

    @Override // W.a
    public void D() {
        super.D();
        synchronized (this) {
            try {
                d dVar = this.f4112w;
                if (dVar != null) {
                    dVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // W.c
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void f(Cursor cursor) {
        if (l()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f4111v;
        this.f4111v = cursor;
        if (m()) {
            super.f(cursor);
        }
        if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
            cursor2.close();
        }
    }

    public String[] M() {
        return this.f4107r;
    }

    @Override // W.a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public Cursor I() {
        synchronized (this) {
            if (!H()) {
                this.f4112w = new d();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            Cursor a10 = androidx.core.content.a.a(i().getContentResolver(), this.f4106q, this.f4107r, this.f4108s, this.f4109t, this.f4110u, this.f4112w);
            if (a10 != null) {
                try {
                    a10.getCount();
                    a10.registerContentObserver(this.f4105p);
                } catch (RuntimeException e10) {
                    a10.close();
                    throw e10;
                }
            }
            synchronized (this) {
                this.f4112w = null;
            }
            return a10;
        } catch (Throwable th) {
            synchronized (this) {
                this.f4112w = null;
                throw th;
            }
        }
    }

    @Override // W.a
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void J(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public void P(String[] strArr) {
        this.f4107r = strArr;
    }

    public void Q(String str) {
        this.f4108s = str;
    }

    public void R(String[] strArr) {
        this.f4109t = strArr;
    }

    public void S(String str) {
        this.f4110u = str;
    }

    public void T(Uri uri) {
        this.f4106q = uri;
    }

    @Override // W.a, W.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f4106q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f4107r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f4108s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f4109t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f4110u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f4111v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f4120h);
    }

    @Override // W.c
    public void r() {
        super.r();
        t();
        Cursor cursor = this.f4111v;
        if (cursor != null && !cursor.isClosed()) {
            this.f4111v.close();
        }
        this.f4111v = null;
    }

    @Override // W.c
    public void s() {
        Cursor cursor = this.f4111v;
        if (cursor != null) {
            f(cursor);
        }
        if (A() || this.f4111v == null) {
            h();
        }
    }

    @Override // W.c
    public void t() {
        b();
    }

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f4105p = new c.a();
        this.f4106q = uri;
        this.f4107r = strArr;
        this.f4108s = str;
        this.f4109t = strArr2;
        this.f4110u = str2;
    }
}
