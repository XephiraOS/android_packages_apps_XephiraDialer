package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f9412k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f9414b;

    /* renamed from: j, reason: collision with root package name */
    public String f9422j;

    /* renamed from: a, reason: collision with root package name */
    public int f9413a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f9415c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f9416d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f9417e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f9418f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f9419g = null;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f9420h = f9412k;

    /* renamed from: i, reason: collision with root package name */
    public String f9421i = null;

    /* loaded from: classes.dex */
    public static class a {
        public static int a(Object obj) {
            return b.a(obj);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }
    }

    public static String d(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int a() {
        int i10 = this.f9413a;
        if (i10 == -1) {
            return a.a(this.f9414b);
        }
        if (i10 == 2) {
            return this.f9417e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public void b() {
        this.f9420h = PorterDuff.Mode.valueOf(this.f9421i);
        switch (this.f9413a) {
            case -1:
                Parcelable parcelable = this.f9416d;
                if (parcelable != null) {
                    this.f9414b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f9416d;
                if (parcelable2 != null) {
                    this.f9414b = parcelable2;
                    return;
                }
                byte[] bArr = this.f9415c;
                this.f9414b = bArr;
                this.f9413a = 3;
                this.f9417e = 0;
                this.f9418f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f9415c, Charset.forName("UTF-16"));
                this.f9414b = str;
                if (this.f9413a == 2 && this.f9422j == null) {
                    this.f9422j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f9414b = this.f9415c;
                return;
        }
    }

    public void c(boolean z10) {
        this.f9421i = this.f9420h.name();
        switch (this.f9413a) {
            case -1:
                if (!z10) {
                    this.f9416d = (Parcelable) this.f9414b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z10) {
                    Bitmap bitmap = (Bitmap) this.f9414b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f9415c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f9416d = (Parcelable) this.f9414b;
                return;
            case 2:
                this.f9415c = ((String) this.f9414b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f9415c = (byte[]) this.f9414b;
                return;
            case 4:
            case 6:
                this.f9415c = this.f9414b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public String toString() {
        if (this.f9413a == -1) {
            return String.valueOf(this.f9414b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(d(this.f9413a));
        switch (this.f9413a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f9414b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f9414b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f9422j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f9417e);
                if (this.f9418f != 0) {
                    sb.append(" off=");
                    sb.append(this.f9418f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f9414b);
                break;
        }
        if (this.f9419g != null) {
            sb.append(" tint=");
            sb.append(this.f9419g);
        }
        if (this.f9420h != f9412k) {
            sb.append(" mode=");
            sb.append(this.f9420h);
        }
        sb.append(")");
        return sb.toString();
    }
}
