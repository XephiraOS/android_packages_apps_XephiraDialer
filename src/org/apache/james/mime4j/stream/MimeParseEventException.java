package org.apache.james.mime4j.stream;

import S9.g;
import org.apache.james.mime4j.MimeException;

/* loaded from: classes4.dex */
public class MimeParseEventException extends MimeException {
    private static final long serialVersionUID = 4632991604246852302L;
    private final g event;

    public MimeParseEventException(g gVar) {
        super(gVar.toString());
        this.event = gVar;
    }
}
