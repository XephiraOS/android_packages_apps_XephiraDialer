package com.oplus.anim.model.content;

import b6.l;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import g6.c;
import l6.e;

/* loaded from: classes3.dex */
public class MergePaths implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f25975a;

    /* renamed from: b, reason: collision with root package name */
    public final MergePathsMode f25976b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25977c;

    /* loaded from: classes3.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode a(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z10) {
        this.f25975a = str;
        this.f25976b = mergePathsMode;
        this.f25977c = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        if (!effectiveAnimationDrawable.F()) {
            e.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new l(this);
    }

    public MergePathsMode b() {
        return this.f25976b;
    }

    public String c() {
        return this.f25975a;
    }

    public boolean d() {
        return this.f25977c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f25976b + '}';
    }
}
