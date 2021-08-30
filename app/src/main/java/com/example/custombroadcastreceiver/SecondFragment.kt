package com.example.custombroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag_second.*


class SecondFragment : Fragment() {
    private var mView : View? = null

    private var myBroadcast : BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context : Context?, intent : Intent?) {
            if(intent?.action.equals(FirstFragment.MY_ACTION)){
                var str = intent?.getStringExtra(FirstFragment.KEY_VALUE)
                tv_show_text.setText(str)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.frag_second,container,false)
        return mView
    }

    override fun onStart() {
        super.onStart()
        var intentFilter = IntentFilter(FirstFragment.MY_ACTION)
        context?.registerReceiver(myBroadcast,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        context?.unregisterReceiver(myBroadcast)
    }
}