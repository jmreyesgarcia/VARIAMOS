package com.variamos.dynsup.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.variamos.dynsup.interfaces.IntInstAttribute;
import com.variamos.dynsup.types.AttributeType;
import com.variamos.hlcl.model.domains.IntDomain;
import com.variamos.hlcl.model.domains.StringDomain;

/**
 * A class to represent semantic and syntax concepts attributes. The attributes
 * are dynamically loaded on modeling perspective. Part of PhD work at
 * University of Paris 1
 * 
 * @author Juan C. Munoz Fernandez <jcmunoz@gmail.com>
 * 
 * @version 1.1
 * @since 2014-11-24
 */
public class ElemAttribute implements Serializable {
	public void setType(String type) {
		this.type = type;
	}

	public void setDefaultGroup(int defaultGroup) {
		this.defaultGroup = defaultGroup;
	}

	public void setPropTabPosition(int propTabPosition) {
		this.propTabPosition = propTabPosition;
	}

	public void setElementDisplayPosition(int elementDisplayPosition) {
		this.elementDisplayPosition = elementDisplayPosition;
	}

	public void setElementDisplaySpacers(String elementDisplaySpacers) {
		this.elementDisplaySpacers = elementDisplaySpacers;
	}

	public void setPropTabEditionCondition(String propTabEditionCondition) {
		this.propTabEditionCondition = propTabEditionCondition;
	}

	public void setPropTabVisualCondition(String propTabVisualCondition) {
		this.propTabVisualCondition = propTabVisualCondition;
	}

	public void setClassCanonicalName(String classCanonicalName) {
		this.classCanonicalName = classCanonicalName;
	}

