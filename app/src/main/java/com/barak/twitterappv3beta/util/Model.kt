package com.barak.twitterappv3beta.util

data class User(
    val email: String? = "",
    val username: String? = "",
    val imageUrl : String? = "",
    val followHashtags: ArrayList<String>? = arrayListOf(),
    val forllowusers: ArrayList<String>? = arrayListOf()

)

data class Tweet(
    val tweetId: String? = "",
    val userIds: ArrayList<String>? = arrayListOf(),
    val username: String? = "",
    val text: String? = "",
    val imageUrl: String? = "",
    val timestamp: Long? = 0,
    val hashtags: ArrayList<String>? = arrayListOf(),
    val likes: ArrayList<String>? = arrayListOf()
)

interface TweetListener {
    fun onLayoutClick(tweet: Tweet?)
    fun onLike(tweet: Tweet?)
    fun onRetweet(tweet: Tweet?)
}