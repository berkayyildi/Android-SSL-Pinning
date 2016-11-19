/*
Update SharedPreferences_example.java
SharedPreferences values will persist across user sessions.
Data in shared preferences will be persistent even though user closes the application.
Available mode for shared preference:

   1. MODE_WORLD_READABLE
   2. MODE_WORLD_WRITEABLE
   3. MODE_PRIVATE
*/

/******* Create SharedPreferences *******/
 
    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE); 
    Editor editor = pref.edit();
 
 
/**************** Storing data as KEY/VALUE pair *******************/
 
    editor.putBoolean("key_name1", true);           // Saving boolean - true/false
    editor.putInt("key_name2", "int value");        // Saving integer
    editor.putFloat("key_name3", "float value");    // Saving float
    editor.putLong("key_name4", "long value");      // Saving long
    editor.putString("key_name5", "string value");  // Saving string
     
    // Save the changes in SharedPreferences
    editor.commit(); // commit changes
 
 
/**************** Get SharedPreferences data *******************/
 
// If value for key not exist then return second param value - In this case null
 
    pref.getBoolean("key_name1", null);         // getting boolean
    pref.getInt("key_name2", null);             // getting Integer
    pref.getFloat("key_name3", null);           // getting Float
    pref.getLong("key_name4", null);            // getting Long
    pref.getString("key_name5", null);          // getting String
 
 
 
 
/************ Deleting Key value from SharedPreferences *****************/
 
    editor.remove("key_name3"); // will delete key key_name3
    editor.remove("key_name4"); // will delete key key_name4
     
    // Save the changes in SharedPreferences
    editor.commit(); // commit changes
    
/************ Clear all data from SharedPreferences *****************/  
 
     editor.clear();
     editor.commit(); // commit changes
