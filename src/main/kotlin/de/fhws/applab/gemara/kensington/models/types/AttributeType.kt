package de.fhws.applab.gemara.kensington.models.types

import de.fhws.applab.gemara.kensington.models.MetaEnum
import de.fhws.applab.gemara.kensington.models.MetaModel
import kotlinx.serialization.Serializable

@Serializable
class AttributeType(var typeName: TypeName = TypeName.STRING)
{
	var className = ""
	var genericParameters: List<AttributeType> = listOf()

	constructor(className: String) : this(TypeName.CLASS)
	{
		this.className = className
	}

	constructor(_refMetaModel: MetaModel) : this(TypeName.METAMODELCLASS)
	{
		this.className = _refMetaModel.metaModelName
	}

	constructor(_refMetaEnum: MetaEnum) : this(TypeName.ENUM){
		this.className = _refMetaEnum.metaEnumName
	}

	constructor(typeName: TypeName, typeArguments: List<AttributeType>) : this(typeName)
	{
		this.genericParameters = typeArguments
	}

	fun accept(visitor: IAttributeTypeVisitor)
	{
		visitor.visit(this)
	}
}