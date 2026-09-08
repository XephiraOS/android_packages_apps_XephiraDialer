package org.tensorflow.lite;

/* loaded from: classes4.dex */
public enum DataType {
    FLOAT32(1),
    INT32(2),
    UINT8(3),
    INT64(4),
    STRING(5),
    INT8(9);


    /* renamed from: g, reason: collision with root package name */
    public static final DataType[] f35897g = values();
    private final int value;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35899a;

        static {
            int[] iArr = new int[DataType.values().length];
            f35899a = iArr;
            try {
                iArr[DataType.FLOAT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35899a[DataType.INT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35899a[DataType.INT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35899a[DataType.UINT8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35899a[DataType.INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35899a[DataType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    DataType(int i10) {
        this.value = i10;
    }

    public static DataType b(int i10) {
        for (DataType dataType : f35897g) {
            if (dataType.value == i10) {
                return dataType;
            }
        }
        throw new IllegalArgumentException("DataType error: DataType " + i10 + " is not recognized in Java (version " + TensorFlowLite.b() + ")");
    }

    public int a() {
        switch (a.f35899a[ordinal()]) {
            case 1:
            case 2:
                return 4;
            case 3:
            case 4:
                return 1;
            case 5:
                return 8;
            case 6:
                return -1;
            default:
                throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
        }
    }

    public String c() {
        switch (a.f35899a[ordinal()]) {
            case 1:
                return "float";
            case 2:
                return "int";
            case 3:
            case 4:
                return "byte";
            case 5:
                return "long";
            case 6:
                return "string";
            default:
                throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
        }
    }
}
