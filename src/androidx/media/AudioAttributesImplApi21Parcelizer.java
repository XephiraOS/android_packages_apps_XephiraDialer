package androidx.media;

import android.media.AudioAttributes;
import k0.AbstractC1206a;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC1206a abstractC1206a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f10430a = (AudioAttributes) abstractC1206a.r(audioAttributesImplApi21.f10430a, 1);
        audioAttributesImplApi21.f10431b = abstractC1206a.p(audioAttributesImplApi21.f10431b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC1206a abstractC1206a) {
        abstractC1206a.x(false, false);
        abstractC1206a.H(audioAttributesImplApi21.f10430a, 1);
        abstractC1206a.F(audioAttributesImplApi21.f10431b, 2);
    }
}
