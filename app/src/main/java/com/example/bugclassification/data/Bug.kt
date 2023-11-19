package com.example.bugclassification.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "bug_info") // 기본 tableName 클래스 이름
data class Bug(
    @PrimaryKey val bugType: String, // 종, 참고 autoGenerate 쓰면 자동 생성
    @ColumnInfo(name = "Bug_title") val bugTitle: String = "", // 분류 - 목
    @ColumnInfo(name = "Bug_information") val bugInfo: String = "", // 정보
    @ColumnInfo(name = "Bug_Habitat") val bugHab: String = "", // 서식지
    @ColumnInfo(name = "Bug_prevention") val bugPrev: String = "", // 예방 방법
    @ColumnInfo(name = "Bug_extermination") val bugExt: String = "", // 퇴치 방법
)

@Entity(
    tableName = "inference_info",
    foreignKeys = [ForeignKey(
        entity = Bug::class,
        parentColumns = ["bugType"],
        childColumns = ["bug_type"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Inference(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "image_uri") val imageUri: String?,
    @ColumnInfo(name = "bug_type") val bugType: String?,
    @ColumnInfo(name = "accuracy") val accuracy: Int?,

)

//data class InferenceWithBugInfo(
//    @Embedded val inference: Inference,
//    @Relation(
//        parentColumn = "bugType",
//        entityColumn = "bug_type"
//    )
//    val bugInfo: Bug
//)
