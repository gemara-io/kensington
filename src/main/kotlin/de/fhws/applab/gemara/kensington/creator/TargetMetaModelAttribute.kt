package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.kensington.models.types.AttributeType
import de.fhws.applab.gemara.kensington.models.types.TypeName
import de.fhws.applab.gemara.towerbridge.models.AbstractModel

import kotlinx.serialization.Serializable

@Serializable
class TargetMetaModelAttribute(
    var sourceAttributeName: String,
    var targetAttributeName: String,
    var type: AttributeType = AttributeType(TypeName.STRING)
) : AbstractModel<IMetaModelVisitor>()
{
    var root: TargetMetaModel? = null
    var functionName = ""
    var onlyModelAsParameter = false

    constructor(
        attributeName: String,
        _type: AttributeType
    ) : this(attributeName, attributeName, _type)
    {
    }

    constructor(
        sourceAttributeName: String,
        targetAttributeName: String,
        _className: String,
        _isCollection: Boolean = false
    )
            : this(sourceAttributeName, targetAttributeName, AttributeType(TypeName.CLASS))
    {
        this.type.className = _className
    }

    constructor(
        sourceAttributeName: String,
        targetAttributeName: String,
        _refMetaModel: TargetMetaModel
    )
            : this(sourceAttributeName, targetAttributeName, AttributeType(TypeName.METAMODELCLASS))
    {
        this.type.className = _refMetaModel.targetMetaModelName
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterTargetMetaModelAttribute(this)
        visitor.exitTargetMetaModelAttribute(this)
    }
}
