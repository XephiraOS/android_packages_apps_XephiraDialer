package com.oua.util;

import android.content.Context;
import android.util.Log;
import com.oua.util.OUAFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* loaded from: classes4.dex */
public class OUAFile {
    private static final int SUB_VERSION = 0;
    private static final String TAG = "com.oua.util.OUAFile";
    private static final int VERSION = 1;
    private Header header;
    private int headerOffset;
    private String ouaFilePath;
    private Version ouaVersoin;
    private String password;

    /* renamed from: com.oua.util.OUAFile$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$oua$util$OUAFile$FileType;

        static {
            int[] iArr = new int[FileType.values().length];
            $SwitchMap$com$oua$util$OUAFile$FileType = iArr;
            try {
                iArr[FileType.Model.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$oua$util$OUAFile$FileType[FileType.Txt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class FileEntry {
        public FileType fileType;
        public String name;
        public int position;
        public int size;

        public FileEntry(String str, FileType fileType) {
            this.name = str;
            this.fileType = fileType;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FileEntry m10clone() {
            FileEntry fileEntry = new FileEntry(this.name, this.fileType);
            fileEntry.position = this.position;
            fileEntry.size = this.size;
            return fileEntry;
        }
    }

    /* loaded from: classes4.dex */
    public enum FileType {
        Model,
        Txt
    }