	public void setMetaConceptInstanceType(String metaConceptInstanceType) {
		this.metaConceptInstanceType = metaConceptInstanceType;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public void setDomain(IntDomain domain) {
		this.domain = domain;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8137579010457747236L;
	/**
	 * Unique name of the attribute within the concept
	 */
	private String name;

	private String attributeType;
	/**
	 * Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 * Enumeration, MEnumeration)
	 */
	private String type;
	/**
	 * Identify if this attribute affects other attributes in the properties
	 * view (to update view after change)
	 */
	private boolean affectProperties;
	/**
	 * Name to display on properties JLabel
	 */
	private String displayName;
	/**
	 * Complete class in referenced attributes (Class, MClass, Enumeration,
	 * MEnumeration)
	 */
	private String classCanonicalName;
	/**
	 * Identifier of the type of instance concept. Examples: OPER
	 */
	private String metaConceptInstanceType;
	/**
	 * Default value for the attribute
	 */
	private Object defaultValue;
	/**
	 * Domain of the attribute (not tested)
	 */
	private IntDomain domain;
	/**
	 * Hint to display on the property tab (not currently implemented)
	 */
	// TODO use on properties: duplicate with ToolTip?
	private String hint;
	/**
	 * defaultGroup for the attribute - for simulation multi-labeling
	 */
	private int defaultGroup;
	/**
	 * Position of the attribute in the property tab panel - -1 to hide
	 */
	private int propTabPosition;
	/**
	 * Position of the attribute in the element representation - -1 to hide
	 */
	private int elementDisplayPosition;
	/**
	 * Spacer for the attribute in the element representation (before and after
	 * separated by #-#
	 */
	private String elementDisplaySpacers;
	/**
	 * Condition to enable edition of the attribute in the property tab - Empty
	 * always edits
	 */
	private String propTabEditionCondition;
	/**
	 * Condition to enable visualization of the attribute in the property tab-
	 * Empty always displays
	 */
	private String propTabVisualCondition;
	/**
	 * Condition to enable visualization of the attribute in the graph Empty
	 * always displays
	 */
	private String elementDisplayCondition;

	private String domainFiltersOwnFields;
	private String domainFiltersRelFields;
	public static final String
	/**
	 * Name of element name
	 */
	VAR_NAME = "Name",
	/**
	 * Name of element type
	 */
	VAR_TYPE = "Type",
	/**
	 * Name of Attribute Type
	 */
	VAR_ATTRIBUTE_TYPE = "AttributeType",
	/**
	 * Name of Attribute Type
	 */
	VAR_ATTRIBUTE_TYPENAME = "Attribute Type",
	/**
	 * Dyplay Name of the element affect properties
	 */
	VAR_AFFECTPROPS = "AffectProps",
	/**
	 * DyplaynName of the element affect properties
	 */
	VAR_AFFECTPROPSNAME = "Affects other elements",
	/**
	 * Name of element display name
	 */
	VAR_DISPLAYNAME = "DispName",
	/**
	 * Display Name of element display name
	 */
	VAR_DISPLAYNAMENAME = "Display Name",
	/**
	 * Name of the element associated class
	 */
	VAR_CLASSCANONICALNAME = "ClassCanName",
	/**
	 * Display name of the element associated class
	 */
	VAR_CLASSCANONICALNAMENAME = "Enumeration Type",
	/**
	 * Name of element associated meta instance type
	 */
	VAR_METACONCEPTINSTTYPE = "MetaCInstType",
	/**
	 * Display name of element associated meta instance type
	 */
	VAR_METACONCEPTINSTTYPENAME = "Instance Type",
	/**
	 * Name of the element default value
	 */
	VAR_DEFAULTVALUE = "DefaultValue",
	/**
	 * Display Name of the element default value
	 */
	VAR_DEFAULTVALUENAME = "Default Value",
	/**
	 * Name of element domain
	 */
	VAR_DOMAIN = "Domain",
	/**
	 * Name of element hint
	 */
	VAR_HINT = "Hint",
	/**
	 * Name of element defaultGroup
	 */
	VAR_defaultGroup = "Default Group",
	/**
	 * Position of the attribute in the property tab panel - -1 to hide
	 */
	VAR_PROPTABPOSITION = "propTabPosition",
	/**
	 * Name of the position of the attribute in the property tab panel - -1 to
	 * hide
	 */
	VAR_PROPTABPOSITION_NAME = "Prop. Tab Position",
	/**
	 * Position of the attribute in the element representation - -1 to hide
	 */
	VAR_ELEMENTDISPLAYPOSITION = "elementDisplayPosition",
	/**
	 * Name of the position of the attribute in the element representation - -1
	 * to hide
	 */
	VAR_ELEMENTDISPLAYPOSITION_NAME = "Element Disp. Position",
	/**
	 * Spacer for the attribute in the element representation (before and after
	 * separated by #-#
	 */
	VAR_ELEMENTDISPLAYSPACERS = "elementDisplaySpacers",
	/**
	 * Name of the spacer for the attribute in the element representation
	 * (before and after separated by #-#
	 */
	VAR_ELEMENTDISPLAYSPACERS_NAME = "Element Disp. Spacers",
	/**
	 * Condition to enable edition of the attribute in the property tab - Empty
	 * always edits
	 */
	VAR_PROPTABEDITIONCOND = "propTabEditionCondition",
	/**
	 * Name of the Condition to enable edition of the attribute in the property
	 * tab - Empty always edits
	 */
	VAR_PROPTABEDITIONCOND_NAME = "Prop. Tab Edition Cond.",
	/**
	 * Condition to enable visualization of the attribute in the property tab-
	 * Empty always displays
	 */
	VAR_PROPTABVISUALCOND = "propTabVisualCondition",
	/**
	 * Name of the Condition to enable visualization of the attribute in the
	 * property tab- Empty always displays
	 */
	VAR_PROPTABVISUALCOND_NAME = "Prop. Tab Visual Cond.",
	/**
	 * Condition to enable visualization of the attribute in the property tab-
	 * Empty always displays
	 */
	VAR_ELEMENTDISPLAYCONDITION = "elementDisplayCondition",
	/**
	 * Name of the Condition to enable visualization of the attribute in the
	 * property tab- Empty always displays
	 */
	VAR_ELEMENTDISPLAYCONDITION_NAME = "Graph Visual Cond.",

	VAR_TOOLTIPTEXT = "toolTipText",

	VAR_DOMAINFILTERSOWNFIELDS = "domFiltOwnFields",

	VAR_DOMAINFILTERSOWNFIELDS_NAME = "Filter domain (Own Fields)",

	VAR_DOMAINFILTERSRELFIELDS = "domFilTRelFields",

	VAR_DOMAINFILTERSRELFIELDS_NAME = "Filter domain (Rel. Fields)",

	VAR_DEFAULTDOMAINVALUEFIELD = "defDomValueField",

	// meta-attribute that defines the default domain in case the domain is null
			VAR_DEFAULTDOMAINVALUEFIELD_NAME = "Def. Domain (Filter Field)",

			VAR_TOOLTIPTEXTNAME = "toolTipTextName";

	public String getElementDisplayCondition() {
		return elementDisplayCondition;
	}

	public void setElementDisplayCondition(String elementDisplayCondition) {
		this.elementDisplayCondition = elementDisplayCondition;
	}

	/**
	 * Dynamic storage of attributes
	 */
	protected Map<String, IntInstAttribute> dynamicAttributeComponentsMap = new HashMap<>();
	private String toolTipText;
	private String defaultDomainValueField;

	public Map<String, IntInstAttribute> getDynamicAttributeComponentsMap() {
		return dynamicAttributeComponentsMap;
	}

	public void setDynamicAttributeComponentsMap(
			Map<String, IntInstAttribute> dynamicAttributesMap) {
		this.dynamicAttributeComponentsMap = dynamicAttributesMap;
	}

	/**
	 * 
	 */
	public ElemAttribute() {

	}

	/**
	 * set local attributes none received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param metaConceptInstanceType
	 *            Identifier of the type of instance concept. Examples: OPER
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			Object defaultValue, int defaultGroup, int propTabPosition,
			String propTabEditionCondition, String propTabVisualCondition,
			int elementDisplayPosition, String elementDisplaySpacers,
			String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, null, null, defaultValue, null, null,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition, "", "", "");
	}

	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			Object defaultValue, int defaultGroup, int propTabPosition,
			String propTabEditionCondition, String propTabVisualCondition,
			int elementDisplayPosition, String elementDisplaySpacers,
			String elementDisplayCondition, String domainFiltersOwnFields,
			String domainFiltersRelFields, String defaultDomainValueField) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, null, null, defaultValue, null, null,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition,
				domainFiltersOwnFields, domainFiltersRelFields,
				defaultDomainValueField);
	}

	public ElemAttribute(String name, String type, AttributeType attributeType,
			String displayName, String toolTipText, Object defaultValue,
			boolean affectProperties, IntDomain domain, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, defaultValue, domain, defaultGroup,
				propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition);
	}

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param hint
	 *            Hint to display on the property tab (not currently
	 *            implemented)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			Object defaultValue, String hint, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, null, null, defaultValue, null, hint,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition);
	}

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param enumType
	 *            Complete class in referenced attributes (Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			String enumType, Object defaultValue, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, enumType, null, defaultValue, null, null,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition);
	}

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param enumType
	 *            Complete class in referenced attributes (Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param metaConceptInstanceType
	 *            Identifier of the type of instance concept. Examples: OPER
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	/*
	 * public ElemAttribute(String name, String type, AttributeType
	 * attributeType, boolean affectProperties, String displayName, String
	 * enumType, String metaConceptInstanceType, Object defaultValue, int
	 * defaultGroup, int propTabPosition, String propTabEditionCondition, String
	 * propTabVisualCondition, int elementDisplayPosition, String
	 * elementDisplaySpacers, String elementDisplayCondition) { this(name, type,
	 * attributeType, affectProperties, displayName, enumType,
	 * metaConceptInstanceType, defaultValue, null, null, defaultGroup,
	 * propTabPosition, propTabEditionCondition, propTabVisualCondition,
	 * elementDisplayPosition, elementDisplaySpacers, elementDisplayCondition);
	 * }
	 */

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param enumType
	 *            Complete class in referenced attributes (Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param metaConceptInstanceType
	 *            Identifier of the type of instance concept. Examples: OPER
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param hint
	 *            Hint to display on the property tab (not currently
	 *            implemented)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			String enumType, Object defaultValue, String hint,
			int defaultGroup, int propTabPosition,
			String propTabEditionCondition, String propTabVisualCondition,
			int elementDisplayPosition, String elementDisplaySpacers,
			String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, enumType, null, defaultValue, null, hint,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition);
	}

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param enumType
	 *            Complete class in referenced attributes (Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param metaConceptInstanceType
	 *            Identifier of the type of instance concept. Examples: OPER
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param hint
	 *            Hint to display on the property tab (not currently
	 *            implemented)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			String enumType, String metaConceptInstanceType,
			Object defaultValue, String hint, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, enumType, metaConceptInstanceType, defaultValue,
				null, hint, defaultGroup, propTabPosition,
				propTabEditionCondition, propTabVisualCondition,
				elementDisplayPosition, elementDisplaySpacers,
				elementDisplayCondition);
	}

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param domain
	 *            Domain of the attribute (not tested)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */

	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			Object defaultValue, IntDomain domain, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, null, null, defaultValue, domain, null,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition);
	}

	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			Object defaultValue, IntDomain domain, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition,
			String domainFiltersOwnFields, String domainFiltersRelFields,
			String defaultDomainValueField) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, null, null, defaultValue, domain, null,
				defaultGroup, propTabPosition, propTabEditionCondition,
				propTabVisualCondition, elementDisplayPosition,
				elementDisplaySpacers, elementDisplayCondition,
				domainFiltersOwnFields, domainFiltersRelFields,
				defaultDomainValueField);
	}

	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			String enumType, String metaConceptInstanceType,
			Object defaultValue, IntDomain domain, String hint, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition) {
		this(name, type, attributeType, affectProperties, displayName,
				toolTipText, enumType, metaConceptInstanceType, defaultValue,
				domain, hint, defaultGroup, propTabPosition,
				propTabEditionCondition, propTabVisualCondition,
				elementDisplayPosition, elementDisplaySpacers,
				elementDisplayCondition, "", "", "");
	}

	/**
	 * set local attributes not received with null
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param domain
	 *            Domain of the attribute (not tested)
	 * @param hint
	 *            Hint to display on the property tab (not currently
	 *            implemented)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	/*
	 * public ElemAttribute(String name, String type, AttributeType
	 * attributeType, boolean affectProperties, String displayName, Object
	 * defaultValue, Domain domain, String hint, int defaultGroup, int
	 * propTabPosition, String propTabEditionCondition, String
	 * propTabVisualCondition, int elementDisplayPosition, String
	 * elementDisplaySpacers, String elementDisplayCondition) { this(name, type,
	 * attributeType, affectProperties, displayName, null, null, defaultValue,
	 * domain, hint, defaultGroup, propTabPosition, propTabEditionCondition,
	 * propTabVisualCondition, elementDisplayPosition, elementDisplaySpacers,
	 * elementDisplayCondition); }
	 */

	/**
	 * constructor, set all local attributes without visual control
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param enumType
	 *            Complete class in referenced attributes (Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param metaConceptInstanceType
	 *            Identifier of the type of instance concept. Examples: OPER
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param domain
	 *            Domain of the attribute (not tested)
	 * @param hint
	 *            Hint to display on the property tab (not currently
	 *            implemented)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */
	/*
	 * public ElemAttribute(String name, String type, AttributeType
	 * attributeType, boolean affectProperties, String displayName, String
	 * enumType, String metaConceptInstanceType, Object defaultValue, Domain
	 * domain, String hint, int defaultGroup) { this(name, type, attributeType,
	 * affectProperties, displayName, enumType, metaConceptInstanceType,
	 * defaultValue, domain, hint, defaultGroup, -1, "", "", -1, "", ""); }
	 */

	/**
	 * Principal constructor, set all local attributes
	 * 
	 * @param name
	 *            local identifier of the attribute
	 * @param type
	 *            Attribute type (String, Integer, Boolean, Set, Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param affectProperties
	 *            Name to display on properties JLabel
	 * @param displayName
	 *            Name to display on properties JLabel
	 * @param enumType
	 *            Complete class in referenced attributes (Class, MClass,
	 *            Enumeration, MEnumeration)
	 * @param metaConceptInstanceType
	 *            Identifier of the type of instance concept. Examples: OPER
	 * @param defaultValue
	 *            Default value for the attribute
	 * @param domain
	 *            Domain of the attribute (not tested)
	 * @param hint
	 *            Hint to display on the property tab (not currently
	 *            implemented)
	 * @param defaultGroup
	 *            Default defaultGroup for the attribute
	 */

	public ElemAttribute(String name, String type, AttributeType attributeType,
			boolean affectProperties, String displayName, String toolTipText,
			String enumType, String metaConceptInstanceType,
			Object defaultValue, IntDomain domain, String hint, int defaultGroup,
			int propTabPosition, String propTabEditionCondition,
			String propTabVisualCondition, int elementDisplayPosition,
			String elementDisplaySpacers, String elementDisplayCondition,
			String domainFiltersOwnFields, String domainFiltersRelFields,
			String defaultDomainValueField) {
		super();
		this.name = name;
		this.type = type;
		this.attributeType = attributeType.toString();
		this.affectProperties = affectProperties;
		this.displayName = displayName;
		this.toolTipText = toolTipText;
		this.classCanonicalName = enumType;
		this.metaConceptInstanceType = metaConceptInstanceType;
		this.defaultValue = defaultValue;
		if (type.equals("String") && domain == null)
			this.domain = new StringDomain();
		else
			this.domain = domain;
		this.hint = hint;
		this.defaultGroup = defaultGroup;
		this.propTabPosition = propTabPosition;
		this.propTabEditionCondition = propTabEditionCondition;
		this.propTabVisualCondition = propTabVisualCondition;
		this.elementDisplayPosition = elementDisplayPosition;
		this.elementDisplaySpacers = elementDisplaySpacers;
		this.elementDisplayCondition = elementDisplayCondition;
		this.setDomainFiltersOwnFields(domainFiltersOwnFields);
		this.setDomainFiltersRelFields(domainFiltersRelFields);
		this.setDefaultDomainValueField(defaultDomainValueField);

		if (type.equals("Class") || type.equals("MClass")
				|| type.equals("Enum") || type.equals("MEnum"))
			type = "String";
		dynamicAttributeComponentsMap.put(VAR_NAME, new ElemAttribAttribute(
				VAR_NAME, "String", VAR_NAME, name));
		dynamicAttributeComponentsMap.put(VAR_TYPE, new ElemAttribAttribute(
				VAR_TYPE, "String", VAR_TYPE, type));
		dynamicAttributeComponentsMap.put(VAR_ATTRIBUTE_TYPE,
				new ElemAttribAttribute(VAR_ATTRIBUTE_TYPE, "String",
						VAR_ATTRIBUTE_TYPENAME, attributeType.toString()));
		dynamicAttributeComponentsMap.put(VAR_AFFECTPROPS,
				new ElemAttribAttribute(VAR_AFFECTPROPS, "Boolean",
						VAR_AFFECTPROPSNAME, affectProperties));
		dynamicAttributeComponentsMap.put(VAR_DISPLAYNAME,
				new ElemAttribAttribute(VAR_DISPLAYNAME, "String",
						VAR_DISPLAYNAMENAME, displayName));
		dynamicAttributeComponentsMap.put(VAR_TOOLTIPTEXT,
				new ElemAttribAttribute(VAR_TOOLTIPTEXT, "String",
						VAR_TOOLTIPTEXTNAME, toolTipText));
		dynamicAttributeComponentsMap.put(VAR_CLASSCANONICALNAME,
				new ElemAttribAttribute(VAR_CLASSCANONICALNAME, "String",
						VAR_CLASSCANONICALNAMENAME, enumType));
		dynamicAttributeComponentsMap.put(VAR_METACONCEPTINSTTYPE,
				new ElemAttribAttribute(VAR_METACONCEPTINSTTYPE, "String",
						VAR_METACONCEPTINSTTYPENAME, metaConceptInstanceType));
		dynamicAttributeComponentsMap.put(VAR_DEFAULTVALUE,
				new ElemAttribAttribute(VAR_DEFAULTVALUE, type,
						VAR_DEFAULTVALUENAME, defaultValue));
		dynamicAttributeComponentsMap.put(VAR_DOMAIN, new ElemAttribAttribute(
				VAR_DOMAIN, "Domain", VAR_DOMAIN, domain)); // TODO Change
															// String to Domain
		dynamicAttributeComponentsMap.put(VAR_HINT, new ElemAttribAttribute(
				VAR_HINT, "String", VAR_HINT, hint));
		dynamicAttributeComponentsMap.put(VAR_defaultGroup,
				new ElemAttribAttribute(VAR_defaultGroup, "Integer",
						VAR_defaultGroup, defaultGroup));
		dynamicAttributeComponentsMap.put(VAR_PROPTABPOSITION,
				new ElemAttribAttribute(VAR_PROPTABPOSITION, "Integer",
						VAR_PROPTABPOSITION_NAME, propTabPosition));
		dynamicAttributeComponentsMap
				.put(VAR_ELEMENTDISPLAYPOSITION,
						new ElemAttribAttribute(VAR_ELEMENTDISPLAYPOSITION,
								"Integer", VAR_ELEMENTDISPLAYPOSITION_NAME,
								elementDisplayPosition));
		dynamicAttributeComponentsMap.put(VAR_ELEMENTDISPLAYSPACERS,
				new ElemAttribAttribute(VAR_ELEMENTDISPLAYSPACERS, "String",
						VAR_ELEMENTDISPLAYSPACERS_NAME, elementDisplaySpacers));
		dynamicAttributeComponentsMap.put(VAR_PROPTABEDITIONCOND,
				new ElemAttribAttribute(VAR_PROPTABEDITIONCOND, "String",
						VAR_PROPTABEDITIONCOND_NAME, propTabEditionCondition));
		dynamicAttributeComponentsMap.put(VAR_PROPTABVISUALCOND,
				new ElemAttribAttribute(VAR_PROPTABVISUALCOND, "String",
						VAR_PROPTABVISUALCOND_NAME, propTabVisualCondition));
		dynamicAttributeComponentsMap.put(VAR_ELEMENTDISPLAYCONDITION,
				new ElemAttribAttribute(VAR_ELEMENTDISPLAYCONDITION, "String",
						VAR_ELEMENTDISPLAYCONDITION_NAME,
						elementDisplayCondition));
		dynamicAttributeComponentsMap
				.put(VAR_DOMAINFILTERSOWNFIELDS,
						new ElemAttribAttribute(VAR_DOMAINFILTERSOWNFIELDS,
								"String", VAR_DOMAINFILTERSOWNFIELDS_NAME,
								domainFiltersOwnFields));
		dynamicAttributeComponentsMap
				.put(VAR_DOMAINFILTERSRELFIELDS,
						new ElemAttribAttribute(VAR_DOMAINFILTERSRELFIELDS,
								"String", VAR_DOMAINFILTERSRELFIELDS_NAME,
								domainFiltersRelFields));
		dynamicAttributeComponentsMap.put(VAR_DEFAULTDOMAINVALUEFIELD,
				new ElemAttribAttribute(VAR_DEFAULTDOMAINVALUEFIELD, "String",
						VAR_DEFAULTDOMAINVALUEFIELD_NAME,
						defaultDomainValueField));
	}

	public int getPropTabPosition() {
		return propTabPosition;
	}

	public int getElementDisplayPosition() {
		return elementDisplayPosition;
	}

	public String getElementDisplayPositionStr() {
		if (elementDisplayPosition < 10)
			return "0" + elementDisplayPosition;
		else
			return elementDisplayPosition + "";
	}

	public String getPropTabPositionStr() {
		if (propTabPosition < 10)
			return "0" + propTabPosition;
		else
			return propTabPosition + "";
	}

	public String getElementDisplaySpacers() {
		return elementDisplaySpacers;
	}

	public String getPropTabEditionCondition() {
		return propTabEditionCondition;
	}

	public String getPropTabVisualCondition() {
		return propTabVisualCondition;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
		dynamicAttributeComponentsMap.put(VAR_DISPLAYNAME,
				new ElemAttribAttribute(VAR_DISPLAYNAME, "String",
						VAR_DISPLAYNAMENAME, displayName));
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getMetaConceptInstanceType() {
		return metaConceptInstanceType;
	}

	public IntDomain getDomain() {
		return domain;
	}

	public String getClassCanonicalName() {
		return classCanonicalName;
	}

	public String getHint() {
		return hint;
	}

	public int getDefaultGroup() {
		return defaultGroup;
	}

	public boolean isAffectProperties() {
		return affectProperties;
	}

	public void setAffectProperties(boolean affectProperties) {
		this.affectProperties = affectProperties;
		dynamicAttributeComponentsMap.put(VAR_AFFECTPROPS,
				new ElemAttribAttribute(VAR_AFFECTPROPS, "Boolean",
						VAR_AFFECTPROPSNAME, affectProperties));

	}

	public void setName(String name) {
		this.name = name;
		dynamicAttributeComponentsMap.put(VAR_NAME, new ElemAttribAttribute(
				VAR_NAME, "String", VAR_NAME, name));

	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getToolTipText() {
		return toolTipText;
	}

	public void setToolTipText(String toolTipText) {
		this.toolTipText = toolTipText;
	}

	public String getDomainFiltersOwnFields() {
		return domainFiltersOwnFields;
	}

	public void setDomainFiltersOwnFields(String domainFiltersOwnFields) {
		this.domainFiltersOwnFields = domainFiltersOwnFields;
	}

	public String getDomainFiltersRelFields() {
		return domainFiltersRelFields;
	}

	public void setDomainFiltersRelFields(String domainFiltersRelFields) {
		this.domainFiltersRelFields = domainFiltersRelFields;
	}

	public String getDefaultDomainValueField() {
		return defaultDomainValueField;
	}

	public void setDefaultDomainValueField(String defaultDomainValueField) {
		this.defaultDomainValueField = defaultDomainValueField;
	}
}