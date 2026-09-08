package c0;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import e0.g;
import e0.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

/* compiled from: DBUtil.java */
/* loaded from: classes.dex */
public class c {
    public static void a(g gVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor b10 = gVar.b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (b10.moveToNext()) {
            try {
                arrayList.add(b10.getString(0));
            } catch (Throwable th) {
                b10.close();
                throw th;
            }
        }
        b10.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                gVar.m("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(RoomDatabase roomDatabase, j jVar, boolean z10, CancellationSignal cancellationSignal) {
        int i10;
        Cursor z11 = roomDatabase.z(jVar, cancellationSignal);
        if (z10 && (z11 instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) z11;
            int count = abstractWindowedCursor.getCount();
            if (abstractWindowedCursor.hasWindow()) {
                i10 = abstractWindowedCursor.getWindow().getNumRows();
            } else {
                i10 = count;
            }
            if (i10 < count) {
                return C0546b.a(abstractWindowedCursor);
            }
            return z11;
        }
        return z11;
    }

    public static int c(File file) {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i10 = allocate.getInt();
                channel.close();
                return i10;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th;
        }
    }
}
