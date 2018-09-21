package kui

import org.w3c.dom.Element
import kotlin.browser.document
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun mountComponent(element: Element, component: Component) {
    component.mountPoint = element
    component.rootElement = null
    component.render()
}

fun mountComponent(id: String, component: Component) {
    mountComponent(document.getElementById(id) ?: return, component)
}

fun <T> renderOnSet(value: T, target: Component? = null): ReadWriteProperty<Component, T> {
    return object : ReadWriteProperty<Component, T> {
        private var field: T = value

        override fun getValue(thisRef: Component, property: KProperty<*>): T {
            return field
        }

        override fun setValue(thisRef: Component, property: KProperty<*>, value: T) {
            field = value
            (target ?: thisRef).render()
        }
    }
}
