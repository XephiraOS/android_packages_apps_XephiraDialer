package org.apache.james.mime4j.io;

import java.io.IOException;

/* loaded from: classes4.dex */
public class MaxLineLimitException extends IOException {
    private static final long serialVersionUID = 1855987166990764426L;

    public MaxLineLimitException(String str) {
        super(str);
    }
}
