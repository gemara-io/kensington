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
        var resource = MetaModel("Resource")
        var resourceName = MetaModelAttribute("resourceName", SimpleType(TypeName.STRING))

        var paramTypeListOfString = ParameterizedType(RawType.LIST)
        paramTypeListOfString.typeArguments.add(SimpleType(TypeName.STRING))
        var listOfStrings = MetaModelAttribute("listOfString", paramTypeListOfString)

        var paramTypeMapOfStringToInt = ParameterizedType(RawType.MAP)
        paramTypeMapOfStringToInt.typeArguments.addAll(listOf(SimpleType(TypeName.STRING), SimpleType(TypeName.INT)))

        var mapOfStringToInt = MetaModelAttribute("map", paramTypeMapOfStringToInt)

        resource.addAttribute(listOfStrings)
        resource.addAttribute(mapOfStringToInt)

        println(Yaml.default.encodeToString(MetaModel.serializer(), resource))
    }

}
