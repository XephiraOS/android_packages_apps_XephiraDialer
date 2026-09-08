package G9;

import com.heytap.accessory.constant.FastPairConstants;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractC1221b;
import okio.ByteString;

/* compiled from: Options.kt */
/* loaded from: classes4.dex */
public final class i extends AbstractC1221b<ByteString> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1139d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final ByteString[] f1140b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f1141c;

    /* compiled from: Options.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public static /* synthetic */ void b(a aVar, long j10, b bVar, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            long j11;
            int i14;
            int i15;
            int i16;
            if ((i13 & 1) != 0) {
                j11 = 0;
            } else {
                j11 = j10;
            }
            if ((i13 & 4) != 0) {
                i14 = 0;
            } else {
                i14 = i10;
            }
            if ((i13 & 16) != 0) {
                i15 = 0;
            } else {
                i15 = i11;
            }
            if ((i13 & 32) != 0) {
                i16 = list.size();
            } else {
                i16 = i12;
            }
            aVar.a(j11, bVar, i14, list, i15, i16, list2);
        }

        public final void a(long j10, b bVar, int i10, List<? extends ByteString> list, int i11, int i12, List<Integer> list2) {
            int i13;
            int i14;
            int i15;
            int i16;
            b bVar2;
            int i17 = i10;
            if (i11 < i12) {
                for (int i18 = i11; i18 < i12; i18++) {
                    if (list.get(i18).o() < i17) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = list.get(i11);
                ByteString byteString2 = list.get(i12 - 1);
                int i19 = -1;
                if (i17 == byteString.o()) {
                    int intValue = list2.get(i11).intValue();
                    int i20 = i11 + 1;
                    ByteString byteString3 = list.get(i20);
                    i13 = i20;
                    i14 = intValue;
                    byteString = byteString3;
                } else {
                    i13 = i11;
                    i14 = -1;
                }
                if (byteString.c(i17) != byteString2.c(i17)) {
                    int i21 = 1;
                    for (int i22 = i13 + 1; i22 < i12; i22++) {
                        if (list.get(i22 - 1).c(i17) != list.get(i22).c(i17)) {
                            i21++;
                        }
                    }
                    long c10 = j10 + c(bVar) + 2 + (i21 * 2);
                    bVar.h0(i21);
                    bVar.h0(i14);
                    for (int i23 = i13; i23 < i12; i23++) {
                        byte c11 = list.get(i23).c(i17);
                        if (i23 == i13 || c11 != list.get(i23 - 1).c(i17)) {
                            bVar.h0(c11 & FastPairConstants.GO_INTENT_NOT_SET);
                        }
                    }
                    b bVar3 = new b();
                    while (i13 < i12) {
                        byte c12 = list.get(i13).c(i17);
                        int i24 = i13 + 1;
                        int i25 = i24;
                        while (true) {
                            if (i25 < i12) {
                                if (c12 != list.get(i25).c(i17)) {
                                    i15 = i25;
                                    break;
                                }
                                i25++;
                            } else {
                                i15 = i12;
                                break;
                            }
                        }
                        if (i24 == i15 && i17 + 1 == list.get(i13).o()) {
                            bVar.h0(list2.get(i13).intValue());
                            i16 = i15;
                            bVar2 = bVar3;
                        } else {
                            bVar.h0(((int) (c10 + c(bVar3))) * i19);
                            i16 = i15;
                            bVar2 = bVar3;
                            a(c10, bVar3, i17 + 1, list, i13, i15, list2);
                        }
                        bVar3 = bVar2;
                        i13 = i16;
                        i19 = -1;
                    }
                    bVar.f0(bVar3);
                    return;
                }
                int min = Math.min(byteString.o(), byteString2.o());
                int i26 = 0;
                for (int i27 = i17; i27 < min && byteString.c(i27) == byteString2.c(i27); i27++) {
                    i26++;
                }
                long c13 = j10 + c(bVar) + 2 + i26 + 1;
                bVar.h0(-i26);
                bVar.h0(i14);
                int i28 = i26 + i17;
                while (i17 < i28) {
                    bVar.h0(byteString.c(i17) & FastPairConstants.GO_INTENT_NOT_SET);
                    i17++;
                }
                if (i13 + 1 == i12) {
                    if (i28 == list.get(i13).o()) {
                        bVar.h0(list2.get(i13).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                b bVar4 = new b();
                bVar.h0(((int) (c(bVar4) + c13)) * (-1));
                a(c13, bVar4, i28, list, i13, i12, list2);
                bVar.f0(bVar4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final long c(b bVar) {
            return bVar.U() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final G9.i d(okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: G9.i.a.d(okio.ByteString[]):G9.i");
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public /* synthetic */ i(ByteString[] byteStringArr, int[] iArr, kotlin.jvm.internal.f fVar) {
        this(byteStringArr, iArr);
    }

    public static final i k(ByteString... byteStringArr) {
        return f1139d.d(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.f1140b.length;
    }

    public /* bridge */ boolean c(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return c((ByteString) obj);
    }

    @Override // kotlin.collections.AbstractC1221b, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ByteString get(int i10) {
        return this.f1140b[i10];
    }

    public final ByteString[] g() {
        return this.f1140b;
    }

    public final int[] h() {
        return this.f1141c;
    }

    public /* bridge */ int i(ByteString byteString) {
        return super.indexOf(byteString);
    }

    @Override // kotlin.collections.AbstractC1221b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return i((ByteString) obj);
    }

    public /* bridge */ int j(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    @Override // kotlin.collections.AbstractC1221b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return j((ByteString) obj);
    }

    public i(ByteString[] byteStringArr, int[] iArr) {
        this.f1140b = byteStringArr;
        this.f1141c = iArr;
    }
}
