package com.example.bugclassification.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users") // 기본 tableName은 클래스 이름
data class Bug(
    @PrimaryKey val bugType: String, // 종, 참고 autoGenerate 쓰면 자동 생성
    @ColumnInfo(name = "Bug_information") val bugInfo: String, // 정보
    @ColumnInfo(name = "Bug_Habitat") val bugHab: String, // 서식지
    @ColumnInfo(name = "Bug_prevention") val bugPrev: String, // 예방 방법
    @ColumnInfo(name = "Bug_extermination") val bugExt: String, // 퇴치 방법
)