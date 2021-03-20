package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.towerbridge.models.AbstractModel

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class MetaModel(var metaModelName: String) : AbstractModel<IMetaModelVisitor>()
{
    @Transient
    var root = MetaModels("", "")
    var createArtefact = false
    var abstractClass = false
    var extendsMetaModels = mutableListOf<String>()
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
