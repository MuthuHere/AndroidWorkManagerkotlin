package com.muthu.workmanager

import android.util.Log.d
import androidx.work.Worker

class UploadBackgroundWork : Worker() {

    override fun doWork(): WorkerResult {


        d("upload called ", "upload triggered successfully")

        return WorkerResult.SUCCESS
    }
}