package com.barak.twitterappv3beta.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.barak.twitterappv3beta.adapters.TweetListAdapter
import com.barak.twitterappv3beta.listeners.HomeCallback
import com.barak.twitterappv3beta.listeners.TweeterListenerImpo
import com.barak.twitterappv3beta.util.TweetListener
import com.barak.twitterappv3beta.util.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

abstract class TwitterFragment : Fragment() {

    protected var tweetsAdapter: TweetListAdapter? = null
    protected var currentUser: User? = null
    protected val firebaseDB = FirebaseFirestore.getInstance()
    protected val userId = FirebaseAuth.getInstance().currentUser?.uid
    protected var listener: TweeterListenerImpo? = null
    protected var callback: HomeCallback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is HomeCallback) {
            callback = context
        } else {
            throw RuntimeException(context.toString() + " must implement HomeCallback")
        }
    }

    fun setUser(user: User?) {
        this.currentUser = user
        listener?.user = user
    }

    abstract fun updateList()

    override fun onResume() {
        super.onResume()
        updateList()
    }
}