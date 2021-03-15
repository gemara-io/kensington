package de.fhws.applab.gemara.kensington.models.types

interface ITypeVisitor
{
    fun visit(type: SimpleType)

    fun visit(type: ParameterizedType)
}
