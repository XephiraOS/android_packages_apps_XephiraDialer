package d6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.oplus.anim.I;
import com.oplus.anim.M;
import java.io.IOException;
import java.util.Map;
import l6.e;
import l6.h;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f30062d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Context f30063a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30064b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, I> f30065c;

    public b(Drawable.Callback callback, String str, M m10, Map<String, I> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f30064b = str + '/';
        } else {
            this.f30064b = str;
        }
        this.f30065c = map;
        d(m10);
        if (!(callback instanceof View)) {
            e.c("EffectiveAnimationDrawable must be inside of a view for images to work.");
            this.f30063a = null;
        } else {
            this.f30063a = ((View) callback).getContext().getApplicationContext();
        }
    }

    public Bitmap a(String str) {
        I i10 = this.f30065c.get(str);
        if (i10 == null) {
            return null;
        }
        Bitmap a10 = i10.a();
        if (a10 != null) {
            return a10;
        }
        Context context = this.f30063a;
        if (context == null) {
            return null;
        }
        String b10 = i10.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b10.startsWith("data:") && b10.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b10.substring(b10.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e10) {
                e.d("data URL did not have correct base64 format.", e10);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f30064b)) {
                e.c("Set non folder.");
                return null;
            }
            e.c("bitmapForId filename = " + b10 + ";imagesFolder = " + this.f30064b);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f30064b + b10), null, options);
                if (decodeStream == null) {
                    e.c("Decoded image `" + str + "` is null.");
                    return null;
                }
                return c(str, h.l(decodeStream, i10.e(), i10.c()));
            } catch (IllegalArgumentException e11) {
                e.d("Unable to decode image `" + str + "`.", e11);
                return null;
            }
        } catch (IOException e12) {
            e.d("Unable to open asset.", e12);
            return null;
        }
    }

    public boolean b(Context context) {
        if ((context == null && this.f30063a == null) || this.f30063a.equals(context)) {
            return true;
        }
        return false;
    }

    public final Bitmap c(String str, Bitmap bitmap) {
        synchronized (f30062d) {
            e.c("putBitmap key = " + str);
            this.f30065c.get(str).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap e(String str, Bitmap bitmap) {
        if (bitmap == null) {
            I i10 = this.f30065c.get(str);
            Bitmap a10 = i10.a();
            i10.f(null);
            return a10;
        }
        Bitmap a11 = this.f30065c.get(str).a();
        c(str, bitmap);
        return a11;
    }

    public void d(M m10) {
    }
}
