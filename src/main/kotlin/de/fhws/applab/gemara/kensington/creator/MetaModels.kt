package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.towerbridge.models.AbstractModel
import kotlinx.serialization.Serializable

@Serializable
class MetaModels(var projectName: String, var packageName: String) : AbstractModel<IMetaModelVisitor>()
{
    private var metaModels = mutableListOf<MetaModel>()

    fun addMetaModel(metaModel: MetaModel)
    {
        this.metaModels.add(metaModel)
        metaModel.root = this
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaModels(this)
        accept(visitor, metaModels)
        visitor.exitMetaModels(this)
    }
}