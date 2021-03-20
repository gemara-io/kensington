package de.fhws.applab.gemara.kensington.models

import com.charleskorn.kaml.Yaml
import de.fhws.applab.gemara.kensington.models.types.AttributeType
import de.fhws.applab.gemara.kensington.models.types.TypeName
import org.junit.Test

class TestMetaModelAttributeType
{
	@Test
	fun test()
	{
		val queryParameterMetaModel = MetaModel("QueryParameter")
		val javaExpressionForQueryValue = MetaModelAttribute(
			"javaExpressionForQueryValue", AttributeType(TypeName.STRING)
		)
		queryParameterMetaModel.addAttribute(javaExpressionForQueryValue)

		val queryMetaModel = MetaModel("Query")
		val queryParametersAttribute = MetaModelAttribute(
			"queryParameters", AttributeType(TypeName.LIST, listOf(AttributeType(queryMetaModel)))
		)
		val sortOrderEnum = MetaEnum("SortOrder", listOf("DESCENDING", "ASCENDING"))
		val sortOrderAttribute = MetaModelAttribute(
			"sortOrder", AttributeType(sortOrderEnum)
		)
		queryMetaModel.addAttribute(queryParametersAttribute)
		queryMetaModel.addAttribute(sortOrderAttribute)

		val primaryCollectionStateMetaModel = MetaModel("GetPrimaryCollectionResourceByQueryState")
		val queryAttribute = MetaModelAttribute("query", AttributeType(queryMetaModel))
		primaryCollectionStateMetaModel.addAttribute(queryAttribute)

		val simpleTextWithConfigWidgetMetaModel = MetaModel("SimpleTextWithConfigurationDisplayWidgetUiModel")
		val configurationAttribute = MetaModelAttribute(
			"configuration",
			AttributeType(TypeName.MAP, listOf(AttributeType(TypeName.INT), AttributeType(TypeName.STRING)))
		)
		simpleTextWithConfigWidgetMetaModel.addAttribute(configurationAttribute)

		val metaModels = MetaModels("enfield2", "de.fhws.applab.gemara")
		metaModels.addMetaModel(queryParameterMetaModel)
		metaModels.addMetaModel(queryMetaModel)
		metaModels.addMetaModel(primaryCollectionStateMetaModel)
		metaModels.addMetaModel(simpleTextWithConfigWidgetMetaModel)

		metaModels.addMetaEnum(sortOrderEnum)

		println(Yaml.default.encodeToString(MetaModels.serializer(), metaModels))
	}
}
