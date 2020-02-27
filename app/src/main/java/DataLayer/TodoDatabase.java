package DataLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import model.WorklistModel;

public class TodoDatabase extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ToDO";

    private static final String TABLE_ACTIVITY = "activity";

    private static final String KEY_ID = "activity_id";
    private static final String KEY_TYPE = "activity_type";
    private static final String KEY_NAME = "activity_name";
    private static final String KEY_DATE = "activity_date";
    private static final String KEY_TIME = "activity_time";
    private static final String KEY_DESC = "activity_description";

    public TodoDatabase(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_ACTIVITY_TABLE = "CREATE TABLE " + TABLE_ACTIVITY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TYPE + " TEXT," + KEY_NAME + " TEXT," + KEY_DATE + " TEXT," + KEY_TIME + " TEXT,"
                + KEY_DESC + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_ACTIVITY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int olderVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIVITY);
        onCreate(sqLiteDatabase);

    }

    public void addValues(WorklistModel  worklistModel) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_TYPE , worklistModel.getActivityType());
        values.put(KEY_NAME,worklistModel.getActivityName());
        values.put(KEY_DATE , worklistModel.getDate());
        values.put(KEY_TIME ,worklistModel.getTime());
        values.put(KEY_DESC ,worklistModel.getActivityDesc());

        sqLiteDatabase.insert(TABLE_ACTIVITY ,null,values);
        sqLiteDatabase.close();

    }

    public void delectSingleEntry(WorklistModel worklistModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACTIVITY, KEY_ID + " = ?",
                new String[] { String.valueOf(worklistModel.getId()) });
        db.close();
    }

    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACTIVITY, null, null);
        db.close();
    }

    public int getTableCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ACTIVITY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();

        // return count
        return cnt;
    }

    public  int getId (){

        String idQuery = "SELECT " + KEY_ID + " FROM " + TABLE_ACTIVITY+" ORDER BY "+KEY_ID+" LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(idQuery,null);
        cursor.moveToFirst();
        int index= cursor.getColumnIndex(KEY_ID);
        int id = Integer.parseInt(cursor.getString(index));
        cursor.close();
        return id;
    }

}
