package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes3.dex */
public interface Writer {

    /* loaded from: classes3.dex */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    FieldOrder fieldOrder();

    void writeBool(int i10, boolean z10);

    void writeBoolList(int i10, List<Boolean> list, boolean z10);

    void writeBytes(int i10, ByteString byteString);

    void writeBytesList(int i10, List<ByteString> list);

    void writeDouble(int i10, double d10);

    void writeDoubleList(int i10, List<Double> list, boolean z10);

    @Deprecated
    void writeEndGroup(int i10);

    void writeEnum(int i10, int i11);

    void writeEnumList(int i10, List<Integer> list, boolean z10);

    void writeFixed32(int i10, int i11);

    void writeFixed32List(int i10, List<Integer> list, boolean z10);

    void writeFixed64(int i10, long j10);

    void writeFixed64List(int i10, List<Long> list, boolean z10);

    void writeFloat(int i10, float f10);

    void writeFloatList(int i10, List<Float> list, boolean z10);

    @Deprecated
    void writeGroup(int i10, Object obj);

    @Deprecated
    void writeGroup(int i10, Object obj, Schema schema);

    @Deprecated
    void writeGroupList(int i10, List<?> list);

    @Deprecated
    void writeGroupList(int i10, List<?> list, Schema schema);

    void writeInt32(int i10, int i11);

    void writeInt32List(int i10, List<Integer> list, boolean z10);

    void writeInt64(int i10, long j10);

    void writeInt64List(int i10, List<Long> list, boolean z10);

    <K, V> void writeMap(int i10, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map);

    void writeMessage(int i10, Object obj);

    void writeMessage(int i10, Object obj, Schema schema);

    void writeMessageList(int i10, List<?> list);

    void writeMessageList(int i10, List<?> list, Schema schema);

    void writeMessageSetItem(int i10, Object obj);

    void writeSFixed32(int i10, int i11);

    void writeSFixed32List(int i10, List<Integer> list, boolean z10);

    void writeSFixed64(int i10, long j10);

    void writeSFixed64List(int i10, List<Long> list, boolean z10);

    void writeSInt32(int i10, int i11);

    void writeSInt32List(int i10, List<Integer> list, boolean z10);

    void writeSInt64(int i10, long j10);

    void writeSInt64List(int i10, List<Long> list, boolean z10);

    @Deprecated
    void writeStartGroup(int i10);

    void writeString(int i10, String str);

    void writeStringList(int i10, List<String> list);

    void writeUInt32(int i10, int i11);

    void writeUInt32List(int i10, List<Integer> list, boolean z10);

    void writeUInt64(int i10, long j10);

    void writeUInt64List(int i10, List<Long> list, boolean z10);
}
