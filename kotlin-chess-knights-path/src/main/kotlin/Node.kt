package info.lotharschulz.chessknights

const val CHESS_CHAR_COORDINATE_DIFFERENCE = 16
const val UPPERCASE_A = 'A' // ascii 65
const val UPPERCASE_H = 'H' // ascii 72

fun convertChessColumnChar2Coordinate(i:Char):Int =
        (i - CHESS_CHAR_COORDINATE_DIFFERENCE).toString().toInt()

data class Node constructor(val x: Int, val y: Int, val boardSize: Int = 8){

    init {
        require(x >= 0 && y >= 0 && x <= boardSize && y <= boardSize)
        {"Coordinates must be bigger than 0 and smaller or equal board size. " +
                "Nodes coordinates must be located within the chess board."}
    }

    constructor(name: String): this(
            if (name[0].toInt() in UPPERCASE_A.toInt()..UPPERCASE_H.toInt()) convertChessColumnChar2Coordinate(name[0])
            else name[0].toString().toInt(),
            name[1].toString().toInt())

    fun convertDigit2ChessColumnChar():Char =
            (x.toString().toCharArray()[0].toInt() + CHESS_CHAR_COORDINATE_DIFFERENCE).toChar()

    override fun toString(): String{
        return convertDigit2ChessColumnChar() + "$y"
    }
}