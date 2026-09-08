package com.android.contacts.framework.virtualsupport;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.AnyProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class GrpcInfo {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_RequestChat_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RequestChat_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_ResponseChat_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ResponseChat_fieldAccessorTable;

    /* loaded from: classes.dex */
    public static final class RequestChat extends GeneratedMessageV3 implements RequestChatOrBuilder {
        public static final int INDEX_FIELD_NUMBER = 1;
        public static final int REQUEST_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int index_;
        private byte memoizedIsInitialized;
        private volatile Object request_;
        private static final RequestChat DEFAULT_INSTANCE = new RequestChat();
        private static final Parser<RequestChat> PARSER = new AbstractParser<RequestChat>() { // from class: com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChat.1
            @Override // com.google.protobuf.Parser
            public RequestChat parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new RequestChat(codedInputStream, extensionRegistryLite);
            }
        };

        public static RequestChat getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GrpcInfo.internal_static_RequestChat_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static RequestChat parseDelimitedFrom(InputStream inputStream) {
            return (RequestChat) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static RequestChat parseFrom(ByteBuffer byteBuffer) {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<RequestChat> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RequestChat)) {
                return super.equals(obj);
            }
            RequestChat requestChat = (RequestChat) obj;
            if (getIndex() == requestChat.getIndex() && getRequest().equals(requestChat.getRequest()) && this.unknownFields.equals(requestChat.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChatOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RequestChat> getParserForType() {
            return PARSER;
        }

        @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChatOrBuilder
        public String getRequest() {
            Object obj = this.request_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.request_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChatOrBuilder
        public ByteString getRequestBytes() {
            Object obj = this.request_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.request_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            int i12 = this.index_;
            if (i12 != 0) {
                i10 = CodedOutputStream.computeInt32Size(1, i12);
            } else {
                i10 = 0;
            }
            if (!getRequestBytes().isEmpty()) {
                i10 += GeneratedMessageV3.computeStringSize(2, this.request_);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getIndex()) * 37) + 2) * 53) + getRequest().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GrpcInfo.internal_static_RequestChat_fieldAccessorTable.ensureFieldAccessorsInitialized(RequestChat.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            int i10 = this.index_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(1, i10);
            }
            if (!getRequestBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.request_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestChatOrBuilder {
            private int index_;
            private Object request_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GrpcInfo.internal_static_RequestChat_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRequest() {
                this.request_ = RequestChat.getDefaultInstance().getRequest();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GrpcInfo.internal_static_RequestChat_descriptor;
            }

            @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChatOrBuilder
            public int getIndex() {
                return this.index_;
            }

            @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChatOrBuilder
            public String getRequest() {
                Object obj = this.request_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.request_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChatOrBuilder
            public ByteString getRequestBytes() {
                Object obj = this.request_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.request_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GrpcInfo.internal_static_RequestChat_fieldAccessorTable.ensureFieldAccessorsInitialized(RequestChat.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setIndex(int i10) {
                this.index_ = i10;
                onChanged();
                return this;
            }

            public Builder setRequest(String str) {
                str.getClass();
                this.request_ = str;
                onChanged();
                return this;
            }

            public Builder setRequestBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.request_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.request_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RequestChat build() {
                RequestChat buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RequestChat buildPartial() {
                RequestChat requestChat = new RequestChat(this);
                requestChat.index_ = this.index_;
                requestChat.request_ = this.request_;
                onBuilt();
                return requestChat;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RequestChat getDefaultInstanceForType() {
                return RequestChat.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.index_ = 0;
                this.request_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.request_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo3clone() {
                return (Builder) super.mo3clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof RequestChat) {
                    return mergeFrom((RequestChat) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(RequestChat requestChat) {
                if (requestChat == RequestChat.getDefaultInstance()) {
                    return this;
                }
                if (requestChat.getIndex() != 0) {
                    setIndex(requestChat.getIndex());
                }
                if (!requestChat.getRequest().isEmpty()) {
                    this.request_ = requestChat.request_;
                    onChanged();
                }
                mergeUnknownFields(((GeneratedMessageV3) requestChat).unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChat.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChat.d()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.android.contacts.framework.virtualsupport.GrpcInfo$RequestChat r3 = (com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChat) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.android.contacts.framework.virtualsupport.GrpcInfo$RequestChat r4 = (com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChat) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.virtualsupport.GrpcInfo.RequestChat.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.contacts.framework.virtualsupport.GrpcInfo$RequestChat$Builder");
            }
        }

        public static Builder newBuilder(RequestChat requestChat) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(requestChat);
        }

        public static RequestChat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private RequestChat(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RequestChat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RequestChat) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RequestChat parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RequestChat getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static RequestChat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private RequestChat() {
            this.memoizedIsInitialized = (byte) -1;
            this.request_ = "";
        }

        public static RequestChat parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static RequestChat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static RequestChat parseFrom(InputStream inputStream) {
            return (RequestChat) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private RequestChat(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.index_ = codedInputStream.readInt32();
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.request_ = codedInputStream.readStringRequireUtf8();
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        public static RequestChat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RequestChat) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RequestChat parseFrom(CodedInputStream codedInputStream) {
            return (RequestChat) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static RequestChat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (RequestChat) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public interface RequestChatOrBuilder extends MessageOrBuilder {
        int getIndex();

        String getRequest();

        ByteString getRequestBytes();
    }

    /* loaded from: classes.dex */
    public static final class ResponseChat extends GeneratedMessageV3 implements ResponseChatOrBuilder {
        private static final ResponseChat DEFAULT_INSTANCE = new ResponseChat();
        private static final Parser<ResponseChat> PARSER = new AbstractParser<ResponseChat>() { // from class: com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChat.1
            @Override // com.google.protobuf.Parser
            public ResponseChat parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new ResponseChat(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RESULT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object result_;

        public static ResponseChat getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GrpcInfo.internal_static_ResponseChat_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ResponseChat parseDelimitedFrom(InputStream inputStream) {
            return (ResponseChat) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ResponseChat parseFrom(ByteBuffer byteBuffer) {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ResponseChat> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResponseChat)) {
                return super.equals(obj);
            }
            ResponseChat responseChat = (ResponseChat) obj;
            if (getResult().equals(responseChat.getResult()) && this.unknownFields.equals(responseChat.unknownFields)) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ResponseChat> getParserForType() {
            return PARSER;
        }

        @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChatOrBuilder
        public String getResult() {
            Object obj = this.result_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.result_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChatOrBuilder
        public ByteString getResultBytes() {
            Object obj = this.result_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.result_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if (!getResultBytes().isEmpty()) {
                i10 = GeneratedMessageV3.computeStringSize(1, this.result_);
            } else {
                i10 = 0;
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getResult().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GrpcInfo.internal_static_ResponseChat_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponseChat.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if (!getResultBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.result_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseChatOrBuilder {
            private Object result_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GrpcInfo.internal_static_ResponseChat_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearResult() {
                this.result_ = ResponseChat.getDefaultInstance().getResult();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GrpcInfo.internal_static_ResponseChat_descriptor;
            }

            @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChatOrBuilder
            public String getResult() {
                Object obj = this.result_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.result_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChatOrBuilder
            public ByteString getResultBytes() {
                Object obj = this.result_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.result_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GrpcInfo.internal_static_ResponseChat_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponseChat.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setResult(String str) {
                str.getClass();
                this.result_ = str;
                onChanged();
                return this;
            }

            public Builder setResultBytes(ByteString byteString) {
                byteString.getClass();
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.result_ = byteString;
                onChanged();
                return this;
            }

            private Builder() {
                this.result_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResponseChat build() {
                ResponseChat buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResponseChat buildPartial() {
                ResponseChat responseChat = new ResponseChat(this);
                responseChat.result_ = this.result_;
                onBuilt();
                return responseChat;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ResponseChat getDefaultInstanceForType() {
                return ResponseChat.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.result_ = "";
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.result_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo3clone() {
                return (Builder) super.mo3clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ResponseChat) {
                    return mergeFrom((ResponseChat) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ResponseChat responseChat) {
                if (responseChat == ResponseChat.getDefaultInstance()) {
                    return this;
                }
                if (!responseChat.getResult().isEmpty()) {
                    this.result_ = responseChat.result_;
                    onChanged();
                }
                mergeUnknownFields(((GeneratedMessageV3) responseChat).unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChat.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChat.c()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.android.contacts.framework.virtualsupport.GrpcInfo$ResponseChat r3 = (com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChat) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.android.contacts.framework.virtualsupport.GrpcInfo$ResponseChat r4 = (com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChat) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.virtualsupport.GrpcInfo.ResponseChat.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.contacts.framework.virtualsupport.GrpcInfo$ResponseChat$Builder");
            }
        }

        public static Builder newBuilder(ResponseChat responseChat) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(responseChat);
        }

        public static ResponseChat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ResponseChat(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ResponseChat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResponseChat) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ResponseChat parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResponseChat getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ResponseChat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ResponseChat() {
            this.memoizedIsInitialized = (byte) -1;
            this.result_ = "";
        }

        public static ResponseChat parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static ResponseChat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ResponseChat parseFrom(InputStream inputStream) {
            return (ResponseChat) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private ResponseChat(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag != 10) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.result_ = codedInputStream.readStringRequireUtf8();
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        public static ResponseChat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResponseChat) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ResponseChat parseFrom(CodedInputStream codedInputStream) {
            return (ResponseChat) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ResponseChat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResponseChat) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes.dex */
    public interface ResponseChatOrBuilder extends MessageOrBuilder {
        String getResult();

        ByteString getResultBytes();
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eGrpcInfo.proto\u001a\u0019google/protobuf/any.proto\"-\n\u000bRequestChat\u0012\r\n\u0005index\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007request\u0018\u0002 \u0001(\t\"\u001e\n\fResponseChat\u0012\u000e\n\u0006result\u0018\u0001 \u0001(\t2E\n\tRouteChat\u00128\n\u0004chat\u0012\u0014.google.protobuf.Any\u001a\u0014.google.protobuf.Any\"\u0000(\u00010\u0001B/\n-com.android.contacts.framework.virtualsupportb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor()}, new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.android.contacts.framework.virtualsupport.GrpcInfo.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                GrpcInfo.descriptor = fileDescriptor;
                return null;
            }
        });
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_RequestChat_descriptor = descriptor2;
        internal_static_RequestChat_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Index", "Request"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_ResponseChat_descriptor = descriptor3;
        internal_static_ResponseChat_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Result"});
        AnyProto.getDescriptor();
    }

    private GrpcInfo() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }
}
