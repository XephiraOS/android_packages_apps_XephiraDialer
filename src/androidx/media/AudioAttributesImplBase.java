package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f10432a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f10433b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f10434c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f10435d = -1;

    public int a() {
        return this.f10433b;
    }

    public int b() {
        int i10 = this.f10434c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f10435d;
        if (i10 != -1) {
            return i10;
        }
        return AudioAttributesCompat.a(false, this.f10434c, this.f10432a);
    }

    public int d() {
        return this.f10432a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f10433b != audioAttributesImplBase.a() || this.f10434c != audioAttributesImplBase.b() || this.f10432a != audioAttributesImplBase.d() || this.f10435d != audioAttributesImplBase.f10435d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10433b), Integer.valueOf(this.f10434c), Integer.valueOf(this.f10432a), Integer.valueOf(this.f10435d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f10435d != -1) {
            sb.append(" stream=");
            sb.append(this.f10435d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f10432a));
        sb.append(" content=");
        sb.append(this.f10433b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f10434c).toUpperCase());
        return sb.toString();
    }
}
