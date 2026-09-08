package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes3.dex */
public final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    public static int computeSizeBoolList(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(i10, true);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i10, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i11));
        }
        return computeTagSize;
    }

    public static int computeSizeEnumList(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag);
        }
        return computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeEnumSizeNoTag(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int computeSizeFixed32List(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i10, 0);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i10, 0L);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i10, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += CodedOutputStream.computeGroupSize(i10, list.get(i12));
        }
        return i11;
    }

    public static int computeSizeInt32List(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag);
        }
        return computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeInt32SizeNoTag(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int computeSizeInt64List(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag);
        }
        return computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeInt64SizeNoTag(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int computeSizeMessage(int i10, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i10, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(i10, (MessageLite) obj, schema);
    }

    public static int computeSizeMessageList(int i10, List<?> list) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            computeTagSize += computeMessageSizeNoTag;
        }
        return computeTagSize;
    }

    public static int computeSizeSInt32List(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag);
        }
        return computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int computeSizeSInt64List(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag);
        }
        return computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int computeSizeStringList(int i10, List<?> list) {
        int computeStringSizeNoTag;
        int computeStringSizeNoTag2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i10) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i11 < size) {
                Object raw = lazyStringList.getRaw(i11);
                if (raw instanceof ByteString) {
                    computeStringSizeNoTag2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    computeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += computeStringSizeNoTag2;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof ByteString) {
                    computeStringSizeNoTag = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                } else {
                    computeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += computeStringSizeNoTag;
                i11++;
            }
        }
        return computeTagSize;
    }

    public static int computeSizeUInt32List(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag);
        }
        return computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int computeSizeUInt64List(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z10) {
            return CodedOutputStream.computeTagSize(i10) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag);
        }
        return computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i10));
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i11));
                i11++;
            }
        } else {
            i10 = 0;
            while (i11 < size) {
                i10 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i10, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = list.get(i12);
                int intValue = num.intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i10, intValue, ub, unknownFieldSchema);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(intValue2) == null) {
                    ub = (UB) storeUnknownEnum(obj, i10, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            boolean z10 = GeneratedMessageV3.alwaysUseFieldBuilders;
            return GeneratedMessageV3.class;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        return UnknownFieldSetSchema.class;
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t10, T t11) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t11);
        if (!extensions.isEmpty()) {
            extensionSchema.getMutableExtensions(t10).mergeFrom(extensions);
        }
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t10, T t11, long j10) {
        UnsafeUtil.putObject(t10, j10, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t10, j10), UnsafeUtil.getObject(t11, j10)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t10, T t11) {
        unknownFieldSchema.setToMessage(t10, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t10), unknownFieldSchema.getFromMessage(t11)));
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i10, int i11, int i12) {
        if (i11 < 40) {
            return true;
        }
        long j10 = i11 - i10;
        long j11 = i12;
        return j10 + 10 <= ((2 * j11) + 3) + ((j11 + 3) * 3);
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB storeUnknownEnum(Object obj, int i10, int i11, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i10, i11);
        return ub;
    }

    public static String toCamelCase(String str, boolean z10) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ('a' <= charAt && charAt <= 'z') {
                if (z10) {
                    sb.append((char) (charAt - ' '));
                } else {
                    sb.append(charAt);
                }
            } else if ('A' <= charAt && charAt <= 'Z') {
                if (i10 == 0 && !z10) {
                    sb.append((char) (charAt + ' '));
                } else {
                    sb.append(charAt);
                }
            } else {
                if ('0' <= charAt && charAt <= '9') {
                    sb.append(charAt);
                }
                z10 = true;
            }
            z10 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i10, boolean z10, Writer writer) {
        if (z10) {
            writer.writeBool(i10, true);
        }
    }

    public static void writeBoolList(int i10, List<Boolean> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i10, list, z10);
        }
    }

    public static void writeBytes(int i10, ByteString byteString, Writer writer) {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i10, byteString);
        }
    }

    public static void writeBytesList(int i10, List<ByteString> list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i10, list);
        }
    }

    public static void writeDouble(int i10, double d10, Writer writer) {
        if (Double.doubleToRawLongBits(d10) != 0) {
            writer.writeDouble(i10, d10);
        }
    }

    public static void writeDoubleList(int i10, List<Double> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i10, list, z10);
        }
    }

    public static void writeEnum(int i10, int i11, Writer writer) {
        if (i11 != 0) {
            writer.writeEnum(i10, i11);
        }
    }

    public static void writeEnumList(int i10, List<Integer> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i10, list, z10);
        }
    }

    public static void writeFixed32(int i10, int i11, Writer writer) {
        if (i11 != 0) {
            writer.writeFixed32(i10, i11);
        }
    }

    public static void writeFixed32List(int i10, List<Integer> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i10, list, z10);
        }
    }

    public static void writeFixed64(int i10, long j10, Writer writer) {
        if (j10 != 0) {
            writer.writeFixed64(i10, j10);
        }
    }

    public static void writeFixed64List(int i10, List<Long> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i10, list, z10);
        }
    }

    public static void writeFloat(int i10, float f10, Writer writer) {
        if (Float.floatToRawIntBits(f10) != 0) {
            writer.writeFloat(i10, f10);
        }
    }

    public static void writeFloatList(int i10, List<Float> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i10, list, z10);
        }
    }

    public static void writeGroupList(int i10, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i10, list);
    }

    public static void writeInt32(int i10, int i11, Writer writer) {
        if (i11 != 0) {
            writer.writeInt32(i10, i11);
        }
    }

    public static void writeInt32List(int i10, List<Integer> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i10, list, z10);
        }
    }

    public static void writeInt64(int i10, long j10, Writer writer) {
        if (j10 != 0) {
            writer.writeInt64(i10, j10);
        }
    }

    public static void writeInt64List(int i10, List<Long> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i10, list, z10);
        }
    }

    public static void writeLazyFieldList(int i10, List<?> list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                ((LazyFieldLite) it.next()).writeTo(writer, i10);
            }
        }
    }

    public static void writeMessage(int i10, Object obj, Writer writer) {
        if (obj != null) {
            writer.writeMessage(i10, obj);
        }
    }

    public static void writeMessageList(int i10, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i10, list);
    }

    public static void writeSFixed32(int i10, int i11, Writer writer) {
        if (i11 != 0) {
            writer.writeSFixed32(i10, i11);
        }
    }

    public static void writeSFixed32List(int i10, List<Integer> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i10, list, z10);
        }
    }

    public static void writeSFixed64(int i10, long j10, Writer writer) {
        if (j10 != 0) {
            writer.writeSFixed64(i10, j10);
        }
    }

    public static void writeSFixed64List(int i10, List<Long> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i10, list, z10);
        }
    }

    public static void writeSInt32(int i10, int i11, Writer writer) {
        if (i11 != 0) {
            writer.writeSInt32(i10, i11);
        }
    }

    public static void writeSInt32List(int i10, List<Integer> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i10, list, z10);
        }
    }

    public static void writeSInt64(int i10, long j10, Writer writer) {
        if (j10 != 0) {
            writer.writeSInt64(i10, j10);
        }
    }

    public static void writeSInt64List(int i10, List<Long> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i10, list, z10);
        }
    }

    public static void writeString(int i10, Object obj, Writer writer) {
        if (obj instanceof String) {
            writeStringInternal(i10, (String) obj, writer);
        } else {
            writeBytes(i10, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i10, String str, Writer writer) {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i10, str);
        }
    }

    public static void writeStringList(int i10, List<String> list, Writer writer) {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i10, list);
        }
    }

    public static void writeUInt32(int i10, int i11, Writer writer) {
        if (i11 != 0) {
            writer.writeUInt32(i10, i11);
        }
    }

    public static void writeUInt32List(int i10, List<Integer> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i10, list, z10);
        }
    }

    public static void writeUInt64(int i10, long j10, Writer writer) {
        if (j10 != 0) {
            writer.writeUInt64(i10, j10);
        }
    }

    public static void writeUInt64List(int i10, List<Long> list, Writer writer, boolean z10) {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i10, list, z10);
        }
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static int computeSizeGroupList(int i10, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += CodedOutputStream.computeGroupSize(i10, list.get(i12), schema);
        }
        return i11;
    }

    public static void writeGroupList(int i10, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i10, list, schema);
    }

    public static void writeMessageList(int i10, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i10, list, schema);
    }

    public static int computeSizeMessageList(int i10, List<?> list, Schema schema) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize += computeMessageSizeNoTag;
        }
        return computeTagSize;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i10, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Integer num = list.get(i12);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, num);
                    }
                    i11++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i10, intValue, ub, unknownFieldSchema);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = (UB) storeUnknownEnum(obj, i10, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
