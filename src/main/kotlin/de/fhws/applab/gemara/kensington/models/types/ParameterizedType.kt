package de.fhws.applab.gemara.kensington.models.types

class ParameterizedType(var rawType: RawType = RawType.LIST, vararg _typeArguments: SimpleType) : AttributeType()
{
    var typeArguments = mutableListOf<SimpleType>()

    init
    {
        this.typeArguments = _typeArguments.toMutableList()
    }
}
