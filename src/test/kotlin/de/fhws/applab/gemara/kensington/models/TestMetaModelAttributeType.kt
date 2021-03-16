package de.fhws.applab.gemara.kensington.models

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
        var listOfStrings =
            MetaModelAttribute("listOfString", ParameterizedType(RawType.LIST, SimpleType(TypeName.STRING)))
        var mapOfStringToInt = MetaModelAttribute(
            "map",
            ParameterizedType(RawType.MAP, SimpleType(TypeName.STRING), SimpleType("Hallo"))
        )
    }

}
