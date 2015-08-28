package com.variamos.perspsupport.semanticsupport;

import java.util.List;

import com.variamos.perspsupport.semanticinterface.IntSemanticPairwiseRelation;
import com.variamos.perspsupport.semanticinterface.IntSemanticRelationType;
import com.variamos.perspsupport.syntaxsupport.SemanticAttribute;
import com.variamos.semantic.types.LevelType;
import com.variamos.semantic.types.SatisficingType;

/**
 * A class to represent the edges with semantic back object. Part of PhD work at
 * University of Paris 1
 * 
 * @author Juan C. Mu�oz Fern�ndez <jcmunoz@gmail.com>
 * 
 * @version 1.1
 * @since 2014-11-23
 * @see com.cfm.productline.
 */
public class SemanticPairwiseRelation extends AbstractSemanticElement implements
		IntSemanticPairwiseRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7976788205587295216L;
	/**
	 * 
	 */
	private List<IntSemanticRelationType> semanticRelationTypes;
	// private boolean toSoftSemanticConcept;
	public static final String
	/**
	* 
	*/
	VAR_SOURCE_LEVEL = "sourceLevel",
	/**
			* 
			*/
	VAR_TARGET_LEVEL = "targetLevel",
	/**
			* 
			*/
	VAR_LEVEL = "level",
	/**
	 * 
	 */
	VAR_SOURCE_LEVELNAME = "Source Level",
	/**
					 * 
					 */
	VAR_TARGET_LEVELNAME = "Target Level",
	/**
			 * 
			 */
	VAR_LEVELNAME = "Level",
	/**
	* 
	*/
	VAR_LEVELCLASS = LevelType.class.getCanonicalName(),
	/**
	 * 
	*/
	VAR_SATISFICINGTYPE = "satisficingType",
	/**
	 * 
	*/
	VAR_SATISFICINGTYPENAME = "Satisficing Level",
	/**
	* 
	*/
	VAR_SATISFICINGTYPECLASS = SatisficingType.class.getCanonicalName(),

	VAR_RELATIONTYPE_IDEN = "relationType",
			VAR_RELATIONTYPE_NAME = "Relation Type",
			VAR_RELATIONTYPE_CLASS = SemanticRelationType.class
					.getCanonicalName();

	public SemanticPairwiseRelation() {
		super(null);
		defineSemanticAttributes();
	}

	public SemanticPairwiseRelation(String identifier,
			boolean toSoftSemanticConcept,
			List<IntSemanticRelationType> semanticRelationTypes) {
		super(identifier);
		this.semanticRelationTypes = semanticRelationTypes;
		// this.toSoftSemanticConcept = toSoftSemanticConcept;
		defineSemanticAttributes();
	}

	public List<IntSemanticRelationType> getSemanticRelationTypes() {
		return semanticRelationTypes;
	}

	public void setSemanticRelationTypes(
			List<IntSemanticRelationType> semanticRelationTypes) {
		this.semanticRelationTypes = semanticRelationTypes;
	}

	private void defineSemanticAttributes() {
		putSemanticAttribute(VAR_RELATIONTYPE_IDEN, new SemanticAttribute(
				VAR_RELATIONTYPE_IDEN, "Class", true, VAR_RELATIONTYPE_NAME,
				VAR_RELATIONTYPE_CLASS, null, "", 0));
		addPropEditableAttribute("06#" + VAR_RELATIONTYPE_IDEN);
		addPropVisibleAttribute("06#" + VAR_RELATIONTYPE_IDEN);
		addPanelVisibleAttribute("06#" + VAR_RELATIONTYPE_IDEN);
		addPanelSpacersAttribute("#" + VAR_RELATIONTYPE_IDEN + "#\n");
	}

}