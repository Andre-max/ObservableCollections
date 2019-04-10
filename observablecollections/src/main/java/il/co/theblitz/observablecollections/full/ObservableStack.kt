package il.co.theblitz.observablecollections.full


import il.co.theblitz.observablecollections.abstracts.ObservableAbstractList
import il.co.theblitz.observablecollections.enums.ObservableCollectionsAction
import java.io.Serializable
import java.util.*

open class ObservableStack<X>: Serializable, ObservableAbstractList<X, Stack<X>>(), RandomAccess, Cloneable {

    init {
        collection = Stack<X>()
    }

    fun search(o: Any?): Int {
        return collection!!.search(o)
    }

    fun push(item: X): X {
        val resultElement = collection!!.push(item)
        signalChanged(ObservableCollectionsAction.Push, actionElement = item, resultElement = resultElement)
        return resultElement
    }

    fun peek(): X {
        return collection!!.peek()
    }

    fun empty(): Boolean {
        return collection!!.empty()
    }

    fun pop(): X {
        val resultElement = collection!!.pop()
        signalChanged(ObservableCollectionsAction.Push, resultElement = resultElement)
        return resultElement
    }

}