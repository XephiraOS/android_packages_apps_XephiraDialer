package kotlin.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.e;
import m9.q;
import v9.l;

/* compiled from: ReadWrite.kt */
/* loaded from: classes4.dex */
public final class TextStreamsKt {
    public static final void a(Reader reader, l<? super String, q> action) {
        BufferedReader bufferedReader;
        i.f(reader, "<this>");
        i.f(action, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            Iterator<String> it = b(bufferedReader).iterator();
            while (it.hasNext()) {
                action.invoke(it.next());
            }
            q qVar = q.f35511a;
            a.a(bufferedReader, null);
        } finally {
        }
    }

    public static final e<String> b(BufferedReader bufferedReader) {
        e<String> c10;
        i.f(bufferedReader, "<this>");
        c10 = SequencesKt__SequencesKt.c(new b(bufferedReader));
        return c10;
    }

    public static final List<String> c(Reader reader) {
        i.f(reader, "<this>");
        final ArrayList arrayList = new ArrayList();
        a(reader, new l<String, q>() { // from class: kotlin.io.TextStreamsKt$readLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(String str) {
                invoke2(str);
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                i.f(it, "it");
                arrayList.add(it);
            }
        });
        return arrayList;
    }
}
