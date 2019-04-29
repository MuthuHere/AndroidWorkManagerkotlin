# AndroidWorkManagerkotlin

With WorkManager, you can easily set up a task and hand it off to the system to run under the conditions you specify


``` implementation 'android.arch.work:work-runtime:1.0.0-alpha01' ```

## MainActivity.kt

here your MainActivity to setup work Manager
```

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
```

## UploadBackgroundWork.kt

```

class UploadBackgroundWork : Worker() {

    override fun doWork(): WorkerResult {


        d("upload called ", "upload triggered successfully")

        return WorkerResult.SUCCESS
    }
}
```
