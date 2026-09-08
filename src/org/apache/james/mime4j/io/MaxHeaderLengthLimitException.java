package org.apache.james.mime4j.io;

import org.apache.james.mime4j.MimeException;

/* loaded from: classes4.dex */
public class MaxHeaderLengthLimitException extends MimeException {
    private static final long serialVersionUID = 8924290744274769913L;

    public MaxHeaderLengthLimitException(String str) {
        super(str);
    }
}
