import info.lotharschulz.chessknights.ChessKnight
import info.lotharschulz.chessknights.Node
import info.lotharschulz.chessknights.convertChessColumnChar2Coordinate
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class ChessKnightTest {
    private val ck = ChessKnight()

    @Test
    fun convertChessColumnChar2Coordinate(){
        assertEquals (4, convertChessColumnChar2Coordinate('D'))
        assertEquals (1, convertChessColumnChar2Coordinate('A'))
        assertEquals (8, convertChessColumnChar2Coordinate('H'))
        assertEquals (7, convertChessColumnChar2Coordinate('G'))
        assertEquals (9, convertChessColumnChar2Coordinate('I'))
    }

    @Test
    fun validMove() {
        assertTrue(ck.validMove(3,3,8))
    }

    @Test
    fun inValidMoveStepBiggerThanBoardSize() {
        assertFalse(ck.validMove(3,3,2))
    }

    @Test
    fun inValidMoveXsmallerThanZero() {
        assertFalse(ck.validMove(-1,3,8))
    }

    @Test
    fun inValidMoveYsmallerThanZero() {
        assertFalse(ck.validMove(3,-1,8))
    }

    @Test
    fun shortestPathListDigitNodes(){
        assertEquals (listOf(Node(7,7), Node(5,6), Node(4,4)),
                      ck.shortestPathList(Node(4,4), Node(7, 7), 8))
    }

    @Test
    fun shortestPathListChessCoordinates1(){
        assertEquals (listOf(Node("G7"), Node("E6"), Node("D4")),
                      ck.shortestPathList(Node("D4"), Node("G7"), 8))
    }

    @Test
    fun shortestPathListChessCoordinates2(){
        assertEquals (listOf(Node("D5"), Node("B4"), Node("C6"), Node("D4")),
                      ck.shortestPathList(Node("D4"), Node("D5"), 8))
    }

    @Test
    fun shortestPathListChessCoordinates3(){
        assertEquals (listOf(Node("C7"), Node("E6"), Node("D4")),
                      ck.shortestPathList(Node("D4"), Node("C7"), 8))
    }

    @Test
    fun shortestPathListForSameDigitNodes(){
        assertEquals (listOf(Node(7,7)),
                      ck.shortestPathList(Node(7,7), Node(7, 7), 8))
    }

    @Test
    fun shortestPathListForSameChessNodes(){
        assertEquals (listOf(Node("G7")),
                      ck.shortestPathList(Node("G7"), Node("G7"), 8))
    }

    @Test
    fun stringifyShortestPathList(){
        assertEquals ("one of potentially multiple shortest paths: C4 A2",
                      ck.stringifyShortestPathList(listOf(Node(1,2), Node(3, 4))))
    }

}