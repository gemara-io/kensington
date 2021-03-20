projectName: enfield2
packageName: de.fhws.applab.gemara
metaModels:

  - metaModelName: GetPrimaryCollectionResourceByQueryState //Extends Implements?
    attributes:
      - attributeName: query
        type: SimpleType
        typeName: METAMODELCLASS
        className: Query
      - attributeName: paging
        type: SimpleType
        typeName: AbstractPaging //Default Wert? //HIER: typeName: Metamodel und className = AbstractPaging
      - attributeName: hookedFilterClassName
        type: SimpleType
        typeName: STRING

  - metaModelName: Query
    attributes:
      - attributeName: queryParameters
        type: ParameterizedType
        rawType: LIST //List vs MutableList, Map vs MutableMap
        typeArgument: QueryParameter
      - attributeName: queryName
        type: SimpleType
        typeName: STRING
      - attributeName: queryPath
        type: SimpleType
        typeName: STRING
      - attributeName: queryStatement
        type: SimpleType
        typeName: STRING
      - attributeName: orderByAttributes
        type: ParameterizedType
        rawType: LIST
        typeArgument: SimpleAttribute
      - attributeName: sortOrder
        type: SimpleType
        typeName: METAMODELCLASS //Enum
        className: NAME des metamodells
      - attributeName: isRawSql
        type: SimpleType
        typeName: BOOLEAN //Default Werte?

  - metaModelName: QueryParameter
    attributes:
      - attributeName: dataType
        type: SimpleType //Enum mit drei Attributen
        typeName: ENUM //Enum Klasse muss noch angegeben werden
      - attributeName: isHidden
        type: SimpleType
        typeName: BOOLEAN
      - attributeName: javaExpressionForQueryValue
        type: SimpleType
        typeName: STRING

  - metaModelName: SimpleTextWithConfigurationDisplayWidgetUiModel
    attributes:
      - attributeName: configuration
        type: ParameterizedType
        rawType: MAP
        typeArguments: //Wrappen in simpletypes
          - INT
          - STRING