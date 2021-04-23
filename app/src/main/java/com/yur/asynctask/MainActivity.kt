package com.yur.asynctask

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.coroutines.*
import java.lang.Runnable
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
     var progressBar : ProgressBar =  findViewById(R.id.progressBar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        progressBar = findViewById(R.id.progressBar)
        val button  = findViewById<Button>(R.id.button)
        val image  = findViewById<ImageView>(R.id.image)
        val newScope = CoroutineScope(Dispatchers.Main)









//    button.setOnClickListener {
//        Thread.sleep(1000)
//        Toast.makeText(this, "finished", Toast.LENGTH_SHORT).show()
//    }

        val tg = ThreadGroup("new Group")
        val thread = Thread(tg, object: Runnable {
            override fun run() {
                progressBar.visibility = View.GONE
                progressBar.layoutParams.height = 20
                button.performClick()

                Log.d("lalala", "current Thread is: ${Thread.currentThread()}")
                //prints D/lalala: current Thread is: Thread[Thread-8,5,new Group]
                image.setImageResource(R.drawable.ic_launcher_background)
            }
        })

        thread.start()
//
//
//        newScope.launch(Dispatchers.Default) {
//            Log.d("asyncTest", "onPreExecute  ${Thread.currentThread()}")
//            var input = 15
//
//            withContext(Dispatchers.IO) {
//                while (input <= 100) {
//
//                    progressBar.visibility = View.GONE
//                    progressBar.layoutParams.height = 20
//                    image.setImageResource(R.drawable.ic_launcher_background)
//
//                    button.performClick()
//                    delay(1000)
//                    Log.d("asyncTest", "inside iteration, ${Thread.currentThread()}")
//                    input += 10
//
//                    withContext(Dispatchers.Main) {
//                        updateProgress(input)
//                    }
//                }
//            }
//        }
////
//        newScope.launch {
//            Log.d("asyncTest", "another cooroutine")
//
//        }
//

//        val myAsync = MyAsync(this)
//        myAsync.execute(15)


    }

    override fun onResume() {
        super.onResume()


//        val async1 = GlobalScope.async (Dispatchers.Default) {
////            doSomeWork1()
//        }
//
//        val async2 = GlobalScope.async (Dispatchers.Default) {
////            doSomeWork2()
//        }

//        GlobalScope.launch {
//            Log.d("asyncTest", "starting")
//            Log.d("asyncTest", "first: ${async1.await()}  second:${async2.await()}")
//        }



//        runBlocking {
//            Log.d("asyncTest", " inside second cooroutine")
//            delay(10000)
//        }
//
//        Log.d("asyncTest", "after coroutine")



    }


    suspend fun doSomeWork1(unit: Long): Any {
        delay(3000)

        val a  : String?  = "null"

        if (a  == null) {
            a?.plus("jk")
        }
        return 0
    }

    suspend fun doSomeWork2( ): Int{
        delay(5000)
        return 5
    }


    fun updateProgress(progress: Int) {
        progressBar.progress = progress
        progressBar.visibility = View.GONE
    }


}