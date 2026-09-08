package U0;

import android.app.Dialog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ManageDialog.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<Dialog> f3824a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList<Dialog> f3825b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList<Dialog> f3826c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList<Dialog> f3827d = new ArrayList<>();

    public static void a(Dialog dialog) {
        ArrayList<Dialog> arrayList = f3825b;
        synchronized (arrayList) {
            e();
            arrayList.add(dialog);
        }
    }

    public static void b(Dialog dialog) {
        ArrayList<Dialog> arrayList = f3824a;
        synchronized (arrayList) {
            f();
            arrayList.add(dialog);
        }
    }

    public static void c(Dialog dialog) {
        ArrayList<Dialog> arrayList = f3826c;
        synchronized (arrayList) {
            g();
            arrayList.add(dialog);
        }
    }

    public static void d(Dialog dialog) {
        ArrayList<Dialog> arrayList = f3827d;
        synchronized (arrayList) {
            h();
            arrayList.add(dialog);
        }
    }

    public static boolean e() {
        ArrayList<Dialog> arrayList = f3825b;
        if (arrayList.size() > 0) {
            Iterator<Dialog> it = arrayList.iterator();
            while (it.hasNext()) {
                Dialog next = it.next();
                if (next != null && next.isShowing()) {
                    next.dismiss();
                }
            }
            f3825b.clear();
            return true;
        }
        return false;
    }

    public static boolean f() {
        ArrayList<Dialog> arrayList = f3824a;
        if (arrayList.size() > 0) {
            Iterator<Dialog> it = arrayList.iterator();
            while (it.hasNext()) {
                Dialog next = it.next();
                if (next != null && next.isShowing()) {
                    next.dismiss();
                }
            }
            f3824a.clear();
            return true;
        }
        return false;
    }

    public static boolean g() {
        ArrayList<Dialog> arrayList = f3826c;
        if (arrayList.size() > 0) {
            Iterator<Dialog> it = arrayList.iterator();
            while (it.hasNext()) {
                Dialog next = it.next();
                if (next != null && next.isShowing()) {
                    next.dismiss();
                }
            }
            f3826c.clear();
            return true;
        }
        return false;
    }

    public static boolean h() {
        ArrayList<Dialog> arrayList = f3827d;
        if (arrayList.size() > 0) {
            Iterator<Dialog> it = arrayList.iterator();
            while (it.hasNext()) {
                Dialog next = it.next();
                if (next != null && next.isShowing()) {
                    next.dismiss();
                }
            }
            f3827d.clear();
            return true;
        }
        return false;
    }

    public static boolean i() {
        ArrayList<Dialog> arrayList = f3825b;
        synchronized (arrayList) {
            try {
                if (arrayList.size() > 0) {
                    Iterator<Dialog> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Dialog next = it.next();
                        if (next != null && next.isShowing()) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean j() {
        ArrayList<Dialog> arrayList = f3824a;
        synchronized (arrayList) {
            try {
                if (arrayList.size() > 0) {
                    Iterator<Dialog> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Dialog next = it.next();
                        if (next != null && next.isShowing()) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
