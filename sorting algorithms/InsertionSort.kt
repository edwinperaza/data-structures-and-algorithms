/**
 * Notación: O(n^2), aquí mantenemos el numero que queremos insertar en una variable temporal
 * Si el valor de la posición anterior es mayor a la actual, entonces reemplazo la posición actual con 
 * el valor anterior y comienzo a iterar hacia el inicio del listado hasta encontrar un valor menor a la posición
 * actual, en ese momento inserto mi valor temporal en dicha posición y continúo el ciclo 
 * En este algoritmo siempre se inicia desde la posición 1, ya que la 0 se toma como comparación inicial
 * Aquí no tenemos recursividad, sólo iteramos sobre el ciclo
 */
fun insertionSort(list: MutableList<Int>): MutableList<Int> {
    var valueToInsert: Int
    var holePosition: Int
    
    for (pos in 1..list.lastIndex) {
        println("=====")
        valueToInsert = list[pos]
        holePosition = pos
        while (holePosition > 0 && list[holePosition-1] > valueToInsert) {
            list[holePosition] = list[holePosition-1]
            println("List: $list, Item Moved: ${list[holePosition]}, at position $holePosition")
            holePosition--
        }
        
        if (holePosition != pos) {
            list[holePosition] = valueToInsert
            println("List: $list, Item inserted $valueToInsert, at position $holePosition")
        } else {
            println("List: $list, Item no Moved")
        }
    }
   
    return list
}

fun main() {
    val listToSort = mutableListOf(1,8,4,6,0)
    println("List unsorted: ${listToSort.toString()}")
    println("List sorted: ${insertionSort(listToSort)}")
}