    /* loaded from: classes4.dex */
    public static class Header {
        public List<FileEntry> entryList;
        public Version packageVersion = new Version(0, 1);
        public String tags = "";
        public long timestamp;
        public String timestampStr;

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Header m11clone() {
            Header header = new Header();
            header.packageVersion = this.packageVersion;
            header.timestamp = this.timestamp;
            header.timestampStr = this.timestampStr;
            header.tags = this.tags;
            header.entryList = (List) this.entryList.stream().map(new Function() { // from class: com.oua.util.x
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    OUAFile.FileEntry m10clone;
                    m10clone = ((OUAFile.FileEntry) obj).m10clone();
                    return m10clone;
                }
            }).collect(Collectors.toList());
            return header;
        }
    }

    /* loaded from: classes4.dex */
    public static class Version {
        int sub_version;
        int version;

        public Version(int i10, int i11) {
            this.version = i10;
            this.sub_version = i11;
        }
    }

    public OUAFile(String str, Context context, String str2) {
        this.headerOffset = 0;
        PositionInputStream openFile = FileUtil.openFile(str, context);
        try {
            this.ouaVersoin = checkVersoin(openFile);
            this.header = loadHeaders(openFile);
            DebugConfig.logv(TAG, str + " header: ", this.header);
            this.headerOffset = (int) openFile.getPosition();
            this.password = str2;
            this.ouaFilePath = str;
            openFile.close();
        } catch (Throwable th) {
            if (openFile != null) {
                try {
                    openFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static Version checkVersoin(PositionInputStream positionInputStream) {
        Version version = (Version) IOStreamUtil.readObject((InputStream) positionInputStream, Version.class);
        if (version.version <= 1) {
            return version;
        }
        throw new Exception(String.format("Not supported version %d.%d vs %d, %d", Integer.valueOf(version.version), Integer.valueOf(version.sub_version), 1, 0));
    }

    public static void decryptAll(String str, String str2, Context context, String str3) {
        SimpleTrace trace = SimpleTrace.getTrace();
        String str4 = TAG;
        trace.startSection("decryptAll", str4);
        OUAFile oUAFile = new OUAFile(str, context, str3);
        DebugConfig.logd(str4, "file header:" + StringUtil.toString(oUAFile.getHeader()));
        SimpleTrace.getTrace().addEvent("load_header");
        for (FileEntry fileEntry : oUAFile.getHeader().entryList) {
            int i10 = AnonymousClass1.$SwitchMap$com$oua$util$OUAFile$FileType[fileEntry.fileType.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    FileUtil.toFile(str2 + "/" + fileEntry.name, file2String(str, fileEntry.name, context, str3));
                }
            } else {
                FileChannel channel = new FileOutputStream(str2 + "/" + fileEntry.name).getChannel();
                try {
                    channel.write(file2DirectBuffer(str, fileEntry.name, context, str3));
                    channel.close();
                } catch (Throwable th) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            SimpleTrace.getTrace().addEvent(fileEntry.name);
        }
        SimpleTrace.getTrace().endSection("decryptAll");
    }

    public static void encrypt(Header header, String str, Context context, String str2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            try {
                int i10 = 0;
                for (FileEntry fileEntry : header.entryList) {
                    fileEntry.position = i10;
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(FileUtil.openFile(fileEntry.name, context));
                    byte[] bArr = new byte[16];
                    new SecureRandom().nextBytes(bArr);
                    int encrypt = OUAFileCipher.encrypt(bufferedInputStream, byteArrayOutputStream, str2, bArr);
                    fileEntry.size = encrypt;
                    i10 += encrypt;
                    String str3 = TAG;
                    DebugConfig.logd(str3, String.format("pos %d, %d", Integer.valueOf(i10), Integer.valueOf(byteArrayOutputStream.size())));
                    bufferedInputStream.close();
                    DebugConfig.logd(str3, "encrypted " + StringUtil.toString(fileEntry));
                }
                header.entryList.forEach(new Consumer() { // from class: com.oua.util.w
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        OUAFile.lambda$encrypt$0((OUAFile.FileEntry) obj);
                    }
                });
                header.timestamp = System.currentTimeMillis();
                header.timestampStr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(header.timestamp));
                writeHeader(bufferedOutputStream, header);
                bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
                DebugConfig.logd(TAG, str + " created!");
                bufferedOutputStream.close();
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static ByteBuffer file2DirectBuffer(String str, String str2, Context context, String str3) {
        DebugConfig.logd(TAG, "load " + str2);
        return new OUAFile(str, context, str3).load2DirectBuffer(str2, context);
    }

    public static String file2String(String str, String str2, Context context, String str3) {
        DebugConfig.logd(TAG, "load " + str2);
        return new OUAFile(str, context, str3).load2String(str2, context);
    }

    private FileEntry findEntry(String str) {
        for (FileEntry fileEntry : this.header.entryList) {
            if (fileEntry.name.equals(str)) {
                return fileEntry;
            }
        }
        Log.e(TAG, String.format("cannot find %s in %s", this.ouaFilePath, str));
        throw new IOException(String.format("cannot find %s in %s", this.ouaFilePath, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$encrypt$0(FileEntry fileEntry) {
        fileEntry.name = FileUtil.getFileName(fileEntry.name);
    }

    private static Header loadHeaders(PositionInputStream positionInputStream) {
        return (Header) IOStreamUtil.readObject((InputStream) positionInputStream, Header.class);
    }

    private PositionInputStream seek2Entry(String str, Context context) {
        FileEntry findEntry = findEntry(str);
        PositionInputStream openFile = FileUtil.openFile(this.ouaFilePath, context);
        openFile.skip(this.headerOffset + findEntry.position);
        return openFile;
    }

    private static int writeHeader(OutputStream outputStream, Header header) {
        Version version = new Version(1, 0);
        String str = TAG;
        DebugConfig.logd(str, "write Version " + StringUtil.toString(version));
        DebugConfig.logd(str, "write Header " + StringUtil.toString(header));
        return IOStreamUtil.writeObject(outputStream, version) + IOStreamUtil.writeObject(outputStream, header);
    }

    public String getFilePath() {
        return this.ouaFilePath;
    }

    public Header getHeader() {
        return this.header;
    }

    public Version getVersion() {
        return this.ouaVersoin;
    }

    public ByteBuffer load2DirectBuffer(String str, Context context) {
        PositionInputStream seek2Entry = seek2Entry(str, context);
        try {
            ByteBuffer decrypt2DirectBuffer = OUAFileCipher.decrypt2DirectBuffer(seek2Entry, this.password);
            if (seek2Entry != null) {
                seek2Entry.close();
            }
            return decrypt2DirectBuffer;
        } catch (Throwable th) {
            if (seek2Entry != null) {
                try {
                    seek2Entry.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String load2String(String str, Context context) {
        PositionInputStream seek2Entry = seek2Entry(str, context);
        try {
            String decrypt2String = OUAFileCipher.decrypt2String(seek2Entry, this.password);
            if (seek2Entry != null) {
                seek2Entry.close();
            }
            return decrypt2String;
        } catch (Throwable th) {
            if (seek2Entry != null) {
                try {
                    seek2Entry.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
