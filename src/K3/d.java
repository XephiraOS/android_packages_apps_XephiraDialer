package k3;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.IOException;
import s3.C1530a;

/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class d implements X2.f<c> {
    @Override // X2.f
    public EncodeStrategy a(X2.d dVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // X2.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(Z2.j<c> jVar, File file, X2.d dVar) {
        try {
            C1530a.f(jVar.get().c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            }
            return false;
        }
    }
}
