package com.variamos.dynsup.staticexpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.variamos.dynsup.instance.InstElement;
import com.variamos.dynsup.instance.InstPairwiseRel;
import com.variamos.dynsup.model.InstanceModel;
import com.variamos.dynsup.model.SyntaxElement;
import com.variamos.dynsup.staticexprsup.AbstractBooleanExpression;
import com.variamos.dynsup.staticexprsup.AbstractNumericExpression;
import com.variamos.dynsup.staticexprsup.GreaterOrEqualsBooleanExpression;
import com.variamos.dynsup.staticexprsup.LessBooleanExpression;
import com.variamos.dynsup.staticexprsup.NumberNumericExpression;
import com.variamos.dynsup.staticexprsup.ProdNumericExpression;
import com.variamos.dynsup.staticexprsup.SumNumericExpression;
import com.variamos.dynsup.translation.ModelExpr2HLCL;
import com.variamos.hlcl.model.domains.RangeDomain;
import com.variamos.hlcl.model.expressions.HlclFactory;
import com.variamos.hlcl.model.expressions.Identifier;
import com.variamos.hlcl.model.expressions.IntBooleanExpression;

public class ModelExpressionSet extends ElementExpressionSet {

	private InstanceModel refas;
	private Map<String, List<IntBooleanExpression>> booleanExpressions = new HashMap<String, List<IntBooleanExpression>>();

	public List<IntBooleanExpression> getBooleanExpressionList(String element) {
		return booleanExpressions.get(element);
	}

	public ModelExpressionSet(String identifier, String description,
			Map<String, Identifier> idMap, HlclFactory hlclFactory,
			InstanceModel refas, int execType) {
		super(identifier, description, idMap, hlclFactory);
		this.refas = refas;
		defineExpressions(execType);
	}

	public boolean validateConceptType(InstElement instElement, String element) {
		if (instElement == null)// || !(instElement instanceof InstVertex))
			return false;
		SyntaxElement metaElement = (instElement.getTransSupportMetaElement());
		if (metaElement == null)
			return false;
		InstElement semElement = metaElement.getTransInstSemanticElement();
		while (semElement != null && semElement.getIdentifier() != null
				&& !semElement.getIdentifier().equals(element)) {
			InstElement sEle = semElement;
			semElement = null;
			for (InstElement ele : sEle.getTargetRelations())
				if (ele instanceof InstPairwiseRel) {
					if (((InstPairwiseRel) ele).getSupportMetaPairwiseRelIden()
							.equals("ExtendsRelation")) {
						semElement = ele.getTargetRelations().get(0);
						break;
					}
				} else if (((InstPairwiseRel) ele).getSupInstEleId().equals(
						"ExtendsRelation")) {
					semElement = ele.getTargetRelations().get(0);
					break;
				}
		}
		if (semElement != null && semElement.getIdentifier() != null
				&& semElement.getIdentifier().equals(element)) {
			return true;
		}
		return false;
	}

