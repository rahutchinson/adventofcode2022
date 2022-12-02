/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package day2

import java.io.File

class RockPaperScissors {

    fun play(playerOneInput: String, playerTwoInput: String): String? {
        val (winner, loser) = getWinnerLoserCombination(playerOneInput, playerTwoInput)
        return winnerMessage(winner, loser)
    }

    private fun isATie(winner: String, loser: String): Boolean {
        return winner == loser
    }

    private fun getWinnerLoserCombination(playerOneInput: String, playerTwoInput: String): Pair<String, String> {
        return if (isPlayerOneWInner(playerOneInput, playerTwoInput))
            Pair(playerOneInput, playerTwoInput)
        else
            Pair(playerTwoInput, playerOneInput)
    }

    private fun isPlayerOneWInner(playerOneInput: String, playerTwoInput: String): Boolean {
        return (playerOneInput == "A" && playerTwoInput == "Z") ||
                (playerOneInput == "B" && playerTwoInput == "X") ||
                (playerOneInput == "C" && playerTwoInput == "Y")
    }

    private fun winnerMessage(winner: String, loser: String) =
            if (isATie(winner, loser))
                "tie"
            else getWinningDisplayMessage(winner, loser)

    private fun getWinningDisplayMessage(winner: String, loser: String) = "$winner beats $loser"
}

fun inputFromAdvent(fileName: String): List<String> {
	return File(fileName).useLines { it.toList() }
}

fun scoreRound(input: String) {
	var words = input.split("\\s".toRegex())
	words = words.map { it -> it.trim() }
	println(words)
}

fun main() {
    val input = inputFromAdvent("input.txt")
    input.forEach { it -> scoreRound(it) }
    println(input)
}
