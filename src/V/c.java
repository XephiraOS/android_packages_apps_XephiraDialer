package V;

import androidx.lifecycle.I;
import androidx.lifecycle.K;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.i;
import u9.C1614a;
import v9.l;

/* compiled from: InitializerViewModelFactory.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List<f<?>> f3959a = new ArrayList();

    public final <T extends I> void a(C9.c<T> clazz, l<? super a, ? extends T> initializer) {
        i.f(clazz, "clazz");
        i.f(initializer, "initializer");
        this.f3959a.add(new f<>(C1614a.a(clazz), initializer));
    }

    public final K.b b() {
        f[] fVarArr = (f[]) this.f3959a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
