package com.oplus.anim.model.content;

import f6.C1017d;
import f6.h;

/* loaded from: classes3.dex */
public class Mask {

    /* renamed from: a, reason: collision with root package name */
    public final MaskMode f25966a;

    /* renamed from: b, reason: collision with root package name */
    public final h f25967b;

    /* renamed from: c, reason: collision with root package name */
    public final C1017d f25968c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25969d;

    /* loaded from: classes3.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, C1017d c1017d, boolean z10) {
        this.f25966a = maskMode;
        this.f25967b = hVar;
        this.f25968c = c1017d;
        this.f25969d = z10;
    }

    public MaskMode a() {
        return this.f25966a;
    }

    public h b() {
        return this.f25967b;
    }

    public C1017d c() {
        return this.f25968c;
    }

    public boolean d() {
        return this.f25969d;
    }
}
