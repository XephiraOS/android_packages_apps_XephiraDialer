package org.apache.james.mime4j.field.datetime.parser;

/* loaded from: classes4.dex */
public class TokenMgrError extends Error {
    private static final long serialVersionUID = 1;
    int errorCode;

    public TokenMgrError(String str, int i10) {
        super(str);
        this.errorCode = i10;
    }

    public static String a(boolean z10, int i10, int i11, int i12, String str, char c10) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Lexical error at line ");
        sb.append(i11);
        sb.append(", column ");
        sb.append(i12);
        sb.append(".  Encountered: ");
        if (z10) {
            str2 = "<EOF> ";
        } else {
            str2 = "\"" + b(String.valueOf(c10)) + "\" (" + ((int) c10) + "), ";
        }
        sb.append(str2);
        sb.append("after : \"");
        sb.append(b(str));
        sb.append("\"");
        return sb.toString();
    }

    public static final String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != 0) {
                if (charAt != '\"') {
                    if (charAt != '\'') {
                        if (charAt != '\\') {
                            if (charAt != '\f') {
                                if (charAt != '\r') {
                                    switch (charAt) {
                                        case '\b':
                                            stringBuffer.append("\\b");
                                            break;
                                        case '\t':
                                            stringBuffer.append("\\t");
                                            break;
                                        case '\n':
                                            stringBuffer.append("\\n");
                                            break;
                                        default:
                                            char charAt2 = str.charAt(i10);
                                            if (charAt2 >= ' ' && charAt2 <= '~') {
                                                stringBuffer.append(charAt2);
                                                break;
                                            } else {
                                                String str2 = "0000" + Integer.toString(charAt2, 16);
                                                stringBuffer.append("\\u" + str2.substring(str2.length() - 4, str2.length()));
                                                break;
                                            }
                                    }
                                } else {
                                    stringBuffer.append("\\r");
                                }
                            } else {
                                stringBuffer.append("\\f");
                            }
                        } else {
                            stringBuffer.append("\\\\");
                        }
                    } else {
                        stringBuffer.append("\\'");
                    }
                } else {
                    stringBuffer.append("\\\"");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public TokenMgrError(boolean z10, int i10, int i11, int i12, String str, char c10, int i13) {
        this(a(z10, i10, i11, i12, str, c10), i13);
    }
}
