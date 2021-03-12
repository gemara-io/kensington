package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.towerbridge.models.AbstractModel

import kotlinx.serialization.Serializable

@Serializable
class MetaModel(var metaModelName: String) : AbstractModel<IMetaModelVisitor>()
{
    var root: MetaModels? = null
    var artefactFileName = ""
    val attributes = mutableListOf<MetaModelAttribute>()

    fun addAttribute(metaModelAttribute: MetaModelAttribute)
    {
        attributes.add(metaModelAttribute)
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaModel(this)
        accept(visitor, attributes)
        visitor.exitMetaModel(this)
    }
}
