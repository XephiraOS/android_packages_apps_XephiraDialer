package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class C {

    /* renamed from: b, reason: collision with root package name */
    public View f11528b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f11527a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Transition> f11529c = new ArrayList<>();

    @Deprecated
    public C() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof C) {
            C c10 = (C) obj;
            if (this.f11528b == c10.f11528b && this.f11527a.equals(c10.f11527a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f11528b.hashCode() * 31) + this.f11527a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f11528b + "\n") + "    values:";
        for (String str2 : this.f11527a.keySet()) {
            str = str + "    " + str2 + ": " + this.f11527a.get(str2) + "\n";
        }
        return str;
    }

    public C(View view) {
        this.f11528b = view;
    }
}
