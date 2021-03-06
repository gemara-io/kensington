package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.towerbridge.models.AbstractModel
import kotlinx.serialization.Serializable

@Serializable
class MetaModels(var projectName: String, var packageName: String) : AbstractModel<IMetaModelVisitor>()
{
    private var metaModels = mutableListOf<MetaModel>()
    private var metaEnums = mutableListOf<MetaEnum>()

    fun addMetaModel(metaModel: MetaModel)
    {
        this.metaModels.add(metaModel)
        metaModel.root = this //achtung rekursion!
    }

    fun addMetaEnum(metaEnum: MetaEnum){
        this.metaEnums.add(metaEnum)
    }

    fun getMetaModels(): List<MetaModel>
    {
        return this.metaModels
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaModels(this)
        accept(visitor, metaModels)
        visitor.exitMetaModels(this)
    }
}
