package com.variamos.perspsupport.semanticsupport;

import com.variamos.perspsupport.instancesupport.InstEnumeration;
import com.variamos.perspsupport.syntaxsupport.SemanticAttribute;
import com.variamos.perspsupport.syntaxsupport.GlobalConfigAttribute;
import com.variamos.perspsupport.syntaxsupport.ExecCurrentStateAttribute;
import com.variamos.perspsupport.types.VariableType;

/**
 * A class to represent the Semantics of Variables. Part of PhD work at
 * University of Paris 1
 * 
 * @author Juan C. Mu�oz Fern�ndez <jcmunoz@gmail.com>
 * 
 * @version 1.1
 * @since 2014-12-02
 * @see com.cfm.productline.
 */
public class SemanticVariable extends AbstractSemanticVertex {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5538738414024566452L;

	public static final String VAR_NAME = "name",
			VAR_NAMENAME = "Name",

			VAR_VALUE = "value",
			VAR_VALUENAME = "Value",

			VAR_EXTVISIBLE = "ExtVisible",
			VAR_EXTVISIBLENAME = "Externally Visible",

			VAR_EXTCONTROL = "ExtControl",
			VAR_EXTCONTROLNAME = "Externally Controlled",

			VAR_VARIABLETYPE = "variableType",
			VAR_VARIABLETYPENAME = "Variable Type",
			VAR_VARIABLETYPECLASS = VariableType.class.getCanonicalName(),

			VAR_CONTEXT = "isContext",
			VAR_CONTEXTNAME = "Context Defined",

			VAR_VARIABLEDOMAIN = "variableDomain",
			VAR_VARIABLEDOMAINNAME = "Variable Domain",

			VAR_ENUMERATIONTYPE = "enumerationType",
			VAR_ENUMERATIONTYPENAME = "Enumeration",
			VAR_ENUMERATIONTYPECLASS = InstEnumeration.class.getCanonicalName(),

			VAR_VARIABLECONFIGVALUE = "variableConfigValue",
			VAR_VARIABLECONFIGVALUENAME = "Configured Value",

			VAR_VARIABLECONFIGDOMAIN = "variableConfigDomain",
			VAR_VARIABLECONFIGDOMAINNAME = "Configured Domain";

	public SemanticVariable() {
		this(null, null);
	}

	public SemanticVariable(String name) {
		this(null, name);
	}

	public SemanticVariable(AbstractSemanticVertex parentConcept, String name) {
		super(parentConcept, name, true);
		defineSemanticAttributes();
	}

