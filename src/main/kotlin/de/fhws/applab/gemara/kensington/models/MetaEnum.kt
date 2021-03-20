package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.towerbridge.models.AbstractModel
import kotlinx.serialization.Serializable

@Serializable
class MetaEnum(val metaEnumName: String, val enumValues: List<String>) : AbstractModel<IMetaModelVisitor>()
{
    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaEnum(this)
        visitor.exitMetaEnum(this)
    }
}
