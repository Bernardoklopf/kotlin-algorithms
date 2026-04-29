// Enum class definindo claramente os movimentos possíveis
enum class Direction(val dRow: Int, val dCol: Int) {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1)
}

// Data class para imutabilidade e facilidade de desestruturação
data class State(val row: Int, val col: Int, val distance: Int)

fun amazonDepo(depoMatrix: Array<IntArray>): Int {
    // 1. Guard clauses elegantes
    if (depoMatrix.isEmpty() || depoMatrix[0].isEmpty()) return -1
    if (depoMatrix[0][0] == 9) return 0

    val rows = depoMatrix.size
    val cols = depoMatrix[0].size

    // 2. Preservando a imutabilidade do input criando uma matriz de Visitados
    // Kotlin idiomático: Array(tamanho) { inicializador }
    val visited = Array(rows) { BooleanArray(cols) }

    // 3. Fila tipada com nosso Data Class
    val queue = ArrayDeque<State>()

    // Setup inicial
    queue.addLast(State(row = 0, col = 0, distance = 0))
    visited[0][0] = true

    // 4. Função local (Local Function) idiomática do Kotlin para checar limites
    // Mantém o escopo limpo e evita passar 'rows' e 'cols' como parâmetros o tempo todo
    fun isValid(r: Int, c: Int): Boolean {
        return r in 0 until rows && c in 0 until cols
    }

    // 5. O Motor do BFS
    while (queue.isNotEmpty()) {
        // Destructuring Declaration (muito elegante em Kotlin)
        val (currentRow, currentCol, currentDist) = queue.removeFirst()

        // Iterando sobre o Enum (use .entries se estiver no Kotlin 1.9+, senão .values())
        for (dir in Direction.values()) {
            val nextRow = currentRow + dir.dRow
            val nextCol = currentCol + dir.dCol

            // Checagem segura usando a função local e a matriz de visitados
            if (isValid(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                val nextCell = depoMatrix[nextRow][nextCol]

                // Condição de vitória
                if (nextCell == 9) {
                    return currentDist + 1
                }

                // Caminho livre
                if (nextCell == 0) {
                    visited[nextRow][nextCol] = true
                    queue.addLast(State(row = nextRow, col = nextCol, distance = currentDist + 1))
                }
            }
        }
    }

    return -1
}

// Time Complexity: O(M * N) - no pior caso, visitamos cada célula da matriz uma vez
// Space Complexity: O(M * N) - para a Queue no pior caso e matriz de visitados
fun amazonDepoRaw(depoMatrix: Array<IntArray>): Int {
    if (depoMatrix.isEmpty() || depoMatrix[0].isEmpty()) return -1
    if (depoMatrix[0][0] == 9) return 0 // Pacote já está na origem!
    val rows = depoMatrix.size
    val cols = depoMatrix[0].size
    // A verdadeira Fila FIFO do BFS. Armazena: [linha, coluna, distancia_percorrida]
    val queue = ArrayDeque<IntArray>()
    queue.add(intArrayOf(0, 0, 0))
    // Modificando a matriz original para economizar memória (Sênior move!)
    // Marcamos o ponto inicial como visitado (ex: usando 1 ou -1)
    depoMatrix[0][0] = -1
    // Array de direções (Cima, Baixo, Esquerda, Direita) - muito mais leve que Enums
    val directions = arrayOf(
        intArrayOf(-1, 0), // UP
        intArrayOf(1, 0),  // DOWN
        intArrayOf(0, -1), // LEFT
        intArrayOf(0, 1)   // RIGHT
    )
    // O verdadeiro motor do BFS
    while (queue.isNotEmpty()) {
        // Puxa o elemento mais antigo da fila
        val current = queue.removeFirst()
        val row = current[0]
        val col = current[1]
        val distance = current[2]
        // Explora os 4 vizinhos
        for (dir in directions) {
            val newRow = row + dir[0]
            val newCol = col + dir[1]
            // Validação 1: Está dentro dos limites?
            if (newRow in 0 until rows && newCol in 0 until cols) {
                val nextCell = depoMatrix[newRow][newCol]
                // Validação 2: Achamos o pacote! (Condição de Vitória)
                if (nextCell == 9) {
                    return distance + 1
                }
                // Validação 3: É um caminho livre (0)?
                if (nextCell == 0) {
                    // Marca como visitado mutando a matriz para não andarmos em círculos
                    depoMatrix[newRow][newCol] = -1

                    // Adiciona o novo passo no final da fila com a distância atualizada
                    queue.add(intArrayOf(newRow, newCol, distance + 1))
                }
            }
        }
    }
    // Se a fila esvaziou e não achamos o 9, é impossível chegar lá.
    return -1
}