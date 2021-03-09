/**
 * El ciclo exterior lo uso para limitar el corrido interno, es decir, cada vez que ejecuto uno vuelta completa al array
 * la siguiente será hasta el final menos el numero de iteraciones que haya hecho, ya que no tiene sentido comparar siempre
 * hasta el final porque ya esta ordenado
 */
fun bubbleSort(list: MutableList<Int>): MutableList<Int> {
    var temp: Int
    var i: Int
    for (i in 0..list.size-1) {
        println("NEW External loop -> i: $i")
        var swapped = false
        println("LastIndex Internal Loop = ${list.size-1-i}")
        for (pos in 0 until (list.size-1-i)) {
            if (list[pos] > list[pos+1]) {
                println("Items Compared -> [${list[pos]},${list[pos+1]}] -> SWAPPED")
                temp = list[pos]
                list[pos] = list[pos+1]
                list[pos+1] = temp
                println("List Swapped: ${list.toString()}")
                swapped = true
            } else {
                println("Items Compared -> [${list[pos]},${list[pos+1]}] -> NOT SWAPPED")
            }
        }
        if (!swapped) break
    }
    
    return list
}

/**
 * La misma búsqueda que la anterior pero acá estoy utlizando lastIndex en lugar de size, de esta manera el loop for
 * lo puedo hacer con ".." en lugar de until
 */
fun bubbleSort(list: MutableList<Int>): MutableList<Int> {
    var temp: Int
    var i: Int
    for (i in 0..list.lastIndex) {
        println("NEW External loop -> i: $i")
        var swapped = false
        println("LastIndex Internal Loop = ${list.size-1-i}")
        for (pos in 0..(list.lastIndex-1-i)) {
            if (list[pos] > list[pos+1]) {
                println("Items Compared -> [${list[pos]},${list[pos+1]}] -> SWAPPED")
                temp = list[pos]
                list[pos] = list[pos+1]
                list[pos+1] = temp
                println("List Swapped: ${list.toString()}")
                swapped = true
            } else {
                println("Items Compared -> [${list[pos]},${list[pos+1]}] -> NOT SWAPPED")
            }
        }
        if (!swapped) break
    }
    
    return list
}

fun main() {
    val listToSort = mutableListOf(1,8,4,6,0)
    println("List: ${listToSort.toString()}, lastIndex = ${listToSort.size-1}")
    println(bubbleSort(listToSort))
}