	private void defineSemanticAttributes() {

		// putSemanticAttribute(VAR_SCOPE,
		// new SemanticAttribute(VAR_SCOPE, "Enumeration", false,
		// VAR_SCOPENAME, VAR_SCOPECLASS, "user", ""));
		// putSemanticAttribute(VAR_CONTEXTTYPE, new SemanticAttribute(
		// VAR_CONTEXTTYPE, "Enumeration", false, VAR_CONTEXTTYPENAME,
		// VAR_CONTEXTTYPECLASS, "profiled", ""));
		putSemanticAttribute(VAR_NAME, new SemanticAttribute(VAR_NAME,
				"String", false, VAR_NAMENAME, "",0));
		putSemanticAttribute(VAR_VARIABLETYPE, new SemanticAttribute(
				VAR_VARIABLETYPE, "Enumeration", true, VAR_VARIABLETYPENAME,
				VAR_VARIABLETYPECLASS, "String", "",0));
		putSemanticAttribute(VAR_VARIABLEDOMAIN, new SemanticAttribute(
				VAR_VARIABLEDOMAIN, "String", false, VAR_VARIABLEDOMAINNAME,
				"0,1",0));
		putSemanticAttribute(VAR_ENUMERATIONTYPE, new SemanticAttribute(
				VAR_ENUMERATIONTYPE, "Class", false, VAR_ENUMERATIONTYPENAME,
				VAR_ENUMERATIONTYPECLASS, "ME", "String", "",0));
		// TODO define domain for enumtype
		putSemanticAttribute(VAR_VALUE, new ExecCurrentStateAttribute(
				VAR_VALUE, "Integer", false, VAR_VALUENAME, 0,1));
		putSemanticAttribute(VAR_CONTEXT, new SemanticAttribute(
				VAR_CONTEXT, "Boolean", false, VAR_CONTEXTNAME, false,0));
		putSemanticAttribute(VAR_EXTVISIBLE, new SemanticAttribute(
				VAR_EXTVISIBLE, "Boolean", false, VAR_EXTVISIBLENAME, false,0));
		putSemanticAttribute(VAR_EXTCONTROL, new SemanticAttribute(
				VAR_EXTCONTROL, "Boolean", false, VAR_EXTCONTROLNAME, false,0));

		putSemanticAttribute(VAR_VARIABLECONFIGVALUE,
				new GlobalConfigAttribute(VAR_VARIABLECONFIGVALUE, "Integer",
						false, VAR_VARIABLECONFIGVALUENAME, 0,0));
		putSemanticAttribute(VAR_VARIABLECONFIGDOMAIN,
				new GlobalConfigAttribute(VAR_VARIABLECONFIGDOMAIN, "String",
						false, VAR_VARIABLECONFIGDOMAINNAME, "",0));

		this.addPropEditableAttribute("01#" + VAR_NAME);
		this.addPropEditableAttribute("02#" + VAR_VARIABLETYPE);
		this.addPropEditableAttribute("03#" + VAR_VARIABLEDOMAIN);
		this.addPropEditableAttribute("04#" + VAR_ENUMERATIONTYPE);
		this.addPropEditableAttribute("05#" + VAR_CONTEXT);
		// this.addPropEditableAttribute("06#" + VAR_SCOPE);
		this.addPropEditableAttribute("08#" + VAR_EXTVISIBLE);
		this.addPropEditableAttribute("09#" + VAR_EXTCONTROL);

		this.addPropEditableAttribute("01#" + VAR_VARIABLECONFIGDOMAIN);

		this.addPropVisibleAttribute("01#" + VAR_NAME);
		this.addPropVisibleAttribute("02#" + VAR_VARIABLETYPE);
		this.addPropVisibleAttribute("03#" + VAR_VARIABLEDOMAIN + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Integer");
		this.addPropVisibleAttribute("04#" + VAR_ENUMERATIONTYPE + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Enumeration");
		this.addPropVisibleAttribute("05#" + VAR_CONTEXT);
		// this.addPropVisibleAttribute("06#" + VAR_SCOPE);
		this.addPropVisibleAttribute("06#" + VAR_VALUE);
		this.addPropVisibleAttribute("07#" + VAR_VALUE);
		this.addPropVisibleAttribute("08#" + VAR_EXTVISIBLE);
		this.addPropVisibleAttribute("09#" + VAR_EXTCONTROL);

		this.addPropVisibleAttribute("01#" + VAR_VARIABLECONFIGDOMAIN + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Enumeration");
		this.addPropVisibleAttribute("01#" + VAR_VARIABLECONFIGDOMAIN + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Integer");
		this.addPropVisibleAttribute("01#" + VAR_VARIABLECONFIGDOMAIN + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Boolean");

		this.addPanelVisibleAttribute("01#" + VAR_NAME);
		this.addPanelVisibleAttribute("02#" + VAR_VARIABLETYPE + "#"
				+ VAR_VARIABLETYPE + "#!=#" + "Enumeration");
		this.addPanelVisibleAttribute("03#" + VAR_ENUMERATIONTYPE + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Enumeration");
		this.addPanelVisibleAttribute("03#" + VAR_VARIABLEDOMAIN + "#"
				+ VAR_VARIABLETYPE + "#==#" + "Integer");
		// this.addPanelVisibleAttribute("04#" + VAR_CONTEXTTYPE);
		// this.addPanelVisibleAttribute("05#" + VAR_SCOPE);

		this.addPanelSpacersAttribute("#" + VAR_NAME + "#\n");
		this.addPanelSpacersAttribute("{#" + VAR_VARIABLETYPE + "#} ");

		this.addPanelSpacersAttribute("{#" + VAR_VARIABLEDOMAIN + "#} ");
		// this.addPanelSpacersAttribute("{#" + VAR_CONTEXTTYPE + "#} ");
		// this.addPanelSpacersAttribute("{#" + VAR_SCOPE + "#}");

	}

	public String toString() {

		return " VAR: " + super.toString();
	}
}