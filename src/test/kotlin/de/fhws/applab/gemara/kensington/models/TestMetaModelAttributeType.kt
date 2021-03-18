package de.fhws.applab.gemara.kensington.models

import com.charleskorn.kaml.Yaml
import de.fhws.applab.gemara.kensington.models.types.ParameterizedType
import de.fhws.applab.gemara.kensington.models.types.RawType
import de.fhws.applab.gemara.kensington.models.types.SimpleType
import de.fhws.applab.gemara.kensington.models.types.TypeName
import org.junit.Test

class TestMetaModelAttributeType
{
	@Test
	fun test()
	{
		val queryParameterMetaModel = MetaModel("QueryParameter")
		val javaExpressionForQueryValue = MetaModelAttribute(
			"javaExpressionForQueryValue", SimpleType(TypeName.STRING)
		)
		queryParameterMetaModel.addAttribute(javaExpressionForQueryValue)

		val queryMetaModel = MetaModel("Query")
		val queryParametersAttribute = MetaModelAttribute(
			"queryParameters", ParameterizedType(RawType.LIST, listOf(SimpleType(queryMetaModel)))
		)
		queryMetaModel.addAttribute(queryParametersAttribute)

		val primaryCollectionStateMetaModel = MetaModel("GetPrimaryCollectionResourceByQueryState")
		val queryAttribute = MetaModelAttribute("query", SimpleType(queryMetaModel))
		primaryCollectionStateMetaModel.addAttribute(queryAttribute)

		val simpleTextWithConfigWidgetMetaModel = MetaModel("SimpleTextWithConfigurationDisplayWidgetUiModel")
		val configurationAttribute = MetaModelAttribute(
			"configuration",
			ParameterizedType(RawType.MAP, listOf(SimpleType(TypeName.INT), SimpleType(TypeName.STRING)))
		)
		simpleTextWithConfigWidgetMetaModel.addAttribute(configurationAttribute)

		val metaModels = MetaModels("enfield2", "de.fhws.applab.gemara")
		metaModels.addMetaModel(queryParameterMetaModel)
		metaModels.addMetaModel(queryMetaModel)
		metaModels.addMetaModel(primaryCollectionStateMetaModel)
		metaModels.addMetaModel(simpleTextWithConfigWidgetMetaModel)

		println(Yaml.default.encodeToString(MetaModel.serializer(), primaryCollectionStateMetaModel))
	}
}
