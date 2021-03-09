/**
 * HeapSort es una versión mejorada de Selection sort, con dos subcolecciones una ordenada y la otra no. 
 * Inicialmente la colección no ordenada es el dato de entrada y la colección vacía será la que se ordenará
 * 
 * Complejidad de: O(n log n), lo que se considera el tiempo mas corto posible para ordenar un numero N de elementos 
 * 
 * Binary Heap es un tipo de Complete Binary Tree. Considerando un Complete Binary Tree como un Binary Tree donde los padres tienen
 * un máximo de 2 hijos, y cada nivel debe ser completo, es decir, tener 2 hijo a excepcion del último nivel
 *
 * La diferencia entre un Complete Binary Tree y un Binary Heap es que en un Binary Heap, los elementos se ordenan de una manera especial. 
 * En este caso, cada elemento padre es más grande que sus dos hijos (llamado Max Heap) o más pequeño que sus dos hijos (llamado Min Heap).
 *
 * Esta estructura se puede representar como un arreglo, donde el padre se encuentra en la posición i index, el hijo izquierdo en el indice (2*i+1)
 * y el hijo o nodo derecho en la posición (2*i+2)
 */
import java.util.*

/**
 * Construimos el heap organizando sus elementos comenando en la mitad del arreglo a la izquierda de esta manera sabemos que el elemento más alto esta en el 
 * index 0
 */
fun <E: Comparable<E>> Array<E>.sort() {
    val middle = (size / 2) - 1
    for (i in middle downTo 0) {
        println("sort 1st -> for i: $i, middle: $middle, size: $size")
        heapify(this, size, i)
    }
    for (i in size - 1 downTo 0) {
        print("sort 2nd -> for i: $i, array: ${Arrays.toString(this)} \n")
        this[0] = this[i].also { this[i] = this[0] }
        print("sort 2nd -> for i: $i, array: ${Arrays.toString(this)} UPDATED\n")
        heapify(this, i, 0)
    }
}

/**
 * Aquí vamos a intercambiar el indice 0 con el último, y vamos a reconstruir el heap sin considerar el último elemento que es el mas grande
 */
private fun <E: Comparable<E>> heapify(arr: Array<E>, heapSize: Int, root: Int) {
    var largest = root
    val leftNode = 2 * root + 1
    val rightNode = 2 * root + 2
    println("heapify -> largest: $largest, leftNode: $leftNode, rightNode: $rightNode, heapSize: $heapSize")
    if (leftNode < heapSize && arr[leftNode] > arr[largest]) { 
        println("heapify -> arr[leftNode]: ${arr[leftNode]} > arr[largest]: ${arr[largest]}")
        largest = leftNode
    }
    if (rightNode < heapSize && arr[rightNode] > arr[largest]) {
        println("heapify -> arr[rightNode]: ${arr[rightNode]} > arr[largest]: ${arr[largest]}")
        largest = rightNode
    }
   
    if (largest != root) {
        arr[root] = arr[largest].also { arr[largest] = arr[root] }
        println("heapify -> array: ${Arrays.toString(arr)} go to internal heapify")
        heapify(arr, heapSize, largest)
    } else {
        println("heapify -> no changes")
    }
}

fun main() {
    //val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    val nums = arrayOf(17, 12, 29, 21, 5, 7)
    nums.sort()
    println(Arrays.toString(nums))
}