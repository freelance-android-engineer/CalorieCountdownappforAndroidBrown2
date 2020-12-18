package ese.com.caloriecountdownappforandroidbrown;

import android.database.Cursor;
import android.database.CursorWrapper;

/**
 * Created by lokeke on 04/05/2016.
 */
public class BreakfastCursor extends CursorWrapper {

//A Convenience clas to wrap a cursor that returns rows for the "food items" table.
    //The {@ link getFoods()} method will give you a Food_Item instance representing the current row.

    private static final String TABLE_BREAKFAST_TIME = "breakfast_time";
    private static final String COLUMUM_BREAKFAST_TIME_ID = "breakfast_time_id";
    private static final String COLUMUM_BREAKFAST_TIME_BREAKFASTTIME = "breakfast_time";


    public BreakfastCursor(Cursor c)
    {
        super(c);
    }

    public String getBreakfast()
    {


        if(isBeforeFirst() || isAfterLast())return "0";



        return new RoundingCIF13().IntToString(getInt(getColumnIndex(COLUMUM_BREAKFAST_TIME_BREAKFASTTIME)));


    }
}
