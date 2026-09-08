package com.google.protobuf;

import java.util.List;

/* loaded from: classes3.dex */
public interface TypeOrBuilder extends MessageOrBuilder {
    String getEdition();

    ByteString getEditionBytes();

    Field getFields(int i10);

    int getFieldsCount();

    List<Field> getFieldsList();

    FieldOrBuilder getFieldsOrBuilder(int i10);

    List<? extends FieldOrBuilder> getFieldsOrBuilderList();

    String getName();

    ByteString getNameBytes();

    String getOneofs(int i10);

    ByteString getOneofsBytes(int i10);

    int getOneofsCount();

    List<String> getOneofsList();

    Option getOptions(int i10);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int i10);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    SourceContext getSourceContext();

    SourceContextOrBuilder getSourceContextOrBuilder();

    Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
