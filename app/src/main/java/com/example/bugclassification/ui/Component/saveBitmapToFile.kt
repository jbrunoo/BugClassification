package com.example.bugclassification.ui.Component

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

fun saveBitmapToFile(context: Context, bitmap: Bitmap): File? {
    // 내부 저장소에 저장하려면 context.filesDir을 사용할 수 있습니다.
    // 외부 저장소를 사용할 때는 Environment.getExternalStorageDirectory()을 사용할 수 있습니다.
    val directory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

    return try {
        val file = File(directory, "image.jpg")
        val stream: OutputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        stream.flush()
        stream.close()
        file
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}