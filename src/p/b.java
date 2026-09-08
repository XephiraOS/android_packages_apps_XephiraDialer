package P;

import android.text.Editable;
import androidx.emoji2.text.n;

/* compiled from: EmojiEditableFactory.java */
/* loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2788a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f2789b;

    /* renamed from: c, reason: collision with root package name */
    public static Class<?> f2790c;

    public b() {
        try {
            f2790c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f2789b == null) {
            synchronized (f2788a) {
                try {
                    if (f2789b == null) {
                        f2789b = new b();
                    }
                } finally {
                }
            }
        }
        return f2789b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f2790c;
        if (cls != null) {
            return n.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
