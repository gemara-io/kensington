package de.fhws.applab.gemara.kensington.models.types

import kotlinx.serialization.Serializable

@Serializable
class ParameterizedType(var rawType: RawType = RawType.LIST) : AttributeType()
{
    var typeArguments = mutableListOf<SimpleType>()

    override fun accept(visitor: ITypeVisitor)
    {
        TODO("Not yet implemented")
    }
}
