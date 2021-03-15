package de.fhws.applab.gemara.kensington.models.types

import de.fhws.applab.gemara.kensington.models.MetaModel

class SimpleType(var typeName: TypeName = TypeName.STRING) : AttributeType()
{
    var className = ""

    constructor(className: String) : this(TypeName.CLASS)
    {
        this.className = className
    }

    constructor(_refMetaModel: MetaModel) : this(TypeName.METAMODELCLASS)
    {
        this.className = _refMetaModel.metaModelName
    }

}
