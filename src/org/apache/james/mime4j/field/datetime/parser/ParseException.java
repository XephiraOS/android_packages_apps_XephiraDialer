package org.apache.james.mime4j.field.datetime.parser;

/* loaded from: classes4.dex */
public class ParseException extends org.apache.james.mime4j.dom.field.ParseException {
    private static final long serialVersionUID = 1;
    public Token currentToken;
    protected String eol;
    public int[][] expectedTokenSequences;
    protected boolean specialConstructor;
    public String[] tokenImage;

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super("");
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = true;
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    public String a(String str) {
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
        String str;
        int[] iArr;
        if (!this.specialConstructor) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[][] iArr2 = this.expectedTokenSequences;
            if (i10 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i10];
            if (i11 < iArr3.length) {
                i11 = iArr3.length;
            }
            int i12 = 0;
            while (true) {
                iArr = this.expectedTokenSequences[i10];
                if (i12 >= iArr.length) {
                    break;
                }
                stringBuffer.append(this.tokenImage[iArr[i12]]);
                stringBuffer.append(" ");
                i12++;
            }
            if (iArr[iArr.length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(this.eol);
            stringBuffer.append("    ");
            i10++;
        }
        Token token = this.currentToken.next;
        String str2 = "Encountered \"";
        int i13 = 0;
        while (true) {
            if (i13 >= i11) {
                break;
            }
            if (i13 != 0) {
                str2 = str2 + " ";
            }
            if (token.kind == 0) {
                str2 = str2 + this.tokenImage[0];
                break;
            }
            str2 = str2 + a(token.image);
            token = token.next;
            i13++;
        }
        String str3 = (str2 + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn) + "." + this.eol;
        if (this.expectedTokenSequences.length == 1) {
            str = str3 + "Was expecting:" + this.eol + "    ";
        } else {
            str = str3 + "Was expecting one of:" + this.eol + "    ";
        }
        return str + stringBuffer.toString();
    }

    public ParseException() {
        super("Cannot parse field");
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }

    public ParseException(String str) {
        super(str);
        this.eol = System.getProperty("line.separator", "\n");
        this.specialConstructor = false;
    }
}
