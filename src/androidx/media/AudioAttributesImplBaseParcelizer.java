package androidx.media;

import k0.AbstractC1206a;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC1206a abstractC1206a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f10432a = abstractC1206a.p(audioAttributesImplBase.f10432a, 1);
        audioAttributesImplBase.f10433b = abstractC1206a.p(audioAttributesImplBase.f10433b, 2);
        audioAttributesImplBase.f10434c = abstractC1206a.p(audioAttributesImplBase.f10434c, 3);
        audioAttributesImplBase.f10435d = abstractC1206a.p(audioAttributesImplBase.f10435d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC1206a abstractC1206a) {
        abstractC1206a.x(false, false);
        abstractC1206a.F(audioAttributesImplBase.f10432a, 1);
        abstractC1206a.F(audioAttributesImplBase.f10433b, 2);
        abstractC1206a.F(audioAttributesImplBase.f10434c, 3);
        abstractC1206a.F(audioAttributesImplBase.f10435d, 4);
    }
}
