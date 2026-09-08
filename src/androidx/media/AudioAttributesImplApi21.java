package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f10430a;

    /* renamed from: b, reason: collision with root package name */
    public int f10431b = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f10430a.equals(((AudioAttributesImplApi21) obj).f10430a);
    }

    public int hashCode() {
        return this.f10430a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f10430a;
    }
}
