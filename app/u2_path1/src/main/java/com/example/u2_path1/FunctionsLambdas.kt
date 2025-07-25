package com.example.u2_path1

/*fun main() {
    val trickFunction = trick()
}*/

/*fun main() {
    // function reference operator (::)
    val trickFunction = ::trick
}*/

/*fun main() {
    // function reference operator (::)
    val trickFunction = trick // lambda version

    trickFunction()
    treat()
}*/

/*fun main(){
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)

    treatFunction()
    trickFunction()
}*/

/*fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    // cupcake is not using the Int parameter, so the 'blah ->' is not needed
    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)

    treatFunction()
    trickFunction()
}*/

/*fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)

    treatFunction()
    trickFunction()
}

fun trick() {
    println("No treats!")
}*/

/*fun main() {
    // concise lambda syntax
    val coins: (Int) -> String = {
        "$it quarters"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)

    treatFunction()
    trickFunction()
}*/

/*fun main() {
    // more concise lambda syntax
    val treatFunction = trickOrTreat(false, {"$it quarters"})
    val trickFunction = trickOrTreat(true, null)

    treatFunction()
    trickFunction()
}*/

/*fun main() {
    // trailing lambda syntax
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)

    treatFunction()
    trickFunction()
}*/

fun main() {
    // trailing lambda syntax
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)

    repeat(4){
        treatFunction()
    }
    trickFunction()
}

fun trick() {
    println("No treats!")
}

/* lambda version */
val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}


fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}

/*fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}*/

/* nullable version */
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null){
            println(extraTreat(5))
        }
        return treat
    }
}