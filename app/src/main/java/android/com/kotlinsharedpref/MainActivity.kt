package android.com.kotlinsharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init view
        textview = findViewById(R.id.textview)

        //save function
        save("hello@gmail.com")

        //get function

        //set text into textview
        textview.text = getemail()
    }

    private fun save(s: String) {
        //SharedPreferences
        var sharedpref = getSharedPreferences("useremail", Context.MODE_PRIVATE)

        //SharedPreferences.Editor
        var editor = sharedpref.edit()

        editor.putString("email", s)
        //editor.putBoolean("isemail",true)
        //editor.putFloat("floatvalue",8855.44F)
        //editor.putInt("intvalue",100)
        //editor.putLong("longvalue",32423423423424L)
        editor.commit()
    }

    //return string
    private fun getemail(): String {
        return getSharedPreferences("useremail", Context.MODE_PRIVATE).getString("email", "")
    }
}
