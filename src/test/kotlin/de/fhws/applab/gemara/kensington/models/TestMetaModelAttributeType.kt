package de.fhws.applab.gemara.kensington.models

import org.junit.Test
import kotlin.test.assertEquals

class TestMetaModelAttributeType
{
    @Test
    fun test()
    {
        var a = MetaModelAttributeType.METAMODELENUM
        a.enumValues = listOf("hallo", "welt")

        assertEquals(listOf("hallo", "welt"), a.enumValues)
    }

}
