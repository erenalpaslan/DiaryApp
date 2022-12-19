package com.easylife.diary.utils.helper.share

import android.app.Activity
import android.content.Intent
import android.net.Uri

/**
 * Created by erenalpaslan on 8.09.2022
 */
object ShareAppHelper {

    fun openShareApp(activity: Activity) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.easylife.diary")
            putExtra(Intent.EXTRA_SUBJECT, "Daily Diary: Lock and note")
            putExtra(Intent.EXTRA_TITLE, Uri.parse("https://play.google.com/store/apps/details?id=com.easylife.diary"))
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            type = "text/*"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        activity.startActivity(shareIntent)
    }

}