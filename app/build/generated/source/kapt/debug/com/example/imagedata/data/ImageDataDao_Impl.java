package com.example.imagedata.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.imagedata.model.ImageDataDB;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ImageDataDao_Impl implements ImageDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ImageDataDB> __insertionAdapterOfImageDataDB;

  private final EntityDeletionOrUpdateAdapter<ImageDataDB> __deletionAdapterOfImageDataDB;

  private final EntityDeletionOrUpdateAdapter<ImageDataDB> __updateAdapterOfImageDataDB;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllImageData;

  public ImageDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfImageDataDB = new EntityInsertionAdapter<ImageDataDB>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `img_table` (`id`,`imgStr`,`imgComment`,`imgRating`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageDataDB value) {
        stmt.bindLong(1, value.getId());
        if (value.getImgStr() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImgStr());
        }
        if (value.getImgComment() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImgComment());
        }
        stmt.bindDouble(4, value.getImgRating());
      }
    };
    this.__deletionAdapterOfImageDataDB = new EntityDeletionOrUpdateAdapter<ImageDataDB>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `img_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageDataDB value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfImageDataDB = new EntityDeletionOrUpdateAdapter<ImageDataDB>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `img_table` SET `id` = ?,`imgStr` = ?,`imgComment` = ?,`imgRating` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ImageDataDB value) {
        stmt.bindLong(1, value.getId());
        if (value.getImgStr() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImgStr());
        }
        if (value.getImgComment() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImgComment());
        }
        stmt.bindDouble(4, value.getImgRating());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllImageData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM img_table";
        return _query;
      }
    };
  }

  @Override
  public void addImages(final ImageDataDB imageDataDB) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfImageDataDB.insert(imageDataDB);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteImageData(final ImageDataDB imageDataDB) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfImageDataDB.handle(imageDataDB);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateImageData(final ImageDataDB imageDataDB) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfImageDataDB.handle(imageDataDB);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllImageData() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllImageData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllImageData.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ImageDataDB>> readAllImageData() {
    final String _sql = "SELECT * FROM img_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"img_table"}, false, new Callable<List<ImageDataDB>>() {
      @Override
      public List<ImageDataDB> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfImgStr = CursorUtil.getColumnIndexOrThrow(_cursor, "imgStr");
          final int _cursorIndexOfImgComment = CursorUtil.getColumnIndexOrThrow(_cursor, "imgComment");
          final int _cursorIndexOfImgRating = CursorUtil.getColumnIndexOrThrow(_cursor, "imgRating");
          final List<ImageDataDB> _result = new ArrayList<ImageDataDB>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ImageDataDB _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpImgStr;
            _tmpImgStr = _cursor.getString(_cursorIndexOfImgStr);
            final String _tmpImgComment;
            _tmpImgComment = _cursor.getString(_cursorIndexOfImgComment);
            final float _tmpImgRating;
            _tmpImgRating = _cursor.getFloat(_cursorIndexOfImgRating);
            _item = new ImageDataDB(_tmpId,_tmpImgStr,_tmpImgComment,_tmpImgRating);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
