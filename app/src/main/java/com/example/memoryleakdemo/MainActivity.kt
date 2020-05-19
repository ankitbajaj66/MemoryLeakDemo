package com.example.memoryleakdemo

import android.content.Context
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var myAsyncTask: MyAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_run_webservice.setOnClickListener {

            myAsyncTask?.let {
                finish()
            }
            myAsyncTask = MyAsyncTask(this)
            myAsyncTask?.execute()
        }

    }

    class MyAsyncTask(private val context: Context) : AsyncTask<Void, Void, Unit>() {
        override fun doInBackground(vararg p0: Void?): Unit {
            val bitmap =
                BitmapFactory.decodeResource(context.resources, R.drawable.ic_launcher_background)

            // Sleep the Thread
            Thread.sleep(5000)
        }

    }
}