	private void defineExpressions(int execType) {
		AbstractNumericExpression rootOutExp = null;
		AbstractNumericExpression parentOutExp = null;
		AbstractNumericExpression coreOutExp = null;
		AbstractNumericExpression reqOutExp = null;
		AbstractNumericExpression prefOutExp = null;

		for (InstElement vertex : refas.getVariabilityVertexCollection()) {
			SyntaxElement metaElement = (vertex.getTransSupportMetaElement());
			if (validateConceptType(vertex, "GeneralConcept"))
				if (vertex.getInstAttribute("Active").getAsBoolean()) {
					switch (execType) {
					case ModelExpr2HLCL.VAL_UPD_EXEC:

						if (metaElement.getAutoIdentifier().equals(
								"GeneralFeature") // TODO temporal solution:
													// syntax validation cannot
													// be used for semantic
													// attributes
								|| metaElement.getAutoIdentifier().equals(
										"LeafFeature")
								|| metaElement.getAutoIdentifier().equals(
										"RootFeature")) {
							if (rootOutExp == null)
								rootOutExp = new SumNumericExpression(vertex,
										"IsRootFeature", true,
										new NumberNumericExpression(0));
							else
								rootOutExp = new SumNumericExpression(vertex,
										"IsRootFeature", true, rootOutExp);
							if (parentOutExp == null)
								parentOutExp = new ProdNumericExpression(
										vertex, "HasParent", true,
										new NumberNumericExpression(1));
							else
								parentOutExp = new ProdNumericExpression(
										vertex, "HasParent", true, parentOutExp);
						}
						if (coreOutExp == null)
							coreOutExp = new SumNumericExpression(vertex,
									"Sel", true, new NumberNumericExpression(0));
						else
							coreOutExp = new SumNumericExpression(vertex,
									"Sel", true, coreOutExp);

						break;
					case ModelExpr2HLCL.SIMUL_MAPE:
					case ModelExpr2HLCL.SIMUL_EXEC:
					case ModelExpr2HLCL.SIMUL_EXPORT:
						if (reqOutExp == null)
							reqOutExp = new SumNumericExpression(vertex,
									"SimulSel", true,
									new NumberNumericExpression(0));
						else
							reqOutExp = new SumNumericExpression(vertex,
									"SimulSel", true, reqOutExp);

						if (prefOutExp == null)
							prefOutExp = new SumNumericExpression(vertex,
									"TestConfSel", true,
									new NumberNumericExpression(0));
						else
							prefOutExp = new SumNumericExpression(vertex,
									"TestConfSel", true, prefOutExp);
					}
				}
		}

		List<IntBooleanExpression> rootList = new ArrayList<IntBooleanExpression>();
		List<IntBooleanExpression> parentList = new ArrayList<IntBooleanExpression>();
		List<IntBooleanExpression> coreList = new ArrayList<IntBooleanExpression>();
		List<IntBooleanExpression> simulList = new ArrayList<IntBooleanExpression>();
		if (rootOutExp != null) {
			AbstractBooleanExpression transformation51 = new GreaterOrEqualsBooleanExpression(
					rootOutExp, new NumberNumericExpression(2));
			Map<String, Identifier> idMap = new HashMap<String, Identifier>();

			idMap.putAll(transformation51.getIdentifiers(getHlclFactory()));
			rootList.add(this.getHlclFactory().doubleImplies(
					this.getHlclFactory().newIdentifier("amodel_roots"),
					transformation51.transform(getHlclFactory(), idMap)));
			rootList.add(this.getHlclFactory().lessOrEqualsThan(
					this.getHlclFactory().newIdentifier("amodel_roots"),
					getHlclFactory().number(0)));
		}
		booleanExpressions.put("Root", rootList);

		if (parentOutExp != null) {
			AbstractBooleanExpression transformation51 = new LessBooleanExpression(
					parentOutExp, new NumberNumericExpression(1));
			Map<String, Identifier> idMap = new HashMap<String, Identifier>();

			idMap.putAll(transformation51.getIdentifiers(getHlclFactory()));
			parentList.add(this.getHlclFactory().doubleImplies(
					this.getHlclFactory().newIdentifier("amodel_parents"),
					transformation51.transform(getHlclFactory(), idMap)));
			parentList.add(this.getHlclFactory().lessOrEqualsThan(
					this.getHlclFactory().newIdentifier("amodel_parents"),
					getHlclFactory().number(0)));
		}
		booleanExpressions.put("Parent", parentList);

		if (coreOutExp != null) {
			Map<String, Identifier> idMap = new HashMap<String, Identifier>();

			idMap.putAll(coreOutExp.getIdentifiers(getHlclFactory()));
			Identifier identifier = this.getHlclFactory().newIdentifier(
					"amodel_order");
			identifier.setDomain(new RangeDomain(0, 200, 0));
			coreList.add(this.getHlclFactory().equals(identifier,
					coreOutExp.transform(getHlclFactory(), idMap)));
			/*
			 * coreList.add(this.getHlclFactory().lessOrEqualsThan(
			 * this.getHlclFactory().newIdentifier("model_parents"),
			 * getHlclFactory().number(0)));
			 */
		}
		booleanExpressions.put("Core", coreList);

		/*
		 * if (reqOutExp != null) { LessOrEqualsBooleanExpression compPrefOutExp
		 * = new LessOrEqualsBooleanExpression( prefOutExp, new
		 * NumberNumericExpression(0)); LessOrEqualsBooleanExpression
		 * compReqOutExp = new LessOrEqualsBooleanExpression( reqOutExp, new
		 * NumberNumericExpression(0)); Map<String, Identifier> idMap = new
		 * HashMap<String, Identifier>();
		 * 
		 * idMap.putAll(reqOutExp.getIdentifiers(getHlclFactory())); Identifier
		 * identifier1 = this.getHlclFactory().newIdentifier( "amodel_req");
		 * identifier1.setDomain(new RangeDomain(0, 200));
		 * idMap.putAll(prefOutExp.getIdentifiers(getHlclFactory()));
		 * 
		 * simulList.add(this.getHlclFactory().equals(identifier1,
		 * reqOutExp.transform(getHlclFactory(), idMap)));
		 * 
		 * simulList.add(this.getHlclFactory().implies(
		 * compPrefOutExp.transform(getHlclFactory(), idMap),
		 * compReqOutExp.transform(getHlclFactory(), idMap)));
		 * 
		 * }
		 */
		if (prefOutExp != null) {
			Map<String, Identifier> idMap = new HashMap<String, Identifier>();

			idMap.putAll(prefOutExp.getIdentifiers(getHlclFactory()));
			Identifier identifier = this.getHlclFactory().newIdentifier(
					"amodel_pref");
			identifier.setDomain(new RangeDomain(0, 200, 0));
			simulList.add(this.getHlclFactory().equals(
					this.getHlclFactory().newIdentifier("amodel_pref"),
					prefOutExp.transform(getHlclFactory(), idMap)));

			simulList.add(this.getHlclFactory().lessOrEqualsThan(
					this.getHlclFactory().newIdentifier("amodel_pref"),
					getHlclFactory().number(1)));
		}
		booleanExpressions.put("Simul", simulList);

	}
}
