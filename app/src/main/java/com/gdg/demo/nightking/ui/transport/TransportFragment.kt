package com.gdg.demo.nightking.ui.transport


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gdg.demo.nightking.R


/**
 * A simple [Fragment] subclass.
 */
class TransportFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transport, container, false)
    }

}
