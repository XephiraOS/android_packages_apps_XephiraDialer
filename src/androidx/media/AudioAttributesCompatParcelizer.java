package androidx.media;

import k0.AbstractC1206a;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC1206a abstractC1206a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f10429a = (AudioAttributesImpl) abstractC1206a.v(audioAttributesCompat.f10429a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC1206a abstractC1206a) {
        abstractC1206a.x(false, false);
        abstractC1206a.M(audioAttributesCompat.f10429a, 1);
    }
}
