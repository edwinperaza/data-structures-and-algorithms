/**
 * Merge sort es de los algoritmos más rápidos y muy utilizado, utiliza la técnica de divide y conquitarás
 * Complejidad de: O(n log n), lo que se considera el tiempo mas corto posible para ordenar un numero N de elementos 
 */


/**
 * Function: Sort
 * Si el Size del la lista es 1, entonces ya esta ordenado y devolvemos ese listado (de un elemento)
 * En caso contrario, vamos a encontrar la mitad, utilizando el size y dividiendo entre 2
 * Obtenemos dos sublistas la lista zquierda desde el inicio hasta la mitad (middle)
 * la lista derecha desde la mitad hasta el final (size)
 * finalmente llamamos el método merge que recibe dos listas para unificarlas pero en sus parámetros vamos
 * a llamar de forma recursiva a el mismo sort
 *
 * <E: Comparable<E>> Nos permite crear una restricción donde el tipo de dato E debe implementar la interfaz Comparable
 * Creamos una función que dada una mutableList del tipo<E> va a tener un método sort 
 */
fun <E: Comparable<E>> MutableList<E>.sort(): MutableList<E> {
    if (size <= 1) return this

    val middle = size / 2
    val left = subList(0, middle)    
    val right = subList(middle, size)
    println("Size: $size, middle: $middle, left: $left, right: $right")
    return merge(left.sort(), right.sort())
}

/**
 * Function: Merge
 * Primero seteamos algunas variable locales con la cantidad de elementos en cada lista y punto inicial de comparación que será 0
 * Iteramos a través de los listados (izquierdo y derecho) y comparamos si cual elemento es menor, dicho elemento es almacenado en la 
 * lista ordenada y procedemos a incrementar el indice que hace referencia a la posición del listado que vamos a comparar
 * una vez que finalizamos de recorrer una lita entonces procedemos a salir del ciclo, esto ocurre cuando un index es mayor o igual al Size
 * Siempre mantenemos el index menor al Size, porque al momento que sea igual va a generar una Excepción
 * 
 * Una vez finalizado ese ciclo, tenemos dos más que nos permite iterar sobre los elementos restantes y agregarlos a final de la lista
 */
private fun <E: Comparable<E>> merge(left: MutableList<E>, right: MutableList<E>): MutableList<E> {
    val leftArrSize = left.size
    val rightArrSize = right.size
    var leftArrIndex = 0
    var rightArrIndex = 0
    val list: MutableList<E> = mutableListOf()
    while(leftArrIndex < leftArrSize && rightArrIndex < rightArrSize) {
        if (left[leftArrIndex] <= right[rightArrIndex]) {
            list.add(left[leftArrIndex])
            leftArrIndex++
        } else {
            list.add(right[rightArrIndex])
            rightArrIndex++
        }
    }

    while(leftArrIndex < leftArrSize) {
        list.add(left[leftArrIndex])
        leftArrIndex++
    }

    while(rightArrIndex < rightArrSize) {
        list.add(right[rightArrIndex])
        rightArrIndex++
    }
    println("Temporal List merged: $list")
    return list
}

fun main() {
    val listToSort = mutableListOf(1,8,4,6,0)
    println("List unsorted: ${listToSort.toString()}")
    println("List sorted: ${listToSort.sort()}")
}