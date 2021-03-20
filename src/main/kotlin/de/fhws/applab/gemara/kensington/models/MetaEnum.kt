package de.fhws.applab.gemara.kensington.models

import kotlinx.serialization.Serializable

@Serializable
class MetaEnum(val metaEnumName: String, val enumValues: List<String>)