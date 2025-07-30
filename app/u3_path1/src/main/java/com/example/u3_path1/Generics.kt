package com.example.u3_path1

class FillInTheBlankQuestion(val questionText: String, val answer: String, difficulty: String) {}

class TrueOrFalseQuestion(val questionText: String, val answer: Boolean, val difficulty: String) {}

class NumericQuestion(val questionText: String, val answer: Int, val difficulty: String) {}

/* using Generics */
// class Question<T>(val questionText: String, val answer: T, val difficulty: String){}
//
// fun main() {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", "medium")
//    val question02 = Question<Boolean>("The sky is green. True or False", false, "easy")
//    val question03 = Question<Int>("How many days are there between full moons?", 28, "hard")
//}

/* using Enums */ // enum class Difficulty{ EASY, MEDIUM, HARD }
//
// class Question<T>(val questionText: String, val answer: T, val difficulty: Difficulty){}
//
// fun main() {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//    println(question01.toString())
//}

/* using Data Class */
enum class Difficulty { EASY, MEDIUM, HARD }

data class Question<T>(val questionText: String, val answer: T, val difficulty: Difficulty) {}

// fun main() {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//    println(question01.toString())
//}

/* Singleton Objects */
// object StudentProgress {
//    var total: Int = 10
//    var answered: Int = 3
//}
//
// fun main() {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//    println(question01.toString())
//    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
//}

/* Singleton - Companion Objects */
// class Quiz {
//    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//
//    companion object StudentProgress {
//        var total: Int = 10
//        var answered: Int = 3
//    }
//}

// fun main() {
//    println("${Quiz.answered} of ${Quiz.total} answered.")
//}

/* Extension properties */
/* extension properties are 'getter-only', they do not store anything */
// val Quiz.StudentProgress.progressText: String
//    get() = "$answered of $total answered"

// fun main() {
//    println(Quiz.progressText)
//}

/* Extension functions */
// fun Quiz.StudentProgress.printProgressBar(){
////    repeat(Quiz.answered) {print('\u2593')}
//    repeat(Quiz.answered) {print('#')}
////    repeat(Quiz.total - Quiz.answered) {print('\u2591')}
//    repeat(Quiz.total - Quiz.answered) {print('_')}
//    println()
//    println(Quiz.progressText)
//}
//
// fun main() {
//    Quiz.printProgressBar()
//}

/* Interfaces */
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

// class Quiz() : ProgressPrintable {
//     override val progressText: String
//         get() = "$answered of $total answered"
//
//     val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//     val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//     val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//
//     companion object StudentProgress {
//         var total: Int = 10
//         var answered: Int = 3
//     }
//
//     override fun printProgressBar() {
//         // repeat(Quiz.answered) {print('\u2593')}
//         repeat(Quiz.answered) { print('#') }
//         // repeat(Quiz.total - Quiz.answered) {print('\u2591')}
//         repeat(Quiz.total - Quiz.answered) { print('*') }
//         println()
//         println(progressText)
//     }
// }

// fun main() {
//     Quiz().printProgressBar()
// }

/* Scope Functions */
// class Quiz() : ProgressPrintable {
//     override val progressText: String
//         get() = "$answered of $total answered"
//
//     val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//     val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
//     val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//
//     companion object StudentProgress {
//         var total: Int = 10
//         var answered: Int = 3
//     }
//
//     override fun printProgressBar() {
//         // repeat(Quiz.answered) {print('\u2593')}
//         repeat(Quiz.answered) { print('#') }
//         // repeat(Quiz.total - Quiz.answered) {print('\u2591')}
//         repeat(Quiz.total - Quiz.answered) { print('*') }
//         println()
//         println(progressText)
//     }
//
//     fun printQuiz() {
//         println(question01.questionText)
//         println(question01.answer)
//         println(question01.difficulty)
//         println()
//         println(question02.questionText)
//         println(question02.answer)
//         println(question02.difficulty)
//         println()
//         println(question03.questionText)
//         println(question03.answer)
//         println(question03.difficulty)
//         println()
//
//     }
// }

/* using let() */
class Quiz() : ProgressPrintable {
    override val progressText: String
        get() = "$answered of $total answered"

    val question01 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question02 = Question<Boolean>("The sky is green. True or False", false, Difficulty.EASY)
    val question03 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override fun printProgressBar() {
        // repeat(Quiz.answered) {print('\u2593')}
        repeat(Quiz.answered) { print('#') }
        // repeat(Quiz.total - Quiz.answered) {print('\u2591')}
        repeat(Quiz.total - Quiz.answered) { print('*') }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question01.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question02.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question03.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

// fun main() {
//     val quiz = Quiz()
//     quiz.printQuiz()
// }

/* using apply() */
// fun main() {
//     val quiz = Quiz().apply { printQuiz() }
// }

/* using apply() more concisely */
fun main() {
    Quiz().apply { printQuiz() }
}