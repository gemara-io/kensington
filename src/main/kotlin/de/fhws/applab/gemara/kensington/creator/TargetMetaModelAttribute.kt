package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.kensington.models.MetaModelAttributeType
import de.fhws.applab.gemara.towerbridge.models.AbstractModel

class TargetMetaModelAttribute(
        var sourceAttributeName: String,
        var targetAttributeName: String,
        var type: MetaModelAttributeType = MetaModelAttributeType.STRING,
        var collection: Boolean = false
) : AbstractModel<IMetaModelVisitor>()
{
    var root: TargetMetaModel? = null
    var className = ""
    var functionName = ""
    var onlyModelAsParameter = false

    constructor(attributeName: String, type: MetaModelAttributeType = MetaModelAttributeType.STRING, collection: Boolean = false)
            : this(attributeName, attributeName, type, collection)
    {
    }

    constructor(attributeName: String, _className: String, _isCollection: Boolean = false)
            : this(attributeName, MetaModelAttributeType.CLASS, _isCollection)
    {
        this.className = _className
    }

    constructor(sourceAttributeName: String, targetAttributeName: String, _className: String, _isCollection: Boolean = false)
            : this(sourceAttributeName, targetAttributeName, MetaModelAttributeType.CLASS, _isCollection)
    {
        this.className = _className
    }

    constructor(attributeName: String, _refMetaModel: TargetMetaModel, _isCollection: Boolean = false)
            : this(attributeName, MetaModelAttributeType.METAMODELCLASS, _isCollection)
    {
        this.className = _refMetaModel.targetMetaModelName
    }

    constructor(sourceAttributeName: String, targetAttributeName: String, _refMetaModel: MetaModel, _isCollection: Boolean = false)
            : this(sourceAttributeName, targetAttributeName, MetaModelAttributeType.METAMODELCLASS, _isCollection)
    {
        this.className = _refMetaModel.metaModelName
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterTargetMetaModelAttribute(this)
        visitor.exitTargetMetaModelAttribute(this)
    }
}
