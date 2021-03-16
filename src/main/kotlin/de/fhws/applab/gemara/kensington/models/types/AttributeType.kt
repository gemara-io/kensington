package de.fhws.applab.gemara.kensington.models.types

import kotlinx.serialization.Serializable

@Serializable
abstract class AttributeType
{
    abstract fun accept(visitor: ITypeVisitor)
}
