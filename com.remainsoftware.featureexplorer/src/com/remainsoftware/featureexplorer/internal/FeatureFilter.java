package com.remainsoftware.featureexplorer.internal;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.osgi.framework.Bundle;

public class FeatureFilter extends ViewerFilter {

	private final String text;

	public FeatureFilter(String text) {
		this.text = text;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof Bundle) {
			return ((Bundle) element).getSymbolicName().contains(text);
		}
		if (element instanceof IBundleGroup) {
			for (Bundle bundle : ((IBundleGroup) element).getBundles()) {
				if (bundle.getSymbolicName().contains(text)) {
					return true;
				}
			}
		}
		if (element instanceof IBundleGroupProvider) {
			return true;
		}
		return false;
	}
}
