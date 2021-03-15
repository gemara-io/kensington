package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.kensington.models.types.AttributeType
import de.fhws.applab.gemara.kensington.models.types.SimpleType
import de.fhws.applab.gemara.kensington.models.types.TypeName
import de.fhws.applab.gemara.towerbridge.models.AbstractModel

import kotlinx.serialization.Serializable

@Serializable
class MetaModelAttribute(
    var attributeName: String,
    var type: AttributeType = SimpleType(TypeName.STRING)
) : AbstractModel<IMetaModelVisitor>()
{
    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaModelAttribute(this)
        visitor.exitMetaModelAttribute(this)
    }
}
