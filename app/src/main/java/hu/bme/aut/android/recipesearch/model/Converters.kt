package hu.bme.aut.android.recipesearch.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    private fun stringToObjectList(s: String) : List<Ingredient> {
        val listType: Type = object : TypeToken<List<Ingredient>>(){}.type
        return Gson().fromJson(s, listType)
    }

    @TypeConverter
    private fun objectListToString(list: List<Ingredient>) : String {
        return Gson().toJson(list, Ingredient::class.java)
    }
}