package U0;

import java.util.ArrayList;
import java.util.Iterator;
import m9.q;

/* compiled from: ManageAutoConfigAlertDialogBuilder.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f3821a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList<b> f3822b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList<b> f3823c = new ArrayList<>();

    public static final void a(b bVar) {
        ArrayList<b> arrayList = f3822b;
        synchronized (arrayList) {
            try {
                c();
                if (bVar != null) {
                    arrayList.add(bVar);
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final void b(b bVar) {
        ArrayList<b> arrayList = f3823c;
        synchronized (arrayList) {
            try {
                c();
                if (bVar != null) {
                    arrayList.add(bVar);
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final boolean c() {
        ArrayList<b> arrayList = f3822b;
        if (arrayList.size() > 0) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                androidx.appcompat.app.b j10 = it.next().j();
                if (j10 != null && j10.isShowing()) {
                    j10.dismiss();
                }
            }
            f3822b.clear();
            return true;
        }
        return false;
    }

    public static final boolean d() {
        ArrayList<b> arrayList = f3823c;
        if (arrayList.size() > 0) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                androidx.appcompat.app.b j10 = it.next().j();
                if (j10 != null && j10.isShowing()) {
                    j10.dismiss();
                }
            }
            f3823c.clear();
            return true;
        }
        return false;
    }
}
