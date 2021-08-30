package com.example.custombroadcastreceiver

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag_first.*


class FirstFragment : Fragment() {
    companion object{
         val KEY_VALUE: String? = "KEY_VALUE"
         val MY_ACTION: String? = "MY_ACTION"
    }

    private var mView : View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.frag_first,container,false)
        initView()
        return mView
    }

    private fun initView() {
        var btClick = mView!!.findViewById<Button>(R.id.bt_click)
        btClick.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var str : String = edt_text.text.toString()
                var intent = Intent(MY_ACTION)
                intent.putExtra(KEY_VALUE,str)

                context?.sendBroadcast(intent)
            }

        })
    }
}