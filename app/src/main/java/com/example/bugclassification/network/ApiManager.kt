package com.example.bugclassification.network

import android.content.Context
import android.net.Uri
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class ApiManager {
    suspend fun uploadImage(context: Context, imageUri: Uri): Pair<String?, Int?> =
        withContext(Dispatchers.IO) {
            // navDeepLink
            val url = "http://192.168.1.53:5000/predict"
            val client = OkHttpClient()
            val inputStream = context.contentResolver.openInputStream(imageUri)
            val file = createFileFromInputStream(inputStream)

            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(
                    "img",
                    "img.jpg",
                    RequestBody.create("img/*".toMediaTypeOrNull(), file)
                )
                .build()

            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

            var predictedClass: String? = null
            var confidence: Int? = null

            try {
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    // Image uploaded successfully
                    val responseBody = response.body?.string()

                    val jsonObject = JSONObject(responseBody)
                    // Extract values from JSON
                    predictedClass = jsonObject.getString("predicted_class")
                    confidence = jsonObject.getInt("confidence")


                    Log.d("성공함", "이미지가 올라갔다? Respones : ${responseBody ?: "no data"}")
                } else {
                    Log.e("망함", "망함")
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return@withContext Pair(predictedClass, confidence)
        }

    fun createFileFromInputStream(inputStream: InputStream?): File {
        val file = File.createTempFile("temp", null)
        inputStream?.use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }
        return file
    }
}