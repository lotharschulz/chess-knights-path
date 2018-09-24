package info.lotharschulz.chessknights

class ChessKnight{

    val row: IntArray = intArrayOf( 2,2,-2,-2,1, 1,-1,-1)
    val col: IntArray = intArrayOf(-1,1, 1,-1,2,-2, 2,-2)

    fun validMove(x: Int, y: Int, boardSize: Int):Boolean = !(x < 0 || y < 0 || x>=boardSize || y>=boardSize)

    fun shortestPathList(src: Node, trgt: Node, boardSize: Int):List<Node>{
        if (src == trgt) return listOf(src)
        val visited:MutableMap<Node, Node> = mutableMapOf()
        val queue: java.util.Queue<Node> = java.util.ArrayDeque<Node>()
        queue.add(src)

        while (!queue.isEmpty()){
            val currentNode = queue.poll()
            if(trgt == currentNode) break
            for (i in 0 until boardSize-1) {
                val xN = currentNode.x + col[i]
                val yN = currentNode.y + row[i]
                if (validMove(xN, yN, boardSize)){
                    val newNode = Node(xN, yN)
                    if (!visited.contains(newNode)){
                        visited[newNode] = currentNode
                        queue.add(newNode)
                    }
                }
            }
        }

        var currentNode = trgt; //start at the end node
        val res:MutableList<Node> = mutableListOf()
        while (currentNode != src && visited.containsKey(currentNode)) //stop at the start node
        {
            res.add(currentNode)
            currentNode = visited.get(currentNode)!!

        }
        // make sure the source is part of the result list
        res.add(src)
        return res
    }

    fun stringifyShortestPathList(l:List<Node>):String =
            l.reversed().joinToString(" ", "one of potentially multiple shortest paths: ")
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Please provide chess knight start and destination position.")
        println("Usage: gradle run -Dexec.args=\"{start position} {target position}\"")
        println("example: gradle run -Dexec.args=\"D4 G7\"")
        return
    }
    val ck = ChessKnight()
    val steplist = ck.shortestPathList(Node(args[0].toString()), Node(args[1].toString()), 8)
    println(ck.stringifyShortestPathList(steplist))
}

