package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class PluginProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"c\n\u0007Version\u0012\u0014\n\u0005major\u0018\u0001 \u0001(\u0005R\u0005major\u0012\u0014\n\u0005minor\u0018\u0002 \u0001(\u0005R\u0005minor\u0012\u0014\n\u0005patch\u0018\u0003 \u0001(\u0005R\u0005patch\u0012\u0016\n\u0006suffix\u0018\u0004 \u0001(\tR\u0006suffix\"ñ\u0001\n\u0014CodeGeneratorRequest\u0012(\n\u0010file_to_generate\u0018\u0001 \u0003(\tR\u000efileToGenerate\u0012\u001c\n\tparameter\u0018\u0002 \u0001(\tR\tparameter\u0012C\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\tprotoFile\u0012L\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.VersionR\u000fcompilerVersion\"\u0094\u0003\n\u0015CodeGeneratorResponse\u0012\u0014\n\u0005error\u0018\u0001 \u0001(\tR\u0005error\u0012-\n\u0012supported_features\u0018\u0002 \u0001(\u0004R\u0011supportedFeatures\u0012H\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.FileR\u0004file\u001a±\u0001\n\u0004File\u0012\u0012\n\u0004name\u0018\u0001 \u0001(\tR\u0004name\u0012'\n\u000finsertion_point\u0018\u0002 \u0001(\tR\u000einsertionPoint\u0012\u0018\n\u0007content\u0018\u000f \u0001(\tR\u0007content\u0012R\n\u0013generated_code_info\u0018\u0010 \u0001(\u000b2\".google.protobuf.GeneratedCodeInfoR\u0011generatedCodeInfo\"8\n\u0007Feature\u0012\u0010\n\fFEATURE_NONE\u0010\u0000\u0012\u001b\n\u0017FEATURE_PROTO3_OPTIONAL\u0010\u0001Br\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ)google.golang.org/protobuf/types/pluginpbª\u0002\u0018Google.Protobuf.Compiler"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable;

    /* loaded from: classes3.dex */
    public static final class CodeGeneratorRequest extends GeneratedMessageV3 implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Version compilerVersion_;
        private LazyStringArrayList fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile Object parameter_;
        private List<DescriptorProtos.FileDescriptorProto> protoFile_;
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();

        @Deprecated
        public static final Parser<CodeGeneratorRequest> PARSER = new AbstractParser<CodeGeneratorRequest>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest.1
            @Override // com.google.protobuf.Parser
            public CodeGeneratorRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = CodeGeneratorRequest.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return newBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.setUnfinishedMessage(newBuilder.buildPartial());
                } catch (UninitializedMessageException e11) {
                    throw e11.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12).setUnfinishedMessage(newBuilder.buildPartial());
                }
            }
        };

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> compilerVersionBuilder_;
            private Version compilerVersion_;
            private LazyStringArrayList fileToGenerate_;
            private Object parameter_;
            private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> protoFile_;

            private void buildPartial0(CodeGeneratorRequest codeGeneratorRequest) {
                int i10;
                Version build;
                int i11 = this.bitField0_;
                if ((i11 & 1) != 0) {
                    this.fileToGenerate_.makeImmutable();
                    codeGeneratorRequest.fileToGenerate_ = this.fileToGenerate_;
                }
                if ((i11 & 2) != 0) {
                    codeGeneratorRequest.parameter_ = this.parameter_;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 8) != 0) {
                    SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        build = this.compilerVersion_;
                    } else {
                        build = singleFieldBuilderV3.build();
                    }
                    codeGeneratorRequest.compilerVersion_ = build;
                    i10 |= 2;
                }
                CodeGeneratorRequest.access$2076(codeGeneratorRequest, i10);
            }

            private void buildPartialRepeatedFields(CodeGeneratorRequest codeGeneratorRequest) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    codeGeneratorRequest.protoFile_ = repeatedFieldBuilderV3.build();
                    return;
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                    this.bitField0_ &= -5;
                }
                codeGeneratorRequest.protoFile_ = this.protoFile_;
            }

            private void ensureFileToGenerateIsMutable() {
                if (!this.fileToGenerate_.isModifiable()) {
                    this.fileToGenerate_ = new LazyStringArrayList((LazyStringList) this.fileToGenerate_);
                }
                this.bitField0_ |= 1;
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.protoFile_ = new ArrayList(this.protoFile_);
                    this.bitField0_ |= 4;
                }
            }

            private SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> getCompilerVersionFieldBuilder() {
                if (this.compilerVersionBuilder_ == null) {
                    this.compilerVersionBuilder_ = new SingleFieldBuilderV3<>(getCompilerVersion(), getParentForChildren(), isClean());
                    this.compilerVersion_ = null;
                }
                return this.compilerVersionBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
                boolean z10;
                if (this.protoFileBuilder_ == null) {
                    List<DescriptorProtos.FileDescriptorProto> list = this.protoFile_;
                    if ((this.bitField0_ & 4) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.protoFileBuilder_ = new RepeatedFieldBuilderV3<>(list, z10, getParentForChildren(), isClean());
                    this.protoFile_ = null;
                }
                return this.protoFileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getProtoFileFieldBuilder();
                    getCompilerVersionFieldBuilder();
                }
            }

            public Builder addAllFileToGenerate(Iterable<String> iterable) {
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.fileToGenerate_);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> iterable) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.protoFile_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder addFileToGenerate(String str) {
                str.getClass();
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(str);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString byteString) {
                byteString.getClass();
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(byteString);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    fileDescriptorProto.getClass();
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(fileDescriptorProto);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(fileDescriptorProto);
                }
                return this;
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return getProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public Builder clearCompilerVersion() {
                this.bitField0_ &= -9;
                this.compilerVersion_ = null;
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.compilerVersionBuilder_ = null;
                }
                onChanged();
                return this;
            }

            public Builder clearFileToGenerate() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearParameter() {
                this.parameter_ = CodeGeneratorRequest.getDefaultInstance().getParameter();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearProtoFile() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.protoFile_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public Version getCompilerVersion() {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Version version = this.compilerVersion_;
                    if (version == null) {
                        return Version.getDefaultInstance();
                    }
                    return version;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return getCompilerVersionFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public VersionOrBuilder getCompilerVersionOrBuilder() {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Version version = this.compilerVersion_;
                if (version == null) {
                    return Version.getDefaultInstance();
                }
                return version;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int i10) {
                return this.fileToGenerate_.get(i10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int i10) {
                return this.fileToGenerate_.getByteString(i10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getParameter() {
                Object obj = this.parameter_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.parameter_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                Object obj = this.parameter_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.parameter_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int i10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessage(i10);
            }

            public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int i10) {
                return getProtoFileFieldBuilder().getBuilder(i10);
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return getProtoFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.protoFile_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.protoFile_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.protoFile_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasCompilerVersion() {
                if ((this.bitField0_ & 8) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < getProtoFileCount(); i10++) {
                    if (!getProtoFile(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeCompilerVersion(Version version) {
                Version version2;
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 8) != 0 && (version2 = this.compilerVersion_) != null && version2 != Version.getDefaultInstance()) {
                        getCompilerVersionBuilder().mergeFrom(version);
                    } else {
                        this.compilerVersion_ = version;
                    }
                } else {
                    singleFieldBuilderV3.mergeFrom(version);
                }
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder removeProtoFile(int i10) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.remove(i10);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i10);
                }
                return this;
            }

            public Builder setCompilerVersion(Version version) {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    version.getClass();
                    this.compilerVersion_ = version;
                } else {
                    singleFieldBuilderV3.setMessage(version);
                }
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setFileToGenerate(int i10, String str) {
                str.getClass();
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(i10, str);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setParameter(String str) {
                str.getClass();
                this.parameter_ = str;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setParameterBytes(ByteString byteString) {
                byteString.getClass();
                this.parameter_ = byteString;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setProtoFile(int i10, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    fileDescriptorProto.getClass();
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(i10, fileDescriptorProto);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, fileDescriptorProto);
                }
                return this;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ProtocolStringList getFileToGenerateList() {
                this.fileToGenerate_.makeImmutable();
                return this.fileToGenerate_;
            }

            private Builder() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest codeGeneratorRequest = new CodeGeneratorRequest(this);
                buildPartialRepeatedFields(codeGeneratorRequest);
                if (this.bitField0_ != 0) {
                    buildPartial0(codeGeneratorRequest);
                }
                onBuilt();
                return codeGeneratorRequest;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
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

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int i10) {
                return getProtoFileFieldBuilder().addBuilder(i10, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
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
                this.bitField0_ = 0;
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.protoFile_ = Collections.emptyList();
                } else {
                    this.protoFile_ = null;
                    repeatedFieldBuilderV3.clear();
                }
                this.bitField0_ &= -5;
                this.compilerVersion_ = null;
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.dispose();
                    this.compilerVersionBuilder_ = null;
                }
                return this;
            }

            public Builder addProtoFile(int i10, DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    fileDescriptorProto.getClass();
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(i10, fileDescriptorProto);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i10, fileDescriptorProto);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo3clone() {
                return (Builder) super.mo3clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof CodeGeneratorRequest) {
                    return mergeFrom((CodeGeneratorRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder setCompilerVersion(Version.Builder builder) {
                SingleFieldBuilderV3<Version, Version.Builder, VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.compilerVersion_ = builder.build();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setProtoFile(int i10, DescriptorProtos.FileDescriptorProto.Builder builder) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.set(i10, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, builder.build());
                }
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(CodeGeneratorRequest codeGeneratorRequest) {
                if (codeGeneratorRequest == CodeGeneratorRequest.getDefaultInstance()) {
                    return this;
                }
                if (!codeGeneratorRequest.fileToGenerate_.isEmpty()) {
                    if (this.fileToGenerate_.isEmpty()) {
                        this.fileToGenerate_ = codeGeneratorRequest.fileToGenerate_;
                        this.bitField0_ |= 1;
                    } else {
                        ensureFileToGenerateIsMutable();
                        this.fileToGenerate_.addAll(codeGeneratorRequest.fileToGenerate_);
                    }
                    onChanged();
                }
                if (codeGeneratorRequest.hasParameter()) {
                    this.parameter_ = codeGeneratorRequest.parameter_;
                    this.bitField0_ |= 2;
                    onChanged();
                }
                if (this.protoFileBuilder_ == null) {
                    if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                        if (this.protoFile_.isEmpty()) {
                            this.protoFile_ = codeGeneratorRequest.protoFile_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureProtoFileIsMutable();
                            this.protoFile_.addAll(codeGeneratorRequest.protoFile_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorRequest.protoFile_.isEmpty()) {
                    if (!this.protoFileBuilder_.isEmpty()) {
                        this.protoFileBuilder_.addAllMessages(codeGeneratorRequest.protoFile_);
                    } else {
                        this.protoFileBuilder_.dispose();
                        this.protoFileBuilder_ = null;
                        this.protoFile_ = codeGeneratorRequest.protoFile_;
                        this.bitField0_ &= -5;
                        this.protoFileBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getProtoFileFieldBuilder() : null;
                    }
                }
                if (codeGeneratorRequest.hasCompilerVersion()) {
                    mergeCompilerVersion(codeGeneratorRequest.getCompilerVersion());
                }
                mergeUnknownFields(codeGeneratorRequest.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder builder) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addProtoFile(int i10, DescriptorProtos.FileDescriptorProto.Builder builder) {
                RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProtoFileIsMutable();
                    this.protoFile_.add(i10, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i10, builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                extensionRegistryLite.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    ByteString readBytes = codedInputStream.readBytes();
                                    ensureFileToGenerateIsMutable();
                                    this.fileToGenerate_.add(readBytes);
                                } else if (readTag == 18) {
                                    this.parameter_ = codedInputStream.readBytes();
                                    this.bitField0_ |= 2;
                                } else if (readTag == 26) {
                                    codedInputStream.readMessage(getCompilerVersionFieldBuilder().getBuilder(), extensionRegistryLite);
                                    this.bitField0_ |= 8;
                                } else if (readTag != 122) {
                                    if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    DescriptorProtos.FileDescriptorProto fileDescriptorProto = (DescriptorProtos.FileDescriptorProto) codedInputStream.readMessage(DescriptorProtos.FileDescriptorProto.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
                                    if (repeatedFieldBuilderV3 == null) {
                                        ensureProtoFileIsMutable();
                                        this.protoFile_.add(fileDescriptorProto);
                                    } else {
                                        repeatedFieldBuilderV3.addMessage(fileDescriptorProto);
                                    }
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        public static /* synthetic */ int access$2076(CodeGeneratorRequest codeGeneratorRequest, int i10) {
            int i11 = i10 | codeGeneratorRequest.bitField0_;
            codeGeneratorRequest.bitField0_ = i11;
            return i11;
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream) {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer byteBuffer) {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorRequest)) {
                return super.equals(obj);
            }
            CodeGeneratorRequest codeGeneratorRequest = (CodeGeneratorRequest) obj;
            if (!getFileToGenerateList().equals(codeGeneratorRequest.getFileToGenerateList()) || hasParameter() != codeGeneratorRequest.hasParameter()) {
                return false;
            }
            if ((hasParameter() && !getParameter().equals(codeGeneratorRequest.getParameter())) || !getProtoFileList().equals(codeGeneratorRequest.getProtoFileList()) || hasCompilerVersion() != codeGeneratorRequest.hasCompilerVersion()) {
                return false;
            }
            if ((!hasCompilerVersion() || getCompilerVersion().equals(codeGeneratorRequest.getCompilerVersion())) && getUnknownFields().equals(codeGeneratorRequest.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public Version getCompilerVersion() {
            Version version = this.compilerVersion_;
            if (version == null) {
                return Version.getDefaultInstance();
            }
            return version;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public VersionOrBuilder getCompilerVersionOrBuilder() {
            Version version = this.compilerVersion_;
            if (version == null) {
                return Version.getDefaultInstance();
            }
            return version;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int i10) {
            return this.fileToGenerate_.get(i10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int i10) {
            return this.fileToGenerate_.getByteString(i10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getParameter() {
            Object obj = this.parameter_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.parameter_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            Object obj = this.parameter_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.parameter_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int i10) {
            return this.protoFile_.get(i10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i10) {
            return this.protoFile_.get(i10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.fileToGenerate_.size(); i12++) {
                i11 += GeneratedMessageV3.computeStringSizeNoTag(this.fileToGenerate_.getRaw(i12));
            }
            int size = i11 + getFileToGenerateList().size();
            if ((this.bitField0_ & 1) != 0) {
                size += GeneratedMessageV3.computeStringSize(2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                size += CodedOutputStream.computeMessageSize(3, getCompilerVersion());
            }
            for (int i13 = 0; i13 < this.protoFile_.size(); i13++) {
                size += CodedOutputStream.computeMessageSize(15, this.protoFile_.get(i13));
            }
            int serializedSize = size + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasCompilerVersion() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (getFileToGenerateCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getFileToGenerateList().hashCode();
            }
            if (hasParameter()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getParameter().hashCode();
            }
            if (getProtoFileCount() > 0) {
                hashCode = (((hashCode * 37) + 15) * 53) + getProtoFileList().hashCode();
            }
            if (hasCompilerVersion()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCompilerVersion().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
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
            for (int i10 = 0; i10 < getProtoFileCount(); i10++) {
                if (!getProtoFile(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CodeGeneratorRequest();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            for (int i10 = 0; i10 < this.fileToGenerate_.size(); i10++) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.fileToGenerate_.getRaw(i10));
            }
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.parameter_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeMessage(3, getCompilerVersion());
            }
            for (int i11 = 0; i11 < this.protoFile_.size(); i11++) {
                codedOutputStream.writeMessage(15, this.protoFile_.get(i11));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        private CodeGeneratorRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(CodeGeneratorRequest codeGeneratorRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeGeneratorRequest);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CodeGeneratorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        private CodeGeneratorRequest() {
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
        }

        public static CodeGeneratorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream) {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream) {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        Version getCompilerVersion();

        VersionOrBuilder getCompilerVersionOrBuilder();

        String getFileToGenerate(int i10);

        ByteString getFileToGenerateBytes(int i10);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int i10);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int i10);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    /* loaded from: classes3.dex */
    public static final class CodeGeneratorResponse extends GeneratedMessageV3 implements CodeGeneratorResponseOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        public static final int SUPPORTED_FEATURES_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object error_;
        private List<File> file_;
        private byte memoizedIsInitialized;
        private long supportedFeatures_;
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();

        @Deprecated
        public static final Parser<CodeGeneratorResponse> PARSER = new AbstractParser<CodeGeneratorResponse>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.1
            @Override // com.google.protobuf.Parser
            public CodeGeneratorResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = CodeGeneratorResponse.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return newBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.setUnfinishedMessage(newBuilder.buildPartial());
                } catch (UninitializedMessageException e11) {
                    throw e11.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12).setUnfinishedMessage(newBuilder.buildPartial());
                }
            }
        };

        /* loaded from: classes3.dex */
        public enum Feature implements ProtocolMessageEnum {
            FEATURE_NONE(0),
            FEATURE_PROTO3_OPTIONAL(1);

            public static final int FEATURE_NONE_VALUE = 0;
            public static final int FEATURE_PROTO3_OPTIONAL_VALUE = 1;
            private final int value;
            private static final Internal.EnumLiteMap<Feature> internalValueMap = new Internal.EnumLiteMap<Feature>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.Feature.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Feature findValueByNumber(int i10) {
                    return Feature.forNumber(i10);
                }
            };
            private static final Feature[] VALUES = values();

            Feature(int i10) {
                this.value = i10;
            }

            public static Feature forNumber(int i10) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        return null;
                    }
                    return FEATURE_PROTO3_OPTIONAL;
                }
                return FEATURE_NONE;
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return CodeGeneratorResponse.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<Feature> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            @Deprecated
            public static Feature valueOf(int i10) {
                return forNumber(i10);
            }

            public static Feature valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
                if (enumValueDescriptor.getType() == getDescriptor()) {
                    return VALUES[enumValueDescriptor.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
        }

        /* loaded from: classes3.dex */
        public static final class File extends GeneratedMessageV3 implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            public static final int GENERATED_CODE_INFO_FIELD_NUMBER = 16;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object content_;
            private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
            private volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile Object name_;
            private static final File DEFAULT_INSTANCE = new File();

            @Deprecated
            public static final Parser<File> PARSER = new AbstractParser<File>() { // from class: com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File.1
                @Override // com.google.protobuf.Parser
                public File parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    Builder newBuilder = File.newBuilder();
                    try {
                        newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                        return newBuilder.buildPartial();
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(newBuilder.buildPartial());
                    } catch (UninitializedMessageException e11) {
                        throw e11.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
                    } catch (IOException e12) {
                        throw new InvalidProtocolBufferException(e12).setUnfinishedMessage(newBuilder.buildPartial());
                    }
                }
            };

            public static /* synthetic */ int access$3476(File file, int i10) {
                int i11 = i10 | file.bitField0_;
                file.bitField0_ = i11;
                return i11;
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static File parseDelimitedFrom(InputStream inputStream) {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static File parseFrom(ByteBuffer byteBuffer) {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Parser<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof File)) {
                    return super.equals(obj);
                }
                File file = (File) obj;
                if (hasName() != file.hasName()) {
                    return false;
                }
                if ((hasName() && !getName().equals(file.getName())) || hasInsertionPoint() != file.hasInsertionPoint()) {
                    return false;
                }
                if ((hasInsertionPoint() && !getInsertionPoint().equals(file.getInsertionPoint())) || hasContent() != file.hasContent()) {
                    return false;
                }
                if ((hasContent() && !getContent().equals(file.getContent())) || hasGeneratedCodeInfo() != file.hasGeneratedCodeInfo()) {
                    return false;
                }
                if ((!hasGeneratedCodeInfo() || getGeneratedCodeInfo().equals(file.getGeneratedCodeInfo())) && getUnknownFields().equals(file.getUnknownFields())) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.content_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                if (generatedCodeInfo == null) {
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                }
                return generatedCodeInfo;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                if (generatedCodeInfo == null) {
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                }
                return generatedCodeInfo;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                Object obj = this.insertionPoint_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.insertionPoint_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                Object obj = this.insertionPoint_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.insertionPoint_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String stringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.name_ = stringUtf8;
                }
                return stringUtf8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i10;
                int i11 = this.memoizedSize;
                if (i11 != -1) {
                    return i11;
                }
                if ((this.bitField0_ & 1) != 0) {
                    i10 = GeneratedMessageV3.computeStringSize(1, this.name_);
                } else {
                    i10 = 0;
                }
                if ((this.bitField0_ & 2) != 0) {
                    i10 += GeneratedMessageV3.computeStringSize(2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    i10 += GeneratedMessageV3.computeStringSize(15, this.content_);
                }
                if ((this.bitField0_ & 8) != 0) {
                    i10 += CodedOutputStream.computeMessageSize(16, getGeneratedCodeInfo());
                }
                int serializedSize = i10 + getUnknownFields().getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                if ((this.bitField0_ & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasGeneratedCodeInfo() {
                if ((this.bitField0_ & 8) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (hasName()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
                }
                if (hasInsertionPoint()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getInsertionPoint().hashCode();
                }
                if (hasContent()) {
                    hashCode = (((hashCode * 37) + 15) * 53) + getContent().hashCode();
                }
                if (hasGeneratedCodeInfo()) {
                    hashCode = (((hashCode * 37) + 16) * 53) + getGeneratedCodeInfo().hashCode();
                }
                int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
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

            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new File();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) {
                if ((this.bitField0_ & 1) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
                }
                if ((this.bitField0_ & 2) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 2, this.insertionPoint_);
                }
                if ((this.bitField0_ & 4) != 0) {
                    GeneratedMessageV3.writeString(codedOutputStream, 15, this.content_);
                }
                if ((this.bitField0_ & 8) != 0) {
                    codedOutputStream.writeMessage(16, getGeneratedCodeInfo());
                }
                getUnknownFields().writeTo(codedOutputStream);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileOrBuilder {
                private int bitField0_;
                private Object content_;
                private SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> generatedCodeInfoBuilder_;
                private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
                private Object insertionPoint_;
                private Object name_;

                private void buildPartial0(File file) {
                    int i10;
                    DescriptorProtos.GeneratedCodeInfo build;
                    int i11 = this.bitField0_;
                    if ((i11 & 1) != 0) {
                        file.name_ = this.name_;
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if ((i11 & 2) != 0) {
                        file.insertionPoint_ = this.insertionPoint_;
                        i10 |= 2;
                    }
                    if ((i11 & 4) != 0) {
                        file.content_ = this.content_;
                        i10 |= 4;
                    }
                    if ((i11 & 8) != 0) {
                        SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                        if (singleFieldBuilderV3 == null) {
                            build = this.generatedCodeInfo_;
                        } else {
                            build = singleFieldBuilderV3.build();
                        }
                        file.generatedCodeInfo_ = build;
                        i10 |= 8;
                    }
                    File.access$3476(file, i10);
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                private SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> getGeneratedCodeInfoFieldBuilder() {
                    if (this.generatedCodeInfoBuilder_ == null) {
                        this.generatedCodeInfoBuilder_ = new SingleFieldBuilderV3<>(getGeneratedCodeInfo(), getParentForChildren(), isClean());
                        this.generatedCodeInfo_ = null;
                    }
                    return this.generatedCodeInfoBuilder_;
                }

                private void maybeForceBuilderInitialization() {
                    if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                        getGeneratedCodeInfoFieldBuilder();
                    }
                }

                public Builder clearContent() {
                    this.content_ = File.getDefaultInstance().getContent();
                    this.bitField0_ &= -5;
                    onChanged();
                    return this;
                }

                public Builder clearGeneratedCodeInfo() {
                    this.bitField0_ &= -9;
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        singleFieldBuilderV3.dispose();
                        this.generatedCodeInfoBuilder_ = null;
                    }
                    onChanged();
                    return this;
                }

                public Builder clearInsertionPoint() {
                    this.insertionPoint_ = File.getDefaultInstance().getInsertionPoint();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.name_ = File.getDefaultInstance().getName();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getContent() {
                    Object obj = this.content_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.content_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    Object obj = this.content_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.content_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                        if (generatedCodeInfo == null) {
                            return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                        }
                        return generatedCodeInfo;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public DescriptorProtos.GeneratedCodeInfo.Builder getGeneratedCodeInfoBuilder() {
                    this.bitField0_ |= 8;
                    onChanged();
                    return getGeneratedCodeInfoFieldBuilder().getBuilder();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    DescriptorProtos.GeneratedCodeInfo generatedCodeInfo = this.generatedCodeInfo_;
                    if (generatedCodeInfo == null) {
                        return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                    }
                    return generatedCodeInfo;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    Object obj = this.insertionPoint_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.insertionPoint_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    Object obj = this.insertionPoint_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.insertionPoint_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    Object obj = this.name_;
                    if (!(obj instanceof String)) {
                        ByteString byteString = (ByteString) obj;
                        String stringUtf8 = byteString.toStringUtf8();
                        if (byteString.isValidUtf8()) {
                            this.name_ = stringUtf8;
                        }
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getNameBytes() {
                    Object obj = this.name_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.name_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    if ((this.bitField0_ & 4) != 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasGeneratedCodeInfo() {
                    if ((this.bitField0_ & 8) != 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    if ((this.bitField0_ & 2) != 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    if ((this.bitField0_ & 1) != 0) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo generatedCodeInfo) {
                    DescriptorProtos.GeneratedCodeInfo generatedCodeInfo2;
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.bitField0_ & 8) != 0 && (generatedCodeInfo2 = this.generatedCodeInfo_) != null && generatedCodeInfo2 != DescriptorProtos.GeneratedCodeInfo.getDefaultInstance()) {
                            getGeneratedCodeInfoBuilder().mergeFrom(generatedCodeInfo);
                        } else {
                            this.generatedCodeInfo_ = generatedCodeInfo;
                        }
                    } else {
                        singleFieldBuilderV3.mergeFrom(generatedCodeInfo);
                    }
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                }

                public Builder setContent(String str) {
                    str.getClass();
                    this.content_ = str;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                public Builder setContentBytes(ByteString byteString) {
                    byteString.getClass();
                    this.content_ = byteString;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo generatedCodeInfo) {
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        generatedCodeInfo.getClass();
                        this.generatedCodeInfo_ = generatedCodeInfo;
                    } else {
                        singleFieldBuilderV3.setMessage(generatedCodeInfo);
                    }
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                }

                public Builder setInsertionPoint(String str) {
                    str.getClass();
                    this.insertionPoint_ = str;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString byteString) {
                    byteString.getClass();
                    this.insertionPoint_ = byteString;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                public Builder setName(String str) {
                    str.getClass();
                    this.name_ = str;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    byteString.getClass();
                    this.name_ = byteString;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File build() {
                    File buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File buildPartial() {
                    File file = new File(this);
                    if (this.bitField0_ != 0) {
                        buildPartial0(file);
                    }
                    onBuilt();
                    return file;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
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
                    this.bitField0_ = 0;
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        singleFieldBuilderV3.dispose();
                        this.generatedCodeInfoBuilder_ = null;
                    }
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo3clone() {
                    return (Builder) super.mo3clone();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof File) {
                        return mergeFrom((File) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo.Builder builder) {
                    SingleFieldBuilderV3<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> singleFieldBuilderV3 = this.generatedCodeInfoBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.generatedCodeInfo_ = builder.build();
                    } else {
                        singleFieldBuilderV3.setMessage(builder.build());
                    }
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                public Builder mergeFrom(File file) {
                    if (file == File.getDefaultInstance()) {
                        return this;
                    }
                    if (file.hasName()) {
                        this.name_ = file.name_;
                        this.bitField0_ |= 1;
                        onChanged();
                    }
                    if (file.hasInsertionPoint()) {
                        this.insertionPoint_ = file.insertionPoint_;
                        this.bitField0_ |= 2;
                        onChanged();
                    }
                    if (file.hasContent()) {
                        this.content_ = file.content_;
                        this.bitField0_ |= 4;
                        onChanged();
                    }
                    if (file.hasGeneratedCodeInfo()) {
                        mergeGeneratedCodeInfo(file.getGeneratedCodeInfo());
                    }
                    mergeUnknownFields(file.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    extensionRegistryLite.getClass();
                    boolean z10 = false;
                    while (!z10) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        this.name_ = codedInputStream.readBytes();
                                        this.bitField0_ |= 1;
                                    } else if (readTag == 18) {
                                        this.insertionPoint_ = codedInputStream.readBytes();
                                        this.bitField0_ |= 2;
                                    } else if (readTag == 122) {
                                        this.content_ = codedInputStream.readBytes();
                                        this.bitField0_ |= 4;
                                    } else if (readTag != 130) {
                                        if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        codedInputStream.readMessage(getGeneratedCodeInfoFieldBuilder().getBuilder(), extensionRegistryLite);
                                        this.bitField0_ |= 8;
                                    }
                                }
                                z10 = true;
                            } catch (InvalidProtocolBufferException e10) {
                                throw e10.unwrapIOException();
                            }
                        } catch (Throwable th) {
                            onChanged();
                            throw th;
                        }
                    }
                    onChanged();
                    return this;
                }
            }

            private File(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Builder newBuilder(File file) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(file);
            }

            public static File parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static File parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static File parseFrom(ByteString byteString) {
                return PARSER.parseFrom(byteString);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
            }

            public static File parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static File parseFrom(byte[] bArr) {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent);
            }

            public static File parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            private File() {
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            public static File parseFrom(InputStream inputStream) {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static File parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static File parseFrom(CodedInputStream codedInputStream) {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static File parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return (File) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes3.dex */
        public interface FileOrBuilder extends MessageOrBuilder {
            String getContent();

            ByteString getContentBytes();

            DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo();

            DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasGeneratedCodeInfo();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        public static /* synthetic */ int access$4176(CodeGeneratorResponse codeGeneratorResponse, int i10) {
            int i11 = i10 | codeGeneratorResponse.bitField0_;
            codeGeneratorResponse.bitField0_ = i11;
            return i11;
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream) {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer byteBuffer) {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CodeGeneratorResponse)) {
                return super.equals(obj);
            }
            CodeGeneratorResponse codeGeneratorResponse = (CodeGeneratorResponse) obj;
            if (hasError() != codeGeneratorResponse.hasError()) {
                return false;
            }
            if ((hasError() && !getError().equals(codeGeneratorResponse.getError())) || hasSupportedFeatures() != codeGeneratorResponse.hasSupportedFeatures()) {
                return false;
            }
            if ((!hasSupportedFeatures() || getSupportedFeatures() == codeGeneratorResponse.getSupportedFeatures()) && getFileList().equals(codeGeneratorResponse.getFileList()) && getUnknownFields().equals(codeGeneratorResponse.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            Object obj = this.error_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.error_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            Object obj = this.error_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.error_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int i10) {
            return this.file_.get(i10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<File> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public FileOrBuilder getFileOrBuilder(int i10) {
            return this.file_.get(i10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.bitField0_ & 1) != 0) {
                i10 = GeneratedMessageV3.computeStringSize(1, this.error_);
            } else {
                i10 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i10 += CodedOutputStream.computeUInt64Size(2, this.supportedFeatures_);
            }
            for (int i12 = 0; i12 < this.file_.size(); i12++) {
                i10 += CodedOutputStream.computeMessageSize(15, this.file_.get(i12));
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public long getSupportedFeatures() {
            return this.supportedFeatures_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasSupportedFeatures() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasError()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getError().hashCode();
            }
            if (hasSupportedFeatures()) {
                hashCode = (((hashCode * 37) + 2) * 53) + Internal.hashLong(getSupportedFeatures());
            }
            if (getFileCount() > 0) {
                hashCode = (((hashCode * 37) + 15) * 53) + getFileList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new CodeGeneratorResponse();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.error_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeUInt64(2, this.supportedFeatures_);
            }
            for (int i10 = 0; i10 < this.file_.size(); i10++) {
                codedOutputStream.writeMessage(15, this.file_.get(i10));
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private Object error_;
            private RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> fileBuilder_;
            private List<File> file_;
            private long supportedFeatures_;

            private void buildPartial0(CodeGeneratorResponse codeGeneratorResponse) {
                int i10;
                int i11 = this.bitField0_;
                if ((i11 & 1) != 0) {
                    codeGeneratorResponse.error_ = this.error_;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    codeGeneratorResponse.supportedFeatures_ = this.supportedFeatures_;
                    i10 |= 2;
                }
                CodeGeneratorResponse.access$4176(codeGeneratorResponse, i10);
            }

            private void buildPartialRepeatedFields(CodeGeneratorResponse codeGeneratorResponse) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    codeGeneratorResponse.file_ = repeatedFieldBuilderV3.build();
                    return;
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.file_ = Collections.unmodifiableList(this.file_);
                    this.bitField0_ &= -5;
                }
                codeGeneratorResponse.file_ = this.file_;
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.file_ = new ArrayList(this.file_);
                    this.bitField0_ |= 4;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            private RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> getFileFieldBuilder() {
                boolean z10;
                if (this.fileBuilder_ == null) {
                    List<File> list = this.file_;
                    if ((this.bitField0_ & 4) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.fileBuilder_ = new RepeatedFieldBuilderV3<>(list, z10, getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
            }

            public Builder addAllFile(Iterable<? extends File> iterable) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.file_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder addFile(File file) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    file.getClass();
                    ensureFileIsMutable();
                    this.file_.add(file);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(file);
                }
                return this;
            }

            public File.Builder addFileBuilder() {
                return getFileFieldBuilder().addBuilder(File.getDefaultInstance());
            }

            public Builder clearError() {
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearFile() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder clearSupportedFeatures() {
                this.bitField0_ &= -3;
                this.supportedFeatures_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                Object obj = this.error_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.error_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                Object obj = this.error_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.error_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int i10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessage(i10);
            }

            public File.Builder getFileBuilder(int i10) {
                return getFileFieldBuilder().getBuilder(i10);
            }

            public List<File.Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.file_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public FileOrBuilder getFileOrBuilder(int i10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.file_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.file_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public long getSupportedFeatures() {
                return this.supportedFeatures_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasSupportedFeatures() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder removeFile(int i10) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.remove(i10);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i10);
                }
                return this;
            }

            public Builder setError(String str) {
                str.getClass();
                this.error_ = str;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setErrorBytes(ByteString byteString) {
                byteString.getClass();
                this.error_ = byteString;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setFile(int i10, File file) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    file.getClass();
                    ensureFileIsMutable();
                    this.file_.set(i10, file);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, file);
                }
                return this;
            }

            public Builder setSupportedFeatures(long j10) {
                this.supportedFeatures_ = j10;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            private Builder() {
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse codeGeneratorResponse = new CodeGeneratorResponse(this);
                buildPartialRepeatedFields(codeGeneratorResponse);
                if (this.bitField0_ != 0) {
                    buildPartial0(codeGeneratorResponse);
                }
                onBuilt();
                return codeGeneratorResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
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

            public File.Builder addFileBuilder(int i10) {
                return getFileFieldBuilder().addBuilder(i10, File.getDefaultInstance());
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
                this.bitField0_ = 0;
                this.error_ = "";
                this.supportedFeatures_ = 0L;
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.file_ = Collections.emptyList();
                } else {
                    this.file_ = null;
                    repeatedFieldBuilderV3.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            public Builder addFile(int i10, File file) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    file.getClass();
                    ensureFileIsMutable();
                    this.file_.add(i10, file);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i10, file);
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo3clone() {
                return (Builder) super.mo3clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof CodeGeneratorResponse) {
                    return mergeFrom((CodeGeneratorResponse) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder setFile(int i10, File.Builder builder) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.set(i10, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(CodeGeneratorResponse codeGeneratorResponse) {
                if (codeGeneratorResponse == CodeGeneratorResponse.getDefaultInstance()) {
                    return this;
                }
                if (codeGeneratorResponse.hasError()) {
                    this.error_ = codeGeneratorResponse.error_;
                    this.bitField0_ |= 1;
                    onChanged();
                }
                if (codeGeneratorResponse.hasSupportedFeatures()) {
                    setSupportedFeatures(codeGeneratorResponse.getSupportedFeatures());
                }
                if (this.fileBuilder_ == null) {
                    if (!codeGeneratorResponse.file_.isEmpty()) {
                        if (this.file_.isEmpty()) {
                            this.file_ = codeGeneratorResponse.file_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureFileIsMutable();
                            this.file_.addAll(codeGeneratorResponse.file_);
                        }
                        onChanged();
                    }
                } else if (!codeGeneratorResponse.file_.isEmpty()) {
                    if (!this.fileBuilder_.isEmpty()) {
                        this.fileBuilder_.addAllMessages(codeGeneratorResponse.file_);
                    } else {
                        this.fileBuilder_.dispose();
                        this.fileBuilder_ = null;
                        this.file_ = codeGeneratorResponse.file_;
                        this.bitField0_ &= -5;
                        this.fileBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getFileFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(codeGeneratorResponse.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder addFile(File.Builder builder) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addFile(int i10, File.Builder builder) {
                RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureFileIsMutable();
                    this.file_.add(i10, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(i10, builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                extensionRegistryLite.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.error_ = codedInputStream.readBytes();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    this.supportedFeatures_ = codedInputStream.readUInt64();
                                    this.bitField0_ |= 2;
                                } else if (readTag != 122) {
                                    if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    File file = (File) codedInputStream.readMessage(File.PARSER, extensionRegistryLite);
                                    RepeatedFieldBuilderV3<File, File.Builder, FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
                                    if (repeatedFieldBuilderV3 == null) {
                                        ensureFileIsMutable();
                                        this.file_.add(file);
                                    } else {
                                        repeatedFieldBuilderV3.addMessage(file);
                                    }
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private CodeGeneratorResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.error_ = "";
            this.supportedFeatures_ = 0L;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(CodeGeneratorResponse codeGeneratorResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(codeGeneratorResponse);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static CodeGeneratorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        private CodeGeneratorResponse() {
            this.error_ = "";
            this.supportedFeatures_ = 0L;
            this.memoizedIsInitialized = (byte) -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        public static CodeGeneratorResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream) {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CodeGeneratorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream) {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CodeGeneratorResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int i10);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int i10);

        List<? extends CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        long getSupportedFeatures();

        boolean hasError();

        boolean hasSupportedFeatures();
    }

    /* loaded from: classes3.dex */
    public static final class Version extends GeneratedMessageV3 implements VersionOrBuilder {
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int major_;
        private byte memoizedIsInitialized;
        private int minor_;
        private int patch_;
        private volatile Object suffix_;
        private static final Version DEFAULT_INSTANCE = new Version();

        @Deprecated
        public static final Parser<Version> PARSER = new AbstractParser<Version>() { // from class: com.google.protobuf.compiler.PluginProtos.Version.1
            @Override // com.google.protobuf.Parser
            public Version parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Builder newBuilder = Version.newBuilder();
                try {
                    newBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                    return newBuilder.buildPartial();
                } catch (InvalidProtocolBufferException e10) {
                    throw e10.setUnfinishedMessage(newBuilder.buildPartial());
                } catch (UninitializedMessageException e11) {
                    throw e11.asInvalidProtocolBufferException().setUnfinishedMessage(newBuilder.buildPartial());
                } catch (IOException e12) {
                    throw new InvalidProtocolBufferException(e12).setUnfinishedMessage(newBuilder.buildPartial());
                }
            }
        };

        public static /* synthetic */ int access$976(Version version, int i10) {
            int i11 = i10 | version.bitField0_;
            version.bitField0_ = i11;
            return i11;
        }

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Version parseDelimitedFrom(InputStream inputStream) {
            return (Version) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Version parseFrom(ByteBuffer byteBuffer) {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Version> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return super.equals(obj);
            }
            Version version = (Version) obj;
            if (hasMajor() != version.hasMajor()) {
                return false;
            }
            if ((hasMajor() && getMajor() != version.getMajor()) || hasMinor() != version.hasMinor()) {
                return false;
            }
            if ((hasMinor() && getMinor() != version.getMinor()) || hasPatch() != version.hasPatch()) {
                return false;
            }
            if ((hasPatch() && getPatch() != version.getPatch()) || hasSuffix() != version.hasSuffix()) {
                return false;
            }
            if ((!hasSuffix() || getSuffix().equals(version.getSuffix())) && getUnknownFields().equals(version.getUnknownFields())) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMajor() {
            return this.major_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMinor() {
            return this.minor_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Version> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getPatch() {
            return this.patch_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10;
            int i11 = this.memoizedSize;
            if (i11 != -1) {
                return i11;
            }
            if ((this.bitField0_ & 1) != 0) {
                i10 = CodedOutputStream.computeInt32Size(1, this.major_);
            } else {
                i10 = 0;
            }
            if ((this.bitField0_ & 2) != 0) {
                i10 += CodedOutputStream.computeInt32Size(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                i10 += CodedOutputStream.computeInt32Size(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                i10 += GeneratedMessageV3.computeStringSize(4, this.suffix_);
            }
            int serializedSize = i10 + getUnknownFields().getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public String getSuffix() {
            Object obj = this.suffix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.suffix_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public ByteString getSuffixBytes() {
            Object obj = this.suffix_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.suffix_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMajor() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMinor() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasPatch() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasSuffix() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasMajor()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getMajor();
            }
            if (hasMinor()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMinor();
            }
            if (hasPatch()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getPatch();
            }
            if (hasSuffix()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getSuffix().hashCode();
            }
            int hashCode2 = (hashCode * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Version();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) {
            if ((this.bitField0_ & 1) != 0) {
                codedOutputStream.writeInt32(1, this.major_);
            }
            if ((this.bitField0_ & 2) != 0) {
                codedOutputStream.writeInt32(2, this.minor_);
            }
            if ((this.bitField0_ & 4) != 0) {
                codedOutputStream.writeInt32(3, this.patch_);
            }
            if ((this.bitField0_ & 8) != 0) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.suffix_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VersionOrBuilder {
            private int bitField0_;
            private int major_;
            private int minor_;
            private int patch_;
            private Object suffix_;

            private void buildPartial0(Version version) {
                int i10;
                int i11 = this.bitField0_;
                if ((i11 & 1) != 0) {
                    version.major_ = this.major_;
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if ((i11 & 2) != 0) {
                    version.minor_ = this.minor_;
                    i10 |= 2;
                }
                if ((i11 & 4) != 0) {
                    version.patch_ = this.patch_;
                    i10 |= 4;
                }
                if ((i11 & 8) != 0) {
                    version.suffix_ = this.suffix_;
                    i10 |= 8;
                }
                Version.access$976(version, i10);
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            public Builder clearMajor() {
                this.bitField0_ &= -2;
                this.major_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMinor() {
                this.bitField0_ &= -3;
                this.minor_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPatch() {
                this.bitField0_ &= -5;
                this.patch_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSuffix() {
                this.suffix_ = Version.getDefaultInstance().getSuffix();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMajor() {
                return this.major_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMinor() {
                return this.minor_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getPatch() {
                return this.patch_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public String getSuffix() {
                Object obj = this.suffix_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.suffix_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public ByteString getSuffixBytes() {
                Object obj = this.suffix_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.suffix_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMajor() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMinor() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasPatch() {
                if ((this.bitField0_ & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasSuffix() {
                if ((this.bitField0_ & 8) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setMajor(int i10) {
                this.major_ = i10;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMinor(int i10) {
                this.minor_ = i10;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setPatch(int i10) {
                this.patch_ = i10;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setSuffix(String str) {
                str.getClass();
                this.suffix_ = str;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setSuffixBytes(ByteString byteString) {
                byteString.getClass();
                this.suffix_ = byteString;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            private Builder() {
                this.suffix_ = "";
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version build() {
                Version buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version buildPartial() {
                Version version = new Version(this);
                if (this.bitField0_ != 0) {
                    buildPartial0(version);
                }
                onBuilt();
                return version;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Version getDefaultInstanceForType() {
                return Version.getDefaultInstance();
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

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.suffix_ = "";
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.major_ = 0;
                this.minor_ = 0;
                this.patch_ = 0;
                this.suffix_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo3clone() {
                return (Builder) super.mo3clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Version) {
                    return mergeFrom((Version) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Version version) {
                if (version == Version.getDefaultInstance()) {
                    return this;
                }
                if (version.hasMajor()) {
                    setMajor(version.getMajor());
                }
                if (version.hasMinor()) {
                    setMinor(version.getMinor());
                }
                if (version.hasPatch()) {
                    setPatch(version.getPatch());
                }
                if (version.hasSuffix()) {
                    this.suffix_ = version.suffix_;
                    this.bitField0_ |= 8;
                    onChanged();
                }
                mergeUnknownFields(version.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                extensionRegistryLite.getClass();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.major_ = codedInputStream.readInt32();
                                    this.bitField0_ |= 1;
                                } else if (readTag == 16) {
                                    this.minor_ = codedInputStream.readInt32();
                                    this.bitField0_ |= 2;
                                } else if (readTag == 24) {
                                    this.patch_ = codedInputStream.readInt32();
                                    this.bitField0_ |= 4;
                                } else if (readTag != 34) {
                                    if (!super.parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.suffix_ = codedInputStream.readBytes();
                                    this.bitField0_ |= 8;
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e10) {
                            throw e10.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        onChanged();
                        throw th;
                    }
                }
                onChanged();
                return this;
            }
        }

        private Version(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Builder newBuilder(Version version) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(version);
        }

        public static Version parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Version parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Version parseFrom(ByteString byteString) {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static Version parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Version parseFrom(byte[] bArr) {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static Version parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Version parseFrom(InputStream inputStream) {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private Version() {
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = (byte) -1;
            this.suffix_ = "";
        }

        public static Version parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Version parseFrom(CodedInputStream codedInputStream) {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Version parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Version) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes3.dex */
    public interface VersionOrBuilder extends MessageOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_compiler_Version_descriptor = descriptor2;
        internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Major", "Minor", "Patch", "Suffix"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = descriptor3;
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"FileToGenerate", "Parameter", "ProtoFile", "CompilerVersion"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = descriptor4;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Error", "SupportedFeatures", "File"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = descriptor5;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Name", "InsertionPoint", "Content", "GeneratedCodeInfo"});
        DescriptorProtos.getDescriptor();
    }

    private PluginProtos() {
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
