package bill.lesson3hw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DHZ_Bill on 9/28/16.
 * DatabaseHelper Class
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "ToDo.db";
    public static final String TABLE_NAME = "toDo_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TODO";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    // create the database table
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TODO TEXT)");
    }
    // upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // insert new data into database
    public long insertData(String toDo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, toDo);
        long result = db.insert(TABLE_NAME, null, contentValues); // You can just return db.insert(... You dont need result variable
        return result;
    }
    // change a ToDoItem in the database
    public boolean updateData(ToDoItem toDoItem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, toDoItem.getId());
        contentValues.put(COL_2, toDoItem.getToDo());
        db.update(TABLE_NAME, contentValues, "ID="+toDoItem.getId(), null);
        return true;
    }
    // delete a ToDoItem from database
    public Integer deleteData(ToDoItem toDoItem){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID="+toDoItem.getId(), null);
    }
    // get all data stored in the database
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}
