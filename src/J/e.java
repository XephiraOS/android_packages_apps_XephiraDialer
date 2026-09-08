package J;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1419a;

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final e f1420a;

        public a(e eVar) {
            this.f1420a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            d b10 = this.f1420a.b(i10);
            if (b10 == null) {
                return null;
            }
            return b10.N0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<d> c10 = this.f1420a.c(str, i10);
            if (c10 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c10.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(c10.get(i11).N0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            d d10 = this.f1420a.d(i10);
            if (d10 == null) {
                return null;
            }
            return d10.N0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f1420a.f(i10, i11, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    public static class b extends a {
        public b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f1420a.a(i10, d.O0(accessibilityNodeInfo), str, bundle);
        }
    }

    public e() {
        this.f1419a = new b(this);
    }

    public d b(int i10) {
        return null;
    }

    public List<d> c(String str, int i10) {
        return null;
    }

    public d d(int i10) {
        return null;
    }

    public Object e() {
        return this.f1419a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public e(Object obj) {
        this.f1419a = obj;
    }

    public void a(int i10, d dVar, String str, Bundle bundle) {
    }
}
