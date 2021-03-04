package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.towerbridge.models.AbstractModel

class MetaModelAttribute(
        var attributeName: String,
        var type: MetaModelAttributeType = MetaModelAttributeType.STRING
) : AbstractModel<IMetaModelVisitor>()
{

    var collection = false
    var className = ""

    constructor(attributeName: String, type: MetaModelAttributeType, _isCollection: Boolean)
            : this(attributeName, type)
    {
        this.collection = _isCollection
    }

    constructor(attributeName: String, _className: String, _isCollection: Boolean = false)
            : this(attributeName, MetaModelAttributeType.CLASS)
    {
        this.collection = _isCollection
        this.className = _className
    }

    constructor(attributeName: String, _refMetaModel: MetaModel, _isCollection: Boolean = false)
            : this(attributeName, MetaModelAttributeType.METAMODELCLASS)
    {
        this.collection = _isCollection
        this.className = _refMetaModel.metaModelName
    }

    override fun accept(visitor: IMetaModelVisitor)
    {
        visitor.enterMetaModelAttribute(this)
        visitor.exitMetaModelAttribute(this)
    }
}
