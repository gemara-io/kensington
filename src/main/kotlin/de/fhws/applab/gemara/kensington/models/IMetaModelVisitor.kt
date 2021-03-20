package de.fhws.applab.gemara.kensington.models

import de.fhws.applab.gemara.towerbridge.models.IVisitor


interface IMetaModelVisitor : IVisitor
{
    fun enterMetaModels(metaModels: MetaModels)
    {
    }

    fun exitMetaModels(metaModels: MetaModels)
    {
    }

    fun enterMetaEnum(metaEnum: MetaEnum)
    {
    }

    fun exitMetaEnum(metaEnum: MetaEnum)
    {
    }
    
    fun enterMetaModel(metaModel: MetaModel)
    {
    }

    fun exitMetaModel(metaModel: MetaModel)
    {
    }

    fun enterMetaModelAttribute(attribute: MetaModelAttribute)
    {

    }

    fun exitMetaModelAttribute(attribute: MetaModelAttribute)
    {

    }

}
