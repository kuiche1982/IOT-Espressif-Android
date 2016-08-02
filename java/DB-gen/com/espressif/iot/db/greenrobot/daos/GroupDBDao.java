package com.espressif.iot.db.greenrobot.daos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.espressif.iot.db.greenrobot.daos.GroupDB;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * DAO for table GROUP_DB.
 */
public class GroupDBDao extends AbstractDao<GroupDB, Long> {

    public static final String TABLENAME = "GROUP_DB";

    /**
     * Properties of entity GroupDB.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property UserKey = new Property(2, String.class, "userKey", false, "USER_KEY");
        public final static Property State = new Property(3, int.class, "state", false, "STATE");
        public final static Property Type = new Property(4, int.class, "type", false, "TYPE");
    };

    private DaoSession daoSession;

    public GroupDBDao(DaoConfig config) {
        super(config);
    }

    public GroupDBDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'GROUP_DB' (" + //
            "'_id' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
            "'NAME' TEXT NOT NULL ," + // 1: name
            "'USER_KEY' TEXT NOT NULL ," + // 2: userKey
            "'STATE' INTEGER NOT NULL ," + // 3: state
            "'TYPE' INTEGER NOT NULL );"); // 4: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GROUP_DB'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GroupDB entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getUserKey());
        stmt.bindLong(4, entity.getState());
        stmt.bindLong(5, entity.getType());
    }

    @Override
    protected void attachEntity(GroupDB entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }

    /** @inheritdoc */
    @Override
    public GroupDB readEntity(Cursor cursor, int offset) {
        GroupDB entity = new GroupDB( //
            cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getString(offset + 2), // userKey
            cursor.getInt(offset + 3), // state
            cursor.getInt(offset + 4) // type
        );
        return entity;
    }

    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GroupDB entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setUserKey(cursor.getString(offset + 2));
        entity.setState(cursor.getInt(offset + 3));
        entity.setType(cursor.getInt(offset + 4));
    }

    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GroupDB entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /** @inheritdoc */
    @Override
    public Long getKey(GroupDB entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

}
