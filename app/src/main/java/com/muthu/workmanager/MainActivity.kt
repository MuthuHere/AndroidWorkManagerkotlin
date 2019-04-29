package com.muthu.workmanager

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.util.Log.d
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //init Work load
        val uploadWorkRequest = OneTimeWorkRequest.Builder(UploadBackgroundWork::class.java).build()

        //use request
        val workManager = WorkManager.getInstance()
        workManager.enqueue(uploadWorkRequest)

        //using work manager can check the status
        workManager.getStatusById(uploadWorkRequest.id).observe(this, Observer {

            if (it != null) {
                d("TAG_MAIN_STATUS", "State of your work is ${it.state.isFinished}")
            }

        })


    }

}
