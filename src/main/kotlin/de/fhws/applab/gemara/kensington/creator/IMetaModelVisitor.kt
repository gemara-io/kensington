package de.fhws.applab.gemara.kensington.creator

import de.fhws.applab.gemara.towerbridge.models.IVisitor

interface IMetaModelVisitor : IVisitor
{
    fun enterMetaModels(metaModels: MetaModels)
    {
    }

    fun exitMetaModels(metaModels: MetaModels)
    {
    }

    fun enterMetaModel(metaModel: MetaModel)
    {
    }

    fun exitMetaModel(metaModel: MetaModel)
    {
    }

    fun enterTargetMetaModel(targetMetaModel: TargetMetaModel)
    {
    }

    fun exitTargetMetaModel(targetMetaModel: TargetMetaModel)
    {
    }

    fun enterTargetMetaModelAttribute(attribute: TargetMetaModelAttribute)
    {
    }

    fun exitTargetMetaModelAttribute(attribute: TargetMetaModelAttribute)
    {
    }

}