package com.example.u3_path1

class FillInTheBlankQuestion(val questionText: String, val answer: String, difficulty: String) {}

class TrueOrFalseQuestion(val questionText: String, val answer: Boolean, val difficulty: String) {}

class NumericQuestion(val questionText: String, val answer: Int, val difficulty: String) {}

/* using Generics */
//class Question<T>(val questionText: String, val answer: T, val difficulty: String){}
//
//fun main() {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", "medium")
//    val question02 = Question<Boolean>("The sky is green. True or False", false, "easy")
//    val question03 = Question<Int>("How many days are there between full moons?", 28, "hard")
//}

/* using Enums */
//enum class Difficulty{ EASY, MEDIUM, HARD }
//
//class Question<T>(val questionText: String, val answer: T, val difficulty: Difficulty){}
//
//fun main() {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//    println(question01.toString())
//}

/* using Data Class */
enum class Difficulty{ EASY, MEDIUM, HARD }

data class Question<T>(val questionText: String, val answer: T, val difficulty: Difficulty){}

fun main() {
    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println(question01.toString())
}

/* TODO: step 5 - Use a Singleton Object */
// https://developer.android.com/codelabs/basic-android-kotlin-compose-generics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-generics
