package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.kensington.models.types.TypeName
import de.fhws.applab.gemara.towerbridge.models.AbstractModel

import kotlinx.serialization.Serializable

@Serializable
class TargetMetaModelAttribute(
    var sourceAttributeName: String,
    var targetAttributeName: String,
    var type: TypeName = TypeName.STRING,
    var collection: Boolean = false
) : AbstractModel<IMetaModelVisitor>()
{
    var root: TargetMetaModel? = null
    var className = ""
    var functionName = ""
    var onlyModelAsParameter = false

    constructor(attributeName: String, type: TypeName = TypeName.STRING, collection: Boolean = false)
            : this(attributeName, attributeName, type, collection)
    {
    }

    constructor(attributeName: String, _className: String, _isCollection: Boolean = false)
            : this(attributeName, TypeName.CLASS, _isCollection)
    {
        this.className = _className
    }

    constructor(
        sourceAttributeName: String,
        targetAttributeName: String,
        _className: String,
        _isCollection: Boolean = false
    )
            : this(sourceAttributeName, targetAttributeName, TypeName.CLASS, _isCollection)
    {
        this.className = _className
    }

    constructor(attributeName: String, _refMetaModel: TargetMetaModel, _isCollection: Boolean = false)
            : this(attributeName, TypeName.METAMODELCLASS, _isCollection)
    {
        this.className = _refMetaModel.targetMetaModelName
    }

    constructor(
        sourceAttributeName: String,
        targetAttributeName: String,
        _refMetaModel: MetaModel,
        _isCollection: Boolean = false
    )
            : this(sourceAttributeName, targetAttributeName, TypeName.METAMODELCLASS, _isCollection)
    {
        this.className = _refMetaModel.metaModelName
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterTargetMetaModelAttribute(this)
        visitor.exitTargetMetaModelAttribute(this)
    }
}
