package com.yur.asynctask

import android.app.Activity
import android.os.AsyncTask
import android.util.Log

class MyAsync(val activity: MainActivity): AsyncTask<Int, Int, String>() {


    override fun onPreExecute() {
        Log.d("asyncTest", "onPreExecute called ${Thread.currentThread()}")
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Int?): String {
        Log.d("asyncTest", "doing in background ${Thread.currentThread()}")
        var input = 0
        if (params.size > 0) {
            input = params.get(0) ?: 0


            while (input != 100) {
                Thread.sleep(1000)
                Log.d("asyncTest", "inside iteration, $input")
                input += 10
                publishProgress(input)
            }
        }

        return input.toString()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        Log.d("asyncTest", "OnPostExecute called: $result   ${Thread.currentThread()}")
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)

        activity.updateProgress(values.get(0) ?: 0)

        Log.d("asyncTest", "onProgressUpdate called  ${Thread.currentThread()}")
    }
}