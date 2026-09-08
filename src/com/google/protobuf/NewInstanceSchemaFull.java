package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;

/* loaded from: classes3.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageV3) obj).newInstance(GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
    }
}
