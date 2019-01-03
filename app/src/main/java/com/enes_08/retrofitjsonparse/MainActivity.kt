package com.enes_08.retrofitjsonparse

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import com.enes_08.retrofitjsonparse.model.response.User
import com.jakewharton.rxbinding2.widget.RxTextView
import com.limonist.mykotlin.Retrofit.IJsonAPI
import com.limonist.mykotlin.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.lang.System.err
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    //

    var services: IJsonAPI? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        services = RetrofitClient.getApi("https://jsonplaceholder.typicode.com/")

        var progress = ProgressDialog(this)
        progress.setMessage("Loading...");



        services!!.getUser2()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe({ progress.show() })
            .doOnComplete({ progress.dismiss() })
            .subscribe(
                { listdata -> handleResponse(listdata) }

                , { throwable ->

                    Log.d("ERROR", throwable.message)
                    progress.dismiss()
                }


            )





        RxTextView.afterTextChangeEvents(etSearch)
            .debounce(1000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tvChangeEvent ->

                // edittext değiştiğinde bir saniye bekleyip kulanıcının yazması bittikten sonra
                // servise istek atılabilir .
                tvResult.setText(


                    "Output : " + tvChangeEvent.view()
                        .getText()
                )
            })

    }

    private fun handleResponse(list: List<User>) {

        for (item in list) {
            Log.d("RESPONSEO-SEND MSG", "***********************")

            Log.d("RESPONSEO-SEND MSG", item.email)
            Log.d("RESPONSEO-SEND MSG", item.name)
            Log.d("RESPONSEO-SEND MSG", item.phone)
            Log.d("RESPONSEO-SEND MSG", item.username)
            Log.d("RESPONSEO-SEND MSG", item.website)
            Log.d("RESPONSEO-SEND MSG", "----------------------------")

            Log.d("RESPONSEO-SEND MSG", item.address!!.city)
            Log.d("RESPONSEO-SEND MSG", item.address!!.street)
            Log.d("RESPONSEO-SEND MSG", item.address!!.suite)
            Log.d("RESPONSEO-SEND MSG", item.address!!.zipcode)
            Log.d("RESPONSEO-SEND MSG", "----------------------------")

            Log.d("RESPONSEO-SEND MSG", item.company!!.name)
            Log.d("RESPONSEO-SEND MSG", item.company!!.bs)
            Log.d("RESPONSEO-SEND MSG", item.company!!.catchPhrase)

            Log.d("RESPONSEO-SEND MSG", "----------------------------")

            Log.d("RESPONSEO-SEND MSG", item.address!!.geo!!.lat)
            Log.d("RESPONSEO-SEND MSG", item.address!!.geo!!.lng)





            Log.d("RESPONSEO-SEND MSG", "***********************")


        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
