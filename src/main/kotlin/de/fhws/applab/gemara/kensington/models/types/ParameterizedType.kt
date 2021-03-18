package de.fhws.applab.gemara.kensington.models.types

import kotlinx.serialization.Serializable

@Serializable
class ParameterizedType(
	var rawType: RawType = RawType.LIST,
	var typeArguments: List<SimpleType> = mutableListOf()
) : AttributeType()
{
	override fun accept(visitor: ITypeVisitor)
	{
		TODO("Not yet implemented")
	}
}
