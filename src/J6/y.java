package j6;

import com.oplus.anim.model.content.MergePaths;
import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: MergePathsParser.java */
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33956a = JsonReader.a.a("nm", "mm", "hd");

    public static MergePaths a(JsonReader jsonReader) {
        String str = null;
        boolean z10 = false;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33956a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        jsonReader.O();
                        jsonReader.S();
                    } else {
                        z10 = jsonReader.o();
                    }
                } else {
                    mergePathsMode = MergePaths.MergePathsMode.a(jsonReader.s());
                }
            } else {
                str = jsonReader.y();
            }
        }
        return new MergePaths(str, mergePathsMode, z10);
    }
}
