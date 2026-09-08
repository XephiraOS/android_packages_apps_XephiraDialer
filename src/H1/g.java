package H1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import kotlin.jvm.internal.i;

/* compiled from: ObservableProperty.kt */
/* loaded from: classes.dex */
public final class g<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f1269a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1270b;

    /* renamed from: c, reason: collision with root package name */
    public final PropertyChangeSupport f1271c;

    public g(T t10, String description) {
        i.f(description, "description");
        this.f1269a = t10;
        this.f1270b = description;
        this.f1271c = new PropertyChangeSupport(description);
    }

    public final void a(PropertyChangeListener listener) {
        i.f(listener, "listener");
        this.f1271c.addPropertyChangeListener(listener);
    }

    public final T b() {
        return this.f1269a;
    }

    public final void c(PropertyChangeListener listener) {
        i.f(listener, "listener");
        this.f1271c.removePropertyChangeListener(listener);
    }

    public final void d(T t10) {
        T t11 = this.f1269a;
        this.f1269a = t10;
        this.f1271c.firePropertyChange(this.f1270b, t11, t10);
    }
}
