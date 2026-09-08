package c6;

import android.graphics.Path;
import com.oplus.anim.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final List<AbstractC0558a<g6.i, Path>> f12821a;

    /* renamed from: b, reason: collision with root package name */
    public final List<AbstractC0558a<Integer, Integer>> f12822b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Mask> f12823c;

    public h(List<Mask> list) {
        this.f12823c = list;
        this.f12821a = new ArrayList(list.size());
        this.f12822b = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f12821a.add(list.get(i10).b().a());
            this.f12822b.add(list.get(i10).c().a());
        }
    }

    public List<AbstractC0558a<g6.i, Path>> a() {
        return this.f12821a;
    }

    public List<Mask> b() {
        return this.f12823c;
    }

    public List<AbstractC0558a<Integer, Integer>> c() {
        return this.f12822b;
    }
}
