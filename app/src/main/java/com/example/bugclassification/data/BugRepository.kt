package com.example.bugclassification.data

class BugRepository(private val bugInfoDao: BugInfoDao, private val inferenceInfoDao: InferenceInfoDao) {

    suspend fun getBugInfoByType(bugType: String): Bug? {
        return bugInfoDao.getBugInfoByType(bugType)
    }

    suspend fun insertInferenceInfo(inference: Inference) {
        inferenceInfoDao.insertInferenceInfo(inference)
    }

    suspend fun getInferenceInfoByBugType(bugType: String): Inference? {
        return inferenceInfoDao.getInferenceInfoByBugType(bugType)
    }
}