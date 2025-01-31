package com.github.adriianh.common.totem.condition

import com.cryptomorin.xseries.XMaterial
import com.github.adriianh.common.totem.ItemRepresentation
import com.github.adriianh.common.totem.Property
import org.bukkit.entity.Player

abstract class Condition<T> : Property, Cloneable {
    abstract val id: String
    abstract val description: List<String>

    override val identifier: String
        get() = id

    abstract fun checkResult(player: Player): Boolean

    abstract fun getExampleValue(): T

    abstract fun getMaterial(): XMaterial

    abstract fun getItemName(): String

    abstract fun getItemLore(): List<String>

    abstract fun getConvertedValue(value: Any?): Any

    abstract fun setConditionValue(value: Any)

    abstract fun getConditionValue(): T

    fun getItem() = ItemRepresentation.asItem(getMaterial())

    override fun setConvertedValue(value: Any) {
        return setConditionValue(getConvertedValue(value))
    }

    public override fun clone(): Condition<*> {
        try {
            return super.clone() as Condition<*>
        } catch (e: CloneNotSupportedException) {
            throw AssertionError()
        }
    }
}