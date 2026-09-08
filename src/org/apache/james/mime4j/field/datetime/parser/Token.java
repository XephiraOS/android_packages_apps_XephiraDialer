package org.apache.james.mime4j.field.datetime.parser;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class Token implements Serializable {
    private static final long serialVersionUID = 1;
    public int beginColumn;
    public int beginLine;
    public int endColumn;
    public int endLine;
    public String image;
    public int kind;
    public Token next;
    public Token specialToken;

    public Token() {
    }

    public static Token a(int i10, String str) {
        return new Token(i10, str);
    }

    public String toString() {
        return this.image;
    }

    public Token(int i10, String str) {
        this.kind = i10;
        this.image = str;
    }
}
