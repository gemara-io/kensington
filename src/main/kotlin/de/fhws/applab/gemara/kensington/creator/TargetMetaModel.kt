package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.towerbridge.models.AbstractModel
import kotlinx.serialization.Serializable

@Serializable
class TargetMetaModel(var targetMetaModelName: String) : AbstractModel<IMetaModelVisitor>()
{
    var root: MetaModel? = null
    var attributes = mutableListOf<TargetMetaModelAttribute>()
    var targetPackageName = ""
    var parentMetaModelName = ""
    var parentAttributeName = ""
    var parentAttributeCollection = false
    var makePublic = false

    fun addAttribute(attribute: TargetMetaModelAttribute)
    {
        this.attributes.add(attribute)
        attribute.root = this
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterTargetMetaModel(this)
        accept(visitor, attributes)
        visitor.exitTargetMetaModel(this)
    }
}