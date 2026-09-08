package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: classes3.dex */
public final class LegacyDescriptorsUtil {

    /* renamed from: com.google.protobuf.LegacyDescriptorsUtil$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax;

        static {
            int[] iArr = new int[Descriptors.FileDescriptor.Syntax.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax = iArr;
            try {
                iArr[Descriptors.FileDescriptor.Syntax.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[Descriptors.FileDescriptor.Syntax.PROTO2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[Descriptors.FileDescriptor.Syntax.PROTO3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class LegacyFileDescriptor {

        /* loaded from: classes3.dex */
        public enum Syntax {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");

            final String name;

            Syntax(String str) {
                this.name = str;
            }
        }

        private LegacyFileDescriptor() {
        }

        public static Syntax getSyntax(Descriptors.FileDescriptor fileDescriptor) {
            int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[fileDescriptor.getSyntax().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        return Syntax.PROTO3;
                    }
                    throw new IllegalArgumentException("Unexpected syntax");
                }
                return Syntax.PROTO2;
            }
            return Syntax.UNKNOWN;
        }
    }

    private LegacyDescriptorsUtil() {
    }
}
