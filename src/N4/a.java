package N4;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ClassPathResourceMetadataLoader.java */
/* loaded from: classes3.dex */
public final class a implements L4.b {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f2363a = Logger.getLogger(a.class.getName());

    @Override // L4.b
    public InputStream a(String str) {
        InputStream resourceAsStream = a.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            f2363a.log(Level.WARNING, String.format("File %s not found", str));
        }
        return resourceAsStream;
    }
}
