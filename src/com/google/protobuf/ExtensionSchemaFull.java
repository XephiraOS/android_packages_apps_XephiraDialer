package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
    private static final long EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f24953a = 0;

    /* renamed from: com.google.protobuf.ExtensionSchemaFull$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private static <T> long getExtensionsFieldOffset() {
        return UnsafeUtil.objectFieldOffset(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
    }

    @Override // com.google.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> entry) {
        return ((Descriptors.FieldDescriptor) entry.getKey()).getNumber();
    }

    @Override // com.google.protobuf.ExtensionSchema
    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i10) {
        return ((ExtensionRegistry) extensionRegistryLite).findImmutableExtensionByNumber(((Message) messageLite).getDescriptorForType(), i10);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object obj) {
        return (FieldSet) UnsafeUtil.getObject(obj, EXTENSION_FIELD_OFFSET);
    }

    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object obj) {
        FieldSet<Descriptors.FieldDescriptor> extensions = getExtensions(obj);
        if (extensions.isImmutable()) {
            FieldSet<Descriptors.FieldDescriptor> m4clone = extensions.m4clone();
            setExtensions(obj, m4clone);
            return m4clone;
        }
        return extensions;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageV3.ExtendableMessage;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0026. Please report as an issue. */
    @Override // com.google.protobuf.ExtensionSchema
    public <UT, UB> UB parseExtension(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Object valueOf;
        Object field;
        ArrayList arrayList;
        ArrayList arrayList2;
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj2;
        int number = extensionInfo.descriptor.getNumber();
        if (extensionInfo.descriptor.isRepeated() && extensionInfo.descriptor.isPacked()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    reader.readDoubleList(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    reader.readFloatList(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    reader.readInt64List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    reader.readUInt64List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    reader.readInt32List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    reader.readFixed64List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    reader.readFixed32List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    reader.readBoolList(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    reader.readUInt32List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    reader.readSFixed32List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    reader.readSFixed64List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    reader.readSInt32List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    reader.readSInt64List(arrayList);
                    arrayList2 = arrayList;
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                case 14:
                    ArrayList arrayList3 = new ArrayList();
                    reader.readEnumList(arrayList3);
                    arrayList2 = new ArrayList();
                    Iterator<Integer> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        Descriptors.EnumValueDescriptor findValueByNumber = extensionInfo.descriptor.getEnumType().findValueByNumber(intValue);
                        if (findValueByNumber != null) {
                            arrayList2.add(findValueByNumber);
                        } else {
                            ub = (UB) SchemaUtil.storeUnknownEnum(obj, number, intValue, ub, unknownFieldSchema);
                        }
                    }
                    fieldSet.setField(extensionInfo.descriptor, arrayList2);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + extensionInfo.descriptor.getLiteType());
            }
        } else {
            if (extensionInfo.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                int readInt32 = reader.readInt32();
                valueOf = extensionInfo.descriptor.getEnumType().findValueByNumber(readInt32);
                if (valueOf == null) {
                    return (UB) SchemaUtil.storeUnknownEnum(obj, number, readInt32, ub, unknownFieldSchema);
                }
            } else {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()]) {
                    case 1:
                        valueOf = Double.valueOf(reader.readDouble());
                        break;
                    case 2:
                        valueOf = Float.valueOf(reader.readFloat());
                        break;
                    case 3:
                        valueOf = Long.valueOf(reader.readInt64());
                        break;
                    case 4:
                        valueOf = Long.valueOf(reader.readUInt64());
                        break;
                    case 5:
                        valueOf = Integer.valueOf(reader.readInt32());
                        break;
                    case 6:
                        valueOf = Long.valueOf(reader.readFixed64());
                        break;
                    case 7:
                        valueOf = Integer.valueOf(reader.readFixed32());
                        break;
                    case 8:
                        valueOf = Boolean.valueOf(reader.readBool());
                        break;
                    case 9:
                        valueOf = Integer.valueOf(reader.readUInt32());
                        break;
                    case 10:
                        valueOf = Integer.valueOf(reader.readSFixed32());
                        break;
                    case 11:
                        valueOf = Long.valueOf(reader.readSFixed64());
                        break;
                    case 12:
                        valueOf = Integer.valueOf(reader.readSInt32());
                        break;
                    case 13:
                        valueOf = Long.valueOf(reader.readSInt64());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        valueOf = reader.readBytes();
                        break;
                    case 16:
                        valueOf = reader.readString();
                        break;
                    case 17:
                        valueOf = reader.readGroup(extensionInfo.defaultInstance.getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        valueOf = reader.readMessage(extensionInfo.defaultInstance.getClass(), extensionRegistryLite);
                        break;
                    default:
                        valueOf = null;
                        break;
                }
            }
            if (extensionInfo.descriptor.isRepeated()) {
                fieldSet.addRepeatedField(extensionInfo.descriptor, valueOf);
            } else {
                int i10 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()];
                if ((i10 == 17 || i10 == 18) && (field = fieldSet.getField(extensionInfo.descriptor)) != null) {
                    valueOf = Internal.mergeMessage(field, valueOf);
                }
                fieldSet.setField(extensionInfo.descriptor, valueOf);
            }
        }
        return ub;
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            fieldSet.setField(extensionInfo.descriptor, reader.readMessage(extensionInfo.defaultInstance.getClass(), extensionRegistryLite));
        } else {
            fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, reader.readBytes()));
        }
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        Message buildPartial = extensionInfo.defaultInstance.newBuilderForType().buildPartial();
        if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
            BinaryReader newInstance = BinaryReader.newInstance(ByteBuffer.wrap(byteString.toByteArray()), true);
            Protobuf.getInstance().mergeFrom(buildPartial, newInstance, extensionRegistryLite);
            fieldSet.setField(extensionInfo.descriptor, buildPartial);
            if (newInstance.getFieldNumber() != Integer.MAX_VALUE) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            return;
        }
        fieldSet.setField(extensionInfo.descriptor, new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString));
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) {
        Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) entry.getKey();
        if (fieldDescriptor.isRepeated()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    SchemaUtil.writeDoubleList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 2:
                    SchemaUtil.writeFloatList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 3:
                    SchemaUtil.writeInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 4:
                    SchemaUtil.writeUInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 5:
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 6:
                    SchemaUtil.writeFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 7:
                    SchemaUtil.writeFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 8:
                    SchemaUtil.writeBoolList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 9:
                    SchemaUtil.writeUInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 10:
                    SchemaUtil.writeSFixed32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 11:
                    SchemaUtil.writeSFixed64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 12:
                    SchemaUtil.writeSInt32List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 13:
                    SchemaUtil.writeSInt64List(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 14:
                    List list = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((Descriptors.EnumValueDescriptor) it.next()).getNumber()));
                    }
                    SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), arrayList, writer, fieldDescriptor.isPacked());
                    return;
                case 15:
                    SchemaUtil.writeBytesList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    SchemaUtil.writeStringList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    SchemaUtil.writeGroupList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 18:
                    SchemaUtil.writeMessageList(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                default:
                    return;
            }
        }
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldDescriptor.getLiteType().ordinal()]) {
            case 1:
                writer.writeDouble(fieldDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                writer.writeFloat(fieldDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                writer.writeInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                writer.writeUInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                writer.writeInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                writer.writeFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                writer.writeFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                writer.writeBool(fieldDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                writer.writeUInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                writer.writeSFixed32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                writer.writeSFixed64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                writer.writeSInt32(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                writer.writeSInt64(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                writer.writeInt32(fieldDescriptor.getNumber(), ((Descriptors.EnumValueDescriptor) entry.getValue()).getNumber());
                return;
            case 15:
                writer.writeBytes(fieldDescriptor.getNumber(), (ByteString) entry.getValue());
                return;
            case 16:
                writer.writeString(fieldDescriptor.getNumber(), (String) entry.getValue());
                return;
            case 17:
                writer.writeGroup(fieldDescriptor.getNumber(), entry.getValue());
                return;
            case 18:
                writer.writeMessage(fieldDescriptor.getNumber(), entry.getValue());
                return;
            default:
                return;
        }
    }

    @Override // com.google.protobuf.ExtensionSchema
    public void setExtensions(Object obj, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        UnsafeUtil.putObject(obj, EXTENSION_FIELD_OFFSET, fieldSet);
    }
}
