package de.fhws.applab.gemara.kensington.models


enum class MetaModelAttributeType()
{
    BOOLEAN,
    INT,
    LONG,
    DOUBLE,
    STRING,
    DATE,
    TIMESTAMP,
    CLASS,
    METAMODELENUM,
    METAMODELCLASS;

    var enumValues = emptyList<String>()
}
