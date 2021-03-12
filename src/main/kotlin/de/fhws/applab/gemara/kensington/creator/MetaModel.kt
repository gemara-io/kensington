package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.towerbridge.models.AbstractModel

import kotlinx.serialization.Serializable

@Serializable
class MetaModel(var metaModelName: String) : AbstractModel<IMetaModelVisitor>()
{
    var root: MetaModels? = null
    var targetMetaModels = mutableListOf<TargetMetaModel>()

    fun addMetaModel(targetMetaModel: TargetMetaModel)
    {
        this.targetMetaModels.add(targetMetaModel)
        targetMetaModel.root = this
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaModel(this)
        accept(visitor, targetMetaModels)
        visitor.exitMetaModel(this)
    }
}
