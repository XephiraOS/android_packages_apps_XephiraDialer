package b6;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final List<u> f12204a = new ArrayList();

    public void a(u uVar) {
        this.f12204a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f12204a.size() - 1; size >= 0; size--) {
            l6.h.b(path, this.f12204a.get(size));
        }
    }
}
