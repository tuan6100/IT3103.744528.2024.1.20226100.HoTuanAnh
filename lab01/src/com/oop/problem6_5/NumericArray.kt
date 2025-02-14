package com.oop.problem6_5

import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun mergeSortArray(array: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val mid = (low + high) / 2
        mergeSortArray(array, low, mid)
        mergeSortArray(array, mid + 1, high)
        mergeArray(array, low, mid, high)
    }
}

fun mergeArray(array: Array<Int>, low: Int, mid: Int, high: Int) {
    val n1 = mid - low + 1
    val n2 = high - mid
    val leftArray = Array(n1) { 0 }
    val rightArray = Array(n2) { 0 }
    for (i in 0 until n1) {
        leftArray[i] = array[low + i]
    }
    for (j in 0 until n2) {
        rightArray[j] = array[mid + 1 + j]
    }
    var i = 0
    var j = 0
    var k = low
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i]
            i++
        } else {
            array[k] = rightArray[j]
            j++
        }
        k++
    }
    while (i < n1) {
        array[k] = leftArray[i]
        i++
        k++
    }
    while (j < n2) {
        array[k] = rightArray[j]
        j++
        k++
    }
}


fun quickSortArray(array: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pivot = getPartition(array, low, high)
        quickSortArray(array, low, pivot - 1)
        quickSortArray(array, pivot + 1, high)
    }
}

fun getPartition(array: Array<Int>, low: Int, high: Int): Int {
    val pivot = array[high]
    var i = low - 1
    for (j in low until high) {
        if (array[j] < pivot) {
            i++
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }
    val temp = array[i + 1]
    array[i + 1] = array[high]
    array[high] = temp
    return i + 1
}


fun heapSortArray(array: Array<Int>) {
    val n = array.size
    for (i in n / 2 - 1 downTo 0) {
        heapify(array, n, i)
    }
    for (i in n - 1 downTo 0) {
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp
        heapify(array, i, 0)
    }
}

fun heapify(array: Array<Int>, n: Int, i: Int) {
    var largest = i
    val leftChild = 2 * i + 1
    val rightChild = 2 * i + 2
    if (leftChild < n && array[leftChild] > array[largest]) {
        largest = leftChild
    }
    if (rightChild < n && array[rightChild] > array[largest]) {
        largest = rightChild
    }
    if (largest != i) {
        val temp = array[i]
        array[i] = array[largest]
        array[largest] = temp
        heapify(array, n, largest)
    }
}


fun measureRuntime(sortFunction: (Array<Int>, Int, Int) -> Unit, array: Array<Int>): Long {
    val cloneArray = array.clone()
    return measureTimeMillis {
        sortFunction(cloneArray, 0, cloneArray.size - 1)
    }
}

fun measureRuntime(sortFunction: (Array<Int>) -> Unit, array: Array<Int>): Long {
    val cloneArray = array.clone()
    return measureTimeMillis {
        sortFunction(cloneArray)
    }
}


fun getSum(array: Array<Int>): Number {
    var sum = 0.0
    array.forEach { elem -> sum += elem.toDouble() }
    return sum
}

fun getAverage(array: Array<Int>): Number {
    return getSum(array).toDouble() / array.size
}


fun main() {
    val arraySize = 10
    val arrayMaxValueOfElement = 100
    val array = Array(arraySize) { Random.nextInt(0, arrayMaxValueOfElement) }
    println("Array: ${array.joinToString()}")
    println("Array size: ${array.size}")
    val cloneArray = array.clone()
    quickSortArray(cloneArray, 0, cloneArray.size - 1)
    println("Sorted array by quicksort: ${cloneArray.joinToString()}")
    println("Quick sort runtime: ${measureRuntime(::quickSortArray, array)} ms")
    val newCloneArray = array.clone()
    heapSortArray(newCloneArray)
    println("Sorted array by heapsort: ${newCloneArray.joinToString()}")
    println("Heap sort runtime: ${measureRuntime(::heapSortArray, array)} ms")
    val anotherCloneArray = array.clone()
    mergeSortArray(anotherCloneArray, 0, anotherCloneArray.size - 1)
    println("Sorted array by mergesort: ${anotherCloneArray.joinToString()}")
    println("Merge sort runtime: ${measureRuntime(::mergeSortArray, array)} ms")
    println("Sum: ${getSum(array)}")
    println("Average: ${getAverage(array)}")
}