package t;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Key.java */
/* renamed from: t.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1575c {

    /* renamed from: f, reason: collision with root package name */
    public static int f36905f = -1;

    /* renamed from: a, reason: collision with root package name */
    public int f36906a;

    /* renamed from: b, reason: collision with root package name */
    public int f36907b;

    /* renamed from: c, reason: collision with root package name */
    public String f36908c;

    /* renamed from: d, reason: collision with root package name */
    public int f36909d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f36910e;

    public AbstractC1575c() {
        int i10 = f36905f;
        this.f36906a = i10;
        this.f36907b = i10;
        this.f36908c = null;
    }

    public abstract void a(HashMap<String, q> hashMap);

    public abstract void b(HashSet<String> hashSet);

    public abstract void c(Context context, AttributeSet attributeSet);

    public boolean d(String str) {
        String str2 = this.f36908c;
        if (str2 != null && str != null) {
            return str.matches(str2);
        }
        return false;
    }

    public void e(HashMap<String, Integer> hashMap) {
    }
}
