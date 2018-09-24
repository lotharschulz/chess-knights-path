import info.lotharschulz.chessknights.Node
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NodeTest {

    @Test
    fun convertDigit2ChessColumnChar(){
        val n = Node(3,4)
        assertEquals ('C',n.convertDigit2ChessColumnChar())
        assertNotEquals('D',n.convertDigit2ChessColumnChar())
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNodeCoordinatesX(){
        Node(-1,4)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNodeCoordinatesY(){
        Node(4,-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNodeCoordinateXandBoardSize(){
        Node(4,3, boardSize = 3)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNodeCoordinateYandBoardSize(){
        Node(2,4, boardSize = 3)
    }

    @Test
    fun checkNode2ndContructor(){
        val n = Node("24")
        assertEquals(2, n.x)
        assertEquals(4, n.y)
    }

    @Test
    fun checkNode2ndContructorWithChar(){
        val n = Node("D4")
        assertEquals(4, n.x)
        assertEquals(4, n.y)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNode2ndConstructorWith2ndCharException(){
        Node("4D")
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNode2ndConstructorWithWrongCharException(){
        Node("I4")
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkNode2ndContructorException(){
        Node("29")
    }


}