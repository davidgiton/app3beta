package com.barak.twitterappv3beta.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barak.twitterappv3beta.R

class MyActivityFragment : TwitterFragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_activity, container, false)
    }
    override fun updateList() {

    }
}