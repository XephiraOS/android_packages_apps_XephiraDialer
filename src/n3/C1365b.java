package n3;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* renamed from: n3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1365b {

    /* renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f35610a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f35610a.add(imageHeaderParser);
    }

    public synchronized List<ImageHeaderParser> b() {
        return this.f35610a;
    }
}
