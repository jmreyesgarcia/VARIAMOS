package com.variamos.reasoning.defectAnalyzer.model.diagnosis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.variamos.hlcl.model.expressions.IntBooleanExpression;

public class CauCos {

	protected List<IntBooleanExpression> elements = new ArrayList<IntBooleanExpression>();
	private static Long indx = 1L;
	protected Long id;

	public CauCos() {
		super();
		indx++;
		id = indx;
	}

	
	public CauCos(List<IntBooleanExpression> elements) {
		this();
		this.elements = elements;
	}

	public int getElementsSize(){
		return elements.size();
	}
	
	public List<IntBooleanExpression> getElements() {
		return elements;
	}

	public void setElements(List<IntBooleanExpression> elements) {
		this.elements = elements;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean add(IntBooleanExpression e) {
		return elements.add(e);
	}

	public void add(int index, IntBooleanExpression element) {
		elements.add(index, element);
	}

	public boolean addAll(Collection<? extends IntBooleanExpression> c) {
		return elements.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends IntBooleanExpression> c) {
		return elements.addAll(index, c);
	}

	@Override
	public String toString() {
		return "CauCos [id=" + id + "] elements size: " + elements.size();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CauCos other = (CauCos) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}
}
