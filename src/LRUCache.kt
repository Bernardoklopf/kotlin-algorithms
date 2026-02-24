// 1. Criamos a estrutura do Nó para a Doubly Linked List
class Node(var key: Int, var value: Int) {
    var prev: Node? = null
    var next: Node? = null
}

class LRUCache(private val capacity: Int) {
    // HashMap aponta para o NÓ, não apenas para o valor
    private val cache = HashMap<Int, Node>()

    // Nós "Dummy" para facilitar manipulação de ponteiros sem checar null
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    // Tempo O(1)
    fun get(key: Int): Int {
        val node = cache[key] ?: return -1

        // Regra de Ouro do LRU: Se foi lido, move para o topo (mais recente)
        removeNode(node)
        addToHead(node)

        return node.value
    }

    // Tempo O(1)
    fun put(key: Int, value: Int) {
        val node = cache[key]

        if (node != null) {
            // Se já existe, atualiza o valor e move para o topo
            node.value = value
            removeNode(node)
            addToHead(node)
        } else {
            // Se não existe, cria novo nó
            val newNode = Node(key, value)
            cache[key] = newNode
            addToHead(newNode)

            // Se estourou capacidade, remove o Menos Recentemente Usado (antes do Tail)
            if (cache.size > capacity) {
                val lruNode = tail.prev!!
                removeNode(lruNode)
                cache.remove(lruNode.key)
            }
        }
    }

    // --- Funções Auxiliares de O(1) para manipulação de ponteiros ---
    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addToHead(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }
}