package DataLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
    private static final String KEY_ISLIVE = "activity_islive";
    public TodoDatabase( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_ACTIVITY_TABLE = "CREATE TABLE " + TABLE_ACTIVITY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TYPE + " TEXT," + KEY_NAME + " TEXT," + KEY_DATE + " TEXT," + KEY_TIME + " TEXT,"
                + KEY_DESC + " TEXT," + KEY_ISLIVE + " BOOLEAN " +")";

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
        values.put(KEY_ISLIVE,worklistModel.getisLive());

        sqLiteDatabase.insert(TABLE_ACTIVITY ,null,values);
        sqLiteDatabase.close();

    }

    public void delectSingleEntry(WorklistModel worklistModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        if(db != null)
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

    public ArrayList<WorklistModel> getAllActivities() {
        ArrayList<WorklistModel> activityList = new ArrayList<WorklistModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ACTIVITY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                WorklistModel worklistModel = new WorklistModel();
                worklistModel.setId(cursor.getInt(0));
                worklistModel.setActivityType(cursor.getString(1));
                worklistModel.setActivityName(cursor.getString(2));
                worklistModel.setDate(cursor.getString(3));
                worklistModel.setTime(cursor.getString(4));
                worklistModel.setActivityDesc(cursor.getString(5));

                // Adding cart to list
                activityList.add(worklistModel);
            } while (cursor.moveToNext());
        }
        return activityList;
    }

    public ArrayList<WorklistModel> getAllDailyActivities(){
        ArrayList<WorklistModel> dailyActivities = new ArrayList<WorklistModel>();
        String selectQuery = "Select * FROM " + TABLE_ACTIVITY + " WHERE "+ KEY_TYPE + " = 'Daily Activity'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                WorklistModel worklistModel = new WorklistModel();
                worklistModel.setId(cursor.getInt(0));
                worklistModel.setActivityType(cursor.getString(1));
                worklistModel.setActivityName(cursor.getString(2));
                worklistModel.setDate(cursor.getString(3));
                worklistModel.setTime(cursor.getString(4));
                worklistModel.setActivityDesc(cursor.getString(5));
                if(cursor.getString(6).equals("0"))
                    worklistModel.setisLive(false);
                else if(cursor.getString(6).equals("1"))
                    worklistModel.setisLive(true);

                dailyActivities.add(worklistModel);
            } while (cursor.moveToNext());
        }
        return dailyActivities;


    }

    public ArrayList<WorklistModel> getdayActivities(String date) {
        ArrayList<WorklistModel> activityList = new ArrayList<WorklistModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ACTIVITY + " WHERE " + KEY_DATE + " = '"+ date+"' AND " + KEY_TYPE + " != 'Daily Activity'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                WorklistModel worklistModel = new WorklistModel();
                worklistModel.setId(cursor.getInt(0));
                worklistModel.setActivityType(cursor.getString(1));
                worklistModel.setActivityName(cursor.getString(2));
                worklistModel.setDate(cursor.getString(3));
                worklistModel.setTime(cursor.getString(4));
                worklistModel.setActivityDesc(cursor.getString(5));
                if(cursor.getString(6).equals("0"))
                    worklistModel.setisLive(false);
                else if(cursor.getString(6).equals("1"))
                    worklistModel.setisLive(true);
                // Adding cart to list
                activityList.add(worklistModel);
            } while (cursor.moveToNext());
        }
        return activityList;
    }

    public  int getCountofisLive (){

        String countQuery = "SELECT COUNT(*) as Count " + " FROM " + TABLE_ACTIVITY+ " WHERE " + KEY_ISLIVE + " = 1 ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.moveToFirst();
        int index= cursor.getColumnIndex("Count");
        int count = Integer.parseInt(cursor.getString(index));
        cursor.close();
        return count;
    }

    public  int getCountofisDone (){

        String countQuery = "SELECT COUNT(*) as Count " + " FROM " + TABLE_ACTIVITY+ " WHERE " + KEY_ISLIVE + " = 0 ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.moveToFirst();
        int index= cursor.getColumnIndex("Count");
        int count = Integer.parseInt(cursor.getString(index));
        cursor.close();
        return count;
    }

    public void updateTask(WorklistModel worklistModel,Boolean flag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_ISLIVE,flag);
        db.update(TABLE_ACTIVITY,cv,KEY_ID + " = ?",new String[] { String.valueOf(worklistModel.getId()) });
        db.close();
    }

}
