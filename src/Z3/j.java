package Z3;

import com.coui.appcompat.poplist.COUIPopupListWindow;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ManagePopup.java */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<COUIPopupListWindow> f5933a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList<COUIPopupListWindow> f5934b = new ArrayList<>();

    public static void a(COUIPopupListWindow cOUIPopupListWindow) {
        ArrayList<COUIPopupListWindow> arrayList = f5934b;
        synchronized (arrayList) {
            c();
            arrayList.add(cOUIPopupListWindow);
        }
    }

    public static void b(COUIPopupListWindow cOUIPopupListWindow) {
        ArrayList<COUIPopupListWindow> arrayList = f5933a;
        synchronized (arrayList) {
            d();
            arrayList.add(cOUIPopupListWindow);
        }
    }

    public static boolean c() {
        ArrayList<COUIPopupListWindow> arrayList = f5934b;
        if (arrayList.size() > 0) {
            Iterator<COUIPopupListWindow> it = arrayList.iterator();
            while (it.hasNext()) {
                COUIPopupListWindow next = it.next();
                if (next != null && next.isShowing()) {
                    next.dismiss();
                }
            }
            f5934b.clear();
            return true;
        }
        return false;
    }

    public static boolean d() {
        ArrayList<COUIPopupListWindow> arrayList = f5933a;
        if (arrayList.size() > 0) {
            Iterator<COUIPopupListWindow> it = arrayList.iterator();
            while (it.hasNext()) {
                COUIPopupListWindow next = it.next();
                if (next != null && next.isShowing()) {
                    next.superDismiss();
                }
            }
            f5933a.clear();
            return true;
        }
        return false;
    }

    public static boolean e() {
        ArrayList<COUIPopupListWindow> arrayList = f5934b;
        synchronized (arrayList) {
            try {
                if (arrayList.size() > 0) {
                    Iterator<COUIPopupListWindow> it = arrayList.iterator();
                    while (it.hasNext()) {
                        COUIPopupListWindow next = it.next();
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

    public static boolean f() {
        ArrayList<COUIPopupListWindow> arrayList = f5933a;
        synchronized (arrayList) {
            try {
                if (arrayList.size() > 0) {
                    Iterator<COUIPopupListWindow> it = arrayList.iterator();
                    while (it.hasNext()) {
                        COUIPopupListWindow next = it.next();
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
