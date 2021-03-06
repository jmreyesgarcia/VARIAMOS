package com.variamos.reasoning.defectAnalyzer.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.variamos.reasoning.defectAnalyzer.model.defects.Defect;
import com.variamos.reasoning.defectAnalyzer.model.diagnosis.DefectAnalyzerModeEnum;

public class VMCauseAnalyzerInDTO {

	private DefectAnalyzerModeEnum defectAnalyzerMode;

	private List<Defect> deadFeaturesList = new ArrayList<Defect>();
	private List<Defect> falseOptionalFeaturesList = new ArrayList<Defect>();
	private List<Defect> domainNotAttainableList = new ArrayList<Defect>();
	private List<Defect> redundancies = new ArrayList<Defect>();
	private Defect voidModel;
	private Defect falseProductLine;

	/**
	 * @return the correctionSetIdentifcationType
	 */
	public DefectAnalyzerModeEnum getDefectAnalyzerMode() {
		return defectAnalyzerMode;
	}

	/**
	 * @return the deadFeaturesList
	 */
	public List<Defect> getDeadFeaturesList() {
		return deadFeaturesList;
	}

	/**
	 * @param deadFeaturesList
	 *            the deadFeaturesList to set
	 */
	public void setDeadFeaturesList(List<Defect> deadFeaturesList) {
		this.deadFeaturesList = deadFeaturesList;
	}

	/**
	 * @return the falseOptionalFeaturesList
	 */
	public List<Defect> getFalseOptionalFeaturesList() {
		return falseOptionalFeaturesList;
	}

	/**
	 * @param falseOptionalFeaturesList
	 *            the falseOptionalFeaturesList to set
	 */
	public void setFalseOptionalFeaturesList(
			List<Defect> falseOptionalFeaturesList) {
		this.falseOptionalFeaturesList = falseOptionalFeaturesList;
	}

	/**
	 * @return the domainNotAttainableList
	 */
	public List<Defect> getDomainNotAttainableList() {
		return domainNotAttainableList;
	}

	/**
	 * @param domainNotAttainableList
	 *            the domainNotAttainableList to set
	 */
	public void setDomainNotAttainableList(List<Defect> domainNotAttainableList) {
		this.domainNotAttainableList = domainNotAttainableList;
	}

	/**
	 * /**
	 * 
	 * @param defectAnalyzerMode
	 *            the correctionSetIdentifcationType to set
	 */
	public void setDefectAnalyzerMode(
			DefectAnalyzerModeEnum defectAnalyzerMode) {
		this.defectAnalyzerMode = defectAnalyzerMode;
	}

	/**
	 * @return the redundancies
	 */
	public List<Defect> getRedundancies() {
		return redundancies;
	}

	/**
	 * @param redundancies
	 *            the redundancies to set
	 */
	public void setRedundancies(List<Defect> redundancies) {
		this.redundancies = redundancies;
	}

	/**
	 * @return the voidModel
	 */
	public Defect getVoidModel() {
		return voidModel;
	}

	/**
	 * @param voidModel
	 *            the voidModel to set
	 */
	public void setVoidModel(Defect voidModel) {
		this.voidModel = voidModel;
	}

	/**
	 * @return the falseProductLine
	 */
	public Defect getFalseProductLine() {
		return falseProductLine;
	}

	/**
	 * @param falseProductLine
	 *            the falseProductLine to set
	 */
	public void setFalseProductLine(Defect falseProductLine) {
		this.falseProductLine = falseProductLine;
	}

}
